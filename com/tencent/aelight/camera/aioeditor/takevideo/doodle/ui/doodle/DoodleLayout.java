package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion;
import com.tencent.aelight.camera.aioeditor.takevideo.ad;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import hr.d;
import hr.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.MobileQQ;
import tr.a;
import ur.a;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleLayout extends RelativeLayout implements View.OnClickListener {
    public static boolean Q0;
    public static final int R0 = DoodlePanel.F[2];
    public static final int S0 = UIUtils.b(BaseApplication.getContext(), 3.0f);
    public static final int T0 = UIUtils.b(BaseApplication.getContext(), 32.0f);
    public static final int U0;
    protected static final float V0;
    private RuntimeException A0;
    private boolean B0;
    public SparseArray<u> C;
    private boolean C0;
    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b D;
    public r D0;
    private gr.a E;
    public s E0;
    private int F;
    public EditTextDialog F0;
    private int G;
    public boolean G0;
    private int H;
    public int H0;
    private int I;
    public FaceLayer.b I0;
    private int J;
    protected q J0;
    private boolean K;
    DynamicTextBuilder K0;
    private long L;
    private Comparator<tr.a> L0;
    protected com.tencent.aelight.camera.aioeditor.capture.data.k M;
    private boolean M0;
    private x N;
    public ab N0;
    public long O0;
    private aa P;
    public Rect P0;
    private int Q;
    private int R;
    private boolean S;
    private EditVideoDoodle T;
    private boolean U;
    private long V;
    private long W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f68146a0;

    /* renamed from: b0, reason: collision with root package name */
    private StoryGuideLineView f68147b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f68148c0;

    /* renamed from: d, reason: collision with root package name */
    public int f68149d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f68150d0;

    /* renamed from: e, reason: collision with root package name */
    public int f68151e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f68152e0;

    /* renamed from: f, reason: collision with root package name */
    public int f68153f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f68154f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q f68155g0;

    /* renamed from: h, reason: collision with root package name */
    public SparseBooleanArray f68156h;

    /* renamed from: h0, reason: collision with root package name */
    private RectF f68157h0;

    /* renamed from: i, reason: collision with root package name */
    public SparseBooleanArray f68158i;

    /* renamed from: i0, reason: collision with root package name */
    private long f68159i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f68160j0;

    /* renamed from: k0, reason: collision with root package name */
    public EditVideoParams f68161k0;

    /* renamed from: l0, reason: collision with root package name */
    public RelativeLayout f68162l0;

    /* renamed from: m, reason: collision with root package name */
    public SparseArray<ur.a> f68163m;

    /* renamed from: m0, reason: collision with root package name */
    public ImageView f68164m0;

    /* renamed from: n0, reason: collision with root package name */
    public HorizontalSelectColorLayout f68165n0;

    /* renamed from: o0, reason: collision with root package name */
    protected DoodlePanel f68166o0;

    /* renamed from: p0, reason: collision with root package name */
    protected DoodlePanel f68167p0;

    /* renamed from: q0, reason: collision with root package name */
    protected DoodleShapePanel f68168q0;

    /* renamed from: r0, reason: collision with root package name */
    public FrameLayout f68169r0;

    /* renamed from: s0, reason: collision with root package name */
    public DoodleTextureView f68170s0;

    /* renamed from: t0, reason: collision with root package name */
    public DoodleView f68171t0;

    /* renamed from: u0, reason: collision with root package name */
    public DoodleEditView f68172u0;

    /* renamed from: v0, reason: collision with root package name */
    public DoodleView f68173v0;

    /* renamed from: w0, reason: collision with root package name */
    private Bitmap f68174w0;

    /* renamed from: x0, reason: collision with root package name */
    private AtomicBoolean f68175x0;

    /* renamed from: y0, reason: collision with root package name */
    private final Lock f68176y0;

    /* renamed from: z0, reason: collision with root package name */
    private final Condition f68177z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements c.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c.a
        public void a(byte[] bArr, int i3, int i16) {
            if (DoodleLayout.this.D0 != null) {
                hd0.c.a("DoodleLayout", "notify outside onDrawMosaic. width:" + i3 + ",height:" + i16);
                DoodleLayout.this.D0.U(bArr);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c.a
        public void b(Bitmap bitmap, boolean z16) {
            r rVar = DoodleLayout.this.D0;
            if (rVar != null) {
                rVar.g(bitmap, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private interface aa {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DoodleLayout.this.h1(8, Boolean.TRUE);
            DoodleLayout doodleLayout = DoodleLayout.this;
            int i3 = doodleLayout.H0;
            if (i3 == 9 || i3 == 11) {
                return;
            }
            doodleLayout.g1(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class h {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68201a;

        static {
            int[] iArr = new int[DoodlePanel.PenMode.values().length];
            f68201a = iArr;
            try {
                iArr[DoodlePanel.PenMode.ERASER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68201a[DoodlePanel.PenMode.FREE_DRAW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68201a[DoodlePanel.PenMode.MOSAIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68201a[DoodlePanel.PenMode.RECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68201a[DoodlePanel.PenMode.OVAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68201a[DoodlePanel.PenMode.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f68201a[DoodlePanel.PenMode.ARROW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f68201a[DoodlePanel.PenMode.SEQUENCE_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class i implements Comparator<tr.a> {
        i() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(tr.a aVar, tr.a aVar2) {
            return aVar2.i() - aVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements HorizontalSelectColorLayout.e {
        j() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.e
        public void b() {
            DoodleLayout.this.R1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class k implements HorizontalSelectColorLayout.d {
        k() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.d
        public void a(qs.d dVar) {
            DoodleLayout.this.B1(dVar.f429429a, dVar.f429430b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class l implements DoodlePanel.c {
        l() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void a(int i3) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = DoodleLayout.this.r0();
            if (r06 != null) {
                DoodleLayout.this.T1(i3);
                DoodleLayout.this.V0();
                if (r06.N()) {
                    ms.a.f("DoodleLayout", "onSelectColor when in mosaic mode, change to the before mode: ");
                    DoodleLayout.this.S(DoodlePanel.PenMode.FREE_DRAW);
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void b() {
            DoodleLayout.this.R1();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void c(float f16) {
            if (DoodleLayout.this.r0() != null) {
                DoodleLayout.this.V1(f16);
                DoodleLayout.this.V0();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void d(DoodlePanel.PenMode penMode) {
            DoodleLayout.this.S(penMode);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void onFinish() {
            DoodleLayout.this.g1(0);
            if (DoodleLayout.this.f68171t0.B()) {
                return;
            }
            DoodleLayout.this.f68171t0.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class n implements DoodleShapePanel.d {
        n() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.d
        public void a(int i3) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = DoodleLayout.this.x0();
            if (x06 != null) {
                x06.I().B(i3);
                DoodleLayout.this.V0();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.d
        public void b() {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = DoodleLayout.this.x0();
            if (x06 != null) {
                x06.I().k();
                DoodleLayout.this.V0();
                DoodleLayout.this.J0();
                DoodleLayout doodleLayout = DoodleLayout.this;
                if (doodleLayout.H0 == 9) {
                    doodleLayout.L1();
                }
                DoodleLayout doodleLayout2 = DoodleLayout.this;
                doodleLayout2.g1(doodleLayout2.H0);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.d
        public void c(float f16) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = DoodleLayout.this.x0();
            if (x06 != null) {
                x06.I().C(f16);
                DoodleLayout.this.V0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class o implements d.a {
        o() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d.a
        public void e() {
            r rVar = DoodleLayout.this.D0;
            if (rVar != null) {
                rVar.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class p implements d.a {
        p() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d.a
        public void e() {
            r rVar = DoodleLayout.this.D0;
            if (rVar != null) {
                rVar.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface q {
        Bitmap S();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface r {
        boolean B();

        void P();

        void U(byte[] bArr);

        void close();

        void e();

        void f(int i3, Object obj);

        void g(Bitmap bitmap, boolean z16);

        void i(int i3, int i16);

        void v(e.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class t implements com.tencent.aelight.camera.aioeditor.capture.data.k {
        t() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void b(e.a aVar, float f16, float f17, float f18) {
            hd0.c.e("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", aVar.f406049d, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            DoodleLayout.this.F(aVar, f16, f17, f18);
            EditVideoParams editVideoParams = DoodleLayout.this.f68161k0;
            if (editVideoParams != null && editVideoParams.f204055d == 3) {
                LpReportInfo_pf00064.report(615, 6);
            }
            id0.b.f("0X80075E3");
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void c() {
            DoodleLayout.this.l0().d0();
            DoodleLayout.this.d0().d0();
            DoodleLayout.this.f68171t0.invalidate();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void f(e.a aVar, float f16, float f17, float f18, SegmentKeeper segmentKeeper) {
            hd0.c.a("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + aVar.f406049d);
            DoodleLayout.this.G(aVar, f16, f17, f18, segmentKeeper);
            EditVideoParams editVideoParams = DoodleLayout.this.f68161k0;
            if (editVideoParams != null && editVideoParams.f204055d == 3) {
                LpReportInfo_pf00064.report(615, 6);
            }
            id0.b.f("0X80075E3");
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void g(String str, String str2) {
            DoodleLayout.this.l0().g0(str, str2);
            DoodleLayout.this.d0().g0(str, str2);
            DoodleLayout.this.f68171t0.invalidate();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void d(vr.a aVar, float f16, float f17, float f18, String str, SegmentKeeper segmentKeeper) {
            hd0.c.f("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", aVar, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
            h(aVar, f16, f17, f18, str, segmentKeeper, false);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void e(vr.a aVar, float f16, float f17, float f18, String str, SegmentKeeper segmentKeeper) {
            hd0.c.f("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", aVar, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
            if (h(aVar, f16, f17, f18, str, segmentKeeper, true)) {
                DoodleLayout.P1("clk_oneface");
                id0.b.i("0X80076CA");
                id0.b.f("0X80075DF");
            }
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 8, 1);
            }
        }

        private boolean h(vr.a aVar, float f16, float f17, float f18, String str, SegmentKeeper segmentKeeper, boolean z16) {
            EditVideoParams editVideoParams;
            int i3;
            EditVideoParams editVideoParams2 = DoodleLayout.this.f68161k0;
            FaceLayer.d dVar = new FaceLayer.d(f16, (editVideoParams2 == null || ((i3 = editVideoParams2.C) == 0 && editVideoParams2.f204060m == 0) || i3 > editVideoParams2.f204060m) ? f17 : ScreenUtil.SCREEN_HIGHT / 2, f18, 0.0f, 0.0f, 0.0f, aVar.f443183c.getIntrinsicWidth(), aVar.f443183c.getIntrinsicHeight());
            EditVideoParams editVideoParams3 = DoodleLayout.this.f68161k0;
            if (editVideoParams3 != null && editVideoParams3.f204055d == 3) {
                LpReportInfo_pf00064.report(615, 6);
            }
            FaceLayer l06 = DoodleLayout.this.l0();
            if (aVar.f443184d == 1 && ((editVideoParams = DoodleLayout.this.f68161k0) == null || editVideoParams.s())) {
                l06 = DoodleLayout.this.d0();
            }
            boolean J = l06.J(aVar.f443181a, aVar.f443182b, aVar.f443183c, dVar, str, false, aVar.f443184d, DoodleLayout.this.n0(), segmentKeeper);
            DoodleLayout.f1(DoodleLayout.this.f68152e0 && J);
            return J;
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.k
        public void a(d.c cVar, String str, float f16, float f17, float f18) {
            Drawable drawable;
            FaceLayer faceLayer;
            EditVideoParams editVideoParams;
            int i3;
            if (cVar == null) {
                hd0.c.g("DoodleLayout", "the item is null.");
                return;
            }
            hd0.c.e("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", cVar.f406024c, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            DoodleLayout.this.N();
            hd0.c.a("DoodleLayout", "addLocationFaceItem:" + cVar.toString());
            boolean z16 = DoodleLayout.this.getContext() instanceof EditPicActivity;
            int i16 = 3;
            boolean z17 = false;
            if (z16) {
                cVar.f406037p = 0;
            } else {
                cVar.f406037p = 3;
            }
            ir.i c16 = hr.c.c(cVar, DoodleLayout.this.getContext(), -1L);
            if (z16) {
                drawable = c16 != null ? new BitmapDrawable(DoodleLayout.this.getContext().getResources(), c16.h()) : null;
            } else {
                drawable = c16;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "[" + drawable.getIntrinsicWidth() + "," + drawable.getIntrinsicHeight() + "]");
                }
                EditVideoParams editVideoParams2 = DoodleLayout.this.f68161k0;
                FaceLayer.d dVar = new FaceLayer.d(f16, (editVideoParams2 == null || ((i3 = editVideoParams2.C) == 0 && editVideoParams2.f204060m == 0) || i3 > editVideoParams2.f204060m) ? f17 : ScreenUtil.SCREEN_HIGHT / 2, f18, 0.0f, 0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                FaceLayer l06 = DoodleLayout.this.l0();
                if (cVar.f406037p == 3 && ((editVideoParams = DoodleLayout.this.f68161k0) == null || editVideoParams.s())) {
                    faceLayer = DoodleLayout.this.d0();
                } else {
                    faceLayer = l06;
                    i16 = 0;
                }
                boolean K = faceLayer.K(cVar.f406042u, TextUtils.isEmpty(str) ? cVar.f406024c : str, drawable, dVar, "", cVar.f406038q, cVar.f406039r, i16, c16.g(), 0, DoodleLayout.this.n0());
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "add Face result" + K);
                }
                if (DoodleLayout.this.f68152e0 && K) {
                    z17 = true;
                }
                DoodleLayout.f1(z17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class u {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g f68214a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c f68215b;

        /* renamed from: c, reason: collision with root package name */
        public final FaceLayer f68216c;

        /* renamed from: d, reason: collision with root package name */
        public final DynamicFaceLayer f68217d;

        /* renamed from: e, reason: collision with root package name */
        public final com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a f68218e;

        /* renamed from: f, reason: collision with root package name */
        public final com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b f68219f;

        /* renamed from: g, reason: collision with root package name */
        public final com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d f68220g;

        /* renamed from: h, reason: collision with root package name */
        public final ArrayList<tr.a> f68221h;

        public u(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g gVar, com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar, FaceLayer faceLayer, DynamicFaceLayer dynamicFaceLayer, com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b bVar, com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a aVar, com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d dVar) {
            ArrayList<tr.a> arrayList = new ArrayList<>();
            this.f68221h = arrayList;
            this.f68214a = gVar;
            this.f68215b = cVar;
            this.f68216c = faceLayer;
            this.f68217d = dynamicFaceLayer;
            this.f68218e = aVar;
            this.f68219f = bVar;
            this.f68220g = dVar;
            arrayList.add(faceLayer);
            arrayList.add(dynamicFaceLayer);
            arrayList.add(cVar);
            arrayList.add(gVar);
            arrayList.add(bVar);
            arrayList.add(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class v implements a.InterfaceC11305a<com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c> {

        /* renamed from: a, reason: collision with root package name */
        int f68222a;

        /* renamed from: b, reason: collision with root package name */
        int f68223b;

        /* renamed from: c, reason: collision with root package name */
        long f68224c;

        v() {
        }

        private void b() {
            DoodleLayout.this.D1(5);
            if (DoodleLayout.this.L > System.currentTimeMillis()) {
                DoodleLayout.this.h1(5, Boolean.FALSE);
            } else {
                DoodleLayout.this.h1(5, Boolean.TRUE);
                DoodleLayout.this.M1(false, true);
            }
            DoodleLayout.this.I0();
            if (QLog.isColorLevel()) {
                QLog.d("Personality", 2, "LineLayer draw move hide");
            }
        }

        private void c(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar, int i3, int i16) {
            if (cVar.L.m() > 0) {
                DoodleLayout.this.f68165n0.setUndoViewEnable(true);
                DoodleLayout.this.f68166o0.setUndoEnabled(true);
            }
            DoodleLayout doodleLayout = DoodleLayout.this;
            if (doodleLayout.H0 == 5) {
                doodleLayout.g1(2);
                DoodleLayout.this.D1(2);
                DoodleLayout.this.G1();
                DoodleLayout.this.M1(true, true);
                if (QLog.isColorLevel()) {
                    QLog.d("Personality", 2, "LineLayer draw up show");
                    return;
                }
                return;
            }
            if (Math.abs(i16 - this.f68222a) >= 3 || Math.abs(i3 - this.f68223b) >= 3) {
                return;
            }
            DoodleLayout doodleLayout2 = DoodleLayout.this;
            if (doodleLayout2.H0 == 6) {
                doodleLayout2.h1(2, Boolean.FALSE);
                DoodleLayout.this.D1(2);
                DoodleLayout.this.G1();
                DoodleLayout.this.M1(true, false);
                if (QLog.isColorLevel()) {
                    QLog.d("Personality", 2, "LineLayer tap up show");
                    return;
                }
                return;
            }
            id0.b.h("0X80080E5", id0.b.f407534c);
            if (!cVar.Q()) {
                DoodleLayout.this.D1(6);
                DoodleLayout.this.g1(6);
                DoodleLayout.this.I0();
                DoodleLayout.this.M1(false, true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Personality", 2, "LineLayer tap up hide");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
        
            if (r2 != 3) goto L35;
         */
        @Override // tr.a.InterfaceC11305a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar, MotionEvent motionEvent) {
            int i3;
            if (!DoodleLayout.this.W0()) {
                DoodleLayout.this.S1(cVar);
            }
            int round = Math.round(motionEvent.getY());
            int round2 = Math.round(motionEvent.getX());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if ((Math.abs(round2 - this.f68222a) >= 3 || Math.abs(round - this.f68223b) >= 3) && (i3 = DoodleLayout.this.H0) != 6 && i3 != 5) {
                            if (!cVar.P()) {
                                b();
                            } else {
                                DoodleLayout doodleLayout = DoodleLayout.this;
                                if (4 != doodleLayout.H0) {
                                    doodleLayout.g1(4);
                                }
                            }
                        }
                    }
                }
                if (cVar.P()) {
                    ms.a.f("DoodleLayout", "LineLayer--onLayerTouch--ACTION_UP--is passive activation");
                    DoodleLayout.this.z1();
                    DoodleLayout.this.g1(0);
                } else {
                    c(cVar, round, round2);
                }
            } else if (cVar.P()) {
                ms.a.a("DoodleLayout", "LineLayer--onLayerTouch--ACTION_DOWN--is passive activation");
            } else {
                this.f68222a = Math.round(motionEvent.getX());
                this.f68223b = Math.round(motionEvent.getY());
                this.f68224c = System.currentTimeMillis();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class w implements tr.c {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<tr.a> f68226a;

        public w(tr.a... aVarArr) {
            this.f68226a = null;
            if (aVarArr != null && aVarArr.length > 0) {
                this.f68226a = new ArrayList<>(aVarArr.length);
                for (tr.a aVar : aVarArr) {
                    if (aVar != null) {
                        this.f68226a.add(aVar);
                    }
                }
                return;
            }
            throw new IllegalArgumentException("layers should not be null or empty");
        }

        @Override // tr.c
        public void a(List<tr.a> list, DoodleView doodleView) {
            list.addAll(this.f68226a);
        }

        public tr.a b(String str) {
            int size = this.f68226a.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f68226a.get(i3).h().equals(str)) {
                    return this.f68226a.get(i3);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface x {
        void b(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class y implements a.InterfaceC11305a<com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d> {

        /* renamed from: a, reason: collision with root package name */
        int f68227a;

        /* renamed from: b, reason: collision with root package name */
        int f68228b;

        /* renamed from: c, reason: collision with root package name */
        long f68229c;

        y() {
        }

        private void b() {
            DoodleLayout.this.D1(10);
            if (DoodleLayout.this.L > System.currentTimeMillis()) {
                DoodleLayout.this.h1(10, Boolean.FALSE);
            } else {
                DoodleLayout.this.h1(10, Boolean.TRUE);
                if (DoodleLayout.this.f68167p0.getVisibility() == 0) {
                    DoodleLayout.this.N1(false, true);
                }
            }
            DoodleLayout.this.K0();
            if (QLog.isColorLevel()) {
                QLog.d("Personality", 2, "LineLayer draw move hide");
            }
        }

        private void c() {
            DoodleLayout doodleLayout = DoodleLayout.this;
            int i3 = doodleLayout.H0;
            if (i3 == 10) {
                doodleLayout.h1(9, Boolean.TRUE);
                DoodleLayout.this.D1(9);
                DoodleLayout.this.L1();
                DoodleLayout.this.N1(true, true);
                if (QLog.isColorLevel()) {
                    QLog.d("Personality", 2, "LineLayer draw up show");
                    return;
                }
                return;
            }
            if (i3 == 9) {
                doodleLayout.h1(9, Boolean.FALSE);
                DoodleLayout.this.D1(9);
                DoodleLayout.this.L1();
                if (QLog.isColorLevel()) {
                    QLog.d("Personality", 2, "LineLayer draw up show");
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        
            if (r2 != 3) goto L40;
         */
        @Override // tr.a.InterfaceC11305a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d dVar, MotionEvent motionEvent) {
            int i3;
            int round = Math.round(motionEvent.getY());
            int round2 = Math.round(motionEvent.getX());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if ((Math.abs(round2 - this.f68227a) >= 3 || Math.abs(round - this.f68228b) >= 3) && (i3 = DoodleLayout.this.H0) != 11 && i3 != 10) {
                            if (!dVar.J()) {
                                b();
                            } else {
                                DoodleLayout doodleLayout = DoodleLayout.this;
                                if (4 != doodleLayout.H0) {
                                    doodleLayout.g1(4);
                                }
                            }
                        }
                        if (DoodleLayout.this.f68168q0.getVisibility() == 0) {
                            DoodleLayout.this.J0();
                        }
                    }
                }
                if (dVar.K()) {
                    DoodleLayout.this.K1(dVar.I().s());
                    DoodleLayout doodleLayout2 = DoodleLayout.this;
                    if (doodleLayout2.H0 == 10) {
                        doodleLayout2.D1(9);
                    }
                    DoodleLayout.this.g1(12);
                } else {
                    DoodleLayout.this.J0();
                    if (dVar.J()) {
                        ms.a.f("DoodleLayout", "LineLayer--onLayerTouch--ACTION_UP--is passive activation");
                        DoodleLayout.this.z1();
                        DoodleLayout.this.g1(0);
                    } else {
                        c();
                    }
                }
            } else if (dVar.J()) {
                ms.a.a("DoodleLayout", "LineLayer--onLayerTouch--ACTION_DOWN--is passive activation");
            } else {
                this.f68227a = Math.round(motionEvent.getX());
                this.f68228b = Math.round(motionEvent.getY());
                this.f68229c = System.currentTimeMillis();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class z {
        public static boolean a(int i3) {
            if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 9 || i3 == 10 || i3 == 11) {
                return true;
            }
            return false;
        }
    }

    static {
        int b16 = UIUtils.b(BaseApplication.getContext(), 5.0f) - 7;
        U0 = b16;
        V0 = (b16 * 1.0f) / (r1 - r0);
    }

    public DoodleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68149d = -1;
        this.f68151e = -1;
        this.f68153f = 0;
        this.f68156h = new SparseBooleanArray();
        this.f68158i = new SparseBooleanArray();
        this.f68163m = new SparseArray<>();
        this.C = new SparseArray<>();
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = false;
        this.R = 0;
        this.S = false;
        this.V = 0L;
        this.W = 0L;
        this.f68146a0 = false;
        this.f68148c0 = false;
        this.f68150d0 = true;
        this.f68152e0 = false;
        this.f68154f0 = false;
        this.f68160j0 = false;
        this.f68175x0 = new AtomicBoolean(true);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f68176y0 = reentrantLock;
        this.f68177z0 = reentrantLock.newCondition();
        this.B0 = true;
        this.H0 = 0;
        this.K0 = new DynamicTextBuilder();
        this.L0 = new i();
        this.M0 = false;
        this.N0 = new ab();
        this.P0 = new Rect();
        LayoutInflater.from(super.getContext()).inflate(p0(), this);
        U0();
        M0();
        N0(this.f68153f);
        this.Q = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void A1() {
        this.f68165n0.setUndoViewEnable(false);
        this.f68166o0.setUndoEnabled(false);
        this.f68167p0.setUndoEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(boolean z16) {
        if (this.B0 && this.C0 != z16) {
            this.C0 = z16;
            if (z16) {
                hd0.c.a("DoodleLayout", "rubbish active.");
                O1();
            } else {
                hd0.c.a("DoodleLayout", "rubbish unActive.");
                y1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar, RectF rectF) {
        ms.a.f("DoodleLayout", "addShapeTipsText---");
        this.f68154f0 = true;
        this.f68155g0 = qVar;
        this.f68157h0 = rectF;
        DynamicTextItem K = C0().K(new g.b(rectF.left, rectF.top, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), null, n0());
        d1(C0().Q(), false);
        if (K != null) {
            if ((K instanceof com.tencent.aelight.camera.aioeditor.capture.text.w) && qVar != null) {
                com.tencent.aelight.camera.aioeditor.capture.text.w wVar = (com.tencent.aelight.camera.aioeditor.capture.text.w) K;
                wVar.V(qVar.E());
                wVar.U(true);
            }
            H1(K, 0, 0);
            return;
        }
        QQToast.makeText(getContext(), getContext().getString(R.string.f2q), 0).show();
    }

    public static float K(float f16) {
        return S0 + ((T0 - r0) * f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        os.a aVar = os.a.f423933a;
        if (aVar.b(AECameraConstants.KEY_FIRST_TIME_REQUEST_FINE_LOCATION, true)) {
            ((PasterDataManager) fr.f.c(4)).v(true, (Activity) getContext());
            aVar.e(AECameraConstants.KEY_FIRST_TIME_REQUEST_FINE_LOCATION, false);
        }
    }

    private void N0(int i3) {
        if (this.D == null) {
            this.D = new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b(this.f68171t0);
        }
        ur.a aVar = this.f68163m.get(i3);
        if (aVar == null) {
            hd0.c.l("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(i3));
            w z06 = z0();
            FaceLayer faceLayer = (FaceLayer) z06.b(FaceLayer.f67956d0);
            DynamicFaceLayer dynamicFaceLayer = (DynamicFaceLayer) z06.b("DynamicFaceLayer");
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c) z06.b("LineLayer");
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g gVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g) z06.b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0);
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b bVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b) z06.b("GuideLineLayer");
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d dVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d) z06.b("ShapeLayer");
            P0(cVar);
            S0(dVar);
            a.C11364a e16 = new a.C11364a().e(z06);
            int i16 = this.I;
            if (i16 == -1) {
                i16 = 480;
            }
            a.C11364a g16 = e16.g(i16);
            int i17 = this.J;
            if (i17 == -1) {
                i17 = 640;
            }
            ur.a d16 = g16.f(i17).d();
            this.f68171t0.setDoodleConfig(d16);
            this.f68171t0.setDoodleLayout(this);
            EditVideoParams editVideoParams = this.f68161k0;
            if (editVideoParams != null) {
                this.f68171t0.w(editVideoParams);
                this.f68172u0.w(this.f68161k0);
            }
            u uVar = new u(gVar, cVar, faceLayer, dynamicFaceLayer, bVar, (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a) this.f68171t0.t(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a.K), dVar);
            this.f68163m.put(i3, d16);
            this.C.put(i3, uVar);
            if (cVar != null) {
                cVar.y(new v());
                cVar.V(new a());
            }
            if (faceLayer != null) {
                faceLayer.y(this.N0);
            }
            if (dynamicFaceLayer != null) {
                dynamicFaceLayer.y(this.N0);
            }
            FaceLayer.c cVar2 = new FaceLayer.c() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.11
                @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.c
                public void a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
                    if (DoodleLayout.this.f68148c0) {
                        return;
                    }
                    DoodleLayout.this.t1(z16, z17, z18, z19, z26);
                }

                @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.c
                public void b(int i18) {
                    r rVar = DoodleLayout.this.D0;
                    if (rVar != null) {
                        rVar.i(1, i18);
                    }
                }

                @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.c
                public boolean c(FaceLayer.b bVar2) {
                    DoodleEditView doodleEditView;
                    if (!DoodleLayout.this.U) {
                        if ((DoodleLayout.this.f68148c0 && !DoodleLayout.this.f68150d0) || (doodleEditView = DoodleLayout.this.f68172u0) == null) {
                            return false;
                        }
                        doodleEditView.setVisibility(0);
                        DoodleLayout.this.e1();
                        if (bVar2.K == 3) {
                            DoodleLayout.this.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((QIMInformationPasterManager) fr.f.d().g(12)).m();
                                }
                            });
                        }
                        DoodleLayout.this.f68172u0.T.L(bVar2);
                        QLog.d("DoodleLayout", 2, "item onEdit: mPOI:" + bVar2.E);
                        DoodleLayout.this.M();
                        bVar2.f453057m = true;
                        bVar2.f453065u.lockData(DoodleLayout.this.f68172u0.N() ^ true);
                        int i18 = bVar2.K;
                        if (i18 == 1 || i18 == 3) {
                            bVar2.f67963x.setCallback(DoodleLayout.this.f68172u0);
                        }
                        DoodleLayout.this.f68172u0.requestLayout();
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DoodleLayout", 2, "onEditFaceItem mIsRecording");
                    }
                    return false;
                }
            };
            if (faceLayer != null) {
                faceLayer.k0(cVar2);
            }
            if (dynamicFaceLayer != null) {
                dynamicFaceLayer.k0(cVar2);
            }
            if (gVar != null && !this.K) {
                gVar.y(this.N0);
                gVar.g0(new ac());
            }
            this.E = (gr.a) this.f68171t0.t("PickLayer");
        } else {
            this.f68171t0.setDoodleConfig(aVar);
        }
        Q0();
        this.U = false;
    }

    private void O0(DynamicTextItem dynamicTextItem, int i3, int i16, boolean z16) {
        this.F0.o0((((Activity) getContext()).getWindow().getAttributes().flags & 1024) == 1024);
        EditTextDialog editTextDialog = this.F0;
        editTextDialog.f68095i0 = i16;
        EditVideoParams editVideoParams = this.f68161k0;
        editTextDialog.q0(editVideoParams != null && editVideoParams.r());
        this.F0.A0(V());
        this.F0.y0(z16);
        this.F0.setContentView(i0());
        this.F0.r0(this.E0);
        this.F0.p0(this.K0);
        this.F0.setOnDismissListener(new c());
        if (i16 == 0) {
            if (dynamicTextItem instanceof com.tencent.aelight.camera.aioeditor.capture.text.w) {
                com.tencent.aelight.camera.aioeditor.capture.text.w wVar = (com.tencent.aelight.camera.aioeditor.capture.text.w) dynamicTextItem;
                if (!wVar.T()) {
                    wVar.V(A0());
                    this.F0.x0(A0());
                } else {
                    this.F0.x0(wVar.R());
                    wVar.U(false);
                }
            }
            this.F0.z0(dynamicTextItem, i3);
        } else if (dynamicTextItem instanceof com.tencent.aelight.camera.aioeditor.capture.text.w) {
            this.F0.x0(((com.tencent.aelight.camera.aioeditor.capture.text.w) dynamicTextItem).R());
        }
        this.F0.show();
    }

    private void O1() {
        ((TransitionDrawable) this.f68162l0.getBackground()).startTransition(240);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(240L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f68162l0.startAnimation(scaleAnimation);
    }

    private void Q0() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null || !this.S) {
            return;
        }
        r06.M(this.f68170s0);
        r06.L.K(new o());
        if (this.S) {
            ((PersonalityOperator) r06.L.l(102)).o(false);
            r06.L.K(new p());
            r06.a0();
        }
    }

    public static void Q1(String str, int i3, int i16, String... strArr) {
        id0.a.n("video_edit", str, i3, i16, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar) {
        qs.d d16 = this.f68165n0.d();
        if (d16 != null) {
            int i3 = d16.f429429a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    }
                    cVar.X(getContext() instanceof QQStoryBaseActivity ? ((QQStoryBaseActivity) getContext()).mApp : null, 2, d16.f429430b);
                    return;
                } else {
                    if (cVar.N()) {
                        return;
                    }
                    cVar.Y();
                    return;
                }
            }
            int i16 = d16.f429430b;
            if (i16 != qs.d.b(W0())) {
                this.f68158i.put(this.f68153f, true);
            } else {
                this.f68158i.put(this.f68153f, false);
            }
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p pVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p) cVar.I(101);
            if (pVar != null) {
                pVar.f(i16);
            }
            if (cVar.O()) {
                return;
            }
            cVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0;
        EditVideoParams editVideoParams;
        if (this.f68172u0.T.G()) {
            c.a F = this.f68172u0.T.F();
            F.f453057m = false;
            if (F instanceof FaceLayer.b) {
                FaceLayer l06 = l0();
                FaceLayer.b bVar = (FaceLayer.b) F;
                int i3 = bVar.K;
                if ((i3 == 1 || i3 == 3) && ((editVideoParams = this.f68161k0) == null || editVideoParams.s())) {
                    l06 = d0();
                    bVar.f67963x.setCallback(this.f68171t0);
                }
                if (l06 != null) {
                    l06.K.add(bVar);
                    return;
                }
                return;
            }
            if (!(F instanceof g.c) || (C0 = C0()) == null) {
                return;
            }
            C0.X.add((g.c) F);
        }
    }

    private boolean i1(boolean z16) {
        N();
        hd0.c.a("DoodleLayout", "onBackPressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o());
        int i3 = this.H0;
        if (i3 == 0 || (i3 == 2 && !z16)) {
            return false;
        }
        z1();
        g1(0);
        if (this.f68171t0.B()) {
            return true;
        }
        hd0.c.a("DoodleLayout", "onBackPressed, resetDoodleView.");
        this.f68171t0.G();
        return true;
    }

    private void y1() {
        ((TransitionDrawable) this.f68162l0.getBackground()).reverseTransition(240);
        this.f68162l0.clearAnimation();
    }

    protected int A0() {
        return com.tencent.aelight.camera.aioeditor.takevideo.a.a(W0());
    }

    public String B0() {
        ArrayList<g.c> arrayList;
        List<String> e16;
        try {
            StringBuilder sb5 = new StringBuilder();
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0 = C0();
            if (C0 != null && (arrayList = C0.X) != null && !arrayList.isEmpty()) {
                Iterator<g.c> it = C0.X.iterator();
                while (it.hasNext()) {
                    DynamicTextItem dynamicTextItem = it.next().f68001z;
                    if (dynamicTextItem != null && (e16 = DynamicTextBuilder.e(dynamicTextItem.v())) != null && e16.size() > 0) {
                        String str = e16.get(0);
                        if (!TextUtils.isEmpty(str)) {
                            sb5.append(str);
                            sb5.append("|");
                        }
                    }
                }
            }
            if (sb5.length() <= 0) {
                return "";
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void B1(int i3, int i16) {
        this.f68149d = i3;
        this.f68151e = i16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeInt("Line_LastType", i3);
        from.encodeInt("Line_LastSubType", i16);
    }

    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0() {
        u uVar = this.C.get(this.f68153f);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(this.f68153f));
            return null;
        }
        return uVar.f68214a;
    }

    public void D() {
        EditVideoDoodle editVideoDoodle = this.T;
        if (editVideoDoodle == null || editVideoDoodle.mParent.U == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f68165n0.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.f68165n0.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D1(int i3) {
        ms.a.a("DoodleLayout", "setState---buttonState=" + i3);
        if (!z.a(i3)) {
            hd0.c.g("DoodleLayout", "illegal state.");
        } else {
            this.H0 = i3;
        }
    }

    public Map<String, List<String>> E0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar != null) {
            Map<String, List<String>> map = uVar.f68216c.f67957a0;
            hd0.c.a("DoodleLayout", "Using face map:" + map.toString());
            return Collections.unmodifiableMap(map);
        }
        return Collections.emptyMap();
    }

    protected void E1(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setVisibility(4);
            }
        }
    }

    public List<FaceLayer.b> F0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(uVar.f68216c.f67958b0);
            arrayList.addAll(uVar.f68217d.f67958b0);
            hd0.c.a("DoodleLayout", "Using poi list:" + arrayList.toString());
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F1(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public boolean G0(int i3) {
        return this.f68158i.get(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G1() {
        View view;
        if (W0()) {
            view = this.f68166o0;
        } else {
            view = this.f68165n0;
        }
        F1(view);
    }

    public boolean H0(int i3) {
        return this.f68156h.get(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DynamicTextItem I() {
        return C0().J(n0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0() {
        View view;
        if (W0()) {
            view = this.f68166o0;
        } else {
            view = this.f68165n0;
        }
        E1(view);
    }

    public void I1(DynamicTextItem dynamicTextItem, int i3, int i16, boolean z16) {
        RelativeLayout relativeLayout;
        if (System.currentTimeMillis() - this.f68159i0 < 500) {
            return;
        }
        this.f68159i0 = System.currentTimeMillis();
        hd0.c.a("DoodleLayout", "onClickInside: showEditTextDialog." + dynamicTextItem + ", textMode:" + i16 + ", this=" + this);
        if (dynamicTextItem != null) {
            dynamicTextItem.z();
        }
        this.E0 = new s();
        EditTextDialog Q = Q();
        this.F0 = Q;
        EditVideoDoodle editVideoDoodle = this.T;
        if (editVideoDoodle != null && (relativeLayout = editVideoDoodle.mParent.U) != null) {
            Q.f68096j0 = relativeLayout;
        }
        O0(dynamicTextItem, i3, i16, z16);
        invalidate();
        int i17 = this.H0;
        if (i17 != 0) {
            if (i17 == 1) {
                F1(this.f68171t0);
                setDoodleGLViewVisibility(0);
            } else if (i17 == 2) {
                I0();
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
                if (r06 != null) {
                    r06.t(false);
                }
            }
        }
        int i18 = this.H0;
        if (i18 != 9 && i18 != 11) {
            g1(3);
        }
        h1(8, Boolean.FALSE);
    }

    public void J(boolean z16) {
        RelativeLayout relativeLayout = this.f68162l0;
        if (relativeLayout == null || !z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = UIUtils.b(getContext(), 48.0f);
            this.f68162l0.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J0() {
        this.f68168q0.setVisibility(8);
    }

    public void J1(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "show limitView in doodleLayout  , mStoryGuideLineView : " + this.f68147b0);
        }
        StoryGuideLineView storyGuideLineView = this.f68147b0;
        if (storyGuideLineView == null) {
            return;
        }
        if (z19) {
            storyGuideLineView.f(true);
        } else {
            storyGuideLineView.b();
        }
        if (z17) {
            this.f68147b0.h();
        } else {
            this.f68147b0.d();
        }
        if (z16) {
            this.f68147b0.g();
        } else {
            this.f68147b0.c();
        }
    }

    protected void M0() {
        DoodlePanel doodlePanel = this.f68166o0;
        DoodlePanel.PenMode penMode = DoodlePanel.PenMode.FREE_DRAW;
        int i3 = R0;
        float f16 = V0;
        doodlePanel.c(penMode, i3, f16);
        this.f68167p0.c(DoodlePanel.PenMode.RECT, i3, f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M1(boolean z16, boolean z17) {
        View view;
        if (W0()) {
            view = this.f68166o0;
        } else {
            view = this.f68165n0;
        }
        long e06 = e0();
        long currentTimeMillis = System.currentTimeMillis() + e06;
        this.L = currentTimeMillis;
        if (z17) {
            this.L = currentTimeMillis + e06;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(e06);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new f(view));
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(e06);
        if (z17) {
            alphaAnimation2.setStartOffset(e06);
        }
        alphaAnimation2.setFillAfter(true);
        alphaAnimation2.setAnimationListener(new g(view));
        if (z16) {
            alphaAnimation = alphaAnimation2;
        }
        view.startAnimation(alphaAnimation);
        HorizontalSelectColorLayout horizontalSelectColorLayout = this.f68165n0;
        if (view == horizontalSelectColorLayout) {
            horizontalSelectColorLayout.setAnimationEndTime(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N1(boolean z16, boolean z17) {
        DoodlePanel doodlePanel = this.f68167p0;
        long e06 = e0();
        long currentTimeMillis = System.currentTimeMillis() + e06;
        this.L = currentTimeMillis;
        if (z17) {
            this.L = currentTimeMillis + e06;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(e06);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new d(doodlePanel));
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(e06);
        if (z17) {
            alphaAnimation2.setStartOffset(e06);
        }
        alphaAnimation2.setFillAfter(true);
        alphaAnimation2.setAnimationListener(new e(doodlePanel));
        if (z16) {
            alphaAnimation = alphaAnimation2;
        }
        doodlePanel.startAnimation(alphaAnimation);
    }

    public void O() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar;
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null || (hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) r06.I(104)) == null) {
            return;
        }
        hVar.b();
    }

    protected EditTextDialog Q() {
        return new EditTextDialog(super.getContext());
    }

    public void R0() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null || ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p) r06.I(101)) == null) {
            return;
        }
        if (this.f68149d == -1) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            if (from.containsKey("Line_LastType") && from.containsKey("Line_LastSubType")) {
                this.f68149d = from.decodeInt("Line_LastType", 0);
                this.f68151e = from.decodeInt("Line_LastSubType", 0);
            } else {
                this.f68149d = 0;
                this.f68151e = qs.d.b(W0());
            }
        }
        this.f68165n0.setSelectedStroke(this.f68149d, this.f68151e);
    }

    public void R1() {
        N();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null) {
            return;
        }
        hd0.c.a("DoodleLayout", "undo, activeLayer:" + this.f68171t0.o() + ",pathCount:" + r06.L.m());
        r06.b0();
        if (r06.L.m() == 0) {
            this.f68165n0.setUndoViewEnable(false);
        } else {
            this.f68165n0.setUndoViewEnable(true);
        }
        this.f68166o0.setUndoEnabled(r06.L.m() > 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S(DoodlePanel.PenMode penMode) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 != null && penMode != null) {
            int i3 = h.f68201a[penMode.ordinal()];
            if (i3 == 1) {
                r06.W(2);
                com.tencent.aelight.camera.ae.report.b.b().r0(2);
                return true;
            }
            if (i3 == 2) {
                if (this.f68166o0.d()) {
                    if (!r06.N()) {
                        r06.Y();
                    }
                } else if (!r06.O()) {
                    r06.Z();
                }
                com.tencent.aelight.camera.ae.report.b.b().r0(1);
                return true;
            }
            if (i3 == 3) {
                if (!r06.N()) {
                    r06.Y();
                }
                com.tencent.aelight.camera.ae.report.b.b().r0(3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean T(DoodlePanel.PenMode penMode) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 != null && penMode != null) {
            ShapeOperator I = x06.I();
            switch (h.f68201a[penMode.ordinal()]) {
                case 4:
                    x06.M(9);
                    I.o();
                    I.z(ShapeOperator.Shape.RECT_HOLLOW);
                    if (I.i()) {
                        V0();
                    }
                    com.tencent.aelight.camera.ae.report.b.b().u0(1);
                    return true;
                case 5:
                    x06.M(10);
                    I.o();
                    I.z(ShapeOperator.Shape.OVAL_HOLLOW);
                    if (I.i()) {
                        V0();
                    }
                    com.tencent.aelight.camera.ae.report.b.b().u0(2);
                    return true;
                case 6:
                    x06.M(7);
                    I.o();
                    I.z(ShapeOperator.Shape.LINE);
                    if (I.i()) {
                        V0();
                    }
                    com.tencent.aelight.camera.ae.report.b.b().u0(4);
                    return true;
                case 7:
                    x06.M(8);
                    I.o();
                    I.z(ShapeOperator.Shape.ARROW);
                    if (I.i()) {
                        V0();
                    }
                    com.tencent.aelight.camera.ae.report.b.b().u0(3);
                    return true;
                case 8:
                    I.o();
                    x06.M(11);
                    I.z(ShapeOperator.Shape.SEQUENCE_NUMBER);
                    if (!I.i()) {
                        return true;
                    }
                    V0();
                    return true;
            }
        }
        return false;
    }

    public void T0() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 != null) {
            r06.L();
        }
    }

    public void T1(int i3) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p pVar;
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null || (pVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p) r06.I(101)) == null) {
            return;
        }
        pVar.f(i3);
    }

    public void U() {
        int i3 = this.H0;
        if (i3 != 6) {
            if (i3 == 11) {
                h1(9, Boolean.FALSE);
                D1(9);
                L1();
                if (QLog.isColorLevel()) {
                    QLog.d("Personality", 2, "exitFullScreen for shape");
                    return;
                }
                return;
            }
            return;
        }
        h1(2, Boolean.FALSE);
        D1(2);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 != null && r06.L.m() > 0) {
            this.f68165n0.setUndoViewEnable(true);
        } else {
            this.f68165n0.setUndoViewEnable(false);
        }
        G1();
        if (QLog.isColorLevel()) {
            QLog.d("Personality", 2, "exitFullScreen");
        }
    }

    public void U1(int i3) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 == null) {
            return;
        }
        x06.I().x(i3);
    }

    public void V0() {
        this.f68171t0.invalidate();
    }

    public void V1(float f16) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null) {
            return;
        }
        float K = K(f16);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p pVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p) r06.I(101);
        if (pVar != null) {
            pVar.g(K);
        }
        r06.L.i().g(K);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) r06.I(104);
        if (hVar != null) {
            hVar.o(v0(K));
        }
    }

    public int W() {
        return this.H0;
    }

    public boolean W0() {
        r rVar = this.D0;
        if (rVar == null) {
            return true;
        }
        try {
            return rVar.B();
        } catch (Throwable th5) {
            hd0.c.h("DoodleLayout", "isEditPic error! ", th5);
            return true;
        }
    }

    public void W1(float f16) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 == null) {
            return;
        }
        K(f16);
        x06.I().A(f16);
    }

    public Bitmap X() {
        return this.f68171t0.s();
    }

    public boolean X0() {
        return this.f68171t0.z();
    }

    public Bitmap Y(int i3, boolean z16) {
        Bitmap bitmap;
        int q16 = this.f68171t0.q();
        int p16 = this.f68171t0.p();
        if (q16 > 0 && p16 > 0) {
            if (this.f68175x0.getAndSet(false)) {
                try {
                    this.f68174w0 = Bitmap.createBitmap(q16, p16, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError e16) {
                    hd0.c.h("DoodleLayout", "createBitmap oom error", e16);
                    return null;
                }
            }
            this.f68176y0.lock();
            while (true) {
                try {
                    bitmap = this.f68174w0;
                    if (bitmap != null) {
                        break;
                    }
                    try {
                        hd0.c.k("DoodleLayout", "getDoodleBitmap wait for bitmap cache");
                        if (!this.f68177z0.await(200L, TimeUnit.MILLISECONDS)) {
                            hd0.c.v("DoodleLayout", "getDoodleBitmap current thread [tid=%d] wait time out !!", Long.valueOf(Thread.currentThread().getId()));
                            RuntimeException runtimeException = this.A0;
                            if (runtimeException != null) {
                                hd0.c.u("DoodleLayout", "Client use the bitmap too long time", runtimeException);
                            }
                        }
                    } catch (InterruptedException e17) {
                        hd0.c.u("DoodleLayout", "getDoodleBitmap current thread InterruptedException", e17);
                    }
                } finally {
                    this.f68176y0.unlock();
                }
            }
            this.f68174w0 = null;
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPaint(paint);
            u uVar = this.C.get(i3);
            if (uVar == null) {
                hd0.c.i("DoodleLayout", "getDoodleBitmap failed can not find layer by video index %d", Integer.valueOf(i3));
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar = uVar.f68215b;
                if (cVar.L.p()) {
                    hd0.c.k("DoodleLayout", "need generate bitmap.");
                    cVar.L.I(q16);
                }
                EditVideoParams editVideoParams = this.f68161k0;
                if (editVideoParams != null && editVideoParams.r()) {
                    cVar.T(canvas);
                }
                LinkedList linkedList = new LinkedList(uVar.f68221h);
                Collections.sort(linkedList, this.L0);
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    tr.a aVar = (tr.a) linkedList.get(size);
                    if (aVar != null) {
                        aVar.w(canvas, aVar.g(), z16);
                    }
                }
                if (z16) {
                    int size2 = linkedList.size() - 1;
                    while (true) {
                        if (size2 < 0) {
                            break;
                        }
                        tr.a aVar2 = (tr.a) linkedList.get(size2);
                        if (aVar2 != null && (aVar2 instanceof DynamicFaceLayer)) {
                            ((DynamicFaceLayer) aVar2).t0(canvas);
                            break;
                        }
                        size2--;
                    }
                }
                hd0.c.a("DoodleLayout", "getDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - uptimeMillis));
            }
            return bitmap;
        }
        hd0.c.i("DoodleLayout", "getDoodleBitmap failed width %d height %d", Integer.valueOf(q16), Integer.valueOf(p16));
        return null;
    }

    public boolean Y0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar == null) {
            return true;
        }
        Iterator<tr.a> it = uVar.f68221h.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public int Z(int i3) {
        u uVar = this.C.get(i3);
        if (uVar == null) {
            return 0;
        }
        int V = uVar.f68214a.V();
        int H = uVar.f68215b.H();
        int W = uVar.f68216c.W();
        int W2 = uVar.f68217d.W();
        int H2 = uVar.f68220g.H();
        hd0.c.a("DoodleLayout", "DoodleCount: text->" + V + ",line->" + H + ",face->" + W + " " + W2 + ", shape->" + H2);
        return V + H + W + W2 + H2;
    }

    public boolean Z0() {
        DoodleView doodleView = this.f68171t0;
        return doodleView != null && doodleView.o() == j0();
    }

    public String a0() {
        List<FaceLayer.b> list;
        List<FaceLayer.b> list2;
        try {
            StringBuilder sb5 = new StringBuilder();
            FaceLayer l06 = l0();
            if (l06 != null && (list2 = l06.K) != null && !list2.isEmpty()) {
                for (FaceLayer.b bVar : l06.K) {
                    if (bVar != null && !TextUtils.isEmpty(bVar.A)) {
                        sb5.append(bVar.A);
                        sb5.append(",");
                    }
                }
            }
            DynamicFaceLayer d06 = d0();
            if (d06 != null && (list = d06.K) != null && !list.isEmpty()) {
                for (FaceLayer.b bVar2 : d06.K) {
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.A)) {
                        sb5.append(bVar2.A);
                        sb5.append(",");
                    }
                }
            }
            if (sb5.length() <= 0) {
                return GlobalUtil.DEF_STRING;
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        } catch (Exception unused) {
            return GlobalUtil.DEF_STRING;
        }
    }

    public String b0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(i3));
            return null;
        }
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g gVar = uVar.f68214a;
        ArrayList<g.c> arrayList = gVar.X;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<g.c> it = gVar.X.iterator();
            while (it.hasNext()) {
                DynamicTextItem dynamicTextItem = it.next().f68001z;
                if (dynamicTextItem != null) {
                    String textMap = dynamicTextItem.q().toString();
                    return textMap.substring(0, textMap.length() - 1);
                }
            }
        }
        return null;
    }

    public boolean b1() {
        DoodleView doodleView = this.f68171t0;
        return doodleView != null && doodleView.o() == this.E;
    }

    public String c0() {
        ArrayList<g.c> arrayList;
        List<String> e16;
        try {
            StringBuilder sb5 = new StringBuilder();
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0 = C0();
            if (C0 != null && (arrayList = C0.X) != null && !arrayList.isEmpty()) {
                Iterator<g.c> it = C0.X.iterator();
                while (it.hasNext()) {
                    DynamicTextItem dynamicTextItem = it.next().f68001z;
                    if (dynamicTextItem != null && (e16 = DynamicTextBuilder.e(dynamicTextItem.v())) != null && e16.size() > 0) {
                        String str = e16.get(0);
                        if (!TextUtils.isEmpty(str)) {
                            sb5.append(str);
                            sb5.append(",");
                        }
                    }
                }
            }
            if (sb5.length() <= 0) {
                return GlobalUtil.DEF_STRING;
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        } catch (Exception unused) {
            return GlobalUtil.DEF_STRING;
        }
    }

    public boolean c1() {
        return this.f68148c0;
    }

    public DynamicFaceLayer d0() {
        u uVar = this.C.get(this.f68153f);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(this.f68153f));
            return null;
        }
        return uVar.f68217d;
    }

    public boolean d1(g.c cVar, boolean z16) {
        DynamicTextItem dynamicTextItem;
        DoodleEditView doodleEditView = this.f68172u0;
        if (doodleEditView == null || cVar == null) {
            return false;
        }
        if (z16) {
            doodleEditView.setVisibility(0);
        }
        e1();
        this.f68172u0.T.L(cVar);
        cVar.f453057m = true;
        cVar.f453065u.lockData(!this.f68172u0.N());
        this.f68172u0.requestLayout();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f M = this.f68172u0.M();
        if (M != null && M.P != null && (dynamicTextItem = cVar.f68001z) != null && dynamicTextItem.F()) {
            cVar.f68001z.J();
            M.P.d(cVar, cVar.f68001z.h(), 0, 0.0f, 0.0f);
        }
        return true;
    }

    protected int e0() {
        return 500;
    }

    public EditPicRawImage f0() {
        return this.T.mParent.L;
    }

    public Bitmap g0() {
        q qVar = this.J0;
        if (qVar == null) {
            return null;
        }
        return qVar.S();
    }

    public void h1(int i3, Object obj) {
        ms.a.a("DoodleLayout", "notifyOutsideState---outsideState=" + i3);
        r rVar = this.D0;
        if (rVar != null) {
            rVar.f(i3, obj);
        }
    }

    protected int i0() {
        return R.layout.b5r;
    }

    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a j0() {
        u uVar = this.C.get(this.f68153f);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(this.f68153f));
            return null;
        }
        return uVar.f68218e;
    }

    public void j1() {
        if (this.H0 == 3) {
            D1(0);
            this.F0.e0(false);
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.I(true);
            }
        }
    }

    public int[] k0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar != null) {
            int[] X = uVar.f68216c.X();
            hd0.c.a("DoodleLayout", "normal face count:" + X[0] + ",location face count:" + X[1]);
            return X;
        }
        return new int[]{0, 0};
    }

    public void k1() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06;
        N();
        hd0.c.a("DoodleLayout", "onFacePressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o());
        id0.b.k("0X80076BA", id0.b.f407535d);
        int i3 = this.H0;
        if (i3 != 0) {
            if (i3 == 3) {
                D1(1);
                this.F0.e0(false);
                DoodleEditView doodleEditView = this.f68172u0;
                if (doodleEditView != null) {
                    doodleEditView.I(true);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
                if (r06 != null) {
                    r06.t(false);
                    I0();
                }
            } else if (i3 == 9 && (x06 = x0()) != null) {
                x06.t(false);
                K0();
            }
        }
        D1(1);
    }

    public FaceLayer l0() {
        u uVar = this.C.get(this.f68153f);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(this.f68153f));
            return null;
        }
        return uVar.f68216c;
    }

    public void l1() {
        r rVar = this.D0;
        if (rVar != null) {
            rVar.P();
        }
        DoodleEditView doodleEditView = this.f68172u0;
        if (doodleEditView != null) {
            doodleEditView.H();
        }
        f1(this.f68152e0);
    }

    public com.tencent.aelight.camera.aioeditor.capture.data.k m0() {
        return this.M;
    }

    public void m1() {
        N();
        hd0.c.a("DoodleLayout", "onLinePressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o());
        id0.b.k("0X80076B8", id0.b.f407535d);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 != null) {
            x06.I().i();
        }
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 == null) {
            return;
        }
        G1();
        r06.t(true);
        r06.U(false);
        R0();
        if (r06.L.m() > 0) {
            this.f68165n0.setUndoViewEnable(true);
        } else {
            this.f68165n0.setUndoViewEnable(false);
        }
        this.f68166o0.setUndoEnabled(r06.L.m() > 0);
        int i3 = this.H0;
        if (i3 != 0) {
            if (i3 == 3) {
                D1(2);
                this.F0.e0(false);
                DoodleEditView doodleEditView = this.f68172u0;
                if (doodleEditView != null) {
                    doodleEditView.I(true);
                    return;
                }
                return;
            }
            if (i3 == 1) {
                F1(this.f68171t0);
                setDoodleGLViewVisibility(0);
            } else if (i3 == 9) {
                K0();
            }
        }
        D1(2);
    }

    public int n0() {
        DoodleEditView doodleEditView = this.f68172u0;
        return (doodleEditView == null || doodleEditView.L() == 1 || this.f68172u0.L() != 0) ? 1 : 0;
    }

    public void n1() {
        if (this.H0 == 3) {
            D1(0);
            g1(0);
            this.F0.e0(false);
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.I(true);
            }
        }
    }

    public String o0() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 != null) {
            return r06.L.j();
        }
        return "";
    }

    public void o1() {
        if (this.H0 == 3) {
            D1(0);
            g1(0);
            this.F0.e0(false);
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.I(true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.L <= System.currentTimeMillis() && !i1(false) && (rVar = this.D0) != null) {
            rVar.close();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f68171t0.C();
        this.f68173v0.C();
        if (this.S) {
            this.f68170s0.N();
        }
        this.f68162l0.clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f68171t0.o() == this.E) {
            g1(7);
            tr.a n3 = this.f68171t0.n(motionEvent);
            ms.a.f("DoodleLayout", "onTouchEvent--findActiveLayer: " + n3);
            this.f68171t0.setActiveLayer(n3);
            this.f68171t0.setTopLevelLayer(n3);
            n3.c(motionEvent);
            this.M0 = true;
            return true;
        }
        if (this.M0) {
            this.f68171t0.o().c(motionEvent);
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return true;
            }
            this.M0 = false;
            return true;
        }
        this.M0 = false;
        return false;
    }

    protected int p0() {
        return R.layout.f167919mf;
    }

    public void p1() {
        N();
        hd0.c.a("DoodleLayout", "onShapePressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o() + ", " + new Throwable());
        id0.b.k("0X80076B8", id0.b.f407535d);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 == null) {
            return;
        }
        L1();
        x06.t(true);
        x06.L(false);
        x06.I().o();
        R0();
        this.f68166o0.setUndoEnabled(false);
        int i3 = this.H0;
        if (i3 != 0) {
            if (i3 == 3) {
                D1(9);
                this.F0.e0(false);
                DoodleEditView doodleEditView = this.f68172u0;
                if (doodleEditView != null) {
                    doodleEditView.I(true);
                    return;
                }
                return;
            }
            if (i3 == 1) {
                F1(this.f68171t0);
                setDoodleGLViewVisibility(0);
            } else if (i3 == 2) {
                I0();
            }
        }
        D1(9);
    }

    public int[] q0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar != null) {
            int[] k3 = uVar.f68215b.L.k();
            hd0.c.a("DoodleLayout", "normal path count:" + k3[0] + ",mosaic path count:" + k3[1]);
            return k3;
        }
        return new int[]{0, 0};
    }

    public void q1() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06;
        N();
        hd0.c.a("DoodleLayout", "onTextPressed, buttonState:" + this.H0 + ",activeLayer:" + this.f68171t0.o());
        DynamicTextItem I = I();
        d1(C0().Q(), false);
        if (I != null) {
            H1(I, 0, 0);
            int i3 = this.H0;
            if (i3 == 2) {
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
                if (r06 != null) {
                    r06.t(false);
                    I0();
                }
            } else if (i3 == 9 && (x06 = x0()) != null) {
                x06.t(false);
                K0();
            }
            D1(3);
            return;
        }
        QQToast.makeText(getContext(), getContext().getString(R.string.f2q), 0).show();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.14
            @Override // java.lang.Runnable
            public void run() {
                DoodleLayout.this.h1(0, Boolean.FALSE);
            }
        });
    }

    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r0() {
        u uVar = this.C.get(this.f68153f);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(this.f68153f));
            return null;
        }
        return uVar.f68215b;
    }

    public void r1(boolean z16) {
        DynamicFaceLayer d06 = d0();
        if (d06 != null) {
            d06.s0(z16);
        }
    }

    public String s0() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x06 = x0();
        if (x06 != null) {
            return x06.I().r();
        }
        return "";
    }

    public void s1() {
        this.f68171t0.D();
    }

    public void setDoodleBitmapMaxSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            hd0.c.a("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + i3 + ",maxHeight:" + i16);
            this.I = i3;
            this.J = i16;
            for (int i17 = 0; i17 < this.f68163m.size(); i17++) {
                this.f68163m.get(i17).f439855b = i3;
                this.f68163m.get(i17).f439856c = i16;
            }
            return;
        }
        hd0.c.g("DoodleLayout", "width or height is illegal, width=" + i3 + ",height=" + i16);
    }

    public void setDoodleBtnOperationHelper(q qVar) {
        this.J0 = qVar;
    }

    public void setDoodleEventListener(r rVar) {
        this.D0 = rVar;
    }

    public void setDoodleGLViewVisibility(int i3) {
        if (this.S) {
            if (!this.G0) {
                hd0.c.a("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
                this.f68170s0.setVisibility(4);
            } else {
                this.f68170s0.O(i3);
            }
        }
    }

    public void setEditVideoDoodle(EditVideoDoodle editVideoDoodle) {
        this.T = editVideoDoodle;
    }

    public void setEditVideoParams(EditVideoParams editVideoParams) {
        this.f68161k0 = editVideoParams;
        this.f68171t0.w(editVideoParams);
        this.f68172u0.w(editVideoParams);
        Q0 = this.f68161k0.r();
        w1();
    }

    public void setLocation(TroopBarPOI troopBarPOI) {
        if (this.I0 == null) {
            hd0.c.g("DoodleLayout", "ClickFaceItem not found.");
            return;
        }
        hd0.c.a("DoodleLayout", "setLocation: clickItem-->" + this.I0);
        l0().j0(this.I0, troopBarPOI);
        this.I0 = null;
    }

    public void setOnTextDialogShowListener(x xVar) {
        this.N = xVar;
    }

    public void setRecording(boolean z16) {
        this.U = z16;
    }

    public void setTimeStamp(long j3, boolean z16) {
        if (!this.f68146a0 || z16) {
            DoodleView doodleView = this.f68171t0;
            if (doodleView != null) {
                doodleView.setTimeStamp(j3);
            }
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.setTimeStamp(j3);
            }
            DoodleView doodleView2 = this.f68173v0;
            if (doodleView2 != null) {
                doodleView2.setTimeStamp(j3);
            }
        }
    }

    public Bitmap t0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar != null) {
            return uVar.f68215b.J();
        }
        return null;
    }

    public void t1(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        if (this.f68148c0) {
            return;
        }
        if (this.T == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "mEditDoodlePart == null && mListener instanceof QIMCaptureController/AECaptureController, showLimitBorder");
            }
            J1(z16, z17, z18, z19);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "mEditDoodlePart != null || mListener is not instanceof QIMCaptureController/AECaptureController, broadcast showLimitBorder message");
            }
            this.T.mParent.s(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.a(z18, z19, z17, z16, z26)));
        }
    }

    public byte[] u0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar == null) {
            return null;
        }
        return uVar.f68215b.K();
    }

    public void u1(boolean z16, float f16, int i3, int i16, PointF pointF, boolean z17, int i17) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.b bVar = this.D;
        if (bVar == null) {
            return;
        }
        bVar.C(z16, f16, i3, i16, pointF, z17, i17);
    }

    public void v1() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.9
            @Override // java.lang.Runnable
            public void run() {
                DoodleLayout.this.w1();
            }
        });
    }

    public List<String> w0(int i3) {
        u uVar = this.C.get(i3);
        if (uVar != null) {
            List<String> n3 = uVar.f68215b.L.n();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("image doodle type count:");
            sb5.append((n3 == null || n3.isEmpty()) ? 0 : n3.size());
            hd0.c.a("DoodleLayout", sb5.toString());
            return n3;
        }
        return Collections.emptyList();
    }

    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d x0() {
        u uVar = this.C.get(this.f68153f);
        if (uVar == null) {
            hd0.c.v("DoodleLayout", "can not find LayerCollection by video index %d", Integer.valueOf(this.f68153f));
            return null;
        }
        return uVar.f68220g;
    }

    public void x1(boolean z16) {
        this.E.t(z16);
    }

    public String y0() {
        List<FaceLayer.b> list;
        List<FaceLayer.b> list2;
        try {
            StringBuilder sb5 = new StringBuilder();
            FaceLayer l06 = l0();
            if (l06 != null && (list2 = l06.K) != null && !list2.isEmpty()) {
                for (FaceLayer.b bVar : l06.K) {
                    if (bVar != null && !TextUtils.isEmpty(bVar.A)) {
                        String str = bVar.f67965z;
                        if (TextUtils.isEmpty(str)) {
                            str = "none";
                        }
                        sb5.append(str);
                        sb5.append("_");
                        sb5.append(bVar.A);
                        sb5.append("|");
                    }
                }
            }
            DynamicFaceLayer d06 = d0();
            if (d06 != null && (list = d06.K) != null && !list.isEmpty()) {
                for (FaceLayer.b bVar2 : d06.K) {
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.A)) {
                        String str2 = bVar2.f67965z;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "none";
                        }
                        sb5.append(str2);
                        sb5.append("_");
                        sb5.append(bVar2.A);
                        sb5.append("|");
                    }
                }
            }
            if (sb5.length() <= 0) {
                return "";
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    protected w z0() {
        return new w(this.D, new gr.a(this.f68171t0), new FaceLayer(this.f68171t0), new DynamicFaceLayer(this.f68171t0), new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c(this.f68171t0), new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d(this.f68171t0), new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g(this.f68171t0));
    }

    public void z1() {
        N();
        F1(this.f68171t0, this.f68173v0);
        setDoodleGLViewVisibility(0);
        I0();
        K0();
        E1(this.f68162l0);
        A1();
        if (this.H0 == 3 && this.F0 != null) {
            D1(0);
            this.F0.e0(false);
            DoodleEditView doodleEditView = this.f68172u0;
            if (doodleEditView != null) {
                doodleEditView.I(true);
                return;
            }
            return;
        }
        D1(0);
        this.f68171t0.G();
        this.f68173v0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class s implements EditTextDialog.i {

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements aa {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f68211a;

            a(boolean z16) {
                this.f68211a = z16;
            }

            @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.aa
            public void a() {
                if (DoodleLayout.this.N != null) {
                    DoodleLayout.this.N.b(true);
                }
                DoodleLayout.this.C0().b0(this.f68211a);
            }
        }

        s() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void a(DynamicTextItem dynamicTextItem, boolean z16, int i3, boolean z17) {
            boolean z18;
            ms.a.a("DoodleLayout", "editTextDialog onDismiss--isAddingTextForShapeTips=" + DoodleLayout.this.f68154f0 + ", confirm=" + z16 + ", editMode=" + i3 + ", changed=" + z17 + ", text=" + dynamicTextItem);
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0 = DoodleLayout.this.C0();
            if (!z16) {
                if (i3 == 0) {
                    C0.R();
                    DoodleEditView doodleEditView = DoodleLayout.this.f68172u0;
                    if (doodleEditView != null) {
                        doodleEditView.T.L(null);
                    }
                    z18 = false;
                }
                z18 = true;
            } else if (dynamicTextItem != null && !dynamicTextItem.D() && (!dynamicTextItem.B(0) || dynamicTextItem.v() != 0 || z17)) {
                if (DoodleLayout.this.f68154f0) {
                    DoodleLayout.this.f68154f0 = false;
                    C0.k0(dynamicTextItem, DoodleLayout.this.f68155g0, DoodleLayout.this.f68157h0);
                    DoodleLayout.this.f68155g0 = null;
                    DoodleLayout.this.f68157h0 = null;
                } else {
                    C0.j0(dynamicTextItem);
                }
                z18 = true;
            } else {
                C0.S(dynamicTextItem);
                DoodleEditView doodleEditView2 = DoodleLayout.this.f68172u0;
                if (doodleEditView2 != null) {
                    doodleEditView2.T.L(null);
                }
                DoodleLayout.this.f68154f0 = false;
                z18 = false;
            }
            if (DoodleLayout.this.C0() != null) {
                DoodleLayout.this.C0().Y();
            }
            if (dynamicTextItem != null) {
                dynamicTextItem.z();
            }
            if (DoodleLayout.this.N != null && z18) {
                DoodleLayout.this.N.b(false);
            }
            if (z18) {
                C0.T();
                DoodleLayout.f1(DoodleLayout.this.f68152e0);
            }
            DoodleLayout.this.P = null;
            DoodleEditView doodleEditView3 = DoodleLayout.this.f68172u0;
            if (doodleEditView3 != null) {
                doodleEditView3.I(true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "raymondguo count " + C0.V() + ", items:" + C0.X.size());
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void b(int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.i("DoodleLayout", 2, "onEditTextOffsetChange centerX:" + i3 + " centerY:" + i16);
            }
            DoodleLayout.this.C0().h0(i3, i16);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void c(boolean z16) {
            DoodleLayout.this.f68160j0 = z16;
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0 = DoodleLayout.this.C0();
            if (QLog.isColorLevel()) {
                QLog.i("DoodleLayout", 2, "onSoftKeyboardStateChange show:" + z16);
            }
            if (!z16) {
                DoodleLayout.this.P = null;
                C0.e0(false);
                DoodleLayout doodleLayout = DoodleLayout.this;
                if (doodleLayout.H0 == 3) {
                    doodleLayout.D1(0);
                    DoodleLayout.this.g1(0);
                    return;
                }
                return;
            }
            C0.e0(true);
            if (DoodleLayout.this.P != null) {
                DoodleLayout.this.P.a();
                DoodleLayout.this.P = null;
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void d(int i3) {
            DoodleLayout.this.C0().i0(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void e(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("DoodleLayout", 2, String.format("onDialogLayout inputShowing: " + DoodleLayout.this.f68160j0, new Object[0]));
            }
            if (!DoodleLayout.this.f68160j0) {
                DoodleLayout.this.F0.B0();
            }
            DoodleLayout doodleLayout = DoodleLayout.this;
            if (doodleLayout.f68172u0 != null && !z16) {
                doodleLayout.e1();
            }
            if (z16 && !DoodleLayout.this.C0().X()) {
                DoodleLayout.this.P = new a(z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("DoodleLayout", 2, "onDialogLayout needAnim:" + z16 + " y:" + DoodleLayout.this.C0().U);
            }
            if (DoodleLayout.this.N != null) {
                DoodleLayout.this.N.b(true);
            }
            DoodleLayout.this.C0().b0(z16);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void onPanelChanged(int i3, int i16) {
            if (DoodleLayout.this.H0 == 3 && QLog.isColorLevel()) {
                QLog.i("DoodleLayout", 2, "onPanelChanged old:" + i3 + " new:" + i16);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void onWindowFocusChanged(boolean z16) {
            if (!z16 || DoodleLayout.this.f68160j0) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("DoodleLayout", 4, String.format("onWindowFocusChanged input not showing", new Object[0]));
            }
            DoodleLayout.this.F0.C0();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.i
        public void f() {
        }
    }

    public static void P1(String str) {
        String str2;
        String[] strArr = new String[1];
        if (Q0) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        strArr[0] = str2;
        Q1(str, 0, 0, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        try {
            this.f68165n0.setStrokeStrategy(new gs.a(super.getContext() instanceof QQStoryBaseActivity ? ((QQStoryBaseActivity) super.getContext()).mApp : null, true, false, W0()), true, 2);
            R0();
        } catch (Exception e16) {
            QLog.e("DoodleLayout", 1, "refresh Stroke error", e16);
        }
    }

    public void H1(DynamicTextItem dynamicTextItem, int i3, int i16) {
        I1(dynamicTextItem, i3, i16, true);
    }

    protected void K0() {
        E1(this.f68167p0);
    }

    public void L(int i3, int i16, boolean z16) {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar;
        hd0.c.a("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", Integer.valueOf(i3), Integer.valueOf(i16)));
        setDoodleBitmapMaxSize(i3, i16);
        int width = this.f68171t0.getWidth();
        int height = this.f68171t0.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f68171t0.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f68171t0.setLayoutParams(layoutParams);
        if (!z16) {
            this.f68171t0.k();
            A1();
        }
        this.f68171t0.E();
        this.f68171t0.onSizeChanged(i3, i16, width, height);
        DoodleEditView doodleEditView = this.f68172u0;
        if (doodleEditView != null) {
            doodleEditView.O(i3, i16);
        }
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = r0();
        if (r06 != null && (hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) r06.I(104)) != null) {
            hVar.b();
        }
        if (this.S) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f68169r0.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i16;
            this.f68169r0.setLayoutParams(layoutParams2);
        }
    }

    protected void L1() {
        F1(this.f68167p0);
    }

    public void P() {
        this.K = true;
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g gVar = this.C.valueAt(i3).f68214a;
            gVar.y(null);
            gVar.g0(null);
        }
    }

    public void R() {
        this.B0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1(int i3) {
        h1(i3, null);
    }

    public void setEditMode(boolean z16) {
        this.f68148c0 = true;
        this.f68150d0 = z16;
    }

    private void S0(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d dVar) {
        if (dVar != null) {
            dVar.I().z(ShapeOperator.Shape.RECT_HOLLOW);
            dVar.I().x(R0);
            dVar.I().A(V0);
            dVar.I().y(new b(dVar));
            dVar.y(new y());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f1(boolean z16) {
        if (z16) {
            com.tencent.aelight.camera.aioeditor.takevideo.ac.a().b();
        }
    }

    public int D0() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            u valueAt = this.C.valueAt(i16);
            i3 = i3 + valueAt.f68214a.V() + valueAt.f68215b.H() + valueAt.f68216c.W() + valueAt.f68217d.W() + valueAt.f68220g.H();
        }
        return i3;
    }

    public void E(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f68176y0.lock();
            if (this.f68174w0 == null) {
                this.A0 = null;
                try {
                    this.f68174w0 = bitmap;
                    this.f68177z0.signal();
                    return;
                } finally {
                    this.f68176y0.unlock();
                }
            }
            throw new IllegalStateException("add bitmap as buffer duplicate");
        }
        throw new IllegalArgumentException("bitmap should not be null or recycled");
    }

    protected void K1(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar) {
        if (qVar != null) {
            K0();
            this.f68168q0.setVisibility(0);
            this.f68168q0.setSelectedColorAndWidth(qVar.E(), qVar.F());
        }
    }

    protected int V() {
        return ScreenUtil.dip2px(65.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ab implements a.InterfaceC11305a<tr.a> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f68181a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f68182b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f68183c = false;

        ab() {
        }

        @Override // tr.a.InterfaceC11305a
        public boolean a(tr.a aVar, MotionEvent motionEvent) {
            Rect rect;
            EditVideoParams editVideoParams;
            boolean z16 = aVar instanceof FaceLayer;
            Rect V = z16 ? ((FaceLayer) aVar).V(new Rect()) : null;
            float f16 = LiuHaiUtils.isLiuHaiUseValid() ? LiuHaiUtils.BOTTOM_HEIGHT : 0.0f;
            if (SystemBarTintManager.hasNavBar(DoodleLayout.this.getContext())) {
                f16 += SystemBarTintManager.getNavigationBarHeight(DoodleLayout.this.getContext());
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int abs = (int) Math.abs(y16 - DoodleLayout.this.R);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if ((action == 2 || action == 5 || action == 6) && abs > DoodleLayout.this.Q) {
                        if (DoodleLayout.this.B0 && DoodleLayout.this.f68162l0.getVisibility() != 0) {
                            if (DoodleLayout.this.B0) {
                                DoodleLayout doodleLayout = DoodleLayout.this;
                                ad.b(doodleLayout.f68162l0, false, doodleLayout.e0());
                            }
                            Rect rect2 = new Rect();
                            this.f68181a = rect2;
                            DoodleLayout.this.f68162l0.getGlobalVisibleRect(rect2);
                            DoodleLayout doodleLayout2 = DoodleLayout.this;
                            doodleLayout2.f68171t0.getGlobalVisibleRect(doodleLayout2.P0);
                            DoodleLayout doodleLayout3 = DoodleLayout.this;
                            int i3 = doodleLayout3.H0;
                            if (i3 == 2) {
                                doodleLayout3.I0();
                            } else if (i3 == 9) {
                                if (doodleLayout3.f68167p0.getVisibility() == 0) {
                                    DoodleLayout.this.N1(false, true);
                                }
                                DoodleLayout.this.K0();
                            }
                            DoodleLayout.this.g1(4);
                        }
                        if (this.f68181a != null) {
                            EditVideoParams editVideoParams2 = DoodleLayout.this.f68161k0;
                            if (editVideoParams2 != null && !editVideoParams2.r()) {
                                if (motionEvent.getPointerCount() != 1 || !this.f68181a.contains((int) x16, (int) y16) || !DoodleLayout.this.B0) {
                                    DoodleLayout.this.C1(false);
                                    this.f68182b = false;
                                } else {
                                    DoodleLayout.this.C1(true);
                                    this.f68182b = true;
                                }
                            } else {
                                Rect rect3 = DoodleLayout.this.P0;
                                if (this.f68181a.contains(((int) x16) + rect3.left, ((int) y16) + rect3.top) || DoodleLayout.this.a1(x16, y16, V, f16)) {
                                    DoodleLayout.this.C1(true);
                                    this.f68182b = true;
                                } else {
                                    DoodleLayout.this.C1(false);
                                    this.f68182b = false;
                                }
                            }
                            this.f68183c = true;
                        }
                    }
                } else {
                    if (this.f68181a != null && ((editVideoParams = DoodleLayout.this.f68161k0) == null || editVideoParams.r())) {
                        DoodleLayout doodleLayout4 = DoodleLayout.this;
                        Rect rect4 = doodleLayout4.P0;
                        int i16 = ((int) x16) + rect4.left;
                        int i17 = ((int) y16) + rect4.top;
                        if (doodleLayout4.C0 && (this.f68181a.contains(i16, i17) || DoodleLayout.this.a1(x16, y16, V, f16))) {
                            if (z16) {
                                hd0.c.a("DoodleLayout", "remove face.");
                                ((FaceLayer) aVar).e0();
                                DoodleLayout.this.u1(false, 0.0f, 0, 0, null, false, 0);
                                if (QLog.isColorLevel()) {
                                    QLog.d("DoodleLayout", 2, "delete face, disable guideline");
                                }
                            } else if (aVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g) {
                                hd0.c.a("DoodleLayout", "editpic remove text.");
                                DoodleLayout.this.u1(false, 0.0f, 0, 0, null, false, 0);
                                ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g) aVar).O();
                                aVar.t(false);
                            } else if (aVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f) {
                                ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f) aVar).J();
                            }
                            DoodleLayout.this.C1(false);
                            DoodleLayout.this.l1();
                        }
                    } else if (motionEvent.getPointerCount() == 1 && (rect = this.f68181a) != null && rect.contains((int) x16, (int) y16) && this.f68182b) {
                        if (aVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g) {
                            hd0.c.a("DoodleLayout", "remove text.");
                            ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g) aVar).O();
                            aVar.t(false);
                        } else if (z16) {
                            hd0.c.a("DoodleLayout", "remove face.");
                            ((FaceLayer) aVar).e0();
                        } else if (aVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f) {
                            ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.f) aVar).J();
                        }
                        DoodleLayout.this.C1(false);
                        DoodleLayout.this.l1();
                    }
                    DoodleLayout doodleLayout5 = DoodleLayout.this;
                    doodleLayout5.E1(doodleLayout5.f68162l0);
                    DoodleLayout doodleLayout6 = DoodleLayout.this;
                    int i18 = doodleLayout6.H0;
                    if (i18 == 2) {
                        doodleLayout6.G1();
                        DoodleLayout doodleLayout7 = DoodleLayout.this;
                        doodleLayout7.g1(doodleLayout7.H0);
                    } else if (i18 == 9) {
                        doodleLayout6.L1();
                        DoodleLayout doodleLayout8 = DoodleLayout.this;
                        doodleLayout8.g1(doodleLayout8.H0);
                    } else if (i18 != 6 && i18 != 11) {
                        doodleLayout6.z1();
                        DoodleLayout.this.g1(0);
                    }
                    if (DoodleLayout.this.T != null || DoodleLayout.this.f68147b0 == null) {
                        if (DoodleLayout.this.T != null && DoodleLayout.this.T.mParent != null) {
                            DoodleLayout.this.T.mParent.s(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.a(false, false, false, false, true)));
                        }
                        DoodleLayout.f1(DoodleLayout.this.f68152e0 && this.f68183c);
                        this.f68183c = false;
                    } else {
                        DoodleLayout.this.J1(false, false, false, false);
                    }
                }
            } else {
                DoodleLayout.this.R = (int) y16;
                this.f68182b = false;
            }
            return false;
        }
    }

    private void U0() {
        this.f68162l0 = (RelativeLayout) super.findViewById(R.id.ifo);
        this.f68164m0 = (ImageView) super.findViewById(R.id.dxw);
        this.M = new t();
        HorizontalSelectColorLayout horizontalSelectColorLayout = (HorizontalSelectColorLayout) super.findViewById(R.id.f8l);
        this.f68165n0 = horizontalSelectColorLayout;
        horizontalSelectColorLayout.setOnUndoViewClickListener(new j());
        this.f68165n0.setOnStrokeSelectedListener(new k());
        L0();
        View findViewById = super.findViewById(R.id.acz);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        w1();
        this.f68171t0 = (DoodleView) super.findViewById(R.id.f165009bo4);
        DoodleEditView doodleEditView = (DoodleEditView) super.findViewById(R.id.bo5);
        this.f68172u0 = doodleEditView;
        doodleEditView.setDoodleLayout(this);
        setOnTextDialogShowListener(this.f68172u0);
        this.f68172u0.setOnLayerTouchListener();
        this.f68173v0 = (DoodleView) super.findViewById(R.id.boa);
        z1();
    }

    protected void L0() {
        DoodlePanel doodlePanel = (DoodlePanel) findViewById(R.id.ukc);
        this.f68166o0 = doodlePanel;
        doodlePanel.setPanelListener(new l());
        DoodlePanel doodlePanel2 = (DoodlePanel) findViewById(R.id.ukd);
        this.f68167p0 = doodlePanel2;
        doodlePanel2.setPanelListener(new m());
        DoodleShapePanel doodleShapePanel = (DoodleShapePanel) findViewById(R.id.uke);
        this.f68168q0 = doodleShapePanel;
        doodleShapePanel.setPanelListener(new n());
    }

    public void setMosaicSize(int i3) {
        if (i3 < 1) {
            hd0.c.g("DoodleLayout", "MosaicSize little than 1.");
            i3 = 1;
        }
        this.F = i3;
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.C.valueAt(i16).f68215b.I(103);
            if (hVar != null) {
                hVar.q(i3);
            }
        }
    }

    public void setupPersonality() {
        this.f68169r0 = (FrameLayout) super.findViewById(R.id.bo6);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        DoodleTextureView doodleTextureView = new DoodleTextureView(super.getContext());
        this.f68170s0 = doodleTextureView;
        this.f68169r0.addView(doodleTextureView, layoutParams);
        boolean i3 = com.tencent.mobileqq.shortvideo.util.f.i();
        this.G0 = i3;
        if (!i3) {
            E1(this.f68169r0);
            setDoodleGLViewVisibility(4);
            this.S = false;
        } else {
            this.S = true;
            Q0();
        }
    }

    private void P0(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar) {
        int i3;
        int i16;
        int i17;
        if (cVar != null) {
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) cVar.I(103);
            if (hVar != null && (i17 = this.F) != -1) {
                hVar.q(i17);
            }
            if (hVar != null && (i3 = this.G) != -1 && (i16 = this.H) != -1) {
                hVar.r(i3, i16);
            }
            float K = K(V0);
            cVar.L.i().g(K);
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p pVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.p) cVar.I(101);
            if (pVar != null) {
                pVar.f(R0);
                pVar.g(K);
            }
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar2 = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) cVar.I(104);
            if (hVar2 != null) {
                hVar2.o(v0(K));
            }
        }
    }

    public void G(e.a aVar, float f16, float f17, float f18, SegmentKeeper segmentKeeper) {
        boolean z16;
        File fileInLocal;
        N();
        if (aVar == null) {
            hd0.c.g("DoodleLayout", "the item is null.");
            return;
        }
        hd0.c.a("DoodleLayout", "addLocationFaceItem:" + aVar.toString());
        FaceLayer.d e16 = zr.b.e(aVar, this.f68171t0.getWidth(), this.f68171t0.getHeight(), f16, f17, f18);
        if (e16 != null) {
            Drawable drawable = aVar.f406050e;
            if (drawable == null || !(drawable instanceof URLDrawable) || (fileInLocal = ((URLDrawable) drawable).getFileInLocal()) == null || !fileInLocal.exists()) {
                z16 = false;
            } else {
                FaceLayer l06 = l0();
                if ((aVar.f406055j == 1 && this.f68161k0 == null) || this.f68161k0.s()) {
                    l06 = d0();
                }
                z16 = l06.J(aVar.f406054i, aVar.f406048c, aVar.f406050e, e16, fileInLocal.getAbsolutePath(), true, aVar.f406055j, n0(), segmentKeeper);
            }
            if (z16) {
                this.D0.v(aVar);
                id0.b.i("0X80076CE");
                f1(this.f68152e0);
                return;
            }
            return;
        }
        hd0.c.g("DoodleLayout", "create FaceLayer.ItemParams failed.");
    }

    public boolean a1(float f16, float f17, Rect rect, float f18) {
        int width = rect == null ? 0 : rect.width() / 2;
        float f19 = -width;
        return f16 < f19 || f17 < f19 || f16 > ((float) (this.P0.width() + width)) || f17 > ((float) (this.P0.height() + width)) + f18;
    }

    public void setMosaicStandardSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.G = i3;
            this.H = i16;
            for (int i17 = 0; i17 < this.C.size(); i17++) {
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.C.valueAt(i17).f68215b.I(103);
                if (hVar != null) {
                    hVar.r(i3, i16);
                }
            }
            return;
        }
        hd0.c.g("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + i3 + ",height:" + i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ac implements g.a {
        ac() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.a
        public void a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
            DoodleLayout.this.t1(z16, z17, z18, z19, z26);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.a
        public void b(DynamicTextItem dynamicTextItem) {
            if (DoodleLayout.this.U) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "onClickInside mIsRecording");
                }
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                DoodleLayout doodleLayout = DoodleLayout.this;
                if (uptimeMillis - doodleLayout.O0 > 500) {
                    doodleLayout.O0 = uptimeMillis;
                    doodleLayout.H1(dynamicTextItem, dynamicTextItem.h(), 1);
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.a
        public boolean c(g.c cVar) {
            if (!DoodleLayout.this.f68148c0 || DoodleLayout.this.f68150d0) {
                return DoodleLayout.this.d1(cVar, true);
            }
            return false;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.a
        public void d(float f16) {
            if (f16 >= 0.95f) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "onAnimate:" + f16);
                }
                DoodleLayout doodleLayout = DoodleLayout.this;
                if (doodleLayout.F0 == null || doodleLayout.C0() == null || DoodleLayout.this.C0().W() == null) {
                    return;
                }
                DoodleLayout doodleLayout2 = DoodleLayout.this;
                doodleLayout2.F0.z0(doodleLayout2.C0().W(), DoodleLayout.this.C0().W().h());
            }
        }
    }

    public void F(e.a aVar, float f16, float f17, float f18) {
        G(aVar, f16, f17, f18, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements q.d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f68186a;

        /* renamed from: b, reason: collision with root package name */
        private float f68187b;

        /* renamed from: c, reason: collision with root package name */
        private Rect f68188c;

        /* renamed from: d, reason: collision with root package name */
        private float[] f68189d = new float[2];

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d f68190e;

        b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d dVar) {
            this.f68190e = dVar;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void a() {
            DoodleLayout.this.J0();
            DoodleLayout doodleLayout = DoodleLayout.this;
            doodleLayout.g1(doodleLayout.H0);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void c(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar, MotionEvent motionEvent) {
            if (DoodleLayout.this.B0 && DoodleLayout.this.f68162l0.getVisibility() != 0) {
                DoodleLayout doodleLayout = DoodleLayout.this;
                ad.b(doodleLayout.f68162l0, false, doodleLayout.e0());
                Rect rect = new Rect();
                this.f68188c = rect;
                DoodleLayout.this.f68162l0.getGlobalVisibleRect(rect);
                DoodleLayout doodleLayout2 = DoodleLayout.this;
                doodleLayout2.f68171t0.getGlobalVisibleRect(doodleLayout2.P0);
            }
            if (DoodleLayout.this.B0) {
                Matrix e16 = this.f68190e.e();
                if (e16 != null) {
                    motionEvent = h(motionEvent, e16);
                }
                if (((int) Math.abs(motionEvent.getY() - this.f68187b)) > DoodleLayout.this.Q && this.f68188c != null) {
                    EditVideoParams editVideoParams = DoodleLayout.this.f68161k0;
                    if (editVideoParams != null && !editVideoParams.r()) {
                        if (motionEvent.getPointerCount() != 1 || !this.f68188c.contains((int) motionEvent.getX(), (int) motionEvent.getY()) || !DoodleLayout.this.B0) {
                            DoodleLayout.this.C1(false);
                            this.f68186a = false;
                        } else {
                            DoodleLayout.this.C1(true);
                            this.f68186a = true;
                        }
                    } else {
                        int x16 = ((int) motionEvent.getX()) + DoodleLayout.this.P0.left;
                        int y16 = ((int) motionEvent.getY()) + DoodleLayout.this.P0.top;
                        ms.a.a("DoodleLayout", "onTouchBodyMove--(" + motionEvent.getX() + ", " + motionEvent.getY() + "), mRubbishRect=" + this.f68188c.toShortString() + ", mDisplayRect=" + DoodleLayout.this.P0.toShortString());
                        if (this.f68188c.contains(x16, y16)) {
                            DoodleLayout.this.C1(true);
                            this.f68186a = true;
                        } else {
                            DoodleLayout.this.C1(false);
                            this.f68186a = false;
                        }
                    }
                }
                if (e16 != null) {
                    motionEvent.recycle();
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void d(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar, RectF rectF) {
            DoodleLayout.this.H(qVar, rectF);
            com.tencent.aelight.camera.ae.report.b.b().t0();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void e(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar, MotionEvent motionEvent) {
            Rect rect;
            EditVideoParams editVideoParams;
            if (DoodleLayout.this.B0) {
                Matrix e16 = this.f68190e.e();
                if (e16 != null) {
                    motionEvent = h(motionEvent, e16);
                }
                if (this.f68188c != null && ((editVideoParams = DoodleLayout.this.f68161k0) == null || editVideoParams.r())) {
                    int x16 = ((int) motionEvent.getX()) + DoodleLayout.this.P0.left;
                    int y16 = (int) motionEvent.getY();
                    DoodleLayout doodleLayout = DoodleLayout.this;
                    int i3 = y16 + doodleLayout.P0.top;
                    if (doodleLayout.C0 && this.f68188c.contains(x16, i3)) {
                        DoodleLayout.this.C1(false);
                        this.f68190e.I().k();
                    }
                } else if (motionEvent.getPointerCount() == 1 && (rect = this.f68188c) != null && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && this.f68186a) {
                    DoodleLayout.this.C1(false);
                    this.f68190e.I().k();
                }
                DoodleLayout doodleLayout2 = DoodleLayout.this;
                doodleLayout2.E1(doodleLayout2.f68162l0);
                if (e16 != null) {
                    motionEvent.recycle();
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void f(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar, MotionEvent motionEvent) {
            Matrix e16 = this.f68190e.e();
            if (e16 != null) {
                ms.a.a("DoodleLayout", "onTouchBodyDown--(" + motionEvent.getX() + ", " + motionEvent.getY() + "), invertMatrix=" + e16.toShortString());
                motionEvent = h(motionEvent, e16);
            }
            if (DoodleLayout.this.B0) {
                this.f68187b = motionEvent.getY();
            }
            if (e16 != null) {
                motionEvent.recycle();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void g() {
            ms.a.a("DoodleLayout", "onClickEmpty");
            DoodleLayout doodleLayout = DoodleLayout.this;
            if (doodleLayout.H0 == 11) {
                doodleLayout.h1(9, Boolean.FALSE);
                DoodleLayout.this.D1(9);
                DoodleLayout.this.L1();
                DoodleLayout.this.N1(true, false);
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "ShapeLayer tap up show");
                    return;
                }
                return;
            }
            if (!this.f68190e.K()) {
                DoodleLayout.this.D1(11);
                DoodleLayout.this.g1(11);
                DoodleLayout.this.K0();
                DoodleLayout.this.N1(false, true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "ShapeLayer tap up hide");
            }
        }

        public MotionEvent h(MotionEvent motionEvent, Matrix matrix) {
            this.f68189d[0] = motionEvent.getX();
            this.f68189d[1] = motionEvent.getY();
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            matrix.mapPoints(this.f68189d);
            float[] fArr = this.f68189d;
            obtain.setLocation(fArr[0], fArr[1]);
            return obtain;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
        public void b(com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q qVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f68193d;

        d(View view) {
            this.f68193d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f68193d.setAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f68195d;

        e(View view) {
            this.f68195d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f68195d.setAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f68197d;

        f(View view) {
            this.f68197d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f68197d.setAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f68199d;

        g(View view) {
            this.f68199d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f68199d.setAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    protected float v0(float f16) {
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class m implements DoodlePanel.c {
        m() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void a(int i3) {
            if (DoodleLayout.this.x0() != null) {
                DoodleLayout.this.U1(i3);
                DoodleLayout.this.V0();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void c(float f16) {
            if (DoodleLayout.this.x0() != null) {
                DoodleLayout.this.W1(f16);
                DoodleLayout.this.V0();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void d(DoodlePanel.PenMode penMode) {
            DoodleLayout.this.T(penMode);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void onFinish() {
            DoodleLayout.this.g1(0);
            if (DoodleLayout.this.f68171t0.B()) {
                return;
            }
            DoodleLayout.this.f68171t0.G();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.c
        public void b() {
        }
    }
}
