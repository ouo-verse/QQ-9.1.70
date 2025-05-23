package com.tencent.timi.game.jump.api;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/jump/api/ITimiGameParserFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParserClass", "getTeamCreateParserClass", "getTeamJoinParserClass", "getQQLiveOpenMainParserClass", "getQQLiveStartLiveParserClass", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface ITimiGameParserFactory extends QRouteApi {
    @NotNull
    Class<? extends av> getJumpParserClass();

    @NotNull
    Class<? extends av> getQQLiveOpenMainParserClass();

    @NotNull
    Class<? extends av> getQQLiveStartLiveParserClass();

    @NotNull
    Class<? extends av> getTeamCreateParserClass();

    @NotNull
    Class<? extends av> getTeamJoinParserClass();
}
