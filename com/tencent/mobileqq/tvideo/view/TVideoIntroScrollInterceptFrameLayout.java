package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoIntroScrollInterceptFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f304786d;

    public TVideoIntroScrollInterceptFrameLayout(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        setOnClickListener(null);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return this.f304786d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f304786d) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public TVideoIntroScrollInterceptFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TVideoIntroScrollInterceptFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
