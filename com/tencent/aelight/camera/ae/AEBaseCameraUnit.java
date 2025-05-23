package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.a;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.util.CameraFocusView;
import com.tencent.aelight.camera.ae.flashshow.util.h;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
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
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AEBaseCameraUnit extends com.tencent.aelight.camera.aebase.e implements AECameraGLSurfaceView.AEKitInitListener, AECameraGLSurfaceView.CaptureListener {

    /* renamed from: b0, reason: collision with root package name */
    protected static final LinkedList<Integer> f61814b0 = new LinkedList<>();
    protected com.tencent.aelight.camera.ae.util.b C;
    protected View D;
    protected AECameraGLSurfaceView E;
    protected AbsAECaptureButton F;
    protected ViewStub G;
    protected CameraFocusView H;
    protected volatile SurfaceTexture I;
    protected LinearLayout J;
    protected RelativeLayout K;
    protected AEVideoCaptureResult L;
    protected AEPhotoCaptureResult M;
    protected LocalMediaInfo N;
    protected or.a P;
    protected int Q;
    protected AECaptureMode R;
    protected AECaptureMode[] S;
    protected AEVideoStoryTopBarViewModel.Ratio T;
    protected AECaptureMode U;
    protected int V;
    protected com.tencent.aelight.camera.ae.a W;
    protected boolean X;
    protected volatile boolean Y;
    protected volatile boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    protected Handler f61815a0;

    /* renamed from: f, reason: collision with root package name */
    protected final String f61816f;

    /* renamed from: h, reason: collision with root package name */
    protected or.e f61817h;

    /* renamed from: i, reason: collision with root package name */
    protected or.d f61818i;

    /* renamed from: m, reason: collision with root package name */
    protected AECameraManager f61819m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements AECameraManager.CameraOpenCallback {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
        public void onOpenResult(int i3, boolean z16) {
            ms.a.f(AEBaseCameraUnit.this.f61816f, "tryOpenCamera result=" + z16 + ", whichCamera=" + i3 + ", mActivityResume=" + AEBaseCameraUnit.this.X);
            if (z16) {
                AECameraGLSurfaceView aECameraGLSurfaceView = AEBaseCameraUnit.this.E;
                if (aECameraGLSurfaceView != null) {
                    aECameraGLSurfaceView.onChangeCamera(i3);
                }
                if (AEBaseCameraUnit.this.V()) {
                    AEBaseCameraUnit.this.d0(i3);
                }
                AEBaseCameraUnit aEBaseCameraUnit = AEBaseCameraUnit.this;
                if (!aEBaseCameraUnit.X) {
                    aEBaseCameraUnit.w(false);
                    return;
                } else {
                    aEBaseCameraUnit.r0();
                    return;
                }
            }
            com.tencent.aelight.camera.report.atta.d.d("cam_startup_failed", null, Arrays.asList(Long.valueOf(com.tencent.aelight.camera.report.atta.e.a(AEBaseCameraUnit.this.z())), Long.valueOf(com.tencent.aelight.camera.report.atta.e.b())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends QQPermission.BasePermissionsListener {
        c() {
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

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermissionCallback f61826a;

        d(QQPermissionCallback qQPermissionCallback) {
            this.f61826a = qQPermissionCallback;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f61826a.grant(-1, null, null);
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
            AEBaseCameraUnit.this.onPhotoCaptured(new AEPhotoCaptureResult(1, 0, str, null, 0L, AEBaseCameraUnit.this.E.getEffectOrientation()));
        }
    }

    public AEBaseCameraUnit() {
        String str = AECameraConstants.TAG + getClass().getSimpleName();
        this.f61816f = str;
        this.f61819m = new AECameraManager();
        this.C = new com.tencent.aelight.camera.ae.util.b();
        this.P = new or.a(10000, 100, 2);
        this.U = null;
        this.V = 11;
        this.Y = false;
        this.Z = false;
        this.f61815a0 = new Handler(Looper.getMainLooper());
        ms.a.f(str, "[AEBaseCameraUnit] + BEGIN");
        ms.a.a(str, "unitConstructor--fake");
        ms.a.f(str, "[AEBaseCameraUnit] + END");
    }

    private AudioCapture O(xp.a aVar) {
        return new AudioCapture(aVar.f448260n, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.E, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c0(Activity activity) {
        activity.getWindow().clearFlags(2048);
        activity.getWindow().addFlags(1024);
        activity.getWindow().addFlags(256);
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4);
    }

    private void f0() {
        this.E.setAEKitInitListener(this);
        this.E.setIsVoiceNeedEncode(W());
        xp.a P = P();
        AudioCapture O = this.W.v() ? O(P) : null;
        this.E.init(P, O, this.W);
        this.E.setBeautyEnable(this.W.w());
        this.E.setFaceEffectEnable(this.W.z());
        this.E.setFilterEnable(this.W.y());
        this.E.setSharpFaceEnable(this.W.A());
        this.E.setPreExtractFrame(T());
        this.E.setUseVideoOrientation(this.W.C());
        this.f61819m.init(P);
        this.f61819m.setAudioCapture(O);
        this.f61819m.setDarkModeEnable(this.W.x());
        this.f61819m.setDarkModeListener(G());
        this.f61819m.setDarkModeChecker(F());
        this.f61819m.setCameraManagerListener(E());
    }

    protected IntentFilter A() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
        return intentFilter;
    }

    protected abstract BroadcastReceiver B();

    public com.tencent.aelight.camera.ae.a C() {
        if (this.W == null) {
            this.W = y();
        }
        return this.W;
    }

    public AECameraManager D() {
        return this.f61819m;
    }

    protected abstract AECameraManager.CameraManagerListener E();

    protected com.tencent.aelight.camera.ae.flashshow.util.h F() {
        return new com.tencent.aelight.camera.ae.flashshow.util.h();
    }

    protected abstract h.a G();

    protected abstract int H();

    public abstract AECaptureMode I(int i3);

    public int J() {
        int i3 = R() ? 1 : 2;
        if (R()) {
            return com.tencent.aelight.camera.ae.flashshow.util.a.b(i3);
        }
        return gm2.a.b(i3);
    }

    protected abstract int K();

    public abstract AECaptureMode[] L(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean M() {
        int checkSelfPermission = z().checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO);
        ms.a.f(this.f61816f, "checkPermission,   audio: " + checkSelfPermission);
        return checkSelfPermission == 0;
    }

    protected boolean N() {
        return z().checkSelfPermission(QQPermissionConstants.Permission.CAMERA) == 0;
    }

    protected abstract xp.a P();

    public abstract boolean Q();

    public boolean R() {
        return gq.a.v(z().getIntent());
    }

    protected boolean S() {
        Integer peek = f61814b0.peek();
        return peek != null && peek.intValue() == this.Q;
    }

    protected abstract boolean T();

    protected void U(String str) {
        tq.b.h().o(str);
    }

    protected abstract boolean V();

    protected abstract boolean W();

    protected void X(boolean z16) {
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), z16, 5);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, z16);
    }

    protected abstract void Y();

    public abstract void Z();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(QQPermissionCallback qQPermissionCallback) {
        QQPermission qQPermission;
        if (this.f61817h.getActivity() instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.f61817h.getActivity();
            boolean z16 = baseActivity.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0;
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.RECORD_AUDIO);
            }
            if (linkedList.size() > 0) {
                if (baseActivity instanceof QIMCameraCaptureActivity) {
                    qQPermission = ((QIMCameraCaptureActivity) baseActivity).z0();
                } else {
                    qQPermission = QQPermissionFactory.getQQPermission(baseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_CAMERA, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_CAMERA));
                }
                qQPermission.requestPermissions((String[]) linkedList.toArray(new String[0]), 2, new d(qQPermissionCallback));
            }
        }
    }

    protected void b0() {
        QQPermission qQPermission;
        if (this.f61817h.getActivity() instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.f61817h.getActivity();
            boolean z16 = baseActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.CAMERA);
            }
            if (linkedList.size() > 0) {
                if (baseActivity instanceof QIMCameraCaptureActivity) {
                    qQPermission = ((QIMCameraCaptureActivity) baseActivity).z0();
                } else {
                    qQPermission = QQPermissionFactory.getQQPermission(baseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_CAMERA, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_CAMERA));
                }
                qQPermission.requestPermissions((String[]) linkedList.toArray(new String[0]), 2, new c());
            }
        }
    }

    public void d0(int i3) {
        if (R()) {
            com.tencent.aelight.camera.ae.flashshow.util.a.e(i3);
        } else {
            gm2.a.d(i3);
        }
    }

    protected void e0() {
        AECaptureMode.NORMAL.setHasCountDown(this.W.t());
        this.T = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.W.p());
        this.U = this.W.l();
        f0();
        g0();
        i0();
    }

    public void g() {
        if (this.E.captureByCameraProxy()) {
            ms.a.f(this.f61816f, "onCaptureButtonPhoto---capturePhotoByCameraProxy");
            AEDashboardUtil.f62611d.f62646p = false;
            v();
        } else {
            ms.a.f(this.f61816f, "conCaptureButtonPhoto---apturePhotoByAEKit");
            AEDashboardUtil.f62611d.f62646p = true;
            u();
        }
        Z();
    }

    protected abstract void g0();

    protected abstract void i0();

    public void k0() {
        boolean z16 = this.f61817h.getActivity().checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0;
        LinkedList linkedList = new LinkedList();
        if (z16) {
            linkedList.add(QQPermissionConstants.Permission.RECORD_AUDIO);
            ms.a.f(this.f61816f, "\u3010Audio Permission\u3011denied");
        }
        final String permissionWording = DialogUtil.getPermissionWording((String[]) linkedList.toArray(new String[0]));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.AEBaseCameraUnit.6

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.AEBaseCameraUnit$6$a */
            /* loaded from: classes32.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ms.a.f(AEBaseCameraUnit.this.f61816f, "PermissionDialog--onClick which=" + i3);
                    Activity activity = AEBaseCameraUnit.this.f61817h.getActivity();
                    if (i3 == 1) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                        activity.startActivity(intent);
                    }
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.AEBaseCameraUnit$6$b */
            /* loaded from: classes32.dex */
            class b implements DialogInterface.OnCancelListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    ms.a.f(AEBaseCameraUnit.this.f61816f, "PermissionDialog--onCancel");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                DialogUtil.showPermissionSettingDialog(AEBaseCameraUnit.this.f61817h.getActivity(), null, permissionWording, aVar, aVar, new b());
            }
        });
    }

    public void l0() {
        if (!S()) {
            ms.a.c(this.f61816f, "stopPreview---EXIT, not called by the top unit");
        } else {
            this.f61819m.cameraStopPreview();
        }
    }

    public void m0(boolean z16) {
        try {
            QQLowLightFilter.enableNightMode(z16);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void o0() {
        if (gq.a.j(z().getIntent())) {
            ms.a.a(this.f61816f, "can not toggle Camera in ar cake mode");
        } else {
            this.f61819m.toggleCamera(new a());
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitInitListener
    public void onAEKitInited() {
        Log.d(this.f61816f, "onAEKitInited: thread = " + Thread.currentThread().getName());
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        super.onActivityPause();
        this.X = false;
        this.E.onPause();
        l0();
        w(false);
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        super.onActivityResume();
        this.X = true;
        this.E.onResume();
        l0();
        w(false);
        this.Z = N();
        q0();
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchAllEssentialBundles();
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        X(false);
        this.Z = N();
        if (bundle != null) {
            this.L = (AEVideoCaptureResult) bundle.getSerializable("KEY_VIDEO_RESULT");
            this.Q = bundle.getInt("KEY_IDENTITY_CODE_SAVE");
            ms.a.f(this.f61816f, "onCreate, restore from background, ID=" + this.Q);
        } else {
            this.Q = f61814b0.size() + 1;
            ms.a.f(this.f61816f, "onCreate, new created, ID=" + this.Q);
        }
        this.C.b();
        uq.a.registerModule();
        LinkedList<Integer> linkedList = f61814b0;
        if (!linkedList.contains(Integer.valueOf(this.Q))) {
            linkedList.push(Integer.valueOf(this.Q));
        }
        z().registerReceiver(B(), A());
        ms.a.f(this.f61816f, "onCreate, ID=" + this.Q + ", sUnitStack=" + linkedList);
    }

    @Override // com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        super.onDestroy();
        z().unregisterReceiver(B());
        w(true);
        GLGestureProxy.getInstance().removeAllListener();
        PlayDownloadManagerWrap.getInstance().clearObserver();
        this.E.onDestroy();
        com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().i();
        X(true);
        AECameraManager aECameraManager = this.f61819m;
        if (aECameraManager != null) {
            aECameraManager.release();
        }
        if (S()) {
            f61814b0.pop();
            ms.a.f(this.f61816f, "onDestroy, is on top, ID=" + this.Q);
        } else {
            ms.a.f(this.f61816f, "onDestroy, is NOT on top, ID=" + this.Q);
        }
        ms.a.f(this.f61816f, "onDestroy, ID=" + this.Q + ", sUnitStack=" + f61814b0);
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("KEY_VIDEO_RESULT", this.L);
        bundle.putInt("KEY_IDENTITY_CODE_SAVE", this.Q);
        ms.a.f(this.f61816f, "onSaveInstanceState---destroyed in background, ID=" + this.Q);
    }

    public void p0() {
        ms.a.f(this.f61816f, "tryOpenCamera---ENTER");
        if (!S()) {
            ms.a.c(this.f61816f, "tryOpenCamera---EXIT, not called by the top unit");
            return;
        }
        AECaptureMode aECaptureMode = this.U;
        if (aECaptureMode != null && aECaptureMode.shouldStartCamera()) {
            this.f61819m.openCamera(new b());
            return;
        }
        ms.a.c(this.f61816f, "tryOpenCamera---EXIT, not right mode: " + aECaptureMode);
    }

    @Override // com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        U("unitInflateView-begin");
        this.D = z().getLayoutInflater().inflate(K(), (ViewGroup) null, false);
        U("unitInflateView-end");
        t();
        e0();
        return this.D;
    }

    protected void q0() {
        if (this.Z) {
            p0();
        } else if (!this.Y) {
            this.Y = true;
            b0();
        } else {
            j0();
        }
    }

    public void r0() {
        ms.a.f(this.f61816f, "tryStartPreview---ENTER");
        if (!S()) {
            ms.a.c(this.f61816f, "tryStartPreview---EXIT, not called by the top unit");
            com.tencent.aelight.camera.report.atta.d.d("cam_startup_failed", null, Arrays.asList(Long.valueOf(com.tencent.aelight.camera.report.atta.e.a(z())), Long.valueOf(com.tencent.aelight.camera.report.atta.e.b())));
            return;
        }
        if (!this.X) {
            ms.a.c(this.f61816f, "tryStartPreview---EXIT, activity not resumed");
            com.tencent.aelight.camera.report.atta.d.d("cam_startup_failed", null, Arrays.asList(Long.valueOf(com.tencent.aelight.camera.report.atta.e.a(z())), Long.valueOf(com.tencent.aelight.camera.report.atta.e.b())));
            return;
        }
        AECaptureMode aECaptureMode = this.U;
        if (aECaptureMode != null && aECaptureMode.shouldStartCamera()) {
            if (this.I == null) {
                ms.a.c(this.f61816f, "tryStartPreview---EXIT, mPreviewTexture is NULL");
                com.tencent.aelight.camera.report.atta.d.d("cam_startup_failed", null, Arrays.asList(Long.valueOf(com.tencent.aelight.camera.report.atta.e.a(z())), Long.valueOf(com.tencent.aelight.camera.report.atta.e.b())));
                return;
            }
            if (com.tencent.aelight.camera.ae.util.h.a() == null) {
                ms.a.c(this.f61816f, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
                com.tencent.aelight.camera.report.atta.d.d("cam_startup_failed", null, Arrays.asList(Long.valueOf(com.tencent.aelight.camera.report.atta.e.a(z())), Long.valueOf(com.tencent.aelight.camera.report.atta.e.b())));
                return;
            }
            if (!Q()) {
                this.T = AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.f().g(AECameraConstants.SP_KEY_AE_CAMERA_RATIO, AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
            }
            ms.a.a(this.f61816f, "tryStartPreview---EXIT,mCurrentRatio" + this.T);
            com.tencent.mobileqq.activity.richmedia.i b16 = com.tencent.aelight.camera.ae.util.h.b(aECaptureMode, com.tencent.aelight.camera.ae.util.h.a(), this.T);
            this.f61819m.setCameraManagerListener(E());
            this.f61819m.startCameraPreview(this.I, b16);
            ms.a.f(this.f61816f, "tryStartPreview---EXIT, normal");
            return;
        }
        ms.a.c(this.f61816f, "tryStartPreview---EXIT, not right mode: " + aECaptureMode);
        com.tencent.aelight.camera.report.atta.d.d("cam_startup_failed", null, Arrays.asList(Long.valueOf(com.tencent.aelight.camera.report.atta.e.a(z())), Long.valueOf(com.tencent.aelight.camera.report.atta.e.b())));
    }

    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void reportFirstFrameShown() {
        com.tencent.aelight.camera.ae.report.b.b().r(this.f61819m.isSupportCamera2() ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        this.J = (LinearLayout) this.D.findViewById(R.id.rov);
        this.K = (RelativeLayout) this.D.findViewById(R.id.rou);
        this.E = (AECameraGLSurfaceView) this.D.findViewById(R.id.rq9);
        this.G = (ViewStub) this.D.findViewById(R.id.f163794s15);
    }

    protected void u() {
        int i3;
        if (this.f61819m.isFlashEnabled()) {
            this.f61819m.turnFlash(z(), true);
            i3 = 1500;
        } else {
            i3 = 0;
        }
        this.E.capturePhotoByAEKit(i3);
    }

    protected void v() {
        AECaptureMode aECaptureMode = this.U;
        if (aECaptureMode == null || !aECaptureMode.shouldStartCamera() || com.tencent.aelight.camera.ae.util.h.a() == null) {
            return;
        }
        if (this.f61819m.isFlashEnabled()) {
            this.f61819m.turnFlash(z(), true);
        }
        com.tencent.mobileqq.activity.richmedia.i b16 = com.tencent.aelight.camera.ae.util.h.b(this.U, com.tencent.aelight.camera.ae.util.h.a(), this.T);
        String str = this.E.getCaptureDir() + "/" + System.currentTimeMillis() + ".jpg";
        FileUtils.createFileIfNotExits(str);
        File file = new File(str);
        this.f61819m.isFrontCamera();
        this.f61819m.capturePhoto(file, this.W.u() ? com.tencent.aelight.camera.ae.flashshow.util.g.e(this.f61819m.getActivityOrientation()) : 0, new e(), b16);
    }

    public void w(boolean z16) {
        if (!S()) {
            ms.a.c(this.f61816f, "closeCamera---EXIT, not called by the top unit");
        } else {
            this.f61819m.stopCamera(z16);
        }
    }

    protected com.tencent.aelight.camera.ae.a y() {
        return x();
    }

    public Activity z() {
        or.e eVar = this.f61817h;
        if (eVar == null) {
            return null;
        }
        return eVar.getActivity();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements AECameraManager.CameraOpenCallback {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
        public void onOpenResult(int i3, boolean z16) {
            if (z16) {
                AEBaseCameraUnit.this.E.onChangeCamera(i3);
                if (AEBaseCameraUnit.this.V()) {
                    AEBaseCameraUnit.this.d0(i3);
                }
                AEBaseCameraUnit.this.Y();
                AEBaseCameraUnit.this.r0();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n0(boolean z16) {
        boolean z17;
        if (z16) {
            Activity z18 = z();
            if (!Settings.System.canWrite(z18)) {
                DialogUtil.showWriteSetting(z18, null, null);
                z17 = false;
                if (z17) {
                    this.f61819m.switchFlash(z16);
                }
                return z17;
            }
        }
        z17 = true;
        if (z17) {
        }
        return z17;
    }

    protected com.tencent.aelight.camera.ae.a x() {
        a.b bVar = new a.b();
        Intent intent = z().getIntent();
        if (intent != null && intent.getExtras() != null) {
            boolean b16 = com.tencent.aelight.camera.ae.util.c.b(intent, this.f61816f);
            ms.a.f(this.f61816f, "extractAECameraConfigFromIntent enableAudio = " + b16);
            int i3 = intent.getExtras().getInt(AECameraConstants.ARG_CAPTURE_MAX_DURATION, -1);
            boolean z16 = intent.getExtras().getBoolean(PeakConstants.ARG_SUPPORT_FILTER, true);
            boolean z17 = intent.getExtras().getBoolean(PeakConstants.ARG_SUPPORT_DD, true);
            boolean z18 = intent.getExtras().getBoolean(PeakConstants.ARG_BEAUTY, true);
            boolean z19 = intent.getExtras().getBoolean(PeakConstants.ARG_SHARP_FACE, true);
            boolean z26 = intent.getExtras().getBoolean(PeakConstants.ARG_ALBUM, true);
            int i16 = intent.getExtras().getInt(AECameraConstants.ARG_DEFAULT_OPEN_PANEL, -1);
            int i17 = intent.getExtras().getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
            int i18 = intent.getExtras().getInt(IJumpUtil.EDIT_VIDEO_WAY, 0);
            int i19 = intent.getExtras().getInt("entrance_type", 120);
            int i26 = intent.getExtras().getInt(PeakConstants.BUSI_TYPE, 14);
            SessionWrap sessionWrap = (SessionWrap) intent.getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
            String stringExtra = intent.getStringExtra(AECameraConstants.ARG_AIO_CLASS);
            int i27 = intent.getExtras().getInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, -1);
            int i28 = intent.getExtras().getInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, -1);
            int i29 = intent.getExtras().getInt("ability_flag", -1);
            int intExtra = intent.getIntExtra(AECameraConstants.AECAMERA_MODE, 200);
            boolean booleanExtra = intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_USE_VIDEO_ORIENTATION, true);
            boolean booleanExtra2 = intent.getBooleanExtra(AECameraConstants.KEY_CAMERA_AUTO_ROTATE, true);
            this.S = L(intExtra);
            this.R = I(intExtra);
            boolean booleanExtra3 = z().getIntent().getBooleanExtra(AECameraConstants.KEY_HAS_COUNTDOWN, false);
            bVar.S(i17).Y(intent.getIntExtra(AECameraConstants.KEY_CAMERA_RESULT_CODE, -1)).L(b16).M(z18).I(i16).O(z16).V(i3).Q(z19).P(z17).a0(z26).G(i29).R(i19).F(i26).K(i18).W(i27).c0(i28).E(booleanExtra2).b0(booleanExtra).T(booleanExtra3).H(intExtra).U(this.R).N(this.S).Z(sessionWrap).D(stringExtra).X(H()).J(intent.getIntExtra(PeakConstants.ARG_FORCE_CAMERA, 0));
        }
        return bVar.C();
    }

    public AEBaseCameraUnit(or.e eVar, or.d dVar) {
        String str = AECameraConstants.TAG + getClass().getSimpleName();
        this.f61816f = str;
        this.f61819m = new AECameraManager();
        this.C = new com.tencent.aelight.camera.ae.util.b();
        this.P = new or.a(10000, 100, 2);
        this.U = null;
        this.V = 11;
        this.Y = false;
        this.Z = false;
        this.f61815a0 = new Handler(Looper.getMainLooper());
        ms.a.f(str, "[AEBaseCameraUnit] + BEGIN");
        this.f61817h = eVar;
        this.f61818i = dVar;
        AEDashboardUtil.t(z().getIntent());
        this.W = y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0() {
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void n(int i3, int i16) {
    }
}
