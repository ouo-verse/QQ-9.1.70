package com.tencent.mobileqq.app.utils;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f196671d;

        a(AppRuntime appRuntime) {
            this.f196671d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.r(this.f196671d, "dc00898", "", "", "0X800BC3B", "0X800BC3B", 0, 0, "", "", "", "");
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            }
        }
    }

    public static void a(AppRuntime appRuntime, TextView textView, String str, int i3) {
        ReportController.r(appRuntime, "dc00898", "", "", "0X800BC3A", "0X800BC3A", 0, 0, "", "", "", "");
        String str2 = str + "\uff08\u65e0\u7f51\u7edc\uff09";
        float measureText = textView.getPaint().measureText(str2);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i3 = (i3 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        float f16 = i3;
        if (measureText > f16) {
            float measureText2 = textView.getPaint().measureText("...\uff08\u65e0\u7f51\u7edc\uff09");
            while (str.length() != 1) {
                str = str.substring(0, str.length() - 1);
                if (textView.getPaint().measureText(str) + measureText2 <= f16) {
                    str2 = str + "...\uff08\u65e0\u7f51\u7edc\uff09";
                }
            }
            textView.setText(str + "\uff08\u65e0\u7f51\u7edc\uff09");
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        spannableStringBuilder.setSpan(new a(appRuntime), str2.length() - 5, str2.length(), 34);
        textView.setText(spannableStringBuilder);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
