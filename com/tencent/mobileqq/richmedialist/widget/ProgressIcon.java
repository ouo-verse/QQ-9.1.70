package com.tencent.mobileqq.richmedialist.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import ie0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/richmedialist/widget/ProgressIcon;", "Landroid/widget/FrameLayout;", "", "color", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "progress", "c", "dispatchDraw", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "progressRect", "e", "I", "curProgress", "f", "viewSize", h.F, "offset", "", "i", UserInfo.SEX_FEMALE, "progressWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "progressPaint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ProgressIcon extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RectF progressRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int viewSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int offset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float progressWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint progressPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressIcon(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Canvas canvas) {
        if (this.curProgress <= 0) {
            return;
        }
        if (this.progressRect == null) {
            int i3 = this.offset;
            float f16 = this.progressWidth;
            float f17 = 2;
            int i16 = this.viewSize;
            this.progressRect = new RectF(i3 + (f16 / f17), i3 + (f16 / f17), (i16 - (f16 / f17)) - i3, (i16 - (f16 / f17)) - i3);
        }
        int i17 = (this.curProgress * 360) / 100;
        if (canvas != null) {
            RectF rectF = this.progressRect;
            Intrinsics.checkNotNull(rectF);
            canvas.drawArc(rectF, 270.0f, i17, false, this.progressPaint);
        }
    }

    private final Paint b(int color) {
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.progressWidth);
        return paint;
    }

    public final void c(int progress) {
        this.curProgress = progress;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        super.dispatchDraw(canvas);
        a(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressIcon(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressIcon(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.curProgress = -1;
        this.viewSize = ViewUtils.dpToPx(24.0f);
        this.offset = ViewUtils.dpToPx(1.0f);
        this.progressWidth = ViewUtils.dpToPx(2.0f);
        this.progressPaint = b(a.f().g(getContext(), R.color.qui_common_brand_standard, 1000));
        setWillNotDraw(false);
    }
}
