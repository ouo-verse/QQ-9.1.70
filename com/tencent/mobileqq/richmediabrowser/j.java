package com.tencent.mobileqq.richmediabrowser;

import android.text.TextUtils;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {
    public static String[] a(String str) {
        if (d(str)) {
            return str.substring(str.indexOf("|") + 1).split("\\|");
        }
        return null;
    }

    public static String b(String str) {
        if (d(str)) {
            String[] split = str.substring(str.indexOf("|") + 1).split("\\|");
            if (split.length >= 8) {
                if (split[7].equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                    return split[4];
                }
                if (split[7].equals("scrawl_link") && split.length >= 9) {
                    return split[8];
                }
            }
        }
        return "";
    }

    public static int c(String[] strArr) {
        if (strArr != null && strArr.length >= 8) {
            if (strArr[7].equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                return 3;
            }
            if (strArr.length >= 9 && strArr[7].equals("scrawl_link")) {
                String str = strArr[8];
                if (!TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOImageData", 2, "name = " + str + " , name.length = " + str.length());
                    }
                    if (!str.startsWith(JobDbManager.TBL_UPLOAD) && str.trim().length() <= 32) {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
            return true;
        }
        return false;
    }

    public static boolean e(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("ScreenShotShare")) {
            return true;
        }
        return false;
    }

    public static String[] f(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split("\\|");
        }
        return null;
    }
}
