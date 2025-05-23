package com.tencent.timi.game.team.impl.setting.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VerticalNestedScrollView extends NestedScrollView {

    /* renamed from: d, reason: collision with root package name */
    private float f379670d;

    /* renamed from: e, reason: collision with root package name */
    private float f379671e;

    /* renamed from: f, reason: collision with root package name */
    private float f379672f;

    /* renamed from: h, reason: collision with root package name */
    private float f379673h;

    public VerticalNestedScrollView(@NonNull Context context) {
        super(context);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                this.f379670d += Math.abs(x16 - this.f379672f);
                float abs = this.f379671e + Math.abs(y16 - this.f379673h);
                this.f379671e = abs;
                this.f379672f = x16;
                this.f379673h = y16;
                if (this.f379670d > abs) {
                    return false;
                }
            }
        } else {
            this.f379671e = 0.0f;
            this.f379670d = 0.0f;
            this.f379672f = motionEvent.getX();
            this.f379673h = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public VerticalNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerticalNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
