package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.play.AEPlayShowGridAdapter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import lf0.b;

/* loaded from: classes32.dex */
public class AEBottomListPart extends com.tencent.aelight.camera.ae.part.b implements AEBottomListScrollView.c<AEBottomListAdapter.b>, AEBottomListScrollView.d<AEBottomListAdapter.b>, AEBottomListScrollView.b, yq2.c {
    protected AEMaterialManager C;
    protected int D;
    private AECaptureMode E;
    private com.tencent.aelight.camera.ae.view.a F;
    private volatile boolean G;
    private final CountDownLatch H;

    /* renamed from: d, reason: collision with root package name */
    protected AEPituCameraUnit f62495d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f62496e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f62497f;

    /* renamed from: h, reason: collision with root package name */
    protected AEBottomListScrollView f62498h;

    /* renamed from: i, reason: collision with root package name */
    protected AEBottomListAdapter f62499i;

    /* renamed from: m, reason: collision with root package name */
    protected AECaptureController f62500m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart$16, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass16 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f62503d;

        AnonymousClass16(String str) {
            this.f62503d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            final AEMaterialMetaData M = AEBottomListPart.this.M(this.f62503d, com.tencent.aelight.camera.ae.data.b.a().b());
            if (M != null) {
                if (M.usable) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ms.a.f("AEBottomListPart", " material usable id: " + M.f69050id);
                            AEBottomListPart.this.f62500m.v(M);
                            AEBottomListPart.this.C.y0(M, false);
                        }
                    });
                    return;
                } else {
                    AEMaterialManager aEMaterialManager = AEBottomListPart.this.C;
                    aEMaterialManager.E0(aEMaterialManager.getApp(), M, new com.tencent.aelight.camera.download.a() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16.2
                        @Override // com.tencent.aelight.camera.download.a
                        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
                            String str;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(" download finish: ");
                            sb5.append(z16);
                            sb5.append(" id: ");
                            if (aEMaterialMetaData == null) {
                                str = "null";
                            } else {
                                str = aEMaterialMetaData.f69050id;
                            }
                            sb5.append(str);
                            ms.a.f("AEBottomListPart", sb5.toString());
                            if (z16) {
                                M.usable = true;
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        AEBottomListPart.this.f62500m.v(M);
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        AEBottomListPart.this.C.y0(M, false);
                                    }
                                });
                            }
                        }

                        @Override // com.tencent.aelight.camera.download.a
                        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
                        }
                    });
                    return;
                }
            }
            ms.a.c("AEBottomListPart", "meta data is null =======");
        }
    }

    /* loaded from: classes32.dex */
    class e implements AEBottomListAdapter.a {
        e() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.a
        public void a() {
            ((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mPartManager.q(131076, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements jf0.c {
        h() {
        }

        @Override // jf0.c
        public void onStart() {
            AEBottomListPart.this.f62498h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEBottomListPart.this.G = true;
            AEBottomListPart.this.H.countDown();
            AEBottomListPart.this.C.j0();
            AEBottomListPart.this.F.cancel();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AEBottomListPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.G = false;
        this.H = new CountDownLatch(1);
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.f62495d = aEPituCameraUnit;
        this.f62500m = aEPituCameraUnit.I1();
    }

    private void I() {
        AEMaterialMetaData H = AEMaterialManager.H();
        if (H != null) {
            AEMaterialMetaData C = this.f62499i.C(this.D);
            if (C != null && H.f69050id.equals(C.f69050id)) {
                k0(this.D);
                return;
            }
            for (int i3 = 0; i3 < this.f62499i.getItemCount(); i3++) {
                AEMaterialMetaData C2 = this.f62499i.C(i3);
                if (C2 != null && H.f69050id.equals(C2.f69050id)) {
                    k0(i3);
                    return;
                }
            }
            k0(this.D);
            return;
        }
        k0(0);
    }

    private void J() {
        com.tencent.aelight.camera.ae.view.a aVar;
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || (aVar = this.F) == null || !aVar.isShowing()) {
            return;
        }
        this.F.dismiss();
    }

    private AEMaterialMetaData L(int i3) {
        AEBottomListAdapter aEBottomListAdapter = this.f62499i;
        if (aEBottomListAdapter != null) {
            return aEBottomListAdapter.C(i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AEMaterialMetaData M(String str, List<AEMaterialCategory> list) {
        List<AEMaterialMetaData> list2;
        for (AEMaterialCategory aEMaterialCategory : list) {
            if (aEMaterialCategory != null && (list2 = aEMaterialCategory.f69044d) != null) {
                Iterator<AEMaterialMetaData> it = list2.iterator();
                while (it.hasNext()) {
                    AEMaterialMetaData next = it.next();
                    if (next != null && (TextUtils.isEmpty(str) || str.equals(next.f69050id))) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, String str2) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (str == null || str.equals(AECaptureMode.NORMAL.name)) {
            if (!TextUtils.isEmpty(str2)) {
                if (str2.startsWith("http")) {
                    R(str2);
                } else if (!this.G) {
                    Q(str2);
                } else {
                    ms.a.f("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
                    P();
                }
            } else {
                P();
            }
        }
        J();
        this.C.g(this, 116);
    }

    private void P() {
        int i3;
        AEMaterialMetaData H = AEMaterialManager.H();
        if (H != null) {
            i3 = H(H.f69050id);
            if (i3 == -1) {
                this.f62499i.A(H);
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        if (i3 < this.f62499i.getItemCount()) {
            this.f62498h.scrollToPosition(i3);
        }
    }

    private void Q(String str) {
        AEPituCameraUnit aEPituCameraUnit;
        AEBaseReportParam.U().Q0("-1");
        int H = H(str);
        if (H != -1) {
            this.mActivity.getIntent().putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "camera^" + str);
            AEMaterialMetaData L = L(H);
            if (L != null) {
                com.tencent.aelight.camera.ae.report.b.b().L0(L.f69050id);
                L.ischoose = true;
                this.mActivity.getIntent().putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, L.takeSameName);
            }
        } else {
            AEMaterialManager aEMaterialManager = this.C;
            AEPituCameraUnit aEPituCameraUnit2 = this.f62495d;
            AEMaterialMetaData A = aEMaterialManager.A(str, aEPituCameraUnit2 != null && aEPituCameraUnit2.Q());
            if (A != null) {
                this.f62499i.A(A);
                com.tencent.aelight.camera.ae.report.b.b().L0(A.f69050id);
                A.ischoose = true;
                H = 1;
            } else {
                if (this.E == AECaptureMode.NORMAL && (aEPituCameraUnit = this.f62495d) != null) {
                    QQToast.makeText(aEPituCameraUnit.z(), R.string.y0q, 1).show();
                }
                H = 0;
            }
        }
        if (H < this.f62499i.getItemCount()) {
            k0(H);
            this.f62498h.getAdapter().notifyDataSetChanged();
        }
    }

    private void R(String str) {
        ms.a.f("AEBottomListPart", "handleTakeSameH5Enter---url=" + str);
        try {
            Intent intent = new Intent(this.f62495d.z(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
            intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, str);
            if (this.mActivity.getIntent().hasExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE)) {
                intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, this.mActivity.getIntent().getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
            } else {
                intent.putExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, this.mActivity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
            }
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.V.b());
            intent.putExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID, this.mActivity.getIntent().getStringExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID));
            this.f62495d.z().startActivity(intent);
            this.mActivity.getIntent().removeExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S() {
        if (this.mActivity == null) {
            return true;
        }
        return !gq.a.r(r0.getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        Boolean value;
        com.tencent.aelight.camera.ae.part.a aVar = this.f62497f;
        return !S() && this.f62496e.O1() && ((aVar == null || aVar.M1() == null || (value = this.f62497f.M1().getValue()) == null) ? true : value.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(final String str, final String str2, boolean z16) {
        final List<AEMaterialMetaData> Z = this.C.Z(z16, W());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.7
            @Override // java.lang.Runnable
            public void run() {
                if (((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mActivity == null || ((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mActivity.isFinishing()) {
                    return;
                }
                if (AEBottomListPart.this.V()) {
                    AEBottomListPart.this.f62498h.setVisibility(0);
                }
                AEBottomListPart.this.f62499i.P(Z);
            }
        });
        AEMaterialMetaData A = this.C.A(str2, W());
        if (K(str, str2) && A != null && !A.downloading && !A.usable) {
            if (!NetworkUtil.isNetworkAvailable(this.mActivity)) {
                ms.a.f("AEBottomListPart", "loadAndHandleData---no network");
                this.G = true;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.v7o));
                    }
                });
            } else {
                AEMaterialManager aEMaterialManager = this.C;
                aEMaterialManager.E0(aEMaterialManager.getApp(), A, new com.tencent.aelight.camera.download.a() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.9
                    @Override // com.tencent.aelight.camera.download.a
                    public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z17, int i3) {
                        ms.a.f("AEBottomListPart", "loadAndHandleData---download finish, isSuccess=" + z17);
                        if (!z17) {
                            AEBottomListPart.this.G = true;
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QQToast.makeText(((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mActivity, HardCodeUtil.qqStr(R.string.qdx), 0).show();
                                }
                            });
                        }
                        AEBottomListPart.this.H.countDown();
                    }

                    @Override // com.tencent.aelight.camera.download.a
                    public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, final int i3) {
                        if (i3 <= 1 || i3 > 100) {
                            return;
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.9.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AEBottomListPart.this.F != null) {
                                    AEBottomListPart.this.F.P((int) ((i3 * 0.9f) + 10.0f));
                                }
                            }
                        });
                    }
                });
                ms.a.f("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
                try {
                    this.H.await();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                ms.a.f("AEBottomListPart", "wait till takeSameMaterial download finish, OVER");
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.10
            @Override // java.lang.Runnable
            public void run() {
                AEBottomListPart.this.O(str, str2);
            }
        });
    }

    private void i0() {
        String j3 = AECameraPrefsUtil.f().j(AECameraConstants.SP_KEY_AE_USER_SELECTED_WATERMARK, "", 0);
        if (AECameraConstants.SP_VAL_AE_USER_SELECTED_WATERMARK_NONE.equals(j3)) {
            return;
        }
        ms.a.f("AEBottomListPart", "recoverLastWatermark---materialId=" + j3);
        com.tencent.aelight.camera.ae.report.b.b().F0();
        ThreadManagerV2.excute(new AnonymousClass16(j3), 64, null, true);
    }

    private void j0() {
        if (AEMaterialManager.H() == null || !AEMaterialManager.H().editablewatermark) {
            return;
        }
        AEMaterialManager.H().ischoose = true;
    }

    private void m0() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.F == null) {
            com.tencent.aelight.camera.ae.view.a aVar = new com.tencent.aelight.camera.ae.view.a(this.mActivity);
            this.F = aVar;
            aVar.O(new i());
        }
        this.F.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (V()) {
            ViewAnimator.j(this.f62498h).a(0.0f, 1.0f).c(300L).h(new h()).k();
        }
    }

    public AEMaterialManager N() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T(int i3) {
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f62498h, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new c(i3));
        this.f62498h.startAnimation(b16);
    }

    protected void U(int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f62498h, "translationY", 0.0f, UIUtils.b(this.mActivity, this.f62498h.getHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new b());
        animatorSet.setDuration(300L).start();
        T(i3);
    }

    public boolean W() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intent = this.mActivity.getIntent();
        final String stringExtra = intent.getStringExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID);
        final String stringExtra2 = intent.getStringExtra(IAECameraUnit.KEY_CURRENT_TAB);
        if ("null".equalsIgnoreCase(stringExtra)) {
            stringExtra = null;
        }
        final boolean K = K(stringExtra2, stringExtra);
        if (K) {
            ((AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1)).x0(stringExtra);
            AEMaterialMetaData A = this.C.A(stringExtra, W());
            if (A != null && A.usable) {
                K = false;
            }
            if (K) {
                m0();
                com.tencent.aelight.camera.ae.view.a aVar = this.F;
                if (aVar != null) {
                    aVar.P(10);
                }
            }
            intent.removeExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID);
            intent.removeExtra(IAECameraUnit.KEY_CURRENT_TAB);
        }
        ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("AEBottomListPart", 4, "loadData: runnable run");
                AEBottomListPart.this.Y(stringExtra2, stringExtra, K);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.d
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void l(AEBottomListAdapter.b bVar, int i3) {
        if (!"call_material_id".equals(bVar.f62489d.f69050id)) {
            this.D = i3;
            bVar.f62489d.ischoose = true;
            if (AEMaterialManager.H() != null && !AEMaterialManager.H().equals(bVar.f62489d)) {
                AEMaterialManager.H().ischoose = false;
                AEMaterialManager.H().isdoubleclick = false;
            }
        }
        QLog.d("AEBottomListPart", 4, "prePosition:" + this.D);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.c
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void c(AEBottomListAdapter.b bVar, boolean z16) {
        AEMaterialMetaData aEMaterialMetaData = bVar.f62489d;
        if (aEMaterialMetaData.ischoose) {
            aEMaterialMetaData.isdoubleclick = true;
        } else {
            aEMaterialMetaData.ischoose = true;
        }
        if ("call_material_id".equals(aEMaterialMetaData.f69050id) || AEMaterialManager.H() == null || AEMaterialManager.H().equals(bVar.f62489d)) {
            return;
        }
        AEMaterialManager.H().ischoose = false;
        AEMaterialManager.H().isdoubleclick = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0() {
        this.f62499i.O();
        AEBaseReportParam.U().s0();
        com.tencent.aelight.camera.ae.report.b.b().g1();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.b
    public void h() {
        if (AEPlayShowGridAdapter.selectedMidMaterialNotConsumed()) {
            a0(AEPlayShowGridAdapter.selectedMidMaterial);
            AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        View view = this.mRootView;
        if (view != null) {
            AEBottomListScrollView aEBottomListScrollView = (AEBottomListScrollView) ((ViewStub) view.findViewById(R.id.f163792s13)).inflate().findViewById(R.id.rz_);
            this.f62498h = aEBottomListScrollView;
            aEBottomListScrollView.setSlideOnFling(true);
            this.f62498h.setItemTransitionTimeMillis(100);
            this.f62498h.setSlideOnFlingThreshold(1000);
            this.f62498h.setOffscreenItems(10);
            this.f62498h.setOnItemChangedListener(this);
            this.f62498h.setScrollStateChangeListener(this);
            this.f62498h.setItemTransformer(new b.a().b(0.754f).a());
            this.f62498h.setLayoutCallback(this);
            AEBottomListAdapter aEBottomListAdapter = new AEBottomListAdapter(this.f62495d, this.f62498h, this.f62500m);
            this.f62499i = aEBottomListAdapter;
            aEBottomListAdapter.N(new e());
            this.f62498h.setAdapter(this.f62499i);
            this.C = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
            if (!S()) {
                this.C.g(this, 113);
                this.C.g(this, 114);
                this.C.g(this, 115);
                this.C.g(this, 112);
                g0();
                Z();
            } else {
                this.f62498h.setVisibility(8);
                this.f62499i.J();
            }
        }
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f62495d).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f62496e = cVar;
        cVar.f65622i.observe(this.f62495d, new f());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.f62495d).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f62497f = aVar;
        aVar.M1().observe(this.f62495d, new g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(int i3) {
        ms.a.a("AEBottomListPart", "reset Selection pos: " + i3);
        this.f62498h.t(i3, this.f62499i.C(i3));
        this.f62498h.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0() {
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f62498h, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new d());
        this.f62498h.startAnimation(b16);
    }

    protected void n0() {
        int b16 = UIUtils.b(this.mActivity, this.f62498h.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f62498h, "translationY", b16, 0.0f));
        animatorSet.addListener(new a());
        animatorSet.setDuration(300L).start();
        l0();
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        ms.a.a("AEBottomListPart", "AEBottomListPart notify---eventId=" + i3);
        if (i3 == 113) {
            AEMaterialMetaData H = AEMaterialManager.H();
            if (H != null && !H.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                a0(H);
            } else {
                k0(0);
                if (W()) {
                    i0();
                }
            }
            QLog.d("AEBottomListPart", 4, "current pendant has change");
            return;
        }
        if (i3 == 1024) {
            QLog.d("AEBottomListPart", 4, "current watermark has change");
            k0(0);
            return;
        }
        if (i3 == 114) {
            AEMaterialMetaData H2 = AEMaterialManager.H();
            if (H2 != null && !H2.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                H2.editablewatermark = true;
            }
            a0(H2);
            return;
        }
        if (i3 == 115) {
            AEMaterialMetaData H3 = AEMaterialManager.H();
            if (H3 != null) {
                H3.editablewatermark = false;
            }
            a0(H3);
            return;
        }
        if (i3 != 112) {
            if (i3 == 116) {
                ms.a.f("AEBottomListPart", "notify---TEMPLATE_INFO_LIST_UPDATE");
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.15
                    @Override // java.lang.Runnable
                    public void run() {
                        AEBottomListPart aEBottomListPart = AEBottomListPart.this;
                        AEBottomListPart.this.f62499i.P(aEBottomListPart.C.x(aEBottomListPart.W()));
                        AEMaterialMetaData H4 = AEMaterialManager.H();
                        if (H4 != null && !H4.equals(AEMaterialMetaData.MATERIAL_NONE)) {
                            AEBottomListPart.this.a0(H4);
                        } else {
                            AEBottomListPart.this.k0(0);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj2 = objArr[0];
        if (obj2 instanceof AEMaterialMetaData) {
            AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) obj2;
            for (int i16 = 0; i16 < this.f62499i.getItemCount(); i16++) {
                AEMaterialMetaData C = this.f62499i.C(i16);
                if (C != null && aEMaterialMetaData.f69050id.equals(C.f69050id)) {
                    C.usable = true;
                    C.downloading = false;
                    this.f62499i.notifyItemChanged(i16);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (V()) {
            this.f62498h.setVisibility(0);
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        if (AEMaterialManager.H() == null || AEMaterialManager.H().isNoneMaterial() || this.mActivity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM) != null) {
            return;
        }
        this.mActivity.getIntent().putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "camera^" + AEMaterialManager.H().f69050id);
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        this.C.n0(this);
        this.C.l();
        AEBottomListAdapter aEBottomListAdapter = this.f62499i;
        if (aEBottomListAdapter != null) {
            aEBottomListAdapter.onDestroy();
        }
    }

    protected void p0() {
        if (this.f62496e.N1()) {
            com.tencent.aelight.camera.ae.part.c cVar = this.mPartManager;
            if (cVar != null) {
                cVar.q(327684, new Object[0]);
                this.mPartManager.q(196612, new Object[0]);
            }
            this.f62495d.I1().a(true, 150);
            return;
        }
        U(327684);
    }

    protected void q0() {
        if (this.f62496e.N1()) {
            com.tencent.aelight.camera.ae.part.c cVar = this.mPartManager;
            if (cVar != null) {
                cVar.q(327701, new Object[0]);
                this.mPartManager.q(196612, new Object[0]);
            }
            this.f62495d.I1().a(true, 150);
            return;
        }
        U(327701);
    }

    protected void r0() {
        if (this.f62496e.N1()) {
            com.tencent.aelight.camera.ae.part.c cVar = this.mPartManager;
            if (cVar != null) {
                cVar.q(327683, new Object[0]);
                this.mPartManager.q(196612, new Object[0]);
            }
            this.f62495d.I1().a(true, 150);
            return;
        }
        if (this.f62496e.L1()) {
            com.tencent.aelight.camera.ae.part.c cVar2 = this.mPartManager;
            if (cVar2 != null) {
                cVar2.q(FileMsg.TRANSFILE_TYPE_ZPLAN_UGC_DYEING, new Object[0]);
            }
            Log.d("AEBottomListPart", "arcake : startARPanel");
            this.f62495d.I1().a(true, 150);
            return;
        }
        U(327683);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.d
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void j(AEBottomListAdapter.b bVar, int i3) {
        bVar.d(4);
        if (!"call_material_id".equals(bVar.f62489d.f69050id) && !this.f62499i.D()) {
            AEMaterialMetaData aEMaterialMetaData = bVar.f62489d;
            if (aEMaterialMetaData.editablewatermark) {
                aEMaterialMetaData.ischoose = false;
                aEMaterialMetaData.isdoubleclick = false;
            }
        }
        this.f62499i.M(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<AECaptureModeChangingEvent> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent == null) {
                return;
            }
            AEBottomListPart.this.f62495d.c3();
            AEBottomListPart.this.E = aECaptureModeChangingEvent.f65599b;
            if (AEBottomListPart.this.E == AECaptureMode.NORMAL) {
                AEBottomListPart.this.o0();
            } else if (AEBottomListPart.this.E == AECaptureMode.GIF) {
                AEBottomListPart.this.f62498h.setVisibility(8);
            } else if (AEBottomListPart.this.E == AECaptureMode.PLAY) {
                AEBottomListPart.this.f62498h.setVisibility(8);
            }
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
            if (AEBottomListPart.this.f62496e.N1()) {
                AEBottomListPart.this.f62498h.setVisibility(8);
                return;
            }
            if (AEBottomListPart.this.f62496e.O1()) {
                if (!AEBottomListPart.this.S()) {
                    AEBottomListPart.this.f62498h.setVisibility(bool.booleanValue() ? 0 : 4);
                    return;
                } else {
                    AEBottomListPart.this.f62498h.setVisibility(8);
                    return;
                }
            }
            if (AEBottomListPart.this.f62496e.P1()) {
                AEBottomListPart.this.f62498h.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(AEMaterialMetaData aEMaterialMetaData) {
        boolean z16;
        if (aEMaterialMetaData == null || aEMaterialMetaData.equals(AEMaterialMetaData.MATERIAL_NONE)) {
            return;
        }
        for (int i3 = 1; i3 < this.f62499i.getItemCount() && this.f62499i.C(i3) != null; i3++) {
            if (aEMaterialMetaData.f69050id.equals(this.f62499i.C(i3).f69050id)) {
                this.f62499i.C(i3).syncStateBy(aEMaterialMetaData);
                k0(i3);
                z16 = true;
                break;
            }
        }
        z16 = false;
        if (z16) {
            return;
        }
        this.f62499i.A(aEMaterialMetaData);
        k0(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean X(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData != null) {
            return aEMaterialMetaData.isWsBanner();
        }
        return false;
    }

    private boolean K(String str, String str2) {
        return ((str != null && !str.equals(AECaptureMode.NORMAL.name)) || TextUtils.isEmpty(str2) || str2.startsWith("http")) ? false : true;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.c
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void g(AEBottomListAdapter.b bVar, int i3) {
        if (bVar != null) {
            bVar.d(3);
            AEMaterialMetaData aEMaterialMetaData = bVar.f62489d;
            com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().l(aEMaterialMetaData);
            if (this.f62499i != null) {
                if (X(aEMaterialMetaData)) {
                    l.g(this.mActivity, aEMaterialMetaData, 1);
                } else {
                    this.f62499i.B(aEMaterialMetaData);
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 131075:
                MutableLiveData<Boolean> P1 = this.f62497f.P1();
                Boolean bool = Boolean.FALSE;
                P1.postValue(bool);
                this.f62497f.Q1().postValue(bool);
                this.f62497f.L1().postValue(bool);
                j0();
                if (!this.f62496e.O1() || S()) {
                    return;
                }
                I();
                n0();
                return;
            case 131076:
                r0();
                return;
            case 131077:
                p0();
                return;
            case FileMsg.TRANSFILE_TYPE_MULTIMSG /* 131078 */:
                this.f62497f.Q1().postValue(Boolean.TRUE);
                s0();
                return;
            case 131079:
                q0();
                return;
            default:
                return;
        }
    }

    private int H(String str) {
        if (str == null) {
            return -1;
        }
        for (int i3 = 0; i3 < this.f62499i.getItemCount(); i3++) {
            AEMaterialMetaData C = this.f62499i.C(i3);
            if (C != null && str.equals(C.f69050id)) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AEBottomListPart", 2, "Watermark Panel Opened!");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AEBottomListPart", 2, "Watermark panel down");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f62519d;

        c(int i3) {
            this.f62519d = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEBottomListPart aEBottomListPart = AEBottomListPart.this;
            if (aEBottomListPart.f62498h != null && !aEBottomListPart.S()) {
                AEBottomListPart.this.f62498h.setAlpha(1.0f);
                AEBottomListPart.this.f62498h.setVisibility(4);
            }
            if (((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mPartManager != null) {
                ((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mPartManager.q(this.f62519d, new Object[0]);
                ((com.tencent.aelight.camera.ae.part.b) AEBottomListPart.this).mPartManager.q(196612, new Object[0]);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AEBottomListPart.this.f62495d.I1().a(true, 150);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AEBottomListPart aEBottomListPart = AEBottomListPart.this;
            if (aEBottomListPart.f62498h == null || !aEBottomListPart.V()) {
                return;
            }
            AEBottomListPart.this.f62498h.setAlpha(1.0f);
            AEBottomListPart.this.f62498h.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    protected void s0() {
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.d
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void k(float f16, int i3, int i16, AEBottomListAdapter.b bVar, AEBottomListAdapter.b bVar2) {
    }
}
