package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.sveffects.SLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DynamicStickerData {
    public static final String KEY_SEGMENTS_DATA = "segmentdata";
    public static final String TAG = "DynamicSticker";
    public PointF centerP;
    public String data;
    public int decodeFlag;
    public float height;
    public int layerHeight;
    public int layerWidth;
    public GifDecoder mGifDecoder;
    public String path;
    public int type;
    public float width;
    public float scale = 1.0f;
    public float rotate = 0.0f;
    public float translateX = 0.0f;
    public float translateY = 0.0f;
    public SegmentKeeper mSegmentKeeper = new SegmentKeeper();
    public Map<Long, TrackerStickerParam.MotionInfo> mapMotionTrack = new HashMap();

    public boolean isShow(long j3) {
        SLog.d(TAG, "isshow:" + j3);
        if (this.mSegmentKeeper.isInSegment(j3)) {
            return true;
        }
        return false;
    }

    public void setSegmentList(List<Pair<Long, Long>> list) {
        this.mSegmentKeeper.setSegmentList(list);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("DynamicStickerData{");
        sb5.append("centerP=");
        sb5.append(this.centerP);
        sb5.append(", scale=");
        sb5.append(this.scale);
        sb5.append(", rotate=");
        sb5.append(this.rotate);
        sb5.append(", translateX=");
        sb5.append(this.translateX);
        sb5.append(", translateY=");
        sb5.append(this.translateY);
        sb5.append(", width=");
        sb5.append(this.width);
        sb5.append(", height=");
        sb5.append(this.height);
        sb5.append(", layerWidth=");
        sb5.append(this.layerWidth);
        sb5.append(", layerHeight=");
        sb5.append(this.layerHeight);
        sb5.append(", type=");
        sb5.append(this.type);
        sb5.append(", path='");
        sb5.append(this.path);
        sb5.append('\'');
        sb5.append(", data=");
        sb5.append(this.data);
        sb5.append(", decodeFlag=");
        sb5.append(this.decodeFlag);
        sb5.append(", mGifDecoder=");
        sb5.append(this.mGifDecoder);
        String segmentKeeper = this.mSegmentKeeper.toString();
        if (!TextUtils.isEmpty(segmentKeeper)) {
            sb5.append(",");
            sb5.append(segmentKeeper);
        } else {
            sb5.append(",segments=null");
        }
        sb5.append('}');
        return sb5.toString();
    }
}
