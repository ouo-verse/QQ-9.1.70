package com.tencent.aelight.camera.aebase.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.j;
import com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.biz.subscribe.utils.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.a;
import com.tencent.mobileqq.shortvideo.o;
import com.tencent.mobileqq.shortvideo.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureQmcfSoDownloadFragment extends BaseFragment implements View.OnClickListener, x.a, ShortVideoResourceManager.e, a.InterfaceC8592a, CameraCaptureView.f, com.tencent.aelight.camera.download.api.a {
    private CircleProgress C;
    private CameraCaptureView D;
    private TextView E;
    private QQAppInterface S;
    private String T;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean P = false;
    private boolean Q = false;
    private volatile int R = 0;
    private volatile boolean U = false;
    private volatile boolean V = false;
    private volatile boolean W = false;

    private boolean Ah() {
        return this.M && this.N && this.P && this.Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bh() {
        return false;
    }

    private void Fh(ShortVideoResourceManager.SVConfigItem sVConfigItem) {
        sVConfigItem.name = "new_qq_android_native_short_video_67";
        sVConfigItem.arm_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_test.zip";
        sVConfigItem.armv7a_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_test.zip";
        sVConfigItem.x86_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_test.zip";
        sVConfigItem.arm64v8a_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_new.zip";
        sVConfigItem.arm_md5 = "a679405ee702c0b96d35cf8676372368";
        sVConfigItem.armv7a_md5 = "a679405ee702c0b96d35cf8676372368";
        sVConfigItem.x86_md5 = "a679405ee702c0b96d35cf8676372368";
        sVConfigItem.arm64v8a_md5 = "fa9cec0ed8f7017e3d086bd94a2f4d41";
        sVConfigItem.versionCode = 67;
        sVConfigItem.predownload = false;
    }

    private void Gh(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.3
            @Override // java.lang.Runnable
            public void run() {
                CaptureQmcfSoDownloadFragment.this.E.setText(str);
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureQmcfSoDownloadFragment", 2, "setTipsTextData: textData=" + str);
                }
            }
        });
    }

    private void Hh() {
        if (Bh()) {
            Gh(HardCodeUtil.qqStr(R.string.k8u) + ((this.K + this.R) / 2) + "%");
            return;
        }
        Gh(HardCodeUtil.qqStr(R.string.f171696k93) + this.K + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        if (Bh()) {
            if (this.L && this.R > 100 && Ah()) {
                Ch();
                return;
            }
            return;
        }
        ms.a.f("CaptureQmcfSoDownloadFragment", "[isAvCodecDownloaded]" + this.L);
        ms.a.f("CaptureQmcfSoDownloadFragment", "[isAEKitBaseDownloaded]" + this.M);
        if (this.L && Ah()) {
            Ch();
        }
    }

    private void Kh() {
        this.K = ((((this.F + this.G) + this.H) + this.I) + this.J) / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(final String str) {
        Hh();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (CaptureQmcfSoDownloadFragment.this.Bh()) {
                    CaptureQmcfSoDownloadFragment.this.C.setProgress((CaptureQmcfSoDownloadFragment.this.K + CaptureQmcfSoDownloadFragment.this.R) / 2);
                    if (QLog.isColorLevel()) {
                        QLog.d("CaptureQmcfSoDownloadFragment", 2, "" + str + " setProgress=" + ((CaptureQmcfSoDownloadFragment.this.K + CaptureQmcfSoDownloadFragment.this.R) / 2));
                    }
                    CaptureQmcfSoDownloadFragment.this.Jh();
                    return;
                }
                CaptureQmcfSoDownloadFragment.this.C.setProgress(CaptureQmcfSoDownloadFragment.this.K);
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureQmcfSoDownloadFragment", 2, "" + str + " setProgress=" + CaptureQmcfSoDownloadFragment.this.F);
                }
            }
        });
    }

    protected synchronized void Ch() {
        hs.a aVar;
        this.W = true;
        if ((!this.U || this.V) && (aVar = (hs.a) getBaseActivity()) != null) {
            aVar.onFinish();
        }
    }

    public void Eh() {
        QQAppInterface qQAppInterface = this.S;
        if (qQAppInterface != null) {
            ShortVideoResourceManager.k(qQAppInterface, this);
            this.S = null;
        }
        AEResManager.J().p0(this);
    }

    @Override // com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.f
    public void H2() {
        if (getBaseActivity() instanceof CaptureQmcfSoDownloadActivity) {
            CaptureQmcfSoDownloadActivity captureQmcfSoDownloadActivity = (CaptureQmcfSoDownloadActivity) getBaseActivity();
            if (captureQmcfSoDownloadActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                this.U = true;
                captureQmcfSoDownloadActivity.requestPermissions(this, 1, QQPermissionConstants.Permission.CAMERA);
            }
        }
    }

    protected int getLayoutId() {
        return R.layout.dot;
    }

    @QQPermissionGrant(1)
    public synchronized void grant() {
        this.V = true;
        if (this.W) {
            hs.a aVar = (hs.a) getBaseActivity();
            if (aVar != null) {
                aVar.onFinish();
            }
        } else {
            this.D.setCameraPermissionResult(true);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.gesture.a.InterfaceC8592a
    public void l8(final boolean z16, boolean z17, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureQmcfSoDownloadFragment", 2, "onStatusChanged: " + z16 + " error:" + i3);
                }
                if (z16) {
                    CaptureQmcfSoDownloadFragment.this.R = 101;
                    CaptureQmcfSoDownloadFragment.this.zh("onStatusChanged");
                } else {
                    QQToast.makeText(BaseApplication.getContext(), R.string.f173072h35, 0).show();
                    CaptureQmcfSoDownloadFragment.this.R = -1;
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
        ms.a.f("CaptureQmcfSoDownloadFragment", "\u3010onAEResDownloadResult\u3011[packageIdx] :" + aEResInfo.index + "[isDownloaded] :" + z16 + "[errorType] :" + i3);
        if (aEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
            if (z16) {
                ms.a.c("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] success, package=" + aEResInfo.description);
                this.G = 100;
                Kh();
                zh("doUserDownloadResource:");
                this.M = true;
                Jh();
                return;
            }
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + i3);
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k89) + i3 + "]", null);
            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8o));
            o.b(2, i3);
            return;
        }
        if (aEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
            if (z16) {
                ms.a.c("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] success, package=" + aEResInfo.description);
                this.H = 100;
                Kh();
                zh("doUserDownloadResource:");
                this.N = true;
                Jh();
                return;
            }
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + i3);
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k89) + i3 + "]", null);
            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8o));
            o.b(2, i3);
            return;
        }
        if (aEResInfo == AEResInfo.LIGHT_RES_BUNDLE_FACE) {
            if (z16) {
                this.I = 100;
                Kh();
                zh("doUserDownloadResource:");
                this.P = true;
                Jh();
                return;
            }
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + i3);
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k89) + i3 + "]", null);
            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8o));
            return;
        }
        if (aEResInfo == AEResInfo.LIGHT_RES_BUNDLE_BG_SEG) {
            if (z16) {
                this.J = 100;
                Kh();
                zh("doUserDownloadResource:");
                this.Q = true;
                Jh();
                return;
            }
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + i3);
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k89) + i3 + "]", null);
            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8o));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.rqg) {
            getBaseActivity().doOnBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.shortvideo.x.a
    public void onConfigResult(int i3, int i16) {
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "result=" + i3 + ",serverError=" + i16, null);
        if (i3 != 1 && i3 != 0) {
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onConfigResult]result:" + i3);
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k8y) + i16 + "]", null);
            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8q) + "result:" + i3);
            o.b(1, i16);
            return;
        }
        if (i16 != 0) {
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onConfigResult]:serverError" + i16);
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k86) + i16 + "]", null);
            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8l) + "serverError" + i16);
            o.b(1, i16);
            ShortVideoResourceManager.s(this.S, this);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        int f16 = ShortVideoResourceManager.f(this.S, arrayList);
        if (f16 == 0) {
            ms.a.c("CaptureQmcfSoDownloadFragment", "[onConfigResult]:success");
            VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.f171693k90), null);
            ShortVideoResourceManager.q(this.S, arrayList, this);
            return;
        }
        if (f16 == -2) {
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                Fh((ShortVideoResourceManager.SVConfigItem) arrayList.get(i17));
            }
            ms.a.c("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.y5s));
            ShortVideoResourceManager.q(this.S, arrayList, this);
            return;
        }
        if (f16 == -101) {
            ShortVideoResourceManager.SVConfigItem sVConfigItem = new ShortVideoResourceManager.SVConfigItem();
            Fh(sVConfigItem);
            arrayList.add(sVConfigItem);
            ms.a.c("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.y5t));
            ShortVideoResourceManager.q(this.S, arrayList, this);
            return;
        }
        ms.a.c("CaptureQmcfSoDownloadFragment", "[onConfigResult]:errCode" + f16);
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k8k) + f16 + "]", null);
        ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k88) + "errorCode:" + f16);
        o.b(1, f16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        CameraCaptureView cameraCaptureView = (CameraCaptureView) inflate.findViewById(R.id.rq9);
        this.D = cameraCaptureView;
        cameraCaptureView.setDarkModeEnable(false);
        this.D.setCameraPermissionListener(this);
        CameraCaptureView.h i3 = j.h().i(inflate.getContext());
        i3.f(false);
        this.D.g(false);
        this.D.setCaptureParam(i3);
        ((Button) inflate.findViewById(R.id.rqg)).setOnClickListener(this);
        CircleProgress circleProgress = (CircleProgress) inflate.findViewById(R.id.rrh);
        this.C = circleProgress;
        circleProgress.setBgAndProgressColor(100, getResources().getColor(R.color.f158017al3), 100, getResources().getColor(R.color.f156818c9));
        this.C.setStrokeWidth(6.0f);
        this.C.setProgress(0.0f);
        this.C.setOnClickListener(this);
        this.E = (TextView) inflate.findViewById(R.id.ru5);
        this.S = (QQAppInterface) getBaseActivity().getAppInterface();
        boolean supportShortVideoRecordAndPlay = VideoEnvironment.supportShortVideoRecordAndPlay();
        this.T = getBaseActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
        if (!supportShortVideoRecordAndPlay) {
            QQToast.makeText(VideoEnvironment.getContext(), HardCodeUtil.qqStr(R.string.k8m), 1);
        } else {
            if (Bh()) {
                Dh();
            } else {
                this.R = 101;
            }
            boolean checkAndLoadAVCodec = VideoEnvironment.checkAndLoadAVCodec();
            boolean z16 = AEResUtil.n(AEResInfo.AE_RES_BASE_PACKAGE.agentType, "qq_aio") != 2;
            boolean z17 = AEResUtil.n(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType, "qq_aio") != 2;
            boolean U = AEResUtil.U(AEResInfo.LIGHT_RES_BUNDLE_FACE);
            boolean V = AEResUtil.V("BG_SEG_AGENT");
            if (checkAndLoadAVCodec && z16 && z17 && U && V) {
                ms.a.c("CaptureQmcfSoDownloadFragment", "\u3010START\u3011onSoDownloadCompleted()");
                VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.T, null);
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CaptureQmcfSoDownloadFragment.this.Ch();
                    }
                }, 5L);
            } else {
                if (!checkAndLoadAVCodec) {
                    o.d(2);
                    ms.a.c("CaptureQmcfSoDownloadFragment", "\u3010START\u3011startDownloadAVCodec");
                    ShortVideoResourceManager.s(this.S, this);
                } else {
                    ms.a.c("CaptureQmcfSoDownloadFragment", "\u3010START\u3011AVcodec isReady");
                    this.L = true;
                    this.F = 100;
                }
                this.P = U;
                this.Q = V;
                if (z16 && z17 && U && V) {
                    ms.a.c("CaptureQmcfSoDownloadFragment", "\u3010START\u3011isAEKitBaseDownloaded=true, isLightBaseDownloaded=true");
                    this.M = true;
                    this.N = true;
                    this.G = 100;
                    this.H = 100;
                    this.I = 100;
                    this.J = 100;
                } else {
                    ms.a.c("CaptureQmcfSoDownloadFragment", "\u3010START\u3011startDownloadAEKitBase / LightBase");
                    if (z16) {
                        this.M = true;
                    }
                    if (z17) {
                        this.N = true;
                    }
                    Ih(z16, z17, U, V);
                }
            }
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.shortvideo.gesture.a.c().a(false, this);
        if (QLog.isDevelopLevel()) {
            QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
        }
        Eh();
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
    public void onDownloadFinish(String str, int i3, String str2) {
        if (str.startsWith("new_qq_android_native_short_video_")) {
            if (i3 != 0) {
                ms.a.c("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] error result" + i3);
                VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.f171697k94) + i3 + "]", null);
                ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.k8h));
                o.b(2, i3);
            } else {
                ms.a.c("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] success");
                this.F = 100;
                this.L = true;
                Jh();
            }
        }
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "name=" + str + ",result=" + i3 + ",filePath=" + str2, null);
    }

    @Override // com.tencent.mobileqq.shortvideo.gesture.a.InterfaceC8592a
    public void onDownloadProgress(final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.6
            @Override // java.lang.Runnable
            public void run() {
                CaptureQmcfSoDownloadFragment.this.R = i3;
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureQmcfSoDownloadFragment", 2, "onDownloadProgress mGestureState=" + CaptureQmcfSoDownloadFragment.this.R + " mVideoState=" + CaptureQmcfSoDownloadFragment.this.F);
                }
                CaptureQmcfSoDownloadFragment.this.zh("GestureDownloadProgress");
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.D.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.D.onResume();
        if (Build.VERSION.SDK_INT >= 29) {
            g.c(getBaseActivity().getWindow());
        }
    }

    private void Ih(boolean z16, boolean z17, boolean z18, boolean z19) {
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(null);
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + isNetworkAvailable, null);
        if (!isNetworkAvailable) {
            ms.a.c("CaptureQmcfSoDownloadFragment", "\u3010END\u3011startDownloadGyBase:" + HardCodeUtil.qqStr(R.string.k8_));
            Gh(HardCodeUtil.qqStr(R.string.k8_));
            return;
        }
        if (!z16) {
            AEResManager.J().w0(AEResInfo.AGENT_TYPE_AE_BASE_RES, this, false);
        }
        if (!z17) {
            AEResManager.J().w0(AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE, this, false);
        }
        if (!z18) {
            AEResManager.J().w0(AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType, this, false);
        }
        if (z19) {
            return;
        }
        AEResManager.J().w0("BG_SEG_AGENT", this, false);
    }

    public void Dh() {
        this.R = 0;
        com.tencent.mobileqq.shortvideo.gesture.a.c().a(true, this);
        boolean b16 = com.tencent.mobileqq.shortvideo.gesture.a.c().b();
        if (QLog.isColorLevel()) {
            QLog.d("CaptureQmcfSoDownloadFragment", 2, "preDownloadGestureRes:" + b16);
        }
        if (!b16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.shortvideo.gesture.a.c().f();
                }
            });
        } else {
            this.R = 101;
        }
    }

    @QQPermissionDenied(1)
    public void denied() {
        this.V = false;
        getBaseActivity().checkSelfPermission(QQPermissionConstants.Permission.CAMERA);
        final String permissionWording = DialogUtil.getPermissionWording(QQPermissionConstants.Permission.CAMERA);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment.7

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment$7$a */
            /* loaded from: classes32.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    BaseActivity baseActivity = CaptureQmcfSoDownloadFragment.this.getBaseActivity();
                    if (i3 == 1) {
                        CaptureQmcfSoDownloadFragment.this.D.setCameraPermissionResult(false);
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", baseActivity.getPackageName(), null));
                        baseActivity.startActivity(intent);
                        return;
                    }
                    baseActivity.finish();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment$7$b */
            /* loaded from: classes32.dex */
            class b implements DialogInterface.OnCancelListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    CaptureQmcfSoDownloadFragment.this.D.setCameraPermissionResult(false);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                DialogUtil.showPermissionSettingDialog(CaptureQmcfSoDownloadFragment.this.getBaseActivity(), null, permissionWording, aVar, aVar, new b());
            }
        });
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
    public void onNetWorkNone() {
        Gh(HardCodeUtil.qqStr(R.string.k8i));
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.qqStr(R.string.k87), null);
        o.b(3, LightConstants.ErrorCode.BONE_NOT_SUPPORT);
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        int i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
        if (aEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
            this.G = i3;
        } else if (aEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
            this.H = i3;
        } else if (aEResInfo == AEResInfo.LIGHT_RES_BUNDLE_FACE) {
            this.I = i3;
        } else if (aEResInfo == AEResInfo.LIGHT_RES_BUNDLE_BG_SEG) {
            this.J = i3;
        }
        Kh();
        zh("doUserDownloadResource:");
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "packageIdx=" + aEResInfo.index + ",totalLen=" + j16 + ",curOffset=" + j3 + ",localProgress=" + i3, null);
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
    public void onUpdateProgress(String str, long j3, long j16) {
        int i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
        if (str.startsWith("new_qq_android_native_short_video_")) {
            this.F = i3;
        }
        Kh();
        zh("doUserDownloadResource:");
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "name=" + str + ",totalLen=" + j16 + ",curOffset=" + j3 + ",localProgress=" + i3, null);
    }
}
