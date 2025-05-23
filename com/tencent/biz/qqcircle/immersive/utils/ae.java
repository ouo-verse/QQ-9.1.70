package com.tencent.biz.qqcircle.immersive.utils;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ae {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLSpan f90121d;

        a(URLSpan uRLSpan) {
            this.f90121d = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), this.f90121d.getURL());
        }
    }

    public static CharSequence a(String str) {
        if (str == null) {
            str = "";
        }
        Spanned fromHtml = Html.fromHtml(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            d(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        Matcher matcher = Pattern.compile("href='(.*?)'", 2).matcher(str);
        if (!matcher.find()) {
            return "";
        }
        return matcher.group(1);
    }

    public static void c(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        textView.setLinkTextColor(QCircleSkinHelper.getInstance().getColor(R.color.f157870cl3));
        textView.setAutoLinkMask(1);
        textView.setText(a(str));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private static void d(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        if (spannableStringBuilder != null && uRLSpan != null) {
            spannableStringBuilder.setSpan(new a(uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        }
    }
}
