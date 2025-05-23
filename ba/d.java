package ba;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.part.publish.common.inputkeyboardmenu.e;
import com.qzone.util.ar;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class d extends ReportDialog {
    private static final int J = ar.e(604.0f);
    private static final int K = ar.e(29.0f);
    protected View C;
    protected View D;
    protected QUSHalfScreenFloatingView E;
    protected QUIButton F;
    protected FrameLayout G;
    private com.qzone.reborn.part.publish.common.inputkeyboardmenu.e H;
    private Dialog I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements e.a {
        a() {
        }

        @Override // com.qzone.reborn.part.publish.common.inputkeyboardmenu.e.a
        public void onSoftKeyboardClosed() {
            d.this.e0(0);
        }

        @Override // com.qzone.reborn.part.publish.common.inputkeyboardmenu.e.a
        public void onSoftKeyboardOpened(int i3) {
            d.this.e0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        public View createContentView() {
            d dVar = d.this;
            dVar.D = LayoutInflater.from(dVar.getContext()).inflate(d.this.Q(), (ViewGroup) null);
            d dVar2 = d.this;
            dVar2.W(dVar2.D);
            return d.this.D;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return d.this.S();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    protected interface e {
        void afterTextChanged(Editable editable);
    }

    private void O() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(20);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e(R(), 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    private void X() {
        this.E.setDraggable(true);
        this.E.setQUSDragFloatController(new b());
        this.E.setOnDismissStartListener(new QUSBaseHalfScreenFloatingView.m() { // from class: ba.b
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.m
            public final void a() {
                d.this.a0();
            }
        });
        this.E.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: ba.c
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                d.this.dismiss();
            }
        });
        this.E.j(new c());
    }

    private void Y() {
        com.qzone.reborn.part.publish.common.inputkeyboardmenu.e eVar = new com.qzone.reborn.part.publish.common.inputkeyboardmenu.e(this.C);
        this.H = eVar;
        eVar.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(int i3) {
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i3 + K;
        }
        this.G.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        try {
            Dialog dialog = this.I;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected abstract int Q();

    protected abstract String R();

    protected int S() {
        return J;
    }

    protected abstract void W(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Z(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a0();

    protected abstract void b0();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0(String str) {
        Dialog dialog = this.I;
        if (dialog == null || !dialog.isShowing()) {
            if (this.I == null) {
                ReportDialog reportDialog = new ReportDialog(getContext(), R.style.f174269ui);
                this.I = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                TextView textView = (TextView) this.I.findViewById(R.id.dialogText);
                this.I.findViewById(R.id.kja).setVisibility(8);
                this.I.findViewById(R.id.cib).setVisibility(0);
                textView.setText(str);
            }
            this.I.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O();
        setContentView(R.layout.f127390j);
        this.C = findViewById(R.id.f19846s);
        this.E = (QUSHalfScreenFloatingView) findViewById(R.id.miy);
        this.F = (QUIButton) findViewById(R.id.f19505v);
        this.G = (FrameLayout) findViewById(R.id.f199674);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: ba.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.Z(view);
            }
        });
        Y();
        X();
    }

    public d(Context context) {
        super(context, R.style.f173448dl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(EditText editText) {
        InputMethodManager inputMethodManager;
        if (editText == null || (inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null || !inputMethodManager.isActive(editText)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(EditText editText) {
        if (editText == null) {
            return;
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setTextIsSelectable(true);
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements QUSBaseHalfScreenFloatingView.p {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            d.this.b0();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
        }
    }

    /* compiled from: P */
    /* renamed from: ba.d$d, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0114d implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private final EditText f28124d;

        /* renamed from: e, reason: collision with root package name */
        private final int f28125e;

        /* renamed from: f, reason: collision with root package name */
        private final String f28126f;

        /* renamed from: h, reason: collision with root package name */
        private int f28127h;

        /* renamed from: i, reason: collision with root package name */
        private int f28128i;

        /* renamed from: m, reason: collision with root package name */
        private e f28129m;

        public C0114d(EditText editText, int i3, String str) {
            this.f28124d = editText;
            this.f28125e = i3;
            this.f28126f = str;
        }

        public void a(e eVar) {
            this.f28129m = eVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            e eVar = this.f28129m;
            if (eVar != null) {
                eVar.afterTextChanged(editable);
            }
            int i3 = this.f28127h;
            int length = editable.length();
            int i16 = this.f28125e;
            if (length > i16) {
                char[] cArr = new char[i16];
                editable.getChars(0, this.f28127h, cArr, 0);
                try {
                    if (this.f28127h + this.f28128i != editable.length()) {
                        editable.getChars(this.f28127h + this.f28128i, editable.length(), cArr, this.f28127h);
                    }
                    editable.replace(0, editable.length(), String.valueOf(cArr).trim());
                    if (editable.toString().trim().length() < i3) {
                        i3 = editable.toString().trim().length();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.f28124d.setSelection(i3);
                QQToast.makeText(d.this.getContext(), 1, String.format(this.f28126f, Integer.valueOf(this.f28125e)), 0).show();
            }
            String obj = editable.toString();
            String b16 = com.qzone.util.g.b(obj, "");
            if (obj.equals(b16)) {
                return;
            }
            editable.replace(0, editable.length(), b16);
            QQToast.makeText(d.this.getContext(), 0, com.qzone.util.l.a(R.string.f134258b), 0).show();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f28127h = i3;
            this.f28128i = i17;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
