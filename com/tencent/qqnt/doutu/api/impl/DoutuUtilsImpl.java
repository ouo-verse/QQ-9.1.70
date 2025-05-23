package com.tencent.qqnt.doutu.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.doutu.api.IDoutuSPUtil;
import com.tencent.qqnt.doutu.api.IDoutuUtils;

/* compiled from: P */
/* loaded from: classes24.dex */
public class DoutuUtilsImpl implements IDoutuUtils {
    static IPatchRedirector $redirector_;

    public DoutuUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.doutu.api.IDoutuUtils
    public void markResDamaged(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else if (!DoutuServiceImpl.isLoadingRes) {
            ((IDoutuSPUtil) QRoute.api(IDoutuSPUtil.class)).updateDoutuResDamaged(context, true);
        }
    }
}
