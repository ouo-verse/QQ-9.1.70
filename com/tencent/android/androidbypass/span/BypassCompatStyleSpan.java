package com.tencent.android.androidbypass.span;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BypassCompatStyleSpan extends StyleSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f72427f;

    /* renamed from: d, reason: collision with root package name */
    private final int f72428d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f72429e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f72427f = new String[]{"oppo", CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO};
        }
    }

    public BypassCompatStyleSpan(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f72428d = i3;
            this.f72429e = b();
        }
    }

    private static void a(Paint paint, int i3) {
        Typeface defaultFromStyle = Typeface.defaultFromStyle(i3);
        int style = defaultFromStyle.getStyle();
        int i16 = (i3 | style) & (~style);
        if ((i16 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i16 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(defaultFromStyle);
    }

    private static boolean b() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            for (String str2 : f72427f) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) textPaint);
        } else if (this.f72429e) {
            a(textPaint, this.f72428d);
        } else {
            super.updateDrawState(textPaint);
        }
    }

    @Override // android.text.style.StyleSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NonNull TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
        } else if (this.f72429e) {
            a(textPaint, this.f72428d);
        } else {
            super.updateMeasureState(textPaint);
        }
    }
}
