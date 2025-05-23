package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import cooperation.photoplus.sticker.Sticker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/PokeBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "()V", "getBid", "", "getBusinessDir", "", "getBusinessItemInfo", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "bid", "scid", "getCustomItemInfo", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness$CustomBusinessItemInfo;", "getFrom", "isEnableCheckFile", "", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PokeBusiness extends QQVasUpdateBusiness<PokeBusiness> {

    @NotNull
    private static final String EFFECT_LIST = "poke.effectList";

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 21L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "poke";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @Nullable String scid) {
        BusinessItemInfo info = super.getBusinessItemInfo(bid, scid);
        if (Intrinsics.areEqual(scid, "poke.effectList")) {
            info.mSaveInDir = false;
            info.mSavePath = info.mSavePath + Sticker.JSON_SUFFIX;
        }
        Intrinsics.checkNotNullExpressionValue(info, "info");
        return info;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long bid, @Nullable String scid) {
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        if (Intrinsics.areEqual(scid, "poke.effectList")) {
            customBusinessItemInfo.mSaveInDir = false;
            customBusinessItemInfo.mSavePath = getSavePath(scid) + Sticker.JSON_SUFFIX;
        }
        return customBusinessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "PokeBusiness";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
