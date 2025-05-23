package com.tencent.biz.videostory.widget.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.util.co;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SquareRoundFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private Path f97244d;

    public SquareRoundFrameLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    private void a() {
        this.f97244d = new Path();
        setWillNotDraw(false);
        b();
    }

    private void b() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, new co.b(getResources().getColor(com.tencent.mobileqq.R.color.f156815c4), getWidth(), getHeight()));
        stateListDrawable.addState(new int[0], new ColorDrawable(0));
        setForeground(stateListDrawable);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            canvas.save();
            canvas.clipPath(this.f97244d);
            super.onDraw(canvas);
            canvas.restore();
        } catch (Exception unused) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != 0 && i16 != 0) {
            if (i3 != i17 || i16 != i18) {
                this.f97244d = co.b(i3, i16);
            }
        }
    }

    public SquareRoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareRoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
