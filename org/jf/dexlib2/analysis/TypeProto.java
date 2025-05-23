package org.jf.dexlib2.analysis;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* loaded from: classes29.dex */
public interface TypeProto {
    int findMethodIndexInVtable(@Nonnull MethodReference methodReference);

    @Nonnull
    ClassPath getClassPath();

    @Nonnull
    TypeProto getCommonSuperclass(@Nonnull TypeProto typeProto);

    @Nullable
    FieldReference getFieldByOffset(int i3);

    @Nullable
    Method getMethodByVtableIndex(int i3);

    @Nullable
    String getSuperclass();

    @Nonnull
    String getType();

    boolean implementsInterface(@Nonnull String str);

    boolean isInterface();
}
