package com.tencent.mobileqq.banner;

import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.activity.recent.bannerprocessor.AdDownloaderBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.DressUpBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameCenterBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameCenterTipsProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GeneralBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MiniBoxBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MusicPlayerBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NtMsgMigrationBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PhoneUnityBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.processor.f;
import com.tencent.mobileqq.flashtransfer.FlashTransferErrBannerProcessor;
import com.tencent.mobileqq.flashtransfer.FlashTransferProgressBannerProcessor;
import com.tencent.mobileqq.font.banner.FontSizeChangeBannerProcessor;
import com.tencent.mobileqq.minigame.va.banner.MiniGameVAResourceBanner;
import com.tencent.mobileqq.onlinestatus.processor.OnlineStatusDNDBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.banner.VasZplanBannerProcessor;
import com.tencent.mobileqq.vashealth.RunningBannerProcessor;
import com.tencent.mobileqq.wifiphoto.banner.ExportFileBannerProcessor;
import com.tencent.mobileqq.wifiphoto.banner.WifiPhotoBannerProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.theme.TextHook;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BannerManager implements com.tencent.mobileqq.banner.processor.a {
    static IPatchRedirector $redirector_;
    private static int A;
    private static int B;
    private static int C;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> D;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> E;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> F;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> G;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> H;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> I;

    @ConfigInject(configPath = "/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version = 6)
    private static final ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> J;

    /* renamed from: m, reason: collision with root package name */
    private static volatile BannerManager f200200m;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f200201n;

    /* renamed from: o, reason: collision with root package name */
    private static int f200202o;

    /* renamed from: p, reason: collision with root package name */
    private static int f200203p;

    /* renamed from: q, reason: collision with root package name */
    private static int f200204q;

    /* renamed from: r, reason: collision with root package name */
    private static int f200205r;

    /* renamed from: s, reason: collision with root package name */
    public static int f200206s;

    /* renamed from: t, reason: collision with root package name */
    public static int f200207t;

    /* renamed from: u, reason: collision with root package name */
    private static int f200208u;

    /* renamed from: v, reason: collision with root package name */
    private static int f200209v;

    /* renamed from: w, reason: collision with root package name */
    private static int f200210w;

    /* renamed from: x, reason: collision with root package name */
    private static int f200211x;

    /* renamed from: y, reason: collision with root package name */
    private static int f200212y;

    /* renamed from: z, reason: collision with root package name */
    private static int f200213z;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QBaseActivity> f200214a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<a> f200215b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.banner.a[] f200216c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f200217d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<ArrayList<Integer>> f200218e;

    /* renamed from: f, reason: collision with root package name */
    private SparseArray<ArrayList<Integer>> f200219f;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList<Integer> f200220g;

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, com.tencent.mobileqq.banner.processor.e> f200221h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<com.tencent.mobileqq.banner.processor.c> f200222i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<com.tencent.mobileqq.banner.processor.d> f200223j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<com.tencent.mobileqq.banner.processor.b> f200224k;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<f> f200225l;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(com.tencent.mobileqq.banner.a aVar, int i3);

        void b(com.tencent.mobileqq.banner.a aVar);

        void c();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList = new ArrayList<>();
        D = arrayList;
        arrayList.add(NetStateBannerProcessor.class);
        arrayList.add(PhoneUnityBannerProcessor.class);
        arrayList.add(SecureModifyPwdNotifyBannerProcessor.class);
        arrayList.add(SecurePhoneChangeNotifyBannerProcessor.class);
        arrayList.add(MissedCallBannerProcessor.class);
        arrayList.add(MobileUnityBannerProcessor.class);
        arrayList.add(FontSizeChangeBannerProcessor.class);
        arrayList.add(WifiPhotoBannerProcessor.class);
        arrayList.add(ExportFileBannerProcessor.class);
        arrayList.add(NetNeedSignOnBannerProcessor.class);
        arrayList.add(IllegalNetworkBannerProcessor.class);
        arrayList.add(DonDisturbBannerProcessor.class);
        arrayList.add(PCOnlineBannerProcessor.class);
        arrayList.add(UpgradeBannerProcessor.class);
        arrayList.add(InstallUpgradeBannerProcessor.class);
        arrayList.add(ContactBannerProcessor.class);
        arrayList.add(SetPwdBannerProcessor.class);
        arrayList.add(VerifyPhoneBannerProcessor.class);
        arrayList.add(OnlineStatusDNDBannerProcessor.class);
        arrayList.add(VasADBannerProcessor.class);
        arrayList.add(PushBannerProcessor.class);
        arrayList.add(QQWifiBannerProcessor.class);
        arrayList.add(RenewalsBannerProcessor.class);
        arrayList.add(ThemeVersionUpdateBannerProcessor.class);
        arrayList.add(ThemeOverdueBannerProcessor.class);
        arrayList.add(DressUpBannerProcessor.class);
        arrayList.add(NtMsgMigrationBannerProcessor.class);
        arrayList.add(MiniGameVAResourceBanner.class);
        arrayList.add(FlashTransferErrBannerProcessor.class);
        arrayList.add(FlashTransferProgressBannerProcessor.class);
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList2 = new ArrayList<>();
        E = arrayList2;
        arrayList2.add(LoginDevicesBannerProcessor.class);
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList3 = new ArrayList<>();
        F = arrayList3;
        arrayList3.add(ComicBannerProcessor.class);
        arrayList3.add(BrowserBannerProcessor.class);
        arrayList3.add(GameCenterBannerProcessor.class);
        arrayList3.add(GameBannerProcessor.class);
        arrayList3.add(RunningBannerProcessor.class);
        arrayList3.add(MiniBoxBannerProcessor.class);
        arrayList3.add(VasZplanBannerProcessor.class);
        arrayList3.add(AdDownloaderBannerProcessor.class);
        arrayList3.add(GameCenterTipsProcessor.class);
        arrayList3.add(GeneralBannerProcessor.class);
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList4 = new ArrayList<>();
        G = arrayList4;
        arrayList4.add(MusicPlayerBannerProcessor.class);
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList5 = new ArrayList<>();
        H = arrayList5;
        arrayList5.add(MultiVideoBannerProcessor.class);
        arrayList5.add(QLinkTransingBannerProcessor.class);
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList6 = new ArrayList<>();
        I = arrayList6;
        arrayList6.add(MsgBackupBannerProcessor.class);
        arrayList6.add(NotificationGuideBannerProcessor.class);
        ArrayList<Class<? extends com.tencent.mobileqq.banner.processor.e>> arrayList7 = new ArrayList<>();
        J = arrayList7;
        arrayList7.add(BeginnerGuideBannerProcessor.class);
    }

    BannerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f200214a = new WeakReference<>(null);
        this.f200215b = new WeakReference<>(null);
        this.f200217d = false;
        this.f200218e = new SparseArray<>(7);
        this.f200220g = new ArrayList<>();
        this.f200221h = new ConcurrentHashMap<>();
        this.f200222i = new ArrayList<>();
        this.f200223j = new ArrayList<>();
        this.f200224k = new ArrayList<>();
        this.f200225l = new ArrayList<>();
    }

    private void C(int i3, Message message) {
        Message obtain;
        for (int i16 = 0; i16 < 7; i16++) {
            ArrayList<Integer> arrayList = this.f200218e.get(i16);
            if (arrayList != null) {
                Iterator<Integer> it = arrayList.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    com.tencent.mobileqq.banner.a aVar = this.f200216c[intValue];
                    Message message2 = null;
                    if (message == null) {
                        obtain = null;
                    } else {
                        obtain = Message.obtain(message);
                    }
                    if (i3 == intValue) {
                        message2 = obtain;
                    }
                    if (a(aVar, z16, message2)) {
                        if (QLog.isColorLevel() && !z16) {
                            QLog.d("Q.recent.banner", 2, "showAllBanner, show banner, banner_layer:", Integer.valueOf(i16), " bannerId:", Integer.valueOf(intValue));
                        }
                        if (QLog.isColorLevel() && z16) {
                            QLog.d("Q.recent.banner", 2, "showAllBanner, cache banner, banner_layer:", Integer.valueOf(i16), " bannerId:", Integer.valueOf(intValue));
                        }
                        z16 = true;
                    }
                }
            }
        }
    }

    private void J(com.tencent.mobileqq.banner.a aVar, Message message) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.recent.banner", 4, "updateBanner| banner = ", aVar, ", msg = ", message);
        }
        if (aVar != null && aVar.f200243c != null && getActivity() != null) {
            TextHook.updateFont(aVar.f200243c);
            com.tencent.mobileqq.banner.processor.e eVar = this.f200221h.get(Integer.valueOf(aVar.f200241a));
            if (eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "updateBanner: key=", Integer.valueOf(aVar.f200241a), ", processor=null");
                }
            } else {
                QLog.d("Q.recent.banner", 2, "initBanner| updateBanner", message);
                eVar.updateBanner(aVar, message);
                View view = aVar.f200243c;
                if (view instanceof TipsBar) {
                    L((TipsBar) view);
                }
            }
        }
    }

    private void L(TipsBar tipsBar) {
        if (this.f200217d) {
            if (QQTheme.isThemeSimpleUI(QQTheme.getCurrentThemeId())) {
                tipsBar.setBarType(4);
            } else {
                tipsBar.setBarType(3);
            }
        } else if (tipsBar.i() == 3 || tipsBar.i() == 4) {
            tipsBar.setBarType(1);
        }
        tipsBar.B();
        tipsBar.A();
    }

    private void M() {
        for (int i3 = 0; i3 < 7; i3++) {
            ArrayList<Integer> arrayList = this.f200219f.get(i3);
            if (arrayList != null) {
                this.f200218e.put(i3, new ArrayList<>(arrayList));
            }
        }
    }

    private void P() {
        if (this.f200219f == null) {
            this.f200219f = new SparseArray<>(7);
        }
        for (int i3 = 0; i3 < 7; i3++) {
            ArrayList<Integer> arrayList = this.f200219f.get(i3);
            if (arrayList == null) {
                this.f200219f.put(i3, new ArrayList<>(1));
            } else {
                arrayList.clear();
            }
        }
        for (int i16 = f200202o; i16 < f200203p; i16++) {
            com.tencent.mobileqq.banner.a aVar = this.f200216c[i16];
            if (aVar != null && aVar.a()) {
                this.f200219f.get(0).add(Integer.valueOf(i16));
            }
        }
        for (int i17 = f200204q; i17 < f200205r; i17++) {
            com.tencent.mobileqq.banner.a aVar2 = this.f200216c[i17];
            if (aVar2 != null && aVar2.a()) {
                this.f200219f.get(1).add(Integer.valueOf(i17));
            }
        }
        for (int i18 = f200206s; i18 < f200207t; i18++) {
            com.tencent.mobileqq.banner.a aVar3 = this.f200216c[i18];
            if (aVar3 != null && aVar3.a()) {
                this.f200219f.get(2).add(Integer.valueOf(i18));
            }
        }
        for (int i19 = f200208u; i19 < f200209v; i19++) {
            com.tencent.mobileqq.banner.a aVar4 = this.f200216c[i19];
            if (aVar4 != null && aVar4.a()) {
                this.f200219f.get(3).add(Integer.valueOf(i19));
            }
        }
        for (int i26 = f200210w; i26 < f200211x; i26++) {
            com.tencent.mobileqq.banner.a aVar5 = this.f200216c[i26];
            if (aVar5 != null && aVar5.a()) {
                this.f200219f.get(4).add(Integer.valueOf(i26));
            }
        }
        for (int i27 = f200212y; i27 < f200213z; i27++) {
            com.tencent.mobileqq.banner.a aVar6 = this.f200216c[i27];
            if (aVar6 != null && aVar6.a()) {
                this.f200219f.get(5).add(Integer.valueOf(i27));
            }
        }
        for (int i28 = A; i28 < B; i28++) {
            com.tencent.mobileqq.banner.a aVar7 = this.f200216c[i28];
            if (aVar7 != null && aVar7.a()) {
                this.f200219f.get(6).add(Integer.valueOf(i28));
            }
        }
    }

    private boolean a(com.tencent.mobileqq.banner.a aVar, boolean z16, Message message) {
        a aVar2;
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 1, "[banner] addBannerViewToMsgTabHeader: invoked. ", " refreshMsg: ", message);
        }
        if (aVar == null || (aVar2 = this.f200215b.get()) == null) {
            return false;
        }
        try {
            j(aVar);
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.recent.banner", 2, "initBanner|", e16.toString());
            }
        }
        if (!c(aVar)) {
            QLog.d("Q.recent.banner", 1, "[banner] addBannerViewToMsgTabHeader not valid. bannerId=" + aVar.f200241a);
            return false;
        }
        if (aVar.f200243c != null && !aVar.f200244d && !z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "fight.addHeaderView_3.");
            }
            Iterator<com.tencent.mobileqq.banner.processor.c> it = this.f200222i.iterator();
            while (it.hasNext()) {
                it.next().d(aVar);
            }
            aVar2.a(aVar, 1);
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime != null) {
                s(waitAppRuntime, aVar.f200241a);
            }
            aVar.f200244d = true;
        }
        QLog.d("Q.recent.banner", 2, "initBanner| updateBanner", message);
        J(aVar, message);
        return true;
    }

    private boolean c(com.tencent.mobileqq.banner.a aVar) {
        if (this.f200220g.contains(Integer.valueOf(aVar.f200241a))) {
            return true;
        }
        return QUINoticeBarManager.l().m(aVar.f200243c);
    }

    private void d() {
        AppRuntime appRuntime;
        for (int i3 = 0; i3 < 7; i3++) {
            ArrayList<Integer> arrayList = this.f200218e.get(i3);
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.banner.a aVar = this.f200216c[it.next().intValue()];
                    if (aVar != null && aVar.f200243c != null && aVar.f200244d) {
                        a aVar2 = this.f200215b.get();
                        if (aVar2 != null) {
                            aVar2.b(aVar);
                        }
                        QBaseActivity qBaseActivity = this.f200214a.get();
                        if (qBaseActivity != null) {
                            appRuntime = qBaseActivity.getAppRuntime();
                        } else {
                            appRuntime = null;
                        }
                        if (appRuntime != null) {
                            r(appRuntime, aVar.f200241a);
                        }
                        aVar.f200244d = false;
                        if (!aVar.a()) {
                            aVar.f200243c = null;
                        }
                    }
                }
            }
        }
    }

    @Nullable
    private com.tencent.mobileqq.banner.processor.e e(Class<? extends com.tencent.mobileqq.banner.processor.e> cls) {
        try {
            com.tencent.mobileqq.banner.processor.e newInstance = cls.getDeclaredConstructor(QBaseActivity.class).newInstance(this.f200214a.get());
            newInstance.onCreate(this);
            return newInstance;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
            QLog.w("Q.recent.banner", 1, "handleProcessorClzz: processor=null, exception:", e16);
            return null;
        }
    }

    private boolean h(Class<? extends com.tencent.mobileqq.banner.processor.e> cls) {
        if (cls == null) {
            QLog.d("Q.recent.banner", 1, "handleProcessorClz: processorClz == null");
            return false;
        }
        com.tencent.mobileqq.banner.processor.e e16 = e(cls);
        if (e16 == null) {
            return false;
        }
        this.f200221h.put(Integer.valueOf(e16.getId()), e16);
        if (e16 instanceof f) {
            this.f200225l.add((f) e16);
        }
        if (e16 instanceof com.tencent.mobileqq.banner.processor.b) {
            this.f200224k.add((com.tencent.mobileqq.banner.processor.b) e16);
        }
        if (e16 instanceof com.tencent.mobileqq.banner.processor.c) {
            this.f200222i.add((com.tencent.mobileqq.banner.processor.c) e16);
        }
        if (e16 instanceof com.tencent.mobileqq.banner.processor.d) {
            this.f200223j.add((com.tencent.mobileqq.banner.processor.d) e16);
        }
        return true;
    }

    private void i() {
        this.f200221h.clear();
        this.f200225l.clear();
        this.f200224k.clear();
        this.f200222i.clear();
        this.f200223j.clear();
        f200202o = 1;
        f200203p = 1;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it = D.iterator();
        while (it.hasNext()) {
            if (h(it.next())) {
                f200203p++;
            }
        }
        int i3 = f200203p;
        f200204q = i3;
        f200205r = i3;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it5 = E.iterator();
        while (it5.hasNext()) {
            if (h(it5.next())) {
                f200205r++;
            }
        }
        int i16 = f200205r;
        f200206s = i16;
        f200207t = i16;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it6 = F.iterator();
        while (it6.hasNext()) {
            if (h(it6.next())) {
                f200207t++;
            }
        }
        int i17 = f200207t;
        f200208u = i17;
        f200209v = i17;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it7 = G.iterator();
        while (it7.hasNext()) {
            if (h(it7.next())) {
                f200209v++;
            }
        }
        int i18 = f200209v;
        f200210w = i18;
        f200211x = i18;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it8 = H.iterator();
        while (it8.hasNext()) {
            if (h(it8.next())) {
                f200211x++;
            }
        }
        int i19 = f200211x;
        f200212y = i19;
        f200213z = i19;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it9 = I.iterator();
        while (it9.hasNext()) {
            if (h(it9.next())) {
                f200213z++;
            }
        }
        int i26 = f200213z;
        A = i26;
        B = i26;
        Iterator<Class<? extends com.tencent.mobileqq.banner.processor.e>> it10 = J.iterator();
        while (it10.hasNext()) {
            if (h(it10.next())) {
                B++;
            }
        }
        C = B;
        for (int i27 : d.W) {
            this.f200220g.add(Integer.valueOf(i27));
        }
    }

    private void j(com.tencent.mobileqq.banner.a aVar) {
        if (aVar != null && aVar.f200243c == null && getActivity() != null) {
            com.tencent.mobileqq.banner.processor.e eVar = this.f200221h.get(Integer.valueOf(aVar.f200241a));
            if (eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "initBannerView: key=", Integer.valueOf(aVar.f200241a), ", processor=null");
                    return;
                }
                return;
            }
            aVar.f200243c = eVar.initBanner(aVar);
            if (QUINoticeBarManager.l().m(aVar.f200243c)) {
                com.tencent.biz.qui.noticebar.b<?> c16 = QUINoticeBarManager.l().c(aVar.f200243c);
                if (c16 != null && c16.j() != 1 && eVar.getId() != d.f200262o && eVar.getId() != d.f200263p) {
                    c16.g(true);
                }
                if (c16 != null) {
                    c16.a(70.5f, 4.7f);
                }
            } else {
                View view = aVar.f200243c;
                if (view instanceof TipsBar) {
                    k((TipsBar) view, eVar.defaultTipsBarType());
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.recent.banner", 2, "initBannerView | banner = ", aVar);
            }
        }
    }

    private void k(TipsBar tipsBar, int i3) {
        String currentThemeId = QQTheme.getCurrentThemeId();
        if (this.f200217d) {
            if (QQTheme.isThemeSimpleUI(currentThemeId)) {
                tipsBar.setBarType(4);
                return;
            } else {
                tipsBar.setBarType(3);
                return;
            }
        }
        tipsBar.setBarType(i3);
    }

    public static BannerManager l() {
        if (f200200m == null) {
            synchronized (BannerManager.class) {
                if (f200200m == null) {
                    f200200m = new BannerManager();
                }
            }
        }
        return f200200m;
    }

    private boolean m() {
        for (int i3 = 0; i3 < 7; i3++) {
            if (!this.f200219f.get(i3).equals(this.f200218e.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean q() {
        for (int i3 = 0; i3 < 7; i3++) {
            if (!this.f200219f.get(i3).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void t(int i3, int i16) {
        AppRuntime appRuntime;
        QBaseActivity qBaseActivity = this.f200214a.get();
        if (qBaseActivity != null) {
            appRuntime = qBaseActivity.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (i16 == 2) {
            if (appRuntime != null) {
                s(appRuntime, i3);
            }
        } else if (i16 == 0 && appRuntime != null) {
            r(appRuntime, i3);
        }
    }

    public void A(int i3, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) message);
            return;
        }
        if (!f200201n) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "refreshBanner !sInit");
                return;
            }
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "refreshBanner: Looper.myLooper() != Looper.getMainLooper()", Integer.valueOf(i3));
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, message) { // from class: com.tencent.mobileqq.banner.BannerManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f200226d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Message f200227e;

                {
                    this.f200226d = i3;
                    this.f200227e = message;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BannerManager.this, Integer.valueOf(i3), message);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Message obtain;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BannerManager bannerManager = BannerManager.this;
                    int i16 = this.f200226d;
                    Message message2 = this.f200227e;
                    if (message2 == null) {
                        obtain = null;
                    } else {
                        obtain = Message.obtain(message2);
                    }
                    bannerManager.A(i16, obtain);
                }
            });
            return;
        }
        P();
        boolean m3 = m();
        boolean q16 = q();
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "[refresh] refreshBanner: invoked. ", " isToShowBannersEmpty: ", Boolean.valueOf(q16), " isBannersEqual: ", Boolean.valueOf(m3));
        }
        if (m3 && q16) {
            return;
        }
        if (q16) {
            d();
            return;
        }
        if (!m3) {
            d();
            M();
        }
        QLog.d("Q.recent.banner", 2, "refreshBanner: showAllBanner enter", Integer.valueOf(i3), message);
        C(i3, message);
    }

    public void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f200217d = z16;
        }
    }

    public void D(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i16;
        G(i3, obtain);
    }

    public void E(int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i16;
        H(i3, obtain, j3);
    }

    public void F(int i3, int i16, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i16;
        I(i3, obtain, j3, z16);
    }

    public void G(int i3, @NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) message);
        } else {
            H(i3, message, 0L);
        }
    }

    public void H(int i3, @NonNull Message message, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), message, Long.valueOf(j3));
        } else {
            I(i3, message, j3, false);
        }
    }

    public void I(int i3, @NonNull Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), message, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (!f200201n) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "transitMessage !sInit");
                return;
            }
            return;
        }
        com.tencent.mobileqq.banner.processor.e eVar = this.f200221h.get(Integer.valueOf(i3));
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "transitMessage: processor=null");
                return;
            }
            return;
        }
        eVar.onMessage(message, j3, z16);
    }

    public void K(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!f200201n) {
            return;
        }
        if (QLog.isColorLevel()) {
            String valueOf = String.valueOf(i3);
            com.tencent.mobileqq.banner.processor.e eVar = this.f200221h.get(Integer.valueOf(i3));
            if (eVar != null) {
                valueOf = eVar.getClass().getSimpleName();
            }
            QLog.d("Q.recent.banner", 2, "updateBannerState|[", valueOf, ",", Integer.valueOf(i16), "]");
        }
        if (i3 >= 1 && i3 < C) {
            com.tencent.mobileqq.banner.a aVar = this.f200216c[i3];
            if (aVar != null) {
                aVar.f200242b = i16;
            } else if (aVar == null && com.tencent.mobileqq.banner.a.b(i16)) {
                this.f200216c[i3] = new com.tencent.mobileqq.banner.a(i3, i16);
            }
            Iterator<com.tencent.mobileqq.banner.processor.d> it = this.f200223j.iterator();
            while (it.hasNext()) {
                it.next().b(i3, i16);
            }
        }
        t(i3, i16);
    }

    public void N(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            if (!f200201n) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i17;
            O(i3, i16, obtain);
        }
    }

    public void O(int i3, int i16, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), message);
            return;
        }
        if (!f200201n) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "updateStateAndRefreshBanner !sInit");
            }
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "updateStateAndRefreshBanner: Looper.myLooper() != Looper.getMainLooper()", Integer.valueOf(i3));
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(message, i3, i16) { // from class: com.tencent.mobileqq.banner.BannerManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Message f200228d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f200229e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f200230f;

                {
                    this.f200228d = message;
                    this.f200229e = i3;
                    this.f200230f = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BannerManager.this, message, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Message obtain;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Message message2 = this.f200228d;
                    if (message2 == null) {
                        obtain = null;
                    } else {
                        obtain = Message.obtain(message2);
                    }
                    BannerManager.this.K(this.f200229e, this.f200230f);
                    BannerManager.this.A(this.f200229e, obtain);
                }
            });
        } else {
            K(i3, i16);
            A(i3, message);
        }
    }

    public synchronized void b(QBaseActivity qBaseActivity, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "bind, QBaseActivity:", qBaseActivity);
        }
        this.f200214a = new WeakReference<>(qBaseActivity);
        this.f200215b = new WeakReference<>(aVar);
        i();
        this.f200216c = new com.tencent.mobileqq.banner.a[C];
        f200201n = true;
    }

    @android.support.annotation.Nullable
    public com.tencent.mobileqq.banner.a f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.banner.a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (!f200201n) {
            return null;
        }
        return this.f200216c[i3];
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g(int i3) {
        com.tencent.mobileqq.banner.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        if (!f200201n) {
            return 0;
        }
        if (i3 >= 0) {
            com.tencent.mobileqq.banner.a[] aVarArr = this.f200216c;
            if (i3 < aVarArr.length) {
                aVar = aVarArr[i3];
                if (aVar != null) {
                    return 0;
                }
                return aVar.f200242b;
            }
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.a
    public QBaseActivity getActivity() {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        WeakReference<QBaseActivity> weakReference = this.f200214a;
        if (weakReference != null && weakReference.get() != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        return QBaseActivity.sTopActivity;
    }

    public boolean n(int i3) {
        com.tencent.mobileqq.banner.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        if (!f200201n) {
            return false;
        }
        if (i3 >= 0) {
            com.tencent.mobileqq.banner.a[] aVarArr = this.f200216c;
            if (i3 < aVarArr.length) {
                aVar = aVarArr[i3];
                if (aVar == null && aVar.a()) {
                    return true;
                }
            }
        }
        aVar = null;
        return aVar == null ? false : false;
    }

    public boolean o(int i3) {
        com.tencent.mobileqq.banner.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        if (!f200201n) {
            return false;
        }
        if (i3 >= 0) {
            com.tencent.mobileqq.banner.a[] aVarArr = this.f200216c;
            if (i3 < aVarArr.length) {
                aVar = aVarArr[i3];
                if (aVar == null && aVar.f200244d) {
                    return true;
                }
            }
        }
        aVar = null;
        return aVar == null ? false : false;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return f200201n;
    }

    public void r(@NonNull AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) appRuntime, i3);
        } else {
            ((IBannerListenerService) appRuntime.getRuntimeService(IBannerListenerService.class, "")).notifyBannerDismiss(i3);
        }
    }

    public void s(@NonNull AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) appRuntime, i3);
        } else {
            ((IBannerListenerService) appRuntime.getRuntimeService(IBannerListenerService.class, "")).notifyBannerShow(i3);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        a aVar = this.f200215b.get();
        if (aVar != null) {
            aVar.c();
        }
        if (getActivity() == null) {
            QLog.d("Q.recent.banner", 2, "onAccountChanged: activity is null");
            return;
        }
        Iterator<Integer> it = this.f200221h.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            com.tencent.mobileqq.banner.processor.e eVar = this.f200221h.get(Integer.valueOf(intValue));
            if (eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "onAccountChanged: key=", Integer.valueOf(intValue), ", processor=null");
                    return;
                }
                return;
            }
            eVar.onAccountChanged();
        }
    }

    public void v(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) appRuntime);
            return;
        }
        Iterator<Integer> it = this.f200221h.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            com.tencent.mobileqq.banner.processor.e eVar = this.f200221h.get(Integer.valueOf(intValue));
            if (eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "onBeforeAccountChanged: key=", Integer.valueOf(intValue), ", processor=null");
                    return;
                }
                return;
            }
            eVar.onBeforeAccountChanged(appRuntime);
        }
    }

    public void w(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) appRuntime);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            }
            Iterator<com.tencent.mobileqq.banner.processor.b> it = this.f200224k.iterator();
            while (it.hasNext()) {
                it.next().c(appRuntime);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY, e16);
            }
        }
        this.f200221h.clear();
        this.f200225l.clear();
        this.f200224k.clear();
        this.f200222i.clear();
        this.f200223j.clear();
        this.f200216c = null;
        f200201n = false;
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        Iterator<com.tencent.mobileqq.banner.processor.b> it = this.f200224k.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 1, "onResume");
        }
        Iterator<com.tencent.mobileqq.banner.processor.b> it = this.f200224k.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
            return;
        }
        Iterator<f> it = this.f200225l.iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }
}
