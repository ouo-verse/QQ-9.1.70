package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
class ArMapUtil$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f199703d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f199704e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f199705f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f199706h;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String str3 = "1";
        if (this.f199703d) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("isMapShow", str);
        if (this.f199704e) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("isFelxMap", str2);
        if (!this.f199705f) {
            str3 = "0";
        }
        hashMap.put("isFelxMapClick", str3);
        hashMap.put("operatorMapCount", String.valueOf(this.f199706h));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARMAP_DETAIL_GRID_MAP", this.f199705f, 0L, 0L, hashMap, "", false);
    }
}
