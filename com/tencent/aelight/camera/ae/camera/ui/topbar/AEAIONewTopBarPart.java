package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.light.DeviceConstants;
import org.light.DeviceSupportUtil;

/* loaded from: classes32.dex */
public class AEAIONewTopBarPart extends com.tencent.aelight.camera.ae.part.b implements View.OnClickListener {
    private LinearLayout C;
    private AECompoundButton D;
    private AECompoundButton E;
    private AECompoundButton F;
    public AECompoundButton G;
    private AECompoundButton H;
    private AECompoundButton I;
    private AECaptureMode J;
    boolean K;

    /* renamed from: d, reason: collision with root package name */
    private int f63316d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f63317e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f63318f;

    /* renamed from: h, reason: collision with root package name */
    private AEVideoStoryTopBarViewModel f63319h;

    /* renamed from: i, reason: collision with root package name */
    private AEPituCameraUnit f63320i;

    /* renamed from: m, reason: collision with root package name */
    private View f63321m;

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
            AEAIONewTopBarPart.this.J = aECaptureMode;
            if (aECaptureMode == AECaptureMode.NORMAL) {
                AECompoundButton aECompoundButton = AEAIONewTopBarPart.this.G;
                if (aECompoundButton != null) {
                    aECompoundButton.setVisibility(8);
                }
                if (AEAIONewTopBarPart.this.E != null) {
                    AEAIONewTopBarPart.this.E.setVisibility(8);
                }
                if (AEAIONewTopBarPart.this.C != null) {
                    AEAIONewTopBarPart.this.C.setVisibility(8);
                }
            } else {
                if (aECaptureMode == AECaptureMode.GIF) {
                    if (AEAIONewTopBarPart.this.f63321m != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AEAIONewTopBarPart.this.f63321m.getLayoutParams();
                        marginLayoutParams.topMargin = x.c(BaseApplication.getContext(), 48.0f);
                        AEAIONewTopBarPart.this.f63321m.setLayoutParams(marginLayoutParams);
                    }
                    AECompoundButton aECompoundButton2 = AEAIONewTopBarPart.this.G;
                    if (aECompoundButton2 != null) {
                        aECompoundButton2.setVisibility(0);
                    }
                    if (AEAIONewTopBarPart.this.E != null) {
                        AEAIONewTopBarPart.this.E.setVisibility(8);
                    }
                    if (AEAIONewTopBarPart.this.C != null) {
                        AEAIONewTopBarPart.this.C.setVisibility(0);
                    }
                    AEAIONewTopBarPart.this.H.setVisibility(0);
                    AEAIONewTopBarPart.this.f63316d = 3;
                    try {
                        z16 = DeviceSupportUtil.isAbilityDeviceSupport(DeviceConstants.DEVICE_SHARE_GLCONTEXT_ERROR);
                    } catch (Exception e16) {
                        ms.a.c("AEVideoStoryTopBarPart", "[DeviceSupportUtil.isAbilityDeviceSupport] e = " + e16.toString());
                        z16 = false;
                    }
                    ms.a.a("AEVideoStoryTopBarPart", "[initViewModel]: deviceNotSupportSegment = " + z16);
                    AEAIONewTopBarPart.this.I.setVisibility(z16 ? 8 : 0);
                } else if (aECaptureMode == AECaptureMode.PLAY) {
                    if (AEAIONewTopBarPart.this.f63321m != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) AEAIONewTopBarPart.this.f63321m.getLayoutParams();
                        marginLayoutParams2.topMargin = x.c(BaseApplication.getContext(), 48.0f);
                        AEAIONewTopBarPart.this.f63321m.setLayoutParams(marginLayoutParams2);
                    }
                    AECompoundButton aECompoundButton3 = AEAIONewTopBarPart.this.G;
                    if (aECompoundButton3 != null) {
                        aECompoundButton3.setVisibility(8);
                    }
                    if (AEAIONewTopBarPart.this.E != null) {
                        AEAIONewTopBarPart.this.E.setVisibility(0);
                        AEAIONewTopBarPart.this.E.a().setImageResource(R.drawable.iyt);
                    }
                    AEAIONewTopBarPart.this.C.setVisibility(8);
                }
            }
            if (AEAIONewTopBarPart.this.w()) {
                AEAIONewTopBarPart.this.F.setVisibility(8);
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
            ms.a.a("AEVideoStoryTopBarPart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011-> observe ->\u66f4\u65b0\u6309\u94ae\u72b6\u6001:" + bool);
            if (bool == null) {
                return;
            }
            AEAIONewTopBarPart.this.I.setSelected(bool.booleanValue());
        }
    }

    public AEAIONewTopBarPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.f63316d = 3;
        this.K = false;
        this.f63320i = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    private void initViewModel() {
        this.f63317e = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f63320i).get(com.tencent.aelight.camera.ae.mode.c.class);
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) n.a(this.f63320i).get(AEVideoStoryTopBarViewModel.class);
        this.f63319h = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.M1().observe(this.f63320i, new a());
        this.f63319h.O1().observe(this.f63320i, new Observer<Boolean>() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(Boolean bool) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
        this.f63317e.f65622i.observe(this.f63320i, new b());
        this.f63319h.P1().observe(this.f63320i, new c());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.f63320i).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f63318f = aVar;
        aVar.M1().observe(this.f63320i, new d());
        this.f63318f.P1().observe(this.f63320i, new e());
        this.f63318f.L1().observe(this.f63320i, new f());
        this.f63318f.Q1().observe(this.f63320i, new g());
    }

    private boolean x() {
        Boolean value;
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f63319h;
        if (aEVideoStoryTopBarViewModel == null || aEVideoStoryTopBarViewModel.P1() == null || (value = this.f63319h.P1().getValue()) == null) {
            return false;
        }
        return value.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16) {
        boolean z17;
        if (z16) {
            if (this.f63317e.N1()) {
                try {
                    z17 = DeviceSupportUtil.isAbilityDeviceSupport(DeviceConstants.DEVICE_SHARE_GLCONTEXT_ERROR);
                } catch (Exception e16) {
                    ms.a.c("AEVideoStoryTopBarPart", "[DeviceSupportUtil.isAbilityDeviceSupport] e = " + e16.toString());
                    z17 = false;
                }
                ms.a.a("AEVideoStoryTopBarPart", "[switchOnLowPriorityTopBtns]: deviceNotSupportSegment = " + z17);
                this.I.setVisibility(z17 ? 8 : 0);
                this.H.setVisibility(0);
            }
            this.F.setVisibility(0);
        } else {
            if (this.f63317e.N1()) {
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
            this.F.setVisibility(8);
        }
        if (w()) {
            this.F.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1u);
        this.K = gq.a.l(this.mActivity.getIntent());
        if (viewStub != null) {
            this.f63321m = viewStub.inflate();
        }
        this.f63321m = this.mRootView.findViewById(R.id.f163726ro3);
        this.C = (LinearLayout) this.mRootView.findViewById(R.id.f163735rq2);
        AECompoundButton aECompoundButton = (AECompoundButton) this.f63321m.findViewById(R.id.rqh);
        this.G = aECompoundButton;
        aECompoundButton.setOnClickListener(this);
        AECompoundButton aECompoundButton2 = (AECompoundButton) this.f63321m.findViewById(R.id.rqi);
        this.E = aECompoundButton2;
        aECompoundButton2.setOnClickListener(this);
        this.D = (AECompoundButton) this.f63321m.findViewById(R.id.rqx);
        AECompoundButton aECompoundButton3 = (AECompoundButton) this.f63321m.findViewById(R.id.rok);
        this.F = aECompoundButton3;
        aECompoundButton3.setOnClickListener(this);
        AECompoundButton aECompoundButton4 = (AECompoundButton) this.f63321m.findViewById(R.id.rre);
        this.H = aECompoundButton4;
        aECompoundButton4.setOnClickListener(this);
        AECompoundButton aECompoundButton5 = (AECompoundButton) this.f63321m.findViewById(R.id.f163800s25);
        this.I = aECompoundButton5;
        aECompoundButton5.setOnClickListener(this);
        this.I.setSelected(false);
        initViewModel();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f63319h;
        if (aEVideoStoryTopBarViewModel == null || aEVideoStoryTopBarViewModel.P1() == null) {
            return;
        }
        ms.a.a("AEVideoStoryTopBarPart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011-> onResume -> post:" + x());
        this.f63319h.P1().postValue(Boolean.valueOf(x()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        boolean z16 = false;
        switch (view.getId()) {
            case R.id.rok /* 2097545309 */:
                com.tencent.aelight.camera.ae.report.b.b().l1();
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.F.a(), 200L, null);
                VSReporter.m("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
                if (AEDashboardUtil.q()) {
                    com.tencent.aelight.camera.ae.report.b.b().U();
                }
                if (this.mPartManager != null) {
                    if (this.f63318f.S1()) {
                        this.mPartManager.q(327686, new Object[0]);
                        break;
                    } else if (!this.f63318f.R1()) {
                        this.mPartManager.q(131077, new Object[0]);
                        break;
                    }
                }
                break;
            case R.id.rpv /* 2097545356 */:
                if (this.mPartManager != null) {
                    com.tencent.aelight.camera.ae.report.b.b().M1();
                    this.mPartManager.q(FileMsg.TRANSFILE_TYPE_MULTIMSG, new Object[0]);
                    break;
                }
                break;
            case R.id.rqh /* 2097545379 */:
            case R.id.rqi /* 2097545380 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, null);
                this.f63320i.x2();
                break;
            case R.id.rre /* 2097545413 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.H.a(), 200L, null);
                AEVideoStoryTopBarViewModel.a value = this.f63319h.M1().getValue();
                if (value != null && value.b()) {
                    z16 = true;
                }
                this.f63319h.M1().postValue(new AEVideoStoryTopBarViewModel.a(!z16, this.f63316d));
                if (this.f63317e.N1()) {
                    AEBaseReportParam.U().W0(!z16);
                    break;
                }
                break;
            case R.id.f163800s25 /* 2097545809 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.I.a(), 200L, null);
                boolean x16 = x();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u3010\u62a0\u80cc\u5f00\u5173\u3011-> \u70b9\u51fb ->post:");
                sb5.append(!x16);
                ms.a.a("AEVideoStoryTopBarPart", sb5.toString());
                this.f63319h.P1().postValue(Boolean.valueOf(!x16));
                if (this.f63317e.N1()) {
                    AEBaseReportParam.U().X0(!x16);
                    com.tencent.aelight.camera.ae.report.b.b().W0();
                    break;
                }
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected boolean w() {
        return (this.f63320i.C().w() && this.f63320i.C().y() && this.f63320i.C().A()) ? false : true;
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
            AEAIONewTopBarPart.this.H.setSelected(aVar.b());
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
            AEAIONewTopBarPart.this.f63321m.setVisibility(bool.booleanValue() ? 0 : 4);
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
            AEAIONewTopBarPart.this.y(!bool.booleanValue());
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
            AEAIONewTopBarPart.this.y(!bool.booleanValue());
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
            AEAIONewTopBarPart.this.y(!bool.booleanValue());
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel;
        if (i3 != 458753 || (aEVideoStoryTopBarViewModel = this.f63319h) == null || aEVideoStoryTopBarViewModel.P1() == null) {
            return;
        }
        ms.a.a("AEVideoStoryTopBarPart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011-> \u76f8\u673a\u542f\u52a8\u68c0\u67e5 -> post:" + x());
        this.f63319h.P1().postValue(Boolean.valueOf(x()));
    }
}
