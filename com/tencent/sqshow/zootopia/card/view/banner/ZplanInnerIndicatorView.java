package com.tencent.sqshow.zootopia.card.view.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseIndicator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001PB\u0011\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IB\u001b\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bH\u0010LB#\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010M\u001a\u00020\u0002\u00a2\u0006\u0004\bH\u0010NJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\"\u00104\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010,\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010,\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\"\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010,\u001a\u0004\b9\u00101\"\u0004\b:\u00103R\"\u0010?\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010,\u001a\u0004\b=\u00101\"\u0004\b>\u00103R\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010-\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\u00a8\u0006Q"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/banner/ZplanInnerIndicatorView;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/BaseIndicator;", "", "widthMeasureSpec", "o", "heightMeasureSpec", DomainData.DOMAIN_NAME, "Landroid/graphics/Canvas;", PM.CANVAS, "", h.F, "", "midY", "i", "index", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onMeasure", "onDraw", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Path;", "path", "Landroid/view/animation/AccelerateInterpolator;", "D", "Lkotlin/Lazy;", "j", "()Landroid/view/animation/AccelerateInterpolator;", "accelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "E", "k", "()Landroid/view/animation/DecelerateInterpolator;", "interpolator", UserInfo.SEX_FEMALE, "I", "selectedPage", "G", "getIndicatorRadius", "()F", "setIndicatorRadius", "(F)V", "indicatorRadius", "H", "getIndicatorSelectedRadius", "setIndicatorSelectedRadius", "indicatorSelectedRadius", "getRatioSelectedRadius", "setRatioSelectedRadius", "ratioSelectedRadius", "J", "getRatioRadius", "setRatioRadius", "ratioRadius", "K", "getIndicatorSpacing", "()I", "setIndicatorSpacing", "(I)V", "indicatorSpacing", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanInnerIndicatorView extends BaseIndicator {

    /* renamed from: C, reason: from kotlin metadata */
    private final Path path;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy accelerateInterpolator;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy interpolator;

    /* renamed from: F, reason: from kotlin metadata */
    private int selectedPage;

    /* renamed from: G, reason: from kotlin metadata */
    private float indicatorRadius;

    /* renamed from: H, reason: from kotlin metadata */
    private float indicatorSelectedRadius;

    /* renamed from: I, reason: from kotlin metadata */
    private float ratioSelectedRadius;

    /* renamed from: J, reason: from kotlin metadata */
    private float ratioRadius;

    /* renamed from: K, reason: from kotlin metadata */
    private int indicatorSpacing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final RectF rectF;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanInnerIndicatorView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h(Canvas canvas) {
        if (e().getIndicatorSize() <= 0) {
            return;
        }
        float height = (getHeight() / 2.0f) + 0.5f;
        i(canvas, height);
        float l3 = l(this.selectedPage);
        float l16 = l((this.selectedPage + 1) % e().getIndicatorSize()) - l3;
        float interpolation = (j().getInterpolation(getOffset()) * l16) + l3;
        float m3 = l3 + (l16 * m());
        float f16 = this.indicatorSelectedRadius * 0.57f;
        float f17 = this.ratioSelectedRadius;
        float m16 = f17 + ((f16 - f17) * m());
        float interpolation2 = ((this.ratioSelectedRadius - f16) * j().getInterpolation(getOffset())) + f16;
        float m17 = (this.indicatorSelectedRadius - f16) * m();
        float interpolation3 = (this.indicatorSelectedRadius - f16) * j().getInterpolation(getOffset());
        this.paint.setColor(e().getSelectedColor());
        float f18 = this.indicatorSelectedRadius;
        this.rectF.set(interpolation - m16, (height - f18) + m17, interpolation + m16, (f18 + height) - m17);
        canvas.drawRoundRect(this.rectF, m16, m16, this.paint);
        float f19 = (height - f16) - interpolation3;
        float f26 = f16 + height + interpolation3;
        this.rectF.set(m3 - interpolation2, f19, m3 + interpolation2, f26);
        canvas.drawRoundRect(this.rectF, interpolation2, interpolation2, this.paint);
        this.path.reset();
        this.path.moveTo(m3, height);
        this.path.lineTo(m3, f19);
        float f27 = ((interpolation - m3) / 2.0f) + m3;
        this.path.quadTo(f27, height, interpolation, (height - this.indicatorSelectedRadius) + m17);
        this.path.lineTo(interpolation, (this.indicatorSelectedRadius + height) - m17);
        this.path.quadTo(f27, height, m3, f26);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    private final void i(Canvas canvas, float midY) {
        this.paint.setColor(e().getNormalColor());
        int indicatorSize = e().getIndicatorSize();
        for (int i3 = 0; i3 < indicatorSize; i3++) {
            float l3 = l(i3);
            float f16 = this.ratioRadius;
            float f17 = this.indicatorRadius;
            this.rectF.set(l3 - f16, midY - f17, l3 + f16, f17 + midY);
            RectF rectF = this.rectF;
            float f18 = this.indicatorRadius;
            canvas.drawRoundRect(rectF, f18, f18, this.paint);
        }
    }

    private final AccelerateInterpolator j() {
        return (AccelerateInterpolator) this.accelerateInterpolator.getValue();
    }

    private final DecelerateInterpolator k() {
        return (DecelerateInterpolator) this.interpolator.getValue();
    }

    private final float l(int index) {
        float coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.ratioRadius, this.ratioSelectedRadius);
        return getPaddingLeft() + coerceAtLeast + (((2.0f * coerceAtLeast) + this.indicatorSpacing) * index) + ((coerceAtLeast - this.ratioRadius) / 2);
    }

    private final float m() {
        return k().getInterpolation(getOffset());
    }

    private final int n(int heightMeasureSpec) {
        float coerceAtLeast;
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.ratioSelectedRadius, this.ratioRadius);
            return (int) ((coerceAtLeast * 2) + getPaddingTop() + getPaddingBottom());
        }
        if (mode == 1073741824) {
            return size;
        }
        Log.e("ZplanInnerIndicatorView", "measureWidth: error !! " + mode);
        return 0;
    }

    private final int o(int widthMeasureSpec) {
        float coerceAtLeast;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.ratioSelectedRadius, this.ratioRadius);
            return (int) ((coerceAtLeast * 2 * e().getIndicatorSize()) + ((e().getIndicatorSize() - 1) * this.indicatorSpacing) + (this.ratioSelectedRadius - this.ratioRadius) + getPaddingLeft() + getPaddingRight());
        }
        if (mode == 1073741824) {
            return size;
        }
        Log.e("ZplanInnerIndicatorView", "measureWidth: error !! " + mode);
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
        setMeasuredDimension(o(widthMeasureSpec), n(heightMeasureSpec));
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.BaseIndicator, com.tencent.sqshow.zootopia.portal.home.banner.c
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.selectedPage = position;
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    public final void setIndicatorRadius(float f16) {
        this.indicatorRadius = f16;
    }

    public final void setIndicatorSelectedRadius(float f16) {
        this.indicatorSelectedRadius = f16;
    }

    public final void setIndicatorSpacing(int i3) {
        this.indicatorSpacing = i3;
    }

    public final void setRatioRadius(float f16) {
        this.ratioRadius = f16;
    }

    public final void setRatioSelectedRadius(float f16) {
        this.ratioSelectedRadius = f16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanInnerIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanInnerIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.rectF = new RectF();
        this.paint = new Paint(1);
        this.path = new Path();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccelerateInterpolator>() { // from class: com.tencent.sqshow.zootopia.card.view.banner.ZplanInnerIndicatorView$accelerateInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccelerateInterpolator invoke() {
                return new AccelerateInterpolator();
            }
        });
        this.accelerateInterpolator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DecelerateInterpolator>() { // from class: com.tencent.sqshow.zootopia.card.view.banner.ZplanInnerIndicatorView$interpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DecelerateInterpolator invoke() {
                return new DecelerateInterpolator();
            }
        });
        this.interpolator = lazy2;
        float dpToPx = ViewUtils.dpToPx(2.1f);
        this.indicatorRadius = dpToPx;
        this.indicatorSelectedRadius = dpToPx;
        this.ratioSelectedRadius = ViewUtils.dpToPx(4.0f);
        this.ratioRadius = ViewUtils.dpToPx(2.1f);
        this.indicatorSpacing = ViewUtils.dpToPx(1.0f);
    }
}
