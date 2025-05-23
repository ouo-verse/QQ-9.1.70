package com.tencent.mobileqq.vas.pendant.drawable;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.pendant.PendantBusiness;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantDrawable;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantRecycle;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPngPendantDrawable;
import com.tencent.mobileqq.vas.pendant.drawable.o;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.qzone.QZoneClickReport;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes20.dex */
public class PendantDrawable extends AbsAsyncDrawable implements IPendantRecycle {
    private static final boolean Q = ar.b("shouyouye", "2024-06-19", "vas_fix_aio_pendant_screen_shot_list").isEnable(true);
    private static final boolean R = ar.b("shouyouye", "2024-11-05", "vas_fix_aio_pendant_screen_shot_list_2").isEnable(true);
    private static final ConcurrentHashMap<Long, Object> S = new ConcurrentHashMap<>();
    private Drawable C;
    private o D;
    private DiyPendantDrawable E;
    private String F;
    private String G;
    private String H;
    private VipData.VipNumberInfo J;

    /* renamed from: e, reason: collision with root package name */
    private final long f310471e;

    /* renamed from: f, reason: collision with root package name */
    private final String f310472f;

    /* renamed from: h, reason: collision with root package name */
    private final int f310473h;

    /* renamed from: i, reason: collision with root package name */
    private final long f310474i;

    /* renamed from: m, reason: collision with root package name */
    private final int f310475m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f310470d = false;
    private boolean I = true;
    private boolean K = true;
    private boolean L = false;
    private final Runnable M = new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.PendantDrawable.1
        @Override // java.lang.Runnable
        public void run() {
            CacheStateMap.restart(PendantDrawable.this.f310471e);
        }
    };
    private final Runnable N = new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.g
        @Override // java.lang.Runnable
        public final void run() {
            PendantDrawable.this.e0();
        }
    };
    private final Runnable P = new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.PendantDrawable.2
        /* JADX WARN: Removed duplicated region for block: B:15:0x005d A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0007, B:8:0x003f, B:10:0x0045, B:11:0x0099, B:14:0x004f, B:15:0x005d, B:17:0x0065, B:18:0x0092, B:20:0x0094, B:21:0x0012, B:23:0x001a, B:25:0x0022, B:28:0x002b, B:30:0x0033), top: B:3:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x003f A[Catch: all -> 0x009b, TryCatch #0 {, blocks: (B:4:0x0007, B:8:0x003f, B:10:0x0045, B:11:0x0099, B:14:0x004f, B:15:0x005d, B:17:0x0065, B:18:0x0092, B:20:0x0094, B:21:0x0012, B:23:0x001a, B:25:0x0022, B:28:0x002b, B:30:0x0033), top: B:3:0x0007 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            synchronized (PendantDrawable.this.R()) {
                if (!PendantDrawable.this.O() && ((PendantDrawable.this.f310475m != 1 || (!PendantDrawable.this.Q() && !PendantDrawable.this.P())) && !PendantDrawable.this.Q() && !PendantDrawable.this.P())) {
                    z16 = false;
                    if (!z16) {
                        if (PendantDrawable.Q) {
                            PendantDrawable.this.N.run();
                        } else {
                            ThreadManagerV2.getUIHandlerV2().post(PendantDrawable.this.N);
                        }
                    } else if (PendantDrawable.this.K) {
                        PendantDrawable.this.d0();
                    } else {
                        QLog.e("PendantDrawable", 1, "no Auto download -> id" + PendantDrawable.this.f310471e + " target:" + PendantDrawable.this.f310474i);
                        return;
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements Function1<Canvas, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Canvas canvas) {
            if (PendantDrawable.this.getCurrentDrawable() == null) {
                try {
                    PendantDrawable.this.load(false);
                } catch (Exception e16) {
                    QLog.e("PendantDrawable", 1, "load exception", e16);
                }
            }
            PendantDrawable.this.draw(canvas);
            return null;
        }
    }

    public PendantDrawable(long j3, String str, int i3, long j16, int i16) {
        this.f310471e = j3;
        this.f310472f = str;
        this.f310473h = i3;
        this.f310474i = j16;
        this.f310475m = i16;
    }

    private Drawable M() {
        FastDynamicDrawable fastDynamicDrawable = null;
        if (PendantGreySwitch.isSupportAvifImage() && !TextUtils.isEmpty(this.F)) {
            fastDynamicDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(this.F).g(new a.c() { // from class: com.tencent.mobileqq.vas.pendant.drawable.j
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                    PendantDrawable.this.V(kVar);
                }
            }).a();
            CacheDrawable.CacheState a16 = fastDynamicDrawable.a();
            if (a16 == null) {
                fastDynamicDrawable.c0(new Function1() { // from class: com.tencent.mobileqq.vas.pendant.drawable.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit W;
                        W = PendantDrawable.this.W((com.tencent.cachedrawable.dynamicdrawable.d) obj);
                        return W;
                    }
                });
            } else {
                CacheStateMap.putCacheState(this.f310471e, this.F, a16);
            }
        }
        return fastDynamicDrawable;
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    private o N(Drawable drawable) {
        boolean z16;
        VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
        vipNumberInfo.setAppId(VipData.VipNumberInfo.APPID.Pendant.getId());
        vipNumberInfo.setItemId((int) this.f310471e);
        o oVar = new o(this.f310472f, drawable, vipNumberInfo);
        oVar.D(new o.a() { // from class: com.tencent.mobileqq.vas.pendant.drawable.i
            @Override // com.tencent.mobileqq.vas.pendant.drawable.o.a
            public final void success(VipData.VipNumberInfo vipNumberInfo2) {
                PendantDrawable.this.X(vipNumberInfo2);
            }
        });
        oVar.C(this.I);
        if (this.f310474i == PendantConstant.PENDANT_TARGET_ID_MARKET) {
            z16 = true;
        } else {
            z16 = false;
        }
        oVar.E(z16);
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O() {
        String str = this.F;
        String avifFileValid = T().avifFileValid(this.f310471e);
        this.F = avifFileValid;
        if (!TextUtils.equals(str, avifFileValid)) {
            this.f310470d = false;
        }
        return !TextUtils.isEmpty(this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        this.H = T().staticPngsValid(this.f310471e);
        return !TextUtils.isEmpty(r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        String str = this.G;
        String pngsFileValid = T().pngsFileValid(this.f310471e);
        this.G = pngsFileValid;
        if (!TextUtils.equals(str, pngsFileValid)) {
            this.f310470d = false;
        }
        return !TextUtils.isEmpty(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public Object R() {
        ConcurrentHashMap<Long, Object> concurrentHashMap = S;
        Object obj = concurrentHashMap.get(Long.valueOf(this.f310471e));
        if (obj == null) {
            synchronized (PendantDrawable.class) {
                obj = concurrentHashMap.get(Long.valueOf(this.f310471e));
                if (obj == null) {
                    obj = new Object();
                    concurrentHashMap.put(Long.valueOf(this.f310471e), obj);
                }
            }
        }
        return obj;
    }

    public static int S(long j3) {
        if (j3 == PendantConstant.PENDANT_TARGET_ID_MARKET) {
            return Integer.MAX_VALUE;
        }
        return 3;
    }

    private PendantBusiness T() {
        return (PendantBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L);
    }

    public static boolean U(String str, int i3) {
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
        if (this.f310474i == PendantConstant.PENDANT_TARGET_ID_AIO) {
            kVar.F(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
        }
        kVar.y(S(this.f310474i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit W(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        CacheStateMap.putCacheState(this.f310471e, this.F, dVar.a());
        return null;
    }

    private void c0() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.M);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.M, 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        if (!this.L && this.f310471e > 0) {
            this.L = true;
            T().addDownLoadListener((int) this.f310471e, new b(this));
            T().startDownload((int) this.f310471e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (this.f310474i != PendantConstant.PENDANT_TARGET_ID_AIO) {
            c0();
        }
        if (this.f310470d && this.C != null) {
            return;
        }
        this.f310470d = true;
        Drawable M = M();
        this.C = M;
        if (M == null) {
            this.C = new f(this.f310471e, this.f310474i);
            if (!TextUtils.isEmpty(this.G)) {
                ((IPngPendantDrawable) this.C).setPngPaths(this.G);
            } else if (!TextUtils.isEmpty(this.H)) {
                ((IPngPendantDrawable) this.C).setBigImgPath(this.H);
            }
        }
        if (U(this.f310472f, this.f310473h)) {
            DiyPendantDrawable diyPendantDrawable = new DiyPendantDrawable(this.C);
            diyPendantDrawable.setPendantDiy(this.f310472f + "_" + this.f310473h);
            this.E = diyPendantDrawable;
        }
        Drawable drawable = this.E;
        if (drawable == null) {
            drawable = this.C;
        }
        final o N = N(drawable);
        this.D = N;
        Z(this.J);
        setTargetDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.pendant.drawable.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Drawable Y;
                Y = PendantDrawable.Y(o.this);
                return Y;
            }
        });
        load(true ^ R);
    }

    public void Z(VipData.VipNumberInfo vipNumberInfo) {
        this.J = vipNumberInfo;
        o oVar = this.D;
        if (oVar != null) {
            if (this.I && vipNumberInfo == null) {
                oVar.A(false);
            } else if (vipNumberInfo != null) {
                oVar.B(vipNumberInfo, false);
            }
        }
    }

    public void a0(boolean z16) {
        this.K = z16;
    }

    public void b0(boolean z16) {
        this.I = z16;
        Z(this.J);
    }

    public void f0() {
        if (Q) {
            this.P.run();
            com.tencent.mobileqq.vas.image.i.f309597a.a(new a());
        } else {
            ThreadManagerV2.excute(this.P, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        if (this.C != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantRecycle
    public void recycle() {
        Object obj = this.C;
        if (obj instanceof IPendantDrawable) {
            ((IPendantDrawable) obj).recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<PendantDrawable> f310477a;

        public b(PendantDrawable pendantDrawable) {
            this.f310477a = new WeakReference<>(pendantDrawable);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            PendantDrawable pendantDrawable = this.f310477a.get();
            if (pendantDrawable != null) {
                pendantDrawable.f0();
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(VipData.VipNumberInfo vipNumberInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Drawable Y(o oVar) {
        return oVar;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NonNull ILoaderSucessCallback iLoaderSucessCallback) {
    }
}
