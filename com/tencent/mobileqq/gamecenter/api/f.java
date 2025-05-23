package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersRsp;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/f;", "", "", "onGameCardRemoved", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$GetGameMsgPartnersRsp;", "gameCardInfo", "onGetGameCardInfo", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface f {
    void onGameCardRemoved();

    void onGetGameCardInfo(@Nullable SgamePartnerSvr$GetGameMsgPartnersRsp gameCardInfo);
}
