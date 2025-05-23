package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.au;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Extension<ContainingType extends au, Type> extends q<ContainingType, Type> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.q
    public final boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object b(Object obj);

    public abstract Descriptors.FieldDescriptor c();

    public abstract ar d();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object e(Object obj);
}
