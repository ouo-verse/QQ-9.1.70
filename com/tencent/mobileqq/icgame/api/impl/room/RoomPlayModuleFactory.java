package com.tencent.mobileqq.icgame.api.impl.room;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayModule;
import com.tencent.mobileqq.icgame.api.impl.room.trtc.TRTCSdk;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes15.dex */
public class RoomPlayModuleFactory {
    private static final String TAG = "RoomPlayModuleFactory";
    private static final IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* loaded from: classes15.dex */
    interface Callback {
        boolean isInterrupt();

        void onResult(RoomPlayModule roomPlayModule);
    }

    public static void createRoomPlayModule(final AudienceRoomConfig audienceRoomConfig, final IcgRoomPlayerConfig icgRoomPlayerConfig, LiveInfo liveInfo, final Callback callback) {
        if (audienceRoomConfig != null && callback != null) {
            StreamType streamType = getStreamType(audienceRoomConfig.appId, icgRoomPlayerConfig, liveInfo);
            IAegisLogApi iAegisLogApi2 = iAegisLogApi;
            iAegisLogApi2.i(TAG, "getStreamType:" + streamType);
            if (streamType == StreamType.NONE) {
                iAegisLogApi2.i(TAG, "createRoomPlayModule fail! streamType is none!");
                callback.onResult(null);
                return;
            } else if (streamType == StreamType.TRTC) {
                TRTCSdk.getInstance().checkAndInit(BaseApplication.getContext().getApplicationContext(), new TRTCSdk.InitCallback() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModuleFactory.1
                    @Override // com.tencent.mobileqq.icgame.api.impl.room.trtc.TRTCSdk.InitCallback
                    public void onFailure() {
                        RoomPlayModuleFactory.iAegisLogApi.i(RoomPlayModuleFactory.TAG, "checkAndInit onFailure()");
                        if (Callback.this.isInterrupt()) {
                            RoomPlayModuleFactory.iAegisLogApi.w(RoomPlayModuleFactory.TAG, "onFailure initPlayModule end! interrupt!!");
                        } else {
                            Callback.this.onResult(RoomPlayModuleFactory.createRoomSupperPlayModule(audienceRoomConfig));
                        }
                    }

                    @Override // com.tencent.mobileqq.icgame.api.impl.room.trtc.TRTCSdk.InitCallback
                    public void onSuccess() {
                        RoomPlayModuleFactory.iAegisLogApi.i(RoomPlayModuleFactory.TAG, "checkAndInit onSuccess()");
                        if (Callback.this.isInterrupt()) {
                            RoomPlayModuleFactory.iAegisLogApi.w(RoomPlayModuleFactory.TAG, "onSuccess initPlayModule end! interrupt!!");
                        } else {
                            Callback.this.onResult(RoomPlayModuleFactory.createRoomTRTCPlayModule(audienceRoomConfig, icgRoomPlayerConfig));
                        }
                    }
                });
                return;
            } else {
                callback.onResult(createRoomSupperPlayModule(audienceRoomConfig));
                return;
            }
        }
        iAegisLogApi.e(TAG, "createRoomPlayModule fail! roomConfig:" + audienceRoomConfig + " callback:" + callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RoomPlayModule createRoomSupperPlayModule(AudienceRoomConfig audienceRoomConfig) {
        iAegisLogApi.i(TAG, "createRoomSupperPlayModule");
        return new RoomSuperPlayerModule(audienceRoomConfig.appId, false, audienceRoomConfig.playerConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RoomPlayModule createRoomTRTCPlayModule(AudienceRoomConfig audienceRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig) {
        iAegisLogApi.i(TAG, "createRoomTRTCPlayModule");
        return new RoomTRTCPlayModule(audienceRoomConfig, icgRoomPlayerConfig);
    }

    private static StreamType getStreamType(String str, IcgRoomPlayerConfig icgRoomPlayerConfig, LiveInfo liveInfo) {
        if (!isLogin(str)) {
            iAegisLogApi.i(TAG, "getStreamType not login ---> flv");
            return StreamType.FLV;
        }
        if (liveInfo != null) {
            return getStreamTypeFromLiveInfo(liveInfo);
        }
        if (icgRoomPlayerConfig != null) {
            return getStreamTypeFromPreloadPlayParams(icgRoomPlayerConfig);
        }
        return StreamType.FLV;
    }

    private static StreamType getStreamTypeFromLiveInfo(LiveInfo liveInfo) {
        IAegisLogApi iAegisLogApi2 = iAegisLogApi;
        iAegisLogApi2.i(TAG, "getStreamTypeFromLiveInfo streamType:" + liveInfo.streamType + " trtcInfo:" + liveInfo.trtcInfo);
        int i3 = liveInfo.streamType;
        StreamType streamType = StreamType.TRTC;
        if (i3 == streamType.value && liveInfo.trtcInfo != null) {
            iAegisLogApi2.i(TAG, "getStreamTypeFromLiveInfo trtcInfo.sig:" + liveInfo.trtcInfo.sig);
            if (!TextUtils.isEmpty(liveInfo.trtcInfo.sig)) {
                iAegisLogApi2.i(TAG, "getStreamTypeFromLiveInfo ---> trtc");
                return streamType;
            }
        }
        iAegisLogApi2.i(TAG, "getStreamTypeFromLiveInfo ---> flv");
        return StreamType.FLV;
    }

    private static StreamType getStreamTypeFromPreloadPlayParams(IcgRoomPlayerConfig icgRoomPlayerConfig) {
        IAegisLogApi iAegisLogApi2 = iAegisLogApi;
        iAegisLogApi2.i(TAG, "getStreamTypeFromPreloadPlayParams preloadPlayParams:" + icgRoomPlayerConfig);
        int i3 = icgRoomPlayerConfig.streamType;
        StreamType streamType = StreamType.TRTC;
        if (i3 == streamType.value && icgRoomPlayerConfig.isSupportTRTCPlay()) {
            iAegisLogApi2.i(TAG, "getStreamTypeFromPreloadPlayParams ---> trtc");
            return streamType;
        }
        int i16 = icgRoomPlayerConfig.streamType;
        StreamType streamType2 = StreamType.FLV;
        if (i16 == streamType2.value && !TextUtils.isEmpty(icgRoomPlayerConfig.superPlayerParams.url)) {
            iAegisLogApi2.i(TAG, "getStreamTypeFromPreloadPlayParams ---> flv");
            return streamType2;
        }
        iAegisLogApi2.i(TAG, "getStreamTypeFromPreloadPlayParams ---> none");
        return StreamType.NONE;
    }

    private static boolean isLogin(String str) {
        if (TextUtils.isEmpty(str)) {
            iAegisLogApi.i(TAG, "isLogin false! appId is null!");
            return false;
        }
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str);
        if (sDKImpl == null) {
            iAegisLogApi.i(TAG, "isLogin false! liveSDK is null!");
            return false;
        }
        IQQLiveModuleLogin loginModule = sDKImpl.getLoginModule();
        if (loginModule == null) {
            iAegisLogApi.i(TAG, "isLogin false! moduleLogin is null!");
            return false;
        }
        return loginModule.isLogined();
    }
}
