package com.tencent.mobileqq.guild.base;

import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0007R!\u0010\b\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005R!\u0010\f\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005R!\u0010\u000e\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001b\u0010\u0010\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/base/GuildToggles;", "", "", "b", "Lkotlin/Lazy;", "()Z", "getDisableAioPreload$annotations", "()V", "disableAioPreload", "c", "d", "getDisableWebPreload$annotations", "disableWebPreload", "getDisableMiniPreload$annotations", "disableMiniPreload", "e", "preloadToggle", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildToggles {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildToggles f214685a = new GuildToggles();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy disableAioPreload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy disableWebPreload;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy disableMiniPreload;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy preloadToggle;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.base.GuildToggles$disableAioPreload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean e16;
                e16 = GuildToggles.f214685a.e();
                return Boolean.valueOf(e16);
            }
        });
        disableAioPreload = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.base.GuildToggles$disableWebPreload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean e16;
                e16 = GuildToggles.f214685a.e();
                return Boolean.valueOf(e16);
            }
        });
        disableWebPreload = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.base.GuildToggles$disableMiniPreload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean e16;
                e16 = GuildToggles.f214685a.e();
                return Boolean.valueOf(e16);
            }
        });
        disableMiniPreload = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.base.GuildToggles$preloadToggle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).isAioAndWebPreloadDisable());
            }
        });
        preloadToggle = lazy4;
    }

    GuildToggles() {
    }

    public static final boolean b() {
        return ((Boolean) disableAioPreload.getValue()).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) disableMiniPreload.getValue()).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) disableWebPreload.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        return ((Boolean) preloadToggle.getValue()).booleanValue();
    }
}
