package com.qzone.reborn.userhome.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/userhome/header/QZoneFamousUserHomeNaviItem;", "Landroid/widget/FrameLayout;", "", "resId", "", "setName", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mItemNameTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFamousUserHomeNaviItem extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mItemNameTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeNaviItem(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setName(int resId) {
        this.mItemNameTv.setText(getContext().getString(resId));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeNaviItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneFamousUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textView = new TextView(context);
        textView.setTextSize(17.0f);
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        textView.setGravity(17);
        this.mItemNameTv = textView;
        addView(textView, new FrameLayout.LayoutParams(-1, -1));
    }
}
