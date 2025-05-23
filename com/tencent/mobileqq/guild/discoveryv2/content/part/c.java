package com.tencent.mobileqq.guild.discoveryv2.content.part;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\t*\u0001\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/part/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "com/tencent/mobileqq/guild/discoveryv2/content/part/c$b", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/c$b;", "scroller", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends MVPFeedsPart {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b scroller = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/part/c$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "scrollDy", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int scrollDy;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            StaggeredGridLayoutManager staggeredGridLayoutManager;
            Integer minOrNull;
            Map mapOf;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            int i3 = 0;
            if (newState == 0) {
                if (this.scrollDy > 0) {
                    this.scrollDy = 0;
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_pgid", ci1.a.c()), TuplesKt.to("eid", "em_sgrp_discover_mine_slideup"));
                    VideoReport.reportEvent("clck", mapOf);
                }
                VideoReport.traverseExposure();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            } else {
                staggeredGridLayoutManager = null;
            }
            if (staggeredGridLayoutManager == null) {
                return;
            }
            int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            Intrinsics.checkNotNullExpressionValue(findFirstVisibleItemPositions, "findFirstVisibleItemPositions");
            minOrNull = ArraysKt___ArraysKt.minOrNull(findFirstVisibleItemPositions);
            if (minOrNull != null) {
                i3 = minOrNull.intValue();
            }
            if (i3 <= c.this.x9().d()) {
                staggeredGridLayoutManager.invalidateSpanAssignments();
                QLog.i("ContentScrollPart", 1, "onScrollStateChanged: invalidateSpanAssignments");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.scrollDy += dy5;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        ((RecyclerView) rootView.findViewById(R.id.uiw)).addOnScrollListener(this.scroller);
    }
}
