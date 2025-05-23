package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBusinessInject;
import com.tencent.mobileqq.vas.updatesystem.business.DefaultCardBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.StickerGuideMaterialBusiness;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/impl/VasUpdateBusinessInjectImpl;", "Lcom/tencent/mobileqq/vas/updatesystem/api/IVasUpdateBusinessInject;", "", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "getInjectList", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasUpdateBusinessInjectImpl implements IVasUpdateBusinessInject {

    @NotNull
    private static final String TAG = "VasUpdateBusinessInjectImpl";

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBusinessInject
    @Nullable
    public List<QQVasUpdateBusiness<?>> getInjectList() {
        ArrayList arrayList = new ArrayList();
        Boolean isUseUpdateBusinessMigration = QQVasUpdateBusiness.isUseUpdateBusinessMigration(3L);
        Intrinsics.checkNotNullExpressionValue(isUseUpdateBusinessMigration, "isUseUpdateBusinessMigration(BID.THEME)");
        if (isUseUpdateBusinessMigration.booleanValue()) {
            arrayList.add(new ThemeUpdateBusiness());
            QLog.i(TAG, 1, "getInjectList, add theme");
        }
        Boolean isUseUpdateBusinessMigration2 = QQVasUpdateBusiness.isUseUpdateBusinessMigration(1004L);
        Intrinsics.checkNotNullExpressionValue(isUseUpdateBusinessMigration2, "isUseUpdateBusinessMigra\u2026D_STICKER_GUIDE_MATERIAL)");
        if (isUseUpdateBusinessMigration2.booleanValue()) {
            arrayList.add(new StickerGuideMaterialBusiness());
        }
        Boolean isUseUpdateBusinessMigration3 = QQVasUpdateBusiness.isUseUpdateBusinessMigration(33L);
        Intrinsics.checkNotNullExpressionValue(isUseUpdateBusinessMigration3, "isUseUpdateBusinessMigra\u2026nstants.BID_DEFAULT_CARD)");
        if (isUseUpdateBusinessMigration3.booleanValue()) {
            arrayList.add(new DefaultCardBusiness());
        }
        return arrayList;
    }
}
