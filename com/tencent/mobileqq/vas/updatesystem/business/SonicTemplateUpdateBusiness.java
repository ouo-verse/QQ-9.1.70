package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/SonicTemplateUpdateBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "Lcom/tencent/vas/update/business/BaseUpdateBusiness;", "()V", "getBid", "", "getBusinessDir", "", "getBusinessItemInfo", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "bid", "scid", "getCustomItemInfo", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness$CustomBusinessItemInfo;", "getFrom", "isEnableCheckFile", "", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SonicTemplateUpdateBusiness extends QQVasUpdateBusiness<BaseUpdateBusiness> {

    @NotNull
    private static final String TAG = "SonicTemplateUpdateBusiness";

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 1001L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "sonic";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @Nullable String scid) {
        BusinessItemInfo info = super.getBusinessItemInfo(bid, scid);
        info.mSaveInDir = false;
        info.mSavePath = getSavePath(scid) + File.separator + scid;
        Intrinsics.checkNotNullExpressionValue(info, "info");
        return info;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long bid, @Nullable String scid) {
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        customBusinessItemInfo.mSaveInDir = false;
        customBusinessItemInfo.mSavePath = getSavePath(scid) + File.separator + scid;
        return customBusinessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
