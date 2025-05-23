package com.tencent.mobileqq.guild.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J'\u0010\u000e\u001a\u00020\u0005\"\f\b\u0000\u0010\r*\u00020\b*\u00020\f*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildSubscribePollingManager;", "", "", "guildId", "pageId", "", "c", "d", "Landroidx/lifecycle/LifecycleOwner;", "oldId", "newId", "b", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "T", "a", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "", "", "Ljava/util/Map;", "pageGuildIdMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSubscribePollingManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildSubscribePollingManager f235373a = new GuildSubscribePollingManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Set<String>> pageGuildIdMap = new LinkedHashMap();

    GuildSubscribePollingManager() {
    }

    public final <T extends LifecycleOwner & com.tencent.mobileqq.guild.homev2.misc.d> void a(@NotNull T t16, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        t16.getLifecycle().addObserver(new GuildSubscribePollingManager$installGuildPolling$1(t16, pageId));
    }

    public final void b(@NotNull LifecycleOwner lifecycleOwner, @NotNull String pageId, @NotNull String oldId, @NotNull String newId) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(oldId, "oldId");
        Intrinsics.checkNotNullParameter(newId, "newId");
        if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            d(oldId, pageId);
            c(newId, pageId);
        }
    }

    public final void c(@NotNull String guildId, @NotNull String pageId) {
        boolean z16;
        Set<String> mutableSetOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Map<String, Set<String>> map = pageGuildIdMap;
        Set<String> set = map.get(guildId);
        if (set != null && !set.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            mutableSetOf = SetsKt__SetsKt.mutableSetOf(pageId);
            map.put(guildId, mutableSetOf);
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            ((IGPSService) S0).subscribePolling(guildId);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.GuildSubscribePollingManager", 1, "subscribePolling gId:" + guildId + " page:" + pageId);
                return;
            }
            return;
        }
        set.add(pageId);
    }

    public final void d(@NotNull String guildId, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Map<String, Set<String>> map = pageGuildIdMap;
        Set<String> set = map.get(guildId);
        if (set != null && set.contains(pageId)) {
            set.remove(pageId);
            if (set.isEmpty()) {
                map.remove(guildId);
                com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
                IRuntimeService S0 = ch.S0(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
                ((IGPSService) S0).unsubscribePolling(guildId);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.GuildSubscribePollingManager", 1, "unsubscribePolling gId:" + guildId + " page:" + pageId);
                    return;
                }
                return;
            }
            return;
        }
        Logger.f235387a.d().w("Guild.GuildSubscribePollingManager", 1, "unsubscribePolling gId:" + guildId + " page:" + pageId + " current page not subscribe yet!");
    }
}
