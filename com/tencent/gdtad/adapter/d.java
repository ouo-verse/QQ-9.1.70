package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d implements AdFeedbackAdapter {
    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getBackgroundColor(Context context) {
        return ie0.a.f().g(context, R.color.qui_common_bg_middle_light, 1000);
    }

    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getButtonTextColor(Context context) {
        return ie0.a.f().g(context, R.color.qui_common_text_primary, 1000);
    }

    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getCancelButtonBackgroundColor(Context context) {
        return ie0.a.f().g(context, R.color.qui_button_bg_primary_default, 1000);
    }

    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getCancelButtonTextColor(Context context) {
        return ie0.a.f().g(context, R.color.qui_button_text_primary_default, 1000);
    }

    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getDividerColor(Context context) {
        return ie0.a.f().g(context, R.color.qui_common_border_standard, 1000);
    }

    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getIconColorFilter(Context context) {
        return ie0.a.f().g(context, R.color.qui_common_icon_primary, 1000);
    }

    @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter
    public int getMainDividerColor(Context context) {
        return ie0.a.f().g(context, R.color.qui_common_icon_tertiary, 1000);
    }
}
