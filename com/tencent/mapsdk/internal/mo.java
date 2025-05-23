package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mo {

    /* renamed from: a, reason: collision with root package name */
    public static final long f149319a = 20;

    /* renamed from: b, reason: collision with root package name */
    public static int f149320b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f149321c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f149322d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f149323e = 2;

    static {
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory <= 16777216) {
            f149320b = 1;
        } else if (maxMemory >= 67108864) {
            f149320b = 2;
        } else {
            f149320b = 0;
        }
    }

    public static double a(double d16, double d17, long j3, long j16) {
        return ((d17 - d16) * (j16 / j3)) + d16;
    }

    public static double b(double d16, double d17, long j3, long j16) {
        double d18 = j16 / j3;
        return ((d17 - d16) * d18 * d18) + d16;
    }

    public static double c(double d16, double d17, long j3, long j16) {
        double d18 = (j16 / j3) - 1.0d;
        return ((d17 - d16) * (1.0d - (d18 * d18))) + d16;
    }

    public static double d(double d16, double d17, long j3, long j16) {
        double d18 = j16 / j3;
        double d19 = d18 * d18;
        double d26 = d19 * d19;
        return ((d17 - d16) * d26 * d26) + d16;
    }

    public static double e(double d16, double d17, long j3, long j16) {
        double d18 = (j16 / j3) - 1.0d;
        double d19 = d18 * d18;
        double d26 = d19 * d19;
        return ((d17 - d16) * (1.0d - (d26 * d26))) + d16;
    }

    private static double f(double d16, double d17, long j3, long j16) {
        double d18 = j16 / j3;
        return ((d17 - d16) * d18 * d18 * d18 * d18) + d16;
    }

    private static double g(double d16, double d17, long j3, long j16) {
        double d18 = (j16 / j3) - 1.0d;
        return ((d17 - d16) * (1.0d - (((d18 * d18) * d18) * d18))) + d16;
    }

    private static double h(double d16, double d17, long j3, long j16) {
        double d18 = j16 / (j3 - 1);
        double d19 = d18 * d18;
        return ((d16 - d17) * (1.0d - (d19 * d19))) + d17;
    }

    private static boolean a() {
        return f149320b == 1;
    }

    private static ShortBuffer b(int i3) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.rewind();
        return asShortBuffer;
    }

    private static float[] c(int i3) {
        return new float[]{((i3 >> 16) & 255) / 255.0f, ((i3 >> 8) & 255) / 255.0f, (i3 & 255) / 255.0f, ((i3 >> 24) & 255) / 255.0f};
    }

    private static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.rewind();
        return asFloatBuffer;
    }

    private static FloatBuffer a(int i3) {
        ByteBuffer allocateDirect;
        ByteBuffer.allocate(0);
        int i16 = i3 * 4;
        try {
            allocateDirect = ByteBuffer.allocateDirect(i16);
        } catch (OutOfMemoryError e16) {
            allocateDirect = ByteBuffer.allocateDirect(i16);
            e16.printStackTrace();
        }
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.rewind();
        return asFloatBuffer;
    }

    private static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        int length = fArr.length;
        if (floatBuffer == null || floatBuffer.capacity() != length) {
            floatBuffer = a(length);
        }
        floatBuffer.put(fArr);
        floatBuffer.rewind();
        return floatBuffer;
    }

    private static ShortBuffer a(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.rewind();
        return asShortBuffer;
    }

    private static ShortBuffer a(short[] sArr, ShortBuffer shortBuffer) {
        int length = sArr.length;
        if (shortBuffer == null || shortBuffer.capacity() != length) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length * 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            shortBuffer = allocateDirect.asShortBuffer();
            shortBuffer.rewind();
        }
        shortBuffer.put(sArr);
        shortBuffer.rewind();
        return shortBuffer;
    }

    private static int a(GL10 gl10, Bitmap bitmap) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        gl10.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        gl10.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        gl10.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        return i3;
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
        Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        createBitmap.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    private static int a(float f16) {
        int i3 = 1;
        while (true) {
            int i16 = i3 + 1;
            int i17 = 2 << i3;
            if (i17 >= ((int) Math.ceil(f16))) {
                return i17;
            }
            i3 = i16;
        }
    }
}
