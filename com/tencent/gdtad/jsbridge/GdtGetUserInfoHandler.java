package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.GetUserInfoCallback;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtGetUserInfoHandler implements GdtJsCallHandler {
    public static final String KEY_AREA = "area";
    public static final String KEY_CITY = "city";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    private static final String TAG = "GdtGetUserInfoHandler";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GetUserInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GdtAdWebPlugin f109236a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f109237b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f109238c;

        a(GdtAdWebPlugin gdtAdWebPlugin, String str, String[] strArr) {
            this.f109236a = gdtAdWebPlugin;
            this.f109237b = str;
            this.f109238c = strArr;
        }

        @Override // com.tencent.gdtad.params.GetUserInfoCallback
        public void callback(@NonNull Bundle bundle) {
            String string = bundle.getString("phone");
            String string2 = bundle.getString("name");
            String string3 = bundle.getString("city");
            String string4 = bundle.getString(GdtGetUserInfoHandler.KEY_AREA);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("phone", string);
                jSONObject.put("name", string2);
                jSONObject.put("city", string3);
                jSONObject.put(GdtGetUserInfoHandler.KEY_AREA, string4);
            } catch (Exception e16) {
                GdtLog.e(GdtGetUserInfoHandler.TAG, e16.toString());
            }
            String jSONObject2 = jSONObject.toString();
            GdtLog.d(GdtGetUserInfoHandler.TAG, "handleJsCallRequest() called with: webPlugin = [" + this.f109236a + "], callback = [" + this.f109237b + "], args = [" + this.f109238c + "], result = [" + jSONObject2 + "]");
            this.f109236a.callJs(this.f109237b, jSONObject2);
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@NonNull GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        new GdtThirdProcessorProxy().gdtGetCurrentUserInfo(new a(gdtAdWebPlugin, str, strArr));
        String str2 = null;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null) {
            str2 = gdtAdWebPlugin.getCurrentUrl();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "getUserInfo", str2);
        return true;
    }
}
