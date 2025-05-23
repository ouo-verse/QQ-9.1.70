package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0004B3\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/share/g;", "", "", "", "a", "Lcom/tencent/mobileqq/sharepanel/model/d;", "b", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "getGuildSharePageSource", "()Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "guildSharePageSource", "c", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "d", "getChannelId", "channelId", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;Ljava/lang/String;Ljava/lang/String;)V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GuildSharePageSource guildSharePageSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String channelId;

    public g(@NotNull Activity activity, @Nullable GuildSharePageSource guildSharePageSource, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.guildSharePageSource = guildSharePageSource;
        this.guildId = str;
        this.channelId = str2;
    }

    private final Map<String, Object> a() {
        int ordinal;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[1];
        GuildSharePageSource guildSharePageSource = this.guildSharePageSource;
        if (guildSharePageSource != null) {
            ordinal = guildSharePageSource.ordinal();
        } else {
            ordinal = GuildSharePageSource.UNKNOWN.ordinal();
        }
        pairArr[0] = TuplesKt.to(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(ordinal));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        String str = this.guildId;
        if (str != null) {
            mutableMapOf.put("sgrp_channel_id", str);
            mutableMapOf.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(str)));
        }
        String str2 = this.channelId;
        if (str2 != null) {
            mutableMapOf.put("sgrp_sub_channel_id", str2);
        }
        mutableMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        return mutableMapOf;
    }

    @NotNull
    public final com.tencent.mobileqq.sharepanel.model.d b() {
        GuildSharePageSource guildSharePageSource = this.guildSharePageSource;
        if (guildSharePageSource == null) {
            guildSharePageSource = GuildSharePageSource.UNKNOWN;
        }
        String valueOf = String.valueOf(guildSharePageSource.ordinal());
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : a().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
        return new com.tencent.mobileqq.sharepanel.model.d(valueOf, jSONObject2);
    }

    public /* synthetic */ g(Activity activity, GuildSharePageSource guildSharePageSource, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i3 & 2) != 0 ? null : guildSharePageSource, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2);
    }
}
