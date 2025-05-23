package com.tencent.icgame.api.strategy.impl;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected String f114818a = "PlayerStrategy|BaseStrategy";

    /* renamed from: b, reason: collision with root package name */
    private final IAegisLogApi f114819b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: c, reason: collision with root package name */
    protected InterfaceC5826a f114820c;

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.api.strategy.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5826a {
        void slowDownloadNetworkChange(boolean z16, boolean z17);
    }

    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public sf4.a b() {
        sf4.a aVar = new sf4.a();
        e("getConfig config:" + aVar);
        return aVar;
    }

    public abstract void c(InterfaceC5826a interfaceC5826a);

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        this.f114819b.e(this.f114818a, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
        this.f114819b.i(this.f114818a, str);
    }

    public abstract void f();

    public abstract void g();

    public abstract void h(long j3);

    public abstract void i(long j3);
}
