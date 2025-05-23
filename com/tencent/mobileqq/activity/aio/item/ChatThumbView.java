package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ChatThumbView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    public boolean f179327d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f179328e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f179329f;

    public ChatThumbView(Context context) {
        super(context);
        this.f179329f = true;
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        uRLDrawable.setFadeInImage(false);
        if (this.f179327d) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            startAnimation(alphaAnimation);
            invalidate();
            return;
        }
        super.onLoadSuccessed(uRLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (com.tencent.mobileqq.activity.aio.o.f179546a) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            if ((mode == Integer.MIN_VALUE || mode == 1073741824) && size <= 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            if ((mode2 == Integer.MIN_VALUE || mode2 == 1073741824) && size2 <= 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            super.onMeasure(i3, i16);
            return;
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (!this.f179329f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && !this.f179328e && (drawable = getDrawable()) != null) {
                drawable.setColorFilter(null);
                drawable.invalidateSelf();
            }
        } else {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.setColorFilter(com.tencent.mobileqq.activity.aio.o.f179547b);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public ChatThumbView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179329f = true;
    }

    public ChatThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179329f = true;
    }
}
