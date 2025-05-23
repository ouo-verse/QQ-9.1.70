package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mq {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149333a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f149334b = 2;

    private static float a(float f16, float f17) {
        return (int) ((f16 * f17) + 0.5f);
    }

    private static Bitmap b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = 2;
        int i16 = 2;
        while (i16 < width) {
            i16 <<= 1;
        }
        while (i3 < height) {
            i3 <<= 1;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i16, i3, false);
        if (createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    private static Bitmap c(TencentMapContext tencentMapContext, Bitmap bitmap, String str, int i3, int i16) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        na naVar = new na(tencentMapContext);
        naVar.setColor(i3);
        naVar.setTextSize(a(i16, 2.0f));
        naVar.setTypeface(Typeface.DEFAULT_BOLD);
        float f16 = naVar.getFontMetrics().bottom - naVar.getFontMetrics().top;
        float max = Math.max(width, naVar.measureText(str)) + 0.0f;
        float max2 = Math.max(height, f16) + 0.0f;
        int ceil = (int) Math.ceil(max);
        int ceil2 = (int) Math.ceil(max2);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, ceil2, false);
        Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDensity(0);
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, new Paint());
        float f17 = (float) (ceil / 2);
        float f18 = ceil2;
        float f19 = (f18 - ((f18 - f16) / 2.0f)) - naVar.getFontMetrics().bottom;
        naVar.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(str, f17, f19, naVar);
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = 2;
        int i16 = 2;
        while (i16 < width) {
            i16 <<= 1;
        }
        while (i3 < height) {
            i3 <<= 1;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(0);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setDensity(0);
            createBitmap.eraseColor(0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static int b(GL10 gl10) {
        int a16 = a(gl10);
        gl10.glBindTexture(GLSLRender.GL_TEXTURE_2D, a16);
        gl10.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        gl10.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        gl10.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        gl10.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        return a16;
    }

    private static Bitmap b(byte[] bArr) {
        return b(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, a()));
    }

    private static Bitmap a(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream, null, a());
    }

    private static Bitmap b(InputStream inputStream) {
        return b(BitmapFactory.decodeStream(inputStream, null, a()));
    }

    private static Bitmap a(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, a());
    }

    private static BitmapFactory.Options a() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return options;
    }

    private static Bitmap b(TencentMapContext tencentMapContext, Bitmap bitmap, String str, int i3, int i16) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        na naVar = new na(tencentMapContext);
        naVar.setColor(i3);
        naVar.setTextSize(a(i16, 2.0f));
        naVar.setTypeface(Typeface.DEFAULT_BOLD);
        float f16 = naVar.getFontMetrics().bottom - naVar.getFontMetrics().top;
        float max = Math.max(width, naVar.measureText(str)) + 0.0f;
        float max2 = Math.max(height, f16) + 0.0f;
        int ceil = (int) Math.ceil(max);
        int ceil2 = (int) Math.ceil(max2);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, ceil2, false);
        Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDensity(0);
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, new Paint());
        float f17 = (float) (ceil / 2);
        float f18 = ceil2;
        float f19 = (f18 - ((f18 - f16) / 2.0f)) - naVar.getFontMetrics().bottom;
        naVar.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(str, f17, f19, naVar);
        return createBitmap;
    }

    private static int a(GL10 gl10, Bitmap bitmap) {
        int b16 = b(gl10);
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        return b16;
    }

    private static void a(GL10 gl10, int i3) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        asIntBuffer.put(i3);
        asIntBuffer.position(0);
        gl10.glDeleteTextures(1, asIntBuffer);
    }

    private static int a(GL10 gl10, int i3, int i16, int i17, int i18, IntBuffer intBuffer) {
        int b16 = b(gl10);
        gl10.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        gl10.glTexSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, intBuffer);
        return b16;
    }

    private static float a(TencentMapContext tencentMapContext, String str, int i3, float f16) {
        na naVar = new na(tencentMapContext);
        naVar.setTextSize(a(i3, f16));
        naVar.setTypeface(Typeface.DEFAULT_BOLD);
        return naVar.measureText(str);
    }

    private static Bitmap a(String str, float f16, int i3, int i16, int i17, Typeface typeface) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i3);
        paint.setTextSize(f16);
        if (typeface != null) {
            paint.setTypeface(typeface);
        }
        Paint paint2 = new Paint(paint);
        paint2.setColor(i16);
        paint2.setStrokeWidth(paint.getStrokeWidth() + 2.0f);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f17 = fontMetrics.bottom - fontMetrics.top;
        if (i17 != 1) {
            if (i17 != 2) {
                return null;
            }
            int ceil = (int) Math.ceil(paint2.measureText(str) + 4.0f);
            int ceil2 = (int) Math.ceil(f17);
            Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            float f18 = (float) (ceil / 2);
            float f19 = (float) ((ceil2 / 2) + 1);
            paint2.setTextAlign(Paint.Align.CENTER);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(str, f18, f19, paint2);
            canvas.drawText(str, f18, f19, paint);
            return createBitmap;
        }
        int ceil3 = (int) Math.ceil(((f17 + 2.0f) * str.length()) + 4.0f);
        int ceil4 = (int) Math.ceil(paint2.measureText(str.substring(0, 1)) + 4.0f);
        float f26 = 0.0f - fontMetrics.top;
        Bitmap createBitmap2 = Bitmap.createBitmap(ceil4, ceil3, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        for (int i18 = 0; i18 < str.length(); i18++) {
            char charAt = str.charAt(i18);
            canvas2.drawText(String.valueOf(charAt), 2.0f, f26, paint2);
            canvas2.drawText(String.valueOf(charAt), 2.0f, f26, paint);
            f26 += f17;
        }
        return createBitmap2;
    }

    private static int a(GL10 gl10) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private static Bitmap a(TencentMapContext tencentMapContext, Bitmap bitmap, String str, int i3, int i16) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        na naVar = new na(tencentMapContext);
        naVar.setColor(i3);
        naVar.setTextSize(a(i16, 2.0f));
        naVar.setTypeface(Typeface.DEFAULT_BOLD);
        float f16 = naVar.getFontMetrics().bottom - naVar.getFontMetrics().top;
        float max = Math.max(width, naVar.measureText(str)) + 0.0f;
        float max2 = Math.max(height, f16) + 0.0f;
        int ceil = (int) Math.ceil(max);
        int ceil2 = (int) Math.ceil(max2);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, ceil2, false);
        Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDensity(0);
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, new Paint());
        float f17 = (float) (ceil / 2);
        float f18 = ceil2;
        float f19 = (f18 - ((f18 - f16) / 2.0f)) - naVar.getFontMetrics().bottom;
        naVar.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(str, f17, f19, naVar);
        return createBitmap;
    }
}
