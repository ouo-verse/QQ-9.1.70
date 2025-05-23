package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MatchTemplateConfig {
    public int checkMethod;
    public int datumIndex0;
    public int datumIndex1;
    public float degreeThreshold;
    public float distanceThreshold;
    public List<KeyPoint> keyPoints;
    public List<KeyVector> keyVectors;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class KeyPoint {
        public float[] coords;
        public int index;
        public float threshold;
        public float weight;

        public KeyPoint() {
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("index", this.index);
                jSONObject.put("weight", this.weight);
                jSONObject.put("threshold", this.threshold);
                JSONArray jSONArray = new JSONArray();
                int i3 = 0;
                while (true) {
                    if (i3 < this.coords.length) {
                        jSONArray.put(r3[i3]);
                        i3++;
                    } else {
                        jSONObject.put("point", jSONArray);
                        return jSONObject;
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public KeyPoint(int i3, float f16, float f17, float[] fArr) {
            this.index = i3;
            this.weight = f16;
            this.coords = fArr;
            this.threshold = f17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class KeyVector {
        public int threshold;
        public int[] vectors;
        public float weight;

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("threshold", this.threshold);
                jSONObject.put("weight", this.weight);
                JSONArray jSONArray = new JSONArray();
                int i3 = 0;
                while (true) {
                    int[] iArr = this.vectors;
                    if (i3 < iArr.length) {
                        jSONArray.put(iArr[i3]);
                        i3++;
                    } else {
                        jSONObject.put("vector", jSONArray);
                        return jSONObject;
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    public static synchronized MatchTemplateConfig parseConfig(String str) {
        MatchTemplateConfig matchTemplateConfig;
        synchronized (MatchTemplateConfig.class) {
            try {
                matchTemplateConfig = new MatchTemplateConfig();
                JSONObject jSONObject = new JSONObject(str);
                matchTemplateConfig.distanceThreshold = (float) jSONObject.optDouble("distanceThreshold", -1.0d);
                matchTemplateConfig.degreeThreshold = (float) jSONObject.optDouble("degreeThreshold", -1.0d);
                matchTemplateConfig.checkMethod = jSONObject.optInt("checkMethod", -1);
                JSONArray jSONArray = jSONObject.getJSONArray("datumIndices");
                matchTemplateConfig.datumIndex0 = jSONArray.getInt(0);
                matchTemplateConfig.datumIndex1 = jSONArray.getInt(1);
                JSONArray optJSONArray = jSONObject.optJSONArray("keyPoints");
                if (optJSONArray != null) {
                    matchTemplateConfig.keyPoints = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                        KeyPoint keyPoint = new KeyPoint();
                        keyPoint.index = jSONObject2.optInt("index");
                        keyPoint.weight = (float) jSONObject2.optDouble("weight");
                        keyPoint.threshold = (float) jSONObject2.optDouble("threshold");
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("point");
                        keyPoint.coords = new float[]{(float) optJSONArray2.getDouble(0), (float) optJSONArray2.getDouble(1)};
                        matchTemplateConfig.keyPoints.add(keyPoint);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("keyVectors");
                if (optJSONArray3 != null) {
                    matchTemplateConfig.keyVectors = new ArrayList();
                    for (int i16 = 0; i16 < optJSONArray3.length(); i16++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray3.get(i16);
                        KeyVector keyVector = new KeyVector();
                        keyVector.weight = (float) jSONObject3.optDouble("weight");
                        keyVector.threshold = jSONObject3.optInt("threshold");
                        JSONArray optJSONArray4 = jSONObject3.optJSONArray("vector");
                        keyVector.vectors = new int[]{optJSONArray4.getInt(0), optJSONArray4.getInt(1)};
                        matchTemplateConfig.keyVectors.add(keyVector);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return matchTemplateConfig;
    }

    public int[] getPointIndices() {
        List<KeyPoint> list = this.keyPoints;
        if (list != null && list.size() > 0) {
            int[] iArr = new int[this.keyPoints.size()];
            for (int i3 = 0; i3 < this.keyPoints.size(); i3++) {
                iArr[i3] = this.keyPoints.get(i3).index;
            }
            return iArr;
        }
        return null;
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.datumIndex0);
            jSONArray.put(this.datumIndex1);
            jSONObject.put("datumIndices", jSONArray);
            jSONObject.put("distanceThreshold", this.distanceThreshold);
            jSONObject.put("degreeThreshold", this.degreeThreshold);
            jSONObject.put("checkMethod", this.checkMethod);
            if (this.keyPoints != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < this.keyPoints.size(); i3++) {
                    jSONArray2.mo162put(this.keyPoints.get(i3).toJsonObject());
                }
                jSONObject.put("keyPoints", jSONArray2);
            }
            if (this.keyVectors != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i16 = 0; i16 < this.keyVectors.size(); i16++) {
                    jSONArray3.mo162put(this.keyVectors.get(i16).toJsonObject());
                }
                jSONObject.put("keyVectors", this.keyPoints);
            }
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
