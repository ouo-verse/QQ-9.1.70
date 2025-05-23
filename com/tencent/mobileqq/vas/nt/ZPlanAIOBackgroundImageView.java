package com.tencent.mobileqq.vas.nt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0014R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/nt/ZPlanAIOBackgroundImageView;", "Landroid/widget/ImageView;", "", "newTranslationY", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", UserInfo.SEX_FEMALE, "translateY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ZPlanAIOBackgroundImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float translateY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanAIOBackgroundImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(float newTranslationY) {
        this.translateY = newTranslationY;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                float intrinsicHeight = drawable2.getIntrinsicHeight();
                float width = getWidth();
                int height = getHeight();
                boolean z18 = false;
                if (width == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && height != 0) {
                    if (intrinsicWidth == 0.0f) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        if (intrinsicHeight == 0.0f) {
                            z18 = true;
                        }
                        if (!z18) {
                            float f16 = width / intrinsicWidth;
                            Matrix matrix = new Matrix();
                            matrix.setScale(f16, f16);
                            matrix.postTranslate(0.0f, this.translateY + (height - (intrinsicHeight * f16)));
                            canvas.save();
                            canvas.concat(matrix);
                            try {
                                super.onDraw(canvas);
                            } catch (Throwable th5) {
                                QLog.e("ZPlanAIOBackgroundImageView", 1, "draw background exception,", th5);
                            }
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getDrawable() != null) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            setMeasuredDimension(size, (int) ((size / r0.getIntrinsicWidth()) * r0.getIntrinsicHeight()));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanAIOBackgroundImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanAIOBackgroundImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanAIOBackgroundImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
