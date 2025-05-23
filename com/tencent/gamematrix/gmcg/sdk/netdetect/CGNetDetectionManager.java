package com.tencent.gamematrix.gmcg.sdk.netdetect;

import android.content.Context;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.task.CGTaskHandler;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGGetIpAddressResp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNetDetectionManager {
    public static final String DEFAULT_BASE_DOMAIN = "cloud.tgpa.qq.com";
    public static final String DEFAULT_NET_DETECT_DOMAIN = "speed-test.gamematrix.qq.com";
    public static final int DETECTION_DELAY_NET_TIME = 2000;
    private static final int DETECTION_DELAY_PACKAGE_COUNT = 10;
    private static final int DETECTION_DELAY_PACKAGE_SIZE = 32;
    public static final int DETECTION_NET_TIME_OUT_TIME = 5000;
    private static final int DETECTION_SPEED_RATE_DURATION_TIME = 2000;
    private static final CGSingletonHelper<CGNetDetectionManager> sInstance = new CGSingletonHelper<CGNetDetectionManager>() { // from class: com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public CGNetDetectionManager create() {
            return new CGNetDetectionManager();
        }
    };
    private CGBizHttpService mCGBizHttpService;
    private List<GmCgNetDetectionInfo> mCachedNetDelayDetectList;
    private List<GmCgNetDetectionInfo> mCachedNetSpeedRateDetectList;
    private DetectionNetListener mDetectionDelayListener;
    private CGTaskHandler.WorkTask mDetectionNetDelayTask;
    private int mDetectionSpeedRateIPCount;
    private DetectionNetListener mDetectionSpeedRateListener;
    private String mTransceiverSessionId;
    private boolean mUseIpToDetect;
    private long startDetectTime;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface DetectionNetListener {
        void onDetectionNetRes(List<GmCgNetDetectionInfo> list);
    }

    private void createNewTransceiverSessionId() {
        this.mTransceiverSessionId = generateTransceiverSessionId(CGGlbConfig.getUserId());
    }

    private void detectNetByIp(List<CGGetIpAddressResp.GatewayBean> list) {
        CGLog.i("detectNetByIp size: " + list.size());
        if (this.mDetectionDelayListener != null) {
            CGLog.e("detectNetDelayInfo error, return  ");
            this.mDetectionDelayListener.onDetectionNetRes(null);
        }
    }

    private static String generateTransceiverSessionId(String str) {
        return CGSystemUtil.encryptMd5(("androidTransceiver@" + str + "@" + System.currentTimeMillis() + "@" + ((int) (Math.random() * 10000.0d))).getBytes());
    }

    public static CGNetDetectionManager get() {
        return sInstance.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectionNetDelay$0(GmCgError gmCgError, CGGetIpAddressResp cGGetIpAddressResp) {
        if (GmCgError.isOK(gmCgError)) {
            detectNetByIp(cGGetIpAddressResp.getGateway());
        } else {
            CGLog.w("requestGateWayIpAddress failed!");
            detectNetByIp(new ArrayList());
        }
    }

    private void returnNetDelayResult(List<GmCgNetDetectionInfo> list) {
        DetectionNetListener detectionNetListener = this.mDetectionDelayListener;
        if (detectionNetListener != null) {
            detectionNetListener.onDetectionNetRes(list);
            this.mDetectionDelayListener = null;
        }
    }

    private void returnNetSpeedRateResult(List<GmCgNetDetectionInfo> list) {
        DetectionNetListener detectionNetListener = this.mDetectionSpeedRateListener;
        if (detectionNetListener != null) {
            detectionNetListener.onDetectionNetRes(list);
            this.mDetectionSpeedRateListener = null;
        }
    }

    public void cancelDetectNet() {
        CGLog.i("cancelDetectNet");
    }

    public void cancelDetectionNetDelayTask() {
        CGTaskHandler.WorkTask workTask = this.mDetectionNetDelayTask;
        if (workTask != null) {
            workTask.cancel();
            this.mDetectionNetDelayTask = null;
        }
    }

    public void clearCacheNetDelayDetection() {
        this.mCachedNetDelayDetectList.clear();
    }

    public void clearCacheSpeedRateDetection() {
        this.mCachedNetSpeedRateDetectList.clear();
    }

    public void detectionNetDelay(DetectionNetListener detectionNetListener) {
        CGLog.i("startNetDetection!");
        this.mDetectionDelayListener = detectionNetListener;
        if (this.mCachedNetDelayDetectList.size() > 0) {
            CGLog.i("return detection net delay result from cached!");
            returnNetDelayResult(this.mCachedNetDelayDetectList);
        } else if (this.mCGBizHttpService != null) {
            createNewTransceiverSessionId();
            this.mCGBizHttpService.requestGateWayIpAddress(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.netdetect.a
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGNetDetectionManager.this.lambda$detectionNetDelay$0(gmCgError, (CGGetIpAddressResp) obj);
                }
            });
        }
    }

    public void detectionNetDelayByIps(DetectionNetListener detectionNetListener, List<CGGetIpAddressResp.GatewayBean> list) {
        this.mDetectionDelayListener = detectionNetListener;
        if (this.mCachedNetDelayDetectList.size() > 0) {
            CGLog.i("return detection net delay result from cached!");
            returnNetDelayResult(this.mCachedNetDelayDetectList);
        } else {
            detectNetByIp(list);
        }
    }

    public void detectionNetSpeedRate(ArrayList<String> arrayList, DetectionNetListener detectionNetListener) {
        CGLog.i("detectionNetSpeedRate!");
        if (arrayList == null && arrayList.size() == 0) {
            CGLog.e("IpAddress is not invalid to detection net speed rate!");
        } else {
            this.mDetectionSpeedRateListener = detectionNetListener;
            this.mDetectionSpeedRateIPCount = arrayList.size();
        }
    }

    public List<GmCgNetDetectionInfo> getCachedNetDelayDetectList() {
        return this.mCachedNetDelayDetectList;
    }

    public String getTransceiverSessionId() {
        if (CGStringUtil.isEmpty(this.mTransceiverSessionId)) {
            createNewTransceiverSessionId();
        }
        return this.mTransceiverSessionId;
    }

    public boolean hasNetDetectionCache() {
        if (this.mCachedNetDelayDetectList.size() > 0) {
            return true;
        }
        return false;
    }

    public void init(Context context, String str, Map<String, String> map) {
        String str2 = "cloud.tgpa.qq.com";
        if (map != null) {
            String str3 = map.get("cloud.tgpa.qq.com");
            if (CGStringUtil.notEmpty(str3)) {
                str2 = str3;
            }
        }
        init(context, str, str2);
    }

    public void setUseIp(boolean z16) {
        this.mUseIpToDetect = z16;
    }

    CGNetDetectionManager() {
        this.mCachedNetDelayDetectList = new ArrayList();
        this.mCachedNetSpeedRateDetectList = new ArrayList();
        this.mDetectionSpeedRateIPCount = -1;
        this.mCGBizHttpService = new CGBizHttpService();
    }

    public void init(Context context, String str) {
        init(context, str, "cloud.tgpa.qq.com");
    }

    private void init(Context context, String str, String str2) {
        if (context != null && !CGStringUtil.isEmpty(str) && !CGStringUtil.isEmpty(str2)) {
            CGLog.i("init CGNetDetectionManager");
            clearCacheNetDelayDetection();
        } else {
            CGLog.i("init CGNetDetectionManager failed");
        }
    }
}
