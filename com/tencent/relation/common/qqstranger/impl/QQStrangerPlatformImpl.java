package com.tencent.relation.common.qqstranger.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.qqstranger.IQQStrangerPlatform;
import com.tencent.relation.common.qqstranger.component.IegRealNameComponent;
import com.tencent.relation.common.qqstranger.component.a;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes25.dex */
public class QQStrangerPlatformImpl implements IQQStrangerPlatform {
    static IPatchRedirector $redirector_;

    public QQStrangerPlatformImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.qqstranger.IQQStrangerPlatform
    public void checkRealName(Context context, @NotNull a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, aVar, Integer.valueOf(i3));
        } else {
            IegRealNameComponent.b(context, aVar, i3);
        }
    }
}
