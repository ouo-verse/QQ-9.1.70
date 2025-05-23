package com.tencent.mobileqq.zplan.minihome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.bo;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomePriceHintView;", "Landroid/widget/FrameLayout;", "", "isOwned", "", "setIsOwned", "", "goldPrice", "silverPrice", "setPrice", "color", "setTextColor", "Ln74/bo;", "d", "Ln74/bo;", "getBinding", "()Ln74/bo;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomePriceHintView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bo binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomePriceHintView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setPrice(int goldPrice, int silverPrice) {
        this.binding.f418868d.setText(String.valueOf(goldPrice));
        this.binding.f418873i.setText(String.valueOf(silverPrice));
    }

    public final void setTextColor(int color) {
        this.binding.f418868d.setTextColor(color);
    }

    public /* synthetic */ MiniHomePriceHintView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomePriceHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        bo g16 = bo.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        g16.f418868d.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
    }

    public final void setIsOwned(boolean isOwned) {
        if (isOwned) {
            this.binding.f418874j.setVisibility(0);
            this.binding.f418874j.setText("\u5df2\u62e5\u6709");
            this.binding.f418867c.setVisibility(8);
            this.binding.f418868d.setVisibility(8);
            this.binding.f418870f.setVisibility(8);
            this.binding.f418872h.setVisibility(8);
            this.binding.f418873i.setVisibility(8);
            return;
        }
        this.binding.f418867c.setVisibility(0);
        this.binding.f418868d.setVisibility(0);
        this.binding.f418870f.setVisibility(8);
        this.binding.f418872h.setVisibility(8);
        this.binding.f418873i.setVisibility(8);
        this.binding.f418874j.setVisibility(8);
    }
}
