package com.tencent.ecommerce.base.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u0018j\u0002`\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u0018j\u0002`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/base/ui/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Landroid/view/View;", "E", "Landroid/view/View;", "itemRoot", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleTextView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "selectedIcon", "Lcom/tencent/ecommerce/base/ui/j;", "H", "Lcom/tencent/ecommerce/base/ui/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/ecommerce/base/ui/j;", "p", "(Lcom/tencent/ecommerce/base/ui/j;)V", "data", "Lkotlin/Function2;", "", "", "Lcom/tencent/ecommerce/base/ui/ItemClick;", "I", "Lkotlin/jvm/functions/Function2;", "itemClick", "itemView", "<init>", "(Lkotlin/jvm/functions/Function2;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final View itemRoot;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView titleTextView;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView selectedIcon;

    /* renamed from: H, reason: from kotlin metadata */
    public ItemData data;

    /* renamed from: I, reason: from kotlin metadata */
    private final Function2<String, Integer, Unit> itemClick;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    static final class ViewOnClickListenerC1035a implements View.OnClickListener {
        ViewOnClickListenerC1035a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function2 unused = a.this.itemClick;
            a.this.itemClick.invoke(a.this.m().title, Integer.valueOf(a.this.m().index));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function2<? super String, ? super Integer, Unit> function2, View view) {
        super(view);
        this.itemClick = function2;
        View findViewById = view.findViewById(R.id.f163050o14);
        this.itemRoot = findViewById;
        this.titleTextView = (TextView) view.findViewById(R.id.ocd);
        this.selectedIcon = (ImageView) view.findViewById(R.id.o_n);
        findViewById.setOnClickListener(new ViewOnClickListenerC1035a());
    }

    public final ItemData m() {
        ItemData itemData = this.data;
        if (itemData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return itemData;
    }

    public final void o() {
        TextView textView = this.titleTextView;
        ItemData itemData = this.data;
        if (itemData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        textView.setText(itemData.title);
        ImageView imageView = this.selectedIcon;
        ItemData itemData2 = this.data;
        if (itemData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        imageView.setVisibility(itemData2.getIsSelected() ? 0 : 8);
    }

    public final void p(ItemData itemData) {
        this.data = itemData;
    }
}
