package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.jl.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMFormVerifyCodeInputView extends LinearLayout {
    public View.OnClickListener C;

    /* renamed from: a, reason: collision with root package name */
    public Context f152238a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152239b;

    /* renamed from: c, reason: collision with root package name */
    public EditText f152240c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f152241d;

    /* renamed from: e, reason: collision with root package name */
    public Button f152242e;

    /* renamed from: f, reason: collision with root package name */
    public int f152243f;

    /* renamed from: g, reason: collision with root package name */
    public int f152244g;

    /* renamed from: h, reason: collision with root package name */
    public int f152245h;

    /* renamed from: i, reason: collision with root package name */
    public int f152246i;

    /* renamed from: j, reason: collision with root package name */
    public int f152247j;

    /* renamed from: k, reason: collision with root package name */
    public int f152248k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f152249l;

    /* renamed from: m, reason: collision with root package name */
    public View.OnFocusChangeListener f152250m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (view == MMFormVerifyCodeInputView.this.f152240c) {
                MMFormVerifyCodeInputView.this.b();
                if (z16) {
                    MMFormVerifyCodeInputView.this.setBackgroundResource(R.drawable.oja);
                } else {
                    MMFormVerifyCodeInputView.this.setBackgroundResource(R.drawable.ojb);
                }
                MMFormVerifyCodeInputView.this.c();
            }
            if (MMFormVerifyCodeInputView.this.f152250m != null) {
                MMFormVerifyCodeInputView.this.f152250m.onFocusChange(view, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MMFormVerifyCodeInputView.this.C != null) {
                MMFormVerifyCodeInputView.this.C.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.f152238a = null;
        this.f152243f = -1;
        this.f152244g = -1;
        this.f152245h = -1;
        this.f152246i = -1;
        this.f152247j = 60;
        this.f152248k = 60;
        this.f152250m = null;
        this.C = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.FormItemView, i3, 0);
        this.f152244g = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.FormItemView_form_hint, -1);
        this.f152243f = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.FormItemView_form_title, -1);
        this.f152245h = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.FormItemView_form_btn_title, -1);
        this.f152246i = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.FormItemView_form_layout, this.f152246i);
        obtainStyledAttributes.recycle();
        View.inflate(context, this.f152246i, this);
        a(context);
    }

    public EditText getContentEditText() {
        return this.f152240c;
    }

    public Editable getText() {
        EditText editText = this.f152240c;
        if (editText != null) {
            return editText.getText();
        }
        w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "contentET is null!");
        return null;
    }

    public TextView getTitleTextView() {
        return this.f152239b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public void setFocusListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f152250m = onFocusChangeListener;
    }

    public void setHint(String str) {
        EditText editText = this.f152240c;
        if (editText != null) {
            editText.setHint(str);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setImeOption(int i3) {
        EditText editText = this.f152240c;
        if (editText != null) {
            editText.setImeOptions(i3);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setInputType(int i3) {
        EditText editText = this.f152240c;
        if (editText != null) {
            editText.setInputType(i3);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setSendSmsBtnClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void setSmsBtnText(int i3) {
        Button button = this.f152242e;
        if (button != null) {
            button.setText(i3);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        }
    }

    public void setText(String str) {
        EditText editText = this.f152240c;
        if (editText != null) {
            editText.setText(str);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f152239b;
        if (textView != null) {
            textView.setText(str);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "titleTV is null!");
        }
    }

    public final void a(Context context) {
        this.f152238a = context;
    }

    public final void b() {
        this.f152249l = new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    public final void c() {
        int[] iArr = this.f152249l;
        if (iArr != null) {
            setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }

    public final void a() {
        this.f152239b = (TextView) findViewById(R.id.title);
        this.f152240c = (EditText) findViewById(R.id.btq);
        this.f152241d = (TextView) findViewById(R.id.f97575kr);
        Button button = (Button) findViewById(R.id.f83194ix);
        this.f152242e = button;
        TextView textView = this.f152239b;
        if (textView == null || this.f152240c == null || this.f152241d == null || button == null) {
            w.h("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", textView, this.f152240c, this.f152241d, button);
        } else {
            int i3 = this.f152243f;
            if (i3 != -1) {
                textView.setText(i3);
            }
            int i16 = this.f152244g;
            if (i16 != -1) {
                this.f152240c.setHint(i16);
            }
            int i17 = this.f152245h;
            if (i17 != -1) {
                this.f152242e.setText(i17);
            }
        }
        if (this.f152240c != null) {
            this.f152240c.setOnFocusChangeListener(new a());
        }
        Button button2 = this.f152242e;
        if (button2 != null) {
            c.a(button2, null, null, false, null, null, null, null, null, null, null, null, Integer.valueOf(R.dimen.bh9));
            this.f152242e.setOnClickListener(new b());
        }
    }

    public void setHint(int i3) {
        EditText editText = this.f152240c;
        if (editText != null) {
            editText.setHint(i3);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setSmsBtnText(String str) {
        Button button = this.f152242e;
        if (button != null) {
            button.setText(str);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        }
    }

    public void setTitle(int i3) {
        TextView textView = this.f152239b;
        if (textView != null) {
            textView.setText(i3);
        } else {
            w.b("MicroMsg.AppBrand.MMFormVerifyCodeInputView", "titleTV is null!");
        }
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMFormVerifyCodeInputView(Context context) {
        super(context);
        this.f152238a = null;
        this.f152243f = -1;
        this.f152244g = -1;
        this.f152245h = -1;
        this.f152246i = -1;
        this.f152247j = 60;
        this.f152248k = 60;
        this.f152250m = null;
        this.C = null;
        a(context);
    }
}
