package com.tencent.mobileqq.guild.discoveryv2.content.view;

import android.content.Context;
import android.content.res.TypedArray;
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
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import up1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/BorderRoundImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "cornerRadius", "", "setCornerRadius", "", NodeProps.BORDER_COLOR, "setBorderColor", NodeProps.BORDER_WIDTH, "setBorderWidth", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "I", "D", "E", "backGroundColor", "innerPadding", "G", "innerRadius", "Landroid/graphics/Paint;", "H", "Landroid/graphics/Paint;", "borderPaint", "backgroundPaint", "Landroid/graphics/Path;", "J", "Landroid/graphics/Path;", "borderPath", "Landroid/graphics/RectF;", "K", "Landroid/graphics/RectF;", "borderRect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BorderRoundImageView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private int borderColor;

    /* renamed from: D, reason: from kotlin metadata */
    private float borderWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private int backGroundColor;

    /* renamed from: F, reason: from kotlin metadata */
    private float innerPadding;

    /* renamed from: G, reason: from kotlin metadata */
    private float innerRadius;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Paint borderPaint;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Paint backgroundPaint;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Path borderPath;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final RectF borderRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float cornerRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderRoundImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = this.borderRect;
        float f16 = this.innerPadding;
        rectF.set(f16, f16, getWidth() - this.innerPadding, getHeight() - this.innerPadding);
        this.borderPath.reset();
        Path path = this.borderPath;
        RectF rectF2 = this.borderRect;
        float f17 = this.innerRadius;
        path.addRoundRect(rectF2, f17, f17, Path.Direction.CW);
        RectF rectF3 = this.borderRect;
        float f18 = this.cornerRadius;
        canvas.drawRoundRect(rectF3, f18, f18, this.backgroundPaint);
        int save = canvas.save();
        canvas.clipPath(this.borderPath);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        RectF rectF4 = this.borderRect;
        float f19 = this.cornerRadius;
        canvas.drawRoundRect(rectF4, f19, f19, this.borderPaint);
    }

    public final void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        this.borderPaint.setColor(borderColor);
    }

    public final void setBorderWidth(float borderWidth) {
        this.innerPadding = borderWidth;
        this.borderWidth = borderWidth;
        this.borderPaint.setStrokeWidth(borderWidth);
    }

    public final void setCornerRadius(float cornerRadius) {
        boolean z16;
        if (this.innerRadius == this.cornerRadius) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.innerRadius = cornerRadius;
        }
        this.cornerRadius = cornerRadius;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderRoundImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BorderRoundImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderRoundImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.borderColor = -16777216;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        this.borderPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        this.backgroundPaint = paint2;
        this.borderPath = new Path();
        this.borderRect = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.E);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ble.BorderRoundImageView)");
        try {
            try {
                this.cornerRadius = obtainStyledAttributes.getDimension(a.I, 0.0f);
                this.borderColor = obtainStyledAttributes.getColor(a.G, -16777216);
                this.borderWidth = obtainStyledAttributes.getDimension(a.H, 0.0f);
                this.backGroundColor = obtainStyledAttributes.getColor(a.F, 0);
                this.innerPadding = obtainStyledAttributes.getDimension(a.J, this.borderWidth);
                this.innerRadius = obtainStyledAttributes.getDimension(a.K, this.cornerRadius);
            } catch (Exception e16) {
                QLog.e("BorderRoundImageView", 1, "Error " + e16);
            }
            obtainStyledAttributes.recycle();
            this.borderPaint.setColor(this.borderColor);
            this.borderPaint.setStrokeWidth(this.borderWidth);
            this.borderPaint.setAntiAlias(true);
            this.backgroundPaint.setColor(this.backGroundColor);
            this.backgroundPaint.setAntiAlias(true);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }
}
