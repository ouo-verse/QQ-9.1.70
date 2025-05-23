package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.intervideo.nowproxy.CustomInterfaceLogic;
import com.tencent.qqinterface.CustomFlagInterface;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CustomFlagInterfaceImpl implements CustomFlagInterface {
    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomBeaconReport() {
        return CustomInterfaceLogic.getsInstance().isBeaconReportCustomizedBySdk();
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomCGIReq() {
        return CustomInterfaceLogic.getsInstance().isCGIReqCustomizedBySdk();
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomCS() {
        return false;
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomCoverImg() {
        return CustomInterfaceLogic.getsInstance().isCustomCoverImg();
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomDownload() {
        return CustomInterfaceLogic.getsInstance().isDownLoadCustomizedBySdk();
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomLog() {
        return CustomInterfaceLogic.getsInstance().isLogCusomizedBySdk();
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomReport() {
        return CustomInterfaceLogic.getsInstance().isReportCustomizedBySDK();
    }

    @Override // com.tencent.qqinterface.CustomFlagInterface
    public boolean isCustomWebview() {
        return CustomInterfaceLogic.getsInstance().isWebviewCusomizedBySdk();
    }
}
