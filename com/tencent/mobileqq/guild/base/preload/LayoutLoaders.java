package com.tencent.mobileqq.guild.base.preload;

import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.layoutinflater.RFWInflateType;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.EnumSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Deprecated(message = "use argus-preload instead")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002\u00a2\u0006\u0004\b1\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R!\u0010\u001c\u001a\u00020\u00158FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001f\u001a\u00020\u00158FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R!\u0010$\u001a\u00020 8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u0017\u0012\u0004\b#\u0010\u001b\u001a\u0004\b!\u0010\"R!\u0010&\u001a\u00020\u00158FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u0012\u0004\b%\u0010\u001b\u001a\u0004\b\u0012\u0010\u0019R!\u0010*\u001a\u00020 8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b'\u0010\u0017\u0012\u0004\b)\u0010\u001b\u001a\u0004\b(\u0010\"R!\u0010,\u001a\u00020\u00158FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0017\u0012\u0004\b+\u0010\u001b\u001a\u0004\b'\u0010\u0019R\u001b\u0010-\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0016\u0010\u0019R\u001b\u00100\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\"\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/base/preload/LayoutLoaders;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "b", "j", "i", "", "Z", "getPRELOAD_SWITCH", "()Z", "setPRELOAD_SWITCH", "(Z)V", "PRELOAD_SWITCH", "", "Lcom/tencent/mobileqq/guild/base/preload/LayoutLoaders$PreloadFlag;", "c", "Ljava/util/Set;", "preloadFlags", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "d", "Lkotlin/Lazy;", "g", "()Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getLeftBarLoader$annotations", "()V", "leftBarLoader", "e", "getFeedLoader$annotations", "feedLoader", "Landroid/widget/FrameLayout$LayoutParams;", "f", "()Landroid/widget/FrameLayout$LayoutParams;", "getLeftBarItemLayoutParams$annotations", "leftBarItemLayoutParams", "getChannelViewLoader$annotations", "channelViewLoader", h.F, "getChannelViewItemLayoutParams", "getChannelViewItemLayoutParams$annotations", "channelViewItemLayoutParams", "getMineGroupCardLoader$annotations", "mineGroupCardLoader", "discoveryThemeCollectionLoader", "k", "getDiscoveryThemeCollectionLayoutParams", "discoveryThemeCollectionLayoutParams", "<init>", "PreloadFlag", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LayoutLoaders {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LayoutLoaders f214751a = new LayoutLoaders();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean PRELOAD_SWITCH = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<PreloadFlag> preloadFlags;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy leftBarLoader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy feedLoader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy leftBarItemLayoutParams;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelViewLoader;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelViewItemLayoutParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mineGroupCardLoader;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy discoveryThemeCollectionLoader;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy discoveryThemeCollectionLayoutParams;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/base/preload/LayoutLoaders$PreloadFlag;", "", "(Ljava/lang/String;I)V", "MINE_GROUP_CARD", "LEFT_BAR", "CHANNEL_VIEW", "DISCOVERY_THEME_COLLECTION", "DISCOVERY_HOT_FEED_ITEM", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum PreloadFlag {
        MINE_GROUP_CARD,
        LEFT_BAR,
        CHANNEL_VIEW,
        DISCOVERY_THEME_COLLECTION,
        DISCOVERY_HOT_FEED_ITEM
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        EnumSet noneOf = EnumSet.noneOf(PreloadFlag.class);
        Intrinsics.checkNotNullExpressionValue(noneOf, "noneOf(PreloadFlag::class.java)");
        preloadFlags = noneOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RFWLayoutPreLoader>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$leftBarLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWLayoutPreLoader invoke() {
                return RFWLayoutPreLoaderFactory.getLayoutLoader(new a("MF-LeftBar", RFWInflateType.ASYNC_LAYOUT_INFLATER_SUB_THREAD_FIRST));
            }
        });
        leftBarLoader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RFWLayoutPreLoader>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$feedLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWLayoutPreLoader invoke() {
                Object layoutPreloadInflateStrategy = ((IGuildFeedConfigAPi) QRoute.api(IGuildFeedConfigAPi.class)).getLayoutPreloadInflateStrategy();
                Intrinsics.checkNotNull(layoutPreloadInflateStrategy, "null cannot be cast to non-null type com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy");
                return RFWLayoutPreLoaderFactory.getLayoutLoader((RFWLayoutLoaderStrategy) layoutPreloadInflateStrategy);
            }
        });
        feedLoader = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout.LayoutParams>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$leftBarItemLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout.LayoutParams invoke() {
                return new FrameLayout.LayoutParams(QQGuildUIUtil.f(72.0f), QQGuildUIUtil.f(61.0f));
            }
        });
        leftBarItemLayoutParams = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RFWLayoutPreLoader>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$channelViewLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWLayoutPreLoader invoke() {
                return RFWLayoutPreLoaderFactory.getLayoutLoader(new a("MF-ChannelView", RFWInflateType.ASYNC_LAYOUT_INFLATER_SUB_THREAD_FIRST));
            }
        });
        channelViewLoader = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout.LayoutParams>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$channelViewItemLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout.LayoutParams invoke() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(QQGuildUIUtil.f(10.0f), QQGuildUIUtil.f(4.0f), QQGuildUIUtil.f(10.0f), QQGuildUIUtil.f(4.0f));
                return layoutParams;
            }
        });
        channelViewItemLayoutParams = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<RFWLayoutPreLoader>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$mineGroupCardLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWLayoutPreLoader invoke() {
                return RFWLayoutPreLoaderFactory.getLayoutLoader(new a("DISCOVER-groupcards", RFWInflateType.ASYNC_LAYOUT_INFLATER_SUB_THREAD_FIRST));
            }
        });
        mineGroupCardLoader = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<RFWLayoutPreLoader>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$discoveryThemeCollectionLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWLayoutPreLoader invoke() {
                return RFWLayoutPreLoaderFactory.getLayoutLoader(new a("DISCOVER-themeCollection", RFWInflateType.ASYNC_LAYOUT_INFLATER_UI_FIRST));
            }
        });
        discoveryThemeCollectionLoader = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout.LayoutParams>() { // from class: com.tencent.mobileqq.guild.base.preload.LayoutLoaders$discoveryThemeCollectionLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout.LayoutParams invoke() {
                return new FrameLayout.LayoutParams(-1, QQGuildUIUtil.f(66.0f));
            }
        });
        discoveryThemeCollectionLayoutParams = lazy8;
    }

    LayoutLoaders() {
    }

    @NotNull
    public static final RFWLayoutPreLoader c() {
        return (RFWLayoutPreLoader) channelViewLoader.getValue();
    }

    @NotNull
    public static final RFWLayoutPreLoader e() {
        return (RFWLayoutPreLoader) feedLoader.getValue();
    }

    @NotNull
    public static final FrameLayout.LayoutParams f() {
        return (FrameLayout.LayoutParams) leftBarItemLayoutParams.getValue();
    }

    @NotNull
    public static final RFWLayoutPreLoader g() {
        return (RFWLayoutPreLoader) leftBarLoader.getValue();
    }

    @NotNull
    public static final RFWLayoutPreLoader h() {
        return (RFWLayoutPreLoader) mineGroupCardLoader.getValue();
    }

    public final void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        g().clearPagePreLoaders(activity);
        e().clearPagePreLoaders(activity);
        c().clearPagePreLoaders(activity);
        b(activity);
        preloadFlags.clear();
        Logger.f235387a.d().i("Guild.discovery.", 1, "clearPreLoadView");
    }

    public final void b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        h().clearPagePreLoaders(activity);
        d().clearPagePreLoaders(activity);
        Set<PreloadFlag> set = preloadFlags;
        set.remove(PreloadFlag.DISCOVERY_THEME_COLLECTION);
        set.remove(PreloadFlag.DISCOVERY_HOT_FEED_ITEM);
        set.remove(PreloadFlag.MINE_GROUP_CARD);
    }

    @NotNull
    public final RFWLayoutPreLoader d() {
        return (RFWLayoutPreLoader) discoveryThemeCollectionLoader.getValue();
    }

    public final void i(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!PRELOAD_SWITCH) {
            return;
        }
        Set<PreloadFlag> set = preloadFlags;
        PreloadFlag preloadFlag = PreloadFlag.CHANNEL_VIEW;
        if (set.contains(preloadFlag)) {
            return;
        }
        set.add(preloadFlag);
    }

    public final void j(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!PRELOAD_SWITCH) {
            return;
        }
        Set<PreloadFlag> set = preloadFlags;
        PreloadFlag preloadFlag = PreloadFlag.LEFT_BAR;
        if (set.contains(preloadFlag)) {
            return;
        }
        g().preloadView(activity, R.layout.exn, 12);
        set.add(preloadFlag);
    }
}
