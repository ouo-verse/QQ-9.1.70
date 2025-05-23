package com.tencent.ecommerce.biz.shophome.ui.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "categoryText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView categoryText;

    public h(View view) {
        super(view);
        this.categoryText = (TextView) view.findViewById(R.id.f163005nt0);
    }

    /* renamed from: l, reason: from getter */
    public final TextView getCategoryText() {
        return this.categoryText;
    }
}
