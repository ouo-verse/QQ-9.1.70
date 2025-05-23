package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
class ArMapUtil$3 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String[] f199707d;

    @Override // java.lang.Runnable
    public void run() {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String[] strArr = this.f199707d;
        if (strArr == null) {
            length = 0;
        } else {
            length = strArr.length;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("preloadFileCount", String.valueOf(length));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARMAP_OFFLINE_ENTER", true, 0L, 0L, hashMap, "", false);
    }
}
