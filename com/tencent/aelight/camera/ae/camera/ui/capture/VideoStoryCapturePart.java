package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.animator.ViewAnimator;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.simple.AioCaptureReportParams;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.watermark.b;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import cooperation.peak.PeakConstants;
import fs.s;
import fs.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import or.c;

/* loaded from: classes32.dex */
public class VideoStoryCapturePart extends com.tencent.aelight.camera.ae.part.b {
    public static int Z;
    private int C;
    private long D;
    private AECameraGLSurfaceView E;
    private ImageView F;
    private View G;
    private View H;
    private View I;
    private View J;
    private View K;
    private ViewGroup L;
    private Dialog M;
    private VideoStoryDataBean N;
    private boolean P;
    private boolean Q;
    private int R;
    private boolean S;
    private AEVideoStoryTopBarViewModel.Ratio T;
    private AECaptureMode U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f62582d;

    /* renamed from: e, reason: collision with root package name */
    private AEVideoStoryTopBarViewModel f62583e;

    /* renamed from: f, reason: collision with root package name */
    private AEPituCameraUnit f62584f;

    /* renamed from: h, reason: collision with root package name */
    List<FrameVideoHelper.FrameBuffer> f62585h;

    /* renamed from: i, reason: collision with root package name */
    private long f62586i;

    /* renamed from: m, reason: collision with root package name */
    private int f62587m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (VideoStoryCapturePart.this.E == null || VideoStoryCapturePart.this.H == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, VideoStoryCapturePart.this.H, VideoStoryCapturePart.this.E);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (VideoStoryCapturePart.this.E == null || VideoStoryCapturePart.this.I == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, VideoStoryCapturePart.this.I, VideoStoryCapturePart.this.E);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (VideoStoryCapturePart.this.E == null || VideoStoryCapturePart.this.J == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, VideoStoryCapturePart.this.J, VideoStoryCapturePart.this.E);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (VideoStoryCapturePart.this.E == null || VideoStoryCapturePart.this.K == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, VideoStoryCapturePart.this.K, VideoStoryCapturePart.this.E);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements Observer<AEVideoStoryTopBarViewModel.Ratio> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.Ratio ratio) {
            int i3;
            ms.a.f("VideoStoryCapturePart", "mCurrentRatio---onChanged: ratio=" + ratio);
            if (ratio == null || VideoStoryCapturePart.this.T == ratio) {
                return;
            }
            VideoStoryCapturePart.this.T = ratio;
            if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
                i3 = VideoStoryCapturePart.this.a0();
            } else {
                i3 = ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1 ? VideoStoryCapturePart.Z : 0;
            }
            com.tencent.mobileqq.activity.richmedia.i a16 = com.tencent.aelight.camera.ae.util.h.a();
            com.tencent.mobileqq.activity.richmedia.i c16 = com.tencent.aelight.camera.ae.util.h.c(VideoStoryCapturePart.this.U, a16, VideoStoryCapturePart.this.V, ratio);
            ms.a.f("VideoStoryCapturePart", "mCurrentRatio---mCaptureMode" + VideoStoryCapturePart.this.U);
            if (VideoStoryCapturePart.this.V) {
                VideoStoryCapturePart.this.w0(i3, c16);
            } else if (VideoStoryCapturePart.this.U != AECaptureMode.NORMAL) {
                VideoStoryCapturePart.this.w0(i3, c16);
            } else if (VideoStoryCapturePart.this.T == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
                VideoStoryCapturePart.this.y0(i3, a16);
            } else {
                VideoStoryCapturePart.this.x0(i3, a16);
            }
            VideoStoryCapturePart.this.A0(a16, c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f62605a;

        i(float f16) {
            this.f62605a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f62605a);
        }
    }

    public VideoStoryCapturePart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.f62586i = 0L;
        this.D = 90000L;
        this.P = false;
        this.Q = false;
        this.R = 0;
        this.S = false;
        this.U = null;
        this.Y = false;
        this.f62584f = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.N = new VideoStoryDataBean();
        Z = ViewUtils.dip2px(60.0f) + ImmersiveUtils.getStatusBarHeight(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(com.tencent.mobileqq.activity.richmedia.i iVar, com.tencent.mobileqq.activity.richmedia.i iVar2) {
        if (this.V) {
            int Y = Y();
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.f13269p);
            int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.f13289r);
            if (this.T == AEVideoStoryTopBarViewModel.Ratio.R_4_3 && this.U == AECaptureMode.NORMAL) {
                dimensionPixelSize = Math.max(((iVar.f185861b - Y) - iVar2.f185861b) + dimensionPixelSize2, dimensionPixelSize);
            }
            ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
            layoutParams.height = dimensionPixelSize;
            this.L.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(AECaptureMode aECaptureMode) {
        int i3;
        float height;
        float f16;
        int i16;
        float f17;
        int i17;
        AECaptureMode aECaptureMode2 = AECaptureMode.GIF;
        if (aECaptureMode == aECaptureMode2 || aECaptureMode == AECaptureMode.NORMAL) {
            if (aECaptureMode == aECaptureMode2) {
                AEPituCameraUnit aEPituCameraUnit = this.f62584f;
                if (aEPituCameraUnit != null) {
                    if (!this.P || (i17 = this.R) == 0) {
                        i16 = x.c(aEPituCameraUnit.z(), 147.0f);
                    } else {
                        f17 = i17;
                        i3 = (int) f17;
                    }
                } else {
                    if (this.P) {
                        height = this.mRootView.getHeight();
                        f16 = 0.072413795f;
                    } else {
                        height = this.mRootView.getHeight();
                        f16 = 0.18103448f;
                    }
                    i16 = (int) (height * f16);
                }
                f17 = i16;
                i3 = (int) f17;
            } else {
                if (this.V) {
                    AEVideoStoryTopBarViewModel.Ratio ratio = this.T;
                    if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
                        i3 = a0();
                    } else if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
                        i3 = Z;
                    }
                }
                i3 = 0;
            }
            com.tencent.mobileqq.activity.richmedia.i a16 = com.tencent.aelight.camera.ae.util.h.a();
            com.tencent.mobileqq.activity.richmedia.i c16 = com.tencent.aelight.camera.ae.util.h.c(this.U, a16, this.V, this.T);
            if (this.V) {
                w0(i3, c16);
            } else if (this.U == AECaptureMode.NORMAL) {
                x0(i3, a16);
            } else {
                w0(i3, c16);
            }
            A0(a16, c16);
        }
    }

    private void O(boolean z16) {
        if (gq.a.f(this.f62584f.C().k())) {
            AioCaptureReportParams aioCaptureReportParams = new AioCaptureReportParams();
            aioCaptureReportParams.f63271d = com.tencent.aelight.camera.ae.camera.ui.simple.d.b(this.f62584f.C().q().f394449f);
            aioCaptureReportParams.f63272e = com.tencent.aelight.camera.ae.camera.ui.simple.d.a(this.f62584f.C().k());
            aioCaptureReportParams.f63273f = z16 ? 2 : 1;
            if (this.mActivity.getIntent() == null) {
                this.mActivity.setIntent(new Intent());
            }
            this.mActivity.getIntent().putExtra("aio_capture_report_params", aioCaptureReportParams);
            ReportController.o(null, "dc00898", "", "", "0X800BFF1", "0X800BFF1", aioCaptureReportParams.f63271d, 0, "", String.valueOf(aioCaptureReportParams.f63273f), String.valueOf(aioCaptureReportParams.f63272e), "");
        }
    }

    private boolean Q() {
        return (this.f62584f.C() == null || this.f62584f.C().n() == -1) ? false : true;
    }

    private boolean R() {
        return (this.f62584f.C() == null || this.f62584f.C().r() == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int i3;
        if (this.S) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1n);
        ViewStub viewStub2 = (ViewStub) this.mRootView.findViewById(R.id.s1j);
        ViewStub viewStub3 = (ViewStub) this.mRootView.findViewById(R.id.s1k);
        ViewStub viewStub4 = (ViewStub) this.mRootView.findViewById(R.id.s1l);
        ViewStub viewStub5 = (ViewStub) this.mRootView.findViewById(R.id.s1m);
        ViewStub viewStub6 = (ViewStub) this.mRootView.findViewById(R.id.s1i);
        viewStub.inflate();
        viewStub2.inflate();
        viewStub3.inflate();
        viewStub4.inflate();
        viewStub5.inflate();
        viewStub6.inflate();
        this.F = (ImageView) this.mRootView.findViewById(R.id.f163716rm3);
        if (com.tencent.aelight.camera.ae.util.i.b()) {
            this.F.setImageResource(R.drawable.ixr);
        }
        this.G = this.mRootView.findViewById(R.id.rq_);
        View findViewById = this.mRootView.findViewById(R.id.rq6);
        this.H = findViewById;
        findViewById.setOnTouchListener(new b());
        View findViewById2 = this.mRootView.findViewById(R.id.rq7);
        this.I = findViewById2;
        findViewById2.setOnTouchListener(new c());
        View findViewById3 = this.mRootView.findViewById(R.id.rq8);
        this.J = findViewById3;
        findViewById3.setOnTouchListener(new d());
        View findViewById4 = this.mRootView.findViewById(R.id.rq5);
        this.K = findViewById4;
        findViewById4.setOnTouchListener(new e());
        if (this.V) {
            i3 = this.mActivity.getResources().getColor(com.tencent.aelight.camera.ae.util.i.a() ? R.color.f9028j : R.color.f9048l);
        } else {
            i3 = com.tencent.aelight.camera.ae.util.i.b() ? -16777216 : -1;
        }
        this.J.setBackgroundColor(i3);
        this.K.setBackgroundColor(i3);
        this.H.setBackgroundColor(i3);
        this.I.setBackgroundColor(i3);
        this.S = true;
    }

    private void T(Object[] objArr) {
        com.tencent.aelight.camera.ae.a C = this.f62584f.C();
        ms.a.f("VideoStoryCapturePart", "enterPhotoEditByConfig:  editType = " + C.n() + " args = " + objArr);
        int n3 = C.n();
        if (n3 == -2) {
            ms.a.f("VideoStoryCapturePart", "enterPhotoEditByConfig: no need edit");
            c0((AEPhotoCaptureResult) objArr[0]);
            return;
        }
        if (n3 == -1) {
            ms.a.c("VideoStoryCapturePart", "\u3010onPhotoEnd\u3011editType undefined");
            return;
        }
        if (n3 == 0) {
            k0(objArr);
            v0(false);
            return;
        }
        if (n3 == 1) {
            n0(objArr);
            v0(false);
        } else if (n3 == 2) {
            o0(objArr);
            v0(false);
        } else {
            if (n3 != 3) {
                return;
            }
            m0(objArr);
            v0(false);
        }
    }

    private void U(Object[] objArr) {
        Intent intent = this.mActivity.getIntent();
        if (gq.a.j(intent)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enterPhotoEditByEntry:  isFromARCake args = ");
            sb5.append(objArr != null ? objArr.length : 0);
            ms.a.f("VideoStoryCapturePart", sb5.toString());
            n0(objArr);
            v0(false);
            return;
        }
        if (gq.a.l(intent)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("enterPhotoEditByEntry:  fromAIO args = ");
            sb6.append(objArr != null ? objArr.length : 0);
            ms.a.f("VideoStoryCapturePart", sb6.toString());
            n0(objArr);
            v0(false);
            return;
        }
        if (gq.a.r(intent)) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("enterPhotoEditByEntry:  fromCircle args = ");
            sb7.append(objArr != null ? objArr.length : 0);
            ms.a.f("VideoStoryCapturePart", sb7.toString());
            k0(objArr);
            v0(false);
            return;
        }
        if (gq.a.i(intent)) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("enterPhotoEditByEntry:  fromAIOWeb args = ");
            sb8.append(objArr != null ? objArr.length : 0);
            ms.a.f("VideoStoryCapturePart", sb8.toString());
            n0(objArr);
            v0(false);
            return;
        }
        if (gq.a.y(intent)) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append("enterPhotoEditByEntry:  fromGuildPtvPanel args = ");
            sb9.append(objArr != null ? objArr.length : 0);
            ms.a.f("VideoStoryCapturePart", sb9.toString());
            n0(objArr);
            v0(false);
            return;
        }
        if (!gq.a.p(intent) && gq.a.S(intent)) {
            if (!gq.a.C(intent) && !gq.a.H(intent)) {
                ms.a.c("VideoStoryCapturePart", "\u3010enterPhotoEditByEntry\u3011: wrong entry: " + gq.a.a(intent));
                intent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", 1);
                o0(objArr);
                v0(false);
                return;
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append("enterPhotoEditByEntry:  isFromQudongTakeFace args = ");
            sb10.append(objArr != null ? objArr.length : 0);
            ms.a.f("VideoStoryCapturePart", sb10.toString());
            m0(objArr);
            v0(false);
            return;
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append("enterPhotoEditByEntry:  isFromCheckEntry args = ");
        sb11.append(objArr != null ? objArr.length : 0);
        ms.a.f("VideoStoryCapturePart", sb11.toString());
        o0(objArr);
        v0(false);
    }

    private void V(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo, Integer num, or.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        int r16 = this.f62584f.C().r();
        if (r16 == 4) {
            l0(aEVideoCaptureResult, localMediaInfo);
        } else if (r16 == -2) {
            ms.a.f("VideoStoryCapturePart", "enterVideoEditByConfig---no need edit");
            d0(aEVideoCaptureResult, aVar, localMediaInfo);
        } else {
            p0(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        }
    }

    private void W(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo, Integer num, or.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        if (num.intValue() == 13) {
            l0(aEVideoCaptureResult, localMediaInfo);
        } else {
            p0(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        }
    }

    private static EditVideoParams X(Activity activity, LocalMediaInfo localMediaInfo, or.c cVar, int i3, Bundle bundle, EditVideoParams.EditSource editSource, int i16) {
        EditVideoParams editVideoParams = new EditVideoParams(i16, i3, editSource, bundle);
        if (cVar != null) {
            editVideoParams.f204056e = cVar.f423434g;
        }
        editVideoParams.D = activity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        editVideoParams.f204058h.putBoolean("enable_hw_encode", true);
        if (ms.a.g()) {
            ms.a.a("VideoStoryCapturePart", "EditVideoParams params:" + editVideoParams.toString());
        }
        long longExtra = activity.getIntent().getLongExtra("troop_uin", 0L);
        if (longExtra != 0) {
            editVideoParams.f204058h.putLong("troop_uin", longExtra);
        }
        return editVideoParams;
    }

    private int Y() {
        int d16 = com.tencent.aelight.camera.ae.util.h.d();
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.f13119a);
        int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.f13189h);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.mActivity);
        if (d16 == 1) {
            return dimensionPixelSize + statusBarHeight + dimensionPixelSize2;
        }
        if (d16 == 2) {
            return dimensionPixelSize;
        }
        return 0;
    }

    private int Z() {
        js.a aVar = js.a.A;
        int b16 = aVar.b();
        if (this.mActivity.getIntent() == null) {
            return b16;
        }
        int intExtra = this.mActivity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        return intExtra == js.a.D.b() ? js.a.C.b() : intExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a0() {
        int d16 = com.tencent.aelight.camera.ae.util.h.d();
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.f13189h);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.mActivity);
        if (d16 == 1) {
            return dimensionPixelSize + statusBarHeight;
        }
        return 0;
    }

    private SimpleObserver<fs.b> b0(final int i3) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        return new SimpleObserver<fs.b>() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.11
            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(fs.b bVar) {
                ms.a.f("VideoStoryCapturePart", "generate observer --- onNext");
                VideoStoryCapturePart.this.e0(bVar, i3);
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onCancel() {
                ms.a.f("VideoStoryCapturePart", "generate observer --- onCancel");
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onComplete() {
                ms.a.f("VideoStoryCapturePart", "generate observer --- onComplete");
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onError(Error error) {
                ms.a.d("VideoStoryCapturePart", "generate observer --- onError", error);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoStoryCapturePart.this.v0(false);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(fs.b bVar, int i3) {
        int i16;
        int i17;
        Activity activity = this.mActivity;
        if (activity != null) {
            ms.a.a("VideoStoryCapturePart", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            PublishParam publishParam = bVar.f400396m;
            ms.a.a("VideoStoryCapturePart", "publishParam = " + publishParam);
            Intent intent = activity.getIntent();
            if (intent != null) {
                i16 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
                i17 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
            } else {
                i16 = 0;
                i17 = 0;
            }
            Intent E0 = SaveVideoActivity.E0(activity, publishParam.f69066d, i17, i16, i3);
            int intExtra = intent != null ? intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()) : 0;
            E0.putExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, true);
            E0.putExtra(ShortVideoConstants.VIDEO_EDIT_FLAG, publishParam.H != 0);
            E0.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, publishParam.f69067e);
            E0.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, intExtra);
            if (intent != null) {
                E0.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
                String stringExtra = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
                ms.a.f("VideoStoryCapturePart", "start SaveVideoActivity---takeSameName=" + stringExtra);
                E0.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra);
                E0.putExtra("qqstory_slide_show_scene", intent.getIntExtra("qqstory_slide_show_scene", -1));
            }
            activity.startActivityForResult(E0, 1026);
        }
    }

    private void g0() {
        if (Build.VERSION.SDK_INT < 29) {
            v0(true);
        }
    }

    private void initViewModel() {
        this.f62582d = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f62584f).get(com.tencent.aelight.camera.ae.mode.c.class);
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) n.a(this.f62584f).get(AEVideoStoryTopBarViewModel.class);
        this.f62583e = aEVideoStoryTopBarViewModel;
        this.T = aEVideoStoryTopBarViewModel.f63374m.getValue();
        this.f62583e.P1().observe(this.f62584f, new f());
        this.f62582d.f65622i.observe(this.f62584f, new g());
        this.f62583e.f63374m.observe(this.f62584f, new h());
        this.f62582d.C.postValue(Boolean.valueOf(this.Q));
    }

    private void j0() {
        s0();
        this.E.setCaptureRequest(new AECameraGLSurfaceView.ExtractFrameRequest() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.13
            @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.ExtractFrameRequest
            public void onExtract(final Bitmap bitmap) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                return;
                            }
                            if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                com.tencent.aelight.camera.ae.flashshow.util.i.b(bitmap).compress(Bitmap.CompressFormat.JPEG, (int) ((Long) ((IVSConfigManager) QRoute.api(IVSConfigManager.class)).getValue(IVSConfigManager.SMART_CUT_PIC_QUALITY_AND, 80L)).longValue(), byteArrayOutputStream);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                VideoStoryCapturePart.this.f62586i += byteArray.length;
                                if (VideoStoryCapturePart.this.f62586i > VideoStoryCapturePart.this.D) {
                                    VideoStoryCapturePart.this.f62586i -= byteArray.length;
                                    com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "onExtract", "size to larger");
                                    byteArrayOutputStream.close();
                                    VideoStoryCapturePart.this.E.setCaptureRequest(null);
                                    return;
                                }
                                VideoStoryCapturePart.this.f62585h.add(new FrameVideoHelper.FrameBuffer(byteArray));
                                byteArrayOutputStream.close();
                                return;
                            }
                            ms.a.c("VideoStoryCapturePart", "error bitmap width height.");
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }, 64, null, false);
            }
        });
    }

    private void k0(Object[] objArr) {
        if (objArr != null && objArr.length >= 1) {
            ms.a.f("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
            AEPhotoCaptureResult aEPhotoCaptureResult = (AEPhotoCaptureResult) objArr[0];
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            EditorPicInfo editorPicInfo = new EditorPicInfo();
            Size imageSize = BitmapUtil.getImageSize(aEPhotoCaptureResult.filePath);
            editorPicInfo.picPath = aEPhotoCaptureResult.filePath;
            editorPicInfo.originPicHeight = imageSize.getHeight();
            editorPicInfo.originPicWidth = imageSize.getWidth();
            editorPicInfo.f66186x = 0.0d;
            editorPicInfo.f66187y = 0.0d;
            editorPicInfo.f66184h = 1.0d;
            editorPicInfo.f66185w = 1.0d;
            arrayList.add(editorPicInfo);
            bundle.putSerializable(AEEditorConstants.CLIPPED_PIC_INFOS, arrayList);
            bundle.putBoolean(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, this.mActivity.getIntent().getBooleanExtra(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, true));
            String stringExtra = this.mActivity.getIntent().getStringExtra("material_id");
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString("material_id", stringExtra);
                bundle.putString(AEEditorConstants.MATERIAL_TOPIC, this.mActivity.getIntent().getStringExtra(AEEditorConstants.MATERIAL_TOPIC));
                bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, this.mActivity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME));
                this.mActivity.getIntent().removeExtra("material_id");
                this.mActivity.getIntent().removeExtra(AEEditorConstants.MATERIAL_TOPIC);
                this.mActivity.getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            }
            if (AEMaterialManager.H() != null) {
                String str = AEMaterialManager.H().f69050id;
                if (TextUtils.isEmpty(str)) {
                    str = "none";
                }
                bundle.putString(AEEditorConstants.GUAJIAN_ID, str);
            }
            if (AEMaterialManager.J() != null) {
                String str2 = AEMaterialManager.J().f69050id;
                bundle.putString(AEEditorConstants.WATER_MARK_ID, TextUtils.isEmpty(str2) ? "none" : str2);
            }
            bundle.putInt(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, this.mActivity.getIntent().getIntExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, 0));
            ArrayList arrayList2 = new ArrayList();
            new vp.b().f442129a = editorPicInfo;
            AEAlbumImageModel aEAlbumImageModel = new AEAlbumImageModel(aEPhotoCaptureResult.filePath, editorPicInfo);
            aEAlbumImageModel.setOriginPath(aEPhotoCaptureResult.filePath);
            arrayList2.add(aEAlbumImageModel);
            bundle.putSerializable(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList2);
            this.mActivity.getIntent().removeExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME);
            if (gq.a.B(this.mActivity.getIntent())) {
                Intent intent = new Intent();
                intent.putExtra(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList2);
                this.mActivity.setResult(-1, intent);
                this.mActivity.finish();
                return;
            }
            ar.a.e(this.mActivity, 0, bundle, Z());
            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.U.longValue();
            AEBaseReportParam.U().f().f65712d = AEBaseReportParam.U().X();
            com.tencent.aelight.camera.ae.report.b.b().C(1);
            return;
        }
        ms.a.c("VideoStoryCapturePart", "[openAEEditorWithPhoto]: args must not be null or length < 1!");
    }

    private void l0(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo) {
        ms.a.f("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
        String a16 = com.tencent.aelight.camera.ae.camera.util.b.a(aEVideoCaptureResult.audioDataFilePath, localMediaInfo.path, g.a.b.f65254c + File.separator + System.currentTimeMillis() + ".mp4");
        if (a16 == null) {
            a16 = localMediaInfo.path;
        }
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(a16);
        bundle.putStringArrayList("PhotoConst.SELECTED_PATHS", arrayList);
        ArrayList arrayList2 = new ArrayList();
        AEAlbumVideoModel aEAlbumVideoModel = new AEAlbumVideoModel(a16);
        aEAlbumVideoModel.setOriginPath(a16);
        arrayList2.add(aEAlbumVideoModel);
        bundle.putSerializable(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList2);
        String stringExtra = this.mActivity.getIntent().getStringExtra("material_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString("material_id", stringExtra);
            bundle.putString(AEEditorConstants.MATERIAL_TOPIC, this.mActivity.getIntent().getStringExtra(AEEditorConstants.MATERIAL_TOPIC));
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, this.mActivity.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME));
            this.mActivity.getIntent().removeExtra("material_id");
            this.mActivity.getIntent().removeExtra(AEEditorConstants.MATERIAL_TOPIC);
            this.mActivity.getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        }
        if (AEMaterialManager.H() != null) {
            String str = AEMaterialManager.H().f69050id;
            if (TextUtils.isEmpty(str)) {
                str = "none";
            }
            bundle.putString(AEEditorConstants.GUAJIAN_ID, str);
        }
        if (AEMaterialManager.J() != null) {
            String str2 = AEMaterialManager.J().f69050id;
            bundle.putString(AEEditorConstants.WATER_MARK_ID, TextUtils.isEmpty(str2) ? "none" : str2);
        }
        bundle.putInt(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, this.mActivity.getIntent().getIntExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, 0));
        this.mActivity.getIntent().removeExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME);
        if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || this.mActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ms.a.f("VideoStoryCapturePart", "updateWMProps onGetLocation");
            com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().k(new a());
        }
        ar.a.e(this.mActivity, 1, bundle, Z());
    }

    private void n0(Object[] objArr) {
        if (ms.a.g()) {
            ms.a.a(AECameraConstants.TAG_PHOTO, "in aio photo end.");
        }
        if (objArr != null && objArr.length >= 3) {
            AEPhotoCaptureResult aEPhotoCaptureResult = (AEPhotoCaptureResult) objArr[0];
            or.a aVar = (or.a) objArr[1];
            Integer num = (Integer) objArr[2];
            ms.a.c("VideoStoryCapturePart", "[openPicEditor]: result = " + aEPhotoCaptureResult + " editFrom = " + num + " entranceParams.businessType = " + aVar.f423403c);
            lr.a.i(this.mActivity, aEPhotoCaptureResult, aVar, null, num.intValue());
            return;
        }
        ms.a.c("VideoStoryCapturePart", "[openPicEditor]:args == null or args.length < 3!");
    }

    private void p0(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo, Integer num, or.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        String str;
        String str2;
        String str3;
        ms.a.a("VideoStoryCapturePart", "openVideoEditorWithVideo");
        Bundle extras = this.mActivity.getIntent().getExtras();
        c.a j3 = new c.a().l(aVar.f423403c).j(10);
        if (gq.a.l(this.mActivity.getIntent())) {
            j3.j(0);
        }
        if (gq.a.j(this.mActivity.getIntent())) {
            j3.h(false);
        }
        aVar.f(j3.f());
        this.mActivity.getIntent().putExtra("extra_transiton_src_from", -1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable) this.f62585h);
        bundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.f62586i);
        bundle.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", num.intValue());
        AEMaterialMetaData e16 = com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().e();
        if (e16 != null) {
            str = e16.name;
        } else {
            str = "";
        }
        VideoStoryDataBean videoStoryDataBean = this.N;
        boolean isEmpty = TextUtils.isEmpty(str);
        Object obj = GlobalUtil.DEF_STRING;
        if (isEmpty) {
            str = GlobalUtil.DEF_STRING;
        }
        videoStoryDataBean.setWatermarkId(str);
        VideoStoryDataBean videoStoryDataBean2 = this.N;
        if (qIMFilterCategoryItem == null) {
            str2 = GlobalUtil.DEF_STRING;
        } else {
            str2 = qIMFilterCategoryItem.f66698e;
        }
        videoStoryDataBean2.setFilterId(str2);
        VideoStoryDataBean videoStoryDataBean3 = this.N;
        if (AEMaterialManager.H() == null) {
            str3 = GlobalUtil.DEF_STRING;
        } else {
            str3 = AEMaterialManager.H().f69050id;
        }
        videoStoryDataBean3.setLensId(str3);
        VideoStoryDataBean videoStoryDataBean4 = this.N;
        if (AEMaterialManager.H() != null) {
            obj = Integer.valueOf(AEMaterialManager.H().categoryId);
        }
        videoStoryDataBean4.setLensTabId(String.valueOf(obj));
        bundle.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.N);
        this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
        ms.a.f("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
        lr.a.j(this.mActivity, aEVideoCaptureResult, localMediaInfo, aVar, bundle, this.f62584f.C().h().intValue(), extras);
    }

    private String q0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(AECameraConstants.WIDGETINFO_SEPARATE);
        return indexOf >= 0 ? str.substring(indexOf + 1) : str;
    }

    private void r0(com.tencent.mobileqq.activity.richmedia.i iVar) {
        if (this.T == AEVideoStoryTopBarViewModel.Ratio.FULL) {
            t0(0, iVar);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.width = iVar.f185860a;
        layoutParams.height = iVar.f185861b - x.c(BaseApplication.getContext(), 56.0f);
        layoutParams.topMargin = 0;
        ms.a.f("VideoStoryCapturePart", "adjustRatio lp.height: " + layoutParams.height + ProgressTracer.SEPARATOR + layoutParams.topMargin);
        this.E.setLayoutParams(layoutParams);
        u0(32.0f, this.E);
    }

    private void s0() {
        this.E.setCaptureRequest(null);
        this.f62585h.clear();
        this.f62586i = 0L;
    }

    private void t0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.width = iVar.f185860a;
        layoutParams.height = iVar.f185861b;
        layoutParams.topMargin = i3;
        ms.a.f("VideoStoryCapturePart", "adjustRatio lp.height: " + layoutParams.height + ProgressTracer.SEPARATOR + layoutParams.topMargin);
        this.E.setLayoutParams(layoutParams);
    }

    private void u0(float f16, AECameraGLSurfaceView aECameraGLSurfaceView) {
        aECameraGLSurfaceView.setOutlineProvider(new i(f16));
        aECameraGLSurfaceView.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        z0(i3, iVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.width = iVar.f185860a;
        layoutParams.height = iVar.f185861b;
        layoutParams.topMargin = i3;
        this.E.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        z0(i3, iVar);
        r0(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        z0(i3, new com.tencent.mobileqq.activity.richmedia.i(iVar.f185860a, iVar.f185861b - x.c(BaseApplication.getContext(), 56.0f)));
        r0(iVar);
    }

    private void z0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        ViewAnimator l3;
        long j3 = iVar.f185860a * iVar.f185861b;
        long width = this.E.getWidth() * this.E.getHeight();
        ms.a.a("VideoStoryCapturePart", "smooth2Size---oldArea=" + width + ", newArea=" + j3);
        if (j3 == width) {
            return;
        }
        S();
        this.G.setVisibility(0);
        com.tencent.aelight.camera.ae.camera.ui.animator.a l16 = ViewAnimator.j(this.H, this.I).x(this.H.getWidth(), (int) Math.ceil((this.f62587m - iVar.f185860a) / 2.0d)).d(this.J).l(this.J.getHeight(), i3).d(this.K).l(this.K.getHeight(), (AEDashboardUtil.q() && this.U == AECaptureMode.NORMAL) ? 0 : (this.mRootView.getHeight() - i3) - iVar.f185861b);
        if (j3 > width) {
            l3 = l16.a().l(300L);
        } else {
            l3 = l16.g(1.5f).l(500L);
        }
        l3.o(new bq.d() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.8
            @Override // bq.d
            public void onStop() {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoStoryCapturePart.this.S) {
                            VideoStoryCapturePart.this.G.setVisibility(8);
                        }
                    }
                }, 500L);
            }
        }).r();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public <T> T get(int i3, Object... objArr) {
        return (T) super.get(i3, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        this.V = gq.a.r(this.mActivity.getIntent());
        this.W = gq.a.l(this.mActivity.getIntent());
        int c16 = gq.a.c(this.mActivity.getIntent());
        this.X = gq.a.O(c16);
        this.Y = gq.a.V(c16);
        this.E = (AECameraGLSurfaceView) this.mRootView.findViewById(R.id.rq9);
        this.L = (ViewGroup) this.mRootView.findViewById(R.id.f163754ru1);
        this.f62585h = new CopyOnWriteArrayList();
        this.N = new VideoStoryDataBean();
        this.f62587m = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        this.C = i3;
        if (com.tencent.aelight.camera.aioeditor.shortvideo.util.c.a(this.f62587m, i3)) {
            this.f62587m = (this.C * 9) / 16;
        }
        LiuHaiUtils.initLiuHaiBarHeight(this.mActivity);
        int LiuHaiTopBarHeight = (this.C - (LiuHaiUtils.needShowLiuHaiTopBar() ? LiuHaiUtils.LiuHaiTopBarHeight() : 0)) - 0;
        if (LiuHaiTopBarHeight < x.c(this.mActivity, 700.0f)) {
            this.P = true;
        } else {
            this.P = false;
        }
        if (this.P) {
            if (LiuHaiTopBarHeight < x.c(this.mActivity, 600.0f)) {
                this.R = x.c(this.mActivity, 58.8f);
            } else {
                this.R = x.c(this.mActivity, 147.0f - (((r0 - LiuHaiTopBarHeight) / x.c(this.mActivity, 100.0f)) * 88.2f));
            }
            if (this.R < x.c(this.mActivity, 110.0f)) {
                this.Q = true;
            }
            int c17 = x.c(this.mActivity, LiuHaiUtils.sNotchHeight + 60 + 24);
            if (this.R < c17) {
                this.R = c17;
            }
        }
        initViewModel();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        if (ms.a.g()) {
            ms.a.c("VideoStoryCapturePart", "onDestroy()");
        }
        SendPanelManager.k().onDestroy();
        super.onDestroy();
        v0(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<AECaptureModeChangingEvent> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent == null) {
                ms.a.c("VideoStoryCapturePart", "modeChangingEvent is null, return");
                return;
            }
            AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
            VideoStoryCapturePart.this.U = aECaptureMode;
            Boolean value = VideoStoryCapturePart.this.f62583e.P1().getValue();
            boolean z16 = false;
            if (aECaptureMode == AECaptureMode.GIF) {
                VideoStoryCapturePart.this.S();
                VideoStoryCapturePart.this.F.setVisibility(0);
                AECameraGLSurfaceView aECameraGLSurfaceView = VideoStoryCapturePart.this.E;
                if (value != null && value.booleanValue()) {
                    z16 = true;
                }
                aECameraGLSurfaceView.switchSegment(z16);
                VideoStoryCapturePart.this.E.switchSegmentFollowFace(true);
            } else {
                if (VideoStoryCapturePart.this.S) {
                    VideoStoryCapturePart.this.F.setVisibility(8);
                }
                VideoStoryCapturePart.this.E.switchSegmentFollowFace(false);
            }
            VideoStoryCapturePart.this.N(aECaptureMode);
        }
    }

    private void c0(AEPhotoCaptureResult aEPhotoCaptureResult) {
        v0(false);
        Intent intent = this.mActivity.getIntent();
        if (gq.a.z(intent)) {
            ms.a.f("VideoStoryCapturePart", "handleNoNeedEditPhoto---from playMiniApp");
            Intent intent2 = new Intent();
            intent2.setAction(MiniConst.LaunchCameraPluginConst.BROADCAST_ACTION_CAMERA_BACK_RESULT);
            intent2.putExtra("file_path", aEPhotoCaptureResult.filePath);
            intent2.putExtra("is_video", false);
            HashMap<String, String> K1 = this.f62584f.K1();
            if (K1 == null) {
                K1 = new HashMap<>();
            }
            String stringExtra = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            String q06 = q0(stringExtra);
            ms.a.a("VideoStoryCapturePart", "handleNoNeedEditPhoto---widgetId=" + q06 + ", widgetInfo=" + stringExtra);
            if (!TextUtils.isEmpty(q06)) {
                K1.put(MiniConst.LaunchCameraPluginConst.EXTRA_INFO_KEY_WIDGET_ID, q06);
            }
            intent2.putExtra("extra_info", K1);
            this.f62584f.z().sendBroadcast(intent2);
            this.f62584f.z().setResult(-1, intent2);
            this.f62584f.z().finish();
        }
    }

    private void f0(Object[] objArr) {
        O(false);
        ms.a.f(AECameraConstants.TAG_PHOTO, "in photo end.");
        if (Q()) {
            T(objArr);
        } else {
            U(objArr);
        }
    }

    private void i0(Object[] objArr) {
        O(true);
        if (objArr == null || objArr.length != 5) {
            return;
        }
        AEVideoCaptureResult aEVideoCaptureResult = (AEVideoCaptureResult) objArr[0];
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) objArr[1];
        Integer num = (Integer) objArr[2];
        or.a aVar = (or.a) objArr[3];
        QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) objArr[4];
        if (R()) {
            V(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        } else {
            W(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        }
        s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null || VideoStoryCapturePart.this.E == null || VideoStoryCapturePart.this.U != AECaptureMode.GIF) {
                return;
            }
            ms.a.a("VideoStoryCapturePart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011->observe:" + bool);
            VideoStoryCapturePart.this.E.switchSegment(bool.booleanValue());
        }
    }

    private void m0(Object[] objArr) {
        if (objArr != null && objArr.length >= 1) {
            int a16 = gq.a.a(this.mActivity.getIntent());
            AEPhotoCaptureResult aEPhotoCaptureResult = (AEPhotoCaptureResult) objArr[0];
            Intent intent = new Intent();
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, a16);
            intent.putExtra(AETakeFacePhotoPreviewFragment.INTENT_KEY_PHOTO_PATH, aEPhotoCaptureResult.filePath);
            intent.putExtra(AECameraConstants.KEY_DISABLE_FACE_DETECT, this.mActivity.getIntent().getBooleanExtra(AECameraConstants.KEY_DISABLE_FACE_DETECT, false));
            intent.putExtra(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, this.mActivity.getIntent().getBooleanExtra(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, false));
            AETakeFacePhotoPreviewFragment.jumpToMeForResult(this.mActivity, intent, a16 == js.a.L.b() ? 1028 : 1024);
            return;
        }
        ms.a.c("VideoStoryCapturePart", "[openPhotoPreview] args must not be null or length < 1!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(boolean z16) {
        if (z16) {
            Activity activity = this.mActivity;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (this.M == null) {
                ReportDialog reportDialog = new ReportDialog(this.mActivity, R.style.qZoneInputDialog);
                this.M = reportDialog;
                reportDialog.setCancelable(false);
                this.M.setCanceledOnTouchOutside(false);
                this.M.setContentView(R.layout.f168383uh);
            }
            ss.a.a(this.M);
            return;
        }
        Dialog dialog = this.M;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.M.dismiss();
    }

    private void d0(AEVideoCaptureResult aEVideoCaptureResult, or.a aVar, LocalMediaInfo localMediaInfo) {
        ms.a.f("VideoStoryCapturePart", "handleNoNeedEditVideo---");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.10
            @Override // java.lang.Runnable
            public void run() {
                VideoStoryCapturePart.this.v0(true);
            }
        });
        EditTakeVideoSource editTakeVideoSource = new EditTakeVideoSource(aEVideoCaptureResult.videoMp4FilePath, aEVideoCaptureResult.audioDataFilePath, localMediaInfo);
        Bundle bundle = new Bundle();
        int a16 = aVar.a();
        EditVideoParams X = X(this.mActivity, localMediaInfo, null, 0, bundle, editTakeVideoSource, a16);
        EditVideoParams.EditSource editSource = X.f204059i;
        int width = editTakeVideoSource.getWidth();
        int height = editTakeVideoSource.getHeight();
        Stream.of(P(editSource, width, height, editTakeVideoSource.getSourcePath(), (width * 1.0f) / height, editTakeVideoSource.f204052e.rotation, "", false, X.m("extra_upload_temp_directory"), X)).map(new ThreadOffFunction("VideoStoryCapturePart", 2)).map(new com.tencent.aelight.camera.ae.camera.ui.capture.a()).map(new t(X)).subscribe(b0(a16));
    }

    private fs.b P(EditVideoParams.EditSource editSource, int i3, int i16, String str, float f16, int i17, String str2, boolean z16, String str3, EditVideoParams editVideoParams) {
        fs.b bVar = new fs.b(editVideoParams);
        bVar.f400387d.videoMaxrate = CodecParam.mMaxrate;
        if (com.tencent.aelight.camera.ae.util.n.l()) {
            bVar.f400387d.videoMaxrate = com.tencent.aelight.camera.ae.util.n.e() * 1000;
            bVar.f400387d.putExtra("composite_key_bitrate_mode", Boolean.valueOf(com.tencent.aelight.camera.ae.util.n.l()));
        }
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.videoMinrate = CodecParam.mMinrate;
        publishVideoEntry.videoUploadGroupTempDir = str3;
        bVar.f400399p = s.b(editVideoParams.f204055d);
        bVar.f400392i = new fs.i(this.mActivity, i3, i16, str, f16, false, i17, 0.0d, 0.0d, str2, z16);
        if (!(editSource instanceof EditTakeVideoSource) && !(editSource instanceof EditLocalVideoSource)) {
            bVar.f400387d.putExtra("is_hw_encode", Boolean.FALSE);
        } else {
            bVar.f400387d.putExtra("is_hw_encode", Boolean.TRUE);
        }
        bVar.f400387d.putExtra("thumb_rotation", Integer.valueOf(i17));
        String m3 = bVar.f400384a.m("extra_text_filter_text");
        if (!TextUtils.isEmpty(m3)) {
            if (TextUtils.isEmpty(bVar.f400387d.videoDoodleDescription)) {
                bVar.f400387d.videoDoodleDescription = m3;
            } else {
                StringBuilder sb5 = new StringBuilder();
                PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
                sb5.append(publishVideoEntry2.videoDoodleDescription);
                sb5.append(m3);
                publishVideoEntry2.videoDoodleDescription = sb5.toString();
            }
        }
        return bVar;
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 262145:
                j0();
                return;
            case 262146:
                i0(objArr);
                return;
            case 262147:
                g0();
                return;
            case 262148:
                f0(objArr);
                return;
            case 262149:
                v0(false);
                return;
            default:
                return;
        }
    }

    private void o0(Object[] objArr) {
        if (objArr != null && objArr.length >= 3) {
            AEPhotoCaptureResult aEPhotoCaptureResult = (AEPhotoCaptureResult) objArr[0];
            Integer num = (Integer) objArr[1];
            Integer num2 = (Integer) objArr[2];
            if (ms.a.g()) {
                ms.a.a(AECameraConstants.TAG_PHOTO, "in normal photo end.");
            }
            Bundle bundle = new Bundle();
            bundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", aEPhotoCaptureResult.filePath);
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.mMimeType = "pic";
            this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
            QQStoryFlowCallback.f(this.mActivity, aEPhotoCaptureResult.filePath, localMediaInfo, 0, (int) localMediaInfo.mDuration, -1, 10023, 0, null, null, false, num.intValue(), num2.intValue(), bundle);
            return;
        }
        ms.a.c("VideoStoryCapturePart", "\u3010openVideoEditorWithPhoto\u3011args is null or args.length is less than 3");
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 1026 || i3 == 1028) {
            ms.a.f("VideoStoryCapturePart", "onActivityResult--REQUEST_CODE_SKIP_EDIT_SAVE_VIDEO--resultCode=" + i16);
            v0(false);
            if (i16 == -1) {
                Intent intent2 = this.mActivity.getIntent();
                if (gq.a.z(intent2)) {
                    ms.a.f("VideoStoryCapturePart", "onActivityResult---success--from playMiniApp");
                    Intent intent3 = new Intent();
                    intent3.setAction(MiniConst.LaunchCameraPluginConst.BROADCAST_ACTION_CAMERA_BACK_RESULT);
                    if (i3 == 1026) {
                        String stringExtra = intent.getStringExtra("key_video_save_path");
                        String stringExtra2 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
                        intent3.putExtra("file_path", stringExtra);
                        intent3.putExtra(MiniConst.LaunchCameraPluginConst.THUMB_PATH, stringExtra2);
                        intent3.putExtra("is_video", true);
                    } else {
                        intent3.putExtra("file_path", intent.getStringExtra(AECameraConstants.INTENT_RESULT_KEY_TAKE_PHOTO_PATH));
                        intent3.putExtra("is_video", false);
                    }
                    HashMap<String, String> K1 = this.f62584f.K1();
                    if (K1 == null) {
                        K1 = new HashMap<>();
                    }
                    String stringExtra3 = intent2.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
                    String q06 = q0(stringExtra3);
                    ms.a.a("VideoStoryCapturePart", "handleNoNeedEditVideo---widgetId=" + q06 + ", widgetInfo=" + stringExtra3);
                    if (!TextUtils.isEmpty(q06)) {
                        K1.put(MiniConst.LaunchCameraPluginConst.EXTRA_INFO_KEY_WIDGET_ID, q06);
                    }
                    intent3.putExtra("extra_info", K1);
                    this.mActivity.sendBroadcast(intent3);
                    this.mActivity.setResult(-1, intent3);
                    this.mActivity.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements b.c {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.b.c
        public void onGetWatermarkDict(Map<String, String> map) {
        }
    }
}
