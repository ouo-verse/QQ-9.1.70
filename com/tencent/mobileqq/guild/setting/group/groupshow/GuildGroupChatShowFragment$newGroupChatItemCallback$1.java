package com.tencent.mobileqq.guild.setting.group.groupshow;

import android.app.Dialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/group/groupshow/GuildGroupChatShowFragment$newGroupChatItemCallback$1", "Lbz1/a;", "", "groupCode", "groupName", "", "b", "signature", "a", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGroupChatShowFragment$newGroupChatItemCallback$1 implements bz1.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GuildGroupChatShowFragment f233443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildGroupChatShowFragment$newGroupChatItemCallback$1(GuildGroupChatShowFragment guildGroupChatShowFragment) {
        this.f233443a = guildGroupChatShowFragment;
    }

    @Override // bz1.a
    public void a(@NotNull String groupCode, @NotNull String signature) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(signature, "signature");
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(this.f233443a.getContext(), aq.e(groupCode, signature, 1016, this.f233443a.guildId), 2);
    }

    @Override // bz1.a
    public void b(@NotNull String groupCode, @NotNull String groupName) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        com.tencent.mobileqq.troop.troopcreate.a.i(this.f233443a.getContext(), groupCode, groupName);
    }

    @Override // bz1.a
    public void c(@NotNull String groupCode, @NotNull String signature, @NotNull String groupName) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(this.f233443a.getContext(), 2, true);
        showOnlyLoadingImageDialog.show();
        ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).needShowSubTroopWithTroopId(groupCode, false, new GuildGroupChatShowFragment$newGroupChatItemCallback$1$onJoinTroop$1(showOnlyLoadingImageDialog, this.f233443a, groupCode, signature, this, groupName));
    }
}
