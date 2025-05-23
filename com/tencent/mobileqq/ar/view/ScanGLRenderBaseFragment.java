package com.tencent.mobileqq.ar.view;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IARGLSurfaceViewUtilApi;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes11.dex */
public abstract class ScanGLRenderBaseFragment extends BaseFragment implements ARGLSurfaceView.d, c, CameraProxy.a, CameraProxy.c {
    protected ARGLSurfaceView C;
    protected CameraProxy E;
    protected int F;
    private SurfaceTexture G;
    protected int I;
    protected int J;
    protected com.tencent.mobileqq.ar.model.d D = new UniformGLRenderManagerImpl();
    protected boolean H = false;
    private int K = 0;
    int L = 0;

    private void ph(int i3) {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "OpenCamera mCameraOpend:" + this.E.A());
        this.E.E(i3);
    }

    private void qh() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "closeCamera");
        this.E.q();
    }

    private boolean sh() {
        try {
            return true ^ ((IARGLSurfaceViewUtilApi) QRoute.api(IARGLSurfaceViewUtilApi.class)).doNotInterceptOpenCamera(getQBaseActivity().getAppRuntime());
        } catch (Exception e16) {
            QLog.e("AREngine_ScanGLRenderFragment", 1, "shouldInterceptOpenCamera error, " + e16);
            return true;
        }
    }

    private void th() {
        if (sh() && getContext() != null && getContext().checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            QLog.d("AREngine_ScanGLRenderFragment", 1, "startCamera, camera permission not granted.");
        } else {
            ph(this.L);
            uh();
        }
    }

    private void uh() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "startCameraPreview mSurfaceReady:" + this.H + ";sCameraProxy.isCameraOpened()=" + this.E.A());
        if (this.H) {
            this.E.O(this.G);
        }
    }

    @Override // com.tencent.mobileqq.ar.view.c
    public void Ac(GL10 gl10, int i3, int i16) {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceChange");
        this.I = i3;
        this.J = i16;
        this.H = true;
        th();
    }

    @Override // com.tencent.mobileqq.ar.ARGLSurfaceView.d
    public void Qe() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onEglContextDestroy");
        this.H = false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scan_elg_destroy_close_camera", false)) {
            if (isResumed()) {
                QLog.d("AREngine_ScanGLRenderFragment", 1, "needCloseCamera isResumed");
                qh();
            }
        } else if (((IARGLSurfaceViewUtilApi) QRoute.api(IARGLSurfaceViewUtilApi.class)).isNeedCloseCamera(getQBaseActivity().getAppRuntime())) {
            QLog.d("AREngine_ScanGLRenderFragment", 1, "needCloseCamera");
            qh();
        }
        com.tencent.mobileqq.ar.model.d dVar = this.D;
        if (dVar != null) {
            dVar.stop();
        }
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.a
    public void R5(int i3, int i16) {
        boolean z16 = true;
        QLog.i("AREngine_ScanGLRenderFragment", 1, "Camera operation fail stage:" + i3);
        boolean z17 = false;
        if (isResumed()) {
            if (this.L != 1 && Camera.getNumberOfCameras() > 1) {
                int o16 = ARCamera.o(1);
                if (o16 == 1) {
                    this.L = o16;
                    th();
                } else {
                    z16 = false;
                }
                z17 = z16;
            } else {
                this.L = 0;
            }
        }
        if (!z17) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    QBaseActivity qBaseActivity = ScanGLRenderBaseFragment.this.getQBaseActivity();
                    if (qBaseActivity != null) {
                        QQToast.makeText(qBaseActivity, HardCodeUtil.qqStr(R.string.t3k), 0).show();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.a
    public void S3() {
        if (this.D != null) {
            int z16 = this.E.z();
            int y16 = this.E.y();
            this.D.s(this.F, this.G, z16, y16, this.I, this.J);
            this.K = 0;
            QLog.i("AREngine_ScanGLRenderFragment", 1, "onStartPreviewSuccess imageWidth:" + z16 + ",imageHeight:" + y16 + ",");
        }
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.c
    public boolean Yd(byte[] bArr) {
        int i3 = this.K;
        this.K = i3 + 1;
        if (i3 < 3) {
            QLog.d("AREngine_ScanGLRenderFragment", 1, "onPreviewCallback");
        }
        com.tencent.mobileqq.ar.model.d dVar = this.D;
        dVar.B(dVar.t() + 1);
        com.tencent.mobileqq.ar.model.d dVar2 = this.D;
        dVar2.x(dVar2.t());
        ARGLSurfaceView aRGLSurfaceView = this.C;
        if (aRGLSurfaceView != null) {
            try {
                aRGLSurfaceView.requestRender();
            } catch (Exception e16) {
                QLog.e("AREngine_ScanGLRenderFragment", 1, "[onPreviewCallback] requestRender error", e16);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ar.view.c
    public void mc(GL10 gl10) {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceCreate");
        this.H = false;
        this.F = GlUtil.createTexture(36197);
        this.G = new SurfaceTexture(this.F);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onConfigurationChanged.  this=" + this);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scan_config_changed_disable_close_camera", false)) {
            qh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ScanGLRenderFragment", 2, "onCreate  this=" + this);
        }
        super.onCreate(bundle);
        CameraProxy v3 = CameraProxy.v();
        this.E = v3;
        v3.M(this);
        this.E.L(this);
        if (QLog.isColorLevel()) {
            QLog.i("AREngine_ScanGLRenderFragment", 2, String.format("onCreate time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ARGLSurfaceView aRGLSurfaceView = new ARGLSurfaceView(getQBaseActivity(), null, null);
        aRGLSurfaceView.setOnEglContextDestoryListener(this);
        ViewParent parent = aRGLSurfaceView.getParent();
        if (parent != null) {
            QLog.d("AREngine_ScanGLRenderFragment", 1, String.format("onCreateView glSurfaceView has a parent? viewParent=%s", parent));
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(aRGLSurfaceView);
            }
        }
        this.C = aRGLSurfaceView;
        this.D.A(aRGLSurfaceView, getQBaseActivity());
        this.D.v(this);
        this.C.setRenderer(this.D);
        this.C.setRenderMode(0);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, aRGLSurfaceView);
        return aRGLSurfaceView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    @TargetApi(18)
    public void onDestroy() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onDestroy start.  this=" + this);
        com.tencent.mobileqq.ar.model.d dVar = this.D;
        if (dVar != null) {
            dVar.uninit();
        }
        this.E.H(this);
        this.E.t();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        ARGLSurfaceView aRGLSurfaceView = this.C;
        if (aRGLSurfaceView != null) {
            aRGLSurfaceView.onPause();
        }
        qh();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onResume");
        super.onResume();
        ARGLSurfaceView aRGLSurfaceView = this.C;
        if (aRGLSurfaceView != null) {
            aRGLSurfaceView.onResume();
        }
        th();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, "onStart");
        super.onStart();
        com.tencent.mobileqq.ar.model.d dVar = this.D;
        if (dVar != null) {
            dVar.start();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.i("AREngine_ScanGLRenderFragment", 1, DKHippyEvent.EVENT_STOP);
        super.onStop();
    }

    public com.tencent.mobileqq.ar.model.d rh() {
        return this.D;
    }
}
