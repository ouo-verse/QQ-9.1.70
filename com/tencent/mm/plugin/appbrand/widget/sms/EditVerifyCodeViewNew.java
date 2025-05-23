package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EditVerifyCodeViewNew extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public Context f152508a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f152509b;

    /* renamed from: c, reason: collision with root package name */
    public TextView[] f152510c;

    /* renamed from: d, reason: collision with root package name */
    public EditText f152511d;

    /* renamed from: e, reason: collision with root package name */
    public e f152512e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                EditVerifyCodeViewNew.this.b();
            } else {
                EditVerifyCodeViewNew.this.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) EditVerifyCodeViewNew.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                EditVerifyCodeViewNew.this.f152511d.requestFocus();
                inputMethodManager.showSoftInput(EditVerifyCodeViewNew.this.f152511d, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) EditVerifyCodeViewNew.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(EditVerifyCodeViewNew.this.f152511d.getWindowToken(), 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void a(String str);
    }

    public EditVerifyCodeViewNew(Context context) {
        super(context);
        this.f152509b = new StringBuilder();
        this.f152510c = new TextView[6];
        a(context);
    }

    public final void b(Context context) {
        this.f152508a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.e6m, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f164831u03);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f164832u04);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f164833u05);
        TextView textView4 = (TextView) inflate.findViewById(R.id.u06);
        TextView textView5 = (TextView) inflate.findViewById(R.id.u07);
        TextView textView6 = (TextView) inflate.findViewById(R.id.u08);
        TextView[] textViewArr = this.f152510c;
        textViewArr[0] = textView;
        textViewArr[1] = textView2;
        textViewArr[2] = textView3;
        textViewArr[3] = textView4;
        textViewArr[4] = textView5;
        textViewArr[5] = textView6;
        textView.setSelected(true);
        EditText editText = (EditText) inflate.findViewById(R.id.f116556z2);
        this.f152511d = editText;
        editText.addTextChangedListener(new a());
        this.f152511d.setOnFocusChangeListener(new b());
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        this.f152511d.setFocusable(true);
        this.f152511d.setFocusableInTouchMode(true);
        b();
    }

    public EditText getEditText() {
        return this.f152511d;
    }

    public String getText() {
        return this.f152511d.getText().toString();
    }

    public void setCodeEditCompleteListener(e eVar) {
        this.f152512e = eVar;
    }

    public void setText(String str) {
        this.f152511d.setText(str);
    }

    public final void a(Context context) {
        b(context);
    }

    public void a() {
        h.f146825d.a(new d());
    }

    public EditVerifyCodeViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152509b = new StringBuilder();
        this.f152510c = new TextView[6];
        a(context);
    }

    public final void a(String str) {
        e eVar;
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            this.f152510c[i3].setText(String.valueOf(charAt));
            this.f152510c[i3].setSelected(false);
            w.d("MicroMsg.EditVerifyCodeViewNew", "i:%d text:%s", Integer.valueOf(i3), String.valueOf(charAt));
        }
        boolean z16 = true;
        for (int i16 = length; i16 < 6; i16++) {
            w.d("MicroMsg.EditVerifyCodeViewNew", "i:%d text:%s", Integer.valueOf(i16), "");
            this.f152510c[i16].setText("");
            if (z16) {
                this.f152510c[i16].setSelected(true);
                z16 = false;
            } else {
                this.f152510c[i16].setSelected(false);
            }
        }
        if (length != 6 || (eVar = this.f152512e) == null) {
            return;
        }
        eVar.a(str);
    }

    public EditVerifyCodeViewNew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152509b = new StringBuilder();
        this.f152510c = new TextView[6];
        a(context);
    }

    public void b() {
        h.f146825d.a(new c());
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            w.g("MicroMsg.EditVerifyCodeViewNew", "afterTextChanged:%s", editable.toString());
            EditVerifyCodeViewNew.this.a(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
