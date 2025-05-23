package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.util.x;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import org.light.DeviceConstants;
import org.light.DeviceSupportUtil;

/* loaded from: classes32.dex */
public class AEVideoStoryTopBarPart extends com.tencent.aelight.camera.ae.part.b implements View.OnClickListener {
    private View C;
    private LinearLayout D;
    private AECompoundButton E;
    protected AECompoundButton F;
    public AECompoundButton G;
    private AECompoundButton H;
    private AECompoundButton I;
    public AECompoundButton J;
    private AECompoundButton K;
    private AECompoundButton L;
    private int M;
    private boolean N;
    private TextView P;
    private AECaptureMode Q;
    boolean R;
    boolean S;
    int T;

    /* renamed from: d, reason: collision with root package name */
    private int f63357d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f63358e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f63359f;

    /* renamed from: h, reason: collision with root package name */
    private AEVideoStoryTopBarViewModel f63360h;

    /* renamed from: i, reason: collision with root package name */
    private AEPituCameraUnit f63361i;

    /* renamed from: m, reason: collision with root package name */
    private View f63362m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.a("AEVideoStoryTopBarPart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011-> observe ->\u66f4\u65b0\u6309\u94ae\u72b6\u6001:" + bool);
            if (bool == null) {
                return;
            }
            AEVideoStoryTopBarPart.this.L.setSelected(bool.booleanValue());
        }
    }

    public AEVideoStoryTopBarPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.f63357d = 3;
        this.M = 0;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.f63361i = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    private int C() {
        int statusBarHeight;
        int i3 = this.M;
        Intent intent = this.mActivity.getIntent();
        if ((gq.a.r(intent) || gq.a.v(intent)) && i3 < (statusBarHeight = LiuHaiUtils.getStatusBarHeight(this.mActivity))) {
            ms.a.f("AEVideoStoryTopBarPart", "Circle camera, no LiuHai exists, statusBarHeight=" + statusBarHeight);
            i3 = statusBarHeight;
        }
        if (!F()) {
            return i3;
        }
        int applyDimension = (int) (i3 + TypedValue.applyDimension(1, 20.0f, this.mActivity.getResources().getDisplayMetrics()));
        x.c(this.mActivity, 20.0f);
        return applyDimension;
    }

    private boolean E() {
        Boolean value;
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f63360h;
        if (aEVideoStoryTopBarViewModel == null || aEVideoStoryTopBarViewModel.P1() == null || (value = this.f63360h.P1().getValue()) == null) {
            return false;
        }
        return value.booleanValue();
    }

    private boolean F() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Build.MANUFACTURER);
        sb5.append(";");
        sb5.append(DeviceInfoMonitor.getModel());
        return "VIVO;V1836T".equalsIgnoreCase(sb5.toString()) || "PEDM00".equalsIgnoreCase(DeviceInfoMonitor.getModel()) || "MT2110".equalsIgnoreCase(DeviceInfoMonitor.getModel()) || "PEGM00".equalsIgnoreCase(DeviceInfoMonitor.getModel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z16) {
        boolean z17;
        if (z16) {
            if (this.f63358e.N1()) {
                try {
                    z17 = DeviceSupportUtil.isAbilityDeviceSupport(DeviceConstants.DEVICE_SHARE_GLCONTEXT_ERROR);
                } catch (Exception e16) {
                    ms.a.c("AEVideoStoryTopBarPart", "[DeviceSupportUtil.isAbilityDeviceSupport] e = " + e16.toString());
                    z17 = false;
                }
                ms.a.a("AEVideoStoryTopBarPart", "[switchOnLowPriorityTopBtns]: deviceNotSupportSegment = " + z17);
                this.L.setVisibility(z17 ? 8 : 0);
                this.K.setVisibility(0);
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(0);
            }
            this.I.setVisibility(0);
            AECompoundButton aECompoundButton = this.H;
            if (aECompoundButton != null) {
                aECompoundButton.setVisibility(0);
            }
        } else {
            if (this.f63358e.N1()) {
                this.L.setVisibility(8);
                this.K.setVisibility(8);
            }
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.I.setVisibility(8);
            AECompoundButton aECompoundButton2 = this.H;
            if (aECompoundButton2 != null) {
                aECompoundButton2.setVisibility(8);
            }
        }
        if (D()) {
            this.I.setVisibility(8);
        }
    }

    private void initViewModel() {
        this.f63358e = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f63361i).get(com.tencent.aelight.camera.ae.mode.c.class);
        TextView textView = this.P;
        if (textView != null) {
            textView.setVisibility(8);
        }
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) n.a(this.f63361i).get(AEVideoStoryTopBarViewModel.class);
        this.f63360h = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.M1().observe(this.f63361i, new a());
        this.f63360h.O1().observe(this.f63361i, new Observer<Boolean>() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(final Boolean bool) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AEVideoStoryTopBarPart.this.f63361i != null) {
                            AEVideoStoryTopBarPart.this.f63361i.i3(bool.booleanValue(), AEVideoStoryTopBarPart.this.F);
                        }
                    }
                });
            }
        });
        this.f63358e.f65622i.observe(this.f63361i, new b());
        this.f63360h.P1().observe(this.f63361i, new c());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.f63361i).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f63359f = aVar;
        aVar.M1().observe(this.f63361i, new d());
        this.f63359f.P1().observe(this.f63361i, new e());
        this.f63359f.L1().observe(this.f63361i, new f());
        this.f63359f.Q1().observe(this.f63361i, new g());
    }

    protected boolean D() {
        return (this.f63361i.C().w() && this.f63361i.C().y() && this.f63361i.C().A()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        boolean z16;
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1t);
        this.M = LiuHaiUtils.sNotchHeight;
        this.R = gq.a.l(this.mActivity.getIntent());
        this.S = gq.a.r(this.mActivity.getIntent());
        if (viewStub != null) {
            this.f63362m = viewStub.inflate();
        }
        View findViewById = this.mRootView.findViewById(R.id.f163757ru4);
        this.f63362m = findViewById;
        if (findViewById != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.topMargin = C();
            this.f63362m.setLayoutParams(marginLayoutParams);
            this.C = this.f63362m.findViewById(R.id.rql);
            this.D = (LinearLayout) this.mRootView.findViewById(R.id.f163735rq2);
            AECompoundButton aECompoundButton = (AECompoundButton) this.f63362m.findViewById(R.id.rqh);
            this.J = aECompoundButton;
            aECompoundButton.setOnClickListener(this);
            this.E = (AECompoundButton) this.f63362m.findViewById(R.id.rqx);
            AECompoundButton aECompoundButton2 = (AECompoundButton) this.f63362m.findViewById(R.id.rru);
            this.F = aECompoundButton2;
            aECompoundButton2.setOnClickListener(this);
            this.F.setSelected(false);
            AEPituCameraUnit aEPituCameraUnit = this.f63361i;
            if (aEPituCameraUnit != null && (z16 = aEPituCameraUnit.J0)) {
                aEPituCameraUnit.i3(z16, this.F);
            }
            AECompoundButton aECompoundButton3 = (AECompoundButton) this.f63362m.findViewById(R.id.rok);
            this.I = aECompoundButton3;
            aECompoundButton3.setOnClickListener(this);
            AECompoundButton aECompoundButton4 = (AECompoundButton) this.f63362m.findViewById(R.id.rpv);
            this.H = aECompoundButton4;
            if (aECompoundButton4 != null) {
                aECompoundButton4.setOnClickListener(this);
            }
            TextView textView = (TextView) this.mRootView.findViewById(R.id.s2q);
            this.P = textView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.G = (AECompoundButton) this.f63362m.findViewById(R.id.rts);
            AECompoundButton aECompoundButton5 = (AECompoundButton) this.f63362m.findViewById(R.id.rre);
            this.K = aECompoundButton5;
            aECompoundButton5.setOnClickListener(this);
            AECompoundButton aECompoundButton6 = (AECompoundButton) this.f63362m.findViewById(R.id.f163800s25);
            this.L = aECompoundButton6;
            aECompoundButton6.setOnClickListener(this);
            this.L.setSelected(false);
            this.G.setOnClickListener(this);
            this.G.setSelected(this.N);
            initViewModel();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f63360h;
        if (aEVideoStoryTopBarViewModel != null && aEVideoStoryTopBarViewModel.P1() != null) {
            ms.a.a("AEVideoStoryTopBarPart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011-> onResume -> post:" + E());
            this.f63360h.P1().postValue(Boolean.valueOf(E()));
        }
        AECompoundButton aECompoundButton = this.G;
        if (aECompoundButton != null) {
            aECompoundButton.setSelected(this.N);
        }
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        boolean r16 = gq.a.r(this.f63361i.z().getIntent());
        boolean z16 = false;
        switch (view.getId()) {
            case R.id.rok /* 2097545309 */:
                com.tencent.aelight.camera.ae.report.b.b().l1();
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.I.a(), 200L, null);
                VSReporter.m("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
                if (AEDashboardUtil.q()) {
                    com.tencent.aelight.camera.ae.report.b.b().U();
                }
                if (this.mPartManager != null) {
                    if (this.f63359f.S1()) {
                        this.mPartManager.q(327686, new Object[0]);
                        break;
                    } else if (!this.f63359f.R1()) {
                        if (r16) {
                            if (!com.tencent.aelight.camera.ae.util.e.a(view)) {
                                Intent intent = new Intent();
                                intent.setAction("ae_editor_bottom_tab_show_hide");
                                intent.putExtra("is_show", false);
                                this.f63361i.z().sendBroadcast(intent);
                                com.tencent.aelight.camera.aebase.c.b(10, null);
                            }
                        }
                        this.mPartManager.q(131077, new Object[0]);
                        break;
                    }
                }
                break;
            case R.id.rpv /* 2097545356 */:
                if (this.mPartManager != null) {
                    if (r16) {
                        if (!com.tencent.aelight.camera.ae.util.e.a(view)) {
                            Intent intent2 = new Intent();
                            intent2.setAction("ae_editor_bottom_tab_show_hide");
                            intent2.putExtra("is_show", false);
                            this.f63361i.z().sendBroadcast(intent2);
                            com.tencent.aelight.camera.aebase.c.b(7, null);
                        }
                    }
                    com.tencent.aelight.camera.ae.report.b.b().M1();
                    this.mPartManager.q(FileMsg.TRANSFILE_TYPE_MULTIMSG, new Object[0]);
                    break;
                }
                break;
            case R.id.rqh /* 2097545379 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, null);
                this.f63361i.x2();
                if (r16) {
                    com.tencent.aelight.camera.aebase.c.b(3, null);
                    break;
                }
                break;
            case R.id.rre /* 2097545413 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.K.a(), 200L, null);
                AEVideoStoryTopBarViewModel.a value = this.f63360h.M1().getValue();
                if (value != null && value.b()) {
                    z16 = true;
                }
                this.f63360h.M1().postValue(new AEVideoStoryTopBarViewModel.a(!z16, this.f63357d));
                if (this.f63358e.N1()) {
                    AEBaseReportParam.U().W0(!z16);
                    break;
                }
                break;
            case R.id.rru /* 2097545429 */:
                AECompoundButton aECompoundButton = this.F;
                if (aECompoundButton != null) {
                    com.tencent.aelight.camera.aioeditor.capture.view.a.d(aECompoundButton.a(), 200L, null);
                    boolean z17 = !this.F.isSelected();
                    this.F.setSelected(z17);
                    this.f63361i.m0(z17);
                    if (!z17) {
                        this.f63361i.f61851k1 = true;
                    } else {
                        this.f63361i.f61851k1 = false;
                    }
                    gm2.d.f(z17);
                    com.tencent.aelight.camera.aioeditor.b.b(z17 ? 1 : 2);
                    break;
                }
                break;
            case R.id.rts /* 2097545500 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.G.a(), 200L, null);
                boolean z18 = !this.G.isSelected();
                if (this.f63361i.n0(z18)) {
                    this.N = z18;
                    this.G.setSelected(z18);
                    if (ms.a.h()) {
                        ms.a.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + z18);
                    }
                }
                com.tencent.aelight.camera.ae.report.b.b().P0();
                if (r16) {
                    com.tencent.aelight.camera.aebase.c.b(6, null);
                    break;
                }
                break;
            case R.id.f163800s25 /* 2097545809 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.L.a(), 200L, null);
                boolean E = E();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u3010\u62a0\u80cc\u5f00\u5173\u3011-> \u70b9\u51fb ->post:");
                sb5.append(!E);
                ms.a.a("AEVideoStoryTopBarPart", sb5.toString());
                this.f63360h.P1().postValue(Boolean.valueOf(!E));
                if (this.f63358e.N1()) {
                    AEBaseReportParam.U().X0(!E);
                    com.tencent.aelight.camera.ae.report.b.b().W0();
                    break;
                }
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Observer<AEVideoStoryTopBarViewModel.a> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.a aVar) {
            if (aVar == null) {
                return;
            }
            AEVideoStoryTopBarPart.this.K.setSelected(aVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Observer<AECaptureModeChangingEvent> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            boolean z16;
            if (aECaptureModeChangingEvent == null) {
                return;
            }
            AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
            AEVideoStoryTopBarPart.this.Q = aECaptureMode;
            ms.a.a("AEVideoStoryTopBarPart", "arcake : captureModeChangedLiveData" + aECaptureMode.toString());
            if (aECaptureMode == AECaptureMode.NORMAL) {
                if (!gq.a.r(((com.tencent.aelight.camera.ae.part.b) AEVideoStoryTopBarPart.this).mActivity.getIntent())) {
                    AEVideoStoryTopBarPart.this.J.a().setImageResource(R.drawable.iyt);
                    if (AEVideoStoryTopBarPart.this.C != null) {
                        AEVideoStoryTopBarPart.this.C.setVisibility(8);
                    }
                    if (AEVideoStoryTopBarPart.this.D != null) {
                        AEVideoStoryTopBarPart.this.D.setVisibility(8);
                        return;
                    }
                    return;
                }
                AEVideoStoryTopBarPart.this.D.setVisibility(0);
                if (!gq.a.r(((com.tencent.aelight.camera.ae.part.b) AEVideoStoryTopBarPart.this).mActivity.getIntent())) {
                    AEVideoStoryTopBarPart.this.E.a().setImageResource(R.drawable.f159994iu3);
                }
                AEVideoStoryTopBarPart.this.G.setVisibility(0);
                if (aECaptureMode.getHasCountDown()) {
                    AEVideoStoryTopBarPart.this.I.setVisibility(8);
                    AEVideoStoryTopBarPart.this.K.a().setImageResource(R.drawable.f159992iu1);
                    AEVideoStoryTopBarPart.this.K.setVisibility(0);
                    AEVideoStoryTopBarPart.this.f63357d = 10;
                } else {
                    if (!gq.a.r(((com.tencent.aelight.camera.ae.part.b) AEVideoStoryTopBarPart.this).mActivity.getIntent())) {
                        AEVideoStoryTopBarPart.this.I.a().setImageResource(R.drawable.isd);
                    }
                    AEVideoStoryTopBarPart.this.I.setVisibility(0);
                    AEVideoStoryTopBarPart.this.K.setVisibility(8);
                }
                AEVideoStoryTopBarPart.this.L.setVisibility(8);
            } else if (aECaptureMode == AECaptureMode.GIF) {
                if (AEVideoStoryTopBarPart.this.C != null) {
                    AEVideoStoryTopBarPart.this.C.setVisibility(0);
                }
                if (AEVideoStoryTopBarPart.this.D != null) {
                    AEVideoStoryTopBarPart.this.D.setVisibility(0);
                }
                AEVideoStoryTopBarPart.this.J.a().setImageResource(R.drawable.iys);
                AEVideoStoryTopBarPart.this.E.a().setImageResource(R.drawable.f159993iu2);
                AEVideoStoryTopBarPart.this.I.a().setImageResource(R.drawable.isc);
                AEVideoStoryTopBarPart.this.G.setVisibility(8);
                AEVideoStoryTopBarPart.this.K.a().setImageResource(R.drawable.ise);
                AEVideoStoryTopBarPart.this.K.setVisibility(0);
                AEVideoStoryTopBarPart.this.f63357d = 3;
                try {
                    z16 = DeviceSupportUtil.isAbilityDeviceSupport(DeviceConstants.DEVICE_SHARE_GLCONTEXT_ERROR);
                } catch (Exception e16) {
                    ms.a.c("AEVideoStoryTopBarPart", "[DeviceSupportUtil.isAbilityDeviceSupport] e = " + e16.toString());
                    z16 = false;
                }
                ms.a.a("AEVideoStoryTopBarPart", "[initViewModel]: deviceNotSupportSegment = " + z16);
                AEVideoStoryTopBarPart.this.L.setVisibility(z16 ? 8 : 0);
            } else if (aECaptureMode == AECaptureMode.PLAY) {
                if (AEVideoStoryTopBarPart.this.C != null) {
                    AEVideoStoryTopBarPart.this.C.setVisibility(0);
                }
                AEVideoStoryTopBarPart.this.J.a().setImageResource(R.drawable.iyt);
                AEVideoStoryTopBarPart.this.D.setVisibility(8);
            } else if (aECaptureMode == AECaptureMode.ARCAKE) {
                if (AEVideoStoryTopBarPart.this.C != null) {
                    AEVideoStoryTopBarPart.this.C.setVisibility(0);
                }
                AEVideoStoryTopBarPart.this.J.a().setImageResource(R.drawable.ncu);
                AEVideoStoryTopBarPart.this.D.setVisibility(8);
                if (AEVideoStoryTopBarPart.this.P != null) {
                    AEVideoStoryTopBarPart.this.P.setVisibility(0);
                }
            }
            if (AEVideoStoryTopBarPart.this.D()) {
                AEVideoStoryTopBarPart.this.I.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            AEVideoStoryTopBarPart.this.f63362m.setVisibility(bool.booleanValue() ? 0 : 4);
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
            if (bool == null) {
                return;
            }
            AEVideoStoryTopBarPart.this.G(!bool.booleanValue());
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
            if (bool == null) {
                return;
            }
            AEVideoStoryTopBarPart.this.G(!bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            AEVideoStoryTopBarPart.this.G(!bool.booleanValue());
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel;
        if (i3 != 458753 || (aEVideoStoryTopBarViewModel = this.f63360h) == null || aEVideoStoryTopBarViewModel.P1() == null) {
            return;
        }
        ms.a.a("AEVideoStoryTopBarPart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011-> \u76f8\u673a\u542f\u52a8\u68c0\u67e5 -> post:" + E());
        this.f63360h.P1().postValue(Boolean.valueOf(E()));
    }
}
