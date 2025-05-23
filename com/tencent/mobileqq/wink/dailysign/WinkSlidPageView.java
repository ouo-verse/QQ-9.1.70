package com.tencent.mobileqq.wink.dailysign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.view.WinkPageIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/WinkSlidPageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "Lcom/tencent/mobileqq/wink/dailysign/at;", "pagerAdapter", "setAdapter", "", "enable", "setPageIndicatorVisible", "Landroidx/viewpager/widget/ViewPager;", "d", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "Lcom/tencent/mobileqq/wink/view/WinkPageIndicator;", "e", "Lcom/tencent/mobileqq/wink/view/WinkPageIndicator;", "mPageIndicator", "f", "Z", "isInited", "()Z", "setInited", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSlidPageView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewPager mViewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WinkPageIndicator mPageIndicator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSlidPageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.i7w, this);
        View findViewById = findViewById(R.id.f124197ip);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.wink_slid_pager)");
        this.mViewPager = (ViewPager) findViewById;
        View findViewById2 = findViewById(R.id.f123917hy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.wink_pager_indicator)");
        this.mPageIndicator = (WinkPageIndicator) findViewById2;
    }

    public final void setAdapter(@Nullable at pagerAdapter) {
        ViewPager viewPager = this.mViewPager;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager = null;
        }
        viewPager.setAdapter(pagerAdapter);
        WinkPageIndicator winkPageIndicator = this.mPageIndicator;
        if (winkPageIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageIndicator");
            winkPageIndicator = null;
        }
        ViewPager viewPager3 = this.mViewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPager2 = viewPager3;
        }
        winkPageIndicator.setViewPager(viewPager2);
    }

    public final void setInited(boolean z16) {
        this.isInited = z16;
    }

    public final void setPageIndicatorVisible(boolean enable) {
        WinkPageIndicator winkPageIndicator = null;
        if (enable) {
            WinkPageIndicator winkPageIndicator2 = this.mPageIndicator;
            if (winkPageIndicator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPageIndicator");
            } else {
                winkPageIndicator = winkPageIndicator2;
            }
            winkPageIndicator.setVisibility(0);
            return;
        }
        WinkPageIndicator winkPageIndicator3 = this.mPageIndicator;
        if (winkPageIndicator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageIndicator");
        } else {
            winkPageIndicator = winkPageIndicator3;
        }
        winkPageIndicator.setVisibility(4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSlidPageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }
}
