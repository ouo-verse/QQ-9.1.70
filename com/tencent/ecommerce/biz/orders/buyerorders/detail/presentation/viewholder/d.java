package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECExtraJumpInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$f;", "data", "", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/d$b;", "E", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/d$b;", "jumpInfoAdapter", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e<f.ExtraJumpInfoData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final b jumpInfoAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u001c\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/d$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/a;", "data", "", "l", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "titleView", UserInfo.SEX_FEMALE, "descView", "Landroid/view/View;", "G", "Landroid/view/View;", "arrow", "H", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView titleView;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView descView;

        /* renamed from: G, reason: from kotlin metadata */
        private final View arrow;

        /* renamed from: H, reason: from kotlin metadata */
        public final View view;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class ViewOnClickListenerC1071a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ECExtraJumpInfo f103358d;

            ViewOnClickListenerC1071a(ECExtraJumpInfo eCExtraJumpInfo) {
                this.f103358d = eCExtraJumpInfo;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ECScheme.g(this.f103358d.getLinkUrl(), null, 2, null);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(View view) {
            super(view);
            this.view = view;
            this.titleView = (TextView) view.findViewById(R.id.ocd);
            this.descView = (TextView) view.findViewById(R.id.nv6);
            this.arrow = view.findViewById(R.id.f162993nq3);
        }

        public final void l(ECExtraJumpInfo data) {
            this.titleView.setText(data.title);
            this.descView.setText(data.desc);
            this.arrow.setVisibility(data.getLinkUrl().length() > 0 ? 0 : 8);
            this.view.setOnClickListener(new ViewOnClickListenerC1071a(data));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R6\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/d$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/d$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/a;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.Adapter<a> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private List<ECExtraJumpInfo> data;

        public b() {
            List<ECExtraJumpInfo> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.data = emptyList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.data.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            holder.l(this.data.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.csg, parent, false));
        }

        public final void setData(List<ECExtraJumpInfo> list) {
            this.data = list;
            notifyDataSetChanged();
        }
    }

    public d(View view) {
        super(view);
        b bVar = new b();
        this.jumpInfoAdapter = bVar;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o8n);
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.e
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void l(f.ExtraJumpInfoData data) {
        this.jumpInfoAdapter.setData(data.a());
    }
}
