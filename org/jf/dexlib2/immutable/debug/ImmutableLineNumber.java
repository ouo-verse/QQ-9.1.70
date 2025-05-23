package org.jf.dexlib2.immutable.debug;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.debug.LineNumber;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableLineNumber extends ImmutableDebugItem implements LineNumber {
    protected final int lineNumber;

    public ImmutableLineNumber(int i3, int i16) {
        super(i3);
        this.lineNumber = i16;
    }

    @Nonnull
    public static ImmutableLineNumber of(@Nonnull LineNumber lineNumber) {
        if (lineNumber instanceof ImmutableLineNumber) {
            return (ImmutableLineNumber) lineNumber;
        }
        return new ImmutableLineNumber(lineNumber.getCodeAddress(), lineNumber.getLineNumber());
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 10;
    }

    @Override // org.jf.dexlib2.iface.debug.LineNumber
    public int getLineNumber() {
        return this.lineNumber;
    }
}
