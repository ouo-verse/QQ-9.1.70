package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class PaceSummary extends aabq {
    public static final Parcelable.Creator<PaceSummary> CREATOR = new aabq.aab(PaceSummary.class);
    private static final String TAG = "PaceSummary";

    @aaby(id = 5)
    private Double avgPace;

    @aaby(id = 6)
    private Double bestPace;

    @aaby(id = 2)
    private Map<String, Double> britishPaceMap;

    @aaby(id = 4)
    private Map<String, Double> britishPartTimeMap;

    @aaby(id = 1)
    private Map<String, Double> paceMap;

    @aaby(id = 3)
    private Map<String, Double> partTimeMap;

    @aaby(id = 7)
    private Map<String, Double> sportHealthPaceMap;

    public PaceSummary() {
        this.paceMap = new HashMap();
        this.britishPaceMap = new HashMap();
        this.partTimeMap = new HashMap();
        this.britishPartTimeMap = new HashMap();
        Double valueOf = Double.valueOf(0.0d);
        this.avgPace = valueOf;
        this.bestPace = valueOf;
        this.sportHealthPaceMap = new HashMap();
        aabz.aabb(TAG, "PaceSummary() ");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaceSummary)) {
            return false;
        }
        PaceSummary paceSummary = (PaceSummary) obj;
        if (Objects.equals(this.paceMap, paceSummary.paceMap) && Objects.equals(this.britishPaceMap, paceSummary.britishPaceMap) && Objects.equals(this.partTimeMap, paceSummary.partTimeMap) && Objects.equals(this.britishPartTimeMap, paceSummary.britishPartTimeMap) && Objects.equals(this.avgPace, paceSummary.avgPace) && Objects.equals(this.bestPace, paceSummary.bestPace) && Objects.equals(this.sportHealthPaceMap, paceSummary.sportHealthPaceMap)) {
            return true;
        }
        return false;
    }

    public Double getAvgPace() {
        return this.avgPace;
    }

    public Double getBestPace() {
        return this.bestPace;
    }

    public Map<String, Double> getBritishPaceMap() {
        return this.britishPaceMap;
    }

    public Map<String, Double> getBritishPartTimeMap() {
        return this.britishPartTimeMap;
    }

    public Map<String, Double> getPaceMap() {
        return this.paceMap;
    }

    public Map<String, Double> getPartTimeMap() {
        return this.partTimeMap;
    }

    public Map<String, Double> getSportHealthPaceMap() {
        return this.sportHealthPaceMap;
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(this.paceMap, this.britishPaceMap, this.partTimeMap, this.britishPartTimeMap, this.avgPace, this.bestPace, this.sportHealthPaceMap);
    }

    public void setAvgPace(Double d16) {
        this.avgPace = d16;
    }

    public void setBestPace(Double d16) {
        this.bestPace = d16;
    }

    public void setBritishPaceMap(Map<String, Double> map) {
        this.britishPaceMap = map;
    }

    public void setBritishPartTimeMap(Map<String, Double> map) {
        this.britishPartTimeMap = map;
    }

    public void setPaceMap(Map<String, Double> map) {
        this.paceMap = map;
    }

    public void setPartTimeMap(Map<String, Double> map) {
        this.partTimeMap = map;
    }

    @Deprecated
    public void setSportHealthPaceMap(Map<String, Double> map) {
        this.sportHealthPaceMap = map;
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("PaceSummary{paceMap = ");
        aab.append(this.paceMap);
        aab.append(", britishPaceMap = ");
        aab.append(this.britishPaceMap);
        aab.append(", partTimeMap = ");
        aab.append(this.partTimeMap);
        aab.append(", britishPartTimeMap = ");
        aab.append(this.britishPartTimeMap);
        aab.append(", avgPace = ");
        aab.append(this.avgPace);
        aab.append(", bestPace = ");
        aab.append(this.bestPace);
        aab.append(", sportHealthPaceMap = ");
        aab.append(this.sportHealthPaceMap);
        aab.append("}");
        return aab.toString();
    }

    @aabw
    public PaceSummary(@aabv(id = 1) Map<String, Double> map, @aabv(id = 2) Map<String, Double> map2, @aabv(id = 3) Map<String, Double> map3, @aabv(id = 4) Map<String, Double> map4, @aabv(id = 5) Double d16, @aabv(id = 6) Double d17, @aabv(id = 7) Map<String, Double> map5) {
        aabz.aabb(TAG, "PaceSummary() SafePrimary ");
        this.paceMap = map;
        this.britishPaceMap = map2;
        this.partTimeMap = map3;
        this.britishPartTimeMap = map4;
        this.avgPace = d16;
        this.bestPace = d17;
        this.sportHealthPaceMap = map5;
    }
}
