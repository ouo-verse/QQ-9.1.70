package com.tencent.guild.aio.util.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001<B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109B#\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u0010:\u001a\u00020\b\u00a2\u0006\u0004\b5\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010/\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006="}, d2 = {"Lcom/tencent/guild/aio/util/ui/RoundBubbleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "radius", "", "color", "o", "dp", "Landroid/content/res/Resources;", "res", "l", "init", "setRadiusDP", "", "rectRadius", "setRadii", "draw", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mRectF", BdhLogUtil.LogTag.Tag_Conn, "[F", "mRadiusList", "Landroid/graphics/Path;", "D", "Landroid/graphics/Path;", "mPath", "E", "I", "getMBorderThickness", "()I", "setMBorderThickness", "(I)V", "mBorderThickness", UserInfo.SEX_FEMALE, "getMBorderInsideColor", "setMBorderInsideColor", "mBorderInsideColor", "G", "getSpace", "()F", "setSpace", "(F)V", "space", "H", "Landroid/content/res/Resources;", "mRes", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RoundBubbleImageView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private float[] mRadiusList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: E, reason: from kotlin metadata */
    private int mBorderThickness;

    /* renamed from: F, reason: from kotlin metadata */
    private int mBorderInsideColor;

    /* renamed from: G, reason: from kotlin metadata */
    private float space;

    /* renamed from: H, reason: from kotlin metadata */
    private Resources mRes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mRectF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundBubbleImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        this.mBorderInsideColor = -1;
        init();
    }

    private final int l(float dp5, Resources res) {
        return (int) ((res.getDisplayMetrics().density * dp5) + 0.5f);
    }

    private final void m(Canvas canvas) {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(getMeasuredHeight(), getMeasuredWidth());
        o(canvas, (coerceAtMost / 2.0f) - this.mBorderThickness, this.mBorderInsideColor);
    }

    private final void o(Canvas canvas, float radius, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.mBorderThickness);
        float measuredWidth = getMeasuredWidth() / 2.0f;
        canvas.drawCircle(measuredWidth, measuredWidth, radius, paint);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mBorderThickness > 0) {
            m(canvas);
        }
        float f16 = 2;
        float width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.space * f16);
        float height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (f16 * this.space);
        this.mRectF.left = getPaddingLeft() + this.space;
        this.mRectF.top = getPaddingTop() + this.space;
        this.mRectF.right = getPaddingLeft() + this.space + width;
        this.mRectF.bottom = getPaddingTop() + this.space + height;
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.mRadiusList, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public final void init() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        this.mRes = resources;
    }

    public final void setMBorderInsideColor(int i3) {
        this.mBorderInsideColor = i3;
    }

    public final void setMBorderThickness(int i3) {
        this.mBorderThickness = i3;
    }

    public final void setRadii(@NotNull float[] rectRadius) {
        Intrinsics.checkNotNullParameter(rectRadius, "rectRadius");
        this.mRadiusList = rectRadius;
    }

    public final void setRadiusDP(float radius) {
        Resources resources = this.mRes;
        if (resources == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRes");
            resources = null;
        }
        Arrays.fill(this.mRadiusList, l(radius, resources));
    }

    public final void setSpace(float f16) {
        this.space = f16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundBubbleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        this.mBorderInsideColor = -1;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundBubbleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        this.mBorderInsideColor = -1;
        init();
    }
}
