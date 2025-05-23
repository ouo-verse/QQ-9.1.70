package com.tencent.mobileqq.guild.mainframe.create.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.guild.mainframe.create.widget.GuildCreateMemberRecyclerView;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ur1.GuildCreateMemberData;
import ur1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/widget/GuildCreateMemberRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "G", "width", "maxItemCount", "", "K", "", "from", "L", "recyclerViewWidth", UserInfo.SEX_FEMALE, "", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "Lur1/d;", "callback", IECSearchBar.METHOD_SET_CALLBACK, "", "Lur1/e;", "data", "I", "Lur1/h;", "f", "Lur1/h;", "memberItemDecoration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCreateMemberRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ur1.h memberItemDecoration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/widget/GuildCreateMemberRecyclerView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(GuildCreateMemberRecyclerView.this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCreateMemberRecyclerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final GuildCreateMemberRecyclerView this$0, Context context, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        GridLayoutManager gridLayoutManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        RecyclerView.LayoutManager layoutManager = this$0.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        } else {
            gridLayoutManager = null;
        }
        if (gridLayoutManager != null) {
            int i29 = i17 - i3;
            if (GuildSplitViewUtils.f235370a.n(context)) {
                i29 = RangesKt___RangesKt.coerceAtMost(i29, this$0.G());
            }
            int i36 = i27 - i19;
            QLog.i("GuildCreateRecyclerView", 1, "layoutChanged\uff0cnewWidth:" + i29 + ", oldWidth:" + i36);
            if (i29 != i36) {
                int F = this$0.F(i29);
                QLog.i("GuildCreateRecyclerView", 1, "layoutChanged\uff0cnewMaxMemberCnt:" + F + ", spanCount:" + gridLayoutManager.getSpanCount());
                if (F != gridLayoutManager.getSpanCount()) {
                    gridLayoutManager.setSpanCount(F);
                    this$0.K(i29, F);
                    this$0.post(new Runnable() { // from class: ur1.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildCreateMemberRecyclerView.H(GuildCreateMemberRecyclerView.this);
                        }
                    });
                }
            }
        }
    }

    private final int F(int recyclerViewWidth) {
        return (int) (recyclerViewWidth / x.a(76.0f));
    }

    private final int G() {
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        if (guildSplitViewUtils.n(getContext())) {
            return GuildSplitViewUtils.j(guildSplitViewUtils, true, null, 2, null);
        }
        return bi.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(GuildCreateMemberRecyclerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = this$0.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private final void K(int width, int maxItemCount) {
        RecyclerView.ItemDecoration itemDecoration = this.memberItemDecoration;
        if (itemDecoration != null) {
            removeItemDecoration(itemDecoration);
        }
        ur1.h hVar = new ur1.h(width, maxItemCount);
        addItemDecoration(hVar);
        this.memberItemDecoration = hVar;
    }

    private final void L(String from) {
        int G = G() - x.a(68.0f);
        int F = F(G);
        K(G, F);
        QLog.i("GuildCreateRecyclerView", 1, "updateNecessary from:" + from + ", maxMemberCnt:" + F + ", recyclerViewWidth:" + G);
        setLayoutManager(new GridLayoutManager(getContext(), F));
    }

    public final void I(@NotNull List<GuildCreateMemberData> data) {
        ur1.a aVar;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(data);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof ur1.a) {
            aVar = (ur1.a) adapter;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.submitList(arrayList);
        }
        VideoReport.traversePage(this);
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        return 0.0f;
    }

    public final void setCallback(@NotNull d callback) {
        ur1.a aVar;
        Intrinsics.checkNotNullParameter(callback, "callback");
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof ur1.a) {
            aVar = (ur1.a) adapter;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.k0(callback);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCreateMemberRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildCreateMemberRecyclerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCreateMemberRecyclerView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        L("init");
        setAdapter(new ur1.a());
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ur1.f
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
                GuildCreateMemberRecyclerView.E(GuildCreateMemberRecyclerView.this, context, view, i16, i17, i18, i19, i26, i27, i28, i29);
            }
        });
        setClipToOutline(true);
        addOnScrollListener(new a());
    }
}
