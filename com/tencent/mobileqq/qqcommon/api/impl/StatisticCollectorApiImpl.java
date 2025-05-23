package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StatisticCollectorApiImpl implements IStatisticCollectorApi {
    static IPatchRedirector $redirector_;

    public StatisticCollectorApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            collectPerformance("", str, str2, z16, j3, j16, hashMap, str3, false, false);
        } else {
            iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void report(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            StatisticCollector.report(str);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            collectPerformance("", str, str2, z16, j3, j16, hashMap, str3, z17, false);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            collectPerformance("", str, str2, z16, j3, j16, hashMap, str3, z17, z18);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            collectPerformance(str, str2, str3, z16, j3, j16, hashMap, str4, false, false);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str4);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            collectPerformance(str, str2, str3, z16, j3, j16, hashMap, str4, z17, false);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str4, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IStatisticCollectorApi
    public void collectPerformance(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            StatisticCollector.getInstance(BaseApplication.context).collectPerformance(str, str2, str3, z16, j3, j16, hashMap, str4, z17, z18);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str4, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }
}
