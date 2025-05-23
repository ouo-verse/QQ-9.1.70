package com.tencent.mobileqq.auto.engine.skin.entity;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BackgroundAttr extends SkinAttr {
    static IPatchRedirector $redirector_;
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        TAG = "SKIN" + BackgroundAttr.class.getSimpleName();
    }

    public BackgroundAttr(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.entity.SkinAttr
    public boolean applyInner(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
        }
        if (isColorAttr()) {
            view.setBackgroundColor(getColor());
            return true;
        }
        if (isDrawableAttr()) {
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingBottom = view.getPaddingBottom();
            view.setBackground(getDrawable());
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            return true;
        }
        return false;
    }
}
