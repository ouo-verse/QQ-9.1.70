package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.emoticonview.api.IApolloDependApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ApolloDependApiImpl implements IApolloDependApi {
    static IPatchRedirector $redirector_;

    public ApolloDependApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IApolloDependApi
    public void onEmoticonNewIconShown(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            ((IApolloUtil) QRoute.api(IApolloUtil.class)).onEmoticonNewIconShown(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IApolloDependApi
    public boolean shouldShowNewIcon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        return ((IApolloUtil) QRoute.api(IApolloUtil.class)).shouldShowNewIcon(i3);
    }
}
