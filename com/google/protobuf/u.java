package com.google.protobuf;

import com.google.protobuf.z;
import com.google.protobuf.z.c;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class u<T extends z.c<T>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object b(t tVar, au auVar, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract z<T> c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract z<T> d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean e(au auVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <UT, UB> UB g(bn bnVar, Object obj, t tVar, z<T> zVar, UB ub5, cb<UT, UB> cbVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void h(bn bnVar, Object obj, t tVar, z<T> zVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(ByteString byteString, Object obj, t tVar, z<T> zVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
