package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;

/* loaded from: classes20.dex */
public class PraiseDownloadBusiness extends QQVasUpdateBusiness {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 20L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "profile_card_praise";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "praise";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String[] getNecessaryFiles() {
        return new String[]{"config.json", "whiteBlackImg.png", "colorImg.png"};
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return VasUpdateConstants.SCID_PRAISE_PREFIX + i3 + ".config.zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
