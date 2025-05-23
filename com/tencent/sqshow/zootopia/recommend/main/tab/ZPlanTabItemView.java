package com.tencent.sqshow.zootopia.recommend.main.tab;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.dc;
import org.libpag.PAGView;
import tl.h;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u001c\u0018\u0000 (2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0004R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "needAnimation", "", "E0", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "data", "G0", "H0", "B0", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabState;", "state", "C0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ln74/dc;", "d", "Ln74/dc;", "mBinding", "e", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "mData", "f", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabState;", "mState", h.F, "Z", "mPagAnimStarted", "com/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabItemView$b", "i", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabItemView$b;", "mPagListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTabItemView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final dc mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZPlanTabData mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanTabState mState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mPagAnimStarted;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b mPagListener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabItemView$b", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements PAGView.PAGViewListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            QLog.i("ZPlanTabItemView_", 1, "onAnimationStart mPagAnimStarted:" + ZPlanTabItemView.this.mPagAnimStarted);
            ZPlanTabItemView.this.mPagAnimStarted = true;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView p06) {
            QLog.i("ZPlanTabItemView_", 1, "onAnimationCancel");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            QLog.i("ZPlanTabItemView_", 1, "onAnimationEnd");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView p06) {
            QLog.i("ZPlanTabItemView_", 1, "onAnimationRepeat");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView p06) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanTabItemView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void E0(boolean needAnimation) {
        ZPlanTabData zPlanTabData = this.mData;
        if (zPlanTabData == null) {
            return;
        }
        int tabType = zPlanTabData.getTabType();
        if (tabType == 0) {
            G0(zPlanTabData, needAnimation);
        } else {
            if (tabType != 1) {
                return;
            }
            H0(zPlanTabData);
        }
    }

    private final void G0(ZPlanTabData data, boolean needAnimation) {
        this.mBinding.f419209f.setVisibility(0);
        this.mBinding.f419206c.setVisibility(8);
        this.mBinding.f419209f.setText(data.getTitle());
        if (this.mState == ZPlanTabState.NORMAL) {
            this.mBinding.f419205b.setVisibility(0);
            this.mBinding.f419207d.setVisibility(8);
            URLImageView uRLImageView = this.mBinding.f419205b;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.iconIgv");
            data.m(uRLImageView);
            this.mBinding.f419209f.setTextColor(getResources().getColor(R.color.qui_common_text_tabbar_primary));
            return;
        }
        URLImageView uRLImageView2 = this.mBinding.f419205b;
        Intrinsics.checkNotNullExpressionValue(uRLImageView2, "mBinding.iconIgv");
        ZPlanPAGView zPlanPAGView = this.mBinding.f419207d;
        Intrinsics.checkNotNullExpressionValue(zPlanPAGView, "mBinding.tabIconPagview");
        data.n(uRLImageView2, zPlanPAGView, needAnimation);
        this.mBinding.f419209f.setTextColor(getResources().getColor(R.color.qui_common_brand_standard));
    }

    private final void H0(ZPlanTabData data) {
        pu4.g sTabSelectedRes;
        this.mBinding.f419205b.setVisibility(8);
        this.mBinding.f419207d.setVisibility(8);
        this.mBinding.f419209f.setVisibility(8);
        this.mBinding.f419206c.setVisibility(0);
        pu4.g material = this.mBinding.f419206c.getMaterial();
        if (this.mState == ZPlanTabState.NORMAL) {
            sTabSelectedRes = data.getSTabNormalRes();
        } else {
            sTabSelectedRes = data.getSTabSelectedRes();
        }
        QLog.i("ZPlanTabItemView_", 1, "refreshViewSpecialStyle targetMaterial:" + o.l(sTabSelectedRes) + ", mState:" + this.mState);
        if (o.c(sTabSelectedRes)) {
            if ((material != null && o.d(material, sTabSelectedRes)) && this.mPagAnimStarted) {
                QLog.e("ZPlanTabItemView_", 1, "material is same and mPagAnimStarted!");
                return;
            }
        }
        this.mPagAnimStarted = false;
        RoundCornerImageView l3 = this.mBinding.f419206c.l();
        Drawable drawable = l3 != null ? l3.getDrawable() : null;
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        this.mBinding.f419206c.setDefaultDrawable(drawable);
        this.mBinding.f419206c.setPagListener(this.mPagListener);
        this.mBinding.f419206c.stop();
        this.mBinding.f419206c.e(sTabSelectedRes);
    }

    public final void B0(ZPlanTabData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        F0(this, false, 1, null);
        ZPlanTabData zPlanTabData = this.mData;
        if (zPlanTabData != null) {
            ZPlanPAGView zPlanPAGView = this.mBinding.f419207d;
            Intrinsics.checkNotNullExpressionValue(zPlanPAGView, "mBinding.tabIconPagview");
            zPlanTabData.l(zPlanPAGView);
        }
    }

    public final void C0(ZPlanTabState state, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(state, "state");
        boolean z16 = needAnimation && this.mState != state;
        this.mState = state;
        E0(z16);
    }

    public final void onDestroy() {
        this.mBinding.f419206c.stop();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanTabItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanTabItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanTabItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mState = ZPlanTabState.NORMAL;
        this.mPagListener = new b();
        dc f16 = dc.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        f16.f419207d.setRadius(0);
        setBackground(new ColorDrawable(0));
    }

    public static /* synthetic */ void D0(ZPlanTabItemView zPlanTabItemView, ZPlanTabState zPlanTabState, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanTabItemView.C0(zPlanTabState, z16);
    }

    static /* synthetic */ void F0(ZPlanTabItemView zPlanTabItemView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        zPlanTabItemView.E0(z16);
    }
}
