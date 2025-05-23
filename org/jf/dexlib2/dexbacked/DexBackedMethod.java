package org.jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodReference;
import org.jf.dexlib2.dexbacked.util.AnnotationsDirectory;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.dexbacked.util.ParameterIterator;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.util.AbstractForwardSequentialList;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethod extends BaseMethodReference implements Method {
    public final int accessFlags;

    @Nonnull
    public final DexBackedClassDef classDef;
    private final int codeOffset;

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int hiddenApiRestrictions;
    private final int methodAnnotationSetOffset;
    private int methodIdItemOffset;
    public final int methodIndex;
    private final int parameterAnnotationSetListOffset;
    private int parametersOffset;
    private int protoIdItemOffset;
    private final int startOffset;

    public DexBackedMethod(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, @Nonnull DexBackedClassDef dexBackedClassDef, int i3, int i16) {
        this.parametersOffset = -1;
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        this.startOffset = dexReader.getOffset();
        this.methodIndex = dexReader.readLargeUleb128() + i3;
        this.accessFlags = dexReader.readSmallUleb128();
        this.codeOffset = dexReader.readSmallUleb128();
        this.hiddenApiRestrictions = i16;
        this.methodAnnotationSetOffset = 0;
        this.parameterAnnotationSetListOffset = 0;
    }

    private int getMethodIdItemOffset() {
        if (this.methodIdItemOffset == 0) {
            this.methodIdItemOffset = this.dexFile.getMethodSection().getOffset(this.methodIndex);
        }
        return this.methodIdItemOffset;
    }

    private int getParametersOffset() {
        if (this.parametersOffset == -1) {
            this.parametersOffset = this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 8);
        }
        return this.parametersOffset;
    }

    private int getProtoIdItemOffset() {
        if (this.protoIdItemOffset == 0) {
            this.protoIdItemOffset = this.dexFile.getProtoSection().getOffset(this.dexFile.getBuffer().readUshort(getMethodIdItemOffset() + 2));
        }
        return this.protoIdItemOffset;
    }

    public static void skipMethods(@Nonnull DexReader dexReader, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            dexReader.skipUleb128();
            dexReader.skipUleb128();
            dexReader.skipUleb128();
        }
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends Annotation> getAnnotations() {
        return AnnotationsDirectory.getAnnotations(this.dexFile, this.methodAnnotationSetOffset);
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.classDef.getType();
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        int i3 = this.hiddenApiRestrictions;
        if (i3 == 7) {
            return ImmutableSet.of();
        }
        return EnumSet.copyOf((Collection) HiddenApiRestriction.getAllFlags(i3));
    }

    public int getMethodIndex() {
        return this.methodIndex;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(getMethodIdItemOffset() + 4));
    }

    @Nonnull
    public List<? extends Set<? extends DexBackedAnnotation>> getParameterAnnotations() {
        return AnnotationsDirectory.getParameterAnnotations(this.dexFile, this.parameterAnnotationSetListOffset);
    }

    @Nonnull
    public Iterator<String> getParameterNames() {
        DexBackedMethodImplementation implementation = getImplementation();
        if (implementation != null) {
            return implementation.getParameterNames(null);
        }
        return ImmutableSet.of().iterator();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public List<String> getParameterTypes() {
        int parametersOffset = getParametersOffset();
        if (parametersOffset > 0) {
            final int readSmallUint = this.dexFile.getDataBuffer().readSmallUint(parametersOffset + 0);
            final int i3 = parametersOffset + 4;
            return new FixedSizeList<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethod.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return readSmallUint;
                }

                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                @Nonnull
                public String readItem(int i16) {
                    return DexBackedMethod.this.dexFile.getTypeSection().get(DexBackedMethod.this.dexFile.getDataBuffer().readUshort(i3 + (i16 * 2)));
                }
            };
        }
        return ImmutableList.of();
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nonnull
    public List<? extends MethodParameter> getParameters() {
        if (getParametersOffset() > 0) {
            final List<String> parameterTypes = getParameterTypes();
            return new AbstractForwardSequentialList<MethodParameter>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethod.1
                @Override // org.jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                @Nonnull
                public Iterator<MethodParameter> iterator() {
                    return new ParameterIterator(parameterTypes, DexBackedMethod.this.getParameterAnnotations(), DexBackedMethod.this.getParameterNames());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return parameterTypes.size();
                }
            };
        }
        return ImmutableList.of();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 4));
    }

    public int getSize() {
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.startOffset);
        readerAt.readLargeUleb128();
        readerAt.readSmallUleb128();
        readerAt.readSmallUleb128();
        int offset = (readerAt.getOffset() - this.startOffset) + 0;
        DexBackedMethodImplementation implementation = getImplementation();
        if (implementation != null) {
            offset += implementation.getSize();
        }
        return offset + new DexBackedMethodReference(this.dexFile, this.methodIndex).getSize();
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nullable
    public DexBackedMethodImplementation getImplementation() {
        int i3 = this.codeOffset;
        if (i3 <= 0) {
            return null;
        }
        DexBackedDexFile dexBackedDexFile = this.dexFile;
        return dexBackedDexFile.createMethodImplementation(dexBackedDexFile, this, i3);
    }

    public DexBackedMethod(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, @Nonnull DexBackedClassDef dexBackedClassDef, int i3, @Nonnull AnnotationsDirectory.AnnotationIterator annotationIterator, @Nonnull AnnotationsDirectory.AnnotationIterator annotationIterator2, int i16) {
        this.parametersOffset = -1;
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        this.startOffset = dexReader.getOffset();
        int readLargeUleb128 = dexReader.readLargeUleb128() + i3;
        this.methodIndex = readLargeUleb128;
        this.accessFlags = dexReader.readSmallUleb128();
        this.codeOffset = dexReader.readSmallUleb128();
        this.hiddenApiRestrictions = i16;
        this.methodAnnotationSetOffset = annotationIterator.seekTo(readLargeUleb128);
        this.parameterAnnotationSetListOffset = annotationIterator2.seekTo(readLargeUleb128);
    }
}
