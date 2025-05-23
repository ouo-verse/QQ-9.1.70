package com.tencent.ttpic.audio;

import android.util.Pair;
import com.tencent.ttpic.util.AudioFabbyUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum MicAudioAdjustManager {
    INSTANCE;

    private static final double BASE_DECIBEL = 65.0d;
    private static final int UPDATE_INTERVAL = 400;
    private static List<Pair<Float, Double>> mOffsetMap;
    private static List<Pair<Float, Double>> mScaleMap;
    private int mLastDecibel;
    private long mLastUpdateTime;
    private int mSumDecibel;
    private Queue<Integer> mRecentDbs = new LinkedList();
    private int mMeanDecibel = 65;

    MicAudioAdjustManager() {
    }

    public static MicAudioAdjustManager getInstance() {
        initOffsetScaleMap();
        return INSTANCE;
    }

    private static void initOffsetScaleMap() {
        mOffsetMap = new ArrayList();
        mScaleMap = new ArrayList();
        List<Pair<Float, Double>> list = mOffsetMap;
        Float valueOf = Float.valueOf(0.0f);
        list.add(Pair.create(valueOf, Double.valueOf(BASE_DECIBEL)));
        List<Pair<Float, Double>> list2 = mOffsetMap;
        Float valueOf2 = Float.valueOf(120.0f);
        list2.add(Pair.create(valueOf2, Double.valueOf(-55.0d)));
        List<Pair<Float, Double>> list3 = mScaleMap;
        Double valueOf3 = Double.valueOf(1.0d);
        list3.add(Pair.create(valueOf, valueOf3));
        mScaleMap.add(Pair.create(Float.valueOf(65.0f), valueOf3));
        mScaleMap.add(Pair.create(valueOf2, valueOf3));
    }

    public int adjustDecibel(int i3) {
        double d16;
        List<Pair<Float, Double>> list = mOffsetMap;
        double d17 = 0.0d;
        if (list != null) {
            d16 = AudioFabbyUtil.getRangeValue(0, this.mMeanDecibel, list, 0.0d);
        } else {
            d16 = 0.0d;
        }
        List<Pair<Float, Double>> list2 = mScaleMap;
        if (list2 != null) {
            d17 = AudioFabbyUtil.getRangeValue(0, this.mMeanDecibel, list2, 1.0d);
        }
        return (int) (((i3 - r0) * d17) + this.mMeanDecibel + d16);
    }

    public void setMicDecibel(int i3) {
        if (this.mLastDecibel != i3) {
            this.mRecentDbs.offer(Integer.valueOf(i3));
            this.mSumDecibel += i3;
            while (this.mRecentDbs.size() > 10) {
                this.mSumDecibel -= this.mRecentDbs.poll().intValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastUpdateTime >= 400) {
                this.mMeanDecibel = this.mSumDecibel / Math.max(this.mRecentDbs.size(), 1);
                this.mLastUpdateTime = currentTimeMillis;
            }
            this.mLastDecibel = i3;
        }
    }
}
