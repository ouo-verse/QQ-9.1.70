package org.jf.dexlib2.writer.builder;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderField extends BaseFieldReference implements Field {
    final int accessFlags;

    @Nonnull
    final BuilderAnnotationSet annotations;

    @Nonnull
    final BuilderFieldReference fieldReference;

    @Nonnull
    Set<HiddenApiRestriction> hiddenApiRestrictions;

    @Nullable
    final BuilderEncodedValues.BuilderEncodedValue initialValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderField(@Nonnull BuilderFieldReference builderFieldReference, int i3, @Nullable BuilderEncodedValues.BuilderEncodedValue builderEncodedValue, @Nonnull BuilderAnnotationSet builderAnnotationSet, @Nonnull Set<HiddenApiRestriction> set) {
        this.fieldReference = builderFieldReference;
        this.accessFlags = i3;
        this.initialValue = builderEncodedValue;
        this.annotations = builderAnnotationSet;
        this.hiddenApiRestrictions = set;
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.fieldReference.definingClass.getType();
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.fieldReference.name.getString();
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return this.fieldReference.fieldType.getType();
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }

    @Override // org.jf.dexlib2.iface.Field
    @Nullable
    public BuilderEncodedValues.BuilderEncodedValue getInitialValue() {
        return this.initialValue;
    }
}
