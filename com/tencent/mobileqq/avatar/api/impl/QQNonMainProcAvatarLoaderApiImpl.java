package com.tencent.mobileqq.avatar.api.impl;

import android.content.Context;
import com.tencent.mobileqq.armap.f;
import com.tencent.mobileqq.armap.g;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class QQNonMainProcAvatarLoaderApiImpl implements IQQNonMainProcAvatarLoaderApi {
    static IPatchRedirector $redirector_;

    public QQNonMainProcAvatarLoaderApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi
    public f getNonMainAppHeadLoader(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
        return new g(context, i3);
    }
}
