package com.tencent.mobileqq.guild.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\nR*\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\f\u0010\bR*\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0010\u0010\u0004\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0003\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/util/a;", "", "", "b", "Ljava/lang/String;", "getBackUrl", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "getBackUrl$annotations", "()V", "backUrl", "c", "getTitle", "getTitle$annotations", "title", "d", "getGuildId", "getGuildId$annotations", "guildId", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String backUrl;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f235421a = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String title = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String guildId = "";

    a() {
    }

    public static final void a(@Nullable String str) {
        backUrl = str;
    }

    public static final void b(@Nullable String str) {
        guildId = str;
    }

    public static final void c(@Nullable String str) {
        title = str;
    }
}
