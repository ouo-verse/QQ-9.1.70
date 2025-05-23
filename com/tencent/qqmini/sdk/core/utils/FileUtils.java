package com.tencent.qqmini.sdk.core.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.util.InputMethodUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileUtils {
    public static final String SECONDARY_DIRECTORY = "QQMiniApp";
    private static final String TAG = "FileUtils";
    public static final String EXTERNAL_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    public static Boolean sIsTargetThanN = null;
    public static String sAuthority = null;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum MediaType {
        PICTURE,
        VIDEO,
        AUDIO
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MyFileCompare implements Comparator<FileInfo> {
        @Override // java.util.Comparator
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            if (fileInfo.isDirectory()) {
                if (!fileInfo2.isDirectory()) {
                    return -1;
                }
            } else if (fileInfo2.isDirectory()) {
                return 1;
            }
            if (fileInfo.getDate() > fileInfo2.getDate()) {
                return -1;
            }
            return fileInfo.getDate() == fileInfo2.getDate() ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f348070a;

        static {
            int[] iArr = new int[MediaType.values().length];
            f348070a = iArr;
            try {
                iArr[MediaType.PICTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f348070a[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f348070a[MediaType.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void broadcastCarmera(Context context, File file) {
        FileProvider7Helper.savePhotoToSysAlbum(context, file);
    }

    public static boolean checkDirAndCreate(String str) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            QMLog.w("FileUtils", "mkdirs failed, path: " + str);
            return false;
        }
        return true;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static boolean copyFile(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            try {
                return copyFile(file, createFile(str2));
            } catch (IOException unused) {
                return false;
            }
        }
        QMLog.e("FileUtils", "copyFile fromPath or toPath is invalid!");
        return false;
    }

    public static File createFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static long delete(String str, boolean z16) {
        long j3 = 0;
        if (str == null) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        if (file.isFile()) {
            long length = file.length();
            file.delete();
            return length;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            j3 += delete(file2.getAbsolutePath(), z16);
        }
        if (!z16) {
            file.delete();
        }
        return j3;
    }

    public static long deleteDirectory(String str) {
        long j3 = 0;
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (listFiles[i3].isDirectory()) {
                        j3 += deleteDirectory(listFiles[i3].getAbsolutePath());
                    } else {
                        j3 += listFiles[i3].length();
                        listFiles[i3].delete();
                    }
                }
            }
            file.delete();
        }
        return j3;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static long deleteFilesInDirectory(String str) {
        File[] listFiles;
        long j3 = 0;
        if (str != null && str.trim().length() != 0 && (listFiles = new File(str).listFiles()) != null && listFiles.length > 0) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    j3 += deleteDirectory(listFiles[i3].getAbsolutePath());
                } else {
                    j3 += listFiles[i3].length();
                    listFiles[i3].delete();
                }
            }
        }
        return j3;
    }

    public static void deleteSubFile(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
    }

    @RequiresApi(26)
    public static void deleteV2(String str) {
        Path path;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (!file.isFile()) {
                path = file.toPath();
                b bVar = new b(null);
                Files.walkFileTree(path, bVar);
                long a16 = bVar.a();
                if (a16 > 1000) {
                    QMLog.w("FileUtils", "deleteFileV2: too many files, count=" + a16);
                    return;
                }
                return;
            }
            file.delete();
        } catch (IOException e16) {
            QMLog.e("FileUtils", "deleteFileV2: error, path=" + str, e16);
        }
    }

    public static boolean fileExists(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static byte[] fileToBytes(File file) {
        BufferedInputStream bufferedInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                long length = file.length();
                if (length <= TTL.MAX_VALUE && length > 0) {
                    int i3 = (int) length;
                    byte[] bArr = new byte[i3];
                    int i16 = 0;
                    while (i16 < i3) {
                        int read = bufferedInputStream.read(bArr, i16, i3 - i16);
                        if (read < 0) {
                            break;
                        }
                        i16 += read;
                    }
                    if (i16 < i3) {
                        QMLog.d("FileUtils", "Could not completely read file " + file);
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    return bArr;
                }
                QMLog.d("FileUtils", "return null. File length=" + length);
                try {
                    bufferedInputStream.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                return null;
            } catch (Throwable unused) {
                try {
                    QMLog.d("FileUtils", "Failed to read file " + file);
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            bufferedInputStream = null;
        }
    }

    private static String findMediaSavingDir(MediaType mediaType) {
        int i3 = a.f348070a[mediaType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return Environment.DIRECTORY_MUSIC;
            }
            return Environment.DIRECTORY_MOVIES;
        }
        return Environment.DIRECTORY_PICTURES;
    }

    public static ArrayList<String> getChildFiles(String str, boolean z16) {
        File file = new File(str);
        ArrayList<String> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        try {
            int length = listFiles.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    if (z16) {
                        arrayList.add(listFiles[i3].getCanonicalPath());
                    }
                    arrayList.addAll(getChildFiles(listFiles[i3].getCanonicalPath(), z16));
                } else {
                    arrayList.add(listFiles[i3].getCanonicalPath());
                }
            }
        } catch (Exception e16) {
            QMLog.e("FileUtils.getChildFiles", "getChildFiles error. " + e16);
        }
        return arrayList;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return "";
        }
        if (str.endsWith(".rename")) {
            String replace = str.replace(".rename", "");
            int lastIndexOf = replace.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return "";
            }
            if (replace.substring(lastIndexOf).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk")) {
                return ".apk.rename";
            }
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            return "";
        }
        return str.substring(lastIndexOf2);
    }

    private static Uri getExternalUri(MediaType mediaType) {
        int i3 = a.f348070a[mediaType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    public static long getFileOrFolderSize(String str) {
        File[] listFiles;
        long length;
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            QMLog.e("FileUtils", "getFileOrFolderSize error, path is empty, please check");
            return 0L;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (file2.isDirectory()) {
                            length = getFileOrFolderSize(file2.getAbsolutePath());
                        } else if (file2.isFile()) {
                            length = file2.length();
                        }
                        j3 += length;
                    }
                }
            }
        }
        return j3;
    }

    public static long getFileSizes(String str) {
        try {
            return new File(str).length();
        } catch (Exception e16) {
            QMLog.e("FileUtils", "fail filePath: " + str, e16);
            return 0L;
        }
    }

    public static ArrayList<FileInfo> getFiles(String str, boolean z16, int i3) {
        File[] listFiles;
        ArrayList<FileInfo> arrayList = null;
        try {
            listFiles = new File(str).listFiles();
        } catch (Exception unused) {
        }
        if (listFiles == null) {
            return null;
        }
        arrayList = new ArrayList<>();
        for (File file : listFiles) {
            if ((z16 || !file.getName().startsWith(".")) && (file.isDirectory() || file.length() != 0)) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(file.getName());
                fileInfo.setDirectory(file.isDirectory());
                fileInfo.setPath(file.getPath());
                fileInfo.setSize(file.length());
                fileInfo.setDate(file.lastModified());
                arrayList.add(fileInfo);
            }
        }
        if (i3 == 0) {
            Collections.sort(arrayList, new MyFileCompare());
        } else {
            Collections.sort(arrayList, new FileCompare());
        }
        return arrayList;
    }

    public static JSONObject getStats(String str) {
        try {
            StructStat stat = Os.stat(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mode", stat.st_mode);
            jSONObject.put("size", stat.st_size);
            jSONObject.put("lastAccessedTime", stat.st_atime);
            jSONObject.put("lastModifiedTime", stat.st_mtime);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("FileUtils.getStats", "getStats error. " + e16);
            return null;
        }
    }

    public static JSONObject getStatsByDir(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("/", getStats(str));
            ArrayList<String> childFiles = getChildFiles(str, true);
            String str2 = new File(str).getCanonicalPath() + "/";
            Iterator<String> it = childFiles.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jSONObject.put(next.replace(str2, ""), getStats(next));
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("FileUtils.getStatsByDir", "getStatsByDir error. " + e16);
            return null;
        }
    }

    public static Uri getUriForFile(Context context, File file) {
        if (isTargetBeyondN(context)) {
            return getUriForFile24(context, file);
        }
        return Uri.fromFile(file);
    }

    private static Uri getUriForFile24(Context context, File file) {
        if (sAuthority == null) {
            sAuthority = context.getApplicationContext().getPackageName() + ".fileprovider";
        }
        return FileProvider.getUriForFile(context, sAuthority, file);
    }

    public static boolean isExternalStoragePath(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null || context.getExternalCacheDir() == null) {
            return false;
        }
        String parent = context.getExternalCacheDir().getParent();
        if (!str.startsWith(EXTERNAL_DIR) || str.startsWith(parent)) {
            return false;
        }
        return true;
    }

    public static void isFileValied(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return;
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static boolean isTargetBeyondN(Context context) {
        boolean z16;
        if (sIsTargetThanN == null) {
            if (Build.VERSION.SDK_INT >= 24 && context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 24) {
                z16 = true;
            } else {
                z16 = false;
            }
            sIsTargetThanN = Boolean.valueOf(z16);
        }
        return sIsTargetThanN.booleanValue();
    }

    private static ContentValues newContentValues(MediaType mediaType, String str) {
        ContentValues contentValues = new ContentValues();
        String findMediaSavingDir = findMediaSavingDir(mediaType);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", findMediaSavingDir + "/" + SECONDARY_DIRECTORY);
        } else {
            String str2 = Environment.getExternalStoragePublicDirectory(findMediaSavingDir) + "/" + SECONDARY_DIRECTORY;
            checkDirAndCreate(str2);
            contentValues.put("_data", str2 + "/" + str);
        }
        return contentValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileFromAssets(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
        } catch (Exception e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (inputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                String str2 = new String(bArr, "utf8");
                try {
                    inputStream.close();
                } catch (IOException e17) {
                    QMLog.e("FileUtils", "readFileFromAssets close error. " + e17);
                }
                return str2;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e18) {
                        QMLog.e("FileUtils", "readFileFromAssets close error. " + e18);
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            QMLog.e("FileUtils", "readFileFromAssets error. " + e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e26) {
                    QMLog.e("FileUtils", "readFileFromAssets close error. " + e26);
                }
            }
            return null;
        }
    }

    public static String readFileToStr(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return readFileToString(file);
                }
                return null;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        if (r2 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileToString(File file) throws IOException {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        String str = null;
        if (file == null) {
            return null;
        }
        isFileValied(file);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            } catch (Exception unused) {
                inputStreamReader = null;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
            }
            try {
                int length = (int) file.length();
                if (length > 12288) {
                    char[] cArr = new char[4096];
                    StringBuilder sb5 = new StringBuilder(12288);
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (-1 == read) {
                            break;
                        }
                        sb5.append(cArr, 0, read);
                    }
                    str = sb5.toString();
                } else {
                    char[] cArr2 = new char[length];
                    str = new String(cArr2, 0, inputStreamReader.read(cArr2));
                }
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                        throw th;
                    } catch (Exception unused6) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception unused7) {
            fileInputStream = null;
            inputStreamReader = null;
        } catch (Throwable th7) {
            th = th7;
            inputStreamReader = null;
        }
        try {
            inputStreamReader.close();
        } catch (Exception unused8) {
            return str;
        }
    }

    public static boolean rename(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return renameFile(new File(str), new File(str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.net.Uri, java.io.InputStream] */
    public static boolean saveToSharedStorageCompat(Context context, File file, String str, MediaType mediaType) {
        ?? r65;
        BufferedInputStream bufferedInputStream;
        ContentValues newContentValues = newContentValues(mediaType, str);
        ContentResolver contentResolver = context.getContentResolver();
        OutputStream outputStream = null;
        try {
            r65 = contentResolver.insert(getExternalUri(mediaType), newContentValues);
        } catch (IllegalArgumentException e16) {
            QMLog.e("FileUtils", "saveToSharedStorageCompat insert error!", e16);
            r65 = 0;
        }
        try {
            if (r65 == 0) {
                QMLog.e("FileUtils", "saveToSharedStorageCompat: Underlying ContentProvider insert return null Uri");
                return false;
            }
            try {
                OutputStream openOutputStream = contentResolver.openOutputStream(r65);
                try {
                    if (openOutputStream == null) {
                        QMLog.e("FileUtils", "saveToSharedStorageCompat: Opening OutputStream return null");
                        if (openOutputStream != null) {
                            try {
                                openOutputStream.close();
                            } catch (IOException e17) {
                                QMLog.e("FileUtils", "saveToSharedStorageCompat: Error occurred when close streams with ", e17);
                            }
                        }
                        return false;
                    }
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        copyFile(bufferedInputStream, openOutputStream);
                        try {
                            openOutputStream.close();
                            bufferedInputStream.close();
                            return true;
                        } catch (IOException e18) {
                            QMLog.e("FileUtils", "saveToSharedStorageCompat: Error occurred when close streams with ", e18);
                            return true;
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                        outputStream = openOutputStream;
                        QMLog.e("FileUtils", "saveToSharedStorageCompat: target file create failed with ", e);
                        if (outputStream != null) {
                            try {
                            } catch (IOException e26) {
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = openOutputStream;
                        QMLog.e("FileUtils", "saveToSharedStorageCompat: Error occurred when copyfile: ", th);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e27) {
                                QMLog.e("FileUtils", "saveToSharedStorageCompat: Error occurred when close streams with ", e27);
                                return false;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return false;
                    }
                } catch (FileNotFoundException e28) {
                    e = e28;
                    bufferedInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = null;
                }
            } catch (FileNotFoundException e29) {
                e = e29;
                bufferedInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = null;
            }
        } finally {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e36) {
                    QMLog.e("FileUtils", "saveToSharedStorageCompat: Error occurred when close streams with ", e36);
                }
            }
            if (r65 != 0) {
                r65.close();
            }
        }
    }

    public static boolean saveVideoToAlbum(Context context, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (parent != null) {
            checkDirAndCreate(parent);
        }
        QMLog.i("FileUtils", "saveVideoToAlbum: " + copyFile(file, file2));
        broadcastCarmera(context, file2);
        return true;
    }

    public static boolean writeFile(String str, byte[] bArr) {
        return writeFile(str, bArr, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(api = 26)
    /* loaded from: classes23.dex */
    public static class b implements FileVisitor<Path> {

        /* renamed from: a, reason: collision with root package name */
        private long f348071a;

        b() {
            this.f348071a = 0L;
        }

        public long a() {
            return this.f348071a;
        }

        @Override // java.nio.file.FileVisitor
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileVisitResult postVisitDirectory(Path path, IOException iOException) throws IOException {
            FileVisitResult fileVisitResult;
            Files.delete(path);
            this.f348071a++;
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }

        @Override // java.nio.file.FileVisitor
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            FileVisitResult fileVisitResult;
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }

        @Override // java.nio.file.FileVisitor
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            FileVisitResult fileVisitResult;
            Files.delete(path);
            this.f348071a++;
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }

        @Override // java.nio.file.FileVisitor
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public FileVisitResult visitFileFailed(Path path, IOException iOException) throws IOException {
            FileVisitResult fileVisitResult;
            QMLog.e("FileUtils", "visitFileFailed: file=" + path, iOException);
            fileVisitResult = FileVisitResult.CONTINUE;
            return fileVisitResult;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static boolean writeFile(String str, byte[] bArr, boolean z16) {
        return writeFile(str, bArr, z16, bArr.length);
    }

    public static boolean writeFile(String str, byte[] bArr, boolean z16, int i3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z16);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, 0, i3);
                fileOutputStream.flush();
                fileOutputStream.close();
                z17 = true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z17;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    public static boolean renameFile(File file, File file2) {
        boolean delete = file2.exists() ? file2.delete() : true;
        return delete ? file.renameTo(file2) : delete;
    }

    public static boolean copyFile(File file, File file2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                            fileOutputStream2.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return true;
                } catch (IOException unused3) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (bufferedInputStream == null) {
                        return false;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                        return false;
                    }
                } catch (OutOfMemoryError unused6) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (bufferedInputStream == null) {
                        return false;
                    }
                    bufferedInputStream.close();
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            throw th;
                        } catch (IOException unused9) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException unused10) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused11) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
            }
        } catch (IOException unused12) {
            bufferedInputStream = null;
        } catch (OutOfMemoryError unused13) {
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
    }

    public static boolean writeFile(String str, String str2) {
        boolean z16;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
                z16 = false;
            }
        }
        z16 = true;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
            z16 = false;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(str2.getBytes());
            } catch (IOException unused3) {
                z16 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused4) {
                z16 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
                return false;
            }
        }
        return z16;
    }

    public static boolean writeFile(byte[] bArr, String str) {
        return writeFile(bArr, str, false);
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16) {
        return writeFile(bArr, str, z16, bArr.length);
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16, int i3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z16);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, 0, i3);
                fileOutputStream.flush();
                fileOutputStream.close();
                z17 = true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z17;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }
}
