package com.tencent.mobileqq.zplan.cc;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/m;", "Li74/a;", "Li74/b;", "", ReportConstant.COSTREPORT_PREFIX, "p", "a", "e", "j", "", "d", "f", ICustomDataEditor.STRING_ARRAY_PARAM_8, "", tl.h.F, "Ljava/lang/String;", "activityName", "l", "()Ljava/lang/String;", "logicName", "<init>", "()V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m extends i74.a implements i74.b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String activityName = "";

    private final void p() {
        final View decorView = k().getWindow().getDecorView();
        final int i3 = 5894;
        decorView.setSystemUiVisibility(5894);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tencent.mobileqq.zplan.cc.k
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i16) {
                m.q(decorView, i3, i16);
            }
        });
        decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.zplan.cc.l
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                m.r(decorView, i3, view, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View this_apply, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setSystemUiVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(View this_apply, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setSystemUiVisibility(i3);
    }

    private final void s() {
        FilamentCaptureFragment.Companion companion = FilamentCaptureFragment.INSTANCE;
        Intent intent = k().getIntent();
        FilamentCaptureFragment a16 = companion.a(intent != null ? intent.getExtras() : null);
        FragmentTransaction beginTransaction = k().getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.plw, a16, "zplan_camera_filament_capture_fragment");
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // i74.a
    public void a() {
        super.a();
        com.tencent.mobileqq.zplan.cc.util.f.f332559a.b();
        com.tencent.mobileqq.zplan.cc.util.g.f332561a.a(k());
    }

    @Override // i74.b
    public boolean a8() {
        boolean isFinishing = k().isFinishing();
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "isPageFinishing : " + isFinishing + ", hash:" + k().hashCode() + ", this:" + k());
        return isFinishing;
    }

    @Override // i74.a
    public boolean d() {
        return false;
    }

    @Override // i74.a
    public void e() {
        super.e();
        k().setContentView(R.layout.dc8);
        s();
    }

    @Override // i74.a
    public void f() {
        super.f();
        ((com.tencent.mobileqq.zplan.ipc.business.b) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.b.class)).onDestroyFaceCamera();
    }

    @Override // i74.a
    public void j() {
        super.j();
        p();
    }

    @Override // i74.a
    /* renamed from: l */
    protected String getLogicName() {
        return "ZPlanCamera_FilamentAIFaceFilamentCameraActivityLogic";
    }
}
