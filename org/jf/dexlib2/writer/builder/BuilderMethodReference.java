package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderMethodReference extends BaseMethodReference implements BuilderReference {

    @Nonnull
    final BuilderTypeReference definingClass;
    int index = -1;

    @Nonnull
    final BuilderStringReference name;

    @Nonnull
    final BuilderMethodProtoReference proto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderMethodReference(@Nonnull BuilderTypeReference builderTypeReference, @Nonnull BuilderStringReference builderStringReference, @Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
        this.definingClass = builderTypeReference;
        this.name = builderStringReference;
        this.proto = builderMethodProtoReference;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.definingClass.getType();
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.name.getString();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return this.proto.returnType.getType();
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public BuilderTypeList getParameterTypes() {
        return this.proto.parameterTypes;
    }
}
