package com.tencent.mobileqq.auto.engine.skin.entity;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TextColorAttr extends SkinAttr {
    static IPatchRedirector $redirector_;

    public TextColorAttr(String str) {
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
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (isColorAttr()) {
                textView.setTextColor(getColorStateList());
                return true;
            }
            return false;
        }
        return false;
    }
}
