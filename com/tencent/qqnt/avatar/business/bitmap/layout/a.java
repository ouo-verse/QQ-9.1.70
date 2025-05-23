package com.tencent.qqnt.avatar.business.bitmap.layout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015JU\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/avatar/business/bitmap/layout/a;", "Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "", "size", "", "Lkotlin/Pair;", "", "subSize", "gap", "gapColor", "Landroid/graphics/Bitmap;", "bitmaps", "b", "(I[Lkotlin/Pair;II[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "count", "a", "(III)[Lkotlin/Pair;", "bimaps", "c", "(III[Landroid/graphics/Bitmap;)[Landroid/graphics/Bitmap;", "<init>", "()V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.avatar.business.bitmap.layout.b
    @NotNull
    public Pair<Float, Float>[] a(@IntRange(from = 2, to = 4) int size, int gap, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair[]) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(size), Integer.valueOf(gap), Integer.valueOf(count));
        }
        if (count != 2) {
            if (count != 3) {
                if (count == 4) {
                    float f16 = (size - gap) / 2.0f;
                    return new Pair[]{new Pair<>(Float.valueOf(f16), Float.valueOf(f16)), new Pair<>(Float.valueOf(f16), Float.valueOf(f16)), new Pair<>(Float.valueOf(f16), Float.valueOf(f16)), new Pair<>(Float.valueOf(f16), Float.valueOf(f16))};
                }
                throw new IllegalStateException("getSubSize can not deal size " + count);
            }
            float f17 = (size - gap) / 2.0f;
            return new Pair[]{new Pair<>(Float.valueOf(f17), Float.valueOf(size)), new Pair<>(Float.valueOf(f17), Float.valueOf(f17)), new Pair<>(Float.valueOf(f17), Float.valueOf(f17))};
        }
        float f18 = (size - gap) / 2.0f;
        float f19 = size;
        return new Pair[]{new Pair<>(Float.valueOf(f18), Float.valueOf(f19)), new Pair<>(Float.valueOf(f18), Float.valueOf(f19))};
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
    @Override // com.tencent.qqnt.avatar.business.bitmap.layout.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap b(int size, @NotNull Pair<Float, Float>[] subSize, int gap, int gapColor, @Nullable Bitmap[] bitmaps) {
        int i3;
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(size), subSize, Integer.valueOf(gap), Integer.valueOf(gapColor), bitmaps);
        }
        Intrinsics.checkNotNullParameter(subSize, "subSize");
        Bitmap createBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (gapColor == 0) {
            i3 = -1;
        } else {
            i3 = gapColor;
        }
        canvas.drawColor(i3);
        Intrinsics.checkNotNull(bitmaps);
        int length = bitmaps.length;
        for (int i16 = 0; i16 < length; i16++) {
            Bitmap bitmap = bitmaps[i16];
            if (bitmap != null) {
                Intrinsics.checkNotNull(bitmap);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) subSize[i16].getFirst().floatValue(), (int) subSize[i16].getSecond().floatValue(), true);
                float f18 = 0.0f;
                if (length == 2 && i16 == 1) {
                    f16 = subSize[0].getFirst().floatValue() + gap;
                } else {
                    f16 = 0.0f;
                }
                if (length == 3) {
                    if (i16 == 0) {
                        f16 = 0.0f;
                    }
                    if (i16 == 1) {
                        f16 = subSize[0].getFirst().floatValue() + gap;
                    }
                    if (i16 == 2) {
                        float f19 = gap;
                        f16 = subSize[0].getFirst().floatValue() + f19;
                        f17 = subSize[1].getSecond().floatValue() + f19;
                        if (length == 4) {
                            if (i16 == 0) {
                                f16 = 0.0f;
                                f17 = 0.0f;
                            }
                            if (i16 == 1) {
                                f17 = subSize[0].getSecond().floatValue() + gap;
                                f16 = 0.0f;
                            }
                            if (i16 == 2) {
                                f16 = subSize[1].getFirst().floatValue() + gap;
                            } else {
                                f18 = f17;
                            }
                            if (i16 == 3) {
                                float f26 = gap;
                                float floatValue = subSize[1].getFirst().floatValue() + f26;
                                f17 = subSize[2].getSecond().floatValue() + f26;
                                f16 = floatValue;
                            }
                            canvas.drawBitmap(createScaledBitmap, f16, f18, (Paint) null);
                        }
                        f18 = f17;
                        canvas.drawBitmap(createScaledBitmap, f16, f18, (Paint) null);
                    }
                }
                f17 = 0.0f;
                if (length == 4) {
                }
                f18 = f17;
                canvas.drawBitmap(createScaledBitmap, f16, f18, (Paint) null);
            }
        }
        return createBitmap;
    }

    @Override // com.tencent.qqnt.avatar.business.bitmap.layout.b
    @NotNull
    public Bitmap[] c(int size, int gap, int count, @NotNull Bitmap[] bimaps) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(size), Integer.valueOf(gap), Integer.valueOf(count), bimaps);
        }
        Intrinsics.checkNotNullParameter(bimaps, "bimaps");
        Bitmap[] bitmapArr = new Bitmap[count];
        Bitmap bitmap7 = null;
        if (count != 2) {
            if (count != 3) {
                if (count == 4) {
                    Bitmap bitmap8 = bimaps[0];
                    if (bitmap8 != null) {
                        bitmap4 = tv3.a.a(bitmap8);
                    } else {
                        bitmap4 = null;
                    }
                    bitmapArr[0] = bitmap4;
                    Bitmap bitmap9 = bimaps[1];
                    if (bitmap9 != null) {
                        bitmap5 = tv3.a.a(bitmap9);
                    } else {
                        bitmap5 = null;
                    }
                    bitmapArr[1] = bitmap5;
                    Bitmap bitmap10 = bimaps[2];
                    if (bitmap10 != null) {
                        bitmap6 = tv3.a.a(bitmap10);
                    } else {
                        bitmap6 = null;
                    }
                    bitmapArr[2] = bitmap6;
                    Bitmap bitmap11 = bimaps[3];
                    if (bitmap11 != null) {
                        bitmap7 = tv3.a.a(bitmap11);
                    }
                    bitmapArr[3] = bitmap7;
                }
            } else {
                Bitmap bitmap12 = bimaps[0];
                if (bitmap12 != null) {
                    bitmap2 = tv3.a.b(bitmap12);
                } else {
                    bitmap2 = null;
                }
                bitmapArr[0] = bitmap2;
                Bitmap bitmap13 = bimaps[1];
                if (bitmap13 != null) {
                    bitmap3 = tv3.a.a(bitmap13);
                } else {
                    bitmap3 = null;
                }
                bitmapArr[1] = bitmap3;
                Bitmap bitmap14 = bimaps[2];
                if (bitmap14 != null) {
                    bitmap7 = tv3.a.a(bitmap14);
                }
                bitmapArr[2] = bitmap7;
            }
        } else {
            Bitmap bitmap15 = bimaps[0];
            if (bitmap15 != null) {
                bitmap = tv3.a.b(bitmap15);
            } else {
                bitmap = null;
            }
            bitmapArr[0] = bitmap;
            Bitmap bitmap16 = bimaps[1];
            if (bitmap16 != null) {
                bitmap7 = tv3.a.c(bitmap16);
            }
            bitmapArr[1] = bitmap7;
        }
        return bitmapArr;
    }
}
