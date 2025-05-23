package com.tencent.aelight.camera.ae.flashshow.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
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
import com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowCustomMaterialPart;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.os.MqqHandler;
import org.light.LightAsset;
import org.light.MaterialConfig;

/* loaded from: classes32.dex */
public class AEFlashShowCustomMaterialPart extends lq.a {
    private View C;
    private View D;
    private final LSMiddleCameraUnit E;
    private com.tencent.aelight.camera.ae.part.a F;
    private AEFlashShowBottomPanelViewModel G;
    private MiniPhotoListAdapter H;
    private final AppInterface I;
    private final CameraPeakServiceHandler J;
    private com.tencent.aelight.camera.ae.config.g K;
    private long L;
    private Dialog M;
    private AECaptureMode N;
    private AEMaterialMetaData P;
    private final HashMap<String, c> Q;
    private final int[] R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: m, reason: collision with root package name */
    private View f64505m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.aelight.camera.ae.config.g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f64509d;

        a(LocalMediaInfo localMediaInfo) {
            this.f64509d = localMediaInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LocalMediaInfo localMediaInfo, boolean z16, int i3) {
            AEFlashShowCustomMaterialPart.this.Y(localMediaInfo, z16, i3);
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateFaceDetect(final boolean z16, final int i3) {
            AEFlashShowCustomMaterialPart.this.I.removeObserver(this);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final LocalMediaInfo localMediaInfo = this.f64509d;
            uIHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.av
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowCustomMaterialPart.a.this.b(localMediaInfo, z16, i3);
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
            AEFlashShowCustomMaterialPart.this.f64505m.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        MaterialConfig f64512a;

        c() {
        }
    }

    public AEFlashShowCustomMaterialPart(Activity activity, View view, lq.b bVar) {
        super(activity, view, bVar);
        AppInterface a16 = QQStoryContext.a();
        this.I = a16;
        this.J = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
        this.N = AECaptureMode.NORMAL;
        this.Q = new HashMap<>();
        this.R = new int[2];
        this.U = false;
        this.V = false;
        this.W = false;
        this.E = (LSMiddleCameraUnit) bVar.b(65537, new Object[0]);
        c0();
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Boolean bool) {
        if (this.f64505m == null) {
            return;
        }
        if (bool != null && bool.booleanValue()) {
            this.W = this.f64505m.getVisibility() == 0;
            M();
        } else if (this.W) {
            N();
        }
    }

    private void B0() {
        this.G.j2().postValue(new ds(true, null, null));
    }

    private void D0() {
        com.tencent.aelight.camera.ae.config.g gVar = this.K;
        if (gVar != null) {
            this.I.removeObserver(gVar);
            this.K = null;
        }
    }

    private void E0(float f16) {
        if (this.f64505m.getVisibility() == 0) {
            I0(f16);
        }
    }

    private void F0() {
        View view;
        if (!L() || (view = this.f64505m) == null || view.getVisibility() == 0 || this.V) {
            return;
        }
        this.V = true;
        com.tencent.aelight.camera.ae.camera.ui.gallery.t.g(this.f415377f, new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.an
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCustomMaterialPart.this.t0();
            }
        }, new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ao
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCustomMaterialPart.this.u0();
            }
        });
    }

    private void G0() {
        Activity activity = this.f415377f;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.M == null) {
            this.M = new QCircleCommonLoadingDialog.c(this.f415377f).n(true).p(this.f415377f.getString(R.string.y0s)).j("").e(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ac
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowCustomMaterialPart.this.v0();
                }
            }).d(new Callable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.am
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean bool;
                    bool = Boolean.TRUE;
                    return bool;
                }
            }).a();
        }
        this.M.show();
        ((QCircleCommonLoadingDialog) this.M).setProgress(70);
    }

    private void H0(boolean z16) {
        FrameLayout frameLayout = (FrameLayout) this.f64505m.findViewById(R.id.f163776ry3);
        TextView textView = (TextView) this.f64505m.findViewById(R.id.rsv);
        RecyclerView recyclerView = (RecyclerView) this.f64505m.findViewById(R.id.ryb);
        this.f64505m.findViewById(R.id.rpd).setVisibility(8);
        if (!z16) {
            N();
            frameLayout.setVisibility(0);
            recyclerView.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(R.string.f169891y54);
            this.V = false;
            return;
        }
        boolean x06 = x0();
        if (x06) {
            C0(frameLayout, textView, recyclerView, false);
            N();
            this.V = false;
        } else {
            C0(frameLayout, textView, recyclerView, x06);
            N();
            this.V = false;
        }
    }

    private void I0(float f16) {
        V();
        this.f64505m.setTranslationY(Math.min(f16, S()));
    }

    private void J0() {
        ds value = this.G.j2().getValue();
        K0(value != null && value.getShow());
        if (value == null || !value.getShow()) {
            return;
        }
        E0(value.getShow() ? 0.0f : S());
    }

    private void K0(boolean z16) {
        if (this.f64505m.getVisibility() != 0) {
            return;
        }
        this.f64505m.findViewById(R.id.f163776ry3).setVisibility(z16 ? 0 : 8);
        this.f64505m.findViewById(R.id.rpd).setVisibility(z16 ? 8 : 0);
    }

    private boolean L() {
        AEMaterialMetaData aEMaterialMetaData;
        c cVar;
        return (this.N != AECaptureMode.NORMAL || (aEMaterialMetaData = this.P) == null || aEMaterialMetaData == AEMaterialMetaData.MATERIAL_NONE || (cVar = this.Q.get(aEMaterialMetaData.f69050id)) == null || cVar.f64512a == null) ? false : true;
    }

    private void M() {
        this.f64505m.animate().alpha(0.0f).setDuration(200L).setListener(new b());
        Q(false);
    }

    private boolean O(LocalMediaInfo localMediaInfo) {
        MaterialConfig W = W();
        if (W == null) {
            return false;
        }
        int i3 = W.minImageWidth;
        int i16 = W.minImageHeight;
        if (i3 <= 0 || i16 <= 0 || (localMediaInfo.mediaWidth >= i3 && localMediaInfo.mediaHeight >= i16)) {
            return true;
        }
        Activity activity = this.f415377f;
        QQToast.makeText(activity, String.format(activity.getString(R.string.y0t), Integer.valueOf(i3), Integer.valueOf(i16)), 0).show();
        return false;
    }

    private int P() {
        View view = this.D;
        if (view == null) {
            return 0;
        }
        return view.getTop() - com.tencent.videocut.utils.e.f384236a.a(40.0f);
    }

    private void Q(boolean z16) {
        ViewGroup.LayoutParams layoutParams;
        View findViewById = this.f415376e.findViewById(R.id.rua);
        if (findViewById != null) {
            int dimensionPixelSize = findViewById.getResources().getDimensionPixelSize(R.dimen.f13159e);
            int dimensionPixelSize2 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13179g);
            int dimensionPixelSize3 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13169f);
            layoutParams = findViewById.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                findViewById.setTranslationY(z16 ? -(((dimensionPixelSize + dimensionPixelSize2) + dimensionPixelSize3) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : 0.0f);
            } else {
                findViewById.setTranslationY(z16 ? -(dimensionPixelSize + dimensionPixelSize2 + dimensionPixelSize3) : 0.0f);
            }
        } else {
            layoutParams = null;
        }
        View findViewById2 = this.f415376e.findViewById(R.id.rpe);
        if (layoutParams == null || findViewById2 == null) {
            return;
        }
        int dimensionPixelSize4 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13159e);
        int dimensionPixelSize5 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13179g);
        int dimensionPixelSize6 = findViewById.getResources().getDimensionPixelSize(R.dimen.f13169f);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            findViewById2.setTranslationY(z16 ? -(((dimensionPixelSize4 + dimensionPixelSize5) + dimensionPixelSize6) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : 0.0f);
        } else {
            findViewById2.setTranslationY(z16 ? -(dimensionPixelSize4 + dimensionPixelSize5 + dimensionPixelSize6) : 0.0f);
        }
    }

    private void R() {
        MiniPhotoListAdapter miniPhotoListAdapter = this.H;
        if (miniPhotoListAdapter != null) {
            miniPhotoListAdapter.o0();
            View view = this.f64505m;
            if (view != null) {
                ((RecyclerView) view.findViewById(R.id.ryb)).scrollToPosition(0);
            }
        }
    }

    private int S() {
        V();
        int bottom = this.f64505m.getBottom();
        View view = this.C;
        if (view != null) {
            bottom = view.getTop() + P();
        }
        return bottom - this.f64505m.getBottom();
    }

    private void T(LocalMediaInfo localMediaInfo, PTFaceAttr pTFaceAttr) {
        if (!x0()) {
            D0();
            a0();
            y0(localMediaInfo, localMediaInfo.path, false);
            return;
        }
        G0();
        D0();
        this.K = new a(localMediaInfo);
        this.L = System.currentTimeMillis();
        this.I.addObserver(this.K);
        if (pTFaceAttr == null) {
            this.J.r3(localMediaInfo.path);
        } else {
            this.J.s3(localMediaInfo.path, pTFaceAttr);
        }
    }

    private void U(boolean z16) {
        FrameLayout frameLayout = (FrameLayout) this.f64505m.findViewById(R.id.f163776ry3);
        TextView textView = (TextView) this.f64505m.findViewById(R.id.rsv);
        RecyclerView recyclerView = (RecyclerView) this.f64505m.findViewById(R.id.ryb);
        frameLayout.setVisibility(0);
        recyclerView.setVisibility(8);
        textView.setVisibility(0);
        if (z16) {
            textView.setText(R.string.y58);
        } else {
            textView.setText(R.string.f169891y54);
        }
    }

    private void V() {
        View view;
        if (this.C == null) {
            this.C = this.f415376e.findViewById(R.id.ru9);
        }
        if (this.D != null || (view = this.C) == null) {
            return;
        }
        AbsLSCaptureButton absLSCaptureButton = (AbsLSCaptureButton) view.findViewById(R.id.rqn);
        if (absLSCaptureButton instanceof AEFlashCameraCaptureButtonLayout) {
            this.D = ((AEFlashCameraCaptureButtonLayout) absLSCaptureButton).p();
        }
    }

    private MaterialConfig W() {
        c cVar;
        AEMaterialMetaData aEMaterialMetaData = this.P;
        if (aEMaterialMetaData == null || (cVar = this.Q.get(aEMaterialMetaData.f69050id)) == null) {
            return null;
        }
        return cVar.f64512a;
    }

    private void X() {
        c cVar;
        MaterialConfig materialConfig;
        AEMaterialMetaData aEMaterialMetaData = this.P;
        if (aEMaterialMetaData == null || (cVar = this.Q.get(aEMaterialMetaData.f69050id)) == null || (materialConfig = cVar.f64512a) == null) {
            return;
        }
        com.tencent.aelight.camera.ae.util.p.a(this.f415377f, 1027, 31, x0(), materialConfig.minImageWidth, materialConfig.minImageHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(LocalMediaInfo localMediaInfo, boolean z16, int i3) {
        a0();
        if (z16) {
            if (i3 == 0 || i3 == -2) {
                y0(localMediaInfo, localMediaInfo.path, false);
                return;
            } else {
                if (i3 == -1) {
                    Activity activity = this.f415377f;
                    QQToast.makeText(activity, activity.getString(R.string.y0u), 0).show();
                    return;
                }
                return;
            }
        }
        if (i3 == -100) {
            if (!x0()) {
                y0(localMediaInfo, localMediaInfo.path, false);
                return;
            } else {
                Activity activity2 = this.f415377f;
                QQToast.makeText(activity2, activity2.getString(R.string.y0x), 0).show();
                return;
            }
        }
        Activity activity3 = this.f415377f;
        QQToast.makeText(activity3, activity3.getString(R.string.y0v), 0).show();
    }

    private void Z() {
        View view = this.f64505m;
        if (view != null && view.getVisibility() == 0) {
            M();
        }
    }

    private void a0() {
        Dialog dialog;
        Activity activity = this.f415377f;
        if (activity == null || activity.isFinishing() || (dialog = this.M) == null || !dialog.isShowing()) {
            return;
        }
        Dialog dialog2 = this.M;
        if (dialog2 instanceof QCircleCommonLoadingDialog) {
            ((QCircleCommonLoadingDialog) dialog2).setProgress(100);
        }
        this.M.dismiss();
    }

    private void b0() {
        File file = new File(g.a.C0559a.f65247a);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void c0() {
        int b16 = dr.c.b();
        if (b16 < 3) {
            int[] iArr = this.R;
            iArr[0] = 1024;
            iArr[1] = 576;
        } else if (b16 < 4) {
            int[] iArr2 = this.R;
            iArr2[0] = 1280;
            iArr2[1] = 720;
        } else {
            int[] iArr3 = this.R;
            iArr3[0] = 1920;
            iArr3[1] = 1080;
        }
    }

    private void d0() {
        this.F = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this.E).get(com.tencent.aelight.camera.ae.part.a.class);
        this.G = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this.E).get(AEFlashShowBottomPanelViewModel.class);
        this.F.N1().observe(this.E, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCustomMaterialPart.this.g0((Boolean) obj);
            }
        });
        this.G.j2().observe(this.E, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCustomMaterialPart.this.i0((ds) obj);
            }
        });
        this.G.f2().observe(this.E, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCustomMaterialPart.this.j0((Boolean) obj);
            }
        });
        this.G.d2().observe(this.E, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCustomMaterialPart.this.A0((Boolean) obj);
            }
        });
        this.G.h2().observe(this.E, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCustomMaterialPart.this.A0((Boolean) obj);
            }
        });
        this.G.k2().observe(this.E, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCustomMaterialPart.this.A0((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        X();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Boolean bool) {
        if (this.f64505m == null) {
            return;
        }
        if (bool != null && bool.booleanValue()) {
            Z();
        } else {
            F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(ds dsVar) {
        if (this.f64505m == null) {
            return;
        }
        boolean z16 = dsVar != null && dsVar.getShow();
        E0(z16 ? 0.0f : S());
        if (this.W && z16) {
            this.f64505m.setVisibility(0);
        }
        K0(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k0(Boolean bool) {
        U(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(final String str, final boolean z16, final LocalMediaInfo localMediaInfo) {
        com.tencent.aelight.camera.ae.camera.ui.gallery.t.b(this.T, this.S, str, new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.af
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCustomMaterialPart.this.m0();
            }
        }, new Consumer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ag
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                AEFlashShowCustomMaterialPart.this.p0(z16, localMediaInfo, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        this.E.z1().v(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, String str2) {
        LSCaptureController z16 = this.E.z1();
        AEMaterialMetaData aEMaterialMetaData = this.P;
        z16.v(aEMaterialMetaData == null ? null : aEMaterialMetaData.f69050id, str);
        this.E.z2(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(final boolean z16, final LocalMediaInfo localMediaInfo, final String str, final String str2) {
        this.E.u2(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ah
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCustomMaterialPart.this.o0(z16, localMediaInfo, str2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r0(Boolean bool) {
        U(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s0(Boolean bool) {
        U(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0() {
        com.tencent.aelight.camera.ae.config.g gVar = this.K;
        if (gVar != null) {
            this.I.removeObserver(gVar);
            this.K = null;
        }
    }

    private boolean x0() {
        HashMap<String, String> hashMap;
        MaterialConfig W = W();
        return (W == null || (hashMap = W.aiFilterList) == null || !hashMap.containsKey("ai.face")) ? false : true;
    }

    private void y0(final LocalMediaInfo localMediaInfo, final String str, final boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ae
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCustomMaterialPart.this.l0(str, z16, localMediaInfo);
            }
        });
    }

    private void z0(final AEMaterialMetaData aEMaterialMetaData) {
        this.E.z1().v(null, null);
        this.P = aEMaterialMetaData;
        if (aEMaterialMetaData != null && aEMaterialMetaData != AEMaterialMetaData.MATERIAL_NONE) {
            c cVar = this.Q.get(aEMaterialMetaData.f69050id);
            if (cVar != null) {
                R();
                L0(cVar.f64512a != null);
                return;
            } else {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowCustomMaterialPart.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            LightAsset lightAsset = VideoSDKMaterialParser.parseVideoMaterial(aEMaterialMetaData.getLocalPath(), "params").getLightAsset();
                            final c cVar2 = new c();
                            cVar2.f64512a = (lightAsset == null || lightAsset.getMaterialConfigs() == null || lightAsset.getMaterialConfigs().length <= 0) ? null : lightAsset.getMaterialConfigs()[0];
                            AEFlashShowCustomMaterialPart.this.Q.put(aEMaterialMetaData.f69050id, cVar2);
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowCustomMaterialPart.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AEMaterialMetaData aEMaterialMetaData2 = AEFlashShowCustomMaterialPart.this.P;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (aEMaterialMetaData2 == aEMaterialMetaData) {
                                        AEFlashShowCustomMaterialPart.this.L0(cVar2.f64512a != null);
                                    }
                                }
                            });
                        } catch (Throwable th5) {
                            w53.b.e("AEFlashShowCustomMaterialPart", th5);
                        }
                    }
                });
                return;
            }
        }
        R();
        L0(false);
    }

    @Override // lq.a
    protected void e() {
        View inflate = ((ViewStub) this.f415376e.findViewById(R.id.s1r)).inflate();
        this.f64505m = inflate;
        ((ViewGroup.MarginLayoutParams) inflate.getLayoutParams()).bottomMargin = com.tencent.aelight.camera.ae.camera.ui.gallery.t.e(this.f64505m.getContext()) - this.f64505m.getResources().getDimensionPixelSize(R.dimen.f158046bb2);
        this.f64505m.findViewById(R.id.rpd).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEFlashShowCustomMaterialPart.this.e0(view);
            }
        });
        this.f64505m.findViewById(R.id.ruj).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEFlashShowCustomMaterialPart.this.f0(view);
            }
        });
        this.f64505m.setTranslationY(com.tencent.av.utils.ba.dp2px(this.f415377f, 85.0f));
        this.f64505m.setVisibility(8);
        d0();
        V();
    }

    @Override // lq.a
    public void h() {
        View view;
        super.h();
        if (this.U) {
            this.U = false;
        } else {
            if (this.H == null || (view = this.f64505m) == null || view.getVisibility() != 0) {
                return;
            }
            this.H.B0(this.f415377f, false, new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ar
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k06;
                    k06 = AEFlashShowCustomMaterialPart.this.k0((Boolean) obj);
                    return k06;
                }
            });
        }
    }

    @Override // lq.a
    public void onDestroy() {
        MiniPhotoListAdapter miniPhotoListAdapter = this.H;
        if (miniPhotoListAdapter != null) {
            miniPhotoListAdapter.u0();
        }
        super.onDestroy();
    }

    private void C0(FrameLayout frameLayout, TextView textView, RecyclerView recyclerView, boolean z16) {
        String str;
        frameLayout.setVisibility(0);
        recyclerView.setVisibility(0);
        textView.setVisibility(8);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            MiniPhotoListAdapter miniPhotoListAdapter = new MiniPhotoListAdapter(new MiniPhotoListAdapter.b() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ai
                @Override // com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter.b
                public final void a(PTFaceAttr pTFaceAttr, LocalMediaInfo localMediaInfo) {
                    AEFlashShowCustomMaterialPart.this.q0(pTFaceAttr, localMediaInfo);
                }
            });
            miniPhotoListAdapter.A0(this.P.f69050id);
            recyclerView.setAdapter(miniPhotoListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f415377f, 0, false));
            recyclerView.addItemDecoration(com.tencent.aelight.camera.ae.camera.ui.gallery.t.a());
            this.H = miniPhotoListAdapter;
            miniPhotoListAdapter.B0(this.f415377f, z16, new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.aj
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit r06;
                    r06 = AEFlashShowCustomMaterialPart.this.r0((Boolean) obj);
                    return r06;
                }
            });
            return;
        }
        MiniPhotoListAdapter miniPhotoListAdapter2 = (MiniPhotoListAdapter) adapter;
        String bindId = miniPhotoListAdapter2.getBindId();
        AEMaterialMetaData aEMaterialMetaData = this.P;
        if (aEMaterialMetaData == null || (str = aEMaterialMetaData.f69050id) == null || str.equals(bindId)) {
            return;
        }
        miniPhotoListAdapter2.A0(this.P.f69050id);
        if (miniPhotoListAdapter2.getDetectFace() != x0()) {
            miniPhotoListAdapter2.B0(this.f415377f, z16, new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ak
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s06;
                    s06 = AEFlashShowCustomMaterialPart.this.s0((Boolean) obj);
                    return s06;
                }
            });
        }
    }

    private void N() {
        this.W = false;
        this.f64505m.setAlpha(0.0f);
        this.f64505m.setVisibility(0);
        J0();
        this.f64505m.animate().alpha(1.0f).setDuration(200L).setListener(null);
        Q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0() {
        H0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        H0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(boolean z16) {
        if (z16) {
            F0();
        } else {
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            F0();
        } else {
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(boolean z16, LocalMediaInfo localMediaInfo, final String str, final String str2) {
        if (z16) {
            MiniPhotoListAdapter miniPhotoListAdapter = this.H;
            if (miniPhotoListAdapter != null) {
                miniPhotoListAdapter.z0(localMediaInfo);
                ((RecyclerView) this.f64505m.findViewById(R.id.ryb)).scrollToPosition(0);
            }
        } else {
            this.H.y0(localMediaInfo);
        }
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.al
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCustomMaterialPart.this.n0(str, str2);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(PTFaceAttr pTFaceAttr, LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null || !O(localMediaInfo)) {
            return;
        }
        T(localMediaInfo, pTFaceAttr);
    }

    @Override // lq.a
    public void l(int i3, Object... objArr) {
        switch (i3) {
            case 851969:
                if (objArr == null || objArr.length <= 0) {
                    return;
                }
                Object obj = objArr[0];
                if (obj instanceof Float) {
                    E0(((Float) obj).floatValue());
                    return;
                }
                return;
            case 851970:
                if (objArr == null || objArr.length <= 0) {
                    return;
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof AEMaterialMetaData) {
                    z0((AEMaterialMetaData) obj2);
                    return;
                }
                return;
            case 851971:
                F0();
                return;
            case 851972:
                Z();
                return;
            case 851973:
                if (objArr == null || objArr.length <= 0) {
                    return;
                }
                List list = (List) objArr[0];
                this.S = ((Integer) list.get(0)).intValue();
                this.T = ((Integer) list.get(1)).intValue();
                if (dr.c.b() < 3) {
                    int i16 = this.S;
                    if (i16 < this.T) {
                        this.S = Math.min(i16, this.R[1]);
                        this.T = Math.min(this.T, this.R[0]);
                        return;
                    } else {
                        this.S = Math.min(i16, this.R[0]);
                        this.T = Math.min(this.T, this.R[1]);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // lq.a
    public void g(int i3, int i16, Intent intent) {
        ArrayList parcelableArrayListExtra;
        if (i3 != 1027) {
            return;
        }
        if (i16 == 0 && intent == null) {
            LocalMediaInfo a16 = os.a.f423933a.a();
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(a16);
        } else {
            parcelableArrayListExtra = (i16 != -1 || intent == null) ? null : intent.getParcelableArrayListExtra("selected_local_infos");
        }
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            return;
        }
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) parcelableArrayListExtra.get(0);
        if (localMediaInfo != null) {
            y0(localMediaInfo, localMediaInfo.path, true);
        }
        this.U = true;
    }
}
