package com.tencent.mobileqq.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.security.business.ModifyPwdTopBarHandler;
import com.tencent.mobileqq.security.business.a;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f285277a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f285278d;

        a(Context context) {
            this.f285278d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) context);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f285278d, b.this.f(peekAppRuntime.getCurrentUin(), "bar_url", ""), 4010, null);
                b.this.b(peekAppRuntime.getCurrentUin(), System.currentTimeMillis());
                ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B187", "0X800B187", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.security.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8554b extends com.tencent.mobileqq.security.business.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f285280e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f285281f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f285282h;

        C8554b(long j3, Map map, String str) {
            this.f285280e = j3;
            this.f285281f = map;
            this.f285282h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3), map, str);
            }
        }

        @Override // com.tencent.mobileqq.security.business.a
        public void b(boolean z16, a.C8555a c8555a) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), c8555a);
                return;
            }
            long c16 = c8555a.c();
            boolean e16 = c8555a.e();
            String b16 = c8555a.b();
            String a16 = c8555a.a();
            int d16 = c8555a.d();
            long j3 = this.f285280e;
            if (c16 != j3) {
                QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not match");
                return;
            }
            com.tencent.mobileqq.security.business.a aVar = (com.tencent.mobileqq.security.business.a) this.f285281f.remove(Long.valueOf(j3));
            if (aVar == null) {
                QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not exist");
                return;
            }
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (baseQQAppInterface != null) {
                baseQQAppInterface.removeObserver(aVar);
                QLog.d("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo isSuccess: " + z16 + " shouldDisplay: " + e16 + " content: " + b16 + " barUrl: " + a16 + " nextAccessTime: " + d16);
                if (z16) {
                    if (e16) {
                        b.this.q(this.f285282h, "key_show_status", true);
                        b.this.o(this.f285282h, "time_fetch_next_time", d16 * 1000);
                        b.this.p(this.f285282h, "bar_url", a16);
                        b.this.p(this.f285282h, "bar_content_string", b16);
                        b.this.l(baseQQAppInterface, true);
                        return;
                    }
                    b.this.q(this.f285282h, "key_verify_for_dlg_or_clk", false);
                    b.this.q(this.f285282h, "key_show_status", false);
                    b.this.l(baseQQAppInterface, false);
                    return;
                }
                return;
            }
            QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo app is null");
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b d() {
        if (f285277a == null) {
            synchronized (b.class) {
                if (f285277a == null) {
                    f285277a = new b();
                }
            }
        }
        return f285277a;
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        QLog.d("ModifyPwdTopBarHelper", 1, "cancelVerifyRiskDialog uin: " + str);
        n(str, false, false, 0L, 0L);
    }

    protected void b(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3));
            return;
        }
        QLog.d("ModifyPwdTopBarHelper", 1, "doAfterClickTopBar uin: " + str + " currentMillis: " + j3);
        n(str, true, false, j3, 0L);
    }

    public void c(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3));
            return;
        }
        QLog.d("ModifyPwdTopBarHelper", 1, "doAfterPushRiskDialog uin: " + str + " currentMillis: " + j3);
        k(str);
        n(str, true, false, j3, 0L);
    }

    protected long e(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, this, str, str2, Long.valueOf(j3))).longValue();
        }
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(str + "_" + str2, j3);
    }

    protected String f(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, this, str, str2, str3);
        }
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(str + "_" + str2, str3);
    }

    protected boolean g(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, str, str2, Boolean.valueOf(z16))).booleanValue();
        }
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(str + "_" + str2, z16);
    }

    public View h(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
        return QUINoticeBarManager.l().h(context).setMsg(f(baseQQAppInterface.getCurrentUin(), "bar_content_string", "")).c(new a(context)).getView();
    }

    public boolean i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return g(str, "key_risk_top_bar_enable", false);
    }

    protected void j(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) str);
            return;
        }
        if (baseQQAppInterface == null) {
            QLog.e("ModifyPwdTopBarHelper", 1, "requestTopBarDisplayInfo error: app == null");
            return;
        }
        ModifyPwdTopBarHandler modifyPwdTopBarHandler = (ModifyPwdTopBarHandler) baseQQAppInterface.getBusinessHandler(ModifyPwdTopBarHandler.class.getName());
        if (modifyPwdTopBarHandler == null) {
            QLog.e("ModifyPwdTopBarHelper", 1, "requestTopBarDisplayInfo error: handler == null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        C8554b c8554b = new C8554b(currentTimeMillis, hashMap, str);
        hashMap.put(Long.valueOf(currentTimeMillis), c8554b);
        baseQQAppInterface.addObserver(c8554b);
        modifyPwdTopBarHandler.D2(currentTimeMillis);
    }

    protected void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        QLog.d("ModifyPwdTopBarHelper", 1, "setModifyPwdTopBarEnable uin: " + str);
        q(str, "key_risk_top_bar_enable", true);
    }

    protected void l(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, baseQQAppInterface, Boolean.valueOf(z16));
        } else if (z16) {
            ReportController.o(baseQQAppInterface, "dc00898", "", "", "0X800B186", "0X800B186", 0, 0, "", "", "", "");
            BannerManager.l().O(SecureModifyPwdNotifyBannerProcessor.f185268d, 2, null);
        } else {
            BannerManager.l().O(SecureModifyPwdNotifyBannerProcessor.f185268d, 0, null);
        }
    }

    public void m(BaseQQAppInterface baseQQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, Long.valueOf(j3));
            return;
        }
        if (baseQQAppInterface != null && !TextUtils.isEmpty(baseQQAppInterface.getCurrentAccountUin()) && j3 > 0) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
            String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
            if (!i(currentAccountUin)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ModifyPwdTopBarHelper", 2, "isModifyPwdBarHelperEnable false");
                    return;
                }
                return;
            }
            boolean g16 = g(currentAccountUin, "key_verify_for_dlg_or_clk", false);
            boolean g17 = g(currentAccountUin, "key_show_status", false);
            long e16 = e(currentAccountUin, "time_dlg_show_or_bar_clk", 0L);
            long e17 = e(currentAccountUin, "time_fetch_next_time", 0L);
            QLog.d("ModifyPwdTopBarHelper", 1, "updateBarDisplayInfo verifyForDlgOrClk: " + g16 + " showStatus: " + g17 + " timeDlgShowOrBarClk: " + e16 + " fetchNext: " + e17 + " barUrl: " + f(currentAccountUin, "bar_url", "") + " contentStr: " + f(currentAccountUin, "bar_content_string", "") + " currentMillis: " + j3);
            if (g16 && j3 - e16 >= 86400000 && j3 >= e17) {
                j(baseQQAppInterface, currentAccountUin);
            }
            l(baseQQAppInterface, g17);
            return;
        }
        QLog.e("ModifyPwdTopBarHelper", 1, "updateBarDisplayStatus: params error");
    }

    protected void n(String str, boolean z16, boolean z17, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        QLog.d("ModifyPwdTopBarHelper", 1, "updateConfigData uin: " + str + " verifyForDlgOrClk: " + z16 + " showStatus: " + z17 + " timeDlgShowOrBarClk: " + j3 + " fetchNext: " + j16);
        q(str, "key_verify_for_dlg_or_clk", z16);
        q(str, "key_show_status", z17);
        o(str, "time_dlg_show_or_bar_clk", j3);
        o(str, "time_fetch_next_time", j16);
    }

    protected void o(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, Long.valueOf(j3));
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putLong(str + "_" + str2, j3);
        edit.apply();
    }

    protected void p(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, str3);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putString(str + "_" + str2, str3);
        edit.apply();
    }

    protected void q(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putBoolean(str + "_" + str2, z16);
        edit.apply();
    }
}
