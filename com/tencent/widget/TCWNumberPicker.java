package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Formatter;

/* loaded from: classes27.dex */
public class TCWNumberPicker extends LinearLayout implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener {
    static IPatchRedirector $redirector_;
    public static final b M;
    private static final char[] N;
    private int C;
    private int D;
    private int E;
    private e F;
    private b G;
    private long H;
    private boolean I;
    private boolean J;
    private TCWNumberPickerButton K;
    private TCWNumberPickerButton L;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f384682d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f384683e;

    /* renamed from: f, reason: collision with root package name */
    private final EditText f384684f;

    /* renamed from: h, reason: collision with root package name */
    private final InputFilter f384685h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f384686i;

    /* renamed from: m, reason: collision with root package name */
    private int f384687m;

    /* loaded from: classes27.dex */
    private static final class AutoIncDecRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<TCWNumberPicker> f384688d;

        public AutoIncDecRunnable(TCWNumberPicker tCWNumberPicker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tCWNumberPicker);
            } else {
                this.f384688d = new WeakReference<>(tCWNumberPicker);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TCWNumberPicker tCWNumberPicker = this.f384688d.get();
            if (tCWNumberPicker != null) {
                tCWNumberPicker.g(this);
            }
        }
    }

    /* loaded from: classes27.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final StringBuilder f384689a;

        /* renamed from: b, reason: collision with root package name */
        final Formatter f384690b;

        /* renamed from: c, reason: collision with root package name */
        final Object[] f384691c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            this.f384689a = sb5;
            this.f384690b = new Formatter(sb5);
            this.f384691c = new Object[1];
        }

        @Override // com.tencent.widget.TCWNumberPicker.b
        public String toString(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f384691c[0] = Integer.valueOf(i3);
            StringBuilder sb5 = this.f384689a;
            sb5.delete(0, sb5.length());
            this.f384690b.format("%02d", this.f384691c);
            return this.f384690b.toString();
        }
    }

    /* loaded from: classes27.dex */
    public interface b {
        String toString(int i3);
    }

    /* loaded from: classes27.dex */
    private class c implements InputFilter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TCWNumberPicker.this);
            }
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), spanned, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            if (TCWNumberPicker.this.f384686i == null) {
                return TCWNumberPicker.this.f384685h.filter(charSequence, i3, i16, spanned, i17, i18);
            }
            String valueOf = String.valueOf(charSequence.subSequence(i3, i16));
            String lowerCase = String.valueOf(String.valueOf(spanned.subSequence(0, i17)) + ((Object) valueOf) + ((Object) spanned.subSequence(i18, spanned.length()))).toLowerCase();
            for (String str : TCWNumberPicker.this.f384686i) {
                if (str.toLowerCase().startsWith(lowerCase)) {
                    return valueOf;
                }
            }
            return "";
        }
    }

    /* loaded from: classes27.dex */
    private class d extends NumberKeyListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TCWNumberPicker.this);
            }
        }

        @Override // android.text.method.NumberKeyListener, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), spanned, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            CharSequence filter = super.filter(charSequence, i3, i16, spanned, i17, i18);
            if (filter == null) {
                filter = charSequence.subSequence(i3, i16);
            }
            String str = String.valueOf(spanned.subSequence(0, i17)) + ((Object) filter) + ((Object) spanned.subSequence(i18, spanned.length()));
            if ("".equals(str)) {
                return str;
            }
            if (TCWNumberPicker.this.l(str) > TCWNumberPicker.this.C) {
                return "";
            }
            return filter;
        }

        @Override // android.text.method.NumberKeyListener
        protected char[] getAcceptedChars() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return TCWNumberPicker.N;
            }
            return (char[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return 2;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
    }

    /* loaded from: classes27.dex */
    public interface e {
        void a(TCWNumberPicker tCWNumberPicker, int i3, int i16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            M = new a();
            N = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        }
    }

    public TCWNumberPicker(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Runnable runnable) {
        if (this.I) {
            j(this.D + 1);
            this.f384682d.postDelayed(runnable, this.H);
        } else if (this.J) {
            j(this.D - 1);
            this.f384682d.postDelayed(runnable, this.H);
        }
    }

    private void j(int i3) {
        int i16 = this.C;
        if (i3 > i16) {
            i3 = this.f384687m;
        } else if (i3 < this.f384687m) {
            i3 = i16;
        }
        this.E = this.D;
        this.D = i3;
        m();
        updateView();
    }

    private String k(int i3) {
        b bVar = this.G;
        if (bVar != null) {
            return bVar.toString(i3);
        }
        return String.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(String str) {
        try {
            if (this.f384686i == null) {
                return Integer.parseInt(str);
            }
            for (int i3 = 0; i3 < this.f384686i.length; i3++) {
                str = str.toLowerCase();
                if (this.f384686i[i3].toLowerCase().startsWith(str)) {
                    return this.f384687m + i3;
                }
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return this.f384687m;
        }
    }

    private void m() {
        e eVar = this.F;
        if (eVar != null) {
            eVar.a(this, this.E, this.D);
        }
    }

    private void n(CharSequence charSequence) {
        int l3 = l(charSequence.toString());
        if (l3 >= this.f384687m && l3 <= this.C) {
            this.E = this.D;
            this.D = l3;
            m();
        }
        updateView();
    }

    private void o(View view) {
        String valueOf = String.valueOf(((TextView) view).getText());
        if ("".equals(valueOf)) {
            updateView();
        } else {
            n(valueOf);
        }
    }

    private void updateView() {
        String[] strArr = this.f384686i;
        if (strArr == null) {
            this.f384684f.setText(k(this.D));
        } else {
            this.f384684f.setText(strArr[this.D - this.f384687m]);
        }
        EditText editText = this.f384684f;
        editText.setSelection(editText.getText().length());
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.J = false;
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.I = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            o(this.f384684f);
            if (!this.f384684f.hasFocus()) {
                this.f384684f.requestFocus();
            }
            if (R.id.dja == view.getId()) {
                j(this.D + 1);
            } else if (R.id.beq == view.getId()) {
                j(this.D - 1);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, view, Boolean.valueOf(z16));
        } else if (!z16) {
            o(view);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view)).booleanValue();
        } else {
            this.f384684f.clearFocus();
            if (R.id.dja == view.getId()) {
                this.I = true;
                this.f384682d.post(this.f384683e);
            } else if (R.id.beq == view.getId()) {
                this.J = true;
                this.f384682d.post(this.f384683e);
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    public void setCurrent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.D = i3;
            updateView();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.setEnabled(z16);
        this.K.setEnabled(z16);
        this.L.setEnabled(z16);
        this.f384684f.setEnabled(z16);
    }

    public void setFormatter(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.G = bVar;
        }
    }

    public void setOnChangeListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        } else {
            this.F = eVar;
        }
    }

    public void setRange(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f384687m = i3;
        this.C = i16;
        this.D = i3;
        updateView();
    }

    public void setSpeed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.H = j3;
        }
    }

    public TCWNumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TCWNumberPicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384683e = new AutoIncDecRunnable(this);
        this.H = 300L;
        setOrientation(1);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168353tj, (ViewGroup) this, true);
        this.f384682d = new Handler();
        c cVar = new c();
        this.f384685h = new d();
        TCWNumberPickerButton tCWNumberPickerButton = (TCWNumberPickerButton) findViewById(R.id.dja);
        this.K = tCWNumberPickerButton;
        tCWNumberPickerButton.setOnClickListener(this);
        this.K.setOnLongClickListener(this);
        this.K.setNumberPicker(this);
        TCWNumberPickerButton tCWNumberPickerButton2 = (TCWNumberPickerButton) findViewById(R.id.beq);
        this.L = tCWNumberPickerButton2;
        tCWNumberPickerButton2.setOnClickListener(this);
        this.L.setOnLongClickListener(this);
        this.L.setNumberPicker(this);
        EditText editText = (EditText) findViewById(R.id.jm5);
        this.f384684f = editText;
        editText.setOnFocusChangeListener(this);
        editText.setFilters(new InputFilter[]{cVar});
        editText.setRawInputType(2);
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    public void setRange(int i3, int i16, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), strArr);
            return;
        }
        this.f384686i = strArr;
        this.f384687m = i3;
        this.C = i16;
        this.D = i3;
        updateView();
    }
}
