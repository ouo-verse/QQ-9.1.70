package com.tencent.mobileqq.ar.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScanGLRenderEnvFragment extends ScanGLRenderBaseFragment {
    private g M;

    private void vh() {
        boolean c16 = com.tencent.mobileqq.ar.ARRecord.e.c();
        QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("initVideoRecord support=%s", Boolean.valueOf(c16)));
        if (c16) {
            if (this.M == null) {
                this.M = new g(getQBaseActivity());
                ARVideoRecordUIControllerImpl.t().m(this.M);
            }
            com.tencent.mobileqq.ar.model.d dVar = this.D;
            if (dVar != null) {
                dVar.E(this.M);
            }
        }
    }

    public static ScanGLRenderEnvFragment wh(ARArguments aRArguments) {
        ScanGLRenderEnvFragment scanGLRenderEnvFragment = new ScanGLRenderEnvFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("AR_ARGUMENTS", aRArguments);
        scanGLRenderEnvFragment.setArguments(bundle);
        return scanGLRenderEnvFragment;
    }

    private void xh() {
        boolean c16 = com.tencent.mobileqq.ar.ARRecord.e.c();
        QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("unInitVideoRecord support=%s", Boolean.valueOf(c16)));
        if (c16) {
            com.tencent.mobileqq.ar.model.d dVar = this.D;
            if (dVar != null) {
                dVar.E(null);
            }
            ARVideoRecordUIControllerImpl.t().n(this.M);
            if (this.M != null) {
                this.M = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        vh();
        ARGLSurfaceView aRGLSurfaceView = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, aRGLSurfaceView);
        return aRGLSurfaceView;
    }

    @Override // com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
        xh();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("AREngine_ScanGLRenderEnvFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
    }

    @Override // com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
        super.onResume();
    }
}
