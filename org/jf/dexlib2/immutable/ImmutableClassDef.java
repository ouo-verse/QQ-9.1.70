package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.q;
import com.google.common.collect.r;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.util.FieldUtil;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableClassDef extends BaseTypeReference implements ClassDef {
    private static final ImmutableConverter<ImmutableClassDef, ClassDef> CONVERTER = new ImmutableConverter<ImmutableClassDef, ClassDef>() { // from class: org.jf.dexlib2.immutable.ImmutableClassDef.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull ClassDef classDef) {
            return classDef instanceof ImmutableClassDef;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableClassDef makeImmutable(@Nonnull ClassDef classDef) {
            return ImmutableClassDef.of(classDef);
        }
    };
    protected final int accessFlags;

    @Nonnull
    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    @Nonnull
    protected final ImmutableSortedSet<? extends ImmutableMethod> directMethods;

    @Nonnull
    protected final ImmutableSortedSet<? extends ImmutableField> instanceFields;

    @Nonnull
    protected final ImmutableList<String> interfaces;

    @Nullable
    protected final String sourceFile;

    @Nonnull
    protected final ImmutableSortedSet<? extends ImmutableField> staticFields;

    @Nullable
    protected final String superclass;

    @Nonnull
    protected final String type;

    @Nonnull
    protected final ImmutableSortedSet<? extends ImmutableMethod> virtualMethods;

    public ImmutableClassDef(@Nonnull String str, int i3, @Nullable String str2, @Nullable Collection<String> collection, @Nullable String str3, @Nullable Collection<? extends Annotation> collection2, @Nullable Iterable<? extends Field> iterable, @Nullable Iterable<? extends Method> iterable2) {
        iterable = iterable == null ? ImmutableList.of() : iterable;
        iterable2 = iterable2 == null ? ImmutableList.of() : iterable2;
        this.type = str;
        this.accessFlags = i3;
        this.superclass = str2;
        this.interfaces = collection == null ? ImmutableList.of() : ImmutableList.copyOf((Collection) collection);
        this.sourceFile = str3;
        this.annotations = ImmutableAnnotation.immutableSetOf(collection2);
        this.staticFields = ImmutableField.immutableSetOf(q.f(iterable, FieldUtil.FIELD_IS_STATIC));
        this.instanceFields = ImmutableField.immutableSetOf(q.f(iterable, FieldUtil.FIELD_IS_INSTANCE));
        this.directMethods = ImmutableMethod.immutableSetOf(q.f(iterable2, MethodUtil.METHOD_IS_DIRECT));
        this.virtualMethods = ImmutableMethod.immutableSetOf(q.f(iterable2, MethodUtil.METHOD_IS_VIRTUAL));
    }

    @Nonnull
    public static ImmutableSet<ImmutableClassDef> immutableSetOf(@Nullable Iterable<? extends ClassDef> iterable) {
        return CONVERTER.toSet(iterable);
    }

    public static ImmutableClassDef of(ClassDef classDef) {
        if (classDef instanceof ImmutableClassDef) {
            return (ImmutableClassDef) classDef;
        }
        return new ImmutableClassDef(classDef.getType(), classDef.getAccessFlags(), classDef.getSuperclass(), classDef.getInterfaces(), classDef.getSourceFile(), classDef.getAnnotations(), classDef.getStaticFields(), classDef.getInstanceFields(), classDef.getDirectMethods(), classDef.getVirtualMethods());
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSourceFile() {
        return this.sourceFile;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSuperclass() {
        return this.superclass;
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.type;
    }

    @Override // org.jf.dexlib2.iface.ClassDef, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public ImmutableSet<? extends ImmutableMethod> getDirectMethods() {
        return this.directMethods;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Collection<? extends ImmutableField> getFields() {
        return new AbstractCollection<ImmutableField>() { // from class: org.jf.dexlib2.immutable.ImmutableClassDef.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            @Nonnull
            public Iterator<ImmutableField> iterator() {
                return r.f(ImmutableClassDef.this.staticFields.iterator(), ImmutableClassDef.this.instanceFields.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ImmutableClassDef.this.staticFields.size() + ImmutableClassDef.this.instanceFields.size();
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public ImmutableSet<? extends ImmutableField> getInstanceFields() {
        return this.instanceFields;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public ImmutableList<String> getInterfaces() {
        return this.interfaces;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Collection<? extends ImmutableMethod> getMethods() {
        return new AbstractCollection<ImmutableMethod>() { // from class: org.jf.dexlib2.immutable.ImmutableClassDef.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            @Nonnull
            public Iterator<ImmutableMethod> iterator() {
                return r.f(ImmutableClassDef.this.directMethods.iterator(), ImmutableClassDef.this.virtualMethods.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ImmutableClassDef.this.directMethods.size() + ImmutableClassDef.this.virtualMethods.size();
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public ImmutableSet<? extends ImmutableField> getStaticFields() {
        return this.staticFields;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public ImmutableSet<? extends ImmutableMethod> getVirtualMethods() {
        return this.virtualMethods;
    }

    public ImmutableClassDef(@Nonnull String str, int i3, @Nullable String str2, @Nullable Collection<String> collection, @Nullable String str3, @Nullable Collection<? extends Annotation> collection2, @Nullable Iterable<? extends Field> iterable, @Nullable Iterable<? extends Field> iterable2, @Nullable Iterable<? extends Method> iterable3, @Nullable Iterable<? extends Method> iterable4) {
        this.type = str;
        this.accessFlags = i3;
        this.superclass = str2;
        this.interfaces = collection == null ? ImmutableList.of() : ImmutableList.copyOf((Collection) collection);
        this.sourceFile = str3;
        this.annotations = ImmutableAnnotation.immutableSetOf(collection2);
        this.staticFields = ImmutableField.immutableSetOf(iterable);
        this.instanceFields = ImmutableField.immutableSetOf(iterable2);
        this.directMethods = ImmutableMethod.immutableSetOf(iterable3);
        this.virtualMethods = ImmutableMethod.immutableSetOf(iterable4);
    }

    public ImmutableClassDef(@Nonnull String str, int i3, @Nullable String str2, @Nullable ImmutableList<String> immutableList, @Nullable String str3, @Nullable ImmutableSet<? extends ImmutableAnnotation> immutableSet, @Nullable ImmutableSortedSet<? extends ImmutableField> immutableSortedSet, @Nullable ImmutableSortedSet<? extends ImmutableField> immutableSortedSet2, @Nullable ImmutableSortedSet<? extends ImmutableMethod> immutableSortedSet3, @Nullable ImmutableSortedSet<? extends ImmutableMethod> immutableSortedSet4) {
        this.type = str;
        this.accessFlags = i3;
        this.superclass = str2;
        this.interfaces = ImmutableUtils.nullToEmptyList(immutableList);
        this.sourceFile = str3;
        this.annotations = ImmutableUtils.nullToEmptySet(immutableSet);
        this.staticFields = ImmutableUtils.nullToEmptySortedSet(immutableSortedSet);
        this.instanceFields = ImmutableUtils.nullToEmptySortedSet(immutableSortedSet2);
        this.directMethods = ImmutableUtils.nullToEmptySortedSet(immutableSortedSet3);
        this.virtualMethods = ImmutableUtils.nullToEmptySortedSet(immutableSortedSet4);
    }
}
