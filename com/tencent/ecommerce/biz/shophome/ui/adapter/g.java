package com.tencent.ecommerce.biz.shophome.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import com.tencent.ecommerce.biz.shophome.ui.view.ECCategoryItemClickListener;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/g;", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/b;", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/h;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "l0", "<init>", "()V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends com.tencent.ecommerce.biz.shophome.ui.adapter.b<h> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f104283e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ECShopCategoryInfo f104284f;

        b(h hVar, ECShopCategoryInfo eCShopCategoryInfo) {
            this.f104283e = hVar;
            this.f104284f = eCShopCategoryInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCategoryItemClickListener categoryItemClickListener = g.this.getCategoryItemClickListener();
            if (categoryItemClickListener != null) {
                categoryItemClickListener.onItemClickListener(this.f104283e.getAdapterPosition(), this.f104284f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(h holder, int position) {
        ECShopCategoryInfo eCShopCategoryInfo = j0().get(position);
        holder.getCategoryText().setText(eCShopCategoryInfo.name);
        holder.itemView.setOnClickListener(new b(holder, eCShopCategoryInfo));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(ViewGroup parent, int viewType) {
        return new h(LayoutInflater.from(parent.getContext()).inflate(R.layout.cuc, parent, false));
    }
}
