package com.tencent.qphone.base.util.log.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    public static boolean writeFile(String str, String str2, boolean z16) {
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file, z16);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.flush();
                        fileOutputStream = fileOutputStream2;
                    } catch (IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return false;
                        }
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return true;
            } catch (IOException unused3) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException unused4) {
            return false;
        }
    }

    public static void zipFiles(ArrayList<QLog.LogFile> arrayList, String str) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str)));
            ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
            try {
                try {
                    Iterator<QLog.LogFile> it = arrayList.iterator();
                    boolean z16 = false;
                    while (it.hasNext()) {
                        QLog.LogFile next = it.next();
                        if (next.exists()) {
                            zipOutputStream.putNextEntry(new ZipEntry(next.getName() + next.stuffix));
                            zipOutputStream.setLevel(9);
                            long length = next.length();
                            FileInputStream fileInputStream = new FileInputStream(next);
                            int i3 = 20480;
                            try {
                                byte[] bArr = new byte[20480];
                                long j3 = 0;
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, i3);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                    j3 += read;
                                    if (j3 >= length) {
                                        z16 = true;
                                        break;
                                    } else {
                                        z16 = true;
                                        i3 = 20480;
                                    }
                                }
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                            } catch (Throwable th5) {
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                throw th5;
                            }
                        }
                    }
                    if (z16) {
                        zipOutputStream.close();
                    }
                    File file = new File(QLog.getLogPath(), "com.tencent.mobileqq_NETFLOW.log");
                    if (file.exists()) {
                        boolean delete = file.delete();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "netflow file has been deleted: " + delete);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " zip stream close.");
                    }
                } catch (IOException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, " zip file error " + e16, e16);
                    }
                    bufferedOutputStream.close();
                    if (QLog.isColorLevel()) {
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "zip file finish");
                    }
                }
            } finally {
                bufferedOutputStream.close();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " file out stream close.");
                }
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }
}
