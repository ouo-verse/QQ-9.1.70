package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
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
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.camera.ui.animator.ViewAnimator;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.watermark.b;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.g;
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
public class AEFlashshowCapturePart extends lq.a {

    /* renamed from: e0, reason: collision with root package name */
    public static int f64602e0;
    private AEVideoStoryTopBarViewModel C;
    private LSMiddleCameraUnit D;
    List<FrameVideoHelper.FrameBuffer> E;
    private long F;
    private int G;
    private int H;
    private long I;
    private LSCameraGLSurfaceView J;
    private ImageView K;
    private View L;
    private View M;
    private View N;
    private View P;
    private View Q;
    private ViewGroup R;
    private Dialog S;
    private VideoStoryDataBean T;
    private boolean U;
    private boolean V;
    private int W;
    private boolean X;
    private AEVideoStoryTopBarViewModel.Ratio Y;
    private LSCaptureMode Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f64603a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f64604b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f64605c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f64606d0;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.mode.a f64607m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AEFlashshowCapturePart.this.J == null || AEFlashshowCapturePart.this.M == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, AEFlashshowCapturePart.this.M, AEFlashshowCapturePart.this.J);
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
            if (AEFlashshowCapturePart.this.J == null || AEFlashshowCapturePart.this.N == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, AEFlashshowCapturePart.this.N, AEFlashshowCapturePart.this.J);
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
            if (AEFlashshowCapturePart.this.J == null || AEFlashshowCapturePart.this.P == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, AEFlashshowCapturePart.this.P, AEFlashshowCapturePart.this.J);
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
            if (AEFlashshowCapturePart.this.J == null || AEFlashshowCapturePart.this.Q == null) {
                return true;
            }
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, false, AEFlashshowCapturePart.this.Q, AEFlashshowCapturePart.this.J);
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
            ms.a.f("AEFlashshowCapturePart", "mCurrentRatio---onChanged: ratio=" + ratio);
            if (ratio == null || AEFlashshowCapturePart.this.Y == ratio) {
                return;
            }
            AEFlashshowCapturePart.this.Y = ratio;
            int i3 = ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1 ? AEFlashshowCapturePart.f64602e0 : 0;
            com.tencent.mobileqq.activity.richmedia.i a16 = com.tencent.aelight.camera.ae.flashshow.util.l.a();
            com.tencent.mobileqq.activity.richmedia.i c16 = com.tencent.aelight.camera.ae.flashshow.util.l.c(AEFlashshowCapturePart.this.Z, a16, false, ratio);
            ms.a.f("AEFlashshowCapturePart", "mCurrentRatio---mCaptureMode" + AEFlashshowCapturePart.this.Z);
            if (AEFlashshowCapturePart.this.Z == LSCaptureMode.NORMAL) {
                AEFlashshowCapturePart.this.n0(i3, a16);
            } else {
                AEFlashshowCapturePart.this.m0(i3, c16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f64625a;

        i(float f16) {
            this.f64625a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f64625a);
        }
    }

    public AEFlashshowCapturePart(Activity activity, View view, lq.b bVar) {
        super(activity, view, bVar);
        this.F = 0L;
        this.I = ((Long) ((IVSConfigManager) QRoute.api(IVSConfigManager.class)).getValue(IVSConfigManager.SMART_CUT_PIC_MAX_BYTE, 90000L)).longValue();
        this.U = false;
        this.V = false;
        this.W = 0;
        this.X = false;
        this.Z = null;
        this.f64606d0 = false;
        this.D = (LSMiddleCameraUnit) bVar.b(65537, new Object[0]);
        this.T = new VideoStoryDataBean();
        f64602e0 = ViewUtils.dip2px(60.0f) + ImmersiveUtils.getStatusBarHeight(activity);
    }

    private boolean I() {
        return (this.D.D() == null || this.D.D().p() == -1) ? false : true;
    }

    private boolean J() {
        return (this.D.D() == null || this.D.D().s() == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.X) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.f415376e.findViewById(R.id.s1n);
        ViewStub viewStub2 = (ViewStub) this.f415376e.findViewById(R.id.s1j);
        ViewStub viewStub3 = (ViewStub) this.f415376e.findViewById(R.id.s1k);
        ViewStub viewStub4 = (ViewStub) this.f415376e.findViewById(R.id.s1l);
        ViewStub viewStub5 = (ViewStub) this.f415376e.findViewById(R.id.s1m);
        ViewStub viewStub6 = (ViewStub) this.f415376e.findViewById(R.id.s1i);
        viewStub.inflate();
        viewStub2.inflate();
        viewStub3.inflate();
        viewStub4.inflate();
        viewStub5.inflate();
        viewStub6.inflate();
        this.K = (ImageView) this.f415376e.findViewById(R.id.f163716rm3);
        this.L = this.f415376e.findViewById(R.id.rq_);
        View findViewById = this.f415376e.findViewById(R.id.rq6);
        this.M = findViewById;
        findViewById.setOnTouchListener(new b());
        View findViewById2 = this.f415376e.findViewById(R.id.rq7);
        this.N = findViewById2;
        findViewById2.setOnTouchListener(new c());
        View findViewById3 = this.f415376e.findViewById(R.id.rq8);
        this.P = findViewById3;
        findViewById3.setOnTouchListener(new d());
        View findViewById4 = this.f415376e.findViewById(R.id.rq5);
        this.Q = findViewById4;
        findViewById4.setOnTouchListener(new e());
        this.X = true;
    }

    private void L(Object[] objArr) {
        com.tencent.aelight.camera.ae.flashshow.ac D = this.D.D();
        ms.a.f("AEFlashshowCapturePart", "enterPhotoEditByConfig:  editType = " + D.p() + " args = " + objArr);
        int p16 = D.p();
        if (p16 == -2) {
            ms.a.f("AEFlashshowCapturePart", "enterPhotoEditByConfig: no need edit");
            R((AEPhotoCaptureResult) objArr[0]);
            return;
        }
        if (p16 == -1) {
            ms.a.c("AEFlashshowCapturePart", "\u3010onPhotoEnd\u3011editType undefined");
            return;
        }
        if (p16 == 0) {
            Z(objArr);
            l0(false);
            return;
        }
        if (p16 == 1) {
            c0(objArr);
            l0(false);
        } else if (p16 == 2) {
            d0(objArr);
            l0(false);
        } else {
            if (p16 != 3) {
                return;
            }
            b0(objArr);
            l0(false);
        }
    }

    private void M(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo, Integer num, or.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        int s16 = this.D.D().s();
        if (s16 == 4) {
            a0(aEVideoCaptureResult, localMediaInfo);
        } else if (s16 == -2) {
            ms.a.f("AEFlashshowCapturePart", "enterVideoEditByConfig---no need edit");
            S(aEVideoCaptureResult, aVar, localMediaInfo);
        } else {
            e0(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        }
    }

    private void N(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo, Integer num, or.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        if (num.intValue() == 13) {
            a0(aEVideoCaptureResult, localMediaInfo);
        } else {
            e0(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        }
    }

    private static EditVideoParams O(Activity activity, LocalMediaInfo localMediaInfo, or.c cVar, int i3, Bundle bundle, EditVideoParams.EditSource editSource, int i16) {
        EditVideoParams editVideoParams = new EditVideoParams(i16, i3, editSource, bundle);
        if (cVar != null) {
            editVideoParams.f204056e = cVar.f423434g;
        }
        editVideoParams.D = activity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        editVideoParams.f204058h.putBoolean("enable_hw_encode", true);
        if (ms.a.g()) {
            ms.a.a("AEFlashshowCapturePart", "EditVideoParams params:" + editVideoParams.toString());
        }
        long longExtra = activity.getIntent().getLongExtra("troop_uin", 0L);
        if (longExtra != 0) {
            editVideoParams.f204058h.putLong("troop_uin", longExtra);
        }
        return editVideoParams;
    }

    private int P() {
        js.a aVar = js.a.A;
        int b16 = aVar.b();
        if (this.f415377f.getIntent() == null) {
            return b16;
        }
        int intExtra = this.f415377f.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        return intExtra == js.a.D.b() ? js.a.C.b() : intExtra;
    }

    private SimpleObserver<fs.b> Q(final int i3) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        return new SimpleObserver<fs.b>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.11
            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(fs.b bVar) {
                ms.a.f("AEFlashshowCapturePart", "generate observer --- onNext");
                AEFlashshowCapturePart.this.U(bVar, i3);
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onCancel() {
                ms.a.f("AEFlashshowCapturePart", "generate observer --- onCancel");
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onComplete() {
                ms.a.f("AEFlashshowCapturePart", "generate observer --- onComplete");
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onError(Error error) {
                ms.a.d("AEFlashshowCapturePart", "generate observer --- onError", error);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEFlashshowCapturePart.this.l0(false);
                    }
                });
            }
        };
    }

    private void T() {
        this.f64607m = (com.tencent.aelight.camera.ae.flashshow.mode.a) com.tencent.aelight.camera.ae.flashshow.ay.a(this.D).get(com.tencent.aelight.camera.ae.flashshow.mode.a.class);
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this.D).get(AEVideoStoryTopBarViewModel.class);
        this.C = aEVideoStoryTopBarViewModel;
        this.Y = aEVideoStoryTopBarViewModel.f63374m.getValue();
        this.C.P1().observe(this.D, new f());
        this.f64607m.f64352i.observe(this.D, new g());
        this.C.f63374m.observe(this.D, new h());
        this.f64607m.C.postValue(Boolean.valueOf(this.V));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(fs.b bVar, int i3) {
        int i16;
        int i17;
        Activity activity = this.f415377f;
        if (activity != null) {
            ms.a.a("AEFlashshowCapturePart", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            PublishParam publishParam = bVar.f400396m;
            ms.a.a("AEFlashshowCapturePart", "publishParam = " + publishParam);
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
                ms.a.f("AEFlashshowCapturePart", "start SaveVideoActivity---takeSameName=" + stringExtra);
                E0.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra);
                E0.putExtra("qqstory_slide_show_scene", intent.getIntExtra("qqstory_slide_show_scene", -1));
            }
            activity.startActivityForResult(E0, 1026);
        }
    }

    private void V(Object[] objArr) {
        ms.a.f(AECameraConstants.TAG_PHOTO, "in photo end.");
        if (I()) {
            L(objArr);
        }
    }

    private void Y() {
        i0();
        this.J.setCaptureRequest(new LSCameraGLSurfaceView.z() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.13
            @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.z
            public void onExtract(final Bitmap bitmap) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.13.1
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
                                AEFlashshowCapturePart.this.F += byteArray.length;
                                if (AEFlashshowCapturePart.this.F > AEFlashshowCapturePart.this.I) {
                                    AEFlashshowCapturePart.this.F -= byteArray.length;
                                    com.tencent.mobileqq.pic.f.c("Q.videostory", "Q.videostory.capture", "onExtract", "size to larger");
                                    byteArrayOutputStream.close();
                                    AEFlashshowCapturePart.this.J.setCaptureRequest(null);
                                    return;
                                }
                                AEFlashshowCapturePart.this.E.add(new FrameVideoHelper.FrameBuffer(byteArray));
                                byteArrayOutputStream.close();
                                return;
                            }
                            ms.a.c("AEFlashshowCapturePart", "error bitmap width height.");
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }, 64, null, false);
            }
        });
    }

    private void Z(Object[] objArr) {
        if (objArr != null && objArr.length >= 1) {
            ms.a.f("AEFlashshowCapturePart", "[PhotoEnd] ready to enter EditorActivity");
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
            bundle.putBoolean(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, this.f415377f.getIntent().getBooleanExtra(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, true));
            String stringExtra = this.f415377f.getIntent().getStringExtra("material_id");
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString("material_id", stringExtra);
                bundle.putString(AEEditorConstants.MATERIAL_TOPIC, this.f415377f.getIntent().getStringExtra(AEEditorConstants.MATERIAL_TOPIC));
                bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, this.f415377f.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME));
                this.f415377f.getIntent().removeExtra("material_id");
                this.f415377f.getIntent().removeExtra(AEEditorConstants.MATERIAL_TOPIC);
                this.f415377f.getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
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
            bundle.putInt(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, this.f415377f.getIntent().getIntExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, 0));
            ArrayList arrayList2 = new ArrayList();
            new vp.b().f442129a = editorPicInfo;
            AEAlbumImageModel aEAlbumImageModel = new AEAlbumImageModel(aEPhotoCaptureResult.filePath, editorPicInfo);
            aEAlbumImageModel.setOriginPath(aEPhotoCaptureResult.filePath);
            arrayList2.add(aEAlbumImageModel);
            bundle.putSerializable(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList2);
            this.f415377f.getIntent().removeExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME);
            if (gq.a.B(this.f415377f.getIntent())) {
                Intent intent = new Intent();
                intent.putExtra(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, arrayList2);
                this.f415377f.setResult(-1, intent);
                this.f415377f.finish();
                return;
            }
            ar.a.e(this.f415377f, 0, bundle, P());
            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.U.longValue();
            AEBaseReportParam.U().f().f65712d = AEBaseReportParam.U().X();
            com.tencent.aelight.camera.ae.report.b.b().C(1);
            return;
        }
        ms.a.c("AEFlashshowCapturePart", "[openAEEditorWithPhoto]: args must not be null or length < 1!");
    }

    private void a0(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo) {
        ms.a.f("AEFlashshowCapturePart", "[VideoEnd] ready to enter EditorActivity");
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
        String stringExtra = this.f415377f.getIntent().getStringExtra("material_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString("material_id", stringExtra);
            bundle.putString(AEEditorConstants.MATERIAL_TOPIC, this.f415377f.getIntent().getStringExtra(AEEditorConstants.MATERIAL_TOPIC));
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, this.f415377f.getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME));
            this.f415377f.getIntent().removeExtra("material_id");
            this.f415377f.getIntent().removeExtra(AEEditorConstants.MATERIAL_TOPIC);
            this.f415377f.getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
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
        bundle.putInt(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, this.f415377f.getIntent().getIntExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, 0));
        this.f415377f.getIntent().removeExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME);
        if (this.f415377f.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || this.f415377f.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ms.a.f("AEFlashshowCapturePart", "updateWMProps onGetLocation");
            com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().k(new a());
        }
        ar.a.e(this.f415377f, 1, bundle, P());
    }

    private void c0(Object[] objArr) {
        if (ms.a.g()) {
            ms.a.a(AECameraConstants.TAG_PHOTO, "in aio photo end.");
        }
        if (objArr != null && objArr.length >= 3) {
            AEPhotoCaptureResult aEPhotoCaptureResult = (AEPhotoCaptureResult) objArr[0];
            or.a aVar = (or.a) objArr[1];
            Integer num = (Integer) objArr[2];
            ms.a.c("AEFlashshowCapturePart", "[openPicEditor]: result = " + aEPhotoCaptureResult + " editFrom = " + num + " entranceParams.businessType = " + aVar.f423403c);
            lr.a.i(this.f415377f, aEPhotoCaptureResult, aVar, null, num.intValue());
            return;
        }
        ms.a.c("AEFlashshowCapturePart", "[openPicEditor]:args == null or args.length < 3!");
    }

    private void e0(AEVideoCaptureResult aEVideoCaptureResult, LocalMediaInfo localMediaInfo, Integer num, or.a aVar, QIMFilterCategoryItem qIMFilterCategoryItem) {
        String str;
        String str2;
        String str3;
        ms.a.a("AEFlashshowCapturePart", "openVideoEditorWithVideo");
        Bundle extras = this.f415377f.getIntent().getExtras();
        c.a j3 = new c.a().l(aVar.f423403c).j(10);
        if (gq.a.l(this.f415377f.getIntent())) {
            j3.j(0);
        }
        if (gq.a.j(this.f415377f.getIntent())) {
            j3.h(false);
        }
        aVar.f(j3.f());
        this.f415377f.getIntent().putExtra("extra_transiton_src_from", -1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable) this.E);
        bundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.F);
        bundle.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", num.intValue());
        AEMaterialMetaData e16 = com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().e();
        if (e16 != null) {
            str = e16.name;
        } else {
            str = "";
        }
        VideoStoryDataBean videoStoryDataBean = this.T;
        boolean isEmpty = TextUtils.isEmpty(str);
        Object obj = GlobalUtil.DEF_STRING;
        if (isEmpty) {
            str = GlobalUtil.DEF_STRING;
        }
        videoStoryDataBean.setWatermarkId(str);
        VideoStoryDataBean videoStoryDataBean2 = this.T;
        if (qIMFilterCategoryItem == null) {
            str2 = GlobalUtil.DEF_STRING;
        } else {
            str2 = qIMFilterCategoryItem.f66698e;
        }
        videoStoryDataBean2.setFilterId(str2);
        VideoStoryDataBean videoStoryDataBean3 = this.T;
        if (AEMaterialManager.H() == null) {
            str3 = GlobalUtil.DEF_STRING;
        } else {
            str3 = AEMaterialManager.H().f69050id;
        }
        videoStoryDataBean3.setLensId(str3);
        VideoStoryDataBean videoStoryDataBean4 = this.T;
        if (AEMaterialManager.H() != null) {
            obj = Integer.valueOf(AEMaterialManager.H().categoryId);
        }
        videoStoryDataBean4.setLensTabId(String.valueOf(obj));
        bundle.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.T);
        this.f415377f.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
        ms.a.f("AEFlashshowCapturePart", "[VideoEnd] jumpToEditVideoActivity");
        lr.a.j(this.f415377f, aEVideoCaptureResult, localMediaInfo, aVar, bundle, this.D.D().i().intValue(), extras);
    }

    private String f0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(AECameraConstants.WIDGETINFO_SEPARATE);
        return indexOf >= 0 ? str.substring(indexOf + 1) : str;
    }

    private void g0(com.tencent.mobileqq.activity.richmedia.i iVar) {
        if (this.Y == AEVideoStoryTopBarViewModel.Ratio.FULL) {
            j0(0, iVar);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.width = iVar.f185860a;
        layoutParams.height = iVar.f185861b;
        layoutParams.topMargin = 0;
        ms.a.f("AEFlashshowCapturePart", "adjustRatio lp.height: " + layoutParams.height + ProgressTracer.SEPARATOR + layoutParams.topMargin);
        this.J.setLayoutParams(layoutParams);
        k0(32.0f, this.J);
    }

    private void i0() {
        this.J.setCaptureRequest(null);
        this.E.clear();
        this.F = 0L;
    }

    private void j0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.width = iVar.f185860a;
        layoutParams.height = iVar.f185861b;
        layoutParams.topMargin = i3;
        ms.a.f("AEFlashshowCapturePart", "adjustRatio lp.height: " + layoutParams.height + ProgressTracer.SEPARATOR + layoutParams.topMargin);
        this.J.setLayoutParams(layoutParams);
    }

    private void k0(float f16, LSCameraGLSurfaceView lSCameraGLSurfaceView) {
        lSCameraGLSurfaceView.setOutlineProvider(new i(f16));
        lSCameraGLSurfaceView.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        o0(i3, iVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.width = iVar.f185860a;
        layoutParams.height = iVar.f185861b;
        layoutParams.topMargin = i3;
        this.J.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        o0(i3, iVar);
        g0(iVar);
    }

    private void o0(int i3, com.tencent.mobileqq.activity.richmedia.i iVar) {
        ViewAnimator l3;
        long j3 = iVar.f185860a * iVar.f185861b;
        long width = this.J.getWidth() * this.J.getHeight();
        ms.a.a("AEFlashshowCapturePart", "smooth2Size---oldArea=" + width + ", newArea=" + j3);
        if (j3 == width) {
            return;
        }
        K();
        this.L.setVisibility(0);
        com.tencent.aelight.camera.ae.camera.ui.animator.a l16 = ViewAnimator.j(this.M, this.N).x(this.M.getWidth(), (int) Math.ceil((this.G - iVar.f185860a) / 2.0d)).d(this.P).l(this.P.getHeight(), i3).d(this.Q).l(this.Q.getHeight(), (AEDashboardUtil.q() && this.Z == LSCaptureMode.NORMAL) ? 0 : (this.f415376e.getHeight() - i3) - iVar.f185861b);
        if (j3 > width) {
            l3 = l16.a().l(300L);
        } else {
            l3 = l16.g(1.5f).l(500L);
        }
        l3.o(new bq.d() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.8
            @Override // bq.d
            public void onStop() {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AEFlashshowCapturePart.this.X) {
                            AEFlashshowCapturePart.this.L.setVisibility(8);
                        }
                    }
                }, 500L);
            }
        }).r();
    }

    @Override // lq.a
    public <T> T d(int i3, Object... objArr) {
        return (T) super.d(i3, objArr);
    }

    @Override // lq.a
    protected void e() {
        this.f64603a0 = gq.a.r(this.f415377f.getIntent());
        this.f64604b0 = gq.a.l(this.f415377f.getIntent());
        int c16 = gq.a.c(this.f415377f.getIntent());
        this.f64605c0 = gq.a.O(c16);
        this.f64606d0 = gq.a.V(c16);
        this.J = (LSCameraGLSurfaceView) this.f415376e.findViewById(R.id.rq9);
        this.R = (ViewGroup) this.f415376e.findViewById(R.id.f163754ru1);
        this.E = new CopyOnWriteArrayList();
        this.T = new VideoStoryDataBean();
        this.G = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        this.H = i3;
        if (com.tencent.aelight.camera.aioeditor.shortvideo.util.c.a(this.G, i3)) {
            this.G = (this.H * 9) / 16;
        }
        LiuHaiUtils.initLiuHaiBarHeight(this.f415377f);
        int LiuHaiTopBarHeight = (this.H - (LiuHaiUtils.needShowLiuHaiTopBar() ? LiuHaiUtils.LiuHaiTopBarHeight() : 0)) - 0;
        if (LiuHaiTopBarHeight < com.tencent.mobileqq.util.x.c(this.f415377f, 700.0f)) {
            this.U = true;
        } else {
            this.U = false;
        }
        if (this.U) {
            if (LiuHaiTopBarHeight < com.tencent.mobileqq.util.x.c(this.f415377f, 600.0f)) {
                this.W = com.tencent.mobileqq.util.x.c(this.f415377f, 58.8f);
            } else {
                this.W = com.tencent.mobileqq.util.x.c(this.f415377f, 147.0f - (((r0 - LiuHaiTopBarHeight) / com.tencent.mobileqq.util.x.c(this.f415377f, 100.0f)) * 88.2f));
            }
            if (this.W < com.tencent.mobileqq.util.x.c(this.f415377f, 110.0f)) {
                this.V = true;
            }
            int c17 = com.tencent.mobileqq.util.x.c(this.f415377f, LiuHaiUtils.sNotchHeight + 60 + 24);
            if (this.W < c17) {
                this.W = c17;
            }
        }
        T();
    }

    @Override // lq.a
    public void onDestroy() {
        if (ms.a.g()) {
            ms.a.c("AEFlashshowCapturePart", "onDestroy()");
        }
        SendPanelManager.k().onDestroy();
        super.onDestroy();
        l0(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<LSCaptureModeChangingEvent> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LSCaptureModeChangingEvent lSCaptureModeChangingEvent) {
            if (lSCaptureModeChangingEvent == null) {
                ms.a.c("AEFlashshowCapturePart", "modeChangingEvent is null, return");
                return;
            }
            LSCaptureMode lSCaptureMode = lSCaptureModeChangingEvent.f64350b;
            AEFlashshowCapturePart.this.Z = lSCaptureMode;
            Boolean value = AEFlashshowCapturePart.this.C.P1().getValue();
            boolean z16 = false;
            if (lSCaptureMode == LSCaptureMode.GIF) {
                AEFlashshowCapturePart.this.K();
                AEFlashshowCapturePart.this.K.setVisibility(0);
                LSCameraGLSurfaceView lSCameraGLSurfaceView = AEFlashshowCapturePart.this.J;
                if (value != null && value.booleanValue()) {
                    z16 = true;
                }
                lSCameraGLSurfaceView.c2(z16);
                AEFlashshowCapturePart.this.J.d2(true);
                return;
            }
            if (AEFlashshowCapturePart.this.X) {
                AEFlashshowCapturePart.this.K.setVisibility(8);
            }
            AEFlashshowCapturePart.this.J.d2(false);
        }
    }

    private void R(AEPhotoCaptureResult aEPhotoCaptureResult) {
        l0(false);
        Intent intent = this.f415377f.getIntent();
        if (gq.a.z(intent)) {
            ms.a.f("AEFlashshowCapturePart", "handleNoNeedEditPhoto---from playMiniApp");
            Intent intent2 = new Intent();
            intent2.setAction(MiniConst.LaunchCameraPluginConst.BROADCAST_ACTION_CAMERA_BACK_RESULT);
            intent2.putExtra("file_path", aEPhotoCaptureResult.filePath);
            intent2.putExtra("is_video", false);
            HashMap<String, String> A1 = this.D.A1();
            if (A1 == null) {
                A1 = new HashMap<>();
            }
            String stringExtra = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            String f06 = f0(stringExtra);
            ms.a.a("AEFlashshowCapturePart", "handleNoNeedEditPhoto---widgetId=" + f06 + ", widgetInfo=" + stringExtra);
            if (!TextUtils.isEmpty(f06)) {
                A1.put(MiniConst.LaunchCameraPluginConst.EXTRA_INFO_KEY_WIDGET_ID, f06);
            }
            intent2.putExtra("extra_info", A1);
            this.D.A().sendBroadcast(intent2);
            this.D.A().setResult(-1, intent2);
            this.D.A().finish();
        }
    }

    private void W() {
        l0(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool == null || AEFlashshowCapturePart.this.J == null || AEFlashshowCapturePart.this.Z != LSCaptureMode.GIF) {
                return;
            }
            ms.a.a("AEFlashshowCapturePart", "\u3010\u62a0\u80cc\u5f00\u5173\u3011->observe:" + bool);
            AEFlashshowCapturePart.this.J.c2(bool.booleanValue());
        }
    }

    private void X(Object[] objArr) {
        if (objArr == null || objArr.length != 5) {
            return;
        }
        AEVideoCaptureResult aEVideoCaptureResult = (AEVideoCaptureResult) objArr[0];
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) objArr[1];
        Integer num = (Integer) objArr[2];
        or.a aVar = (or.a) objArr[3];
        QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) objArr[4];
        if (J()) {
            M(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        } else {
            N(aEVideoCaptureResult, localMediaInfo, num, aVar, qIMFilterCategoryItem);
        }
        i0();
    }

    private void b0(Object[] objArr) {
        if (objArr != null && objArr.length >= 1) {
            int a16 = gq.a.a(this.f415377f.getIntent());
            AEPhotoCaptureResult aEPhotoCaptureResult = (AEPhotoCaptureResult) objArr[0];
            Intent intent = new Intent();
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, a16);
            intent.putExtra(AETakeFacePhotoPreviewFragment.INTENT_KEY_PHOTO_PATH, aEPhotoCaptureResult.filePath);
            intent.putExtra(AECameraConstants.KEY_DISABLE_FACE_DETECT, this.f415377f.getIntent().getBooleanExtra(AECameraConstants.KEY_DISABLE_FACE_DETECT, false));
            intent.putExtra(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, this.f415377f.getIntent().getBooleanExtra(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, false));
            AETakeFacePhotoPreviewFragment.jumpToMeForResult(this.f415377f, intent, a16 == js.a.L.b() ? 1028 : 1024);
            return;
        }
        ms.a.c("AEFlashshowCapturePart", "[openPhotoPreview] args must not be null or length < 1!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z16) {
        if (z16) {
            Activity activity = this.f415377f;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (this.S == null) {
                ReportDialog reportDialog = new ReportDialog(this.f415377f, R.style.qZoneInputDialog);
                this.S = reportDialog;
                reportDialog.setCancelable(false);
                this.S.setCanceledOnTouchOutside(false);
                this.S.setContentView(R.layout.f168383uh);
            }
            this.S.show();
            return;
        }
        Dialog dialog = this.S;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.S.dismiss();
    }

    private void S(AEVideoCaptureResult aEVideoCaptureResult, or.a aVar, LocalMediaInfo localMediaInfo) {
        ms.a.f("AEFlashshowCapturePart", "handleNoNeedEditVideo---");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart.10
            @Override // java.lang.Runnable
            public void run() {
                AEFlashshowCapturePart.this.l0(true);
            }
        });
        EditTakeVideoSource editTakeVideoSource = new EditTakeVideoSource(aEVideoCaptureResult.videoMp4FilePath, aEVideoCaptureResult.audioDataFilePath, localMediaInfo);
        Bundle bundle = new Bundle();
        int a16 = aVar.a();
        EditVideoParams O = O(this.f415377f, localMediaInfo, null, 0, bundle, editTakeVideoSource, a16);
        EditVideoParams.EditSource editSource = O.f204059i;
        int width = editTakeVideoSource.getWidth();
        int height = editTakeVideoSource.getHeight();
        Stream.of(H(editSource, width, height, editTakeVideoSource.getSourcePath(), (width * 1.0f) / height, editTakeVideoSource.f204052e.rotation, "", false, O.m("extra_upload_temp_directory"), O)).map(new ThreadOffFunction("AEFlashshowCapturePart", 2)).map(new com.tencent.aelight.camera.ae.camera.ui.capture.a()).map(new fs.t(O)).subscribe(Q(a16));
    }

    private fs.b H(EditVideoParams.EditSource editSource, int i3, int i16, String str, float f16, int i17, String str2, boolean z16, String str3, EditVideoParams editVideoParams) {
        fs.b bVar = new fs.b(editVideoParams);
        bVar.f400387d.videoMaxrate = CodecParam.mMaxrate;
        if (com.tencent.aelight.camera.ae.util.n.l()) {
            bVar.f400387d.videoMaxrate = com.tencent.aelight.camera.ae.util.n.e() * 1000;
            bVar.f400387d.putExtra("composite_key_bitrate_mode", Boolean.valueOf(com.tencent.aelight.camera.ae.util.n.l()));
        }
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.videoMinrate = CodecParam.mMinrate;
        publishVideoEntry.videoUploadGroupTempDir = str3;
        bVar.f400399p = fs.s.b(editVideoParams.f204055d);
        bVar.f400392i = new fs.i(this.f415377f, i3, i16, str, f16, false, i17, 0.0d, 0.0d, str2, z16);
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

    @Override // lq.a
    public void l(int i3, Object... objArr) {
        switch (i3) {
            case 262145:
                Y();
                return;
            case 262146:
                X(objArr);
                return;
            case 262147:
                W();
                return;
            case 262148:
                V(objArr);
                return;
            case 262149:
                l0(false);
                return;
            default:
                return;
        }
    }

    private void d0(Object[] objArr) {
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
            this.f415377f.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
            QQStoryFlowCallback.f(this.f415377f, aEPhotoCaptureResult.filePath, localMediaInfo, 0, (int) localMediaInfo.mDuration, -1, 10023, 0, null, null, false, num.intValue(), num2.intValue(), bundle);
            return;
        }
        ms.a.c("AEFlashshowCapturePart", "\u3010openVideoEditorWithPhoto\u3011args is null or args.length is less than 3");
    }

    @Override // lq.a
    public void g(int i3, int i16, Intent intent) {
        if (i3 == 1026 || i3 == 1028) {
            ms.a.f("AEFlashshowCapturePart", "onActivityResult--REQUEST_CODE_SKIP_EDIT_SAVE_VIDEO--resultCode=" + i16);
            l0(false);
            if (i16 == -1) {
                Intent intent2 = this.f415377f.getIntent();
                if (gq.a.z(intent2)) {
                    ms.a.f("AEFlashshowCapturePart", "onActivityResult---success--from playMiniApp");
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
                    HashMap<String, String> A1 = this.D.A1();
                    if (A1 == null) {
                        A1 = new HashMap<>();
                    }
                    String stringExtra3 = intent2.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
                    String f06 = f0(stringExtra3);
                    ms.a.a("AEFlashshowCapturePart", "handleNoNeedEditVideo---widgetId=" + f06 + ", widgetInfo=" + stringExtra3);
                    if (!TextUtils.isEmpty(f06)) {
                        A1.put(MiniConst.LaunchCameraPluginConst.EXTRA_INFO_KEY_WIDGET_ID, f06);
                    }
                    intent3.putExtra("extra_info", A1);
                    this.f415377f.sendBroadcast(intent3);
                    this.f415377f.setResult(-1, intent3);
                    this.f415377f.finish();
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
