package cooperation.qzone.util;

import android.os.Debug;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TimeCostTrace {
    public static final String TAG_QZONE_LAUNCH = "qzone_launch";
    public static final String TAG_QZONE_REFRESH = "qzone_refresh";
    public static final String TAG_QZONE_REFRESH_MORE = "qzone_refresh_more";
    public static final String TRACE_CODE_REFRESH = "100";
    public static final String TRACE_CODE_REFRESH_MORE = "101";
    public static HashMap<String, TimeCostTrace> map;
    public boolean isColdBoot;
    private String tag;
    public long mFirstTime = 0;
    private Map<String, long[]> timeMap = new ConcurrentHashMap();
    public int sceneId = 0;

    TimeCostTrace(String str) {
        this.tag = str;
    }

    private static long currentTime() {
        return System.currentTimeMillis();
    }

    public static TimeCostTrace getTrace(String str) {
        if (map == null) {
            map = new HashMap<>();
        }
        TimeCostTrace timeCostTrace = map.get(str);
        if (timeCostTrace == null) {
            TimeCostTrace timeCostTrace2 = new TimeCostTrace(str);
            map.put(str, timeCostTrace2);
            return timeCostTrace2;
        }
        return timeCostTrace;
    }

    public static void removeTrace(String str) {
        TimeCostTrace timeCostTrace;
        HashMap<String, TimeCostTrace> hashMap = map;
        if (hashMap != null && (timeCostTrace = hashMap.get(str)) != null) {
            timeCostTrace.destroy();
            map.remove(str);
        }
    }

    public void destroy() {
        Map<String, long[]> map2 = this.timeMap;
        if (map2 != null) {
            map2.clear();
            this.mFirstTime = 0L;
            this.sceneId = 0;
            this.isColdBoot = false;
        }
    }

    public String dumpStepCost() {
        Map<String, long[]> map2 = this.timeMap;
        if (map2 != null && map2.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (String str : this.timeMap.keySet()) {
                long[] jArr = this.timeMap.get(str);
                if (jArr != null) {
                    sb5.append(str);
                    sb5.append(":");
                    if (jArr.length > 0) {
                        sb5.append(jArr[0] - this.mFirstTime);
                        sb5.append(",");
                    }
                    if (jArr.length > 1) {
                        sb5.append(jArr[1] - this.mFirstTime);
                    }
                    sb5.append(";");
                }
            }
            String substring = sb5.substring(0, sb5.length() - 1);
            QLog.i(this.tag, 1, "dump step cost detail:" + substring);
            return substring;
        }
        return "";
    }

    public String dumpStepCostV2() {
        Map<String, long[]> map2 = this.timeMap;
        if (map2 == null || map2.size() <= 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.timeMap);
        try {
            for (String str : hashMap.keySet()) {
                long[] jArr = (long[]) hashMap.get(str);
                if (jArr != null && jArr.length > 1) {
                    jSONObject.put(str, jArr[1] - jArr[0]);
                }
            }
        } catch (Exception e16) {
            QZLog.d(TAG_QZONE_LAUNCH, 4, "", e16);
        }
        return jSONObject.toString();
    }

    public long getStepCost(String str) {
        if (this.sceneId < 0) {
            QLog.e(this.tag, 2, "TimeCostTrace getStepCost sceneId<0");
            return -1L;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(this.tag, 2, "TimeCostTrace getStepCost code \u662f\u7a7a\u5b57\u7b26\u4e32");
            return -1L;
        }
        if (!this.timeMap.containsKey(str)) {
            QLog.e(this.tag, 2, str, "\u6ca1\u6709\u88ab\u8bb0\u5f55");
            return -1L;
        }
        long[] jArr = this.timeMap.get(str);
        if (jArr != null && jArr.length > 1) {
            return jArr[1] - jArr[0];
        }
        QLog.e(this.tag, 2, "TimeCostTrace getStepCost arr\u4e0d\u5408\u6cd5");
        return -1L;
    }

    public long getTimeCost() {
        if (this.timeMap != null && this.mFirstTime > 0 && this.sceneId >= 0) {
            long currentTime = currentTime() - this.mFirstTime;
            if (QLog.isColorLevel()) {
                QLog.d(this.tag, 2, "getTimeCost:" + currentTime);
            }
            return currentTime;
        }
        return -1L;
    }

    public Map<String, long[]> getTimeMap() {
        return this.timeMap;
    }

    public void markFirst() {
        markFirst(currentTime(), 0, false);
    }

    public void startStep(String str) {
        startStep(str, -1L);
    }

    public void stopStep(String str) {
        if (this.sceneId < 0 || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTime = currentTime();
        long[] jArr = this.timeMap.get(str);
        if (jArr == null) {
            jArr = new long[5];
            this.timeMap.put(str, jArr);
        }
        jArr[1] = currentTime;
        jArr[4] = Debug.threadCpuTimeNanos();
    }

    public void markFirst(long j3, int i3, boolean z16) {
        this.mFirstTime = j3;
        this.sceneId = i3;
        this.isColdBoot = z16;
        if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "TimeCostTrace--markFirst");
        }
    }

    public void startStep(String str, long j3) {
        if (this.sceneId >= 0 && !TextUtils.isEmpty(str)) {
            if (j3 <= 0) {
                j3 = currentTime();
            }
            long[] jArr = this.timeMap.get(str);
            if (jArr == null) {
                jArr = new long[5];
                this.timeMap.put(str, jArr);
            }
            jArr[0] = j3;
            jArr[2] = Thread.currentThread().getId();
            jArr[3] = Debug.threadCpuTimeNanos();
        }
    }
}
