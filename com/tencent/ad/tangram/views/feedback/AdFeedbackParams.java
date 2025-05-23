package com.tencent.ad.tangram.views.feedback;

import android.app.Activity;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdFeedbackParams {
    public static final int LANDSCAPE_STYLE = 1;
    public static final int PORTRAIT_STYLE = 0;
    public WeakReference<Activity> activity;

    /* renamed from: ad, reason: collision with root package name */
    public Ad f61346ad;
    public WeakReference<AdFeedbackDialogFragment.Listener> listener;
    public int styleId = 0;
    public boolean isDarkMode = false;
    public boolean shouldShowToast = true;
    public boolean shouldShowCancelButton = true;

    public boolean isValid() {
        int i3;
        Ad ad5 = this.f61346ad;
        if (ad5 != null && ad5.isValid() && this.activity != null && this.listener != null && ((i3 = this.styleId) == 0 || i3 == 1)) {
            return true;
        }
        return false;
    }
}
