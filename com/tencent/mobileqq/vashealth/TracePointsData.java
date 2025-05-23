package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class TracePointsData extends Entity {
    public static final String TABLE_NAME = "TracePointsData";
    public int accuracy;
    public double altitude;
    public float latitude;
    public float longitude;
    public float speed;
    public long startTime;
    public int steps;

    @unique
    public long time;

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.startTime);
            jSONObject.put("time", this.time);
            jSONObject.put("latitude", Double.parseDouble(Float.toString(this.latitude)));
            jSONObject.put("longitude", Double.parseDouble(Float.toString(this.longitude)));
            jSONObject.put("speed", this.speed);
            jSONObject.put("accuracy", this.accuracy);
            jSONObject.put("steps", this.steps);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return "lat: " + Float.toString(this.latitude) + ",lon: " + Float.toString(this.longitude) + ",time: " + this.time + ",speed: " + this.speed + ",accuracy: " + this.accuracy + ",steps: " + this.steps;
    }
}
