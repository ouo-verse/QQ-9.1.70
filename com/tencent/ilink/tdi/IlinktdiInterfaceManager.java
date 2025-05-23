package com.tencent.ilink.tdi;

import com.tencent.ilink.tdi.manager.TdiManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ilink/tdi/IlinktdiInterfaceManager;", "", "ilinkAppid", "", "(Ljava/lang/String;)V", "handle", "", "getHandle", "()J", "setHandle", "(J)V", "tdiManager", "Lcom/tencent/ilink/tdi/manager/TdiManager;", "getTdiManager", "()Lcom/tencent/ilink/tdi/manager/TdiManager;", "setTdiManager", "(Lcom/tencent/ilink/tdi/manager/TdiManager;)V", "destroy", "", "tdi-android-lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class IlinktdiInterfaceManager {
    private long handle;

    @NotNull
    private TdiManager tdiManager;

    public IlinktdiInterfaceManager(@NotNull String ilinkAppid) {
        Intrinsics.checkNotNullParameter(ilinkAppid, "ilinkAppid");
        long aa5 = TdiManagerJniInterface.INSTANCE.aa(ilinkAppid);
        this.handle = aa5;
        TdiManagerJniCallback.registerInstance(aa5, this);
        this.tdiManager = new TdiManager(this.handle);
    }

    public final void destroy() {
        TdiManagerJniCallback.unregisterInstance(this.handle);
        TdiManagerJniInterface.INSTANCE.ab(this.handle);
    }

    public final long getHandle() {
        return this.handle;
    }

    @NotNull
    public final TdiManager getTdiManager() {
        return this.tdiManager;
    }

    public final void setHandle(long j3) {
        this.handle = j3;
    }

    public final void setTdiManager(@NotNull TdiManager tdiManager) {
        Intrinsics.checkNotNullParameter(tdiManager, "<set-?>");
        this.tdiManager = tdiManager;
    }
}
