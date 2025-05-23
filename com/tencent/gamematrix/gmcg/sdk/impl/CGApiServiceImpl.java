package com.tencent.gamematrix.gmcg.sdk.impl;

import com.tencent.gamematrix.gmcg.api.GmCgApiService;
import com.tencent.gamematrix.gmcg.api.GmCgAuthRefreshListener;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocDeviceLabel;
import com.tencent.gamematrix.gmcg.api.model.GmCgHardwareInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgLiveStreamingStatus;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgRecommendGameInfo;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager;
import com.tencent.gamematrix.gmcg.sdk.service.CGAllocDeviceInfo;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGCommonResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGDeviceShareCodeResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGGameConfigResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGGetMyWaitQueueResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGHardwareInfoResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGHoldDeviceResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGQueryDeviceStateResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGQueryLiveStreamingResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGQueryMobileConfigResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGQuerySaturationResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGRecommendGameResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGStartLiveStreamingResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGVirtualGamepadTokenResp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGApiServiceImpl implements GmCgApiService {
    private CGBizHttpService mBizHttpService = new CGBizHttpService();
    private CGQualificationChecker mQualificationChecker = new CGQualificationChecker(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doMultiAllocDevice, reason: merged with bridge method [inline-methods] */
    public void lambda$getRecommendGameAfterQualification$3(List<GmCgNetDetectionInfo> list, List<String> list2, final GmCgApiService.GetRecommendGameResultListener getRecommendGameResultListener) {
        if (list == null) {
            CGLog.w("doMultiAllocDevice failed, server ips is null");
        }
        this.mBizHttpService.requestMyRecommendGame(list, list2, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.i
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$doMultiAllocDevice$4(GmCgApiService.GetRecommendGameResultListener.this, gmCgError, (CGRecommendGameResp) obj);
            }
        });
    }

    private void freeMyDeviceAfterQualification(String str, boolean z16, final GmCgApiService.ActionResultListener actionResultListener) {
        CGLog.i("freeMyDeviceAfterQualification: " + str + ", needDeleteArchive: " + z16);
        this.mBizHttpService.requestFreeMyDevice(str, z16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.r
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$freeMyDeviceAfterQualification$1(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
            }
        });
    }

    private void getGameConfigInfoAfterQualification(String str, final GmCgApiService.GetGameConfigResultListener getGameConfigResultListener) {
        this.mBizHttpService.requestGetGameConfig(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.u
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$getGameConfigInfoAfterQualification$5(GmCgApiService.GetGameConfigResultListener.this, gmCgError, (CGGameConfigResp) obj);
            }
        });
    }

    private void getMyDevicesAfterQualification(final GmCgApiService.GetMyDevicesResultListener getMyDevicesResultListener) {
        this.mBizHttpService.requestGetMyDevices(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.g
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$getMyDevicesAfterQualification$0(GmCgApiService.GetMyDevicesResultListener.this, gmCgError, (CGHoldDeviceResp) obj);
            }
        });
    }

    private void getMyWaitQueueAfterQualification(final GmCgApiService.GetMyWaitQueueResultListener getMyWaitQueueResultListener) {
        this.mBizHttpService.requestMyWaitQueue(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.k
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$getMyWaitQueueAfterQualification$22(GmCgApiService.GetMyWaitQueueResultListener.this, gmCgError, (CGGetMyWaitQueueResp) obj);
            }
        });
    }

    private void getRecommendGameAfterQualification(final List<String> list, final GmCgApiService.GetRecommendGameResultListener getRecommendGameResultListener) {
        CGNetDetectionManager.get().detectionNetDelay(new CGNetDetectionManager.DetectionNetListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.s
            @Override // com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager.DetectionNetListener
            public final void onDetectionNetRes(List list2) {
                CGApiServiceImpl.this.lambda$getRecommendGameAfterQualification$3(list, getRecommendGameResultListener, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$collectLog$18(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteUserArchive$12(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doMultiAllocDevice$4(GmCgApiService.GetRecommendGameResultListener getRecommendGameResultListener, GmCgError gmCgError, CGRecommendGameResp cGRecommendGameResp) {
        if (GmCgError.isOK(gmCgError)) {
            GmCgRecommendGameInfo gmCgRecommendGameInfo = new GmCgRecommendGameInfo();
            gmCgRecommendGameInfo.pGameTag = cGRecommendGameResp.tag;
            gmCgRecommendGameInfo.pShouldWait = cGRecommendGameResp.wait;
            if (getRecommendGameResultListener != null) {
                getRecommendGameResultListener.onGotRecommendGame(gmCgRecommendGameInfo);
                return;
            }
            return;
        }
        if (getRecommendGameResultListener != null) {
            getRecommendGameResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchCloudGameLog$20(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$freeDeviceForSubAccount$6(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$freeMyDeviceAfterQualification$1(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$generateDeviceShareCode$14(GmCgApiService.GetDeviceShareCodeResultListener getDeviceShareCodeResultListener, GmCgError gmCgError, CGDeviceShareCodeResp cGDeviceShareCodeResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (getDeviceShareCodeResultListener != null) {
                getDeviceShareCodeResultListener.onGotRecommendGame(cGDeviceShareCodeResp.share_code);
            }
        } else if (getDeviceShareCodeResultListener != null) {
            getDeviceShareCodeResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getGameConfigInfoAfterQualification$5(GmCgApiService.GetGameConfigResultListener getGameConfigResultListener, GmCgError gmCgError, CGGameConfigResp cGGameConfigResp) {
        if (getGameConfigResultListener != null) {
            if (GmCgError.isOK(gmCgError)) {
                getGameConfigResultListener.onGotGameConfig(cGGameConfigResp.toGmCgGameConfigInfo());
            } else {
                getGameConfigResultListener.onGotFail(gmCgError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMyDevicesAfterQualification$0(GmCgApiService.GetMyDevicesResultListener getMyDevicesResultListener, GmCgError gmCgError, CGHoldDeviceResp cGHoldDeviceResp) {
        if (GmCgError.isOK(gmCgError)) {
            ArrayList arrayList = new ArrayList();
            List<CGAllocDeviceInfo> list = cGHoldDeviceResp.devices;
            if (list != null) {
                Iterator<CGAllocDeviceInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toGmCgDeviceInfo(0));
                }
            }
            if (getMyDevicesResultListener != null) {
                getMyDevicesResultListener.onGotMyDevices(arrayList);
                return;
            }
            return;
        }
        if (getMyDevicesResultListener != null) {
            getMyDevicesResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMyWaitQueueAfterQualification$22(GmCgApiService.GetMyWaitQueueResultListener getMyWaitQueueResultListener, GmCgError gmCgError, CGGetMyWaitQueueResp cGGetMyWaitQueueResp) {
        if (getMyWaitQueueResultListener != null) {
            if (GmCgError.isOK(gmCgError)) {
                if (cGGetMyWaitQueueResp != null && cGGetMyWaitQueueResp.data != null) {
                    getMyWaitQueueResultListener.onGotMyWaitQueue(cGGetMyWaitQueueResp.toGmCgPlayQueueInfo());
                    return;
                } else {
                    getMyWaitQueueResultListener.onGotMyWaitQueue(Collections.emptyList());
                    return;
                }
            }
            getMyWaitQueueResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryDeviceSaturation$19(GmCgApiService.QueryDeviceSaturationResultListener queryDeviceSaturationResultListener, GmCgError gmCgError, CGQuerySaturationResp cGQuerySaturationResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (queryDeviceSaturationResultListener != null) {
                queryDeviceSaturationResultListener.onGotDeviceSaturation(cGQuerySaturationResp.saturation);
            }
        } else if (queryDeviceSaturationResultListener != null) {
            queryDeviceSaturationResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryDeviceStateAfterQualification$23(GmCgApiService.QueryDeviceStateResultListener queryDeviceStateResultListener, GmCgError gmCgError, CGQueryDeviceStateResp cGQueryDeviceStateResp) {
        if (queryDeviceStateResultListener != null) {
            if (GmCgError.isOK(gmCgError)) {
                queryDeviceStateResultListener.onGotDeviceState(cGQueryDeviceStateResp.toGmCgDeviceState());
            } else {
                queryDeviceStateResultListener.onGotFail(gmCgError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryLiveStreaming$9(GmCgApiService.QueryLiveStreamingResultListener queryLiveStreamingResultListener, GmCgError gmCgError, CGQueryLiveStreamingResp cGQueryLiveStreamingResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (queryLiveStreamingResultListener != null) {
                GmCgLiveStreamingStatus gmCgLiveStreamingStatus = new GmCgLiveStreamingStatus();
                gmCgLiveStreamingStatus.pDeviceId = cGQueryLiveStreamingResp.deviceID;
                gmCgLiveStreamingStatus.pRtmpAddr = cGQueryLiveStreamingResp.rtmpAddr;
                gmCgLiveStreamingStatus.pStatus = cGQueryLiveStreamingResp.status;
                gmCgLiveStreamingStatus.pDesc = cGQueryLiveStreamingResp.desc;
                queryLiveStreamingResultListener.onGotLiveStreamingStatus(gmCgLiveStreamingStatus);
                return;
            }
            return;
        }
        if (queryLiveStreamingResultListener != null) {
            queryLiveStreamingResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryMobileConfig$16(GmCgApiService.QueryMobileConfigResultListener queryMobileConfigResultListener, GmCgError gmCgError, CGQueryMobileConfigResp cGQueryMobileConfigResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (queryMobileConfigResultListener != null) {
                queryMobileConfigResultListener.onGotMobileConfig(CGJsonUtil.toJson(cGQueryMobileConfigResp));
            }
        } else if (queryMobileConfigResultListener != null) {
            queryMobileConfigResultListener.onGotFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queryVirtualGamepadToken$11(GmCgApiService.VirtualGamepadTokenListener virtualGamepadTokenListener, GmCgError gmCgError, CGVirtualGamepadTokenResp cGVirtualGamepadTokenResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (virtualGamepadTokenListener != null) {
                virtualGamepadTokenListener.onResult(cGVirtualGamepadTokenResp.qrUrl);
            }
        } else if (virtualGamepadTokenListener != null) {
            virtualGamepadTokenListener.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeDeviceForSubAccount$13(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestSendDataChannel$17(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestTVHardwareInfo$15(GmCgApiService.GetHardwareInfoResultListener getHardwareInfoResultListener, GmCgError gmCgError, CGHardwareInfoResp cGHardwareInfoResp) {
        if (getHardwareInfoResultListener != null) {
            if (GmCgError.isOK(gmCgError)) {
                getHardwareInfoResultListener.onResult(cGHardwareInfoResp.need_check, cGHardwareInfoResp.config, cGHardwareInfoResp.tip_code);
            } else {
                getHardwareInfoResultListener.onResult(false, null, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setBotDeviceModeAfterQualification$2(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (actionResultListener != null) {
            if (GmCgError.isOK(gmCgError)) {
                actionResultListener.onActionSucceed();
            } else {
                actionResultListener.onActionResult(gmCgError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLiveStreaming$7(GmCgApiService.StartLiveStreamingResultListener startLiveStreamingResultListener, GmCgError gmCgError, CGStartLiveStreamingResp cGStartLiveStreamingResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (startLiveStreamingResultListener != null) {
                startLiveStreamingResultListener.onStartLiveStreamingOk(cGStartLiveStreamingResp.taskId);
            }
        } else if (startLiveStreamingResultListener != null) {
            startLiveStreamingResultListener.onStartLiveStreamingFail(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLiveStreamingPod$10(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopLiveStreaming$8(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$switchUserDeviceInfoAfterQualification$21(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (actionResultListener != null) {
            if (GmCgError.isOK(gmCgError)) {
                actionResultListener.onActionSucceed();
            } else {
                actionResultListener.onActionResult(gmCgError);
            }
        }
    }

    private void queryDeviceStateAfterQualification(String str, final GmCgApiService.QueryDeviceStateResultListener queryDeviceStateResultListener) {
        this.mBizHttpService.requestQueryCgDeviceState(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.m
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$queryDeviceStateAfterQualification$23(GmCgApiService.QueryDeviceStateResultListener.this, gmCgError, (CGQueryDeviceStateResp) obj);
            }
        });
    }

    private void setBotDeviceModeAfterQualification(String str, boolean z16, Integer num, final GmCgApiService.ActionResultListener actionResultListener) {
        this.mBizHttpService.setBotDeviceMode(str, z16, num, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.n
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$setBotDeviceModeAfterQualification$2(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
            }
        });
    }

    private void switchUserDeviceInfoAfterQualification(final GmCgApiService.ActionResultListener actionResultListener) {
        this.mBizHttpService.setUserDeviceInfo("", new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.f
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$switchUserDeviceInfoAfterQualification$21(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void cancel() {
        this.mBizHttpService.cancel();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void collectLog(String str, boolean z16, final GmCgApiService.ActionResultListener actionResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.collectLog(str, z16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.q
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$collectLog$18(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void deleteUserArchive(String str, final GmCgApiService.ActionResultListener actionResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.requestDeleteUserArchive(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.o
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$deleteUserArchive$12(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void fetchCloudGameLog(String str, final GmCgApiService.ActionResultListener actionResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.fetchLog(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.w
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$fetchCloudGameLog$20(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void freeDeviceForSubAccount(String str, final GmCgApiService.ActionResultListener actionResultListener) {
        this.mBizHttpService.requestFreeDeviceForSubAccount(CGGlbConfig.getUserId(), str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.h
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$freeDeviceForSubAccount$6(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void freeMyDevice(String str, GmCgApiService.ActionResultListener actionResultListener) {
        CGLog.i("freeMyDevice: " + str);
        if (this.mBizHttpService != null) {
            freeMyDeviceAfterQualification(str, false, actionResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void freeMyDeviceAndDeleteArchive(String str, GmCgApiService.ActionResultListener actionResultListener) {
        CGLog.i("freeMyDeviceAndDeleteArchive deviceId: " + str);
        if (this.mBizHttpService != null) {
            freeMyDeviceAfterQualification(str, true, actionResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void freeMyDeviceByClientType(int i3, String str, GmCgApiService.ActionResultListener actionResultListener) {
        if (this.mBizHttpService != null) {
            freeMyDeviceAfterQualification(str, false, actionResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void generateDeviceShareCode(String str, boolean z16, final GmCgApiService.GetDeviceShareCodeResultListener getDeviceShareCodeResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.requestGenerateDeviceShareCode(CGGlbConfig.getUserId(), str, z16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.t
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$generateDeviceShareCode$14(GmCgApiService.GetDeviceShareCodeResultListener.this, gmCgError, (CGDeviceShareCodeResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void getGameConfigInfo(String str, GmCgApiService.GetGameConfigResultListener getGameConfigResultListener) {
        if (this.mBizHttpService != null) {
            getGameConfigInfoAfterQualification(str, getGameConfigResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void getMyDevices(GmCgApiService.GetMyDevicesResultListener getMyDevicesResultListener) {
        if (this.mBizHttpService != null) {
            getMyDevicesAfterQualification(getMyDevicesResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void getMyWaitQueue(GmCgApiService.GetMyWaitQueueResultListener getMyWaitQueueResultListener) {
        if (this.mBizHttpService != null) {
            getMyWaitQueueAfterQualification(getMyWaitQueueResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void getRecommendGame(List<String> list, GmCgApiService.GetRecommendGameResultListener getRecommendGameResultListener) {
        if (this.mBizHttpService != null) {
            getRecommendGameAfterQualification(list, getRecommendGameResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void queryDeviceSaturation(String str, String str2, boolean z16, List<GmCgAllocDeviceLabel> list, final GmCgApiService.QueryDeviceSaturationResultListener queryDeviceSaturationResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.querySaturationResp(str, str2, z16, list, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.l
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$queryDeviceSaturation$19(GmCgApiService.QueryDeviceSaturationResultListener.this, gmCgError, (CGQuerySaturationResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void queryDeviceState(String str, GmCgApiService.QueryDeviceStateResultListener queryDeviceStateResultListener) {
        if (this.mBizHttpService != null) {
            queryDeviceStateAfterQualification(str, queryDeviceStateResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void queryLiveStreaming(String str, final GmCgApiService.QueryLiveStreamingResultListener queryLiveStreamingResultListener) {
        this.mBizHttpService.requestQueryLiveStreaming(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.a
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$queryLiveStreaming$9(GmCgApiService.QueryLiveStreamingResultListener.this, gmCgError, (CGQueryLiveStreamingResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void queryMobileConfig(final GmCgApiService.QueryMobileConfigResultListener queryMobileConfigResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.requestQueryMobileConfig(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.v
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$queryMobileConfig$16(GmCgApiService.QueryMobileConfigResultListener.this, gmCgError, (CGQueryMobileConfigResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void queryVirtualGamepadToken(String str, final GmCgApiService.VirtualGamepadTokenListener virtualGamepadTokenListener) {
        this.mBizHttpService.requestVirtualGamepadToken(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.p
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$queryVirtualGamepadToken$11(GmCgApiService.VirtualGamepadTokenListener.this, gmCgError, (CGVirtualGamepadTokenResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void removeDeviceForSubAccount(String str, String str2, final GmCgApiService.ActionResultListener actionResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.requestRemoveDeviceForSubAccount(CGGlbConfig.getUserId(), str, str2, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.x
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$removeDeviceForSubAccount$13(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void requestSendDataChannel(String str, String str2, final GmCgApiService.ActionResultListener actionResultListener) {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.requestSendDataChannel(str, str2, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.c
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGApiServiceImpl.lambda$requestSendDataChannel$17(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void requestTVHardwareInfo(String str, String str2, double d16, GmCgHardwareInfo gmCgHardwareInfo, final GmCgApiService.GetHardwareInfoResultListener getHardwareInfoResultListener) {
        this.mBizHttpService.requestHardwareInfo(str, str2, gmCgHardwareInfo, d16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.e
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$requestTVHardwareInfo$15(GmCgApiService.GetHardwareInfoResultListener.this, gmCgError, (CGHardwareInfoResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener) {
        CGQualificationChecker cGQualificationChecker = this.mQualificationChecker;
        if (cGQualificationChecker != null) {
            cGQualificationChecker.setAuthRefreshListener(gmCgAuthRefreshListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void setBotDeviceMode(String str, boolean z16, GmCgApiService.ActionResultListener actionResultListener) {
        setBotDeviceMode(str, z16, null, actionResultListener);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void startLiveStreaming(String str, String str2, String str3, final GmCgApiService.StartLiveStreamingResultListener startLiveStreamingResultListener) {
        this.mBizHttpService.requestStartLiveStreaming(str, str2, str3, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.d
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$startLiveStreaming$7(GmCgApiService.StartLiveStreamingResultListener.this, gmCgError, (CGStartLiveStreamingResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void startLiveStreamingPod(String str, final GmCgApiService.ActionResultListener actionResultListener) {
        this.mBizHttpService.requestStartLiveStreamingPod(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.b
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$startLiveStreamingPod$10(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void stopLiveStreaming(String str, final GmCgApiService.ActionResultListener actionResultListener) {
        this.mBizHttpService.requestStopLiveStreaming(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.j
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGApiServiceImpl.lambda$stopLiveStreaming$8(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void switchUserDeviceInfo(GmCgApiService.ActionResultListener actionResultListener) {
        if (this.mBizHttpService != null) {
            switchUserDeviceInfoAfterQualification(actionResultListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService
    public void setBotDeviceMode(String str, boolean z16, Integer num, GmCgApiService.ActionResultListener actionResultListener) {
        if (this.mBizHttpService != null) {
            setBotDeviceModeAfterQualification(str, z16, num, actionResultListener);
        }
    }
}
