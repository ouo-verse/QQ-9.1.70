package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMFormInputView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public Context f152638a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152639b;

    /* renamed from: c, reason: collision with root package name */
    public EditText f152640c;

    /* renamed from: d, reason: collision with root package name */
    public int f152641d;

    /* renamed from: e, reason: collision with root package name */
    public int f152642e;

    /* renamed from: f, reason: collision with root package name */
    public int f152643f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnFocusChangeListener f152644g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (MMFormInputView.this.f152644g != null) {
                MMFormInputView.this.f152644g.onFocusChange(view, z16);
            }
        }
    }

    public MMFormInputView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.f152638a = null;
        this.f152641d = -1;
        this.f152642e = -1;
        this.f152643f = -1;
        this.f152644g = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FormItemView, i3, 0);
        this.f152642e = obtainStyledAttributes.getResourceId(R.styleable.FormItemView_form_hint, -1);
        this.f152641d = obtainStyledAttributes.getResourceId(R.styleable.FormItemView_form_title, -1);
        this.f152643f = obtainStyledAttributes.getResourceId(R.styleable.FormItemView_form_layout, this.f152643f);
        obtainStyledAttributes.recycle();
        View.inflate(context, this.f152643f, this);
        a(context);
    }

    public EditText getContentEditText() {
        return this.f152640c;
    }

    public Editable getText() {
        EditText editText = this.f152640c;
        if (editText != null) {
            return editText.getText();
        }
        n.b("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        return null;
    }

    public TextView getTitleTextView() {
        return this.f152639b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        a();
    }

    public void setFocusListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f152644g = onFocusChangeListener;
    }

    public void setHint(String str) {
        EditText editText = this.f152640c;
        if (editText != null) {
            editText.setHint(str);
        } else {
            n.b("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        }
    }

    public void setImeOption(int i3) {
        EditText editText = this.f152640c;
        if (editText != null) {
            editText.setImeOptions(i3);
        } else {
            n.b("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        }
    }

    public void setInputType(int i3) {
        EditText editText = this.f152640c;
        if (editText != null) {
            editText.setInputType(i3);
        } else {
            n.b("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        }
    }

    public void setText(String str) {
        EditText editText = this.f152640c;
        if (editText != null) {
            editText.setText(str);
        } else {
            n.b("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f152639b;
        if (textView != null) {
            textView.setText(str);
        } else {
            n.b("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
        }
    }

    public final void a(Context context) {
        this.f152638a = context;
    }

    public final void a() {
        this.f152639b = (TextView) findViewById(com.tencent.mobileqq.R.id.title);
        EditText editText = (EditText) findViewById(com.tencent.mobileqq.R.id.btq);
        this.f152640c = editText;
        TextView textView = this.f152639b;
        if (textView != null && editText != null) {
            int i3 = this.f152641d;
            if (i3 != -1) {
                textView.setText(i3);
            }
            int i16 = this.f152642e;
            if (i16 != -1) {
                this.f152640c.setHint(i16);
            }
        } else {
            n.e("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", textView, editText);
        }
        if (this.f152640c != null) {
            this.f152640c.setOnFocusChangeListener(new a());
        }
    }

    public void setHint(int i3) {
        EditText editText = this.f152640c;
        if (editText != null) {
            editText.setHint(i3);
        } else {
            n.b("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        }
    }

    public void setTitle(int i3) {
        TextView textView = this.f152639b;
        if (textView != null) {
            textView.setText(i3);
        } else {
            n.b("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
        }
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMFormInputView(Context context) {
        super(context);
        this.f152638a = null;
        this.f152641d = -1;
        this.f152642e = -1;
        this.f152643f = -1;
        this.f152644g = null;
        a(context);
    }
}
