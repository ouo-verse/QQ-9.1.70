package com.tencent.mobileqq.shortvideo.facedancegame;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ExpressionTemplateConfig {
    public float[] expressionAngle;
    public List<PointF> expressionFeat;
    public String expressionID;
    public double[] expressionWeight;

    public static ExpressionTemplateConfig parseConfig(String str) {
        try {
            ExpressionTemplateConfig expressionTemplateConfig = new ExpressionTemplateConfig();
            JSONObject jSONObject = new JSONObject(str);
            expressionTemplateConfig.expressionID = jSONObject.getString("expressionID");
            JSONArray optJSONArray = jSONObject.optJSONArray("expressionFeat");
            if (optJSONArray != null) {
                float f16 = 0.0f;
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    double d16 = optJSONArray.getDouble(i3);
                    if (i3 % 2 == 0) {
                        f16 = (float) d16;
                    } else {
                        PointF pointF = new PointF(f16, (float) d16);
                        if (expressionTemplateConfig.expressionFeat == null) {
                            expressionTemplateConfig.expressionFeat = new ArrayList();
                        }
                        expressionTemplateConfig.expressionFeat.add(pointF);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("expressionAngle");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                for (int i16 = 0; i16 < length; i16++) {
                    if (expressionTemplateConfig.expressionAngle == null) {
                        expressionTemplateConfig.expressionAngle = new float[length];
                    }
                    expressionTemplateConfig.expressionAngle[i16] = (float) optJSONArray2.getDouble(i16);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("expressionWeight");
            if (optJSONArray3 != null) {
                int length2 = optJSONArray3.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    if (expressionTemplateConfig.expressionWeight == null) {
                        expressionTemplateConfig.expressionWeight = new double[length2];
                    }
                    expressionTemplateConfig.expressionWeight[i17] = optJSONArray3.getDouble(i17);
                }
            }
            return expressionTemplateConfig;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
