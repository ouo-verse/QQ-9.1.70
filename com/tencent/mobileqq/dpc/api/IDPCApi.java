package com.tencent.mobileqq.dpc.api;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IDPCApi extends QRouteApi, IDPCApiConstant {
    void addObserver(DPCObserver dPCObserver);

    ConfigurationService$ReqGetConfig buidldReqConfig(AppRuntime appRuntime);

    int getAbRamdom();

    String getFeatureValue(String str);

    String getFeatureValue(String str, String str2);

    String getFeatureValueWithoutAccountManager(String str);

    String getFeatureValueWithoutAccountManager(String str, String str2);

    int getMaxAbRamdom();

    int getServerDataCurrentState();

    int getServerDataCurrentStateWithoutAccountManager();

    boolean isFeatureSupported(String str);

    boolean isFeatureSupported(String str, long j3);

    boolean isInited();

    boolean isLoadDpcSpToggleEnable();

    boolean isRichStatusToggleEnable();

    void nextServerDataState(int i3);

    boolean onDPCResponse(ConfigurationService$RespGetConfig configurationService$RespGetConfig, String str);

    int parseComplexParamsBySimpleStringParser(String str, String[] strArr);

    int parseComplexParamsByStringToIntParser(String str, Integer[] numArr);

    void registerBroadCast(AppRuntime appRuntime);

    void removeObserver(DPCObserver dPCObserver);

    void unRegisterBroadCast(AppRuntime appRuntime);
}
