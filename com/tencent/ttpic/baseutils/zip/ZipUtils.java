package com.tencent.ttpic.baseutils.zip;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ZipUtils {
    private static final String TAG = "ZipUtils";

    private static void doZip(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) throws IOException {
        String str2;
        File[] listFiles;
        if (zipOutputStream != null && file != null) {
            if (file.exists()) {
                if (TextUtils.isEmpty(str)) {
                    str2 = file.getName();
                } else {
                    str2 = str + File.separator + file.getName();
                }
                if (file.isFile()) {
                    BufferedInputStream bufferedInputStream = null;
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str2));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                                if (-1 != read) {
                                    zipOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        bufferedInputStream2.close();
                                        return;
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                        return;
                                    }
                                }
                            }
                        } catch (IOException e17) {
                            e = e17;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e19) {
                        e = e19;
                    }
                } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        doZip(zipOutputStream, file2, str2, bArr);
                    }
                }
            } else {
                throw new FileNotFoundException("Target File is missing");
            }
        } else {
            throw new IOException("I/O Object got NullPointerException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0140 A[Catch: IOException -> 0x013c, all -> 0x0154, TRY_LEAVE, TryCatch #11 {all -> 0x0154, blocks: (B:23:0x0039, B:25:0x003f, B:28:0x0064, B:93:0x006a, B:95:0x009e, B:96:0x00a1, B:99:0x00aa, B:31:0x00af, B:44:0x00fa, B:50:0x0102, B:81:0x0138, B:73:0x0140, B:78:0x0147, B:77:0x0144, B:63:0x0122, B:59:0x012a, B:67:0x012e), top: B:22:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String unZip(String str, String str2) {
        FileInputStream fileInputStream;
        String str3;
        BufferedOutputStream bufferedOutputStream;
        IOException e16;
        synchronized (ZipUtils.class) {
            ZipInputStream zipInputStream = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(fileInputStream));
                        str3 = null;
                        FileOutputStream fileOutputStream = null;
                        BufferedOutputStream bufferedOutputStream2 = null;
                        while (true) {
                            try {
                                try {
                                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                                    if (nextEntry != null) {
                                        String str4 = TAG;
                                        LogUtils.d(str4, "unZip entry = " + nextEntry);
                                        String name = nextEntry.getName();
                                        if (!name.contains("../")) {
                                            if (nextEntry.isDirectory()) {
                                                String str5 = str2 + File.separator + name;
                                                LogUtils.d(str4, "unZip entry is folder, path = " + str5);
                                                File file3 = new File(str5);
                                                if (!file3.exists()) {
                                                    file3.mkdirs();
                                                }
                                                FileUtils.deleteFiles(str5, null);
                                                if (TextUtils.isEmpty(str3)) {
                                                    str3 = file3.getPath();
                                                }
                                            } else {
                                                byte[] bArr = new byte[4096];
                                                String str6 = str2 + File.separator + name;
                                                LogUtils.d(str4, "unZip entry is file, path = " + str6);
                                                try {
                                                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str6));
                                                    try {
                                                        BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream2, 4096);
                                                        while (true) {
                                                            try {
                                                                int read = zipInputStream2.read(bArr);
                                                                if (read == -1) {
                                                                    break;
                                                                }
                                                                bufferedOutputStream3.write(bArr, 0, read);
                                                            } catch (IOException e17) {
                                                                e16 = e17;
                                                                bufferedOutputStream = bufferedOutputStream3;
                                                                fileOutputStream = fileOutputStream2;
                                                                try {
                                                                    LogUtils.e(e16);
                                                                    if (bufferedOutputStream != null) {
                                                                        try {
                                                                            bufferedOutputStream.close();
                                                                        } catch (IOException e18) {
                                                                            LogUtils.e(e18);
                                                                            bufferedOutputStream2 = bufferedOutputStream;
                                                                        }
                                                                    }
                                                                    if (fileOutputStream != null) {
                                                                        fileOutputStream.close();
                                                                    }
                                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                                    if (bufferedOutputStream2 != null) {
                                                                        try {
                                                                            bufferedOutputStream2.close();
                                                                        } catch (IOException e19) {
                                                                            LogUtils.e(e19);
                                                                            throw th;
                                                                        }
                                                                    }
                                                                    if (fileOutputStream != null) {
                                                                        fileOutputStream.close();
                                                                    }
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                bufferedOutputStream2 = bufferedOutputStream3;
                                                                fileOutputStream = fileOutputStream2;
                                                                if (bufferedOutputStream2 != null) {
                                                                }
                                                                if (fileOutputStream != null) {
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        bufferedOutputStream3.flush();
                                                        try {
                                                            bufferedOutputStream3.close();
                                                            fileOutputStream2.close();
                                                        } catch (IOException e26) {
                                                            LogUtils.e(e26);
                                                        }
                                                        bufferedOutputStream2 = bufferedOutputStream3;
                                                        fileOutputStream = fileOutputStream2;
                                                    } catch (IOException e27) {
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        e16 = e27;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                    }
                                                } catch (IOException e28) {
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    e16 = e28;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                }
                                            }
                                        }
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e29) {
                                            e = e29;
                                            LogUtils.e(e);
                                            return str3;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    zipInputStream = zipInputStream2;
                                    if (zipInputStream != null) {
                                        try {
                                            zipInputStream.close();
                                        } catch (IOException e36) {
                                            LogUtils.e(e36);
                                            throw th;
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (IOException e37) {
                                e = e37;
                                zipInputStream = zipInputStream2;
                                LogUtils.e(e);
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (IOException e38) {
                                        e = e38;
                                        LogUtils.e(e);
                                        return str3;
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str3;
                            }
                        }
                        zipInputStream2.close();
                        fileInputStream.close();
                    } catch (Throwable th10) {
                        th = th10;
                    }
                } catch (IOException e39) {
                    e = e39;
                    str3 = null;
                }
            } catch (IOException e46) {
                e = e46;
                fileInputStream = null;
                str3 = null;
            } catch (Throwable th11) {
                th = th11;
                fileInputStream = null;
            }
            return str3;
        }
    }

    public static boolean zip(File file, File file2) {
        return zip(new File[]{file}, file2);
    }

    public static boolean zip(File[] fileArr, File file) {
        if (fileArr == null || fileArr.length < 1 || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            byte[] bArr = new byte[4096];
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file, false)));
            try {
                for (File file2 : fileArr) {
                    doZip(zipOutputStream2, file2, null, bArr);
                }
                zipOutputStream2.flush();
                zipOutputStream2.closeEntry();
                try {
                    zipOutputStream2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return true;
            } catch (IOException unused) {
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream == null) {
                    return false;
                }
                try {
                    zipOutputStream.close();
                    return false;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static byte[] zip(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            ZipEntry zipEntry = new ZipEntry("placeHolder.dat");
            zipEntry.setSize(bArr.length);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(bArr);
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] unZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
            while (zipInputStream.getNextEntry() != null) {
                byte[] bArr3 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = zipInputStream.read(bArr3, 0, 1024);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            zipInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return bArr2;
    }
}
