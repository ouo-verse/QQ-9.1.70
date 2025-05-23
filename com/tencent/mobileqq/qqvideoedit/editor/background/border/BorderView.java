package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditContainerView;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.EditViewTransform;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\fH\u0016J\u0011\u0010\"\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010(R\u0016\u0010+\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010-R\u0014\u00100\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010/R\u001a\u00104\u001a\u00020\f8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u00103R\"\u0010;\u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010E\u001a\u00020\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/BorderView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", "Landroid/widget/FrameLayout;", "", "k", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "i", "", HippyTKDListViewAdapter.X, "y", "Landroid/graphics/PointF;", "g", "degree", "c", "(F)Ljava/lang/Float;", "e", "getMaxScale", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/e;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/a;", "j", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "transform", "a", "Landroid/graphics/RectF;", "d", "", "active", "setActive", "isActive", "getCenter", "f", h.F, "()Ljava/lang/Float;", "", "[F", "adsorptionDegrees", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "borderPaint", "Landroid/graphics/PointF;", "position", "Landroid/util/Size;", "Landroid/util/Size;", "size", "Landroid/graphics/RectF;", "borderRectF", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getCenterPointF", "()Landroid/graphics/PointF;", "centerPointF", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "getRotate", "()F", "setRotate", "(F)V", CanvasView.ACTION_ROTATE, "D", "getScale", "setScale", "scale", "Landroid/graphics/Matrix;", "E", "Landroid/graphics/Matrix;", "stickerMatrix", "Z", "isActived", "()Z", "setActived", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class BorderView extends FrameLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private float rotate;

    /* renamed from: D, reason: from kotlin metadata */
    private float scale;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Matrix stickerMatrix;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isActived;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] adsorptionDegrees;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Paint borderPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF position;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Size size;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF borderRectF;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF centerPointF;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k() {
        Paint paint = this.borderPaint;
        if (paint != null) {
            paint.setStrokeWidth(j().getWidth() / this.scale);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    public void a(@NotNull EditViewTransform transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.position = transform.getPosition();
        this.size = transform.getSize();
        this.rotate = transform.getRotation();
        this.scale = transform.getScale();
        this.centerPointF.x = this.position.x + (this.size.getWidth() / 2);
        this.centerPointF.y = this.position.y + (this.size.getHeight() / 2);
        invalidate();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @Nullable
    public e b() {
        e eVar = new e();
        EditContainerView.Companion companion = EditContainerView.INSTANCE;
        eVar.f(companion.c());
        eVar.g(companion.a());
        eVar.i(companion.d());
        eVar.j(companion.a());
        eVar.h(getContext().getColor(R.color.f158017al3));
        return eVar;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @Nullable
    public Float c(float degree) {
        for (float f16 : this.adsorptionDegrees) {
            if (Math.abs(degree - f16) < 2.0f) {
                return Float.valueOf(f16);
            }
        }
        return Float.valueOf(degree);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @Nullable
    public RectF d() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        i(canvas);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    public float e() {
        return 0.2f;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @Nullable
    public PointF f() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @Nullable
    public PointF g(float x16, float y16) {
        PointF pointF = new PointF(x16, y16);
        int width = this.size.getWidth();
        Intrinsics.checkNotNull(getParent(), "null cannot be cast to non-null type android.view.ViewGroup");
        float abs = Math.abs(x16 + ((width - ((ViewGroup) r2).getWidth()) / 2));
        EditContainerView.Companion companion = EditContainerView.INSTANCE;
        if (abs < companion.b()) {
            Intrinsics.checkNotNull(getParent(), "null cannot be cast to non-null type android.view.ViewGroup");
            pointF.x = (((ViewGroup) r5).getWidth() - this.size.getWidth()) / 2;
        }
        int height = this.size.getHeight();
        Intrinsics.checkNotNull(getParent(), "null cannot be cast to non-null type android.view.ViewGroup");
        if (Math.abs(y16 + ((height - ((ViewGroup) r2).getHeight()) / 2)) < companion.b()) {
            Intrinsics.checkNotNull(getParent(), "null cannot be cast to non-null type android.view.ViewGroup");
            pointF.y = (((ViewGroup) r5).getHeight() - this.size.getHeight()) / 2;
        }
        return pointF;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @NotNull
    /* renamed from: getCenter, reason: from getter */
    public PointF getCenterPointF() {
        return this.centerPointF;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    public float getMaxScale() {
        return 2.0f;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    @Nullable
    public Float h() {
        return null;
    }

    protected void i(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.isActived) {
            return;
        }
        if (this.borderPaint == null) {
            Paint paint = new Paint();
            this.borderPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            BorderStyle j3 = j();
            Paint paint2 = this.borderPaint;
            if (paint2 != null) {
                paint2.setColor(j3.getColor());
            }
            Paint paint3 = this.borderPaint;
            if (paint3 != null) {
                paint3.setStrokeWidth(j3.getWidth());
            }
        }
        canvas.save();
        Matrix matrix = this.stickerMatrix;
        matrix.reset();
        float width = this.position.x + (this.size.getWidth() / 2);
        float height = this.position.y + (this.size.getHeight() / 2);
        matrix.postRotate(this.rotate, width, height);
        float f16 = this.scale;
        matrix.postScale(f16, f16, width, height);
        canvas.concat(this.stickerMatrix);
        RectF rectF = this.borderRectF;
        float f17 = this.position.x;
        rectF.left = f17;
        rectF.right = f17 + this.size.getWidth();
        float f18 = this.position.y;
        rectF.top = f18;
        rectF.bottom = f18 + this.size.getHeight();
        k();
        RectF rectF2 = this.borderRectF;
        Paint paint4 = this.borderPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawRect(rectF2, paint4);
        canvas.restore();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    /* renamed from: isActive, reason: from getter */
    public boolean getIsActived() {
        return this.isActived;
    }

    @NotNull
    public BorderStyle j() {
        return new BorderStyle(-1, com.tencent.videocut.utils.e.f384236a.a(5.0f));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.c
    public void setActive(boolean active) {
        this.isActived = active;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BorderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adsorptionDegrees = new float[]{0.0f, 45.0f, 90.0f, 135.0f, 180.0f, 225.0f, 270.0f, 315.0f, 360.0f};
        this.position = new PointF();
        this.size = new Size(0, 0);
        this.borderRectF = new RectF();
        this.centerPointF = new PointF();
        this.scale = 1.0f;
        this.stickerMatrix = new Matrix();
    }
}
