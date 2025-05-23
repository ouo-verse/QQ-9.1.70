package com.tencent.mobileqq.guild.media.core;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R0\u0010\u000e\u001a\u001e\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\f0\f0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/w;", "", "", "methodName", "", "c", "d", "tag", "b", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap;", "sLogs", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f228756a = new w();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Long> sLogs = new ConcurrentHashMap<>(new HashMap(8));

    w() {
    }

    @JvmStatic
    public static final void a(@NotNull String tag, @NotNull String methodName) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }

    @JvmStatic
    public static final void b(@NotNull String tag, @NotNull String methodName) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }

    @JvmStatic
    public static final void c(@NotNull String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }

    @JvmStatic
    public static final void d() {
    }
}
