package cooperation.vip.qqbanner.manager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.view.TitleVasContentLayout;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.event.TianshuAdCloseEvent;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vassplash.common.c;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.ad.i;
import cooperation.vip.ad.w;
import cooperation.vip.tianshu.TianShuManager;
import i15.d;
import j15.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VasADBannerManager implements View.OnClickListener, SimpleEventReceiver {
    private static Boolean G;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<BaseActivity> f391314d;

    /* renamed from: e, reason: collision with root package name */
    private BannerManager f391315e;

    /* renamed from: f, reason: collision with root package name */
    protected View f391316f;

    /* renamed from: h, reason: collision with root package name */
    protected View f391317h;

    /* renamed from: i, reason: collision with root package name */
    protected URLImageView f391318i;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Boolean> f391319m = new HashMap();
    private boolean C = false;
    private long D = 0;
    private boolean E = false;
    private boolean F = false;

    private boolean B() {
        return ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).mAutomator.H2();
    }

    private void K() {
        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(35, null);
    }

    private void L() {
        j15.a g16;
        d f16;
        if (this.D == 0 || (g16 = cooperation.vip.qqbanner.manager.a.e().g(m())) == null || (f16 = g16.f()) == null) {
            return;
        }
        String str = f16.f407075f;
        String str2 = f16.f407074e;
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.D);
        this.D = 0L;
        QLog.d("VasADBannerManager", 2, "reportTianShuBannerStayDuration: " + currentTimeMillis);
        w.l(str, 133, currentTimeMillis, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(j15.a aVar) {
        boolean i3 = aVar.i();
        this.E = i3;
        if (i3) {
            boolean B = B();
            this.F = B;
            if (B) {
                K();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasADBannerManager", 2, "startPreloadWebView needed: " + this.E + ", done: " + this.F);
        }
    }

    private void P() {
        this.E = false;
        this.F = false;
        if (QLog.isColorLevel()) {
            QLog.d("VasADBannerManager", 2, "stopPreloadWebView");
        }
    }

    private void d(boolean z16) {
        I();
        y(z16);
        cooperation.vip.qqbanner.manager.a.e().m(m());
        if (i.j()) {
            BannerManager.l().D(VasADBannerProcessor.f185279h, 3001);
        }
    }

    private void e() {
        j15.a g16;
        d f16;
        if (i.j() && (g16 = cooperation.vip.qqbanner.manager.a.e().g(m())) != null && (f16 = g16.f()) != null && !TextUtils.isEmpty(f16.f407085p)) {
            SimpleEventBus.getInstance().dispatchEvent(new TianshuAdCloseEvent(f16.f407085p, hashCode()));
        }
    }

    public static VasADBannerManager f(BaseActivity baseActivity, BannerManager bannerManager) {
        j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(m());
        if (g16 != null) {
            VasADBannerManager e16 = g16.e();
            if (e16 != null) {
                e16.z(baseActivity, bannerManager);
            }
            return e16;
        }
        return null;
    }

    private static boolean i() {
        if (G == null) {
            G = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tian_shu_clear_url_drawable_listener", true));
        }
        return G.booleanValue();
    }

    private static String m() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("VasADBannerManager", 4, "getCurrentUin = " + runtime.getAccount());
            }
            return runtime.getAccount();
        }
        return null;
    }

    private String o(d dVar) {
        String str;
        String str2 = dVar.f407071b;
        if (!str2.contains("http://") && !str2.contains("https://")) {
            str2 = "https://" + str2;
        }
        if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str = str2 + "&qboss_trace=" + dVar.f407074e;
        } else {
            str = str2 + "?qboss_trace=" + dVar.f407074e;
        }
        return str + MobileReportManager.getStringQboos2H5(BaseApplicationImpl.getApplication().getRuntime().getAccount(), dVar.f407074e, ContainerUtils.FIELD_DELIMITER);
    }

    private void s(TianshuAdCloseEvent tianshuAdCloseEvent) {
        j15.a g16;
        d f16;
        if (tianshuAdCloseEvent == null || tianshuAdCloseEvent.getList() == null || tianshuAdCloseEvent.getList().isEmpty() || tianshuAdCloseEvent.getSenderHashCode() == hashCode() || (g16 = cooperation.vip.qqbanner.manager.a.e().g(m())) == null || (f16 = g16.f()) == null) {
            return;
        }
        QLog.d("VasADBannerManager", 1, "handleCloseEvent currentAdId:" + f16.f407075f);
        try {
            if (tianshuAdCloseEvent.getList().contains(Integer.valueOf(Integer.parseInt(f16.f407075f)))) {
                d(true);
            }
        } catch (Exception unused) {
        }
    }

    private boolean t(@NotNull Activity activity, d dVar) {
        if (TextUtils.isEmpty(dVar.f407072c)) {
            QLog.e("VasADBannerManager", 1, "handle Jump app schema, schemaUrl is empty");
            return u(activity, dVar);
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(dVar.f407072c));
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_jc_splash_screen");
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager != null && packageManager.resolveActivity(intent, 65536) != null) {
                activity.startActivity(intent);
                return true;
            }
        } catch (Exception e16) {
            QLog.e("VasADBannerManager", 1, "handleJumpAppSchema\uff0cerror" + e16);
        }
        return u(activity, dVar);
    }

    private boolean u(@NotNull Activity activity, d dVar) {
        if (TextUtils.isEmpty(dVar.f407071b)) {
            QLog.e("VasADBannerManager", 1, "handle Jump h5, jumpUrl is empty");
            return false;
        }
        String o16 = o(dVar);
        if (QLog.isDevelopLevel()) {
            QLog.i("VasADBannerManager", 4, "TraceInfo qboss banner final traceInfo jump url = " + o16);
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", o16);
            intent.putExtra("big_brother_source_key", "biz_src_jc_vip");
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            activity.startActivity(intent);
            return true;
        } catch (Exception e16) {
            QLog.e("VasADBannerManager", 1, "handleJumpH5" + e16);
            return false;
        }
    }

    private boolean v(@NotNull Activity activity, QQAppInterface qQAppInterface, d dVar) {
        if (qQAppInterface != null && !TextUtils.isEmpty(dVar.f407071b)) {
            try {
                ax c16 = bi.c(qQAppInterface, activity, dVar.f407071b);
                if (c16 != null) {
                    c16.b();
                    return true;
                }
            } catch (Exception e16) {
                QLog.e("VasADBannerManager", 1, "handleJumpSchema\uff0cerror" + e16);
            }
            return false;
        }
        QLog.e("VasADBannerManager", 1, "handle Jump schema, app is null || jumpUrl is empty");
        return false;
    }

    private boolean w(d dVar) {
        BaseActivity g16 = g();
        QQAppInterface h16 = h();
        if (g16 == null) {
            return false;
        }
        int i3 = dVar.f407073d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                return t(g16, dVar);
            }
            return v(g16, h16, dVar);
        }
        return u(g16, dVar);
    }

    @Nullable
    public View A() {
        QLog.i("VasADBannerManager", 1, "initVasADBanner");
        BaseActivity g16 = g();
        if (g16 == null) {
            QLog.e("VasADBannerManager", 1, "activity null, initVasADBanner failed");
            return null;
        }
        View inflate = LayoutInflater.from(g16).inflate(p(), (ViewGroup) null);
        this.f391316f = inflate;
        this.f391317h = inflate.findViewById(R.id.dij);
        this.f391318i = (URLImageView) this.f391316f.findViewById(R.id.di_);
        DisplayUtil.init(g16);
        ViewGroup.LayoutParams layoutParams = this.f391318i.getLayoutParams();
        layoutParams.width = r();
        layoutParams.height = k();
        this.f391318i.setLayoutParams(layoutParams);
        this.f391318i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f391318i.setOnClickListener(this);
        this.f391317h.setOnClickListener(this);
        this.f391316f.setVisibility(8);
        View view = this.f391316f;
        if (view instanceof TitleVasContentLayout) {
            ((TitleVasContentLayout) view).setTotalTitleHeight(k());
        }
        return this.f391316f;
    }

    public boolean C() {
        SparseArray<a.C10566a> sparseArray;
        j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(m());
        if (g16 != null && (sparseArray = g16.f409140a) != null && sparseArray.size() != 0) {
            return true;
        }
        QLog.i("VasADBannerManager", 1, "isNeedShowVasADBanner configInfo is null, return false.");
        return false;
    }

    public void D() {
        if (this.E && !this.F) {
            this.F = true;
            K();
        }
    }

    public void F() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QLog.e("VasADBannerManager", 1, "onRecycle");
        if (i()) {
            QLog.e("VasADBannerManager", 1, "clearUrlDrawableListener");
            URLImageView uRLImageView = this.f391318i;
            if (uRLImageView != null) {
                Drawable drawable = uRLImageView.getDrawable();
                if (drawable instanceof URLDrawable) {
                    ((URLDrawable) drawable).setURLDrawableListener(null);
                }
            }
        }
        j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(m());
        if (g16 != null && g16.f() != null) {
            if (g16.h()) {
                TianShuManager.getInstance().clearAdShowStatus(510);
            } else {
                TianShuManager.getInstance().clearAdShowStatus(715);
            }
        }
    }

    public void G(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("VasADBannerManager", 2, "onScrollChange isScroll = " + z16);
        }
    }

    public void H(j15.a aVar) {
        if (aVar != null && aVar.f() != null) {
            String str = aVar.f().f407075f;
            if (aVar.h() && aVar.g()) {
                w.j(str, 140, aVar.f().f407074e);
                if (QLog.isDebugVersion()) {
                    QLog.e("VasSplashBannerAd", 2, "report banner click success:140");
                    QLog.d("VasSplashBannerAd", 2, "start report [click] c2s url ----");
                }
                c.t(aVar.f().f407083n);
                ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("tianshu", "unionbanner", "click", str, m());
            } else if (aVar.h()) {
                w.r(str, 138, aVar.f().f407074e);
            } else {
                w.k(str, 102);
            }
            this.D = System.currentTimeMillis();
        }
    }

    public void I() {
        j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(m());
        if (g16 != null && g16.f() != null) {
            if (g16.h()) {
                w.r(g16.f().f407075f, 122, g16.f().f407074e);
            } else {
                w.k(g16.f().f407075f, 122);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(j15.a aVar) {
        if (aVar != null && aVar.f() != null) {
            String str = aVar.f().f407075f;
            if (aVar.h() && aVar.g()) {
                w.j(str, 117, aVar.f().f407074e);
                if (QLog.isDebugVersion()) {
                    QLog.e("VasSplashBannerAd", 2, "report banner expose success:117");
                    QLog.d("VasSplashBannerAd", 2, "start report [exposure] c2s url ----");
                }
                c.t(aVar.f().f407084o);
                ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("tianshu", "unionbanner", "expo", str, m());
            } else if (aVar.h()) {
                c.c(m() + "");
                w.r(str, 137, aVar.f().f407074e);
            } else {
                w.k(str, 101);
            }
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkAndPreloadRes(aVar.f().f407071b);
            IHippyAccessHelper iHippyAccessHelper = (IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class);
            TabPreloadItem.AdType adType = TabPreloadItem.AdType.MESSAGE_TAB_TOP_BANNER;
            if (iHippyAccessHelper.isAdNeedsPreload(str, adType)) {
                ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadAdHippy(str, adType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i3) {
        View view = this.f391317h;
        if (view != null && (view instanceof ImageView)) {
            ((ImageView) view).setColorFilter(i3);
        }
    }

    public void N() {
        d dVar;
        SparseArray<a.C10566a> sparseArray;
        int i3;
        boolean z16;
        if (this.f391316f != null && this.f391318i != null) {
            SimpleEventBus.getInstance().registerReceiver(this);
            QLog.i("VasADBannerManager", 1, "start showVasADBanner");
            j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(m());
            if (g16 != null) {
                dVar = g16.f();
            } else {
                dVar = null;
            }
            if (g16 != null && (sparseArray = g16.f409140a) != null && dVar != null) {
                a.C10566a c10566a = sparseArray.get(1);
                if (c10566a == null) {
                    QLog.e("VasADBannerManager", 1, "initVasADBanner resourceInfo = null");
                    x();
                    return;
                }
                if (!TextUtils.isEmpty(c10566a.f409145c) && ((i3 = dVar.f407070a) == 1 || i3 == 0)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    Drawable drawable = b.f306350a;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    obtain.mRequestWidth = l();
                    obtain.mRequestHeight = k();
                    if (dVar.f407070a == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    obtain.mPlayGifImage = z16;
                    final URLDrawable fileDrawable = URLDrawable.getFileDrawable(c10566a.f409145c, obtain);
                    if (fileDrawable == null) {
                        QLog.i("VasADBannerManager", 1, "initVasADBanner urlDrawable == null  file path = " + c10566a.f409145c);
                        x();
                        return;
                    }
                    this.f391318i.setImageDrawable(fileDrawable);
                    if (fileDrawable.getStatus() == 1) {
                        this.f391316f.setVisibility(0);
                        QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable status is success");
                        J(g16);
                        SetSplash.n(this.f391316f);
                        return;
                    }
                    fileDrawable.setURLDrawableListener(new a(g16));
                    ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADBannerManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            URLDrawable uRLDrawable = fileDrawable;
                            if (uRLDrawable != null) {
                                uRLDrawable.downloadImediatly(true);
                            }
                        }
                    });
                    return;
                }
                QLog.i("VasADBannerManager", 1, "initVasADBanner resType is wrong: " + dVar.f407070a + " file path = " + c10566a.f409145c);
                x();
                return;
            }
            QLog.i("VasADBannerManager", 1, "initVasADBanner config info is null, uin: " + m());
            x();
            return;
        }
        QLog.e("VasADBannerManager", 1, "showVasADBanner xml init error");
        x();
    }

    public void b() {
        if (QLog.isDevelopLevel()) {
            QLog.i("VasADBannerManager", 4, "checkIfHideBanner isClick: " + this.C);
        }
        if (this.C) {
            x();
            this.C = false;
        }
    }

    public void c() {
        Map<String, Boolean> map = this.f391319m;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseActivity g() {
        return this.f391314d.get();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TianshuAdCloseEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQAppInterface h() {
        BaseActivity g16 = g();
        if (g16 == null) {
            return null;
        }
        return g16.app;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String j(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        QQAppInterface h16 = h();
        if (h16 != null) {
            str2 = ac.f(h16, h16.getCurrentAccountUin());
        } else {
            str2 = "";
        }
        return str.replace("{nickname}", str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k() {
        return (int) (l() * 0.13333334f);
    }

    protected int l() {
        return DisplayUtil.getScreenWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View n(Bundle bundle) {
        View view = new View(g());
        view.setTag(bundle);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        g();
        QQAppInterface h16 = h();
        int id5 = view.getId();
        if (id5 != R.id.dij && id5 != R.id.f165789xl2) {
            if (id5 == R.id.f83264j3 || id5 == R.id.di_) {
                j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(m());
                if (g16 != null && g16.f() != null) {
                    d f16 = g16.f();
                    H(g16);
                    if (QLog.isColorLevel()) {
                        QLog.i("VasADBannerManager", 2, "qboss banner jump url = " + f16.f407071b + ", schema url = " + f16.f407072c);
                    }
                    this.C = w(f16);
                } else {
                    QLog.e("VasADBannerManager", 1, "qboss banner configInfo = null || bannerData = null");
                    EventCollector.getInstance().onViewClicked(view);
                }
            }
        } else {
            d(false);
        }
        ReportController.r(h16, "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 11, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TianshuAdCloseEvent) {
            s((TianshuAdCloseEvent) simpleBaseEvent);
        }
    }

    public void onResume() {
        b();
    }

    protected int p() {
        return R.layout.hgt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            QLog.e("VasADBannerManager", 1, "getValidTextColor, color =\uff0c " + str + "error:", e16);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int r() {
        return -1;
    }

    public void x() {
        y(false);
    }

    public void y(boolean z16) {
        QLog.e("VasADBannerManager", 1, "hideBanner");
        View view = this.f391316f;
        if (view != null) {
            view.setVisibility(8);
        }
        BannerManager bannerManager = this.f391315e;
        if (bannerManager != null) {
            bannerManager.D(VasADBannerProcessor.f185279h, 2000);
            P();
        }
        c();
        L();
        if (!z16) {
            e();
        }
    }

    public void z(BaseActivity baseActivity, BannerManager bannerManager) {
        this.f391314d = new WeakReference<>(baseActivity);
        this.f391315e = bannerManager;
    }

    public void E() {
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j15.a f391321d;

        a(j15.a aVar) {
            this.f391321d = aVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable load failed.");
            if (th5 != null) {
                th5.getMessage();
            }
            try {
                VasADBannerManager.this.x();
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("VasADBannerManager", 1, "onLoadFailed Exception");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable load success");
            try {
                VasADBannerManager vasADBannerManager = VasADBannerManager.this;
                View view = vasADBannerManager.f391316f;
                if (view != null && vasADBannerManager.f391318i != null && uRLDrawable != null) {
                    view.setVisibility(0);
                    VasADBannerManager.this.O(this.f391321d);
                    VasADBannerManager.this.J(this.f391321d);
                    SetSplash.n(VasADBannerManager.this.f391316f);
                } else if (view != null) {
                    QLog.w("VasADBannerManager", 1, "showVasADBanner and Animation failed, mUrlImageView :" + VasADBannerManager.this.f391318i + "urlDrawable :" + uRLDrawable);
                    VasADBannerManager.this.x();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("VasADBannerManager", 1, "onLoadSuccessed Exception");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
