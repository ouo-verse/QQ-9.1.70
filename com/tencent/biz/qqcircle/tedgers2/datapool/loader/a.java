package com.tencent.biz.qqcircle.tedgers2.datapool.loader;

import android.os.Handler;
import com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolConfig;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a extends dc0.a {

    /* renamed from: c, reason: collision with root package name */
    protected DataPoolConfig f92504c;

    /* renamed from: d, reason: collision with root package name */
    protected Handler f92505d;

    /* renamed from: e, reason: collision with root package name */
    protected d f92506e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f92507f;

    /* renamed from: g, reason: collision with root package name */
    protected long f92508g;

    /* renamed from: h, reason: collision with root package name */
    protected long f92509h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f92510i;

    public a(dc0.b bVar, DataPoolConfig dataPoolConfig, Handler handler, d dVar) {
        super(bVar);
        this.f92508g = 2000L;
        this.f92509h = 600000L;
        this.f92510i = new AtomicBoolean(false);
        this.f92504c = dataPoolConfig;
        this.f92505d = handler;
        this.f92506e = dVar;
        if (b() != null && c() != null) {
            if (c().c() > 0) {
                this.f92508g = c().c();
                this.f393528b.a(h(), "[BaseItemLoader]   | normalInterval = " + this.f92508g);
            }
            if (c().d() > 0) {
                this.f92509h = c().d();
                this.f393528b.a(h(), "[BaseItemLoader]   | errorInterval = " + this.f92509h);
            }
        }
    }

    private boolean d() {
        return !g().m();
    }

    public void e() {
        this.f393528b.a(h(), "[clearPoolAndStopLoopCheck]");
        if (g() != null) {
            g().f();
        }
        m();
    }

    protected abstract void f();

    protected abstract gc0.a g();

    protected abstract String h();

    protected abstract int i();

    public void j() {
        boolean i3 = g().i();
        this.f393528b.a(h(), "[itemLoopValidCheck]   | isFilter = " + i3);
        if (i3) {
            o(false);
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.f393528b.a(h(), "[restartDataCheck]");
        this.f92510i.set(false);
        n();
        o(false);
    }

    public void l() {
        this.f92510i.set(false);
        boolean d16 = d();
        this.f393528b.a(h(), "[startLoadData]   | isNeedLoadData = " + d16);
        if (!d16) {
            return;
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.f393528b.a(h(), "[stopDataCheck]");
        this.f92510i.set(true);
        this.f92505d.removeMessages(i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        long j3;
        if (this.f92510i.get()) {
            this.f393528b.a(h(), "[triggerItemValidDelayedCheck]  isClose");
            return;
        }
        if (g() != null) {
            g().o();
            j3 = g().l();
        } else {
            j3 = 0;
        }
        this.f393528b.a(h(), "[triggerItemValidDelayedCheck]   | delayTime = " + j3);
        if (j3 == -1) {
            return;
        }
        this.f92505d.removeMessages(i());
        this.f92505d.sendEmptyMessageDelayed(i(), j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(boolean z16) {
        long j3;
        if (this.f92510i.get()) {
            this.f393528b.a(h(), "[triggerStartLoadCheck]  isClose");
            return;
        }
        this.f92505d.removeMessages(1);
        Handler handler = this.f92505d;
        if (z16) {
            j3 = this.f92509h;
        } else {
            j3 = this.f92508g;
        }
        handler.sendEmptyMessageDelayed(1, j3);
        this.f393528b.a(h(), "[triggerStartLoadCheck]");
    }
}
