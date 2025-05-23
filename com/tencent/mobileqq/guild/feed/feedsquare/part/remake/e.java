package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ)\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/e;", "", "", "guildId", "channelId", "", "sectionType", "Landroid/os/Bundle;", "a", "bundle", "shareSource", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "c", "sectionName", "", "isMember", "b", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Boolean;)Landroid/os/Bundle;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f218972a = new e();

    e() {
    }

    @NotNull
    public final Bundle a(@NotNull String guildId, @NotNull String channelId, int sectionType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        String str = com.tencent.mobileqq.guild.feed.b.f218115a;
        GuildFeedSquareInitBean guildFeedSquareInitBean = new GuildFeedSquareInitBean();
        guildFeedSquareInitBean.setGuildId(guildId);
        guildFeedSquareInitBean.setChannelId(channelId);
        guildFeedSquareInitBean.setBusinessType(av.f223852a.a(sectionType));
        Unit unit = Unit.INSTANCE;
        return BundleKt.bundleOf(TuplesKt.to(str, guildFeedSquareInitBean));
    }

    @NotNull
    public final Bundle b(@NotNull Bundle bundle, @Nullable String sectionName, @Nullable Boolean isMember) {
        GuildFeedSquareInitBean guildFeedSquareInitBean;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Serializable serializable = bundle.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        if (serializable instanceof GuildFeedSquareInitBean) {
            guildFeedSquareInitBean = (GuildFeedSquareInitBean) serializable;
        } else {
            guildFeedSquareInitBean = null;
        }
        if (guildFeedSquareInitBean != null) {
            if (sectionName == null) {
                sectionName = "";
            }
            guildFeedSquareInitBean.setChannelName(sectionName);
            if (isMember != null) {
                isMember.booleanValue();
                guildFeedSquareInitBean.setIsMember(isMember.booleanValue());
            }
            bundle.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedSquareInitBean);
        }
        return bundle;
    }

    @NotNull
    public final Bundle c(@NotNull Bundle bundle, int shareSource, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam) {
        GuildFeedSquareInitBean guildFeedSquareInitBean;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Serializable serializable = bundle.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        if (serializable instanceof GuildFeedSquareInitBean) {
            guildFeedSquareInitBean = (GuildFeedSquareInitBean) serializable;
        } else {
            guildFeedSquareInitBean = null;
        }
        if (guildFeedSquareInitBean != null) {
            guildFeedSquareInitBean.setShareSource(shareSource);
            guildFeedSquareInitBean.setJoinInfoParam(joinInfoParam);
            bundle.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedSquareInitBean);
        }
        return bundle;
    }
}
