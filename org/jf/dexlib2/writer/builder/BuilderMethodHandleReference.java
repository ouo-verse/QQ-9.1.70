package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodHandleReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderMethodHandleReference extends BaseMethodHandleReference implements BuilderReference {
    int index = -1;

    @Nonnull
    final BuilderReference memberReference;
    final int methodHandleType;

    public BuilderMethodHandleReference(int i3, @Nonnull BuilderReference builderReference) {
        this.methodHandleType = i3;
        this.memberReference = builderReference;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    public int getMethodHandleType() {
        return this.methodHandleType;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    @Nonnull
    public BuilderReference getMemberReference() {
        return this.memberReference;
    }
}
