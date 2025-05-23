package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private static final int f235443a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f235444b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f235445c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f235446d;

    static {
        int dip2px = ViewUtils.dip2px(46.0f);
        f235443a = dip2px;
        f235444b = ViewUtils.dip2px(55.0f);
        f235445c = ViewUtils.dip2px(1.5f);
        f235446d = dip2px / 2;
    }

    private static void a(Bitmap bitmap, Canvas canvas) {
        Rect rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
    }

    public static void b(int i3, Canvas canvas, int i16, int i17) {
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawColor(i3);
        Rect rect = new Rect(0, 0, i16, i17);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(createBitmap, (Rect) null, rect, paint);
    }

    private static void c(Bitmap bitmap, Bitmap bitmap2, Canvas canvas) {
        if (bitmap == null) {
            return;
        }
        int width = (int) (canvas.getWidth() * 0.79f);
        int height = (bitmap.getHeight() * width) / bitmap.getWidth();
        int width2 = (canvas.getWidth() - width) / 2;
        int height2 = ((((canvas.getHeight() - f235444b) - bitmap2.getHeight()) - height) * 3) / 4;
        Rect rect = new Rect(width2, height2, width + width2, height + height2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
    }

    private static void d(Bitmap bitmap, Canvas canvas) {
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, (canvas.getWidth() / 2) - (bitmap.getWidth() / 2), (canvas.getHeight() - f235444b) - bitmap.getHeight(), (Paint) null);
    }

    public static Bitmap e(Bitmap bitmap, View view, int i3) {
        try {
            Bitmap g16 = g(bitmap);
            int width = view.getWidth();
            int height = view.getHeight();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                b(i3, canvas, width, height);
                Rect rect = new Rect(0, 0, width, (int) (width / 2.15f));
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                canvas.drawBitmap(g16, (Rect) null, rect, paint);
                return createBitmap;
            } catch (OutOfMemoryError e16) {
                QLog.w("GuildQRCodeUtil", 1, "getGuildBgBitmap createBitmap OOM: " + e16.getMessage());
                return null;
            }
        } catch (OutOfMemoryError e17) {
            QLog.w("GuildQRCodeUtil", 1, "getGuildBgBitmap getTransAlphaBitmap OOM: " + e17.getMessage());
            return null;
        }
    }

    public static Bitmap f(Context context, h02.b bVar, View view, Bitmap bitmap, Bitmap bitmap2) {
        if (bVar.b() == null) {
            QLog.w("GuildQRCodeUtil", 1, "getQrCodeShareImg qrCodeParams waterMarkBitmap is:" + bVar.b() + " logo:" + bVar.a());
            return null;
        }
        if (bitmap.isRecycled()) {
            QLog.w("GuildQRCodeUtil", 1, "getQrCodeShareImg bgBitmap isRecycled!");
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = (int) (view.getWidth() * 1.4f);
        int i3 = (int) (width2 * 1.7777778f);
        if (QLog.isColorLevel()) {
            QLog.i("GuildQRCodeUtil", 2, "getQrCodeShareImg() context: " + context + ", params: " + bVar + ", shareWidth=" + width2 + ",shareHeight=" + i3 + ", scaleWidth=" + width + ",scaleHeight=" + i3);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, width, height, false);
            if (createScaledBitmap == null) {
                QLog.w("GuildQRCodeUtil", 1, "getQrCodeShareImg copyViewCacheBitmap is null!");
                view.setDrawingCacheEnabled(false);
                view.destroyDrawingCache();
                return null;
            }
            view.setDrawingCacheEnabled(false);
            view.destroyDrawingCache();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width2, i3, Bitmap.Config.RGB_565);
                try {
                    int width3 = bitmap.getWidth();
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width3, Math.min((int) (width3 * 1.7777778f), bitmap.getHeight()), (Matrix) null, false);
                    Canvas canvas = new Canvas(createBitmap);
                    a(createBitmap2, canvas);
                    c(createScaledBitmap, bVar.b(), canvas);
                    d(bVar.b(), canvas);
                    h(createBitmap2);
                    h(bitmap2);
                    return createBitmap;
                } catch (OutOfMemoryError e16) {
                    QLog.w("GuildQRCodeUtil", 1, "getQrCodeShareImg cropBgBitmap OOM: " + e16.getMessage());
                    return null;
                }
            } catch (OutOfMemoryError e17) {
                QLog.w("GuildQRCodeUtil", 1, "getQrCodeShareImg shareBitmap OOM: " + e17.getMessage());
                return null;
            }
        } catch (OutOfMemoryError e18) {
            QLog.w("GuildQRCodeUtil", 1, "getQrCodeShareImg OOM: " + e18.getMessage());
            view.setDrawingCacheEnabled(false);
            view.destroyDrawingCache();
            return null;
        }
    }

    public static Bitmap g(Bitmap bitmap) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        float height = bitmap.getHeight();
        float f16 = 100.0f / height;
        float f17 = 255.0f;
        float f18 = 100.0f;
        for (int width2 = bitmap.getWidth() * (bitmap.getHeight() - ((int) height)); width2 < width; width2++) {
            if (width2 % bitmap.getWidth() == 0) {
                f18 -= f16;
                f17 = (f18 * 255.0f) / 100.0f;
            }
            iArr[width2] = (((int) f17) << 24) | (iArr[width2] & 16777215);
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    private static void h(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
