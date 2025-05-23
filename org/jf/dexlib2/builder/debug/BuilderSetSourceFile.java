package org.jf.dexlib2.builder.debug;

import javax.annotation.Nullable;
import org.jf.dexlib2.builder.BuilderDebugItem;
import org.jf.dexlib2.iface.debug.SetSourceFile;
import org.jf.dexlib2.iface.reference.StringReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderSetSourceFile extends BuilderDebugItem implements SetSourceFile {

    @Nullable
    private final StringReference sourceFile;

    public BuilderSetSourceFile(@Nullable StringReference stringReference) {
        this.sourceFile = stringReference;
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 9;
    }

    @Override // org.jf.dexlib2.iface.debug.SetSourceFile
    @Nullable
    public String getSourceFile() {
        StringReference stringReference = this.sourceFile;
        if (stringReference == null) {
            return null;
        }
        return stringReference.getString();
    }

    @Override // org.jf.dexlib2.iface.debug.SetSourceFile
    @Nullable
    public StringReference getSourceFileReference() {
        return this.sourceFile;
    }
}
