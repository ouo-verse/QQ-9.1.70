package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(JumpActivity jumpActivity, int i3, int i16, Intent intent) {
        Bundle bundle;
        ((IQJumpApi) QRoute.api(IQJumpApi.class)).releaseMapActivityProxy();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            String string = bundle.getString("latitude");
            String string2 = bundle.getString("longitude");
            if (jumpActivity.doCallBack) {
                JumpActivityHelper.n(jumpActivity, "ret=0&lon=" + string2 + "&lat=" + string);
            }
            jumpActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.a
    public void a(int i3, int i16, Intent intent, JumpActivity jumpActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent, jumpActivity);
        } else {
            b(jumpActivity, i3, i16, intent);
        }
    }
}
