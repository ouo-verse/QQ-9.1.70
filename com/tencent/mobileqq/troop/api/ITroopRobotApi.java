package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H&J(\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\u000b\u001a\u00020\nH&J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITroopRobotApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedUins", "Lcom/tencent/mobileqq/troop/api/c;", "initTroopRobotInviteFilter", "robotUidList", "Ljava/lang/Runnable;", "runnable", "", "fetchRobotInfo", "robotUin", "", "canInviteToTroop", "couldInviteTroopRobot", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopRobotApi extends QRouteApi {
    boolean canInviteToTroop(@Nullable String troopUin, @Nullable String robotUin);

    boolean couldInviteTroopRobot(@Nullable String troopUin);

    void fetchRobotInfo(@NotNull ArrayList<String> robotUidList, @NotNull Runnable runnable);

    @NotNull
    c initTroopRobotInviteFilter(@Nullable String troopUin, @Nullable ArrayList<String> selectedUins);
}
