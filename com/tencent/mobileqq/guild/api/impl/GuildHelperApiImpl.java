package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import com.tencent.mobileqq.guild.api.IGuildHelperApi;
import com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.GuildMyProfileFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment;
import com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildNoticeIncomeFragment;
import com.tencent.mobileqq.guild.profile.me.GuildMeFragment;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildHelperApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildHelperApi;", "()V", "onClickGuildHelperCommonItem", "", "context", "Landroid/content/Context;", "peerUidInt", "", "(Landroid/content/Context;Ljava/lang/Integer;)V", "openGuildMeFragment", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildHelperApiImpl implements IGuildHelperApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildHelperApi
    public void onClickGuildHelperCommonItem(@NotNull Context context, @Nullable Integer peerUidInt) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (peerUidInt != null && peerUidInt.intValue() == 101) {
            GuildNoticeIncomeFragment.INSTANCE.b(context);
            return;
        }
        if (peerUidInt != null && peerUidInt.intValue() == 102) {
            GuildMyProfileFragment.INSTANCE.a(context, new GuildMyProfileFragment.OpenParam(0, null, null, 7, null));
            return;
        }
        if (peerUidInt != null && peerUidInt.intValue() == 103) {
            GuildAssistantFragment.INSTANCE.b(context);
        } else if (peerUidInt != null && peerUidInt.intValue() == 104) {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildVisitorFeedNoticeFragment();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHelperApi
    public void openGuildMeFragment(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GuildMeFragment.INSTANCE.a(context);
    }
}
