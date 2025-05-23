package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000  2\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/timi/game/ui/widget/CommonButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "Landroid/graphics/Paint;", tl.h.F, "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Path;", "i", "Landroid/graphics/Path;", "mClipPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mDrawPath", "Landroid/graphics/RectF;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/RectF;", "mRectF", "", "e", "()Z", "isBelowOMR1", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class CommonButton extends AppCompatTextView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RectF mRectF;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mClipPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mDrawPath;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonButton(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final boolean e() {
        if (Build.VERSION.SDK_INT <= 27) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void draw(@Nullable Canvas canvas) {
        this.mRectF.setEmpty();
        this.mDrawPath.reset();
        this.mClipPath.reset();
        this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        float min = Math.min(getWidth(), getHeight()) / 2;
        if (e()) {
            if (canvas != null) {
                canvas.saveLayer(this.mRectF, null, 31);
            }
            super.draw(canvas);
            this.mClipPath.addRoundRect(this.mRectF, min, min, Path.Direction.CW);
            if (canvas != null) {
                canvas.drawPath(this.mClipPath, this.mPaint);
            }
        } else {
            if (canvas != null) {
                canvas.saveLayer(this.mRectF, null);
            }
            super.draw(canvas);
            this.mDrawPath.addRoundRect(this.mRectF, min, min, Path.Direction.CW);
            this.mClipPath.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
            this.mClipPath.op(this.mDrawPath, Path.Op.DIFFERENCE);
            if (canvas != null) {
                canvas.drawPath(this.mClipPath, this.mPaint);
            }
        }
        if (canvas != null) {
            canvas.restore();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonButton(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ CommonButton(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonButton(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        PorterDuffXfermode porterDuffXfermode;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Paint paint = new Paint();
        if (e()) {
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        }
        paint.setXfermode(porterDuffXfermode);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        this.mPaint = paint;
        this.mClipPath = new Path();
        this.mDrawPath = new Path();
        this.mRectF = new RectF();
    }
}
