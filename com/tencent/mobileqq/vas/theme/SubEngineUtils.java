package com.tencent.mobileqq.vas.theme;

import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SubEngineUtils {
    public static String getThemeFileRootPath(String str) {
        File[] listFiles;
        File file;
        File[] listFiles2;
        File file2 = new File(new ThemeLocator().setThemeId(str).getBasePath(BaseApplication.getContext()));
        if (file2.exists() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            int length = listFiles.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    file = listFiles[i3];
                    if (file.isDirectory()) {
                        break;
                    }
                    i3++;
                } else {
                    file = null;
                    break;
                }
            }
            if (file != null && (listFiles2 = file.listFiles()) != null && listFiles2.length != 0) {
                return listFiles2[0].getAbsolutePath();
            }
        }
        return null;
    }
}
