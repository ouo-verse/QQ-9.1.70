package com.tencent.biz.qqcircle.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDrawerOperationsBannerRecyclerView extends RecyclerView {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
    }

    public QFSDrawerOperationsBannerRecyclerView(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        return super.dispatchTouchEvent(motionEvent);
    }

    public QFSDrawerOperationsBannerRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSDrawerOperationsBannerRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setChildTouchEventDelegate(a aVar) {
    }
}
