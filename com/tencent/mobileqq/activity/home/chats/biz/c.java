package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.biz.tianshu.TianShuConversationThirdView;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.ad.TianshuNewAdManager;
import cooperation.vip.ad.TianshuSplashManager;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends d {
    static IPatchRedirector $redirector_;
    private static boolean H;
    private TianshuSplashManager C;
    private TianshuNewAdManager D;
    private cooperation.ad.c E;
    private boolean F;
    private final a G;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static final class a extends ez2.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // ez2.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onProcessForeground();
                c.H = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            H = true;
        }
    }

    public c(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.F = false;
        this.G = new a();
        H = true;
        this.D = new TianshuNewAdManager();
    }

    private void Aa(int i3, String str, boolean z16) {
        MqqHandler ca5 = ca();
        if (ca5 == null) {
            QLog.e("ADPart", 1, "sendTianShuSplashRequestMsg  handler == null");
            return;
        }
        if (z16) {
            ca5.removeMessages(9003);
        }
        Message obtain = Message.obtain();
        obtain.what = 9003;
        obtain.obj = str;
        ca5.sendMessageDelayed(obtain, i3);
    }

    private void Ba(final int i3) {
        TianShuConversationThirdView ra5 = ra();
        if (ra5 == null) {
            QLog.e("ADPart", 1, "sendTianshuAdRequest thirdView == null");
        }
        if (this.D == null) {
            this.D = new TianshuNewAdManager();
        }
        this.D.x(Z9().isCardContainerVisible());
        this.D.w(getActivity());
        this.D.y(ra5);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.ua(i3);
            }
        });
    }

    private void Ca(String str) {
        if (cooperation.vip.ad.i.k()) {
            QLog.d("ADPart", 1, "sendTianshuSplashRequest fail, use new plan");
            return;
        }
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) X9;
        if (this.C == null) {
            this.C = new TianshuSplashManager(qQAppInterface);
        }
        this.C.p(str);
    }

    private void qa() {
        TianshuSplashManager tianshuSplashManager = this.C;
        if (tianshuSplashManager != null) {
            tianshuSplashManager.m();
            this.C = null;
        }
        TianshuNewAdManager tianshuNewAdManager = this.D;
        if (tianshuNewAdManager != null) {
            tianshuNewAdManager.onDestroy();
            this.D = null;
        }
        cooperation.ad.c cVar = this.E;
        if (cVar != null) {
            cVar.m();
            this.E = null;
        }
    }

    private TianShuConversationThirdView ra() {
        if (getPartRootView() == null) {
            QLog.e("ADPart", 1, "initTianShuThirdView  getRootView() == null");
            return null;
        }
        View findViewById = getPartRootView().findViewById(R.id.f97175jo);
        QLog.d("ADPart", 1, "initTianShuThirdView  view = " + findViewById);
        if (!(findViewById instanceof TianShuConversationThirdView)) {
            return null;
        }
        return (TianShuConversationThirdView) findViewById;
    }

    private void sa(Message message) {
        BannerManager.l().O(BeginnerGuideBannerProcessor.f185201d, 2, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ta() {
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestPublicAccountAd(5, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ua(int i3) {
        TianshuNewAdManager tianshuNewAdManager = this.D;
        if (tianshuNewAdManager != null) {
            tianshuNewAdManager.v(i3);
        }
    }

    private void xa(int i3, String str) {
        MqqHandler ca5 = ca();
        if (ca5 == null) {
            QLog.e("ADPart", 1, "sendOlympicAdBannerRequest  handler == null");
            return;
        }
        ca5.removeMessages(9006);
        Message obtain = Message.obtain();
        obtain.what = 9006;
        obtain.obj = str;
        ca5.sendMessageDelayed(obtain, i3);
    }

    private void za() {
        if (this.E == null) {
            this.E = new cooperation.ad.c(Z9());
        }
        this.E.n();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void B9(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        Aa(500, "tianshu_req_splash_type_after_sync", true);
        Ba(1);
        xa((int) ((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getRequestTabAdBannerDelay(), "ams_req_renewals_type_after_sync");
    }

    public void Da(int i3, long j3, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), str);
            return;
        }
        QLog.i("ADPart", 1, "sendVasBannerMsg[what:" + i3 + ",delay:" + j3 + ",refreshType:" + str);
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.obj = str;
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.I(VasADBannerProcessor.f185279h, obtain, j3, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Aa(500, "tianshu_req_splash_type_pull_down", true);
        Ba(2);
        xa(500, "ams_req_renewals_type_pull_down");
        TianshuNewAdManager tianshuNewAdManager = this.D;
        if (tianshuNewAdManager != null) {
            tianshuNewAdManager.j();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ADPart";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 9003) {
            if (i3 != 9006) {
                if (i3 == 1134210) {
                    sa(message);
                    return false;
                }
                return false;
            }
            za();
            return false;
        }
        Ca((String) message.obj);
        return false;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) X9;
        BannerManager Y9 = Y9();
        TianshuSplashManager tianshuSplashManager = this.C;
        if (tianshuSplashManager != null) {
            tianshuSplashManager.l(qQAppInterface);
        }
        if (Y9 != null) {
            Da(3001, 0L, true, null);
        }
        TianShuManager.getInstance().clearNecessaryDataCacheForReport();
        TianShuManager.setLastClickAdTraceInfo("", "");
        TianshuNewAdManager tianshuNewAdManager = this.D;
        if (tianshuNewAdManager != null) {
            tianshuNewAdManager.s(qQAppInterface);
        }
        Ba(1);
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) logoutReason);
        } else {
            TianShuManager.getInstance().clearNecessaryDataCacheForReport();
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        super.onPartCreate(activity, bundle);
        if (!this.F && ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).isReqSceneTypePageSwitchOn()) {
            this.F = true;
            Foreground.addActivityLifeCallback(this.G);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        qa();
        if (this.F) {
            this.F = false;
            Foreground.removeActivityLifeCallback(this.G);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }

    public void pa(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this._binding.f().getLayoutParams();
        if (z16) {
            i3 = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cje);
        } else {
            i3 = 0;
        }
        marginLayoutParams.topMargin = i3;
        this._binding.f().setLayoutParams(marginLayoutParams);
    }

    public void va(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (this.F && !z16 && z17 && !H) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.ta();
                }
            }, 128, null, false);
        }
        H = false;
    }

    public void wa(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (z16) {
            Aa(500, "tianshu_req_splash_type_net_change", true);
            Ba(3);
            xa((int) ((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getRequestTabAdBannerDelay(), "ams_req_renewals_type_net_change");
            TianShuManager.setLastClickAdTraceInfo("", "");
        }
    }
}
