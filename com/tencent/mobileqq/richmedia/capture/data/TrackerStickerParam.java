package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class TrackerStickerParam {
    private static final String KEY_SEGMENTS_DATA = "segmentdata";
    public PointF centerP;
    public float height;
    public int layerHeight;
    public int layerWidth;
    public SegmentKeeper mSegmentKeeper;
    public Map<Long, MotionInfo> mapMotionTrack;
    public String path;
    public float rotate;
    public float scale;
    public float translateXValue;
    public float translateYValue;
    public float width;

    public TrackerStickerParam() {
        this.mapMotionTrack = new HashMap();
        this.mSegmentKeeper = new SegmentKeeper();
    }

    public static ArrayList<TrackerStickerParam> FromString(String str) {
        ArrayList<TrackerStickerParam> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("TrackList");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    TrackerStickerParam trackerStickerParam = new TrackerStickerParam();
                    trackerStickerParam.FromJson(jSONObject);
                    arrayList.add(trackerStickerParam);
                }
            }
        } catch (JSONException e16) {
            SLog.e("TrackerStickerParam", "TrackList FromString" + e16.toString());
        }
        return arrayList;
    }

    public static String ToJsonString(ArrayList<TrackerStickerParam> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                TrackerStickerParam trackerStickerParam = arrayList.get(i3);
                if (trackerStickerParam != null) {
                    jSONArray.mo162put(trackerStickerParam.toJSONObject());
                }
            }
            try {
                jSONObject.put("TrackList", jSONArray);
            } catch (JSONException e16) {
                SLog.e("TrackerStickerParam", "TrackList" + e16.toString());
            }
            return jSONObject.toString();
        }
        return null;
    }

    public static Map<Long, MotionInfo> mapMotionFromJarray(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    MotionInfo motionInfo = new MotionInfo(false, 0L, 0.0f, 0.0f, 1.0f, 0.0f);
                    motionInfo.isLost = jSONObject.getBoolean("isLost");
                    motionInfo.frameTime = jSONObject.getLong("frameTime");
                    motionInfo.f281358x = (float) jSONObject.getDouble("motionX");
                    motionInfo.f281359y = (float) jSONObject.getDouble("motionY");
                    motionInfo.scale = (float) jSONObject.getDouble("scaleP");
                    motionInfo.rotate = (float) jSONObject.getDouble("rotateP");
                    hashMap.put(Long.valueOf(motionInfo.frameTime), motionInfo);
                } catch (JSONException e16) {
                    SLog.e("TrackerStickerParam", "mapMotionFromJarray" + e16.toString());
                }
            }
        }
        return hashMap;
    }

    public static JSONArray motionMapToJarray(Map<Long, MotionInfo> map) {
        JSONArray jSONArray = new JSONArray();
        if (map != null && map.size() > 0) {
            for (Map.Entry<Long, MotionInfo> entry : map.entrySet()) {
                Long key = entry.getKey();
                MotionInfo value = entry.getValue();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("frameTime", key);
                    jSONObject.put("motionX", value.f281358x);
                    jSONObject.put("motionY", value.f281359y);
                    jSONObject.put("isLost", value.isLost);
                    jSONObject.put("scaleP", value.scale);
                    jSONObject.put("rotateP", value.rotate);
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    SLog.e("TrackerStickerParam", "motionMapToJarray" + e16.toString());
                }
            }
        }
        return jSONArray;
    }

    public void FromJson(JSONObject jSONObject) {
        try {
            if (this.centerP == null) {
                this.centerP = new PointF(0.0f, 0.0f);
            }
            this.centerP.x = (float) jSONObject.getDouble("centerPx");
            this.centerP.y = (float) jSONObject.getDouble("centerPy");
            this.scale = (float) jSONObject.getDouble("scale");
            this.rotate = (float) jSONObject.getDouble(CanvasView.ACTION_ROTATE);
            this.translateXValue = (float) jSONObject.getDouble("translateXValue");
            this.translateYValue = (float) jSONObject.getDouble("translateYValue");
            this.width = (float) jSONObject.getDouble("width");
            this.height = (float) jSONObject.getDouble("height");
            this.path = jSONObject.getString("path");
            this.layerWidth = jSONObject.getInt("layerWidth");
            this.layerHeight = jSONObject.getInt("layerHeight");
            this.mapMotionTrack = mapMotionFromJarray(jSONObject.getJSONArray("motionTrack"));
            if (jSONObject.has("segmentdata")) {
                this.mSegmentKeeper.fromJSONObject(jSONObject.getJSONObject("segmentdata"));
            } else {
                SLog.e("TrackerStickerParam", "FromJSONObject error\uff0c segmentdata not exist!");
            }
        } catch (JSONException e16) {
            SLog.e("TrackerStickerParam", "mapMotionFromJarray" + e16.toString());
        }
    }

    public boolean isShow(long j3) {
        if (this.mSegmentKeeper.isInSegment(j3)) {
            return true;
        }
        return false;
    }

    public void setSegmentList(List<Pair<Long, Long>> list) {
        this.mSegmentKeeper.setSegmentList(list);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("centerPx", this.centerP.x);
            jSONObject.put("centerPy", this.centerP.y);
            jSONObject.put("scale", this.scale);
            jSONObject.put(CanvasView.ACTION_ROTATE, this.rotate);
            jSONObject.put("translateXValue", this.translateXValue);
            jSONObject.put("translateYValue", this.translateYValue);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            jSONObject.put("path", this.path);
            jSONObject.put("layerWidth", this.layerWidth);
            jSONObject.put("layerHeight", this.layerHeight);
            jSONObject.put("motionTrack", motionMapToJarray(this.mapMotionTrack));
            JSONObject jSONObject2 = this.mSegmentKeeper.toJSONObject();
            if (jSONObject2 != null) {
                jSONObject.put("segmentdata", jSONObject2);
            }
        } catch (JSONException e16) {
            SLog.e("TrackerStickerParam", "toJSONObject" + e16.toString());
        }
        return jSONObject;
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
        sb5.append(this.translateXValue);
        sb5.append(", translateY=");
        sb5.append(this.translateYValue);
        sb5.append(", width=");
        sb5.append(this.width);
        sb5.append(", height=");
        sb5.append(this.height);
        sb5.append(", layerWidth=");
        sb5.append(this.layerWidth);
        sb5.append(", layerHeight=");
        sb5.append(this.layerHeight);
        sb5.append(", path='");
        sb5.append(this.path);
        sb5.append('\'');
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

    public TrackerStickerParam(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, int i3, int i16, String str, Map<Long, MotionInfo> map) {
        this.mapMotionTrack = new HashMap();
        this.mSegmentKeeper = new SegmentKeeper();
        this.centerP = new PointF(f16, f17);
        this.scale = f18;
        this.rotate = f19;
        this.translateXValue = f26;
        this.translateYValue = f27;
        this.width = f28;
        this.height = f29;
        this.path = str;
        this.layerWidth = i3;
        this.layerHeight = i16;
        this.mapMotionTrack = map;
    }

    /* loaded from: classes18.dex */
    public static class MotionInfo {
        public long frameTime;
        public boolean isLost;
        public float rotate;
        public float scale;

        /* renamed from: x, reason: collision with root package name */
        public float f281358x;

        /* renamed from: y, reason: collision with root package name */
        public float f281359y;

        public MotionInfo(boolean z16, long j3, float f16, float f17, float f18, float f19) {
            this.isLost = z16;
            this.frameTime = j3;
            this.f281358x = f16;
            this.f281359y = f17;
            this.scale = f18;
            this.rotate = f19;
        }

        public JSONObject convertToJSON() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isLost", this.isLost);
                jSONObject.put("frameTime", this.frameTime);
                jSONObject.put(HippyTKDListViewAdapter.X, this.f281358x);
                jSONObject.put("y", this.f281359y);
                jSONObject.put("scale", this.scale);
                jSONObject.put(CanvasView.ACTION_ROTATE, this.rotate);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        public MotionInfo(JSONObject jSONObject) {
            this.isLost = false;
            this.scale = 1.0f;
            this.rotate = 0.0f;
            try {
                this.isLost = jSONObject.getBoolean("isLost");
                this.frameTime = jSONObject.getLong("frameTime");
                this.f281358x = (float) jSONObject.getDouble(HippyTKDListViewAdapter.X);
                this.f281359y = (float) jSONObject.getDouble("y");
                this.scale = (float) jSONObject.getDouble("scale");
                this.rotate = (float) jSONObject.getDouble(CanvasView.ACTION_ROTATE);
            } catch (Exception unused) {
            }
        }
    }
}
