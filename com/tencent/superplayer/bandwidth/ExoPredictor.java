package com.tencent.superplayer.bandwidth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class ExoPredictor extends AbstractPredictor {
    public static final int DEFAULT_MAX_WEIGHT = 500;
    private static final int MIN_AVG_SAMPLE = 20;
    private int currentWeight;
    private final MoveAvgPredictor mAvgPredictor;
    private final float weightFactor;
    private final ArrayList<Long> samples = new ArrayList<>();
    private int maxWeight = 500;

    public ExoPredictor(float f16) {
        this.weightFactor = f16;
        MoveAvgPredictor moveAvgPredictor = new MoveAvgPredictor((int) f16, 20);
        this.mAvgPredictor = moveAvgPredictor;
        addChildPredictor(moveAvgPredictor);
    }

    private void resetMaxWeight() {
        int sqrt;
        if (this.mAvgPredictor.samples.size() >= 3 && (sqrt = (int) (Math.sqrt(this.mAvgPredictor.prediction) * this.weightFactor)) > 0) {
            this.maxWeight = sqrt;
        }
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void onIdle() {
        resetMaxWeight();
        super.onIdle();
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public long onSample(long j3) {
        long longValue;
        double sqrt = Math.sqrt(j3);
        while (this.currentWeight + sqrt > this.maxWeight && this.samples.size() > 0) {
            this.currentWeight = (int) (this.currentWeight - Math.sqrt(this.samples.remove(0).longValue()));
        }
        this.samples.add(Long.valueOf(j3));
        this.currentWeight = (int) (this.currentWeight + sqrt);
        int i3 = this.maxWeight / 2;
        List list = (List) this.samples.clone();
        Collections.sort(list);
        if (this.currentWeight > i3) {
            Iterator it = list.iterator();
            longValue = 0;
            long j16 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Long l3 = (Long) it.next();
                j16 = (long) (j16 + Math.sqrt(l3.longValue()));
                if (j16 > i3) {
                    longValue = l3.longValue();
                    break;
                }
            }
        } else {
            longValue = ((Long) list.get(list.size() - 1)).longValue();
        }
        if (this.samples.size() >= this.weightFactor) {
            resetMaxWeight();
        }
        return longValue;
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void reset() {
        super.reset();
        this.samples.clear();
        this.currentWeight = 0;
    }

    public String toString() {
        return "ExoPredictor(" + this.maxWeight + ')';
    }
}
