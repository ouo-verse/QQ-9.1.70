package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSlideConflictView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f90474d;

    public QFSSlideConflictView(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                parent.requestDisallowInterceptTouchEvent(this.f90474d);
            }
        } else {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setDisallowParentInterceptTouchEvent(boolean z16) {
        this.f90474d = z16;
    }

    public QFSSlideConflictView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSlideConflictView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
