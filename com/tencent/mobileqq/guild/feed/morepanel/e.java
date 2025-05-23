package com.tencent.mobileqq.guild.feed.morepanel;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.v;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0001\u0004B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/e;", "", "", "", "a", "Lcom/tencent/mobileqq/sharepanel/model/d;", "b", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "pageSource", "Ljava/lang/String;", "guildId", "c", "channelId", "d", "feedId", "<init>", "(Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSharePageSource pageSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String feedId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/e$a;", "", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "pageSource", "Lvk1/b;", "provide", "Lcom/tencent/mobileqq/sharepanel/model/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final com.tencent.mobileqq.sharepanel.model.d a(@NotNull GuildSharePageSource pageSource, @NotNull vk1.b provide) {
            Intrinsics.checkNotNullParameter(pageSource, "pageSource");
            Intrinsics.checkNotNullParameter(provide, "provide");
            return new e(pageSource, String.valueOf(provide.getGuildId()), String.valueOf(provide.getChannelId()), provide.getFeedId()).b();
        }

        Companion() {
        }
    }

    public e(@NotNull GuildSharePageSource pageSource, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(pageSource, "pageSource");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.pageSource = pageSource;
        this.guildId = guildId;
        this.channelId = channelId;
        this.feedId = feedId;
    }

    private final Map<String, Object> a() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(this.pageSource.ordinal())));
        String str = this.guildId;
        mutableMapOf.put("sgrp_channel_id", str);
        mutableMapOf.put("sgrp_user_type", Integer.valueOf(v.c(str)));
        mutableMapOf.put("sgrp_sub_channel_id", this.channelId);
        mutableMapOf.put("sgrp_feed_id", this.feedId);
        mutableMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        return mutableMapOf;
    }

    @NotNull
    public final com.tencent.mobileqq.sharepanel.model.d b() {
        String valueOf = String.valueOf(this.pageSource.ordinal());
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : a().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
        return new com.tencent.mobileqq.sharepanel.model.d(valueOf, jSONObject2);
    }
}
