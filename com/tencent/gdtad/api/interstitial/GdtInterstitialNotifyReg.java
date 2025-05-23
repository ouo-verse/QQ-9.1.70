package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtInterstitialNotifyReg implements g {
    private static GdtAd c(@Nullable String str) {
        JSONObject jSONObject;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                Object obj = JSONObject.NULL;
                if (!obj.equals(jSONObject2) && (jSONObject = jSONObject2.getJSONObject("adInfo")) != null && !obj.equals(jSONObject) && (adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject))) != null) {
                    GdtAd gdtAd = new GdtAd(adInfo);
                    if (gdtAd.isValid()) {
                        return gdtAd;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            GdtLog.i("GdtInterstitialNotifyReg", String.format("getAd params:%s", str), th5);
            return null;
        }
    }

    private static JSONObject d(@Nullable String str) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                Object obj = JSONObject.NULL;
                if (!obj.equals(jSONObject2) && (jSONObject = jSONObject2.getJSONObject("options")) != null && !obj.equals(jSONObject)) {
                    return jSONObject.getJSONObject("antiSpamParamsOnCGI");
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            GdtLog.i("GdtInterstitialNotifyReg", String.format("getAntiSpamParamsOnCGI params:%s", str), th5);
            return null;
        }
    }

    private static int e(@Nullable String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!JSONObject.NULL.equals(jSONObject)) {
                    return jSONObject.getInt("errCode");
                }
                return Integer.MIN_VALUE;
            }
            return Integer.MIN_VALUE;
        } catch (Throwable th5) {
            GdtLog.e("GdtInterstitialNotifyReg", String.format("getError params:%s", str), th5);
            return Integer.MIN_VALUE;
        }
    }

    private static int f(int i3) {
        if (i3 != 101 && i3 != 102 && i3 != 106) {
            if (i3 != 103 && i3 != 104 && i3 != 105 && i3 != 107 && i3 != 108) {
                GdtLog.e("GdtInterstitialNotifyReg", String.format("getError arkScriptError:%d not working", Integer.valueOf(i3)));
            }
            return 1;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GdtInterstitialFragment g(@Nullable String str) {
        GdtAd c16 = c(str);
        if (c16 != null && c16.isValid()) {
            String traceId = c16.getTraceId();
            if (!TextUtils.isEmpty(traceId)) {
                return e.d().c(traceId);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(@Nullable String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!JSONObject.NULL.equals(jSONObject)) {
                    return jSONObject.getString("key");
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            GdtLog.e("GdtInterstitialNotifyReg", String.format("getKey params:%s", str), th5);
            return null;
        }
    }

    private static int i(@Nullable String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!JSONObject.NULL.equals(jSONObject)) {
                    return jSONObject.getInt("reason");
                }
                return Integer.MIN_VALUE;
            }
            return Integer.MIN_VALUE;
        } catch (Throwable th5) {
            GdtLog.e("GdtInterstitialNotifyReg", String.format("getReasonForClose params:%s", str), th5);
            return Integer.MIN_VALUE;
        }
    }

    private static String j(@Nullable String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!JSONObject.NULL.equals(jSONObject)) {
                    return jSONObject.getString("url");
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            GdtLog.e("GdtInterstitialNotifyReg", String.format("getUrl params:%s", str), th5);
            return null;
        }
    }

    private boolean k(@Nullable String str) {
        boolean z16;
        final GdtInterstitialFragment g16 = g(str);
        if (g16 == null) {
            z16 = false;
        } else {
            final JSONObject d16 = d(str);
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = d16;
                    if (jSONObject != null && !JSONObject.NULL.equals(jSONObject) && g16.th() != null && g16.th().clickOptions != null) {
                        g16.th().clickOptions.antiSpamParams = d16.toString();
                    }
                    g16.vh();
                }
            }, 0);
            z16 = true;
        }
        GdtLog.i("GdtInterstitialNotifyReg", String.format("receiveClick %b", Boolean.valueOf(z16)));
        return z16;
    }

    private boolean l(@Nullable String str) {
        boolean z16;
        final int i3 = i(str);
        final GdtInterstitialFragment g16 = g(str);
        if (g16 == null) {
            z16 = false;
        } else {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4
                @Override // java.lang.Runnable
                public void run() {
                    g16.sh(i3, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
                }
            }, 0);
            z16 = true;
        }
        GdtLog.i("GdtInterstitialNotifyReg", String.format("receiveClose %b", Boolean.valueOf(z16)));
        return z16;
    }

    private boolean m(@Nullable String str) {
        final GdtInterstitialFragment g16;
        final int e16 = e(str);
        final int f16 = f(e16);
        GdtLog.e("GdtInterstitialNotifyReg", String.format("receiveError error:%d arkScriptError:%d params:%s", Integer.valueOf(f16), Integer.valueOf(e16), str));
        if ((f16 == 4 || f16 == 207) && (g16 = g(str)) != null) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.6
                @Override // java.lang.Runnable
                public void run() {
                    g16.sh(4, f16, Integer.MIN_VALUE, e16);
                }
            }, 0);
        }
        return true;
    }

    private boolean n(@Nullable String str) {
        boolean z16;
        String j3 = j(str);
        if (!TextUtils.isEmpty(j3)) {
            final AdHttp.Params params = new AdHttp.Params();
            params.setUrl(j3);
            params.method = "GET";
            if (params.canSend()) {
                z16 = AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdHttp.send(params);
                    }
                }, 4);
                GdtLog.i("GdtInterstitialNotifyReg", String.format("receiveHTTPGet %b %s", Boolean.valueOf(z16), j3));
                return z16;
            }
        }
        z16 = false;
        GdtLog.i("GdtInterstitialNotifyReg", String.format("receiveHTTPGet %b %s", Boolean.valueOf(z16), j3));
        return z16;
    }

    private boolean o(@Nullable String str) {
        boolean z16;
        final GdtInterstitialFragment g16 = g(str);
        if (g16 == null) {
            z16 = false;
        } else {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.5
                @Override // java.lang.Runnable
                public void run() {
                    g16.xh();
                }
            }, 0);
            z16 = true;
        }
        GdtLog.i("GdtInterstitialNotifyReg", String.format("receiveLoaded %b", Boolean.valueOf(z16)));
        return z16;
    }

    private boolean p(@Nullable final String str) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.7
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String h16 = GdtInterstitialNotifyReg.h(str);
                GdtInterstitialFragment g16 = GdtInterstitialNotifyReg.g(str);
                if (!TextUtils.isEmpty(h16) && g16 != null) {
                    if ("ark_interstitial_video_onprogress".equals(h16)) {
                        i3 = 1;
                    } else if ("ark_interstitial_video_onload".equals(h16)) {
                        i3 = 2;
                    } else if ("ark_interstitial_video_onplaying".equals(h16)) {
                        i3 = 3;
                    } else if ("ark_interstitial_video_onpause".equals(h16)) {
                        i3 = 4;
                    } else if ("ark_interstitial_video_onended".equals(h16)) {
                        i3 = 5;
                    } else if ("ark_interstitial_video_onerror".equals(h16)) {
                        i3 = 6;
                    } else {
                        i3 = Integer.MIN_VALUE;
                    }
                    if (i3 != Integer.MIN_VALUE) {
                        g16.yh(i3);
                    }
                    if ("ark_interstitial_onexposure".equals(h16)) {
                        g16.wh();
                        return;
                    }
                    return;
                }
                GdtLog.e("GdtInterstitialNotifyReg", "receiveReport");
            }
        }, 0);
        return true;
    }

    private static void q(Context context, @Nullable final GdtInterstitialParams gdtInterstitialParams, final GdtInterstitialStatus gdtInterstitialStatus, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToLogicThread(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1
            @Override // java.lang.Runnable
            public void run() {
                Object pbToJson;
                JSONObject jSONObject = new JSONObject();
                try {
                    GdtInterstitialParams gdtInterstitialParams2 = GdtInterstitialParams.this;
                    if (gdtInterstitialParams2 != null && gdtInterstitialParams2.canShow() && (pbToJson = GdtJsonPbUtil.pbToJson(GdtInterstitialParams.this.clickOptions.f108486ad.info)) != null && !JSONObject.NULL.equals(pbToJson)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("adInfo", pbToJson);
                        jSONObject.put("gdt", jSONObject2);
                    }
                    ark.arkNotify(e.d().a().f108629a, e.d().a().f108631c, str, jSONObject.toString(), ark.ARKMETADATA_JSON);
                } catch (Throwable th5) {
                    GdtLog.e("GdtInterstitialNotifyReg", "sendEvent", th5);
                }
                GdtLog.i("GdtInterstitialNotifyReg", String.format("sendEvent %s", str));
                GdtAnalysisHelperForInterstitial.reportForInterstitialSendNotification((Context) weakReference.get(), GdtInterstitialParams.this, gdtInterstitialStatus, str, e.d().a().f108629a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        q(context, gdtInterstitialParams, gdtInterstitialStatus, "interstitial_view_pause_event");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void s(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        q(context, gdtInterstitialParams, gdtInterstitialStatus, "interstitial_view_destroy_event");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void t(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        q(context, gdtInterstitialParams, gdtInterstitialStatus, "interstitial_view_resume_event");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x008d  */
    @Override // com.tencent.mobileqq.ark.module.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean notify(String str, String str2, @Nullable String str3) {
        boolean z16;
        GdtInterstitialParams gdtInterstitialParams;
        boolean p16;
        boolean z17 = false;
        GdtLog.i("GdtInterstitialNotifyReg", String.format("notify appName:%s eventName:%s params:%s", str, str2, str3));
        if (e.d().a().f108629a.equals(str)) {
            if ("interstitial_http_get_event".equals(str2)) {
                z16 = n(str3);
            } else {
                if ("interstitial_jump_click_event".equals(str2)) {
                    p16 = k(str3);
                } else if ("interstitial_close_click_event".equals(str2)) {
                    p16 = l(str3);
                } else if ("interstitial_success_event".equals(str2)) {
                    p16 = o(str3);
                } else if ("interstitial_error_event".equals(str2)) {
                    p16 = m(str3);
                } else if ("interstitial_report_event".equals(str2)) {
                    String h16 = h(str3);
                    if (!TextUtils.isEmpty(h16)) {
                        str2 = h16;
                    }
                    p16 = p(str3);
                }
                z16 = p16;
                z17 = true;
            }
            if (z17) {
                GdtInterstitialFragment g16 = g(str3);
                GdtInterstitialStatus gdtInterstitialStatus = null;
                if (g16 != null) {
                    gdtInterstitialParams = g16.th();
                } else {
                    gdtInterstitialParams = null;
                }
                if (g16 != null) {
                    gdtInterstitialStatus = g16.uh();
                }
                GdtAnalysisHelperForInterstitial.reportForInterstitialReceiveNotification(BaseApplication.getContext(), gdtInterstitialParams, gdtInterstitialStatus, str2, str);
            }
            return z16;
        }
        z16 = false;
        if (z17) {
        }
        return z16;
    }
}
