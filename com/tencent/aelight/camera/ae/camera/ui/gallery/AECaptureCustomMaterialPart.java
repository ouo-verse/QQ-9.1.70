package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart;
import com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter;
import com.tencent.aelight.camera.ae.camera.ui.panel.bv;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.av.utils.ba;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.os.MqqHandler;
import org.light.LightAsset;
import org.light.MaterialConfig;

/* loaded from: classes32.dex */
public class AECaptureCustomMaterialPart extends com.tencent.aelight.camera.ae.part.b {
    private MiniPhotoListAdapter C;
    private final AppInterface D;
    private final CameraPeakServiceHandler E;
    private com.tencent.aelight.camera.ae.config.g F;
    private long G;
    private Dialog H;
    private AECaptureMode I;
    private AEMaterialMetaData J;
    private final HashMap<String, c> K;
    private final int[] L;
    private int M;
    private int N;
    private boolean P;
    private boolean Q;
    private boolean R;

    /* renamed from: d, reason: collision with root package name */
    private View f62697d;

    /* renamed from: e, reason: collision with root package name */
    private View f62698e;

    /* renamed from: f, reason: collision with root package name */
    private View f62699f;

    /* renamed from: h, reason: collision with root package name */
    private final AEPituCameraUnit f62700h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f62701i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.t f62702m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.aelight.camera.ae.config.g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f62706d;

        a(LocalMediaInfo localMediaInfo) {
            this.f62706d = localMediaInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LocalMediaInfo localMediaInfo, boolean z16, int i3) {
            AECaptureCustomMaterialPart.this.X(localMediaInfo, z16, i3);
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateFaceDetect(final boolean z16, final int i3) {
            AECaptureCustomMaterialPart.this.D.removeObserver(this);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final LocalMediaInfo localMediaInfo = this.f62706d;
            uIHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.s
                @Override // java.lang.Runnable
                public final void run() {
                    AECaptureCustomMaterialPart.a.this.b(localMediaInfo, z16, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AECaptureCustomMaterialPart.this.f62697d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        MaterialConfig f62709a;

        c() {
        }
    }

    public AECaptureCustomMaterialPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        AppInterface a16 = QQStoryContext.a();
        this.D = a16;
        this.E = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
        this.I = AECaptureMode.NORMAL;
        this.K = new HashMap<>();
        this.L = new int[2];
        this.P = false;
        this.Q = false;
        this.R = false;
        this.f62700h = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        b0();
        a0();
    }

    private void A0() {
        com.tencent.aelight.camera.ae.config.g gVar = this.F;
        if (gVar != null) {
            this.D.removeObserver(gVar);
            this.F = null;
        }
    }

    private void B0(float f16) {
        if (this.f62697d.getVisibility() == 0) {
            F0(f16);
        }
    }

    private void C0() {
        View view;
        if (!L() || (view = this.f62697d) == null || view.getVisibility() == 0 || this.Q) {
            return;
        }
        this.Q = true;
        t.g(this.mActivity, new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.j
            @Override // java.lang.Runnable
            public final void run() {
                AECaptureCustomMaterialPart.this.r0();
            }
        }, new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.k
            @Override // java.lang.Runnable
            public final void run() {
                AECaptureCustomMaterialPart.this.s0();
            }
        });
    }

    private void D0() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.H == null) {
            ReportDialog reportDialog = new ReportDialog(this.mActivity, R.style.qZoneInputDialog);
            this.H = reportDialog;
            reportDialog.setContentView(R.layout.f168383uh);
            ((TextView) this.H.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.y0s);
            this.H.setCancelable(true);
            this.H.setCanceledOnTouchOutside(false);
            this.H.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AECaptureCustomMaterialPart.this.t0(dialogInterface);
                }
            });
        }
        this.H.show();
    }

    private void E0(boolean z16) {
        FrameLayout frameLayout = (FrameLayout) this.f62697d.findViewById(R.id.f163776ry3);
        TextView textView = (TextView) this.f62697d.findViewById(R.id.rsv);
        RecyclerView recyclerView = (RecyclerView) this.f62697d.findViewById(R.id.ryb);
        this.f62697d.findViewById(R.id.rpd).setVisibility(8);
        if (!z16) {
            N();
            frameLayout.setVisibility(0);
            recyclerView.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(R.string.f169891y54);
            this.Q = false;
            return;
        }
        boolean u06 = u0();
        if (u06) {
            z0(frameLayout, textView, recyclerView, false);
            N();
            this.Q = false;
        } else {
            z0(frameLayout, textView, recyclerView, u06);
            N();
            this.Q = false;
        }
    }

    private void F0(float f16) {
        U();
        this.f62697d.setTranslationY(Math.min(f16, R()));
    }

    private void G0() {
        bv value = this.f62702m.N1().getValue();
        H0(value != null && value.getShow());
        if (value == null || !value.getShow()) {
            return;
        }
        B0(value.getShow() ? 0.0f : R());
    }

    private void H0(boolean z16) {
        if (this.f62697d.getVisibility() != 0) {
            return;
        }
        this.f62697d.findViewById(R.id.f163776ry3).setVisibility(z16 ? 0 : 8);
        this.f62697d.findViewById(R.id.rpd).setVisibility(z16 ? 8 : 0);
    }

    private boolean L() {
        AEMaterialMetaData aEMaterialMetaData;
        c cVar;
        return (this.f62700h.Q() || this.I != AECaptureMode.NORMAL || (aEMaterialMetaData = this.J) == null || aEMaterialMetaData == AEMaterialMetaData.MATERIAL_NONE || (cVar = this.K.get(aEMaterialMetaData.f69050id)) == null || cVar.f62709a == null) ? false : true;
    }

    private void M() {
        this.f62697d.animate().alpha(0.0f).setDuration(200L).setListener(new b());
        Q(false);
    }

    private boolean O(LocalMediaInfo localMediaInfo) {
        MaterialConfig V = V();
        if (V == null) {
            return false;
        }
        int i3 = V.minImageWidth;
        int i16 = V.minImageHeight;
        if (i3 <= 0 || i16 <= 0 || (localMediaInfo.mediaWidth >= i3 && localMediaInfo.mediaHeight >= i16)) {
            return true;
        }
        Activity activity = this.mActivity;
        QQToast.makeText(activity, String.format(activity.getString(R.string.y0t), Integer.valueOf(i3), Integer.valueOf(i16)), 0).show();
        return false;
    }

    private int P() {
        View view = this.f62699f;
        if (view == null) {
            return 0;
        }
        return view.getTop();
    }

    private void Q(boolean z16) {
        View findViewById = this.mRootView.findViewById(R.id.rqs);
        if (findViewById != null) {
            int dimensionPixelSize = findViewById.getResources().getDimensionPixelSize(R.dimen.f13159e);
            int dimensionPixelSize2 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13179g);
            int dimensionPixelSize3 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13169f);
            if (findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                findViewById.setTranslationY(z16 ? -(((dimensionPixelSize + dimensionPixelSize2) + dimensionPixelSize3) - ((ViewGroup.MarginLayoutParams) r4).bottomMargin) : 0.0f);
            } else {
                findViewById.setTranslationY(z16 ? -(dimensionPixelSize + dimensionPixelSize2 + dimensionPixelSize3) : 0.0f);
            }
        }
    }

    private int R() {
        U();
        int bottom = this.f62697d.getBottom();
        View view = this.f62698e;
        if (view != null) {
            bottom = view.getTop() + P();
        }
        return bottom - this.f62697d.getBottom();
    }

    private void S(LocalMediaInfo localMediaInfo, PTFaceAttr pTFaceAttr) {
        if (!u0()) {
            A0();
            Z();
            v0(localMediaInfo, localMediaInfo.path, false);
            return;
        }
        D0();
        A0();
        this.F = new a(localMediaInfo);
        this.G = System.currentTimeMillis();
        this.D.addObserver(this.F);
        if (pTFaceAttr == null) {
            this.E.r3(localMediaInfo.path);
        } else {
            this.E.s3(localMediaInfo.path, pTFaceAttr);
        }
    }

    private void T(boolean z16) {
        FrameLayout frameLayout = (FrameLayout) this.f62697d.findViewById(R.id.f163776ry3);
        TextView textView = (TextView) this.f62697d.findViewById(R.id.rsv);
        RecyclerView recyclerView = (RecyclerView) this.f62697d.findViewById(R.id.ryb);
        frameLayout.setVisibility(0);
        recyclerView.setVisibility(8);
        textView.setVisibility(0);
        if (z16) {
            textView.setText(R.string.y58);
        } else {
            textView.setText(R.string.f169891y54);
        }
    }

    private void U() {
        View view;
        if (this.f62698e == null) {
            this.f62698e = this.mRootView.findViewById(R.id.ru9);
        }
        if (this.f62699f != null || (view = this.f62698e) == null) {
            return;
        }
        AbsAECaptureButton absAECaptureButton = (AbsAECaptureButton) view.findViewById(R.id.rqn);
        if (absAECaptureButton instanceof AEPituCameraCaptureButtonLayout) {
            this.f62699f = ((AEPituCameraCaptureButtonLayout) absAECaptureButton).D;
        } else if (absAECaptureButton instanceof QIMCameraCaptureButtonLayoutNew) {
            this.f62699f = ((QIMCameraCaptureButtonLayoutNew) absAECaptureButton).C;
        }
    }

    private MaterialConfig V() {
        c cVar;
        AEMaterialMetaData aEMaterialMetaData = this.J;
        if (aEMaterialMetaData == null || (cVar = this.K.get(aEMaterialMetaData.f69050id)) == null) {
            return null;
        }
        return cVar.f62709a;
    }

    private void W() {
        c cVar;
        MaterialConfig materialConfig;
        AEMaterialMetaData aEMaterialMetaData = this.J;
        if (aEMaterialMetaData == null || (cVar = this.K.get(aEMaterialMetaData.f69050id)) == null || (materialConfig = cVar.f62709a) == null) {
            return;
        }
        com.tencent.aelight.camera.ae.util.p.a(this.mActivity, 1027, 23, u0(), materialConfig.minImageWidth, materialConfig.minImageHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(LocalMediaInfo localMediaInfo, boolean z16, int i3) {
        Z();
        if (z16) {
            if (i3 == 0 || i3 == -2) {
                v0(localMediaInfo, localMediaInfo.path, false);
                return;
            } else {
                if (i3 == -1) {
                    Activity activity = this.mActivity;
                    QQToast.makeText(activity, activity.getString(R.string.y0u), 0).show();
                    return;
                }
                return;
            }
        }
        if (i3 == -100) {
            if (!u0()) {
                v0(localMediaInfo, localMediaInfo.path, false);
                return;
            } else {
                Activity activity2 = this.mActivity;
                QQToast.makeText(activity2, activity2.getString(R.string.y0x), 0).show();
                return;
            }
        }
        Activity activity3 = this.mActivity;
        QQToast.makeText(activity3, activity3.getString(R.string.y0v), 0).show();
    }

    private void Y() {
        View view = this.f62697d;
        if (view != null && view.getVisibility() == 0) {
            M();
        }
    }

    private void Z() {
        Dialog dialog;
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || (dialog = this.H) == null || !dialog.isShowing()) {
            return;
        }
        this.H.dismiss();
    }

    private void a0() {
        File file = new File(g.a.C0559a.f65247a);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void b0() {
        int b16 = dr.c.b();
        if (b16 < 3) {
            int[] iArr = this.L;
            iArr[0] = 1024;
            iArr[1] = 576;
        } else if (b16 < 4) {
            int[] iArr2 = this.L;
            iArr2[0] = 1280;
            iArr2[1] = 720;
        } else {
            int[] iArr3 = this.L;
            iArr3[0] = 1920;
            iArr3[1] = 1080;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        y0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        W();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Boolean bool) {
        if (this.f62697d == null) {
            return;
        }
        if (bool != null && bool.booleanValue()) {
            Y();
        } else {
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
        AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
        this.I = aECaptureMode;
        if (aECaptureMode == AECaptureMode.NORMAL) {
            C0();
        } else {
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(bv bvVar) {
        if (this.f62697d == null) {
            return;
        }
        boolean z16 = bvVar != null && bvVar.getShow();
        B0(this.f62702m.P1() ? 0.0f : R());
        if (this.R && z16) {
            this.f62697d.setVisibility(0);
        }
        if (this.f62697d.getVisibility() == 0) {
            this.f62697d.findViewById(R.id.f163776ry3).setVisibility(bvVar.getShow() ? 0 : 8);
            this.f62697d.findViewById(R.id.rpd).setVisibility(bvVar.getShow() ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i0(Boolean bool) {
        T(bool.booleanValue());
        return Unit.INSTANCE;
    }

    private void initViewModel() {
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) com.tencent.aelight.camera.ae.n.a(this.f62700h).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f62701i = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this.f62700h).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f62702m = (com.tencent.aelight.camera.ae.camera.ui.panel.t) com.tencent.aelight.camera.ae.n.a(this.f62700h).get(com.tencent.aelight.camera.ae.camera.ui.panel.t.class);
        this.f62701i.N1().observe(this.f62700h, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECaptureCustomMaterialPart.this.e0((Boolean) obj);
            }
        });
        cVar.f65622i.observe(this.f62700h, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECaptureCustomMaterialPart.this.f0((AECaptureModeChangingEvent) obj);
            }
        });
        this.f62701i.L1().observe(this.f62700h, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECaptureCustomMaterialPart.this.x0((Boolean) obj);
            }
        });
        this.f62702m.N1().observe(this.f62700h, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECaptureCustomMaterialPart.this.g0((bv) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(String str, final boolean z16, final LocalMediaInfo localMediaInfo) {
        t.b(this.N, this.M, str, new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.f
            @Override // java.lang.Runnable
            public final void run() {
                AECaptureCustomMaterialPart.this.k0();
            }
        }, new Consumer() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.g
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                AECaptureCustomMaterialPart.this.n0(z16, localMediaInfo, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0() {
        this.f62700h.I1().u(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(String str) {
        AECaptureController I1 = this.f62700h.I1();
        AEMaterialMetaData aEMaterialMetaData = this.J;
        I1.u(aEMaterialMetaData == null ? null : aEMaterialMetaData.f69050id, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(final boolean z16, final LocalMediaInfo localMediaInfo, final String str) {
        this.f62700h.P2(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.h
            @Override // java.lang.Runnable
            public final void run() {
                AECaptureCustomMaterialPart.this.m0(z16, localMediaInfo, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit p0(Boolean bool) {
        T(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit q0(Boolean bool) {
        T(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(DialogInterface dialogInterface) {
        com.tencent.aelight.camera.ae.config.g gVar = this.F;
        if (gVar != null) {
            this.D.removeObserver(gVar);
            this.F = null;
        }
    }

    private boolean u0() {
        HashMap<String, String> hashMap;
        MaterialConfig V = V();
        return (V == null || (hashMap = V.aiFilterList) == null || !hashMap.containsKey("ai.face")) ? false : true;
    }

    private void v0(final LocalMediaInfo localMediaInfo, final String str, final boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.o
            @Override // java.lang.Runnable
            public final void run() {
                AECaptureCustomMaterialPart.this.j0(str, z16, localMediaInfo);
            }
        });
    }

    private void w0(final AEMaterialMetaData aEMaterialMetaData) {
        this.f62700h.I1().u(null, null);
        this.J = aEMaterialMetaData;
        if (aEMaterialMetaData != null && aEMaterialMetaData != AEMaterialMetaData.MATERIAL_NONE) {
            c cVar = this.K.get(aEMaterialMetaData.f69050id);
            if (cVar != null) {
                J0(cVar.f62709a != null);
                return;
            } else {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LightAsset lightAsset = VideoSDKMaterialParser.parseVideoMaterial(aEMaterialMetaData.getLocalPath(), "params").getLightAsset();
                        final c cVar2 = new c();
                        cVar2.f62709a = (lightAsset == null || lightAsset.getMaterialConfigs() == null || lightAsset.getMaterialConfigs().length <= 0) ? null : lightAsset.getMaterialConfigs()[0];
                        AECaptureCustomMaterialPart.this.K.put(aEMaterialMetaData.f69050id, cVar2);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AEMaterialMetaData aEMaterialMetaData2 = AECaptureCustomMaterialPart.this.J;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (aEMaterialMetaData2 == aEMaterialMetaData) {
                                    AECaptureCustomMaterialPart.this.J0(cVar2.f62709a != null);
                                }
                            }
                        });
                    }
                });
                return;
            }
        }
        J0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Boolean bool) {
        if (this.f62697d == null) {
            return;
        }
        if (bool != null && bool.booleanValue()) {
            this.R = this.f62697d.getVisibility() == 0;
            M();
        } else if (this.R) {
            N();
        }
    }

    private void y0() {
        this.mRootView.findViewById(R.id.rps).callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        if (this.f62700h.Q()) {
            return;
        }
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.s1r)).inflate();
        this.f62697d = inflate;
        ((ViewGroup.MarginLayoutParams) inflate.getLayoutParams()).bottomMargin = t.e(this.f62697d.getContext());
        this.f62697d.findViewById(R.id.rpd).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AECaptureCustomMaterialPart.this.c0(view);
            }
        });
        this.f62697d.findViewById(R.id.ruj).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AECaptureCustomMaterialPart.this.d0(view);
            }
        });
        this.f62697d.setTranslationY(ba.dp2px(this.mActivity, 133.0f));
        this.f62697d.setVisibility(8);
        initViewModel();
        U();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        View view;
        super.onActivityResume();
        if (this.P) {
            this.P = false;
        } else {
            if (this.C == null || (view = this.f62697d) == null || view.getVisibility() != 0) {
                return;
            }
            this.C.B0(this.mActivity, false, new Function1() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i06;
                    i06 = AECaptureCustomMaterialPart.this.i0((Boolean) obj);
                    return i06;
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        MiniPhotoListAdapter miniPhotoListAdapter = this.C;
        if (miniPhotoListAdapter != null) {
            miniPhotoListAdapter.u0();
        }
        super.onDestroy();
    }

    private void N() {
        this.R = false;
        this.f62697d.setAlpha(0.0f);
        this.f62697d.setVisibility(0);
        G0();
        this.f62697d.animate().alpha(1.0f).setDuration(200L).setListener(null);
        Q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        E0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0() {
        E0(false);
    }

    private void z0(FrameLayout frameLayout, TextView textView, RecyclerView recyclerView, boolean z16) {
        String str;
        frameLayout.setVisibility(0);
        recyclerView.setVisibility(0);
        textView.setVisibility(8);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            MiniPhotoListAdapter miniPhotoListAdapter = new MiniPhotoListAdapter(new MiniPhotoListAdapter.b() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.c
                @Override // com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter.b
                public final void a(PTFaceAttr pTFaceAttr, LocalMediaInfo localMediaInfo) {
                    AECaptureCustomMaterialPart.this.o0(pTFaceAttr, localMediaInfo);
                }
            });
            miniPhotoListAdapter.A0(this.J.f69050id);
            recyclerView.setAdapter(miniPhotoListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 0, false));
            recyclerView.addItemDecoration(t.a());
            this.C = miniPhotoListAdapter;
            miniPhotoListAdapter.B0(this.mActivity, z16, new Function1() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p06;
                    p06 = AECaptureCustomMaterialPart.this.p0((Boolean) obj);
                    return p06;
                }
            });
            return;
        }
        MiniPhotoListAdapter miniPhotoListAdapter2 = (MiniPhotoListAdapter) adapter;
        String bindId = miniPhotoListAdapter2.getBindId();
        AEMaterialMetaData aEMaterialMetaData = this.J;
        if (aEMaterialMetaData == null || (str = aEMaterialMetaData.f69050id) == null || str.equals(bindId)) {
            return;
        }
        miniPhotoListAdapter2.A0(this.J.f69050id);
        if (miniPhotoListAdapter2.getDetectFace() != u0()) {
            miniPhotoListAdapter2.B0(this.mActivity, z16, new Function1() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit q06;
                    q06 = AECaptureCustomMaterialPart.this.q0((Boolean) obj);
                    return q06;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(boolean z16) {
        if (z16) {
            C0();
        } else {
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(boolean z16, LocalMediaInfo localMediaInfo, final String str) {
        if (z16) {
            MiniPhotoListAdapter miniPhotoListAdapter = this.C;
            if (miniPhotoListAdapter != null) {
                miniPhotoListAdapter.z0(localMediaInfo);
                ((RecyclerView) this.f62697d.findViewById(R.id.ryb)).scrollToPosition(0);
            }
        } else {
            this.C.y0(localMediaInfo);
        }
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.i
            @Override // java.lang.Runnable
            public final void run() {
                AECaptureCustomMaterialPart.this.l0(str);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(PTFaceAttr pTFaceAttr, LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null || !O(localMediaInfo)) {
            return;
        }
        S(localMediaInfo, pTFaceAttr);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 851969:
                if (objArr == null || objArr.length <= 0) {
                    return;
                }
                Object obj = objArr[0];
                if (obj instanceof Float) {
                    B0(((Float) obj).floatValue());
                    return;
                }
                return;
            case 851970:
                if (objArr == null || objArr.length <= 0) {
                    return;
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof AEMaterialMetaData) {
                    w0((AEMaterialMetaData) obj2);
                    return;
                }
                return;
            case 851971:
                C0();
                return;
            case 851972:
                Y();
                return;
            case 851973:
                if (objArr == null || objArr.length <= 0) {
                    return;
                }
                List list = (List) objArr[0];
                this.M = ((Integer) list.get(0)).intValue();
                this.N = ((Integer) list.get(1)).intValue();
                if (dr.c.b() < 3) {
                    int i16 = this.M;
                    if (i16 < this.N) {
                        this.M = Math.min(i16, this.L[1]);
                        this.N = Math.min(this.N, this.L[0]);
                        return;
                    } else {
                        this.M = Math.min(i16, this.L[0]);
                        this.N = Math.min(this.N, this.L[1]);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 != 1027) {
            return;
        }
        ArrayList arrayList = null;
        if (i16 == 0 && intent == null) {
            LocalMediaInfo a16 = os.a.f423933a.a();
            if (a16 != null) {
                arrayList = new ArrayList();
                arrayList.add(a16);
            }
        } else if (i16 == -1 && intent != null) {
            arrayList = intent.getParcelableArrayListExtra("selected_local_infos");
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) arrayList.get(0);
        if (localMediaInfo != null) {
            v0(localMediaInfo, localMediaInfo.path, true);
        }
        this.P = true;
    }
}
