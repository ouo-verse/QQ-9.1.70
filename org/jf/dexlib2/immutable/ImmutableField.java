package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableField extends BaseFieldReference implements Field {
    private static final ImmutableConverter<ImmutableField, Field> CONVERTER = new ImmutableConverter<ImmutableField, Field>() { // from class: org.jf.dexlib2.immutable.ImmutableField.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull Field field) {
            return field instanceof ImmutableField;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableField makeImmutable(@Nonnull Field field) {
            return ImmutableField.of(field);
        }
    };
    protected final int accessFlags;

    @Nonnull
    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    @Nonnull
    protected final String definingClass;

    @Nonnull
    protected final ImmutableSet<HiddenApiRestriction> hiddenApiRestrictions;

    @Nullable
    protected final ImmutableEncodedValue initialValue;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String type;

    public ImmutableField(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, int i3, @Nullable EncodedValue encodedValue, @Nullable Collection<? extends Annotation> collection, @Nullable Set<HiddenApiRestriction> set) {
        this.definingClass = str;
        this.name = str2;
        this.type = str3;
        this.accessFlags = i3;
        this.initialValue = ImmutableEncodedValueFactory.ofNullable(encodedValue);
        this.annotations = ImmutableAnnotation.immutableSetOf(collection);
        this.hiddenApiRestrictions = set == null ? ImmutableSet.of() : ImmutableSet.copyOf((Collection) set);
    }

    @Nonnull
    public static ImmutableSortedSet<ImmutableField> immutableSetOf(@Nullable Iterable<? extends Field> iterable) {
        return CONVERTER.toSortedSet(Ordering.natural(), iterable);
    }

    public static ImmutableField of(Field field) {
        if (field instanceof ImmutableField) {
            return (ImmutableField) field;
        }
        return new ImmutableField(field.getDefiningClass(), field.getName(), field.getType(), field.getAccessFlags(), field.getInitialValue(), field.getAnnotations(), field.getHiddenApiRestrictions());
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.jf.dexlib2.iface.Field
    public EncodedValue getInitialValue() {
        return this.initialValue;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return this.type;
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return this.annotations;
    }

    public ImmutableField(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, int i3, @Nullable ImmutableEncodedValue immutableEncodedValue, @Nullable ImmutableSet<? extends ImmutableAnnotation> immutableSet, @Nullable ImmutableSet<HiddenApiRestriction> immutableSet2) {
        this.definingClass = str;
        this.name = str2;
        this.type = str3;
        this.accessFlags = i3;
        this.initialValue = immutableEncodedValue;
        this.annotations = ImmutableUtils.nullToEmptySet(immutableSet);
        this.hiddenApiRestrictions = ImmutableUtils.nullToEmptySet(immutableSet2);
    }
}
