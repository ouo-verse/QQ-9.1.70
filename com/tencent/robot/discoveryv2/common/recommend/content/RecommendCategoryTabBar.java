package com.tencent.robot.discoveryv2.common.recommend.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0005B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\u0012B-\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/RecommendCategoryTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "position", "", "a", "", "title", "addTab", "getTabMargin", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RecommendCategoryTabBar extends QUIPageTabBar {
    public RecommendCategoryTabBar(@Nullable Context context) {
        this(context, null);
    }

    private final void a(int position) {
        TextView textView;
        boolean z16;
        View childAt = this.mTabContainer.getChildAt(position);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (childAt instanceof TextView) {
            textView = (TextView) childAt;
        } else {
            textView = null;
        }
        if (textView != null) {
            if (position == getCurrentPosition()) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setSelected(z16);
            textView.setTextSize(16.0f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = ViewUtils.dip2px(16.0f);
                marginLayoutParams.rightMargin = ViewUtils.dip2px(12.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        super.addTab(position, title);
        a(position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        return 0;
    }

    public RecommendCategoryTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecommendCategoryTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public RecommendCategoryTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mTabContainer.getLayoutParams().width = -2;
    }
}
