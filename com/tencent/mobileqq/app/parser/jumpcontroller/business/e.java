package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(JumpActivity jumpActivity) {
        if (jumpActivity.doCallBack) {
            JumpActivityHelper.n(jumpActivity, "HexUtil.bytes2HexStr(fileKey)");
        }
        jumpActivity.finish();
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
