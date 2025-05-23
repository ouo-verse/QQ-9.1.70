package com.tencent.mobileqq.guild.home.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.home.utils.GuildFeedsHomeSubChannelPollingManager;
import com.tencent.mobileqq.guild.homev2.misc.d;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import d12.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J&\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002J+\u0010\u0018\u001a\u00020\u0005\"\f\b\u0000\u0010\u0016*\u00020\u000f*\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR&\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001a0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/home/utils/GuildFeedsHomeSubChannelPollingManager;", "", "", "guildId", "pageId", "", "b", "j", "", "fromDestroy", "c", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "d", "i", h.F, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "instanceId", "oldId", "newId", "g", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "T", "receiver", "f", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "", "Ljava/util/Set;", "pageResumed", "guildObservingSet", "", "Ljava/util/Map;", "pageGuildIdMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedsHomeSubChannelPollingManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedsHomeSubChannelPollingManager f225330a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> pageResumed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> guildObservingSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Set<String>> pageGuildIdMap;

    static {
        GuildFeedsHomeSubChannelPollingManager guildFeedsHomeSubChannelPollingManager = new GuildFeedsHomeSubChannelPollingManager();
        f225330a = guildFeedsHomeSubChannelPollingManager;
        pageResumed = new LinkedHashSet();
        guildObservingSet = new LinkedHashSet();
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(guildFeedsHomeSubChannelPollingManager.d());
        pageGuildIdMap = new LinkedHashMap();
    }

    GuildFeedsHomeSubChannelPollingManager() {
    }

    private final void b(String guildId, String pageId) {
        boolean isBlank;
        Set<String> mutableSetOf;
        isBlank = StringsKt__StringsJVMKt.isBlank(guildId);
        if (!isBlank && !Intrinsics.areEqual(guildId, "0")) {
            Map<String, Set<String>> map = pageGuildIdMap;
            Set<String> set = map.get(guildId);
            if (set == null) {
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(pageId);
                map.put(guildId, mutableSetOf);
            } else {
                set.add(pageId);
            }
        }
    }

    private final void c(String guildId, boolean fromDestroy) {
        boolean isBlank;
        Set set;
        isBlank = StringsKt__StringsJVMKt.isBlank(guildId);
        if (!isBlank && !Intrinsics.areEqual(guildId, "0")) {
            set = CollectionsKt___CollectionsKt.toSet(pageResumed);
            Set<String> set2 = pageGuildIdMap.get(guildId);
            if (set2 == null) {
                set2 = SetsKt__SetsKt.emptySet();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : set2) {
                if (set.contains((String) obj)) {
                    arrayList.add(obj);
                }
            }
            boolean c16 = a.c();
            Logger.f235387a.d().d("Guild.NewHome.GuildFeedsHomeSubChannelPollingManager", 1, "checkGuildPollingStatus guildId:" + guildId + " activePages:" + arrayList + " feedsHome:" + c16);
            if (c16) {
                if (arrayList.isEmpty()) {
                    IRuntimeService S0 = ch.S0(IGPSService.class, "");
                    Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                    ((IGPSService) S0).fetchChannelInfoWithUnreadStatus(guildId, false);
                } else if (!fromDestroy) {
                    IRuntimeService S02 = ch.S0(IGPSService.class, "");
                    Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(java, process)");
                    ((IGPSService) S02).fetchChannelInfoWithUnreadStatus(guildId, true);
                }
            }
        }
    }

    private final INetworkStateApi.a d() {
        return new INetworkStateApi.a() { // from class: cp1.a
            @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
            public final void onNetworkConnect(boolean z16) {
                GuildFeedsHomeSubChannelPollingManager.e(z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z16) {
        List list;
        if (z16) {
            list = CollectionsKt___CollectionsKt.toList(guildObservingSet);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                f225330a.c((String) it.next(), false);
            }
        }
    }

    private final void j(String guildId, String pageId) {
        Set<String> set = pageGuildIdMap.get(guildId);
        if (set != null) {
            set.remove(pageId);
        }
    }

    public final <T extends LifecycleOwner & d> void f(@NotNull final T receiver, @NotNull final String instanceId) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        receiver.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.home.utils.GuildFeedsHomeSubChannelPollingManager$install$1

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes13.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f225336a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f225336a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                String guildId = ((d) LifecycleOwner.this).getGuildId();
                int i3 = a.f225336a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        GuildFeedsHomeSubChannelPollingManager.f225330a.h(guildId, instanceId);
                        source.getLifecycle().removeObserver(this);
                        return;
                    }
                    return;
                }
                GuildFeedsHomeSubChannelPollingManager.f225330a.i(guildId, instanceId);
            }
        });
    }

    public final void g(@NotNull LifecycleOwner lifecycleOwner, @NotNull String instanceId, @NotNull String oldId, @NotNull String newId) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(oldId, "oldId");
        Intrinsics.checkNotNullParameter(newId, "newId");
        if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            h(oldId, instanceId);
            i(newId, instanceId);
        }
    }

    public final void h(@NotNull String guildId, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildFeedsHomeSubChannelPollingManager", 1, "onPageDestroy gId:" + guildId + " page:" + pageId);
        }
        j(guildId, pageId);
        c(guildId, true);
    }

    public final void i(@NotNull String guildId, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildFeedsHomeSubChannelPollingManager", 1, "onPageResume gId:" + guildId + " page:" + pageId);
        }
        pageResumed.add(pageId);
        b(guildId, pageId);
        c(guildId, false);
    }
}
