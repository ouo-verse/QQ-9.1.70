package com.tencent.qmethod.monitor.ext.overcall;

import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import com.tencent.qmethod.monitor.base.util.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/overcall/b;", "", "", "a", "d", "info", "", "e", "c", "f", "", "b", "g", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f343662a = new b();

    b() {
    }

    private final String a() {
        StringBuilder sb5 = new StringBuilder();
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        sb5.append(aVar.d(PMonitorInitParam.Property.APP_VERSION));
        sb5.append(util.base64_pad_url);
        sb5.append(com.tencent.qmethod.pandoraex.core.collector.utils.a.d(aVar.g().getContext()));
        return sb5.toString();
    }

    private final String d() {
        return a() + "_overCall";
    }

    public final long b() {
        return f.b(a());
    }

    @Nullable
    public final String c() {
        return f.d(d());
    }

    public final void e(@NotNull String info) {
        Intrinsics.checkParameterIsNotNull(info, "info");
        f.g(d(), info);
    }

    public final void f() {
        f.g(d(), "");
    }

    public final void g() {
        f.f(a(), 1L);
    }
}
