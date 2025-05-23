package com.tencent.mobileqq.phonecontact.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReportUtil {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(AppInterface appInterface, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        int i28;
        int i29;
        if (i26 >= 3) {
            if (i16 == 0) {
                i29 = 11;
            } else if (i17 == 0) {
                i29 = 12;
            } else {
                i29 = 13;
            }
        } else if (i18 >= 100) {
            if (i16 == 0) {
                i29 = 21;
            } else if (i17 == 0) {
                i29 = 22;
            } else {
                i29 = 23;
            }
        } else {
            i28 = 0;
            if (i28 != 0) {
                return;
            }
            ThreadManagerV2.post(new Runnable(i3, i28, i16, i17, i18, i19, i26, i27) { // from class: com.tencent.mobileqq.phonecontact.util.ReportUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int C;
                final /* synthetic */ int D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f258501d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f258502e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f258503f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f258504h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f258505i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f258506m;

                {
                    this.f258501d = i3;
                    this.f258502e = i28;
                    this.f258503f = i16;
                    this.f258504h = i17;
                    this.f258505i = i18;
                    this.f258506m = i19;
                    this.C = i26;
                    this.D = i27;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i28), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("report_key_from", String.valueOf(this.f258501d));
                    hashMap.put("report_key_type", String.valueOf(this.f258502e));
                    hashMap.put("report_key_qqContactCnt", String.valueOf(this.f258503f));
                    hashMap.put("report_key_rawContactCnt", String.valueOf(this.f258504h));
                    hashMap.put("report_key_delCnt", String.valueOf(this.f258505i));
                    hashMap.put("report_key_delCntConflict", String.valueOf(this.f258506m));
                    hashMap.put("report_key_delCntDangerous", String.valueOf(this.C));
                    hashMap.put("report_key_insertCnt", String.valueOf(this.D));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actContactSyncExReport", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel()) {
                        QLog.i("actContactSyncExReport", 2, String.format("reportContactSyncExIfNeed from|type|qqContactCnt|rawContactCnt|delCnt|delCntConflict|delCntDangerous|insertCnt = %d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(this.f258501d), Integer.valueOf(this.f258502e), Integer.valueOf(this.f258503f), Integer.valueOf(this.f258504h), Integer.valueOf(this.f258505i), Integer.valueOf(this.f258506m), Integer.valueOf(this.C), Integer.valueOf(this.D)));
                    }
                }
            }, 5, null, false);
            return;
        }
        i28 = i29;
        if (i28 != 0) {
        }
    }
}
