package org.jf.dexlib2.writer;

import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodHandleSection<MethodHandleKey extends MethodHandleReference, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference> extends IndexSection<MethodHandleKey> {
    FieldRefKey getFieldReference(MethodHandleKey methodhandlekey);

    MethodRefKey getMethodReference(MethodHandleKey methodhandlekey);
}
