package org.jf.dexlib2.analysis.reflection;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.analysis.reflection.util.ReflectionUtils;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReflectionField extends BaseFieldReference implements Field {
    private final java.lang.reflect.Field field;

    public ReflectionField(java.lang.reflect.Field field) {
        this.field = field;
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.field.getModifiers();
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends Annotation> getAnnotations() {
        return ImmutableSet.of();
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return ReflectionUtils.javaToDexName(this.field.getDeclaringClass().getName());
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return ImmutableSet.of();
    }

    @Override // org.jf.dexlib2.iface.Field
    @Nullable
    public EncodedValue getInitialValue() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.field.getName();
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return ReflectionUtils.javaToDexName(this.field.getType().getName());
    }
}
