package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseMethodParameter;

/* loaded from: classes29.dex */
public class BuilderMethodParameter extends BaseMethodParameter {

    @Nonnull
    final BuilderAnnotationSet annotations;

    @Nullable
    final BuilderStringReference name;

    @Nonnull
    final BuilderTypeReference type;

    public BuilderMethodParameter(@Nonnull BuilderTypeReference builderTypeReference, @Nullable BuilderStringReference builderStringReference, @Nonnull BuilderAnnotationSet builderAnnotationSet) {
        this.type = builderTypeReference;
        this.name = builderStringReference;
        this.annotations = builderAnnotationSet;
    }

    @Override // org.jf.dexlib2.iface.MethodParameter, org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getName() {
        BuilderStringReference builderStringReference = this.name;
        if (builderStringReference == null) {
            return null;
        }
        return builderStringReference.getString();
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.type.getType();
    }

    @Override // org.jf.dexlib2.iface.MethodParameter
    @Nonnull
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }
}
