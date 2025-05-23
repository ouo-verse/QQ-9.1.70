package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/MidBannerPageItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/BaseBannerPageItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/b;", "", "position", "", "positionOffset", "positionOffsetPixels", "", "f", "D", UserInfo.SEX_FEMALE, "getScaleMin", "()F", "setScaleMin", "(F)V", "scaleMin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MidBannerPageItemView extends BaseBannerPageItemView {

    /* renamed from: D, reason: from kotlin metadata */
    private float scaleMin;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MidBannerPageItemView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.BaseBannerPageItemView
    public void f(int position, float positionOffset, int positionOffsetPixels) {
        super.f(position, positionOffset, positionOffsetPixels);
        float abs = Math.abs(getCurPos() - (position + positionOffset));
        if (abs >= 1.0f) {
            ZPlanMediaView bannerBg = getBannerBg();
            if (bannerBg != null) {
                bannerBg.setScaleX(this.scaleMin);
            }
            ZPlanMediaView bannerBg2 = getBannerBg();
            if (bannerBg2 == null) {
                return;
            }
            bannerBg2.setScaleY(this.scaleMin);
            return;
        }
        float f16 = 1;
        float f17 = this.scaleMin;
        float f18 = ((f16 - f17) * (f16 - abs)) + f17;
        ZPlanMediaView bannerBg3 = getBannerBg();
        if (bannerBg3 != null) {
            bannerBg3.setScaleX(f18);
        }
        ZPlanMediaView bannerBg4 = getBannerBg();
        if (bannerBg4 == null) {
            return;
        }
        bannerBg4.setScaleY(f18);
    }

    public final void setScaleMin(float f16) {
        this.scaleMin = f16;
    }

    public /* synthetic */ MidBannerPageItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MidBannerPageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scaleMin = 0.75f;
        LayoutInflater.from(getContext()).inflate(R.layout.d8k, this);
        setBannerBg((ZPlanMediaView) findViewById(R.id.pde));
        setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    }
}
