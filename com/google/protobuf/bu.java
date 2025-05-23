package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0252a;
import com.google.protobuf.ax;

/* compiled from: P */
/* loaded from: classes2.dex */
public class bu<MType extends a, BType extends a.AbstractC0252a, IType extends ax> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private a.b f35751a;

    /* renamed from: b, reason: collision with root package name */
    private BType f35752b;

    /* renamed from: c, reason: collision with root package name */
    private MType f35753c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f35754d;

    public bu(MType mtype, a.b bVar, boolean z16) {
        this.f35753c = (MType) ad.a(mtype);
        this.f35751a = bVar;
        this.f35754d = z16;
    }

    private void h() {
        a.b bVar;
        if (this.f35752b != null) {
            this.f35753c = null;
        }
        if (this.f35754d && (bVar = this.f35751a) != null) {
            bVar.a();
            this.f35754d = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        h();
    }

    public MType b() {
        this.f35754d = true;
        return f();
    }

    public bu<MType, BType, IType> c() {
        ar defaultInstanceForType;
        MType mtype = this.f35753c;
        if (mtype != null) {
            defaultInstanceForType = mtype.getDefaultInstanceForType();
        } else {
            defaultInstanceForType = this.f35752b.getDefaultInstanceForType();
        }
        this.f35753c = (MType) defaultInstanceForType;
        BType btype = this.f35752b;
        if (btype != null) {
            btype.dispose();
            this.f35752b = null;
        }
        h();
        return this;
    }

    public void d() {
        this.f35751a = null;
    }

    public BType e() {
        if (this.f35752b == null) {
            BType btype = (BType) this.f35753c.newBuilderForType(this);
            this.f35752b = btype;
            btype.mergeFrom(this.f35753c);
            this.f35752b.markClean();
        }
        return this.f35752b;
    }

    public MType f() {
        if (this.f35753c == null) {
            this.f35753c = (MType) this.f35752b.buildPartial();
        }
        return this.f35753c;
    }

    public bu<MType, BType, IType> g(MType mtype) {
        if (this.f35752b == null) {
            ar arVar = this.f35753c;
            if (arVar == arVar.getDefaultInstanceForType()) {
                this.f35753c = mtype;
                h();
                return this;
            }
        }
        e().mergeFrom(mtype);
        h();
        return this;
    }
}
