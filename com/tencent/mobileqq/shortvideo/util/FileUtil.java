package com.tencent.mobileqq.shortvideo.util;

import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FileUtil {
    public static boolean checkFileExist(String str) {
        return new File(str).exists();
    }

    public static boolean fileExistsAndNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }
}
