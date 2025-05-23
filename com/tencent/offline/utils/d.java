package com.tencent.offline.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
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
                    System.out.println(listFiles[i3].getAbsolutePath() + " delete suc");
                } else {
                    a(listFiles[i3].getAbsolutePath());
                }
            }
        }
        file.delete();
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
}
