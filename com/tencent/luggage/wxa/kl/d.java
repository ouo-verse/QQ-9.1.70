package com.tencent.luggage.wxa.kl;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.il.d implements g.b {
    public int G;
    public boolean H;
    public int I;
    public boolean J;
    public Integer K;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class a extends ColorDrawable {
        public a(int i3) {
            super(i3);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
            super.setAlpha(i3);
            a();
        }

        @Override // android.graphics.drawable.ColorDrawable
        public void setColor(int i3) {
            super.setColor(i3);
            a();
        }

        public final void a() {
            d.this.setStatusBarColor(getColor());
        }
    }

    public d(@NonNull Context context) {
        super(context);
        this.G = 0;
        this.H = false;
        this.J = true;
        this.K = null;
    }

    private i getActionBar() {
        if (getChildCount() <= 0) {
            return null;
        }
        return (i) getChildAt(0);
    }

    public final boolean a(View view) {
        return view instanceof i;
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return false;
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchSystemUiVisibilityChanged(int i3) {
        super.dispatchSystemUiVisibilityChanged(i3);
        if (this.J && ViewCompat.isAttachedToWindow(this) && DrawStatusBarFrameLayout.E && (getWindowSystemUiVisibility() & 4) == 0) {
            w.a("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", Integer.valueOf(hashCode()));
            m();
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void m() {
        w.a("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] isLayoutFrozen[%b]", Integer.valueOf(hashCode()), Integer.valueOf(this.G), Boolean.valueOf(this.H), Boolean.valueOf(this.J), Boolean.valueOf(i()));
        super.g();
        a(this.G, this.H);
    }

    @Override // com.tencent.luggage.wxa.xd.g.b
    public void onBackground() {
        setActuallyVisible(false);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (a(view)) {
            if (view.getBackground() instanceof ColorDrawable) {
                a aVar = new a(((ColorDrawable) view.getBackground()).getColor());
                view.setBackground(aVar);
                aVar.a();
                return;
            }
            view.setBackground(new a(0));
            return;
        }
        throw new IllegalAccessError("Cant add non ActionBar instance here");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (a(view) && (view.getBackground() instanceof a)) {
            view.setBackground(new ColorDrawable(((a) view.getBackground()).getColor()));
        }
    }

    public void setActuallyVisible(boolean z16) {
        boolean z17;
        if (z16 != this.J) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.J = z16;
        if (z17 && z16) {
            setDeferStatusBarHeightChange(false);
            m();
            setWillNotDraw(false);
        }
        if (z17 && !z16) {
            setDeferStatusBarHeightChange(true);
        }
    }

    public void setDeferStatusBarHeightChange(boolean z16) {
        super.setLayoutFrozen(z16);
    }

    public void setForceTopInsetsHeight(int i3) {
        this.K = Integer.valueOf(i3);
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout
    public void setStatusBarColor(int i3) {
        a(i3, this.H);
    }

    public void setStatusBarForegroundStyle(boolean z16) {
        if (getActionBar() == null) {
            return;
        }
        a(getActionBar().getBackgroundColor(), z16);
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout
    public void a(int i3, boolean z16) {
        this.G = i3;
        this.H = z16;
        if (!this.J) {
            super.a(i3, z16, false);
        } else {
            super.a(i3, z16, true);
        }
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, com.tencent.mm.ui.statusbar.a.d
    public void a(int i3) {
        w.d("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = " + i3);
        Integer num = this.K;
        if (num != null) {
            int intValue = num.intValue();
            this.I = intValue;
            super.a(intValue);
        } else {
            this.I = i3;
            if (i()) {
                return;
            }
            super.a(i3);
        }
    }

    public void a(Context context) {
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        if (this.K != null) {
            a(0);
        }
    }
}
