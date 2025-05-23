package bh0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bl\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012S\u0010\u000e\u001aO\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\u0004\u0018\u0001`\r\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lbh0/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "", "viewType", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "view", "position", "itemViewType", "", "Lcom/tencent/ecommerce/base/ui/component/ECRecyclerViewItemClick;", "itemClickListener", "<init>", "(Landroid/view/View;ILkotlin/jvm/functions/Function3;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class c extends RecyclerView.ViewHolder {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes39.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function3 f28398e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f28399f;

        a(Function3 function3, int i3) {
            this.f28398e = function3;
            this.f28399f = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int adapterPosition = c.this.getAdapterPosition();
            if (adapterPosition >= 0) {
                Function3 function3 = this.f28398e;
                if (function3 != null) {
                }
            } else {
                cg0.a.a("ECBaseRecyclerViewHolder", "itemView.setOnClickListener", "itemView onClick position = " + adapterPosition);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(View view, int i3, Function3<? super View, ? super Integer, ? super Integer, Unit> function3) {
        super(view);
        view.setOnClickListener(new a(function3, i3));
    }
}
