package com.tencent.guild.aio.input.at.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R+\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/input/at/utils/RecentAtRobotCache;", "", "", "guildId", "", "a", "robotId", "", "d", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Lkotlin/Lazy;", "()Ljava/util/ArrayList;", "recentRobotList", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RecentAtRobotCache {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RecentAtRobotCache f111102a = new RecentAtRobotCache();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy recentRobotList;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ArrayList<String>>() { // from class: com.tencent.guild.aio.input.at.utils.RecentAtRobotCache$recentRobotList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<String> invoke() {
                return new ArrayList<>();
            }
        });
        recentRobotList = lazy;
    }

    RecentAtRobotCache() {
    }

    @JvmStatic
    @NotNull
    public static final List<String> a(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        RecentAtRobotCache recentAtRobotCache = f111102a;
        recentAtRobotCache.b().clear();
        recentAtRobotCache.b().addAll(so0.c.d(guildId));
        return recentAtRobotCache.b();
    }

    private final ArrayList<String> b() {
        return (ArrayList) recentRobotList.getValue();
    }

    @JvmStatic
    public static final void c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        RecentAtRobotCache recentAtRobotCache = f111102a;
        if (recentAtRobotCache.b().isEmpty()) {
            return;
        }
        so0.c.k(guildId, recentAtRobotCache.b());
        recentAtRobotCache.b().clear();
    }

    @JvmStatic
    public static final void d(@NotNull String robotId) {
        Intrinsics.checkNotNullParameter(robotId, "robotId");
        RecentAtRobotCache recentAtRobotCache = f111102a;
        int indexOf = recentAtRobotCache.b().indexOf(robotId);
        if (indexOf != -1) {
            recentAtRobotCache.b().remove(indexOf);
        }
        recentAtRobotCache.b().add(0, robotId);
    }
}
