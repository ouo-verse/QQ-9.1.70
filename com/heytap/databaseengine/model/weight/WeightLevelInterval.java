package com.heytap.databaseengine.model.weight;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class WeightLevelInterval implements Serializable {

    @SerializedName("endValue")
    private double endValue;

    @SerializedName("levelIntervalName")
    private String levelIntervalName;

    @SerializedName("startValue")
    private double startValue;

    public double getEndValue() {
        return this.endValue;
    }

    public String getLevelIntervalName() {
        return this.levelIntervalName;
    }

    public double getStartValue() {
        return this.startValue;
    }

    public void setEndValue(double d16) {
        this.endValue = d16;
    }

    public void setLevelIntervalName(String str) {
        this.levelIntervalName = str;
    }

    public void setStartValue(double d16) {
        this.startValue = d16;
    }

    public String toString() {
        return "WeightLevelInterval{levelIntervalName='" + this.levelIntervalName + "', startValue=" + this.startValue + ", endValue=" + this.endValue + '}';
    }
}
