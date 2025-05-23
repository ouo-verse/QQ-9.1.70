package com.tencent.open.agent.util;

import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements j {
    @Override // com.tencent.open.agent.util.j
    public void a(String str) {
        ForwardStatisticsReporter.m(str);
    }

    @Override // com.tencent.open.agent.util.j
    public void b(String str, long j3) {
        ForwardStatisticsReporter.d(str, j3);
    }

    @Override // com.tencent.open.agent.util.j
    public void c(String str, com.tencent.open.model.a aVar, HashMap<String, String> hashMap, boolean z16) {
        String str2;
        if (aVar == null) {
            str2 = "";
        } else {
            str2 = aVar.f341678a;
        }
        ForwardStatisticsReporter.i(str, str2, hashMap, z16);
    }

    @Override // com.tencent.open.agent.util.j
    public void d(String str, com.tencent.open.model.a aVar) {
        ForwardStatisticsReporter.e(str, aVar);
    }

    @Override // com.tencent.open.agent.util.j
    public void e(String str, com.tencent.open.model.a aVar, boolean z16) {
        ForwardStatisticsReporter.g(str, aVar, z16);
    }

    @Override // com.tencent.open.agent.util.j
    public void f(String str, String str2, long j3, HashMap<String, String> hashMap, boolean z16) {
        ForwardStatisticsReporter.h(str, str2, j3, hashMap, z16);
    }

    @Override // com.tencent.open.agent.util.j
    public void g(String str, String str2, boolean z16) {
        ForwardStatisticsReporter.j(str, str2, z16);
    }
}
