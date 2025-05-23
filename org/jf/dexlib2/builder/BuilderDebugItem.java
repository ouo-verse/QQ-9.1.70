package org.jf.dexlib2.builder;

import org.jf.dexlib2.iface.debug.DebugItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BuilderDebugItem extends ItemWithLocation implements DebugItem {
    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getCodeAddress() {
        MethodLocation methodLocation = this.location;
        if (methodLocation != null) {
            return methodLocation.getCodeAddress();
        }
        throw new IllegalStateException("Cannot get the address of a BuilderDebugItem that isn't associated with a method.");
    }
}
