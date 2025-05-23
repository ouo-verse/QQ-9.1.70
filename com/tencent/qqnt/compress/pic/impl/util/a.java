package com.tencent.qqnt.compress.pic.impl.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/util/a;", "", "Ljava/io/File;", "imageFile", "Landroid/graphics/Bitmap;", "c", "", "reqWidth", "reqHeight", "", "maxRatio", "d", "Landroid/graphics/BitmapFactory$Options;", "options", "b", "(Landroid/graphics/BitmapFactory$Options;II)I", MimeHelper.IMAGE_SUBTYPE_BITMAP, "e", "(Ljava/io/File;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "a", "(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;", "f", "(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355759a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f355759a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Bitmap a(@NotNull Bitmap bitmap, float maxRatio) {
        int coerceAtMost;
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, this, bitmap, Float.valueOf(maxRatio));
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (maxRatio < 1.0f) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(width, height);
        float f16 = coerceAtMost;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(width, height);
        if (coerceAtLeast / f16 <= maxRatio) {
            return bitmap;
        }
        float f17 = f16 * maxRatio;
        if (width > height) {
            width = (int) f17;
        } else {
            height = (int) f17;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, 0, width, height)");
        return createBitmap;
    }

    public final int b(@NotNull BitmapFactory.Options options, int reqWidth, int reqHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, options, Integer.valueOf(reqWidth), Integer.valueOf(reqHeight))).intValue();
        }
        Intrinsics.checkNotNullParameter(options, "options");
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        if (intValue > reqHeight || intValue2 > reqWidth) {
            int i16 = intValue / 2;
            int i17 = intValue2 / 2;
            while (i16 / i3 >= reqHeight && i17 / i3 >= reqWidth) {
                i3 *= 2;
            }
        }
        return i3;
    }

    @NotNull
    public final Bitmap c(@NotNull File imageFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageFile);
        }
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Bitmap decodeFile = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        a aVar = f355759a;
        Intrinsics.checkNotNullExpressionValue(decodeFile, "this");
        return aVar.e(imageFile, decodeFile);
    }

    @Nullable
    public final Bitmap d(@NotNull File imageFile, int reqWidth, int reqHeight, float maxRatio) {
        Bitmap e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, imageFile, Integer.valueOf(reqWidth), Integer.valueOf(reqHeight), Float.valueOf(maxRatio));
        }
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
        options.inJustDecodeBounds = false;
        a aVar = f355759a;
        options.inSampleSize = aVar.b(options, reqWidth, reqHeight);
        com.tencent.qqnt.compress.pic.impl.safeDecode.c cVar = com.tencent.qqnt.compress.pic.impl.safeDecode.c.f355748a;
        String absolutePath = imageFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "imageFile.absolutePath");
        Bitmap f16 = com.tencent.qqnt.compress.pic.impl.safeDecode.c.f(cVar, absolutePath, options, false, 4, null);
        if (f16 != null && (e16 = aVar.e(imageFile, f16)) != null) {
            if (maxRatio >= 1.0f) {
                e16 = aVar.a(e16, maxRatio);
            }
            if (e16 != null) {
                return aVar.f(e16, reqWidth, reqHeight);
            }
        }
        return null;
    }

    @NotNull
    public final Bitmap e(@NotNull File imageFile, @NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) imageFile, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int attributeInt = new ExifInterface(imageFile.getAbsolutePath()).getAttributeInt("Orientation", 0);
        Matrix matrix = new Matrix();
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt != 8) {
                    return bitmap;
                }
                matrix.postRotate(270.0f);
            } else {
                matrix.postRotate(90.0f);
            }
        } else {
            matrix.postRotate(180.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, \u2026map.height, matrix, true)");
        return createBitmap;
    }

    @NotNull
    public final Bitmap f(@NotNull Bitmap bitmap, int reqWidth, int reqHeight) {
        float coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, this, bitmap, Integer.valueOf(reqWidth), Integer.valueOf(reqHeight));
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(reqWidth / bitmap.getWidth(), reqHeight / bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(coerceAtMost, coerceAtMost);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, \u2026map.height, matrix, true)");
        return createBitmap;
    }
}
