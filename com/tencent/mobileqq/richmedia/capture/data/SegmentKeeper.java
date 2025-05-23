package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SegmentKeeper implements Parcelable {
    public static final Parcelable.Creator<SegmentKeeper> CREATOR = new Parcelable.Creator<SegmentKeeper>() { // from class: com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SegmentKeeper createFromParcel(Parcel parcel) {
            return new SegmentKeeper(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SegmentKeeper[] newArray(int i3) {
            return new SegmentKeeper[i3];
        }
    };
    public static final String KEY_ADJUSTTIME_VALID = "adjusttime_valid";
    public static final String KEY_DURATION = "duration_ms";
    public static final String KEY_MODE = "mode";
    public static final String KEY_SEGMENT_END = "end_ms";
    public static final String KEY_SEGMENT_LIST = "segments";
    public static final String KEY_SEGMENT_START = "start_ms";
    public static final int MODE_LOOP = 1;
    public static final int MODE_NORMAL = 0;
    public static final String TAG = "SegmentKeeper";
    private static long mAdjustTime;
    private boolean mAdjustTimeValid;
    private boolean mCurIn;
    private boolean mDataLocked;
    private boolean mDisable;
    private long mDuration;
    private boolean mLastIn;
    private int mMode;
    private boolean mReverse;
    private List<Pair<Long, Long>> mSegmentRanges;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class SortComparator implements Comparator {
        SortComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Pair pair = (Pair) obj;
            Pair pair2 = (Pair) obj2;
            if (((Long) pair.first).longValue() > ((Long) pair2.first).longValue()) {
                return 1;
            }
            if (pair.first == pair2.first) {
                return 0;
            }
            return -1;
        }
    }

    public SegmentKeeper() {
        this.mMode = 1;
        this.mReverse = false;
        this.mDataLocked = false;
        this.mSegmentRanges = new LinkedList();
        this.mDuration = Long.MAX_VALUE;
        this.mAdjustTimeValid = true;
        this.mCurIn = false;
        this.mLastIn = false;
        this.mDisable = false;
    }

    public static void adjustTime(long j3) {
        mAdjustTime = j3;
    }

    private void sortList() {
        Collections.sort(this.mSegmentRanges, new SortComparator());
    }

    public void addSegment(long j3, long j16) {
        if (this.mDataLocked) {
            SLog.d(TAG, "addSegment, data is locked!!");
        } else {
            this.mSegmentRanges.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
        }
    }

    public void changeNormalMode(long j3) {
        SLog.d(TAG, "changeNomalMode begin:" + toString());
        if (this.mMode == 0) {
            return;
        }
        if (this.mSegmentRanges.size() == 0) {
            this.mDuration = j3;
            return;
        }
        if (j3 <= this.mDuration) {
            this.mDuration = j3;
            LinkedList linkedList = new LinkedList();
            for (Pair<Long, Long> pair : this.mSegmentRanges) {
                long longValue = ((Long) pair.first).longValue();
                long longValue2 = ((Long) pair.second).longValue();
                long j16 = this.mDuration;
                if (longValue < j16) {
                    if (longValue2 > j16) {
                        longValue2 = j16;
                    }
                    linkedList.add(new Pair(Long.valueOf(longValue), Long.valueOf(longValue2)));
                }
            }
            this.mSegmentRanges.clear();
            this.mSegmentRanges.addAll(linkedList);
            SLog.d(TAG, "changeNomalMode end:" + toString());
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        long j17 = j3 / this.mDuration;
        for (long j18 = 0; j18 < j17; j18++) {
            for (Iterator<Pair<Long, Long>> it = this.mSegmentRanges.iterator(); it.hasNext(); it = it) {
                Pair<Long, Long> next = it.next();
                linkedList2.add(new Pair(Long.valueOf(((Long) next.first).longValue() + (this.mDuration * j18)), Long.valueOf(((Long) next.second).longValue() + (this.mDuration * j18))));
            }
        }
        long j19 = j3 - (j17 * this.mDuration);
        if (j19 > 0) {
            for (Pair<Long, Long> pair2 : this.mSegmentRanges) {
                long longValue3 = ((Long) pair2.first).longValue();
                long longValue4 = ((Long) pair2.second).longValue();
                if (longValue4 <= j19) {
                    linkedList2.add(new Pair(Long.valueOf(longValue3), Long.valueOf(longValue4)));
                } else if (j19 <= longValue3) {
                    break;
                } else {
                    linkedList2.add(new Pair(Long.valueOf(longValue3), Long.valueOf(j19)));
                }
            }
        }
        this.mDuration = j3;
        this.mSegmentRanges.clear();
        this.mSegmentRanges.addAll(linkedList2);
        SLog.d(TAG, "changeNomalMode end:" + toString());
    }

    public void clearSegments() {
        if (this.mDataLocked) {
            SLog.d(TAG, "clearSegments, data is locked!!");
        } else {
            if (this.mSegmentRanges.size() == 0) {
                return;
            }
            this.mSegmentRanges.clear();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void disable(boolean z16) {
        this.mDisable = z16;
    }

    public void fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.mDataLocked) {
            SLog.d(TAG, "fromJSONObject , data is locked:");
            return;
        }
        try {
            this.mDuration = jSONObject.optLong(KEY_DURATION, Long.MAX_VALUE);
            this.mAdjustTimeValid = jSONObject.optBoolean(KEY_ADJUSTTIME_VALID, true);
            this.mMode = jSONObject.optInt("mode", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_SEGMENT_LIST);
            this.mSegmentRanges.clear();
            if (optJSONArray == null) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                this.mSegmentRanges.add(new Pair<>(Long.valueOf(jSONObject2.getLong(KEY_SEGMENT_START)), Long.valueOf(jSONObject2.getLong(KEY_SEGMENT_END))));
            }
        } catch (JSONException e16) {
            SLog.e(TAG, "FromJSONObject exception:" + e16.toString());
        }
    }

    public List<Pair<Long, Long>> getSegmentList() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.mSegmentRanges);
        return linkedList;
    }

    public void init(int i3, long j3, List<Pair<Long, Long>> list) {
        this.mMode = i3;
        this.mDuration = j3;
        setSegmentList(list);
    }

    public boolean isCurrentIn() {
        return this.mCurIn;
    }

    public boolean isDataLocked() {
        return this.mDataLocked;
    }

    public boolean isDisable() {
        return this.mDisable;
    }

    public boolean isEmpty() {
        if (this.mSegmentRanges.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isInSegment(long j3) {
        long j16;
        if (this.mDisable || isEmpty()) {
            return true;
        }
        if (this.mAdjustTimeValid) {
            j16 = mAdjustTime;
        } else {
            j16 = 0;
        }
        long j17 = j3 + j16;
        if (this.mMode == 1) {
            long j18 = this.mDuration;
            if (j17 > j18 && j18 > 0) {
                j17 %= j18;
            }
            SLog.d(TAG, "isInSegment time, loop mode, pos:" + j17);
        }
        if (this.mDuration < j17) {
            return false;
        }
        for (Pair<Long, Long> pair : this.mSegmentRanges) {
            if (j17 >= ((Long) pair.first).longValue() && j17 <= ((Long) pair.second).longValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSegmentChanged(long j3) {
        this.mLastIn = this.mCurIn;
        boolean isInSegment = isInSegment(j3);
        this.mCurIn = isInSegment;
        if (isInSegment != this.mLastIn) {
            return true;
        }
        return false;
    }

    public void lockData(boolean z16) {
        this.mDataLocked = z16;
    }

    public void removeLastSegment() {
        if (this.mDataLocked) {
            SLog.d(TAG, "removeLastSegment, data is locked!!");
            return;
        }
        if (this.mSegmentRanges.size() == 0) {
            return;
        }
        if (this.mMode == 1) {
            SLog.e(TAG, "removeLastSegment in loop moad!! segments:" + toString());
        }
        List<Pair<Long, Long>> list = this.mSegmentRanges;
        list.remove(list.size() - 1);
    }

    public void reverseSegments(boolean z16) {
        if (this.mReverse == z16) {
            return;
        }
        this.mReverse = z16;
        if (this.mSegmentRanges.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<Long, Long> pair : this.mSegmentRanges) {
            long longValue = ((Long) pair.first).longValue();
            long longValue2 = ((Long) pair.second).longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            long j3 = this.mDuration;
            if (longValue2 > j3) {
                longValue2 = j3;
            }
            if (longValue < longValue2) {
                arrayList.add(new Pair(Long.valueOf(this.mDuration - longValue2), Long.valueOf(this.mDuration - longValue)));
            }
        }
        this.mSegmentRanges.clear();
        this.mSegmentRanges.addAll(arrayList);
        SLog.d(TAG, "reverssegment:" + toString());
    }

    public void set(SegmentKeeper segmentKeeper) {
        if (segmentKeeper == null) {
            return;
        }
        this.mDuration = segmentKeeper.mDuration;
        mAdjustTime = mAdjustTime;
        this.mMode = segmentKeeper.mMode;
        this.mDisable = segmentKeeper.mDisable;
        this.mSegmentRanges.clear();
        this.mSegmentRanges.addAll(segmentKeeper.getSegmentList());
        this.mReverse = segmentKeeper.mReverse;
        this.mDataLocked = segmentKeeper.mDataLocked;
        this.mAdjustTimeValid = segmentKeeper.mAdjustTimeValid;
    }

    public void setAdjustTimeValid(boolean z16) {
        this.mAdjustTimeValid = z16;
    }

    public void setMode(int i3) {
        this.mMode = i3;
    }

    public void setSegmentList(List<Pair<Long, Long>> list) {
        if (this.mDataLocked) {
            SLog.e(TAG, "setSegmentList, data is locked!!");
            return;
        }
        this.mSegmentRanges.clear();
        if (list != null) {
            this.mSegmentRanges.addAll(list);
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_DURATION, this.mDuration);
            jSONObject.put(KEY_ADJUSTTIME_VALID, this.mAdjustTimeValid);
            jSONObject.put("mode", this.mMode);
            if (this.mSegmentRanges.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Pair<Long, Long> pair : this.mSegmentRanges) {
                    long longValue = ((Long) pair.first).longValue();
                    long longValue2 = ((Long) pair.second).longValue();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(KEY_SEGMENT_START, longValue);
                    jSONObject2.put(KEY_SEGMENT_END, longValue2);
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put(KEY_SEGMENT_LIST, jSONArray);
            }
        } catch (JSONException e16) {
            SLog.e(TAG, "toJSONObject exception:" + e16.toString());
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("segmode=[");
        sb5.append(this.mMode);
        sb5.append("]");
        sb5.append("adjusttimevalid=[");
        sb5.append(this.mAdjustTimeValid);
        sb5.append("]");
        sb5.append("duration=[");
        sb5.append(this.mDuration);
        sb5.append("]");
        sb5.append("disable=[");
        sb5.append(this.mDisable);
        sb5.append("]");
        sb5.append("reverse=[");
        sb5.append(this.mReverse);
        sb5.append("]");
        sb5.append("datalocked=[");
        sb5.append(this.mDataLocked);
        sb5.append("]");
        sb5.append("segments=");
        if (this.mSegmentRanges.size() > 0) {
            for (Pair<Long, Long> pair : this.mSegmentRanges) {
                sb5.append("[");
                sb5.append(pair.first);
                sb5.append("-");
                sb5.append(pair.second);
                sb5.append("]");
            }
        } else {
            sb5.append("[null]");
        }
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mMode);
        parcel.writeLong(this.mDuration);
        parcel.writeInt(this.mAdjustTimeValid ? 1 : 0);
        parcel.writeInt(this.mReverse ? 1 : 0);
        parcel.writeInt(this.mDataLocked ? 1 : 0);
        parcel.writeInt(this.mSegmentRanges.size());
        if (this.mSegmentRanges.size() > 0) {
            for (Pair<Long, Long> pair : this.mSegmentRanges) {
                parcel.writeLong(((Long) pair.first).longValue());
                parcel.writeLong(((Long) pair.second).longValue());
            }
        }
    }

    public void addSegment(Pair<Long, Long> pair) {
        if (pair == null) {
            return;
        }
        if (this.mDataLocked) {
            SLog.d(TAG, "addSegment, data is locked!!");
        } else {
            this.mSegmentRanges.add(new Pair<>(pair.first, pair.second));
        }
    }

    public void addSegment(List<Pair<Long, Long>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.mDataLocked) {
            SLog.d(TAG, "addSegment, data is locked!!");
            return;
        }
        Iterator<Pair<Long, Long>> it = list.iterator();
        while (it.hasNext()) {
            addSegment(it.next());
        }
    }

    public SegmentKeeper(SegmentKeeper segmentKeeper) {
        this.mMode = 1;
        this.mReverse = false;
        this.mDataLocked = false;
        this.mSegmentRanges = new LinkedList();
        this.mDuration = Long.MAX_VALUE;
        this.mAdjustTimeValid = true;
        this.mCurIn = false;
        this.mLastIn = false;
        this.mDisable = false;
        set(segmentKeeper);
    }

    public SegmentKeeper(Parcel parcel) {
        this.mMode = 1;
        this.mReverse = false;
        this.mDataLocked = false;
        this.mSegmentRanges = new LinkedList();
        this.mDuration = Long.MAX_VALUE;
        this.mAdjustTimeValid = true;
        this.mCurIn = false;
        this.mLastIn = false;
        this.mDisable = false;
        this.mMode = parcel.readInt();
        this.mDuration = parcel.readLong();
        this.mAdjustTimeValid = parcel.readInt() == 1;
        this.mReverse = parcel.readInt() == 1;
        this.mDataLocked = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        this.mSegmentRanges.clear();
        if (readInt > 0) {
            for (int i3 = 0; i3 < readInt; i3++) {
                this.mSegmentRanges.add(new Pair<>(Long.valueOf(parcel.readLong()), Long.valueOf(parcel.readLong())));
            }
        }
    }
}
