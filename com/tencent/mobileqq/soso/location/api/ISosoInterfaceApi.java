package com.tencent.mobileqq.soso.location.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.ISosoInterfaceConstant;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* compiled from: P */
@QAPI(process = {"all"})
@Deprecated
/* loaded from: classes18.dex */
public interface ISosoInterfaceApi extends QRouteApi, ISosoInterfaceConstant {
    SosoLbsInfo getCanUsedLbsInfoCache(long j3, boolean z16, int i3, boolean z17);

    String getCityCode();

    @Deprecated
    SosoLbsInfo getRawSosoInfo();

    @Deprecated
    SosoLbsInfo getSosoInfo();

    String getSosoInterfaceBlackClassName();

    ClassLoader getSosoInterfaceClassLoader();

    void onDestroy();

    void removeOnLocationListener(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener);

    @Deprecated
    void reqRawLbsData(long j3, String str);

    void saveNormalEnterConversationTime(long j3);

    boolean saveSosoInterfaceConfig(String str);

    void setResumeFlagFromConversation(long j3);

    void startLocation(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener);

    void startOfficialLocation();

    void updateMainProcessCachedLocation(int i3, SosoLbsInfo sosoLbsInfo);

    void updateRawData(String str, byte[] bArr);
}
