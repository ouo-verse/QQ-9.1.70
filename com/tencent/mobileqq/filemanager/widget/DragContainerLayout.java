package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.widget.DragView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DragContainerLayout extends DragView {

    /* renamed from: d, reason: collision with root package name */
    private View.OnLongClickListener f209411d;

    public DragContainerLayout(Context context) {
        this(context, null);
    }

    @Override // com.tencent.widget.DragView, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener = this.f209411d;
        if (onLongClickListener != null) {
            onLongClickListener.onLongClick(this);
        }
    }

    public void setContainerLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f209411d = onLongClickListener;
    }

    public DragContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
