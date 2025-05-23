package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.config.business.msf.MSFToggleUpdateImpl;
import com.tencent.mobileqq.data.dt.QQDtSamplingToggleUpdateImpl;
import com.tencent.mobileqq.perf.thread.config.ThreadPoolMonitorUpdateImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqmatrix.ThreadMonitorUpdateImpl;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitchUpdateListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/ABTestModule/Inject_ABCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends c>> f264306a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f264306a = arrayList;
        arrayList.add(ThreadMonitorUpdateImpl.class);
        f264306a.add(ZPlanFeatureSwitchUpdateListener.class);
        f264306a.add(MSFToggleUpdateImpl.class);
        f264306a.add(QQDtSamplingToggleUpdateImpl.class);
        f264306a.add(ThreadPoolMonitorUpdateImpl.class);
        f264306a.add(com.tencent.mobileqq.avatar.utils.d.class);
    }

    public static CopyOnWriteArrayList<c> a() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<Class<? extends c>> it = f264306a.iterator();
        while (it.hasNext()) {
            try {
                copyOnWriteArrayList.add(it.next().newInstance());
            } catch (Throwable th5) {
                QLog.e("FeatureSwitchUtil", 1, "Init Fail", th5);
            }
        }
        return copyOnWriteArrayList;
    }

    private static void b(String str, HashMap<String, String> hashMap) {
        String account;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            account = "";
        } else {
            account = peekAppRuntime.getAccount();
        }
        String str2 = account;
        hashMap.put("keyUin", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, str, false, 0L, 0L, hashMap, "");
    }

    public static void c(String str, FeatureSwitch featureSwitch) {
        String featureSwitch2;
        if (featureSwitch == null) {
            featureSwitch2 = "";
        } else {
            featureSwitch2 = featureSwitch.toString();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FeatureSwitchUtil", 2, "reportGetFeatureEvent : ", str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("keyFeatureContent", featureSwitch2);
        hashMap.put("keyGetFeatureName", str);
        b("ft_get_switch_statue", hashMap);
    }
}
