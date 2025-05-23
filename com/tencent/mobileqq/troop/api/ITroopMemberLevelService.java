package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0013\u001a\u00020\u0012H&J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0016H&J\b\u0010\u001b\u001a\u00020\fH&J\b\u0010\u001c\u001a\u00020\bH&J\b\u0010\u001d\u001a\u00020\fH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITroopMemberLevelService;", "Lmqq/app/api/IRuntimeService;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "isAllowDisplayInAIO", "", "newConfig", "", "updateConfig", "", "troopUin", "onTroopAdminChanged", "isNewRealLevelGrayTroop", "Lcom/tencent/mobileqq/troop/memberlevel/api/b;", "getConfig", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "Lcom/tencent/qqnt/aio/nick/f;", "getTroopMemberLevelForAIO", "memberUin", "memberLevelInfo", "sendMemberLevelUpdateEvent", "checkNeedRefreshAIOWhenProcessMsg", "isNeedRefreshTroopAIO", "clearNeedRefreshTroopFlag", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface ITroopMemberLevelService extends IRuntimeService {
    void checkNeedRefreshAIOWhenProcessMsg();

    void clearNeedRefreshTroopFlag();

    @NotNull
    com.tencent.mobileqq.troop.memberlevel.api.b getConfig();

    @NotNull
    com.tencent.qqnt.aio.nick.f getTroopMemberLevelForAIO(@NotNull TroopInfo troopInfo, @Nullable TroopMemberInfo troopMemberInfo);

    boolean isAllowDisplayInAIO(@NotNull AppRuntime appRuntime, @NotNull TroopInfo troopInfo, @NotNull AIOMsgItem msgItem);

    boolean isNeedRefreshTroopAIO();

    boolean isNewRealLevelGrayTroop(@Nullable String troopUin);

    void onTroopAdminChanged(@Nullable String troopUin);

    void sendMemberLevelUpdateEvent(@NotNull String troopUin, @NotNull String memberUin, @NotNull com.tencent.qqnt.aio.nick.f memberLevelInfo);

    void updateConfig(@Nullable Object newConfig);
}
