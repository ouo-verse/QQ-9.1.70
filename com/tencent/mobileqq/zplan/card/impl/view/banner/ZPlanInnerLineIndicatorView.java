package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseIndicator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001JB\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CB\u001b\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bB\u0010FB#\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\u0006\u0010G\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010HJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J@\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00105R\u0014\u00108\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0014\u0010:\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0014\u0010;\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00105R\u0014\u0010=\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b<\u00103R\u0014\u0010?\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00105\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanInnerLineIndicatorView;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/BaseIndicator;", "", "widthMeasureSpec", "p", "heightMeasureSpec", "o", "Landroid/graphics/Canvas;", PM.CANVAS, "", tl.h.F, "", "midY", "finalPercent", "startLeft", "dstLeft", "startRight", "dstRight", "i", "l", "", "logMsg", "", "isDebugOnly", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "position", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onMeasure", "onDraw", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/view/animation/AccelerateInterpolator;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "getAccelerateInterpolator", "()Landroid/view/animation/AccelerateInterpolator;", "accelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "D", "k", "()Landroid/view/animation/DecelerateInterpolator;", "interpolator", "E", "I", "selectIndex", UserInfo.SEX_FEMALE, "indicatorNormalRadius", "G", "indicatorSelectedRadius", "H", "indicatorSpacing", "indicatorNormalWidth", "J", "indicatorSelectedCount", "K", "indicatorSelectedWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanInnerLineIndicatorView extends BaseIndicator {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy accelerateInterpolator;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy interpolator;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private final float indicatorNormalRadius;

    /* renamed from: G, reason: from kotlin metadata */
    private final float indicatorSelectedRadius;

    /* renamed from: H, reason: from kotlin metadata */
    private final float indicatorSpacing;

    /* renamed from: I, reason: from kotlin metadata */
    private final float indicatorNormalWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private final int indicatorSelectedCount;

    /* renamed from: K, reason: from kotlin metadata */
    private final float indicatorSelectedWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final RectF rectF;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanInnerLineIndicatorView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h(Canvas canvas) {
        n("drawBezier selectedPage = " + this.selectIndex + " totalSize = " + e().getIndicatorSize() + " ", true);
        float height = ((float) getHeight()) / 2.0f;
        float f16 = this.indicatorNormalRadius;
        float f17 = height - f16;
        float f18 = f16 + height;
        float f19 = this.indicatorSelectedRadius;
        float f26 = height - f19;
        float f27 = f19 + height;
        this.paint.setColor(e().getNormalColor());
        int indicatorSize = e().getIndicatorSize() + (this.indicatorSelectedCount - 1);
        for (int i3 = 0; i3 < indicatorSize; i3++) {
            float f28 = this.indicatorNormalWidth;
            float f29 = (this.indicatorSpacing + f28) * i3;
            this.rectF.set(f29, f17, f28 + f29, f18);
            RectF rectF = this.rectF;
            float f36 = this.indicatorNormalRadius;
            canvas.drawRoundRect(rectF, f36, f36, this.paint);
        }
        this.paint.setColor(e().getSelectedColor());
        float l3 = l();
        if (this.selectIndex == e().getIndicatorSize() - 1) {
            float f37 = (this.indicatorNormalWidth + this.indicatorSpacing) * this.selectIndex;
            float f38 = f37 + this.indicatorSelectedWidth;
            i(canvas, height, l3, f37, f38, f38, f38);
            i(canvas, height, l3, 0.0f, 0.0f, 0.0f, this.indicatorSelectedWidth + 0.0f);
            return;
        }
        float f39 = this.indicatorNormalWidth;
        float f46 = this.indicatorSpacing;
        float f47 = (f39 + f46) * this.selectIndex;
        float f48 = this.indicatorSelectedWidth;
        float f49 = ((f39 + f46) * (r7 + 1)) + f48;
        float f56 = f49 - f48;
        float f57 = f48 + f47;
        if (l3 > 0.5f) {
            f47 += ((f56 - f47) * (l3 - 0.5f)) / 0.5f;
        }
        if (l3 <= 0.5f) {
            f49 = (((f49 - f57) * l3) / 0.5f) + f57;
        }
        this.rectF.set(f47, f26, f49, f27);
        RectF rectF2 = this.rectF;
        float f58 = this.indicatorSelectedRadius;
        canvas.drawRoundRect(rectF2, f58, f58, this.paint);
    }

    private final void i(Canvas canvas, float midY, float finalPercent, float startLeft, float dstLeft, float startRight, float dstRight) {
        this.paint.setColor(e().getSelectedColor());
        float f16 = this.indicatorSelectedRadius;
        float f17 = startLeft + ((dstLeft - startLeft) * finalPercent);
        float f18 = startRight + ((dstRight - startRight) * finalPercent);
        this.rectF.set(f17, midY - f16, f18, midY + f16);
        RectF rectF = this.rectF;
        float f19 = this.indicatorSelectedRadius;
        canvas.drawRoundRect(rectF, f19, f19, this.paint);
    }

    private final DecelerateInterpolator k() {
        return (DecelerateInterpolator) this.interpolator.getValue();
    }

    private final float l() {
        return k().getInterpolation(getOffset());
    }

    private final void m(String logMsg, boolean isDebugOnly) {
        if (j(isDebugOnly)) {
            QLog.e("ZPlanInnerLineIndicator", 1, logMsg);
        }
    }

    private final void n(String logMsg, boolean isDebugOnly) {
        if (j(isDebugOnly)) {
            QLog.i("ZPlanInnerLineIndicator", 1, logMsg);
        }
    }

    private final int o(int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (int) ((Math.max(this.indicatorSelectedRadius, this.indicatorNormalRadius) * 2) + getPaddingTop() + getPaddingBottom() + 1);
        }
        if (mode == 1073741824) {
            return size;
        }
        m("measureWidth: error !! " + mode, false);
        return 0;
    }

    private final int p(int widthMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (int) (this.indicatorSelectedWidth + ((this.indicatorNormalWidth + this.indicatorSpacing) * (e().getIndicatorSize() - 1)) + getPaddingLeft() + getPaddingRight());
        }
        if (mode == 1073741824) {
            return size;
        }
        m("measureWidth: error !! " + mode, false);
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        h(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(p(widthMeasureSpec), o(heightMeasureSpec));
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseIndicator, com.tencent.sqshow.zootopia.portal.home.banner.c
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.selectIndex = position;
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanInnerLineIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanInnerLineIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.rectF = new RectF();
        this.paint = new Paint(1);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccelerateInterpolator>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZPlanInnerLineIndicatorView$accelerateInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccelerateInterpolator invoke() {
                return new AccelerateInterpolator();
            }
        });
        this.accelerateInterpolator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DecelerateInterpolator>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZPlanInnerLineIndicatorView$interpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DecelerateInterpolator invoke() {
                return new DecelerateInterpolator();
            }
        });
        this.interpolator = lazy2;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f12196t) / 2.0f;
        this.indicatorNormalRadius = dimensionPixelSize;
        this.indicatorSelectedRadius = dimensionPixelSize;
        float e16 = com.tencent.sqshow.zootopia.utils.i.e(2);
        this.indicatorSpacing = e16;
        float e17 = com.tencent.sqshow.zootopia.utils.i.e(5);
        this.indicatorNormalWidth = e17;
        this.indicatorSelectedCount = 4;
        this.indicatorSelectedWidth = (e17 * 4) + (e16 * (4 - 1));
    }

    private final boolean j(boolean isDebugOnly) {
        return !isDebugOnly || QLog.isColorLevel();
    }
}
