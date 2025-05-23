package com.tencent.luggage.wxa.ol;

import android.os.Looper;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k0 implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tn.b0 f136805a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136806b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.sl.b f136807c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f136808d = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k0.this.f136807c != null) {
                k0.this.f136807c.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements SpanWatcher {
        public b() {
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i3, int i16) {
            if (a1.a(obj)) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", spannable, obj.getClass().getSimpleName());
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i3, int i16, int i17, int i18) {
            if (a1.a(obj)) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", spannable, obj.getClass().getSimpleName());
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i3, int i16) {
            if (a1.a(obj)) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", spannable, obj.getClass().getSimpleName());
                k0.this.f136805a.b(k0.this.f136808d);
                k0.this.f136805a.a(k0.this.f136808d, 100L);
            }
        }
    }

    public k0(EditText editText) {
        this.f136806b = false;
        this.f136806b = editText.isFocused();
        editText.setOnFocusChangeListener(this);
        this.f136805a = new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper());
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
        this.f136806b = z16;
        if (!z16) {
            this.f136805a.b(this.f136808d);
        }
    }

    public Editable a(Editable editable) {
        editable.setSpan(new b(), 0, editable.length(), 18);
        editable.setSpan(new c(), 0, editable.length(), 18);
        return editable;
    }

    public void a(com.tencent.luggage.wxa.sl.b bVar) {
        this.f136807c = bVar;
    }

    public void a() {
        this.f136805a.b(this.f136808d);
        if (this.f136806b) {
            this.f136808d.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            k0.this.f136805a.b(k0.this.f136808d);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
