package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.vas.update.entity.BusinessItemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/StickerGuideMaterialBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "()V", "getBid", "", "getBusinessDir", "", "getBusinessItemInfo", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "bid", "scid", "getEpId", "getFrom", "getSavePath", "getSaveZipPath", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class StickerGuideMaterialBusiness extends QQVasUpdateBusiness<StickerGuideMaterialBusiness> {
    private final String getEpId(String scid) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) scid, '.', 23, false, 4, (Object) null);
        String substring = scid.substring(23, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    private final String getSaveZipPath(String scid) {
        String replace$default;
        String epId = getEpId(scid);
        String H5MagicZipPath = MarketFaceConstants.H5MagicZipPath;
        Intrinsics.checkNotNullExpressionValue(H5MagicZipPath, "H5MagicZipPath");
        replace$default = StringsKt__StringsJVMKt.replace$default(H5MagicZipPath, "[epId]", epId, false, 4, (Object) null);
        return replace$default;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 1004L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "guideMaterial";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @NotNull String scid) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(scid, "scid");
        BusinessItemInfo itemInfo = super.getBusinessItemInfo(bid, scid);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, VasUpdateConstants.SCID_H5_MAGIC_ZIP, false, 2, null);
        if (startsWith$default) {
            itemInfo.mSaveInDir = false;
            itemInfo.mSavePath = getSaveZipPath(scid);
        }
        Intrinsics.checkNotNullExpressionValue(itemInfo, "itemInfo");
        return itemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "StickerGuideMaterial";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public String getSavePath(@NotNull String scid) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(scid, "scid");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, VasUpdateConstants.SCID_H5_MAGIC_ZIP, false, 2, null);
        if (startsWith$default) {
            return getSaveZipPath(scid);
        }
        String savePath = super.getSavePath(scid);
        Intrinsics.checkNotNullExpressionValue(savePath, "super.getSavePath(scid)");
        return savePath;
    }
}
