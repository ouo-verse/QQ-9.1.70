package org.jf.dexlib2.immutable.debug;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.debug.EpilogueBegin;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableEpilogueBegin extends ImmutableDebugItem implements EpilogueBegin {
    public ImmutableEpilogueBegin(int i3) {
        super(i3);
    }

    @Nonnull
    public static ImmutableEpilogueBegin of(@Nonnull EpilogueBegin epilogueBegin) {
        if (epilogueBegin instanceof ImmutableEpilogueBegin) {
            return (ImmutableEpilogueBegin) epilogueBegin;
        }
        return new ImmutableEpilogueBegin(epilogueBegin.getCodeAddress());
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 8;
    }
}
