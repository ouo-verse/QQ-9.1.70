package com.qq.e.comm.net;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ZipCompress {
    /* JADX WARN: Removed duplicated region for block: B:30:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] compressByGzip(byte[] bArr) {
        Throwable th5;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = null;
            bArr2 = null;
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Exception e17) {
                    e = e17;
                    gZIPOutputStream = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (gZIPOutputStream2 != null) {
                    }
                    byteArrayOutputStream.close();
                    throw th5;
                }
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bArr2;
                }
                return bArr2;
            } catch (Throwable th7) {
                th5 = th7;
                gZIPOutputStream2 = gZIPOutputStream;
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        throw th5;
                    }
                }
                byteArrayOutputStream.close();
                throw th5;
            }
        }
        return bArr;
    }

    public static String compressByGzipAndBase64(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encodeToString(compressByGzip(str.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0052: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:83), block:B:25:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] decompressByGzip(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        if (bArr != null && bArr.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            byte[] bArr3 = null;
            bArr3 = null;
            GZIPInputStream gZIPInputStream3 = null;
            try {
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            return bArr3;
                        }
                    }
                    byteArrayOutputStream.flush();
                    bArr3 = byteArrayOutputStream.toByteArray();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e18) {
                    e = e18;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (gZIPInputStream3 != null) {
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
                return bArr3;
            } catch (Throwable th6) {
                th = th6;
                gZIPInputStream3 = gZIPInputStream2;
                if (gZIPInputStream3 != null) {
                    try {
                        gZIPInputStream3.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        }
        return bArr;
    }

    public static void unZipFolder(String str, String str2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("../")) {
                    GDTLogger.e("unsecurity zipfile!");
                    com.qq.e.comm.a.a();
                } else if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    String str3 = File.separator;
                    sb5.append(str3);
                    sb5.append(name);
                    GDTLogger.d(sb5.toString());
                    File file = new File(str2 + str3 + name);
                    if (!file.exists()) {
                        GDTLogger.d("Create the file:" + str2 + str3 + name);
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }

    public static ArrayList<File> upZipSelectedFile(File file, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        ZipFile zipFile = null;
        InputStream inputStream2 = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3 = null;
        if (file == null) {
            return null;
        }
        ArrayList<File> arrayList = new ArrayList<>();
        GDTLogger.d("begin unzip: target dir : " + str + "; key word: " + str2);
        StringBuilder sb5 = new StringBuilder("begin unzip: zipfile : ");
        sb5.append(file.getAbsolutePath());
        GDTLogger.d(sb5.toString());
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                GDTLogger.d("zipFile size : " + file.length());
                ZipFile zipFile4 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile4.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        GDTLogger.d("unzip entry name : " + nextElement.getName());
                        if (nextElement.getName().contains(str2) && !nextElement.isDirectory()) {
                            if (nextElement.getName().contains("../")) {
                                GDTLogger.e("unsecurity zipfile!");
                                com.qq.e.comm.a.a();
                            } else {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(str);
                                String str3 = File.separator;
                                sb6.append(str3);
                                sb6.append(nextElement.getName());
                                String str4 = str + str3 + new File(sb6.toString()).getName();
                                GDTLogger.d("unzip " + nextElement.getName() + " write to " + str4);
                                File file3 = new File(str4);
                                if (!file3.exists()) {
                                    file3.createNewFile();
                                }
                                try {
                                    inputStream = zipFile4.getInputStream(nextElement);
                                    try {
                                        fileOutputStream = new FileOutputStream(file3);
                                    } catch (IOException e17) {
                                        e = e17;
                                        fileOutputStream = null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileOutputStream = null;
                                    }
                                } catch (IOException e18) {
                                    e = e18;
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (Throwable th6) {
                                    th = th6;
                                    fileOutputStream = null;
                                }
                                try {
                                    try {
                                        byte[] bArr = new byte[(int) nextElement.getSize()];
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        inputStream.close();
                                    } catch (Throwable th7) {
                                        th = th7;
                                        inputStream2 = inputStream;
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (IOException e19) {
                                    e = e19;
                                    e.printStackTrace();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    arrayList.add(file3);
                                }
                                fileOutputStream.close();
                                arrayList.add(file3);
                            }
                        }
                    }
                    zipFile4.close();
                } catch (ZipException e26) {
                    e = e26;
                    zipFile3 = zipFile4;
                    e.printStackTrace();
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                    return arrayList;
                } catch (IOException e27) {
                    e = e27;
                    zipFile = zipFile4;
                    e.printStackTrace();
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return arrayList;
                } catch (Throwable th8) {
                    th = th8;
                    zipFile2 = zipFile4;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (ZipException e29) {
                e = e29;
            } catch (IOException e36) {
                e = e36;
            }
            return arrayList;
        } catch (Throwable th9) {
            th = th9;
        }
    }
}
