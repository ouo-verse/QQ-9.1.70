package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerLayerInfo {
    private int layerIndex;
    private TAVStickerLayerType layerType;
    private CMTimeRange timeRange;
    private List<TAVStickerTimeEffect> timeEffects = new ArrayList();
    private List<TAVStickerImageEffect> imageEffects = new ArrayList();
    private List<TAVStickerUserData> userDataList = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class TAVStickerImageEffect {
        private String effectId;
        private String name;
        private CMTimeRange timeRange;

        public TAVStickerImageEffect(CMTimeRange cMTimeRange, String str, String str2) {
            this.timeRange = CMTimeRange.CMTimeRangeInvalid;
            this.effectId = "";
            this.name = "";
            if (cMTimeRange != null) {
                this.timeRange = cMTimeRange;
            }
            if (str != null) {
                this.effectId = str;
            }
            if (str2 != null) {
                this.name = str2;
            }
        }

        public String getEffectId() {
            return this.effectId;
        }

        public String getName() {
            return this.name;
        }

        public CMTimeRange getTimeRange() {
            return this.timeRange;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class TAVStickerTimeEffect {
        private boolean reversed;
        private CMTimeRange sourceVideoTimeRange;
        private CMTimeRange timeRange;

        public TAVStickerTimeEffect(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, boolean z16) {
            CMTimeRange cMTimeRange3 = CMTimeRange.CMTimeRangeInvalid;
            this.sourceVideoTimeRange = cMTimeRange3;
            this.timeRange = cMTimeRange3;
            this.reversed = false;
            if (cMTimeRange != null) {
                this.sourceVideoTimeRange = cMTimeRange;
            }
            if (cMTimeRange2 != null) {
                this.timeRange = cMTimeRange2;
            }
            this.reversed = z16;
        }

        public CMTimeRange getSourceVideoTimeRange() {
            return this.sourceVideoTimeRange;
        }

        public CMTimeRange getTimeRange() {
            return this.timeRange;
        }

        public boolean isReversed() {
            return this.reversed;
        }

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TAVStickerTimeEffect {sourceVideoTimeRange : ");
            String str2 = "null";
            if (this.sourceVideoTimeRange == null) {
                str = "null";
            } else {
                str = "start : " + this.sourceVideoTimeRange.getStartUs() + ", duration : " + this.sourceVideoTimeRange.getDurationUs();
            }
            sb5.append(str);
            sb5.append(", timeRange : ");
            if (this.timeRange != null) {
                str2 = "start : " + this.timeRange.getStartUs() + ", duration : " + this.timeRange.getDurationUs();
            }
            sb5.append(str2);
            sb5.append(", reversed : ");
            sb5.append(this.reversed);
            sb5.append("}");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class TAVStickerUserData {
        private String data;
        private CMTimeRange timeRange;

        public TAVStickerUserData(CMTimeRange cMTimeRange, String str) {
            this.timeRange = CMTimeRange.CMTimeRangeInvalid;
            this.data = "";
            if (cMTimeRange != null) {
                this.timeRange = cMTimeRange;
            }
            if (str != null) {
                this.data = str;
            }
        }

        public String getData() {
            return this.data;
        }

        public CMTimeRange getTimeRange() {
            return this.timeRange;
        }
    }

    public TAVStickerLayerInfo(int i3, TAVStickerLayerType tAVStickerLayerType, CMTimeRange cMTimeRange, List<TAVStickerTimeEffect> list, List<TAVStickerImageEffect> list2, List<TAVStickerUserData> list3) {
        this.layerType = TAVStickerLayerType.Unknown;
        this.layerIndex = 0;
        this.timeRange = CMTimeRange.CMTimeRangeInvalid;
        this.layerIndex = i3;
        if (tAVStickerLayerType != null) {
            this.layerType = tAVStickerLayerType;
        }
        if (cMTimeRange != null) {
            this.timeRange = cMTimeRange;
        }
        if (list != null) {
            this.timeEffects.clear();
            this.timeEffects.addAll(list);
        }
        if (list2 != null) {
            this.imageEffects.clear();
            this.imageEffects.addAll(list2);
        }
        if (list3 != null) {
            this.userDataList.clear();
            this.userDataList.addAll(list3);
        }
    }

    public List<TAVStickerImageEffect> getImageEffects() {
        return this.imageEffects;
    }

    public int getLayerIndex() {
        return this.layerIndex;
    }

    public TAVStickerLayerType getLayerType() {
        return this.layerType;
    }

    public List<TAVStickerTimeEffect> getTimeEffects() {
        return this.timeEffects;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public List<TAVStickerUserData> getUserDataList() {
        return this.userDataList;
    }
}
