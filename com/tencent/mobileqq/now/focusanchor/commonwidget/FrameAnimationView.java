package com.tencent.mobileqq.now.focusanchor.commonwidget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class FrameAnimationView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f254341d;

    public FrameAnimationView(Context context) {
        super(context);
    }

    public void a() {
        setImageResource(this.f254341d);
        ((AnimationDrawable) getDrawable()).start();
    }

    public void setAnimationRes(int i3) {
        this.f254341d = i3;
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
