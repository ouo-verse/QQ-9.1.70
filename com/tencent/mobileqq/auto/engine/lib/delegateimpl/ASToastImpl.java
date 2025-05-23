package com.tencent.mobileqq.auto.engine.lib.delegateimpl;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.auto.engine.lib.IToastDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASToastImpl implements IToastDelegate {
    static IPatchRedirector $redirector_;

    public ASToastImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IToastDelegate
    public int getIconTypeDefault() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IToastDelegate
    public int getIconTypeError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IToastDelegate
    public int getIconTypeNone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IToastDelegate
    public int getIconTypeSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IToastDelegate
    public Toast makeTextAndShow(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Toast) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        return QQToast.makeText(MobileQQ.sMobileQQ, i3, str, i16).show();
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IToastDelegate
    public Toast showToastByNativeToast(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Toast) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0f));
        gradientDrawable.setShape(0);
        TextView textView = new TextView(MobileQQ.sMobileQQ);
        textView.setBackground(gradientDrawable);
        textView.setTextSize(2, 14.0f);
        int dip2px = ViewUtils.dip2px(12.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setLines(1);
        textView.setTextColor(-1);
        textView.setText(str);
        Toast toast = new Toast(MobileQQ.sMobileQQ);
        toast.setView(textView);
        toast.setDuration(i16);
        toast.setGravity(17, 0, 0);
        toast.show();
        return toast;
    }
}
