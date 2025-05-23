package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.p;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements GdtJsCallHandler {
    private void a(GdtAdWebPlugin gdtAdWebPlugin, String str, int i3) {
        if (gdtAdWebPlugin != null && str != null) {
            JSONObject newJSONObject = AdJSONUtil.newJSONObject();
            AdJSONUtil.put(newJSONObject, "code", Integer.valueOf(i3));
            gdtAdWebPlugin.callJs(str, AdJSONUtil.toString(newJSONObject));
            return;
        }
        GdtLog.e("GdtVideoCellingJsCallHandler", "[callError2Web] error");
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        AdError adError;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        int i3 = 0;
        if (gdtAdWebPlugin != null && activity != null) {
            if (strArr != null && strArr.length != 0) {
                GdtLog.d("GdtVideoCellingJsCallHandler", "args = " + strArr[0]);
                JSONObject optJSONObject = AdJSONUtil.optJSONObject(AdJSONUtil.newJSONObject(strArr[0]), "options");
                AdVideoCeiling.Params b16 = p.b(optJSONObject, activity);
                if (b16 == null) {
                    GdtLog.e("GdtVideoCellingJsCallHandler", "[handleJsCallRequest] params error");
                    a(gdtAdWebPlugin, str, -1);
                    return false;
                }
                if (!TextUtils.isEmpty(AdJSONUtil.optString(optJSONObject, "posId", "")) && b16.isValid()) {
                    adError = AdVideoCeiling.getInstance().show(b16);
                } else {
                    adError = new AdError(4);
                }
                if (!adError.isSuccess()) {
                    i3 = -1;
                }
                a(gdtAdWebPlugin, str, i3);
                AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) gdtAdWebPlugin.getActivity(), true, "openVideoCelling", gdtAdWebPlugin.getCurrentUrl(), b16.f61336ad);
                return adError.isSuccess();
            }
            GdtLog.e("GdtVideoCellingJsCallHandler", "[handleJsCallRequest] params error");
            a(gdtAdWebPlugin, str, -1);
            return false;
        }
        GdtLog.e("GdtVideoCellingJsCallHandler", "[handleJsCallRequest] error");
        return false;
    }
}
