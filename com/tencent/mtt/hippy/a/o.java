package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyRootView;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    final n f336995a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f336996b;

    /* renamed from: d, reason: collision with root package name */
    private String f336998d;

    /* renamed from: e, reason: collision with root package name */
    private final UUID f336999e = UUID.randomUUID();

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mtt.hippy.a.a.a f336997c = new com.tencent.mtt.hippy.a.a.a();

    public o(HippyGlobalConfigs hippyGlobalConfigs, boolean z16, String str, String str2, String str3) {
        this.f336995a = d.a(hippyGlobalConfigs, z16, str, str2, str3);
        this.f336996b = z16;
    }

    public n a() {
        return this.f336995a;
    }

    public String b(String str) {
        return this.f336995a.a(str, this.f336999e.toString(), this.f336998d);
    }

    public String c() {
        return this.f336999e.toString();
    }

    public com.tencent.mtt.hippy.a.a.a d() {
        return this.f336997c;
    }

    public String a(String str) {
        return this.f336995a.a(str);
    }

    public void b(HippyRootView hippyRootView) {
        this.f336995a.b(hippyRootView);
    }

    public void c(String str) {
        this.f336998d = str;
    }

    public void a(HippyRootView hippyRootView) {
        this.f336995a.a(hippyRootView);
    }

    public boolean b() {
        return this.f336996b;
    }

    public void a(h hVar) {
        this.f336995a.a(hVar);
    }

    public void a(String str, h hVar) {
        this.f336995a.a(str, hVar);
    }

    public void a(Throwable th5) {
        this.f336995a.a(th5);
    }
}
