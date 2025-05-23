package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000b\u001a\u00020\u0006R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/h;", "", "", "position", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "d", "Lcooperation/qqcircle/report/QCircleLpReportDc05507$DataBuilder;", "b", "a", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "map", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, FeedCloudMeta$StFeed> map = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/h$a;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/Pair;", "", "a", "DC_PAGE_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.h$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Pair<Integer, Integer> a(@Nullable RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager;
            StaggeredGridLayoutManager staggeredGridLayoutManager;
            Integer firstOrNull;
            Integer lastOrNull;
            if (recyclerView != null) {
                try {
                    layoutManager = recyclerView.getLayoutManager();
                } catch (Exception e16) {
                    QLog.e("RankVideoDCReporter", 1, "[computeExposure] ", e16);
                }
            } else {
                layoutManager = null;
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            } else {
                staggeredGridLayoutManager = null;
            }
            if (staggeredGridLayoutManager != null) {
                int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
                Intrinsics.checkNotNullExpressionValue(findFirstVisibleItemPositions, "lm.findFirstVisibleItemPositions(null)");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(findFirstVisibleItemPositions);
                int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
                Intrinsics.checkNotNullExpressionValue(findLastVisibleItemPositions, "lm.findLastVisibleItemPositions(null)");
                lastOrNull = ArraysKt___ArraysKt.lastOrNull(findLastVisibleItemPositions);
                if (firstOrNull != null && lastOrNull != null) {
                    return new Pair<>(firstOrNull, lastOrNull);
                }
            }
            return null;
        }

        Companion() {
        }
    }

    private final QCircleLpReportDc05507.DataBuilder b(int position, FeedCloudMeta$StFeed feed) {
        QCircleLpReportDc05507.DataBuilder position2 = new QCircleLpReportDc05507.DataBuilder().setActionType(1).setSubActionType(1).setFeedId(feed.f398449id.get()).setToUin(feed.poster.f398463id.get()).setAuthorUin(feed.poster.f398463id.get()).setPageId(129).setExt1("2").setPlayScene(0).setPosition(position);
        Intrinsics.checkNotNullExpressionValue(position2, "DataBuilder()\n          \u2026   .setPosition(position)");
        return position2;
    }

    private final void d(int position, FeedCloudMeta$StFeed feed) {
        if (QLog.isDebugVersion()) {
            QLog.d("RankVideoDCReporter", 1, "[report] position=" + position + ", poster=" + feed.poster.nick.get());
        }
        QCircleLpReportDc05507.report(b(position, feed));
    }

    public final void a(int position, @Nullable FeedCloudMeta$StFeed feed) {
        if (feed == null) {
            QLog.w("RankVideoDCReporter", 1, "[addRecord] invalid feed, position=" + position);
            return;
        }
        if (this.map.putIfAbsent(Integer.valueOf(position), feed) == null && QLog.isDebugVersion()) {
            QLog.d("RankVideoDCReporter", 1, "[addRecord] position=" + position + ", poster=" + feed.poster.nick.get());
        }
    }

    public final void c() {
        for (Map.Entry<Integer, FeedCloudMeta$StFeed> entry : this.map.entrySet()) {
            d(entry.getKey().intValue(), entry.getValue());
        }
        this.map.clear();
    }
}
