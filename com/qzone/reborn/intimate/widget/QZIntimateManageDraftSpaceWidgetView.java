package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b\u001f\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateManageDraftSpaceWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "", "getLayoutId", "dataList", com.tencent.luggage.wxa.c8.c.G, "", "n0", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "rvDraftRecyclerView", "Lhj/c;", tl.h.F, "Lkotlin/Lazy;", "p0", "()Lhj/c;", "draftSpaceListAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "i", "o0", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateManageDraftSpaceWidgetView extends QZoneBaseWidgetView<List<? extends QZIntimateProfileReader$IntimateSpaceAbs>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView rvDraftRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy draftSpaceListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy concatAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateManageDraftSpaceWidgetView(Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.nir);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_draft_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nf6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rv_draft_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.rvDraftRecyclerView = recyclerView;
        lazy = LazyKt__LazyJVMKt.lazy(QZIntimateManageDraftSpaceWidgetView$draftSpaceListAdapter$2.INSTANCE);
        this.draftSpaceListAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RFWConcatAdapter>() { // from class: com.qzone.reborn.intimate.widget.QZIntimateManageDraftSpaceWidgetView$concatAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RFWConcatAdapter invoke() {
                hj.c p06;
                RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
                p06 = QZIntimateManageDraftSpaceWidgetView.this.p0();
                return new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{p06});
            }
        });
        this.concatAdapter = lazy2;
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        mk.g.f416876a.a(recyclerView, Color.parseColor("#AFAFAF"), ImmersiveUtils.dpToPx(4.0f), false);
        recyclerView.setAdapter(o0());
        y yVar = new y(getContext(), 0, ImmersiveUtils.dpToPx(0.5f), Color.parseColor("#1A000000"));
        yVar.d(ImmersiveUtils.dpToPx(68.0f), ImmersiveUtils.dpToPx(16.0f));
        yVar.f(false);
        recyclerView.addItemDecoration(yVar);
    }

    private final RFWConcatAdapter o0() {
        return (RFWConcatAdapter) this.concatAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final hj.c p0() {
        return (hj.c) this.draftSpaceListAdapter.getValue();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cjx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<QZIntimateProfileReader$IntimateSpaceAbs> dataList, int pos) {
        if (bl.b(dataList)) {
            this.tvTitle.setVisibility(8);
            this.rvDraftRecyclerView.setVisibility(8);
            setVisibility(8);
        } else {
            this.tvTitle.setVisibility(0);
            this.rvDraftRecyclerView.setVisibility(0);
            setVisibility(0);
            p0().setItems(dataList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateManageDraftSpaceWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.nir);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_draft_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nf6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rv_draft_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.rvDraftRecyclerView = recyclerView;
        lazy = LazyKt__LazyJVMKt.lazy(QZIntimateManageDraftSpaceWidgetView$draftSpaceListAdapter$2.INSTANCE);
        this.draftSpaceListAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RFWConcatAdapter>() { // from class: com.qzone.reborn.intimate.widget.QZIntimateManageDraftSpaceWidgetView$concatAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RFWConcatAdapter invoke() {
                hj.c p06;
                RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
                p06 = QZIntimateManageDraftSpaceWidgetView.this.p0();
                return new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{p06});
            }
        });
        this.concatAdapter = lazy2;
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        mk.g.f416876a.a(recyclerView, Color.parseColor("#AFAFAF"), ImmersiveUtils.dpToPx(4.0f), false);
        recyclerView.setAdapter(o0());
        y yVar = new y(getContext(), 0, ImmersiveUtils.dpToPx(0.5f), Color.parseColor("#1A000000"));
        yVar.d(ImmersiveUtils.dpToPx(68.0f), ImmersiveUtils.dpToPx(16.0f));
        yVar.f(false);
        recyclerView.addItemDecoration(yVar);
    }
}
