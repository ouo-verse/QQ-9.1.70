package com.tencent.tbs.one.impl.a;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f374550a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f374551b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<m<T>> f374552c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f374553d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f374554e;

    /* renamed from: f, reason: collision with root package name */
    private int f374555f;

    /* renamed from: g, reason: collision with root package name */
    private T f374556g;

    /* renamed from: h, reason: collision with root package name */
    private int f374557h;

    /* renamed from: i, reason: collision with root package name */
    private String f374558i;

    /* renamed from: j, reason: collision with root package name */
    private Throwable f374559j;

    public abstract void a();

    public final void a(m<T> mVar) {
        synchronized (this.f374551b) {
            if (this.f374554e) {
                if (mVar != null) {
                    mVar.a(0, 100);
                    mVar.a(this.f374556g);
                }
                return;
            }
            int i3 = this.f374557h;
            if (i3 != 0) {
                if (mVar != null) {
                    mVar.a(i3, this.f374558i, this.f374559j);
                }
                return;
            }
            if (mVar != null) {
                mVar.a(0, this.f374555f);
                this.f374552c.add(mVar);
            }
            if (this.f374553d) {
                return;
            }
            this.f374553d = true;
            a();
        }
    }

    public void b() {
        this.f374550a = true;
    }

    public void a(T t16) {
        synchronized (this.f374551b) {
            this.f374553d = false;
            this.f374554e = true;
            int i3 = this.f374555f;
            this.f374555f = 100;
            this.f374556g = t16;
            m[] mVarArr = (m[]) this.f374552c.toArray(new m[0]);
            this.f374552c.clear();
            for (m mVar : mVarArr) {
                mVar.a(i3, 100);
                mVar.a(t16);
            }
        }
    }

    public void a(int i3, String str, Throwable th5) {
        synchronized (this.f374551b) {
            this.f374553d = false;
            this.f374555f = 0;
            this.f374557h = i3;
            this.f374558i = str;
            this.f374559j = th5;
            m[] mVarArr = (m[]) this.f374552c.toArray(new m[0]);
            this.f374552c.clear();
            for (m mVar : mVarArr) {
                mVar.a(i3, str, th5);
            }
        }
    }

    public final void a(int i3) {
        synchronized (this.f374551b) {
            int i16 = this.f374555f;
            if (i3 - i16 > 2) {
                this.f374555f = i3;
                for (m mVar : (m[]) this.f374552c.toArray(new m[0])) {
                    mVar.a(i16, i3);
                }
            }
        }
    }
}
