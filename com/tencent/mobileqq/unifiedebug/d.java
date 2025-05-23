package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.sticker.Sticker;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f305802a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f305802a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    }

    public static void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    private static JSONObject b(File file) throws JSONException {
        int i3;
        int i16;
        int i17 = 0;
        if (file.isDirectory()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        int i18 = i3 | 0;
        if (file.canWrite()) {
            i16 = 4;
        } else {
            i16 = 0;
        }
        int i19 = i18 | i16;
        if (file.canRead()) {
            i17 = 2;
        }
        int i26 = i19 | i17 | (file.canExecute() ? 1 : 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, Integer.toOctalString(i26));
        jSONObject.put("lastModified", f305802a.format(new Date(file.lastModified())));
        return jSONObject;
    }

    public static String[] c(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return file.list();
        }
        return null;
    }

    private static void d(ZipOutputStream zipOutputStream, File file, int i3) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(i3)));
                    zipOutputStream.setLevel(9);
                    long length = file.length();
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[20480];
                        long j3 = 0;
                        do {
                            int read = fileInputStream.read(bArr, 0, 20480);
                            if (read == -1) {
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("UnifiedFileUtil", 2, "read " + read + " from " + file.getName());
                            }
                            zipOutputStream.write(bArr, 0, read);
                            j3 += read;
                        } while (j3 < length);
                        fileInputStream.close();
                        zipOutputStream.closeEntry();
                        return;
                    } catch (Throwable th5) {
                        fileInputStream.close();
                        zipOutputStream.closeEntry();
                        throw th5;
                    }
                }
                zipOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(i3) + "/"));
                File[] listFiles = file.listFiles();
                JSONObject jSONObject = new JSONObject();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        d(zipOutputStream, file2, i3);
                        jSONObject.put(file2.getName(), b(file2));
                    }
                }
                jSONObject.put(".", b(file));
                String str = "properties.json";
                if (new File(file, "properties.json").exists()) {
                    str = "properties_" + System.currentTimeMillis() + Sticker.JSON_SUFFIX;
                }
                zipOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(i3) + "/" + str));
                zipOutputStream.write(jSONObject.toString(4).getBytes("utf-8"));
                zipOutputStream.closeEntry();
            }
        } catch (IOException e16) {
            QLog.e("UnifiedFileUtil", 1, "zipFile errror: " + e16.getMessage());
            for (StackTraceElement stackTraceElement : e16.getStackTrace()) {
                QLog.e("UnifiedFileUtil", 1, stackTraceElement.toString());
            }
        } catch (JSONException e17) {
            QLog.e("UnifiedFileUtil", 1, "zipFile: ", e17);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f9 A[Catch: IOException -> 0x00f5, TRY_LEAVE, TryCatch #2 {IOException -> 0x00f5, blocks: (B:72:0x00f1, B:61:0x00f9), top: B:71:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(File file, List<String> list, String str) {
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        if (file != null && list != null && !list.isEmpty()) {
            ZipOutputStream zipOutputStream2 = null;
            zipOutputStream2 = null;
            FileOutputStream fileOutputStream2 = null;
            int i3 = 0;
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    zipOutputStream = new ZipOutputStream(fileOutputStream);
                } catch (IOException e16) {
                    e = e16;
                    zipOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (zipOutputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        d(zipOutputStream, new File(file, it.next()), file.getPath().length() + 1);
                    }
                    try {
                        zipOutputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e17) {
                        QLog.e("UnifiedFileUtil", 1, "zipFiles errror: " + e17.getMessage());
                        StackTraceElement[] stackTrace = e17.getStackTrace();
                        while (i3 < stackTrace.length) {
                            QLog.e("UnifiedFileUtil", 1, stackTrace[i3].toString());
                            i3++;
                        }
                    }
                } catch (IOException e18) {
                    e = e18;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        QLog.e("UnifiedFileUtil", 1, "zipFiles errror: " + e.getMessage());
                        StackTraceElement[] stackTrace2 = e.getStackTrace();
                        for (int i16 = 0; i16 < stackTrace2.length; i16++) {
                            QLog.e("UnifiedFileUtil", 1, stackTrace2[i16].toString());
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e19) {
                                QLog.e("UnifiedFileUtil", 1, "zipFiles errror: " + e19.getMessage());
                                StackTraceElement[] stackTrace3 = e19.getStackTrace();
                                while (i3 < stackTrace3.length) {
                                    QLog.e("UnifiedFileUtil", 1, stackTrace3[i3].toString());
                                    i3++;
                                }
                                return;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = fileOutputStream2;
                        zipOutputStream2 = zipOutputStream;
                        if (zipOutputStream2 != null) {
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e26) {
                                QLog.e("UnifiedFileUtil", 1, "zipFiles errror: " + e26.getMessage());
                                StackTraceElement[] stackTrace4 = e26.getStackTrace();
                                while (i3 < stackTrace4.length) {
                                    QLog.e("UnifiedFileUtil", 1, stackTrace4[i3].toString());
                                    i3++;
                                }
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    zipOutputStream2 = zipOutputStream;
                    if (zipOutputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e27) {
                e = e27;
                zipOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b2, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d9, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00db, code lost:
    
        com.tencent.qphone.base.util.QLog.i("UnifiedFileUtil", 2, "zip file finish");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d2, code lost:
    
        com.tencent.qphone.base.util.QLog.d("UnifiedFileUtil", 2, " zip out stream close.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d0, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<String> list, String str) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (list == null) {
            return;
        }
        try {
            zipOutputStream2 = new ZipOutputStream(new FileOutputStream(new File(str)));
        } catch (IOException e16) {
            e = e16;
            zipOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            zipOutputStream = null;
        }
        try {
            for (String str2 : list) {
                File file = new File(str2);
                if (file.exists()) {
                    long length = file.length();
                    try {
                        fileInputStream2 = new FileInputStream(file);
                    } catch (IOException e17) {
                        e = e17;
                        fileInputStream2 = null;
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = null;
                    }
                    try {
                        try {
                            zipOutputStream2.putNextEntry(new ZipEntry(file.getName()));
                            zipOutputStream2.setLevel(9);
                            int i3 = 20480;
                            byte[] bArr = new byte[20480];
                            long j3 = 0;
                            while (true) {
                                int read = fileInputStream2.read(bArr, 0, i3);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream2.write(bArr, 0, read);
                                j3 += read;
                                if (j3 >= length) {
                                    break;
                                } else {
                                    i3 = 20480;
                                }
                            }
                            fileInputStream2.close();
                            zipOutputStream2.flush();
                        } catch (Throwable th7) {
                            th = th7;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream2.closeEntry();
                            throw th;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        QLog.e("UnifiedFileUtil", 1, "zip file error: " + str2, e);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        zipOutputStream2.flush();
                        zipOutputStream2.closeEntry();
                    }
                    zipOutputStream2.closeEntry();
                }
            }
            try {
                zipOutputStream2.close();
            } catch (IOException unused) {
            }
        } catch (IOException e19) {
            e = e19;
            zipOutputStream = zipOutputStream2;
            try {
                QLog.e("UnifiedFileUtil", 1, "zip files error", e);
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (!QLog.isColorLevel()) {
                    QLog.d("UnifiedFileUtil", 2, " zip out stream close.");
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            zipOutputStream = zipOutputStream2;
            if (zipOutputStream != null) {
            }
            if (!QLog.isColorLevel()) {
            }
        }
    }
}
