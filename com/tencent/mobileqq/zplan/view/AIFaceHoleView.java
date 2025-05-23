package com.tencent.mobileqq.zplan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010@J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010%\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\rR\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\rR\u0014\u00101\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010\rR\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/AIFaceHoleView;", "Landroid/view/View;", "", "w", tl.h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "I", "leftMargin", "e", "MAX_WIDTH", "f", "currentWidth", "currentHeight", "i", "strokeW", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "getCircleBottom", "()F", "setCircleBottom", "(F)V", "circleBottom", "Landroid/graphics/Paint;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Paint;", "p", "D", "ringP", "E", "bgP", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/LinearGradient;", "G", "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "H", "color1", "color2", "J", "color3", "", "K", "[I", "colorArray", "", "L", "[F", "posArray", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIFaceHoleView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private final Paint p;

    /* renamed from: D, reason: from kotlin metadata */
    private final Paint ringP;

    /* renamed from: E, reason: from kotlin metadata */
    private final Paint bgP;

    /* renamed from: F, reason: from kotlin metadata */
    private RectF rectF;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearGradient linearGradient;

    /* renamed from: H, reason: from kotlin metadata */
    private final int color1;

    /* renamed from: I, reason: from kotlin metadata */
    private final int color2;

    /* renamed from: J, reason: from kotlin metadata */
    private final int color3;

    /* renamed from: K, reason: from kotlin metadata */
    private final int[] colorArray;

    /* renamed from: L, reason: from kotlin metadata */
    private final float[] posArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int leftMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int MAX_WIDTH;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int strokeW;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float circleBottom;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIFaceHoleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float coerceAtMost;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i3 = this.currentWidth;
        if (i3 == 0) {
            i3 = getMeasuredWidth();
        }
        int i16 = this.currentHeight;
        if (i16 == 0) {
            i16 = getMeasuredHeight();
        }
        if (this.linearGradient == null) {
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i16, this.colorArray, this.posArray, Shader.TileMode.CLAMP);
            this.linearGradient = linearGradient;
            this.bgP.setShader(linearGradient);
        }
        if (this.rectF == null) {
            this.rectF = new RectF(0.0f, 0.0f, i3, i16);
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        canvas.drawRect(rectF, this.bgP);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 - (this.leftMargin * 2), this.MAX_WIDTH);
        float f16 = i3 / 2;
        float f17 = 2;
        float f18 = coerceAtMost / f17;
        float screenHeight = ((float) ((ScreenUtils.getScreenHeight(getContext()) * 0.65d) / 2)) - f18;
        canvas.drawCircle(f16, getTop() + screenHeight + f18, f18, this.ringP);
        canvas.drawCircle(f16, getTop() + screenHeight + f18, f18 - this.strokeW, this.p);
        this.circleBottom = getTop() + screenHeight + (f18 * f17);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        this.currentWidth = w3;
        this.currentHeight = h16;
        QLog.i("AIFaceHoleView", 1, "onSizeChanged , " + w3 + ", " + h16);
        this.linearGradient = null;
        this.rectF = null;
    }

    public final void setCircleBottom(float f16) {
        this.circleBottom = f16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIFaceHoleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AIFaceHoleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIFaceHoleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leftMargin = UIUtil.dp2px(context, 16.0f);
        this.MAX_WIDTH = UIUtil.dp2px(context, 360.0f);
        this.strokeW = 2;
        Paint paint = new Paint(1);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.p = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.parseColor("#C7C7C7"));
        paint2.setStrokeWidth(2);
        this.ringP = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStrokeWidth(2);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        this.bgP = paint3;
        int parseColor = Color.parseColor("#7fF5F5F5");
        this.color1 = parseColor;
        int parseColor2 = Color.parseColor("#FAF5F5F5");
        this.color2 = parseColor2;
        int parseColor3 = Color.parseColor("#FFF5F5F5");
        this.color3 = parseColor3;
        this.colorArray = new int[]{parseColor, parseColor, parseColor2, parseColor3};
        this.posArray = new float[]{0.0f, 0.5f, 0.7f, 1.0f};
        setLayerType(1, null);
    }
}
