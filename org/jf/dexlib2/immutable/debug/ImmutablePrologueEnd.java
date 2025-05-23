package org.jf.dexlib2.immutable.debug;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.debug.PrologueEnd;

/* loaded from: classes29.dex */
public class ImmutablePrologueEnd extends ImmutableDebugItem implements PrologueEnd {
    public ImmutablePrologueEnd(int i3) {
        super(i3);
    }

    @Nonnull
    public static ImmutablePrologueEnd of(@Nonnull PrologueEnd prologueEnd) {
        if (prologueEnd instanceof ImmutablePrologueEnd) {
            return (ImmutablePrologueEnd) prologueEnd;
        }
        return new ImmutablePrologueEnd(prologueEnd.getCodeAddress());
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 7;
    }
}
