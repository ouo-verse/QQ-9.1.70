package com.tencent.ecommerce.biz.shophome.ui.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "categoryText", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "l", "()Landroid/view/View;", "categoryBg", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView categoryText;

    /* renamed from: F, reason: from kotlin metadata */
    private final View categoryBg;

    public f(View view) {
        super(view);
        this.categoryText = (TextView) view.findViewById(R.id.f163005nt0);
        this.categoryBg = view.findViewById(R.id.o2m);
    }

    /* renamed from: l, reason: from getter */
    public final View getCategoryBg() {
        return this.categoryBg;
    }

    /* renamed from: m, reason: from getter */
    public final TextView getCategoryText() {
        return this.categoryText;
    }
}
