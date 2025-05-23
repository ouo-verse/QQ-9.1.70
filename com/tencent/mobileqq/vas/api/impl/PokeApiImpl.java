package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.api.IPokeApi;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/PokeApiImpl;", "Lcom/tencent/mobileqq/vas/api/IPokeApi;", "()V", "getNewPokeBusiness", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "getPokeEffectRootPath", "", "id", "", "getPokeResRootPath", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PokeApiImpl implements IPokeApi {
    private final QQVasUpdateBusiness<?> getNewPokeBusiness() {
        Boolean migration = QQVasUpdateBusiness.isUseUpdateBusinessMigration(21L);
        Intrinsics.checkNotNullExpressionValue(migration, "migration");
        if (!migration.booleanValue()) {
            return null;
        }
        try {
            return QQVasUpdateBusiness.getBusiness(21L);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPokeApi
    @NotNull
    public String getPokeEffectRootPath(int id5) {
        QQVasUpdateBusiness<?> newPokeBusiness = getNewPokeBusiness();
        if (newPokeBusiness != null) {
            String savePath = newPokeBusiness.getSavePath(VasUpdateConstants.SCID_POKE_PANEL_PREFIX + id5);
            Intrinsics.checkNotNullExpressionValue(savePath, "{\n            newPokeBus\u2026em.effect.$id\")\n        }");
            return savePath;
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.poke.ag.f191654d + File.separator + id5;
    }

    @Override // com.tencent.mobileqq.vas.api.IPokeApi
    @NotNull
    public String getPokeResRootPath(int id5) {
        QQVasUpdateBusiness<?> newPokeBusiness = getNewPokeBusiness();
        if (newPokeBusiness != null) {
            String savePath = newPokeBusiness.getSavePath(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + id5);
            Intrinsics.checkNotNullExpressionValue(savePath, "{\n            newPokeBus\u2026.item.res.$id\")\n        }");
            return savePath;
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.poke.ag.f191654d + File.separator + id5;
    }
}
