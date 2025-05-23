package com.tencent.ttpic.logic.watermark;

import android.media.AudioRecord;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FFTData {
    public static final int BUFFER_SIZE = AudioRecord.getMinBufferSize(44100, 1, 2);
    private static final int DEFAULT_SIZE = 1024;
    private static final int SAMPLE_RATE_IN_HZ = 44100;
    public int[] mFFTBuffer;
    public int mFFTFreqMax;
    public int mFFTSize;
    public int mFFTSum;

    public FFTData() {
        this.mFFTFreqMax = 22050;
        this.mFFTSum = 0;
        int i3 = BUFFER_SIZE;
        if (i3 > 0) {
            this.mFFTBuffer = new int[i3];
            this.mFFTSize = i3;
        } else {
            this.mFFTBuffer = new int[1024];
            this.mFFTSize = 1024;
        }
    }

    public FFTData(int i3) {
        this.mFFTFreqMax = 22050;
        this.mFFTSum = 0;
        if (i3 > 0) {
            this.mFFTBuffer = new int[i3];
            this.mFFTSize = i3;
        } else {
            this.mFFTBuffer = new int[1024];
            this.mFFTSize = 1024;
        }
    }

    public FFTData(int i3, int i16) {
        this.mFFTFreqMax = 22050;
        this.mFFTSum = 0;
        if (i3 > 0) {
            this.mFFTBuffer = new int[i3];
            this.mFFTSize = i3;
        } else {
            this.mFFTBuffer = new int[1024];
            this.mFFTSize = 1024;
        }
        this.mFFTFreqMax = i16;
    }
}
