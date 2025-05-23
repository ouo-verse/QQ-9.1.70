package org.jf.dexlib2.builder.debug;

import org.jf.dexlib2.builder.BuilderDebugItem;
import org.jf.dexlib2.iface.debug.LineNumber;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderLineNumber extends BuilderDebugItem implements LineNumber {
    private final int lineNumber;

    public BuilderLineNumber(int i3) {
        this.lineNumber = i3;
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
