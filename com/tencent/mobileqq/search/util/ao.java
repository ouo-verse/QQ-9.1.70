package com.tencent.mobileqq.search.util;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static long f285007a;

    /* renamed from: b, reason: collision with root package name */
    private static long f285008b;

    /* renamed from: c, reason: collision with root package name */
    private static a f285009c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f285010a;

        /* renamed from: b, reason: collision with root package name */
        int f285011b;

        /* renamed from: c, reason: collision with root package name */
        int f285012c;

        /* renamed from: d, reason: collision with root package name */
        boolean f285013d;

        a() {
        }
    }

    public static void a() {
        if (f285007a != 0 && f285009c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("SearchStaticsUtil", 2, "recordEnd: spend total time = " + (currentTimeMillis - f285007a) + ", diff time = " + (currentTimeMillis - f285008b));
            }
            a aVar = f285009c;
            aVar.f285012c = (int) (currentTimeMillis - f285007a);
            d(aVar);
            f285008b = 0L;
            f285007a = 0L;
            f285009c = null;
        }
    }

    public static void b() {
        long currentTimeMillis = System.currentTimeMillis();
        f285007a = currentTimeMillis;
        f285008b = currentTimeMillis;
        a aVar = new a();
        f285009c = aVar;
        aVar.f285013d = y.b();
        if (QLog.isColorLevel()) {
            QLog.d("SearchStaticsUtil", 1, "recordStart: current time = " + f285007a + ", isOptimization = " + y.b());
        }
    }

    public static void c(String str, int i3) {
        a aVar;
        if (f285008b == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("SearchStaticsUtil", 2, "[" + str + "] recordUpdate: spend total time = " + (currentTimeMillis - f285007a) + ", diff time = " + (currentTimeMillis - f285008b) + ", from = " + i3);
        }
        f285008b = currentTimeMillis;
        if (i3 != -1 && (aVar = f285009c) != null && aVar.f285010a == 0) {
            aVar.f285011b = i3;
            aVar.f285010a = (int) (System.currentTimeMillis() - f285007a);
            if (QLog.isColorLevel()) {
                QLog.d("SearchStaticsUtil", 2, "recordUpdate - first : update cost time = " + (currentTimeMillis - f285007a) + ", from = " + i3);
            }
        }
    }

    private static void d(@NonNull a aVar) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String valueOf = String.valueOf(aVar.f285010a);
        String valueOf2 = String.valueOf(aVar.f285011b);
        String valueOf3 = String.valueOf(aVar.f285012c);
        if (aVar.f285013d) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C3C6", "0X800C3C6", 0, 0, valueOf, valueOf2, valueOf3, str);
    }
}
