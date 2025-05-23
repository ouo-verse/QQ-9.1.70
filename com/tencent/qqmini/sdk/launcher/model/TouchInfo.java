package com.tencent.qqmini.sdk.launcher.model;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TouchInfo {
    private long duration;
    private int endX;
    private int endY;
    private int startX;
    private int startY;

    public TouchInfo(int i3, int i16, int i17, int i18, long j3) {
        this.startX = i3;
        this.startY = i16;
        this.endX = i17;
        this.endY = i18;
        this.duration = j3;
    }

    public String toJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tsx", this.startX);
            jSONObject.put("tsy", this.startY);
            jSONObject.put("tex", this.endX);
            jSONObject.put("tey", this.endY);
            jSONObject.put("td", this.duration);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }
}
