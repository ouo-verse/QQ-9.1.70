package com.tencent.mobileqq.qqlive.room.multichat.view.seat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatCornerImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static ColorFilter f271817i;

    /* renamed from: d, reason: collision with root package name */
    boolean f271818d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f271819e;

    /* renamed from: f, reason: collision with root package name */
    private Path f271820f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f271821h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f271817i = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public MultiAvChatCornerImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f271818d = false;
        this.f271819e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f271821h = new RectF();
    }

    protected void c(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
        }
    }

    protected void d(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.drawableStateChanged();
        if (!this.f271818d) {
            return;
        }
        int[] drawableState = getDrawableState();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= drawableState.length) {
                break;
            }
            if (drawableState[i3] == 16842919) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (isPressed() | z16) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.setColorFilter(f271817i);
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 != null) {
            drawable2.setColorFilter(null);
            drawable2.invalidateSelf();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (!VersionUtils.isKITKAT()) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.f271820f == null) {
            this.f271820f = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.f271820f;
                RectF rectF = this.f271821h;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, this.f271819e, Path.Direction.CW);
                canvas.clipPath(path);
                d(canvas);
                super.onDraw(canvas);
                c(canvas);
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public void setPressMask(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f271818d = z16;
        }
    }

    public void setRadius(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fArr);
        } else {
            this.f271819e = fArr;
            e();
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f271819e = new float[]{f16, f16, f16, f16, f16, f16, f16, f16};
            e();
        }
    }

    public MultiAvChatCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f271818d = false;
        this.f271819e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f271821h = new RectF();
    }

    public MultiAvChatCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f271818d = false;
        this.f271819e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f271821h = new RectF();
    }
}
