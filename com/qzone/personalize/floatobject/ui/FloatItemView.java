package com.qzone.personalize.floatobject.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.e;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FloatItemView extends SurfaceView {
    private static final boolean T = ar.b("kenaiyu", "2024-08-15", "vas_bug_128774947").isEnable(true);
    private final int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private final int H;
    public Bitmap I;
    public boolean J;
    private Runnable K;
    private Runnable L;
    private int M;
    private AtomicBoolean N;
    private final Object P;
    private volatile boolean Q;
    public Handler R;
    private e.b S;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceHolder f49279d;

    /* renamed from: e, reason: collision with root package name */
    private e[] f49280e;

    /* renamed from: f, reason: collision with root package name */
    public String f49281f;

    /* renamed from: h, reason: collision with root package name */
    private Random f49282h;

    /* renamed from: i, reason: collision with root package name */
    private Matrix f49283i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f49284m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10) {
                if (FloatItemView.this.N.get()) {
                    FloatItemView.this.J(0, 0);
                } else {
                    removeMessages(10);
                    sendEmptyMessageDelayed(10, 100L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements SurfaceHolder.Callback {
        c() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            QZLog.i("FloatItemView", 1, "surfaceChanged");
            if (FloatItemView.this.N.get()) {
                return;
            }
            FloatItemView.this.N.set(true);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (FloatItemView.T) {
                synchronized (FloatItemView.this.P) {
                    QZLog.i("FloatItemView", 1, "surfaceDestroyed");
                    FloatItemView.this.stop();
                    FloatItemView.this.N.set(false);
                    com.qzone.common.event.e.b().e(FloatItemView.this.S);
                }
                return;
            }
            QZLog.i("FloatItemView", 1, "surfaceDestroyed");
            FloatItemView.this.stop();
            FloatItemView.this.N.set(false);
            com.qzone.common.event.e.b().e(FloatItemView.this.S);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            QZLog.i("FloatItemView", 1, "surfaceCreated");
            FloatItemView.this.N.set(false);
            if (!com.qzone.common.event.e.b().d()) {
                com.qzone.common.event.e.b().c(FloatItemView.this.getContext().getApplicationContext());
            }
            com.qzone.common.event.e.b().f(FloatItemView.this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public int f49291a;

        /* renamed from: b, reason: collision with root package name */
        public float f49292b;

        /* renamed from: c, reason: collision with root package name */
        public float f49293c;

        /* renamed from: d, reason: collision with root package name */
        public float f49294d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f49295e;

        /* renamed from: f, reason: collision with root package name */
        public int f49296f;

        /* renamed from: g, reason: collision with root package name */
        public float f49297g;

        /* renamed from: h, reason: collision with root package name */
        public int f49298h;

        /* renamed from: i, reason: collision with root package name */
        public int f49299i;

        /* renamed from: j, reason: collision with root package name */
        private int f49300j;

        /* renamed from: k, reason: collision with root package name */
        private float f49301k;

        /* renamed from: l, reason: collision with root package name */
        private float f49302l;

        /* renamed from: m, reason: collision with root package name */
        private int f49303m;

        /* renamed from: n, reason: collision with root package name */
        private int f49304n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f49305o = false;

        public e(Context context) {
            this.f49295e = FloatItemView.this.D(0, 1) == 0;
        }

        private void h() {
            int i3 = this.f49299i;
            if (i3 == 0) {
                float f16 = this.f49292b;
                if (f16 < -200.0f || f16 > FloatItemView.this.E + 200) {
                    this.f49294d = (this.f49298h * 2) - this.f49294d;
                }
                if (this.f49293c > FloatItemView.this.F) {
                    FloatItemView floatItemView = FloatItemView.this;
                    if (floatItemView.J) {
                        this.f49296f = floatItemView.z(this, this.f49299i);
                        this.f49293c = FloatItemView.this.C(this, this.f49291a, this.f49299i);
                        this.f49292b = FloatItemView.this.B(this, this.f49291a, this.f49299i);
                        return;
                    } else {
                        this.f49305o = true;
                        floatItemView.M--;
                        return;
                    }
                }
                return;
            }
            if (i3 == 1) {
                float f17 = this.f49292b;
                if (f17 < -200.0f || f17 > FloatItemView.this.E + 200) {
                    this.f49294d = (this.f49298h * 2) - this.f49294d;
                }
                if (this.f49293c < (-((int) this.f49297g)) * FloatItemView.this.E()) {
                    FloatItemView floatItemView2 = FloatItemView.this;
                    if (floatItemView2.J) {
                        this.f49296f = floatItemView2.z(this, this.f49299i);
                        this.f49293c = FloatItemView.this.C(this, this.f49291a, this.f49299i);
                        this.f49292b = FloatItemView.this.B(this, this.f49291a, this.f49299i);
                        return;
                    } else {
                        this.f49305o = true;
                        floatItemView2.M--;
                        return;
                    }
                }
                return;
            }
            if (i3 == 3) {
                float f18 = this.f49293c;
                if (f18 < -200.0f || f18 > FloatItemView.this.F + 200) {
                    this.f49294d = (this.f49298h * 2) - this.f49294d;
                }
                if (this.f49292b < (-this.f49297g) * FloatItemView.this.F()) {
                    FloatItemView floatItemView3 = FloatItemView.this;
                    if (floatItemView3.J) {
                        this.f49296f = floatItemView3.z(this, this.f49299i);
                        this.f49293c = FloatItemView.this.C(this, this.f49291a, this.f49299i);
                        this.f49292b = FloatItemView.this.B(this, this.f49291a, this.f49299i);
                        return;
                    } else {
                        this.f49305o = true;
                        floatItemView3.M--;
                        return;
                    }
                }
                return;
            }
            if (i3 == 2) {
                float f19 = this.f49293c;
                if (f19 < -200.0f || f19 > FloatItemView.this.F + 200) {
                    this.f49294d = (this.f49298h * 2) - this.f49294d;
                }
                if (this.f49292b > FloatItemView.this.E) {
                    FloatItemView floatItemView4 = FloatItemView.this;
                    if (floatItemView4.J) {
                        this.f49296f = floatItemView4.z(this, this.f49299i);
                        this.f49293c = FloatItemView.this.C(this, this.f49291a, this.f49299i);
                        this.f49292b = FloatItemView.this.B(this, this.f49291a, this.f49299i);
                    } else {
                        this.f49305o = true;
                        floatItemView4.M--;
                    }
                }
            }
        }

        public void i(Canvas canvas) {
            Bitmap bitmap = FloatItemView.this.I;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            Matrix matrix = FloatItemView.this.f49283i;
            float f16 = (-this.f49294d) + this.f49298h;
            float f17 = this.f49303m;
            float f18 = this.f49297g;
            matrix.setRotate(f16, f17 * f18, this.f49304n * f18);
            FloatItemView.this.f49283i.postScale((this.f49297g / 2.0f) * FloatItemView.this.G, (this.f49297g / 2.0f) * FloatItemView.this.G);
            canvas.translate(this.f49292b, this.f49293c);
            FloatItemView floatItemView = FloatItemView.this;
            canvas.drawBitmap(floatItemView.I, floatItemView.f49283i, null);
            canvas.translate(-this.f49292b, -this.f49293c);
            if (this.f49295e) {
                this.f49294d -= this.f49302l;
            } else {
                this.f49294d += this.f49302l;
            }
            float f19 = this.f49294d;
            int i3 = this.f49300j;
            int i16 = this.f49298h;
            if (f19 > i3 + i16) {
                this.f49294d = i3 + i16;
                this.f49295e = true;
            } else if (f19 < (-i3) + i16) {
                this.f49294d = (-i3) + i16;
                this.f49295e = false;
            }
            this.f49292b = (float) (this.f49292b + (this.f49301k * this.f49297g * Math.sin((this.f49294d / 180.0f) * 3.141592653589793d)));
            this.f49293c = (float) (this.f49293c + (this.f49301k * this.f49297g * Math.cos((this.f49294d / 180.0f) * 3.141592653589793d)));
            h();
        }
    }

    public FloatItemView(Context context) {
        super(context);
        this.C = 20;
        this.D = 40;
        this.H = 200;
        this.J = false;
        this.N = new AtomicBoolean(false);
        this.P = new Object();
        this.Q = false;
        this.R = new a(Looper.getMainLooper());
        G();
    }

    private int A(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return 0;
                }
                return -90;
            }
            return 90;
        }
        return 180;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E() {
        Bitmap bitmap = this.I;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        return this.I.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F() {
        Bitmap bitmap = this.I;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        return this.I.getWidth();
    }

    private void G() {
        this.S = new b();
        this.E = ViewUtils.getScreenWidth();
        this.F = ViewUtils.getScreenHeight();
        this.G = ViewUtils.getDensity();
        this.f49282h = new Random();
        this.f49283i = new Matrix();
        Paint paint = new Paint();
        this.f49284m = paint;
        paint.setAntiAlias(true);
        this.f49284m.setColor(-1);
        this.N.set(false);
        this.f49279d = getHolder();
        setZOrderOnTop(true);
        this.f49279d.setFormat(-2);
        this.f49279d.addCallback(new c());
        this.K = new Runnable() { // from class: com.qzone.personalize.floatobject.ui.FloatItemView.4
            /* JADX WARN: Can't wrap try/catch for region: R(6:8|(2:9|10)|(4:16|17|(3:18|19|(2:21|(1:35)(3:23|(1:34)(2:25|(2:32|33)(2:29|30))|31))(0))|42)(0)|40|41|42) */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
            
                com.qzone.personalize.floatobject.ui.FloatItemView.y(com.qzone.util.l.a(com.tencent.mobileqq.R.string.mlq));
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00d5, code lost:
            
                r2 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00d6, code lost:
            
                r3 = "FloatItemView";
                r2 = "SurfaceView has a exception e: " + r2;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FloatItemView floatItemView = FloatItemView.this;
                if (!floatItemView.J && floatItemView.M == 0) {
                    FloatItemView.this.stop();
                }
                FloatItemView.y("refreshRunnable hasStop=" + FloatItemView.this.Q + ",hasInit\uff1d" + FloatItemView.this.N.get());
                synchronized (FloatItemView.this.P) {
                    Canvas canvas = null;
                    try {
                        canvas = FloatItemView.this.f49279d.lockCanvas();
                    } catch (Throwable th5) {
                        try {
                            QZLog.w("FloatItemView", "SurfaceView has a exception e: " + th5);
                            try {
                                FloatItemView.this.f49279d.unlockCanvasAndPost(canvas);
                            } catch (Throwable th6) {
                                String str = "FloatItemView";
                                String str2 = "SurfaceView has a exception e: " + th6;
                                QZLog.w(str, str2);
                                FloatItemView.this.J(0, 20);
                            }
                        } finally {
                        }
                    }
                    if (canvas != null && FloatItemView.this.N.get() && FloatItemView.this.f49279d.getSurface().isValid()) {
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        int i3 = 0;
                        while (true) {
                            try {
                                if (i3 < FloatItemView.this.D) {
                                    if (FloatItemView.this.Q) {
                                        break;
                                    }
                                    e eVar = FloatItemView.this.f49280e[i3];
                                    if (eVar != null) {
                                        if (eVar.f49296f == 0 && !eVar.f49305o) {
                                            eVar.i(canvas);
                                        } else {
                                            eVar.f49296f--;
                                        }
                                    }
                                    i3++;
                                }
                            } catch (Throwable th7) {
                                QZLog.w("FloatItemView", "refreshRunnable FloatItemView has a exception e: " + th7);
                            }
                        }
                    }
                    FloatItemView.this.f49279d.unlockCanvasAndPost(canvas);
                }
                FloatItemView.this.J(0, 20);
            }
        };
        this.L = new Runnable() { // from class: com.qzone.personalize.floatobject.ui.FloatItemView.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2;
                synchronized (FloatItemView.this.P) {
                    Canvas canvas = null;
                    try {
                        canvas = FloatItemView.this.f49279d.lockCanvas();
                        if (canvas != null && FloatItemView.this.N.get() && FloatItemView.this.f49279d.getSurface().isValid()) {
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        }
                    } catch (Throwable th5) {
                        try {
                            QZLog.w("FloatItemView", "SurfaceView has a exception e: " + th5);
                            try {
                                FloatItemView.this.f49279d.unlockCanvasAndPost(canvas);
                            } catch (Throwable th6) {
                                str = "FloatItemView";
                                str2 = "SurfaceView has a exception e: " + th6;
                                QZLog.w(str, str2);
                            }
                        } finally {
                        }
                    }
                    try {
                        FloatItemView.this.f49279d.unlockCanvasAndPost(canvas);
                    } catch (Throwable th7) {
                        str = "FloatItemView";
                        str2 = "SurfaceView has a exception e: " + th7;
                        QZLog.w(str, str2);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3, float f16, int i16, float f17, Drawable drawable, int i17, int i18, int i19, int i26, int i27, boolean z16) {
        this.J = z16;
        this.D = i3;
        this.M = i3;
        try {
            this.f49280e = new e[i3];
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            this.I = bitmap;
            this.I = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            for (int i28 = 0; i28 < this.D; i28++) {
                e eVar = new e(getContext());
                eVar.f49291a = i28;
                eVar.f49301k = (this.G * f16) / 2.0f;
                eVar.f49300j = i16;
                eVar.f49302l = f17;
                eVar.f49297g = D(i19, i26) / 100.0f;
                eVar.f49299i = i27;
                eVar.f49298h = A(i27);
                eVar.f49292b = B(eVar, i28, i27);
                eVar.f49293c = C(eVar, i28, i27);
                eVar.f49303m = (int) (i17 * eVar.f49297g);
                eVar.f49304n = (int) (i18 * eVar.f49297g);
                int i29 = eVar.f49298h;
                eVar.f49294d = D((-i16) + i29, i29 + i16);
                eVar.f49296f = z(eVar, i27);
                this.f49280e[i28] = eVar;
            }
            start();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3, int i16) {
        if (this.N.get()) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return;
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FloatItemThread).removeTask(this.L);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FloatItemThread).postDelayed(this.L, i16);
                return;
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FloatItemThread).removeTask(this.K);
            if (this.Q) {
                return;
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FloatItemThread).postDelayed(this.K, i16);
        }
    }

    public void destroy() {
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.N.get()) {
            stop();
            J(1, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initObjects(final FloatCacheData floatCacheData, final boolean z16) {
        ArrayList<NS_MOBILE_CUSTOM.FloatItemView> arrayList;
        Drawable drawable;
        Drawable drawable2;
        if (floatCacheData != null && (arrayList = floatCacheData.vecView) != null && arrayList.size() != 0 && floatCacheData.vecView.get(0) != null && floatCacheData.vecView.get(0).stFileInfo != null) {
            destroy();
            this.f49281f = floatCacheData.strId;
            if (ImageManagerEnv.getAppContext() == null) {
                ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
            }
            NS_MOBILE_CUSTOM.FloatItemView floatItemView = floatCacheData.vecView.get(0);
            if (floatItemView != null) {
                if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                    final Option url = Option.obtain().setUrl(floatItemView.stFileInfo.strFileUrl);
                    com.tencent.mobileqq.qzone.picload.c.a().i(url, new IPicLoadStateListener() { // from class: com.qzone.personalize.floatobject.ui.a
                        @Override // com.tencent.libra.listener.IPicLoadStateListener
                        public final void onStateChange(LoadState loadState, Option option) {
                            FloatItemView.this.I(url, floatCacheData, z16, loadState, option);
                        }
                    });
                } else {
                    drawable = ImageLoader.getInstance().loadImage(floatItemView.stFileInfo.strFileUrl, new d(floatCacheData, z16));
                    drawable2 = drawable;
                    if (drawable2 == null) {
                        H(floatCacheData.iCount, floatCacheData.fSpeed * 20.0f, floatCacheData.iMaxAngle, floatCacheData.fAngleSpeed * 20.0f, drawable2, floatCacheData.iRotationX, floatCacheData.iRotationY, floatCacheData.iMinSize, floatCacheData.iMaxSize, floatCacheData.iDirection, z16);
                        return;
                    }
                    return;
                }
            }
            drawable = null;
            drawable2 = drawable;
            if (drawable2 == null) {
            }
        } else {
            com.tencent.xaction.log.b.a("FloatItemView", 1, "float item init error, data is invalid");
        }
    }

    public void onDestroy() {
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void stop() {
        Handler handler = this.R;
        if (handler != null) {
            handler.removeMessages(10);
        }
        this.Q = true;
        if (this.N.get()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FloatItemThread).removeTask(this.K);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FloatItemThread).removeTask(this.L);
        }
    }

    public void start() {
        this.Q = false;
        Handler handler = this.R;
        if (handler != null) {
            handler.sendEmptyMessage(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(int i3, int i16) {
        if (i3 > i16) {
            QZLog.w("FloatItemView", "start is bigger then end,please check the item config.start=" + i3 + ",end=" + i16);
            return i3;
        }
        return this.f49282h.nextInt((i16 - i3) + 1) + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(Option option, FloatCacheData floatCacheData, boolean z16, LoadState loadState, Option option2) {
        if (loadState != LoadState.STATE_SUCCESS) {
            return;
        }
        H(floatCacheData.iCount, floatCacheData.fSpeed * 20.0f, floatCacheData.iMaxAngle, floatCacheData.fAngleSpeed * 20.0f, new BitmapDrawable(getResources(), option.getResultBitMap()), floatCacheData.iRotationX, floatCacheData.iRotationY, floatCacheData.iMinSize, floatCacheData.iMaxSize, floatCacheData.iDirection, z16);
    }

    public FloatItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = 20;
        this.D = 40;
        this.H = 200;
        this.J = false;
        this.N = new AtomicBoolean(false);
        this.P = new Object();
        this.Q = false;
        this.R = new a(Looper.getMainLooper());
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float B(e eVar, int i3, int i16) {
        int D;
        if (i16 == 0) {
            int i17 = i3 % 4;
            int i18 = this.E;
            D = D((i17 * i18) / 4, ((i17 + 1) * i18) / 4);
        } else if (i16 == 1) {
            int i19 = i3 % 4;
            int i26 = this.E;
            D = D((i19 * i26) / 4, ((i19 + 1) * i26) / 4);
        } else if (i16 == 2) {
            D = (-((int) eVar.f49297g)) * F();
        } else {
            if (i16 != 3) {
                return 0.0f;
            }
            D = this.E;
        }
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C(e eVar, int i3, int i16) {
        if (i16 == 0) {
            return (-((int) eVar.f49297g)) * E();
        }
        if (i16 == 1) {
            return this.F;
        }
        if (i16 == 2) {
            int i17 = i3 % 4;
            int i18 = this.F;
            return D((i17 * i18) / 4, ((i17 + 1) * i18) / 4);
        }
        if (i16 != 3) {
            return 0;
        }
        int i19 = i3 % 4;
        int i26 = this.F;
        return D((i19 * i26) / 4, ((i19 + 1) * i26) / 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z(e eVar, int i3) {
        if (i3 == 0) {
            return D(0, (int) (this.F / (eVar.f49301k * eVar.f49297g)));
        }
        if (i3 == 1) {
            return D(0, (int) (this.F / (eVar.f49301k * eVar.f49297g)));
        }
        if (i3 == 2) {
            return D(0, (int) (this.E / (eVar.f49301k * eVar.f49297g)));
        }
        if (i3 != 3) {
            return 0;
        }
        return D(0, (int) (this.E / (eVar.f49301k * eVar.f49297g)));
    }

    public void initObjects(String str, boolean z16) {
        FloatCacheData createFromJsonString = FloatCacheData.createFromJsonString(LoginData.getInstance().getUin(), str);
        if (createFromJsonString != null) {
            initObjects(createFromJsonString, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements e.b {
        b() {
        }

        @Override // com.qzone.common.event.e.b
        public void onScreenOff() {
            FloatItemView.this.stop();
        }

        @Override // com.qzone.common.event.e.b
        public void onScreenOn() {
        }
    }

    public FloatItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 20;
        this.D = 40;
        this.H = 200;
        this.J = false;
        this.N = new AtomicBoolean(false);
        this.P = new Object();
        this.Q = false;
        this.R = new a(Looper.getMainLooper());
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FloatCacheData f49288d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f49289e;

        d(FloatCacheData floatCacheData, boolean z16) {
            this.f49288d = floatCacheData;
            this.f49289e = z16;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            FloatItemView floatItemView = FloatItemView.this;
            FloatCacheData floatCacheData = this.f49288d;
            floatItemView.H(floatCacheData.iCount, floatCacheData.fSpeed * 20.0f, floatCacheData.iMaxAngle, floatCacheData.fAngleSpeed * 20.0f, drawable, floatCacheData.iRotationX, floatCacheData.iRotationY, floatCacheData.iMinSize, floatCacheData.iMaxSize, floatCacheData.iDirection, this.f49289e);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
