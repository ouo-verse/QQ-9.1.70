package com.tencent.mobileqq.ar.arengine;

import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ai {
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (r6 == null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArCloudConfigInfo a(String str, String str2) {
        Throwable th5;
        BufferedReader bufferedReader;
        StringBuilder sb5 = new StringBuilder();
        File file = new File(str + ((String) str2));
        ArCloudConfigInfo arCloudConfigInfo = null;
        try {
            try {
                System.out.println(HardCodeUtil.qqStr(R.string.f171612jr4));
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                    }
                }
                bufferedReader.close();
            } catch (IOException e17) {
                e = e17;
                bufferedReader = null;
            } catch (Throwable th6) {
                str2 = 0;
                th5 = th6;
                if (str2 != 0) {
                }
                throw th5;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused) {
                String sb6 = sb5.toString();
                try {
                    QLog.i("ArConfig_Utils", 1, "processCloudMarkerRecogResult. jsonContent = " + sb6);
                    arCloudConfigInfo = c.a(sb6);
                } catch (Exception e18) {
                    QLog.i("ArConfig_Utils", 1, "processCloudMarkerRecogResult. parse json failed. error msg = " + e18.getMessage());
                }
                QLog.i("ArConfig_Utils", 1, "processCloudMarkerRecogResult. config = " + arCloudConfigInfo);
                return arCloudConfigInfo;
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (str2 != 0) {
                try {
                    str2.close();
                } catch (IOException unused2) {
                }
            }
            throw th5;
        }
    }

    public static boolean b(String str, String str2, String str3) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str2 + str3);
                if (!file.exists()) {
                    File file2 = new File(file.getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                        file.createNewFile();
                    }
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes());
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return true;
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public static void c(String str, String str2) throws IOException {
        QZipFile qZipFile;
        InputStream inputStream;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_Utils", 2, "uncompressZip: path=" + str);
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str2 + "/");
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            qZipFile = new QZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                byte[] bArr = new byte[8192];
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name != null && !name.contains("../")) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        String str3 = File.separator;
                        sb5.append(str3);
                        sb5.append(name);
                        String sb6 = sb5.toString();
                        if (nextElement.isDirectory()) {
                            File file2 = new File(sb6);
                            if (!file2.exists()) {
                                file2.mkdir();
                            }
                        } else {
                            int lastIndexOf = sb6.lastIndexOf(str3);
                            String substring = sb6.substring(0, lastIndexOf);
                            if (!sb6.substring(lastIndexOf + 1).startsWith(".")) {
                                File file3 = new File(substring);
                                if (!file3.exists()) {
                                    file3.mkdir();
                                }
                                File file4 = new File(sb6 + ".tmp");
                                File file5 = new File(sb6);
                                if (file4.exists()) {
                                    file4.delete();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                                try {
                                    inputStream = qZipFile.getInputStream(nextElement);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                fileOutputStream2.write(bArr, 0, read);
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e16) {
                                                    e16.printStackTrace();
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e17) {
                                                    e17.printStackTrace();
                                                }
                                            }
                                            if (qZipFile != null) {
                                                try {
                                                    qZipFile.close();
                                                    throw th;
                                                } catch (IOException e18) {
                                                    e18.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    fileOutputStream2.flush();
                                    fileOutputStream2.close();
                                    inputStream.close();
                                    if (!FileUtils.renameFile(file4, file5)) {
                                        FileUtils.copyFile(file4, file5);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    inputStream = null;
                                }
                            }
                        }
                    }
                }
                try {
                    qZipFile.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            qZipFile = null;
            inputStream = null;
        }
    }
}
