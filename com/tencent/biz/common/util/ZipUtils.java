package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.RecycleableBufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZipUtils {
    protected static final int BUFF_SIZE = 1048576;
    private static final String TAG = "ZipUtils";
    private static UnzipCallback sUnzipCallback;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface UnzipCallback {
        void onFileUnzip(File file, String str);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ZipFilenameFilter {
        boolean accept(ZipEntry zipEntry);
    }

    private static void closeClosable(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e(TAG, 1, "closeClosable error : ", e16);
            }
        }
    }

    public static Enumeration<?> getEntriesEnumeration(File file) throws ZipException, IOException {
        return new QZipFile(file).entries();
    }

    public static ArrayList<String> getEntriesNames(File file) throws ZipException, IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Enumeration<?> entriesEnumeration = getEntriesEnumeration(file);
        while (entriesEnumeration.hasMoreElements()) {
            arrayList.add(new String(getEntryName((ZipEntry) entriesEnumeration.nextElement()).getBytes("GB2312"), "8859_1"));
        }
        return arrayList;
    }

    public static String getEntryComment(ZipEntry zipEntry) throws UnsupportedEncodingException {
        return new String(zipEntry.getComment().getBytes("GB2312"), "8859_1");
    }

    public static String getEntryName(ZipEntry zipEntry) throws UnsupportedEncodingException {
        return new String(zipEntry.getName().getBytes("GB2312"), "8859_1");
    }

    public static long getUncompressedFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            QZipFile qZipFile = new QZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                long j3 = 0;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        j3 += nextElement.getSize();
                    }
                }
                qZipFile.close();
                return j3;
            } finally {
            }
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static UnzipCallback getUnzipCallback() {
        return sUnzipCallback;
    }

    public static File newFile(File file, ZipEntry zipEntry) {
        File file2;
        File file3 = null;
        try {
            file2 = new File(file, zipEntry.getName());
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            if (!file2.getCanonicalPath().startsWith(canonicalPath + File.separator)) {
                throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
            }
            return file2;
        } catch (Throwable th6) {
            th = th6;
            file3 = file2;
            th.printStackTrace();
            return file3;
        }
    }

    public static void setUnzipCallback(UnzipCallback unzipCallback) {
        sUnzipCallback = unzipCallback;
    }

    public static void unZipFile(File file, String str) throws IOException {
        unZipFile(file, str, true);
    }

    public static int unZipFile2(String str, String str2) {
        QZipInputStream qZipInputStream;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "unZipFile2 new file:" + str + ", folderPath:" + str2);
            }
            File file = new File(str);
            unzipStartNotice(file, str2);
            if (!file.exists()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "unZipFile2  zipFilePath doesn't exist");
                    return -2;
                }
                return -2;
            }
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            try {
                qZipInputStream = new QZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, " unZipFile2  \u89e3\u538b\u9519\u8bef\uff1a", th5);
                }
                qZipInputStream = null;
            }
            try {
                try {
                    try {
                        StringBuilder sb5 = new StringBuilder(512);
                        while (true) {
                            ZipEntry nextEntry = qZipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                sb5.delete(0, sb5.length());
                                String name = nextEntry.getName();
                                if (QLog.isDevelopLevel()) {
                                    QLog.d(TAG, 4, "unZipFile2 folderPath:" + str2 + ",ZipEntry name: " + name);
                                }
                                sb5.append(str2);
                                sb5.append(File.separator);
                                sb5.append(name);
                                if (nextEntry.isDirectory()) {
                                    File file3 = new File(sb5.toString());
                                    if (!file3.exists()) {
                                        file3.mkdirs();
                                    }
                                } else {
                                    File file4 = new File(sb5.toString());
                                    if (!file4.exists()) {
                                        File parentFile = file4.getParentFile();
                                        if (!parentFile.exists()) {
                                            parentFile.mkdirs();
                                        }
                                    }
                                    witeInto(qZipInputStream, file4);
                                }
                            } else {
                                try {
                                    qZipInputStream.close();
                                    return 0;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    return 0;
                                }
                            }
                        }
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e17);
                        }
                        if (qZipInputStream != null) {
                            try {
                                qZipInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        return -4;
                    } catch (Exception e19) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e19);
                        }
                        if (qZipInputStream != null) {
                            try {
                                qZipInputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        return -5;
                    }
                } catch (FileNotFoundException e27) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e27);
                    }
                    if (qZipInputStream != null) {
                        try {
                            qZipInputStream.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                    return -3;
                }
            } catch (Throwable th6) {
                if (qZipInputStream != null) {
                    try {
                        qZipInputStream.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                throw th6;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "unZipFile2 \u53c2\u6570\u9519\u8bef\uff1azipFilePath:" + str + ",folderPath:" + str2);
                return -1;
            }
            return -1;
        }
    }

    public static int unZipFile3(String str, String str2) {
        try {
            return unzipFix(str, new File(str2));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1;
        }
    }

    public static int unZipFiles(File file, String str, ZipFilenameFilter zipFilenameFilter) {
        QZipFile qZipFile;
        QZipFile qZipFile2;
        RecycleableBufferedOutputStream recycleableBufferedOutputStream;
        CheckedInputStream checkedInputStream;
        InputStream inputStream;
        unzipStartNotice(file, str);
        new ArrayList();
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        try {
            qZipFile2 = new QZipFile(file);
        } catch (Throwable th5) {
            th = th5;
            qZipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = qZipFile2.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.getName().contains("..")) {
                    int i3 = 8192;
                    byte[] bArr = new byte[8192];
                    if (zipFilenameFilter != null && zipFilenameFilter.accept(nextElement)) {
                        File file3 = new File(new String((str + File.separator + nextElement.getName()).getBytes("8859_1"), "GB2312"));
                        if (nextElement.isDirectory()) {
                            if (!file3.exists()) {
                                file3.mkdir();
                            }
                        } else {
                            try {
                                inputStream = qZipFile2.getInputStream(nextElement);
                                try {
                                    CheckedInputStream checkedInputStream2 = new CheckedInputStream(inputStream, new CRC32());
                                    try {
                                        recycleableBufferedOutputStream = RecycleableBufferedOutputStream.obtain(new BufferedOutputStream(new FileOutputStream(file3)));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        checkedInputStream = checkedInputStream2;
                                        recycleableBufferedOutputStream = null;
                                    }
                                    try {
                                        long size = nextElement.getSize();
                                        while (size > 0) {
                                            int read = checkedInputStream2.read(bArr, 0, i3);
                                            recycleableBufferedOutputStream.write(bArr, 0, read);
                                            size -= read;
                                            bArr = bArr;
                                            i3 = 8192;
                                        }
                                        if (nextElement.getCrc() != checkedInputStream2.getChecksum().getValue()) {
                                            QLog.e("upZipFile", 1, "crc error name: " + nextElement.getName() + ", zipFile: " + file);
                                            try {
                                                checkedInputStream2.close();
                                            } catch (IOException unused) {
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused2) {
                                                }
                                            }
                                            if (recycleableBufferedOutputStream != null) {
                                                try {
                                                    recycleableBufferedOutputStream.flush();
                                                    recycleableBufferedOutputStream.close();
                                                } catch (IOException unused3) {
                                                }
                                            }
                                            try {
                                                qZipFile2.close();
                                                return -4;
                                            } catch (Exception unused4) {
                                                return -4;
                                            }
                                        }
                                        try {
                                            checkedInputStream2.close();
                                        } catch (IOException unused5) {
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        if (recycleableBufferedOutputStream != null) {
                                            try {
                                                recycleableBufferedOutputStream.flush();
                                                recycleableBufferedOutputStream.close();
                                            } catch (IOException unused7) {
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        checkedInputStream = checkedInputStream2;
                                        if (checkedInputStream != null) {
                                            try {
                                                checkedInputStream.close();
                                            } catch (IOException unused8) {
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused9) {
                                            }
                                        }
                                        if (recycleableBufferedOutputStream != null) {
                                            try {
                                                recycleableBufferedOutputStream.flush();
                                                recycleableBufferedOutputStream.close();
                                                throw th;
                                            } catch (IOException unused10) {
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    recycleableBufferedOutputStream = null;
                                    checkedInputStream = null;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                recycleableBufferedOutputStream = null;
                                checkedInputStream = null;
                                inputStream = null;
                            }
                        }
                    }
                }
            }
            try {
                qZipFile2.close();
            } catch (Exception unused11) {
            }
            return 0;
        } catch (Throwable th10) {
            th = th10;
            qZipFile = qZipFile2;
            try {
                QLog.e("upZipFile", 1, "error " + th.getMessage() + ", zipFile: " + file);
                if (qZipFile != null) {
                    try {
                        qZipFile.close();
                        return -1;
                    } catch (Exception unused12) {
                        return -1;
                    }
                }
                return -1;
            } catch (Throwable th11) {
                if (qZipFile != null) {
                    try {
                        qZipFile.close();
                    } catch (Exception unused13) {
                    }
                }
                throw th11;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0138, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x013a, code lost:
    
        com.tencent.qphone.base.util.QLog.d("upZipFile", 2, "" + r10.getCrc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0153, code lost:
    
        r13.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[Catch: Exception -> 0x019d, IOException -> 0x01a3, FileNotFoundException -> 0x01a9, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x019d, blocks: (B:17:0x0073, B:18:0x0080, B:20:0x0087, B:23:0x009b, B:25:0x00b3, B:27:0x00c2, B:71:0x0153, B:87:0x0158, B:83:0x015d, B:52:0x0165, B:60:0x016a, B:56:0x016f, B:110:0x018a, B:106:0x018f, B:98:0x0194, B:99:0x019a), top: B:16:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int unZipFolder(String str, String str2) {
        QZipFile qZipFile;
        int i3;
        CheckedInputStream checkedInputStream;
        RecycleableBufferedOutputStream recycleableBufferedOutputStream;
        InputStream inputStream;
        if (TextUtils.isEmpty(str2)) {
            QLog.e("upZipFile", 4, "new file:" + str.toString() + ",target is null ");
            return 9;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("upZipFile", 4, "new file:" + str.toString() + ", " + str2);
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str);
        unzipStartNotice(file2, str2);
        try {
            qZipFile = new QZipFile(file2);
            int i16 = 8192;
            try {
                try {
                    byte[] bArr = new byte[8192];
                    StringBuilder sb5 = new StringBuilder(512);
                    Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                    while (true) {
                        if (entries.hasMoreElements()) {
                            ZipEntry nextElement = entries.nextElement();
                            String name = nextElement.getName();
                            if (!name.contains("..")) {
                                sb5.delete(0, sb5.length());
                                sb5.append(str2);
                                sb5.append(File.separator);
                                sb5.append(name);
                                if (nextElement.isDirectory()) {
                                    File file3 = new File(sb5.toString());
                                    if (!file3.exists()) {
                                        file3.mkdirs();
                                    }
                                } else {
                                    try {
                                        inputStream = qZipFile.getInputStream(nextElement);
                                        try {
                                            CheckedInputStream checkedInputStream2 = new CheckedInputStream(inputStream, new CRC32());
                                            try {
                                                File file4 = new File(new String(sb5.toString().getBytes("8859_1"), "GB2312"));
                                                if (!file4.exists()) {
                                                    File parentFile = file4.getParentFile();
                                                    if (!parentFile.exists()) {
                                                        parentFile.mkdirs();
                                                    }
                                                }
                                                recycleableBufferedOutputStream = RecycleableBufferedOutputStream.obtain(new BufferedOutputStream(new FileOutputStream(file4)));
                                            } catch (Throwable th5) {
                                                th = th5;
                                                checkedInputStream = checkedInputStream2;
                                                recycleableBufferedOutputStream = null;
                                                if (checkedInputStream != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (recycleableBufferedOutputStream == null) {
                                                }
                                            }
                                            try {
                                                long size = nextElement.getSize();
                                                while (size > 0) {
                                                    int read = checkedInputStream2.read(bArr, 0, i16);
                                                    recycleableBufferedOutputStream.write(bArr, 0, read);
                                                    size -= read;
                                                    i16 = 8192;
                                                }
                                                if (nextElement.getCrc() != checkedInputStream2.getChecksum().getValue()) {
                                                    break;
                                                }
                                                try {
                                                    checkedInputStream2.close();
                                                } catch (IOException unused) {
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                }
                                                if (recycleableBufferedOutputStream != null) {
                                                    try {
                                                        recycleableBufferedOutputStream.flush();
                                                        recycleableBufferedOutputStream.close();
                                                    } catch (IOException unused3) {
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                checkedInputStream = checkedInputStream2;
                                                if (checkedInputStream != null) {
                                                    try {
                                                        checkedInputStream.close();
                                                    } catch (IOException unused4) {
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused5) {
                                                    }
                                                }
                                                if (recycleableBufferedOutputStream == null) {
                                                    try {
                                                        recycleableBufferedOutputStream.flush();
                                                        recycleableBufferedOutputStream.close();
                                                        throw th;
                                                    } catch (IOException unused6) {
                                                        throw th;
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            checkedInputStream = null;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        checkedInputStream = null;
                                        recycleableBufferedOutputStream = null;
                                        inputStream = null;
                                    }
                                }
                                i16 = 8192;
                            }
                        } else {
                            i3 = 0;
                            break;
                        }
                    }
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                    i3 = 5;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    i3 = 6;
                }
            } catch (Exception e18) {
                e18.printStackTrace();
                i3 = 7;
            }
            try {
                qZipFile.close();
                return i3;
            } catch (IOException e19) {
                e19.printStackTrace();
                return 8;
            }
        } catch (ZipException unused7) {
            if (QLog.isColorLevel()) {
                QLog.d("upZipFile", 2, "ZipException");
            }
            closeClosable(null);
            return 1;
        } catch (IOException unused8) {
            if (QLog.isColorLevel()) {
                QLog.d("upZipFile", 2, "IOException");
            }
            closeClosable(null);
            return 2;
        } catch (Exception unused9) {
            if (QLog.isColorLevel()) {
                QLog.d("upZipFile", 2, "Exception");
            }
            closeClosable(null);
            return 3;
        }
        i3 = 4;
        qZipFile.close();
        return i3;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused10) {
            }
        }
        if (recycleableBufferedOutputStream != null) {
            try {
                recycleableBufferedOutputStream.flush();
                recycleableBufferedOutputStream.close();
            } catch (IOException unused11) {
            }
        }
        i3 = 4;
        qZipFile.close();
        return i3;
        if (recycleableBufferedOutputStream != null) {
        }
        i3 = 4;
        qZipFile.close();
        return i3;
    }

    public static ArrayList<File> unZipSelectedFile(File file, String str, String str2) throws ZipException, IOException {
        OutputStream outputStream;
        InputStream inputStream;
        unzipStartNotice(file, str);
        ArrayList<File> arrayList = new ArrayList<>();
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        QZipFile qZipFile = new QZipFile(file);
        Enumeration<? extends ZipEntry> entries = qZipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.getName().contains("..") && nextElement.getName().contains(str2)) {
                InputStream inputStream2 = null;
                try {
                    inputStream = qZipFile.getInputStream(nextElement);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                }
                try {
                    File file3 = new File(new String((str + File.separator + nextElement.getName()).getBytes("8859_1"), "GB2312"));
                    if (!file3.exists()) {
                        File parentFile = file3.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                    }
                    RecycleableBufferedOutputStream obtain = RecycleableBufferedOutputStream.obtain(new BufferedOutputStream(new FileOutputStream(file3)));
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        obtain.write(bArr, 0, read);
                    }
                    arrayList.add(file3);
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    if (obtain != null) {
                        try {
                            obtain.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static int unzipFix(String str, File file) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[1024];
        int i3 = -1;
        QZipInputStream qZipInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                QZipInputStream qZipInputStream2 = new QZipInputStream(new FileInputStream(str));
                try {
                    ZipEntry nextEntry = qZipInputStream2.getNextEntry();
                    while (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (name != null && !name.contains("../")) {
                            File newFile = newFile(file, nextEntry);
                            if (nextEntry.isDirectory()) {
                                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                                    throw new IOException("Failed to create directory " + newFile);
                                }
                            } else {
                                File parentFile = newFile.getParentFile();
                                if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                                    throw new IOException("Failed to create directory " + parentFile);
                                }
                                FileOutputStream fileOutputStream3 = new FileOutputStream(newFile);
                                while (true) {
                                    try {
                                        int read = qZipInputStream2.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, 0, read);
                                    } catch (Throwable th5) {
                                        qZipInputStream = qZipInputStream2;
                                        fileOutputStream = fileOutputStream3;
                                        th = th5;
                                        try {
                                            th.printStackTrace();
                                            if (qZipInputStream != null) {
                                                try {
                                                    qZipInputStream.close();
                                                } catch (IOException e16) {
                                                    QLog.d(TAG, 1, "close zis error : ", e16);
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            return i3;
                                        } finally {
                                        }
                                    }
                                }
                                fileOutputStream3.close();
                                fileOutputStream2 = fileOutputStream3;
                            }
                            nextEntry = qZipInputStream2.getNextEntry();
                        }
                    }
                    qZipInputStream2.closeEntry();
                    qZipInputStream2.close();
                    try {
                        qZipInputStream2.close();
                        i3 = 0;
                    } catch (IOException e17) {
                        QLog.d(TAG, 1, "close zis error : ", e17);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                    qZipInputStream = qZipInputStream2;
                }
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (IOException e18) {
            QLog.d(TAG, 1, "close fos error : ", e18);
        }
        return i3;
    }

    private static void unzipStartNotice(File file, String str) {
        UnzipCallback unzipCallback = sUnzipCallback;
        if (unzipCallback != null) {
            unzipCallback.onFileUnzip(file, str);
        }
    }

    private static void witeInto(QZipInputStream qZipInputStream, File file) {
        byte[] bArr = new byte[8192];
        RecycleableBufferedOutputStream recycleableBufferedOutputStream = null;
        try {
            try {
                recycleableBufferedOutputStream = RecycleableBufferedOutputStream.obtain(new FileOutputStream(file));
                while (true) {
                    int read = qZipInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    } else {
                        recycleableBufferedOutputStream.write(bArr, 0, read);
                    }
                }
                if (recycleableBufferedOutputStream != null) {
                    try {
                        recycleableBufferedOutputStream.close();
                    } catch (IOException e16) {
                        e = e16;
                        if (!QLog.isColorLevel()) {
                            return;
                        }
                        QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e);
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e17);
                }
                if (recycleableBufferedOutputStream != null) {
                    try {
                        recycleableBufferedOutputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (!QLog.isColorLevel()) {
                            return;
                        }
                        QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e);
                    }
                }
            }
        } catch (Throwable th5) {
            if (recycleableBufferedOutputStream != null) {
                try {
                    recycleableBufferedOutputStream.close();
                } catch (IOException e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "unZipFile2 \u89e3\u538b\u9519\u8bef", e19);
                    }
                }
            }
            throw th5;
        }
    }

    public static void unZipFile(File file, String str, boolean z16) throws IOException {
        RecycleableBufferedOutputStream recycleableBufferedOutputStream;
        unzipStartNotice(file, str);
        try {
            QZipFile qZipFile = new QZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                byte[] bArr = new byte[8192];
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.getName().contains("..")) {
                        if (nextElement.isDirectory()) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("upZipFile", 4, "ze.getName() = " + nextElement.getName());
                            }
                            String str2 = new String((str + nextElement.getName()).getBytes("8859_1"), "GB2312");
                            if (QLog.isColorLevel()) {
                                QLog.d("upZipFile", 2, "str = " + str2);
                            }
                            new File(str2).mkdir();
                        } else {
                            File file2 = new File(str + nextElement.getName());
                            file2.getParentFile().mkdirs();
                            InputStream inputStream = null;
                            try {
                                recycleableBufferedOutputStream = RecycleableBufferedOutputStream.obtain(new FileOutputStream(file2));
                            } catch (Throwable th5) {
                                th = th5;
                                recycleableBufferedOutputStream = null;
                            }
                            try {
                                inputStream = qZipFile.getInputStream(nextElement);
                                while (true) {
                                    int read = inputStream.read(bArr, 0, 8192);
                                    if (read != -1) {
                                        recycleableBufferedOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                                inputStream.close();
                                if (recycleableBufferedOutputStream != null) {
                                    try {
                                        recycleableBufferedOutputStream.flush();
                                        recycleableBufferedOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (recycleableBufferedOutputStream != null) {
                                    try {
                                        recycleableBufferedOutputStream.flush();
                                        recycleableBufferedOutputStream.close();
                                        throw th;
                                    } catch (IOException unused4) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                qZipFile.close();
            } finally {
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, z16 + " - unZipFile error : ", e16);
            if (!z16) {
                throw e16;
            }
        }
    }
}
