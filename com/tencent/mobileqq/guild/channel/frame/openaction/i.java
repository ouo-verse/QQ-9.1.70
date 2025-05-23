package com.tencent.mobileqq.guild.channel.frame.openaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface i {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a {
        @NotNull
        public static Bundle a(@NotNull i iVar, @NotNull JumpGuildParam jumpGuildParam) {
            Intent intent;
            Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", jumpGuildParam.getGuildId());
            bundle.putString("channelId", jumpGuildParam.getChannelId());
            bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, jumpGuildParam.getJoinInfoParam());
            bundle.putParcelable(JumpGuildParam.KEY_DETAIL_PAGE_JUMP_INFO, jumpGuildParam.getDetailPageJumpInfo());
            bundle.putParcelable("GuildAppReportSourceInfo", jumpGuildParam.getReportSourceInfo());
            bundle.putParcelable("GuildFeedReportSourceInfo", jumpGuildParam.getFeedReportSourceInfo());
            Object obj = jumpGuildParam.extras.get("activity_bundle");
            Bundle bundle2 = null;
            if (obj instanceof Intent) {
                intent = (Intent) obj;
            } else {
                intent = null;
            }
            if (intent != null) {
                bundle2 = intent.getExtras();
            }
            if (bundle2 != null) {
                jumpGuildParam.extras.remove("activity_bundle");
                bundle2.setClassLoader(jumpGuildParam.getClass().getClassLoader());
                bundle.putAll(jumpGuildParam.extras);
                bundle.putAll(bundle2);
            } else {
                bundle.putAll(jumpGuildParam.extras);
            }
            return bundle;
        }
    }

    boolean a(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam);
}
