package org.jf.dexlib2.analysis;

import com.google.common.base.n;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.reference.ImmutableFieldReference;
import org.jf.dexlib2.util.TypeUtils;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class ArrayProto implements TypeProto {
    private static final String BRACKETS = n.c("[", 256);
    protected final ClassPath classPath;
    protected final int dimensions;
    protected final String elementType;

    public ArrayProto(@Nonnull ClassPath classPath, @Nonnull String str) {
        this.classPath = classPath;
        int i3 = 0;
        while (str.charAt(i3) == '[') {
            i3++;
            if (i3 == str.length()) {
                throw new ExceptionWithContext("Invalid array type: %s", str);
            }
        }
        if (i3 != 0) {
            this.dimensions = i3;
            this.elementType = str.substring(i3);
            return;
        }
        throw new ExceptionWithContext("Invalid array type: %s", str);
    }

    @Nonnull
    private static String makeArrayType(@Nonnull String str, int i3) {
        return BRACKETS.substring(0, i3) + str;
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
        if (typeProto instanceof ArrayProto) {
            if (!TypeUtils.isPrimitiveType(getElementType())) {
                ArrayProto arrayProto = (ArrayProto) typeProto;
                if (!TypeUtils.isPrimitiveType(arrayProto.getElementType())) {
                    int i3 = this.dimensions;
                    int i16 = arrayProto.dimensions;
                    if (i3 == i16) {
                        TypeProto typeProto2 = this.classPath.getClass(this.elementType);
                        TypeProto typeProto3 = this.classPath.getClass(arrayProto.elementType);
                        TypeProto commonSuperclass = typeProto2.getCommonSuperclass(typeProto3);
                        if (typeProto2 == commonSuperclass) {
                            return this;
                        }
                        if (typeProto3 == commonSuperclass) {
                            return typeProto;
                        }
                        return this.classPath.getClass(makeArrayType(commonSuperclass.getType(), this.dimensions));
                    }
                    return this.classPath.getClass(makeArrayType("Ljava/lang/Object;", Math.min(i3, i16)));
                }
            }
            ArrayProto arrayProto2 = (ArrayProto) typeProto;
            if (this.dimensions == arrayProto2.dimensions && getElementType().equals(arrayProto2.getElementType())) {
                return this;
            }
            return this.classPath.getClass("Ljava/lang/Object;");
        }
        if (typeProto instanceof ClassProto) {
            try {
                if (typeProto.isInterface()) {
                    if (implementsInterface(typeProto.getType())) {
                        return typeProto;
                    }
                }
            } catch (UnresolvedClassException unused) {
            }
            return this.classPath.getClass("Ljava/lang/Object;");
        }
        return typeProto.getCommonSuperclass(this);
    }

    public int getDimensions() {
        return this.dimensions;
    }

    @Nonnull
    public String getElementType() {
        return this.elementType;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public FieldReference getFieldByOffset(int i3) {
        if (i3 == 8) {
            return new ImmutableFieldReference(getType(), "length", PoiListCacheRecord.WEIGHT_TYPE);
        }
        return null;
    }

    @Nonnull
    public String getImmediateElementType() {
        int i3 = this.dimensions;
        if (i3 > 1) {
            return makeArrayType(this.elementType, i3 - 1);
        }
        return this.elementType;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public Method getMethodByVtableIndex(int i3) {
        return this.classPath.getClass("Ljava/lang/Object;").getMethodByVtableIndex(i3);
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nullable
    public String getSuperclass() {
        return "Ljava/lang/Object;";
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    @Nonnull
    public String getType() {
        return makeArrayType(this.elementType, this.dimensions);
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public boolean implementsInterface(@Nonnull String str) {
        if (!str.equals("Ljava/lang/Cloneable;") && !str.equals("Ljava/io/Serializable;")) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.analysis.TypeProto
    public boolean isInterface() {
        return false;
    }

    public String toString() {
        return getType();
    }
}
