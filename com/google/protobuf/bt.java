package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.f;
import com.google.protobuf.ax;

/* compiled from: P */
/* loaded from: classes2.dex */
public class bt<MType extends GeneratedMessage, BType extends GeneratedMessage.f, IType extends ax> implements GeneratedMessage.g {

    /* renamed from: a, reason: collision with root package name */
    private GeneratedMessage.g f35747a;

    /* renamed from: b, reason: collision with root package name */
    private BType f35748b;

    /* renamed from: c, reason: collision with root package name */
    private MType f35749c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f35750d;

    public bt(MType mtype, GeneratedMessage.g gVar, boolean z16) {
        this.f35749c = (MType) ad.a(mtype);
        this.f35747a = gVar;
        this.f35750d = z16;
    }

    private void i() {
        GeneratedMessage.g gVar;
        if (this.f35748b != null) {
            this.f35749c = null;
        }
        if (this.f35750d && (gVar = this.f35747a) != null) {
            gVar.a();
            this.f35750d = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        i();
    }

    public MType b() {
        this.f35750d = true;
        return f();
    }

    public bt<MType, BType, IType> c() {
        ar defaultInstanceForType;
        MType mtype = this.f35749c;
        if (mtype != null) {
            defaultInstanceForType = mtype.getDefaultInstanceForType();
        } else {
            defaultInstanceForType = this.f35748b.getDefaultInstanceForType();
        }
        this.f35749c = (MType) defaultInstanceForType;
        BType btype = this.f35748b;
        if (btype != null) {
            btype.dispose();
            this.f35748b = null;
        }
        i();
        return this;
    }

    public void d() {
        this.f35747a = null;
    }

    public BType e() {
        if (this.f35748b == null) {
            BType btype = (BType) this.f35749c.newBuilderForType(this);
            this.f35748b = btype;
            btype.mergeFrom(this.f35749c);
            this.f35748b.markClean();
        }
        return this.f35748b;
    }

    public MType f() {
        if (this.f35749c == null) {
            this.f35749c = (MType) this.f35748b.buildPartial();
        }
        return this.f35749c;
    }

    public IType g() {
        BType btype = this.f35748b;
        if (btype != null) {
            return btype;
        }
        return this.f35749c;
    }

    public bt<MType, BType, IType> h(MType mtype) {
        if (this.f35748b == null) {
            MType mtype2 = this.f35749c;
            if (mtype2 == mtype2.getDefaultInstanceForType()) {
                this.f35749c = mtype;
                i();
                return this;
            }
        }
        e().mergeFrom(mtype);
        i();
        return this;
    }

    public bt<MType, BType, IType> j(MType mtype) {
        this.f35749c = (MType) ad.a(mtype);
        BType btype = this.f35748b;
        if (btype != null) {
            btype.dispose();
            this.f35748b = null;
        }
        i();
        return this;
    }
}
