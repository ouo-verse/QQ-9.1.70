package com.tencent.qqnt.emoticon.api.impl;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qcircle.api.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emoticon.api.IQCircleEmoticonApi;

/* compiled from: P */
/* loaded from: classes24.dex */
public class QCircleEmoticonApiImpl implements IQCircleEmoticonApi {
    static IPatchRedirector $redirector_;

    public QCircleEmoticonApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IQCircleEmoticonApi
    public boolean isSingleFollowUin(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return a.d(str);
    }
}
