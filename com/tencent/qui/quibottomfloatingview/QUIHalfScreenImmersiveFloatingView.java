package com.tencent.qui.quibottomfloatingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QUIHalfScreenImmersiveFloatingView extends QUIBaseHalfScreenFloatingView {
    static IPatchRedirector $redirector_;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f363688r0;

    public QUIHalfScreenImmersiveFloatingView(@NonNull Context context) {
        super(context);
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
        if (this.f363668j0 != null && this.N != null) {
            if (this.f363688r0) {
                ud0.d.g("QUIHalfScreenImmersiveFloatingView", ud0.d.f438811e, "not support round corner");
                return view;
            }
            FloatingRoundCorneredLayout floatingRoundCorneredLayout = new FloatingRoundCorneredLayout(getContext());
            floatingRoundCorneredLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            floatingRoundCorneredLayout.addView(view);
            return floatingRoundCorneredLayout;
        }
        return view;
    }

    @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView
    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.N = new FrameLayout(getContext());
        }
    }

    @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView
    protected void m(@Nullable AttributeSet attributeSet, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributeSet, i3);
            return;
        }
        this.M = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        d(attributeSet, i3, layoutParams);
    }

    public void setNotSupportRoundCorner(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f363688r0 = z16;
        }
    }

    @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView
    public void setQUIDragFloatController(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            super.setQUIDragFloatController(bVar);
            this.N.bringChildToFront(this.M);
        }
    }

    public QUIHalfScreenImmersiveFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUIHalfScreenImmersiveFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
