package com.tencent.imcore.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f116692a;

    /* renamed from: b, reason: collision with root package name */
    public static long f116693b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37131);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f116692a = true;
            f116693b = 0L;
        }
    }

    public static void a(AppRuntime appRuntime, boolean z16, String str, String str2, aj ajVar) {
        String str3;
        if (appRuntime == null) {
            return;
        }
        try {
            if (!f116692a) {
                QLog.i("C2CMessageReport", 2, "return because switch");
                return;
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty("3")) {
                hashMap.put("verify_type", "3");
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("fail_type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("time_range", str2);
            }
            if (ajVar != null && !TextUtils.isEmpty(ajVar.f116541s)) {
                hashMap.put("friend_uin", ajVar.f116541s);
            }
            if (z16) {
                str3 = "1";
            } else {
                str3 = "2";
            }
            hashMap.put("is_load_sec", str3);
            if (QLog.isColorLevel()) {
                QLog.i("C2CMessageReport", 1, "reportAioLoad isSuc=" + z16 + ",params=" + hashMap.toString());
            }
            QQBeaconReport.reportWithAppKey("0S200MNJT807V3GE", appRuntime.getCurrentUin(), "c2c_aio_roam_load", z16, hashMap, false);
        } catch (Exception e16) {
            QLog.i("C2CMessageReport", 1, "reportAioLoad", e16);
        }
    }

    public static void b(AppRuntime appRuntime, ArrayList<MessageRecord> arrayList, int i3, long j3, aj ajVar) {
        if (appRuntime == null) {
            return;
        }
        try {
            if (!f116692a) {
                QLog.i("C2CMessageReport", 2, "return because switch");
            } else if (arrayList.size() >= i3) {
                if (j3 > 0) {
                    a(appRuntime, false, "5", "1", ajVar);
                } else {
                    a(appRuntime, false, "7", "2", ajVar);
                }
            }
        } catch (Exception e16) {
            QLog.i("C2CMessageReport", 1, "reportAioLoadBeforeReq", e16);
        }
    }

    public static void c(AppRuntime appRuntime, Bundle bundle, aj ajVar) {
        if (appRuntime == null) {
            return;
        }
        try {
            if (!f116692a) {
                QLog.i("C2CMessageReport", 2, "return because switch");
            } else {
                a(appRuntime, bundle.getBoolean("success"), "8", "1", ajVar);
            }
        } catch (Exception e16) {
            QLog.i("C2CMessageReport", 1, "reportAioLoadWhenPullMsgBreak", e16);
        }
    }

    public static void d(boolean z16) {
        f116692a = z16;
        QLog.i("C2CMessageReport", 1, "setReportSwitch sC2cMessageReportSwitch=" + f116692a);
    }
}
