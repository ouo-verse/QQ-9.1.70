package org.jf.dexlib2.immutable.debug;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseStringReference;
import org.jf.dexlib2.iface.debug.SetSourceFile;
import org.jf.dexlib2.iface.reference.StringReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableSetSourceFile extends ImmutableDebugItem implements SetSourceFile {

    @Nullable
    protected final String sourceFile;

    public ImmutableSetSourceFile(int i3, @Nullable String str) {
        super(i3);
        this.sourceFile = str;
    }

    @Nonnull
    public static ImmutableSetSourceFile of(@Nonnull SetSourceFile setSourceFile) {
        if (setSourceFile instanceof ImmutableSetSourceFile) {
            return (ImmutableSetSourceFile) setSourceFile;
        }
        return new ImmutableSetSourceFile(setSourceFile.getCodeAddress(), setSourceFile.getSourceFile());
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 9;
    }

    @Override // org.jf.dexlib2.iface.debug.SetSourceFile
    @Nullable
    public String getSourceFile() {
        return this.sourceFile;
    }

    @Override // org.jf.dexlib2.iface.debug.SetSourceFile
    @Nullable
    public StringReference getSourceFileReference() {
        if (this.sourceFile == null) {
            return null;
        }
        return new BaseStringReference() { // from class: org.jf.dexlib2.immutable.debug.ImmutableSetSourceFile.1
            @Override // org.jf.dexlib2.iface.reference.StringReference
            @Nonnull
            public String getString() {
                return ImmutableSetSourceFile.this.sourceFile;
            }
        };
    }
}
