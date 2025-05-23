package com.tencent.mobileqq.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.utils.r;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class EmoticonSpan extends ReplacementSpan implements IEmoticonSpanRefreshCallback {
    static IPatchRedirector $redirector_ = null;
    public static final int ANIMATION_MASK = Integer.MIN_VALUE;
    public float eBottom;
    public float eLeft;
    public float eRight;
    public float eTop;
    public int emojiType;
    public int index;
    private WeakReference<Drawable> mDrawableRef;
    public volatile boolean mIsAPNG;
    protected ISpanRefreshCallback mSpanCallback;
    protected int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonSpan.this);
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
            } else {
                EmoticonSpan.this.invlidateEmoticonSpan(uRLDrawable);
            }
        }
    }

    public EmoticonSpan(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.index = i3;
        this.size = i16;
        this.emojiType = i17;
    }

    protected Drawable doGetDrwable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.emojiType == 0) {
            Drawable emojiDrawable = QQEmojiUtil.getEmojiDrawable(this.index);
            if (emojiDrawable != null) {
                int i3 = this.size;
                emojiDrawable.setBounds(0, 0, i3, i3);
            }
            return emojiDrawable;
        }
        int i16 = this.index;
        if ((Integer.MIN_VALUE & i16) == 0) {
            Drawable b16 = r.b(i16, false);
            if (b16 != null) {
                int i17 = this.size;
                b16.setBounds(0, 0, i17, i17);
            }
            return b16;
        }
        int i18 = i16 & Integer.MAX_VALUE;
        if (QQSysFaceUtil.isValidFaceId(i18)) {
            if (QQSysFaceUtil.isStaticFace(i18)) {
                Drawable b17 = r.b(i18, false);
                if (b17 != null) {
                    int i19 = this.size;
                    b17.setBounds(0, 0, i19, i19);
                }
                return b17;
            }
            Drawable b18 = r.b(i18, true);
            if (b18 != null) {
                int i26 = this.size;
                b18.setBounds(0, 0, i26, i26);
            }
            return b18;
        }
        return new ColorDrawable();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Paint.FontMetrics fontMetrics;
        float f17;
        float f18;
        float f19;
        float f26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float height = drawable.getBounds().height();
        canvas.save();
        float f27 = i18 - this.size;
        if (paint != null) {
            fontMetrics = paint.getFontMetrics();
        } else {
            fontMetrics = null;
        }
        if (fontMetrics != null) {
            f17 = fontMetrics.top;
            f18 = fontMetrics.bottom;
            f19 = fontMetrics.ascent;
            f26 = fontMetrics.descent;
            float f28 = (int) (((f26 + f19) / 2.0f) - (height / 2.0f));
            fontMetrics.top = f28;
            fontMetrics.ascent = f28;
            float f29 = (int) (height + f28);
            fontMetrics.bottom = f29;
            fontMetrics.descent = f29;
            if (i19 > i18) {
                f27 += f29;
            }
        } else {
            f17 = 0.0f;
            f18 = 0.0f;
            f19 = 0.0f;
            f26 = 0.0f;
        }
        canvas.translate(f16, f27);
        drawable.draw(canvas);
        this.eLeft = f16;
        this.eTop = i17;
        this.eRight = f16 + this.size;
        this.eBottom = i19;
        if (fontMetrics != null) {
            fontMetrics.ascent = f19;
            fontMetrics.descent = f26;
            fontMetrics.top = f17;
            fontMetrics.bottom = f18;
        }
        canvas.restore();
    }

    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getDrawable() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable2 = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        } else {
            drawable = null;
        }
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (this.mIsAPNG && !uRLDrawable.mUseApngImage) {
                if (QLog.isColorLevel()) {
                    QLog.d(QQText.TAG, 2, "getDrawable: change to apng");
                }
                if (drawable2 != null) {
                    Drawable doGetDrwable = doGetDrwable();
                    this.mDrawableRef = new WeakReference<>(doGetDrwable);
                    setDrawableListenerIfNeed(doGetDrwable);
                    return doGetDrwable;
                }
                return drawable2;
            }
        }
        drawable2 = drawable;
        if (drawable2 != null) {
        }
    }

    public int getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return Integer.MAX_VALUE & this.index;
    }

    public Rect getRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Rect) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        int i3 = this.size;
        return new Rect(0, 0, i3, i3);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        if (fontMetricsInt != null && (fontMetricsInt.ascent == 0 || fontMetricsInt.top == 0)) {
            int i17 = -this.size;
            fontMetricsInt.ascent = i17;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i17;
            fontMetricsInt.bottom = 0;
        }
        return this.size;
    }

    protected void invlidateEmoticonSpan(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        } else if (this.mSpanCallback != null && drawable != null) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonSpan", 2, " invlidateEmoticonSpan. ");
            }
            this.mSpanCallback.invalidateDrawable(drawable);
        }
    }

    protected void setDrawableListenerIfNeed(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            return;
        }
        if (this.mSpanCallback != null && (drawable instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() != 1) {
                uRLDrawable.setURLDrawableListener(new a());
            }
        }
    }

    public void setSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.size = i3;
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, i3, i3);
        }
    }

    @Override // com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback
    public void setSpanRefreshCallback(ISpanRefreshCallback iSpanRefreshCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iSpanRefreshCallback);
        } else {
            this.mSpanCallback = iSpanRefreshCallback;
        }
    }
}
