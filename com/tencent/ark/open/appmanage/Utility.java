package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Utility {
    static final Pattern PATTERN_VALID_APPID = Pattern.compile("^[\\w\\d]+(\\.[\\w\\d]+)+$");
    private static final String TAG = "ArkApp.ArkAppMgr";

    public static String QueryAppRetCodeToString(int i3) {
        if (i3 != -8) {
            if (i3 != -7) {
                if (i3 != -6) {
                    if (i3 != -3) {
                        if (i3 != -2) {
                            if (i3 != -1) {
                                if (i3 != 0) {
                                    if (i3 != 5) {
                                        if (i3 != 6) {
                                            if (i3 != 7) {
                                                if (i3 > 0) {
                                                    return "\u670d\u52a1\u7aef\u5176\u4ed6\u9519\u8bef";
                                                }
                                                return WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
                                            }
                                            return "\u5e94\u7528\u66f4\u65b0\u5931\u8d25";
                                        }
                                        return "\u8bf7\u5c06QQ\u5347\u7ea7\u5230\u6700\u65b0\u7248\u672c\u540e\u67e5\u770b";
                                    }
                                    return "\u5e94\u7528\u672a\u4e0a\u67b6";
                                }
                                return "\u6210\u529f";
                            }
                            return "\u5ba2\u6237\u7aef\u5176\u4ed6\u9519\u8bef";
                        }
                        return "\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5";
                    }
                    return "\u5e94\u7528\u7ec4\u4ef6\u66f4\u65b0\u5931\u8d25";
                }
                return "\u5e94\u7528\u7ec4\u4ef6\u52a0\u8f7d\u4e2d\u3002";
            }
            return "\u52a0\u8f7d\u8d85\u65f6";
        }
        return "\u65e0\u6548\u7684\u89c6\u56fe";
    }

    public static int compareVersionString(String str, String str2) {
        int i3;
        int i16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            Logger.logI("ArkApp.ArkAppMgr", "compareVersionString: ver1=", str, ",ver2=", str2);
            for (int i17 = 0; i17 < 4; i17++) {
                try {
                    if (split.length > i17) {
                        i3 = Integer.parseInt(split[i17]);
                    } else {
                        i3 = 0;
                    }
                    if (split2.length > i17) {
                        i16 = Integer.parseInt(split2[i17]);
                    } else {
                        i16 = 0;
                    }
                    if (i3 > i16) {
                        return 1;
                    }
                    if (i3 < i16) {
                        return -1;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    Logger.logI("ArkApp.ArkAppMgr", "compareVersionString: Exception:", e16.getMessage());
                }
            }
            return 0;
        }
        Logger.logE("ArkApp.ArkAppMgr", "compareVersionString empty : ver1=", str, ",ver2=", str2);
        return 0;
    }

    public static boolean deleteFile(File file) {
        if (file != null) {
            if (file.isFile()) {
                if (!file.delete()) {
                    file.deleteOnExit();
                    return false;
                }
                return true;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        deleteFile(file2);
                    }
                }
                return file.delete();
            }
        }
        return false;
    }

    public static String getAppDirByNameAndVersion(String str) {
        return String.format("%s/%s", ArkEnvironmentManager.getInstance().getAppInstallDirectory(), str);
    }

    public static String getAppPathByNameAndVersion(String str, String str2, String str3) {
        return String.format("%s/%s.%s", getAppDirByNameAndVersion(str), str2, str3);
    }

    public static boolean isValidAppName(String str) {
        if (TextUtils.isEmpty(str) || !PATTERN_VALID_APPID.matcher(str).find()) {
            return false;
        }
        return true;
    }

    public static boolean isValidAppVersion(String str) {
        if (str == null || str.length() == 0 || !str.matches("^\\d+(\\.\\d+){0,3}$")) {
            return false;
        }
        return true;
    }
}
