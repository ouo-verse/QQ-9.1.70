package org.jf.dexlib2.writer.builder;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.q;
import com.google.common.collect.r;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderClassDef extends BaseTypeReference implements ClassDef {
    final int accessFlags;

    @Nonnull
    final BuilderAnnotationSet annotations;

    @Nonnull
    final SortedSet<BuilderMethod> directMethods;

    @Nonnull
    final SortedSet<BuilderField> instanceFields;

    @Nonnull
    final BuilderTypeList interfaces;

    @Nullable
    final BuilderStringReference sourceFile;

    @Nonnull
    final SortedSet<BuilderField> staticFields;

    @Nullable
    final BuilderEncodedValues.BuilderArrayEncodedValue staticInitializers;

    @Nullable
    final BuilderTypeReference superclass;

    @Nonnull
    final BuilderTypeReference type;

    @Nonnull
    final SortedSet<BuilderMethod> virtualMethods;
    int classDefIndex = -1;
    int annotationDirectoryOffset = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderClassDef(@Nonnull BuilderTypeReference builderTypeReference, int i3, @Nullable BuilderTypeReference builderTypeReference2, @Nonnull BuilderTypeList builderTypeList, @Nullable BuilderStringReference builderStringReference, @Nonnull BuilderAnnotationSet builderAnnotationSet, @Nullable SortedSet<BuilderField> sortedSet, @Nullable SortedSet<BuilderField> sortedSet2, @Nullable Iterable<? extends BuilderMethod> iterable, @Nullable BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
        iterable = iterable == null ? ImmutableList.of() : iterable;
        sortedSet = sortedSet == null ? ImmutableSortedSet.of() : sortedSet;
        sortedSet2 = sortedSet2 == null ? ImmutableSortedSet.of() : sortedSet2;
        this.type = builderTypeReference;
        this.accessFlags = i3;
        this.superclass = builderTypeReference2;
        this.interfaces = builderTypeList;
        this.sourceFile = builderStringReference;
        this.annotations = builderAnnotationSet;
        this.staticFields = sortedSet;
        this.instanceFields = sortedSet2;
        this.directMethods = ImmutableSortedSet.copyOf(q.f(iterable, MethodUtil.METHOD_IS_DIRECT));
        this.virtualMethods = ImmutableSortedSet.copyOf(q.f(iterable, MethodUtil.METHOD_IS_VIRTUAL));
        this.staticInitializers = builderArrayEncodedValue;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public List<String> getInterfaces() {
        return Lists.n(this.interfaces, Functions.a());
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSourceFile() {
        BuilderStringReference builderStringReference = this.sourceFile;
        if (builderStringReference == null) {
            return null;
        }
        return builderStringReference.getString();
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSuperclass() {
        BuilderTypeReference builderTypeReference = this.superclass;
        if (builderTypeReference == null) {
            return null;
        }
        return builderTypeReference.getType();
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.type.getType();
    }

    @Override // org.jf.dexlib2.iface.ClassDef, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public SortedSet<BuilderMethod> getDirectMethods() {
        return this.directMethods;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Collection<BuilderField> getFields() {
        return new AbstractCollection<BuilderField>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassDef.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            @Nonnull
            public Iterator<BuilderField> iterator() {
                return r.r(ImmutableList.of(BuilderClassDef.this.staticFields.iterator(), BuilderClassDef.this.instanceFields.iterator()), Ordering.natural());
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return BuilderClassDef.this.staticFields.size() + BuilderClassDef.this.instanceFields.size();
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public SortedSet<BuilderField> getInstanceFields() {
        return this.instanceFields;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Collection<BuilderMethod> getMethods() {
        return new AbstractCollection<BuilderMethod>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassDef.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            @Nonnull
            public Iterator<BuilderMethod> iterator() {
                return r.r(ImmutableList.of(BuilderClassDef.this.directMethods.iterator(), BuilderClassDef.this.virtualMethods.iterator()), Ordering.natural());
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return BuilderClassDef.this.directMethods.size() + BuilderClassDef.this.virtualMethods.size();
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public SortedSet<BuilderField> getStaticFields() {
        return this.staticFields;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public SortedSet<BuilderMethod> getVirtualMethods() {
        return this.virtualMethods;
    }
}
