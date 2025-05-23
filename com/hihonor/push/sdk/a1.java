package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a1<TResult> {

    /* renamed from: b, reason: collision with root package name */
    public boolean f36353b;

    /* renamed from: c, reason: collision with root package name */
    public TResult f36354c;

    /* renamed from: d, reason: collision with root package name */
    public Exception f36355d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f36352a = new Object();

    /* renamed from: e, reason: collision with root package name */
    public List<j0<TResult>> f36356e = new ArrayList();

    public final void a() {
        synchronized (this.f36352a) {
            Iterator<j0<TResult>> it = this.f36356e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e16) {
                    throw e16;
                } catch (Exception e17) {
                    throw new RuntimeException(e17);
                }
            }
            this.f36356e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.f36352a) {
            exc = this.f36355d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.f36352a) {
            if (this.f36355d == null) {
                tresult = this.f36354c;
            } else {
                throw new RuntimeException(this.f36355d);
            }
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.f36352a) {
        }
        return false;
    }

    public final boolean e() {
        boolean z16;
        synchronized (this.f36352a) {
            if (this.f36353b) {
                d();
                if (this.f36355d == null) {
                    z16 = true;
                }
            }
            z16 = false;
        }
        return z16;
    }

    public final a1<TResult> a(j0<TResult> j0Var) {
        synchronized (this.f36352a) {
            if (!this.f36353b) {
                this.f36356e.add(j0Var);
            } else {
                j0Var.a(this);
            }
        }
        return this;
    }
}
