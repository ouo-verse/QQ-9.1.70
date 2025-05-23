package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001c\u00a2\u0006\u0004\b;\u0010!JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002J\u001b\u0010\u0016\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u000bJ;\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R(\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R.\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b1\u00106\u001a\u0004\b/\u00107\"\u0004\b8\u00109\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/ax;", "", "", "width", "height", "", "Lcom/tencent/mobileqq/filemanager/util/a;", "bitmaps", "Lcom/tencent/mobileqq/filemanager/util/ax$a;", "", "bitmapSizePos", "Landroid/graphics/Bitmap;", "b", "(II[Lcom/tencent/mobileqq/filemanager/util/a;[Lcom/tencent/mobileqq/filemanager/util/ax$a;)Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "targetWidth", "targetHeight", "c", "a", "l", "gap", "k", "i", "([Lcom/tencent/mobileqq/filemanager/util/a;)Lcom/tencent/mobileqq/filemanager/util/ax;", "d", "count", "g", "(IIII)[Lcom/tencent/mobileqq/filemanager/util/ax$a;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "I", "getWidth_", "()I", "setWidth_", "(I)V", "width_", "getHeight_", "setHeight_", "height_", "getGap_", "setGap_", "gap_", "e", "[Lcom/tencent/mobileqq/filemanager/util/a;", "f", "()[Lcom/tencent/mobileqq/filemanager/util/a;", "j", "([Lcom/tencent/mobileqq/filemanager/util/a;)V", "bitmaps_", "[Lcom/tencent/mobileqq/filemanager/util/ax$a;", "()[Lcom/tencent/mobileqq/filemanager/util/ax$a;", tl.h.F, "([Lcom/tencent/mobileqq/filemanager/util/ax$a;)V", "bitmapSizePos_", "<init>", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ax {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int width_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int height_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int gap_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public a[] bitmaps_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Quad<Float>[] bitmapSizePos_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0012\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/ax$a;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "width", "b", "height", "c", "posX", "posY", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.filemanager.util.ax$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class Quad<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final T width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final T height;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final T posX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final T posY;

        public Quad(T t16, T t17, T t18, T t19) {
            this.width = t16;
            this.height = t17;
            this.posX = t18;
            this.posY = t19;
        }

        public final T a() {
            return this.height;
        }

        public final T b() {
            return this.posX;
        }

        public final T c() {
            return this.posY;
        }

        public final T d() {
            return this.width;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Quad)) {
                return false;
            }
            Quad quad = (Quad) other;
            if (Intrinsics.areEqual(this.width, quad.width) && Intrinsics.areEqual(this.height, quad.height) && Intrinsics.areEqual(this.posX, quad.posX) && Intrinsics.areEqual(this.posY, quad.posY)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            T t16 = this.width;
            int i3 = 0;
            if (t16 == null) {
                hashCode = 0;
            } else {
                hashCode = t16.hashCode();
            }
            int i16 = hashCode * 31;
            T t17 = this.height;
            if (t17 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = t17.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            T t18 = this.posX;
            if (t18 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = t18.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            T t19 = this.posY;
            if (t19 != null) {
                i3 = t19.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "Quad(width=" + this.width + ", height=" + this.height + ", posX=" + this.posX + ", posY=" + this.posY + ')';
        }
    }

    public ax(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final Bitmap a(Bitmap bitmap, int targetWidth, int targetHeight) {
        float f16;
        float f17;
        Bitmap resultBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f18 = 0.0f;
        if (width * targetHeight > targetWidth * height) {
            f16 = targetWidth / width;
            f17 = (targetHeight - ((int) (height * f16))) / 2.0f;
        } else {
            f18 = (targetWidth - ((int) (width * r12))) / 2.0f;
            f16 = targetHeight / height;
            f17 = 0.0f;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, (Rect) null, new RectF(f18, f17, (width * f16) + f18, (height * f16) + f17), paint);
        Intrinsics.checkNotNullExpressionValue(resultBitmap, "resultBitmap");
        return resultBitmap;
    }

    private final Bitmap b(int width, int height, a[] bitmaps, Quad<Float>[] bitmapSizePos) {
        Bitmap c16;
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawColor(-1);
        Intrinsics.checkNotNull(bitmaps);
        int length = bitmaps.length;
        for (int i3 = 0; i3 < length; i3++) {
            a aVar = bitmaps[i3];
            if (aVar != null) {
                if (aVar.getScaleType() == 1) {
                    c16 = a(bitmaps[i3].getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String(), (int) bitmapSizePos[i3].d().floatValue(), (int) bitmapSizePos[i3].a().floatValue());
                } else {
                    c16 = c(bitmaps[i3].getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String(), (int) bitmapSizePos[i3].d().floatValue(), (int) bitmapSizePos[i3].a().floatValue());
                }
                canvas.drawBitmap(c16, bitmapSizePos[i3].b().floatValue(), bitmapSizePos[i3].c().floatValue(), (Paint) null);
            }
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    private final Bitmap c(Bitmap bitmap, int targetWidth, int targetHeight) {
        int i3;
        int i16;
        float f16 = targetWidth / targetHeight;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f17 = width;
        float f18 = height;
        float f19 = f17 / f18;
        if (f19 > f16) {
            i3 = (int) (f18 * f16);
        } else {
            if (f19 < f16) {
                i16 = (int) (f17 / f16);
                i3 = width;
                int i17 = (width - i3) / 2;
                int i18 = (height - i16) / 2;
                Rect rect = new Rect(i17, i18, i3 + i17, i16 + i18);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height()), targetWidth, targetHeight, true);
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(cropp\u2026idth, targetHeight, true)");
                return createScaledBitmap;
            }
            i3 = width;
        }
        i16 = height;
        int i172 = (width - i3) / 2;
        int i182 = (height - i16) / 2;
        Rect rect2 = new Rect(i172, i182, i3 + i172, i16 + i182);
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, rect2.left, rect2.top, rect2.width(), rect2.height()), targetWidth, targetHeight, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap2, "createScaledBitmap(cropp\u2026idth, targetHeight, true)");
        return createScaledBitmap2;
    }

    @NotNull
    public final Bitmap d() {
        a[] f16 = f();
        Intrinsics.checkNotNull(f16);
        int length = f16.length;
        if (length > 9) {
            length = 9;
        }
        h(g(this.width_, this.height_, this.gap_, length));
        return b(this.width_, this.height_, f(), e());
    }

    @NotNull
    public final Quad<Float>[] e() {
        Quad<Float>[] quadArr = this.bitmapSizePos_;
        if (quadArr != null) {
            return quadArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bitmapSizePos_");
        return null;
    }

    @NotNull
    public final a[] f() {
        a[] aVarArr = this.bitmaps_;
        if (aVarArr != null) {
            return aVarArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bitmaps_");
        return null;
    }

    @NotNull
    public final Quad<Float>[] g(@IntRange(from = 1, to = 9) int width, int height, int gap, int count) {
        Float valueOf = Float.valueOf(0.0f);
        switch (count) {
            case 1:
                return new Quad[]{new Quad<>(Float.valueOf(width), Float.valueOf(height), valueOf, valueOf)};
            case 2:
                float f16 = (width - gap) / 2.0f;
                float f17 = height;
                return new Quad[]{new Quad<>(Float.valueOf(f16), Float.valueOf(f17), valueOf, valueOf), new Quad<>(Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f16 + gap), valueOf)};
            case 3:
                float f18 = (width - gap) / 2.0f;
                float f19 = height;
                float f26 = gap;
                float f27 = (f19 - f26) / 2.0f;
                float f28 = f18 + f26;
                return new Quad[]{new Quad<>(Float.valueOf(f18), Float.valueOf(f19), valueOf, valueOf), new Quad<>(Float.valueOf(f18), Float.valueOf(f27), Float.valueOf(f28), valueOf), new Quad<>(Float.valueOf(f18), Float.valueOf(f27), Float.valueOf(f28), Float.valueOf(f27 + f26))};
            case 4:
                float f29 = (width - gap) / 2.0f;
                float f36 = (height - gap) / 2.0f;
                float f37 = gap;
                float f38 = f29 + f37;
                float f39 = f37 + f36;
                return new Quad[]{new Quad<>(Float.valueOf(f29), Float.valueOf(f36), valueOf, valueOf), new Quad<>(Float.valueOf(f29), Float.valueOf(f36), Float.valueOf(f38), valueOf), new Quad<>(Float.valueOf(f29), Float.valueOf(f36), valueOf, Float.valueOf(f39)), new Quad<>(Float.valueOf(f29), Float.valueOf(f36), Float.valueOf(f38), Float.valueOf(f39))};
            case 5:
                float f46 = (width - gap) / 2.0f;
                float f47 = (width - (gap * 2)) / 3.0f;
                float f48 = (height - gap) / 2.0f;
                float f49 = gap;
                float f56 = f48 + f49;
                return new Quad[]{new Quad<>(Float.valueOf(f46), Float.valueOf(f48), valueOf, valueOf), new Quad<>(Float.valueOf(f46), Float.valueOf(f48), Float.valueOf(f46 + f49), valueOf), new Quad<>(Float.valueOf(f47), Float.valueOf(f48), valueOf, Float.valueOf(f56)), new Quad<>(Float.valueOf(f47), Float.valueOf(f48), Float.valueOf(f47 + f49), Float.valueOf(f56)), new Quad<>(Float.valueOf(f47), Float.valueOf(f48), Float.valueOf((f47 * 2.0f) + (f49 * 2.0f)), Float.valueOf(f56))};
            case 6:
                float f57 = (width - (gap * 2)) / 3.0f;
                float f58 = (height - gap) / 2.0f;
                float f59 = gap;
                float f65 = f57 + f59;
                float f66 = (f57 * 2.0f) + (2.0f * f59);
                float f67 = f59 + f58;
                return new Quad[]{new Quad<>(Float.valueOf(f57), Float.valueOf(f58), valueOf, valueOf), new Quad<>(Float.valueOf(f57), Float.valueOf(f58), Float.valueOf(f65), valueOf), new Quad<>(Float.valueOf(f57), Float.valueOf(f58), Float.valueOf(f66), valueOf), new Quad<>(Float.valueOf(f57), Float.valueOf(f58), valueOf, Float.valueOf(f67)), new Quad<>(Float.valueOf(f57), Float.valueOf(f58), Float.valueOf(f65), Float.valueOf(f67)), new Quad<>(Float.valueOf(f57), Float.valueOf(f58), Float.valueOf(f66), Float.valueOf(f67))};
            case 7:
                float f68 = (width - (gap * 2)) / 3.0f;
                float f69 = (width - (gap * 3)) / 4.0f;
                float f75 = (height - gap) / 2.0f;
                float f76 = gap;
                float f77 = f75 + f76;
                float f78 = f76 * 2.0f;
                return new Quad[]{new Quad<>(Float.valueOf(f68), Float.valueOf(f75), valueOf, valueOf), new Quad<>(Float.valueOf(f68), Float.valueOf(f75), Float.valueOf(f68 + f76), valueOf), new Quad<>(Float.valueOf(f68), Float.valueOf(f75), Float.valueOf((f68 * 2.0f) + f78), valueOf), new Quad<>(Float.valueOf(f69), Float.valueOf(f75), valueOf, Float.valueOf(f77)), new Quad<>(Float.valueOf(f69), Float.valueOf(f75), Float.valueOf(f69 + f76), Float.valueOf(f77)), new Quad<>(Float.valueOf(f69), Float.valueOf(f75), Float.valueOf((2.0f * f69) + f78), Float.valueOf(f77)), new Quad<>(Float.valueOf(f69), Float.valueOf(f75), Float.valueOf((f69 * 3.0f) + (f76 * 3.0f)), Float.valueOf(f77))};
            case 8:
                float f79 = (width - (gap * 3)) / 4.0f;
                float f85 = (height - gap) / 2.0f;
                float f86 = gap;
                float f87 = f79 + f86;
                float f88 = (f79 * 2.0f) + (2.0f * f86);
                float f89 = (f79 * 3.0f) + (3.0f * f86);
                float f95 = f86 + f85;
                return new Quad[]{new Quad<>(Float.valueOf(f79), Float.valueOf(f85), valueOf, valueOf), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), Float.valueOf(f87), valueOf), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), Float.valueOf(f88), valueOf), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), Float.valueOf(f89), valueOf), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), valueOf, Float.valueOf(f95)), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), Float.valueOf(f87), Float.valueOf(f95)), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), Float.valueOf(f88), Float.valueOf(f95)), new Quad<>(Float.valueOf(f79), Float.valueOf(f85), Float.valueOf(f89), Float.valueOf(f95))};
            case 9:
                float f96 = (width - gap) / 2.0f;
                float f97 = ((height - gap) / 3.0f) * 2.0f;
                float f98 = gap;
                float f99 = (f96 - f98) / 2.0f;
                float f100 = height - f97;
                float f101 = (f97 - f98) / 2.0f;
                float f102 = f96 + f98;
                float f103 = f96 + f99 + (2.0f * f98);
                float f104 = f101 + f98;
                float f105 = f97 + f98;
                return new Quad[]{new Quad<>(Float.valueOf(f96), Float.valueOf(f97), valueOf, valueOf), new Quad<>(Float.valueOf(f99), Float.valueOf(f101), Float.valueOf(f102), valueOf), new Quad<>(Float.valueOf(f99), Float.valueOf(f101), Float.valueOf(f103), valueOf), new Quad<>(Float.valueOf(f99), Float.valueOf(f101), Float.valueOf(f102), Float.valueOf(f104)), new Quad<>(Float.valueOf(f99), Float.valueOf(f101), Float.valueOf(f103), Float.valueOf(f104)), new Quad<>(Float.valueOf(f99), Float.valueOf(f100), valueOf, Float.valueOf(f105)), new Quad<>(Float.valueOf(f99), Float.valueOf(f100), Float.valueOf(f98 + f99), Float.valueOf(f105)), new Quad<>(Float.valueOf(f99), Float.valueOf(f100), Float.valueOf(f102), Float.valueOf(f105)), new Quad<>(Float.valueOf(f99), Float.valueOf(f100), Float.valueOf(f103), Float.valueOf(f105))};
            default:
                throw new IllegalStateException("getSubSizePos can not deal size " + count);
        }
    }

    public final void h(@NotNull Quad<Float>[] quadArr) {
        Intrinsics.checkNotNullParameter(quadArr, "<set-?>");
        this.bitmapSizePos_ = quadArr;
    }

    @NotNull
    public final ax i(@NotNull a[] bitmaps) {
        Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
        j(bitmaps);
        return this;
    }

    public final void j(@NotNull a[] aVarArr) {
        Intrinsics.checkNotNullParameter(aVarArr, "<set-?>");
        this.bitmaps_ = aVarArr;
    }

    @NotNull
    public final ax k(int gap) {
        this.gap_ = gap;
        return this;
    }

    @NotNull
    public final ax l(int width, int height) {
        this.width_ = width;
        this.height_ = height;
        return this;
    }
}
