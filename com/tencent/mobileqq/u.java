package com.tencent.mobileqq;

import android.os.Looper;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface u {
    void a(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9);

    void b(int i3, long j3, long j16);

    String c();

    void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3);

    boolean d();

    String[] e(String str, String str2, String str3);

    void exitProcess(String str);

    Looper f();

    void g();

    void h(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5);
}
