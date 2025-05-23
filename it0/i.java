package it0;

/* compiled from: P */
/* loaded from: classes38.dex */
public final /* synthetic */ class i {
    public static /* synthetic */ long a(long j3, long j16) {
        if (j16 < 0) {
            return (j3 ^ Long.MIN_VALUE) < (j16 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j3 >= 0) {
            return j3 / j16;
        }
        long j17 = ((j3 >>> 1) / j16) << 1;
        return j17 + (((j3 - (j17 * j16)) ^ Long.MIN_VALUE) < (j16 ^ Long.MIN_VALUE) ? 0 : 1);
    }
}
