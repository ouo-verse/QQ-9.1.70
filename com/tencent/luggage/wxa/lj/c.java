package com.tencent.luggage.wxa.lj;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.il.d {
    public int G;

    public c(@NonNull Context context) {
        super(context);
        setClickable(false);
        this.G = 0;
    }

    public void a(Context context) {
        if (getContext() instanceof MutableContextWrapper) {
            if (this.G > 0) {
                setLayoutFrozen(!(context instanceof Activity));
            } else {
                setLayoutFrozen(false);
            }
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
    }

    @Override // com.tencent.luggage.wxa.il.d, com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout
    public void l() {
        super.l();
        super.setWillNotDraw(true);
    }

    @Override // android.view.View
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
        if (getChildCount() == 1) {
            getChildAt(0).cancelPendingInputEvents();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (!a(view)) {
            com.tencent.luggage.wxa.er.a.a("Cant add non CapsuleBar instance here !");
        }
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        super.setAlpha(MathUtils.clamp(f16, 0.0f, 1.0f));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2, 21);
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(false);
        this.G = 0;
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, com.tencent.mm.ui.statusbar.a.d
    public void a(int i3) {
        super.a(i3);
        this.G = i3;
    }

    public final boolean a(View view) {
        return view instanceof h;
    }
}
