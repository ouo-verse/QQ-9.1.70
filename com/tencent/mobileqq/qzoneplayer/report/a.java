package com.tencent.mobileqq.qzoneplayer.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public interface a {
    void a(String str, long j3, long j16);

    void b(ArrayList<Map<String, String>> arrayList);

    long c(int i3);

    void d(ArrayList<Map<String, String>> arrayList, Map<String, String> map, String str, Map<String, String> map2, String str2);

    void e(Map<String, String> map, int i3, boolean z16);

    void f(String str, String str2, String str3, HashMap<String, String> hashMap);

    void g(String str, Map<String, String> map);

    long getLocalStoreTotalCountLimit();

    String getNetworkType();

    String getQua();

    long getUin();

    void h(int i3, String str, String str2, String str3, HashMap<String, String> hashMap, boolean z16, boolean z17);

    void i(String str, int i3);
}
