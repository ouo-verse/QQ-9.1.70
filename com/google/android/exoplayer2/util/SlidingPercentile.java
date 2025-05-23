package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class SlidingPercentile {
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private int totalWeight;
    private static final Comparator<Sample> INDEX_COMPARATOR = new Comparator<Sample>() { // from class: com.google.android.exoplayer2.util.SlidingPercentile.1
        @Override // java.util.Comparator
        public int compare(Sample sample, Sample sample2) {
            return sample.index - sample2.index;
        }
    };
    private static final Comparator<Sample> VALUE_COMPARATOR = new Comparator<Sample>() { // from class: com.google.android.exoplayer2.util.SlidingPercentile.2
        @Override // java.util.Comparator
        public int compare(Sample sample, Sample sample2) {
            float f16 = sample.value;
            float f17 = sample2.value;
            if (f16 < f17) {
                return -1;
            }
            return f17 < f16 ? 1 : 0;
        }
    };
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int currentSortOrder = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Sample {
        public int index;
        public float value;
        public int weight;

        Sample() {
        }
    }

    public SlidingPercentile(int i3) {
        this.maxWeight = i3;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    public void addSample(int i3, float f16) {
        Sample sample;
        ensureSortedByIndex();
        int i16 = this.recycledSampleCount;
        if (i16 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i17 = i16 - 1;
            this.recycledSampleCount = i17;
            sample = sampleArr[i17];
        } else {
            sample = new Sample();
        }
        int i18 = this.nextSampleIndex;
        this.nextSampleIndex = i18 + 1;
        sample.index = i18;
        sample.weight = i3;
        sample.value = f16;
        this.samples.add(sample);
        this.totalWeight += i3;
        while (true) {
            int i19 = this.totalWeight;
            int i26 = this.maxWeight;
            if (i19 > i26) {
                int i27 = i19 - i26;
                Sample sample2 = this.samples.get(0);
                int i28 = sample2.weight;
                if (i28 <= i27) {
                    this.totalWeight -= i28;
                    this.samples.remove(0);
                    int i29 = this.recycledSampleCount;
                    if (i29 < 5) {
                        Sample[] sampleArr2 = this.recycledSamples;
                        this.recycledSampleCount = i29 + 1;
                        sampleArr2[i29] = sample2;
                    }
                } else {
                    sample2.weight = i28 - i27;
                    this.totalWeight -= i27;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f16) {
        ensureSortedByValue();
        float f17 = f16 * this.totalWeight;
        int i3 = 0;
        for (int i16 = 0; i16 < this.samples.size(); i16++) {
            Sample sample = this.samples.get(i16);
            i3 += sample.weight;
            if (i3 >= f17) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        return this.samples.get(r5.size() - 1).value;
    }
}
