package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class VFSFileOp {
    private static final String TAG = "MicroMsg.VFSFileOp";

    VFSFileOp() {
    }

    public static int appendToFile(String str, byte[] bArr) {
        return appendToFile(str, bArr, 0, bArr.length);
    }

    public static boolean copyDir(String str, String str2) {
        return recursiveCopyOrMove(FileSystemManager.instance().resolve(VFSUtils.parseUri(str)), FileSystemManager.instance().resolve(VFSUtils.parseUri(str2)), false);
    }

    public static long copyFile(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str.equals(str2)) {
            return -1L;
        }
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        FileSystemManager.Resolution resolve2 = FileSystemManager.instance().resolve(VFSUtils.parseUri(str2));
        if (resolve.valid() && resolve2.valid()) {
            try {
                return resolve2.fileSystem.copyFile(resolve2.path, resolve.fileSystem, resolve.path);
            } catch (IOException e16) {
                QLog.e(TAG, 1, "Failed to copy file " + str + " -> " + str2 + MsgSummary.STR_COLON + e16.getMessage());
            }
        }
        return -1L;
    }

    public static boolean createNewFile(String str) {
        try {
            VFSFile vFSFile = new VFSFile(str);
            if (!vFSFile.exists()) {
                if (!vFSFile.createNewFile()) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean deleteDir(String str) {
        return deleteDir(str, true);
    }

    public static boolean deleteFile(String str) {
        if (str != null && str.length() != 0) {
            return new VFSFile(str).delete();
        }
        return false;
    }

    public static String exportExternalPath(String str, boolean z16) {
        if (str != null && !str.isEmpty()) {
            String resolveRealPath = VFSUtils.resolveRealPath(VFSUtils.parseUri(str), z16);
            if (resolveRealPath != null && !resolveRealPath.startsWith("/")) {
                return "/" + resolveRealPath;
            }
            return resolveRealPath;
        }
        QLog.d(TAG, 1, "exportExternalPath is called! path is null");
        return null;
    }

    public static Uri exportExternalUri(VFSFile vFSFile, String str) {
        Uri uri = vFSFile.getUri();
        Uri exportUri = FileSystemManager.instance().exportUri(uri);
        if (exportUri == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Cannot get URI for export: " + uri);
                return null;
            }
            return null;
        }
        Uri vfsUriToContentUri = VFSFileProvider.vfsUriToContentUri(exportUri, str);
        if (vfsUriToContentUri == null && QLog.isColorLevel()) {
            QLog.w(TAG, 2, "Cannot convert export URI to content URI: " + exportUri);
        }
        return vfsUriToContentUri;
    }

    public static boolean fileExists(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        if (!resolve.valid()) {
            return false;
        }
        return resolve.fileSystem.exists(resolve.path);
    }

    public static long fileLength(String str) {
        FileSystem.FileEntry stat;
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        if (!resolve.valid() || (stat = resolve.fileSystem.stat(resolve.path)) == null) {
            return 0L;
        }
        return stat.size;
    }

    public static long fileModifyTime(String str) {
        FileSystem.FileEntry stat;
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        if (!resolve.valid() || (stat = resolve.fileSystem.stat(resolve.path)) == null) {
            return 0L;
        }
        return stat.modifiedTime;
    }

    public static String getFileExt(String str) {
        String name;
        int lastIndexOf;
        if (str == null || str.length() <= 0 || (lastIndexOf = (name = new VFSFile(str).getName()).lastIndexOf(46)) <= 0 || lastIndexOf == name.length() - 1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public static byte[] getFileMD5(String str) {
        Throwable th5;
        InputStream inputStream;
        if (str == null) {
            return null;
        }
        try {
            inputStream = openRead(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        byte[] digest = messageDigest.digest();
                        VFSUtils.closeQuietly(inputStream);
                        return digest;
                    }
                }
            } catch (Exception unused) {
                VFSUtils.closeQuietly(inputStream);
                return null;
            } catch (Throwable th6) {
                th5 = th6;
                VFSUtils.closeQuietly(inputStream);
                throw th5;
            }
        } catch (Exception unused2) {
            inputStream = null;
        } catch (Throwable th7) {
            th5 = th7;
            inputStream = null;
        }
    }

    public static String getFileMD5String(String str) {
        byte[] fileMD5 = getFileMD5(str);
        if (fileMD5 == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(32);
        for (byte b16 : fileMD5) {
            sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
        }
        return sb5.toString();
    }

    public static final String getNameWithoutExt(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String name = new VFSFile(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        if (lastIndexOf == 0) {
            return "";
        }
        return name.substring(0, lastIndexOf);
    }

    public static String getParentAbsolutePath(String str) {
        return new VFSFile(str).getAbsoluteFile().getParent();
    }

    public static Iterable<FileSystem.FileEntry> listFiles(String str, boolean z16) {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        if (!resolve.valid()) {
            return null;
        }
        return resolve.fileSystem.list(resolve.path, z16);
    }

    public static void markNoMedia(String str) {
        if (str != null && !str.isEmpty()) {
            FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
            if (!resolve.valid() || (resolve.fileSystem.capabilityFlags() & 2) == 0 || resolve.fileSystem.realPath(resolve.path, true) == null) {
                return;
            }
            try {
                resolve.fileSystem.openWrite(resolve.path + "/.nomedia", false).close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean mkdirs(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        VFSFile vFSFile = new VFSFile(str);
        if (!vFSFile.mkdirs() && !vFSFile.isDirectory()) {
            return false;
        }
        return true;
    }

    public static boolean moveDir(String str, String str2) {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        FileSystemManager.Resolution resolve2 = FileSystemManager.instance().resolve(VFSUtils.parseUri(str2));
        if (resolve.valid() && resolve2.valid()) {
            FileSystem fileSystem = resolve.fileSystem;
            FileSystem fileSystem2 = resolve2.fileSystem;
            if ((fileSystem.capabilityFlags() & 10) == 10 && (fileSystem2.capabilityFlags() & 10) == 10) {
                String realPath = fileSystem.realPath(resolve.path, false);
                String realPath2 = fileSystem2.realPath(resolve2.path, true);
                if (realPath != null && realPath2 != null && new File(realPath).renameTo(new File(realPath2))) {
                    return true;
                }
            }
        }
        if (!recursiveCopyOrMove(resolve, resolve2, true) || !deleteDir(str, false)) {
            return false;
        }
        return true;
    }

    public static boolean moveFile(String str, String str2) {
        if (str != null && str2 != null && str.length() != 0 && str2.length() != 0) {
            FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
            FileSystemManager.Resolution resolve2 = FileSystemManager.instance().resolve(VFSUtils.parseUri(str2));
            if (resolve.valid() && resolve2.valid()) {
                try {
                    boolean moveFile = resolve2.fileSystem.moveFile(resolve2.path, resolve.fileSystem, resolve.path);
                    if (!moveFile) {
                        if (resolve2.fileSystem.copyFile(resolve2.path, resolve.fileSystem, resolve.path) >= 0) {
                            moveFile = true;
                        } else {
                            moveFile = false;
                        }
                        if (moveFile) {
                            resolve.fileSystem.delete(resolve.path);
                        }
                    }
                    return moveFile;
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "Failed to move file " + str + " -> " + str2 + MsgSummary.STR_COLON + e16.getMessage());
                }
            }
        }
        return false;
    }

    public static ParcelFileDescriptor openFileDescriptor(String str, String str2) throws FileNotFoundException {
        if (str != null && !str.isEmpty()) {
            return openFileDescriptor(VFSUtils.parseUri(str), null, str2);
        }
        throw new FileNotFoundException("path is empty");
    }

    public static RandomAccessFile openRandomAccess(String str, boolean z16) throws FileNotFoundException {
        if (str != null && !str.isEmpty()) {
            return openRandomAccess(VFSUtils.parseUri(str), z16);
        }
        throw new FileNotFoundException("path is empty");
    }

    public static InputStream openRead(String str) throws FileNotFoundException {
        if (str != null && !str.isEmpty()) {
            return openRead(VFSUtils.parseUri(str));
        }
        throw new FileNotFoundException("path is empty");
    }

    public static ReadableByteChannel openReadChannel(String str) throws FileNotFoundException {
        if (str != null && !str.isEmpty()) {
            return openReadChannel(VFSUtils.parseUri(str));
        }
        throw new FileNotFoundException("path is empty");
    }

    public static OutputStream openWrite(String str) throws FileNotFoundException {
        return openWrite(str, false);
    }

    public static WritableByteChannel openWriteChannel(String str) throws FileNotFoundException {
        return openWriteChannel(str, false);
    }

    public static String readFileAsString(String str) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(openRead(str));
                try {
                    char[] cArr = new char[512];
                    while (true) {
                        int read = inputStreamReader2.read(cArr);
                        if (read != -1) {
                            sb5.append(cArr, 0, read);
                        } else {
                            VFSUtils.closeQuietly(inputStreamReader2);
                            return sb5.toString();
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    inputStreamReader = inputStreamReader2;
                    QLog.e(TAG, 1, "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = inputStreamReader2;
                    VFSUtils.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0099: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:154), block:B:45:0x0099 */
    public static byte[] readFromFile(String str, int i3, int i16) {
        int i17;
        InputStream inputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (str == null) {
            return null;
        }
        if (i16 >= 0 && i16 <= 8388608) {
            i17 = i16;
        } else {
            i17 = 4096;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i17);
        try {
            try {
                inputStream = openRead(str);
                for (long j3 = i3; j3 > 0; j3 -= inputStream.skip(j3)) {
                    try {
                    } catch (IOException e16) {
                        e = e16;
                        QLog.e(TAG, 1, "readFromFile failed: " + str + ", " + e.getMessage());
                        VFSUtils.closeQuietly(inputStream);
                        return null;
                    }
                }
                byte[] bArr = new byte[1024];
                if (i16 < 0) {
                    i16 = Integer.MAX_VALUE;
                }
                while (true) {
                    int read = inputStream.read(bArr, 0, Math.min(i16, 1024));
                    if (read == -1 || i16 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    i16 -= read;
                }
                VFSUtils.closeQuietly(inputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, String.format("readFromFile: %s [%d]", str, Integer.valueOf(byteArray.length)));
                }
                return byteArray;
            } catch (IOException e17) {
                e = e17;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                VFSUtils.closeQuietly(closeable2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            VFSUtils.closeQuietly(closeable2);
            throw th;
        }
    }

    private static boolean recursiveCopyOrMove(FileSystemManager.Resolution resolution, FileSystemManager.Resolution resolution2, boolean z16) {
        Iterable<FileSystem.FileEntry> list;
        String str;
        if (!resolution.valid() || !resolution2.valid() || (list = resolution.fileSystem.list(resolution.path, true)) == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        resolution2.fileSystem.mkdirs(resolution2.path);
        hashSet.add(resolution2.path);
        for (FileSystem.FileEntry fileEntry : list) {
            String substring = fileEntry.relPath.substring(resolution.path.length());
            if (!substring.startsWith("/")) {
                substring = "/" + substring;
            }
            String str2 = resolution2.path + substring;
            if (fileEntry.isDirectory) {
                if (hashSet.add(str2)) {
                    resolution2.fileSystem.mkdirs(str2);
                }
            } else {
                int lastIndexOf = str2.lastIndexOf(47);
                if (lastIndexOf > 0) {
                    String substring2 = str2.substring(0, lastIndexOf);
                    if (hashSet.add(substring2)) {
                        resolution2.fileSystem.mkdirs(substring2);
                    }
                }
                if (z16) {
                    try {
                        resolution2.fileSystem.moveFile(str2, fileEntry.fileSystem, fileEntry.relPath);
                    } catch (IOException unused) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Failed to ");
                        if (z16) {
                            str = "move";
                        } else {
                            str = "copy";
                        }
                        sb5.append(str);
                        sb5.append(" files.");
                        QLog.e(TAG, 1, sb5.toString());
                        return false;
                    }
                } else {
                    resolution2.fileSystem.copyFile(str2, fileEntry.fileSystem, fileEntry.relPath);
                }
            }
        }
        return true;
    }

    public static boolean renameFile(String str, String str2, String str3) {
        return moveFile(str + str2, str + str3);
    }

    public static int unzipFolder(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(openRead(str));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            if (!name.contains("../") && !name.contains("..\\")) {
                                if (nextEntry.isDirectory()) {
                                    new VFSFile(str2 + "/" + name.substring(0, name.length() - 1)).mkdirs();
                                } else {
                                    OutputStream openWrite = openWrite(new VFSFile(str2 + "/" + name));
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = zipInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        openWrite.write(bArr, 0, read);
                                    }
                                    openWrite.close();
                                }
                            }
                        } else {
                            VFSUtils.closeQuietly(zipInputStream2);
                            return 0;
                        }
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        zipInputStream = zipInputStream2;
                        QLog.e(TAG, 1, "FileNotFoundException unzipFolder is called!", e);
                        VFSUtils.closeQuietly(zipInputStream);
                        return -1;
                    } catch (IOException e17) {
                        e = e17;
                        zipInputStream = zipInputStream2;
                        QLog.e(TAG, 1, "IOException unzipFolder is called!", e);
                        VFSUtils.closeQuietly(zipInputStream);
                        return -2;
                    } catch (Throwable th5) {
                        th = th5;
                        zipInputStream = zipInputStream2;
                        VFSUtils.closeQuietly(zipInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static int writeFile(String str, byte[] bArr) {
        return writeFile(str, bArr, 0, bArr.length);
    }

    public static boolean zipFolder(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            return zipFolders(Collections.singletonList(str), str2);
        }
        return false;
    }

    public static boolean zipFolders(List<String> list, String str) {
        ZipOutputStream zipOutputStream;
        FileSystem.FileEntry stat;
        int i3;
        Iterable<FileSystem.FileEntry> iterable;
        String substring;
        int i16;
        if (str == null || str.isEmpty()) {
            return false;
        }
        mkdirs(getParentAbsolutePath(str));
        byte[] bArr = new byte[4096];
        InputStream inputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(openWrite(str));
            try {
                try {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(it.next()));
                        if (resolve.valid() && (stat = resolve.fileSystem.stat(resolve.path)) != null) {
                            if (stat.isDirectory) {
                                int length = resolve.path.length();
                                if (resolve.path.endsWith("/")) {
                                    i16 = 0;
                                } else {
                                    i16 = 1;
                                }
                                i3 = length + i16;
                                iterable = resolve.fileSystem.list(resolve.path, true);
                                if (iterable == null) {
                                }
                            } else {
                                int lastIndexOf = resolve.path.lastIndexOf(47) + 1;
                                List singletonList = Collections.singletonList(stat);
                                i3 = lastIndexOf;
                                iterable = singletonList;
                            }
                            for (FileSystem.FileEntry fileEntry : iterable) {
                                if (!fileEntry.isDirectory) {
                                    if (fileEntry.relPath.length() < i3) {
                                        substring = fileEntry.name;
                                    } else {
                                        substring = fileEntry.relPath.substring(i3);
                                    }
                                    InputStream openRead = fileEntry.openRead();
                                    try {
                                        zipOutputStream.putNextEntry(new ZipEntry(substring));
                                        while (true) {
                                            int read = openRead.read(bArr);
                                            if (read < 0) {
                                                break;
                                            }
                                            zipOutputStream.write(bArr, 0, read);
                                        }
                                        openRead.close();
                                        zipOutputStream.closeEntry();
                                    } catch (IOException unused) {
                                        inputStream = openRead;
                                        QLog.e(TAG, 1, "Failed to write ZipFile");
                                        VFSUtils.closeQuietly(inputStream);
                                        VFSUtils.closeQuietly(zipOutputStream);
                                        return false;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        inputStream = openRead;
                                        VFSUtils.closeQuietly(inputStream);
                                        VFSUtils.closeQuietly(zipOutputStream);
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                    VFSUtils.closeQuietly((Closeable) null);
                    VFSUtils.closeQuietly(zipOutputStream);
                    return true;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException unused3) {
            zipOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            zipOutputStream = null;
        }
    }

    public static int appendToFile(String str, byte[] bArr, int i3, int i16) {
        if (bArr == null || bArr.length == 0 || bArr.length < i3 + i16) {
            return -2;
        }
        OutputStream outputStream = null;
        try {
            try {
                outputStream = openWrite(str, true);
                outputStream.write(bArr, i3, i16);
                return 0;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, String.format("file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e16.getClass().getSimpleName(), e16.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i16)) + e16);
                }
                VFSUtils.closeQuietly(outputStream);
                return -1;
            }
        } finally {
            VFSUtils.closeQuietly(outputStream);
        }
    }

    public static boolean deleteDir(String str, boolean z16) {
        if (str == null || str.length() == 0) {
            return false;
        }
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(VFSUtils.parseUri(str));
        if (resolve.valid()) {
            return resolve.fileSystem.deleteDir(resolve.path, z16);
        }
        return false;
    }

    public static OutputStream openWrite(Uri uri) throws FileNotFoundException {
        return openWrite(uri, false);
    }

    public static WritableByteChannel openWriteChannel(Uri uri) throws FileNotFoundException {
        return openWriteChannel(uri, false);
    }

    public static int writeFile(String str, byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i3 + i16) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            try {
                outputStream = openWrite(str);
                outputStream.write(bArr, i3, i16);
                return 0;
            } catch (IOException e16) {
                QLog.e(TAG, 1, "writeFile '%s' Failed: %s", str, e16.getMessage());
                VFSUtils.closeQuietly(outputStream);
                return -1;
            }
        } finally {
            VFSUtils.closeQuietly(outputStream);
        }
    }

    public static OutputStream openWrite(VFSFile vFSFile) throws FileNotFoundException {
        return openWrite(vFSFile.getUri(), vFSFile.resolve(), false);
    }

    public static WritableByteChannel openWriteChannel(VFSFile vFSFile) throws FileNotFoundException {
        return openWriteChannel(vFSFile.getUri(), vFSFile.resolve(), false);
    }

    public static ParcelFileDescriptor openFileDescriptor(Uri uri, String str) throws FileNotFoundException {
        return openFileDescriptor(uri, null, str);
    }

    public static RandomAccessFile openRandomAccess(Uri uri, boolean z16) throws FileNotFoundException {
        String resolveRealPath = VFSUtils.resolveRealPath(uri, z16);
        if (resolveRealPath != null) {
            return new RandomAccessFile(resolveRealPath, z16 ? "rw" : "r");
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    public static InputStream openRead(Uri uri) throws FileNotFoundException {
        return openRead(uri, null);
    }

    public static ReadableByteChannel openReadChannel(Uri uri) throws FileNotFoundException {
        return openReadChannel(uri, null);
    }

    public static OutputStream openWrite(String str, boolean z16) throws FileNotFoundException {
        if (str != null && !str.isEmpty()) {
            return openWrite(VFSUtils.parseUri(str), z16);
        }
        throw new FileNotFoundException("path is empty");
    }

    public static WritableByteChannel openWriteChannel(String str, boolean z16) throws FileNotFoundException {
        if (str != null && !str.isEmpty()) {
            return openWriteChannel(VFSUtils.parseUri(str), null, z16);
        }
        throw new FileNotFoundException("path is empty");
    }

    public static ParcelFileDescriptor openFileDescriptor(VFSFile vFSFile, String str) throws FileNotFoundException {
        return openFileDescriptor(vFSFile.getUri(), vFSFile.resolve(), str);
    }

    public static InputStream openRead(VFSFile vFSFile) throws FileNotFoundException {
        return openRead(vFSFile.getUri(), vFSFile.resolve());
    }

    public static ReadableByteChannel openReadChannel(VFSFile vFSFile) throws FileNotFoundException {
        return openReadChannel(vFSFile.getUri(), vFSFile.resolve());
    }

    static ParcelFileDescriptor openFileDescriptor(Uri uri, FileSystemManager.Resolution resolution, String str) throws FileNotFoundException {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(uri, resolution);
        if (resolve.valid()) {
            return resolve.fileSystem.openParcelFd(resolve.path, str);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InputStream openRead(Uri uri, FileSystemManager.Resolution resolution) throws FileNotFoundException {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(uri, resolution);
        if (resolve.valid()) {
            return resolve.fileSystem.openRead(resolve.path);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    static ReadableByteChannel openReadChannel(Uri uri, FileSystemManager.Resolution resolution) throws FileNotFoundException {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(uri, resolution);
        if (resolve.valid()) {
            return resolve.fileSystem.openReadChannel(resolve.path);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    public static OutputStream openWrite(Uri uri, boolean z16) throws FileNotFoundException {
        return openWrite(uri, null, z16);
    }

    public static WritableByteChannel openWriteChannel(Uri uri, boolean z16) throws FileNotFoundException {
        return openWriteChannel(uri, null, z16);
    }

    public static OutputStream openWrite(VFSFile vFSFile, boolean z16) throws FileNotFoundException {
        return openWrite(vFSFile.getUri(), vFSFile.resolve(), z16);
    }

    public static WritableByteChannel openWriteChannel(VFSFile vFSFile, boolean z16) throws FileNotFoundException {
        return openWriteChannel(vFSFile.getUri(), vFSFile.resolve(), z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputStream openWrite(Uri uri, FileSystemManager.Resolution resolution, boolean z16) throws FileNotFoundException {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(uri, resolution);
        if (resolve.valid()) {
            return resolve.fileSystem.openWrite(resolve.path, z16);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }

    static WritableByteChannel openWriteChannel(Uri uri, FileSystemManager.Resolution resolution, boolean z16) throws FileNotFoundException {
        FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(uri, resolution);
        if (resolve.valid()) {
            return resolve.fileSystem.openWriteChannel(resolve.path, z16);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + uri);
    }
}
