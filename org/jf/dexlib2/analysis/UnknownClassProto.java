package org.jf.dexlib2.analysis;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* loaded from: classes29.dex */
public class UnknownClassProto implements TypeProto {

    @Nonnull
    protected final ClassPath classPath;

    public UnknownClassProto(@Nonnull ClassPath classPath) {
        this.classPath = classPath;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public int findMethodIndexInVtable(@Nonnull MethodReference methodReference) {
        return this.classPath.getClass("Ljava/lang/Object;").findMethodIndexInVtable(methodReference);
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public ClassPath getClassPath() {
        return this.classPath;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public TypeProto getCommonSuperclass(@Nonnull TypeProto typeProto) {
        if (typeProto.getType().equals("Ljava/lang/Object;")) {
            return typeProto;
        }
        if (typeProto instanceof ArrayProto) {
            return this.classPath.getClass("Ljava/lang/Object;");
        }
        return this;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public FieldReference getFieldByOffset(int i3) {
        return this.classPath.getClass("Ljava/lang/Object;").getFieldByOffset(i3);
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public Method getMethodByVtableIndex(int i3) {
        return this.classPath.getClass("Ljava/lang/Object;").getMethodByVtableIndex(i3);
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public String getSuperclass() {
        return null;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public String getType() {
        return "Ujava/lang/Object;";
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
        return "Ujava/lang/Object;";
    }
}
