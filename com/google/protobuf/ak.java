package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class ak implements br {

    /* renamed from: b, reason: collision with root package name */
    private static final at f35664b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final at f35665a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a implements at {
        a() {
        }

        @Override // com.google.protobuf.at
        public boolean a(Class<?> cls) {
            return false;
        }

        @Override // com.google.protobuf.at
        public as b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements at {

        /* renamed from: a, reason: collision with root package name */
        private at[] f35666a;

        b(at... atVarArr) {
            this.f35666a = atVarArr;
        }

        @Override // com.google.protobuf.at
        public boolean a(Class<?> cls) {
            for (at atVar : this.f35666a) {
                if (atVar.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.at
        public as b(Class<?> cls) {
            for (at atVar : this.f35666a) {
                if (atVar.a(cls)) {
                    return atVar.b(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ak() {
        this(b());
    }

    private static at b() {
        return new b(ab.c(), c());
    }

    private static at c() {
        try {
            int i3 = n.f35907d;
            return (at) n.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f35664b;
        }
    }

    private static boolean d(as asVar) {
        if (asVar.getSyntax() == ProtoSyntax.PROTO2) {
            return true;
        }
        return false;
    }

    private static <T> bq<T> e(Class<T> cls, as asVar) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (d(asVar)) {
                return ay.Q(cls, asVar, be.b(), ai.b(), bs.O(), x.b(), aq.b());
            }
            return ay.Q(cls, asVar, be.b(), ai.b(), bs.O(), null, aq.b());
        }
        if (d(asVar)) {
            return ay.Q(cls, asVar, be.a(), ai.a(), bs.I(), x.a(), aq.a());
        }
        return ay.Q(cls, asVar, be.a(), ai.a(), bs.J(), null, aq.a());
    }

    @Override // com.google.protobuf.br
    public <T> bq<T> a(Class<T> cls) {
        bs.K(cls);
        as b16 = this.f35665a.b(cls);
        if (b16.a()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                return az.l(bs.O(), x.b(), b16.b());
            }
            return az.l(bs.I(), x.a(), b16.b());
        }
        return e(cls, b16);
    }

    ak(at atVar) {
        this.f35665a = (at) ad.b(atVar, "messageInfoFactory");
    }
}
