package com.tencent.mobileqq.qqlive.trtc.video.source.camera;

import androidx.annotation.NonNull;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.engine.c;
import com.tencent.mobileqq.qqlive.trtc.render.TRTCRenderCtrl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.trtc.TRTCCloudDef;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends com.tencent.mobileqq.qqlive.trtc.video.source.b implements com.tencent.mobileqq.qqlive.trtc.video.source.camera.a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f273400j;

    /* renamed from: f, reason: collision with root package name */
    private TXDeviceManager f273401f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f273402g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f273403h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f273404i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f273405a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61813);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RTCCameraDefine.RTCMirrorType.values().length];
            f273405a = iArr;
            try {
                iArr[RTCCameraDefine.RTCMirrorType.RTC_MIRROR_LOCAL_RENDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f273405a[RTCCameraDefine.RTCMirrorType.RTC_MIRROR_ENCODER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f273405a[RTCCameraDefine.RTCMirrorType.RTC_ALL_PIPELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61815);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f273400j = true;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273402g = false;
        this.f273403h = false;
        this.f273404i = new AtomicBoolean(false);
    }

    private void r(boolean z16) {
        this.f273403h = z16;
        this.f273396b.setVideoEncoderMirror(z16);
    }

    private void s(boolean z16) {
        int i3;
        this.f273402g = z16;
        TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        tRTCRenderParams.mirrorType = i3;
        this.f273396b.setLocalRenderParams(tRTCRenderParams);
    }

    private void t() {
        if (!((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).isHevcEncodeEnable()) {
            QLog.i("TRTCCameraCaptureSource", 1, "[enableHevcEncode] hevc disabled");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DTConstants.TAG.API, V2TXLiveProperty.kV2EnableHevcEncode);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enable", 1);
            jSONObject.put("params", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            QLog.i("TRTCCameraCaptureSource", 1, "[enableHevcEncode] json=" + jSONObject3);
            this.f273396b.callExperimentalAPI(jSONObject3);
        } catch (JSONException e16) {
            QLog.e("TRTCCameraCaptureSource", 1, "[enableHevcEncode] failed ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.b, com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void c(@NonNull c cVar) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        super.c(cVar);
        if (this.f273395a.b()) {
            this.f273401f = this.f273396b.getDeviceManager();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public void d(RTCCameraDefine.RTCMirrorType rTCMirrorType, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, rTCMirrorType, Boolean.valueOf(z16));
            return;
        }
        q();
        QLog.i("TRTCCameraCaptureSource", 1, "setMirror type:" + rTCMirrorType + " isMirror:" + z16);
        int i3 = a.f273405a[rTCMirrorType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    s(z16);
                    r(z16);
                    return;
                }
                return;
            }
            r(z16);
            return;
        }
        s(z16);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.b, com.tencent.mobileqq.qqlive.trtc.video.source.a
    public synchronized void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.destroy();
        this.f273404i.set(false);
        this.f273401f = null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public int getCameraId() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (f273400j) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public boolean l(RTCCameraDefine.RTCMirrorType rTCMirrorType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) rTCMirrorType)).booleanValue();
        }
        int i3 = a.f273405a[rTCMirrorType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                if (this.f273402g && this.f273403h) {
                    return true;
                }
                return false;
            }
            return this.f273403h;
        }
        return this.f273402g;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        q();
        return this.f273404i.get();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return l(RTCCameraDefine.RTCMirrorType.RTC_ALL_PIPELINE);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public void p(@NonNull com.tencent.mobileqq.qqlive.trtc.render.a aVar) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        q();
        if (aVar instanceof TRTCRenderCtrl) {
            TRTCVideoQualityParams tRTCVideoQualityParams = this.f273399e;
            if (tRTCVideoQualityParams != null) {
                this.f273396b.setVideoEncoderParam(com.tencent.mobileqq.qqlive.trtc.utils.a.j(tRTCVideoQualityParams));
            }
            t();
            this.f273396b.setGSensorMode(0);
            this.f273396b.startLocalPreview(f273400j, ((TRTCRenderCtrl) aVar).e());
            this.f273404i.set(true);
            return;
        }
        throw new IllegalStateException("startCapture failed!, please use TRTCRenderCtrl!");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public void setMirror(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            q();
            d(RTCCameraDefine.RTCMirrorType.RTC_ALL_PIPELINE, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public void stopCapture() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        q();
        this.f273396b.stopLocalPreview();
        this.f273404i.set(false);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.camera.a
    public void switchCamera() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        q();
        f273400j = !f273400j;
        this.f273401f.switchCamera(f273400j);
    }
}
