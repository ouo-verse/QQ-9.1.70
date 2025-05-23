package com.tencent.mobileqq.troop.file.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes35.dex */
public class ChildPressEffectRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    List<View> f295691d;

    public ChildPressEffectRelativeLayout(Context context) {
        super(context);
        this.f295691d = new ArrayList();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (isPressed()) {
            Iterator<View> it = this.f295691d.iterator();
            while (it.hasNext()) {
                it.next().setPressed(false);
            }
        }
        super.drawableStateChanged();
    }

    public ChildPressEffectRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f295691d = new ArrayList();
    }

    @Override // android.view.View
    public void setPressed(boolean z16) {
        if (z16) {
            Iterator<View> it = this.f295691d.iterator();
            while (it.hasNext()) {
                it.next().setPressed(false);
            }
        }
        super.setPressed(z16);
    }

    public ChildPressEffectRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f295691d = new ArrayList();
    }
}
