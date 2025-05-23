package org.apache.httpcore.pool;

import java.io.Serializable;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class PoolStats implements Serializable {
    private static final long serialVersionUID = -2807686144795228544L;
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int i3, int i16, int i17, int i18) {
        this.leased = i3;
        this.pending = i16;
        this.available = i17;
        this.max = i18;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getMax() {
        return this.max;
    }

    public int getPending() {
        return this.pending;
    }

    public String toString() {
        return "[leased: " + this.leased + "; pending: " + this.pending + "; available: " + this.available + "; max: " + this.max + "]";
    }
}
