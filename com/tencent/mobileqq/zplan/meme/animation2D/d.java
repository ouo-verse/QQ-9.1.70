package com.tencent.mobileqq.zplan.meme.animation2D;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019JF\u0010\r\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/d;", "", "Landroid/graphics/Bitmap;", "back", "center", "front", "", "radius", "", "needBackGround", "", "encodeWidth", "encodeHeight", "e", MimeHelper.IMAGE_SUBTYPE_BITMAP, "c", "", "path", "b", CustomImageProps.QUALITY, "filePath", "f", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f333935a = new d();

    d() {
    }

    public final byte[] a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            int width = bitmap.getWidth() * bitmap.getHeight();
            int[] iArr = new int[width];
            byte[] bArr = new byte[width * 4];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            int i3 = 0;
            for (int i16 = 0; i16 < width; i16++) {
                int i17 = iArr[i16];
                int i18 = i3 + 1;
                bArr[i3] = (byte) ((i17 >> 16) & 255);
                int i19 = i18 + 1;
                bArr[i18] = (byte) ((i17 >> 8) & 255);
                int i26 = i19 + 1;
                bArr[i19] = (byte) (i17 & 255);
                i3 = i26 + 1;
                bArr[i26] = (byte) ((i17 >> 24) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Bitmap must be in ARGB_8888 format".toString());
    }

    public final Bitmap b(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            return BitmapFactory.decodeFile(path);
        } catch (Exception e16) {
            QLog.e(BitmapUtil.TAG, 1, "getBitmapByPath exception", e16);
            return null;
        }
    }

    public final Bitmap c(Bitmap bitmap, float radius, boolean needBackGround) {
        PorterDuff.Mode mode;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if ((radius == 0.0f) && !needBackGround) {
            return bitmap;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        if (needBackGround) {
            paint.setColor(-1);
        }
        RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
        Bitmap retBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(retBitmap);
        if (radius > 0.0f) {
            canvas.drawRoundRect(rectF, radius, radius, paint);
            if (needBackGround) {
                mode = PorterDuff.Mode.SRC_ATOP;
            } else {
                mode = PorterDuff.Mode.SRC_IN;
            }
            paint.setXfermode(new PorterDuffXfermode(mode));
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        Intrinsics.checkNotNullExpressionValue(retBitmap, "retBitmap");
        return retBitmap;
    }

    public final Bitmap e(Bitmap back, Bitmap center, Bitmap front, float radius, boolean needBackGround, int encodeWidth, int encodeHeight) {
        Bitmap copy;
        Canvas canvas;
        Intrinsics.checkNotNullParameter(center, "center");
        if (encodeWidth <= 0 || encodeHeight <= 0) {
            encodeWidth = center.getWidth();
            encodeHeight = center.getHeight();
        }
        Rect rect = new Rect(0, 0, encodeWidth, encodeHeight);
        if (back != null) {
            copy = Bitmap.createScaledBitmap(back, encodeWidth, encodeHeight, true).copy(Bitmap.Config.ARGB_8888, true);
            Intrinsics.checkNotNullExpressionValue(copy, "createScaledBitmap(back,\u2026p.Config.ARGB_8888, true)");
            canvas = new Canvas(copy);
            canvas.drawBitmap(center, new Rect(0, 0, center.getWidth(), center.getHeight()), rect, (Paint) null);
        } else {
            copy = Bitmap.createScaledBitmap(center, encodeWidth, encodeHeight, true).copy(Bitmap.Config.ARGB_8888, true);
            Intrinsics.checkNotNullExpressionValue(copy, "createScaledBitmap(cente\u2026p.Config.ARGB_8888, true)");
            canvas = new Canvas(copy);
        }
        if (front != null) {
            canvas.drawBitmap(front, new Rect(0, 0, front.getWidth(), front.getHeight()), rect, (Paint) null);
        }
        return c(copy, radius, needBackGround);
    }

    public final boolean f(Bitmap bitmap, int quality, String filePath) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file2 = new File(file.getParent());
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdirs();
            }
            if (!file.exists() || !file.isFile()) {
                file = com.tencent.zplan.common.utils.c.f385288a.c(filePath);
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, quality, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return true;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                QLog.e(BitmapUtil.TAG, 1, "saveBitmapFileAsPNG error.", th);
                return false;
            } finally {
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
            }
        }
    }

    public static /* synthetic */ Bitmap d(d dVar, Bitmap bitmap, float f16, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return dVar.c(bitmap, f16, z16);
    }

    public static /* synthetic */ boolean g(d dVar, Bitmap bitmap, int i3, String str, int i16, Object obj) throws IOException {
        if ((i16 & 2) != 0) {
            i3 = 100;
        }
        return dVar.f(bitmap, i3, str);
    }
}
