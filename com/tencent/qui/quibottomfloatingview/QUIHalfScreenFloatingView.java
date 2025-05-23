package com.tencent.qui.quibottomfloatingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QUIHalfScreenFloatingView extends QUIBaseHalfScreenFloatingView {
    static IPatchRedirector $redirector_;

    public QUIHalfScreenFloatingView(@NonNull Context context) {
        super(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView
    public View j(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        }
        return view;
    }

    @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView
    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.N = linearLayout;
        linearLayout.setOrientation(1);
    }

    @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView
    protected void m(@Nullable AttributeSet attributeSet, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributeSet, i3);
        } else {
            this.M = new FrameLayout(getContext());
            d(attributeSet, i3, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    public void setHeadViewBg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        FrameLayout frameLayout = this.M;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(i3);
        }
    }

    public QUIHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
