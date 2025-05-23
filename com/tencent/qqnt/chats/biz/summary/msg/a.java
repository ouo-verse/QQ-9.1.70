package com.tencent.qqnt.chats.biz.summary.msg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f354407a;

    /* renamed from: b, reason: collision with root package name */
    public int f354408b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f354409c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f354410d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f354411e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f354412f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f354413g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.chats.biz.summary.msg.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static class C9569a extends ImageSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f354414d;

        public C9569a(Drawable drawable, int i3) {
            super(drawable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, i3);
            } else {
                this.f354414d = i3;
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
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int i26 = (int) ((i19 - drawable.getBounds().bottom) - (fontMetrics.bottom - fontMetrics.descent));
            canvas.save();
            canvas.translate(f16, i26);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
            }
            return super.getSize(paint, charSequence, i3, i16, fontMetricsInt) + this.f354414d;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageSpan a(@NonNull Resources resources, @NonNull Drawable drawable) {
        return new C9569a(drawable, (int) (resources.getDisplayMetrics().scaledDensity * 2.0f));
    }

    static ImageSpan b(@NonNull Resources resources, int i3) {
        Drawable c16 = c(resources, i3);
        if (c16 != null) {
            return a(resources, c16);
        }
        return null;
    }

    public static Drawable c(@NonNull Resources resources, int i3) {
        Drawable drawable;
        try {
            if (i3 == 2) {
                drawable = resources.getDrawable(R.drawable.bwe);
            } else if (i3 == 1) {
                drawable = resources.getDrawable(R.drawable.bwf);
            } else {
                drawable = null;
            }
            if (drawable == null) {
                return null;
            }
            int i16 = (int) (resources.getDisplayMetrics().scaledDensity * 16.0f);
            drawable.setBounds(0, 0, i16, i16);
            return drawable;
        } catch (Exception e16) {
            QLog.i("MsgSummary", 1, e16.toString());
            return null;
        }
    }

    public CharSequence d(Context context) {
        Resources resources;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        if (context == null || (resources = context.getResources()) == null) {
            return "";
        }
        if (this.f354412f && !TextUtils.isEmpty(this.f354413g)) {
            return this.f354413g;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(this.f354407a)) {
            spannableStringBuilder.append(this.f354407a);
            spannableStringBuilder.append((CharSequence) MsgSummary.STR_COLON);
        }
        if (!TextUtils.isEmpty(this.f354409c)) {
            spannableStringBuilder.append(this.f354409c);
        }
        int length = spannableStringBuilder.length();
        int i16 = this.f354408b;
        if (i16 == 2) {
            spannableStringBuilder.append((CharSequence) MsgSummary.STR_FAILED);
            i3 = spannableStringBuilder.length();
        } else if (i16 == 1) {
            spannableStringBuilder.append((CharSequence) MsgSummary.STR_SENDING);
            i3 = spannableStringBuilder.length();
        } else {
            i3 = 0;
        }
        if (!TextUtils.isEmpty(this.f354410d)) {
            spannableStringBuilder.append(this.f354410d);
        }
        CharSequence charSequence = this.f354411e;
        if (charSequence != null) {
            spannableStringBuilder.append(charSequence);
        }
        ImageSpan b16 = b(resources, this.f354408b);
        if (b16 != null) {
            spannableStringBuilder.setSpan(b16, length, i3, 33);
        }
        return spannableStringBuilder;
    }
}
