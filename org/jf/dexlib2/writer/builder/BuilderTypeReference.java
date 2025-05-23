package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseTypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderTypeReference extends BaseTypeReference implements BuilderReference {
    int index = -1;

    @Nonnull
    final BuilderStringReference stringReference;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderTypeReference(@Nonnull BuilderStringReference builderStringReference) {
        this.stringReference = builderStringReference;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.stringReference.getString();
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }
}
