package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.jz;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hn {

    /* renamed from: a, reason: collision with root package name */
    protected static Paint f148685a = null;

    /* renamed from: b, reason: collision with root package name */
    public static a f148686b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final int f148687c = 2048;

    /* renamed from: d, reason: collision with root package name */
    private static final String f148688d = "BitmapUtil";

    /* renamed from: e, reason: collision with root package name */
    private static byte[] f148689e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        private static final AtomicInteger f148690b = new AtomicInteger();

        /* renamed from: a, reason: collision with root package name */
        private final MemoryCache<ki> f148691a;

        public a(Context context, int i3, int i16) {
            File c16 = mz.a(context, (TencentMapOptions) null).c();
            if (kl.a("5.6.3.2", "4.4.6")) {
                kt.a(new File(c16, "BitmapDescriptorCache"), new File(c16, "bitmaps"));
            }
            MemoryCache.a aVar = new MemoryCache.a(i3);
            aVar.f147656b = i16;
            aVar.f147658d = true;
            aVar.f147657c = new jz.b<ki>() { // from class: com.tencent.mapsdk.internal.hn.a.1
                @Override // com.tencent.mapsdk.internal.jz.b
                public final /* synthetic */ boolean a(ki kiVar) {
                    ki kiVar2 = kiVar;
                    if (kiVar2 == null) {
                        return true;
                    }
                    String str = kiVar2.f148979f;
                    if (!kiVar2.f() || str == null) {
                        return true;
                    }
                    a.this.f148691a.a(str);
                    return true;
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private boolean a2(ki kiVar) {
                    if (kiVar == null) {
                        return true;
                    }
                    String str = kiVar.f148979f;
                    if (!kiVar.f() || str == null) {
                        return true;
                    }
                    a.this.f148691a.a(str);
                    return true;
                }
            };
            this.f148691a = (MemoryCache) kd.a(i3, ki.class, aVar);
            a();
        }

        public static int b() {
            return f148690b.get();
        }

        public final synchronized void c() {
            AtomicInteger atomicInteger = f148690b;
            if (atomicInteger.get() <= 0 || atomicInteger.decrementAndGet() == 0) {
                this.f148691a.j();
            }
        }

        public static void a() {
            AtomicInteger atomicInteger = f148690b;
            if (atomicInteger.get() < 0) {
                atomicInteger.set(0);
            }
            atomicInteger.incrementAndGet();
        }

        public final synchronized boolean b(String str) {
            ki a16 = this.f148691a.a(str, ki.class);
            if (a16 == null || !a16.f()) {
                return false;
            }
            LogUtil.b(ky.f149113s, "remove:" + str + " bitmapData:" + a16);
            this.f148691a.a(str);
            return true;
        }

        public final synchronized void a(String str, Bitmap bitmap) {
            a(str, new ki(bitmap));
        }

        private synchronized void a(String str, ki kiVar) {
            LogUtil.b(ky.f149113s, "putCache:" + str + " id:" + kiVar.f148979f + " bitmapData:" + kiVar);
            ki a16 = this.f148691a.a(str, ki.class);
            if (a16 != null) {
                LogUtil.b(ky.f149113s, "getCache:" + str + " id:" + a16.f148979f + " recycle:" + a16.g() + " bitmapData:" + a16);
            }
            if (a16 != null && !a16.g() && !TextUtils.isEmpty(a16.f148979f) && a16.f148979f.equals(kiVar.f148979f)) {
                LogUtil.b(ky.f149113s, "same bitmap!!".concat(String.valueOf(str)));
                a16.e();
            } else {
                this.f148691a.b(str, (String) kiVar);
            }
        }

        public final synchronized Bitmap a(String str) {
            ki b16 = this.f148691a.b(str, ki.class);
            if (b16 == null) {
                return null;
            }
            return b16.c();
        }
    }

    static {
        Paint paint = new Paint();
        f148685a = paint;
        paint.setAntiAlias(true);
    }

    private static Bitmap a(int[] iArr, int i3, int i16, Bitmap.Config config) {
        return Bitmap.createBitmap(iArr, i3, i16, config);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0082: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:25:0x0082 */
    public static Bitmap b(Context context, String str) {
        InputStream inputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        r0 = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            try {
                inputStream = ku.b(mz.a(context, (TencentMapOptions) null).e() + str);
                if (inputStream == null) {
                    try {
                        if (mw.a() != null) {
                            inputStream = mw.b(context, mw.a() + str);
                        } else if (mw.b() != null) {
                            inputStream = ku.b(mw.b() + str);
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        ku.a((Closeable) inputStream);
                        return bitmap;
                    } catch (OutOfMemoryError unused) {
                    }
                }
                if (inputStream == null) {
                    inputStream = mw.b(context, ho.f148701d.concat(String.valueOf(str)));
                }
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e17) {
                e = e17;
                inputStream = null;
            } catch (OutOfMemoryError unused2) {
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                ku.a(closeable2);
                throw th;
            }
            ku.a((Closeable) inputStream);
            return bitmap;
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            ku.a(closeable2);
            throw th;
        }
    }

    private static byte[] c(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                ku.a(byteArrayOutputStream2);
                return byteArray;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = byteArrayOutputStream2;
                ku.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static Bitmap d(Bitmap bitmap) {
        Bitmap a16;
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (bitmap.isRecycled() || width <= 0 || height <= 0 || (a16 = a(width, height, Bitmap.Config.ARGB_8888)) == null) {
                return null;
            }
            a16.setDensity(bitmap.getDensity());
            Canvas canvas = new Canvas(a16);
            a16.eraseColor(0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, f148685a);
            return a16;
        }
        return null;
    }

    private static Bitmap e(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError unused) {
                try {
                    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                } catch (OutOfMemoryError unused2) {
                }
            }
        }
        return null;
    }

    private static Drawable f(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    private static Bitmap g(Bitmap bitmap) {
        try {
            return Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static byte[] a() {
        Bitmap a16;
        if (f148689e == null && (a16 = a(256, 256, Bitmap.Config.ARGB_8888)) != null) {
            new Canvas(a16).drawARGB(0, 255, 255, 255);
            f148689e = c(a16);
        }
        return f148689e;
    }

    private static Bitmap c(String str, int i3) {
        Rect rect = new Rect();
        TextPaint textPaint = new TextPaint(65);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Integer.MIN_VALUE);
        textPaint.setTextSize(i3);
        textPaint.clearShadowLayer();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, Math.round(rect.width()), Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false);
        Bitmap a16 = a(staticLayout.getWidth(), staticLayout.getHeight(), Bitmap.Config.ARGB_8888);
        if (a16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(a16);
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        return a16;
    }

    public static Bitmap a(View view) {
        Bitmap bitmap;
        if (view != null) {
            try {
                synchronized (view) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                    view.setDrawingCacheEnabled(true);
                    view.buildDrawingCache();
                    Bitmap drawingCache = view.getDrawingCache();
                    if (drawingCache != null && !drawingCache.isRecycled()) {
                        int width = drawingCache.getWidth();
                        int height = drawingCache.getHeight();
                        if (!drawingCache.isRecycled() && width > 0 && height > 0 && (bitmap = a(width, height, Bitmap.Config.ARGB_8888)) != null) {
                            bitmap.setDensity(drawingCache.getDensity());
                            Canvas canvas = new Canvas(bitmap);
                            bitmap.eraseColor(0);
                            canvas.drawBitmap(drawingCache, 0.0f, 0.0f, f148685a);
                            view.destroyDrawingCache();
                        }
                    }
                    bitmap = null;
                    view.destroyDrawingCache();
                }
                return bitmap;
            } catch (Throwable th5) {
                Log.e("BitmapUtil", "BitmapUtil.convertToBitmap errorDetail:" + Log.getStackTraceString(th5));
            }
        }
        return null;
    }

    public static Bitmap b(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / ho.b()), (int) (bitmap.getHeight() / ho.b()), true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private static Bitmap b(String str, int i3) {
        Rect rect = new Rect();
        TextPaint textPaint = new TextPaint(65);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Integer.MIN_VALUE);
        textPaint.setTextSize(i3);
        textPaint.clearShadowLayer();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, Math.round(rect.width()), Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false);
        Bitmap a16 = a(staticLayout.getWidth(), staticLayout.getHeight(), Bitmap.Config.ARGB_8888);
        if (a16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(a16);
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        return a16;
    }

    public static Bitmap c(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception unused) {
                ku.a((Closeable) inputStream);
                return null;
            } catch (OutOfMemoryError unused2) {
            } catch (Throwable th5) {
                th = th5;
                inputStream2 = inputStream;
                ku.a((Closeable) inputStream2);
                throw th;
            }
        } catch (Exception unused3) {
            inputStream = null;
        } catch (OutOfMemoryError unused4) {
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
        ku.a((Closeable) inputStream);
        return bitmap;
    }

    private static Bitmap a(Bitmap bitmap, int i3, int i16) {
        Bitmap a16;
        if (bitmap == null || bitmap.isRecycled() || i3 <= 0 || i16 <= 0 || (a16 = a(i3, i16, Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        a16.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(a16);
        a16.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, f148685a);
        return a16;
    }

    public static Bitmap a(Bitmap bitmap, Context context, int i3, int i16) {
        int min;
        int min2;
        Bitmap a16;
        if (bitmap == null || bitmap.isRecycled() || i3 <= 0 || i16 <= 0 || (a16 = a((min = Math.min(i3, 2048)), (min2 = Math.min(i16, 2048)), Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        a16.eraseColor(0);
        Canvas canvas = new Canvas(a16);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, min, min2);
        bitmapDrawable.draw(canvas);
        return a16;
    }

    public static String a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getAllocationByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        sb5.append("@");
        sb5.append(width);
        sb5.append(HippyTKDListViewAdapter.X);
        sb5.append(height);
        sb5.append("@");
        sb5.append(Util.getMD5String(allocate.array()));
        allocate.clear();
        return sb5.toString();
    }

    private static boolean a(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null || bitmap.isRecycled() || TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    bitmap.compress(compressFormat, 100, fileOutputStream2);
                    ku.a(fileOutputStream2);
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    ku.a(fileOutputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    ku.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean a(Bitmap bitmap, String str) {
        return a(bitmap, str, Bitmap.CompressFormat.PNG);
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap a16 = a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (a16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(a16);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return a16;
    }

    private static Bitmap a(int i3, int i16, Bitmap.Config config) {
        try {
            try {
                return Bitmap.createBitmap(i3, i16, config);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        } catch (OutOfMemoryError unused2) {
            return Bitmap.createBitmap(i3, i16, config);
        }
    }

    private static Bitmap a(Bitmap bitmap, float f16) {
        if (bitmap == null || f16 == 1.0f) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r4 == null) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, String str) {
        FileInputStream fileInputStream;
        String str2;
        InputStream inputStream = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            if (str != 0) {
                try {
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
                if (str.trim().length() != 0) {
                    if (str.trim().charAt(0) != '/') {
                        str2 = context.getFilesDir() + "/" + ((String) str);
                    } else {
                        str2 = context.getFilesDir() + ((String) str);
                    }
                    fileInputStream = new FileInputStream(str2);
                    try {
                        bitmap = BitmapFactory.decodeStream(fileInputStream);
                        str = fileInputStream;
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        str = fileInputStream;
                    }
                    try {
                        str.close();
                    } catch (Exception unused2) {
                        return bitmap;
                    }
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = str;
        }
    }

    public static final Bitmap a(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap a(Context context, int i3) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i3);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private static Bitmap a(String str, int i3) {
        Rect rect = new Rect();
        TextPaint textPaint = new TextPaint(65);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Integer.MIN_VALUE);
        textPaint.setTextSize(i3);
        textPaint.clearShadowLayer();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, Math.round(rect.width()), Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false);
        Bitmap a16 = a(staticLayout.getWidth(), staticLayout.getHeight(), Bitmap.Config.ARGB_8888);
        if (a16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(a16);
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        return a16;
    }
}
