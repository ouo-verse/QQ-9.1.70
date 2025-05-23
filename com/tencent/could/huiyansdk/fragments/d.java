package com.tencent.could.huiyansdk.fragments;

import android.hardware.Camera;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.could.aicamare.callback.CameraEventListener;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.api.HuiYanExtraCallBack;
import com.tencent.could.huiyansdk.api.HuiYanOperationConfigCallBack;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.entity.CameraRiskChangeInfo;
import com.tencent.could.huiyansdk.entity.CameraRiskParamConfig;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.HuiYanSdkConfig;
import com.tencent.could.huiyansdk.manager.c;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.could.huiyansdk.utils.b;
import com.tencent.could.huiyansdk.view.LoadingFrontAnimatorView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements CameraEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100087a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements HuiYanOperationConfigCallBack {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanOperationConfigCallBack
        public void onFail(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            k.a.f100197a.a(2, "AuthingFragment", "do prepare get config error: " + str);
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanOperationConfigCallBack
        public void onSuccess() {
            int netZoom;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.could.huiyansdk.manager.f fVar = f.a.f100180a;
            CameraHolder cameraHolder = d.this.f100087a.f100060o;
            Camera.Size cameraSize = cameraHolder.getCameraSize();
            fVar.getClass();
            fVar.f100170h = new WeakReference<>(cameraHolder);
            int i3 = 0;
            fVar.f100164b = false;
            fVar.f100165c = false;
            fVar.f100179q = 0;
            fVar.f100172j = 0;
            fVar.f100173k = 0;
            fVar.f100174l.clear();
            fVar.f100176n.clear();
            if (cameraSize != null) {
                fVar.f100166d = cameraSize.width;
                fVar.f100167e = cameraSize.height;
            }
            com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
            kVar.a(1, "CameraRiskManager", "startThread work thread!");
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("cameraRisk");
            fVar.f100168f = baseHandlerThread;
            baseHandlerThread.start();
            fVar.f100169g = new com.tencent.could.huiyansdk.manager.e(fVar, fVar.f100168f.getLooper());
            Camera currentCamera = cameraHolder.getCurrentCamera();
            if (currentCamera != null) {
                try {
                    Camera.Parameters parameters = currentCamera.getParameters();
                    int minExposureCompensation = parameters.getMinExposureCompensation();
                    int maxExposureCompensation = parameters.getMaxExposureCompensation();
                    if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
                        kVar.a(2, "CameraRiskManager", "not support exposure compensation");
                    } else {
                        HashMap<Float, Integer> hashMap = new HashMap<>();
                        if (fVar.f100163a == null) {
                            fVar.f100163a = new HashMap();
                        }
                        fVar.f100163a.clear();
                        float f16 = 1.0f;
                        float f17 = -1.0f;
                        while (minExposureCompensation <= maxExposureCompensation) {
                            if (minExposureCompensation != 0) {
                                float exposureCompensationStep = minExposureCompensation * parameters.getExposureCompensationStep();
                                hashMap.put(Float.valueOf(exposureCompensationStep), Integer.valueOf(minExposureCompensation));
                                if (exposureCompensationStep > f17) {
                                    f17 = exposureCompensationStep;
                                }
                                if (exposureCompensationStep < f16) {
                                    f16 = exposureCompensationStep;
                                }
                            }
                            minExposureCompensation++;
                        }
                        CameraRiskParamConfig cameraRiskParamConfig = HuiYanSdkImp.getInstance().getCameraRiskParamConfig();
                        CameraRiskChangeInfo cameraRiskChangeStageStart = cameraRiskParamConfig.getCameraRiskChangeStageStart();
                        if (cameraRiskChangeStageStart != null) {
                            cameraRiskChangeStageStart.setRealExposure(fVar.a(hashMap, cameraRiskChangeStageStart.getExposure()));
                        }
                        CameraRiskChangeInfo cameraRiskChangeStageReflect = cameraRiskParamConfig.getCameraRiskChangeStageReflect();
                        if (cameraRiskChangeStageReflect != null) {
                            cameraRiskChangeStageReflect.setRealExposure(fVar.a(hashMap, cameraRiskChangeStageReflect.getExposure()));
                        }
                        fVar.f100163a.put("0.0", 0);
                        List<Integer> zoomRatios = parameters.getZoomRatios();
                        if (zoomRatios != null && zoomRatios.size() >= 0) {
                            if (cameraRiskChangeStageStart != null) {
                                if (cameraRiskChangeStageStart.getNetZoom() == -1) {
                                    netZoom = 0;
                                } else {
                                    netZoom = cameraRiskChangeStageStart.getNetZoom();
                                }
                                TwoTuple<Integer, Integer> a16 = fVar.a(zoomRatios, netZoom);
                                cameraRiskChangeStageStart.setRealZoom(a16.first.intValue());
                                cameraRiskChangeStageStart.setZoomValue(a16.second.intValue());
                                cameraRiskParamConfig.setCameraRiskChangeStageStart(cameraRiskChangeStageStart);
                                Log.d("CameraRiskManager", "find start zoom index:" + cameraRiskChangeStageStart.getZoomValue());
                            }
                            if (cameraRiskChangeStageReflect != null) {
                                if (cameraRiskChangeStageReflect.getNetZoom() != -1) {
                                    i3 = cameraRiskChangeStageReflect.getNetZoom();
                                }
                                TwoTuple<Integer, Integer> a17 = fVar.a(zoomRatios, i3);
                                cameraRiskChangeStageReflect.setRealZoom(a17.first.intValue());
                                cameraRiskChangeStageReflect.setZoomValue(a17.second.intValue());
                                cameraRiskParamConfig.setCameraRiskChangeStageReflect(cameraRiskChangeStageReflect);
                                Log.d("CameraRiskManager", "find reflect zoom index:" + cameraRiskChangeStageStart.getZoomValue());
                            }
                            k.a.f100197a.a(1, "CameraRiskManager", "camera zoom init success!");
                        }
                        k.a.f100197a.a(2, "CameraRiskManager", "camera error zoomRatios.size() < 0");
                    }
                } catch (RuntimeException e16) {
                    k.a.f100197a.a(2, "CameraRiskManager", "initCameraExposureInfo:" + e16.getLocalizedMessage());
                }
            } else {
                kVar.a(2, "CameraRiskManager", "camera is null!");
            }
            AuthingFragment.a(d.this.f100087a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements Runnable {
            static IPatchRedirector $redirector_;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (HuiYanSdkImp.getInstance().isCurrentFinish()) {
                    k.a.f100197a.a(1, "AuthingFragment", "current check is finish! not need start CameraRisk");
                } else {
                    k.a.f100197a.a(1, "AuthingFragment", "real start stage start");
                    f.a.f100180a.a(d.this.f100087a.f100060o, 1);
                }
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                d.this.f100087a.f100068w = false;
                LoadingFrontAnimatorView loadingFrontAnimatorView = d.this.f100087a.f100054i;
                if (loadingFrontAnimatorView != null) {
                    loadingFrontAnimatorView.postDelayed(new a(), 200L);
                }
                d.this.f100087a.o();
                d.this.f100087a.a(false);
                if (d.this.f100087a.f100054i == null) {
                    return;
                }
                AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
                if (authUiConfig != null && authUiConfig.isHideFrontCircleViewOnCheck()) {
                    d.this.f100087a.f100054i.setVisibility(8);
                    return;
                } else {
                    d.this.f100087a.f100054i.setVisibility(0);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public d(AuthingFragment authingFragment) {
        this.f100087a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    @Override // com.tencent.could.aicamare.callback.CameraEventListener
    public void onAutoFocusSucceed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            Log.e("AuthingFragment", "auto focus success!");
        }
    }

    @Override // com.tencent.could.aicamare.callback.CameraEventListener
    public void onCameraClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            Log.e("AuthingFragment", "close camera success!");
        }
    }

    @Override // com.tencent.could.aicamare.callback.CameraEventListener
    public void onCameraSucceed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f100087a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ab
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.a();
                }
            });
        }
    }

    @Override // com.tencent.could.aicamare.callback.CameraEventListener
    public void onDataFrameCallBack(byte[] bArr) {
        byte[] poll;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            return;
        }
        com.tencent.could.huiyansdk.manager.f fVar = f.a.f100180a;
        if (fVar.f100164b) {
            Log.e("CameraRiskManager", "setCameraRawByte!");
            fVar.f100164b = false;
            byte[] a16 = b.a.f100299a.a();
            if (a16 == null) {
                a16 = (byte[]) bArr.clone();
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    a16[i3] = bArr[i3];
                }
            }
            if (fVar.f100169g != null) {
                Message obtainMessage = fVar.f100169g.obtainMessage();
                obtainMessage.what = 1000;
                obtainMessage.obj = a16;
                fVar.f100169g.sendMessage(obtainMessage);
            } else {
                k.a.f100197a.a(2, "CameraRiskManager", "setCameraRawByte handler is null!");
            }
        }
        HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
        if (sdkConfig != null && !sdkConfig.isJustCheckRawCamera() && this.f100087a.f100068w) {
            com.tencent.could.huiyansdk.turing.f fVar2 = f.a.f100288a;
            if (fVar2.f100282k && fVar2.f100278g != null) {
                if (fVar2.f100285n == null) {
                    k.a.f100197a.a(2, "TuringSdkHelper", "cancelWaitFirstFrameTimeOut handler == null!");
                } else if (!fVar2.f100275d) {
                    fVar2.f100275d = true;
                    k.a.f100197a.a(1, "TuringSdkHelper", "remove first frame time out event!");
                    fVar2.f100285n.removeMessages(3);
                    com.tencent.could.huiyansdk.manager.l lVar = fVar2.f100279h;
                    if (lVar != null) {
                        lVar.h();
                    }
                }
                byte[] a17 = b.a.f100299a.a();
                if (a17 == null) {
                    a17 = (byte[]) bArr.clone();
                } else {
                    for (int i16 = 0; i16 < bArr.length; i16++) {
                        a17[i16] = bArr[i16];
                    }
                }
                if (fVar2.f100273b) {
                    if (fVar2.f100278g != null) {
                        fVar2.f100278g.a(a17);
                    }
                    com.tencent.could.huiyansdk.manager.l lVar2 = fVar2.f100279h;
                    if (lVar2 != null) {
                        if (lVar2.d()) {
                            b.a.f100299a.a(a17);
                        } else if (lVar2.f100207j) {
                            b.a.f100299a.a(a17);
                        } else {
                            int i17 = lVar2.f100209l;
                            if (i17 < 5) {
                                lVar2.f100209l = i17 + 1;
                                b.a.f100299a.a(a17);
                            } else {
                                if (lVar2.f100198a.size() >= 10 && (poll = lVar2.f100198a.poll()) != null) {
                                    b.a.f100299a.a(poll);
                                }
                                lVar2.f100198a.add(a17);
                            }
                        }
                    }
                }
            } else {
                Log.d("TuringSdkHelper", "processFrame is not create!");
            }
            HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
            Camera.Size cameraSize = this.f100087a.f100060o.getCameraSize();
            huiYanBaseApi.getClass();
            if (cameraSize == null) {
                Log.e("YouTuSdkHelper", "input camera error! size is null");
            } else {
                YtSDKKitFramework.getInstance().updateWithFrameData(bArr, cameraSize.width, cameraSize.height, 1);
            }
        }
    }

    @Override // com.tencent.could.aicamare.callback.CameraEventListener
    public void onEventError(int i3, String str) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
        kVar.a(1, "AuthingFragment", "onEventError: " + i3 + " msg: " + str);
        if (i3 != 4 && i3 != 5) {
            if (i3 == 3) {
                i16 = 214;
            } else {
                i16 = 215;
            }
            if (i3 == 7) {
                i16 = 230;
                i17 = R.string.txy_set_display_orientation_error;
            } else {
                i17 = R.string.txy_inner_error;
            }
            if (i16 == 214) {
                i17 = R.string.txy_do_not_change_app_in_auth;
            }
            if (i16 == 215) {
                i17 = R.string.txy_get_or_init_camera_error;
            }
            if (this.f100087a.getContext() != null) {
                String string = this.f100087a.c().getString(i17);
                CompareResult compareResult = new CompareResult();
                compareResult.setErrorMsg(string);
                compareResult.setErrorCode(i16);
                this.f100087a.b((Object) compareResult);
                HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "OpenCameraError", string);
                HuiYanSdkImp.getInstance().sendOperateInfo("StartCamera", 1, 0L, string);
                return;
            }
            kVar.a(2, "AuthingFragment", "camera on error context is null! code " + i16);
            CommonUtils.sendErrorAndExitAuth(213, this.f100087a.c().getString(R.string.txy_inner_error) + " camera error code: " + i16);
            return;
        }
        kVar.a(2, "AuthingFragment", str);
    }

    @Override // com.tencent.could.aicamare.callback.CameraEventListener
    public void onPreviewSucceed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f100087a.f100068w = false;
            new WeakReference(this.f100087a.f100060o.getCurrentCamera());
            com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
            kVar.a(1, "AuthingFragment", "on preview succeed!");
            HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "OpenCameraSuccess", "");
            HuiYanSdkImp.getInstance().sendOperateInfo("StartCamera", 1, 1L, "");
            com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
            if (fVar.f100285n == null) {
                kVar.a(2, "TuringSdkHelper", "startTimeOutForWaitFirstFrame handler == null!");
            } else {
                kVar.a(1, "TuringSdkHelper", "start set event first frame time out!");
                Message obtainMessage = fVar.f100285n.obtainMessage();
                obtainMessage.what = 3;
                fVar.f100285n.sendMessageDelayed(obtainMessage, 5000L);
            }
            c.b.f100154a.f100142k = fVar.f100279h;
            this.f100087a.b(HuiYanSdkImp.getInstance().getSdkConfig().getPrepareFaceTimeOutMs(), HuiYanSdkImp.getInstance().getSdkConfig().isShowPrepareTimeout());
            this.f100087a.a((Runnable) new b());
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str;
        HuiYanSdkConfig sdkConfig;
        int cameraId = this.f100087a.f100060o.getCameraId();
        HuiYanExtraCallBack extraCallBack = HuiYanSdkImp.getInstance().getExtraCallBack();
        if (extraCallBack != null && (sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig()) != null) {
            extraCallBack.onCameraInfoStr(cameraId, sdkConfig.isUseBackCamera());
        }
        com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
        kVar.a(1, "AuthingFragment", "on get camera succeed!");
        com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
        if (fVar.f100282k && fVar.f100278g != null) {
            str = fVar.f100278g.a();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get auth error info, turing is not create! ");
            sb5.append(fVar.f100282k);
            sb5.append(", ");
            sb5.append(fVar.f100278g == null);
            kVar.a(2, "TuringSdkHelper", sb5.toString());
            str = "init error";
        }
        if (!TextUtils.isEmpty(str)) {
            kVar.a(2, "AuthingFragment", "turing auth error!");
            CommonUtils.sendErrorAndExitAuth(231, this.f100087a.getString(R.string.txy_turing_auth_lic_error) + " error: " + str);
            return;
        }
        AuthingFragment authingFragment = this.f100087a;
        authingFragment.getClass();
        f.a.f100180a.f100175m = new i(authingFragment);
        if (a.C1019a.f100038a.f100036e) {
            kVar.a(2, "AuthingFragment", "get config first.");
            HuiYanSdkImp.getInstance().doOnPrepare(new a());
        } else {
            kVar.a(2, "AuthingFragment", "not get config first.");
            AuthingFragment.a(this.f100087a);
        }
    }
}
