package n6;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.component.banner.Banner;
import com.qzone.component.banner.CreditAppealBanner;
import com.qzone.component.banner.MedalBanner;
import com.qzone.component.banner.MusicPlayerBanner;
import com.qzone.component.banner.NetStateCheckBanner;
import com.qzone.component.banner.QZoneMessageBubbleBanner;
import com.qzone.component.banner.VisitNotifyBanner;
import com.qzone.component.banner.WhatsNewBanner;
import com.qzone.component.banner.YellowDiamondTopBanner;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import gf.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f418414a;

    /* renamed from: b, reason: collision with root package name */
    private final c f418415b;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f418417d;

    /* renamed from: h, reason: collision with root package name */
    private d f418421h;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<Banner> f418416c = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private int f418418e = 0;

    /* renamed from: f, reason: collision with root package name */
    private Banner.a f418419f = new a();

    /* renamed from: g, reason: collision with root package name */
    private Comparator<Banner> f418420g = new b();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface c {
        n6.d getBannerManager();

        FrameLayout getTopBannerContainer();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface d {
        boolean a(int i3, int i16, String str);
    }

    public e(Activity activity, c cVar) {
        this.f418414a = activity;
        this.f418415b = cVar;
    }

    private boolean h() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        QZLog.e("TopBannerManager", "findOrCreateBannerIfNotExsit checkUIThread error");
        return false;
    }

    private Banner i(Context context, int i3) {
        if (context == null) {
            QZLog.e("TopBannerManager", 1, " TopBannerManager createBanner==null ,type=", Integer.valueOf(i3));
            return null;
        }
        if (i3 == 1) {
            return new NetStateCheckBanner(context);
        }
        if (i3 == 2) {
            return new QZoneMessageBubbleBanner(context);
        }
        if (i3 == 4) {
            return new MusicPlayerBanner(context);
        }
        if (i3 == 6) {
            return new CreditAppealBanner(context);
        }
        if (i3 == 9) {
            return new VisitNotifyBanner(context);
        }
        if (i3 == 20) {
            QZLog.i("TopBannerManager", "@bannershow TYPE_YELOWDIMOND_TOPBANNER");
            YellowDiamondTopBanner yellowDiamondTopBanner = new YellowDiamondTopBanner(context);
            yellowDiamondTopBanner.setDefaultLayoutParams();
            return yellowDiamondTopBanner;
        }
        if (i3 == 11) {
            return new WhatsNewBanner(context);
        }
        if (i3 != 12) {
            return null;
        }
        return new MedalBanner(context);
    }

    private int k(Activity activity) {
        int dimensionPixelSize;
        int notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), activity);
        if (notchHeight >= 0 && (dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.f159598b01)) < notchHeight) {
            return notchHeight - dimensionPixelSize;
        }
        return 0;
    }

    private void l() {
        if (this.f418417d == null) {
            m();
        }
    }

    private void m() {
        c cVar;
        if (this.f418414a != null && (cVar = this.f418415b) != null) {
            this.f418417d = cVar.getTopBannerContainer();
            int i3 = this.f418418e;
            if (i3 > 0) {
                n(this.f418414a, i3);
                return;
            } else {
                o(this.f418414a);
                return;
            }
        }
        QZLog.e("TopBannerManager", "initUI failed!! activity==null");
    }

    private void n(Activity activity, int i3) {
        FrameLayout frameLayout = this.f418417d;
        String str = "null";
        if (frameLayout == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[modifyTopMargin] act: ");
            FrameLayout frameLayout2 = this.f418417d;
            if (frameLayout2 != null) {
                str = frameLayout2.toString();
            }
            sb5.append(str);
            p(sb5.toString());
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i3 + k(activity);
            p("[modifyTopMargin] margin top: " + marginLayoutParams.topMargin);
            this.f418417d.setLayoutParams(layoutParams);
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[modifyTopMargin] top margin:");
        if (layoutParams != null) {
            str = layoutParams.toString();
        }
        sb6.append(str);
        p(sb6.toString());
    }

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d("TopBannerManager", 1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3, int i16) {
        Banner e16 = e(i3);
        if (e16 == null) {
            return;
        }
        e16.i(false);
        CopyOnWriteArrayList<Banner> copyOnWriteArrayList = this.f418416c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f418416c);
        Collections.sort(arrayList, this.f418420g);
        this.f418416c.clear();
        this.f418416c.addAll(arrayList);
        Iterator<Banner> it = this.f418416c.iterator();
        while (it.hasNext()) {
            Banner next = it.next();
            if (next != null && next != e16 && next.f46297e && next.f46298f && next.d() > i16 && !next.l() && (e16.d() >= 200 || next.d() < 200)) {
                next.i(true);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(int i3) {
        Banner e16 = e(i3);
        if (e16 == null) {
            return false;
        }
        Iterator<Banner> it = this.f418416c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Banner next = it.next();
            if (next != null && next != e16 && next.l()) {
                if (next.d() < e16.d()) {
                    return false;
                }
                if (next.d() == e16.d() && (next instanceof QZoneMessageBubbleBanner) && (e16 instanceof QZoneMessageBubbleBanner)) {
                    if (((QZoneMessageBubbleBanner) next).x() < ((QZoneMessageBubbleBanner) e16).x()) {
                        return false;
                    }
                    next.i(false);
                } else {
                    next.i(false);
                }
            }
        }
        if (!e16.l()) {
            r();
            e16.i(true);
        }
        return true;
    }

    @Override // gf.n
    public void a() {
        CopyOnWriteArrayList<Banner> copyOnWriteArrayList = this.f418416c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<Banner> it = this.f418416c.iterator();
        while (it.hasNext()) {
            Banner next = it.next();
            if (next != null && next.f46297e && next.e() != 4 && next.e() != 1 && next.e() != 9 && next.e() != 20 && next.l()) {
                next.g();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    @Override // gf.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.qzone.feed.business.model.a aVar) {
        Banner e16;
        d dVar;
        if (aVar == null) {
            QZLog.e("TopBannerManager", "dispatchBannerData==null");
            return;
        }
        QZLog.d("TopBannerManager", 1, "bannerType = " + aVar.f47117a);
        int i3 = aVar.f47117a;
        if (i3 != 2 && i3 != 6 && i3 != 14 && i3 != 20) {
            switch (i3) {
                case 9:
                    e16 = e(9);
                    break;
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    QZLog.e("TopBannerManager", "Unsupported Banner.");
                    e16 = null;
                    break;
            }
            int i16 = aVar.f47117a;
            int i17 = aVar.f47118b;
            String str = aVar.f47120d;
            dVar = this.f418421h;
            if (dVar != null) {
                u(aVar, e16);
                return;
            } else {
                if (dVar.a(i16, i17, str)) {
                    return;
                }
                u(aVar, e16);
                return;
            }
        }
        e16 = e(i3);
        int i162 = aVar.f47117a;
        int i172 = aVar.f47118b;
        String str2 = aVar.f47120d;
        dVar = this.f418421h;
        if (dVar != null) {
        }
    }

    @Override // gf.n
    public boolean d() {
        Activity activity = this.f418414a;
        return (activity == null || activity.isFinishing() || this.f418414a.isDestroyed()) ? false : true;
    }

    @Override // gf.n
    public Banner e(int i3) {
        FrameLayout j3;
        Banner banner = null;
        if (!h()) {
            return null;
        }
        if (this.f418416c == null) {
            this.f418416c = new CopyOnWriteArrayList<>();
        }
        synchronized (this) {
            try {
                try {
                    if (this.f418416c.size() != 0) {
                        Iterator<Banner> it = this.f418416c.iterator();
                        while (it.hasNext()) {
                            Banner next = it.next();
                            if (next.e() == i3) {
                                return next;
                            }
                        }
                    }
                } catch (Exception e16) {
                    QZLog.e("TopBannerManager", "findOrCreateBannerIfNotExsit error ", e16);
                }
                if (this.f418414a != null && (j3 = j()) != null) {
                    Banner i16 = i(this.f418414a, i3);
                    if (i16 != null) {
                        j3.addView(i16);
                        i16.h(null);
                        i16.setOnDisplayListener(this.f418419f);
                        this.f418416c.add(i16);
                    }
                    banner = i16;
                }
                return banner;
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    @Override // gf.n
    public void hide(int i3) {
        CopyOnWriteArrayList<Banner> copyOnWriteArrayList = this.f418416c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        if (QLog.isDebugVersion() || QLog.isColorLevel()) {
            QLog.d("TopBannerManager", 1, "[hide] current hide banner type: ", Integer.valueOf(i3));
        }
        Banner e16 = e(i3);
        if (e16 != null) {
            e16.g();
        }
    }

    public FrameLayout j() {
        if (this.f418417d == null) {
            l();
        }
        return this.f418417d;
    }

    public void q(d dVar) {
        this.f418421h = dVar;
    }

    public void r() {
        FrameLayout j3 = j();
        if (j3 == null || j3.getVisibility() == 0) {
            return;
        }
        j3.setVisibility(0);
    }

    public void v(int i3) {
        this.f418418e = i3;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements Banner.a {
        a() {
        }

        @Override // com.qzone.component.banner.Banner.a
        public boolean a(boolean z16, int i3, int i16) {
            if (z16) {
                return e.this.t(i3);
            }
            e.this.s(i3, i16);
            return true;
        }
    }

    @Override // gf.n
    public void c() {
        QZLog.i("TopBannerManager", 2, "destroyAll");
        CopyOnWriteArrayList<Banner> copyOnWriteArrayList = this.f418416c;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<Banner> it = this.f418416c.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.f418416c.clear();
        }
        FrameLayout frameLayout = this.f418417d;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    private void o(Activity activity) {
        int notchHeight;
        int dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams;
        if (activity == null || this.f418417d == null || (notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), activity)) <= 0 || (dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.f159598b01)) >= notchHeight || (layoutParams = this.f418417d.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin += notchHeight - dimensionPixelSize;
        this.f418417d.setLayoutParams(marginLayoutParams);
    }

    private void u(com.qzone.feed.business.model.a aVar, Banner banner) {
        if (banner == null) {
            return;
        }
        banner.t(aVar);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements Comparator<Banner> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Banner banner, Banner banner2) {
            if (banner == null) {
                return -1;
            }
            if (banner2 != null && banner.d() <= banner2.d()) {
                return banner.d() < banner2.d() ? -1 : 0;
            }
            return 1;
        }
    }
}
