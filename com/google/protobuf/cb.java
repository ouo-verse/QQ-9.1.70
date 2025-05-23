package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class cb<T, B> {
    abstract void a(B b16, int i3, int i16);

    abstract void b(B b16, int i3, long j3);

    abstract void c(B b16, int i3, T t16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(B b16, int i3, ByteString byteString);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(B b16, int i3, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(T t16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(T t16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T k(T t16, T t17);

    final void l(B b16, bn bnVar) throws IOException {
        while (bnVar.t() != Integer.MAX_VALUE && m(b16, bnVar)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(B b16, bn bnVar) throws IOException {
        int tag = bnVar.getTag();
        int a16 = WireFormat.a(tag);
        int b17 = WireFormat.b(tag);
        if (b17 != 0) {
            if (b17 != 1) {
                if (b17 != 2) {
                    if (b17 != 3) {
                        if (b17 != 4) {
                            if (b17 == 5) {
                                a(b16, a16, bnVar.p());
                                return true;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    B n3 = n();
                    int c16 = WireFormat.c(a16, 4);
                    l(n3, bnVar);
                    if (c16 == bnVar.getTag()) {
                        c(b16, a16, r(n3));
                        return true;
                    }
                    throw InvalidProtocolBufferException.invalidEndTag();
                }
                d(b16, a16, bnVar.e());
                return true;
            }
            b(b16, a16, bnVar.w());
            return true;
        }
        e(b16, a16, bnVar.b());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, B b16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, T t16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(bn bnVar);

    abstract T r(B b16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(T t16, Writer writer) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(T t16, Writer writer) throws IOException;
}
