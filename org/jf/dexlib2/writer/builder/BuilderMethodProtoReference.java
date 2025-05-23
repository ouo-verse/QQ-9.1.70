package org.jf.dexlib2.writer.builder;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodProtoReference;

/* loaded from: classes29.dex */
public class BuilderMethodProtoReference extends BaseMethodProtoReference implements BuilderReference {
    int index = -1;

    @Nonnull
    final BuilderTypeList parameterTypes;

    @Nonnull
    final BuilderTypeReference returnType;

    @Nonnull
    final BuilderStringReference shorty;

    public BuilderMethodProtoReference(@Nonnull BuilderStringReference builderStringReference, @Nonnull BuilderTypeList builderTypeList, @Nonnull BuilderTypeReference builderTypeReference) {
        this.shorty = builderStringReference;
        this.parameterTypes = builderTypeList;
        this.returnType = builderTypeReference;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    @Nonnull
    public List<? extends CharSequence> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    @Nonnull
    public String getReturnType() {
        return this.returnType.getType();
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }
}
