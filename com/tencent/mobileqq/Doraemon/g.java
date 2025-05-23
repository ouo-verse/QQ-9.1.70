package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(int i3, Bundle bundle, d dVar) {
        ((IDoraemonClient) QRoute.api(IDoraemonClient.class)).sendToServer(i3, bundle, dVar);
    }

    public void a(int i3, Bundle bundle, int i16, Messenger messenger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bundle, Integer.valueOf(i16), messenger);
            return;
        }
        int i17 = bundle.getInt("key_sub_cmd");
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 == 3) {
                    com.tencent.mobileqq.Doraemon.monitor.b.c().i(bundle.getString("key"), bundle.getInt("type"), bundle.getString("appid"), bundle.getString(DTConstants.TAG.API));
                    return;
                }
                return;
            }
            com.tencent.mobileqq.Doraemon.monitor.b.c().g(bundle.getString("key"), bundle.getInt("type"), bundle.getString("appid"));
            return;
        }
        bundle.putBundle("key_result", ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).getUserInfo());
        Message obtain = Message.obtain((Handler) null, i3);
        obtain.setData(bundle);
        if (messenger != null) {
            try {
                messenger.send(obtain);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("DoraemonBridge", 2, "messeage not sent:" + e16.getMessage());
                }
            }
        }
    }
}
