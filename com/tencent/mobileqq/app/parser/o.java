package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.CustomHeightFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public o(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private void F() {
        int i3;
        String decode = Uri.decode(this.f307441f.get("url"));
        try {
            i3 = Integer.valueOf(this.f307441f.get("customheight")).intValue();
        } catch (Exception e16) {
            QLog.e("CustomHeightWebJumpAction", 1, "error parse custom height " + e16);
            i3 = 0;
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
        intent.putExtra("url", decode);
        intent.putExtra("isTransparentTitle", true);
        intent.putExtra("fragmentClass", CustomHeightFragment.class);
        intent.putExtra("customheight", i3);
        if (!(this.f307437b instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f307437b.startActivity(intent, ActivityOptions.makeCustomAnimation(this.f307437b, R.anim.f154424l, R.anim.f154425m).toBundle());
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if ("jump".equals(this.f307440e)) {
                F();
            }
            return true;
        } catch (Exception e16) {
            QLog.e("CustomHeightWebJumpAction", 1, "doAction error: " + e16.getMessage());
            i("CustomHeightWebJumpAction");
            return false;
        }
    }
}
