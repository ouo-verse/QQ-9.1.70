package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\bR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\b\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/view/ShadowFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "d", "I", "shadowTopLeftRadius", "e", "shadowTopRightRadius", "f", "shadowBottomLeftRadius", tl.h.F, "shadowBottomRightRadius", "i", "shadowLeftBreadth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "shadowTopBreadth", BdhLogUtil.LogTag.Tag_Conn, "shadowRightBreadth", "D", "shadowBottomBreadth", "E", NodeProps.SHADOW_OFFSET_X, UserInfo.SEX_FEMALE, NodeProps.SHADOW_OFFSET_Y, "G", "shadowBackgroundColor", "H", "shadowBreadthColor", "shadowBlur", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ShadowFrameLayout extends FrameLayout {
    private static final int L = R.color.f157952an2;
    private static final int M = R.color.f158017al3;

    /* renamed from: C, reason: from kotlin metadata */
    private int shadowRightBreadth;

    /* renamed from: D, reason: from kotlin metadata */
    private int shadowBottomBreadth;

    /* renamed from: E, reason: from kotlin metadata */
    private int shadowOffsetX;

    /* renamed from: F, reason: from kotlin metadata */
    private int shadowOffsetY;

    /* renamed from: G, reason: from kotlin metadata */
    private int shadowBackgroundColor;

    /* renamed from: H, reason: from kotlin metadata */
    private int shadowBreadthColor;

    /* renamed from: I, reason: from kotlin metadata */
    private int shadowBlur;

    @NotNull
    public Map<Integer, View> J;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int shadowTopLeftRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int shadowTopRightRadius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int shadowBottomLeftRadius;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int shadowBottomRightRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int shadowLeftBreadth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int shadowTopBreadth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float width = getWidth() - getPaddingRight();
        float height = getHeight() - getPaddingBottom();
        RectF rectF = new RectF();
        Path path = new Path();
        rectF.set(paddingLeft, paddingTop, width, height);
        path.reset();
        path.moveTo(this.shadowTopLeftRadius + paddingLeft, paddingTop);
        path.lineTo(width - this.shadowTopRightRadius, paddingTop);
        path.quadTo(width, paddingTop, width, this.shadowTopRightRadius + paddingTop);
        path.lineTo(width, this.shadowTopRightRadius + paddingTop);
        path.lineTo(width, height - this.shadowBottomRightRadius);
        path.quadTo(width, height, width - this.shadowBottomRightRadius, height);
        path.lineTo(width - this.shadowBottomRightRadius, height);
        path.lineTo(this.shadowBottomLeftRadius + paddingLeft, height);
        path.quadTo(paddingLeft, height, paddingLeft, height - this.shadowBottomLeftRadius);
        path.lineTo(paddingLeft, height - this.shadowBottomLeftRadius);
        path.lineTo(paddingLeft, this.shadowTopLeftRadius + paddingTop);
        path.quadTo(paddingLeft, paddingTop, this.shadowTopLeftRadius + paddingLeft, paddingTop);
        path.close();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(this.shadowBackgroundColor);
        paint.setShadowLayer(this.shadowBlur, this.shadowOffsetX, this.shadowOffsetY, this.shadowBreadthColor);
        if (canvas != null) {
            canvas.drawPath(path, paint);
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.J = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.f323092a7);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.ShadowFrameLayout)");
        this.shadowTopLeftRadius = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323231m7, 0);
        this.shadowTopRightRadius = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323242n7, 0);
        this.shadowBottomLeftRadius = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323140e7, 0);
        this.shadowBottomRightRadius = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323152f7, 0);
        this.shadowLeftBreadth = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323176h7, 5);
        this.shadowTopBreadth = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323220l7, 5);
        this.shadowRightBreadth = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323209k7, 5);
        this.shadowBottomBreadth = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323128d7, 5);
        this.shadowOffsetX = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323187i7, 0);
        this.shadowOffsetY = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323198j7, 0);
        this.shadowBackgroundColor = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.f323104b7, getContext().getColor(M));
        this.shadowBreadthColor = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.f323164g7, getContext().getColor(L));
        this.shadowBlur = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.f323116c7, 10);
        obtainStyledAttributes.recycle();
        setPadding(this.shadowLeftBreadth, this.shadowTopBreadth, this.shadowRightBreadth, this.shadowBottomBreadth);
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public /* synthetic */ ShadowFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
