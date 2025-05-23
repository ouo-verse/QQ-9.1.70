package com.tencent.biz.richframework.video.rfw.player.strategy;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.utils.SuperPlayerAV1MediaCodecDetectUtils;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import uq3.k;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerAV1DecodeStrategyV2 {
    private static volatile RFWPlayerAV1DecodeStrategyV2 sInstance;
    private volatile boolean mHasDetect = false;
    private IShiplyVersion mShiplyVerionImpl;

    /* loaded from: classes5.dex */
    public interface IShiplyVersion {
        boolean isTargetVersion(String str, long j3);
    }

    RFWPlayerAV1DecodeStrategyV2() {
    }

    private boolean conNotDetect() {
        if (!o.k()) {
            return true;
        }
        if (QCircleVideoDeviceInfoUtils.isLowDevice()) {
            QLog.d("RFWPlayerAV1DecodeStrategyV2", 1, "is low device ");
            return true;
        }
        if (!k.a().c("MMKV_KEY_AV1_HAS_DETECT", false) && !this.mHasDetect) {
            return false;
        }
        QLog.d("RFWPlayerAV1DecodeStrategyV2", 1, "has detect:" + k.a().c("MMKV_KEY_AV1_HAS_DETECT", false) + " |" + this.mHasDetect);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doSubThreadDetect() {
        if (conNotDetect()) {
            return;
        }
        if (!isTargetPlayerCoreSo()) {
            QLog.d("RFWPlayerAV1DecodeStrategyV2", 1, "is not target version");
            return;
        }
        this.mHasDetect = true;
        try {
            SuperPlayerAV1MediaCodecDetectUtils.a("https://downv6.qq.com/video_story/50040_0b532orhlwyboiai3dfsfztxtu6dox6qc22a.f102212.mp4", 5220L, 174, 300000, new SuperPlayerAV1MediaCodecDetectUtils.d() { // from class: com.tencent.biz.richframework.video.rfw.player.strategy.c
                @Override // com.tencent.superplayer.utils.SuperPlayerAV1MediaCodecDetectUtils.d
                public final void a(SuperPlayerAV1MediaCodecDetectUtils.e eVar) {
                    RFWPlayerAV1DecodeStrategyV2.lambda$doSubThreadDetect$1(eVar);
                }
            });
        } catch (Exception e16) {
            QLog.e("RFWPlayerAV1DecodeStrategyV2", 1, e16, new Object[0]);
        }
    }

    public static RFWPlayerAV1DecodeStrategyV2 g() {
        if (sInstance == null) {
            synchronized (RFWPlayerAV1DecodeStrategyV2.class) {
                if (sInstance == null) {
                    sInstance = new RFWPlayerAV1DecodeStrategyV2();
                }
            }
        }
        return sInstance;
    }

    private boolean isTargetPlayerCoreSo() {
        IShiplyVersion iShiplyVersion = this.mShiplyVerionImpl;
        if (iShiplyVersion != null && iShiplyVersion.isTargetVersion(SoLoadConstants.SONAME_TPCORE_MASTER, 30163L)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doSubThreadDetect$1(SuperPlayerAV1MediaCodecDetectUtils.e eVar) {
        if (eVar == null) {
            return;
        }
        QLog.d("RFWPlayerAV1DecodeStrategyV2", 1, "detectAV1MediaCodecSupport result :" + eVar);
        if (!eVar.b()) {
            QCircleQualityReporter.reportQualityEvent("av1_detect_result", Arrays.asList(QCircleReportHelper.newEntry("ret_code", String.valueOf(0))), false);
            k.a().j("MMKV_KEY_AV1_DETECT_RESULT", false);
            k.a().j("MMKV_KEY_AV1_HAS_DETECT", true);
        } else {
            if (eVar.c()) {
                return;
            }
            if (eVar.a()) {
                QCircleQualityReporter.reportQualityEvent("av1_detect_result", Arrays.asList(QCircleReportHelper.newEntry("ret_code", String.valueOf(1))), false);
                k.a().j("MMKV_KEY_AV1_DETECT_RESULT", true);
                k.a().j("MMKV_KEY_AV1_HAS_DETECT", true);
            } else {
                QCircleQualityReporter.reportQualityEvent("av1_detect_result", Arrays.asList(QCircleReportHelper.newEntry("ret_code", String.valueOf(2))), false);
                k.a().j("MMKV_KEY_AV1_DETECT_RESULT", false);
                k.a().j("MMKV_KEY_AV1_HAS_DETECT", true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerDetect$0(boolean z16) {
        if (z16) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.strategy.b
                @Override // java.lang.Runnable
                public final void run() {
                    RFWPlayerAV1DecodeStrategyV2.this.doSubThreadDetect();
                }
            }, 30000L);
        }
    }

    public void addExpToQFSPlayerReport(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return;
        }
        try {
            if (k.a().c("MMKV_KEY_AV1_HAS_DETECT", false)) {
                if (k.a().c("MMKV_KEY_AV1_DETECT_RESULT", false)) {
                    str = "AV1MediacodecEnable";
                } else {
                    str = "AV1MediacodecUnable";
                }
                jSONObject.put("s27", str);
                QQVideoPlaySDKManager.addSuperGlobalReportData("param_bucket4", str);
            }
        } catch (JSONException e16) {
            RFWLog.e("RFWPlayerAV1DecodeStrategyV2", RFWLog.USR, e16);
        }
    }

    public boolean enableAV1MediaCodec() {
        if (!k.a().c("MMKV_KEY_AV1_DETECT_RESULT", false) || !o.k()) {
            return false;
        }
        return true;
    }

    public void injectShiplyVersion(IShiplyVersion iShiplyVersion) {
        this.mShiplyVerionImpl = iShiplyVersion;
    }

    public boolean shouldInject() {
        if (this.mShiplyVerionImpl == null) {
            return true;
        }
        return false;
    }

    public void triggerDetect() {
        QLog.d("RFWPlayerAV1DecodeStrategyV2", 1, "triggerDetect start ");
        if (conNotDetect()) {
            return;
        }
        QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: com.tencent.biz.richframework.video.rfw.player.strategy.a
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public final void onSDKInited(boolean z16) {
                RFWPlayerAV1DecodeStrategyV2.this.lambda$triggerDetect$0(z16);
            }
        });
    }
}
