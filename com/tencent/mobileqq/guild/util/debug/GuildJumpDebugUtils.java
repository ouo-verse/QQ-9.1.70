package com.tencent.mobileqq.guild.util.debug;

import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J3\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/util/debug/GuildJumpDebugUtils;", "", "T", "", "tag", "prefix", "obj", "", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "", "b", "Lkotlin/Lazy;", "getEnableLog", "()Z", "enableLog", "", "Ljava/lang/Class;", "c", "[Ljava/lang/Class;", "primitiveTypes", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJumpDebugUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildJumpDebugUtils f235553a = new GuildJumpDebugUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableLog = LazyKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils$enableLog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).getJumpDebugLogEnable());
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Class<?>[] primitiveTypes = {Map.class, List.class, Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, String.class, Boolean.class, Byte.class, Character.class, Short.class, Integer.class, Long.class, Float.class, Double.class, String.class};

    GuildJumpDebugUtils() {
    }

    @JvmStatic
    public static final <T> void a(@NotNull String tag, @NotNull String prefix, @Nullable T obj) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
    }
}
