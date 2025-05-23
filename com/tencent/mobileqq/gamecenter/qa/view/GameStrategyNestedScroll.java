package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameStrategyNestedScroll extends NestedScrollView {

    /* renamed from: d, reason: collision with root package name */
    private int f212900d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f212901e;

    public GameStrategyNestedScroll(@NonNull Context context) {
        super(context);
        this.f212901e = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
        } catch (Exception e16) {
            QLog.e("GameStrategyNestedScroll", 1, e16, new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1) {
            if (action == 2) {
                if (this.f212901e) {
                    this.f212900d = (int) motionEvent.getY();
                    this.f212901e = false;
                }
                int y16 = ((int) motionEvent.getY()) - this.f212900d;
                if (getScrollY() <= 0 && y16 >= 0) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        this.f212901e = true;
        return super.onTouchEvent(motionEvent);
    }

    public GameStrategyNestedScroll(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f212901e = true;
    }

    public GameStrategyNestedScroll(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f212901e = true;
    }
}
