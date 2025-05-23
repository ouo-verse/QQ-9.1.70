package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qqcircle.utils.QCircleFileUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostFileUtils {
    public static void createFileIfNotExits(String str) {
        FileUtils.createFileIfNotExits(str);
    }

    public static void delete(String str, boolean z16) {
        FileUtils.delete(str, z16);
    }

    public static void deleteDirectory(String str) {
        FileUtils.deleteDirectory(str);
    }

    public static boolean fileExists(String str) {
        return FileUtils.fileExists(str);
    }

    public static boolean moveFile(String str, String str2) {
        return QCircleFileUtils.moveFile(str, str2);
    }
}
