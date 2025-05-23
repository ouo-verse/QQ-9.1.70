package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QVipMedalView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QVipMedalViewApiImpl implements IQVipMedalViewApi {
    static IPatchRedirector $redirector_;

    public QVipMedalViewApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi
    public void setData(View view, MedalList medalList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setData(view, medalList, Boolean.TRUE);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) medalList);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi
    public void setData(View view, MedalList medalList, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, medalList, bool);
            return;
        }
        QVipMedalView qVipMedalView = (QVipMedalView) view;
        qVipMedalView.setLoopCount(!bool.booleanValue() ? 1 : Integer.MAX_VALUE);
        qVipMedalView.setData(medalList);
    }
}
