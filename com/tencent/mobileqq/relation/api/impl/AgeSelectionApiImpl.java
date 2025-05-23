package com.tencent.mobileqq.relation.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.IAgeSelectionApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AgeSelectionApiImpl implements IAgeSelectionApi {
    static IPatchRedirector $redirector_;

    public AgeSelectionApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAgeSelectionApi
    public void startAgeSelectionActivity(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, intent, Integer.valueOf(i3));
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) AgeSelectionActivity.class);
        intent2.putExtras(intent);
        activity.startActivityForResult(intent2, i3);
    }
}
