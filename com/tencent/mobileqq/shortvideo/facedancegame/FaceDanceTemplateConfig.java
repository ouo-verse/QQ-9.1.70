package com.tencent.mobileqq.shortvideo.facedancegame;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FaceDanceTemplateConfig {
    public ExpressionTemplateConfig mExpressionConfig;
    public String mGestureType;
    public String mTemplateID;
    public float threshold;

    public static FaceDanceTemplateConfig parseConfig(String str, List<ExpressionTemplateConfig> list) {
        if (list != null && list.size() != 0) {
            try {
                FaceDanceTemplateConfig faceDanceTemplateConfig = new FaceDanceTemplateConfig();
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("expression");
                Iterator<ExpressionTemplateConfig> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ExpressionTemplateConfig next = it.next();
                    if (next.expressionID.equals(string)) {
                        faceDanceTemplateConfig.mExpressionConfig = next;
                        break;
                    }
                }
                if (faceDanceTemplateConfig.mExpressionConfig == null) {
                    return null;
                }
                faceDanceTemplateConfig.mTemplateID = jSONObject.getString("id");
                faceDanceTemplateConfig.mGestureType = jSONObject.getString("gesture");
                faceDanceTemplateConfig.threshold = (float) jSONObject.getDouble("expression_threshold");
                return faceDanceTemplateConfig;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }
}
