package com.tencent.gdtad.util;

import android.app.Activity;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class k {
    public static AdFeedbackParams a(String str, WeakReference<AdFeedbackDialogFragment.Listener> weakReference, WeakReference<Activity> weakReference2) {
        int i3;
        JSONObject jSONObject;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        boolean z16 = false;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("adInfo");
            jSONObject = jSONObject2.optJSONObject("options");
            try {
                if (!AdJSONUtil.isJSONObjectNull(jSONObject)) {
                    i3 = jSONObject.optInt("orientation", 0);
                } else {
                    i3 = 0;
                }
                try {
                    adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(string));
                    try {
                        if (!AdJSONUtil.isJSONObjectNull(jSONObject)) {
                            if (jSONObject.optBoolean("isDarkMode", false)) {
                                z16 = true;
                            }
                        }
                    } catch (Throwable th5) {
                        adInfo2 = adInfo;
                        th = th5;
                        QLog.e("GdtFeedbackUtil", 1, "[createFeedbackParams]", th);
                        adInfo = adInfo2;
                        adFeedbackParams.activity = weakReference2;
                        adFeedbackParams.styleId = i3;
                        adFeedbackParams.f61346ad = new GdtAd(adInfo);
                        adFeedbackParams.isDarkMode = z16;
                        adFeedbackParams.listener = weakReference;
                        adFeedbackParams.shouldShowToast = AdJSONUtil.optBoolean(jSONObject, "shouldShowToast", true);
                        adFeedbackParams.shouldShowCancelButton = AdJSONUtil.optBoolean(jSONObject, "shouldShowCancelButton", true);
                        return adFeedbackParams;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                i3 = 0;
            }
        } catch (Throwable th8) {
            th = th8;
            i3 = 0;
            jSONObject = null;
        }
        adFeedbackParams.activity = weakReference2;
        adFeedbackParams.styleId = i3;
        adFeedbackParams.f61346ad = new GdtAd(adInfo);
        adFeedbackParams.isDarkMode = z16;
        adFeedbackParams.listener = weakReference;
        adFeedbackParams.shouldShowToast = AdJSONUtil.optBoolean(jSONObject, "shouldShowToast", true);
        adFeedbackParams.shouldShowCancelButton = AdJSONUtil.optBoolean(jSONObject, "shouldShowCancelButton", true);
        return adFeedbackParams;
    }
}
