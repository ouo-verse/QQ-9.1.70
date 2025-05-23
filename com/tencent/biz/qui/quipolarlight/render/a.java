package com.tencent.biz.qui.quipolarlight.render;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Size;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0015\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0002J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/render/a;", "", "", "value", "", NodeProps.COLORS, "", "a", "image", "Lcom/tencent/biz/qui/quipolarlight/a;", "gradient", "", "b", "Lcom/tencent/biz/qui/quipolarlight/a$b;", "e", "", "c", "time", "frequency", "Landroid/graphics/Bitmap;", "d", "Landroid/util/Size;", "renderSize", "f", "Landroid/util/Size;", "mRenderSize", "Lcom/tencent/biz/qui/quipolarlight/b;", "Lcom/tencent/biz/qui/quipolarlight/b;", "noiseCreator", "Landroid/graphics/Bitmap;", "renderBitmap", "imageSize", "<init>", "(Landroid/util/Size;)V", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Size mRenderSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.biz.qui.quipolarlight.b noiseCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Bitmap renderBitmap;

    public a(@NotNull Size imageSize) {
        Intrinsics.checkNotNullParameter(imageSize, "imageSize");
        this.mRenderSize = imageSize;
        this.noiseCreator = new com.tencent.biz.qui.quipolarlight.b();
        Bitmap createBitmap = Bitmap.createBitmap(this.mRenderSize.getWidth(), this.mRenderSize.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(mRen\u2026 Bitmap.Config.ARGB_8888)");
        this.renderBitmap = createBitmap;
    }

    private final int a(float value, int[] colors) {
        float f16;
        float f17;
        float f18;
        float f19 = 1;
        float f26 = (value + f19) / 2;
        int length = colors.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                float f27 = i3;
                float length2 = f27 / (colors.length - 1);
                float length3 = (f27 + f19) / (colors.length - 1);
                if (f26 < length3) {
                    int i16 = i3 + 1;
                    float f28 = f26 - length2;
                    float f29 = length3 - length2;
                    f16 = Color.red(colors[i3]) + (((Color.red(colors[i16]) - Color.red(colors[i3])) * f28) / f29);
                    f17 = Color.green(colors[i3]) + (((Color.green(colors[i16]) - Color.green(colors[i3])) * f28) / f29);
                    f18 = Color.blue(colors[i3]) + (((Color.blue(colors[i16]) - Color.blue(colors[i3])) * f28) / f29);
                    break;
                }
                i3++;
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
                f18 = 0.0f;
                break;
            }
        }
        return Color.rgb((int) f16, (int) f17, (int) f18);
    }

    private final void b(int[] image, com.tencent.biz.qui.quipolarlight.a gradient) {
        if (!(gradient instanceof a.C0951a) && (gradient instanceof a.b)) {
            e(image, (a.b) gradient);
        }
    }

    private final double c(double value) {
        double d16 = 1;
        return (Math.exp((-2) * value) - d16) / (Math.exp(-2.0d) - d16);
    }

    private final void e(int[] image, a.b gradient) {
        int height = this.mRenderSize.getHeight();
        int width = this.mRenderSize.getWidth();
        for (int i3 = 0; i3 < height; i3++) {
            for (int i16 = 0; i16 < width; i16++) {
                int i17 = (i3 * width) + i16;
                int i18 = image[i17];
                int red = Color.red(i18);
                int green = Color.green(i18);
                int blue = Color.blue(i18);
                int alpha = Color.alpha(i18);
                float f16 = width;
                float f17 = i16;
                float f18 = height;
                float f19 = i3;
                double startAlpha = (1 - gradient.getStartAlpha()) + ((gradient.getStartAlpha() - gradient.getEndAlpha()) * c(((((gradient.getCenterX() * f16) - f17) * ((gradient.getCenterX() * f16) - f17)) + (((gradient.getCenterY() * f18) - f19) * ((gradient.getCenterY() * f18) - f19))) / (((gradient.getRadius() * f16) * gradient.getRadius()) * f16)));
                if (startAlpha > 1) {
                    startAlpha = 1.0d;
                }
                image[i17] = Color.argb((int) ((1.0d - startAlpha) * alpha), red, green, blue);
            }
        }
    }

    @NotNull
    public final Bitmap d(float time, @NotNull int[] colors, float frequency, @Nullable com.tencent.biz.qui.quipolarlight.a gradient) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        int width = this.mRenderSize.getWidth();
        int height = this.mRenderSize.getHeight();
        if (this.noiseCreator.getFrequency() != frequency) {
            this.noiseCreator.h(frequency);
        }
        int[] iArr = new int[width * height];
        for (int i3 = 0; i3 < width; i3++) {
            for (int i16 = 0; i16 < height; i16++) {
                iArr[(i3 * width) + i16] = a(this.noiseCreator.c(i3, i16, time), colors);
            }
        }
        if (gradient instanceof a.b) {
            b(iArr, gradient);
        }
        this.renderBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return this.renderBitmap;
    }

    public final void f(@NotNull Size renderSize) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        this.mRenderSize = renderSize;
        Bitmap createBitmap = Bitmap.createBitmap(renderSize.getWidth(), this.mRenderSize.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(mRen\u2026 Bitmap.Config.ARGB_8888)");
        this.renderBitmap = createBitmap;
    }
}
