package androidx.fragment.app;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Landroidx/fragment/app/ArgusGlobalConfig;", "", "enableMonitor", "", "enableWriteDb", "enablePredict", "(ZZZ)V", "getEnableMonitor", "()Z", "setEnableMonitor", "(Z)V", "getEnablePredict", "setEnablePredict", "getEnableWriteDb", "setEnableWriteDb", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final /* data */ class ArgusGlobalConfig {
    private boolean enableMonitor;
    private boolean enablePredict;
    private boolean enableWriteDb;

    public ArgusGlobalConfig(boolean z16, boolean z17, boolean z18) {
        this.enableMonitor = z16;
        this.enableWriteDb = z17;
        this.enablePredict = z18;
    }

    public static /* synthetic */ ArgusGlobalConfig copy$default(ArgusGlobalConfig argusGlobalConfig, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = argusGlobalConfig.enableMonitor;
        }
        if ((i3 & 2) != 0) {
            z17 = argusGlobalConfig.enableWriteDb;
        }
        if ((i3 & 4) != 0) {
            z18 = argusGlobalConfig.enablePredict;
        }
        return argusGlobalConfig.copy(z16, z17, z18);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableMonitor() {
        return this.enableMonitor;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableWriteDb() {
        return this.enableWriteDb;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnablePredict() {
        return this.enablePredict;
    }

    @NotNull
    public final ArgusGlobalConfig copy(boolean enableMonitor, boolean enableWriteDb, boolean enablePredict) {
        return new ArgusGlobalConfig(enableMonitor, enableWriteDb, enablePredict);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ArgusGlobalConfig) {
                ArgusGlobalConfig argusGlobalConfig = (ArgusGlobalConfig) other;
                if (this.enableMonitor != argusGlobalConfig.enableMonitor || this.enableWriteDb != argusGlobalConfig.enableWriteDb || this.enablePredict != argusGlobalConfig.enablePredict) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getEnableMonitor() {
        return this.enableMonitor;
    }

    public final boolean getEnablePredict() {
        return this.enablePredict;
    }

    public final boolean getEnableWriteDb() {
        return this.enableWriteDb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.enableMonitor;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.enableWriteDb;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.enablePredict;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    public final void setEnableMonitor(boolean z16) {
        this.enableMonitor = z16;
    }

    public final void setEnablePredict(boolean z16) {
        this.enablePredict = z16;
    }

    public final void setEnableWriteDb(boolean z16) {
        this.enableWriteDb = z16;
    }

    @NotNull
    public String toString() {
        return "ArgusGlobalConfig(enableMonitor=" + this.enableMonitor + ", enableWriteDb=" + this.enableWriteDb + ", enablePredict=" + this.enablePredict + ")";
    }
}
