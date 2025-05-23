package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/quickupdate/a;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "", "getBid", "", "getFrom", "getBusinessDir", "", "id", "level", "transformScid", "getSavePath", "bid", "scid", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "getBusinessItemInfo", "<init>", "()V", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends QQVasUpdateBusiness<a> {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 59L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "bigVipLevelBadge";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @Nullable String scid) {
        String savePath = getSavePath(scid);
        BusinessItemInfo itemInfo = super.getBusinessItemInfo(bid, scid);
        itemInfo.mSaveInDir = false;
        itemInfo.mSavePath = savePath;
        Intrinsics.checkNotNullExpressionValue(itemInfo, "itemInfo");
        return itemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "BigMemberLevelBadgeBusiness";
    }

    @NotNull
    public final String getSavePath(int id5, int level) {
        String savePath = getSavePath(transformScid(id5, level));
        Intrinsics.checkNotNullExpressionValue(savePath, "getSavePath(transformScid(id, level))");
        return savePath;
    }

    @NotNull
    public final String transformScid(int id5, int level) {
        return "bigVipLevelBadge." + id5 + "." + level + ".png";
    }
}
