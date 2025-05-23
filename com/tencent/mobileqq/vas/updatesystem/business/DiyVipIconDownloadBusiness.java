package com.tencent.mobileqq.vas.updatesystem.business;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DiyVipIconDownloadBusiness extends QQVasUpdateBusiness {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 56L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "vipicon_download";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "vip";
    }

    public File getImagesRoot(Context context, int i3) {
        return new File(getSavePath(getScid(i3)));
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return getScidPrefix() + "." + i3 + ".zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getScidPrefix() {
        return "qqcustomnameplate";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void startDownload(int i3) {
        super.startDownload(i3);
    }
}
