package com.tencent.mobileqq.springhb.entry;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.MainActivityData;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.WnsNetworkConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    b f289092a;

    public h(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f289092a = bVar;
        }
    }

    private static String n(BaseActivityData baseActivityData) {
        if (baseActivityData == null) {
            return "null";
        }
        return baseActivityData.f289093id;
    }

    private static String o(BaseActivityData baseActivityData) {
        if (baseActivityData == null) {
            return "null";
        }
        return com.tencent.mobileqq.springhb.b.a(baseActivityData.type);
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void a(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onPendantHide actData actType = %s id=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData)));
            this.f289092a.a(baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(506, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onPendantHide ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void b(@NonNull MainActivityData mainActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) mainActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, "\u2014\u2014\u2014\u2014> onMainActivityRealStart");
            this.f289092a.b(mainActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(WnsNetworkConst.WRITE_FAIL, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onMainActivityRealStart ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void c(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onActivityAboutToOver actData actType = %s id=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData)));
            this.f289092a.c(baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(503, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onActivityAboutToOver ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void d(MainActivityData mainActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) mainActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, "\u2014\u2014\u2014\u2014> onMainActivityOver");
            this.f289092a.d(mainActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(WnsNetworkConst.NETWORK_DISABLE, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onMainActivityOver ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void e(MsgTabBannerData msgTabBannerData) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgTabBannerData);
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u2014\u2014\u2014\u2014> onMsgTabBannerHide data id = ");
            if (msgTabBannerData == null) {
                str = "null";
            } else {
                str = msgTabBannerData.f289095id;
            }
            sb5.append(str);
            sb5.append(" <\u2014\u2014\u2014\u2014");
            QLog.d("SpringHb_WrapperActivityExecutor", 1, sb5.toString());
            this.f289092a.e(msgTabBannerData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(516, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onMsgTabBannerHide ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void f(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onPendantShow actData actType = %s id=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData)));
            this.f289092a.f(baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(505, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onPendantShow ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void g(@NonNull MsgTabBannerData msgTabBannerData) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgTabBannerData);
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u2014\u2014\u2014\u2014> onMsgTabBannerShow data id = ");
            if (msgTabBannerData == null) {
                str = "null";
            } else {
                str = msgTabBannerData.f289095id;
            }
            sb5.append(str);
            sb5.append(" <\u2014\u2014\u2014\u2014");
            QLog.d("SpringHb_WrapperActivityExecutor", 1, sb5.toString());
            this.f289092a.g(msgTabBannerData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(515, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onMsgTabBannerShow ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void h(long j3, BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onActivityStart actData actType = %s id=%s taskTime=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData), en.i(j3)));
            this.f289092a.h(j3, baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(501, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onActivityStart ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void i(@NonNull MainActivityData mainActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) mainActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, "\u2014\u2014\u2014\u2014> onMainActivityPreStart");
            this.f289092a.i(mainActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(517, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onMainActivityPreStart ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void j(long j3, BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onActivityRealStart actData actType = %s id=%s taskTime=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData), en.i(j3)));
            this.f289092a.j(j3, baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(502, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onActivityRealStart ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void k(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onActivityOver actData actType = %s id=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData)));
            this.f289092a.k(baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(504, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onActivityOver ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void l(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onBreathLightHide actData actType = %s id=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData)));
            if (baseActivityData != null && baseActivityData.getType() != 2) {
                this.f289092a.l(baseActivityData);
            }
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(508, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onBreathLightHide ex. " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void m(@NonNull BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseActivityData);
            return;
        }
        try {
            QLog.d("SpringHb_WrapperActivityExecutor", 1, String.format("\u2014\u2014\u2014\u2014> onBreathLightShow actData actType = %s id=%s <\u2014\u2014\u2014\u2014", o(baseActivityData), n(baseActivityData)));
            this.f289092a.m(baseActivityData);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(507, e16, new String[0]);
            }
            QLog.e("SpringHb_WrapperActivityExecutor", 1, "onBreathLightShow ex. " + e16.getMessage(), e16);
        }
    }
}
