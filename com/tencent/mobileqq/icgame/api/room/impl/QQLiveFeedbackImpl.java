package com.tencent.mobileqq.icgame.api.room.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IQQLiveFeedback;
import com.tencent.mobileqq.icgame.room.feedback.QQLiveFeedbackFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveFeedbackImpl implements IQQLiveFeedback {
    public static final String TAG = "ICGame_feedback";

    private void startFeedbackActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", str);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("fragment_class", QQLiveFeedbackFragment.class.getCanonicalName());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IQQLiveFeedback
    public String getUrl(IQQLiveSDK iQQLiveSDK) {
        return f42.a.d(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IQQLiveFeedback
    public void openFeedbackActivity(Activity activity, IQQLiveSDK iQQLiveSDK) {
        if (activity == null) {
            QLog.e(TAG, 1, "hostActivity is null");
        } else if (iQQLiveSDK == null) {
            QLog.e(TAG, 1, "livesdk is null");
        } else {
            startFeedbackActivity(activity, f42.a.d(iQQLiveSDK));
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IQQLiveFeedback
    public void openFeedbackActivity(Context context, String str) {
        if (context == null) {
            QLog.e(TAG, 1, "context is null");
        } else {
            startFeedbackActivity(context, f42.a.c(context.getApplicationContext(), str));
        }
    }
}
