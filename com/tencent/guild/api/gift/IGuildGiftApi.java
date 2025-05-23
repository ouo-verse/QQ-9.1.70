package com.tencent.guild.api.gift;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildGiftApi extends QRouteApi {
    void enterRoom();

    void exitRoom();

    void handleGiftBtnClick(@NotNull com.tencent.aio.part.root.panel.mvx.config.c cVar, int i3);

    void preLoadGiftData(@NotNull String str);

    void releaseAnimationEngine();

    void startGiftAnimation(com.tencent.aio.main.businesshelper.b bVar, @NotNull GuildMsgItem guildMsgItem, boolean z16, boolean z17, @Nullable String str);
}
