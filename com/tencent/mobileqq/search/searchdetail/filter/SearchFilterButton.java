package com.tencent.mobileqq.search.searchdetail.filter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "z0", "", "selected", "A0", "setSelected", "", "label", IECSearchBar.METHOD_SET_TEXT, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "text", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "icon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchFilterButton extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView icon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.text = new TextView(context);
        this.icon = new ImageView(context);
        z0();
        A0(false);
    }

    private final void A0(boolean selected) {
        int color;
        int color2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(bj.a(6));
        if (selected) {
            color = GuildUIUtils.f235378a.E(Color.parseColor("#0099FF"), 0.1f);
        } else {
            color = getContext().getColor(R.color.qui_common_fill_standard_primary);
        }
        gradientDrawable.setColor(color);
        setBackground(gradientDrawable);
        TextView textView = this.text;
        if (selected) {
            color2 = getContext().getColor(R.color.qui_common_brand_standard);
        } else {
            color2 = getContext().getColor(R.color.qui_common_text_secondary);
        }
        textView.setTextColor(color2);
        if (selected) {
            GuildUIUtils.d(this.icon, R.drawable.qui_chevron_up, Integer.valueOf(R.color.qui_common_brand_standard));
        } else {
            GuildUIUtils.d(this.icon, R.drawable.qui_chevron_down, Integer.valueOf(R.color.qui_common_icon_secondary));
        }
    }

    private final void z0() {
        setMinHeight(bj.a(36));
        setPadding(bj.a(16), bj.a(8), bj.a(10), bj.a(8));
        this.text.setId(View.generateViewId());
        this.icon.setId(View.generateViewId());
        View view = this.text;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.endToStart = this.icon.getId();
        layoutParams.setMargins(0, 0, bj.a(2), 0);
        Unit unit = Unit.INSTANCE;
        addView(view, layoutParams);
        View view2 = this.icon;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(bj.a(16), bj.a(16));
        layoutParams2.startToEnd = this.text.getId();
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.endToEnd = 0;
        layoutParams2.setMargins(bj.a(4), 0, 0, 0);
        addView(view2, layoutParams2);
        TextView textView = this.text;
        textView.setTextSize(2, 14.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        A0(selected);
    }

    public final void setText(@NotNull String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.text.setText(label);
    }

    public /* synthetic */ SearchFilterButton(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
