package com.tencent.mobileqq.icgame.api.impl.room.trtc;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveTrtcInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: classes15.dex */
public class RoomTRTCParamsBuilder {
    private static final String TAG = "RoomTRTCUtils";
    private static final IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static TRTCCloudDef.TRTCParams buildFromLiveInfo(long j3, LiveInfo liveInfo) {
        if (liveInfo == null) {
            iAegisLogApi.i(TAG, "buildFromLiveInfo fail! liveInfo is null!");
            return null;
        }
        LiveRoomInfo liveRoomInfo = liveInfo.roomInfo;
        if (liveRoomInfo != null && liveRoomInfo.roomId != 0) {
            LiveTrtcInfo liveTrtcInfo = liveInfo.trtcInfo;
            if (liveTrtcInfo != null && !TextUtils.isEmpty(liveTrtcInfo.sig)) {
                if (liveInfo.streamIdInfo == null) {
                    iAegisLogApi.i(TAG, "buildFromLiveInfo fail! liveInfo.streamIdInfo");
                    return null;
                }
                if (j3 == 0) {
                    iAegisLogApi.i(TAG, "buildPreloadParams fail! userId is 0!");
                    return null;
                }
                TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
                tRTCParams.roomId = (int) liveInfo.roomInfo.roomId;
                tRTCParams.userId = "" + j3;
                tRTCParams.userSig = liveInfo.trtcInfo.sig;
                tRTCParams.sdkAppId = TRTCSdk.TRTC_APP_ID;
                tRTCParams.role = 21;
                tRTCParams.streamId = liveInfo.streamIdInfo.mainStreamId;
                iAegisLogApi.i(TAG, "liveInfo --> TRTCParams roomId:" + tRTCParams.roomId + " userId:" + tRTCParams.userId + " userSig:" + tRTCParams.userSig + " sdkAppId:" + tRTCParams.sdkAppId + " role:" + tRTCParams.role + " streamId:" + tRTCParams.streamId);
                return tRTCParams;
            }
            iAegisLogApi.i(TAG, "buildFromLiveInfo fail! liveInfo.trtcInfo is null or sig is null");
            return null;
        }
        iAegisLogApi.i(TAG, "buildFromLiveInfo fail! liveInfo.roomInfo is null or roomId = 0");
        return null;
    }

    public static TRTCCloudDef.TRTCParams buildFromPreloadParams(long j3, IcgRoomPlayerConfig icgRoomPlayerConfig) {
        if (icgRoomPlayerConfig == null) {
            iAegisLogApi.i(TAG, "buildPreloadParams fail! preloadPlayParams is null!");
            return null;
        }
        if (j3 == 0) {
            iAegisLogApi.i(TAG, "buildPreloadParams fail! userId is 0!");
            return null;
        }
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.roomId = (int) icgRoomPlayerConfig.roomId;
        tRTCParams.userId = "" + j3;
        PreloadTRTCPlayerParams preloadTRTCPlayerParams = icgRoomPlayerConfig.trtcPlayerParams;
        tRTCParams.userSig = preloadTRTCPlayerParams.trtcSig;
        tRTCParams.sdkAppId = TRTCSdk.TRTC_APP_ID;
        tRTCParams.role = 21;
        tRTCParams.streamId = preloadTRTCPlayerParams.streamId;
        iAegisLogApi.i(TAG, "PreloadParams --> TRTCParams roomId:" + tRTCParams.roomId + " userId:" + tRTCParams.userId + " userSig:" + tRTCParams.userSig + " sdkAppId:" + tRTCParams.sdkAppId + " role:" + tRTCParams.role + " streamId:" + tRTCParams.streamId);
        return tRTCParams;
    }
}
