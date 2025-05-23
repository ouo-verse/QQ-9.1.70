package com.tencent.timi.game.api.strategy.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected String f376311a = "PlayerStrategy|BaseStrategy";

    /* renamed from: b, reason: collision with root package name */
    private final IAegisLogApi f376312b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: c, reason: collision with root package name */
    protected InterfaceC9921a f376313c;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.api.strategy.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC9921a {
        void slowDownloadNetworkChange(boolean z16, boolean z17);
    }

    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public sf4.a b() {
        sf4.a aVar = new sf4.a();
        try {
            aVar = (sf4.a) VasToggle.QQLIVE_PLAYER_NETWORK_STRATEGY.getBean(sf4.a.class, new sf4.a());
        } catch (Exception e16) {
            d("getConfig error! " + e16.getMessage());
        }
        e("getConfig config:" + aVar);
        return aVar;
    }

    public abstract void c(InterfaceC9921a interfaceC9921a);

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        this.f376312b.e(this.f376311a, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
        this.f376312b.i(this.f376311a, str);
    }

    public abstract void f();

    public abstract void g();

    public abstract void h(long j3);

    public abstract void i(long j3);
}
