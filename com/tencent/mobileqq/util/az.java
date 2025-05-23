package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    private static int f306602a = -1;

    public static boolean a(Context context, AppInterface appInterface) {
        if (b(context)) {
            if (appInterface.isBackgroundPause || !ca.b(BaseApplication.getContext())) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static boolean b(Context context) {
        int readValueForInt = SettingCloneUtil.readValueForInt(context, null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, 0);
        int serverTime = (int) NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.d("NoDisturbUtil", 4, "canDisturb curServerTime = [" + serverTime + "] isNoDisturbMode=" + readValueForInt);
        }
        if (serverTime > readValueForInt) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context, AppInterface appInterface) {
        if (!(appInterface instanceof BaseQQAppInterface)) {
            return false;
        }
        int i3 = f306602a;
        if (i3 == -1) {
            boolean readValue = SettingCloneUtil.readValue(context, appInterface.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, false);
            f306602a = readValue ? 1 : 0;
            return readValue;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public static void d(boolean z16) {
        f306602a = z16 ? 1 : 0;
        if (QLog.isColorLevel()) {
            QLog.d("NoDisturbUtil", 2, "setMuteStat:", Integer.valueOf(f306602a));
        }
    }
}
