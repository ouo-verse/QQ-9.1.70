package com.tencent.mobileqq.customviews;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.item.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class FilePicMesProgressTextView extends MessageProgressTextView {
    static IPatchRedirector $redirector_;
    private boolean E;
    int F;
    int G;
    public boolean H;

    @Override // com.tencent.mobileqq.customviews.MessageProgressTextView
    public void setDisplayInTextView(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.H = z16;
        this.F = i3;
        this.G = i16;
    }

    @Override // com.tencent.mobileqq.customviews.MessageProgressTextView
    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.E && this.H) {
            setText(i3 + "%");
        } else {
            setText("");
        }
        Drawable background = getBackground();
        if (background != null) {
            background.setLevel((100 - i3) * 100);
            if ((background instanceof a) && !this.H) {
                ((a) background).a(this.F, this.G);
            }
        }
    }
}
