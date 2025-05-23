package com.tencent.luggage.wxa.br;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public Context f123118a;

    /* renamed from: b, reason: collision with root package name */
    public int f123119b;

    /* renamed from: c, reason: collision with root package name */
    public TextView[] f123120c;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f123121d;

    /* renamed from: e, reason: collision with root package name */
    public EditText f123122e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.br.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC6086a implements View.OnClickListener {
        public ViewOnClickListenerC6086a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            if (a.this.f123122e == null) {
                return;
            }
            if (view.getId() == a.this.b("tenpay_keyboard_x")) {
                int i16 = a.this.f123119b;
                if (i16 != 1) {
                    if (i16 == 2) {
                        a.this.f123122e.dispatchKeyEvent(new KeyEvent(0, 56));
                        return;
                    }
                    return;
                } else {
                    a.this.f123122e.dispatchKeyEvent(new KeyEvent(0, 59));
                    a.this.f123122e.dispatchKeyEvent(new KeyEvent(0, 52));
                    a.this.f123122e.dispatchKeyEvent(new KeyEvent(1, 59));
                    return;
                }
            }
            if (view.getId() == a.this.b("tenpay_keyboard_1")) {
                i3 = 8;
            } else if (view.getId() == a.this.b("tenpay_keyboard_2")) {
                i3 = 9;
            } else if (view.getId() == a.this.b("tenpay_keyboard_3")) {
                i3 = 10;
            } else if (view.getId() == a.this.b("tenpay_keyboard_4")) {
                i3 = 11;
            } else if (view.getId() == a.this.b("tenpay_keyboard_5")) {
                i3 = 12;
            } else if (view.getId() == a.this.b("tenpay_keyboard_6")) {
                i3 = 13;
            } else if (view.getId() == a.this.b("tenpay_keyboard_7")) {
                i3 = 14;
            } else if (view.getId() == a.this.b("tenpay_keyboard_8")) {
                i3 = 15;
            } else if (view.getId() == a.this.b("tenpay_keyboard_9")) {
                i3 = 16;
            } else if (view.getId() == a.this.b("tenpay_keyboard_0")) {
                i3 = 7;
            } else if (view.getId() == a.this.b("tenpay_keyboard_d")) {
                i3 = 67;
            } else {
                i3 = 0;
            }
            a.this.f123122e.dispatchKeyEvent(new KeyEvent(0, i3));
            a.this.f123122e.dispatchKeyEvent(new KeyEvent(1, i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
    }

    public a(Context context) {
        super(context);
        this.f123119b = 0;
        this.f123120c = new TextView[11];
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c.a();
    }

    public void setInputEditText(EditText editText) {
        if (editText != null) {
            this.f123122e = editText;
            int imeOptions = editText.getImeOptions();
            CharSequence imeActionLabel = this.f123122e.getImeActionLabel();
            if (!TextUtils.isEmpty(imeActionLabel)) {
                this.f123120c[10].setText(imeActionLabel);
            }
            if (imeOptions == 1) {
                this.f123119b = 0;
                if (TextUtils.isEmpty(imeActionLabel)) {
                    this.f123120c[10].setText("");
                }
            }
        }
    }

    public void setSecureAccessibility(View.AccessibilityDelegate accessibilityDelegate) {
        int i3 = 0;
        while (true) {
            TextView[] textViewArr = this.f123120c;
            if (i3 < textViewArr.length) {
                textViewArr[i3].setAccessibilityDelegate(accessibilityDelegate);
                i3++;
            } else {
                this.f123121d.setAccessibilityDelegate(accessibilityDelegate);
                return;
            }
        }
    }

    public void setXMode(int i3) {
        this.f123119b = i3;
        TextView textView = this.f123120c[10];
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f123119b = 0;
                    return;
                } else {
                    textView.setText(".");
                    textView.setBackgroundResource(a("tenpay_keybtn_bottom_new"));
                    return;
                }
            }
            textView.setText("X");
            textView.setBackgroundResource(a("tenpay_keybtn_bottom_new"));
            return;
        }
        textView.setText("");
        textView.setBackgroundResource(a("tenpay_keybtn_bottom_new"));
    }

    public final void a(Context context) {
        this.f123118a = context.getApplicationContext();
        c.a(context);
        View inflate = LayoutInflater.from(context).inflate(this.f123118a.getResources().getIdentifier("tenpay_number_keyboard", TtmlNode.TAG_LAYOUT, this.f123118a.getPackageName()), (ViewGroup) this, true);
        this.f123120c[1] = (TextView) inflate.findViewById(b("tenpay_keyboard_1"));
        this.f123120c[2] = (TextView) inflate.findViewById(b("tenpay_keyboard_2"));
        this.f123120c[3] = (TextView) inflate.findViewById(b("tenpay_keyboard_3"));
        this.f123120c[4] = (TextView) inflate.findViewById(b("tenpay_keyboard_4"));
        this.f123120c[5] = (TextView) inflate.findViewById(b("tenpay_keyboard_5"));
        this.f123120c[6] = (TextView) inflate.findViewById(b("tenpay_keyboard_6"));
        this.f123120c[7] = (TextView) inflate.findViewById(b("tenpay_keyboard_7"));
        this.f123120c[8] = (TextView) inflate.findViewById(b("tenpay_keyboard_8"));
        this.f123120c[9] = (TextView) inflate.findViewById(b("tenpay_keyboard_9"));
        this.f123120c[10] = (TextView) inflate.findViewById(b("tenpay_keyboard_x"));
        int i3 = 0;
        this.f123120c[0] = (TextView) inflate.findViewById(b("tenpay_keyboard_0"));
        this.f123121d = (RelativeLayout) inflate.findViewById(b("tenpay_keyboard_d"));
        ViewOnClickListenerC6086a viewOnClickListenerC6086a = new ViewOnClickListenerC6086a();
        for (int i16 = 0; i16 <= 9; i16++) {
            this.f123120c[i16].setContentDescription(String.valueOf(i16));
        }
        this.f123120c[10].setContentDescription("\u5b57\u6bcdX");
        this.f123121d.setContentDescription("\u5220\u9664");
        while (true) {
            TextView[] textViewArr = this.f123120c;
            if (i3 < textViewArr.length) {
                textViewArr[i3].setOnClickListener(viewOnClickListenerC6086a);
                i3++;
            } else {
                this.f123121d.setOnClickListener(viewOnClickListenerC6086a);
                return;
            }
        }
    }

    public int b(String str) {
        return this.f123118a.getResources().getIdentifier(str, "id", this.f123118a.getPackageName());
    }

    public int a(String str) {
        return this.f123118a.getResources().getIdentifier(str, "drawable", this.f123118a.getPackageName());
    }

    public void setOnTouchListener(b bVar) {
    }
}
