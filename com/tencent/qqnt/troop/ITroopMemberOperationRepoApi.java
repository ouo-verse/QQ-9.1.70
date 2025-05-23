package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.qqnt.bean.InviteToTroopParam;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&JJ\u0010\u0012\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J>\u0010\u0016\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J8\u0010\u0012\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&J,\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J,\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u001cH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/troop/ITroopMemberOperationRepoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "memberUid", "", "gagTimeStamp", "Landroidx/lifecycle/LifecycleOwner;", "owner", "from", "Lcom/tencent/qqnt/troop/i;", "asyncCallback", "", "setMemberShutUp", "groupCode", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "invitedUidList", "inviteToGroup", "", "Lcom/tencent/mobileqq/troop/data/TroopCreateInfo$a;", "invitedMemberList", "inviteMembersToGroup", "Lcom/tencent/qqnt/bean/InviteToTroopParam;", "param", "", "securityPass", "Lcom/tencent/qqnt/bean/b;", "Lcom/tencent/qqnt/troop/c;", "deleteTroopMember", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopMemberOperationRepoApi extends QRouteApi {
    void deleteTroopMember(@NotNull com.tencent.qqnt.bean.b param, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable c asyncCallback);

    void inviteMembersToGroup(@Nullable String groupCode, @Nullable List<? extends TroopCreateInfo.a> invitedMemberList, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void inviteToGroup(@NotNull InviteToTroopParam param, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void inviteToGroup(@NotNull InviteToTroopParam param, @NotNull String from, boolean securityPass);

    void inviteToGroup(@Nullable String groupCode, @Nullable String memberUid, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void inviteToGroup(@Nullable String groupCode, @Nullable ArrayList<String> invitedUidList, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);

    void setMemberShutUp(@Nullable String troopUin, @Nullable String memberUid, long gagTimeStamp, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback);
}
