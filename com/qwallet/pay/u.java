package com.qwallet.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qwallet.utils.QWalletUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class u {
    private static boolean a(JSONObject jSONObject, Context context) {
        if (jSONObject == null) {
            return false;
        }
        return context instanceof Activity;
    }

    private static boolean b(String str, int i3) {
        String string = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(str, "redpack_popwnd_network_" + i3, null);
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase();
            int systemNetwork = NetworkUtil.getSystemNetwork(null);
            if (systemNetwork >= 0) {
                String[] strArr = AppConstants.NET_TYPE_NAME;
                if (systemNetwork < strArr.length) {
                    return upperCase.contains(strArr[systemNetwork].toUpperCase());
                }
                return false;
            }
            return false;
        }
        return true;
    }

    private static boolean c(String str, int i3, long j3) {
        int i16 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt(str, "redpack_popwnd_freq_" + i3, 0);
        long j16 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getLong(str, "redpack_popwnd_last_show_time_" + i3, 0L);
        if (i16 <= 0) {
            i16 = 1;
        }
        if (j3 > j16 && j3 - j16 < i16 * 86400) {
            return false;
        }
        return true;
    }

    private static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        int i3 = 0;
        while (i3 < split.length && !split[i3].equals(str2)) {
            i3++;
        }
        if (i3 >= split.length) {
            return false;
        }
        return true;
    }

    private static boolean e(String str, int i3, long j3) {
        long j16 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getLong(str, "redpack_popwnd_begin_time_" + i3, -1L);
        long j17 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getLong(str, "redpack_popwnd_end_time_" + i3, -1L);
        if (j3 >= j16 && j3 <= j17) {
            return true;
        }
        return false;
    }

    public static String f(APMidasResponse aPMidasResponse) {
        StringBuilder sb5 = new StringBuilder();
        if (aPMidasResponse != null) {
            sb5.append("rc=");
            sb5.append(aPMidasResponse.resultCode);
            sb5.append("&rm=");
            sb5.append(aPMidasResponse.resultMsg);
            sb5.append("&rsn=");
            sb5.append(aPMidasResponse.realSaveNum);
            sb5.append("&pc=");
            sb5.append(aPMidasResponse.payChannel);
            sb5.append("&ps=");
            sb5.append(aPMidasResponse.payState);
            sb5.append("&pds=");
            sb5.append(aPMidasResponse.provideState);
            sb5.append("&ei=");
            sb5.append(aPMidasResponse.extendInfo);
            sb5.append("&pr1=");
            sb5.append(aPMidasResponse.payReserve1);
            sb5.append("&pr2=");
            sb5.append(aPMidasResponse.payReserve2);
            sb5.append("&pr3=");
            sb5.append(aPMidasResponse.payReserve3);
        }
        return sb5.toString();
    }

    public static void g(JSONObject jSONObject, Context context) {
        String h16;
        int i3;
        if (!a(jSONObject, context) || !jSONObject.optString("need_realname_flag").equals("1") || (i3 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt((h16 = QWalletUtils.h()), "redpack_popwnd_id", 0)) <= 0) {
            return;
        }
        int i16 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt(h16, "redpack_popwnd_current_" + i3, 0);
        int i17 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt(h16, "redpack_popwnd_total_" + i3, 0);
        if (i17 > 0 && i16 >= i17) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!e(h16, i3, currentTimeMillis) || !c(h16, i3, currentTimeMillis) || !b(h16, i3)) {
            return;
        }
        if (!d(((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(h16, "redpack_popwnd_state_" + i3, null), String.valueOf(jSONObject.optInt("state", -1)))) {
            return;
        }
        if (!d(((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(h16, "redpack_popwnd_state_" + i3, null), jSONObject.optString(NotifyMsgApiImpl.KEY_GROUP_TYPE, ""))) {
            return;
        }
        String string = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(h16, "redpack_popwnd_url_" + i3, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", string);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("hide_more_button", true);
        intent.putExtra(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, true);
        intent.putExtra("isTransparentTitle", true);
        RouteUtils.startActivity(context, intent, "/qwallet/tenpay/full");
        QWalletHelperDelegate.sFullWndCurType = 0;
        QWalletHelperDelegate.sFullWndCurID = i3;
        ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(h16, "redpack_popwnd_current_" + i3, i16 + 1);
        ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putLong(h16, "redpack_popwnd_last_show_time_" + i3, currentTimeMillis);
    }
}
