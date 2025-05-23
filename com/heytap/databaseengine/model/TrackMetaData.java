package com.heytap.databaseengine.model;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.heytap.databaseengine.utils.HLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class TrackMetaData {
    private static final String TAG = "TrackMetaData";
    private String coordinate;
    private String runExtra;
    private String sportId;
    private int sportMode;
    private String sportName;
    private int sportType;
    private String vendor;
    private int avgPace = 0;
    private int bestPace = 0;
    private int avgHeartRate = 0;
    private int maxHeartRate = 0;
    private int minHeartRate = 0;
    private int avgStepRate = 0;
    private int bestStepRate = 0;
    private int totalDistance = 0;
    private int modifiedTotalDistance = 0;
    private long totalCalories = 0;
    private int totalSteps = 0;
    private long totalTime = 0;
    private int totalClimb = 0;
    private Map<Float, Short> partTimeMap = new HashMap();
    private Map<Double, Short> britishPartTimeMap = new HashMap();
    private Map<Integer, Integer> paceMap = new HashMap();
    private Map<Float, Integer> britishPaceMap = new HashMap();
    private int creepingWave = 0;
    private Map<String, Integer> wearSportData = new HashMap();
    private boolean isFreeMotion = false;
    private int sportDataSource = 0;
    private int chiefSportDataType = 0;
    private boolean hasTrackPoint = true;
    private int abnormalTrack = 0;
    private Map<Long, Short> stepRate = new HashMap();
    private Map<Long, Double> altitude = new HashMap();

    public int getAbnormalTrack() {
        return this.abnormalTrack;
    }

    public Map<Long, Double> getAltitude() {
        return this.altitude;
    }

    public int getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public int getAvgPace() {
        return this.avgPace;
    }

    public int getAvgStepRate() {
        return this.avgStepRate;
    }

    public int getBestPace() {
        return this.bestPace;
    }

    public int getBestStepRate() {
        return this.bestStepRate;
    }

    public Map<Float, Integer> getBritishPaceMap() {
        return this.britishPaceMap;
    }

    public Map<Double, Short> getBritishPartTimeMap() {
        return this.britishPartTimeMap;
    }

    public int getChiefSportDataType() {
        return this.chiefSportDataType;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public int getCreepingWave() {
        return this.creepingWave;
    }

    public boolean getHasTrackPoint() {
        return this.hasTrackPoint;
    }

    public boolean getIsFreeMotion() {
        return this.isFreeMotion;
    }

    public int getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public int getMinHeartRate() {
        return this.minHeartRate;
    }

    public int getModifiedTotalDistance() {
        return this.modifiedTotalDistance;
    }

    public Map<Integer, Integer> getPaceMap() {
        return this.paceMap;
    }

    public Map<Float, Short> getPartTimeMap() {
        return this.partTimeMap;
    }

    public int getRecordGrade() {
        if (!TextUtils.isEmpty(this.runExtra)) {
            try {
                return new JSONObject(this.runExtra).optInt("recordGrade", 0);
            } catch (JSONException e16) {
                HLog.e(TAG, "JSONException e = " + e16.getMessage());
            }
        }
        return 0;
    }

    public String getRunExtra() {
        return this.runExtra;
    }

    public int getSportDataSource() {
        return this.sportDataSource;
    }

    public String getSportId() {
        return this.sportId;
    }

    public int getSportMode() {
        return this.sportMode;
    }

    public String getSportName() {
        return this.sportName;
    }

    public int getSportType() {
        return this.sportType;
    }

    public Map<Long, Short> getStepRate() {
        return this.stepRate;
    }

    public long getTotalCalories() {
        return this.totalCalories;
    }

    public int getTotalClimb() {
        return this.totalClimb;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public String getVendor() {
        return this.vendor;
    }

    public Map<String, Integer> getWearSportData() {
        return this.wearSportData;
    }

    public void setAbnormalTrack(int i3) {
        this.abnormalTrack = i3;
    }

    public void setAltitude(Map<Long, Double> map) {
        this.altitude = map;
    }

    public void setAvgHeartRate(int i3) {
        this.avgHeartRate = i3;
    }

    public void setAvgPace(int i3) {
        this.avgPace = i3;
    }

    public void setAvgStepRate(int i3) {
        this.avgStepRate = i3;
    }

    public void setBestPace(int i3) {
        this.bestPace = i3;
    }

    public void setBestStepRate(int i3) {
        this.bestStepRate = i3;
    }

    public void setBritishPaceMap(Map<Float, Integer> map) {
        this.britishPaceMap = map;
    }

    public void setBritishPartTimeMap(Map<Double, Short> map) {
        this.britishPartTimeMap = map;
    }

    public void setChiefSportDataType(int i3) {
        this.chiefSportDataType = i3;
    }

    public void setCoordinate(String str) {
        this.coordinate = str;
    }

    public void setCreepingWave(int i3) {
        this.creepingWave = i3;
    }

    public void setHasTrackPoint(boolean z16) {
        this.hasTrackPoint = z16;
    }

    public void setIsFreeMotion(boolean z16) {
        this.isFreeMotion = z16;
    }

    public void setMaxHeartRate(int i3) {
        this.maxHeartRate = i3;
    }

    public void setMinHeartRate(int i3) {
        this.minHeartRate = i3;
    }

    public void setModifiedTotalDistance(int i3) {
        this.modifiedTotalDistance = i3;
    }

    public void setPaceMap(Map<Integer, Integer> map) {
        this.paceMap = map;
    }

    public void setPartTimeMap(Map<Float, Short> map) {
        this.partTimeMap = map;
    }

    public void setRunExtra(String str) {
        this.runExtra = str;
    }

    public void setSportDataSource(int i3) {
        this.sportDataSource = i3;
    }

    public void setSportId(String str) {
        this.sportId = str;
    }

    public void setSportMode(int i3) {
        this.sportMode = i3;
    }

    public void setSportName(String str) {
        this.sportName = str;
    }

    public void setSportType(int i3) {
        this.sportType = i3;
    }

    public void setStepRate(Map<Long, Short> map) {
        this.stepRate = map;
    }

    public void setTotalCalories(long j3) {
        this.totalCalories = j3;
    }

    public void setTotalClimb(int i3) {
        this.totalClimb = i3;
    }

    public void setTotalDistance(int i3) {
        this.totalDistance = i3;
    }

    public void setTotalSteps(int i3) {
        this.totalSteps = i3;
    }

    public void setTotalTime(long j3) {
        this.totalTime = j3;
    }

    public void setVendor(String str) {
        this.vendor = str;
    }

    public void setWearSportData(Map<String, Integer> map) {
        this.wearSportData = map;
    }

    public String toString() {
        return "TrackMetaData{avgPace=" + this.avgPace + ", bestPace=" + this.bestPace + ", avgStepRate=" + this.avgStepRate + ", bestStepRate=" + this.bestStepRate + ", totalDistance=" + this.totalDistance + ", modifiedTotalDistance=" + this.modifiedTotalDistance + ", totalCalories=" + this.totalCalories + ", totalSteps=" + this.totalSteps + ", totalTime=" + this.totalTime + ", sportId='" + this.sportId + "', sportType=" + this.sportType + ", partTimeMap=" + this.partTimeMap + ", britishPartTimeMap=" + this.britishPartTimeMap + ", paceMap=" + this.paceMap + ", britishPaceMap=" + this.britishPaceMap + ", sportMode=" + this.sportMode + ", creepingWave=" + this.creepingWave + ", wearSportData=" + this.wearSportData + ", vendor='" + this.vendor + "', coordinate='" + this.coordinate + "', isFreeMotion=" + this.isFreeMotion + ", sportDataSource=" + this.sportDataSource + ", chiefSportDataType=" + this.chiefSportDataType + ", hasTrackPoint=" + this.hasTrackPoint + ", abnormalTrack=" + this.abnormalTrack + ", stepRate=" + this.stepRate + ", altitude=" + this.altitude + '}';
    }
}
