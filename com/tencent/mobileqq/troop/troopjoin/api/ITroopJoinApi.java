package com.tencent.mobileqq.troop.troopjoin.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.troopjoin.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JP\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H&JX\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001026\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H&JT\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00102:\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u0019H&Jf\u0010\u001e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00102:\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u0019H&J0\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0013H&J\u000e\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H&\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/api/ITroopJoinApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopjoin/a;", "param", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/troop/troopjoin/TryJoinTroopResult;", "Lkotlin/ParameterName;", "name", "result", "", "bizErrorCode", "", "callback", "joinTroop", "", "skipCheck", "tryLaunchJoinTroop", "", "troopId", "isFromTroopCard", "needShow", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;", "subTroopInfo", "Lcom/tencent/mobileqq/troop/troopjoin/api/CallBackSubTroopFun;", "needShowSubTroopWithTroopId", "troopUin", "troopMemberCount", "troopMaxMemberCount", "needShowSubTroopWithTroopInfo", "mainTroopId", "sourceId", "sourcePageDTId", "showSwitchSubTroop", "Ljava/lang/Class;", "getJoinTroopJumpParser", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopJoinApi extends QRouteApi {
    @Nullable
    Class<?> getJoinTroopJumpParser();

    void joinTroop(@NotNull Context context, @NotNull a param, @NotNull Function2<? super TryJoinTroopResult, ? super Integer, Unit> callback);

    void needShowSubTroopWithTroopId(@NotNull String troopId, boolean isFromTroopCard, @NotNull Function2<? super Boolean, ? super TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> callback);

    void needShowSubTroopWithTroopInfo(@Nullable String troopUin, int troopMemberCount, int troopMaxMemberCount, boolean isFromTroopCard, @NotNull Function2<? super Boolean, ? super TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> callback);

    void showSwitchSubTroop(@NotNull Context context, @NotNull String mainTroopId, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo, int sourceId, @NotNull String sourcePageDTId);

    void tryLaunchJoinTroop(@NotNull Context context, @NotNull a param, boolean skipCheck, @NotNull Function2<? super TryJoinTroopResult, ? super Integer, Unit> callback);
}
