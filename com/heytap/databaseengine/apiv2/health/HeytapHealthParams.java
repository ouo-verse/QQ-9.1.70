package com.heytap.databaseengine.apiv2.health;

import androidx.annotation.Keep;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.utils.HLog;
import java.util.HashMap;
import java.util.Map;

@Keep
/* loaded from: classes2.dex */
public class HeytapHealthParams {
    public static final String BODY = "BODY";
    public static final String DAILY_ACTIVITY = "DAILY_ACTIVITY";
    public static final String ECG = "ECG";
    public static final String HEART_RATE = "HEART_RATE";
    public static final int LOWEST_APP_VERSION = 3180000;
    public static final int NOT_SUPPORT_DATA_TYPE = -1;
    public static final String PRESSURE = "PRESSURE";
    public static final String SLEEP = "SLEEP";
    public static final String SPO2 = "SPO2";
    public static final String SPORT = "SPORT";
    private static final String TAG = "HeytapHealthParams";
    private static final Map<String, Integer> tableTypeMap;
    private String dataType;
    private long endTime;
    private MODE mode;
    public int sdkVersion;
    private long startTime;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final String dataType;
        private MODE mode;
        private long startTime = 0;
        private long endTime = 0;

        public Builder(String str, MODE mode) {
            this.dataType = str;
            this.mode = mode;
        }

        public HeytapHealthParams build() {
            return new HeytapHealthParams(this);
        }

        public Builder setEndTime(long j3) {
            this.endTime = j3;
            return this;
        }

        public Builder setStartTime(long j3) {
            this.startTime = j3;
            return this;
        }

        public Builder setTimeScope(long j3, long j16) {
            this.startTime = j3;
            this.endTime = j16;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum MODE {
        STAT("STAT"),
        DETAIL("DETAIL"),
        DEFAULT("DEFAULT");

        private String description;

        MODE(String str) {
            this.description = str;
        }

        public String getDescription() {
            return this.description;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        tableTypeMap = hashMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(DAILY_ACTIVITY);
        MODE mode = MODE.DETAIL;
        sb5.append(mode.getDescription());
        hashMap.put(sb5.toString(), 1001);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(DAILY_ACTIVITY);
        MODE mode2 = MODE.STAT;
        sb6.append(mode2.getDescription());
        hashMap.put(sb6.toString(), 1002);
        hashMap.put(SPORT + mode.getDescription(), 1003);
        hashMap.put(SPORT + mode2.getDescription(), 1005);
        hashMap.put(HEART_RATE + mode.getDescription(), 1008);
        hashMap.put(HEART_RATE + mode2.getDescription(), 1009);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(SLEEP);
        MODE mode3 = MODE.DEFAULT;
        sb7.append(mode3.getDescription());
        hashMap.put(sb7.toString(), 1010);
        hashMap.put(ECG + mode3.getDescription(), 1012);
        hashMap.put(SPO2 + mode3.getDescription(), 1014);
        hashMap.put(PRESSURE + mode3.getDescription(), 1017);
        hashMap.put(BODY + mode3.getDescription(), 1021);
    }

    public static int getTableType(String str) {
        Integer num = tableTypeMap.get(str);
        if (num == null) {
            HLog.e(TAG, "error table type");
            return -1;
        }
        return num.intValue();
    }

    public String getDataType() {
        return this.dataType;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public MODE getMode() {
        return this.mode;
    }

    public long getStartTime() {
        return this.startTime;
    }

    HeytapHealthParams(Builder builder) {
        this.sdkVersion = _HeytapHealth.sdkVersion;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.dataType = builder.dataType;
        this.mode = builder.mode;
    }
}
