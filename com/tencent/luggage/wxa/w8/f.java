package com.tencent.luggage.wxa.w8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final FutureTask f144125a;

    public f(Runnable runnable) {
        this.f144125a = new FutureTask(runnable, 0);
    }

    public boolean a(long j3) {
        try {
            this.f144125a.get(j3, TimeUnit.MILLISECONDS);
            return true;
        } catch (InterruptedException e16) {
            com.tencent.luggage.wxa.p8.f.a("MagicBrush.SyncTask", e16, "await failed", new Object[0]);
            return false;
        } catch (ExecutionException e17) {
            com.tencent.luggage.wxa.p8.f.a("MagicBrush.SyncTask", e17, "execute failed", new Object[0]);
            return false;
        } catch (TimeoutException e18) {
            com.tencent.luggage.wxa.p8.f.a("MagicBrush.SyncTask", e18, "execute timeout", new Object[0]);
            return false;
        }
    }

    public boolean b() {
        return this.f144125a.isDone();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f144125a.run();
    }

    public f(Callable callable) {
        this.f144125a = new FutureTask(callable);
    }

    public Object a() {
        try {
            return this.f144125a.get();
        } catch (InterruptedException e16) {
            com.tencent.luggage.wxa.p8.f.a("MagicBrush.SyncTask", e16, "await failed", new Object[0]);
            return null;
        } catch (ExecutionException e17) {
            com.tencent.luggage.wxa.p8.f.a("MagicBrush.SyncTask", e17, "execute failed", new Object[0]);
            return null;
        }
    }
}
