package com.tencent.oskplayer.model;

import android.text.TextUtils;
import com.tencent.oskplayer.model.VideoDecoderType;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SegmentVideoInfo {
    public static final int DEFAULT_VIDEO_RATE = 750;
    private static final String LOG_TAG = "SegmentVideoInfo";
    public static final int STREAM_TYPE_H265_NORMAL = 4;
    public static final int STREAM_TYPE_HIGNBR = 1;
    public static final int STREAM_TYPE_LOWBR = 2;
    public static final int STREAM_TYPE_NORMAL = 0;
    public static final int STREAM_TYPE_ORIGINAL = 3;
    private int currentStreamRate;
    private int defaultStreamRate;
    private HashMap<Integer, StreamInfo> streams;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class SegmentInfo {
        public int duration;
        public int offset;
        public String url;

        public SegmentInfo(String str, int i3, int i16) {
            this.url = str;
            this.offset = i3;
            this.duration = i16;
        }
    }

    public SegmentVideoInfo() {
        this(new HashMap());
    }

    public static int maxFloor(Set<Integer> set, int i3) {
        if (set != null && set.size() != 0) {
            int i16 = 0;
            for (Integer num : set) {
                if (num.intValue() > i16 && num.intValue() <= i3) {
                    i16 = num.intValue();
                }
            }
            if (i16 != 0) {
                return i16;
            }
            return i3;
        }
        return i3;
    }

    private void resetStreamTypeIfNeeded() {
        HashMap<Integer, StreamInfo> hashMap = this.streams;
        if (hashMap != null && hashMap.size() > 0) {
            int i3 = 0;
            for (Integer num : this.streams.keySet()) {
                if (num.intValue() > i3) {
                    i3 = num.intValue();
                }
            }
            if (i3 <= 4) {
                if (this.defaultStreamRate >= 750) {
                    this.defaultStreamRate = 0;
                }
                if (this.currentStreamRate >= 750) {
                    this.currentStreamRate = 0;
                }
            }
        }
    }

    public StreamInfo getCurrentStreamInfo() {
        resetStreamTypeIfNeeded();
        return getStreamInfo(this.currentStreamRate);
    }

    public int getCurrentStreamType() {
        resetStreamTypeIfNeeded();
        return this.currentStreamRate;
    }

    public StreamInfo getDefaultStreamInfo() {
        if (this.streams == null) {
            return null;
        }
        resetStreamTypeIfNeeded();
        return this.streams.get(Integer.valueOf(this.defaultStreamRate));
    }

    public String getDefaultUrl() {
        return getRealSegmentUrl(0, 0);
    }

    public String getRealSegmentUrl(int i3, int i16) {
        ArrayList<SegmentInfo> arrayList;
        SegmentInfo segmentInfo;
        StreamInfo streamInfo = getStreamInfo(i3);
        if (streamInfo == null || (arrayList = streamInfo.segmentInfos) == null || (segmentInfo = arrayList.get(i16)) == null || TextUtils.isEmpty(segmentInfo.url)) {
            return "";
        }
        return segmentInfo.url;
    }

    public int getSegmentCount() {
        StreamInfo currentStreamInfo = getCurrentStreamInfo();
        if (currentStreamInfo == null) {
            return 0;
        }
        return currentStreamInfo.getCount();
    }

    public StreamInfo getStreamInfo(int i3) {
        HashMap<Integer, StreamInfo> hashMap = this.streams;
        if (hashMap != null && hashMap.size() != 0) {
            return this.streams.get(Integer.valueOf(i3));
        }
        return null;
    }

    public HashMap<Integer, StreamInfo> getStreams() {
        return this.streams;
    }

    public int getdefaultStreamRate() {
        resetStreamTypeIfNeeded();
        return this.defaultStreamRate;
    }

    public boolean isValid() {
        HashMap<Integer, StreamInfo> hashMap = this.streams;
        if (hashMap != null && !hashMap.isEmpty()) {
            Iterator<StreamInfo> it = this.streams.values().iterator();
            while (it.hasNext()) {
                if (!it.next().isValid()) {
                    return false;
                }
            }
            return true;
        }
        PlayerUtils.log(6, LOG_TAG, "streams is null or empty");
        return false;
    }

    public void setCurrentStreamType(int i3) {
        this.currentStreamRate = i3;
    }

    public void setMaxStreamRate(int i3) {
        if (this.currentStreamRate > i3) {
            this.currentStreamRate = maxFloor(this.streams.keySet(), i3);
        }
    }

    public void setStreamInfo(StreamInfo streamInfo, int i3) {
        HashMap<Integer, StreamInfo> hashMap = this.streams;
        if (hashMap == null) {
            return;
        }
        hashMap.put(Integer.valueOf(i3), streamInfo);
    }

    public void setStreams(HashMap<Integer, StreamInfo> hashMap) {
        this.streams = hashMap;
    }

    public void setVideoRate(int i3) {
        this.currentStreamRate = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("SegmentVideoInfo{streams=[");
        for (Map.Entry<Integer, StreamInfo> entry : this.streams.entrySet()) {
            sb5.append("{streamType=");
            sb5.append(entry.getKey());
            sb5.append(", streamInfo=");
            StreamInfo value = entry.getValue();
            if (value == null) {
                sb5.append("null");
            } else {
                sb5.append(value.toString());
            }
            sb5.append("}, ");
        }
        sb5.append("]");
        sb5.append(", defaultStreamRate=");
        sb5.append(this.defaultStreamRate);
        sb5.append(", currentStreamRate=");
        sb5.append(this.currentStreamRate);
        sb5.append('}');
        return sb5.toString();
    }

    public SegmentVideoInfo(HashMap<Integer, StreamInfo> hashMap) {
        this(hashMap, 750);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class StreamInfo {
        private VideoDecoderType.DecoderType decoderTypeSuggest;
        public boolean isHLSLive;
        public boolean isVideoTimeCanBeTrust;
        public boolean isVip;
        public String mSafeUrlKey;
        private String mUrl;
        public ArrayList<SegmentInfo> segmentInfos;
        public int streamType;

        public StreamInfo() {
            this.segmentInfos = new ArrayList<>();
            this.decoderTypeSuggest = VideoDecoderType.DecoderType.H264;
        }

        public void addSegmentInfo(String str, int i3) {
            int i16;
            if (this.segmentInfos == null) {
                this.segmentInfos = new ArrayList<>();
            }
            if (this.segmentInfos.isEmpty()) {
                i16 = 0;
            } else {
                int size = this.segmentInfos.size() - 1;
                i16 = this.segmentInfos.get(size).duration + this.segmentInfos.get(size).offset;
            }
            if (!TextUtils.isEmpty(str)) {
                this.segmentInfos.add(new SegmentInfo(str, i16, i3));
            }
        }

        public int getCount() {
            ArrayList<SegmentInfo> arrayList = this.segmentInfos;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public VideoDecoderType.DecoderType getDecoderTypeSuggest() {
            return this.decoderTypeSuggest;
        }

        public SegmentInfo getSegment(int i3) {
            if (this.segmentInfos != null && i3 >= 0 && i3 < getCount()) {
                return this.segmentInfos.get(i3);
            }
            return null;
        }

        public int getSegmentIndex(long j3) {
            ArrayList<SegmentInfo> arrayList = this.segmentInfos;
            if (arrayList != null && !arrayList.isEmpty()) {
                int count = getCount();
                if (count == 1) {
                    return 0;
                }
                for (int i3 = 0; i3 < count; i3++) {
                    if (this.segmentInfos.get(i3) == null) {
                        return -1;
                    }
                    if (r3.offset + r3.duration > j3) {
                        return i3;
                    }
                }
            }
            return -1;
        }

        public int getTotalDuration() {
            ArrayList<SegmentInfo> arrayList = this.segmentInfos;
            if (arrayList == null || arrayList.isEmpty()) {
                return 0;
            }
            SegmentInfo segmentInfo = this.segmentInfos.get(r0.size() - 1);
            if (segmentInfo == null) {
                return 0;
            }
            return segmentInfo.offset + segmentInfo.duration;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public boolean isValid() {
            ArrayList<SegmentInfo> arrayList = this.segmentInfos;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < this.segmentInfos.size(); i3++) {
                    SegmentInfo segmentInfo = this.segmentInfos.get(i3);
                    if (segmentInfo == null) {
                        PlayerUtils.log(6, SegmentVideoInfo.LOG_TAG, "segment index=" + i3 + " segment is null");
                        return false;
                    }
                    if (TextUtils.isEmpty(segmentInfo.url)) {
                        PlayerUtils.log(6, SegmentVideoInfo.LOG_TAG, "segment index=" + i3 + " url is empty");
                        return false;
                    }
                    if (segmentInfo.offset < 0) {
                        PlayerUtils.log(6, SegmentVideoInfo.LOG_TAG, "segment index=" + i3 + " segmentInfo.offset=" + segmentInfo.offset);
                        return false;
                    }
                    if (segmentInfo.duration < 0) {
                        PlayerUtils.log(6, SegmentVideoInfo.LOG_TAG, "segment index=" + i3 + " segmentInfo.duration=" + segmentInfo.duration);
                        return false;
                    }
                    if (i3 > 0) {
                        SegmentInfo segmentInfo2 = this.segmentInfos.get(i3 - 1);
                        if (segmentInfo2.offset + segmentInfo2.duration != segmentInfo.offset) {
                            PlayerUtils.log(6, SegmentVideoInfo.LOG_TAG, "segment index=" + i3 + " segmentInfo.offset=" + segmentInfo.offset + " before.offset=" + segmentInfo2.offset + " before.duration=" + segmentInfo2.duration);
                            return false;
                        }
                    }
                }
                return true;
            }
            PlayerUtils.log(6, SegmentVideoInfo.LOG_TAG, "segmentInfos is null or empty");
            return false;
        }

        public void setDecoderTypeSuggest(VideoDecoderType.DecoderType decoderType) {
            this.decoderTypeSuggest = decoderType;
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder(32);
            sb5.append("[");
            ArrayList<SegmentInfo> arrayList = this.segmentInfos;
            if (arrayList == null) {
                sb5.append("null");
            } else {
                Iterator<SegmentInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    SegmentInfo next = it.next();
                    if (next == null) {
                        sb5.append("{null}");
                    } else {
                        sb5.append("{url=");
                        sb5.append(next.url);
                        sb5.append(", duration=");
                        sb5.append(next.duration);
                        sb5.append(", offset=");
                        sb5.append(next.offset);
                        sb5.append("}");
                    }
                    sb5.append(", ");
                }
            }
            sb5.append("]");
            return sb5.toString();
        }

        public void updateDuration() {
            ArrayList<SegmentInfo> arrayList = this.segmentInfos;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 1; i3 < this.segmentInfos.size(); i3++) {
                    SegmentInfo segmentInfo = this.segmentInfos.get(i3);
                    SegmentInfo segmentInfo2 = this.segmentInfos.get(i3 - 1);
                    if (segmentInfo != null && segmentInfo2 != null) {
                        segmentInfo.offset = segmentInfo2.offset + segmentInfo2.duration;
                    } else {
                        return;
                    }
                }
            }
        }

        public StreamInfo(String str, int i3) {
            this(str, i3, VideoDecoderType.DecoderType.H264);
        }

        public StreamInfo(String str, int i3, VideoDecoderType.DecoderType decoderType) {
            this.mUrl = str;
            SegmentInfo segmentInfo = new SegmentInfo(str, 0, i3);
            ArrayList<SegmentInfo> arrayList = new ArrayList<>();
            this.segmentInfos = arrayList;
            arrayList.add(segmentInfo);
            this.decoderTypeSuggest = decoderType;
        }
    }

    public SegmentVideoInfo(String str, int i3) {
        this();
        this.streams.put(0, new StreamInfo(str, i3));
    }

    public SegmentVideoInfo(HashMap<Integer, StreamInfo> hashMap, int i3) {
        this.streams = hashMap;
        this.defaultStreamRate = i3;
        this.currentStreamRate = i3;
    }
}
