package org.jf.dexlib2.builder.debug;

import javax.annotation.Nullable;
import org.jf.dexlib2.builder.BuilderDebugItem;
import org.jf.dexlib2.iface.debug.EndLocal;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderEndLocal extends BuilderDebugItem implements EndLocal {
    private final int register;

    public BuilderEndLocal(int i3) {
        this.register = i3;
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 5;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getName() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.debug.EndLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getSignature() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getType() {
        return null;
    }
}
