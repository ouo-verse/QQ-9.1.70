package com.tencent.mobileqq.wink.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class r {
    public static String a(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb5.append(readLine);
                sb5.append("\n");
            } else {
                bufferedReader.close();
                return sb5.toString();
            }
        }
    }

    public static void b(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    b(context, str + "/" + str3, str2 + "/" + str3);
                }
                return;
            }
            InputStream inputStream = null;
            try {
                InputStream open = context.getAssets().open(str);
                try {
                    fileOutputStream = new FileOutputStream(new File(str2));
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    open.close();
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = open;
                    try {
                        QLog.e("QQWinkUtil", 1, "copyFilesFromAssets t:" + th.getMessage());
                        th.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return;
                    } catch (Throwable th7) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            fileOutputStream.close();
        } catch (Exception e16) {
            QLog.e("QQWinkUtil", 1, "copyFilesFromAssets e:" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.getParentFile() != null) {
                String absolutePath = file.getParentFile().getAbsolutePath();
                if (!TextUtils.isEmpty(absolutePath)) {
                    return absolutePath + File.separator;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String d(String str) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        String a16 = a(fileInputStream);
        fileInputStream.close();
        return a16;
    }

    public static String e() {
        StringWriter stringWriter = new StringWriter();
        new Throwable("").printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean f(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:peak".equals(it.next().processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("QQWinkUtil", 2, "get process info fail.");
                return false;
            }
            return false;
        }
    }
}
