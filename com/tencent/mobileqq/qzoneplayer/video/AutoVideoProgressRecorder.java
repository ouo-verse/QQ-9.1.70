package com.tencent.mobileqq.qzoneplayer.video;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes35.dex */
public class AutoVideoProgressRecorder {
    private static AutoVideoProgressRecorder sInstance;
    private ConcurrentHashMap<String, VideoPlayInfoHolder> mRecordMap;
    private ConcurrentHashMap<String, q> mSceneRecordMap;
    private ConcurrentHashMap<String, VideoPlayInfoHolder> mSecondaryRecordMap;
    private final String TAG = "AutoVideoProgressRecorder";
    private final long defaultAdvanceTimestamp = 500;
    private long advanceTimestamp = 500;

    AutoVideoProgressRecorder() {
    }

    public static AutoVideoProgressRecorder getInstance() {
        if (sInstance == null) {
            AutoVideoProgressRecorder autoVideoProgressRecorder = new AutoVideoProgressRecorder();
            sInstance = autoVideoProgressRecorder;
            autoVideoProgressRecorder.mRecordMap = new ConcurrentHashMap<>();
            sInstance.mSecondaryRecordMap = new ConcurrentHashMap<>();
            sInstance.mSceneRecordMap = new ConcurrentHashMap<>();
        }
        return sInstance;
    }

    public void clearAllRecords() {
        ConcurrentHashMap<String, VideoPlayInfoHolder> concurrentHashMap = this.mRecordMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mRecordMap = new ConcurrentHashMap<>();
        }
    }

    public void clearAllSecondaryRecords() {
        ConcurrentHashMap<String, VideoPlayInfoHolder> concurrentHashMap = this.mSecondaryRecordMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mSecondaryRecordMap = new ConcurrentHashMap<>();
        }
    }

    public synchronized boolean clearRecord(String str) {
        if (this.mRecordMap == null || TextUtils.isEmpty(str) || !this.mRecordMap.containsKey(str)) {
            return false;
        }
        this.mRecordMap.remove(str);
        return true;
    }

    public q getPlayVideoSceneRecord(String str) {
        if (this.mSceneRecordMap == null || str == null || TextUtils.isEmpty(str) || !this.mSceneRecordMap.containsKey(str)) {
            return null;
        }
        return this.mSceneRecordMap.get(str);
    }

    public VideoPlayInfoHolder getVideoProgressRecord(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.contains(VideoPlayInfo.PasterVidLabel)) {
            ConcurrentHashMap<String, VideoPlayInfoHolder> concurrentHashMap = this.mRecordMap;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                VideoPlayInfoHolder shallowCopy = VideoPlayInfoHolder.shallowCopy(this.mRecordMap.get(str));
                if (shallowCopy != null) {
                    long j3 = shallowCopy.currentPositionMills;
                    long j16 = this.advanceTimestamp;
                    if (j3 >= j16) {
                        long j17 = j3 - j16;
                        shallowCopy.currentPositionMills = j17;
                        shallowCopy.currentPositionSec = Math.round((j17 * 1.0d) / 1000.0d);
                    } else {
                        shallowCopy.currentPositionMills = 0L;
                        shallowCopy.currentPositionSec = 0L;
                    }
                }
                return shallowCopy;
            }
        } else {
            ConcurrentHashMap<String, VideoPlayInfoHolder> concurrentHashMap2 = this.mSecondaryRecordMap;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str)) {
                VideoPlayInfoHolder shallowCopy2 = VideoPlayInfoHolder.shallowCopy(this.mSecondaryRecordMap.get(str));
                if (shallowCopy2 != null) {
                    long j18 = shallowCopy2.currentPositionMills;
                    long j19 = this.advanceTimestamp;
                    if (j18 >= j19) {
                        long j26 = j18 - j19;
                        shallowCopy2.currentPositionMills = j26;
                        shallowCopy2.currentPositionSec = Math.round((j26 * 1.0d) / 1000.0d);
                    } else {
                        shallowCopy2.currentPositionMills = 0L;
                        shallowCopy2.currentPositionSec = 0L;
                    }
                }
                return shallowCopy2;
            }
        }
        return null;
    }

    public boolean putPlayVideoSceneRecord(String str, q qVar) {
        if (this.mSceneRecordMap == null) {
            return false;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        this.mSceneRecordMap.put(str, qVar);
        return true;
    }

    public boolean putVideoProgerssRecord(String str, VideoPlayInfoHolder videoPlayInfoHolder) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains(VideoPlayInfo.PasterVidLabel)) {
            ConcurrentHashMap<String, VideoPlayInfoHolder> concurrentHashMap = this.mRecordMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, VideoPlayInfoHolder.shallowCopy(videoPlayInfoHolder));
                return true;
            }
        } else {
            ConcurrentHashMap<String, VideoPlayInfoHolder> concurrentHashMap2 = this.mSecondaryRecordMap;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.put(str, VideoPlayInfoHolder.shallowCopy(videoPlayInfoHolder));
                return true;
            }
        }
        return false;
    }

    public void setAdvanceTimestamp(long j3) {
        this.advanceTimestamp = j3;
    }
}
