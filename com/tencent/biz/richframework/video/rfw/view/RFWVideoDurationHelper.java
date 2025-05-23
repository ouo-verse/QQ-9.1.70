package com.tencent.biz.richframework.video.rfw.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoDurationHelper {
    private static volatile RFWVideoDurationHelper sHelper;
    private final HashMap<String, Map<Long, PlaySection>> mDurationMap = new HashMap<>();
    private final HashMap<String, Long> mCurPosMap = new HashMap<>();
    private boolean mEnable = false;
    private final List<VideoDurationUpdateListener> mVideoDurationUpdateListeners = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class PlaySection {
        private long end;
        private float playRate;
        private long start;

        public PlaySection(long j3, long j16, float f16) {
            this.start = j3;
            this.end = j16;
            this.playRate = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface VideoDurationUpdateListener {
        void onDurationUpdate(long j3);
    }

    private long computeTotalDuration() {
        Iterator<Map<Long, PlaySection>> it = this.mDurationMap.values().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            for (PlaySection playSection : it.next().values()) {
                if (playSection.end > playSection.start && playSection.playRate != 0.0f) {
                    j3 = ((float) j3) + (((float) (playSection.end - playSection.start)) / playSection.playRate);
                }
            }
        }
        return j3;
    }

    private boolean filterFrequentlyRecord(String str, long j3, boolean z16, float f16) {
        if (z16) {
            return false;
        }
        Long l3 = this.mCurPosMap.get(str);
        if (l3 != null && l3.longValue() > 0 && ((float) Math.abs(j3 - l3.longValue())) <= f16 * 1000.0f) {
            return true;
        }
        this.mCurPosMap.put(str, Long.valueOf(j3));
        return false;
    }

    public static RFWVideoDurationHelper g() {
        if (sHelper == null) {
            synchronized (RFWVideoDurationHelper.class) {
                if (sHelper == null) {
                    sHelper = new RFWVideoDurationHelper();
                }
            }
        }
        return sHelper;
    }

    private boolean updateDurationEnd(Map<Long, PlaySection> map, long j3, boolean z16, float f16) {
        boolean z17;
        Iterator<Map.Entry<Long, PlaySection>> it = map.entrySet().iterator();
        PlaySection playSection = null;
        while (true) {
            if (it.hasNext()) {
                PlaySection value = it.next().getValue();
                if (j3 >= value.start && j3 <= value.end) {
                    z17 = false;
                    break;
                }
                if (j3 > value.end && (playSection == null || value.end > playSection.end)) {
                    playSection = value;
                }
            } else {
                z17 = true;
                break;
            }
        }
        if (z17) {
            if (playSection != null && !z16 && playSection.playRate == f16) {
                playSection.end = j3;
            } else {
                playSection = new PlaySection(j3, j3, f16);
            }
            map.put(Long.valueOf(playSection.start), playSection);
        }
        return z17;
    }

    public void disable() {
        this.mEnable = false;
    }

    public void enable() {
        this.mEnable = true;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void recordDuration(String str, long j3, long j16, boolean z16, float f16) {
        if (!isEnable() || filterFrequentlyRecord(str, j3, z16, f16) || j3 > j16) {
            return;
        }
        Map<Long, PlaySection> map = this.mDurationMap.get(str);
        if (map == null) {
            TreeMap treeMap = new TreeMap();
            PlaySection playSection = new PlaySection(j3, j3, f16);
            treeMap.put(Long.valueOf(playSection.start), playSection);
            this.mDurationMap.put(str, treeMap);
            return;
        }
        if (updateDurationEnd(map, j3, z16, f16)) {
            Iterator<VideoDurationUpdateListener> it = this.mVideoDurationUpdateListeners.iterator();
            while (it.hasNext()) {
                it.next().onDurationUpdate(computeTotalDuration());
            }
        }
    }

    public void registerVideoDurationUpdateListener(VideoDurationUpdateListener videoDurationUpdateListener) {
        if (this.mVideoDurationUpdateListeners.contains(videoDurationUpdateListener)) {
            return;
        }
        this.mVideoDurationUpdateListeners.add(videoDurationUpdateListener);
    }

    public void reset() {
        this.mDurationMap.clear();
        this.mCurPosMap.clear();
    }

    public void unRegisterVideoDurationUpdateListener(VideoDurationUpdateListener videoDurationUpdateListener) {
        if (!this.mVideoDurationUpdateListeners.contains(videoDurationUpdateListener)) {
            return;
        }
        this.mVideoDurationUpdateListeners.remove(videoDurationUpdateListener);
    }
}
