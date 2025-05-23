package n6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.component.banner.ArkAdsBanner;
import com.qzone.component.banner.Banner;
import com.qzone.component.banner.BaseBubbleBanner;
import com.qzone.component.banner.DynamicAdsBanner;
import com.qzone.component.banner.MoodListBanner;
import com.qzone.component.banner.NewStyleOperationAdsBanner;
import com.qzone.component.banner.OperationAdsBanner;
import com.qzone.component.banner.PassiveFeedBubbleBanner;
import com.qzone.component.banner.QZoneFeedPublishMoodBanner;
import com.qzone.component.banner.QZoneGuidePublishMoodBanner;
import com.qzone.component.banner.SwipeOperationAdsBanner;
import com.qzone.component.banner.VisitorBubbleBanner;
import com.qzone.component.banner.WebViewBanner;
import com.qzone.component.banner.general.GeneralModelDispatchBanner;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import gf.g;
import gf.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d implements g, s {
    private static com.qzone.feed.business.model.a L;
    private static com.qzone.feed.business.model.a M;
    private static com.qzone.feed.business.model.a N;
    private static com.qzone.feed.business.model.a P;
    private static volatile boolean Q;
    private boolean C;
    private boolean D;
    private boolean E;
    private ArrayList<Banner> F;
    private LinearLayout G;

    /* renamed from: d, reason: collision with root package name */
    private final a f418408d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Banner> f418409e;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f418411h;

    /* renamed from: m, reason: collision with root package name */
    private boolean f418413m;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, ViewStub> f418410f = null;

    /* renamed from: i, reason: collision with root package name */
    private int f418412i = 0;
    private boolean H = true;
    private boolean I = false;
    private Comparator<Banner> J = new Comparator() { // from class: n6.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int x16;
            x16 = d.x((Banner) obj, (Banner) obj2);
            return x16;
        }
    };
    private Banner.a K = new Banner.a() { // from class: n6.c
        @Override // com.qzone.component.banner.Banner.a
        public final boolean a(boolean z16, int i3, int i16) {
            boolean y16;
            y16 = d.this.y(z16, i3, i16);
            return y16;
        }
    };

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface a {
        ViewStub getBannerContainerViewStub();

        void notifyFirstFeedUpdateView();
    }

    public d(Activity activity, a aVar) {
        this.f418411h = new WeakReference<>(activity);
        this.f418408d = aVar;
    }

    private void A(int i3, int i16) {
        Banner k3 = k(i3);
        if (k3 == null) {
            return;
        }
        k3.i(false);
        Collections.sort(this.f418409e, this.J);
        Iterator<Banner> it = this.f418409e.iterator();
        while (it.hasNext()) {
            Banner next = it.next();
            if (next != null && next != k3 && next.f46297e && next.f46298f && next.d() > i16 && !next.l()) {
                B(next.e());
                QZLog.i("HotBannerManager", "tryToHideBanner--showBanner:" + next.getClass().getSimpleName() + ",type:" + next.e());
                return;
            }
            if (next != null && next != k3 && (next instanceof BaseBubbleBanner) && (next.e() == 17 || next.e() == 23)) {
                if (next.l()) {
                    ((BaseBubbleBanner) next).J(false);
                    a aVar = this.f418408d;
                    if (aVar != null) {
                        aVar.notifyFirstFeedUpdateView();
                    }
                }
            }
        }
        C();
    }

    private synchronized boolean B(int i3) {
        Activity activity = this.f418411h.get();
        boolean z16 = false;
        if (activity == null) {
            return false;
        }
        if (activity.isFinishing()) {
            QZLog.i("HotBannerManager", "tryToShowBanner QZoneFriendFeedFragment isFinishing return");
            return false;
        }
        Banner k3 = k(i3);
        if (k3 != null && i.T0()) {
            if (this.F == null) {
                this.F = new ArrayList<>();
            }
            this.F.add(k3);
            QZLog.d("HotBannerManager", 1, "tryToShowBanner:localPhoto, the first feed is recommend feed.");
            return false;
        }
        if (k3 != null) {
            QZLog.i("HotBannerManager", 4, "tryToShowBanner--bannerToShow:" + k3.getClass().getSimpleName() + ",type:" + k3.e() + ",isVisible:" + k3.l() + ",priority:" + k3.d());
            Iterator<Banner> it = this.f418409e.iterator();
            while (it.hasNext()) {
                Banner next = it.next();
                if (next != null && next != k3 && next.l()) {
                    QZLog.i("HotBannerManager", 4, "tryToShowBanner--bannerToCheck:" + next.getClass().getSimpleName() + ",type:" + next.e() + ",isVisible:" + next.l() + ",priority:" + next.d());
                    if (next.d() < k3.d()) {
                        if (!p(next, k3)) {
                            return false;
                        }
                        QZLog.i("HotBannerManager", 1, "tryToShowBanner--can show while high priority banner exists.");
                    } else {
                        p(k3, next);
                    }
                }
            }
            QZLog.i("HotBannerManager", 1, "tryToShowBanner--show banner:" + k3.getClass().getSimpleName() + ",type:" + k3.e());
            if (com.qzone.component.banner.a.a(i3)) {
                i.C2(true);
                a aVar = this.f418408d;
                if (aVar != null) {
                    aVar.notifyFirstFeedUpdateView();
                }
            }
            k3.i(true);
            C();
            a aVar2 = this.f418408d;
            if (aVar2 != null) {
                aVar2.notifyFirstFeedUpdateView();
            }
            z16 = true;
        }
        return z16;
    }

    private boolean p(Banner banner, Banner banner2) {
        if (t(banner, banner2)) {
            z(banner, banner2);
            return true;
        }
        banner2.i(false);
        QZLog.i("HotBannerManager", 1, "tryToShowBanner--banner not show:" + banner2.getClass().getSimpleName() + ",type:" + banner2.e());
        return false;
    }

    private boolean q() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        QZLog.e("HotBannerManager", "findOrCreateBannerIfNotExsit checkUIThread error");
        return false;
    }

    private boolean t(Banner banner, Banner banner2) {
        return w(banner, banner2) || banner.e() == 23;
    }

    private boolean u(int i3) {
        if (i3 != 17 && i3 != 23) {
            return true;
        }
        return false;
    }

    public static boolean v() {
        return Q;
    }

    private boolean w(Banner banner, Banner banner2) {
        return (banner.e() != 17 || banner2.e() == 23 || banner2.e() == 27) ? false : true;
    }

    private void z(Banner banner, Banner banner2) {
        if (banner instanceof BaseBubbleBanner) {
            if (com.qzone.component.banner.a.a(banner2.e())) {
                ((BaseBubbleBanner) banner).K(true, false);
            } else {
                ((BaseBubbleBanner) banner).J(true);
            }
        }
    }

    @Override // gf.s
    public View R() {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList == null) {
            return null;
        }
        Iterator<Banner> it = arrayList.iterator();
        while (it.hasNext()) {
            ViewParent viewParent = (Banner) it.next();
            if (viewParent instanceof s) {
                return ((s) viewParent).R();
            }
        }
        return null;
    }

    @Override // gf.g
    public void a() {
        int i3;
        VisitorBubbleBanner visitorBubbleBanner;
        PassiveFeedBubbleBanner passiveFeedBubbleBanner;
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Banner> it = this.f418409e.iterator();
            while (it.hasNext()) {
                Banner next = it.next();
                if (next != null && next.f46297e && next.l() && next.j() && ((i3 = this.f418412i) == 0 || i3 != next.e())) {
                    next.g();
                    if (e(17) && (passiveFeedBubbleBanner = (PassiveFeedBubbleBanner) k(17)) != null) {
                        passiveFeedBubbleBanner.J(false);
                    }
                    if (e(23) && (visitorBubbleBanner = (VisitorBubbleBanner) k(23)) != null) {
                        visitorBubbleBanner.J(false);
                    }
                }
            }
        }
        this.f418412i = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:4:0x0005, B:7:0x000c, B:9:0x0012, B:11:0x0016, B:16:0x0021, B:17:0x0026, B:18:0x002a, B:20:0x002f, B:21:0x0032, B:22:0x0035, B:23:0x0038, B:25:0x0057, B:27:0x005b, B:28:0x006b, B:30:0x005e, B:32:0x0062, B:33:0x0065, B:35:0x0069, B:36:0x006f, B:38:0x0051), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:4:0x0005, B:7:0x000c, B:9:0x0012, B:11:0x0016, B:16:0x0021, B:17:0x0026, B:18:0x002a, B:20:0x002f, B:21:0x0032, B:22:0x0035, B:23:0x0038, B:25:0x0057, B:27:0x005b, B:28:0x006b, B:30:0x005e, B:32:0x0062, B:33:0x0065, B:35:0x0069, B:36:0x006f, B:38:0x0051), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0051 A[Catch: all -> 0x0076, FALL_THROUGH, TryCatch #0 {all -> 0x0076, blocks: (B:4:0x0005, B:7:0x000c, B:9:0x0012, B:11:0x0016, B:16:0x0021, B:17:0x0026, B:18:0x002a, B:20:0x002f, B:21:0x0032, B:22:0x0035, B:23:0x0038, B:25:0x0057, B:27:0x005b, B:28:0x006b, B:30:0x005e, B:32:0x0062, B:33:0x0065, B:35:0x0069, B:36:0x006f, B:38:0x0051), top: B:2:0x0003 }] */
    @Override // gf.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.qzone.feed.business.model.a aVar) {
        Banner k3;
        LinearLayout linearLayout;
        try {
            if (aVar == null) {
                QZLog.e("HotBannerManager", "dispatchBannerData data==null");
                return;
            }
            if (u5.a.e() && (linearLayout = this.G) != null) {
                int i3 = aVar.f47117a;
                if (i3 != 17 && i3 != 23) {
                    linearLayout.setImportantForAccessibility(4);
                }
                linearLayout.setImportantForAccessibility(1);
            }
            int i16 = aVar.f47117a;
            if (i16 != 5) {
                switch (i16) {
                    default:
                        switch (i16) {
                            default:
                                switch (i16) {
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                        break;
                                    default:
                                        QZLog.e("HotBannerManager", "Unsupported Banner Type. data.bannerType=" + aVar.f47117a);
                                        k3 = null;
                                        break;
                                }
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                                k3 = k(i16);
                                break;
                        }
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                }
                if (k3 == null) {
                    if (k3 instanceof OperationAdsBanner) {
                        L = aVar;
                    } else if (k3 instanceof NewStyleOperationAdsBanner) {
                        M = aVar;
                    } else if (k3 instanceof ArkAdsBanner) {
                        P = aVar;
                    }
                    k3.t(aVar);
                    return;
                }
                QZLog.e("HotBannerManager", "dispatchBannerData banner == null");
                return;
            }
            k3 = k(i16);
            if (k3 == null) {
            }
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
            LinearLayout linearLayout2 = this.G;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    @Override // gf.g
    public void c() {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Banner> it = this.f418409e.iterator();
            while (it.hasNext()) {
                Banner next = it.next();
                int e16 = next.e();
                if (e16 == 5) {
                    if (((OperationAdsBanner) next).C) {
                        this.f418413m = true;
                        L = null;
                    } else {
                        this.f418413m = false;
                    }
                } else if (e16 == 18) {
                    if (((NewStyleOperationAdsBanner) next).f46390f0) {
                        this.C = true;
                        M = null;
                    } else {
                        this.C = false;
                    }
                } else if (e16 == 26) {
                    if (((DynamicAdsBanner) next).f46390f0) {
                        this.D = true;
                        N = null;
                    } else {
                        this.D = false;
                    }
                } else if (e16 == 31) {
                    if (((ArkAdsBanner) next).f46291i) {
                        this.E = true;
                        P = null;
                    } else {
                        this.E = false;
                    }
                }
                next.destroy();
            }
            this.f418409e.clear();
        }
        HashMap<Integer, ViewStub> hashMap = this.f418410f;
        if (hashMap != null) {
            hashMap.clear();
        }
        C();
    }

    @Override // gf.g
    public void d(Configuration configuration) {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList == null) {
            return;
        }
        Iterator<Banner> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().n(configuration);
        }
    }

    @Override // gf.g
    public boolean e(int i3) {
        if (this.f418409e == null) {
            return false;
        }
        synchronized (this) {
            if (this.f418409e.size() != 0) {
                Iterator<Banner> it = this.f418409e.iterator();
                while (it.hasNext()) {
                    Banner next = it.next();
                    if (next != null && next.e() == i3) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // gf.g
    public void f(int i3) {
        LinearLayout linearLayout = this.G;
        if (linearLayout != null) {
            com.qzone.reborn.feedx.widget.i.a(linearLayout, i3);
        }
    }

    @Override // gf.g
    public void h() {
        ArrayList<Banner> arrayList = this.F;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int size = this.F.size();
        int i3 = 1025;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < size; i18++) {
            Banner banner = this.F.get(i18);
            if (banner.d() < i3) {
                i16 = banner.e();
                i3 = banner.d();
                i17 = i18;
            }
        }
        if (i16 != -1) {
            B(i16);
            if (this.F.get(i17).k()) {
                return;
            }
            this.F.remove(i17);
        }
    }

    @Override // gf.g
    public void i(int i3) {
        this.f418412i = i3;
    }

    @Override // gf.g
    public Banner k(int i3) {
        Activity activity;
        Banner banner = null;
        if (!q()) {
            return null;
        }
        if (this.f418409e == null) {
            this.f418409e = new ArrayList<>();
        }
        synchronized (this) {
            if (this.f418409e.size() != 0) {
                Iterator<Banner> it = this.f418409e.iterator();
                while (it.hasNext()) {
                    Banner next = it.next();
                    if (next != null && next.e() == i3) {
                        return next;
                    }
                }
            }
            WeakReference<Activity> weakReference = this.f418411h;
            if (weakReference != null && (activity = weakReference.get()) != null && (banner = r(i3, activity)) != null) {
                this.f418409e.add(banner);
                if (banner.e() == 27) {
                    o(banner);
                }
            }
            return banner;
        }
    }

    @Override // gf.g
    public void l(boolean z16) {
        if ((L == null && M == null && N == null && P == null) || u5.a.e()) {
            QZLog.e("HotBannerManager", "dispatchOperationAdsOrFriendVideoBannerData==null");
            return;
        }
        com.qzone.feed.business.model.a aVar = L;
        if (aVar != null && z16) {
            if (!this.f418413m) {
                Banner k3 = k(aVar.f47117a);
                if (k3 == null || !(k3 instanceof OperationAdsBanner)) {
                    return;
                }
                ((OperationAdsBanner) k3).D = false;
                k3.t(L);
                return;
            }
            L = null;
            return;
        }
        com.qzone.feed.business.model.a aVar2 = M;
        if (aVar2 != null && z16) {
            if (!this.C) {
                Banner k16 = k(aVar2.f47117a);
                if (k16 == null || !(k16 instanceof NewStyleOperationAdsBanner)) {
                    return;
                }
                ((NewStyleOperationAdsBanner) k16).f46392g0 = false;
                k16.t(M);
                return;
            }
            M = null;
            return;
        }
        com.qzone.feed.business.model.a aVar3 = N;
        if (aVar3 != null && z16) {
            if (!this.D) {
                Banner k17 = k(aVar3.f47117a);
                if (k17 == null || !(k17 instanceof DynamicAdsBanner)) {
                    return;
                }
                ((DynamicAdsBanner) k17).f46392g0 = false;
                k17.t(N);
                return;
            }
            N = null;
            return;
        }
        com.qzone.feed.business.model.a aVar4 = P;
        if (aVar4 == null || !z16) {
            return;
        }
        if (!this.E) {
            Banner k18 = k(aVar4.f47117a);
            if (k18 == null || !(k18 instanceof ArkAdsBanner)) {
                return;
            }
            ((ArkAdsBanner) k18).f46292m = false;
            k18.t(P);
            return;
        }
        P = null;
    }

    public void o(Banner banner) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(banner);
    }

    @Override // gf.g
    public void onActivityResult(int i3, int i16, Intent intent) {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null) {
            Iterator<Banner> it = arrayList.iterator();
            while (it.hasNext()) {
                Banner next = it.next();
                if (next != null && next.l()) {
                    next.m(i3, i16, intent);
                }
            }
        }
    }

    @Override // gf.g
    public void onPause() {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null) {
            Iterator<Banner> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().q();
            }
        }
    }

    @Override // gf.g
    public void onResume() {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null) {
            Iterator<Banner> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().r();
            }
        }
    }

    @Override // gf.g
    public void onScrollStateChanged(int i3, int i16) {
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null) {
            boolean z16 = true;
            boolean z17 = i3 == 0;
            if (this.H != z17) {
                this.H = z17;
            } else {
                z16 = false;
            }
            Iterator<Banner> it = arrayList.iterator();
            while (it.hasNext()) {
                Banner next = it.next();
                next.s(i16);
                if (z16) {
                    next.o(this.H);
                }
            }
        }
    }

    private boolean C() {
        boolean z16 = false;
        Q = false;
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Banner> it = this.f418409e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Banner next = it.next();
                if (next != null && next.f46297e && next.l() && u(next.e())) {
                    Q = true;
                    if (com.qzone.component.banner.a.a(next.e())) {
                        z16 = true;
                    }
                }
            }
        }
        i.C2(z16);
        i.y2(Q);
        return Q;
    }

    private Banner r(int i3, Context context) {
        Banner operationAdsBanner;
        HashMap<Integer, ViewStub> hashMap;
        if (context == null) {
            QZLog.e("HotBannerManager", 1, " HotBannerManager createBanner==null ,type=", Integer.valueOf(i3));
            return null;
        }
        if (lm.a.f414989a.f(i3)) {
            QZLog.e("HotBannerManager", 1, "banner is forbidden, type: " + i3);
            return null;
        }
        if (i3 == 5) {
            operationAdsBanner = new OperationAdsBanner(context);
        } else if (i3 == 21) {
            operationAdsBanner = new SwipeOperationAdsBanner(context);
        } else if (i3 != 23) {
            switch (i3) {
                case 17:
                    operationAdsBanner = new PassiveFeedBubbleBanner(context);
                    break;
                case 18:
                    operationAdsBanner = new NewStyleOperationAdsBanner(context);
                    break;
                case 19:
                    operationAdsBanner = new WebViewBanner(context);
                    break;
                default:
                    switch (i3) {
                        case 26:
                            operationAdsBanner = new DynamicAdsBanner(context);
                            break;
                        case 27:
                            operationAdsBanner = new MoodListBanner(context);
                            Q = true;
                            break;
                        case 28:
                            operationAdsBanner = new QZoneFeedPublishMoodBanner(context);
                            break;
                        case 29:
                            operationAdsBanner = new QZoneGuidePublishMoodBanner(this.f418411h.get());
                            break;
                        case 30:
                            operationAdsBanner = new GeneralModelDispatchBanner(context);
                            break;
                        case 31:
                            operationAdsBanner = new ArkAdsBanner(context);
                            break;
                        default:
                            operationAdsBanner = null;
                            break;
                    }
            }
        } else {
            operationAdsBanner = new VisitorBubbleBanner(context);
        }
        if (!this.I) {
            QLog.d("HotBannerManager", 1, "has not been initiated, init");
            boolean s16 = s();
            this.I = s16;
            if (!s16) {
                QLog.e("HotBannerManager", 1, "init fail, return null");
                return null;
            }
        }
        if (operationAdsBanner != null && (hashMap = this.f418410f) != null && hashMap.get(Integer.valueOf(i3)) != null) {
            operationAdsBanner.setOnDisplayListener(this.K);
            operationAdsBanner.h(this.f418410f.get(Integer.valueOf(i3)));
        }
        return operationAdsBanner;
    }

    private boolean s() {
        try {
            if (this.f418411h.get() == null) {
                QZLog.e("HotBannerManager", "initUI fail: activity is null");
                return false;
            }
            ViewStub bannerContainerViewStub = this.f418408d.getBannerContainerViewStub();
            if (bannerContainerViewStub == null) {
                QZLog.e("HotBannerManager", "initUI fail: viewStub is null");
                return false;
            }
            LinearLayout linearLayout = (LinearLayout) bannerContainerViewStub.inflate().findViewById(R.id.h9k);
            this.G = linearLayout;
            if (linearLayout == null) {
                QZLog.e("HotBannerManager", "initUI fail: container is null");
                return false;
            }
            f(QZoneCoverUtils.getSuperCoverTrans(null));
            this.f418410f = new HashMap<>();
            ViewStub viewStub = (ViewStub) this.G.findViewById(R.id.h_9);
            ViewStub viewStub2 = (ViewStub) this.G.findViewById(R.id.h__);
            ViewStub viewStub3 = (ViewStub) this.G.findViewById(R.id.f67763e8);
            ViewStub viewStub4 = (ViewStub) this.G.findViewById(R.id.f67783e_);
            ViewStub viewStub5 = (ViewStub) this.G.findViewById(R.id.hlw);
            ViewStub viewStub6 = (ViewStub) this.G.findViewById(R.id.hun);
            ViewStub viewStub7 = (ViewStub) this.G.findViewById(R.id.ha5);
            ViewStub viewStub8 = (ViewStub) this.G.findViewById(R.id.hsc);
            ViewStub viewStub9 = (ViewStub) this.G.findViewById(R.id.h9d);
            ViewStub viewStub10 = (ViewStub) this.G.findViewById(R.id.d2o);
            ViewStub viewStub11 = (ViewStub) this.G.findViewById(R.id.f67733e5);
            ViewStub viewStub12 = (ViewStub) this.G.findViewById(R.id.vng);
            this.f418410f.put(5, viewStub);
            this.f418410f.put(18, viewStub2);
            this.f418410f.put(28, viewStub3);
            this.f418410f.put(29, viewStub4);
            this.f418410f.put(17, viewStub5);
            this.f418410f.put(23, viewStub6);
            this.f418410f.put(19, viewStub7);
            this.f418410f.put(21, viewStub8);
            this.f418410f.put(26, viewStub9);
            this.f418410f.put(27, viewStub10);
            this.f418410f.put(31, viewStub11);
            this.f418410f.put(30, viewStub12);
            i.y2(Q);
            return true;
        } catch (Exception e16) {
            QZLog.e("HotBannerManager", "initUI", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y(boolean z16, int i3, int i16) {
        if (z16) {
            return B(i3);
        }
        A(i3, i16);
        return true;
    }

    @Override // gf.g
    public void g() {
        VisitorBubbleBanner visitorBubbleBanner;
        PassiveFeedBubbleBanner passiveFeedBubbleBanner;
        if (e(17) && (passiveFeedBubbleBanner = (PassiveFeedBubbleBanner) k(17)) != null) {
            passiveFeedBubbleBanner.J(false);
        }
        if (e(23) && (visitorBubbleBanner = (VisitorBubbleBanner) k(23)) != null) {
            visitorBubbleBanner.J(false);
        }
        h();
    }

    @Override // gf.g
    public void j(Message message) {
        if (message == null) {
            QZLog.e("HotBannerManager", "msg  ==null || bannerType = TYPE_NONE");
            return;
        }
        ArrayList<Banner> arrayList = this.f418409e;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<Banner> it = this.f418409e.iterator();
        while (it.hasNext()) {
            Banner next = it.next();
            if (next != null && next.f46297e && next.l()) {
                next.f(message);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x(Banner banner, Banner banner2) {
        if (banner == null) {
            return -1;
        }
        if (banner2 == null) {
            return 1;
        }
        return Integer.compare(banner.d(), banner2.d());
    }
}
