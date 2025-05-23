package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ZipUtil {
    private static final String TAG = "ZipUtil";

    public static long getUncompressedFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(str).entries();
            long j3 = 0;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    j3 += nextElement.getSize();
                }
            }
            return j3;
        } catch (Exception e16) {
            QMLog.e(TAG, "fail filedName: " + str, e16);
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x013d, code lost:
    
        com.tencent.qqmini.sdk.launcher.log.QMLog.d("upZipFile", "" + r11.getCrc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0156, code lost:
    
        r15.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[Catch: IOException -> 0x01a4, FileNotFoundException -> 0x01a8, Exception -> 0x01ac, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x01ac, blocks: (B:14:0x0070, B:16:0x0072, B:17:0x007d, B:19:0x0084, B:22:0x0098, B:24:0x00b0, B:26:0x00bf, B:68:0x0156, B:77:0x015b, B:73:0x0160, B:52:0x0169, B:60:0x016e, B:56:0x0173, B:101:0x0193, B:97:0x0198, B:89:0x019d, B:90:0x01a3), top: B:13:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int unZipFolder(String str, String str2) {
        QZipFile qZipFile;
        String str3;
        String str4;
        int i3;
        CheckedInputStream checkedInputStream;
        InputStream inputStream;
        RecycleableBufferedOutputStream recycleableBufferedOutputStream;
        CheckedInputStream checkedInputStream2;
        RecycleableBufferedOutputStream obtain;
        StringBuilder sb5;
        String str5 = str;
        QMLog.e(TAG, "zipFilePath: " + str5 + ", folderPath: " + str2);
        if (TextUtils.isEmpty(str2)) {
            QMLog.e("upZipFile", "new file:" + str.toString() + ",target is null ");
            return 9;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            qZipFile = new QZipFile(new File(str5));
            try {
                try {
                    byte[] bArr = new byte[8192];
                    try {
                        StringBuilder sb6 = new StringBuilder(512);
                        Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                        while (true) {
                            i3 = 0;
                            if (entries.hasMoreElements()) {
                                ZipEntry nextElement = entries.nextElement();
                                String name = nextElement.getName();
                                if (!name.contains("..")) {
                                    sb6.delete(0, sb6.length());
                                    sb6.append(str2);
                                    sb6.append(File.separator);
                                    sb6.append(name);
                                    if (nextElement.isDirectory()) {
                                        File file2 = new File(sb6.toString());
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                        sb5 = sb6;
                                    } else {
                                        try {
                                            inputStream = qZipFile.getInputStream(nextElement);
                                            try {
                                                checkedInputStream2 = new CheckedInputStream(inputStream, new CRC32());
                                            } catch (Throwable th5) {
                                                th = th5;
                                                checkedInputStream = null;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            checkedInputStream = null;
                                            inputStream = null;
                                        }
                                        try {
                                            File file3 = new File(new String(sb6.toString().getBytes("8859_1"), "GB2312"));
                                            if (!file3.exists()) {
                                                File parentFile = file3.getParentFile();
                                                if (!parentFile.exists()) {
                                                    parentFile.mkdirs();
                                                }
                                            }
                                            obtain = RecycleableBufferedOutputStream.obtain(new BufferedOutputStream(new FileOutputStream(file3)));
                                        } catch (Throwable th7) {
                                            th = th7;
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
                                                StringBuilder sb7 = sb6;
                                                int read = checkedInputStream2.read(bArr, 0, 8192);
                                                obtain.write(bArr, 0, read);
                                                size -= read;
                                                sb6 = sb7;
                                            }
                                            sb5 = sb6;
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
                                            if (obtain != null) {
                                                try {
                                                    obtain.flush();
                                                    obtain.close();
                                                } catch (IOException unused3) {
                                                }
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            recycleableBufferedOutputStream = obtain;
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
                                    }
                                    str5 = str;
                                    sb6 = sb5;
                                }
                            }
                        }
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        str4 = str;
                        QMLog.e(TAG, "fail filedName: " + str4 + " folder: " + str2, e);
                        e.printStackTrace();
                        i3 = 5;
                        qZipFile.close();
                        return i3;
                    } catch (IOException e17) {
                        e = e17;
                        str3 = str;
                        QMLog.e(TAG, "fail filedName: " + str3 + " folder: " + str2, e);
                        e.printStackTrace();
                        i3 = 6;
                        qZipFile.close();
                        return i3;
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                    str4 = str5;
                } catch (IOException e19) {
                    e = e19;
                    str3 = str5;
                }
            } catch (Exception e26) {
                QMLog.e(TAG, "fail filedName: " + str + " folder: " + str2, e26);
                e26.printStackTrace();
                i3 = 7;
            }
            try {
                qZipFile.close();
                return i3;
            } catch (IOException e27) {
                e27.printStackTrace();
                return 8;
            }
        } catch (ZipException unused7) {
            QMLog.d("upZipFile", "ZipException");
            return 1;
        } catch (IOException unused8) {
            QMLog.d("upZipFile", "IOException");
            return 2;
        } catch (Exception unused9) {
            QMLog.d("upZipFile", "Exception");
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
        if (obtain != null) {
            try {
                obtain.flush();
                obtain.close();
            } catch (IOException unused11) {
            }
        }
        i3 = 4;
        qZipFile.close();
        return i3;
        if (obtain != null) {
        }
        i3 = 4;
        qZipFile.close();
        return i3;
    }

    public static boolean unzipFileTo(String str, String str2, String str3) {
        boolean z16;
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (nextEntry.getName().equals(str2)) {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        zipInputStream.closeEntry();
                        z16 = true;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            zipInputStream.close();
            return z16;
        } catch (IOException e16) {
            QMLog.e(TAG, "fail zipPath: " + str + " destFile: " + str3, e16);
            e16.printStackTrace();
            return false;
        }
    }
}
