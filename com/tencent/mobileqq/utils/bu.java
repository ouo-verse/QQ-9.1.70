package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bu {

    /* renamed from: a, reason: collision with root package name */
    private static long f307506a = 157286400;

    public static void a() {
        File file = new File(AppConstants.SDCARD_MUSIC);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
    }

    public static void b() {
        File[] listFiles;
        File file = new File(AppConstants.SDCARD_MUSIC);
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -15);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        long j3 = 0;
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                try {
                    if (file2.lastModified() < timeInMillis) {
                        d(file2);
                    } else {
                        treeMap.put(Long.valueOf(file2.lastModified()), file2);
                        j3 += file2.length();
                    }
                } catch (Exception unused) {
                }
            }
        }
        while (j3 > f307506a) {
            Iterator it = treeMap.entrySet().iterator();
            while (it.hasNext()) {
                File file3 = (File) ((Map.Entry) it.next()).getValue();
                long length = file3.length();
                if (d(file3)) {
                    j3 -= length;
                }
            }
        }
    }

    public static void c(String str) {
        File file = new File(AppConstants.SDCARD_MUSIC + str + PluginUtils.CONFIG_FILE_EXTEND_NAME);
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "delCfgFile");
        }
        if (file.exists()) {
            file.delete();
        }
    }

    private static boolean d(File file) {
        if (!file.getName().endsWith(PluginUtils.CONFIG_FILE_EXTEND_NAME)) {
            new File(file.getAbsolutePath() + PluginUtils.CONFIG_FILE_EXTEND_NAME).delete();
        }
        return file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(String str, int[] iArr) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        IOException e16;
        FileNotFoundException e17;
        File file = new File(AppConstants.SDCARD_MUSIC + str + PluginUtils.CONFIG_FILE_EXTEND_NAME);
        if (!file.exists()) {
            return true;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e18) {
                e = e18;
                fileInputStream = null;
                byteArrayOutputStream2 = null;
            } catch (IOException e19) {
                e = e19;
                fileInputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } catch (FileNotFoundException e26) {
                        e17 = e26;
                        QLog.e("QQPlayerService", 1, "isCacheComplete,FileNotFoundException:" + e17.getMessage(), e17);
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e27) {
                                QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e27.getMessage(), e27);
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e28) {
                                QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e28.getMessage(), e28);
                            }
                        }
                        return false;
                    } catch (IOException e29) {
                        e16 = e29;
                        QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e16.getMessage(), e16);
                        file.delete();
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e36) {
                                QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e36.getMessage(), e36);
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e37) {
                                QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e37.getMessage(), e37);
                            }
                        }
                        return false;
                    }
                }
                String[] split = byteArrayOutputStream2.toString().split(":");
                if (split != null && split.length >= 4) {
                    int parseInt = Integer.parseInt(split[1]);
                    int parseInt2 = Integer.parseInt(split[3]);
                    if (parseInt == parseInt2) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e38) {
                            QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e38.getMessage(), e38);
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e39) {
                            QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e39.getMessage(), e39);
                        }
                        return true;
                    }
                    iArr[0] = parseInt;
                    iArr[1] = parseInt2;
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e46) {
                        QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e46.getMessage(), e46);
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e47) {
                        QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e47.getMessage(), e47);
                    }
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "isCacheComplete,getCacheInfo:read error,string.length < 4");
                }
                iArr[0] = 0;
                iArr[1] = 0;
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e48) {
                    QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e48.getMessage(), e48);
                }
                try {
                    fileInputStream.close();
                } catch (IOException e49) {
                    QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e49.getMessage(), e49);
                }
                return false;
            } catch (FileNotFoundException e56) {
                e = e56;
                byteArrayOutputStream2 = null;
                e17 = e;
                QLog.e("QQPlayerService", 1, "isCacheComplete,FileNotFoundException:" + e17.getMessage(), e17);
                if (byteArrayOutputStream2 != null) {
                }
                if (fileInputStream != null) {
                }
                return false;
            } catch (IOException e57) {
                e = e57;
                byteArrayOutputStream2 = null;
                e16 = e;
                QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e16.getMessage(), e16);
                file.delete();
                if (byteArrayOutputStream2 != null) {
                }
                if (fileInputStream != null) {
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream = null;
                th = th;
                if (byteArrayOutputStream != null) {
                }
                if (fileInputStream == null) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e58) {
                    QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e58.getMessage(), e58);
                }
            }
            if (fileInputStream == null) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e59) {
                    QLog.e("QQPlayerService", 1, "isCacheComplete,IOException:" + e59.getMessage(), e59);
                    throw th;
                }
            }
            throw th;
        }
    }

    public static void f(String str, int i3, int i16) {
        StringBuilder sb5;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                String str2 = AppConstants.SDCARD_MUSIC;
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(str2 + str + PluginUtils.CONFIG_FILE_EXTEND_NAME);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2, false);
                try {
                    String str3 = "downloadOffset:" + i3 + ":fileSize:" + i16;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "saveCacheInfo,result:" + str3);
                    }
                    fileOutputStream2.write(str3.getBytes());
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        sb5 = new StringBuilder();
                        sb5.append("saveCacheInfo,IOException:");
                        sb5.append(e.getMessage());
                        QLog.e("QQPlayerService", 1, sb5.toString(), e);
                    }
                } catch (FileNotFoundException e17) {
                    fileOutputStream = fileOutputStream2;
                    e = e17;
                    QLog.e("QQPlayerService", 1, "saveCacheInfo,FileNotFoundException:" + e.getMessage(), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e18) {
                            e = e18;
                            sb5 = new StringBuilder();
                            sb5.append("saveCacheInfo,IOException:");
                            sb5.append(e.getMessage());
                            QLog.e("QQPlayerService", 1, sb5.toString(), e);
                        }
                    }
                } catch (IOException e19) {
                    fileOutputStream = fileOutputStream2;
                    e = e19;
                    QLog.e("QQPlayerService", 1, "saveCacheInfo,IOException:" + e.getMessage(), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e26) {
                            e = e26;
                            sb5 = new StringBuilder();
                            sb5.append("saveCacheInfo,IOException:");
                            sb5.append(e.getMessage());
                            QLog.e("QQPlayerService", 1, sb5.toString(), e);
                        }
                    }
                } catch (Throwable th5) {
                    fileOutputStream = fileOutputStream2;
                    th = th5;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e27) {
                            QLog.e("QQPlayerService", 1, "saveCacheInfo,IOException:" + e27.getMessage(), e27);
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

    public static void g(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    try {
                        byte readByte = randomAccessFile2.readByte();
                        randomAccessFile2.seek(0L);
                        randomAccessFile2.write(readByte);
                        randomAccessFile2.close();
                    } catch (IOException e16) {
                        e = e16;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (IOException unused2) {
        }
    }
}
