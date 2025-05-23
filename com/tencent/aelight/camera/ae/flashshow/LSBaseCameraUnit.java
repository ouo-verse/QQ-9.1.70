package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.LSCameraManager;
import com.tencent.aelight.camera.ae.flashshow.ac;
import com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton;
import com.tencent.aelight.camera.ae.flashshow.util.CameraFocusView;
import com.tencent.aelight.camera.ae.flashshow.util.h;
import com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.view.RendererUtils;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class LSBaseCameraUnit extends com.tencent.aelight.camera.aebase.e implements LSCameraGLSurfaceView.x, LSCameraGLSurfaceView.y {

    /* renamed from: e0, reason: collision with root package name */
    protected static final LinkedList<Integer> f63726e0 = new LinkedList<>();
    protected com.tencent.aelight.camera.ae.util.b C;
    protected View D;
    protected LSCameraGLSurfaceView E;
    protected AbsLSCaptureButton F;
    private ImageView G;
    private Bitmap H;
    protected ViewStub I;
    protected CameraFocusView J;
    protected volatile SurfaceTexture K;
    protected LinearLayout L;
    protected RelativeLayout M;
    protected AEVideoCaptureResult N;
    protected AEPhotoCaptureResult P;
    protected LocalMediaInfo Q;
    protected or.a R;
    protected int S;
    protected LSCaptureMode T;
    protected LSCaptureMode[] U;
    protected AEVideoStoryTopBarViewModel.Ratio V;
    protected LSCaptureMode W;
    protected int X;
    protected ac Y;
    protected Bundle Z;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f63727a0;

    /* renamed from: b0, reason: collision with root package name */
    protected volatile boolean f63728b0;

    /* renamed from: c0, reason: collision with root package name */
    protected volatile boolean f63729c0;

    /* renamed from: d0, reason: collision with root package name */
    protected Handler f63730d0;

    /* renamed from: f, reason: collision with root package name */
    protected final String f63731f;

    /* renamed from: h, reason: collision with root package name */
    protected or.e f63732h;

    /* renamed from: i, reason: collision with root package name */
    protected or.d f63733i;

    /* renamed from: m, reason: collision with root package name */
    protected LSCameraManager f63734m;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit$5, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f63735d;
        final /* synthetic */ LSBaseCameraUnit this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit$5$a */
        /* loaded from: classes32.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ms.a.f(AnonymousClass5.this.this$0.f63731f, "PermissionDialog--onClick which=" + i3);
                Activity activity = AnonymousClass5.this.this$0.f63732h.getActivity();
                if (i3 == 1) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                    activity.startActivity(intent);
                }
                dialogInterface.dismiss();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit$5$b */
        /* loaded from: classes32.dex */
        class b implements DialogInterface.OnCancelListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ms.a.f(AnonymousClass5.this.this$0.f63731f, "PermissionDialog--onCancel");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a();
            DialogUtil.showPermissionSettingDialog(this.this$0.f63732h.getActivity(), null, this.f63735d, aVar, aVar, new b());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermissionCallback f63739a;

        b(QQPermissionCallback qQPermissionCallback) {
            this.f63739a = qQPermissionCallback;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f63739a.grant(-1, null, null);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements LSCameraManager.b {
        c() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
        public void onOpenResult(int i3, boolean z16) {
            ms.a.f(LSBaseCameraUnit.this.f63731f, "tryOpenCamera result=" + z16 + ", whichCamera=" + i3 + ", mActivityResume=" + LSBaseCameraUnit.this.f63727a0);
            if (z16) {
                LSCameraGLSurfaceView lSCameraGLSurfaceView = LSBaseCameraUnit.this.E;
                if (lSCameraGLSurfaceView != null) {
                    lSCameraGLSurfaceView.u1(i3);
                }
                if (LSBaseCameraUnit.this.V()) {
                    LSBaseCameraUnit.this.c0(i3);
                }
                LSBaseCameraUnit lSBaseCameraUnit = LSBaseCameraUnit.this;
                if (!lSBaseCameraUnit.f63727a0) {
                    lSBaseCameraUnit.x(false);
                } else {
                    lSBaseCameraUnit.p0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends QQPermission.BasePermissionsListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements c.b {
        e() {
        }

        @Override // com.tencent.qqcamerakit.capture.c.b
        public void a(String str) {
            LSBaseCameraUnit.this.onPhotoCaptured(new AEPhotoCaptureResult(1, 0, str, null, 0L, LSBaseCameraUnit.this.E.H0()));
        }
    }

    public LSBaseCameraUnit() {
        String simpleName = getClass().getSimpleName();
        this.f63731f = simpleName;
        this.f63734m = new LSCameraManager();
        this.C = new com.tencent.aelight.camera.ae.util.b();
        this.H = null;
        this.R = new or.a(10000, 100, 2);
        this.W = null;
        this.X = 11;
        this.f63728b0 = false;
        this.f63729c0 = false;
        this.f63730d0 = new Handler(Looper.getMainLooper());
        ms.a.f(simpleName, "[LSBaseCameraUnit] + BEGIN");
        ms.a.a(simpleName, "unitConstructor--fake");
        ms.a.f(simpleName, "[LSBaseCameraUnit] + END");
        com.tencent.aelight.camera.ae.util.m.f65786a.b(A().getIntent());
    }

    private iq.a P(xp.a aVar) {
        return new iq.a(aVar.f448260n, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.E, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b0(Activity activity) {
        activity.getWindow().clearFlags(2048);
        activity.getWindow().addFlags(1024);
        activity.getWindow().addFlags(256);
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4);
    }

    private void e0() {
        this.E.setAEKitInitListener(this);
        xp.a Q = Q();
        iq.a P = this.Y.w() ? P(Q) : null;
        this.E.T0(Q, P, this.Y);
        this.E.setBeautyEnable(this.Y.x());
        this.E.setFaceEffectEnable(this.Y.A());
        this.E.setFilterEnable(this.Y.z());
        this.E.setSharpFaceEnable(this.Y.B());
        this.E.setPreExtractFrame(T());
        this.E.setUseVideoOrientation(this.Y.C());
        this.f63734m.init(Q);
        this.f63734m.setAudioCapture(P);
        this.f63734m.setDarkModeEnable(this.Y.y());
        this.f63734m.setDarkModeListener(H());
        this.f63734m.setDarkModeChecker(G());
        this.f63734m.x(E());
    }

    public Activity A() {
        or.e eVar = this.f63732h;
        if (eVar == null) {
            return null;
        }
        return eVar.getActivity();
    }

    protected IntentFilter B() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
        return intentFilter;
    }

    protected abstract BroadcastReceiver C();

    public ac D() {
        if (this.Y == null) {
            this.Y = z();
        }
        return this.Y;
    }

    protected abstract LSCameraManager.a E();

    public GLSurfaceView F() {
        return this.E;
    }

    protected com.tencent.aelight.camera.ae.flashshow.util.h G() {
        return new com.tencent.aelight.camera.ae.flashshow.util.h();
    }

    protected abstract h.a H();

    protected abstract int I();

    public abstract LSCaptureMode J(int i3);

    public int K() {
        return com.tencent.aelight.camera.ae.flashshow.util.a.b(R() ? 1 : 2);
    }

    protected abstract int L();

    public abstract LSCaptureMode[] M(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean N() {
        int checkSelfPermission = A().checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO);
        ms.a.f(this.f63731f, "checkPermission,   audio: " + checkSelfPermission);
        return checkSelfPermission == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean O() {
        int checkSelfPermission = A().checkSelfPermission(QQPermissionConstants.Permission.CAMERA);
        ms.a.f(this.f63731f, "checkPermission, camera: " + checkSelfPermission);
        return checkSelfPermission == 0;
    }

    protected abstract xp.a Q();

    public boolean R() {
        return gq.a.v(A().getIntent());
    }

    protected boolean S() {
        Integer peek = f63726e0.peek();
        return peek != null && peek.intValue() == this.S;
    }

    protected abstract boolean T();

    protected void U(String str) {
        tq.b.h().o(str);
    }

    protected abstract boolean V();

    protected void W(boolean z16) {
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), z16, 5);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, z16);
    }

    protected abstract void X();

    public abstract void Y();

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(QQPermissionCallback qQPermissionCallback) {
        if (this.f63732h.getActivity() instanceof QPublicFragmentActivity) {
            QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) this.f63732h.getActivity();
            boolean z16 = qPublicFragmentActivity.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0;
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.RECORD_AUDIO);
            }
            if (linkedList.size() > 0) {
                QQPermissionFactory.getQQPermission(qPublicFragmentActivity, new BusinessConfig(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, QQPermissionConstants.Business.SCENE.GY_FLASH_SHOW_UNIT)).requestPermissions((String[]) linkedList.toArray(new String[0]), 2, new b(qQPermissionCallback));
            }
        }
    }

    protected void a0() {
        if (this.f63732h.getActivity() instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.f63732h.getActivity();
            boolean z16 = baseActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.CAMERA);
            }
            if (linkedList.isEmpty()) {
                return;
            }
            QQPermissionFactory.getQQPermission(baseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, QQPermissionConstants.Business.SCENE.GY_FLASH_SHOW_UNIT)).requestPermissions((String[]) linkedList.toArray(new String[0]), 2, new d());
        }
    }

    public void c0(int i3) {
        com.tencent.aelight.camera.ae.flashshow.util.a.e(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0() {
        LSCaptureMode.NORMAL.setHasCountDown(this.Y.u());
        this.V = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.Y.r());
        this.W = this.Y.m();
        e0();
        f0();
        g0();
    }

    protected abstract void f0();

    public void g() {
        if (this.E.m0()) {
            ms.a.f(this.f63731f, "onCaptureButtonPhoto---capturePhotoByCameraProxy");
            LSDashboardUtil.f64214d.f64249p = false;
            w();
        } else {
            ms.a.f(this.f63731f, "conCaptureButtonPhoto---apturePhotoByAEKit");
            LSDashboardUtil.f64214d.f64249p = true;
            v();
        }
        Y();
    }

    protected abstract void g0();

    public void j0() {
        ms.a.f(this.f63731f, "stopPreview");
        if (!S()) {
            ms.a.c(this.f63731f, "stopPreview---EXIT, not called by the top unit");
        } else {
            this.f63734m.cameraStopPreview();
        }
    }

    public void k0(boolean z16) {
        try {
            QQLowLightFilter.enableNightMode(z16);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void m0() {
        if (gq.a.j(A().getIntent())) {
            ms.a.a(this.f63731f, "can not toggle Camera in ar cake mode");
        } else {
            this.f63734m.z(new a());
        }
    }

    public void n0() {
        ms.a.f(this.f63731f, "tryOpenCamera---ENTER");
        if (!S()) {
            ms.a.c(this.f63731f, "tryOpenCamera---EXIT, not called by the top unit");
            return;
        }
        LSCaptureMode lSCaptureMode = this.W;
        if (lSCaptureMode != null && lSCaptureMode.shouldStartCamera()) {
            this.f63734m.v(new c());
            return;
        }
        ms.a.c(this.f63731f, "tryOpenCamera---EXIT, not right mode: " + lSCaptureMode);
    }

    protected void o0() {
        if (this.f63729c0) {
            n0();
        } else {
            if (this.f63728b0) {
                return;
            }
            this.f63728b0 = true;
            a0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.x
    public void onAEKitInited() {
        Log.d(this.f63731f, "onAEKitInited: thread = " + Thread.currentThread().getName());
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        super.onActivityPause();
        ms.a.a(this.f63731f, "onActivityPause");
        this.f63727a0 = false;
        try {
            ImageView imageView = this.G;
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
            Bitmap bitmap = this.H;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.H.recycle();
            }
            this.H = null;
        } catch (Exception unused) {
            ms.a.c(this.f63731f, "recycle error");
        }
        if (QzoneConfig.getFlashCameraFirstFrameConfig()) {
            this.E.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LSFilterProcessTex.C0 <= 0 || LSFilterProcessTex.D0 <= 0) {
                        return;
                    }
                    LSBaseCameraUnit.this.H = RendererUtils.saveTexture2Bitmap(LSFilterProcessTex.B0, GLSLRender.GL_TEXTURE_2D, LSFilterProcessTex.C0, LSFilterProcessTex.D0);
                }
            });
        }
        mq.a.d().a(IPrefRecorder.MILESTONE_CAMERA_TAB_SWITCH);
        this.E.onPause();
        j0();
        x(false);
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        super.onActivityResume();
        this.f63727a0 = true;
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(8);
            Bitmap bitmap = this.H;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.G.setVisibility(0);
                tq.b.h().t(false);
                try {
                    this.G.setImageBitmap(this.H);
                    mq.a.d().j(IPrefRecorder.MILESTONE_CAMERA_RESUME_SWITCH);
                } catch (Exception unused) {
                    ms.a.c(this.f63731f, "mFirstFrameBitMap set error ");
                }
            } else {
                this.G.setVisibility(8);
                tq.b.h().t(true);
            }
        }
        this.E.onResume();
        this.E.setFirstFrameView(this.G);
        this.E.setFrameBitMap(this.H);
        j0();
        x(false);
        this.f63729c0 = O();
        o0();
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W(false);
        this.f63729c0 = O();
        if (bundle != null) {
            this.N = (AEVideoCaptureResult) bundle.getSerializable("KEY_VIDEO_RESULT");
            this.S = bundle.getInt("KEY_IDENTITY_CODE_SAVE");
            ms.a.f(this.f63731f, "onCreate, restore from background, ID=" + this.S);
        } else {
            this.S = f63726e0.size() + 1;
            ms.a.f(this.f63731f, "onCreate, new created, ID=" + this.S);
        }
        this.C.b();
        uq.a.registerModule();
        LinkedList<Integer> linkedList = f63726e0;
        if (!linkedList.contains(Integer.valueOf(this.S))) {
            linkedList.push(Integer.valueOf(this.S));
        }
        A().registerReceiver(C(), B());
        ms.a.f(this.f63731f, "onCreate, ID=" + this.S + ", sUnitStack=" + linkedList);
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        super.onDestroy();
        ms.a.a(this.f63731f, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        A().unregisterReceiver(C());
        x(true);
        GLGestureProxy.getInstance().removeAllListener();
        PlayDownloadManagerWrap.getInstance().clearObserver();
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.E;
        if (lSCameraGLSurfaceView != null) {
            lSCameraGLSurfaceView.v1();
        }
        com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().i();
        W(true);
        if (S()) {
            f63726e0.pop();
            ms.a.f(this.f63731f, "onDestroy, is on top, ID=" + this.S);
        } else {
            ms.a.f(this.f63731f, "onDestroy, is NOT on top, ID=" + this.S);
        }
        ms.a.f(this.f63731f, "onDestroy, ID=" + this.S + ", sUnitStack=" + f63726e0);
        Bitmap bitmap = this.H;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.H.recycle();
            this.H = null;
        }
        this.f63730d0.removeCallbacksAndMessages(null);
        this.D = null;
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("KEY_VIDEO_RESULT", this.N);
        bundle.putInt("KEY_IDENTITY_CODE_SAVE", this.S);
        ms.a.f(this.f63731f, "onSaveInstanceState---destroyed in background, ID=" + this.S);
    }

    public void p0() {
        ms.a.f(this.f63731f, "tryStartPreview---ENTER");
        if (!S()) {
            ms.a.c(this.f63731f, "tryStartPreview---EXIT, not called by the top unit");
            return;
        }
        if (!this.f63727a0) {
            ms.a.c(this.f63731f, "tryStartPreview---EXIT, activity not resumed");
            return;
        }
        LSCaptureMode lSCaptureMode = this.W;
        if (lSCaptureMode != null && lSCaptureMode.shouldStartCamera()) {
            if (this.K == null) {
                ms.a.c(this.f63731f, "tryStartPreview---EXIT, mPreviewTexture is NULL");
                return;
            }
            if (com.tencent.aelight.camera.ae.util.h.a() == null) {
                ms.a.c(this.f63731f, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
                return;
            }
            this.V = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
            ms.a.a(this.f63731f, "tryStartPreview---EXIT,mCurrentRatio" + this.V);
            com.tencent.mobileqq.activity.richmedia.i b16 = com.tencent.aelight.camera.ae.flashshow.util.l.b(lSCaptureMode, com.tencent.aelight.camera.ae.util.h.a(), this.V);
            this.f63734m.x(E());
            this.f63734m.startCameraPreview(this.K, b16);
            ms.a.f(this.f63731f, "tryStartPreview---EXIT, normal");
            return;
        }
        ms.a.c(this.f63731f, "tryStartPreview---EXIT, not right mode: " + lSCaptureMode);
    }

    @Override // com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        U("unitInflateView-begin");
        View b16 = wp.a.a().b(L());
        if (b16 != null) {
            this.D = b16;
        } else {
            this.D = A().getLayoutInflater().inflate(L(), (ViewGroup) null, false);
        }
        U("unitInflateView-end");
        u();
        this.G = (ImageView) this.D.findViewById(R.id.rtt);
        d0();
        return this.D;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.y
    public void reportFirstFrameShown() {
        com.tencent.aelight.camera.ae.report.b.b().r(this.f63734m.isSupportCamera2() ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.L = (LinearLayout) this.D.findViewById(R.id.rov);
        this.M = (RelativeLayout) this.D.findViewById(R.id.rou);
        LSCameraGLSurfaceView lSCameraGLSurfaceView = (LSCameraGLSurfaceView) this.D.findViewById(R.id.rq9);
        this.E = lSCameraGLSurfaceView;
        if (lSCameraGLSurfaceView != null) {
            lSCameraGLSurfaceView.setFrom(A().getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, 0));
            this.E.setActivity(A());
        }
        this.I = (ViewStub) this.D.findViewById(R.id.f163794s15);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        int i3;
        if (this.f63734m.isFlashEnabled()) {
            this.f63734m.turnFlash(A(), true);
            i3 = 1500;
        } else {
            i3 = 0;
        }
        this.E.o0(i3);
    }

    protected void w() {
        LSCaptureMode lSCaptureMode = this.W;
        if (lSCaptureMode == null || !lSCaptureMode.shouldStartCamera() || com.tencent.aelight.camera.ae.util.h.a() == null) {
            return;
        }
        if (this.f63734m.isFlashEnabled()) {
            this.f63734m.turnFlash(A(), true);
        }
        com.tencent.mobileqq.activity.richmedia.i b16 = com.tencent.aelight.camera.ae.flashshow.util.l.b(this.W, com.tencent.aelight.camera.ae.util.h.a(), this.V);
        String str = this.E.F0() + "/" + System.currentTimeMillis() + ".jpg";
        FileUtils.createFileIfNotExits(str);
        File file = new File(str);
        this.f63734m.isFrontCamera();
        this.f63734m.capturePhoto(file, this.Y.v() ? com.tencent.aelight.camera.ae.flashshow.util.g.e(this.f63734m.getActivityOrientation()) : 0, new e(), b16);
    }

    public void x(boolean z16) {
        ms.a.f(this.f63731f, "closeCamera");
        if (!S()) {
            ms.a.c(this.f63731f, "closeCamera---EXIT, not called by the top unit");
        } else {
            this.f63734m.stopCamera(z16);
        }
    }

    protected ac z() {
        return y();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements LSCameraManager.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
        public void onOpenResult(int i3, boolean z16) {
            if (z16) {
                LSBaseCameraUnit.this.E.u1(i3);
                if (LSBaseCameraUnit.this.V()) {
                    LSBaseCameraUnit.this.c0(i3);
                }
                LSBaseCameraUnit.this.X();
                LSBaseCameraUnit.this.p0();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l0(boolean z16) {
        boolean z17;
        if (z16) {
            Activity A = A();
            if (!Settings.System.canWrite(A)) {
                DialogUtil.showWriteSetting(A, null, null);
                z17 = false;
                if (z17) {
                    this.f63734m.switchFlash(z16);
                }
                return z17;
            }
        }
        z17 = true;
        if (z17) {
        }
        return z17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x018b, code lost:
    
        if (r3 != (-1)) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ac y() {
        String str;
        String str2;
        boolean z16;
        int i3;
        String str3;
        boolean z17;
        int i16;
        Bundle bundle;
        int i17;
        Bundle bundle2;
        boolean z18;
        int intExtra;
        boolean z19;
        String str4;
        String str5;
        ac.b bVar = new ac.b();
        Intent intent = A().getIntent();
        if (intent != null && intent.getExtras() != null) {
            String str6 = "";
            if (intent.hasExtra("key_attrs")) {
                Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
                if (serializableExtra instanceof HashMap) {
                    HashMap hashMap = (HashMap) serializableExtra;
                    if (!hashMap.containsKey("cameraId")) {
                        str2 = "";
                    } else {
                        str2 = (String) hashMap.get("cameraId");
                    }
                    if (!hashMap.containsKey("cameraMode")) {
                        str5 = "";
                    } else {
                        str5 = (String) hashMap.get("cameraMode");
                    }
                    if (hashMap.containsKey("needCacheCameraMode")) {
                        str6 = (String) hashMap.get("needCacheCameraMode");
                    }
                    str = str6;
                    str6 = str5;
                    boolean b16 = com.tencent.aelight.camera.ae.util.c.b(intent, this.f63731f);
                    ms.a.f(this.f63731f, "extractAECameraConfigFromIntent enableAudio = " + b16);
                    int i18 = intent.getExtras().getInt(AECameraConstants.ARG_CAPTURE_MAX_DURATION, -1);
                    boolean z26 = intent.getExtras().getBoolean(PeakConstants.ARG_SUPPORT_FILTER, true);
                    boolean z27 = intent.getExtras().getBoolean(PeakConstants.ARG_SUPPORT_DD, true);
                    boolean z28 = intent.getExtras().getBoolean(PeakConstants.ARG_BEAUTY, true);
                    z16 = intent.getExtras().getBoolean(PeakConstants.ARG_SHARP_FACE, true);
                    boolean z29 = intent.getExtras().getBoolean(PeakConstants.ARG_ALBUM, true);
                    int i19 = intent.getExtras().getInt(AECameraConstants.ARG_DEFAULT_OPEN_PANEL, -1);
                    int i26 = intent.getExtras().getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
                    int i27 = intent.getExtras().getInt(IJumpUtil.EDIT_VIDEO_WAY, 0);
                    int i28 = intent.getExtras().getInt("entrance_type", 120);
                    int i29 = intent.getExtras().getInt(PeakConstants.BUSI_TYPE, 14);
                    String stringExtra = intent.getStringExtra(AECameraConstants.ARG_AIO_CLASS);
                    int i36 = intent.getExtras().getInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, -1);
                    int i37 = intent.getExtras().getInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, -1);
                    i3 = intent.getExtras().getInt("ability_flag", 1);
                    if (!str6.isEmpty() && str6.equals("1")) {
                        i3 = 5;
                    }
                    if (str.isEmpty() && str.equals("1")) {
                        AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
                        if (a16 != null) {
                            str4 = a16.getCurrentAccountUin();
                        } else {
                            str4 = "none";
                        }
                        os.a aVar = os.a.f423933a;
                        str3 = str;
                        StringBuilder sb5 = new StringBuilder();
                        z17 = z16;
                        sb5.append(AECameraConstants.MMKV_CAMERA_ENTRANCE_EXP_USER_ID_AND_CACHE_VALUE);
                        sb5.append(str4);
                        i16 = aVar.c(sb5.toString(), -1);
                    } else {
                        str3 = str;
                        z17 = z16;
                    }
                    i16 = i3;
                    bundle = this.Z;
                    if (bundle != null && (i16 == 1 || i16 == 5)) {
                        i16 = bundle.getInt("ability_flag", 1);
                    }
                    int intExtra2 = intent.getIntExtra(AECameraConstants.AECAMERA_MODE, 200);
                    boolean booleanExtra = intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_USE_VIDEO_ORIENTATION, true);
                    boolean booleanExtra2 = intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_AUTO_ROTATE, true);
                    this.U = M(intExtra2);
                    this.T = J(intExtra2);
                    boolean booleanExtra3 = A().getIntent().getBooleanExtra(AECameraConstants.KEY_HAS_COUNTDOWN, false);
                    int I = I();
                    if ("1".equals(intent.getStringExtra(QQWinkConstants.AE_CAMERA_RATIO))) {
                        I = AEVideoStoryTopBarViewModel.Ratio.R_4_3.code;
                    }
                    int intExtra3 = intent.getIntExtra(PeakConstants.ARG_FORCE_CAMERA, 0);
                    if (str2.isEmpty()) {
                        i17 = str2.equals("0") ? 2 : 1;
                    } else {
                        i17 = intExtra3;
                    }
                    int intExtra4 = intent.getIntExtra(AECameraConstants.KEY_CAMERA_RESULT_CODE, -1);
                    int i38 = i17;
                    boolean z36 = intent.getIntExtra(QCircleScheme.AttrQQPublish.DISABLE_MOTION, 0) == 0;
                    boolean z37 = intent.getIntExtra(QCircleScheme.AttrQQPublish.DISABLE_BEAUTY, 0) == 0;
                    bundle2 = this.Z;
                    boolean z38 = z37;
                    int i39 = I;
                    if (bundle2 == null) {
                        z18 = booleanExtra3;
                        z19 = bundle2.getBoolean("camera_direct_return_result", false);
                        intExtra = this.Z.getInt("fragment_request_business_code", 0);
                    } else {
                        z18 = booleanExtra3;
                        boolean booleanExtra4 = intent.getBooleanExtra("camera_direct_return_result", false);
                        intExtra = intent.getIntExtra("fragment_request_business_code", 0);
                        z19 = booleanExtra4;
                    }
                    bVar.a0(i26).i0(intExtra4).T(b16).U(z28).O(i19).W(z26).e0(i18).Y(z17).X(z27).j0(z29).M(i16).Z(i28).K(i29).S(i27).g0(i36).l0(i37).J(booleanExtra2).k0(booleanExtra).b0(z18).N(intExtra2).c0(this.T).V(this.U).I(stringExtra).h0(i39).P(i38).R(z36).Q(z38).f0(str3.equals("1")).d0(z19).L(intExtra);
                }
            }
            str = "";
            str2 = str;
            boolean b162 = com.tencent.aelight.camera.ae.util.c.b(intent, this.f63731f);
            ms.a.f(this.f63731f, "extractAECameraConfigFromIntent enableAudio = " + b162);
            int i182 = intent.getExtras().getInt(AECameraConstants.ARG_CAPTURE_MAX_DURATION, -1);
            boolean z262 = intent.getExtras().getBoolean(PeakConstants.ARG_SUPPORT_FILTER, true);
            boolean z272 = intent.getExtras().getBoolean(PeakConstants.ARG_SUPPORT_DD, true);
            boolean z282 = intent.getExtras().getBoolean(PeakConstants.ARG_BEAUTY, true);
            z16 = intent.getExtras().getBoolean(PeakConstants.ARG_SHARP_FACE, true);
            boolean z292 = intent.getExtras().getBoolean(PeakConstants.ARG_ALBUM, true);
            int i192 = intent.getExtras().getInt(AECameraConstants.ARG_DEFAULT_OPEN_PANEL, -1);
            int i262 = intent.getExtras().getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
            int i272 = intent.getExtras().getInt(IJumpUtil.EDIT_VIDEO_WAY, 0);
            int i282 = intent.getExtras().getInt("entrance_type", 120);
            int i292 = intent.getExtras().getInt(PeakConstants.BUSI_TYPE, 14);
            String stringExtra2 = intent.getStringExtra(AECameraConstants.ARG_AIO_CLASS);
            int i362 = intent.getExtras().getInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, -1);
            int i372 = intent.getExtras().getInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, -1);
            i3 = intent.getExtras().getInt("ability_flag", 1);
            if (!str6.isEmpty()) {
                i3 = 5;
            }
            if (str.isEmpty()) {
            }
            str3 = str;
            z17 = z16;
            i16 = i3;
            bundle = this.Z;
            if (bundle != null) {
                i16 = bundle.getInt("ability_flag", 1);
            }
            int intExtra22 = intent.getIntExtra(AECameraConstants.AECAMERA_MODE, 200);
            boolean booleanExtra5 = intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_USE_VIDEO_ORIENTATION, true);
            boolean booleanExtra22 = intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_AUTO_ROTATE, true);
            this.U = M(intExtra22);
            this.T = J(intExtra22);
            boolean booleanExtra32 = A().getIntent().getBooleanExtra(AECameraConstants.KEY_HAS_COUNTDOWN, false);
            int I2 = I();
            if ("1".equals(intent.getStringExtra(QQWinkConstants.AE_CAMERA_RATIO))) {
            }
            int intExtra32 = intent.getIntExtra(PeakConstants.ARG_FORCE_CAMERA, 0);
            if (str2.isEmpty()) {
            }
            int intExtra42 = intent.getIntExtra(AECameraConstants.KEY_CAMERA_RESULT_CODE, -1);
            int i382 = i17;
            if (intent.getIntExtra(QCircleScheme.AttrQQPublish.DISABLE_MOTION, 0) == 0) {
            }
            if (intent.getIntExtra(QCircleScheme.AttrQQPublish.DISABLE_BEAUTY, 0) == 0) {
            }
            bundle2 = this.Z;
            boolean z382 = z37;
            int i392 = I2;
            if (bundle2 == null) {
            }
            bVar.a0(i262).i0(intExtra42).T(b162).U(z282).O(i192).W(z262).e0(i182).Y(z17).X(z272).j0(z292).M(i16).Z(i282).K(i292).S(i272).g0(i362).l0(i372).J(booleanExtra22).k0(booleanExtra5).b0(z18).N(intExtra22).c0(this.T).V(this.U).I(stringExtra2).h0(i392).P(i382).R(z36).Q(z382).f0(str3.equals("1")).d0(z19).L(intExtra);
        }
        return bVar.H();
    }

    public LSBaseCameraUnit(or.e eVar, or.d dVar, Bundle bundle) {
        String simpleName = getClass().getSimpleName();
        this.f63731f = simpleName;
        this.f63734m = new LSCameraManager();
        this.C = new com.tencent.aelight.camera.ae.util.b();
        this.H = null;
        this.R = new or.a(10000, 100, 2);
        this.W = null;
        this.X = 11;
        this.f63728b0 = false;
        this.f63729c0 = false;
        this.f63730d0 = new Handler(Looper.getMainLooper());
        ms.a.f(simpleName, "[LSBaseCameraUnit] + BEGIN");
        this.f63732h = eVar;
        this.f63733i = dVar;
        LSDashboardUtil.o(A().getIntent());
        com.tencent.aelight.camera.ae.util.m.f65786a.b(A().getIntent());
        this.Z = bundle;
        this.Y = z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0() {
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void n(int i3, int i16) {
    }
}
