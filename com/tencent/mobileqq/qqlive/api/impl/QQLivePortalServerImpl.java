package com.tencent.mobileqq.qqlive.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLivePortalServer;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.a;
import com.tencent.mobileqq.qroute.QRoute;

/* loaded from: classes17.dex */
public class QQLivePortalServerImpl implements IQQLivePortalServer {
    static IPatchRedirector $redirector_ = null;
    private static final String PARAM_URL_FMT = "buffer=%s&tab=%s&from=%s";
    private static final int UPDATE_JS_BUNDLE_TYPE_NOT_UPDATE = 1;

    public QQLivePortalServerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void jumpToNewPortal(Activity activity, int i3, int i16) {
        a aVar = new a();
        aVar.e(i3);
        aVar.h(1);
        aVar.i(String.format(PARAM_URL_FMT, "", Integer.valueOf(i16), Integer.valueOf(i3)));
        ((IQQIvLiveHallApi) QRoute.api(IQQIvLiveHallApi.class)).openQQIvLiveHall(activity, aVar);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLivePortalServer
    public void goToPortal(Activity activity, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            jumpToNewPortal(activity, i3, i16);
        }
    }
}
