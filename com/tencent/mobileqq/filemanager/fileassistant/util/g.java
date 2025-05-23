package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.CommonMMKVUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f208076a = "key_qfile_existed";

    public static void a(boolean z16) {
        int i3;
        if (CommonMMKVUtils.getInt(f208076a, 0, true) != 0) {
            return;
        }
        if (z16) {
            b("0X800C242");
        }
        String str = f208076a;
        if (z16) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        CommonMMKVUtils.putInt(str, i3, true);
    }

    private static void b(String str) {
        c(str, 0, 0, "", "");
    }

    private static void c(String str, int i3, int i16, String str2, String str3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", str, str, 0, 0, String.valueOf(i3), String.valueOf(i16), str2, str3);
    }

    public static void d(int i3) {
        c("0X800C23A", 0, i3, "", "");
    }

    public static void e() {
        b("0X800C21D");
    }

    public static void f() {
        b("0X800C217");
    }
}
