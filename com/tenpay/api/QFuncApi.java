package com.tenpay.api;

import android.content.Context;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.QwLog;
import cooperation.qwallet.pluginshare.ITenCookie;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QFuncApi {
    private static final String TAG = "QFuncApi";

    public static void QLogd(String str, int i3, String str2) {
        if (QwLog.getIsDevelop()) {
            Log.d(str, str2);
        } else {
            QLog.d(str, i3, str2);
        }
    }

    public static void QLoge(String str, int i3, String str2) {
        if (QwLog.getIsDevelop()) {
            Log.e(str, str2);
        } else {
            QLog.e(str, i3, str2);
        }
    }

    public static void QLogi(String str, int i3, String str2) {
        if (QwLog.getIsDevelop()) {
            Log.i(str, str2);
        } else {
            QLog.i(str, i3, str2);
        }
    }

    public static String getDeviceId(Context context) {
        String c16 = o.c();
        QwLog.i("device id = " + c16);
        return c16;
    }

    public static String getMsgNo(String str) {
        return ((ITenCookie) QRoute.api(ITenCookie.class)).getMsgNo(str);
    }

    public static int getRealHeight(Context context) {
        return ScreenUtil.getRealHeight(context);
    }

    public static boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    public static boolean isEMUI3_1() {
        return OSUtils.isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return OSUtils.isFlymeOS();
    }

    public static int isSupporImmersive() {
        return ImmersiveUtils.isSupporImmersive();
    }

    public static String loadDynamicSo() {
        boolean isFeatureSwitch = ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_DYNAMIC_CFTUTILS_SO);
        QLog.i(TAG, 2, "dynamicSwitch =" + isFeatureSwitch);
        if (!isFeatureSwitch) {
            return null;
        }
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(SoLoadConstants.SONAME_QWALLET_CFTUTILS);
        QLog.i(TAG, 1, "loadCftUtilsSo " + loadSync.toString());
        if (!loadSync.isSucc()) {
            return null;
        }
        QLog.i(TAG, 1, "versionName " + loadSync.getVer());
        return loadSync.getVer();
    }

    public static final String md5(byte[] bArr) {
        return HexUtil.bytes2HexStr(bArr);
    }
}
