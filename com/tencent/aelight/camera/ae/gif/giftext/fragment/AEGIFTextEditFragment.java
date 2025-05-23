package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.gif.AEStoryGIFPreviewActivity;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer;
import com.tencent.aelight.camera.ae.gif.video.b;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.immersive.SystemBarTintManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGIFTextEditFragment extends ReportFragment {
    private RelativeLayout C;
    private sq.d D;
    private rq.e E;
    private String F;
    private String G;
    private int H;
    private QQCustomDialog I;
    private Dialog J;
    private j K;
    private View L;
    com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b M;
    private String N = null;
    private boolean P = false;
    private float Q = 0.0f;
    private float R = 1.0f;
    private float S = 0.82f;
    private float T = 0.16f;

    /* renamed from: d, reason: collision with root package name */
    private AEStoryGIFPreviewActivity f65389d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f65390e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f65391f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f65392h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f65393i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f65394m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.aelight.camera.ae.config.g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f65404d;

        a(AppInterface appInterface) {
            this.f65404d = appInterface;
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateTextValid(boolean z16, boolean z17) {
            AEGIFTextEditFragment.this.K.a(z16, z17);
            this.f65404d.removeObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f65406d;

        b(View view) {
            this.f65406d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Log.d("AEGIFTextEditFragment", "onGlobalLayout");
            Rect rect = new Rect();
            this.f65406d.getWindowVisibleDisplayFrame(rect);
            int height = this.f65406d.getRootView().getHeight() - rect.bottom;
            int A = AEGIFTextEditFragment.this.A();
            if (height > A) {
                AEGIFTextEditFragment.this.R(height - A);
            } else {
                AEGIFTextEditFragment.this.R(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements j {
        e() {
        }

        @Override // com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.j
        public void a(boolean z16, boolean z17) {
            if (AEGIFTextEditFragment.this.P) {
                AEGIFTextEditFragment.this.B(z16, z17);
            } else {
                AEGIFTextEditFragment.this.C(z16, z17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements PngsTextDrawer.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f65412a;

        f(String str) {
            this.f65412a = str;
        }

        @Override // com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer.a
        public void a(String str) {
            AEGIFTextEditFragment.this.M.P1(this.f65412a, str);
            AEGIFTextEditFragment.this.J.dismiss();
            AEGIFTextEditFragment.this.getFragmentManager().popBackStack();
        }

        @Override // com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer.a
        public void onGifCreateFail() {
            AEGIFTextEditFragment.this.J.dismiss();
            AEGIFTextEditFragment.this.getFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AEGIFTextEditFragment.this.I.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEGIFTextEditFragment.this.f65391f.setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i implements InputFilter {

        /* renamed from: d, reason: collision with root package name */
        private int f65416d = 32;

        public i() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            if (charSequence.equals("\n")) {
                return "";
            }
            int i19 = 0;
            int i26 = 0;
            while (i19 <= this.f65416d && i26 < spanned.length()) {
                i19 += AEGIFTextEditFragment.this.y(spanned.charAt(i26));
                i26++;
            }
            if (i19 > this.f65416d) {
                return spanned.subSequence(0, i26 - 1);
            }
            int i27 = 0;
            while (i19 <= this.f65416d && i27 < charSequence.length()) {
                i19 += AEGIFTextEditFragment.this.y(charSequence.charAt(i27));
                i27++;
            }
            if (i19 > this.f65416d) {
                i27--;
            }
            return charSequence.subSequence(0, i27);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface j {
        void a(boolean z16, boolean z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing() || !SystemBarTintManager.hasNavBar(activity)) {
            return 0;
        }
        return SystemBarTintManager.getNavigationBarHeight(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z16, boolean z17) {
        this.J.dismiss();
        if (!z16) {
            Q();
        } else if (z17) {
            O();
            getFragmentManager().popBackStack();
        } else {
            this.f65389d.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    AEGIFTextEditFragment.this.Q();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ((InputMethodManager) this.f65389d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f65389d.getWindow().getDecorView().getRootView().getWindowToken(), 0);
    }

    private void F() {
        this.M = (com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b) n.a(this.f65389d).get(com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b.class);
    }

    private void G() {
        this.f65394m = (RelativeLayout) this.f65390e.findViewById(R.id.rzu);
        this.C = (RelativeLayout) this.f65390e.findViewById(R.id.rzz);
        this.f65392h = (ImageView) this.f65390e.findViewById(R.id.rpu);
        this.f65393i = (RecyclerView) this.f65390e.findViewById(R.id.s09);
        this.f65393i.setLayoutManager(new LinearLayoutManager(this.f65389d, 0, false));
        sq.d dVar = new sq.d(this.f65389d, this.f65393i);
        this.D = dVar;
        dVar.A(this.H);
        this.f65393i.setAdapter(this.D);
        this.f65390e.findViewById(R.id.s2e).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                com.tencent.aelight.camera.ae.report.b.b().a1();
                AEGIFTextEditFragment.this.D();
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEGIFTextEditFragment.this.w(false);
                    }
                }, 200L);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f65390e.findViewById(R.id.s2f).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                com.tencent.aelight.camera.ae.report.b.b().b1();
                AEGIFTextEditFragment.this.D();
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEGIFTextEditFragment.this.w(true);
                    }
                }, 200L);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f65392h.setOnClickListener(new h());
    }

    public static AEGIFTextEditFragment H(String str, boolean z16, View view, String str2) {
        AEGIFTextEditFragment I = I(str, z16, str2);
        I.L(view);
        return I;
    }

    public static AEGIFTextEditFragment I(String str, boolean z16, String str2) {
        AEGIFTextEditFragment aEGIFTextEditFragment = new AEGIFTextEditFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_PNG_DIR_PATH", str);
        bundle.putBoolean("KEY_IS_MULTIPLE", z16);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("KEY_FONT_ID", str2);
        }
        aEGIFTextEditFragment.setArguments(bundle);
        return aEGIFTextEditFragment;
    }

    private void J(String str, String str2) {
        AEBaseReportParam.U().Z0(str);
        AEBaseReportParam.U().r1(str2);
    }

    private void K() {
        if (((AEGIFOutlineTextView) this.L.findViewById(R.id.rxq)) == null || this.f65391f.getText().toString().indexOf(10) <= 0) {
            return;
        }
        this.S = 0.73f;
        this.T = 0.3f;
    }

    private void L(View view) {
        this.L = view;
    }

    private void N(j jVar) {
        this.K = jVar;
    }

    private void O() {
        final String obj = this.f65391f.getText().toString();
        final String w3 = this.D.w();
        final int v3 = this.D.v();
        final String u16 = this.D.u();
        if (this.E != null) {
            this.f65389d.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    AEGIFTextEditFragment.this.E.s(obj, w3, u16);
                    AEGIFTextEditFragment.this.E.u(v3);
                    if (w3.equals("#ccffffff")) {
                        AEGIFTextEditFragment.this.E.t(false, true);
                    } else {
                        AEGIFTextEditFragment.this.E.t(true, false);
                    }
                }
            });
        }
        this.M.Q1(obj, v3);
        J(obj, w3);
    }

    private void P() {
        ReportDialog reportDialog = new ReportDialog(this.f65389d, R.style.qZoneInputDialog);
        this.J = reportDialog;
        reportDialog.setCancelable(false);
        this.J.setCanceledOnTouchOutside(false);
        this.J.setContentView(R.layout.dom);
        this.J.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f65389d, 230);
        this.I = createCustomDialog;
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.j7j));
        this.I.setCanceledOnTouchOutside(false);
        this.I.setPositiveButton(HardCodeUtil.qqStr(R.string.j7i), new g());
        this.I.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(final int i3) {
        this.C.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.13
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AEGIFTextEditFragment.this.C.getLayoutParams();
                int i16 = marginLayoutParams.bottomMargin;
                int i17 = i3;
                if (i16 != i17) {
                    marginLayoutParams.bottomMargin = i17;
                    AEGIFTextEditFragment.this.C.setLayoutParams(marginLayoutParams);
                }
            }
        });
    }

    private void v(String str) {
        AppInterface a16 = QQStoryContext.a();
        CameraPeakServiceHandler cameraPeakServiceHandler = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
        a16.addObserver(new a(a16));
        cameraPeakServiceHandler.q3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        String obj = this.f65391f.getText().toString();
        if (z16) {
            if (obj.equals("")) {
                rq.e eVar = this.E;
                if (eVar != null) {
                    eVar.h();
                }
                this.M.L1();
                J("none", this.D.w());
                getFragmentManager().popBackStack();
                return;
            }
            P();
            v(obj);
            return;
        }
        getFragmentManager().popBackStack();
    }

    private void x() {
        ((InputMethodManager) this.f65389d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(1, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y(char c16) {
        if (c16 != '\n' && c16 != '\r') {
            if (c16 < '\u0080') {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public void E(String str) {
        ImageView imageView;
        EditText editText = (EditText) this.f65390e.findViewById(R.id.s0y);
        this.f65391f = editText;
        this.D.t(editText);
        this.f65391f.setText(this.F);
        this.f65391f.setTextColor(Color.parseColor(str));
        this.f65391f.setSelection(this.F.length());
        if (this.f65391f.length() > 0 && (imageView = this.f65392h) != null) {
            imageView.setVisibility(0);
        }
        this.f65391f.setFilters(new InputFilter[]{new i()});
        this.f65391f.addTextChangedListener(new c());
    }

    public void M(rq.e eVar) {
        this.E = eVar;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.N = getArguments().getString("KEY_PNG_DIR_PATH");
        this.P = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
        if (getArguments().containsKey("KEY_FONT_ID")) {
            this.G = getArguments().getString("KEY_FONT_ID");
        }
        this.f65389d = (AEStoryGIFPreviewActivity) getActivity();
        F();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f65390e = (ViewGroup) layoutInflater.inflate(z(), viewGroup, false);
        rq.e eVar = this.E;
        if (eVar != null) {
            this.F = eVar.n();
            this.H = this.E.m();
        } else {
            this.F = this.M.O1().getValue();
        }
        G();
        E(this.D.w());
        x();
        ViewGroup viewGroup2 = this.f65390e;
        FragmentCollector.onFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        D();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        String str;
        super.onResume();
        this.f65391f.requestFocus();
        com.tencent.aelight.camera.ae.report.b b16 = com.tencent.aelight.camera.ae.report.b.b();
        if (this.P) {
            str = "recommend";
        } else {
            str = "edit";
        }
        b16.c1(str);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f65390e.setOnTouchListener(new d());
        N(new e());
        u(this.f65394m);
    }

    public void u(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view));
    }

    protected int z() {
        return R.layout.do9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z16, boolean z17) {
        String str;
        if (!z16) {
            this.J.dismiss();
            Q();
            return;
        }
        if (z17) {
            O();
            b.a value = this.M.M1().getValue();
            if (value != null && (str = value.f65547a) != null) {
                FileUtils.deleteDirectory(str);
            }
            PngsTextDrawer pngsTextDrawer = new PngsTextDrawer(this.N);
            K();
            String obj = this.f65391f.getText().toString();
            pngsTextDrawer.n(obj, 55, this.D.w(), this.D.u(), x.c(getActivity(), 4.0f), this.G, this.Q, this.S, this.R, this.T);
            pngsTextDrawer.o(new f(obj));
            return;
        }
        this.J.dismiss();
        this.f65389d.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.4
            @Override // java.lang.Runnable
            public void run() {
                AEGIFTextEditFragment.this.Q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        boolean f65408d = false;

        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                AEGIFTextEditFragment.this.f65392h.setVisibility(0);
            } else {
                AEGIFTextEditFragment.this.f65392h.setVisibility(4);
            }
            boolean z16 = true;
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < editable.length(); i17++) {
                char charAt = editable.charAt(i17);
                if (charAt == '\n') {
                    return;
                }
                if (charAt == ' ') {
                    if (z16) {
                        z16 = false;
                    }
                    i16 = i17;
                }
                i3 += AEGIFTextEditFragment.this.y(charAt);
                if (i3 > 16 && !this.f65408d) {
                    AEGIFTextEditFragment.this.f65391f.removeTextChangedListener(this);
                    if (!z16) {
                        AEGIFTextEditFragment.this.f65391f.setText(editable.insert(i16, "\r\n"));
                    } else {
                        AEGIFTextEditFragment.this.f65391f.setText(editable.insert(i17, "\r\n"));
                    }
                    AEGIFTextEditFragment.this.f65391f.setSelection(editable.length());
                    this.f65408d = true;
                    AEGIFTextEditFragment.this.f65391f.addTextChangedListener(this);
                    return;
                }
            }
            if (i3 <= 16) {
                this.f65408d = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
