package com.tencent.gamecenter.wadl.api;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameDownloadSpeedReporter$GameDownloadInfo;
import tencent.im.qqgame.QQGameGcSpkTaskDye;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameTrpcService extends QRouteApi {
    public static final int ACTION_FROM_DISTRIBUTE = 3;
    public static final int ACTION_FROM_INSTALLED_STEP_A = 4;
    public static final int ACTION_FROM_INSTALLED_STEP_B = 5;
    public static final int ACTION_FROM_UPDATE = 2;
    public static final int ACTION_FROM_YUYUE = 1;

    void addListener(WadlTrpcListener wadlTrpcListener);

    void checkInstallChannel(int i3, int i16, String str, WadlParams wadlParams);

    void checkInstallChannel(int i3, int i16, String str, String str2, String str3);

    TrpcProxy.TrpcInovkeReq createTrpcInvokeReq(String str, boolean z16, byte[] bArr);

    void destroy();

    void dyeUser(String str, String str2, String str3, int i3, int i16, QQGameGcSpkTaskDye.SubscribeReq subscribeReq, String str4, String str5);

    void getGameList();

    boolean isUseCanaryEnv();

    void onRespTrpcSso(Intent intent, boolean z16, int i3, int i16, byte[] bArr);

    void querySubscribeStatus(String str, String str2, Bundle bundle);

    void removeListener(WadlTrpcListener wadlTrpcListener);

    void reportAtta(JSONObject jSONObject);

    void reportAtta157(JSONObject jSONObject);

    void reportAttaV2(JSONObject jSONObject);

    void reportInstallAction(String str, String str2, int i3);

    void reportRealDownloadSpeed(long j3, QQGameDownloadSpeedReporter$GameDownloadInfo qQGameDownloadSpeedReporter$GameDownloadInfo);

    void reportTianJi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void reportToDcByTrpc(JSONObject jSONObject);

    void requestTrpc(TrpcProxy.TrpcListReq trpcListReq, Bundle bundle);

    void requestTrpcForSpring(TrpcProxy.TrpcListReq trpcListReq, Bundle bundle);

    void setUseCanaryEnv(boolean z16);

    void subscribe(String str, String str2, String str3, int i3, Bundle bundle);

    void subscribeNewVersionReq(String str, String str2, String str3, Bundle bundle);
}
