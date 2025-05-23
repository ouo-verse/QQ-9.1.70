package org.jf.dexlib2.immutable.debug;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.debug.RestartLocal;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableRestartLocal extends ImmutableDebugItem implements RestartLocal {

    @Nullable
    protected final String name;
    protected final int register;

    @Nullable
    protected final String signature;

    @Nullable
    protected final String type;

    public ImmutableRestartLocal(int i3, int i16) {
        super(i3);
        this.register = i16;
        this.name = null;
        this.type = null;
        this.signature = null;
    }

    @Nonnull
    public static ImmutableRestartLocal of(@Nonnull RestartLocal restartLocal) {
        if (restartLocal instanceof ImmutableRestartLocal) {
            return (ImmutableRestartLocal) restartLocal;
        }
        return new ImmutableRestartLocal(restartLocal.getCodeAddress(), restartLocal.getRegister(), restartLocal.getType(), restartLocal.getName(), restartLocal.getSignature());
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 6;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.iface.debug.RestartLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getSignature() {
        return this.signature;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getType() {
        return this.type;
    }

    public ImmutableRestartLocal(int i3, int i16, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(i3);
        this.register = i16;
        this.name = str;
        this.type = str2;
        this.signature = str3;
    }
}
