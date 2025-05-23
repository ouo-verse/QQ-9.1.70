package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class SnapshotResult {
    private static final /* synthetic */ SnapshotResult[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SnapshotResult INCREAMENT_UPDATE;
    public static final SnapshotResult NO_UPDATE;
    public static final SnapshotResult PAGING_FETCH;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SnapshotResult snapshotResult = new SnapshotResult("PAGING_FETCH", 0);
        PAGING_FETCH = snapshotResult;
        SnapshotResult snapshotResult2 = new SnapshotResult("NO_UPDATE", 1);
        NO_UPDATE = snapshotResult2;
        SnapshotResult snapshotResult3 = new SnapshotResult("INCREAMENT_UPDATE", 2);
        INCREAMENT_UPDATE = snapshotResult3;
        $VALUES = new SnapshotResult[]{snapshotResult, snapshotResult2, snapshotResult3};
    }

    SnapshotResult(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static SnapshotResult valueOf(String str) {
        return (SnapshotResult) Enum.valueOf(SnapshotResult.class, str);
    }

    public static SnapshotResult[] values() {
        return (SnapshotResult[]) $VALUES.clone();
    }
}
