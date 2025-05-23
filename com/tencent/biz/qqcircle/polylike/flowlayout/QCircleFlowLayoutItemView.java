package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFlowLayoutItemView extends FrameLayout implements Checkable {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f91597e = {R.attr.state_checked};

    /* renamed from: d, reason: collision with root package name */
    private boolean f91598d;

    public QCircleFlowLayoutItemView(Context context) {
        super(context);
    }

    public View a() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f91598d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f91597e);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        if (this.f91598d != z16) {
            this.f91598d = z16;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f91598d);
    }
}
