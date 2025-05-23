package com.tenpay.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.ITenCookie;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public class QFuncProxy {
    private static final String TAG = "QFuncProxy";

    public static boolean clearTempArgs(String str) {
        return ((ITenCookie) QRoute.api(ITenCookie.class)).clearTempArgs(str);
    }

    public static final int dp2px(float f16, Resources resources) {
        return BaseAIOUtils.f(f16, resources);
    }

    public static void followUin(final String str, Context context, final boolean z16) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tenpay.api.QFuncProxy.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((INewQWalletApi) QRoute.apiIPCSync(INewQWalletApi.class)).ipcFollowUin(str, z16);
                } catch (Exception e16) {
                    QLog.e(QFuncProxy.TAG, 1, "followUin: ", e16);
                }
            }
        });
    }

    public static String getDeviceId(Context context) {
        return QFuncApi.getDeviceId(context);
    }

    public static String getMsgNo(String str) {
        return QFuncApi.getMsgNo(str);
    }

    public static String getWebViewUAForQQ(String str, String str2, boolean z16) {
        return i.n(str, str2, z16);
    }

    public static void gotoH5(Context context, String str, boolean z16, boolean z17) {
        k.b(context, str, z16, z17, null);
    }

    public static boolean isColorLevel() {
        return QFuncApi.isColorLevel();
    }

    public static boolean isFlymeOS() {
        return QFuncApi.isFlymeOS();
    }

    public static boolean isNetSupport(Context context) {
        return NetworkUtil.isNetSupport(context);
    }

    public static int isSupporImmersive() {
        return QFuncApi.isSupporImmersive();
    }

    public static final String md5(byte[] bArr) {
        return QFuncApi.md5(bArr);
    }

    public static void putEncryptValue(String str, String str2, SharedPreferences sharedPreferences, String str3) {
        ((ITenCookie) QRoute.api(ITenCookie.class)).putEncryptValue(str, str2, sharedPreferences, str3);
    }

    public static void setTempArgs(String str, String str2) {
        ((ITenCookie) QRoute.api(ITenCookie.class)).setTempArgs(str, str2);
    }

    public static void setUin(String str) {
        ((ITenCookie) QRoute.api(ITenCookie.class)).setUin(str);
    }

    public static String toMD5(String str) {
        return MD5.toMD5(str);
    }

    public static void webProxy(ArrayList<WebViewPlugin> arrayList) {
        if (arrayList == null) {
            return;
        }
        arrayList.addAll(((IQwTemp) QRoute.api(IQwTemp.class)).getQWalletJsPlugins());
        arrayList.add(((IIdentificationApi) QRoute.api(IIdentificationApi.class)).createIdentificationPlugin());
    }

    public static void writeTagCookie(Context context, String str, List<String> list) {
        ((ITenCookie) QRoute.api(ITenCookie.class)).writeTagCookie(context, str, list);
    }
}
