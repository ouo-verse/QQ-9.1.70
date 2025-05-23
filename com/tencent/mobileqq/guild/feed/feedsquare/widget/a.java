package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\u0004R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001aj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "scrap", "", "putRecycledView", "", "viewType", "getRecycledView", "a", QCircleLpReportDc05507.KEY_CLEAR, "b", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", tl.h.F, "Ljava/util/Map;", "feedListViewTypeMaxCount", "i", "topFeedViewTypeMaxCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "feedMultiImageMaxCount", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "viewTypeCountMap", "<init>", "(Landroid/content/Context;)V", "D", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends RecyclerView.RecycledViewPool {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> viewTypeCountMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> feedListViewTypeMaxCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> topFeedViewTypeMaxCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> feedMultiImageMaxCount;

    public a(@NotNull Context context) {
        Map<Integer, Integer> mapOf;
        Map<Integer, Integer> mapOf2;
        Map<Integer, Integer> mapOf3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2, 8), TuplesKt.to(3, 1), TuplesKt.to(4, 5), TuplesKt.to(5, 5), TuplesKt.to(6, 1));
        this.feedListViewTypeMaxCount = mapOf;
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, 1));
        this.topFeedViewTypeMaxCount = mapOf2;
        mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1001, 9));
        this.feedMultiImageMaxCount = mapOf3;
        this.viewTypeCountMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : mapOf.entrySet()) {
            setMaxRecycledViews(entry.getKey().intValue(), entry.getValue().intValue());
        }
        for (Map.Entry<Integer, Integer> entry2 : this.topFeedViewTypeMaxCount.entrySet()) {
            setMaxRecycledViews(entry2.getKey().intValue(), entry2.getValue().intValue());
        }
        for (Map.Entry<Integer, Integer> entry3 : this.feedMultiImageMaxCount.entrySet()) {
            setMaxRecycledViews(entry3.getKey().intValue(), entry3.getValue().intValue());
        }
    }

    public final void a() {
        for (Map.Entry<Integer, Integer> entry : this.viewTypeCountMap.entrySet()) {
            QLog.d("FeedSquareRecycledViewPool", 4, "ViewType: " + entry.getKey().intValue() + ", Count: " + entry.getValue().intValue());
        }
    }

    public final void b() {
        super.clear();
        this.viewTypeCountMap.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool, com.tencent.cache.api.b, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (QLog.isDevelopLevel()) {
            QLog.d("FeedSquareRecycledViewPool", 4, "clear has been called");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    @Nullable
    public RecyclerView.ViewHolder getRecycledView(int viewType) {
        RecyclerView.ViewHolder recycledView = super.getRecycledView(viewType);
        if (recycledView != null) {
            HashMap<Integer, Integer> hashMap = this.viewTypeCountMap;
            Integer valueOf = Integer.valueOf(viewType);
            Integer num = this.viewTypeCountMap.get(Integer.valueOf(viewType));
            if (num == null) {
                num = 0;
            }
            hashMap.put(valueOf, Integer.valueOf(num.intValue() - 1));
        }
        return recycledView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(@NotNull RecyclerView.ViewHolder scrap) {
        Intrinsics.checkNotNullParameter(scrap, "scrap");
        super.putRecycledView(scrap);
        int itemViewType = scrap.getItemViewType();
        HashMap<Integer, Integer> hashMap = this.viewTypeCountMap;
        Integer valueOf = Integer.valueOf(itemViewType);
        Integer num = this.viewTypeCountMap.get(Integer.valueOf(itemViewType));
        if (num == null) {
            num = 0;
        }
        hashMap.put(valueOf, Integer.valueOf(num.intValue() + 1));
    }
}
