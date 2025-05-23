package com.tencent.mobileqq.widget.gridpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004R\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/widget/gridpage/QQGridContainerView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/widget/gridpage/c;", "T", "Lcom/tencent/mobileqq/widget/gridpage/b;", "adapter", "", "setAdapter", "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "layoutInflater", "Lcom/tencent/mobileqq/widget/gridpage/QQGridViewPager;", "e", "Lcom/tencent/mobileqq/widget/gridpage/QQGridViewPager;", "gridPage", "Lcom/tencent/mobileqq/widget/gridpage/QQGridIndicatorView;", "f", "Lcom/tencent/mobileqq/widget/gridpage/QQGridIndicatorView;", "indicator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQGridContainerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View layoutInflater;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQGridViewPager gridPage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQGridIndicatorView indicator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/widget/gridpage/QQGridContainerView$a", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "selectIndex", "", "onPageSelected", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends ViewPager.SimpleOnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int selectIndex) {
            QQGridContainerView.this.indicator.setSelectedPage(selectIndex);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGridContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.i3w, this);
        this.layoutInflater = inflate;
        View findViewById = inflate.findViewById(R.id.vsy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layoutInflater.findViewById(R.id.grid_page)");
        this.gridPage = (QQGridViewPager) findViewById;
        View findViewById2 = inflate.findViewById(R.id.vsz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layoutInflater.findViewB\u2026R.id.grid_page_indicator)");
        this.indicator = (QQGridIndicatorView) findViewById2;
    }

    public final <T extends c> void setAdapter(@NotNull b<T> adapter) {
        int i3;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.gridPage.setAdapter(adapter);
        QQGridIndicatorView qQGridIndicatorView = this.indicator;
        PagerAdapter adapter2 = this.gridPage.getAdapter();
        if (adapter2 != null) {
            i3 = adapter2.getF373114d();
        } else {
            i3 = 0;
        }
        qQGridIndicatorView.setPageCount(i3);
        this.gridPage.addOnPageChangeListener(new a());
    }
}
