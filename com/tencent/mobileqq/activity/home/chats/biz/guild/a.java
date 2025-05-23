package com.tencent.mobileqq.activity.home.chats.biz.guild;

import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/a;", "", "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSubscribeChannelReturnType;", "returnType", "", "a", "", "value", "b", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f182944a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String guildId = "";

    a() {
    }

    @JvmStatic
    public static final void a(@NotNull GuildSubscribeChannelReturnType returnType) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_return_type", Integer.valueOf(returnType.getValue())), TuplesKt.to("sgrp_channel_id", guildId));
        VideoReport.reportEvent("ev_sgrp_subscribe_channel_return_clk", mapOf);
    }
}
