package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;

/* compiled from: P */
/* loaded from: classes20.dex */
public class IntimacyDownloadBusiness extends QQVasUpdateBusiness {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 322L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "intimacy";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "intimacy";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "intimacy." + i3 + ".common.zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
