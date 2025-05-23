package com.tencent.mobileqq.springhb.prize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.SpringGiftView;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.GameCenterConfigData;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements View.OnClickListener, WadlProxyServiceCallBackInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static com.tencent.biz.common.offline.a f289581m;

    /* renamed from: d, reason: collision with root package name */
    private long f289582d;

    /* renamed from: e, reason: collision with root package name */
    private e f289583e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f289584f;

    /* renamed from: h, reason: collision with root package name */
    private int f289585h;

    /* renamed from: i, reason: collision with root package name */
    private WadlParams f289586i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpringHb_GameLaunchHelper", 1, "[loaded], code:" + i3 + ",param:" + str);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75365);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f289581m = new a();
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289582d = 0L;
        this.f289585h = 0;
        QLog.i("SpringHb_GameLaunchHelper", 1, "[GameLaunchHelper]");
        this.f289583e = new e();
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
    }

    private void c() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f289583e.f289566a);
        WadlProxyServiceUtil.getProxyService().doQueryAction(arrayList);
    }

    private static String d(String str) {
        if (h() != null && !TextUtils.isEmpty(str)) {
            String h16 = SpringGiftView.h(com.tencent.mobileqq.springhb.preload.s.b(str));
            if (com.tencent.mobileqq.filemanager.util.q.p(h16)) {
                return h16;
            }
        }
        return "";
    }

    public static String e() {
        GameCenterConfigData h16 = h();
        if (h16 == null) {
            QLog.i("SpringHb_GameLaunchHelper", 1, "[getAppId], use local url, gameConfigData is null.");
            return "";
        }
        return h16.appId;
    }

    public static URLDrawable f(String str, String str2, ApngOptions apngOptions) {
        URLDrawable apngURLDrawable;
        if (TextUtils.isEmpty(str)) {
            URLDrawable apngURLDrawable2 = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, SpringGiftView.h(com.tencent.mobileqq.springhb.preload.s.a(str2)));
            if (QLog.isColorLevel()) {
                QLog.d("SpringHb_GameLaunchHelper", 2, "[getBtnDrawable1111], url is null.");
            }
            return apngURLDrawable2;
        }
        String d16 = d(str);
        if (TextUtils.isEmpty(d16)) {
            apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(str, apngOptions, SpringGiftView.h(com.tencent.mobileqq.springhb.preload.s.a(str2)));
            if (QLog.isColorLevel()) {
                QLog.d("SpringHb_GameLaunchHelper", 2, "[getBtnDrawable222], res not downloaded.");
            }
        } else {
            apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, d16);
            if (QLog.isColorLevel()) {
                QLog.d("SpringHb_GameLaunchHelper", 2, "[getBtnDrawable333],  res is downloaded.");
            }
        }
        return apngURLDrawable;
    }

    public static GameCenterConfigData h() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            QLog.w("SpringHb_GameLaunchHelper", 1, "[getGameCenterConfigData], fail to open page, not is QQAppInterface");
            return null;
        }
        SpringFestivalEntryManager springFestivalEntryManager = (SpringFestivalEntryManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (springFestivalEntryManager == null) {
            return null;
        }
        BaseActivityData A = springFestivalEntryManager.A(springFestivalEntryManager.I());
        if (A == null) {
            QLog.w("SpringHb_GameLaunchHelper", 1, "curActivityData or gameCenterConfigData is null.");
            return null;
        }
        return A.gameCenterConfigData;
    }

    public static void i(String str) {
        GameCenterConfigData h16 = h();
        if (h16 == null) {
            QLog.i("SpringHb_GameLaunchHelper", 1, "[goHomePage], use local url, gameConfigData is null.");
            return;
        }
        String str2 = h16.defaultUrl;
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                str = h16.appId;
            }
            str2 = "mqqapi://hippy/open?src_type%3Dweb%26version%3D1%26bundleName%3DQQGameCenterV2%26url%3Dhttps%253A%252F%252Fplay.qq.com%252Fhippy-ssr%252Fv1%252Fapp%252Fgame-detail%253Fp_collections%253D%252526appid%25253DAPPID%252526_cache%25253Dappid%252526adtag%25253Dsys%252526autodownload%25253D1%252526autolaunch%25253D1%26isAnimated%3Dtrue%26isStatusBarDarkFont%3Dtrue%26".replace("APPID", str);
            QLog.i("SpringHb_GameLaunchHelper", 1, "use local url, gameAppId:" + str);
        }
        com.tencent.mobileqq.springhb.x.l(str2);
    }

    private boolean j() {
        if (System.currentTimeMillis() - this.f289582d >= 500) {
            this.f289582d = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i3) {
        try {
            this.f289585h = i3;
            String str = "";
            int dimensionPixelSize = this.f289584f.getResources().getDimensionPixelSize(R.dimen.dd5);
            int dimensionPixelSize2 = this.f289584f.getResources().getDimensionPixelSize(R.dimen.f159568dd4);
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setUseCache(false);
            apngOptions.setRequestWidth(dimensionPixelSize);
            apngOptions.setRequestHeight(dimensionPixelSize2);
            GameCenterConfigData h16 = h();
            int i16 = this.f289585h;
            if (i16 == 0) {
                if (TextUtils.isEmpty(this.f289583e.f289570e)) {
                    this.f289585h = 3;
                    if (h16 != null) {
                        str = h16.goHomePageResUrl;
                    }
                    this.f289584f.setImageDrawable(f(str, "spring_2024_prize_go_game_home_page.apng", apngOptions));
                } else {
                    if (h16 != null) {
                        str = h16.startCloudGameResUrl;
                    }
                    this.f289584f.setImageDrawable(f(str, "spring_2024_prize_launch_cloud_game_and_download.apng", apngOptions));
                }
            } else if (i16 == 1) {
                if (h16 != null) {
                    str = h16.installApkResUrl;
                }
                this.f289584f.setImageDrawable(f(str, "spring_2024_prize_cash_install.apng", apngOptions));
            } else if (i16 == 2) {
                if (h16 != null) {
                    str = h16.startLocalResUrl;
                }
                this.f289584f.setImageDrawable(f(str, "spring_2024_prize_cash_launch_local_game.apng", apngOptions));
            } else if (i16 == 3) {
                if (h16 != null) {
                    str = h16.goHomePageResUrl;
                }
                this.f289584f.setImageDrawable(f(str, "spring_2024_prize_go_game_home_page.apng", apngOptions));
            }
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_GameLaunchHelper", 1, "+++++++++url++++++++++++++:" + str);
            }
        } catch (Throwable th5) {
            QLog.e("SpringHb_GameLaunchHelper", 1, "[setBtnBackground], th:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(ArrayList arrayList) {
        try {
            HtmlOffline.C(arrayList, MobileQQ.sMobileQQ.peekAppRuntime(), f289581m, true, true);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                QLog.i("SpringHb_GameLaunchHelper", 1, "bid:" + str + ",version:" + HtmlOffline.z(str));
            }
        } catch (Throwable th5) {
            QLog.e("SpringHb_GameLaunchHelper", 1, "[updateOfflineRes], th" + th5);
        }
    }

    private void o(final int i3) {
        QLog.i("SpringHb_GameLaunchHelper", 1, "[setBtnBackground], status:" + i3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.prize.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.k(i3);
            }
        });
    }

    private void r() {
        com.tencent.mobileqq.springhb.x.l(this.f289583e.f289570e);
    }

    private void s() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        String str = this.f289583e.f289576k;
        if (!TextUtils.isEmpty(str) && qQAppInterface != null) {
            String str2 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_ym_activity&gamedata=&platformdata=";
            if (!str.startsWith(ContainerUtils.FIELD_DELIMITER)) {
                str2 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_ym_activity&gamedata=&platformdata=" + ContainerUtils.FIELD_DELIMITER;
            }
            String str3 = str2 + str;
            eq2.a aVar = new eq2.a();
            Context context = this.f289584f.getContext();
            e eVar = this.f289583e;
            aVar.d(qQAppInterface, context, eVar.f289566a, str3, eVar.f289568c, 536870912);
        }
    }

    private void t() {
        if (TextUtils.isEmpty(this.f289583e.f289568c)) {
            QLog.i("SpringHb_GameLaunchHelper", 1, "[updateBtnStatus], package name is null.");
            o(3);
            return;
        }
        int appVersionCode = GameCenterUtil.getAppVersionCode(this.f289583e.f289568c);
        QLog.i("SpringHb_GameLaunchHelper", 1, " versionCode:" + appVersionCode);
        if (appVersionCode != -1) {
            o(2);
        } else {
            c();
        }
    }

    public static void u(ArrayList<String> arrayList) {
        QLog.i("SpringHb_GameLaunchHelper", 1, "[updateJsBundle]");
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                QLog.i("SpringHb_GameLaunchHelper", 1, "bundleName:" + next);
                ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(next, "ym_activity", null);
            }
        }
    }

    public static void v(final ArrayList<String> arrayList) {
        QLog.i("SpringHb_GameLaunchHelper", 1, "[updateOfflineRes], bidList:" + arrayList);
        if (arrayList != null && arrayList.size() != 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.prize.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.l(arrayList);
                }
            }, 128, null, true);
        }
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int i3 = this.f289585h;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "";
                    }
                    return "5";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("SpringHb_GameLaunchHelper", 1, "[onDestroy]");
        this.f289584f = null;
        this.f289583e = null;
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("SpringHb_GameLaunchHelper", 1, "[onResume]");
        if (this.f289584f != null && this.f289583e != null) {
            t();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (j()) {
            int i3 = this.f289585h;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            i(this.f289583e.f289566a);
                        }
                    } else {
                        s();
                    }
                } else {
                    WadlProxyServiceUtil.getProxyService().doInstallAction(this.f289586i);
                }
            } else {
                r();
            }
            ad.b(g());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
            return;
        }
        QLog.i("SpringHb_GameLaunchHelper", 1, "[onQueryCallback]");
        if (arrayList != null && arrayList.size() != 0) {
            try {
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    WadlResult next = it.next();
                    if (next != null && this.f289583e.f289568c.equals(next.wadlParams.packageName)) {
                        if (next.taskStatus == 6) {
                            o(1);
                        } else {
                            o(0);
                        }
                        this.f289586i = next.wadlParams;
                        return;
                    }
                }
                o(0);
                return;
            } catch (Throwable th5) {
                QLog.e("SpringHb_GameLaunchHelper", 1, "[onQueryCallback], th" + th5);
                return;
            }
        }
        QLog.w("SpringHb_GameLaunchHelper", 1, "no result.");
        o(0);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) arrayList);
        } else {
            QLog.i("SpringHb_GameLaunchHelper", 1, "[onQueryCallbackVia]");
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) wadlResult);
        }
    }

    public void p(ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) imageView);
            return;
        }
        this.f289584f = imageView;
        imageView.setOnClickListener(this);
        t();
    }

    public void q(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar);
        } else {
            this.f289583e = eVar;
        }
    }
}
