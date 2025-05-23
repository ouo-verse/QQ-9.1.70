package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.vas.k;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class FriendProfileCardBgDrawable extends Drawable implements Runnable {
    private k C;
    private int G;
    private int H;
    public a K;
    public Resources M;
    public boolean Q;
    private Rect R;
    private Rect S;
    private int V;
    private int W;

    /* renamed from: d, reason: collision with root package name */
    public Object f178208d;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f178210f;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap f178211h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f178212i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f178213m;
    public int D = -1;
    private int E = 0;
    public int F = 50;
    public Handler I = new Handler(Looper.getMainLooper());
    public boolean J = true;
    public boolean L = false;
    public int N = 0;
    public boolean P = false;
    private final byte[] T = new byte[0];
    private boolean U = false;

    /* renamed from: e, reason: collision with root package name */
    private Paint f178209e = new Paint(6);

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class a extends AsyncTask<Long, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private Object f178214a;

        public a(Object obj) {
            this.f178214a = obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Long... lArr) {
            long longValue;
            Bitmap g16;
            FriendProfileCardBgDrawable friendProfileCardBgDrawable;
            long j3;
            try {
                longValue = lArr[0].longValue();
                g16 = FriendProfileCardBgDrawable.this.g(this.f178214a, (int) lArr[1].longValue());
                friendProfileCardBgDrawable = FriendProfileCardBgDrawable.this;
            } catch (OutOfMemoryError e16) {
                QLog.e("FriendProfileCardBgDrawable", 4, "", e16);
                FriendProfileCardBgDrawable friendProfileCardBgDrawable2 = FriendProfileCardBgDrawable.this;
                friendProfileCardBgDrawable2.f178211h = null;
                friendProfileCardBgDrawable2.J = true;
            } catch (Throwable th5) {
                QLog.e("FriendProfileCardBgDrawable", 1, "", th5);
                FriendProfileCardBgDrawable friendProfileCardBgDrawable3 = FriendProfileCardBgDrawable.this;
                friendProfileCardBgDrawable3.f178211h = null;
                friendProfileCardBgDrawable3.J = true;
            }
            if (!friendProfileCardBgDrawable.Q) {
                Handler handler = friendProfileCardBgDrawable.I;
                if (friendProfileCardBgDrawable.f178213m == null) {
                    j3 = 1000;
                } else {
                    j3 = 0;
                }
                handler.postDelayed(friendProfileCardBgDrawable, j3);
                return null;
            }
            if (g16 != null && !isCancelled()) {
                FriendProfileCardBgDrawable.this.f178211h = g16;
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis < longValue) {
                    FriendProfileCardBgDrawable friendProfileCardBgDrawable4 = FriendProfileCardBgDrawable.this;
                    friendProfileCardBgDrawable4.I.postDelayed(friendProfileCardBgDrawable4, longValue - uptimeMillis);
                } else {
                    FriendProfileCardBgDrawable friendProfileCardBgDrawable5 = FriendProfileCardBgDrawable.this;
                    friendProfileCardBgDrawable5.I.post(friendProfileCardBgDrawable5);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r26) {
            FriendProfileCardBgDrawable.this.K = null;
        }
    }

    public FriendProfileCardBgDrawable(Resources resources, k kVar) {
        this.Q = false;
        this.M = resources;
        this.C = kVar;
        if (kVar != null) {
            String[] strArr = kVar.f309614b;
            if (strArr != null) {
                this.Q = true;
            }
            n(strArr, kVar.f309620h, kVar.f309613a);
        }
    }

    @TargetApi(19)
    public static boolean b(Bitmap bitmap, int i3, int i16) {
        if (i3 * i16 * j(bitmap.getConfig()) <= bitmap.getAllocationByteCount()) {
            return true;
        }
        return false;
    }

    private void e() throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            if (this.f178213m == null) {
                String str = "profilecard:" + this.C.f309613a;
                ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                Bitmap f16 = imageCacheHelper.f(str);
                if (f16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendProfileCardBgDrawable", 2, "get background form sImageCache filePath= " + this.C.f309613a);
                    }
                    this.f178213m = f16;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendProfileCardBgDrawable", 2, "cache not exists, decode new one, filePath= " + this.C.f309613a);
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.C.f309613a));
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                        if (options.outWidth == this.G && options.outHeight == this.H) {
                            this.f178213m = decodeStream;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("FriendProfileCardBgDrawable", 2, "Background size not match screen size, create a new one to resize");
                            }
                            if (decodeStream != null) {
                                if (this.G > 0 && this.H > 0) {
                                    int width = (decodeStream.getWidth() - this.G) / 2;
                                    int height = decodeStream.getHeight();
                                    int i3 = this.H;
                                    this.f178213m = Bitmap.createBitmap(decodeStream, width, (height - i3) / 2, this.G, i3);
                                } else {
                                    this.f178213m = decodeStream;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("FriendProfileCardBgDrawable", 2, "decodeBg, can out creatBitmap mWidth = " + this.G + " mHeight = " + this.H);
                                    }
                                }
                                decodeStream.recycle();
                            } else {
                                QLog.e("FriendProfileCardBgDrawable", 1, "decodeBg, original bitmap == null");
                            }
                        }
                        imageCacheHelper.i(str, this.f178213m, Business.AIO);
                        bufferedInputStream = bufferedInputStream2;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            QLog.e("FriendProfileCardBgDrawable", 1, "decodeBg Error e = " + th);
                            if (bufferedInputStream == null) {
                                return;
                            }
                        } finally {
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void h(int i3, int i16, int i17, int i18) {
        k kVar = this.C;
        if (kVar != null && this.Q) {
            float f16 = this.G / i3;
            float f17 = this.H / i16;
            float f18 = i17;
            int i19 = (int) (kVar.f309615c * f18);
            float f19 = i18;
            int i26 = (int) (kVar.f309616d * f19);
            int i27 = (int) (kVar.f309617e * f18);
            int i28 = (int) (kVar.f309618f * f19);
            int i29 = (int) (i19 / f16);
            int i36 = (int) (i26 / f17);
            this.R = new Rect(i29, i36, ((int) (i27 / f16)) + i29, ((int) (i28 / f17)) + i36);
        }
    }

    static int j(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    private void n(String[] strArr, int i3, String str) {
        StringBuilder sb5;
        int i16;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                Rect bounds = getBounds();
                DisplayMetrics displayMetrics = this.M.getDisplayMetrics();
                int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
                int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
                if (bounds.width() != 0) {
                    min = bounds.width();
                }
                if (bounds.height() != 0) {
                    max = bounds.height();
                }
                int i17 = this.V;
                if (i17 != 0 && i17 == min && (i16 = this.W) != 0 && i16 == max) {
                    return;
                }
                this.V = min;
                this.W = max;
                this.f178208d = strArr;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                try {
                    BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                    int i18 = options.outHeight;
                    int i19 = options.outWidth;
                    float f16 = min / max;
                    int min2 = Math.min(i19, (int) (i18 * f16));
                    this.G = min2;
                    this.H = (int) (min2 / f16);
                    this.S = new Rect(0, 0, min, max);
                    if (!this.Q) {
                        try {
                            bufferedInputStream2.close();
                            return;
                        } catch (IOException e16) {
                            QLog.e("FriendProfileCardBgDrawable", 1, "setPngPaths  e = " + e16);
                            return;
                        }
                    }
                    h(min, max, i19, i18);
                    this.E = strArr.length;
                    this.F = i3;
                    this.N = Integer.MAX_VALUE;
                    this.P = false;
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e17) {
                        e = e17;
                        sb5 = new StringBuilder();
                        sb5.append("setPngPaths  e = ");
                        sb5.append(e);
                        QLog.e("FriendProfileCardBgDrawable", 1, sb5.toString());
                    }
                } catch (IOException e18) {
                    e = e18;
                    bufferedInputStream = bufferedInputStream2;
                    QLog.e("FriendProfileCardBgDrawable", 1, "setPngPaths error: " + e.getMessage());
                    l();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e19) {
                            e = e19;
                            sb5 = new StringBuilder();
                            sb5.append("setPngPaths  e = ");
                            sb5.append(e);
                            QLog.e("FriendProfileCardBgDrawable", 1, sb5.toString());
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e26) {
                            QLog.e("FriendProfileCardBgDrawable", 1, "setPngPaths  e = " + e26);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e27) {
            e = e27;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        Rect rect;
        Paint paint;
        Rect rect2;
        if (this.U) {
            QLog.e("FriendProfileCardBgDrawable", 1, "draw, FriendProfileCardBgDrawable has been recycled");
            return;
        }
        k kVar = this.C;
        if (kVar != null) {
            String[] strArr = kVar.f309614b;
            if (strArr != null) {
                this.Q = true;
            }
            n(strArr, kVar.f309620h, kVar.f309613a);
        }
        if (!this.Q) {
            Bitmap bitmap2 = this.f178213m;
            if (bitmap2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("FriendProfileCardBgDrawable", 2, "canvas.width:" + canvas.getWidth() + " canvas.height:" + canvas.getHeight());
                }
                f();
                return;
            }
            if (this.f178209e != null) {
                if (bitmap2.isRecycled()) {
                    this.f178213m = null;
                    QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBackground has been recycled");
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardBgDrawable", 2, "draw static background");
                }
                Rect rect3 = this.S;
                if (rect3 != null) {
                    canvas.drawBitmap(this.f178213m, (Rect) null, rect3, this.f178209e);
                    return;
                }
                return;
            }
            return;
        }
        Bitmap bitmap3 = this.f178213m;
        if (bitmap3 != null && !bitmap3.isRecycled() && (paint = this.f178209e) != null && (rect2 = this.S) != null) {
            canvas.drawBitmap(this.f178213m, (Rect) null, rect2, paint);
        }
        if (this.D != -1 && (bitmap = this.f178210f) != null) {
            if (bitmap.isRecycled()) {
                this.f178210f = null;
                QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBitmap has been recycled");
            } else {
                Paint paint2 = this.f178209e;
                if (paint2 != null && (rect = this.R) != null) {
                    canvas.drawBitmap(this.f178210f, (Rect) null, rect, paint2);
                }
            }
        }
        if (this.N == 0) {
            super.invalidateSelf();
            this.P = true;
        } else {
            f();
        }
    }

    protected void f() {
        if (this.U) {
            QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame, FriendProfileCardBgDrawable has been recycled");
            return;
        }
        if (this.J && !this.L) {
            this.J = false;
            long uptimeMillis = SystemClock.uptimeMillis() + this.F;
            if (this.K != null) {
                QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame mTask != null currentFrame = " + this.D);
            }
            a aVar = new a(this.f178208d);
            this.K = aVar;
            aVar.execute(Long.valueOf(uptimeMillis), Long.valueOf(this.D));
        }
    }

    @TargetApi(11)
    protected Bitmap g(Object obj, int i3) throws IOException {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.C == null) {
            return null;
        }
        e();
        if (!this.Q) {
            return null;
        }
        String[] strArr = (String[]) obj;
        int length = (i3 + 1) % strArr.length;
        String str = strArr[length];
        options.inDensity = 320;
        options.inTargetDensity = this.M.getDisplayMetrics().densityDpi;
        options.inMutable = true;
        options.inSampleSize = 1;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(strArr[length]));
        BitmapFactory.decodeStream(bufferedInputStream, null, options2);
        bufferedInputStream.close();
        if (this.f178212i != null) {
            synchronized (this.T) {
                bitmap = this.f178212i;
                if (bitmap != null) {
                    this.f178212i = null;
                } else {
                    bitmap = null;
                }
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null && b(bitmap, options2.outWidth, options2.outHeight)) {
            options.inBitmap = bitmap;
        } else {
            options.inBitmap = null;
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
        bufferedInputStream2.close();
        return decodeStream;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.H;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public Bitmap i() {
        if (this.f178213m == null) {
            try {
                e();
            } catch (IOException e16) {
                QLog.e("FriendProfileCardBgDrawable", 2, "decode Bg error, e.message = " + e16.toString());
            }
        }
        return this.f178213m;
    }

    protected int k(int i3) {
        if (i3 == this.E - 1) {
            this.N--;
            return 0;
        }
        return i3 + 1;
    }

    public void l() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    FriendProfileCardBgDrawable.this.m();
                }
            });
        } else {
            m();
        }
    }

    public void m() {
        this.U = true;
        Bitmap bitmap = this.f178210f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f178210f = null;
        }
        Bitmap bitmap2 = this.f178211h;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f178211h = null;
        }
        a aVar = this.K;
        if (aVar != null) {
            aVar.cancel(false);
            this.K = null;
        }
        if (this.f178212i != null) {
            synchronized (this.T) {
                Bitmap bitmap3 = this.f178212i;
                if (bitmap3 != null) {
                    bitmap3.recycle();
                    this.f178212i = null;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        if (!this.Q) {
            super.invalidateSelf();
            this.J = true;
            return;
        }
        if (this.f178211h == null) {
            return;
        }
        this.J = true;
        this.D = k(this.D);
        Bitmap bitmap2 = this.f178211h;
        if (bitmap2 != null && (bitmap = this.f178210f) != bitmap2) {
            if (bitmap != null) {
                this.f178212i = bitmap;
            }
            this.f178210f = bitmap2;
            this.f178211h = null;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f178209e.getAlpha()) {
            this.f178209e.setAlpha(i3);
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f178209e.setColorFilter(colorFilter);
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.f178209e.setDither(z16);
        super.invalidateSelf();
    }
}
