package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IGdtInterstitialAd {
    public static final int KEY_INTERSTITIAL_REQUEST = 10001;

    boolean canShow();

    void close(Activity activity);

    void onClose(Activity activity, int i3, Intent intent);

    void setAntiSpamParamsForDisplayOnReportServer(JSONObject jSONObject);

    boolean show(Activity activity);
}
