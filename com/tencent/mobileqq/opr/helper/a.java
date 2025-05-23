package com.tencent.mobileqq.opr.helper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.SliceBitmapDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0002\"\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b*@\u0010\u0010\"\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n2\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/image/URLDrawable;", "Landroid/graphics/Bitmap;", "b", "Lcom/tencent/image/SliceBitmapDrawable;", "a", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "getTRANSPARENT", "()Landroid/graphics/drawable/ColorDrawable;", "TRANSPARENT", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "URLDrawableCallback", "opr_debug"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ColorDrawable f256999a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8432);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f256999a = new ColorDrawable(0);
        }
    }

    private static final Bitmap a(SliceBitmapDrawable sliceBitmapDrawable) {
        sliceBitmapDrawable.setTargetDensity(160);
        int rowCount = sliceBitmapDrawable.getRowCount();
        int columnCount = sliceBitmapDrawable.getColumnCount();
        Bitmap finalBitmap = Bitmap.createBitmap(sliceBitmapDrawable.getIntrinsicWidth(), sliceBitmapDrawable.getIntrinsicHeight(), sliceBitmapDrawable.getBitmap(0).getConfig());
        Canvas canvas = new Canvas(finalBitmap);
        canvas.setDensity(160);
        if (columnCount > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int i17 = i3 + 1;
                int i18 = 0;
                if (rowCount > 0) {
                    int i19 = 0;
                    while (true) {
                        int i26 = i18 + 1;
                        Bitmap bitmap = sliceBitmapDrawable.getBitmap((i3 * rowCount) + i18);
                        canvas.drawBitmap(bitmap, i19, i16, (Paint) null);
                        i19 += bitmap.getWidth();
                        i18 = bitmap.getHeight();
                        if (i26 >= rowCount) {
                            break;
                        }
                        i18 = i26;
                    }
                }
                i16 += i18;
                if (i17 >= columnCount) {
                    break;
                }
                i3 = i17;
            }
        }
        Intrinsics.checkNotNullExpressionValue(finalBitmap, "finalBitmap");
        return finalBitmap;
    }

    @Nullable
    public static final Bitmap b(@NotNull URLDrawable uRLDrawable) {
        Intrinsics.checkNotNullParameter(uRLDrawable, "<this>");
        if (uRLDrawable.getStatus() != 1) {
            return null;
        }
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) currDrawable).getBitmap();
        }
        if (currDrawable instanceof RegionDrawable) {
            return ((RegionDrawable) currDrawable).getBitmap();
        }
        if (!(currDrawable instanceof SliceBitmapDrawable)) {
            return null;
        }
        return a((SliceBitmapDrawable) currDrawable);
    }
}
