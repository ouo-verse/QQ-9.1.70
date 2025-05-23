package com.tencent.mobileqq.vas.updatesystem.business;

/* compiled from: P */
/* loaded from: classes20.dex */
public class XAResBusiness extends QQVasUpdateBusiness {
    public static final long BID = 54;
    protected static final String TAG = "VasUpdate_XAResBusiness";

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 54L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "xares";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "XAResBusiness";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        if (i3 >= 8) {
            return getScidPrefix() + "android." + i3;
        }
        return super.getScid(i3);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getScidPrefix() {
        return "xaResource.";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return QQVasUpdateBusiness.isEnableFileCheck(getBid());
    }
}
