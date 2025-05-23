package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ColorScreenBusiness extends QQVasUpdateBusiness {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 22L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "profile_color_screen";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "color_screen";
    }

    public String getImagesDir(int i3) {
        return getSavePath(i3) + File.separator + "images";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "colorScreen.android." + i3;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
