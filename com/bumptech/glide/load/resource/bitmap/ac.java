package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    private static final Paint f31817a = new Paint(6);

    /* renamed from: b, reason: collision with root package name */
    private static final Paint f31818b = new Paint(7);

    /* renamed from: c, reason: collision with root package name */
    private static final Paint f31819c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<String> f31820d;

    /* renamed from: e, reason: collision with root package name */
    private static final Lock f31821e;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class a implements Lock {
        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j3, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        Lock aVar;
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f31820d = hashSet;
        if (hashSet.contains(DeviceInfoMonitor.getModel())) {
            aVar = new ReentrantLock();
        } else {
            aVar = new a();
        }
        f31821e = aVar;
        Paint paint = new Paint(7);
        f31819c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f31821e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f31817a);
            d(canvas);
            lock.unlock();
        } catch (Throwable th5) {
            f31821e.unlock();
            throw th5;
        }
    }

    public static Bitmap b(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3, int i16) {
        float width;
        float height;
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i16) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f16 = 0.0f;
        if (bitmap.getWidth() * i16 > bitmap.getHeight() * i3) {
            width = i16 / bitmap.getHeight();
            f16 = (i3 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i3 / bitmap.getWidth();
            height = (i16 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f16 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmap2 = dVar.get(i3, i16, h(bitmap));
        l(bitmap, bitmap2);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap c(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3, int i16) {
        if (bitmap.getWidth() <= i3 && bitmap.getHeight() <= i16) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return e(dVar, bitmap, i3, i16);
    }

    private static void d(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap e(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3, int i16) {
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i16) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i3 / bitmap.getWidth(), i16 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmap2 = dVar.get((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), h(bitmap));
        l(bitmap, bitmap2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i3 + HippyTKDListViewAdapter.X + i16);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + HippyTKDListViewAdapter.X + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + HippyTKDListViewAdapter.X + bitmap2.getHeight());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("minPct:   ");
            sb5.append(min);
            Log.v("TransformationUtils", sb5.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Lock f() {
        return f31821e;
    }

    public static int g(int i3) {
        switch (i3) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        if (bitmap.getConfig() != null) {
            return bitmap.getConfig();
        }
        return Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    static void i(int i3, Matrix matrix) {
        switch (i3) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean j(int i3) {
        switch (i3) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap k(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3) {
        if (!j(i3)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        i(i3, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmap2 = dVar.get(Math.round(rectF.width()), Math.round(rectF.height()), h(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static void l(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
