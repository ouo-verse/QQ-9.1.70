package com.tencent.mobileqq.vas.vipicon;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k extends QQVasUpdateBusiness {
    @NotNull
    public String e(int i3) {
        return getSavePath(getScid(i3)) + "/" + i3 + ".png";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 44L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "namePlatePendant_dir";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "NamePlatePendantBusiness";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "nameplatependant.{id}.common.zip".replace("{id}", i3 + "");
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }
}
