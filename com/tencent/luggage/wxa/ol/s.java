package com.tencent.luggage.wxa.ol;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.ro.b;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s extends com.tencent.luggage.wxa.ro.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b extends com.tencent.luggage.wxa.qo.a {

        /* renamed from: d, reason: collision with root package name */
        public final int f136930d;

        /* renamed from: e, reason: collision with root package name */
        public final a.EnumC6654a f136931e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.a f136933a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f136934b;

            public a(b.a aVar, String str) {
                this.f136933a = aVar;
                this.f136934b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f136933a.a(this.f136934b);
            }
        }

        public b(int i3, a.EnumC6654a enumC6654a) {
            super(i3, enumC6654a);
            this.f136930d = i3;
            this.f136931e = enumC6654a;
        }

        @Override // com.tencent.luggage.wxa.qo.a, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            EditText editText;
            String str;
            StringBuilder sb5 = new StringBuilder();
            boolean z16 = false;
            sb5.append(spanned.subSequence(0, i17).toString());
            sb5.append(spanned.subSequence(i18, spanned.length()).toString());
            int a16 = com.tencent.luggage.wxa.qo.a.a(sb5.toString(), this.f136931e) + com.tencent.luggage.wxa.qo.a.a(charSequence.subSequence(i3, i16).toString(), this.f136931e);
            int i19 = this.f136930d;
            if (a16 > i19) {
                z16 = true;
            }
            if (z16) {
                charSequence = charSequence.subSequence(i3, Math.max(i3, Math.min(i19 - (spanned.length() - (i18 - i17)), i16)));
            }
            if (z16 && com.tencent.luggage.wxa.tn.w0.a(charSequence)) {
                if (s.this.f139898c == null) {
                    editText = null;
                } else {
                    editText = (EditText) s.this.f139898c.get();
                }
                b.a aVar = s.this.f139904i;
                if (editText != null && aVar != null) {
                    if (editText.getText() != null) {
                        str = editText.getText().toString();
                    } else {
                        str = "";
                    }
                    editText.post(new a(aVar, str));
                }
            }
            return charSequence;
        }
    }

    public s(WeakReference weakReference) {
        super(weakReference);
    }

    public static s a(EditText editText) {
        return new s(new WeakReference(editText));
    }

    @Override // com.tencent.luggage.wxa.ro.b
    public com.tencent.luggage.wxa.qo.a a(int i3, a.EnumC6654a enumC6654a) {
        return new b(i3, enumC6654a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a implements b.a {
        @Override // com.tencent.luggage.wxa.ro.b.a
        public void b(String str) {
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void c(String str) {
        }
    }
}
