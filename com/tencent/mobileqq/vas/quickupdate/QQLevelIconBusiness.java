package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQLevelIconBusiness extends QQVasUpdateBusiness {
    public static QQLevelIconBusiness sInstance = new QQLevelIconBusiness();

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 41L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "qqlevel_icon";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "qq_level";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        if (i3 == 0) {
            i3 = 136;
        }
        return "qqVipLevel." + i3;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
