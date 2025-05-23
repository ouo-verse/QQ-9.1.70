package com.tencent.luggage.wxa.wk;

import android.text.Editable;
import android.text.Html;
import com.tencent.luggage.wxa.wk.d;
import org.xml.sax.XMLReader;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Html.TagHandler {

    /* renamed from: a, reason: collision with root package name */
    public d.a f144285a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f144286b;

    public c(d.a aVar, boolean z16) {
        this.f144285a = aVar;
        this.f144286b = z16;
    }

    public final Object a(Editable editable, Class cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        for (int length = spans.length; length > 0; length--) {
            int i3 = length - 1;
            if (editable.getSpanFlags(spans[i3]) == 17) {
                return spans[i3];
            }
        }
        return null;
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean z16, String str, Editable editable, XMLReader xMLReader) {
        if ("a".equalsIgnoreCase(str)) {
            if (z16) {
                int length = editable.length();
                editable.setSpan(new a("", this.f144285a, this.f144286b), length, length, 17);
                return;
            }
            int length2 = editable.length();
            a aVar = (a) a(editable, a.class);
            int spanStart = editable.getSpanStart(aVar);
            String charSequence = editable.subSequence(spanStart, length2).toString();
            editable.removeSpan(aVar);
            if (spanStart != length2) {
                editable.setSpan(new a(charSequence, this.f144285a, this.f144286b), spanStart, length2, 33);
            }
        }
    }
}
