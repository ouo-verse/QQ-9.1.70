package com.tencent.mobileqq.guild.setting.guildmanage.navigation;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatusChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "navigationStatus", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;)V", "getNavigationStatus", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildNavigationStatusChangeEvent extends SimpleBaseEvent {

    @NotNull
    private final GuildNavigationStatus navigationStatus;

    public GuildNavigationStatusChangeEvent(@NotNull GuildNavigationStatus navigationStatus) {
        Intrinsics.checkNotNullParameter(navigationStatus, "navigationStatus");
        this.navigationStatus = navigationStatus;
    }

    @NotNull
    public final GuildNavigationStatus getNavigationStatus() {
        return this.navigationStatus;
    }
}
