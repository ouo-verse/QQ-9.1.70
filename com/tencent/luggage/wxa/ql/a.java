package com.tencent.luggage.wxa.ql;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.luggage.wxa.dn.c;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.ql.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f138930a = new C6651a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ql.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6651a implements b {
        @Override // com.tencent.luggage.wxa.ql.b
        public Spannable a(Context context, Spannable spannable, int i3, c cVar, Spannable.Factory factory) {
            return spannable;
        }

        @Override // com.tencent.luggage.wxa.ql.b
        public b.a b(int i3) {
            return null;
        }

        @Override // com.tencent.luggage.wxa.ql.b
        public SpannableString a(Context context, CharSequence charSequence, float f16) {
            if (charSequence == null) {
                return null;
            }
            return new SpannableString(charSequence);
        }
    }

    public static b a() {
        b bVar = (b) g.a(b.class);
        if (bVar == null) {
            return f138930a;
        }
        return bVar;
    }
}
