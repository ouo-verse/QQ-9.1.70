package com.qzone.proxy.feedcomponent.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.ui.CustomPraiseView;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.OnAnimationListener;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;
import cooperation.qzone.zipanimate.ZipFrameLoadedListener;
import cooperation.qzone.zipanimate.ZipLoadedListener;

/* loaded from: classes39.dex */
public class CustomPraiseView extends FrameLayout {

    /* renamed from: d0, reason: collision with root package name */
    public static final float f50769d0 = FeedGlobalEnv.g().getScreenWidth() / 720.0f;
    String C;
    int D;
    int E;
    boolean F;
    int G;
    int H;
    int I;
    Drawable J;
    f K;
    int L;
    private int M;
    private int N;
    com.tencent.mobileqq.vas.ui.c P;
    Drawable Q;
    private DelayHideTask R;
    private long S;
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k T;
    long U;
    Handler V;
    long W;

    /* renamed from: a0, reason: collision with root package name */
    int f50770a0;

    /* renamed from: b0, reason: collision with root package name */
    int f50771b0;

    /* renamed from: c0, reason: collision with root package name */
    Paint f50772c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50773d;

    /* renamed from: e, reason: collision with root package name */
    ZipDrawableLoaderInterface f50774e;

    /* renamed from: f, reason: collision with root package name */
    ZipLoadedListener f50775f;

    /* renamed from: h, reason: collision with root package name */
    boolean f50776h;

    /* renamed from: i, reason: collision with root package name */
    boolean f50777i;

    /* renamed from: m, reason: collision with root package name */
    com.qzone.proxy.feedcomponent.ui.a f50778m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class DelayHideTask implements Runnable {
        DelayHideTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            CustomPraiseView.this.setVisibility(8);
        }

        @Override // java.lang.Runnable
        public void run() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    CustomPraiseView.DelayHideTask.this.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ZipFrameLoadedListener {
        a() {
        }

        @Override // cooperation.qzone.zipanimate.ZipFrameLoadedListener
        public void onLoaded(int i3, Drawable drawable) {
            CustomPraiseView.this.f50778m.a(drawable, 0L);
            CustomPraiseView.this.V.removeMessages(1000);
            CustomPraiseView.this.V.sendEmptyMessageDelayed(1000, 1000 / r4.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements d.a {
        b() {
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onEnd() {
            CustomPraiseView.this.setVisibility(8);
            CustomPraiseView.this.k();
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onStart() {
            CustomPraiseView.this.e();
        }
    }

    /* loaded from: classes39.dex */
    class d extends f {
        d() {
            super();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            CustomPraiseView.this.J = drawable;
        }
    }

    /* loaded from: classes39.dex */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1000) {
                return;
            }
            CustomPraiseView customPraiseView = CustomPraiseView.this;
            if (customPraiseView.f50776h && customPraiseView.E == 1) {
                customPraiseView.h();
                if (!CustomPraiseView.this.f50778m.e()) {
                    CustomPraiseView.this.f50778m.i();
                    CustomPraiseView.this.V.sendEmptyMessageDelayed(1000, 1000 / r5.D);
                    int i3 = CustomPraiseView.this.M;
                    CustomPraiseView customPraiseView2 = CustomPraiseView.this;
                    int i16 = i3 + customPraiseView2.G;
                    int i17 = com.qzone.proxy.feedcomponent.ui.a.f50813k;
                    int i18 = i16 - (i17 / 2);
                    int i19 = customPraiseView2.N;
                    CustomPraiseView customPraiseView3 = CustomPraiseView.this;
                    int i26 = i19 + customPraiseView3.H;
                    int i27 = com.qzone.proxy.feedcomponent.ui.a.f50814l;
                    int i28 = i26 - i27;
                    customPraiseView3.invalidate(i18, i28, i17 + i18, i27 + i28);
                    return;
                }
                CustomPraiseView.this.n();
            }
        }
    }

    public CustomPraiseView(Context context) {
        super(context);
        this.f50773d = VasNormalToggle.VAS_QZONE_PRAISE_SWITCH_CONFIG.isEnable(true);
        this.D = 30;
        this.E = 0;
        this.I = 1;
        this.M = 0;
        this.N = 0;
        this.S = 2000L;
        this.V = new e(Looper.getMainLooper());
        this.W = -1L;
        this.f50770a0 = -1;
        this.f50771b0 = -1;
        this.f50772c0 = new Paint();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        k();
        DelayHideTask delayHideTask = new DelayHideTask();
        this.R = delayHideTask;
        ThreadManagerV2.executeDelay(delayHideTask, 16, null, false, this.S);
    }

    private void j() {
        if (this.f50773d) {
            this.S = VasNormalToggle.VAS_QZONE_PRAISE_SWITCH_CONFIG.getJson().optLong("view_hide_delay", 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        DelayHideTask delayHideTask = this.R;
        if (delayHideTask == null) {
            return;
        }
        ThreadManagerV2.removeJob(delayHideTask, 16);
        this.R = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.translate(this.M, this.N);
        super.dispatchDraw(canvas);
        canvas.translate(-this.M, -this.N);
    }

    void h() {
        if (this.f50778m == null) {
            this.f50778m = new com.qzone.proxy.feedcomponent.ui.a(this);
        }
    }

    void i(String str, ImageLoader.ImageLoadListener imageLoadListener) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.needRecycle = true;
        obtain.imageConfig = Bitmap.Config.ARGB_4444;
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, imageLoadListener, obtain);
        if (loadImage != null) {
            imageLoadListener.onImageLoaded(str, loadImage, obtain);
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    void m(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.V.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void n() {
        this.V.removeMessages(1000);
        k();
        com.qzone.proxy.feedcomponent.ui.a aVar = this.f50778m;
        if (aVar != null) {
            aVar.g();
        }
        this.J = null;
        setVisibility(8);
        this.F = false;
        this.f50777i = false;
        if (this.Q != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.Q);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (this.f50776h && this.F) {
            canvas.translate(this.M, this.N);
            if (this.E == 1) {
                Drawable drawable2 = this.J;
                if (drawable2 != null) {
                    int intrinsicWidth = drawable2.getIntrinsicWidth();
                    int intrinsicHeight = this.J.getIntrinsicHeight();
                    float f16 = f50769d0;
                    int i3 = (int) (intrinsicWidth * f16);
                    int i16 = (int) (intrinsicHeight * f16);
                    Drawable drawable3 = this.J;
                    int i17 = this.G;
                    int i18 = this.H;
                    drawable3.setBounds(((-i3) / 2) + i17, ((-i16) / 2) + i18, i17 + (i3 / 2), i18 + (i16 / 2));
                    this.J.draw(canvas);
                }
                h();
                canvas.translate(this.G - (com.qzone.proxy.feedcomponent.ui.a.f50813k / 2), this.H - com.qzone.proxy.feedcomponent.ui.a.f50814l);
                this.f50778m.b(canvas);
                canvas.translate(-r0, -r1);
            } else {
                if (this.f50773d) {
                    com.tencent.mobileqq.vas.ui.c cVar = this.P;
                    if (cVar == null) {
                        return;
                    } else {
                        drawable = cVar.getDrawable();
                    }
                } else {
                    drawable = this.Q;
                    if (drawable == null) {
                        return;
                    }
                }
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                int intrinsicHeight2 = drawable.getIntrinsicHeight();
                if (intrinsicWidth2 <= 0) {
                    return;
                }
                int i19 = this.G;
                int i26 = this.H;
                drawable.setBounds(((-intrinsicWidth2) / 2) + i19, ((-intrinsicHeight2) / 2) + i26, i19 + (intrinsicWidth2 / 2), i26 + (intrinsicHeight2 / 2));
                drawable.draw(canvas);
            }
            canvas.translate(-this.M, -this.N);
        }
    }

    public void setAnimationRes(String str, int i3, int i16, int i17) {
        String str2;
        if (this.L != i17) {
            n();
        }
        this.L = i17;
        this.E = i16;
        String str3 = this.C;
        if (str3 != null && !str3.equals(str)) {
            this.f50776h = false;
        }
        if (this.f50774e == null) {
            this.f50774e = ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(getContext());
        }
        this.f50774e.release();
        this.f50774e.setRecycleFlag(false);
        if (this.f50775f == null) {
            this.f50775f = new ZipLoadedListener() { // from class: com.qzone.proxy.feedcomponent.ui.CustomPraiseView.1
                @Override // cooperation.qzone.zipanimate.ZipLoadedListener
                public void onZipLoaded(boolean z16) {
                    CustomPraiseView customPraiseView = CustomPraiseView.this;
                    if (customPraiseView.f50776h) {
                        return;
                    }
                    customPraiseView.f50776h = z16;
                    customPraiseView.m(new Runnable() { // from class: com.qzone.proxy.feedcomponent.ui.CustomPraiseView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CustomPraiseView customPraiseView2 = CustomPraiseView.this;
                            if (customPraiseView2.F) {
                                if (customPraiseView2.f50777i) {
                                    customPraiseView2.f();
                                }
                                CustomPraiseView.this.l();
                            }
                        }
                    });
                }
            };
        }
        this.f50774e.setZipLoadedListener(this.f50775f);
        if (!this.f50776h || (str2 = this.C) == null || !str2.equals(str)) {
            this.f50774e.setDrawableData(str, -1, true);
        }
        if (i3 > 0) {
            this.D = i3;
        }
        this.C = str;
    }

    public void setParticleCenterDrawable(String str) {
        if (this.K == null) {
            this.K = new d();
        }
        i(str, this.K);
    }

    public void setScrollBy(int i3, int i16) {
        this.M += i3;
        this.N += i16;
        invalidate();
    }

    public void setShowPos(int i3, int i16) {
        this.G = i3;
        this.H = i16;
        this.M = 0;
        this.N = 0;
    }

    public void f() {
        this.f50777i = true;
        if (this.f50776h) {
            h();
            this.f50778m.g();
        }
    }

    void g() {
        setWillNotDraw(false);
        setVisibility(8);
        setLayerType(1, null);
        j();
    }

    public void l() {
        this.F = true;
        if (this.f50776h) {
            if (this.E == 1) {
                h();
                if (!this.f50777i) {
                    ZipDrawableLoaderInterface zipDrawableLoaderInterface = this.f50774e;
                    zipDrawableLoaderInterface.loadFrame(this.f50778m.c(zipDrawableLoaderInterface.getFrameCount()), new a());
                }
                this.U = SystemClock.uptimeMillis();
                this.V.removeMessages(1000);
                this.V.sendEmptyMessageDelayed(1000, 1000 / this.D);
                this.F = true;
                this.f50770a0 = -1;
                this.f50771b0 = -1;
                this.W = -1L;
                setVisibility(0);
                return;
            }
            if (this.f50773d) {
                if (this.T == null) {
                    com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k();
                    kVar.B(400);
                    kVar.C(400);
                    kVar.I(false);
                    kVar.y(1);
                    this.T = kVar;
                }
                com.tencent.mobileqq.vas.ui.c qzoneFrameDrawable = ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneFrameDrawable(this.C, "", this.T, 1);
                this.P = qzoneFrameDrawable;
                qzoneFrameDrawable.getDrawable().setCallback(this);
                this.P.h(new b());
            } else {
                if (this.Q == null) {
                    this.Q = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationListener(this.Q, new c());
                }
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.Q, this.C, this.D);
                this.Q.setCallback(this);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.Q, f50769d0);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.Q);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.Q);
            }
            this.F = true;
            this.f50770a0 = -1;
            this.f50771b0 = -1;
            this.W = -1L;
            this.U = SystemClock.uptimeMillis();
            setVisibility(0);
        }
    }

    public CustomPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f50773d = VasNormalToggle.VAS_QZONE_PRAISE_SWITCH_CONFIG.isEnable(true);
        this.D = 30;
        this.E = 0;
        this.I = 1;
        this.M = 0;
        this.N = 0;
        this.S = 2000L;
        this.V = new e(Looper.getMainLooper());
        this.W = -1L;
        this.f50770a0 = -1;
        this.f50771b0 = -1;
        this.f50772c0 = new Paint();
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements OnAnimationListener {
        c() {
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onAnimationFinished() {
            CustomPraiseView.this.setVisibility(8);
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onDrawableLoaded() {
        }
    }

    public CustomPraiseView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50773d = VasNormalToggle.VAS_QZONE_PRAISE_SWITCH_CONFIG.isEnable(true);
        this.D = 30;
        this.E = 0;
        this.I = 1;
        this.M = 0;
        this.N = 0;
        this.S = 2000L;
        this.V = new e(Looper.getMainLooper());
        this.W = -1L;
        this.f50770a0 = -1;
        this.f50771b0 = -1;
        this.f50772c0 = new Paint();
        g();
    }

    /* loaded from: classes39.dex */
    abstract class f implements ImageLoader.ImageLoadListener {
        f() {
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
