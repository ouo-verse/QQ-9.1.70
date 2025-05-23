package com.tencent.mm.vfs;

import android.os.CancellationSignal;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CancellationSignalCompat {
    private CancellationSignal signal = new CancellationSignal();
    private CancellationSignalBeforeJB signalBeforeJB;

    public void cancel() {
        this.signal.cancel();
    }

    public boolean isCanceled() {
        return this.signal.isCanceled();
    }

    public void throwIfCanceled() {
        if (!this.signal.isCanceled()) {
        } else {
            throw new OperationCanceledException();
        }
    }
}
