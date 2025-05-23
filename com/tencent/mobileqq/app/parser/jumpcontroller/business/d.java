package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(JumpActivity jumpActivity, int i3, int i16, Intent intent) {
        if (-1 == i16 && intent != null) {
            String stringExtra = intent.getStringExtra("roomId");
            if (stringExtra != null) {
                ((IQJumpApi) QRoute.api(IQJumpApi.class)).handleStartGroupAudio(jumpActivity, stringExtra);
                return;
            }
            return;
        }
        jumpActivity.finish();
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
