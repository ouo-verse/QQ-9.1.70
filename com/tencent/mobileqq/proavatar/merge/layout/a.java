package com.tencent.mobileqq.proavatar.merge.layout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.proavatar.group.GroupUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002JK\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/proavatar/merge/layout/a;", "Lcom/tencent/mobileqq/proavatar/merge/layout/b;", "", "size", "", RedTouchConst.PicDownload.ISCIRCLE, "", "Landroid/graphics/Bitmap;", "bitmaps", "c", "(IZ[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "layoutSize", "partSize", "", "Landroid/graphics/RectF;", "d", "Lkotlin/Pair;", "", "subSize", "b", "(I[Lkotlin/Pair;Z[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "gap", "count", "a", "(III)[Lkotlin/Pair;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static final int f259664b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/proavatar/merge/layout/a$a;", "", "", "CROP_CENTER", "I", "CROP_NONE", "GAP_COLOR", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.merge.layout.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f259664b = Color.parseColor("#FFE0E0E0");
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bitmap c(int size, boolean isCircle, Bitmap[] bitmaps) {
        int length;
        if (bitmaps == null || (length = bitmaps.length) <= 4) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        int i3 = f259664b;
        paint.setColor(i3);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        if (isCircle) {
            float f16 = size / 2.0f;
            canvas.drawCircle(f16, f16, f16, paint);
        } else {
            canvas.drawColor(i3);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        int i16 = 0;
        for (RectF rectF : d(size, length)) {
            int i17 = i16 + 1;
            Bitmap bitmap = bitmaps[i16];
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rectF, paint);
            i16 = i17;
        }
        return createBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x016e, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<RectF> d(int layoutSize, int partSize) {
        ArrayList arrayList = new ArrayList(partSize);
        float f16 = layoutSize;
        float rint = (float) Math.rint(f16 / 50.0f);
        float rint2 = (float) Math.rint(f16 / 3.0f);
        float f17 = rint2 + (rint2 % 2);
        float f18 = f17 / 2.0f;
        float rint3 = (float) Math.rint(f16 / 2.0f);
        float f19 = rint / 2.0f;
        switch (partSize) {
            case 5:
            case 6:
                float f26 = rint3 - f19;
                RectF rectF = new RectF(rint3 - f18, f26 - f17, rint3 + f18, f26);
                RectF rectF2 = new RectF(rectF);
                float f27 = f17 + rint;
                rectF2.offset(0.0f, f27);
                if (partSize == 5) {
                    RectF rectF3 = new RectF(rectF);
                    rectF3.offset((-f18) - f19, 0.0f);
                    arrayList.add(rectF3);
                    RectF rectF4 = new RectF(rectF);
                    rectF4.offset(f18 + f19, 0.0f);
                    arrayList.add(rectF4);
                } else {
                    RectF rectF5 = new RectF(rectF);
                    rectF5.offset((-f17) - rint, 0.0f);
                    arrayList.add(rectF5);
                    arrayList.add(rectF);
                    RectF rectF6 = new RectF(rectF);
                    rectF6.offset(f27, 0.0f);
                    arrayList.add(rectF6);
                }
                RectF rectF7 = new RectF(rectF2);
                rectF7.offset((-f17) - rint, 0.0f);
                arrayList.add(rectF7);
                arrayList.add(rectF2);
                RectF rectF8 = new RectF(rectF2);
                rectF8.offset(f27, 0.0f);
                arrayList.add(rectF8);
                break;
            case 7:
            case 8:
            case 9:
                float f28 = rint3 - f18;
                float f29 = rint3 + f18;
                RectF rectF9 = new RectF(f28, f28, f29, f29);
                float rint4 = (float) Math.rint(0.22f * f17);
                if (partSize != 7) {
                    if (partSize != 8) {
                        if (partSize == 9) {
                            RectF rectF10 = new RectF(rectF9);
                            float f36 = (-f17) - rint;
                            rectF10.offset(f36, f36);
                            rectF10.left += rint4;
                            rectF10.top += rint4;
                            arrayList.add(rectF10);
                            RectF rectF11 = new RectF(rectF9);
                            rectF11.offset(0.0f, f36);
                            arrayList.add(rectF11);
                            RectF rectF12 = new RectF(rectF9);
                            rectF12.offset(f17 + rint, f36);
                            rectF12.right -= rint4;
                            rectF12.top += rint4;
                            arrayList.add(rectF12);
                        }
                    } else {
                        RectF rectF13 = new RectF(rectF9);
                        float f37 = (-f17) - rint;
                        rectF13.offset((-f18) - f19, f37);
                        arrayList.add(rectF13);
                        RectF rectF14 = new RectF(rectF9);
                        rectF14.offset(f18 + f19, f37);
                        arrayList.add(rectF14);
                    }
                } else {
                    RectF rectF15 = new RectF(rectF9);
                    rectF15.offset(0.0f, (-f17) - rint);
                    arrayList.add(rectF15);
                }
                RectF rectF16 = new RectF(rectF9);
                float f38 = (-f17) - rint;
                rectF16.offset(f38, 0.0f);
                arrayList.add(rectF16);
                arrayList.add(rectF9);
                RectF rectF17 = new RectF(rectF9);
                float f39 = f17 + rint;
                rectF17.offset(f39, 0.0f);
                arrayList.add(rectF17);
                RectF rectF18 = new RectF(rectF9);
                rectF18.offset(f38, f39);
                rectF18.left += rint4;
                rectF18.bottom -= rint4;
                arrayList.add(rectF18);
                RectF rectF19 = new RectF(rectF9);
                rectF19.offset(0.0f, f39);
                arrayList.add(rectF19);
                RectF rectF20 = new RectF(rectF9);
                rectF20.offset(f39, f39);
                rectF20.right -= rint4;
                rectF20.bottom -= rint4;
                arrayList.add(rectF20);
                break;
        }
    }

    @Override // com.tencent.mobileqq.proavatar.merge.layout.b
    @NotNull
    public Pair<Float, Float>[] a(int size, int gap, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair[]) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(size), Integer.valueOf(gap), Integer.valueOf(count));
        }
        if (count != 1) {
            if (count != 2) {
                if (count != 3) {
                    float f16 = (size - gap) / 2.0f;
                    return new Pair[]{new Pair<>(Float.valueOf(f16), Float.valueOf(f16)), new Pair<>(Float.valueOf(f16), Float.valueOf(f16)), new Pair<>(Float.valueOf(f16), Float.valueOf(f16)), new Pair<>(Float.valueOf(f16), Float.valueOf(f16))};
                }
                float f17 = (size - gap) / 2.0f;
                return new Pair[]{new Pair<>(Float.valueOf(f17), Float.valueOf(size)), new Pair<>(Float.valueOf(f17), Float.valueOf(f17)), new Pair<>(Float.valueOf(f17), Float.valueOf(f17))};
            }
            float f18 = (size - gap) / 2.0f;
            float f19 = size;
            return new Pair[]{new Pair<>(Float.valueOf(f18), Float.valueOf(f19)), new Pair<>(Float.valueOf(f18), Float.valueOf(f19))};
        }
        float f26 = size;
        return new Pair[]{new Pair<>(Float.valueOf(f26), Float.valueOf(f26))};
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e6  */
    @Override // com.tencent.mobileqq.proavatar.merge.layout.b
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap b(int size, @NotNull Pair<Float, Float>[] subSize, boolean isCircle, @Nullable Bitmap[] bitmaps) {
        int length;
        int i3;
        float f16;
        float f17;
        int i16;
        float f18;
        int i17;
        Rect rect;
        float floatValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 4;
        int i19 = 3;
        int i26 = 2;
        int i27 = 1;
        int i28 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(size), subSize, Boolean.valueOf(isCircle), bitmaps);
        }
        Intrinsics.checkNotNullParameter(subSize, "subSize");
        Bitmap c16 = c(size, isCircle, bitmaps);
        if (c16 != null) {
            return c16;
        }
        float f19 = size;
        float rint = (float) Math.rint(f19 / 50.0f);
        Bitmap createBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(f259664b);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        if (isCircle) {
            float f26 = f19 / 2.0f;
            canvas.drawCircle(f26, f26, f26, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        Intrinsics.checkNotNull(bitmaps);
        if (bitmaps.length > 4) {
            length = 4;
        } else {
            length = bitmaps.length;
        }
        int i29 = 0;
        while (i29 < length) {
            RectF rectF = new RectF();
            float f27 = 0.0f;
            if (length == i26) {
                if (i29 == i27) {
                    f16 = subSize[i28].getFirst().floatValue() + rint;
                } else {
                    f16 = 0.0f;
                }
                i3 = i27;
            } else {
                i3 = i28;
                f16 = 0.0f;
            }
            if (length == i19) {
                if (i29 == 0) {
                    i3 = i27;
                    f16 = 0.0f;
                }
                if (i29 == i27) {
                    f16 = subSize[i28].getFirst().floatValue() + rint;
                }
                if (i29 == i26) {
                    f16 = subSize[i28].getFirst().floatValue() + rint;
                    f17 = subSize[i27].getSecond().floatValue() + rint;
                    i16 = i3;
                    if (length == i18) {
                        if (i29 == 0) {
                            f16 = 0.0f;
                            f17 = 0.0f;
                        }
                        if (i29 == i27) {
                            f16 = subSize[i28].getFirst().floatValue() + rint;
                            f17 = 0.0f;
                        }
                        if (GroupUtil.f259599a.m()) {
                            if (i29 == i26) {
                                f17 = subSize[i28].getSecond().floatValue() + rint;
                            } else {
                                f27 = f16;
                            }
                            if (i29 == i19) {
                                f27 = subSize[i28].getFirst().floatValue() + rint;
                                floatValue = subSize[i28].getSecond().floatValue();
                            }
                            f18 = f27;
                            float f28 = f17;
                            rectF.set(f18, f28, f18 + subSize[i29].getFirst().floatValue(), f28 + subSize[i29].getSecond().floatValue());
                            if (i16 != i27) {
                                int width = bitmaps[i29].getWidth();
                                int height = bitmaps[i29].getHeight();
                                rect = new Rect();
                                i17 = 2;
                                float floatValue2 = (f19 - subSize[i29].getFirst().floatValue()) / 2;
                                float f29 = width;
                                i28 = 0;
                                rect.set((int) ((floatValue2 / f19) * f29), 0, (int) (f29 * ((subSize[i29].getFirst().floatValue() + floatValue2) / f19)), (int) ((subSize[i29].getSecond().floatValue() / f19) * height));
                            } else {
                                i17 = 2;
                                i28 = 0;
                                rect = null;
                            }
                            canvas.drawBitmap(bitmaps[i29], rect, rectF, paint);
                            i29++;
                            i26 = i17;
                            i18 = 4;
                            i19 = 3;
                            i27 = 1;
                        } else {
                            if (i29 == i26) {
                                f16 = subSize[i28].getFirst().floatValue() + rint;
                                f17 = subSize[i28].getSecond().floatValue() + rint;
                            }
                            if (i29 == i19) {
                                floatValue = subSize[i28].getSecond().floatValue();
                            }
                        }
                        f17 = floatValue + rint;
                        f18 = f27;
                        float f282 = f17;
                        rectF.set(f18, f282, f18 + subSize[i29].getFirst().floatValue(), f282 + subSize[i29].getSecond().floatValue());
                        if (i16 != i27) {
                        }
                        canvas.drawBitmap(bitmaps[i29], rect, rectF, paint);
                        i29++;
                        i26 = i17;
                        i18 = 4;
                        i19 = 3;
                        i27 = 1;
                    }
                    f18 = f16;
                    float f2822 = f17;
                    rectF.set(f18, f2822, f18 + subSize[i29].getFirst().floatValue(), f2822 + subSize[i29].getSecond().floatValue());
                    if (i16 != i27) {
                    }
                    canvas.drawBitmap(bitmaps[i29], rect, rectF, paint);
                    i29++;
                    i26 = i17;
                    i18 = 4;
                    i19 = 3;
                    i27 = 1;
                }
            }
            f17 = 0.0f;
            i16 = i3;
            if (length == i18) {
            }
            f18 = f16;
            float f28222 = f17;
            rectF.set(f18, f28222, f18 + subSize[i29].getFirst().floatValue(), f28222 + subSize[i29].getSecond().floatValue());
            if (i16 != i27) {
            }
            canvas.drawBitmap(bitmaps[i29], rect, rectF, paint);
            i29++;
            i26 = i17;
            i18 = 4;
            i19 = 3;
            i27 = 1;
        }
        return createBitmap;
    }
}
