package com.tencent.troopguild;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.troop.api.config.j;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"Lcom/tencent/troopguild/TroopGuildInfoListProcessor;", "Lcom/tencent/mobileqq/troop/api/config/j;", "Lcom/tencent/common/app/AppInterface;", "app", "", "b", "<init>", "()V", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class TroopGuildInfoListProcessor extends j {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.api.config.j
    public void b(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        ((ITroopGuildInfoService) app.getRuntimeService(ITroopGuildInfoService.class, "")).onGetTroopList();
        Integer groupGuildFlag = ((IGuildUserService) app.getRuntimeService(IGuildUserService.class, "")).getGroupGuildFlag();
        if (groupGuildFlag == null || groupGuildFlag.intValue() != 1) {
            return;
        }
        ((IGuildDelayInitializeService) app.getRuntimeService(IGuildDelayInitializeService.class, "")).scheduleTask(new IGuildDelayInitializeService.InitializeTask("TroopGuildInfoListProcessor.onGetTroopList delay clearGuildRelatedData", new TroopGuildInfoListProcessor$onGetTroopListWithDetail$1(app)));
    }
}
