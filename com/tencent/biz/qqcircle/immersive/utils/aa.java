package com.tencent.biz.qqcircle.immersive.utils;

import android.content.res.Configuration;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aa {
    public static boolean a(Configuration configuration) {
        String configuration2;
        String str;
        boolean z16;
        if ((bz.r() && !bz.m()) || !uq3.o.V1()) {
            return false;
        }
        String str2 = "";
        if (configuration == null) {
            configuration2 = "";
        } else {
            configuration2 = configuration.toString();
        }
        if (!configuration2.contains("mWindowingMode=")) {
            return false;
        }
        try {
            String[] split = configuration2.split(" ");
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    str = "";
                    break;
                }
                str = split[i3];
                if (str.contains("mWindowingMode=")) {
                    break;
                }
                i3++;
            }
            String[] split2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length >= 2) {
                str2 = split2[1];
            }
            if (!str2.contains("freeform") && !str2.contains("100")) {
                z16 = false;
                QLog.d("QFSFreeWindowModeUtils", 1, "[handlerMultiWindowModeStatus] windowModeStr: " + str + " | windowModeName: " + str2 + " | isActivityInFreeFormMode: " + z16);
                return z16;
            }
            z16 = true;
            QLog.d("QFSFreeWindowModeUtils", 1, "[handlerMultiWindowModeStatus] windowModeStr: " + str + " | windowModeName: " + str2 + " | isActivityInFreeFormMode: " + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.e("QFSFreeWindowModeUtils", 1, "[handlerMultiWindowModeStatus] error: ", th5);
            return false;
        }
    }
}
