package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.os.MqqHandler;

/* loaded from: classes11.dex */
public class ShortCutJumpQFileResultPlugin extends a {
    static IPatchRedirector $redirector_;

    public ShortCutJumpQFileResultPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(JumpActivity jumpActivity) {
        new MqqHandler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpQFileResultPlugin.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    JumpActivityHelper.c0(JumpActivity.this);
                }
            }
        }, 10L);
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.a
    public void a(int i3, int i16, Intent intent, JumpActivity jumpActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent, jumpActivity);
        } else {
            b(jumpActivity);
        }
    }
}
