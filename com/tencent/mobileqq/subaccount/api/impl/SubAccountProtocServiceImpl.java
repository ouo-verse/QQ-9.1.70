package com.tencent.mobileqq.subaccount.api.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dc;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.h;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class SubAccountProtocServiceImpl implements ISubAccountProtocService {
    static IPatchRedirector $redirector_ = null;
    private static final long DAY_MILLS_SEC = 86400000;
    private static final String TAG = "Q.subaccount.SubAccountProtocManager";
    private static byte[] lock;
    private static byte[] lock1;
    private static byte[] lock2;
    private AppInterface app;
    private dc bindObserver;
    private boolean isBindOperator;
    private boolean isGetBindFinish;
    private boolean isInGetBindOperator;
    private boolean isUnBindOperator;
    private Runnable mDayRunnable;

    /* loaded from: classes18.dex */
    private static class DayRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        DayRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences("mobileQQ", 0);
            long j3 = sharedPreferences.getLong("subaccount_last_report_time_" + appInterface.getCurrentAccountUin(), 0L);
            long currentTimeMillis = System.currentTimeMillis() - 10;
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            calendar2.add(5, 1);
            calendar2.clear(10);
            calendar2.clear(12);
            calendar2.clear(13);
            calendar2.clear(14);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.add(5, 1);
            calendar3.clear(10);
            calendar3.clear(12);
            calendar3.clear(13);
            calendar3.clear(14);
            long timeInMillis = (calendar3.getTimeInMillis() - currentTimeMillis) - 100;
            if (timeInMillis < 0) {
                timeInMillis = 86400000;
            }
            if (j3 > 0 && calendar.after(calendar2) && h.A(appInterface)) {
                boolean B = h.B(appInterface);
                HashMap hashMap = new HashMap();
                hashMap.put("Top_bind_account", Integer.valueOf(B ? 1 : 0));
                StatisticCollector.getInstance(appInterface.getApp()).reportOnOff(appInterface, appInterface.getCurrentAccountUin(), hashMap);
                sharedPreferences.edit().putLong("subaccount_last_report_time_" + appInterface.getCurrentAccountUin(), currentTimeMillis).commit();
            }
            if (j3 == 0) {
                sharedPreferences.edit().putLong("subaccount_last_report_time_" + appInterface.getCurrentAccountUin(), currentTimeMillis).commit();
            }
            ThreadManagerV2.executeDelay(this, 16, null, true, 60000 + timeInMillis + ((long) (Math.random() * 30.0d * 60.0d * 1000.0d)));
        }
    }

    /* loaded from: classes18.dex */
    class a extends dc {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountProtocServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (SubAccountProtocServiceImpl.lock) {
                    SubAccountProtocServiceImpl.this.isBindOperator = false;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            ArrayList<String> e16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SubAccountProtocManager.onGetBindSubAccount() isSucc=");
                sb5.append(z16);
                sb5.append(" data.mSubUin=");
                if (aVar == null) {
                    str = "data is null";
                } else {
                    str = aVar.f291124d;
                }
                sb5.append(str);
                QLog.d("SUB_ACCOUNT", 2, sb5.toString());
            }
            if (!SubAccountProtocServiceImpl.this.isGetBindFinish && ThreadManager.getSubThreadHandler() != null) {
                ThreadManager.getSubThreadHandler().postDelayed(SubAccountProtocServiceImpl.this.mDayRunnable, 100L);
            }
            if (aVar != null) {
                if (aVar.g()) {
                    h.c(SubAccountProtocServiceImpl.this.app, aVar.d(), 2);
                }
                if (aVar.h() && (e16 = aVar.e()) != null) {
                    Iterator<String> it = e16.iterator();
                    while (it.hasNext()) {
                        h.S(SubAccountProtocServiceImpl.this.app, it.next());
                    }
                }
                aVar.b();
            }
            synchronized (SubAccountProtocServiceImpl.lock2) {
                SubAccountProtocServiceImpl.this.isInGetBindOperator = false;
                SubAccountProtocServiceImpl.this.isGetBindFinish = true;
            }
            if (aVar != null && aVar.f291131k) {
                h.G(SubAccountProtocServiceImpl.this.app, aVar.f291124d, false);
                if (!((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                    ((ISubAccountServlet) QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(SubAccountProtocServiceImpl.this.app, aVar.f291124d);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                synchronized (SubAccountProtocServiceImpl.lock1) {
                    SubAccountProtocServiceImpl.this.isUnBindOperator = false;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        lock = new byte[0];
        lock1 = new byte[0];
        lock2 = new byte[0];
    }

    public SubAccountProtocServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isBindOperator = false;
        this.isUnBindOperator = false;
        this.isInGetBindOperator = false;
        this.bindObserver = new a();
        this.mDayRunnable = new DayRunnable();
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountProtocService
    public void bindAccount(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3);
            return;
        }
        if (this.app == null) {
            return;
        }
        synchronized (lock) {
            if (this.isBindOperator) {
                return;
            }
            this.isBindOperator = true;
            ((SubAccountBindHandler) this.app.getBusinessHandler(SubAccountBindHandler.class.getName())).E2(str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountProtocService
    public void getBindAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.app == null) {
            return;
        }
        synchronized (lock2) {
            if (this.isInGetBindOperator) {
                return;
            }
            this.isInGetBindOperator = true;
            ((SubAccountBindHandler) this.app.getBusinessHandler(SubAccountBindHandler.class.getName())).F2();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountProtocService
    public boolean getBindAccountFinish() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        synchronized (lock2) {
            z16 = this.isGetBindFinish;
        }
        return z16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.app = appInterface;
        this.isBindOperator = false;
        this.isUnBindOperator = false;
        this.isInGetBindOperator = false;
        this.isGetBindFinish = false;
        appInterface.addObserver(this.bindObserver);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "SubAccountProtocManager: manager init");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.app.removeObserver(this.bindObserver);
        if (ThreadManager.getSubThreadHandler() != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.mDayRunnable);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountProtocService
    public void unBindAccount(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.app == null) {
            return;
        }
        synchronized (lock1) {
            if (this.isUnBindOperator) {
                return;
            }
            this.isUnBindOperator = true;
            ((SubAccountBindHandler) this.app.getBusinessHandler(SubAccountBindHandler.class.getName())).S2(str);
        }
    }
}
