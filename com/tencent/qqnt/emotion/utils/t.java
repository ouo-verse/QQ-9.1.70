package com.tencent.qqnt.emotion.utils;

import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes24.dex */
public class t {
    static IPatchRedirector $redirector_;

    public static void a(File file, String str) throws IOException {
        QZipFile qZipFile = new QZipFile(file);
        try {
            try {
                b(qZipFile, str);
            } catch (IOException e16) {
                throw e16;
            }
        } finally {
            qZipFile.close();
        }
    }

    private static void b(QZipFile qZipFile, String str) throws IOException {
        p pVar;
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
                    File file = new File(str + nextElement.getName());
                    file.getParentFile().mkdirs();
                    InputStream inputStream = null;
                    try {
                        pVar = p.f(new FileOutputStream(file));
                    } catch (Throwable th5) {
                        th = th5;
                        pVar = null;
                    }
                    try {
                        inputStream = qZipFile.getInputStream(nextElement);
                        while (true) {
                            int read = inputStream.read(bArr, 0, 8192);
                            if (read != -1) {
                                pVar.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            }
                        }
                        inputStream.close();
                        if (pVar != null) {
                            try {
                                pVar.flush();
                            } catch (IOException unused2) {
                            }
                            try {
                                pVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (pVar != null) {
                            try {
                                pVar.flush();
                            } catch (IOException unused5) {
                            }
                            try {
                                pVar.close();
                                throw th;
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
            }
        }
    }
}
