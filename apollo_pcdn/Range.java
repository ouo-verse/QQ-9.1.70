package apollo_pcdn;

import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes.dex */
public class Range {
    protected transient boolean pcdnCMemOwn;
    private transient long pcdnCPtr;

    public Range() {
        this(apollo_pcdnJNI.new_Range__PCDN_0(), true);
    }

    protected static long getCPtr(Range range) {
        if (range == null) {
            return 0L;
        }
        return range.pcdnCPtr;
    }

    public synchronized void delete() {
        long j3 = this.pcdnCPtr;
        if (j3 != 0) {
            if (this.pcdnCMemOwn) {
                this.pcdnCMemOwn = false;
                apollo_pcdnJNI.delete_Range(j3);
            }
            this.pcdnCPtr = 0L;
        }
    }

    protected void finalize() {
        delete();
    }

    public BigInteger getRange_end() {
        return apollo_pcdnJNI.Range_range_end_get(this.pcdnCPtr, this);
    }

    public BigInteger getRange_start() {
        return apollo_pcdnJNI.Range_range_start_get(this.pcdnCPtr, this);
    }

    public void setRange_end(BigInteger bigInteger) {
        apollo_pcdnJNI.Range_range_end_set(this.pcdnCPtr, this, bigInteger);
    }

    public void setRange_start(BigInteger bigInteger) {
        apollo_pcdnJNI.Range_range_start_set(this.pcdnCPtr, this, bigInteger);
    }

    protected Range(long j3, boolean z16) {
        this.pcdnCMemOwn = z16;
        this.pcdnCPtr = j3;
    }

    public Range(BigInteger bigInteger, BigInteger bigInteger2) {
        this(apollo_pcdnJNI.new_Range__PCDN_1(bigInteger, bigInteger2), true);
    }
}
