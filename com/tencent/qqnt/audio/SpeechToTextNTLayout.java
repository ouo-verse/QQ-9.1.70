package com.tencent.qqnt.audio;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.audio.SpeechToTextNTLayout;
import com.tencent.util.LoadingUtil;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SpeechToTextNTLayout extends ConstraintLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private ImageView D;
    private VoiceTextSttQueryController E;
    private final VoiceTextShowAnimator F;
    private IVoice2TxtTmpApi G;
    private String H;
    private String I;
    private int J;
    private final int K;
    private boolean L;
    private final int M;
    private boolean N;
    private boolean P;
    private int Q;
    private final c71.b R;
    private final TextView.OnEditorActionListener S;
    private final TextWatcher T;
    private INetInfoHandler U;
    private final ViewTreeObserver.OnGlobalLayoutListener V;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f352512d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.p f352513e;

    /* renamed from: f, reason: collision with root package name */
    private View f352514f;

    /* renamed from: h, reason: collision with root package name */
    private e f352515h;

    /* renamed from: i, reason: collision with root package name */
    private d71.c f352516i;

    /* renamed from: m, reason: collision with root package name */
    private EditText f352517m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements c71.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpeechToTextNTLayout.this);
            }
        }

        @Override // c71.b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SpeechToTextNTLayout.this.h1();
                SpeechToTextNTLayout.this.F.m();
                SpeechToTextNTLayout.this.E.s();
                SpeechToTextNTLayout.this.f352517m.setText(SpeechToTextNTLayout.this.f352516i.b().b());
                SpeechToTextNTLayout.this.f352516i.c().g(5);
                QQToast.makeText(SpeechToTextNTLayout.this.getContext(), HardCodeUtil.qqStr(R.string.viz), 0).show(SpeechToTextNTLayout.this.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                SpeechToTextNTLayout.this.W0();
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }

        @Override // c71.b
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (!SpeechToTextNTLayout.this.f352516i.c().b() && !SpeechToTextNTLayout.this.f352516i.c().e()) {
                SpeechToTextNTLayout.this.f352516i.b().d(str);
                SpeechToTextNTLayout.this.k1();
            } else if (QLog.isColorLevel()) {
                QLog.d("SpeechToTextLayout", 2, "updateText has finish");
            }
        }

        @Override // c71.b
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                SpeechToTextNTLayout.this.f352516i.c().g(4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f352519d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpeechToTextNTLayout.this);
            } else {
                this.f352519d = true;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            if (!SpeechToTextNTLayout.this.f352516i.c().e()) {
                return;
            }
            String obj = editable.toString();
            SpeechToTextNTLayout.this.f352516i.b().c(obj);
            SpeechToTextNTLayout.this.f352516i.d().f(true);
            boolean z16 = !StringUtil.isEmpty(obj);
            if (z16 == this.f352519d) {
                return;
            }
            this.f352519d = z16;
            SpeechToTextNTLayout.this.D.setEnabled(z16);
            if (z16) {
                SpeechToTextNTLayout.this.D.setImageResource(R.drawable.mo6);
            } else {
                SpeechToTextNTLayout.this.D.setImageResource(R.drawable.mo5);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpeechToTextNTLayout.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            SpeechToTextNTLayout.this.V0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            SpeechToTextNTLayout.this.V0();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.audio.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechToTextNTLayout.c.this.c();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.audio.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeechToTextNTLayout.c.this.d();
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class d implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpeechToTextNTLayout.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!SpeechToTextNTLayout.this.P) {
                return;
            }
            int height = SpeechToTextNTLayout.this.f352514f.getRootView().getHeight();
            boolean z17 = true;
            if (height < SpeechToTextNTLayout.this.M) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (!SpeechToTextNTLayout.this.N) {
                    SpeechToTextNTLayout.this.e1(true);
                    SpeechToTextNTLayout.this.N = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("SpeechToTextLayout", 2, "OnGlobalLayoutListener height too small need adapt, rootViewHeight:" + height + ", heightTooSmallThreshold:" + SpeechToTextNTLayout.this.M);
                        return;
                    }
                    return;
                }
                return;
            }
            if (SpeechToTextNTLayout.this.N) {
                SpeechToTextNTLayout.this.e1(false);
                SpeechToTextNTLayout.this.N = false;
                if (QLog.isColorLevel()) {
                    QLog.d("SpeechToTextLayout", 2, "OnGlobalLayoutListener height restore, rootViewHeight:" + height + ", heightTooSmallThreshold:" + SpeechToTextNTLayout.this.M);
                    return;
                }
                return;
            }
            Rect rect = new Rect();
            SpeechToTextNTLayout.this.f352514f.getWindowVisibleDisplayFrame(rect);
            int height2 = rect.height();
            if (height == height2) {
                return;
            }
            int i3 = height - height2;
            if (i3 <= SpeechToTextNTLayout.this.K) {
                z17 = false;
            }
            if (z17 != SpeechToTextNTLayout.this.L) {
                SpeechToTextNTLayout.this.U0(z17, i3);
                if (QLog.isColorLevel()) {
                    QLog.d("SpeechToTextLayout", 2, "OnGlobalLayoutListener keyboard curKeyboardShown:" + z17 + ", rootViewHeight:" + height + ", windowDisplayHeight:" + height2 + ", diff:" + i3 + ", keyboardHeightThreshold:" + SpeechToTextNTLayout.this.K);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface e {
        void a(String str);

        void finish();
    }

    public SpeechToTextNTLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.F = new VoiceTextShowAnimator();
        this.K = ViewUtils.dpToPx(160.0f);
        this.M = ViewUtils.dpToPx(420.0f);
        this.Q = 0;
        this.R = new a();
        this.S = new TextView.OnEditorActionListener() { // from class: com.tencent.qqnt.audio.p
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean b16;
                b16 = SpeechToTextNTLayout.this.b1(textView, i3, keyEvent);
                return b16;
            }
        };
        this.T = new b();
        this.U = new c();
        this.V = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(boolean z16, int i3) {
        this.L = z16;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (!z16) {
            i3 = 0;
        }
        marginLayoutParams.bottomMargin = i3;
        setLayoutParams(marginLayoutParams);
        e1(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        if (this.f352516i.c().d() || this.f352516i.c().a()) {
            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.viz), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            h1();
            this.F.m();
            this.E.s();
            this.f352517m.setText(this.f352516i.b().b());
            this.f352516i.c().g(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        Z0();
        i1();
        this.f352515h.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        int i3 = this.Q + 1;
        this.Q = i3;
        if (i3 % 10 == 0 && !NetworkUtil.isNetworkAvailable()) {
            d1();
            return;
        }
        if (this.f352516i.c().d()) {
            this.f352517m.setText(this.F.f());
        } else if (this.f352516i.c().a()) {
            this.f352517m.setText(this.F.g(this.f352516i.b().b(), true));
            this.f352517m.setSelection(this.F.h(), this.F.h());
        } else if (this.f352516i.c().b()) {
            Y0();
        }
    }

    private void Y0() {
        String b16 = this.f352516i.b().b();
        if (StringUtil.isEmpty(b16)) {
            this.f352517m.setText("");
            this.f352516i.c().g(5);
            this.f352517m.setFocusableInTouchMode(true);
            this.F.m();
            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.f214705tm), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            W0();
        } else {
            if (this.F.l(b16)) {
                this.f352517m.setText(b16);
                this.F.m();
                this.f352517m.setFocusableInTouchMode(true);
                this.f352516i.c().g(5);
                this.f352517m.setSelection(b16.length(), b16.length());
            } else {
                this.f352517m.setText(this.F.g(b16, true));
                this.f352517m.setSelection(this.F.h(), this.F.h());
            }
            ViewCompat.setImportantForAccessibility(this.f352517m, 1);
        }
        this.D.setEnabled(!StringUtil.isEmpty(b16));
        this.D.setBackgroundResource(R.drawable.jam);
        this.D.setImageResource(R.drawable.mo6);
    }

    private void Z0() {
        ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f352517m.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b1(TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            g1();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.audio.r
            @Override // java.lang.Runnable
            public final void run() {
                SpeechToTextNTLayout.this.X0();
            }
        });
    }

    private void d1() {
        QLog.d("SpeechToTextLayout", 1, "onNetworkUnAvailable  net unAvailable");
        QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.viy), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        h1();
        this.f352516i.c().g(5);
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(boolean z16) {
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
        if (z16) {
            i3 = getResources().getDimensionPixelSize(R.dimen.c3e);
            if (FontSettingManager.getFontLevel() != 16.0f) {
                i3 = (int) FontSettingManager.revertSize2Normal(this.f352512d.getApp(), i3);
            }
        } else {
            i3 = this.J;
        }
        marginLayoutParams.bottomMargin = i3;
        this.C.setLayoutParams(marginLayoutParams);
    }

    private void f1() {
        if (this.I == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(getContext())) {
            d1();
            return;
        }
        this.G.setIsInVoiceTxt(true);
        AppNetConnInfo.registerConnectionChangeReceiver(getContext(), this.U);
        this.f352516i.c().g(1);
        this.E.m(this.H);
        this.F.k();
        if (AppSetting.f99565y) {
            com.tencent.mobileqq.util.c.a(this, getContext().getString(R.string.z7j));
        }
    }

    private void g1() {
        this.f352515h.a(this.f352516i.a());
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        this.D.setEnabled(true);
        this.f352517m.setFocusableInTouchMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        if (!StringUtil.isEmpty(this.f352516i.b().b())) {
            this.f352516i.c().g(2);
            if (!this.D.isEnabled()) {
                this.D.setEnabled(true);
            }
        }
    }

    public void a1(String str, int i3, AppRuntime appRuntime, View view, int i16, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), appRuntime, view, Integer.valueOf(i16), eVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpeechToTextLayout", 2, "init, addMarginBottom:" + i16);
        }
        this.f352512d = appRuntime;
        this.f352514f = view;
        this.f352515h = eVar;
        com.tencent.mobileqq.activity.aio.p pVar = new com.tencent.mobileqq.activity.aio.p();
        this.f352513e = pVar;
        pVar.f179557e = str;
        pVar.f179555d = i3;
        this.f352516i = new d71.c();
        this.E = new VoiceTextSttQueryController();
        this.G = (IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class);
        if (FontSettingManager.getFontLevel() != 16.0f) {
            FontSettingManager.resetViewSize2Normal(appRuntime.getApp(), this);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
        int i17 = marginLayoutParams.bottomMargin + i16;
        marginLayoutParams.bottomMargin = i17;
        this.J = i17;
        this.C.setLayoutParams(marginLayoutParams);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        i1();
        this.f352514f.getViewTreeObserver().removeOnGlobalLayoutListener(this.V);
        VoiceTextSttQueryController voiceTextSttQueryController = this.E;
        if (voiceTextSttQueryController != null) {
            voiceTextSttQueryController.r();
        }
    }

    public void i1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        INetInfoHandler iNetInfoHandler = this.U;
        if (iNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
            this.U = null;
        }
        this.P = false;
        this.f352517m.setText("");
        this.E.i();
        this.F.m();
        this.G.setIsInVoiceTxt(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f352514f.getViewTreeObserver().addOnGlobalLayoutListener(this.V);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.y0a) {
                W0();
            } else if (id5 == R.id.y0d) {
                g1();
            } else if (id5 == R.id.bys && (this.f352516i.c().d() || this.f352516i.c().a())) {
                QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.f172918vj2), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (l.b()) {
            this.f352514f.getViewTreeObserver().removeOnGlobalLayoutListener(this.V);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onFinishInflate();
        ImageView imageView = (ImageView) findViewById(R.id.y0d);
        this.D = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.y0a);
        this.C = imageView2;
        imageView2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.bys);
        this.f352517m = editText;
        editText.setHorizontallyScrolling(false);
        this.f352517m.setMaxLines(100);
        this.f352517m.setOnClickListener(this);
        this.f352517m.setOnEditorActionListener(this.S);
        this.f352517m.addTextChangedListener(this.T);
        this.f352517m.setShowSoftInputOnFocus(true);
    }

    public void setParam(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.H = str;
        this.I = str2;
        this.P = true;
        if (this.N) {
            e1(false);
            this.N = false;
        }
        if (this.L) {
            U0(false, 0);
        }
        this.D.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        this.f352517m.setFocusableInTouchMode(false);
        ViewCompat.setImportantForAccessibility(this.f352517m, 2);
        VoiceTextSttQueryController voiceTextSttQueryController = this.E;
        AppRuntime appRuntime = this.f352512d;
        c71.b bVar = this.R;
        com.tencent.mobileqq.activity.aio.p pVar = this.f352513e;
        voiceTextSttQueryController.p(str2, appRuntime, bVar, pVar.f179555d, pVar.f179557e);
        this.F.j(Color.parseColor("#80FFFFFF"), new VoiceTextShowAnimator.a() { // from class: com.tencent.qqnt.audio.q
            @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.a
            public final void a() {
                SpeechToTextNTLayout.this.c1();
            }
        });
        this.f352516i.e();
        f1();
    }

    public SpeechToTextNTLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.F = new VoiceTextShowAnimator();
        this.K = ViewUtils.dpToPx(160.0f);
        this.M = ViewUtils.dpToPx(420.0f);
        this.Q = 0;
        this.R = new a();
        this.S = new TextView.OnEditorActionListener() { // from class: com.tencent.qqnt.audio.p
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean b16;
                b16 = SpeechToTextNTLayout.this.b1(textView, i3, keyEvent);
                return b16;
            }
        };
        this.T = new b();
        this.U = new c();
        this.V = new d();
    }

    public SpeechToTextNTLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.F = new VoiceTextShowAnimator();
        this.K = ViewUtils.dpToPx(160.0f);
        this.M = ViewUtils.dpToPx(420.0f);
        this.Q = 0;
        this.R = new a();
        this.S = new TextView.OnEditorActionListener() { // from class: com.tencent.qqnt.audio.p
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i36, KeyEvent keyEvent) {
                boolean b16;
                b16 = SpeechToTextNTLayout.this.b1(textView, i36, keyEvent);
                return b16;
            }
        };
        this.T = new b();
        this.U = new c();
        this.V = new d();
    }
}
