package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.draft.WinkEditStretchedData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001fJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J>\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J8\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkAdaptiveImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/Bitmap;", "bm", "Lkotlin/Pair;", "", "l", "playerWidth", "scaledWidth", "", "scale", "playerHeight", "scaledHeight", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "renderWidth", "renderHeight", "renderFillType", "", "useVerticalPlayer", "setImageBitmap", "isVertical", "setBitmapForFrameFreeze", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAdaptiveImageView extends AppCompatImageView {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f322689m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAdaptiveImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f322689m = new LinkedHashMap();
    }

    private final Pair<Integer, Integer> l(Bitmap bm5) {
        return new Pair<>(Integer.valueOf(bm5.getScaledWidth(getContext().getResources().getDisplayMetrics().densityDpi)), Integer.valueOf(bm5.getScaledHeight(getContext().getResources().getDisplayMetrics().densityDpi)));
    }

    private final void m(int playerWidth, int scaledWidth, float scale, int playerHeight, int scaledHeight, Bitmap bm5) {
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        matrix.postTranslate((playerWidth - (scaledWidth * scale)) * 0.5f, (playerHeight - (scaledHeight * scale)) * 0.5f);
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(matrix);
        setImageBitmap(bm5);
    }

    public static /* synthetic */ void setBitmapForFrameFreeze$default(WinkAdaptiveImageView winkAdaptiveImageView, Bitmap bitmap, int i3, int i16, int i17, int i18, boolean z16, int i19, Object obj) {
        if ((i19 & 32) != 0) {
            z16 = true;
        }
        winkAdaptiveImageView.setBitmapForFrameFreeze(bitmap, i3, i16, i17, i18, z16);
    }

    public final void setBitmapForFrameFreeze(@NotNull Bitmap bm5, int playerWidth, int playerHeight, int renderWidth, int renderHeight, boolean isVertical) {
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(bm5, "bm");
        Pair<Integer, Integer> l3 = l(bm5);
        int intValue = l3.component1().intValue();
        int intValue2 = l3.component2().intValue();
        if (isVertical) {
            f16 = playerWidth * 1.0f;
            f17 = intValue;
        } else {
            f16 = renderHeight * 1.0f;
            f17 = intValue2;
        }
        m(playerWidth, intValue, f16 / f17, playerHeight, intValue2, bm5);
    }

    public final void setImageBitmap(@NotNull Bitmap bm5, int renderWidth, int renderHeight, int playerWidth, int playerHeight, int renderFillType, boolean useVerticalPlayer) {
        boolean z16;
        float g16;
        Intrinsics.checkNotNullParameter(bm5, "bm");
        Pair<Integer, Integer> l3 = l(bm5);
        int intValue = l3.component1().intValue();
        int intValue2 = l3.component2().intValue();
        float f16 = intValue;
        Pair<WinkVideoTavCut.RenderSizeAndOriginSize, WinkEditStretchedData> a16 = com.tencent.mobileqq.wink.editor.util.f.f322633a.a(renderFillType, playerWidth, playerHeight, f16, intValue2);
        if (renderHeight == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            float f17 = renderWidth;
            if (Math.abs((f17 / r2) - (intValue / intValue2)) >= 0.01d) {
                if (useVerticalPlayer) {
                    f17 = playerWidth;
                }
                g16 = (f17 * 1.0f) / f16;
                m(playerWidth, intValue, g16, playerHeight, intValue2, bm5);
            }
        }
        g16 = a16.getFirst().g();
        m(playerWidth, intValue, g16, playerHeight, intValue2, bm5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAdaptiveImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f322689m = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAdaptiveImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f322689m = new LinkedHashMap();
    }
}
