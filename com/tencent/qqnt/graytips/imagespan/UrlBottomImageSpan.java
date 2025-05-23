package com.tencent.qqnt.graytips.imagespan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes24.dex */
public class UrlBottomImageSpan extends ImageSpan implements com.tencent.qqnt.graytips.span.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f356860d;

    /* renamed from: e, reason: collision with root package name */
    private URLDrawable f356861e;

    /* renamed from: f, reason: collision with root package name */
    private String f356862f;

    /* renamed from: h, reason: collision with root package name */
    private int f356863h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Drawable.Callback> f356864i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UrlBottomImageSpan.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            } else if (QLog.isColorLevel()) {
                QLog.i("UrlBottomImageSpan", 2, "onLoadCanceled");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else if (QLog.isColorLevel()) {
                QLog.i("UrlBottomImageSpan", 2, "onLoadFialed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            } else if (QLog.isColorLevel()) {
                QLog.i("UrlBottomImageSpan", 2, "onLoadProgressed i:" + i3);
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
                QLog.i("UrlBottomImageSpan", 2, "onLoadSuccessed");
            }
            Drawable.Callback callback = uRLDrawable.getCallback();
            if (callback instanceof TextView) {
                TextView textView = (TextView) callback;
                textView.setText(textView.getText());
            }
        }
    }

    public UrlBottomImageSpan(Context context, int i3, String str) {
        this(context, i3, str, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), str);
    }

    @Override // com.tencent.qqnt.graytips.span.b
    public void a(Drawable.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
        } else if (callback == null) {
            this.f356864i = null;
        } else {
            this.f356864i = new WeakReference<>(callback);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        int i26;
        int i27;
        int i28;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i29 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() == 1) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i26 = drawable.getIntrinsicHeight();
                int i36 = this.f356863h;
                if (i26 > i36 && i36 > 0) {
                    intrinsicWidth = (intrinsicWidth * i36) / i26;
                    i26 = i36;
                }
                URLDrawable uRLDrawable2 = this.f356861e;
                if (intrinsicWidth > 0) {
                    i27 = intrinsicWidth;
                } else {
                    i27 = 0;
                }
                if (i26 > 0) {
                    i28 = i26;
                } else {
                    i28 = 0;
                }
                uRLDrawable2.setBounds(0, 0, i27, i28);
                i29 = intrinsicWidth;
            } else {
                i26 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i("UrlBottomImageSpan", 2, "draw status:" + uRLDrawable.getStatus() + " width:" + i29 + " height:" + i26);
            }
        }
        canvas.save();
        canvas.translate(f16, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    @Nullable
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (TextUtils.isEmpty(this.f356862f)) {
            return super.getDrawable();
        }
        URLDrawable uRLDrawable = this.f356861e;
        Drawable.Callback callback = null;
        boolean z16 = true;
        if (uRLDrawable == null) {
            try {
                this.f356861e = URLDrawable.getDrawable(this.f356862f, URLDrawable.URLDrawableOptions.obtain());
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.graytips.imagespan.UrlBottomImageSpan.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UrlBottomImageSpan.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (UrlBottomImageSpan.this.f356861e != null && UrlBottomImageSpan.this.f356861e.getStatus() != 1) {
                            UrlBottomImageSpan.this.f356861e.downloadImediatly();
                        }
                    }
                }, 128, null, true);
                if (QLog.isColorLevel()) {
                    QLog.i("UrlBottomImageSpan", 2, "getDrawable. startDownload get url:" + this.f356862f);
                }
                return this.f356861e;
            } catch (Throwable th5) {
                this.f356861e = null;
                QLog.e("UrlBottomImageSpan", 2, "getDrawable error: " + th5.getMessage());
                return super.getDrawable();
            }
        }
        if (uRLDrawable.getStatus() != 1) {
            WeakReference<Drawable.Callback> weakReference = this.f356864i;
            if (weakReference != null) {
                callback = weakReference.get();
            }
            if (callback != null) {
                this.f356861e.setCallback(callback);
            }
            this.f356861e.setURLDrawableListener(new a());
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getDrawable. first get url:");
                sb5.append(this.f356862f);
                sb5.append("  cb:");
                if (callback == null) {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i("UrlBottomImageSpan", 2, sb5.toString());
            }
        }
        return this.f356861e;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            if (QLog.isColorLevel()) {
                QLog.i("UrlBottomImageSpan", 2, "[getSize]: drawable is null, size is 0, url is " + this.f356862f);
            }
            return 0;
        }
        if ((drawable instanceof URLDrawable) && ((URLDrawable) drawable).getStatus() == 1) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            i17 = drawable.getIntrinsicHeight();
            int i27 = this.f356863h;
            if (i17 > i27 && i27 > 0) {
                intrinsicWidth = (intrinsicWidth * i27) / i17;
                i17 = i27;
            }
            URLDrawable uRLDrawable = this.f356861e;
            if (intrinsicWidth > 0) {
                i18 = intrinsicWidth;
            } else {
                i18 = 0;
            }
            if (i17 > 0) {
                i19 = i17;
            } else {
                i19 = 0;
            }
            uRLDrawable.setBounds(0, 0, i18, i19);
            i26 = intrinsicWidth;
        } else {
            i17 = 0;
        }
        Rect bounds = drawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i28 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i29 = (bounds.bottom - bounds.top) / 2;
            int i36 = i28 / 4;
            int i37 = i29 - i36;
            int i38 = -(i29 + i36);
            fontMetricsInt.ascent = i38;
            fontMetricsInt.top = i38;
            fontMetricsInt.bottom = i37;
            fontMetricsInt.descent = i37;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UrlBottomImageSpan", 2, "getSize size:" + bounds.right + " width:" + i26 + " height:" + i17 + " imageUrl:" + this.f356862f);
        }
        return bounds.right;
    }

    public UrlBottomImageSpan(Context context, int i3, String str, int i16) {
        super(context, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        this.f356860d = context;
        this.f356862f = str;
        this.f356863h = i16;
    }
}
