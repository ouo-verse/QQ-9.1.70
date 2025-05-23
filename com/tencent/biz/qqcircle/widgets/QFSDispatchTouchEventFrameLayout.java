package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSDispatchTouchEventFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f93207d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void onDispatchTouchEvent(MotionEvent motionEvent);
    }

    public QFSDispatchTouchEventFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f93207d;
        if (aVar != null) {
            aVar.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnDispatchListener(a aVar) {
        this.f93207d = aVar;
    }

    public QFSDispatchTouchEventFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSDispatchTouchEventFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
