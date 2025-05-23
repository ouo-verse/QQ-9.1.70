package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseFieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderFieldReference extends BaseFieldReference implements BuilderReference {

    @Nonnull
    final BuilderTypeReference definingClass;

    @Nonnull
    final BuilderTypeReference fieldType;
    int index = -1;

    @Nonnull
    final BuilderStringReference name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderFieldReference(@Nonnull BuilderTypeReference builderTypeReference, @Nonnull BuilderStringReference builderStringReference, @Nonnull BuilderTypeReference builderTypeReference2) {
        this.definingClass = builderTypeReference;
        this.name = builderStringReference;
        this.fieldType = builderTypeReference2;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.definingClass.getType();
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.name.getString();
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return this.fieldType.getType();
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }
}
