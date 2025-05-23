package com.tencent.mobileqq.guild.feed.nativepublish.draft;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J0\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/draft/a;", "", "", "guildId", "", "isShortFeed", "topicId", "feedId", "", "b", "d", "c", "actionType", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f221827a = new a();

    a() {
    }

    private final void a(String guildId, String actionType, boolean isShortFeed, String topicId, String feedId) {
        int i3;
        Map mapOf;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("action_type", actionType);
        if (isShortFeed) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pairArr[1] = TuplesKt.to("sgrp_forum_short_article", Integer.valueOf(i3));
        pairArr[2] = TuplesKt.to("sgrp_channel_id", guildId);
        pairArr[3] = TuplesKt.to("sgrp_topic_id", topicId);
        pairArr[4] = TuplesKt.to("sgrp_feed_id", feedId);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("ev_sgrp_draft_edit", null, mapOf);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedDraftReporter", 1, "report: " + mapOf);
        }
    }

    @JvmStatic
    public static final void b(@NotNull String guildId, boolean isShortFeed, @NotNull String topicId, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        f221827a.a(guildId, "1", isShortFeed, topicId, feedId);
    }

    @JvmStatic
    public static final void c(@NotNull String guildId, boolean isShortFeed, @NotNull String topicId, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        f221827a.a(guildId, "3", isShortFeed, topicId, feedId);
    }

    @JvmStatic
    public static final void d(@NotNull String guildId, boolean isShortFeed, @NotNull String topicId, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        f221827a.a(guildId, "2", isShortFeed, topicId, feedId);
    }
}
