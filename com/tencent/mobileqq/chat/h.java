package com.tencent.mobileqq.chat;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.config.business.NotificationBannerConfProcessor;
import com.tencent.mobileqq.notification.api.ISystemNotificationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h implements Manager {
    static IPatchRedirector $redirector_;

    public h(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    public static h g(QQAppInterface qQAppInterface) {
        return (h) qQAppInterface.getManager(QQManagerFactory.NOTIFICATION_BANNER_MANAGER);
    }

    private void j(BaseActivity baseActivity) {
        com.tencent.mobileqq.app.msgnotify.a.f196345a.o(baseActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(BaseActivity baseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        j(baseActivity);
        ReportController.r(null, "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 23, 0, "", "", "", "");
        q("em_bas_go_settings");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(BannerManager bannerManager, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        h(bannerManager);
        t();
        q("em_bas_top_message_bar");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", DTChatsConst.m.f354839a.a());
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(View view) {
        VideoReport.setElementId(view, "em_bas_top_message_bar");
        VideoReport.setElementParams(view, null);
    }

    private boolean o() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - ea.q0(peekAppRuntime.getCurrentUin());
        long e16 = NotificationBannerConfProcessor.d().e();
        if (com.tencent.mobileqq.app.msgnotify.e.a()) {
            e16 = NotificationBannerConfProcessor.d().a();
        }
        if (currentTimeMillis >= e16) {
            return false;
        }
        return true;
    }

    private void q(final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.chat.g
            @Override // java.lang.Runnable
            public final void run() {
                h.m(str);
            }
        });
    }

    private void r(final View view) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.chat.f
            @Override // java.lang.Runnable
            public final void run() {
                h.n(view);
            }
        });
    }

    private void s(BannerManager bannerManager, Message message) {
        bannerManager.O(NotificationGuideBannerProcessor.f185237d, 2, message);
        ReportController.r(null, "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 23, 0, "", "", "", "");
    }

    public boolean e() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        boolean f16 = NotificationBannerConfProcessor.d().f();
        boolean f17 = f();
        if (f17) {
            QLog.d("NotificationBannerManager", 2, "bannerVisible: systemNotificationEnabled");
            return false;
        }
        boolean o16 = o();
        if (com.tencent.mobileqq.app.msgnotify.e.a()) {
            z16 = com.tencent.mobileqq.app.msgnotify.a.f196345a.e();
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NotificationBannerManager", 2, "bannerVisible: invoked. ", " confVisible: ", Boolean.valueOf(f16), " systemNotificationEnabled: ", Boolean.valueOf(f17), " limitedByDuration: ", Boolean.valueOf(o16), " isNotifyDialogMax: ", Boolean.valueOf(z16));
        }
        if (!f16 || f17 || o16 || !z16) {
            return false;
        }
        return true;
    }

    public boolean f() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (((ISystemNotificationApi) QRoute.api(ISystemNotificationApi.class)).getCachedNotificationSwitch(BaseApplication.getContext()) && com.tencent.mobileqq.app.msgnotify.a.f196345a.m()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NotificationBannerManager", 2, "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    public void h(BannerManager bannerManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bannerManager);
        } else {
            bannerManager.O(NotificationGuideBannerProcessor.f185237d, 0, null);
        }
    }

    public void i(final BannerManager bannerManager, final BaseActivity baseActivity, com.tencent.biz.qui.noticebar.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bannerManager, baseActivity, dVar);
            return;
        }
        String c16 = NotificationBannerConfProcessor.d().c();
        dVar.setMsg(c16).b(NotificationBannerConfProcessor.d().b(), new View.OnClickListener() { // from class: com.tencent.mobileqq.chat.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.k(baseActivity, view);
            }
        }).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.chat.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.l(bannerManager, view);
            }
        });
        r(dVar.getView());
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void p(BannerManager bannerManager, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bannerManager, (Object) message);
        } else if (e()) {
            s(bannerManager, message);
        } else {
            h(bannerManager);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ea.k4(peekAppRuntime.getCurrentUin(), System.currentTimeMillis());
    }

    public void u(BannerManager bannerManager, com.tencent.biz.qui.noticebar.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bannerManager, (Object) dVar);
            return;
        }
        i(bannerManager, null, dVar);
        if (e()) {
            dVar.getView().setVisibility(0);
        } else {
            dVar.getView().setVisibility(8);
        }
    }
}
