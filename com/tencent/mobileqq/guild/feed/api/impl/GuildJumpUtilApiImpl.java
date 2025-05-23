package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.feed.api.IGuildJumpUtilApi;
import com.tencent.mobileqq.guild.feed.batchmanage.GuildFeedBatchManageFragment;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildJumpUtilApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildJumpUtilApi;", "()V", "openGuildBatchManagePage", "", "context", "Landroid/content/Context;", "guildId", "", "openUrlOrSchema", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "url", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildJumpUtilApiImpl implements IGuildJumpUtilApi {
    @Override // com.tencent.mobileqq.guild.feed.api.IGuildJumpUtilApi
    public void openGuildBatchManagePage(@NotNull Context context, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QPublicFragmentActivity.start(context, GuildFeedBatchManageFragment.INSTANCE.b(guildId), GuildFeedBatchManageFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildJumpUtilApi
    public void openUrlOrSchema(@Nullable Activity activity, @Nullable String url) {
        GuildJumpUtil.w(activity, url);
    }
}
