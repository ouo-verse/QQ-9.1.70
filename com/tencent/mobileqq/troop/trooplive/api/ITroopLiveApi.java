package com.tencent.mobileqq.troop.trooplive.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncRoomIDRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/trooplive/api/ITroopLiveApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "needJumpSyncRoom", "", "troopId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "needJump", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncRoomIDRsp;", "syncRoomInfo", "Lcom/tencent/mobileqq/troop/trooplive/api/CallBackSyncRoomFun;", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopLiveApi extends QRouteApi {
    void needJumpSyncRoom(@NotNull String troopId, @NotNull Function2<? super Boolean, ? super TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> callback);
}
