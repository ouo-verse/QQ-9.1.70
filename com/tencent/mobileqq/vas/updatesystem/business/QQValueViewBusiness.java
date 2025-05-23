package com.tencent.mobileqq.vas.updatesystem.business;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQValueViewBusiness extends QQVasUpdateBusiness {
    public static final long BID = 52;
    protected static final String TAG = "VasUpdate_QQValueViewBusiness";

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 52L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "qqvalue_dir";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "QQValueViewBusiness";
    }
}
