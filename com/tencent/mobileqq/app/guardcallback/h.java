package com.tencent.mobileqq.app.guardcallback;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.j;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static h f195670c;

    /* renamed from: a, reason: collision with root package name */
    private long f195671a;

    /* renamed from: b, reason: collision with root package name */
    private long f195672b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70244);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f195670c = new h();
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195671a = 1800000L;
            this.f195672b = 0L;
        }
    }

    private void b() {
        if (!e()) {
            return;
        }
        if (!GuildInjectImpl.L()) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "checkAndJump GuildInjectImpl.isGuildTabShow : false");
            return;
        }
        if (!RecentUtil.f185179d) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "checkAndJump RecentUtil.isInMainTab : false");
            return;
        }
        FrameFragment.d d16 = d();
        if (d16 == null) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "checkAndJump null == tabIndicator");
            return;
        }
        String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
        if (!j.c(d16.getContext(), currentUin)) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "checkAndJump isSwitchToGuild : false");
        } else if (SystemClock.elapsedRealtime() - this.f195672b < this.f195671a) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "checkAndJump step < MINUTE_30");
        } else {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "jumpToGuildSafe");
            g(d16, currentUin);
        }
    }

    public static h c() {
        return f195670c;
    }

    private FrameFragment.d d() {
        if (SplashActivity.sWeakInstance == null) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "getQQTabHost SplashActivity.sWeakInstance==null");
            return null;
        }
        SplashActivity splashActivity = SplashActivity.sWeakInstance.get();
        if (splashActivity == null) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "getQQTabHost activity==null");
            return null;
        }
        MainFragment mainFragment = (MainFragment) splashActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (mainFragment == null) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "getQQTabHost mf==null");
            return null;
        }
        if (mainFragment.R) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "getQQTabHost misDrawerOpened == true,  \u4e0d\u8981\u5207\u6362");
            return null;
        }
        return mainFragment.mTabIndicator;
    }

    public static boolean e() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ground_toggle_guild_9015", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void h(FrameFragment.d dVar) {
        try {
            com.tencent.mobileqq.guild.report.b.g("default", "GuardManager.TabProcessor");
            ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).startGuildTabInitTask(1);
            dVar.setCurrentTabByTag(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName());
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("GuardManager.TabProcessor", 1, "jumpToGuild", e16);
        }
    }

    private void g(final FrameFragment.d dVar, String str) {
        if (TabDataHelper.getGroundToggleGuildInit(dVar.getContext(), str)) {
            com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "jumpToGuildSafe already jump to guild, skip");
            return;
        }
        TabDataHelper.putGroundToggleGuildInit(dVar.getContext(), str, true);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h(dVar);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.guardcallback.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.h(dVar);
                }
            });
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f195672b = SystemClock.elapsedRealtime();
        com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "onApplicationBackground mOnAppBackground=" + this.f195672b);
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.xaction.log.b.a("GuardManager.TabProcessor", 1, "onApplicationForeground cost=" + (SystemClock.elapsedRealtime() - this.f195672b));
        if (this.f195672b == 0) {
            return;
        }
        try {
            b();
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("GuardManager.TabProcessor", 1, "checkAndJump", e16);
        }
    }
}
