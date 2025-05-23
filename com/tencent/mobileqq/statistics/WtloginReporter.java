package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes18.dex */
public class WtloginReporter {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface) {
        ThreadManagerV2.executeOnFileThread(new Runnable(qQAppInterface.getCurrentAccountUin()) { // from class: com.tencent.mobileqq.statistics.WtloginReporter.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f289932d;

            {
                this.f289932d = r4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                int i16 = 2;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str = util.get_cost_time(BaseApplication.getContext());
                if (TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WtloginReporter", 2, "costValue is null");
                        return;
                    }
                    return;
                }
                if (Math.random() <= 0.001d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                String[] split = str.split(";");
                if (split != null) {
                    int i17 = 0;
                    while (i17 < split.length) {
                        String[] split2 = split[i17].split("\\|");
                        if (split2 != null && split2.length == 5) {
                            try {
                                long parseLong = Long.parseLong(split2[0]);
                                int parseInt = Integer.parseInt(split2[1]);
                                long parseLong2 = Long.parseLong(split2[i16]);
                                long parseLong3 = Long.parseLong(split2[3]);
                                long parseLong4 = Long.parseLong(split2[4]);
                                if (z16) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("uin", this.f289932d);
                                    hashMap.put("recordTime", String.valueOf(parseLong));
                                    hashMap.put(IProfileCardConst.KEY_FROM_TYPE, String.valueOf(parseInt));
                                    hashMap.put("costTime1", String.valueOf(parseLong2));
                                    hashMap.put("costTime2", String.valueOf(parseLong3));
                                    hashMap.put("costTime3", String.valueOf(parseLong4));
                                    if (parseLong2 > 1000) {
                                        hashMap.put("warnCost", "1");
                                    }
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f289932d, "wtloginCost", true, 0L, 0L, hashMap, "");
                                }
                            } catch (Throwable th5) {
                                QLog.e("WtloginReporter", 1, th5, new Object[0]);
                            }
                        } else {
                            Object[] objArr = new Object[i16];
                            objArr[0] = "error costTimes:";
                            objArr[1] = split[i17];
                            QLog.e("WtloginReporter", 1, objArr);
                        }
                        i17++;
                        i16 = 2;
                    }
                }
                util.save_cost_time(BaseApplication.getContext(), "");
                String str2 = util.get_cost_trace(BaseApplication.getContext());
                if (TextUtils.isEmpty(str2)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WtloginReporter", 2, "backTraceValue is null");
                        return;
                    }
                    return;
                }
                String[] split3 = str2.split("\\|");
                if (split3 != null) {
                    for (int i18 = 0; i18 < split3.length; i18++) {
                        String[] split4 = split3[i18].split(",");
                        if (split4 != null) {
                            if (split4.length == 2) {
                                try {
                                    long parseLong5 = Long.parseLong(split4[0]);
                                    String str3 = split4[1];
                                    if (z16) {
                                        HashMap<String, String> hashMap2 = new HashMap<>();
                                        hashMap2.put("uin", this.f289932d);
                                        hashMap2.put("recordTime", String.valueOf(parseLong5));
                                        hashMap2.put("backTrace", str3);
                                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f289932d, "wtloginCostTrace", true, 0L, 0L, hashMap2, "");
                                    }
                                } catch (Throwable th6) {
                                    QLog.e("WtloginReporter", 1, th6, new Object[0]);
                                }
                            } else {
                                i3 = 2;
                            }
                        } else {
                            i3 = 2;
                        }
                        Object[] objArr2 = new Object[i3];
                        objArr2[0] = "error traceItems:";
                        objArr2[1] = split3[i18];
                        QLog.e("WtloginReporter", 1, objArr2);
                    }
                }
                util.save_cost_trace(BaseApplication.getContext(), "");
            }
        });
    }
}
