package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/LeftBannerPageItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/BaseBannerPageItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/b;", "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", "", "viewBgColor", "", "b", "(Landroidx/viewpager2/widget/ViewPager2;Ljava/lang/Integer;)V", "position", "", "positionOffset", "positionOffsetPixels", "f", "g", "Landroid/view/View;", "D", "Landroid/view/View;", "getCoverView", "()Landroid/view/View;", "setCoverView", "(Landroid/view/View;)V", "coverView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class LeftBannerPageItemView extends BaseBannerPageItemView {

    /* renamed from: D, reason: from kotlin metadata */
    private View coverView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LeftBannerPageItemView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.BaseBannerPageItemView, com.tencent.mobileqq.zplan.card.impl.view.banner.b
    public void b(ViewPager2 viewpager, Integer viewBgColor) {
        View view;
        super.b(viewpager, viewBgColor);
        if ((viewBgColor != null ? viewBgColor.intValue() : 0) == 0 || (view = this.coverView) == null) {
            return;
        }
        Intrinsics.checkNotNull(viewBgColor);
        view.setBackgroundColor(viewBgColor.intValue());
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.BaseBannerPageItemView
    public void f(int position, float positionOffset, int positionOffsetPixels) {
        super.f(position, positionOffset, positionOffsetPixels);
        float f16 = positionOffset * 2.0f;
        if (f16 > 1.0f) {
            f16 = 2.0f - f16;
        }
        int n3 = Utils.n(40.0f, getContext().getResources());
        View view = this.coverView;
        if (view == null) {
            return;
        }
        float f17 = 1 - f16;
        if (view != null) {
            n3 = view.getWidth();
        }
        view.setTranslationX(-(f17 * n3));
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.BaseBannerPageItemView
    public void g(int position) {
        super.g(position);
        int n3 = Utils.n(40.0f, getContext().getResources());
        View view = this.coverView;
        if (view == null) {
            return;
        }
        if (view != null) {
            n3 = view.getWidth();
        }
        view.setTranslationX(n3);
    }

    public final void setCoverView(View view) {
        this.coverView = view;
    }

    public /* synthetic */ LeftBannerPageItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeftBannerPageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.d8h, this);
        this.coverView = findViewById(R.id.pmu);
        setBannerBg((ZPlanMediaView) findViewById(R.id.pde));
        setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        ZPlanMediaView bannerBg = getBannerBg();
        RoundCornerImageView l3 = bannerBg != null ? bannerBg.l() : null;
        if (l3 == null) {
            return;
        }
        l3.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
