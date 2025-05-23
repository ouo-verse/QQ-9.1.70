package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0019\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/j;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/a;", "bannerInfos", "", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/i;", "E", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/i;", "adapter", "", UserInfo.SEX_FEMALE, "I", "dp8", "G", "dp16", "Landroid/view/View;", "itemView", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "listener", "<init>", "(Landroid/view/View;Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;)V", "H", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j extends RecyclerView.ViewHolder {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final i adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private final int dp8;

    /* renamed from: G, reason: from kotlin metadata */
    private final int dp16;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/publishguide/j$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.left = childAdapterPosition == 0 ? j.this.dp16 : j.this.dp8;
            RecyclerView.Adapter adapter = parent.getAdapter();
            int i16 = 0;
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (childAdapterPosition == i3 - 1) {
                i16 = j.this.dp16;
            }
            outRect.right = i16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/publishguide/j$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/j$c;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "listener", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/j;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.publishguide.j$c, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final j a(@NotNull ViewGroup parent, @NotNull f listener) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168742gp2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026iewholder, parent, false)");
            return new j(inflate, listener, null);
        }

        Companion() {
        }
    }

    public /* synthetic */ j(View view, f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, fVar);
    }

    public final void n(@NotNull List<BannerInfo> bannerInfos) {
        Intrinsics.checkNotNullParameter(bannerInfos, "bannerInfos");
        this.adapter.updateData(bannerInfos);
    }

    j(View view, f fVar) {
        super(view);
        this.dp8 = e83.a.b(8);
        this.dp16 = e83.a.b(16);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.t48);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.itemView.getContext(), 0, false));
        recyclerView.addItemDecoration(new a());
        i iVar = new i(fVar);
        this.adapter = iVar;
        recyclerView.setAdapter(iVar);
        recyclerView.setItemViewCacheSize(3);
        recyclerView.addOnScrollListener(new b());
    }
}
