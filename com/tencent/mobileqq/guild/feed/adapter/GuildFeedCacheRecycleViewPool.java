package com.tencent.mobileqq.guild.feed.adapter;

import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter;
import com.tencent.mobileqq.guild.feed.block.GuildFeedListSortBlock;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedBaseItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedTopView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\t\b\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0006\u0010\u000e\u001a\u00020\u0002R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildFeedCacheRecycleViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "", "f", "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getRecycledView", "max", "setMaxRecycledViews", "getRecycledViewCount", "scrap", "putRecycledView", QCircleLpReportDc05507.KEY_CLEAR, "e", "", "Ljava/util/List;", "getFeedItemTypeIndex", "()Ljava/util/List;", "setFeedItemTypeIndex", "(Ljava/util/List;)V", "feedItemTypeIndex", "Lui1/f;", tl.h.F, "Lui1/f;", "hostLifeCallback", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedCacheRecycleViewPool extends RecyclerView.RecycledViewPool {

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private static GuildFeedCacheRecycleViewPool f217924m;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> feedItemTypeIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ui1.f hostLifeCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final HashSet<Integer> C = new HashSet<>();

    @NotNull
    private static final Object D = new Object();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildFeedCacheRecycleViewPool$a;", "", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildFeedCacheRecycleViewPool;", "a", "", "MAX_CACHE_POOL_SIZE", "I", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "cacheKey", "Ljava/util/HashSet;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/lang/Object;", "sInstance", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildFeedCacheRecycleViewPool;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.adapter.GuildFeedCacheRecycleViewPool$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildFeedCacheRecycleViewPool a() {
            if (GuildFeedCacheRecycleViewPool.f217924m == null) {
                synchronized (GuildFeedCacheRecycleViewPool.D) {
                    if (GuildFeedCacheRecycleViewPool.f217924m == null) {
                        GuildFeedCacheRecycleViewPool.f217924m = new GuildFeedCacheRecycleViewPool();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            GuildFeedCacheRecycleViewPool guildFeedCacheRecycleViewPool = GuildFeedCacheRecycleViewPool.f217924m;
            Intrinsics.checkNotNull(guildFeedCacheRecycleViewPool);
            return guildFeedCacheRecycleViewPool;
        }

        Companion() {
        }
    }

    public GuildFeedCacheRecycleViewPool() {
        List<Integer> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0, 1, 2, 3, 4);
        this.feedItemTypeIndex = mutableListOf;
        ui1.f fVar = new ui1.f();
        this.hostLifeCallback = fVar;
        f();
        fVar.b();
        fVar.d(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildFeedCacheRecycleViewPool.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QLog.i("GuildFeedCacheRecycleViewPool", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
                GuildFeedCacheRecycleViewPool.this.hostLifeCallback.c();
                GuildFeedCacheRecycleViewPool.f217924m = null;
            }
        });
    }

    private final void f() {
        int a16 = d.INSTANCE.a() + 1000;
        Iterator<T> it = this.feedItemTypeIndex.iterator();
        while (it.hasNext()) {
            setMaxRecycledViews(((Number) it.next()).intValue() + a16, 10);
        }
        int b16 = d.INSTANCE.b();
        Iterator<T> it5 = this.feedItemTypeIndex.iterator();
        while (it5.hasNext()) {
            setMaxRecycledViews(((Number) it5.next()).intValue() + b16, 10);
        }
        setMaxRecycledViews(6000, 10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool, com.tencent.cache.api.b, java.util.AbstractMap, java.util.Map
    public void clear() {
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("clear()");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildFeedCacheRecycleViewPool", 1, (String) it.next(), null);
        }
        Iterator<T> it5 = C.iterator();
        while (it5.hasNext()) {
            int intValue = ((Number) it5.next()).intValue();
            setMaxRecycledViews(intValue, Math.max(getRecycledViewCount(intValue), 3));
        }
        f();
    }

    public final void e() {
        Logger.f235387a.d().i("GuildFeedCacheRecycleViewPool", 1, "clearAllCache()");
        super.clear();
        f217924m = null;
        this.hostLifeCallback.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    @Nullable
    public RecyclerView.ViewHolder getRecycledView(int viewType) {
        RecyclerView.ViewHolder viewHolder;
        try {
            viewHolder = super.getRecycledView(viewType);
            if (viewHolder == null) {
                try {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildFeedCacheRecycleViewPool", 2, "[getRecycledView] viewType " + viewType + ", holder is null");
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "getRecycledView " + viewType + " error!!!";
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildFeedCacheRecycleViewPool", 1, (String) it.next(), th);
                    }
                    return viewHolder;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            viewHolder = null;
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public int getRecycledViewCount(int viewType) {
        try {
            return super.getRecycledViewCount(viewType);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getRecycledViewCount " + viewType + " error!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedCacheRecycleViewPool", 1, (String) it.next(), th5);
            }
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(@Nullable RecyclerView.ViewHolder scrap) {
        View view;
        GuildFeedBaseItemView guildFeedBaseItemView;
        GuildSimpleFeedItemImageAdapter.GuildSimpleFeedItemImageViewHolder guildSimpleFeedItemImageViewHolder;
        View view2;
        GuildFeedListSortBlock.GuildFeedListInnerSortWidget guildFeedListInnerSortWidget;
        KeyEvent.Callback callback;
        GuildFeedTopView guildFeedTopView = null;
        if (scrap != null) {
            try {
                view = scrap.itemView;
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "putRecycledView " + scrap + " error!!!";
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedCacheRecycleViewPool", 1, (String) it.next(), th5);
                }
                return;
            }
        } else {
            view = null;
        }
        if (view instanceof GuildFeedBaseItemView) {
            guildFeedBaseItemView = (GuildFeedBaseItemView) view;
        } else {
            guildFeedBaseItemView = null;
        }
        if (guildFeedBaseItemView != null) {
            guildFeedBaseItemView.A0();
        }
        if (scrap instanceof GuildSimpleFeedItemImageAdapter.GuildSimpleFeedItemImageViewHolder) {
            guildSimpleFeedItemImageViewHolder = (GuildSimpleFeedItemImageAdapter.GuildSimpleFeedItemImageViewHolder) scrap;
        } else {
            guildSimpleFeedItemImageViewHolder = null;
        }
        if (guildSimpleFeedItemImageViewHolder != null) {
            guildSimpleFeedItemImageViewHolder.q();
        }
        if (scrap != null) {
            view2 = scrap.itemView;
        } else {
            view2 = null;
        }
        if (view2 instanceof GuildFeedListSortBlock.GuildFeedListInnerSortWidget) {
            guildFeedListInnerSortWidget = (GuildFeedListSortBlock.GuildFeedListInnerSortWidget) view2;
        } else {
            guildFeedListInnerSortWidget = null;
        }
        if (guildFeedListInnerSortWidget != null) {
            guildFeedListInnerSortWidget.release();
        }
        if (scrap != null) {
            callback = scrap.itemView;
        } else {
            callback = null;
        }
        if (callback instanceof GuildFeedTopView) {
            guildFeedTopView = (GuildFeedTopView) callback;
        }
        if (guildFeedTopView != null) {
            guildFeedTopView.release();
        }
        super.putRecycledView(scrap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void setMaxRecycledViews(int viewType, int max) {
        try {
            C.add(Integer.valueOf(viewType));
            super.setMaxRecycledViews(viewType, max);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "setMaxRecycledViews " + viewType + " error!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedCacheRecycleViewPool", 1, (String) it.next(), th5);
            }
        }
    }
}
