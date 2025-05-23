package com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat;

import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule;
import com.tencent.gamematrix.gmcg.sdk.nonage.NonAgeDebug;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageCloudGameHeartBeatResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageUser;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageVerifiedResult;
import com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest;
import com.tencent.gamematrix.gmcg.sdk.nonage.utils.HandlerUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonAgeHeartBeater {
    private static final int FACT_TYPE_END = 13;
    private static final int FACT_TYPE_HEARTBEAT = 12;
    private static final int FACT_TYPE_START = 11;
    private static final String TAG = "CGNonAgeProtect-HB";
    private long mCurrentTimeStamp;
    private int mFaceType;
    private IHeartBeatListener mListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface IHeartBeatListener {
        void onHeartBeatForceOffline(String str, String str2);

        void onHeartBeatSuccess();

        void onHeartBeatTimeout();

        void onHeartBeatTips(String str, String str2);

        void onHeartBeatUserExpire();
    }

    public CGNonAgeHeartBeater(IHeartBeatListener iHeartBeatListener) {
        this.mListener = iHeartBeatListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealWithResult(final int i3, final long j3, final int i16, final CGNonageCloudGameHeartBeatResp cGNonageCloudGameHeartBeatResp) {
        IHeartBeatListener iHeartBeatListener;
        if (this.mFaceType == 13) {
            return;
        }
        if (NonAgeDebug.testExpire) {
            IHeartBeatListener iHeartBeatListener2 = this.mListener;
            if (iHeartBeatListener2 != null) {
                iHeartBeatListener2.onHeartBeatUserExpire();
            }
            NonAgeDebug.testExpire = false;
            return;
        }
        CGLog.d("CGNonAgeProtect-HB-dealWithResult: faceType = " + i3 + ",duration = " + j3 + ",retryCount = " + i16);
        if (cGNonageCloudGameHeartBeatResp != null && cGNonageCloudGameHeartBeatResp.getResult() != null) {
            CGLog.d("CGNonAgeProtect-HB-dealWithResult: result = " + cGNonageCloudGameHeartBeatResp.toString());
            CGNonageVerifiedResult.Instruction logoutInstruction = cGNonageCloudGameHeartBeatResp.getResult().getLogoutInstruction();
            CGNonageVerifiedResult.Instruction tipsInstruction = cGNonageCloudGameHeartBeatResp.getResult().getTipsInstruction();
            if (logoutInstruction != null) {
                IHeartBeatListener iHeartBeatListener3 = this.mListener;
                if (iHeartBeatListener3 != null) {
                    iHeartBeatListener3.onHeartBeatForceOffline(logoutInstruction.title, logoutInstruction.f107886msg);
                }
                if (cGNonageCloudGameHeartBeatResp.getResult().getLogoutInstruction() != null) {
                    CGNonAgeProtectRequest.postHeatBeatExcute(cGNonageCloudGameHeartBeatResp.getResult().getTraceId(), cGNonageCloudGameHeartBeatResp.getResult().getLogoutInstruction().ruleName, new CGNonAgeProtectRequest.IRequestCallback<CGNonageCloudGameHeartBeatResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.4
                        @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
                        public void onError(GmCgError gmCgError) {
                            CGLog.d("CGNonAgeProtect-HB-dealWithResult: postHeatBeatExcute onError: " + gmCgError);
                        }

                        @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
                        public void onSuccess(CGNonageCloudGameHeartBeatResp cGNonageCloudGameHeartBeatResp2) {
                            CGLog.d("CGNonAgeProtect-HB-dealWithResult: postHeatBeatExcute onSuccess: ");
                        }
                    });
                }
                stop();
                return;
            }
            if (tipsInstruction != null && (iHeartBeatListener = this.mListener) != null) {
                iHeartBeatListener.onHeartBeatTips(tipsInstruction.title, tipsInstruction.f107886msg);
            }
            IHeartBeatListener iHeartBeatListener4 = this.mListener;
            if (iHeartBeatListener4 != null) {
                iHeartBeatListener4.onHeartBeatSuccess();
            }
            if (this.mFaceType != 13) {
                HandlerUtils.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.5
                    @Override // java.lang.Runnable
                    public void run() {
                        CGNonAgeHeartBeater.this.heartBeat(12, cGNonageCloudGameHeartBeatResp.getResult().getInterval(), cGNonageCloudGameHeartBeatResp.getResult().getInterval());
                    }
                });
                return;
            }
            return;
        }
        if (cGNonageCloudGameHeartBeatResp != null && (cGNonageCloudGameHeartBeatResp.getErrCode() == -126 || cGNonageCloudGameHeartBeatResp.getErrCode() == -110)) {
            CGLog.d("CGNonAgeProtect-HB-dealWithResult: result != null && (result.getErrCode() == -126 || result.getErrCode() == -110)");
            IHeartBeatListener iHeartBeatListener5 = this.mListener;
            if (iHeartBeatListener5 != null) {
                iHeartBeatListener5.onHeartBeatUserExpire();
                return;
            }
            return;
        }
        if (cGNonageCloudGameHeartBeatResp == null) {
            CGLog.d("CGNonAgeProtect-HB-dealWithResult:result == null");
        } else if (cGNonageCloudGameHeartBeatResp.getResult() == null) {
            CGLog.d("CGNonAgeProtect-HB-dealWithResult:result.getResult() == null");
        }
        HandlerUtils.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.3
            @Override // java.lang.Runnable
            public void run() {
                CGNonAgeHeartBeater.this.sendRequest(i3, j3, i16 + 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void heartBeat(final int i3, long j3, final long j16) {
        CGLog.d("CGNonAgeProtect-HB-heartBeat: faceType = " + i3 + ",delay = " + j3 + ",durationSecond = " + j16);
        if (NonAgeDebug.testHeartBeat) {
            j16 = 5;
            j3 = Math.min(j3, 5L);
        }
        this.mFaceType = i3;
        this.mCurrentTimeStamp = System.currentTimeMillis();
        HandlerUtils.postDelay(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.1
            @Override // java.lang.Runnable
            public void run() {
                CGNonAgeHeartBeater.this.sendRequest(i3, j16, 0);
            }
        }, j3 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequest(final int i3, final long j3, final int i16) {
        String str;
        String str2;
        String str3;
        CGLog.d("CGNonAgeProtect-HB-sendRequest: face type = " + i3 + ", duration = " + j3 + ", retryCount = " + i16);
        if (i16 >= 3) {
            CGLog.d("CGNonAgeProtect-HB-sendRequest: time out");
            IHeartBeatListener iHeartBeatListener = this.mListener;
            if (iHeartBeatListener != null) {
                iHeartBeatListener.onHeartBeatTimeout();
                return;
            }
            return;
        }
        CGNonageUser user = CGNonAgeProtectModule.getInstance().getUser();
        if (user != null) {
            str = user.getAppId();
            str3 = user.getUserId();
            str2 = user.getKey();
        } else {
            str = "";
            str2 = "";
            str3 = str2;
        }
        CGLog.d("CGNonAgeProtect-HB-appid = " + str + ",-uid = " + str3 + ",-ukey = " + str2);
        CGNonAgeProtectRequest.postHeatBeat(i3, j3, str, new CGNonAgeProtectRequest.IRequestCallback<CGNonageCloudGameHeartBeatResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.nonage.heatbeat.CGNonAgeHeartBeater.2
            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onError(GmCgError gmCgError) {
                CGLog.d("CGNonAgeProtect-HB-ERROR = " + gmCgError.getErrorCode() + ",msg = " + gmCgError.getErrorMsg());
                CGNonAgeHeartBeater.this.sendRequest(i3, j3, i16 + 1);
            }

            @Override // com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest.IRequestCallback
            public void onSuccess(CGNonageCloudGameHeartBeatResp cGNonageCloudGameHeartBeatResp) {
                CGNonAgeHeartBeater.this.dealWithResult(i3, j3, i16, cGNonageCloudGameHeartBeatResp);
            }
        });
    }

    public void startBeat() {
        heartBeat(11, 0L, 0L);
    }

    public void stop() {
        CGLog.d("CGNonAgeProtect-HB- heartbeat stop");
        long currentTimeMillis = System.currentTimeMillis();
        int min = Math.min((int) ((currentTimeMillis - this.mCurrentTimeStamp) / 1000), 300);
        this.mCurrentTimeStamp = currentTimeMillis;
        heartBeat(13, 0L, min);
    }
}
