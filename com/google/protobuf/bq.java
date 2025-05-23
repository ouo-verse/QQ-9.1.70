package com.google.protobuf;

import com.google.protobuf.f;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public interface bq<T> {
    void a(T t16, T t17);

    boolean b(T t16);

    int c(T t16);

    boolean d(T t16, T t17);

    void e(T t16, Writer writer) throws IOException;

    void f(T t16, byte[] bArr, int i3, int i16, f.b bVar) throws IOException;

    void g(T t16);

    int h(T t16);

    void i(T t16, bn bnVar, t tVar) throws IOException;

    T newInstance();
}
