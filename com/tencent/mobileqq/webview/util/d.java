package com.tencent.mobileqq.webview.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static boolean a(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            File file2 = listFiles[i3];
            if (file2 != null) {
                if (file2.isFile()) {
                    b(listFiles[i3].getAbsolutePath());
                } else {
                    a(listFiles[i3].getAbsolutePath());
                }
            }
        }
        file.delete();
        if (QLog.isColorLevel()) {
            QLog.d("Util", 2, "deleteDirectory dirPath:", str);
        }
        return true;
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                file.delete();
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static String c(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
