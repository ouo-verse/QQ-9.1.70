package com.tencent.qqnt.graytips.imagespan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes24.dex */
public class UrlCenterImageSpan extends ImageSpan implements com.tencent.qqnt.graytips.span.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f356866d;

    /* renamed from: e, reason: collision with root package name */
    private int f356867e;

    /* renamed from: f, reason: collision with root package name */
    private URLDrawable f356868f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable.Callback f356869h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UrlCenterImageSpan.this);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UrlCenterImageSpan", 2, "onLoadSuccessed() called with: urlDrawable = [" + uRLDrawable + "]");
            }
            Drawable.Callback callback = uRLDrawable.getCallback();
            if (callback instanceof TextView) {
                TextView textView = (TextView) callback;
                textView.setText(textView.getText());
            }
        }
    }

    public UrlCenterImageSpan(Context context, int i3, String str) {
        super(context, i3, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), str);
        } else {
            this.f356867e = 0;
            this.f356866d = str;
        }
    }

    private void c(Drawable drawable, int i3) {
        if ((drawable instanceof URLDrawable) && ((URLDrawable) drawable).getStatus() == 1) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i16 = this.f356867e;
            if (i16 > 0 && intrinsicHeight > 0 && intrinsicWidth > 0 && i16 != intrinsicHeight) {
                this.f356868f.setBounds(0, 0, Math.max((intrinsicWidth * i16) / intrinsicHeight, 0), Math.max(i16, 0));
            } else {
                drawable.setBounds(0, 0, (int) (((i3 * 1.0f) / (drawable.getIntrinsicHeight() / 2)) * (drawable.getIntrinsicWidth() / 2)), i3);
            }
        }
    }

    @Override // com.tencent.qqnt.graytips.span.b
    public void a(Drawable.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
        } else {
            this.f356869h = callback;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        c(drawable, fontMetricsInt.bottom - fontMetricsInt.top);
        canvas.save();
        canvas.translate(f16, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17);
        drawable.draw(canvas);
        canvas.restore();
        String str = this.f356866d;
        if (str != null) {
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || this.f356866d.endsWith(".apng")) {
                Drawable.Callback callback = drawable.getCallback();
                if (callback instanceof View) {
                    ((View) callback).invalidate();
                }
            }
        }
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    @Nullable
    public Drawable getDrawable() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (TextUtils.isEmpty(this.f356866d)) {
            return super.getDrawable();
        }
        URLDrawable uRLDrawable = this.f356868f;
        if (uRLDrawable == null) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                if (this.f356866d.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                    obtain.mPlayGifImage = true;
                } else if (this.f356866d.endsWith(".apng")) {
                    obtain.mUseApngImage = true;
                }
                this.f356868f = URLDrawable.getDrawable(this.f356866d, obtain);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("UrlCenterImageSpan.getDrawable. url:");
                    sb5.append(this.f356866d);
                    sb5.append(" drawable:");
                    if (this.f356868f != null) {
                        str = this.f356868f.getIntrinsicWidth() + "";
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, sb5.toString());
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.graytips.imagespan.UrlCenterImageSpan.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UrlCenterImageSpan.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (UrlCenterImageSpan.this.f356868f != null && UrlCenterImageSpan.this.f356868f.getStatus() != 1) {
                            UrlCenterImageSpan.this.f356868f.downloadImediatly();
                            if (QLog.isColorLevel()) {
                                QLog.i("UrlCenterImageSpan", 2, "[getDrawable]: startDownload, url is " + UrlCenterImageSpan.this.f356866d);
                            }
                        }
                    }
                }, 128, null, true);
                return this.f356868f;
            } catch (Exception e16) {
                this.f356868f = null;
                QLog.e("UrlCenterImageSpan", 2, "getDrawable error: " + e16.getMessage());
                return super.getDrawable();
            }
        }
        if (uRLDrawable.getStatus() != 1) {
            this.f356868f.setCallback(this.f356869h);
            this.f356868f.setURLDrawableListener(new a());
        }
        return this.f356868f;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("UrlCenterImageSpan", 4, "[getSize]: drawable is null, size is 0, imageUrl is " + this.f356866d);
            }
            return 0;
        }
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
        c(drawable, i17);
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
        return bounds.right;
    }

    public UrlCenterImageSpan(Context context, int i3, String str, int i16) {
        super(context, i3, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), str, Integer.valueOf(i16));
        } else {
            this.f356866d = str;
            this.f356867e = i16;
        }
    }
}
