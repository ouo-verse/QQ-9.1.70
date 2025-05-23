package com.tencent.qqmini.v8rt.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SpeedUtil {
    public static final SpeedUtil DEFAULT = new SpeedUtil("default");
    public static final String TAG = "SpdUtl";
    private final Map<String, ReportPoint> mPoints = new LinkedHashMap();
    private final String name;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ReportPoint implements Comparable<ReportPoint> {
        long startTs = 0;
        String event = "";

        @Override // java.lang.Comparable
        public int compareTo(ReportPoint reportPoint) {
            long j3 = this.startTs - reportPoint.startTs;
            if (j3 < 0) {
                return -1;
            }
            return j3 > 0 ? 1 : 0;
        }
    }

    public SpeedUtil(String str) {
        this.name = str;
    }

    public synchronized void clear() {
        this.mPoints.clear();
    }

    public synchronized void event(String str) {
        ReportPoint reportPoint = this.mPoints.get(str);
        if (reportPoint == null) {
            reportPoint = new ReportPoint();
            this.mPoints.put(str, reportPoint);
        } else {
            Logger.w(TAG, "operation " + str + " already exists");
        }
        reportPoint.event = str;
        reportPoint.startTs = System.currentTimeMillis();
    }

    public synchronized void report(String... strArr) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            list = Arrays.asList(strArr);
        } else {
            list = null;
        }
        Iterator<Map.Entry<String, ReportPoint>> it = this.mPoints.entrySet().iterator();
        while (it.hasNext()) {
            ReportPoint value = it.next().getValue();
            if (list != null) {
                if (list.contains(value.event)) {
                    arrayList.add(value);
                }
            } else {
                arrayList.add(value);
            }
        }
        Collections.sort(arrayList);
        Iterator it5 = arrayList.iterator();
        long j3 = -1;
        long j16 = -1;
        while (it5.hasNext()) {
            ReportPoint reportPoint = (ReportPoint) it5.next();
            if (j3 == -1) {
                j3 = reportPoint.startTs;
            }
            if (j16 == -1) {
                j16 = reportPoint.startTs;
            }
            Logger.d(TAG, reportPoint.event + "->" + reportPoint.startTs + ",diff=" + (reportPoint.startTs - j3));
            j3 = reportPoint.startTs;
        }
        Logger.d(TAG, this.name + " total:" + (j3 - j16));
    }
}
