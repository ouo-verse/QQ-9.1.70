package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Utils {
    public static final int SECOND_IN_NANOS = 1000000000;
    private static final ThreadLocal<PathMeasure> threadLocalPathMeasure = new ThreadLocal<PathMeasure>() { // from class: com.airbnb.lottie.utils.Utils.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> threadLocalTempPath = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> threadLocalTempPath2 = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<float[]> threadLocalPoints = new ThreadLocal<float[]>() { // from class: com.airbnb.lottie.utils.Utils.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float INV_SQRT_2 = (float) (Math.sqrt(2.0d) / 2.0d);

    Utils() {
    }

    public static void applyTrimPathIfNeeded(Path path, @Nullable TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.isHidden()) {
            return;
        }
        applyTrimPathIfNeeded(path, ((FloatKeyframeAnimation) trimPathContent.getStart()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getEnd()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getOffset()).getFloatValue() / 360.0f);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception unused) {
            }
        }
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f16 = pointF3.x + pointF.x;
            float f17 = pointF.y + pointF3.y;
            float f18 = pointF2.x;
            float f19 = f18 + pointF4.x;
            float f26 = pointF2.y;
            path.cubicTo(f16, f17, f19, f26 + pointF4.y, f18, f26);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float dpScale() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float getAnimationScale(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = threadLocalPoints.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f16 = INV_SQRT_2;
        fArr[2] = f16;
        fArr[3] = f16;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        float[] fArr = threadLocalPoints.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static int hashFor(float f16, float f17, float f18, float f19) {
        int i3;
        if (f16 != 0.0f) {
            i3 = (int) (527 * f16);
        } else {
            i3 = 17;
        }
        if (f17 != 0.0f) {
            i3 = (int) (i3 * 31 * f17);
        }
        if (f18 != 0.0f) {
            i3 = (int) (i3 * 31 * f18);
        }
        if (f19 != 0.0f) {
            return (int) (i3 * 31 * f19);
        }
        return i3;
    }

    public static boolean isAtLeastVersion(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i3 < i18) {
            return false;
        }
        if (i3 > i18) {
            return true;
        }
        if (i16 < i19) {
            return false;
        }
        if (i16 <= i19 && i17 < i26) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkException(Throwable th5) {
        if (!(th5 instanceof SocketException) && !(th5 instanceof ClosedChannelException) && !(th5 instanceof InterruptedIOException) && !(th5 instanceof ProtocolException) && !(th5 instanceof SSLException) && !(th5 instanceof UnknownHostException) && !(th5 instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }

    public static Bitmap renderPath(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap createBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        LPaint lPaint = new LPaint();
        lPaint.setAntiAlias(true);
        lPaint.setColor(-16776961);
        canvas.drawPath(path, lPaint);
        return createBitmap;
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i3, int i16) {
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i16) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i16, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint) {
        saveLayerCompat(canvas, rectF, paint, 31);
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int i3) {
        L.beginSection("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        L.endSection("Utils#saveLayer");
    }

    public static void applyTrimPathIfNeeded(Path path, float f16, float f17, float f18) {
        L.beginSection("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = threadLocalPathMeasure.get();
        Path path2 = threadLocalTempPath.get();
        Path path3 = threadLocalTempPath2.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f16 == 1.0f && f17 == 0.0f) {
            L.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f17 - f16) - 1.0f) >= 0.01d) {
            float f19 = f16 * length;
            float f26 = f17 * length;
            float f27 = f18 * length;
            float min = Math.min(f19, f26) + f27;
            float max = Math.max(f19, f26) + f27;
            if (min >= length && max >= length) {
                min = MiscUtils.floorMod(min, length);
                max = MiscUtils.floorMod(max, length);
            }
            if (min < 0.0f) {
                min = MiscUtils.floorMod(min, length);
            }
            if (max < 0.0f) {
                max = MiscUtils.floorMod(max, length);
            }
            if (min == max) {
                path.reset();
                L.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            L.endSection("applyTrimPathIfNeeded");
            return;
        }
        L.endSection("applyTrimPathIfNeeded");
    }
}
