package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseStringReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderStringReference extends BaseStringReference implements BuilderReference {
    int index = -1;

    @Nonnull
    final String string;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderStringReference(@Nonnull String str) {
        this.string = str;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.StringReference
    @Nonnull
    public String getString() {
        return this.string;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }
}
