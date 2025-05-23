package com.tencent.mobileqq.zplan.aio.panel.panel;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B+\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d*\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/PanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/PanelAdapter$a;", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "getItemCount", "holder", "", "l0", "Lkotlinx/coroutines/CoroutineScope;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "dataSource", "", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/a;", "D", "Ljava/util/List;", "builders", "k0", "()Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "getValue$delegate", "(Lcom/tencent/mobileqq/zplan/aio/panel/panel/PanelAdapter;)Ljava/lang/Object;", "value", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/StateFlow;Ljava/util/List;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PanelAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final StateFlow<Panel> dataSource;

    /* renamed from: D, reason: from kotlin metadata */
    private final List<com.tencent.mobileqq.zplan.aio.panel.panel.a> builders;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/PanelAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "E", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "l", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vh", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RecyclerView.ViewHolder vh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecyclerView.ViewHolder vh5) {
            super(vh5.itemView);
            Intrinsics.checkNotNullParameter(vh5, "vh");
            this.vh = vh5;
        }

        /* renamed from: l, reason: from getter */
        public final RecyclerView.ViewHolder getVh() {
            return this.vh;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PanelAdapter(CoroutineScope scope, StateFlow<Panel> dataSource, List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> builders) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(builders, "builders");
        this.scope = scope;
        this.dataSource = dataSource;
        this.builders = builders;
    }

    private final Panel k0() {
        return this.dataSource.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return k0().b().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return k0().b().get(position).getPageType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        for (com.tencent.mobileqq.zplan.aio.panel.panel.a aVar : this.builders) {
            if (aVar.getPageType() == holder.getItemViewType()) {
                RecyclerView.ViewHolder vh5 = holder.getVh();
                Object g16 = CorountineFunKt.g(i.e.f261783e, "zplan_PanelAdapter_flow\u53d8\u6362", null, new PanelAdapter$onBindViewHolder$2(this, position, null), 4, null);
                Intrinsics.checkNotNull(g16);
                aVar.d(vh5, (StateFlow) g16);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        for (com.tencent.mobileqq.zplan.aio.panel.panel.a aVar : this.builders) {
            if (aVar.getPageType() == viewType) {
                return new a(aVar.c((RecyclerView) parent));
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
