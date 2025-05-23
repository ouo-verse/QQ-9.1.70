package com.google.protobuf;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
class ce extends cb<cd, cd> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public cd g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(cd cdVar) {
        return cdVar.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(cd cdVar) {
        return cdVar.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public cd k(cd cdVar, cd cdVar2) {
        if (!cdVar2.equals(cd.e())) {
            return cd.o(cdVar, cdVar2);
        }
        return cdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public cd n() {
        return cd.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, cd cdVar) {
        p(obj, cdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, cd cdVar) {
        ((GeneratedMessageLite) obj).unknownFields = cdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public cd r(cd cdVar) {
        cdVar.j();
        return cdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(cd cdVar, Writer writer) throws IOException {
        cdVar.s(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(cd cdVar, Writer writer) throws IOException {
        cdVar.u(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    public void j(Object obj) {
        g(obj).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    public boolean q(bn bnVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(cd cdVar, int i3, int i16) {
        cdVar.r(WireFormat.c(i3, 5), Integer.valueOf(i16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(cd cdVar, int i3, long j3) {
        cdVar.r(WireFormat.c(i3, 1), Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(cd cdVar, int i3, cd cdVar2) {
        cdVar.r(WireFormat.c(i3, 3), cdVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(cd cdVar, int i3, ByteString byteString) {
        cdVar.r(WireFormat.c(i3, 2), byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(cd cdVar, int i3, long j3) {
        cdVar.r(WireFormat.c(i3, 0), Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.cb
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public cd f(Object obj) {
        cd g16 = g(obj);
        if (g16 == cd.e()) {
            cd p16 = cd.p();
            p(obj, p16);
            return p16;
        }
        return g16;
    }
}
