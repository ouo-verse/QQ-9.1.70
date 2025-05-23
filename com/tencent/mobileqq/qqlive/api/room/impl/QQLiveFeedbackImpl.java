package com.tencent.mobileqq.qqlive.api.room.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveFeedback;
import com.tencent.mobileqq.qqlive.room.feedback.QQLiveFeedbackFragment;
import com.tencent.mobileqq.qqlive.room.feedback.a;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveFeedbackImpl implements IQQLiveFeedback {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "qqlive_feedback";

    public QQLiveFeedbackImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

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

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveFeedback
    public String getUrl(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        }
        return a.d(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveFeedback
    public void openFeedbackActivity(Activity activity, IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) iQQLiveSDK);
            return;
        }
        if (activity == null) {
            QLog.e(TAG, 1, "hostActivity is null");
        } else if (iQQLiveSDK == null) {
            QLog.e(TAG, 1, "livesdk is null");
        } else {
            startFeedbackActivity(activity, a.d(iQQLiveSDK));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveFeedback
    public void openFeedbackActivity(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
        } else if (context == null) {
            QLog.e(TAG, 1, "context is null");
        } else {
            startFeedbackActivity(context, a.c(context.getApplicationContext(), str));
        }
    }
}
