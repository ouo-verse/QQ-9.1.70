package com.tencent.mobileqq.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RotateSwitchImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f316173d;

    public RotateSwitchImageView(Context context) {
        super(context);
    }

    private void a() {
        this.f316173d = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.ROTATION, 0.0f, -90.0f).setDuration(250L);
    }

    public void b() {
        if (this.f316173d == null) {
            a();
        }
        this.f316173d.reverse();
    }

    public void c() {
        if (this.f316173d == null) {
            a();
        }
        this.f316173d.start();
    }

    public RotateSwitchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotateSwitchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
