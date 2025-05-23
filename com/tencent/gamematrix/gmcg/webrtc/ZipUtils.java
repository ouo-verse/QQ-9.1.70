package com.tencent.gamematrix.gmcg.webrtc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ZipUtils {
    private static final int BUFFER_SIZE = 2048;

    public static void toZip(List<File> list, OutputStream outputStream) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
                try {
                    for (File file : list) {
                        byte[] bArr = new byte[2048];
                        zipOutputStream2.putNextEntry(new ZipEntry(file.getName()));
                        FileInputStream fileInputStream = new FileInputStream(file);
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read != -1) {
                                zipOutputStream2.write(bArr, 0, read);
                            }
                        }
                        zipOutputStream2.closeEntry();
                        fileInputStream.close();
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    System.out.println("compression completed, time consuming:" + (currentTimeMillis2 - currentTimeMillis) + " ms");
                    try {
                        zipOutputStream2.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } catch (Exception e17) {
                    e = e17;
                    throw new RuntimeException("zip error from ZipUtils", e);
                } catch (Throwable th5) {
                    th = th5;
                    zipOutputStream = zipOutputStream2;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void unZip(File file, String str) throws RuntimeException {
        long currentTimeMillis = System.currentTimeMillis();
        if (file.exists()) {
            ZipFile zipFile = null;
            try {
                try {
                    ZipFile zipFile2 = new ZipFile(file);
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry nextElement = entries.nextElement();
                            System.out.println("unZip:" + nextElement.getName());
                            if (nextElement.isDirectory()) {
                                new File(str + "/" + nextElement.getName()).mkdirs();
                            } else {
                                File file2 = new File(str + "/" + nextElement.getName());
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                file2.createNewFile();
                                InputStream inputStream = zipFile2.getInputStream(nextElement);
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                }
                                fileOutputStream.close();
                                inputStream.close();
                            }
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        System.out.println("decompression completed, time-consuming:" + (currentTimeMillis2 - currentTimeMillis) + " ms");
                        try {
                            zipFile2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    } catch (Exception e17) {
                        e = e17;
                        throw new RuntimeException("unzip error from ZipUtils", e);
                    } catch (Throwable th5) {
                        th = th5;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            throw new RuntimeException(file.getPath() + "source file does not exist");
        }
    }
}
