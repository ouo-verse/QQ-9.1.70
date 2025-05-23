package com.tencent.luggage.wxa.tl;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends LinearLayout {
    public ImageButton C;
    public EditText D;
    public View E;
    public boolean F;

    /* renamed from: a, reason: collision with root package name */
    public Context f141503a;

    /* renamed from: b, reason: collision with root package name */
    public int f141504b;

    /* renamed from: c, reason: collision with root package name */
    public Button f141505c;

    /* renamed from: d, reason: collision with root package name */
    public Button f141506d;

    /* renamed from: e, reason: collision with root package name */
    public Button f141507e;

    /* renamed from: f, reason: collision with root package name */
    public Button f141508f;

    /* renamed from: g, reason: collision with root package name */
    public Button f141509g;

    /* renamed from: h, reason: collision with root package name */
    public Button f141510h;

    /* renamed from: i, reason: collision with root package name */
    public Button f141511i;

    /* renamed from: j, reason: collision with root package name */
    public Button f141512j;

    /* renamed from: k, reason: collision with root package name */
    public Button f141513k;

    /* renamed from: l, reason: collision with root package name */
    public Button f141514l;

    /* renamed from: m, reason: collision with root package name */
    public Button f141515m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.tl.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC6767a implements View.OnClickListener {
        public ViewOnClickListenerC6767a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            if (a.this.D == null) {
                return;
            }
            if (view.getId() == R.id.je6) {
                int i16 = a.this.f141504b;
                if (i16 != 1) {
                    if (i16 == 2) {
                        a.this.D.dispatchKeyEvent(new KeyEvent(0, 56));
                        return;
                    }
                    return;
                } else {
                    a.this.D.dispatchKeyEvent(new KeyEvent(0, 59));
                    a.this.D.dispatchKeyEvent(new KeyEvent(0, 52));
                    a.this.D.dispatchKeyEvent(new KeyEvent(1, 59));
                    return;
                }
            }
            if (view.getId() == R.id.jdw) {
                i3 = 8;
            } else if (view.getId() == R.id.jdx) {
                i3 = 9;
            } else if (view.getId() == R.id.jdy) {
                i3 = 10;
            } else if (view.getId() == R.id.jdz) {
                i3 = 11;
            } else if (view.getId() == R.id.f166954je0) {
                i3 = 12;
            } else if (view.getId() == R.id.f166955je1) {
                i3 = 13;
            } else if (view.getId() == R.id.f166956je2) {
                i3 = 14;
            } else if (view.getId() == R.id.f166957je3) {
                i3 = 15;
            } else if (view.getId() == R.id.f166958je4) {
                i3 = 16;
            } else if (view.getId() == R.id.jdv) {
                i3 = 7;
            } else if (view.getId() == R.id.je5) {
                i3 = 67;
            } else {
                i3 = 0;
            }
            a.this.D.dispatchKeyEvent(new KeyEvent(0, i3));
            a.this.D.dispatchKeyEvent(new KeyEvent(1, i3));
        }
    }

    public a(Context context) {
        super(context);
        this.f141504b = 0;
        a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setInputEditText(EditText editText) {
        if (editText != null) {
            this.D = editText;
            int imeOptions = editText.getImeOptions();
            CharSequence imeActionLabel = this.D.getImeActionLabel();
            if (!TextUtils.isEmpty(imeActionLabel)) {
                this.f141514l.setText(imeActionLabel);
            }
            if (imeOptions == 1) {
                this.f141504b = 0;
                if (TextUtils.isEmpty(imeActionLabel)) {
                    this.f141514l.setText("");
                }
            }
        }
    }

    public void setSecureAccessibility(View.AccessibilityDelegate accessibilityDelegate) {
        this.f141515m.setAccessibilityDelegate(accessibilityDelegate);
        this.f141505c.setAccessibilityDelegate(accessibilityDelegate);
        this.f141506d.setAccessibilityDelegate(accessibilityDelegate);
        this.f141507e.setAccessibilityDelegate(accessibilityDelegate);
        this.f141508f.setAccessibilityDelegate(accessibilityDelegate);
        this.f141509g.setAccessibilityDelegate(accessibilityDelegate);
        this.f141510h.setAccessibilityDelegate(accessibilityDelegate);
        this.f141511i.setAccessibilityDelegate(accessibilityDelegate);
        this.f141512j.setAccessibilityDelegate(accessibilityDelegate);
        this.f141513k.setAccessibilityDelegate(accessibilityDelegate);
        this.f141514l.setAccessibilityDelegate(accessibilityDelegate);
        this.C.setAccessibilityDelegate(accessibilityDelegate);
    }

    public void setXMode(int i3) {
        this.f141504b = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f141504b = 0;
                    return;
                }
                this.f141514l.setText(".");
                if (this.F) {
                    this.f141514l.setBackgroundResource(R.drawable.loz);
                    return;
                } else {
                    this.f141514l.setBackgroundResource(R.drawable.loy);
                    return;
                }
            }
            this.f141514l.setText("X");
            if (this.F) {
                this.f141514l.setBackgroundResource(R.drawable.loz);
                return;
            } else {
                this.f141514l.setBackgroundResource(R.drawable.loy);
                return;
            }
        }
        this.f141514l.setText("");
        if (this.F) {
            this.f141514l.setBackgroundResource(R.color.b66);
        } else {
            this.f141514l.setBackgroundResource(R.color.f156750b63);
        }
    }

    public final void a(Context context) {
        this.f141503a = context.getApplicationContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167655dz2, (ViewGroup) this, true);
        this.E = inflate;
        this.f141505c = (Button) inflate.findViewById(R.id.jdw);
        this.f141506d = (Button) this.E.findViewById(R.id.jdx);
        this.f141507e = (Button) this.E.findViewById(R.id.jdy);
        this.f141508f = (Button) this.E.findViewById(R.id.jdz);
        this.f141509g = (Button) this.E.findViewById(R.id.f166954je0);
        this.f141510h = (Button) this.E.findViewById(R.id.f166955je1);
        this.f141511i = (Button) this.E.findViewById(R.id.f166956je2);
        this.f141512j = (Button) this.E.findViewById(R.id.f166957je3);
        this.f141513k = (Button) this.E.findViewById(R.id.f166958je4);
        this.f141514l = (Button) this.E.findViewById(R.id.je6);
        this.f141515m = (Button) this.E.findViewById(R.id.jdv);
        this.C = (ImageButton) this.E.findViewById(R.id.je5);
        ViewOnClickListenerC6767a viewOnClickListenerC6767a = new ViewOnClickListenerC6767a();
        this.f141505c.setContentDescription("1");
        this.f141506d.setContentDescription("2");
        this.f141507e.setContentDescription("3");
        this.f141508f.setContentDescription("4");
        this.f141509g.setContentDescription("5");
        this.f141510h.setContentDescription("6");
        this.f141511i.setContentDescription("7");
        this.f141512j.setContentDescription("8");
        this.f141513k.setContentDescription("9");
        this.f141515m.setContentDescription("0");
        this.f141514l.setContentDescription("\u5b57\u6bcdX");
        this.C.setContentDescription("\u5220\u9664");
        this.f141505c.setOnClickListener(viewOnClickListenerC6767a);
        this.f141506d.setOnClickListener(viewOnClickListenerC6767a);
        this.f141507e.setOnClickListener(viewOnClickListenerC6767a);
        this.f141508f.setOnClickListener(viewOnClickListenerC6767a);
        this.f141509g.setOnClickListener(viewOnClickListenerC6767a);
        this.f141510h.setOnClickListener(viewOnClickListenerC6767a);
        this.f141511i.setOnClickListener(viewOnClickListenerC6767a);
        this.f141512j.setOnClickListener(viewOnClickListenerC6767a);
        this.f141513k.setOnClickListener(viewOnClickListenerC6767a);
        this.f141514l.setOnClickListener(viewOnClickListenerC6767a);
        this.f141515m.setOnClickListener(viewOnClickListenerC6767a);
        this.C.setOnClickListener(viewOnClickListenerC6767a);
    }

    public void a() {
        this.F = true;
        this.f141505c.setTextColor(getResources().getColor(R.color.b1r));
        this.f141505c.setBackgroundResource(R.drawable.ja9);
        this.f141506d.setTextColor(getResources().getColor(R.color.b1r));
        this.f141506d.setBackgroundResource(R.drawable.ja9);
        this.f141507e.setTextColor(getResources().getColor(R.color.b1r));
        this.f141507e.setBackgroundResource(R.drawable.ja9);
        this.f141508f.setTextColor(getResources().getColor(R.color.b1r));
        this.f141508f.setBackgroundResource(R.drawable.ja9);
        this.f141509g.setTextColor(getResources().getColor(R.color.b1r));
        this.f141509g.setBackgroundResource(R.drawable.ja9);
        this.f141510h.setTextColor(getResources().getColor(R.color.b1r));
        this.f141510h.setBackgroundResource(R.drawable.ja9);
        this.f141511i.setTextColor(getResources().getColor(R.color.b1r));
        this.f141511i.setBackgroundResource(R.drawable.ja9);
        this.f141512j.setTextColor(getResources().getColor(R.color.b1r));
        this.f141512j.setBackgroundResource(R.drawable.ja9);
        this.f141513k.setTextColor(getResources().getColor(R.color.b1r));
        this.f141513k.setBackgroundResource(R.drawable.ja9);
        this.f141514l.setTextColor(getResources().getColor(R.color.b1r));
        this.f141514l.setBackgroundResource(R.drawable.loz);
        this.f141515m.setTextColor(getResources().getColor(R.color.b1r));
        this.f141515m.setBackgroundResource(R.drawable.ja9);
        this.C.setBackgroundResource(R.drawable.loz);
        this.E.findViewById(R.id.if5).setBackgroundResource(R.color.ao9);
        this.E.findViewById(R.id.ujb).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujg).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujh).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujk).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujl).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujm).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujn).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujo).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujp).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujc).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujd).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.uje).setBackgroundResource(R.color.b1h);
        this.E.findViewById(R.id.ujf).setBackgroundResource(R.color.b1h);
    }
}
