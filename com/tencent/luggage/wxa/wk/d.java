package com.tencent.luggage.wxa.wk;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(String str);
    }

    public static CharSequence a(CharSequence charSequence, a aVar, boolean z16) {
        if (!(charSequence instanceof Spannable)) {
            return charSequence;
        }
        Spannable spannable = (Spannable) charSequence;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, charSequence.length(), URLSpan.class);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        for (URLSpan uRLSpan : uRLSpanArr) {
            spannableStringBuilder.removeSpan(uRLSpan);
            spannableStringBuilder.setSpan(new com.tencent.luggage.wxa.wk.a(uRLSpan.getURL(), aVar, z16), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
        }
        return spannableStringBuilder;
    }

    public static CharSequence a(String str, boolean z16, a aVar) {
        return a(Html.fromHtml(str, new b(), new c(aVar, z16)), aVar, z16);
    }
}
