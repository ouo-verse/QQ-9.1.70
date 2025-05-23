package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends ImageSpan {
    static IPatchRedirector $redirector_;
    private static String C;

    /* renamed from: d, reason: collision with root package name */
    private String f302148d;

    /* renamed from: e, reason: collision with root package name */
    private int f302149e;

    /* renamed from: f, reason: collision with root package name */
    private URLDrawable f302150f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable.Callback f302151h;

    /* renamed from: i, reason: collision with root package name */
    private int f302152i;

    /* renamed from: m, reason: collision with root package name */
    private int f302153m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QLog.i(c.C, 1, "onLoadSuccess url:" + c.this.f302148d);
                Drawable.Callback callback = uRLDrawable.getCallback();
                if (callback instanceof View) {
                    View view = (View) callback;
                    view.invalidate();
                    view.requestLayout();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            C = "GuildUrlCenterImageSpan";
        }
    }

    public c(Context context, String str, int i3, int i16, int i17) {
        super(context, 0, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f302148d = str;
        this.f302149e = i3;
        this.f302152i = i16;
        this.f302153m = i17;
    }

    public void c(Drawable.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
        } else {
            this.f302151h = callback;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        canvas.save();
        canvas.translate(this.f302152i + f16, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17);
        drawable.draw(canvas);
        canvas.restore();
        String str = this.f302148d;
        if (str != null) {
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || this.f302148d.endsWith(".apng")) {
                Drawable.Callback callback = drawable.getCallback();
                if (callback instanceof View) {
                    ((View) callback).invalidate();
                }
            }
        }
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f302148d != null) {
            URLDrawable uRLDrawable = this.f302150f;
            if (uRLDrawable != null) {
                return uRLDrawable;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int i3 = this.f302149e;
            if (i3 > 0) {
                obtain.mRequestWidth = i3;
                obtain.mRequestHeight = i3;
            }
            if (this.f302148d.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                obtain.mPlayGifImage = true;
            } else if (this.f302148d.endsWith(".apng")) {
                obtain.mUseApngImage = true;
            }
            URLDrawable drawable = URLDrawable.getDrawable(this.f302148d, obtain);
            this.f302150f = drawable;
            if (drawable != null) {
                drawable.setCallback(this.f302151h);
                this.f302150f.setURLDrawableListener(new a());
                URLDrawable uRLDrawable2 = this.f302150f;
                int i16 = this.f302149e;
                uRLDrawable2.setBounds(0, 0, i16, i16);
            }
            return this.f302150f;
        }
        return super.getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 0;
        }
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
        Rect bounds = drawable.getBounds();
        if (fontMetricsInt != null) {
            int i18 = (bounds.bottom - bounds.top) / 2;
            int i19 = i17 / 4;
            int i26 = i18 - i19;
            int i27 = -(i18 + i19);
            fontMetricsInt.ascent = i27;
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
        }
        return this.f302152i + bounds.right + this.f302153m;
    }
}
