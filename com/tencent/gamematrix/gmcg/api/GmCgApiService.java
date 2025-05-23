package com.tencent.gamematrix.gmcg.api;

import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocDeviceLabel;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceStateInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgHardwareInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgLiveStreamingStatus;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgRecommendGameInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface GmCgApiService {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ActionResultListener {
        void onActionResult(GmCgError gmCgError);

        void onActionSucceed();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetDeviceShareCodeResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotRecommendGame(String str);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetGameConfigResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotGameConfig(GmCgGameConfigInfo gmCgGameConfigInfo);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetHardwareInfoResultListener {
        void onResult(boolean z16, GmCgHardwareInfo gmCgHardwareInfo, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetMyDevicesResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotMyDevices(List<GmCgDeviceInfo> list);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetMyWaitQueueResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotMyWaitQueue(List<GmCgPlayQueueInfo> list);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GetRecommendGameResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotRecommendGame(GmCgRecommendGameInfo gmCgRecommendGameInfo);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface QueryDeviceSaturationResultListener {
        void onGotDeviceSaturation(int i3);

        void onGotFail(GmCgError gmCgError);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface QueryDeviceStateResultListener {
        void onGotDeviceState(GmCgDeviceStateInfo gmCgDeviceStateInfo);

        void onGotFail(GmCgError gmCgError);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface QueryLiveStreamingResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotLiveStreamingStatus(GmCgLiveStreamingStatus gmCgLiveStreamingStatus);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface QueryMobileConfigResultListener {
        void onGotFail(GmCgError gmCgError);

        void onGotMobileConfig(String str);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface StartLiveStreamingResultListener {
        void onStartLiveStreamingFail(GmCgError gmCgError);

        void onStartLiveStreamingOk(String str);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface VirtualGamepadTokenListener {
        void onResult(String str);
    }

    void cancel();

    void collectLog(String str, boolean z16, ActionResultListener actionResultListener);

    void deleteUserArchive(String str, ActionResultListener actionResultListener);

    void fetchCloudGameLog(String str, ActionResultListener actionResultListener);

    void freeDeviceForSubAccount(String str, ActionResultListener actionResultListener);

    void freeMyDevice(String str, ActionResultListener actionResultListener);

    void freeMyDeviceAndDeleteArchive(String str, ActionResultListener actionResultListener);

    void freeMyDeviceByClientType(int i3, String str, ActionResultListener actionResultListener);

    void generateDeviceShareCode(String str, boolean z16, GetDeviceShareCodeResultListener getDeviceShareCodeResultListener);

    void getGameConfigInfo(String str, GetGameConfigResultListener getGameConfigResultListener);

    void getMyDevices(GetMyDevicesResultListener getMyDevicesResultListener);

    void getMyWaitQueue(GetMyWaitQueueResultListener getMyWaitQueueResultListener);

    void getRecommendGame(List<String> list, GetRecommendGameResultListener getRecommendGameResultListener);

    void queryDeviceSaturation(String str, String str2, boolean z16, List<GmCgAllocDeviceLabel> list, QueryDeviceSaturationResultListener queryDeviceSaturationResultListener);

    void queryDeviceState(String str, QueryDeviceStateResultListener queryDeviceStateResultListener);

    void queryLiveStreaming(String str, QueryLiveStreamingResultListener queryLiveStreamingResultListener);

    void queryMobileConfig(QueryMobileConfigResultListener queryMobileConfigResultListener);

    void queryVirtualGamepadToken(String str, VirtualGamepadTokenListener virtualGamepadTokenListener);

    void removeDeviceForSubAccount(String str, String str2, ActionResultListener actionResultListener);

    void requestSendDataChannel(String str, String str2, ActionResultListener actionResultListener);

    void requestTVHardwareInfo(String str, String str2, double d16, GmCgHardwareInfo gmCgHardwareInfo, GetHardwareInfoResultListener getHardwareInfoResultListener);

    void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener);

    void setBotDeviceMode(String str, boolean z16, ActionResultListener actionResultListener);

    void setBotDeviceMode(String str, boolean z16, @Nullable Integer num, ActionResultListener actionResultListener);

    void startLiveStreaming(String str, String str2, String str3, StartLiveStreamingResultListener startLiveStreamingResultListener);

    void startLiveStreamingPod(String str, ActionResultListener actionResultListener);

    void stopLiveStreaming(String str, ActionResultListener actionResultListener);

    void switchUserDeviceInfo(ActionResultListener actionResultListener);
}
