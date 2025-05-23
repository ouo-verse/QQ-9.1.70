package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.bus.api.IBusManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j extends com.tencent.mobileqq.troop.api.config.q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f186610a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f186610a = "TroopBizTroopPushProcessor";
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.q
    public void a(@NonNull AppInterface appInterface, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.tencent.mobileqq.troop.luckycharacter.a.b(i3, i16)) {
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.t(str));
        }
        if (((i3 ^ i16) & 4096) != 0) {
            if ((i3 & 4096) == 0) {
                z16 = false;
            }
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.i(str, 0L, z16));
        }
    }
}
