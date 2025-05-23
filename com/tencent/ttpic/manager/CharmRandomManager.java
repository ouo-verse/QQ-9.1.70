package com.tencent.ttpic.manager;

import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CharmRandomManager {
    public static final int ALWAYS_TRIGGERED_RANDOM_INDEX = 0;
    public static final int HAND_RANDOM_INDEX = 0;
    private static final CharmRandomManager INSTANCE = new CharmRandomManager();
    private static final Random mRandom = new Random(System.currentTimeMillis());
    private boolean isUpdateFaceCharm;
    private boolean isUpdateHandCharm;
    private Map<Integer, Double> mCharmValueMap = new HashMap();
    private Map<Integer, Double> mHandsValueMap = new HashMap();

    CharmRandomManager() {
        clearAll();
    }

    public static CharmRandomManager getInstance() {
        return INSTANCE;
    }

    public void clearAll() {
        this.mCharmValueMap.clear();
        this.mHandsValueMap.clear();
    }

    public void clearFaceRandoms() {
        this.mCharmValueMap.clear();
    }

    public void clearHandRandoms() {
        this.mHandsValueMap.clear();
    }

    public boolean constainsFaceCharm(int i3) {
        return this.mCharmValueMap.containsKey(Integer.valueOf(i3));
    }

    public boolean containsHandCharm(int i3) {
        return this.mHandsValueMap.containsKey(Integer.valueOf(i3));
    }

    public double getFaceCharmValue(int i3) {
        return this.mCharmValueMap.get(Integer.valueOf(i3)).doubleValue();
    }

    public double getHandCharmValue() {
        return this.mHandsValueMap.get(0).doubleValue();
    }

    public void removeCharmRange(int i3) {
        this.mCharmValueMap.remove(Integer.valueOf(i3));
    }

    public void updateCharmValue(List<Integer> list, boolean z16) {
        double doubleValue;
        if ((!CollectionUtils.isEmpty(list) && !this.mCharmValueMap.containsKey(list.get(0))) || (z16 && !this.mHandsValueMap.containsKey(0))) {
            if (this.isUpdateHandCharm) {
                if (z16 && !this.mHandsValueMap.containsKey(0)) {
                    doubleValue = mRandom.nextDouble();
                } else {
                    if (this.mHandsValueMap.containsKey(0)) {
                        doubleValue = this.mHandsValueMap.get(0).doubleValue();
                    }
                    doubleValue = -1.0d;
                }
            } else {
                if (this.isUpdateFaceCharm) {
                    if (!CollectionUtils.isEmpty(list) && !this.mCharmValueMap.containsKey(list.get(0))) {
                        doubleValue = mRandom.nextDouble();
                    } else if (!CollectionUtils.isEmpty(list) && this.mCharmValueMap.containsKey(list.get(0))) {
                        doubleValue = this.mCharmValueMap.get(list.get(0)).doubleValue();
                    }
                }
                doubleValue = -1.0d;
            }
        } else if (!CollectionUtils.isEmpty(list) && this.mCharmValueMap.containsKey(list.get(0))) {
            doubleValue = this.mCharmValueMap.get(list.get(0)).doubleValue();
        } else {
            if (this.mHandsValueMap.containsKey(0)) {
                doubleValue = this.mHandsValueMap.get(0).doubleValue();
            }
            doubleValue = -1.0d;
        }
        if (doubleValue < 0.0d) {
            doubleValue = mRandom.nextDouble();
        }
        if (!CollectionUtils.isEmpty(list)) {
            this.mCharmValueMap.put(Integer.valueOf(list.get(0).intValue()), Double.valueOf(doubleValue));
            for (int i3 = 1; i3 < list.size(); i3++) {
                if (!this.mCharmValueMap.containsKey(Integer.valueOf(list.get(i3).intValue()))) {
                    this.mCharmValueMap.put(list.get(i3), Double.valueOf(mRandom.nextDouble()));
                }
            }
        }
        if (z16) {
            this.mHandsValueMap.put(0, Double.valueOf(doubleValue));
        }
    }

    public void updateCharmValueForCosFunGroup(List<Integer> list, double d16, boolean z16) {
        if (z16) {
            d16 = -1.0d;
        }
        this.mCharmValueMap.put(0, Double.valueOf(d16));
        if (list != null) {
            for (int i3 = 1; i3 < list.size(); i3++) {
                if (!this.mCharmValueMap.containsKey(Integer.valueOf(list.get(i3).intValue()))) {
                    this.mCharmValueMap.put(list.get(i3), Double.valueOf(d16));
                }
            }
        }
        this.mHandsValueMap.put(0, Double.valueOf(d16));
    }

    public void updateUpdateMode(boolean z16, boolean z17) {
        this.isUpdateFaceCharm = z16;
        this.isUpdateHandCharm = z17;
    }
}
