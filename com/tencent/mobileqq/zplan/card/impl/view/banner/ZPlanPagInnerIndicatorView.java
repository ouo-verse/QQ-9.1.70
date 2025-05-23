package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0003\u000e !B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0018\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$c;", "", "lastSelectPos", "curSelectPos", "", "g", "count", "selectPos", "b", "position", "Landroid/view/View;", "view", "a", "d", "I", "indicatorSpacing", "e", "currentPos", "f", "itemCount", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "IndicatorItemView", "ItemStatus", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanPagInnerIndicatorView extends LinearLayout implements ZplanPagFrameView.c {
    private static final float C;
    private static final float D;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final float f332078i;

    /* renamed from: m, reason: collision with root package name */
    private static final float f332079m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int indicatorSpacing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemCount;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B#\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00100\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u00101J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R*\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$IndicatorItemView;", "Landroid/view/View;", "", "widthMeasureSpec", "d", "heightMeasureSpec", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "b", "onMeasure", "onDraw", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$ItemStatus;", "value", "f", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$ItemStatus;", "getItemStatus", "()Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$ItemStatus;", "setItemStatus", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$ItemStatus;)V", "itemStatus", "", tl.h.F, UserInfo.SEX_FEMALE, "getDiff", "()F", "setDiff", "(F)V", "diff", "i", "getWidthRate", "setWidthRate", "widthRate", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView;Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "defStyleAttr", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class IndicatorItemView extends View {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final RectF rectF;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final Paint paint;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private ItemStatus itemStatus;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private float diff;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private float widthRate;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ZPlanPagInnerIndicatorView f332088m;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f332089a;

            static {
                int[] iArr = new int[ItemStatus.values().length];
                try {
                    iArr[ItemStatus.NORMAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ItemStatus.SELECTED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f332089a = iArr;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public IndicatorItemView(ZPlanPagInnerIndicatorView zPlanPagInnerIndicatorView, Context context) {
            this(zPlanPagInnerIndicatorView, context, null, 0);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        private final void a(Canvas canvas) {
            this.paint.setColor(-1996488705);
            this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
            RectF rectF = this.rectF;
            Companion companion = ZPlanPagInnerIndicatorView.INSTANCE;
            canvas.drawRoundRect(rectF, companion.a(), companion.a(), this.paint);
        }

        private final void b(Canvas canvas) {
            this.paint.setColor(-1);
            this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
            RectF rectF = this.rectF;
            Companion companion = ZPlanPagInnerIndicatorView.INSTANCE;
            canvas.drawRoundRect(rectF, companion.b(), companion.b(), this.paint);
        }

        private final int c(int heightMeasureSpec) {
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode == Integer.MIN_VALUE || mode == 0) {
                return (int) (ZPlanPagInnerIndicatorView.INSTANCE.a() * 2);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }

        private final int d(int widthMeasureSpec) {
            float a16;
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            if (mode != Integer.MIN_VALUE && mode != 0) {
                if (mode != 1073741824) {
                    return 0;
                }
                return size;
            }
            int i3 = a.f332089a[this.itemStatus.ordinal()];
            if (i3 == 1) {
                a16 = ZPlanPagInnerIndicatorView.INSTANCE.a() + (this.diff * this.widthRate);
            } else if (i3 == 2) {
                a16 = ZPlanPagInnerIndicatorView.INSTANCE.c() - (this.diff * this.widthRate);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return (int) (a16 * 2);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
            if (this.itemStatus == ItemStatus.NORMAL) {
                a(canvas);
            } else {
                b(canvas);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(d(widthMeasureSpec), c(heightMeasureSpec));
        }

        public final void setDiff(float f16) {
            this.diff = f16;
        }

        public final void setItemStatus(ItemStatus value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.itemStatus = value;
            requestLayout();
        }

        public final void setWidthRate(float f16) {
            this.widthRate = f16;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IndicatorItemView(ZPlanPagInnerIndicatorView zPlanPagInnerIndicatorView, Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f332088m = zPlanPagInnerIndicatorView;
            this.rectF = new RectF();
            this.paint = new Paint(1);
            this.itemStatus = ItemStatus.NORMAL;
            Companion companion = ZPlanPagInnerIndicatorView.INSTANCE;
            this.diff = companion.c() - companion.a();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$ItemStatus;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "SELECTED", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum ItemStatus {
        NORMAL,
        SELECTED
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZPlanPagInnerIndicatorView$a;", "", "", "indicatorRadius", UserInfo.SEX_FEMALE, "a", "()F", "indicatorSelectedRadius", "b", "ratioSelectedRadius", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.card.impl.view.banner.ZPlanPagInnerIndicatorView$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return ZPlanPagInnerIndicatorView.f332078i;
        }

        public final float b() {
            return ZPlanPagInnerIndicatorView.f332079m;
        }

        public final float c() {
            return ZPlanPagInnerIndicatorView.C;
        }

        Companion() {
        }
    }

    static {
        float dpToPx = ViewUtils.dpToPx(2.1f);
        f332078i = dpToPx;
        f332079m = dpToPx;
        C = ViewUtils.dpToPx(6.0f);
        D = dpToPx;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanPagInnerIndicatorView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g(int lastSelectPos, int curSelectPos) {
        View childAt = getChildAt(curSelectPos);
        IndicatorItemView indicatorItemView = childAt instanceof IndicatorItemView ? (IndicatorItemView) childAt : null;
        float dpToPx = (lastSelectPos - curSelectPos) * ViewUtils.dpToPx(6.0f);
        if (indicatorItemView != null) {
            ObjectAnimator.ofFloat(indicatorItemView, "translationX", dpToPx, 0.0f).start();
        }
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.c
    public void a(int position, View view) {
        QLog.d("ZPIndicatorView", 1, "select pos " + position + " " + this.currentPos + " ");
        if (this.currentPos == position) {
            return;
        }
        View childAt = getChildAt(position);
        IndicatorItemView indicatorItemView = childAt instanceof IndicatorItemView ? (IndicatorItemView) childAt : null;
        if (indicatorItemView != null) {
            indicatorItemView.setItemStatus(ItemStatus.SELECTED);
        }
        int i3 = this.currentPos;
        if (i3 != -1) {
            View childAt2 = getChildAt(i3);
            IndicatorItemView indicatorItemView2 = childAt2 instanceof IndicatorItemView ? (IndicatorItemView) childAt2 : null;
            if (indicatorItemView2 != null) {
                indicatorItemView2.setItemStatus(ItemStatus.NORMAL);
            }
            g(this.currentPos, position);
        }
        this.currentPos = position;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.c
    public void b(int count, int selectPos) {
        ItemStatus itemStatus;
        removeAllViews();
        this.currentPos = selectPos;
        this.itemCount = count;
        for (int i3 = 0; i3 < count; i3++) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            IndicatorItemView indicatorItemView = new IndicatorItemView(this, context);
            if (i3 == selectPos) {
                itemStatus = ItemStatus.SELECTED;
            } else {
                itemStatus = ItemStatus.NORMAL;
            }
            indicatorItemView.setItemStatus(itemStatus);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.h(this), com.tencent.sqshow.zootopia.utils.i.h(this));
            layoutParams.rightMargin = this.indicatorSpacing;
            addView(indicatorItemView, layoutParams);
            QLog.d("ZPIndicatorView", 1, " add view " + i3);
        }
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.c
    public void c(int i3, float f16) {
        ZplanPagFrameView.c.a.b(this, i3, f16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanPagInnerIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPagInnerIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.indicatorSpacing = ViewUtils.dpToPx(3.0f);
        this.currentPos = -1;
        this.itemCount = -1;
        setOrientation(0);
        setGravity(17);
    }
}
