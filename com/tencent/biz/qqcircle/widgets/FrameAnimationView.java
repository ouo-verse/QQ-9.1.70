package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FrameAnimationView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private Handler f92883d;

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92883d = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f92883d.removeCallbacksAndMessages(null);
        if (getBackground() instanceof QQAnimationDrawable) {
            QQAnimationDrawable qQAnimationDrawable = (QQAnimationDrawable) getBackground();
            if (qQAnimationDrawable.isRunning()) {
                qQAnimationDrawable.stop();
            }
        }
        if (getDrawable() instanceof QQAnimationDrawable) {
            QQAnimationDrawable qQAnimationDrawable2 = (QQAnimationDrawable) getDrawable();
            if (qQAnimationDrawable2.isRunning()) {
                qQAnimationDrawable2.run();
            }
        }
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrameAnimationView(Context context) {
        this(context, null);
    }
}
