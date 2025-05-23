package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.util.LiuHaiUtils;
import com.tribe.async.async.JobSegment;
import hr.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import wr.a;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoDoodle extends u implements DoodleLayout.r, DoodleLayout.q, com.tencent.aelight.camera.aioeditor.takevideo.d {
    public static final String N = vc0.a.f441365e;
    public static String P = "EditVideoDoodle";
    private static int Q;
    private static int R;
    public int C;
    protected boolean D;
    protected Handler E;
    public boolean F;
    private long G;
    protected boolean H;
    protected boolean I;
    private ViewTreeObserver.OnGlobalLayoutListener J;
    protected Runnable K;
    a.j L;
    qs.b M;

    /* renamed from: d, reason: collision with root package name */
    private ViewStub f67754d;

    /* renamed from: e, reason: collision with root package name */
    protected DoodleLayout f67755e;

    /* renamed from: f, reason: collision with root package name */
    private DoodleView f67756f;

    /* renamed from: h, reason: collision with root package name */
    public ProviderViewEditContainer f67757h;

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f67758i;

    /* renamed from: m, reason: collision with root package name */
    private final int f67759m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends qs.b {
        a() {
        }

        @Override // qs.b
        public void a() {
            hd0.c.k("Q.qqstory.publish.edit.StoryDoodle", "DoodleInfoLoadObserver, onLoadSucc");
            EditVideoDoodle.this.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DoodleEditView.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.b
        public void a(c.a aVar) {
            EditVideoDoodle.this.f67757h.f(103, aVar);
            EditVideoPartManager editVideoPartManager = EditVideoDoodle.this.mParent;
            if (editVideoPartManager.f67780d == 0) {
                editVideoPartManager.t(11);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.b
        public void b() {
            EditVideoDoodle.this.f67757h.c();
            EditVideoPartManager editVideoPartManager = EditVideoDoodle.this.mParent;
            if (editVideoPartManager.f67780d == 11) {
                editVideoPartManager.t(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return EditVideoDoodle.this.f67757h.b(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            EditVideoDoodle.this.f67755e.getViewTreeObserver().removeGlobalOnLayoutListener(EditVideoDoodle.this.J);
            EditVideoDoodle.this.mParent.s(Message.obtain((Handler) null, 16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements a.j {
        e() {
        }

        @Override // wr.a.j
        public void a(int i3, List<bd0.a> list) {
            hd0.c.a("Q.qqstory.publish.edit.StoryDoodle", "onPOIPostersRequestResult callback");
            EditVideoDoodle editVideoDoodle = EditVideoDoodle.this;
            editVideoDoodle.D = true;
            editVideoDoodle.E.removeCallbacks(editVideoDoodle.K);
            if (list == null) {
                list = Collections.EMPTY_LIST;
            }
            com.tencent.biz.qqstory.base.c.a().dispatch(new a.h(i3, list));
        }
    }

    public EditVideoDoodle(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager);
        this.C = 1;
        this.E = new Handler(Looper.getMainLooper());
        this.F = false;
        this.G = 0L;
        this.H = false;
        this.I = false;
        this.J = new d();
        this.K = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.5
            @Override // java.lang.Runnable
            public void run() {
                EditVideoDoodle editVideoDoodle = EditVideoDoodle.this;
                if (editVideoDoodle.D) {
                    return;
                }
                editVideoDoodle.L.a(1, Collections.EMPTY_LIST);
            }
        };
        this.L = new e();
        this.M = new a();
        this.f67759m = i3;
    }

    private void k0(EditVideoParams.EditSource editSource, int i3) {
        int width = editSource.getWidth();
        int height = editSource.getHeight();
        if (i3 == 90 || i3 == 270) {
            width = Math.min(editSource.getWidth(), editSource.getHeight());
            height = Math.max(editSource.getWidth(), editSource.getHeight());
        }
        if (this.mParent.f0() != null && !this.mParent.f0().getTakePicToVideo()) {
            this.f67755e.R();
        }
        l0(width, height, this.f67756f);
        l0(width, height, this.f67755e.f68172u0);
    }

    private void l0(int i3, int i16, View view) {
        if (view == null) {
            ms.a.c("Q.qqstory.publish.edit.StoryDoodle", "doodle main layout null");
            return;
        }
        n0();
        float f16 = i3 / i16;
        int i17 = Q;
        int i18 = (int) (i17 / f16);
        ms.a.f("Q.qqstory.publish.edit.StoryDoodle", "adjustDoodleLayoutSize---screenWidth=" + Q + ", screenHeight=" + R + ", viewWidth=" + i17 + ", viewHeight=" + i18);
        int min = Math.min(i18, R);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i17;
            layoutParams.height = min;
            layoutParams.addRule(15);
            view.setLayoutParams(layoutParams);
        }
    }

    private void m0() {
        if (this.mParent.C.q()) {
            EditVideoPartManager editVideoPartManager = this.mParent;
            if (editVideoPartManager.C.f204055d == 14) {
                if (editVideoPartManager.f0() == null || this.mParent.f0().isLandTakePicToVideo()) {
                    return;
                }
                EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
                if (editSource instanceof EditLocalVideoSource) {
                    k0(editSource, ((EditLocalVideoSource) editSource).f204044e.rotation);
                    return;
                }
                return;
            }
        }
        if (this.mParent.C.s()) {
            EditVideoParams editVideoParams = this.mParent.C;
            if (editVideoParams.f204055d == 2) {
                EditVideoParams.EditSource editSource2 = editVideoParams.f204059i;
                if (editSource2 instanceof EditTakeVideoSource) {
                    k0(editSource2, ((EditTakeVideoSource) editSource2).f204052e.rotation);
                }
            }
        }
    }

    private void n0() {
        if (R <= 0 || Q <= 0) {
            Q = ScreenUtil.SCREEN_WIDTH;
            R = ScreenUtil.getRealHeight(getContext());
            if (DeviceInfoMonitor.getModel().equals("Lenovo L78011")) {
                R -= LiuHaiUtils.getStatusBarHeight(getContext());
            }
        }
    }

    private void r0(String str) {
        File file = new File(str);
        if (file.isFile()) {
            hd0.c.t("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + file.delete());
        }
        if (file.exists()) {
            return;
        }
        hd0.c.t("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + file.mkdirs());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public boolean B() {
        return this.mParent.l0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public void C() {
        if (this.F) {
            V().v1();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public Bitmap L(int i3, boolean z16) {
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout == null) {
            return null;
        }
        return doodleLayout.Y(i3, z16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public boolean O(int i3) {
        DoodleLayout doodleLayout = this.f67755e;
        return doodleLayout == null || doodleLayout.Y0(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void P() {
        if (this.I) {
            this.I = false;
        } else {
            this.mParent.t(0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.q
    public Bitmap S() {
        return this.mParent.S();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void U(byte[] bArr) {
        if (this.mParent.C.r()) {
            return;
        }
        this.f67758i = bArr;
        VideoSourceHelper.nativeSetMosaic(16, bArr);
        x xVar = (x) getEditExport(x.class);
        if (xVar != null) {
            xVar.u(16, bArr);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public DoodleLayout V() {
        s0();
        return this.f67755e;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public boolean W() {
        if (System.currentTimeMillis() < this.mAnimationEndTime || !EditVideoPartManager.v(this.f67759m, 1) || !TextUtils.isEmpty(V().b0(this.mParent.N()))) {
            return false;
        }
        EditVideoPartManager editVideoPartManager = this.mParent;
        if (editVideoPartManager.f67780d == 12) {
            editVideoPartManager.t(0);
        }
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public void Z(int i3, int i16, boolean z16) {
        Bundle bundle;
        V().L(i3, i16, z16);
        if (z16 || (bundle = this.mParent.Y) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(FaceLayer.f67956d0);
        if (bundle2 != null) {
            this.f67755e.l0().u(bundle2);
        }
        this.f67755e.d0().u(this.mParent.Y.getBundle("DynamicFaceLayer"));
        if (this.f67755e.C0() != null) {
            this.f67755e.C0().u(this.mParent.Y.getBundle(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public void b(Bitmap bitmap) {
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout != null) {
            doodleLayout.E(bitmap);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void close() {
        this.mParent.n1();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void e() {
        this.mUi.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.7
            @Override // java.lang.Runnable
            public void run() {
                EditVideoDoodle editVideoDoodle = EditVideoDoodle.this;
                int i3 = editVideoDoodle.C;
                if (i3 == 2) {
                    editVideoDoodle.mParent.E0();
                } else if (i3 == 3) {
                    editVideoDoodle.mParent.D0();
                }
                EditVideoDoodle.this.C = 1;
            }
        }, 200L);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void f(int i3, Object obj) {
        hd0.c.a("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + i3);
        if (this.f67755e == null || this.H) {
            return;
        }
        if (i3 != 0) {
            switch (i3) {
                case 2:
                    this.mParent.u(4, obj);
                    return;
                case 3:
                    this.mParent.u(2, obj);
                    return;
                case 4:
                    this.mParent.t(6);
                    return;
                case 5:
                case 10:
                    this.mParent.u(5, obj);
                    return;
                case 6:
                case 11:
                    this.mParent.t(5);
                    return;
                case 7:
                    break;
                case 8:
                    this.mParent.u(23, obj);
                    return;
                case 9:
                    this.mParent.u(25, obj);
                    return;
                case 12:
                    this.mParent.t(26);
                    return;
                default:
                    return;
            }
        }
        this.mParent.t(0);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void g(Bitmap bitmap, boolean z16) {
        x xVar = (x) getEditExport(x.class);
        if (xVar != null) {
            xVar.d(bitmap, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        int i3 = message.what;
        if (i3 == 11) {
            this.mAnimationEndTime = ((Long) message.obj).longValue();
            return true;
        }
        if (i3 != 13) {
            return super.handleEditVideoMessage(message);
        }
        Long[] lArr = (Long[]) message.obj;
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout != null) {
            doodleLayout.setTimeStamp(lArr[0].longValue(), false);
        }
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public boolean isEmpty() {
        DoodleLayout doodleLayout = this.f67755e;
        return doodleLayout == null || doodleLayout.X0();
    }

    public int o0(int i3) {
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout == null) {
            return 0;
        }
        return doodleLayout.Z(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        ProviderViewEditContainer providerViewEditContainer = this.f67757h;
        if (providerViewEditContainer != null && providerViewEditContainer.e()) {
            return true;
        }
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout != null && doodleLayout.b1()) {
            this.f67755e.h1(7, null);
            this.f67755e.x1(false);
            return true;
        }
        DoodleLayout doodleLayout2 = this.f67755e;
        if (doodleLayout2 != null && doodleLayout2.getVisibility() == 0) {
            int W = this.f67755e.W();
            if (W != 10) {
                if (W != 11) {
                    switch (W) {
                        case 1:
                        case 2:
                        case 3:
                            this.mParent.t(0);
                            return true;
                    }
                }
                this.f67755e.U();
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        r0(N);
        this.f67754d = (ViewStub) findViewSure(R.id.f163744rs1);
        QQStoryContext.h();
        PtvTemplateManager.j().m(QQStoryContext.a(), this.M);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.3
            @Override // java.lang.Runnable
            public void run() {
                ((wr.a) fr.f.c(14)).r(true);
            }
        }, 64, null, true);
        publishEditExport(com.tencent.aelight.camera.aioeditor.takevideo.d.class, this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        super.onPause();
        AbstractGifImage.pauseAll();
        ApngImage.pauseByTag(13);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        if (this.f67755e.f68161k0.s()) {
            AbstractGifImage.resumeAll();
            ApngImage.playByTag(13);
        } else {
            AbstractGifImage.pauseAll();
            ApngImage.pauseByTag(13);
        }
    }

    public int p0() {
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout == null) {
            return 0;
        }
        return doodleLayout.D0();
    }

    public JobSegment<fs.b, fs.b> q0(int i3) {
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if (!(editSource instanceof EditTakeVideoSource) && !(editSource instanceof EditLocalVideoSource)) {
            return (JobSegment) xc0.c.a(fs.c.class, this, (com.tencent.aelight.camera.aioeditor.takevideo.e) getEditExport(com.tencent.aelight.camera.aioeditor.takevideo.e.class), Integer.valueOf(i3));
        }
        return (JobSegment) xc0.c.a(fs.k.class, this, (com.tencent.aelight.camera.aioeditor.takevideo.e) getEditExport(com.tencent.aelight.camera.aioeditor.takevideo.e.class), Integer.valueOf(i3));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.d
    public Bitmap r() {
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout == null) {
            return null;
        }
        return doodleLayout.X();
    }

    public void s0() {
        ProviderViewEditContainer providerViewEditContainer;
        if (this.f67755e == null) {
            hd0.c.a("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
            if (this.f67754d.getParent() instanceof ViewGroup) {
                this.f67755e = (DoodleLayout) this.f67754d.inflate();
            } else {
                this.f67755e = (DoodleLayout) findViewSure(R.id.f163743rs0);
            }
            this.f67756f = (DoodleView) this.f67755e.findViewById(R.id.f165009bo4);
            if (this.mParent.C.D == js.a.f410906f.b()) {
                this.f67755e.f68152e0 = true;
            }
            this.f67755e.getViewTreeObserver().addOnGlobalLayoutListener(this.J);
            if (!EditVideoPartManager.v(this.f67759m, 1)) {
                this.f67755e.P();
            }
            this.F = true;
            m0();
            this.f67755e.T0();
            this.f67755e.setupPersonality();
            this.f67755e.setDoodleBitmapMaxSize(720, 1280);
            this.f67755e.setMosaicSize(16);
            this.f67755e.setMosaicStandardSize(this.mParent.C.f204059i.getWidth(), this.mParent.C.f204059i.getHeight());
            this.f67755e.setDoodleEventListener(this);
            this.f67755e.setDoodleBtnOperationHelper(this);
            this.f67755e.setEditVideoParams(this.mParent.C);
            this.f67755e.setEditVideoDoodle(this);
            this.f67755e.D();
            this.f67755e.J(B());
            Bundle bundle = this.mParent.Y;
            if (bundle != null) {
                String str = FaceLayer.f67956d0;
                if (bundle.getBundle(str) != null) {
                    this.mParent.Y.getBundle(str).putBoolean("edit_type_photo", this.mParent.l0());
                }
                this.f67755e.l0().u(this.mParent.Y.getBundle(str));
                this.f67755e.d0().u(this.mParent.Y.getBundle("DynamicFaceLayer"));
                if (this.f67755e.C0() != null) {
                    Bundle bundle2 = this.mParent.Y;
                    String str2 = com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0;
                    if (bundle2.getBundle(str2) != null) {
                        this.mParent.Y.getBundle(str2).putBoolean("edit_type_photo", this.mParent.l0());
                    }
                    this.f67755e.C0().u(this.mParent.Y.getBundle(str2));
                }
            }
            com.tencent.aelight.camera.aioeditor.capture.util.b.c().a(this.mParent.M(), this.f67755e);
            DoodleEditView doodleEditView = this.f67755e.f68172u0;
            if (this.f67757h == null) {
                EditVideoPartManager editVideoPartManager = this.mParent;
                ProviderViewEditContainer providerViewEditContainer2 = editVideoPartManager.H.N;
                this.f67757h = providerViewEditContainer2;
                if (providerViewEditContainer2 != null) {
                    providerViewEditContainer2.setLiuHaiParentView(editVideoPartManager.U);
                }
                if (doodleEditView != null && (providerViewEditContainer = this.f67757h) != null) {
                    EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
                    if (editSource instanceof EditLocalVideoSource) {
                        int i3 = ((EditLocalVideoSource) editSource).f204045f;
                    }
                    providerViewEditContainer.setStickerListener(doodleEditView.K());
                    doodleEditView.setDoodleEditViewListener(new b());
                }
                findViewSure(R.id.rsm).setOnTouchListener(new c());
            }
        }
    }

    public void t0(RectF rectF) {
        DoodleView doodleView = this.f67756f;
        if (doodleView != null) {
            doodleView.setContentBounds(rectF);
        }
    }

    public void u0(Matrix matrix) {
        DoodleView doodleView = this.f67756f;
        if (doodleView != null) {
            doodleView.setExtraTransform(matrix);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class f extends com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.d {

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<hr.a> f67765b = new ConcurrentLinkedQueue<>();

        /* renamed from: c, reason: collision with root package name */
        private final List<hr.a> f67766c = new ArrayList();

        public hr.a e(String str) {
            if (this.f67765b.isEmpty()) {
                g(((PasterDataManager) fr.f.c(4)).n());
            }
            Iterator<hr.a> it = this.f67765b.iterator();
            while (it.hasNext()) {
                hr.a next = it.next();
                if (next != null && TextUtils.equals(str, next.f405988a)) {
                    return next;
                }
            }
            return null;
        }

        public void f(hr.a aVar) {
            hd0.c.a("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + aVar);
            int indexOf = this.f67766c.indexOf(aVar);
            if (indexOf >= 0) {
                this.f67766c.set(indexOf, aVar);
                b(indexOf);
            }
        }

        public void g(Collection<hr.a> collection) {
            hd0.c.a("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + collection.size());
            synchronized (this) {
                this.f67765b.clear();
                this.f67766c.clear();
                for (hr.a aVar : collection) {
                    if (aVar != null) {
                        this.f67765b.add(aVar);
                        if (aVar.f405999l == 0) {
                            this.f67766c.add(aVar);
                        }
                    }
                }
            }
            a();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.c
        public int getCount() {
            return this.f67766c.size();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.c
        public hr.a getItem(int i3) {
            if (i3 < 0 || i3 >= this.f67766c.size()) {
                return null;
            }
            return this.f67766c.get(i3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, int i16, Object obj) {
        this.I = false;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    if (i3 == 6 || i3 == i16) {
                        return;
                    }
                    s0();
                    v0(0);
                    return;
                }
                if (i16 == 3) {
                    if (i3 != 6) {
                        s0();
                        this.f67755e.k1();
                        v0(0);
                    }
                    this.f67755e.x1(true);
                    return;
                }
                if (i16 == 4) {
                    if (i3 != 5) {
                        s0();
                        this.f67755e.m1();
                        v0(0);
                        return;
                    }
                    return;
                }
                if (i16 == 7) {
                    v0(8);
                    return;
                }
                if (i16 == 8) {
                    return;
                }
                if (i16 != 17 && i16 != 18 && i16 != 21) {
                    if (i16 == 25) {
                        if (i3 != 5) {
                            s0();
                            this.f67755e.p1();
                            v0(0);
                            return;
                        }
                        return;
                    }
                    switch (i16) {
                        case 12:
                        case 13:
                        case 14:
                            break;
                        default:
                            v0(0);
                            return;
                    }
                }
            }
            v0(0);
            this.f67755e.z1();
            this.f67755e.x1(true);
            return;
        }
        v0(0);
        this.f67755e.z1();
        this.f67755e.r1(false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        this.H = true;
        this.E.removeCallbacks(this.K);
        com.tencent.aelight.camera.aioeditor.capture.util.b.c().d(this.mParent.M());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void v(e.a aVar) {
        String str;
        String[] strArr = new String[4];
        if (this.mParent.l0()) {
            str = "2";
        } else {
            str = "1";
        }
        strArr[0] = str;
        strArr[1] = "";
        strArr[2] = "0";
        strArr[3] = "";
        id0.a.n("video_edit", "add_place", 0, 0, strArr);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void i(int i3, int i16) {
        if (i3 != 1) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.G > 4000) {
            this.E.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.9
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(EditVideoDoodle.this.getContext(), HardCodeUtil.qqStr(R.string.m2s), 0).show();
                }
            });
            this.G = elapsedRealtime;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        super.editVideoPrePublish(i3, bVar);
        DoodleLayout doodleLayout = this.f67755e;
        if (doodleLayout == null) {
            hd0.c.t("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
            return;
        }
        if (doodleLayout != null) {
            doodleLayout.f68172u0.H();
        }
        bVar.f400387d.videoDoodleDescription = V().b0(i3);
        this.mParent.f0().setWordId(V().c0());
        this.mParent.f0().setStickerId(V().a0());
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setEditStickerIds(V().y0());
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setEditTextIds(V().B0());
        AEBaseReportParam.U().b1(V().o0());
        AEBaseReportParam.U().f1(V().s0());
        bVar.f400387d.mMosaicMask = this.f67755e.u0(i3);
        bVar.f400387d.mMosaicSize = 16;
        if (V().F0(i3).size() > 0) {
            bVar.f400387d.videoLocationDescription = ((PasterDataManager) fr.f.c(4)).r();
        }
        if (this.mParent.C.q()) {
            EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
            if (editSource instanceof EditLocalVideoSource) {
                PublishVideoEntry publishVideoEntry = bVar.f400387d;
                publishVideoEntry.videoLongitude = ((EditLocalVideoSource) editSource).f204044e.longitude;
                publishVideoEntry.videoLatitude = ((EditLocalVideoSource) editSource).f204044e.latitude;
            } else if (editSource instanceof EditLocalPhotoSource) {
                PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
                publishVideoEntry2.videoLongitude = ((EditLocalPhotoSource) editSource).f204042e.longitude;
                publishVideoEntry2.videoLatitude = ((EditLocalPhotoSource) editSource).f204042e.latitude;
            }
        }
        if (V().G0(i3)) {
            id0.b.i("0X80076C0");
        }
        if (V().H0(i3)) {
            id0.b.i("0X80076C4");
        }
        EditVideoParams.EditSource editSource2 = this.mParent.C.f204059i;
        boolean z16 = (editSource2 instanceof EditTakePhotoSource) || (editSource2 instanceof EditLocalPhotoSource);
        int[] q06 = V().q0(i3);
        if (q06 != null && q06.length == 2) {
            if (q06[0] > 0) {
                EditVideoPartManager editVideoPartManager = this.mParent;
                int b06 = editVideoPartManager.b0();
                String[] strArr = new String[3];
                strArr[0] = "1";
                strArr[1] = "";
                if (this.mParent.l0()) {
                    str4 = "2";
                } else {
                    str4 = "1";
                }
                strArr[2] = str4;
                editVideoPartManager.X0("pub_graffiti", b06, 0, strArr);
                id0.b.k("0X80076E0", id0.b.f407535d);
                id0.b.h("0X80075EA", id0.b.f407534c);
                bVar.f400398o.reservesArray.add("1");
                bVar.f400402s.hasGraffiti = true;
            } else if (z16 && fs.g.a(0)) {
                id0.b.h("0X80075EA", id0.b.f407534c);
            }
            if (q06[1] > 0) {
                EditVideoPartManager editVideoPartManager2 = this.mParent;
                int b07 = editVideoPartManager2.b0();
                String[] strArr2 = new String[3];
                strArr2[0] = "1";
                strArr2[1] = "";
                if (this.mParent.l0()) {
                    str3 = "2";
                } else {
                    str3 = "1";
                }
                strArr2[2] = str3;
                editVideoPartManager2.X0("pub_mosaics", b07, 0, strArr2);
                id0.b.i("0X80076E1");
                id0.b.f("0X80075EB");
                bVar.f400390g = true;
                if (q06[0] == 0) {
                    bVar.f400398o.reservesArray.add("1");
                }
            } else if (z16 && fs.g.a(1)) {
                id0.b.f("0X80075EB");
            }
        }
        int[] k06 = V().k0(i3);
        if (k06 == null || k06.length != 2) {
            str = "2";
            str2 = "";
        } else {
            Map<String, List<String>> E0 = V().E0(i3);
            List<FaceLayer.b> F0 = V().F0(i3);
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : E0.entrySet()) {
                List<String> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    String key = entry.getKey();
                    for (String str5 : value) {
                        sb5.append(key);
                        sb5.append(':');
                        sb5.append(str5);
                        sb5.append(',');
                    }
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            hd0.c.b("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", sb5);
            StringBuilder sb6 = new StringBuilder();
            if (F0.size() > 0) {
                Iterator<FaceLayer.b> it = F0.iterator();
                while (it.hasNext()) {
                    sb6.append(it.next().A);
                    sb6.append(',');
                }
                sb6.deleteCharAt(sb6.length() - 1);
            }
            hd0.c.b("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", sb6);
            if (k06[0] <= 0) {
                str = "2";
                str2 = "";
                if (z16 && fs.g.a(2)) {
                    id0.b.h("0X80075ED", id0.b.f407534c);
                }
            } else {
                EditVideoPartManager editVideoPartManager3 = this.mParent;
                int b08 = editVideoPartManager3.b0();
                str = "2";
                str2 = "";
                String[] strArr3 = new String[3];
                strArr3[0] = String.valueOf(k06[0]);
                strArr3[1] = sb5.toString();
                strArr3[2] = this.mParent.l0() ? str : "1";
                editVideoPartManager3.X0("pub_face", b08, 0, strArr3);
                id0.b.k("0X80076E3", id0.b.f407535d);
                id0.b.h("0X80075ED", id0.b.f407534c);
                bVar.f400398o.reservesArray.add("4");
                bVar.f400398o.reserves6 = sb5.toString();
            }
            if (k06[1] > 0) {
                EditVideoPartManager editVideoPartManager4 = this.mParent;
                editVideoPartManager4.X0("pub_poi", editVideoPartManager4.b0(), 0, String.valueOf(k06[1]), sb6.toString());
                id0.b.i("0X80076E4");
                id0.b.f("0X80075EE");
                if (k06[0] > 0) {
                    bVar.f400398o.reserves6 = bVar.f400398o.reserves6 + "," + sb6.toString();
                } else {
                    bVar.f400398o.reservesArray.add("4");
                    bVar.f400398o.reserves6 = sb6.toString();
                }
            } else if (z16 && fs.g.a(3)) {
                id0.b.f("0X80075EE");
            }
        }
        String b09 = V().b0(i3);
        if (!TextUtils.isEmpty(b09)) {
            EditVideoPartManager editVideoPartManager5 = this.mParent;
            int b010 = editVideoPartManager5.b0();
            String[] strArr4 = new String[3];
            strArr4[0] = "1";
            strArr4[1] = b09;
            strArr4[2] = this.mParent.l0() ? str : "1";
            editVideoPartManager5.X0("pub_text", b010, 0, strArr4);
            id0.b.k("0X80076E2", id0.b.f407535d);
            id0.b.h("0X80075EC", id0.b.f407534c);
            bVar.f400398o.reservesArray.add("3");
            bVar.f400402s.hasText = true;
        } else if (z16 && fs.g.a(4)) {
            id0.b.h("0X80075EC", id0.b.f407534c);
        }
        List<String> w06 = V().w0(i3);
        if (w06 != null && w06.size() > 0) {
            String str6 = str2;
            for (int i16 = 0; i16 < w06.size(); i16++) {
                str6 = str6 + w06.get(i16);
                if (i16 != w06.size() - 1) {
                    str6 = str6 + ",";
                }
            }
            EditVideoPartManager editVideoPartManager6 = this.mParent;
            editVideoPartManager6.X0("person_gra", editVideoPartManager6.b0(), 0, str6);
        }
        ShortVideoUtils.setRecentPOI(fr.b.a().getCurrentAccountUin(), hr.d.f406010u ? bVar.f400387d.videoLocationDescription : str2);
        if ((V().l0() == null || V().l0().K == null || V().l0().K.size() <= 0) && (V().d0() == null || V().d0().K == null || V().d0().K.size() <= 0)) {
            return;
        }
        bVar.f400402s.hasFace = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v0(int i3) {
        DoodleLayout doodleLayout;
        if (i3 != 0) {
            if ((i3 != 4 && i3 != 8) || (doodleLayout = this.f67755e) == null || doodleLayout.getVisibility() == i3) {
                return;
            }
            this.f67755e.setVisibility(i3);
            this.f67755e.setDoodleGLViewVisibility(i3);
            return;
        }
        s0();
        if (this.f67755e.getVisibility() != i3) {
            this.f67755e.setVisibility(i3);
            this.f67755e.setDoodleGLViewVisibility(i3);
        }
    }
}
