package com.tencent.mobileqq.matchfriend.reborn.publish.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0010\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0007\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/guide/QQStrangerFeedPublishGuideBubbleView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "d", UserInfo.SEX_FEMALE, "cornerRadius", "e", "triangleHeight", "f", "triangleWidth", h.F, "borderStrokeWidth", "", "i", "I", "color1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "color2", BdhLogUtil.LogTag.Tag_Conn, "color3", "Landroid/graphics/RadialGradient;", "D", "Lkotlin/Lazy;", "()Landroid/graphics/RadialGradient;", "gradientShader", "Landroid/graphics/Paint;", "E", "Landroid/graphics/Paint;", "borderPaint", "fillPaint", "Landroid/graphics/Path;", "G", "Landroid/graphics/Path;", "borderPath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerFeedPublishGuideBubbleView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int color3;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy gradientShader;

    /* renamed from: E, reason: from kotlin metadata */
    private final Paint borderPaint;

    /* renamed from: F, reason: from kotlin metadata */
    private final Paint fillPaint;

    /* renamed from: G, reason: from kotlin metadata */
    private final Path borderPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float cornerRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float triangleHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float triangleWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float borderStrokeWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int color1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int color2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedPublishGuideBubbleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final RadialGradient d() {
        return (RadialGradient) this.gradientShader.getValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight() - this.triangleHeight;
        Path path = this.borderPath;
        path.reset();
        path.moveTo(0.0f, this.cornerRadius);
        float f16 = this.cornerRadius;
        float f17 = 2;
        path.arcTo(0.0f, 0.0f, f16 * f17, f16 * f17, 180.0f, 90.0f, false);
        path.lineTo(width - this.cornerRadius, 0.0f);
        float f18 = this.cornerRadius;
        path.arcTo(width - (f18 * f17), 0.0f, width, f18 * f17, 270.0f, 90.0f, false);
        path.lineTo(width, height - (this.cornerRadius * f17));
        float f19 = this.cornerRadius;
        path.arcTo(width - (f19 * f17), height - (f19 * f17), width, height, 0.0f, 90.0f, false);
        path.lineTo((this.triangleWidth + width) / f17, height);
        path.lineTo(width / f17, getHeight());
        path.lineTo((width - this.triangleWidth) / f17, height);
        path.lineTo(this.cornerRadius, height);
        float f26 = this.cornerRadius;
        path.arcTo(0.0f, height - (f26 * f17), f26 * f17, height, 90.0f, 90.0f, false);
        path.close();
        if (canvas != null) {
            canvas.drawPath(this.borderPath, this.fillPaint);
        }
        this.borderPaint.setShader(d());
        if (canvas != null) {
            canvas.drawPath(this.borderPath, this.borderPaint);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedPublishGuideBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QQStrangerFeedPublishGuideBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedPublishGuideBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.cornerRadius = l.a(16.0f);
        float a16 = l.a(7.0f);
        this.triangleHeight = a16;
        this.triangleWidth = l.a(12.5f);
        this.borderStrokeWidth = l.a(1.0f);
        this.color1 = Color.parseColor("#6F57FF");
        this.color2 = Color.parseColor("#CB69FF");
        this.color3 = Color.parseColor("#FF9254");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RadialGradient>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.guide.QQStrangerFeedPublishGuideBubbleView$gradientShader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RadialGradient invoke() {
                int i16;
                int i17;
                int i18;
                float width = 1.4f * QQStrangerFeedPublishGuideBubbleView.this.getWidth();
                i16 = QQStrangerFeedPublishGuideBubbleView.this.color1;
                i17 = QQStrangerFeedPublishGuideBubbleView.this.color2;
                i18 = QQStrangerFeedPublishGuideBubbleView.this.color3;
                return new RadialGradient(0.0f, 0.0f, width, new int[]{i16, i17, i18}, new float[]{0.0f, 0.56f, 0.9f}, Shader.TileMode.CLAMP);
            }
        });
        this.gradientShader = lazy;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(l.b(1));
        this.borderPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(context.getResources().getColor(R.color.qui_common_bg_top_light, null));
        this.fillPaint = paint2;
        this.borderPath = new Path();
        super.setWillNotDraw(false);
        setPadding(0, 0, 0, (int) a16);
    }
}
