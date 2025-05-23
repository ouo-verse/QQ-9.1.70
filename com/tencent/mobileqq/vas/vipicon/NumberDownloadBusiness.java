package com.tencent.mobileqq.vas.vipicon;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NumberDownloadBusiness extends QQVasUpdateBusiness {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 324L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "number";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "serialnumber";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "serialnumber." + i3 + ".png.zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
