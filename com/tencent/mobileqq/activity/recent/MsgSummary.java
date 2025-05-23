package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation$ParcelObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@ParcelAnnotation$ParcelObject
/* loaded from: classes10.dex */
public class MsgSummary {
    static IPatchRedirector $redirector_ = null;
    public static final int EMOJI_DEFAULT = 0;
    public static final int EMOJI_HAS = 1;
    static final int ICON_MARGIN = 2;
    public static final int STATE_DEFAULT = 0;
    public static final int STATE_FAILED = 2;
    static final int STATE_ICON_SIZE = 16;
    public static final int STATE_SENDING = 1;
    public static final String STR_COLON = ": ";
    public static final String STR_FAILED = "F ";
    public static final String STR_SENDING = "S ";
    public boolean bShowDraft;
    public CharSequence mDraft;
    public int mEmojiFlag;
    public int nState;
    public CharSequence prefixOfContent;
    public CharSequence strContent;
    public CharSequence strPrefix;
    public CharSequence suffix;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends ImageSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f185150d;

        public a(Drawable drawable, int i3) {
            super(drawable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, i3);
            } else {
                this.f185150d = i3;
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
            return super.getSize(paint, charSequence, i3, i16, fontMetricsInt) + this.f185150d;
        }
    }

    public MsgSummary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static ImageSpan a(@NonNull Resources resources, @NonNull Drawable drawable) {
        return new a(drawable, (int) (resources.getDisplayMetrics().scaledDensity * 2.0f));
    }

    static ImageSpan b(@NonNull Resources resources, int i3) {
        Drawable c16 = c(resources, i3);
        if (c16 != null) {
            return a(resources, c16);
        }
        return null;
    }

    static Drawable c(@NonNull Resources resources, int i3) {
        Drawable drawable;
        try {
            if (i3 == 2) {
                drawable = resources.getDrawable(com.tencent.mobileqq.imcore.proxy.d.f238032a);
            } else if (i3 == 1) {
                drawable = resources.getDrawable(com.tencent.mobileqq.imcore.proxy.d.f238033b);
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
            QLog.i("Q.recent", 1, e16.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x006a A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #0 {Exception -> 0x0072, blocks: (B:45:0x003a, B:47:0x0042, B:48:0x004b, B:50:0x0053, B:51:0x005a, B:53:0x005e, B:54:0x0064, B:56:0x006a), top: B:44:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence d(Context context) {
        Resources resources;
        int i3;
        int i16;
        ImageSpan b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        if (context == null || (resources = context.getResources()) == null) {
            return "";
        }
        if (this.bShowDraft && !TextUtils.isEmpty(this.mDraft)) {
            return this.mDraft;
        }
        int i17 = 0;
        if (this.strContent instanceof Spannable) {
            try {
                if (!TextUtils.isEmpty(this.strPrefix)) {
                    i3 = this.strPrefix.length() + 2;
                } else {
                    i3 = 0;
                }
                if (!TextUtils.isEmpty(this.prefixOfContent)) {
                    i3 += this.prefixOfContent.length();
                }
                i16 = this.nState;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.recent", 2, e16.toString());
                }
            }
            if (i16 != 2) {
                if (i16 == 1) {
                }
                b16 = b(resources, i16);
                if (b16 != null) {
                    ((Spannable) this.strContent).setSpan(b16, i3, i17, 33);
                }
                return this.strContent;
            }
            i17 = i3 + 2;
            b16 = b(resources, i16);
            if (b16 != null) {
            }
            return this.strContent;
        }
        StringBuffer stringBuffer = new StringBuffer(40);
        if (!TextUtils.isEmpty(this.strPrefix)) {
            stringBuffer.append(this.strPrefix);
            stringBuffer.append(STR_COLON);
        }
        if (!TextUtils.isEmpty(this.prefixOfContent)) {
            stringBuffer.append(this.prefixOfContent);
        }
        int length = stringBuffer.length();
        int i18 = this.nState;
        if (i18 == 2) {
            stringBuffer.append(STR_FAILED);
            i17 = stringBuffer.length();
        } else if (i18 == 1) {
            stringBuffer.append(STR_SENDING);
            i17 = stringBuffer.length();
        }
        if (!TextUtils.isEmpty(this.strContent)) {
            stringBuffer.append(this.strContent);
        }
        CharSequence charSequence = this.suffix;
        if (charSequence != null) {
            stringBuffer.append(charSequence);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuffer.toString());
        ImageSpan b17 = b(resources, this.nState);
        if (b17 != null) {
            spannableStringBuilder.setSpan(b17, length, i17, 33);
        }
        return spannableStringBuilder;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.strPrefix = null;
        this.nState = 0;
        this.prefixOfContent = null;
        this.strContent = null;
        this.suffix = null;
        this.mEmojiFlag = 0;
        this.bShowDraft = false;
        this.mDraft = null;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(this.strPrefix);
        sb5.append(";");
        sb5.append(this.nState);
        sb5.append(";");
        sb5.append(this.strContent);
        sb5.append(";");
        sb5.append(this.suffix);
        sb5.append(";");
        sb5.append(this.mEmojiFlag);
        sb5.append(";");
        sb5.append(this.bShowDraft);
        sb5.append(";");
        sb5.append(this.mDraft);
        return sb5.toString();
    }
}
