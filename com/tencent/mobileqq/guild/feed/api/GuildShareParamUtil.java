package com.tencent.mobileqq.guild.feed.api;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/GuildShareParamUtil;", "", "", "appId", "", "c", "", "b", "", "Lkotlin/Lazy;", "a", "()Ljava/util/Map;", "supportThirdVideo", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildShareParamUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildShareParamUtil f217972a = new GuildShareParamUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy supportThirdVideo;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<Long, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.api.GuildShareParamUtil$supportThirdVideo$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Long, ? extends Integer> invoke() {
                Map<Long, ? extends Integer> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(100498506L, 8), TuplesKt.to(100951776L, 9));
                return mapOf;
            }
        });
        supportThirdVideo = lazy;
    }

    GuildShareParamUtil() {
    }

    private final Map<Long, Integer> a() {
        return (Map) supportThirdVideo.getValue();
    }

    @JvmStatic
    public static final int b(long appId) {
        Integer num = f217972a.a().get(Long.valueOf(appId));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @JvmStatic
    public static final boolean c(long appId) {
        return false;
    }
}
