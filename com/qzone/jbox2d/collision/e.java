package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Vec2 f48039a = new Vec2();

    /* renamed from: c, reason: collision with root package name */
    public float f48041c = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f48040b = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public final ContactID f48042d = new ContactID();

    public void a(e eVar) {
        this.f48039a.set(eVar.f48039a);
        this.f48040b = eVar.f48040b;
        this.f48041c = eVar.f48041c;
        this.f48042d.k(eVar.f48042d);
    }
}
