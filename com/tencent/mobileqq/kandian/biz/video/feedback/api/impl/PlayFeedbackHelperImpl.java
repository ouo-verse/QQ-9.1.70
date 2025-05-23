package com.tencent.mobileqq.kandian.biz.video.feedback.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IPlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/impl/PlayFeedbackHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/feedback/api/IPlayFeedbackHelper;", "()V", "feedbackViolaCall", "", "shareEntryActivity", "Landroid/app/Activity;", "jsonObject", "Lorg/json/JSONObject;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PlayFeedbackHelperImpl implements IPlayFeedbackHelper {
    @Override // com.tencent.mobileqq.kandian.biz.video.feedback.api.IPlayFeedbackHelper
    public void feedbackViolaCall(Activity shareEntryActivity, JSONObject jsonObject) {
        PlayFeedbackHelper.f(shareEntryActivity, jsonObject);
    }
}
