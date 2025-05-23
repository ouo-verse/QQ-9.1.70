package com.tencent.mobileqq.shortvideo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShortVideoDebugSetting extends QRouteApi {
    boolean isAIOUseAsyncHardwareVideoCompress();

    boolean isRichMediaPathDebugToolEnable();

    boolean isShowAIOVideoViewDebugInfo();

    boolean isSimulateForwardVideoNotExistsOnServer();

    void setAIOUseAsyncHardwareVideoCompress(boolean z16);

    void setRichMediaPathDebugToolEnable(boolean z16);

    void setShowAIOVideoViewDebugInfo(boolean z16);

    void setSimulateForwardVideoNotExistsOnServer(boolean z16);
}
