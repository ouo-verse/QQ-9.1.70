package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.panel.ao;
import com.tencent.aelight.camera.ae.camera.ui.panel.bv;
import com.tencent.aelight.camera.ae.camera.ui.panel.t;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.ab;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import kotlin.Pair;

/* loaded from: classes32.dex */
public class AETopRightBarPart extends AEVideoStoryTopBarPart {
    View U;
    private AEPituCameraUnit V;
    private AEVideoStoryTopBarViewModel W;
    private com.tencent.aelight.camera.ae.part.a X;
    private ab Y;
    private AEFlashShowBottomPanelViewModel Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f63331a0;

    /* renamed from: b0, reason: collision with root package name */
    private t f63332b0;

    /* renamed from: c0, reason: collision with root package name */
    private AECompoundButton f63333c0;

    /* renamed from: d0, reason: collision with root package name */
    private AECompoundButton f63334d0;

    /* renamed from: e0, reason: collision with root package name */
    private AECompoundButton f63335e0;

    /* renamed from: f0, reason: collision with root package name */
    private AECompoundButton f63336f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f63337g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f63338h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f63339i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f63340j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f63341k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f63342l0;

    /* renamed from: m0, reason: collision with root package name */
    private AECaptureMode f63343m0;

    /* renamed from: n0, reason: collision with root package name */
    private ao f63344n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            AETopRightBarPart.this.V(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (AETopRightBarPart.this.U != null) {
                AETopRightBarPart.this.U.setVisibility(bool.booleanValue() ? 8 : 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (AETopRightBarPart.this.U == null || bool.booleanValue()) {
                return;
            }
            AETopRightBarPart.this.U.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements Observer<ao> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ao aoVar) {
            AETopRightBarPart.this.f63344n0 = aoVar;
        }
    }

    public AETopRightBarPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.V = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    private boolean W(final String str) {
        if (com.tencent.aelight.camera.ae.d.j()) {
            return true;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.10
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), str, 0).show();
            }
        });
        return false;
    }

    private void X(int i3) {
        View findViewById = this.U.findViewById(i3);
        if (findViewById == null || !(findViewById instanceof TextView)) {
            return;
        }
        ((TextView) findViewById).setTextSize(18.0f);
    }

    private boolean Z() {
        i a16 = com.tencent.aelight.camera.ae.util.h.a();
        double a17 = a16.a() / (a16.b() * 1.0d);
        ms.a.f("AETopRightBarPart", "adjustRatio value " + a17);
        return a17 >= 1.9730000495910645d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a0() {
        return Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b0(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            view.setAlpha(0.5f);
        } else if (motionEvent.getActionMasked() == 1) {
            view.setAlpha(1.0f);
            view.performClick();
        }
        return true;
    }

    private void initViewModel() {
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) n.a(this.V).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f63331a0 = cVar;
        cVar.f65622i.observe(this.V, new a());
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) n.a(this.V).get(AEVideoStoryTopBarViewModel.class);
        this.W = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.O1().observe(this.V, new Observer<Boolean>() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(final Boolean bool) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AETopRightBarPart.this.V != null) {
                            AETopRightBarPart.this.V.i3(bool.booleanValue(), AETopRightBarPart.this.f63340j0);
                        }
                    }
                });
            }
        });
        this.W.f63374m.observe(this.V, new b());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.V).get(com.tencent.aelight.camera.ae.part.a.class);
        this.X = aVar;
        aVar.M1().observe(this.V, new c());
        this.X.L1().observe(this.V, new d());
        this.Y = (ab) n.a(this.V).get(ab.class);
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = (AEFlashShowBottomPanelViewModel) n.a(this.V).get(AEFlashShowBottomPanelViewModel.class);
        this.Z = aEFlashShowBottomPanelViewModel;
        aEFlashShowBottomPanelViewModel.e2().observe(this.V, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AETopRightBarPart.this.c0((Pair) obj);
            }
        });
        this.Z.k2().observe(this.V, new e());
        this.Z.f2().observe(this.V, new f());
        t tVar = (t) n.a(this.V).get(t.class);
        this.f63332b0 = tVar;
        tVar.N1().observe(this.V, new g());
        ((AEPituCameraUnit.an) n.a(this.V).get(AEPituCameraUnit.an.class)).f61910i.observe(this.V, new h());
    }

    public void Y() {
        if (SimpleUIUtil.isNowElderMode()) {
            X(R.id.rqy);
            X(R.id.rx9);
            X(R.id.rzc);
            X(R.id.rty);
            X(R.id.rrv);
            int dip2px = ViewUtils.dip2px(16.0f);
            BaseAIOUtils.h(this.J, dip2px, dip2px, dip2px, dip2px);
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public <T> T get(int i3, Object... objArr) {
        return (T) super.get(i3, objArr);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart, com.tencent.aelight.camera.ae.part.b
    protected void initView() {
        boolean z16;
        ms.a.a("AETopRightBarPart", "initView");
        this.f63342l0 = LiuHaiUtils.sNotchHeight;
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1s);
        this.U = this.mRootView.findViewById(R.id.f163717rm4);
        if (viewStub != null) {
            this.U = viewStub.inflate();
        }
        this.f63335e0 = (AECompoundButton) this.U.findViewById(R.id.rx7);
        this.f63341k0 = this.U.findViewById(R.id.rx8);
        this.f63335e0.setOnClickListener(this);
        AECompoundButton aECompoundButton = (AECompoundButton) this.U.findViewById(R.id.rqx);
        this.f63333c0 = aECompoundButton;
        aECompoundButton.setOnClickListener(this);
        AECompoundButton aECompoundButton2 = this.f63333c0;
        aECompoundButton2.setContentDescription(aECompoundButton2.getResources().getString(R.string.y9u));
        if (!com.tencent.aelight.camera.ae.flashshow.util.f.a()) {
            this.f63333c0.setVisibility(4);
            this.f63333c0.setEnabled(false);
        }
        vq.a.f443174a.b(this.f63333c0, "em_ae_switch_btn");
        this.f63339i0 = this.U.findViewById(R.id.rzb);
        AECompoundButton aECompoundButton3 = (AECompoundButton) this.U.findViewById(R.id.rza);
        this.f63334d0 = aECompoundButton3;
        if (aECompoundButton3 != null) {
            aECompoundButton3.setOnClickListener(this);
        }
        if (this.f63334d0 != null) {
            AECameraPrefsUtil f16 = AECameraPrefsUtil.f();
            AEVideoStoryTopBarViewModel.Ratio ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
            AEVideoStoryTopBarViewModel.Ratio fromCode = AEVideoStoryTopBarViewModel.Ratio.fromCode(f16.g(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, ratio.code, 0));
            if (fromCode == ratio) {
                this.f63334d0.a().setImageResource(R.drawable.iwt);
            } else if (fromCode == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
                this.f63334d0.a().setImageResource(R.drawable.iws);
            }
        }
        this.f63337g0 = this.U.findViewById(R.id.rzp);
        AECompoundButton aECompoundButton4 = (AECompoundButton) this.U.findViewById(R.id.rts);
        this.G = aECompoundButton4;
        aECompoundButton4.setOnClickListener(this);
        View findViewById = this.U.findViewById(R.id.rrt);
        this.f63340j0 = findViewById;
        findViewById.setVisibility(8);
        AECompoundButton aECompoundButton5 = (AECompoundButton) this.U.findViewById(R.id.rru);
        this.f63336f0 = aECompoundButton5;
        aECompoundButton5.setOnClickListener(this);
        this.f63336f0.setSelected(false);
        AEPituCameraUnit aEPituCameraUnit = this.V;
        if (aEPituCameraUnit != null && (z16 = aEPituCameraUnit.J0)) {
            aEPituCameraUnit.i3(z16, this.f63340j0);
        }
        AECompoundButton aECompoundButton6 = (AECompoundButton) this.U.findViewById(R.id.rqh);
        this.J = aECompoundButton6;
        aECompoundButton6.setOnClickListener(this);
        this.J.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b06;
                b06 = AETopRightBarPart.b0(view, motionEvent);
                return b06;
            }
        });
        this.f63338h0 = this.U.findViewById(R.id.rtu);
        initViewModel();
        Y();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.rqh /* 2097545379 */:
                VideoReport.reportEvent("dt_clck", this.J, null);
                break;
            case R.id.rqx /* 2097545395 */:
                AEPituCameraUnit aEPituCameraUnit = this.V;
                if (aEPituCameraUnit != null) {
                    aEPituCameraUnit.z2(this.f63333c0);
                    break;
                }
                break;
            case R.id.rru /* 2097545429 */:
                AECompoundButton aECompoundButton = this.f63336f0;
                if (aECompoundButton != null) {
                    com.tencent.aelight.camera.aioeditor.capture.view.a.d(aECompoundButton.a(), 200L, null);
                    boolean z16 = !this.f63336f0.isSelected();
                    this.f63336f0.setSelected(z16);
                    this.V.m0(z16);
                    this.V.f61851k1 = !z16;
                    gm2.d.f(z16);
                    com.tencent.aelight.camera.aioeditor.b.b(z16 ? 1 : 2);
                    break;
                }
                break;
            case R.id.rx7 /* 2097545626 */:
                if (W(HardCodeUtil.qqStr(R.string.xzx))) {
                    com.tencent.aelight.camera.ae.report.b.b().l1();
                    com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.f63335e0.a(), 200L, null);
                    VSReporter.m("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
                    com.tencent.aelight.camera.ae.report.b.b().U();
                    if (this.f63344n0 != null) {
                        this.V.I1().a(true, 150);
                        this.f63344n0.show();
                        this.X.L1().postValue(Boolean.TRUE);
                        break;
                    } else if (this.mPartManager != null) {
                        if (this.X.S1()) {
                            this.mPartManager.q(327686, new Object[0]);
                            break;
                        } else {
                            this.mPartManager.q(131077, new Object[0]);
                            break;
                        }
                    }
                }
                break;
            case R.id.rza /* 2097545704 */:
                AEVideoStoryTopBarViewModel.Ratio value = this.W.f63374m.getValue();
                ms.a.a("AETopRightBarPart", "adjustRatio screen radtio: " + value);
                AEVideoStoryTopBarViewModel.Ratio ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
                if (value == ratio) {
                    value = AEVideoStoryTopBarViewModel.Ratio.R_16_9;
                    AECompoundButton aECompoundButton2 = this.f63334d0;
                    if (aECompoundButton2 != null) {
                        aECompoundButton2.a().setImageResource(R.drawable.iws);
                    }
                    this.W.f63374m.setValue(value);
                } else if (value == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
                    AECompoundButton aECompoundButton3 = this.f63334d0;
                    if (aECompoundButton3 != null) {
                        aECompoundButton3.a().setImageResource(R.drawable.iwt);
                    }
                    this.W.f63374m.setValue(ratio);
                    value = ratio;
                }
                if (value == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
                    str = "16VS9";
                } else {
                    str = "FULL";
                }
                com.tencent.aelight.camera.ae.report.b.b().P(str);
                break;
        }
        super.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart, com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        super.send(i3, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Observer<AECaptureModeChangingEvent> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (AETopRightBarPart.this.V.N1() != AECaptureMode.NORMAL || gq.a.J(AETopRightBarPart.this.V.z())) {
                return;
            }
            AETopRightBarPart.this.V.I1().g();
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent != null) {
                AETopRightBarPart aETopRightBarPart = AETopRightBarPart.this;
                if (aETopRightBarPart.U == null) {
                    return;
                }
                if (!gq.a.r(((com.tencent.aelight.camera.ae.part.b) aETopRightBarPart).mActivity.getIntent())) {
                    AETopRightBarPart.this.f63343m0 = aECaptureModeChangingEvent.f65599b;
                    if (AETopRightBarPart.this.f63343m0 != AECaptureMode.NORMAL) {
                        AETopRightBarPart.this.f63337g0.setVisibility(8);
                        return;
                    }
                    AETopRightBarPart.this.f63337g0.setVisibility(0);
                    if (AETopRightBarPart.this.W != null && AETopRightBarPart.this.W.f63374m != null) {
                        AETopRightBarPart.this.W.f63374m.postValue(AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.f().g(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0)));
                    }
                    if (AETopRightBarPart.this.f63339i0 != null) {
                        ms.a.a("AETopRightBarPart", "mRatioSwitchView");
                        AETopRightBarPart.this.f63339i0.setVisibility(AETopRightBarPart.this.a0() ? 0 : 8);
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AETopRightBarPart.a.this.b();
                        }
                    });
                    return;
                }
                AETopRightBarPart.this.f63337g0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<bv> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(bv bvVar) {
            if (bvVar != null) {
                AETopRightBarPart.this.V(bvVar.getShow());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            if (ratio == null || AETopRightBarPart.this.f63334d0 == null) {
                return;
            }
            if (ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
                AETopRightBarPart.this.f63334d0.a().setImageResource(R.drawable.iwt);
            } else if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
                AETopRightBarPart.this.f63334d0.a().setImageResource(R.drawable.iws);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            AETopRightBarPart.this.U.setVisibility(bool.booleanValue() ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Pair pair) {
        if (pair == null) {
            return;
        }
        int i3 = ((Boolean) pair.getSecond()).booleanValue() ? 8 : 0;
        View view = this.f63338h0;
        if (view != null) {
            view.setVisibility(i3);
        }
        AECompoundButton aECompoundButton = this.J;
        if (aECompoundButton != null) {
            aECompoundButton.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z16) {
        int i3 = z16 ? 8 : 0;
        this.f63341k0.setVisibility(i3);
        if (a0()) {
            this.f63339i0.setVisibility(i3);
        } else {
            this.f63339i0.setVisibility(8);
        }
        this.f63338h0.setVisibility(i3);
        this.J.setVisibility(i3);
        if (z16) {
            this.f63340j0.setVisibility(8);
        }
    }
}
