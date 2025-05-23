package com.tencent.rlottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rlottie.decoder.DispatchQueuePool;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AXrLottieDrawable extends BitmapDrawable implements Animatable {
    static IPatchRedirector $redirector_;

    /* renamed from: m0, reason: collision with root package name */
    private static final Handler f365152m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final DispatchQueuePool f365153n0;

    /* renamed from: o0, reason: collision with root package name */
    private static ThreadPoolExecutor f365154o0;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private long I;
    private volatile boolean J;
    private Runnable K;
    private Runnable L;
    private volatile Bitmap M;
    private volatile Bitmap N;
    private volatile Bitmap P;
    private boolean Q;
    private CountDownLatch R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private boolean X;
    protected float Y;
    protected float Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f365155a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Rect f365156b0;

    /* renamed from: c0, reason: collision with root package name */
    private volatile boolean f365157c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f365158d;

    /* renamed from: d0, reason: collision with root package name */
    private volatile boolean f365159d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f365160e;

    /* renamed from: e0, reason: collision with root package name */
    private volatile long f365161e0;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f365162f;

    /* renamed from: f0, reason: collision with root package name */
    private c f365163f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Runnable f365164g0;

    /* renamed from: h, reason: collision with root package name */
    private int f365165h;

    /* renamed from: h0, reason: collision with root package name */
    private final Runnable f365166h0;

    /* renamed from: i, reason: collision with root package name */
    private float f365167i;

    /* renamed from: i0, reason: collision with root package name */
    private final Runnable f365168i0;

    /* renamed from: j0, reason: collision with root package name */
    private final Runnable f365169j0;

    /* renamed from: k0, reason: collision with root package name */
    private final Runnable f365170k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f365171l0;

    /* renamed from: m, reason: collision with root package name */
    private int f365172m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static final class BuilderType {
        private static final /* synthetic */ BuilderType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BuilderType FILE;
        public static final BuilderType JSON;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13101);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BuilderType builderType = new BuilderType("JSON", 0);
            JSON = builderType;
            BuilderType builderType2 = new BuilderType("FILE", 1);
            FILE = builderType2;
            $VALUES = new BuilderType[]{builderType, builderType2};
        }

        BuilderType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static BuilderType valueOf(String str) {
            return (BuilderType) Enum.valueOf(BuilderType.class, str);
        }

        public static BuilderType[] values() {
            return (BuilderType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f365174a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13068);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BuilderType.values().length];
            f365174a = iArr;
            try {
                iArr[BuilderType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f365174a[BuilderType.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface c {
        void onFrameChanged(AXrLottieDrawable aXrLottieDrawable, int i3);

        void onRecycle();

        void onRepeat(int i3, boolean z16);

        void onStart();

        void onStop(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 54)) {
            redirector.redirect((short) 54);
        } else {
            f365152m0 = new Handler(Looper.getMainLooper());
            f365153n0 = new DispatchQueuePool(4);
        }
    }

    public AXrLottieDrawable(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        this.f365162f = new int[3];
        this.f365167i = 1.0f;
        this.f365172m = -1;
        this.C = -1;
        this.D = false;
        this.E = -1;
        this.G = 1;
        this.H = false;
        this.Y = 1.0f;
        this.Z = 1.0f;
        this.f365156b0 = new Rect();
        this.f365163f0 = null;
        this.f365164g0 = new Runnable() { // from class: com.tencent.rlottie.AXrLottieDrawable.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AXrLottieDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AXrLottieDrawable.this.L = null;
                    AXrLottieDrawable.this.N = null;
                    Log.e("AXrLottieDrawable", "getFrame fail, uiRunnableNoFrame, currentFrame:" + AXrLottieDrawable.this.W);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.f365166h0 = new Runnable() { // from class: com.tencent.rlottie.AXrLottieDrawable.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AXrLottieDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Log.e("AXrLottieDrawable", "getFrame, uiRunnableCacheFinished");
                AXrLottieDrawable.this.K = null;
                AXrLottieDrawable.this.P();
            }
        };
        this.f365168i0 = new Runnable() { // from class: com.tencent.rlottie.AXrLottieDrawable.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AXrLottieDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AXrLottieDrawable.this.U = true;
                    AXrLottieDrawable.this.j0();
                    AXrLottieDrawable.this.P();
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.f365169j0 = new Runnable() { // from class: com.tencent.rlottie.AXrLottieDrawable.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AXrLottieDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!AXrLottieDrawable.this.f365159d0 && !AXrLottieDrawable.this.S && AXrLottieDrawable.this.f365161e0 != 0) {
                    AXrLottieDrawable.f365154o0.execute(AXrLottieDrawable.this.K = new Runnable() { // from class: com.tencent.rlottie.AXrLottieDrawable.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                if (AXrLottieDrawable.this.K == null) {
                                    return;
                                }
                                AXrLottieNative.createCache(AXrLottieDrawable.this.f365161e0, AXrLottieDrawable.this.f365158d, AXrLottieDrawable.this.f365160e);
                                AXrLottieDrawable.f365152m0.post(AXrLottieDrawable.this.f365166h0);
                            }
                        }
                    });
                }
                AXrLottieDrawable.this.P();
            }
        };
        this.f365170k0 = new Runnable() { // from class: com.tencent.rlottie.AXrLottieDrawable.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AXrLottieDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (AXrLottieDrawable.this.f365159d0) {
                    c cVar = AXrLottieDrawable.this.f365163f0;
                    if (cVar != null) {
                        cVar.onRecycle();
                        return;
                    }
                    return;
                }
                if (AXrLottieDrawable.this.f365161e0 == 0) {
                    if (AXrLottieDrawable.this.R != null) {
                        AXrLottieDrawable.this.R.countDown();
                    }
                    AXrLottieDrawable.f365152m0.post(AXrLottieDrawable.this.f365164g0);
                    return;
                }
                if (AXrLottieDrawable.this.P == null) {
                    try {
                        AXrLottieDrawable aXrLottieDrawable = AXrLottieDrawable.this;
                        aXrLottieDrawable.P = Bitmap.createBitmap(aXrLottieDrawable.f365158d, AXrLottieDrawable.this.f365160e, Bitmap.Config.ARGB_8888);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (AXrLottieDrawable.this.P != null) {
                    try {
                        if (AXrLottieNative.getFrame(AXrLottieDrawable.this.f365161e0, AXrLottieDrawable.this.W, AXrLottieDrawable.this.P, AXrLottieDrawable.this.f365158d, AXrLottieDrawable.this.f365160e, AXrLottieDrawable.this.P.getRowBytes()) == -1) {
                            Log.e("AXrLottieDrawable", "getFrame fail, ret:-1, currentFrame: " + AXrLottieDrawable.this.W);
                            AXrLottieDrawable.f365152m0.post(AXrLottieDrawable.this.f365164g0);
                            if (AXrLottieDrawable.this.R != null) {
                                AXrLottieDrawable.this.R.countDown();
                                return;
                            }
                            return;
                        }
                        if (AXrLottieDrawable.this.f365162f[2] != 0) {
                            AXrLottieDrawable.f365152m0.post(AXrLottieDrawable.this.f365169j0);
                            AXrLottieDrawable.this.f365162f[2] = 0;
                        }
                        AXrLottieDrawable aXrLottieDrawable2 = AXrLottieDrawable.this;
                        aXrLottieDrawable2.N = aXrLottieDrawable2.P;
                        int b06 = AXrLottieDrawable.this.b0();
                        int Q = AXrLottieDrawable.this.Q();
                        int R = AXrLottieDrawable.this.R();
                        if (!AXrLottieDrawable.this.f0() || !AXrLottieDrawable.this.D) {
                            c cVar2 = AXrLottieDrawable.this.f365163f0;
                            if (AXrLottieDrawable.this.G == 2) {
                                if (AXrLottieDrawable.this.H) {
                                    AXrLottieDrawable.x(AXrLottieDrawable.this, b06);
                                    if (AXrLottieDrawable.this.W <= R) {
                                        AXrLottieDrawable.this.H = false;
                                        z16 = true;
                                    }
                                    z16 = false;
                                } else {
                                    AXrLottieDrawable.w(AXrLottieDrawable.this, b06);
                                    if (AXrLottieDrawable.this.W >= Q) {
                                        AXrLottieDrawable.this.H = true;
                                        z16 = true;
                                    }
                                    z16 = false;
                                }
                                AXrLottieDrawable.this.J = false;
                            } else {
                                if (AXrLottieDrawable.this.W + b06 < Q) {
                                    AXrLottieDrawable.w(AXrLottieDrawable.this, b06);
                                    AXrLottieDrawable.this.J = false;
                                } else if (AXrLottieDrawable.this.E == -1) {
                                    AXrLottieDrawable.this.W = R;
                                    AXrLottieDrawable.this.J = false;
                                    if (cVar2 != null) {
                                        cVar2.onRepeat(-1, false);
                                    }
                                } else {
                                    z16 = true;
                                }
                                z16 = false;
                            }
                            if (z16 && AXrLottieDrawable.this.E >= 0) {
                                AXrLottieDrawable.E(AXrLottieDrawable.this);
                                if (AXrLottieDrawable.this.F >= AXrLottieDrawable.this.E) {
                                    AXrLottieDrawable.this.H = false;
                                    AXrLottieDrawable.this.J = true;
                                    if (cVar2 != null) {
                                        cVar2.onRepeat(AXrLottieDrawable.this.F, true);
                                    }
                                } else if (AXrLottieDrawable.this.G == 1) {
                                    AXrLottieDrawable.this.W = R;
                                    if (cVar2 != null) {
                                        cVar2.onRepeat(AXrLottieDrawable.this.F, false);
                                    }
                                }
                            } else if (AXrLottieDrawable.this.W > Q) {
                                AXrLottieDrawable.this.W = Q;
                            } else if (AXrLottieDrawable.this.W < R) {
                                AXrLottieDrawable.this.W = R;
                            }
                        } else {
                            if (AXrLottieDrawable.this.W > Q) {
                                if (AXrLottieDrawable.this.W - b06 <= Q) {
                                    AXrLottieDrawable.this.J = true;
                                } else {
                                    AXrLottieDrawable.x(AXrLottieDrawable.this, b06);
                                    AXrLottieDrawable.this.J = false;
                                }
                            } else if (AXrLottieDrawable.this.W + b06 >= Q) {
                                AXrLottieDrawable.this.J = true;
                            } else {
                                AXrLottieDrawable.w(AXrLottieDrawable.this, b06);
                                AXrLottieDrawable.this.J = false;
                            }
                            if (AXrLottieDrawable.this.W < R) {
                                AXrLottieDrawable.this.W = R;
                                AXrLottieDrawable.this.J = true;
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                AXrLottieDrawable.f365152m0.post(AXrLottieDrawable.this.f365168i0);
                if (AXrLottieDrawable.this.R != null) {
                    AXrLottieDrawable.this.R.countDown();
                }
            }
        };
        bVar.getClass();
        int i3 = bVar.f365198b;
        this.f365158d = i3 == -100 ? 200 : i3;
        int i16 = bVar.f365199c;
        this.f365160e = i16 != -100 ? i16 : 200;
        this.X = bVar.f365201e;
        this.f365171l0 = bVar.f365197a;
        getPaint().setFlags(2);
        int i17 = a.f365174a[bVar.f365175n.ordinal()];
        if (i17 != 1) {
            if (i17 == 2) {
                i0(bVar.f365177p, bVar.f365200d, bVar.f365202f);
            }
        } else {
            h0(bVar.f365176o, bVar.f365200d);
        }
        int i18 = bVar.f365203g;
        if (i18 != -100) {
            w0(i18);
        }
        int i19 = bVar.f365204h;
        if (i19 != -100) {
            x0(i19);
        }
        int i26 = bVar.f365206j;
        if (i26 != -100) {
            p0(i26);
        }
        int i27 = bVar.f365205i;
        if (i27 != -100) {
            r0(i27);
        }
        float f16 = bVar.f365209m;
        if (f16 > 0.0f) {
            z0(f16);
        }
        c cVar = bVar.f365207k;
        if (cVar != null) {
            y0(cVar);
        }
        if (bVar.f365208l) {
            start();
        }
    }

    static /* synthetic */ int E(AXrLottieDrawable aXrLottieDrawable) {
        int i3 = aXrLottieDrawable.F;
        aXrLottieDrawable.F = i3 + 1;
        return i3;
    }

    private void O() {
        Runnable runnable = this.K;
        if (runnable != null && f365154o0.remove(runnable)) {
            this.K = null;
        }
        if (this.N != null && this.L != null) {
            this.L = null;
            this.N = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.S) {
            O();
            if (this.L == null && this.K == null && this.f365161e0 != 0) {
                AXrLottieNative.destroy(this.f365161e0);
                this.f365161e0 = 0L;
            }
        }
        if (this.f365161e0 == 0) {
            l0();
        } else {
            this.Q = true;
            o0();
        }
    }

    public static b T(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return new b(context, com.tencent.rlottie.decoder.b.c(context, str), str2);
    }

    public static b U(@NonNull Context context, @NonNull File file) {
        return new b(context, file);
    }

    public static b V(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return new b(context, str, str2);
    }

    private void h0(File file, boolean z16) {
        boolean z17;
        int i3;
        String k3 = com.tencent.rlottie.a.b(null).k(file);
        if (z16 && !TextUtils.isEmpty(k3)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f365161e0 = AXrLottieNative.create(file.getAbsolutePath(), this.f365158d, this.f365160e, this.f365162f, this.X, z17, k3);
        if (z17 && f365154o0 == null) {
            f365154o0 = new BaseThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
        if (this.X && this.f365162f[1] < 60) {
            this.X = false;
        }
        if (this.X) {
            i3 = 33;
        } else {
            i3 = 16;
        }
        this.f365165h = Math.max(i3, (int) (1000.0f / this.f365162f[1]));
        k0();
    }

    private void i0(String str, boolean z16, boolean z17) {
        int i3;
        File f16;
        if (z16 && (f16 = com.tencent.rlottie.a.b(null).f(str, W())) != null) {
            h0(f16, true);
            return;
        }
        this.f365161e0 = AXrLottieNative.createWithJson(str, W(), this.f365162f);
        if (this.X) {
            i3 = 33;
        } else {
            i3 = 16;
        }
        this.f365165h = Math.max(i3, (int) (1000.0f / this.f365162f[1]));
        if (z17) {
            c(true);
        }
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        if (getCallback() != null) {
            invalidateSelf();
        }
    }

    private void l0() {
        this.M = null;
        this.P = null;
    }

    private boolean o0() {
        boolean z16;
        if (!g0()) {
            Log.i("AXrLottieDrawable", "getFrame, scheduleNextGetFrame");
            return false;
        }
        if (this.L != null || this.N != null || this.f365161e0 == 0 || this.S || (!this.f365157c0 && (!(z16 = this.T) || (z16 && this.U)))) {
            return false;
        }
        DispatchQueuePool dispatchQueuePool = f365153n0;
        Runnable runnable = this.f365170k0;
        this.L = runnable;
        dispatchQueuePool.f(runnable);
        return true;
    }

    private void v0(long j3, long j16, long j17, boolean z16) {
        this.P = this.M;
        this.M = this.N;
        this.N = null;
        if (this.J) {
            A0(true);
        }
        this.L = null;
        this.U = true;
        this.Q = false;
        if (com.tencent.rlottie.a.c() <= 60.0f) {
            this.I = j3;
        } else {
            this.I = j3 - Math.min(16L, j16 - j17);
        }
        if (z16 && this.V) {
            this.U = false;
            this.V = false;
        }
        c cVar = this.f365163f0;
        if (cVar != null) {
            cVar.onFrameChanged(this, this.W);
        }
        o0();
    }

    static /* synthetic */ int w(AXrLottieDrawable aXrLottieDrawable, int i3) {
        int i16 = aXrLottieDrawable.W + i3;
        aXrLottieDrawable.W = i16;
        return i16;
    }

    static /* synthetic */ int x(AXrLottieDrawable aXrLottieDrawable, int i3) {
        int i16 = aXrLottieDrawable.W - i3;
        aXrLottieDrawable.W = i16;
        return i16;
    }

    public void A0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
            return;
        }
        this.f365157c0 = false;
        c cVar = this.f365163f0;
        if (cVar != null) {
            cVar.onStop(z16);
        }
    }

    protected int Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int i3 = this.C;
        if (i3 <= 0) {
            return this.f365162f[0];
        }
        return i3;
    }

    protected int R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return Math.min(Math.max(this.f365172m, 0), this.f365162f[0]);
    }

    protected int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return (int) (this.f365165h / this.f365167i);
    }

    public String W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f365171l0;
    }

    public int X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.W;
    }

    public long Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        int[] iArr = this.f365162f;
        return (iArr[0] / iArr[1]) * 1000.0f;
    }

    public int Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return Q();
    }

    public int a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f365162f[1];
    }

    protected int b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        if (!this.X) {
            return 1;
        }
        return 2;
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        this.T = z16;
        if (z16) {
            Log.d("AXrLottieDrawable", "setAllowDecodeSingleFrame, value:" + z16);
            o0();
        }
    }

    public com.tencent.rlottie.c c0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (com.tencent.rlottie.c) iPatchRedirector.redirect((short) 49, (Object) this, i3);
        }
        return d0(i3, this.f365158d, this.f365160e);
    }

    public com.tencent.rlottie.c d0(int i3, int i16, int i17) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (com.tencent.rlottie.c) iPatchRedirector.redirect((short) 50, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        com.tencent.rlottie.c cVar = new com.tencent.rlottie.c();
        try {
            bitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        } catch (Throwable th5) {
            th5.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            if (AXrLottieNative.getFrame(this.f365161e0, i3, bitmap, i16, i17, bitmap.getRowBytes()) == -1) {
                z16 = false;
            }
            cVar.f365196c = z16;
        }
        cVar.f365195b = bitmap;
        cVar.f365194a = i3;
        return cVar;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int S;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) canvas);
            return;
        }
        if (this.f365161e0 != 0 && !this.S) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - this.I);
            if (com.tencent.rlottie.a.c() <= 60.0f) {
                S = S() - 6;
            } else {
                S = S();
            }
            if (this.f365157c0) {
                if (this.M == null && this.N == null) {
                    o0();
                } else if (this.N != null && (this.M == null || abs >= S)) {
                    v0(elapsedRealtime, abs, S, false);
                }
            } else if ((this.V || (this.T && abs >= S)) && this.N != null) {
                v0(elapsedRealtime, abs, S, true);
            }
            if (this.M != null) {
                if (this.f365155a0) {
                    this.f365156b0.set(getBounds());
                    this.Y = this.f365156b0.width() / this.f365158d;
                    this.Z = this.f365156b0.height() / this.f365160e;
                    this.f365155a0 = false;
                }
                canvas.save();
                Rect rect = this.f365156b0;
                canvas.translate(rect.left, rect.top);
                canvas.scale(this.Y, this.Z);
                canvas.drawBitmap(m0(this.M, this.W), 0.0f, 0.0f, getPaint());
                if (this.f365157c0) {
                    j0();
                }
                canvas.restore();
            }
        }
    }

    public int e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f365162f[0];
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AXrLottieDrawable)) {
            return false;
        }
        AXrLottieDrawable aXrLottieDrawable = (AXrLottieDrawable) obj;
        if (this.f365158d != aXrLottieDrawable.f365158d || this.f365160e != aXrLottieDrawable.f365160e || Q() != aXrLottieDrawable.Q() || R() != aXrLottieDrawable.R() || this.E != aXrLottieDrawable.E || this.G != aXrLottieDrawable.G) {
            return false;
        }
        return this.f365171l0.equals(aXrLottieDrawable.f365171l0);
    }

    protected boolean f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.C > 0) {
            return true;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    public boolean g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f365161e0 != 0) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return this.f365160e;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        return this.f365158d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this)).intValue();
        }
        return this.f365160e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }
        return this.f365158d;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.f365157c0;
    }

    protected void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        }
    }

    protected Bitmap m0(Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Bitmap) iPatchRedirector.redirect((short) 51, (Object) this, (Object) bitmap, i3);
        }
        return bitmap;
    }

    public void n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        this.F = 0;
        this.H = false;
        u0(R(), true, true);
        if (this.f365157c0) {
            this.f365157c0 = false;
            start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) rect);
        } else {
            super.onBoundsChange(rect);
            this.f365155a0 = true;
        }
    }

    public void p0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            if ((i3 >= 0 && this.F >= i3) || this.G < -1) {
                return;
            }
            this.E = i3;
        }
    }

    public void q0(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        p0(i3);
    }

    public void r0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        if (i3 != 1 && i3 != 2) {
            return;
        }
        this.G = i3;
        if (i3 != 2) {
            this.H = false;
        }
    }

    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        c cVar = this.f365163f0;
        if (this.f365157c0 && cVar != null) {
            cVar.onRecycle();
        }
        this.f365157c0 = false;
        this.f365159d0 = true;
        O();
        if (this.L == null && this.K == null) {
            if (this.f365161e0 != 0) {
                AXrLottieNative.destroy(this.f365161e0);
                this.f365161e0 = 0L;
            }
            l0();
            return;
        }
        this.S = true;
    }

    public void s0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        } else {
            t0(i3, true);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (this.f365157c0) {
            return;
        }
        c cVar = this.f365163f0;
        if (cVar != null) {
            cVar.onStart();
        }
        this.f365157c0 = true;
        this.H = false;
        o0();
        j0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            A0(false);
        }
    }

    public void t0(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            u0(i3, z16, false);
        }
    }

    public void u0(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (i3 >= 0 && i3 <= this.f365162f[0]) {
            this.W = i3;
            this.J = false;
            this.U = false;
            if ((!z16 || z17) && this.Q && this.N != null) {
                this.P = this.N;
                this.N = null;
                this.L = null;
                this.Q = false;
            }
            if (!z16 && this.L == null) {
                this.R = new CountDownLatch(1);
            }
            if (o0()) {
                if (!z16) {
                    try {
                        this.R.await();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    this.R = null;
                }
            } else {
                this.V = true;
            }
            j0();
        }
    }

    public void w0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            if (i3 > this.f365162f[0]) {
                return;
            }
            this.C = i3;
        }
    }

    public void x0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            if (i3 > this.f365162f[0]) {
                return;
            }
            this.f365172m = Math.max(i3, 0);
        }
    }

    public void y0(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
        } else {
            this.f365163f0 = cVar;
        }
    }

    public void z0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16));
        } else {
            if (f16 <= 0.0f) {
                return;
            }
            this.f365167i = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: n, reason: collision with root package name */
        private final BuilderType f365175n;

        /* renamed from: o, reason: collision with root package name */
        private final File f365176o;

        /* renamed from: p, reason: collision with root package name */
        private final String f365177p;

        /* renamed from: q, reason: collision with root package name */
        private final Context f365178q;

        public b(Context context, File file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) file);
                return;
            }
            if (file != null) {
                this.f365178q = context;
                this.f365176o = file;
                this.f365177p = null;
                this.f365175n = BuilderType.FILE;
                g(file.getAbsolutePath());
                return;
            }
            throw new NullPointerException("lottie file can't be null!");
        }

        @Override // com.tencent.rlottie.d
        public AXrLottieDrawable b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AXrLottieDrawable) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new AXrLottieDrawable(this);
        }

        public b(Context context, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, str, str2);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f365178q = context;
                this.f365176o = null;
                this.f365177p = str;
                this.f365175n = BuilderType.JSON;
                g(str2);
                return;
            }
            throw new NullPointerException("json can't be empty!");
        }
    }
}
