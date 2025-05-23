package com.tencent.mobileqq.qqlive.trtc.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.trtc.TRTCCloudDef;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static int a(int i3) {
        if (i3 == 1) {
            return 1;
        }
        return 0;
    }

    public static int b(int i3) {
        if (i3 == 1) {
            return 21;
        }
        return 20;
    }

    public static int c(int i3) {
        if (i3 != 0) {
            int i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    return 1;
                }
            }
            return i16;
        }
        return 0;
    }

    public static TRTCCloudDef.TRTCRenderParams d(@NonNull QQLiveRenderParams qQLiveRenderParams) {
        TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
        tRTCRenderParams.fillMode = a(qQLiveRenderParams.getFillMode());
        tRTCRenderParams.mirrorType = 0;
        tRTCRenderParams.rotation = 0;
        return tRTCRenderParams;
    }

    public static int e(int i3) {
        if (3 == i3) {
            return 112;
        }
        if (4 == i3) {
            return 114;
        }
        if (2 == i3) {
            return 110;
        }
        if (1 == i3) {
            return 108;
        }
        if (i3 != 0) {
            return 112;
        }
        return 106;
    }

    public static int f(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return 1;
    }

    public static TRTCCloudDef.TRTCParams g(@NonNull QQLiveRoomParams qQLiveRoomParams) throws IllegalArgumentException {
        if (qQLiveRoomParams.getUserSig() != null) {
            TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
            tRTCParams.userId = qQLiveRoomParams.getUserId();
            tRTCParams.userSig = qQLiveRoomParams.getUserSig();
            tRTCParams.role = b(qQLiveRoomParams.getRoleType());
            tRTCParams.roomId = (int) qQLiveRoomParams.getRoomId();
            tRTCParams.streamId = qQLiveRoomParams.getStreamId();
            tRTCParams.userDefineRecordId = qQLiveRoomParams.getUserDefineRecordId();
            tRTCParams.businessInfo = qQLiveRoomParams.getBussinessInfo();
            return tRTCParams;
        }
        throw new IllegalArgumentException("UserSig is null");
    }

    public static TRTCCloudDef.TRTCScreenShareParams h(QQLiveScreenCaptureParams qQLiveScreenCaptureParams) {
        if (qQLiveScreenCaptureParams == null) {
            return new TRTCCloudDef.TRTCScreenShareParams();
        }
        TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams = new TRTCCloudDef.TRTCScreenShareParams();
        tRTCScreenShareParams.floatingView = qQLiveScreenCaptureParams.getFloatingView();
        return tRTCScreenShareParams;
    }

    public static TRTCCloudDef.TRTCSwitchRoomConfig i(@NonNull QQLiveRoomParams qQLiveRoomParams) throws IllegalArgumentException {
        if (qQLiveRoomParams.getUserSig() != null) {
            TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig = new TRTCCloudDef.TRTCSwitchRoomConfig();
            tRTCSwitchRoomConfig.roomId = (int) qQLiveRoomParams.getRoomId();
            tRTCSwitchRoomConfig.userSig = qQLiveRoomParams.getUserSig();
            return tRTCSwitchRoomConfig;
        }
        throw new IllegalArgumentException("userSig is null");
    }

    public static TRTCCloudDef.TRTCVideoEncParam j(TRTCVideoQualityParams tRTCVideoQualityParams) {
        if (tRTCVideoQualityParams == null) {
            return new TRTCCloudDef.TRTCVideoEncParam();
        }
        TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        tRTCVideoEncParam.videoResolution = e(tRTCVideoQualityParams.getVideoResolution());
        tRTCVideoEncParam.videoBitrate = tRTCVideoQualityParams.getVideoBitRate();
        tRTCVideoEncParam.minVideoBitrate = tRTCVideoQualityParams.getMinVideoBitRate();
        tRTCVideoEncParam.videoFps = tRTCVideoQualityParams.getVideoFps();
        tRTCVideoEncParam.enableAdjustRes = tRTCVideoQualityParams.isEnableAdjustRes();
        tRTCVideoEncParam.videoResolutionMode = f(tRTCVideoQualityParams.getVideoResolutionMode());
        return tRTCVideoEncParam;
    }
}
