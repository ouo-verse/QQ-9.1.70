package gw;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.c;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends Dialog {
    private static int E = -1;
    ViewGroup C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f403438d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f403439e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f403440f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f403441h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f403442i;

    /* renamed from: m, reason: collision with root package name */
    protected LinearLayout f403443m;

    /* compiled from: P */
    /* renamed from: gw.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class ViewOnClickListenerC10398a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f403444d;

        ViewOnClickListenerC10398a(DialogInterface.OnClickListener onClickListener) {
            this.f403444d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f403444d;
            if (onClickListener != null) {
                onClickListener.onClick(a.this, 0);
            }
            try {
                if (a.this.isShowing()) {
                    a.this.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f403446d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f403446d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f403446d;
            if (onClickListener != null) {
                onClickListener.onClick(a.this, 1);
            }
            try {
                if (a.this.isShowing()) {
                    a.this.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    public a(Context context, int i3) {
        super(context, i3);
        this.D = true;
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
    }

    private int d() {
        int i3 = E;
        if (i3 != -1) {
            return i3;
        }
        int i16 = getContext().getResources().getDisplayMetrics().widthPixels;
        E = i16;
        return i16;
    }

    private void e() {
        String valueOf;
        if (QLog.isDevelopLevel()) {
            TextView textView = this.f403438d;
            if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                valueOf = this.f403438d.getText().toString();
            } else {
                TextView textView2 = this.f403439e;
                if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                    valueOf = this.f403439e.getText().toString();
                } else {
                    valueOf = String.valueOf(hashCode());
                }
            }
            QLog.i("QAVCustomDialog", 1, "show, content=" + valueOf);
        }
    }

    private void k() {
        ViewGroup viewGroup;
        ViewGroup.LayoutParams layoutParams;
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f158688md);
        int d16 = d();
        if (d16 <= 0 || dimension <= 0 || d16 >= dimension || (viewGroup = this.C) == null || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = d16;
        this.C.setLayoutParams(layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.getText().add(getContext().getString(R.string.a_q));
        }
        super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Dialog.class.getName());
        return false;
    }

    public a f(CharSequence charSequence) {
        if (this.f403439e == null) {
            return this;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f403439e.setText(charSequence);
            this.f403439e.setVisibility(0);
            this.f403439e.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else {
            this.f403439e.setVisibility(8);
        }
        return this;
    }

    public a j(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f403438d.setText(str);
            this.f403438d.setContentDescription(str);
            this.f403438d.setVisibility(0);
        } else {
            this.f403438d.setVisibility(8);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        int parseColor;
        super.setContentView(i3);
        this.f403438d = (TextView) findViewById(R.id.rat);
        this.f403439e = (TextView) findViewById(R.id.rar);
        this.f403440f = (TextView) findViewById(R.id.ral);
        this.f403441h = (TextView) findViewById(R.id.rao);
        this.f403442i = (TextView) findViewById(R.id.rap);
        this.f403441h.setVisibility(8);
        this.f403442i.setVisibility(8);
        this.f403443m = (LinearLayout) findViewById(R.id.raf);
        this.C = (ViewGroup) findViewById(R.id.raq);
        c.f(this);
        if (this.D) {
            c.h(this);
        }
        c.d(this);
        k();
        if (QQTheme.isNowThemeIsNight()) {
            this.C.setBackgroundResource(R.drawable.inr);
            parseColor = Color.parseColor("#FFF0F0F4");
        } else {
            this.C.setBackgroundResource(R.drawable.ins);
            parseColor = Color.parseColor("#1A1C1E");
        }
        this.f403438d.setTextColor(parseColor);
        this.f403439e.setTextColor(parseColor);
        this.f403440f.setTextColor(parseColor);
        this.f403441h.setTextColor(parseColor);
        this.f403442i.setTextColor(parseColor);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.f403438d.setText(i3);
        this.f403438d.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void show() {
        c.b(this);
        e();
        try {
            super.show();
        } catch (Throwable th5) {
            QLog.e("QAVCustomDialog", 1, "show error:", th5);
        }
    }

    public a g(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.f403441h.setVisibility(8);
            return this;
        }
        this.f403441h.setText(i3);
        AccessibilityUtil.c(this.f403441h, getContext().getString(i3), Button.class.getName());
        this.f403441h.setVisibility(0);
        this.f403441h.setOnClickListener(new ViewOnClickListenerC10398a(onClickListener));
        i();
        return this;
    }

    public a h(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.f403442i.setVisibility(8);
            return this;
        }
        this.f403442i.setText(i3);
        AccessibilityUtil.c(this.f403442i, getContext().getString(i3), Button.class.getName());
        this.f403442i.setVisibility(0);
        this.f403442i.setOnClickListener(new b(onClickListener));
        i();
        return this;
    }

    protected void i() {
    }
}
