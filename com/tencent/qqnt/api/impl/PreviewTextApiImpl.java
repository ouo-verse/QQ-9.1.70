package com.tencent.qqnt.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.api.IPreviewTextApi;

/* loaded from: classes23.dex */
public class PreviewTextApiImpl implements IPreviewTextApi {
    static IPatchRedirector $redirector_;

    public PreviewTextApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.api.IPreviewTextApi
    public Intent createTextPreviewIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) TextPreviewActivity.class);
    }

    @Override // com.tencent.qqnt.api.IPreviewTextApi
    public boolean isPreviewTextAct(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        return context instanceof TextPreviewActivity;
    }
}
