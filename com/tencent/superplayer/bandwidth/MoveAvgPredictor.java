package com.tencent.superplayer.bandwidth;

import com.tencent.superplayer.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class MoveAvgPredictor extends AbstractPredictor {
    private final int maxSize;
    private final int minSample;
    final ArrayList<Long> samples;

    public MoveAvgPredictor(int i3) {
        this(i3, 0);
    }

    public final int getSampleSize() {
        return this.samples.size();
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void onIdle() {
        super.onIdle();
        this.samples.clear();
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public long onSample(long j3) {
        LogUtil.d("MoveAvgPredictor", this + " onSample: bandwidth=" + j3 + "kb/s");
        if (this.samples.size() >= this.maxSize && this.samples.size() > 0) {
            this.samples.remove(0);
        }
        if (j3 > this.minSample) {
            this.samples.add(Long.valueOf(j3));
        }
        long j16 = 0;
        if (this.samples.size() <= 0) {
            return 0L;
        }
        Iterator<Long> it = this.samples.iterator();
        while (it.hasNext()) {
            j16 += it.next().longValue();
        }
        return j16 / this.samples.size();
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void reset() {
        super.reset();
        this.samples.clear();
    }

    public String toString() {
        return "MoveAvgPredictor(" + this.maxSize + ')';
    }

    public MoveAvgPredictor(int i3, int i16) {
        this.maxSize = i3;
        this.samples = new ArrayList<>();
        this.minSample = i16;
    }
}
