package com.tencent.ecommerce.biz.shophome.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/i;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "itemIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QZoneJsConstants.KEY_HIGH_FIVE_TEXT, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    public final ImageView itemIcon;

    /* renamed from: F, reason: from kotlin metadata */
    public final TextView itemText;

    public i(View view, ImageView imageView, TextView textView) {
        super(view);
        this.itemIcon = imageView;
        this.itemText = textView;
    }
}
