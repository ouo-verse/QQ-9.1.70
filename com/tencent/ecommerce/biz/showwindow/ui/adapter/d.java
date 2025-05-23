package com.tencent.ecommerce.biz.showwindow.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "itView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setSelectedIconView", "(Landroid/widget/ImageView;)V", "selectedIconView", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    public final View itView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView selectedIconView;

    public d(View view, ImageView imageView) {
        super(view);
        this.itView = view;
        this.selectedIconView = imageView;
    }

    /* renamed from: l, reason: from getter */
    public final ImageView getSelectedIconView() {
        return this.selectedIconView;
    }
}
