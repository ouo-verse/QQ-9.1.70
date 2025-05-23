package com.tencent.mobileqq.setting.main.config;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import ie0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/setting/main/config/SearchItemConfig;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/setting/main/config/SearchItemConfig$SearchView;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "J", "<init>", "()V", "k", "a", "SearchView", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SearchItemConfig extends w<SearchView> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/setting/main/config/SearchItemConfig$SearchView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class SearchView extends FrameLayout {
        public /* synthetic */ SearchView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchView(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, LayoutAttrsKt.getDp(36)));
            linearLayout.setBackgroundResource(R.drawable.f159657rr);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(LayoutAttrsKt.getDp(18), LayoutAttrsKt.getDp(18)));
            imageView.setImageDrawable(a.f().o(context, R.drawable.qui_search, R.color.qui_common_icon_secondary, 1000));
            int dp5 = LayoutAttrsKt.getDp(4);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                int i16 = layoutParams2 != null ? layoutParams2.width : -2;
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, layoutParams3 != null ? layoutParams3.height : -2);
            }
            if (dp5 != marginLayoutParams.rightMargin) {
                marginLayoutParams.rightMargin = dp5;
                imageView.setLayoutParams(marginLayoutParams);
            }
            TextView textView = new TextView(context);
            textView.setClickable(false);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            textView.setText("\u641c\u7d22");
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dcs));
            textView.setGravity(17);
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_secondary));
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            addView(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public SearchView H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SearchView searchView = new SearchView(context, null, 0, 6, null);
        searchView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return searchView;
    }
}
