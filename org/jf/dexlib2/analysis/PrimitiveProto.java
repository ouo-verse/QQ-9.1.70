package org.jf.dexlib2.analysis;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class PrimitiveProto implements TypeProto {
    protected final ClassPath classPath;
    protected final String type;

    public PrimitiveProto(@Nonnull ClassPath classPath, @Nonnull String str) {
        this.classPath = classPath;
        this.type = str;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public int findMethodIndexInVtable(@Nonnull MethodReference methodReference) {
        return -1;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public ClassPath getClassPath() {
        return this.classPath;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public TypeProto getCommonSuperclass(@Nonnull TypeProto typeProto) {
        throw new ExceptionWithContext("Cannot call getCommonSuperclass on PrimitiveProto", new Object[0]);
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public FieldReference getFieldByOffset(int i3) {
        return null;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public Method getMethodByVtableIndex(int i3) {
        return null;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public String getSuperclass() {
        return null;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public String getType() {
        return this.type;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public boolean implementsInterface(@Nonnull String str) {
        return false;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public boolean isInterface() {
        return false;
    }

    public String toString() {
        return this.type;
    }
}
