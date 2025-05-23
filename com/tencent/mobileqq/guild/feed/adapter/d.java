package com.tencent.mobileqq.guild.feed.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeedSummary;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\u0010\n\u001a\u00060\tR\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewCacheExtension;", "", "j", "Landroid/view/View;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "i", "g", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "recycler", "", "globalPosition", "globalViewType", "getViewForPositionAndType", "e", "Landroid/view/View;", "hostContentView", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "mCacheHolders", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lij1/g;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "feedBlockDataList", "Lij1/h;", "feedTopBlockDataList", "Lcom/tencent/mobileqq/guild/feed/viewmodel/a;", "Lcom/tencent/mobileqq/guild/feed/viewmodel/a;", "mCacheViewModel", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "topCacheViewHolder", "k", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "l", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends RecyclerView.ViewCacheExtension {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static int f217935m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static int f217936n = 3;

    /* renamed from: o, reason: collision with root package name */
    private static int f217937o = 11;

    /* renamed from: p, reason: collision with root package name */
    private static int f217938p = 6;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View hostContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Object, RecyclerView.ViewHolder> mCacheHolders;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<ij1.g> feedBlockDataList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<ij1.h> feedTopBlockDataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.viewmodel.a mCacheViewModel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.ViewHolder topCacheViewHolder;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/d$a;", "", "", "asyncPositionOffset", "I", "getAsyncPositionOffset", "()I", "c", "(I)V", "normalViewTypeOffset", "b", "e", "asyncViewTypeOffset", "a", "d", "CACHE_ITEM_TYPE_OFFSET", "", "TAG", "Ljava/lang/String;", "VIEW_CACHE_MAX_SIZE", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.adapter.d$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d.f217938p;
        }

        public final int b() {
            return d.f217937o;
        }

        public final void c(int i3) {
            d.f217936n = i3;
        }

        public final void d(int i3) {
            d.f217938p = i3;
        }

        public final void e(int i3) {
            d.f217937o = i3;
        }

        Companion() {
        }
    }

    private final void j() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedListFirstLoadingEvent(true));
    }

    public final void g() {
        this.mCacheHolders.clear();
        this.feedBlockDataList.clear();
        this.feedTopBlockDataList.clear();
        this.mCacheViewModel.s2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewCacheExtension
    @Nullable
    public View getViewForPositionAndType(@NotNull RecyclerView.Recycler recycler, int globalPosition, int globalViewType) {
        Object orNull;
        int i3;
        RecyclerView.ViewHolder viewHolder;
        Integer num;
        View view;
        boolean z16;
        GProStFeed b16;
        GProStFeedSummary gProStFeedSummary;
        boolean z17;
        View view2;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        boolean z18 = true;
        boolean z19 = false;
        if (f217935m == globalPosition) {
            RecyclerView.ViewHolder viewHolder2 = this.topCacheViewHolder;
            if (viewHolder2 != null && globalViewType == viewHolder2.getItemViewType()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                RecyclerView.ViewHolder viewHolder3 = this.topCacheViewHolder;
                if (viewHolder3 != null) {
                    view2 = viewHolder3.itemView;
                } else {
                    view2 = null;
                }
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                if (view2 != null) {
                    z19 = true;
                }
                String str = "globalPosition: " + globalPosition + ", type " + globalViewType + ", topItemView is [" + z19 + "]";
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedAsyncExtendCache", 1, (String) it.next(), null);
                }
                return view2;
            }
        }
        int i16 = globalPosition - f217936n;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.feedBlockDataList, i16);
        ij1.g gVar = (ij1.g) orNull;
        if (gVar != null && (b16 = gVar.b()) != null && (gProStFeedSummary = b16.summary) != null) {
            i3 = gProStFeedSummary.layoutType;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        if (gVar != null) {
            viewHolder = this.mCacheHolders.get(gVar);
        } else {
            viewHolder = null;
        }
        Logger.a d16 = Logger.f235387a.d();
        int i17 = f217936n;
        int i18 = f217938p;
        if (viewHolder != null) {
            num = Integer.valueOf(viewHolder.getItemViewType());
        } else {
            num = null;
        }
        if (viewHolder != null) {
            view = viewHolder.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("GuildFeedAsyncExtendCache", 1, "getViewForPositionAndType, globalPosition " + globalPosition + ", asyncPositionOffsetStart " + i17 + ", originDataType: " + i3 + ", globalViewType " + globalViewType + ",  asyncViewTypeOffsetStart: " + i18 + ", mCacheHolders viewType: " + num + ",  view exits : " + z16 + "!");
        if (viewHolder == null || viewHolder.getItemViewType() != globalViewType) {
            z18 = false;
        }
        if (z18) {
            if (i16 == 0) {
                j();
            }
            return viewHolder.itemView;
        }
        return null;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final View getHostContentView() {
        return this.hostContentView;
    }

    @NotNull
    public final RecyclerView i() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            return null;
        }
        return recyclerView;
    }
}
