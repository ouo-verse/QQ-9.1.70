package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.m;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMClearEditText extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public String f152628a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f152629b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f152630c;

    /* renamed from: d, reason: collision with root package name */
    public int f152631d;

    /* renamed from: e, reason: collision with root package name */
    public View.OnFocusChangeListener f152632e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnTouchListener f152633f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f152634g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (MMClearEditText.this.f152632e != null) {
                MMClearEditText.this.f152632e.onFocusChange(view, z16);
            }
            MMClearEditText.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (MMClearEditText.this.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > (r4.getWidth() - r4.getPaddingRight()) - MMClearEditText.this.f152630c.getIntrinsicWidth()) {
                MMClearEditText.this.b();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
    }

    public MMClearEditText(Context context) {
        super(context);
        this.f152628a = "";
        this.f152629b = false;
        this.f152630c = m.a(getContext(), R.drawable.oj9, getResources().getColor(R.color.aiq));
        this.f152631d = 0;
        this.f152632e = null;
        this.f152633f = new c();
        this.f152634g = false;
        a(context);
    }

    public final void c() {
        if (!getText().toString().equals("") && isFocused()) {
            a();
        } else {
            d();
        }
    }

    public final void d() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public View.OnTouchListener getDefaultOnTouchListener() {
        return this.f152633f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof TextView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        if (!this.f152629b) {
            parcelable = View.BaseSavedState.EMPTY_STATE;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i3);
        if (i3 == 16908322) {
            this.f152631d = 0;
            String obj = getText().toString();
            try {
                a(obj);
            } catch (IndexOutOfBoundsException unused) {
                n.b("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.f152631d));
                if (this.f152631d < 3) {
                    this.f152631d++;
                    a(" " + obj);
                } else {
                    n.b("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
                }
            }
        }
        return onTextContextMenuItem;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f152632e = onFocusChangeListener;
    }

    public final void a(Context context) {
        if (this.f152630c == null) {
            this.f152630c = m.a(getContext(), R.drawable.oj9, getResources().getColor(R.color.aiq));
        }
        Drawable drawable = this.f152630c;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f152630c.getIntrinsicHeight());
        n.a("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.f152630c.getIntrinsicWidth()), Integer.valueOf(this.f152630c.getIntrinsicHeight()));
        c();
        setHeight(this.f152630c.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.blb) * 5));
        setOnTouchListener(this.f152633f);
        addTextChangedListener(new a());
        super.setOnFocusChangeListener(new b());
    }

    public void b() {
        setText("");
        d();
    }

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152628a = "";
        this.f152629b = false;
        this.f152630c = m.a(getContext(), R.drawable.oj9, getResources().getColor(R.color.aiq));
        this.f152631d = 0;
        this.f152632e = null;
        this.f152633f = new c();
        this.f152634g = false;
        a(context);
    }

    public void a(String str) {
        int selectionStart = getSelectionStart();
        setText(com.tencent.luggage.wxa.oo.a.a(getContext(), str));
        int length = getText().length() - str.length();
        if (length > 0) {
            int i3 = selectionStart + length;
            if (i3 <= getText().length()) {
                setSelection(i3);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152628a = "";
        this.f152629b = false;
        this.f152630c = m.a(getContext(), R.drawable.oj9, getResources().getColor(R.color.aiq));
        this.f152631d = 0;
        this.f152632e = null;
        this.f152633f = new c();
        this.f152634g = false;
        a(context);
    }

    public final void a() {
        if (this.f152634g) {
            return;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.f152630c, getCompoundDrawables()[3]);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            MMClearEditText.this.c();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    public void setClearBtnCallBcakListener(d dVar) {
    }

    public void setClearBtnListener(e eVar) {
    }
}
