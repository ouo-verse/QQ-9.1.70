package com.heytap.databaseengine.model.weight;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class WeightLabel implements Serializable {

    @SerializedName("label")
    private String label;

    @SerializedName("labelContent")
    private String labelContent;

    @SerializedName("labelDescription")
    private String labelDescription;

    @SerializedName("labelDietaryAdvice")
    private String labelDietaryAdvice;

    @SerializedName("labelLevelName")
    private String labelLevelName;

    @SerializedName("labelSportsAdvice")
    private String labelSportsAdvice;

    @SerializedName("labelUnit")
    private String labelUnit;

    @SerializedName("labelValue")
    private double labelValue;

    @SerializedName("levelIntervalList")
    private List<WeightLevelInterval> levelIntervalList;

    @SerializedName("takeCare")
    private boolean takeCare;

    public String getLabel() {
        return this.label;
    }

    public String getLabelContent() {
        return this.labelContent;
    }

    public String getLabelDescription() {
        return this.labelDescription;
    }

    public String getLabelDietaryAdvice() {
        return this.labelDietaryAdvice;
    }

    public String getLabelLevelName() {
        return this.labelLevelName;
    }

    public String getLabelSportsAdvice() {
        return this.labelSportsAdvice;
    }

    public String getLabelUnit() {
        return this.labelUnit;
    }

    public double getLabelValue() {
        return this.labelValue;
    }

    public List<WeightLevelInterval> getLevelIntervalList() {
        return this.levelIntervalList;
    }

    public boolean isTakeCare() {
        return this.takeCare;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLabelContent(String str) {
        this.labelContent = str;
    }

    public void setLabelDescription(String str) {
        this.labelDescription = str;
    }

    public void setLabelDietaryAdvice(String str) {
        this.labelDietaryAdvice = str;
    }

    public void setLabelLevelName(String str) {
        this.labelLevelName = str;
    }

    public void setLabelSportsAdvice(String str) {
        this.labelSportsAdvice = str;
    }

    public void setLabelUnit(String str) {
        this.labelUnit = str;
    }

    public void setLabelValue(double d16) {
        this.labelValue = d16;
    }

    public void setLevelIntervalList(List<WeightLevelInterval> list) {
        this.levelIntervalList = list;
    }

    public void setTakeCare(boolean z16) {
        this.takeCare = z16;
    }

    public String toString() {
        return "WeightLabel{label='" + this.label + "', labelValue=" + this.labelValue + ", labelUnit='" + this.labelUnit + "', labelLevelName='" + this.labelLevelName + "', takeCare=" + this.takeCare + ", labelContent='" + this.labelContent + "', labelDietaryAdvice='" + this.labelDietaryAdvice + "', labelSportsAdvice='" + this.labelSportsAdvice + "', labelDescription='" + this.labelDescription + "', levelIntervalList=" + this.levelIntervalList + '}';
    }
}
