package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
final class bw implements as {

    /* renamed from: a, reason: collision with root package name */
    private final ProtoSyntax f35775a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f35776b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f35777c;

    /* renamed from: d, reason: collision with root package name */
    private final y[] f35778d;

    /* renamed from: e, reason: collision with root package name */
    private final au f35779e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<y> f35780a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoSyntax f35781b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f35782c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f35783d;

        /* renamed from: e, reason: collision with root package name */
        private int[] f35784e = null;

        /* renamed from: f, reason: collision with root package name */
        private Object f35785f;

        public a(int i3) {
            this.f35780a = new ArrayList(i3);
        }

        public bw a() {
            if (!this.f35782c) {
                if (this.f35781b != null) {
                    this.f35782c = true;
                    Collections.sort(this.f35780a);
                    return new bw(this.f35781b, this.f35783d, this.f35784e, (y[]) this.f35780a.toArray(new y[0]), this.f35785f);
                }
                throw new IllegalStateException("Must specify a proto syntax");
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void b(int[] iArr) {
            this.f35784e = iArr;
        }

        public void c(Object obj) {
            this.f35785f = obj;
        }

        public void d(y yVar) {
            if (!this.f35782c) {
                this.f35780a.add(yVar);
                return;
            }
            throw new IllegalStateException("Builder can only build once");
        }

        public void e(boolean z16) {
            this.f35783d = z16;
        }

        public void f(ProtoSyntax protoSyntax) {
            this.f35781b = (ProtoSyntax) ad.b(protoSyntax, "syntax");
        }
    }

    bw(ProtoSyntax protoSyntax, boolean z16, int[] iArr, y[] yVarArr, Object obj) {
        this.f35775a = protoSyntax;
        this.f35776b = z16;
        this.f35777c = iArr;
        this.f35778d = yVarArr;
        this.f35779e = (au) ad.b(obj, "defaultInstance");
    }

    public static a e(int i3) {
        return new a(i3);
    }

    @Override // com.google.protobuf.as
    public boolean a() {
        return this.f35776b;
    }

    @Override // com.google.protobuf.as
    public au b() {
        return this.f35779e;
    }

    public int[] c() {
        return this.f35777c;
    }

    public y[] d() {
        return this.f35778d;
    }

    @Override // com.google.protobuf.as
    public ProtoSyntax getSyntax() {
        return this.f35775a;
    }
}
