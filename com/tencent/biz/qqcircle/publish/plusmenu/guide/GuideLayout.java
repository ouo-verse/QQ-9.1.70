package com.tencent.biz.qqcircle.publish.plusmenu.guide;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qa0.GuidLineOption;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\n\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002\u0005\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u0017\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0014J0\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\t048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010'R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusmenu/guide/GuideLayout;", "Landroid/widget/FrameLayout;", "", "bottomMargin", "", "a", "f", "Landroid/view/View;", "highlightView", "Lqa0/a;", "option", "Landroid/graphics/Rect;", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "c", "d", "highLight", "Landroid/graphics/RectF;", "e", "Lcom/tencent/biz/qqcircle/publish/plusmenu/guide/GuideLayout$b;", "listener", "setListener", "margin", "setBottomMargin", "(Ljava/lang/Integer;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "onDraw", "", "Lqa0/b;", "Ljava/util/List;", "guidePages", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Lqa0/b;", "currentPage", h.F, "I", "highlightColor", "i", "Landroid/view/View;", "pageLayout", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "guideLineOptions", BdhLogUtil.LogTag.Tag_Conn, "calculateHeightViews", "D", "Ljava/lang/Integer;", "E", "contentHeight", UserInfo.SEX_FEMALE, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public final class GuideLayout extends FrameLayout {
    private static final int G;
    private static final int H;
    private static final int I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<View> calculateHeightViews;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer bottomMargin;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer contentHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<qa0.b> guidePages;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qa0.b currentPage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int highlightColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View pageLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuidLineOption> guideLineOptions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusmenu/guide/GuideLayout$b;", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
    }

    static {
        int parseColor = Color.parseColor("#80000000");
        G = parseColor;
        H = Color.parseColor("#00000000");
        I = parseColor;
    }

    private final void a(int bottomMargin) {
        if (this.contentHeight != null) {
            return;
        }
        int i3 = 0;
        int i16 = 0;
        for (View view : this.calculateHeightViews) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i16 = i16 + view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        int measuredHeight = getMeasuredHeight();
        if (QLog.isColorLevel()) {
            QLog.d("GuideLayout", 1, "onMeasure, contentHeight:" + i16 + ", containerHeight:" + measuredHeight + ", bottomMargin:" + bottomMargin);
        }
        int a16 = (measuredHeight - bottomMargin) - cx.a(20.0f);
        if (a16 > i16) {
            i3 = a16 - i16;
        }
        View view2 = this.pageLayout;
        view2.setPadding(view2.getPaddingLeft(), i3, view2.getPaddingRight(), view2.getPaddingBottom());
        this.contentHeight = Integer.valueOf(i16);
    }

    private final Rect b(View highlightView, GuidLineOption option) {
        float left;
        int i3;
        RectF e16 = e(highlightView);
        float bottom = (e16.top - option.getAnchorView().getBottom()) - cx.a(option.getMargin());
        float ratio = option.getRatio() * bottom;
        int align = option.getAlign();
        if (align != 1) {
            if (align != 8388611) {
                if (align != 8388613) {
                    i3 = option.getGuideLineView().getLeft();
                } else {
                    left = option.getGuideLineView().getRight() - ratio;
                }
            } else {
                i3 = option.getGuideLineView().getLeft();
            }
            float f16 = e16.top;
            return new Rect(i3, (int) (f16 - bottom), (int) (i3 + ratio), (int) f16);
        }
        left = (option.getGuideLineView().getLeft() + (option.getGuideLineView().getMeasuredWidth() / 2)) - (ratio / 2);
        i3 = (int) left;
        float f162 = e16.top;
        return new Rect(i3, (int) (f162 - bottom), (int) (i3 + ratio), (int) f162);
    }

    private final void c(Canvas canvas) {
        canvas.drawColor(G);
    }

    private final void d(Canvas canvas) {
        qa0.b bVar = this.currentPage;
        if (bVar != null) {
            float a16 = cx.a(bVar.getRoundCorner());
            RectF e16 = e(bVar.getHighlightView());
            Paint paint = this.paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Unit unit = Unit.INSTANCE;
            canvas.drawRoundRect(e16, a16, a16, paint);
            Paint paint2 = this.paint;
            paint2.setXfermode(null);
            paint2.setColor(this.highlightColor);
            canvas.drawRoundRect(e16, a16, a16, paint2);
        }
    }

    private final RectF e(View highLight) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        highLight.getLocationInWindow(iArr2);
        return new RectF(iArr2[0] - iArr[0], iArr2[1] - iArr[1], r3 + highLight.getWidth(), r0 + highLight.getHeight());
    }

    private final void f() {
        int i3 = 0;
        for (Object obj : this.guidePages) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GuidLineOption guidLineOption = this.guideLineOptions.get(i3);
            Rect b16 = b(((qa0.b) obj).getHighlightView(), this.guideLineOptions.get(i3));
            guidLineOption.getGuideLineView().layout(b16.left, b16.top, b16.right, b16.bottom);
            i3 = i16;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        c(canvas);
        d(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        f();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Integer num = this.bottomMargin;
        if (num != null) {
            a(num.intValue());
        }
    }

    public final void setBottomMargin(@Nullable Integer margin) {
        this.bottomMargin = margin;
    }

    public final void setListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
