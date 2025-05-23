package com.qq.e.comm.util;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.net.rr.Response;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FileUtil {
    public static boolean copyTo(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            tryClose(inputStream);
                            tryClose(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    try {
                        GDTLogger.e(String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath()), th);
                        return false;
                    } finally {
                        tryClose(inputStream);
                        tryClose(fileOutputStream);
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        return false;
    }

    public static void deleteDir(File file) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (ArrayUtilStub.isNullOrEmpty(listFiles)) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        deleteDir(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean deleteFileSafely(File file) {
        boolean z16 = false;
        if (file != null && file.exists()) {
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    try {
                        boolean tryWriteLock = tryWriteLock(fileOutputStream3);
                        if (tryWriteLock != 0) {
                            z16 = file.delete();
                        }
                        tryClose(fileOutputStream3);
                        fileOutputStream = tryWriteLock;
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream2 = fileOutputStream3;
                        GDTLogger.e("build stream, " + e.toString());
                        tryClose(fileOutputStream2);
                        fileOutputStream = fileOutputStream2;
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream3;
                        tryClose(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return z16;
    }

    public static boolean deleteObjectFromCache(Serializable serializable, String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static String getConfigDir() {
        String rootDir = getRootDir();
        if (rootDir != null) {
            return rootDir + File.separator + Constants.TangramFiles.TG_CONFIG_DIR;
        }
        return null;
    }

    public static long getDirSize(File file) {
        long j3 = 0;
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (ArrayUtilStub.isNullOrEmpty(listFiles)) {
                return 0L;
            }
            for (File file2 : listFiles) {
                j3 += file2.isDirectory() ? getDirSize(file2) : file2.length();
            }
        }
        return j3;
    }

    public static File getDownladVideoFile(String str) {
        File rewardVideoDownLoadDir = getRewardVideoDownLoadDir();
        if (rewardVideoDownLoadDir == null) {
            return null;
        }
        String downloadFileNameFromUrl = getDownloadFileNameFromUrl(str);
        if (TextUtils.isEmpty(downloadFileNameFromUrl)) {
            return null;
        }
        return new File(rewardVideoDownLoadDir, downloadFileNameFromUrl);
    }

    public static File getDownloadDir() {
        File externalCacheDirSafe = getExternalCacheDirSafe();
        File cacheDir = GDTADManager.getInstance().getAppContext().getApplicationContext().getCacheDir();
        if (externalCacheDirSafe == null) {
            externalCacheDirSafe = cacheDir;
        }
        File file = new File(externalCacheDirSafe, "com_qq_e_download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getDownloadFileNameFromUrl(String str) {
        return Md5Util.encode(str);
    }

    public static File getExternalCacheDirSafe() {
        try {
            return GDTADManager.getInstance().getAppContext().getApplicationContext().getExternalCacheDir();
        } catch (Throwable th5) {
            GDTLogger.e("PluginFileUtil getExternalCacheDir error", th5);
            return null;
        }
    }

    public static String getFileName(String str) {
        return Md5Util.encode(str);
    }

    public static List<File> getFiles(String str, List<File> list) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (ArrayUtilStub.isNullOrEmpty(listFiles)) {
                return null;
            }
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        getFiles(file2.getAbsolutePath(), list);
                    } else if (!list.contains(file2)) {
                        list.add(file2);
                    }
                }
            }
        }
        return list;
    }

    public static List<File> getFilesSortedByModifyTimeDesc(String str) {
        List<File> files = getFiles(str, new ArrayList());
        if (files != null && files.size() > 0) {
            Collections.sort(files, new Comparator<File>() { // from class: com.qq.e.comm.util.FileUtil.1
                @Override // java.util.Comparator
                public final int compare(File file, File file2) {
                    if (file.lastModified() < file2.lastModified()) {
                        return 1;
                    }
                    return file.lastModified() == file2.lastModified() ? 0 : -1;
                }
            });
        }
        return files;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:46), block:B:18:0x002d */
    public static <T extends Serializable> T getObjFromFile(String str) {
        ObjectInputStream objectInputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(str));
            } catch (FileNotFoundException e16) {
                e = e16;
                objectInputStream = null;
            } catch (IOException e17) {
                e = e17;
                objectInputStream = null;
            } catch (ClassNotFoundException e18) {
                e = e18;
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                tryClose(inputStream2);
                throw th;
            }
            try {
                T t16 = (T) objectInputStream.readObject();
                tryClose(objectInputStream);
                return t16;
            } catch (FileNotFoundException e19) {
                e = e19;
                e.printStackTrace();
                tryClose(objectInputStream);
                return null;
            } catch (IOException e26) {
                e = e26;
                e.printStackTrace();
                tryClose(objectInputStream);
                return null;
            } catch (ClassNotFoundException e27) {
                e = e27;
                e.printStackTrace();
                tryClose(objectInputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            tryClose(inputStream2);
            throw th;
        }
    }

    public static File getRewardVideoDownLoadDir() {
        File downloadDir = getDownloadDir();
        if (downloadDir == null) {
            return null;
        }
        File file = new File(downloadDir, "rewardVideo");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String getRootDir() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext != null) {
            return appContext.getDir(Constants.TangramFiles.TANGRAM_FILES_DIR, 0).getAbsolutePath();
        }
        return null;
    }

    public static String getTempFileName(String str) {
        return Md5Util.encode(str) + FileDataSink.TEMP_FILE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileInputStream] */
    public static String read(File file) {
        String str = null;
        str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream = null;
        str = null;
        str = null;
        if (file != null) {
            ?? exists = file.exists();
            try {
                try {
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = exists;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (exists != 0) {
                try {
                    exists = new FileInputStream(file);
                } catch (FileNotFoundException e17) {
                    e = e17;
                    exists = 0;
                } catch (IOException e18) {
                    e = e18;
                    exists = 0;
                } catch (Throwable th6) {
                    th = th6;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[exists.available()];
                    exists.read(bArr);
                    String str2 = new String(bArr, "UTF-8");
                    try {
                        exists.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    str = str2;
                } catch (FileNotFoundException e27) {
                    e = e27;
                    e.printStackTrace();
                    if (exists != 0) {
                        exists.close();
                        exists = exists;
                    }
                    return str;
                } catch (IOException e28) {
                    e = e28;
                    e.printStackTrace();
                    if (exists != 0) {
                        exists.close();
                        exists = exists;
                    }
                    return str;
                }
            }
        }
        return str;
    }

    public static String readStringFromFile(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            String str = (String) new ObjectInputStream(fileInputStream).readObject();
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
            try {
                GDTLogger.e("readStringFromFile", th);
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return null;
                }
            } catch (Throwable th7) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                throw th7;
            }
        }
    }

    public static boolean renameTo(File file, File file2) {
        if (file != null && file2 != null && file.exists()) {
            if (!file.renameTo(file2)) {
                return copyTo(null, file2);
            }
            return true;
        }
        return false;
    }

    public static void saveObjectToCache(Serializable serializable, String str) {
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                File file = new File(new File(str).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(str));
                try {
                    objectOutputStream2.writeObject(serializable);
                    tryClose(objectOutputStream2);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                } catch (IOException e17) {
                    e = e17;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream = objectOutputStream2;
                    th.printStackTrace();
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            } catch (Throwable th6) {
                th = th6;
            }
        } finally {
            tryClose((OutputStream) null);
        }
    }

    public static void tryClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean tryWriteLock(FileOutputStream fileOutputStream) {
        try {
            return fileOutputStream.getChannel().tryLock().isValid();
        } catch (Exception e16) {
            GDTLogger.d("write lock, " + e16.toString());
            return false;
        }
    }

    public static void write(File file, String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str.getBytes("UTF-8"));
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                    } catch (IOException e19) {
                        e = e19;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e28) {
                    e = e28;
                } catch (IOException e29) {
                    e = e29;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public static boolean writeFile(Response response, File file) {
        FileOutputStream fileOutputStream;
        InputStream streamContent;
        InputStream inputStream = null;
        try {
            streamContent = response.getStreamContent();
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = streamContent.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    tryClose(streamContent);
                    tryClose(fileOutputStream);
                    tryClose(streamContent);
                    tryClose(fileOutputStream);
                    return true;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = streamContent;
            try {
                GDTLogger.e("Download File has exception! ", th);
                return false;
            } finally {
                tryClose(inputStream);
                tryClose(fileOutputStream);
            }
        }
    }

    public static long getDirSize(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (ArrayUtilStub.isNullOrEmpty(listFiles)) {
                return 0L;
            }
            for (File file2 : listFiles) {
                if (file2 != null) {
                    j3 += file2.isDirectory() ? getDirSize(file2) : file2.length();
                }
            }
        }
        return j3;
    }

    public static void tryClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
