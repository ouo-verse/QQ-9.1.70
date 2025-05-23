package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ThemeLabelTextView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ThemeLabelTextViewApiImpl implements IThemeLabelTextViewApi {
    static IPatchRedirector $redirector_;

    public ThemeLabelTextViewApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi
    public void setSupportMaskView(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
        } else {
            ((ThemeLabelTextView) view).setSupportMaskView(z16);
        }
    }
}
