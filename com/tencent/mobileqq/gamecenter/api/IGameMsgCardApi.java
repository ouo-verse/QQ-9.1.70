package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersRsp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH&J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IGameMsgCardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/gamecenter/api/f;", "listener", "", "onGameBoxCreate", "onGameBoxDestroy", "onGameCardRemoved", "Lcom/tencent/qqnt/chats/core/data/a;", "builder", "Lje1/a;", "createGameBoxChatsListAdapter", "reqGameCardInfo", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$GetGameMsgPartnersRsp;", "cardInfo", "onGetGameCardInfo", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "createGameCardView", "", "fromOpenId", "toOpenId", "openGameMsgAioInMainProcess", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMsgCardApi extends QRouteApi {
    @NotNull
    je1.a createGameBoxChatsListAdapter(@NotNull com.tencent.qqnt.chats.core.data.a builder);

    @NotNull
    ViewGroup createGameCardView(@NotNull Context context, @NotNull SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo);

    void onGameBoxCreate(@NotNull f listener);

    void onGameBoxDestroy();

    void onGameCardRemoved();

    void onGetGameCardInfo(@Nullable SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo);

    void openGameMsgAioInMainProcess(@Nullable String fromOpenId, @Nullable String toOpenId);

    void reqGameCardInfo();
}
