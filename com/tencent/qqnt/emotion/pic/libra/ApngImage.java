package com.tencent.qqnt.emotion.pic.libra;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.pic.libra.b;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes24.dex */
public class ApngImage implements Runnable {

    /* renamed from: e0, reason: collision with root package name */
    protected static final ArrayList<WeakReference<ApngImage>> f356293e0 = new ArrayList<WeakReference<ApngImage>>(105) { // from class: com.tencent.qqnt.emotion.pic.libra.ApngImage.1
        private void d() {
            if (size() > 100) {
                removeRange(0, (r0 - 100) - 1);
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(WeakReference<ApngImage> weakReference) {
            boolean add = super.add((AnonymousClass1) weakReference);
            d();
            return add;
        }
    };

    /* renamed from: f0, reason: collision with root package name */
    public static ArrayList<Integer> f356294f0 = new ArrayList<>();

    /* renamed from: g0, reason: collision with root package name */
    public static int f356295g0 = 1;

    /* renamed from: h0, reason: collision with root package name */
    protected static boolean f356296h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private static int f356297i0 = 262144;

    /* renamed from: j0, reason: collision with root package name */
    private static Handler f356298j0;

    /* renamed from: k0, reason: collision with root package name */
    private static ArgumentsRunnable<WeakReference<ApngImage>> f356299k0;
    public boolean C;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    protected File J;
    protected int K;
    long Q;
    long R;
    int S;
    int[] T;
    private Bitmap Y;
    private Bitmap Z;

    /* renamed from: b0, reason: collision with root package name */
    private long f356301b0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f356304d0;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap f356307h;

    /* renamed from: i, reason: collision with root package name */
    public int f356308i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f356309m;

    /* renamed from: d, reason: collision with root package name */
    public int f356303d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f356305e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f356306f = 0;
    public boolean D = true;
    protected boolean I = false;
    protected int L = 160;
    protected ArrayList<WeakReference<b.InterfaceC9615b>> M = new ArrayList<>();
    boolean N = false;
    int[] P = new int[7];
    private Paint U = new Paint();
    private Paint V = new Paint();
    private boolean W = true;
    private boolean X = false;

    /* renamed from: a0, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<com.tencent.qqnt.emotion.pic.libra.a>> f356300a0 = new CopyOnWriteArrayList<>();

    /* renamed from: c0, reason: collision with root package name */
    private boolean f356302c0 = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class DoAccumulativeRunnable extends ArgumentsRunnable<WeakReference<ApngImage>> {

        /* renamed from: e, reason: collision with root package name */
        private long f356310e = 0;

        DoAccumulativeRunnable() {
        }

        @Override // com.tencent.qqnt.emotion.pic.libra.ArgumentsRunnable
        protected void f(List<WeakReference<ApngImage>> list) {
            ApngImage apngImage;
            for (WeakReference<ApngImage> weakReference : list) {
                if (weakReference != null && (apngImage = weakReference.get()) != null) {
                    apngImage.i();
                }
            }
            this.f356310e = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.qqnt.emotion.pic.libra.ArgumentsRunnable
        protected void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.f356310e;
            if (j3 != 0 && uptimeMillis - j3 <= 5) {
                ApngImage.f356298j0.postDelayed(this, 5 - (uptimeMillis - this.f356310e));
            } else {
                run();
                this.f356310e = uptimeMillis;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    private static final class FinalizeNativeRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final long f356311d;

        /* renamed from: e, reason: collision with root package name */
        private final long f356312e;

        FinalizeNativeRunnable(long j3, long j16) {
            this.f356311d = j3;
            this.f356312e = j16;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long j3 = this.f356311d;
                if (j3 != 0) {
                    com.tencent.image.ApngImage.nativeFreeFrame(j3);
                }
                long j16 = this.f356312e;
                if (j16 != 0) {
                    com.tencent.image.ApngImage.nativeFreeImage(j16);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.e("LibraApngImage", 1, "freeNativeInstance error", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a extends AsyncTask<Void, Void, Object> {

        /* renamed from: a, reason: collision with root package name */
        long f356313a;

        public a(long j3) {
            this.f356313a = j3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(Void... voidArr) {
            try {
                ApngImage.this.x(ApngImage.this.o(), this.f356313a);
                return null;
            } catch (Throwable th5) {
                return th5;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ApngImage.this.v();
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object obj) {
            if (obj instanceof Throwable) {
                ApngImage.this.w((Throwable) obj);
            }
        }
    }

    public ApngImage(File file, boolean z16) throws IOException {
        this.J = file;
        r(z16);
    }

    public static final void A(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("LibraApngImage", 2, "playByTag , conplayids:" + f356294f0 + ", tag:" + i3);
        }
        if (f356296h0) {
            y();
        }
        if (!f356294f0.contains(Integer.valueOf(i3))) {
            f356294f0.add(Integer.valueOf(i3));
        }
        C();
    }

    public static final synchronized void C() {
        synchronized (ApngImage.class) {
            f356296h0 = false;
            for (int size = f356293e0.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<ApngImage>> arrayList = f356293e0;
                ApngImage apngImage = arrayList.get(size).get();
                if (apngImage == null) {
                    arrayList.remove(size);
                } else if (apngImage.n()) {
                    arrayList.remove(size);
                    apngImage.B();
                }
            }
        }
    }

    public static int D(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    private void m(File file) {
        this.R = com.tencent.image.ApngImage.nativeStartDecode(file.getAbsolutePath(), this.P, this.S);
        int[] iArr = this.P;
        if (iArr[5] == 0) {
            int i3 = iArr[0];
            this.f356303d = i3;
            int i16 = iArr[1];
            this.f356305e = i16;
            int i17 = iArr[2];
            this.f356306f = i17;
            if (this.G) {
                this.f356308i = iArr[6];
            }
            if (i3 > 0 && i16 > 0 && i17 > 0) {
                return;
            }
            throw new RuntimeException("bad apng, w=" + this.f356303d + " h=" + this.f356305e + " frames=" + this.f356306f);
        }
        throw new RuntimeException("start decode error: " + this.P[5]);
    }

    private void r(boolean z16) throws IOException {
        this.U.setAntiAlias(true);
        this.V.setAntiAlias(true);
        this.V.setColor(0);
        this.f356304d0 = z16;
        m(this.J);
        s();
        if (!o() || this.f356306f == 1) {
            this.X = true;
        }
        h();
        if (z16) {
            this.f356307h = this.Y;
        }
        if (this.X) {
            this.f356307h = this.Y;
            this.Z = null;
        }
    }

    private void s() {
        int i3;
        int i16;
        int i17 = this.f356303d;
        if (i17 > 0 && (i3 = this.f356305e) > 0) {
            try {
                this.Y = Bitmap.createBitmap(i17, i3, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                try {
                    this.Y = Bitmap.createBitmap(this.f356303d, this.f356305e, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused2) {
                    QLog.e("LibraApngImage", 1, "APNG create Bitmap OOM");
                }
            }
            int i18 = this.f356303d;
            if (i18 > 0 && (i16 = this.f356305e) > 0) {
                if (this.C || i18 * i16 <= f356297i0) {
                    try {
                        this.Z = Bitmap.createBitmap(i18, i16, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused3) {
                        QLog.e("LibraApngImage", 1, "APNG buffer create OOM");
                    }
                }
            }
        }
    }

    private void u() {
        synchronized (this.f356300a0) {
            for (int i3 = 0; i3 < this.f356300a0.size(); i3++) {
                WeakReference<com.tencent.qqnt.emotion.pic.libra.a> weakReference = this.f356300a0.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().invalidateSelf();
                }
            }
        }
    }

    public static final void y() {
        f356296h0 = true;
        synchronized (f356294f0) {
            f356294f0.clear();
        }
    }

    public static final void z(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("LibraApngImage", 2, "pauseByTag , conplayids:" + f356294f0 + ", tag:" + i3);
        }
        synchronized (f356294f0) {
            int indexOf = f356294f0.indexOf(Integer.valueOf(i3));
            if (indexOf >= 0) {
                f356294f0.remove(indexOf);
            }
        }
    }

    public void B() {
        u();
        this.N = false;
    }

    public void f(com.tencent.qqnt.emotion.pic.libra.a aVar) {
        if (aVar != null) {
            synchronized (this.f356300a0) {
                this.f356300a0.add(new WeakReference<>(aVar));
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            f356298j0.post(new FinalizeNativeRunnable(this.Q, this.R));
            this.Q = 0L;
            this.R = 0L;
        } finally {
            super.finalize();
        }
    }

    void g(ApngImage apngImage) {
        if (apngImage != null && !apngImage.N) {
            for (int size = f356293e0.size() - 1; size >= 0; size--) {
                if (f356293e0.get(size).get() == apngImage) {
                    return;
                }
            }
            f356293e0.add(new WeakReference<>(apngImage));
            apngImage.N = true;
        }
    }

    public synchronized void h() {
        if (this.Z != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(this.Y);
            this.Y.eraseColor(0);
            if (this.E) {
                paint.setFilterBitmap(true);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.f356303d, this.f356305e), this.f356303d, this.f356305e, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawBitmap(this.Z, 0.0f, 0.0f, paint);
        }
    }

    protected void i() {
        h();
        this.f356302c0 = true;
        if (n()) {
            u();
        } else {
            g(this);
        }
    }

    public void j(Canvas canvas, Rect rect, Rect rect2, Paint paint, boolean z16) {
        if (canvas != null && rect2 != null) {
            int i3 = this.f356308i;
            if (i3 > 0 && i3 <= this.H && this.f356309m) {
                canvas.drawColor(16777215);
                return;
            }
            t();
            if (!this.X && z16) {
                Bitmap bitmap = this.Y;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, rect, rect2, paint);
                }
                if (n()) {
                    int i16 = this.f356308i;
                    if (i16 > 0 && i16 <= this.H) {
                        if (this.F && this.P[3] == this.f356306f - 1) {
                            k();
                            return;
                        }
                        return;
                    }
                    k();
                    return;
                }
                g(this);
                return;
            }
            Bitmap bitmap2 = this.f356307h;
            if (bitmap2 != null) {
                try {
                    canvas.drawBitmap(bitmap2, rect, rect2, paint);
                } catch (RuntimeException e16) {
                    QLog.e("LibraApngImage", 1, "draw first frame error, width:" + this.f356303d + ", height:" + this.f356305e, e16);
                    this.f356307h = null;
                }
            }
        }
    }

    protected void k() {
        if (this.f356302c0) {
            this.f356302c0 = false;
            int l3 = l();
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.f356301b0;
            if (j3 == 0) {
                this.f356301b0 = uptimeMillis;
            } else if (j3 + (l3 * 2) <= uptimeMillis) {
                this.f356301b0 = uptimeMillis;
            }
            this.f356301b0 += l3;
            try {
                new a(this.f356301b0).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            } catch (RejectedExecutionException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("LibraApngImage", 2, "executeNewTask()", e16);
                }
            }
        }
    }

    public int l() {
        return this.K;
    }

    final boolean n() {
        if (this.I) {
            return false;
        }
        if (this.W && f356296h0) {
            return false;
        }
        if (this.T == null) {
            return true;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.T;
            if (i3 >= iArr.length) {
                return false;
            }
            if (f356294f0.contains(Integer.valueOf(iArr[i3]))) {
                return true;
            }
            i3++;
        }
    }

    protected synchronized boolean o() {
        long j3 = this.R;
        if (j3 != 0) {
            Bitmap bitmap = this.Z;
            if (bitmap != null) {
                this.Q = com.tencent.image.ApngImage.nativeGetNextFrame(j3, this.Q, bitmap, this.P);
            } else {
                this.Q = com.tencent.image.ApngImage.nativeGetNextFrame(j3, this.Q, this.Y, this.P);
            }
            int[] iArr = this.P;
            if (iArr[5] == 0) {
                this.K = iArr[4];
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LibraApngImage", 2, "getNextFrame fail: " + this.P[5]);
            }
        }
        return false;
    }

    public int p(int i3) {
        return D(this.f356305e, this.L, i3);
    }

    public int q(int i3) {
        return D(this.f356303d, this.L, i3);
    }

    @Override // java.lang.Runnable
    public void run() {
        f356299k0.a(new WeakReference<>(this));
    }

    protected void t() {
        if (f356298j0 == null) {
            f356298j0 = new Handler(Looper.getMainLooper());
            f356299k0 = new DoAccumulativeRunnable();
        }
    }

    void v() {
        if (QLog.isColorLevel()) {
            QLog.e("LibraApngImage", 2, "apng decode canceled. " + this.J);
        }
        this.f356302c0 = true;
    }

    void w(Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.e("LibraApngImage", 2, "apng decode error. " + this.J, th5);
        }
        this.f356302c0 = true;
    }

    void x(boolean z16, long j3) {
        if (z16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis < j3) {
                f356298j0.postDelayed(this, j3 - uptimeMillis);
            } else {
                f356298j0.post(this);
            }
            if (this.f356308i > 0 && this.f356306f == this.P[3] + 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("LibraApngImage", 2, "apng mFrameCount:" + this.f356306f + ", current:" + this.P[3]);
                }
                this.H++;
                synchronized (this.M) {
                    for (int size = this.M.size() - 1; size >= 0; size--) {
                        b.InterfaceC9615b interfaceC9615b = this.M.get(size).get();
                        if (interfaceC9615b != null) {
                            interfaceC9615b.onPlayRepeat(this.H);
                        } else {
                            this.M.remove(size);
                        }
                    }
                }
            }
        }
    }
}
