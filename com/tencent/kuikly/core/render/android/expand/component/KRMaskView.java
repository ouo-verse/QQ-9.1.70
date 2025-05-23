package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J0\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010(R\u0014\u0010,\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRMaskView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "L", "", "N", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "K", "", "propValue", "M", "", "propKey", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "child", "target", "onDescendantInvalidated", "changed", "", "left", "top", "right", "bottom", "onLayout", "H", "Landroid/graphics/Bitmap;", "maskBitmap", "I", "Z", "maskBitmapInvalidated", "Landroid/graphics/Paint;", "J", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/PorterDuffXfermode;", "Landroid/graphics/PorterDuffXfermode;", "porterDuffXferMode", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRMaskView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private Bitmap maskBitmap;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean maskBitmapInvalidated;

    /* renamed from: J, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: K, reason: from kotlin metadata */
    private final PorterDuffXfermode porterDuffXferMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRMaskView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(1);
        this.porterDuffXferMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        M(0);
    }

    private final Bitmap K(View view) {
        int h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(this);
        int g16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(this);
        if (h16 > 0 && g16 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(h16, g16, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return null;
    }

    private final boolean L() {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, true);
        if ((equals || Intrinsics.areEqual(DeviceInfoMonitor.getModel(), "HLK-AL00")) && Build.VERSION.SDK_INT == 29) {
            return true;
        }
        return false;
    }

    private final boolean M(Object propValue) {
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                setLayerType(2, null);
            } else {
                setLayerType(1, null);
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void N() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setVisibility(0);
            Bitmap bitmap = this.maskBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.maskBitmap = K(childAt);
            childAt.setVisibility(8);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (propKey.hashCode() == -610439601 && propKey.equals("renderingMode")) {
            return M(propValue);
        }
        return super.b(propKey, propValue);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.maskBitmapInvalidated) {
            N();
            this.maskBitmapInvalidated = false;
        }
        Bitmap bitmap = this.maskBitmap;
        if (bitmap != null) {
            this.paint.setXfermode(this.porterDuffXferMode);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
            this.paint.setXfermode(null);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(@NotNull View child, @NotNull View target) {
        View childAt;
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onDescendantInvalidated(child, target);
        if (!this.maskBitmapInvalidated && (childAt = getChildAt(0)) != null) {
            if (L()) {
                this.maskBitmapInvalidated = true;
                invalidate();
            } else if (childAt == child) {
                this.maskBitmapInvalidated = true;
                invalidate();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            this.maskBitmapInvalidated = true;
        }
    }
}
