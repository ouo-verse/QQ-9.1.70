package com.tencent.ecommerce.biz.detail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/b;", "Lbh0/b;", "", "position", "getItemViewType", "Lbh0/c;", "holder", "", "k0", "", "G", "Z", "isHost", "Landroid/content/Context;", "context", "Lbh0/d;", "viewModel", "<init>", "(Landroid/content/Context;Lbh0/d;Z)V", "H", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends bh0.b {

    /* renamed from: G, reason: from kotlin metadata */
    public final boolean isHost;

    public b(Context context, bh0.d dVar, boolean z16) {
        super(context, dVar);
        this.isHost = z16;
    }

    @Override // bh0.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ECBasePtsViewData i06 = i0(position);
        if (i06 != null) {
            String pageName = i06.getPageName();
            return ((Intrinsics.areEqual(pageName, "shop_home_product_card") ^ true) && (Intrinsics.areEqual(pageName, "apply_sample_recommend_card") ^ true) && (Intrinsics.areEqual(pageName, "product_detail_saas_card") ^ true) && (Intrinsics.areEqual(pageName, "product_detail_saas_card") ^ true)) ? 1 : 2;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsViewData");
    }

    @Override // bh0.b, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0 */
    public void onBindViewHolder(bh0.c holder, int position) {
        View view = holder.itemView;
        if (getItemViewType(position) != 1) {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(false);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            }
        } else {
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams2).setFullSpan(true);
                view.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            }
        }
        super.onBindViewHolder(holder, position);
    }
}
