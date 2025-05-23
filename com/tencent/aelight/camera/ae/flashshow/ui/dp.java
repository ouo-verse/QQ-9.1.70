package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes32.dex */
public class dp extends lq.a implements View.OnClickListener {
    private LSMiddleCameraUnit C;
    private AECompoundButton D;
    private AEVideoStoryTopBarViewModel E;
    private com.tencent.aelight.camera.ae.part.a F;
    private ab G;
    private AEFlashShowBottomPanelViewModel H;
    private AECompoundButton I;
    public AECompoundButton J;
    public AECompoundButton K;
    private View L;
    private View M;
    private View N;
    private View P;
    private boolean Q;
    private int R;
    private boolean S;

    /* renamed from: m, reason: collision with root package name */
    View f64875m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Observer<AEFlashCameraCaptureButtonLayout.Style> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEFlashCameraCaptureButtonLayout.Style style) {
            int i3 = g.f64882a[style.ordinal()];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (dp.this.f64875m != null) {
                dp.this.f64875m.setVisibility(bool.booleanValue() ? 8 : 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (dp.this.f64875m == null || bool.booleanValue()) {
                return;
            }
            dp.this.f64875m.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f extends AccessibilityDelegateCompat {
        f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(Button.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f64882a;

        static {
            int[] iArr = new int[AEFlashCameraCaptureButtonLayout.Style.values().length];
            f64882a = iArr;
            try {
                iArr[AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64882a[AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public dp(Activity activity, View view, lq.b bVar) {
        super(activity, view, bVar);
        this.R = 3;
        this.S = true;
        this.C = (LSMiddleCameraUnit) bVar.b(65537, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Boolean bool) {
        if (bool.booleanValue()) {
            this.K.setForegroundResource(R.drawable.izd);
            this.K.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.do
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dp.this.z(view);
                }
            });
        } else {
            this.K.setForegroundResource(R.drawable.iw9);
            this.K.setOnClickListener(this);
        }
    }

    private void B(View view) {
        ViewCompat.setAccessibilityDelegate(view, new f());
    }

    public static View.OnTouchListener u() {
        return new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dn
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w3;
                w3 = dp.w(view, motionEvent);
                return w3;
            }
        };
    }

    private void v() {
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this.C).get(AEVideoStoryTopBarViewModel.class);
        this.E = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.M1().observe(this.C, new a());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this.C).get(com.tencent.aelight.camera.ae.part.a.class);
        this.F = aVar;
        aVar.M1().observe(this.C, new b());
        ab abVar = (ab) com.tencent.aelight.camera.ae.n.a(this.C).get(ab.class);
        this.G = abVar;
        abVar.L1().observe(this.C, new c());
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this.C).get(AEFlashShowBottomPanelViewModel.class);
        this.H = aEFlashShowBottomPanelViewModel;
        aEFlashShowBottomPanelViewModel.e2().observe(this.C, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dl
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dp.this.y((Pair) obj);
            }
        });
        this.H.k2().observe(this.C, new d());
        this.H.f2().observe(this.C, new e());
        this.E.Q1().observe(this.C, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dp.this.A((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean w(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            view.setAlpha(0.5f);
        } else if (motionEvent.getActionMasked() == 1) {
            view.setAlpha(1.0f);
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.M.setAlpha(0.5f);
        } else if (motionEvent.getActionMasked() == 1) {
            this.M.setAlpha(1.0f);
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.C.k2();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // lq.a
    public <T> T d(int i3, Object... objArr) {
        return (T) super.d(i3, objArr);
    }

    @Override // lq.a
    protected void e() {
        ViewStub viewStub = (ViewStub) this.f415376e.findViewById(R.id.s1s);
        this.f64875m = this.f415376e.findViewById(R.id.f163717rm4);
        if (viewStub != null) {
            this.f64875m = viewStub.inflate();
        }
        AECompoundButton aECompoundButton = (AECompoundButton) this.f64875m.findViewById(R.id.rta);
        this.I = aECompoundButton;
        aECompoundButton.setOnClickListener(this);
        B(this.I);
        AECompoundButton aECompoundButton2 = (AECompoundButton) this.f64875m.findViewById(R.id.rts);
        this.J = aECompoundButton2;
        aECompoundButton2.setOnClickListener(this);
        this.J.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dk
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x16;
                x16 = dp.this.x(view, motionEvent);
                return x16;
            }
        });
        this.J.setSelected(this.Q);
        B(this.J);
        AECompoundButton aECompoundButton3 = (AECompoundButton) this.f64875m.findViewById(R.id.rqh);
        this.K = aECompoundButton3;
        aECompoundButton3.setOnClickListener(this);
        this.K.setOnTouchListener(u());
        AECompoundButton aECompoundButton4 = (AECompoundButton) this.f64875m.findViewById(R.id.rrr);
        this.D = aECompoundButton4;
        aECompoundButton4.setOnClickListener(this);
        B(this.D);
        this.N = this.f64875m.findViewById(R.id.rrs);
        View findViewById = this.f64875m.findViewById(R.id.rtc);
        this.L = findViewById;
        findViewById.setOnClickListener(this);
        this.L.setOnTouchListener(u());
        this.M = this.f64875m.findViewById(R.id.rtu);
        VideoReport.setElementId(this.I, WinkDaTongReportConstant.ElementId.EM_XSJ_FILTER_BUTTON);
        VideoReport.setElementId(this.K, "em_xsj_close_button");
        v();
    }

    @Override // lq.a
    public void h() {
        super.h();
        AECompoundButton aECompoundButton = this.J;
        if (aECompoundButton != null) {
            aECompoundButton.setSelected(this.Q);
        }
    }

    @Override // lq.a
    public void l(int i3, Object... objArr) {
        super.l(i3, objArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        MutableLiveData<Boolean> l26 = AEFlashShowBottomPanelViewModel.l2();
        Boolean bool = Boolean.TRUE;
        l26.postValue(bool);
        switch (view.getId()) {
            case R.id.ror /* 2097545316 */:
            case R.id.ros /* 2097545317 */:
                this.H.d2().postValue(bool);
                VideoReport.reportEvent("dt_clck", this.P, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
                break;
            case R.id.rqh /* 2097545379 */:
                this.E.L1().setValue(bool);
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, null);
                this.C.k2();
                break;
            case R.id.rrr /* 2097545426 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.D.a(), 200L, null);
                int i3 = this.R;
                if (i3 == 0) {
                    this.D.a().setImageResource(R.drawable.iw_);
                    this.D.setContentDescription("\u5012\u8ba1\u65f6");
                } else if (i3 == 3) {
                    this.D.a().setImageResource(R.drawable.irr);
                    this.D.setContentDescription("\u5012\u8ba1\u65f63\u79d2");
                } else if (i3 == 10) {
                    this.D.a().setImageResource(R.drawable.irq);
                    this.D.setContentDescription("\u5012\u8ba1\u65f610\u79d2");
                }
                this.E.M1().postValue(new AEVideoStoryTopBarViewModel.a(this.S, this.R));
                break;
            case R.id.rta /* 2097545483 */:
            case R.id.rtc /* 2097545485 */:
                this.H.h2().setValue(bool);
                VideoReport.reportEvent("dt_clck", this.I, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
                break;
            case R.id.rts /* 2097545500 */:
                com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.J.a(), 200L, null);
                boolean z16 = !this.J.isSelected();
                if (this.C.l0(z16)) {
                    this.Q = z16;
                    this.J.setSelected(z16);
                    if (ms.a.h()) {
                        ms.a.a("AEFlashShowRightBarPart", "onClick, mFlashButton.setSelected(), on=" + z16);
                    }
                }
                com.tencent.aelight.camera.ae.report.b.b().P0();
                AECompoundButton aECompoundButton = this.J;
                StringBuilder sb5 = new StringBuilder();
                if (this.Q) {
                    str = "\u6253\u5f00";
                } else {
                    str = "\u5173\u95ed";
                }
                sb5.append(str);
                sb5.append("\u95ea\u5149\u706f");
                aECompoundButton.setContentDescription(sb5.toString());
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // lq.a
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
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
            if (!aVar.b() && dp.this.D != null) {
                dp.this.D.a().setImageResource(R.drawable.iw_);
            }
            int a16 = aVar.a();
            if (a16 == 0) {
                dp.this.R = 3;
                dp.this.S = true;
            } else if (a16 == 3) {
                dp.this.R = 10;
                dp.this.S = true;
            } else {
                if (a16 != 10) {
                    return;
                }
                dp.this.R = 0;
                dp.this.S = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            dp.this.f64875m.setVisibility(bool.booleanValue() ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Pair pair) {
        if (pair == null) {
            return;
        }
        int i3 = ((Boolean) pair.getSecond()).booleanValue() ? 8 : 0;
        View view = this.N;
        if (view != null) {
            view.setVisibility(i3);
        }
        View view2 = this.L;
        if (view2 != null) {
            view2.setVisibility(i3);
        }
        View view3 = this.M;
        if (view3 != null) {
            view3.setVisibility(i3);
        }
        AECompoundButton aECompoundButton = this.K;
        if (aECompoundButton != null) {
            aECompoundButton.setVisibility(i3);
        }
        View view4 = this.P;
        if (view4 != null) {
            view4.setVisibility(i3);
        }
    }
}
