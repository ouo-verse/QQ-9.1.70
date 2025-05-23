package com.tencent.guild.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/api/IGuildAioPopupPanelConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchTroopListSwitch", "", "qqAppInterface", "Lcom/tencent/common/app/AppInterface;", "guildId", "", "fetchCallback", "Lkotlin/Function1;", "", "isEnableTroopList", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes6.dex */
public interface IGuildAioPopupPanelConfigApi extends QRouteApi {
    void fetchTroopListSwitch(@NotNull AppInterface qqAppInterface, long guildId, @Nullable Function1<? super Boolean, Unit> fetchCallback);

    boolean isEnableTroopList();
}
