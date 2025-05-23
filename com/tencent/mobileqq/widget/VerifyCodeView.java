package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.widget.shape.DotView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UIRestoreAfterFontChangedUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VerifyCodeView extends LinearLayout implements TextWatcher {
    private static String L = "VerifyCodeView";
    private static int M = 2131251414;
    private static int N = 2131251416;
    private static int P = 2131251411;
    private static int Q = 2131251413;
    private static int R = 2131251415;
    private static int S = 2131251412;
    private boolean C;
    private ArrayList<b> D;
    private ArrayList<a> E;
    private Vibrator F;
    private boolean G;
    private int H;
    private Runnable I;
    private boolean J;
    private Runnable K;

    /* renamed from: d, reason: collision with root package name */
    private EditText f316503d;

    /* renamed from: e, reason: collision with root package name */
    private int f316504e;

    /* renamed from: f, reason: collision with root package name */
    private int f316505f;

    /* renamed from: h, reason: collision with root package name */
    private int f316506h;

    /* renamed from: i, reason: collision with root package name */
    private int f316507i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f316508m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onVerifyCodeChanged(boolean z16, String str);
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewGroup.LayoutParams layoutParams;
        boolean z16;
        int i3;
        this.f316508m = false;
        this.C = false;
        this.K = new Runnable() { // from class: com.tencent.mobileqq.widget.VerifyCodeView.2
            @Override // java.lang.Runnable
            public void run() {
                VerifyCodeView.this.f316503d.setText("");
                VerifyCodeView.this.o(false);
                VerifyCodeView.this.p();
            }
        };
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410052f9);
        this.f316504e = obtainStyledAttributes.getInteger(jj2.b.f410166p9, 6);
        this.f316506h = obtainStyledAttributes.getColor(jj2.b.f410120l9, -16777216);
        this.f316507i = obtainStyledAttributes.getColor(jj2.b.f410131m9, SupportMenu.CATEGORY_MASK);
        this.G = obtainStyledAttributes.getBoolean(jj2.b.f410109k9, false);
        int dimension = (int) obtainStyledAttributes.getDimension(jj2.b.f410142n9, 20.0f);
        float f16 = obtainStyledAttributes.getFloat(jj2.b.f410154o9, 29.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(jj2.b.f410098j9, 80.0f);
        int dimension3 = (int) obtainStyledAttributes.getDimension(jj2.b.f410076h9, 80.0f);
        float scale = UIRestoreAfterFontChangedUtil.getScale(getContext());
        float f17 = f16 / scale;
        int round = Math.round(dimension2 / scale);
        int round2 = Math.round(dimension3 / scale);
        this.f316508m = obtainStyledAttributes.getBoolean(jj2.b.f410087i9, false);
        this.C = obtainStyledAttributes.getBoolean(jj2.b.f410064g9, false);
        obtainStyledAttributes.recycle();
        this.D = new ArrayList<>();
        this.f316503d = new EditText(context);
        int i16 = 0;
        while (i16 < this.f316504e) {
            b bVar = new b(context, f17, this.f316506h, round, round2, this.f316503d);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (this.C) {
                layoutParams2.weight = 1.0f;
            } else if (i16 != this.f316504e - 1) {
                layoutParams2.rightMargin = dimension;
            }
            addView(bVar, layoutParams2);
            this.D.add(bVar);
            i16++;
            bVar.e(getResources().getString(R.string.f237607hi, Integer.valueOf(i16)));
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("verify_code_view_focus_fix_switch", true);
        QLog.i(L, 1, "VerifyCodeView focusFixSwitch: " + isSwitchOn);
        if (isSwitchOn) {
            layoutParams = new LinearLayout.LayoutParams(10, 10);
            i3 = 10;
            z16 = false;
        } else {
            layoutParams = null;
            z16 = true;
            i3 = 0;
        }
        this.f316503d.setCursorVisible(z16);
        this.f316503d.setInputType(2);
        this.f316503d.setSingleLine();
        this.f316503d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f316504e)});
        this.f316503d.setTextSize(i3);
        this.f316503d.setTextColor(0);
        this.f316503d.setBackgroundResource(R.color.ajr);
        if (layoutParams == null) {
            addView(this.f316503d);
        } else {
            addView(this.f316503d, layoutParams);
        }
        this.f316503d.addTextChangedListener(this);
        this.f316503d.setFocusable(true);
        this.f316503d.setFocusableInTouchMode(true);
        this.f316503d.requestFocus();
        ViewCompat.setImportantForAccessibility(this.f316503d, 2);
        l();
        this.f316505f = 0;
        p();
    }

    private void h() {
        try {
            if (this.F == null) {
                this.F = (Vibrator) getContext().getSystemService("vibrator");
            }
            Vibrator vibrator = this.F;
            if (vibrator != null) {
                vibrator.vibrate(50L);
            }
        } catch (Exception e16) {
            QLog.e(L, 1, "exception when doVibrate.", e16);
        }
    }

    private void j(boolean z16) {
        ArrayList<a> arrayList = this.E;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onVerifyCodeChanged(z16, i());
            }
        }
    }

    private void l() {
        ArrayList<b> arrayList = this.D;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<b> it = this.D.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.c();
                n(next);
            }
        }
    }

    private void m(String str) {
        boolean z16;
        l();
        for (char c16 : str.toCharArray()) {
            if (!Character.isDigit(c16)) {
                QLog.e(L, 1, "setCode error: verify code not digit string");
                return;
            }
        }
        int length = str.length();
        this.f316505f = length;
        if (this.H != length) {
            removeCallbacks(this.I);
        }
        int i3 = 0;
        while (true) {
            int i16 = this.f316505f;
            if (i3 < i16) {
                b bVar = this.D.get(i3);
                if (this.G) {
                    if (i3 == this.f316505f - 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    q(z16, bVar);
                }
                int i17 = i3 + 1;
                bVar.h(str.substring(i3, i17));
                i3 = i17;
            } else {
                this.H = i16;
                return;
            }
        }
    }

    private void n(b bVar) {
        int i3;
        boolean z16 = this.f316508m;
        if (z16) {
            i3 = R;
        } else if (this.J) {
            i3 = N;
        } else {
            i3 = M;
        }
        bVar.d(i3, z16);
        UIRestoreAfterFontChangedUtil.restoreViewBgRadius(bVar, getContext().getResources().getDimension(R.dimen.di9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z16) {
        int i3;
        int i16;
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (z16) {
                i3 = this.f316507i;
            } else {
                i3 = this.f316506h;
            }
            next.i(i3);
            if (z16) {
                boolean z17 = this.f316508m;
                if (z17) {
                    i16 = R.drawable.m16;
                } else {
                    i16 = R.drawable.f162645m15;
                }
                next.d(i16, z17);
            } else {
                n(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        int i3;
        int i16 = this.f316505f;
        if (i16 >= 0 && i16 < this.D.size()) {
            if (this.f316508m) {
                i3 = S;
            } else if (this.J) {
                i3 = Q;
            } else {
                i3 = P;
            }
            this.D.get(this.f316505f).d(i3, this.f316508m);
            UIRestoreAfterFontChangedUtil.restoreViewBgRadius(this.D.get(this.f316505f), getContext().getResources().getDimension(R.dimen.di9));
        }
    }

    private void q(boolean z16, final b bVar) {
        if (z16 && this.f316505f - this.H == 1) {
            bVar.g(false);
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.widget.VerifyCodeView.1
                @Override // java.lang.Runnable
                public void run() {
                    bVar.g(true);
                }
            };
            this.I = runnable;
            postDelayed(runnable, 400L);
            return;
        }
        bVar.g(true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z16;
        m(editable.toString());
        p();
        if (this.f316505f == this.f316504e) {
            z16 = true;
        } else {
            z16 = false;
        }
        j(z16);
    }

    public void e(a aVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(aVar);
    }

    public void f() {
        this.f316503d.setText("");
    }

    public void g() {
        o(true);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f155059vh));
        h();
        postDelayed(this.K, 1000L);
    }

    public String i() {
        return this.f316503d.getText().toString();
    }

    public void k(InputMethodManager inputMethodManager) {
        this.f316503d.requestFocus();
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f316503d, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.K);
        removeCallbacks(this.I);
    }

    public void setCode(String str) {
        this.f316503d.setText(str);
    }

    public void setContextMenuEnable(boolean z16) {
        this.f316503d.setLongClickable(false);
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().f(z16);
        }
    }

    public void setDigitTextColorNormal(int i3) {
        ArrayList<b> arrayList = this.D;
        if (arrayList == null) {
            return;
        }
        this.f316506h = i3;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().i(i3);
        }
    }

    public void setDigitTextColorWrong(int i3) {
        this.f316507i = i3;
    }

    public void setTheme(boolean z16) {
        this.J = z16;
        Iterator<b> it = this.D.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends RelativeLayout implements TextWatcher, View.OnKeyListener {

        /* renamed from: d, reason: collision with root package name */
        public TextView f316510d;

        /* renamed from: e, reason: collision with root package name */
        public EditText f316511e;

        /* renamed from: f, reason: collision with root package name */
        public EditText f316512f;

        /* renamed from: h, reason: collision with root package name */
        private DotView f316513h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public class a extends EditText {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f316514d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, Context context2) {
                super(context);
                this.f316514d = context2;
            }

            @Override // android.widget.EditText, android.widget.TextView
            public boolean onTextContextMenuItem(int i3) {
                if (i3 != 16908322) {
                    return super.onTextContextMenuItem(i3);
                }
                String a16 = com.tencent.mobileqq.utils.v.a(getContext());
                if (a16.length() == 0) {
                    QQToast.makeText(this.f316514d, 1, R.string.f173332sv, 0).show();
                } else {
                    b.this.f316512f.setText(a16);
                    EditText editText = b.this.f316512f;
                    editText.setSelection(editText.getText().length());
                }
                return true;
            }
        }

        public b(Context context, float f16, int i3, int i16, int i17, EditText editText) {
            super(context);
            this.f316512f = editText;
            TextView textView = new TextView(context);
            this.f316510d = textView;
            textView.setMaxLines(1);
            this.f316510d.setSingleLine();
            this.f316510d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f316510d.setTextSize(f16);
            this.f316510d.setTextColor(i3);
            this.f316510d.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
            this.f316510d.setFocusable(false);
            this.f316510d.setBackgroundColor(0);
            this.f316510d.setGravity(17);
            this.f316510d.setPadding(0, 0, 1, 1);
            this.f316510d.setWidth(i16);
            this.f316510d.setHeight(i17);
            this.f316510d.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.f316510d, layoutParams);
            d(VerifyCodeView.M, false);
            b(context, f16, i16, i17);
            a(context, i3);
        }

        private void a(Context context, int i3) {
            DotView dotView = new DotView(context);
            this.f316513h = dotView;
            dotView.setRadius(5.4f);
            this.f316513h.setColor(i3);
            this.f316513h.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.f316513h, layoutParams);
        }

        private void b(Context context, float f16, int i3, int i16) {
            a aVar = new a(context, context);
            this.f316511e = aVar;
            aVar.setWidth(i3);
            this.f316511e.setHeight(i16);
            this.f316511e.setMaxLines(1);
            this.f316511e.setSingleLine();
            this.f316511e.setInputType(2);
            this.f316511e.setTextSize(f16);
            this.f316511e.setTextColor(0);
            this.f316511e.setBackgroundColor(0);
            this.f316511e.addTextChangedListener(this);
            this.f316511e.setOnKeyListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.f316511e, layoutParams);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                this.f316512f.getText().append((CharSequence) editable.toString());
                this.f316512f.requestFocus();
                EditText editText = this.f316512f;
                editText.setSelection(editText.getText().length());
                this.f316511e.setText("");
            }
        }

        public void c() {
            h("");
            this.f316513h.setVisibility(8);
            this.f316510d.setVisibility(0);
        }

        public void d(int i3, boolean z16) {
            if (z16) {
                this.f316510d.setBackgroundResource(i3);
                setBackground(null);
            } else {
                setBackgroundResource(i3);
                this.f316510d.setBackground(null);
            }
        }

        public void e(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f316511e.setContentDescription(str);
            }
        }

        public void f(boolean z16) {
            this.f316511e.setLongClickable(z16);
        }

        public void g(boolean z16) {
            if (z16) {
                this.f316510d.setVisibility(8);
                this.f316513h.setVisibility(0);
            } else {
                this.f316510d.setVisibility(0);
                this.f316513h.setVisibility(8);
            }
        }

        public void h(String str) {
            this.f316510d.setText(str);
        }

        public void i(int i3) {
            this.f316510d.setTextColor(i3);
            this.f316513h.setColor(i3);
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            String obj;
            int length;
            if (i3 == 67 && keyEvent.getAction() == 0 && (view instanceof EditText) && ((EditText) view).getText().length() == 0 && (length = (obj = this.f316512f.getText().toString()).length()) > 0) {
                int i16 = length - 1;
                this.f316512f.setText(obj.substring(0, i16));
                this.f316512f.requestFocus();
                this.f316512f.setSelection(i16);
            }
            return false;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
