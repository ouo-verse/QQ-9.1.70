package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<m> f178508a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private g f178509b = new g();

    /* renamed from: c, reason: collision with root package name */
    private long f178510c;

    public void a(m mVar, boolean z16, boolean z17) {
        if (mVar == null) {
            return;
        }
        if (z16) {
            this.f178509b.b(mVar);
        }
        this.f178508a.add(mVar);
        if (z17) {
            this.f178510c += mVar.j();
        }
    }

    public g b() {
        return this.f178509b;
    }

    public ArrayList<m> c() {
        return this.f178508a;
    }

    public void d(long j3) {
        this.f178510c = j3;
    }
}
