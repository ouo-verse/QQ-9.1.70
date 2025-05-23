package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class PhoneFrame extends PhoneInnerFrame {
    static IPatchRedirector $redirector_;
    private BaseActivityView.e H;

    public PhoneFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.activity.phone.PhoneInnerFrame
    protected BaseActivityView.e n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseActivityView.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.H;
    }

    @Override // com.tencent.mobileqq.activity.phone.PhoneInnerFrame
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            e().finish();
        }
    }

    public void setPhoneContext(BaseActivityView.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        } else {
            this.H = eVar;
        }
    }

    public PhoneFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PhoneFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
