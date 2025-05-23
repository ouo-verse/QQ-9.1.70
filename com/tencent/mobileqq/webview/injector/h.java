package com.tencent.mobileqq.webview.injector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class h implements com.tencent.mobileqq.webview.swift.injector.k {
    @Override // com.tencent.mobileqq.webview.swift.injector.k
    public String a() {
        return com.tencent.mobileqq.perf.replay.collect.a.k().toString();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.k
    public void b(long j3, int i3) {
        com.tencent.mobileqq.perf.replay.collect.a.h(j3, i3);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.k
    public void c(String str, String str2) {
        com.tencent.qqperf.monitor.crash.tools.o.a(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.k
    public void d() {
        com.tencent.qqperf.monitor.crash.catchedexception.a.b(new RuntimeException("Webview init. "));
    }
}
