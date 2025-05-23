package com.tencent.qqnt.aio.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ChatThumbView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f352412h;

    /* renamed from: i, reason: collision with root package name */
    public static ColorFilter f352413i;

    /* renamed from: d, reason: collision with root package name */
    public boolean f352414d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f352415e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f352416f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        "MNC".equals(Build.VERSION.CODENAME);
        f352412h = true;
        f352413i = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
    }

    public ChatThumbView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f352416f = true;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            return;
        }
        uRLDrawable.setFadeInImage(false);
        if (this.f352414d) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            startAnimation(alphaAnimation);
            invalidate();
            return;
        }
        super.onLoadSuccessed(uRLDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (f352412h) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f352416f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && !this.f352415e && (drawable = getDrawable()) != null) {
                drawable.setColorFilter(null);
                drawable.invalidateSelf();
            }
        } else {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.setColorFilter(f352413i);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public ChatThumbView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f352416f = true;
        } else {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    public ChatThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f352416f = true;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
