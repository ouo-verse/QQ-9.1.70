package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class HideOnExceedView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f264156d;

    public HideOnExceedView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f264156d) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        ViewGroup viewGroup = (ViewGroup) getParent();
        this.f264156d = viewGroup != null && (i17 > viewGroup.getWidth() || i18 > viewGroup.getHeight());
    }

    public HideOnExceedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
