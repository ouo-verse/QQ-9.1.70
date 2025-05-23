package com.tencent.aelight.camera.ae.camera.ui.simple;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.panel.ao;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.util.f;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes32.dex */
public class AESimpleCapturePart extends com.tencent.aelight.camera.ae.part.b implements View.OnClickListener {
    private AECompoundButton C;
    private View D;
    private View E;
    private View F;
    private View G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private final AEPituCameraUnit L;
    private int M;
    private ao N;
    private String P;
    private AEVideoStoryTopBarViewModel Q;
    private com.tencent.aelight.camera.ae.part.a R;

    /* renamed from: d, reason: collision with root package name */
    private View f63262d;

    /* renamed from: e, reason: collision with root package name */
    private AECompoundButton f63263e;

    /* renamed from: f, reason: collision with root package name */
    private AECompoundButton f63264f;

    /* renamed from: h, reason: collision with root package name */
    private AECompoundButton f63265h;

    /* renamed from: i, reason: collision with root package name */
    private AECompoundButton f63266i;

    /* renamed from: m, reason: collision with root package name */
    private AECompoundButton f63267m;

    /* loaded from: classes32.dex */
    class a implements com.tencent.aelight.camera.ae.camera.ui.simple.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.simple.a
        public void a() {
            boolean isFrontCamera = AESimpleCapturePart.this.L.D().isFrontCamera();
            AESimpleCapturePart.this.K(isFrontCamera);
            AESimpleCapturePart.this.G("0X800BFF3", isFrontCamera ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            AESimpleCapturePart.this.w(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<ao> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ao aoVar) {
            AESimpleCapturePart.this.N = aoVar;
        }
    }

    public AESimpleCapturePart(Activity activity, ViewStub viewStub, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, viewStub, cVar);
        this.M = -1;
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.L = aEPituCameraUnit;
        if (aEPituCameraUnit != null) {
            this.M = d.b(aEPituCameraUnit.C().q().f394449f);
            aEPituCameraUnit.S2(new a());
        }
    }

    private void A() {
        if (this.L == null) {
            return;
        }
        com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.f63263e.a(), 200L, null);
        boolean z16 = !this.f63263e.isSelected();
        if (this.L.n0(z16)) {
            this.f63263e.setSelected(z16);
            L(z16);
        }
        ReportController.o(null, "dc00898", "", "", "0X800BFF5", "0X800BFF5", this.M, 0, "", "", "", "");
    }

    private void B() {
        if (x()) {
            ReportController.o(null, "dc00898", "", "", "0x800C244", "0x800C244", this.M, 0, "", "", "", "");
            com.tencent.aelight.camera.ae.report.b.b().l1();
            com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.f63265h.a(), 200L, null);
            VSReporter.m("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
            com.tencent.aelight.camera.ae.report.b.b().U();
            if (this.N != null) {
                this.L.I1().a(true, 150);
                this.N.show();
                this.R.L1().postValue(Boolean.TRUE);
            } else if (this.mPartManager != null) {
                if (this.R.S1()) {
                    this.mPartManager.q(327686, new Object[0]);
                } else {
                    this.mPartManager.q(131077, new Object[0]);
                }
            }
        }
    }

    private void C() {
        AEVideoStoryTopBarViewModel.Ratio value = this.Q.f63374m.getValue();
        AEVideoStoryTopBarViewModel.Ratio ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
        if (value == ratio) {
            value = AEVideoStoryTopBarViewModel.Ratio.R_16_9;
            this.f63264f.a().setImageResource(R.drawable.iso);
            this.Q.f63374m.setValue(value);
        } else if (value == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
            this.f63264f.a().setImageResource(R.drawable.isp);
            this.Q.f63374m.setValue(ratio);
            value = ratio;
        }
        M(value == ratio);
        ReportController.o(null, "dc00898", "", "", "0X800BFF7", "0X800BFF7", this.M, 0, "", "", "", "");
    }

    private void H() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.simple.AESimpleCapturePart.2
            @Override // java.lang.Runnable
            public void run() {
                ReportController.o(null, "dc00898", "", "", "0X800BFF6", "0X800BFF6", AESimpleCapturePart.this.M, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800BFF4", "0X800BFF4", AESimpleCapturePart.this.M, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800BFEE", "0X800BFEE", AESimpleCapturePart.this.M, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800BFF2", "0X800BFF2", AESimpleCapturePart.this.M, 0, "", "", "", "");
            }
        }, 16, null, false);
    }

    public static boolean I() {
        return true;
    }

    private void J() {
        if (!AppSetting.f99565y || this.F == null || this.f63265h == null || this.J == null) {
            return;
        }
        QLog.d("AESimpleCapturePart", 1, "updateBeautyContentDescription " + ((Object) this.J.getText()));
        AccessibilityUtil.p(this.F, this.J.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z16) {
        if (this.G == null || this.C == null || this.K == null) {
            return;
        }
        String qqStr = HardCodeUtil.qqStr(z16 ? R.string.f169905y83 : R.string.f169906y84);
        AccessibilityUtil.p(this.G, qqStr);
        AccessibilityUtil.p(this.f63267m, qqStr);
    }

    private void L(boolean z16) {
        if (!AppSetting.f99565y || this.D == null || this.f63263e == null || this.H == null) {
            return;
        }
        QLog.d("AESimpleCapturePart", 1, "updateFlashContentDescription " + z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\uff0c");
        sb5.append(this.D.getResources().getString(z16 ? R.string.y8k : R.string.y8j));
        String sb6 = sb5.toString();
        AccessibilityUtil.c(this.D, ((Object) this.H.getText()) + sb6, Button.class.getName());
    }

    private void M(boolean z16) {
        if (!AppSetting.f99565y || this.E == null || this.f63264f == null || this.I == null) {
            return;
        }
        QLog.d("AESimpleCapturePart", 1, "updateRatioContentDescription " + z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\uff0c");
        sb5.append(this.E.getResources().getString(z16 ? R.string.y9r : R.string.y9q));
        String sb6 = sb5.toString();
        AccessibilityUtil.c(this.E, ((Object) this.I.getText()) + sb6, Button.class.getName());
    }

    private void N() {
        if (AppSetting.f99565y) {
            QLog.d("AESimpleCapturePart", 1, "updateViewForTalkback");
            ViewCompat.setImportantForAccessibility(this.f63263e, 2);
            ViewCompat.setImportantForAccessibility(this.H, 2);
            ViewCompat.setImportantForAccessibility(this.D, 1);
            L(this.f63263e.isSelected());
            ViewCompat.setImportantForAccessibility(this.f63264f, 2);
            ViewCompat.setImportantForAccessibility(this.I, 2);
            ViewCompat.setImportantForAccessibility(this.E, 1);
            ViewCompat.setImportantForAccessibility(this.f63265h, 2);
            ViewCompat.setImportantForAccessibility(this.J, 2);
            ViewCompat.setImportantForAccessibility(this.F, 1);
            J();
            ViewCompat.setImportantForAccessibility(this.C, 2);
            ViewCompat.setImportantForAccessibility(this.K, 2);
            ViewCompat.setImportantForAccessibility(this.G, 1);
            K(false);
            AECompoundButton aECompoundButton = this.f63266i;
            if (aECompoundButton != null) {
                AccessibilityUtil.p(aECompoundButton, HardCodeUtil.qqStr(R.string.y8c));
            }
        }
    }

    private void initViewModel() {
        AEPituCameraUnit aEPituCameraUnit = this.L;
        if (aEPituCameraUnit == null) {
            ms.a.c("AESimpleCapturePart", "AESimpleCapturePart create but AEPituCameraUnit mUnit is null");
            return;
        }
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) n.a(aEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class);
        this.Q = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.f63374m.observe(this.L, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.simple.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AESimpleCapturePart.this.E((AEVideoStoryTopBarViewModel.Ratio) obj);
            }
        });
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.L).get(com.tencent.aelight.camera.ae.part.a.class);
        this.R = aVar;
        aVar.M1().observe(this.L, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.simple.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AESimpleCapturePart.this.F((Boolean) obj);
            }
        });
        this.R.L1().observe(this.L, new b());
        ((AEPituCameraUnit.an) n.a(this.L).get(AEPituCameraUnit.an.class)).f61910i.observe(this.L, new c());
    }

    private void v() {
        int dimensionPixelSize = this.f63262d.getResources().getDimensionPixelSize(R.dimen.bb7);
        AECompoundButton[] aECompoundButtonArr = {this.f63263e, this.f63264f, this.f63265h, this.f63266i, this.f63267m, this.C};
        for (int i3 = 0; i3 < 6; i3++) {
            AECompoundButton aECompoundButton = aECompoundButtonArr[i3];
            ViewGroup.LayoutParams layoutParams = aECompoundButton.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            aECompoundButton.setLayoutParams(layoutParams);
        }
        int dimensionPixelSize2 = this.f63262d.getResources().getDimensionPixelSize(R.dimen.bb8);
        int[] iArr = {R.id.s3z, R.id.f163807s40, R.id.rx9, R.id.rqy};
        for (int i16 = 0; i16 < 4; i16++) {
            TextView textView = (TextView) this.f63262d.findViewById(iArr[i16]);
            if (textView != null) {
                textView.setTextSize(0, dimensionPixelSize2);
            }
        }
    }

    private boolean x() {
        if (com.tencent.aelight.camera.ae.d.j()) {
            return true;
        }
        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.xzx), 0).show();
        return false;
    }

    private void y() {
        AEPituCameraUnit aEPituCameraUnit = this.L;
        if (aEPituCameraUnit == null) {
            return;
        }
        aEPituCameraUnit.z2(this.f63267m);
    }

    private void z(View view) {
        if (this.L == null) {
            return;
        }
        com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, null);
        this.L.x2();
        ReportController.o(null, "dc00898", "", "", "0X800BFEF", "0X800BFEF", this.M, 0, "", "", "", "");
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    protected void initAfterInflation(View view) {
        this.f63262d = view;
        this.P = view.getResources().getString(R.string.f169903y81);
        AECompoundButton aECompoundButton = (AECompoundButton) view.findViewById(R.id.rpn);
        this.f63263e = aECompoundButton;
        aECompoundButton.setOnClickListener(this);
        this.f63263e.setSelected(false);
        View findViewById = view.findViewById(R.id.rwa);
        this.D = findViewById;
        findViewById.setOnClickListener(this);
        this.H = (TextView) view.findViewById(R.id.s3z);
        AECompoundButton aECompoundButton2 = (AECompoundButton) view.findViewById(R.id.rpp);
        this.f63264f = aECompoundButton2;
        aECompoundButton2.setOnClickListener(this);
        View findViewById2 = view.findViewById(R.id.rwc);
        this.E = findViewById2;
        findViewById2.setOnClickListener(this);
        this.I = (TextView) view.findViewById(R.id.f163807s40);
        AECompoundButton aECompoundButton3 = (AECompoundButton) view.findViewById(R.id.rpo);
        this.f63265h = aECompoundButton3;
        aECompoundButton3.setOnClickListener(this);
        View findViewById3 = view.findViewById(R.id.rwb);
        this.F = findViewById3;
        findViewById3.setOnClickListener(this);
        this.J = (TextView) view.findViewById(R.id.rx9);
        if (!I()) {
            this.F.setVisibility(8);
        }
        AECompoundButton aECompoundButton4 = (AECompoundButton) view.findViewById(R.id.rpl);
        this.C = aECompoundButton4;
        aECompoundButton4.setOnClickListener(this);
        View findViewById4 = view.findViewById(R.id.rw_);
        this.G = findViewById4;
        findViewById4.setVisibility(8);
        this.G.setOnClickListener(this);
        this.K = (TextView) view.findViewById(R.id.rqy);
        AECompoundButton aECompoundButton5 = (AECompoundButton) view.findViewById(R.id.rpm);
        this.f63266i = aECompoundButton5;
        aECompoundButton5.setOnClickListener(this);
        AECompoundButton aECompoundButton6 = (AECompoundButton) view.findViewById(R.id.rpk);
        this.f63267m = aECompoundButton6;
        aECompoundButton6.setOnClickListener(this);
        AECompoundButton aECompoundButton7 = this.f63267m;
        aECompoundButton7.setContentDescription(aECompoundButton7.getResources().getString(R.string.f169906y84));
        if (!f.a()) {
            this.f63267m.setVisibility(4);
            this.f63267m.setEnabled(false);
        }
        vq.a.f443174a.b(this.f63267m, "em_ae_switch_btn");
        N();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f63266i.getLayoutParams();
        marginLayoutParams.bottomMargin += (int) this.f63266i.getResources().getDimension(R.dimen.bb6);
        this.f63266i.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f63267m.getLayoutParams();
        marginLayoutParams2.bottomMargin += (int) this.f63267m.getResources().getDimension(R.dimen.bb6);
        this.f63267m.setLayoutParams(marginLayoutParams2);
        if (SimpleUIUtil.isNowElderMode()) {
            v();
        }
        D();
        initViewModel();
        H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        ensureInflate();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        switch (id5) {
            case R.id.rpk /* 2097545345 */:
            case R.id.rpl /* 2097545346 */:
                y();
                break;
            case R.id.rpm /* 2097545347 */:
                z(view);
                break;
            case R.id.rpn /* 2097545348 */:
                A();
                break;
            case R.id.rpo /* 2097545349 */:
                B();
                break;
            case R.id.rpp /* 2097545350 */:
                C();
                break;
            default:
                switch (id5) {
                }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, int i3) {
        ReportController.o(null, "dc00898", "", "", str, str, this.M, i3, "", "", String.valueOf(d.a(this.L.C().k())), "");
    }

    private void D() {
        int dip2px = ViewUtils.dip2px(20.0f);
        BaseAIOUtils.g(this.f63266i, dip2px);
        BaseAIOUtils.g(this.f63267m, dip2px);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(AEVideoStoryTopBarViewModel.Ratio ratio) {
        if (ratio == null) {
            return;
        }
        AEVideoStoryTopBarViewModel.Ratio ratio2 = AEVideoStoryTopBarViewModel.Ratio.FULL;
        if (ratio == ratio2) {
            this.f63264f.a().setImageResource(R.drawable.isp);
        } else if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
            this.f63264f.a().setImageResource(R.drawable.iso);
        }
        M(ratio == ratio2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Boolean bool) {
        if (bool == null) {
            return;
        }
        this.f63262d.setVisibility(bool.booleanValue() ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        int i3 = z16 ? 8 : 0;
        this.D.setVisibility(i3);
        this.E.setVisibility(i3);
        this.f63266i.setVisibility(i3);
        this.f63267m.setVisibility(i3);
        View view = this.F;
        if (!I()) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.G.setVisibility(z16 ? 0 : 8);
    }
}
