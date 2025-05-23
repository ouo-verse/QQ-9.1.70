package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import cooperation.photoplus.sticker.Sticker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/DefaultCardBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "()V", "getBid", "", "getBusinessDir", "", "getCustomItemInfo", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness$CustomBusinessItemInfo;", "bid", "scid", "getFrom", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class DefaultCardBusiness extends QQVasUpdateBusiness<DefaultCardBusiness> {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 33L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "default_card";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long bid, @Nullable String scid) {
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        customBusinessItemInfo.mSaveInDir = false;
        customBusinessItemInfo.mSavePath = getSavePath(scid) + "/" + getBid() + "_" + scid + Sticker.JSON_SUFFIX;
        return customBusinessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "default_card";
    }
}
