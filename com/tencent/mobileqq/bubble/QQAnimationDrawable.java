package com.tencent.mobileqq.bubble;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.ref.SoftReference;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes11.dex */
public class QQAnimationDrawable extends Drawable implements Runnable, Animatable {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name */
    public static final ExecutorService f200602c0;

    /* renamed from: d0, reason: collision with root package name */
    public static byte[] f200603d0;
    private long C;
    private Bitmap D;
    Bitmap E;
    Bitmap F;
    private int G;
    private boolean H;
    private WorkerRunnable I;
    int J;
    private int[] K;
    private String[] L;
    private BitmapFactory.Options M;
    private int N;
    private boolean P;
    private ArrayList<Bitmap> Q;
    private HashMap<String, SoftReference<Bitmap>> R;
    private String S;
    private int T;
    private int U;
    private boolean V;
    private Object W;
    private long X;
    private int Y;
    private volatile SerialExecutor Z;

    /* renamed from: a0, reason: collision with root package name */
    private FutureTask<Bitmap> f200604a0;

    /* renamed from: b0, reason: collision with root package name */
    private Set<SoftReference<Bitmap>> f200605b0;

    /* renamed from: d, reason: collision with root package name */
    private Paint f200606d;

    /* renamed from: e, reason: collision with root package name */
    protected int f200607e;

    /* renamed from: f, reason: collision with root package name */
    private int f200608f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f200609h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f200610i;

    /* renamed from: m, reason: collision with root package name */
    private int f200611m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SerialExecutor implements Executor {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final b<Runnable> f200612d;

        /* renamed from: e, reason: collision with root package name */
        Runnable f200613e;

        SerialExecutor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f200612d = new b<>(30);
            }
        }

        protected synchronized void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f200612d.a();
            }
        }

        protected synchronized void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Runnable c16 = this.f200612d.c();
            this.f200613e = c16;
            if (c16 != null) {
                QLog.d("QQAnimationDrawable", 2, "scheduleNext start");
                QQAnimationDrawable.f200602c0.execute(this.f200613e);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
                return;
            }
            QLog.d("QQAnimationDrawable", 2, "SerialExecutor excute");
            this.f200612d.b(new Runnable(runnable) { // from class: com.tencent.mobileqq.bubble.QQAnimationDrawable.SerialExecutor.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Runnable f200614d;

                {
                    this.f200614d = runnable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SerialExecutor.this, (Object) runnable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QLog.d("QQAnimationDrawable", 2, "SerialExecutor run");
                        this.f200614d.run();
                    } finally {
                        QLog.d("QQAnimationDrawable", 2, "SerialExecutor scheduleNext");
                        SerialExecutor.this.b();
                    }
                }
            });
            if (this.f200613e == null) {
                QLog.d("QQAnimationDrawable", 2, "SerialExecutor mActive == null scheduleNext");
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class WorkerRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f200615d;

        /* renamed from: e, reason: collision with root package name */
        private long f200616e;

        public WorkerRunnable(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQAnimationDrawable.this, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                this.f200615d = i3;
                this.f200616e = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("WorkerRunnable run | drawtime:");
            sb5.append(this.f200616e);
            sb5.append(" main:");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("QQAnimationDrawable", 2, sb5.toString());
            Process.setThreadPriority(10);
            long uptimeMillis = SystemClock.uptimeMillis();
            QQAnimationDrawable qQAnimationDrawable = QQAnimationDrawable.this;
            qQAnimationDrawable.F = qQAnimationDrawable.u(false, this.f200615d);
            QQAnimationDrawable.this.G = this.f200615d;
            QQAnimationDrawable qQAnimationDrawable2 = QQAnimationDrawable.this;
            if (qQAnimationDrawable2.E == null && this.f200615d == 0) {
                qQAnimationDrawable2.E = qQAnimationDrawable2.F;
            }
            QQAnimationDrawable.a(qQAnimationDrawable2);
            QQAnimationDrawable qQAnimationDrawable3 = QQAnimationDrawable.this;
            qQAnimationDrawable3.scheduleSelf(qQAnimationDrawable3, SystemClock.uptimeMillis() + Math.max(this.f200616e - uptimeMillis, 0L));
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final AbstractCollection<T> f200617a;

        public b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f200617a = new ArrayDeque();
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f200617a.clear();
            }
        }

        public void b(T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) t16);
                return;
            }
            AbstractCollection<T> abstractCollection = this.f200617a;
            if (abstractCollection instanceof ArrayDeque) {
                ((ArrayDeque) abstractCollection).offer(t16);
            }
        }

        public T c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (T) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            AbstractCollection<T> abstractCollection = this.f200617a;
            if (abstractCollection instanceof ArrayDeque) {
                return (T) ((ArrayDeque) abstractCollection).poll();
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            f200602c0 = ProxyExecutors.newSingleThreadExecutor();
            f200603d0 = new byte[24576];
        }
    }

    public QQAnimationDrawable() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private void A(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QQAnimationDrawable", 4, str);
        }
    }

    private void B(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.e("QQAnimationDrawable", 4, str);
        }
    }

    private void C(boolean z16) {
        if (z16) {
            QLog.d("QQAnimationDrawable", 1, "playEnd mCountOfFrame" + this.f200608f);
            stop();
            QLog.d("QQAnimationDrawable", 1, hashCode() + "playEnd listener" + String.valueOf(false));
        }
    }

    private void J() {
        long j3 = this.X;
        long j16 = 0;
        if (j3 == 0) {
            int i3 = this.Y;
            if (i3 != 0) {
                j16 = this.C / i3;
            }
            this.X = j16;
            return;
        }
        if (this.C == 0) {
            this.C = j3 * this.Y;
        }
    }

    static /* bridge */ /* synthetic */ a a(QQAnimationDrawable qQAnimationDrawable) {
        qQAnimationDrawable.getClass();
        return null;
    }

    private void d(BitmapFactory.Options options) {
        options.inMutable = true;
        Bitmap v3 = v(options);
        if (v3 != null) {
            options.inBitmap = v3;
        }
    }

    public static int e(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i17 <= i16 && i18 <= i3) {
            return 1;
        }
        int i19 = 2;
        while (true) {
            if (i17 / i19 <= i16 && i18 / i19 <= i3) {
                return i19;
            }
            i19 *= 2;
        }
    }

    @TargetApi(19)
    private static boolean f(Bitmap bitmap, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        int i16 = options.inSampleSize;
        if ((i3 / i16) * (options.outHeight / i16) * w(bitmap.getConfig()) <= bitmap.getAllocationByteCount()) {
            return true;
        }
        return false;
    }

    private void j() {
        ArrayList<Bitmap> arrayList = this.Q;
        if (arrayList != null) {
            Iterator<Bitmap> it = arrayList.iterator();
            while (it.hasNext()) {
                Bitmap next = it.next();
                if (next != null && !next.isRecycled()) {
                    next.recycle();
                }
            }
            this.Q.clear();
        }
    }

    private void k() {
        Bitmap bitmap;
        HashMap<String, SoftReference<Bitmap>> hashMap = this.R;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                SoftReference<Bitmap> softReference = this.R.get(it.next());
                if (softReference != null && (bitmap = softReference.get()) != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.R.clear();
        }
    }

    private void m(Bitmap bitmap, long j3, String str) {
        try {
            if (bitmap == null) {
                BitmapFactory.Options options = this.M;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + str + " " + this.M.outWidth + "\u2014\u2014" + this.M.outHeight);
                }
                BitmapFactory.Options options2 = this.M;
                Bitmap.createBitmap(options2.outWidth, options2.outHeight, Bitmap.Config.ARGB_8888);
                return;
            }
            BitmapFactory.Options options3 = this.M;
            options3.inJustDecodeBounds = false;
            options3.inBitmap = bitmap;
            options3.inSampleSize = 1;
            options3.inDensity = 320;
            options3.inTargetDensity = this.J;
            BitmapFactory.decodeFile(str, options3);
            if (QLog.isDevelopLevel()) {
                QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - j3));
            }
        } catch (Exception e16) {
            B(e16.getMessage());
        } catch (OutOfMemoryError unused) {
            B("getBitmapFromFile OOM");
        }
    }

    private void n(Bitmap bitmap, long j3, int i3) {
        try {
            if (bitmap == null) {
                this.M.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i3, this.M);
                BitmapFactory.Options options = this.M;
                Bitmap.createBitmap(options.outWidth, options.outHeight, Bitmap.Config.ARGB_8888);
            } else {
                BitmapFactory.Options options2 = this.M;
                options2.inJustDecodeBounds = false;
                options2.inBitmap = bitmap;
                options2.inSampleSize = 1;
                options2.inDensity = 320;
                options2.inTargetDensity = this.J;
                BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i3, this.M);
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - j3));
                }
            }
        } catch (Exception e16) {
            B(e16.getMessage());
        } catch (OutOfMemoryError unused) {
            B("getBitmapFromFile OOM");
        }
    }

    private synchronized Bitmap o(boolean z16, int i3) {
        Bitmap t16 = t(i3);
        if (t16 != null) {
            return t16;
        }
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                BitmapFactory.Options options = this.M;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.S, options);
                BitmapFactory.Options options2 = this.M;
                int i16 = (int) (options2.outWidth / (this.T * 1.0f));
                int i17 = (int) (options2.outHeight / (this.U * 1.0f));
                options2.inJustDecodeBounds = false;
                options2.inDensity = 320;
                options2.inTargetDensity = this.J;
                Bitmap decodeFile = BitmapFactory.decodeFile(this.S, options2);
                for (int i18 = 0; i18 < this.U; i18++) {
                    int i19 = 0;
                    while (i19 < this.T) {
                        int i26 = i19;
                        Bitmap createBitmap = Bitmap.createBitmap(decodeFile, i19 * i16, i18 * i17, i16, i17, (Matrix) null, true);
                        if (createBitmap != null) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("QQAnimationDrawable", 4, "cache " + ((i18 * 8) + i26));
                            }
                            this.Q.add(createBitmap);
                        }
                        i19 = i26 + 1;
                    }
                }
                if (decodeFile != null && !decodeFile.isRecycled()) {
                    decodeFile.recycle();
                }
                this.f200608f = this.Q.size();
                A("create bitmap " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e16) {
                B(e16.getMessage());
            }
        } catch (OutOfMemoryError unused) {
            B("getBitmapFromFile OOM");
        }
        return this.Q.get(i3);
    }

    private synchronized Bitmap p(boolean z16, int i3, Bitmap bitmap) {
        int[] iArr = this.K;
        if (iArr != null && i3 < iArr.length) {
            long currentTimeMillis = System.currentTimeMillis();
            int i16 = this.K[i3];
            if (i16 > 0) {
                if (this.P) {
                    SoftReference<Bitmap> softReference = this.R.get(Integer.valueOf(i16));
                    if (softReference != null && softReference.get() != null) {
                        return softReference.get();
                    }
                    try {
                        bitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i16);
                        this.R.put(String.valueOf(i16), new SoftReference<>(bitmap));
                    } catch (OutOfMemoryError unused) {
                    }
                } else {
                    n(this.F, currentTimeMillis, i16);
                    bitmap = this.F;
                }
            }
        }
        return bitmap;
    }

    private synchronized Bitmap q(boolean z16, int i3, Bitmap bitmap) {
        String[] strArr = this.L;
        if (strArr != null && i3 < strArr.length) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.L[i3];
            if (str != null) {
                if (this.P) {
                    SoftReference<Bitmap> softReference = this.R.get(str);
                    if (softReference != null && softReference.get() != null) {
                        return softReference.get();
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        options.inTempStorage = f200603d0;
                        BitmapFactory.decodeFile(str, options);
                        int e16 = e(options, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels);
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = e16;
                        d(options);
                        bitmap = BaseImageUtil.decodeFileWithBufferedStream(str, options);
                        if (bitmap != null && !bitmap.isRecycled()) {
                            this.f200605b0.add(new SoftReference<>(bitmap));
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                } else {
                    m(this.F, currentTimeMillis, str);
                    bitmap = this.F;
                }
            }
        }
        return bitmap;
    }

    @Nullable
    private Bitmap t(int i3) {
        Bitmap bitmap;
        if (i3 < this.Q.size() && (bitmap = this.Q.get(i3)) != null) {
            return bitmap;
        }
        return null;
    }

    private static int w(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    private void z(boolean z16, boolean z17, boolean z18) {
        long uptimeMillis;
        boolean z19 = true;
        int i3 = this.f200607e + 1;
        if (i3 >= this.f200608f) {
            i3 = 0;
        }
        if (z17) {
            unscheduleSelf(this);
        }
        if ((!this.f200609h && this.f200611m > 0) || i3 < this.f200608f - 1) {
            z19 = false;
        }
        QLog.d("QQAnimationDrawable", 4, "animation QQAnimationDrawable loadNextBitmap  playEnd:" + z19 + ",mDecodeNextFrameEnd:" + this.H + ",animate:" + z18);
        if (!z19 && this.H && z18) {
            this.H = false;
            if (z16) {
                uptimeMillis = 0;
            } else {
                uptimeMillis = SystemClock.uptimeMillis() + this.X;
            }
            this.I = new WorkerRunnable(i3, uptimeMillis);
            this.Z.execute(this.I);
        }
        C(z19);
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QQAnimationDrawable", 4, " reset");
        }
        this.f200611m = 1;
        this.f200607e = -1;
        this.G = 0;
        this.F = null;
        this.D = null;
        g();
    }

    public void E(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        } else {
            this.C = j3;
            J();
        }
    }

    public void F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f200609h = z16;
        }
    }

    public void G(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) strArr);
            return;
        }
        H(0);
        if (!Arrays.equals(this.L, strArr)) {
            h();
            this.L = strArr;
        }
        String[] strArr2 = this.L;
        if (strArr2 != null) {
            this.f200608f = strArr2.length;
        } else {
            this.f200608f = 0;
        }
        this.Y = strArr.length;
        J();
    }

    public void H(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.N = i3;
        }
    }

    public void I(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f200610i = false;
        this.f200611m = i3;
        if (i3 > 1) {
            F(false);
        } else if (i3 == 1) {
            F(true);
        }
        start();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("animation QQAnimationDrawable draw  currentBitmap == null ");
        if (this.D == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("QQAnimationDrawable", 4, sb5.toString());
        synchronized (this.W) {
            Bitmap bitmap = this.D;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.D, (Rect) null, getBounds(), this.f200606d);
            }
        }
        z(false, false, true);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (this.Z != null) {
            this.Z.a();
        }
        FutureTask<Bitmap> futureTask = this.f200604a0;
        if (futureTask != null) {
            futureTask.cancel(true);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            return bitmap.getScaledHeight(this.J);
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            return bitmap.getScaledWidth(this.J);
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return -2;
    }

    public synchronized void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        Bitmap bitmap = this.E;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.E.recycle();
        }
        Bitmap bitmap2 = this.D;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            synchronized (this.W) {
                this.D.recycle();
            }
        }
        Bitmap bitmap3 = this.F;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.F.recycle();
        }
        j();
        k();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f200607e > -1) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!this.V) {
            return;
        }
        if (!this.f200610i && this.f200607e == x() - 1) {
            this.f200611m--;
        }
        this.H = true;
        Bitmap bitmap = this.F;
        if (bitmap != null) {
            this.D = bitmap;
        }
        int i3 = this.f200607e;
        this.f200607e = this.G;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.f200606d.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) colorFilter);
        } else {
            this.f200606d.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.f200606d.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.f200606d.setFilterBitmap(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (visible || z17) {
                y();
            }
        } else {
            unscheduleSelf(this);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.V = true;
        if (this.f200608f > 0 && this.X > 0 && !isRunning()) {
            this.H = true;
            z(true, false, true);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.V = false;
        QLog.d("QQAnimationDrawable", 4, " stop");
        if (isRunning()) {
            unscheduleSelf(this);
        }
        if (!this.f200610i) {
            this.f200611m = 1;
        }
        D();
    }

    Bitmap u(boolean z16, int i3) {
        int i16 = this.N;
        Bitmap bitmap = null;
        if (i16 == 0) {
            bitmap = q(z16, i3, null);
        } else if (i16 == 2) {
            bitmap = p(z16, i3, null);
        } else if (i16 == 1) {
            bitmap = o(z16, i3);
        }
        if (bitmap == null) {
            return this.F;
        }
        return bitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) runnable);
        } else {
            this.f200607e = -1;
            super.unscheduleSelf(runnable);
        }
    }

    protected Bitmap v(BitmapFactory.Options options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Bitmap) iPatchRedirector.redirect((short) 31, (Object) this, (Object) options);
        }
        Set<SoftReference<Bitmap>> set = this.f200605b0;
        Bitmap bitmap = null;
        if (set != null && !set.isEmpty()) {
            synchronized (this.f200605b0) {
                Iterator<SoftReference<Bitmap>> it = this.f200605b0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bitmap bitmap2 = it.next().get();
                    if (bitmap2 != null && bitmap2.isMutable()) {
                        if (f(bitmap2, options)) {
                            it.remove();
                            bitmap = bitmap2;
                            break;
                        }
                    } else {
                        it.remove();
                    }
                }
            }
        }
        return bitmap;
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.f200608f;
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    public QQAnimationDrawable(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f200606d = new Paint(6);
        this.f200607e = -1;
        this.f200608f = 0;
        this.f200609h = false;
        this.f200610i = true;
        this.f200611m = 1;
        this.C = 0L;
        this.G = 0;
        this.H = true;
        this.J = 160;
        this.M = new BitmapFactory.Options();
        this.N = 2;
        this.P = true;
        this.Q = new ArrayList<>();
        this.R = new HashMap<>();
        this.V = false;
        this.W = new Object();
        this.Z = new SerialExecutor();
        int i3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
        this.J = i3;
        this.J = i3 != 0 ? i3 : 160;
        this.f200605b0 = Collections.synchronizedSet(new HashSet());
    }
}
