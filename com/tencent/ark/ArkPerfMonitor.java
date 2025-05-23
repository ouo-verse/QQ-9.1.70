package com.tencent.ark;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
class ArkPerfMonitor {
    private static final ArkPerfMonitor _instance = new ArkPerfMonitor();
    private final HashMap<PerfRecordKey, PerfRecord> _records = new HashMap<>();

    /* loaded from: classes3.dex */
    public interface IReport {
        void report(String str, String str2, int i3);
    }

    /* loaded from: classes3.dex */
    private static class PerfRecord {
        public int count;
        public double totalTime;

        PerfRecord() {
            this.totalTime = 0.0d;
            this.count = 1;
        }
    }

    /* loaded from: classes3.dex */
    private static class PerfRecordKey {
        public final String appID;
        public final String view;

        PerfRecordKey(String str, String str2) {
            this.appID = str;
            this.view = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                PerfRecordKey perfRecordKey = (PerfRecordKey) obj;
                if (this.appID.equals(perfRecordKey.appID) && this.view.equals(perfRecordKey.view)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.appID.hashCode() + this.view.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    private static class ReportItem {
        public String appID;
        int time;
        public String view;

        ReportItem() {
        }
    }

    ArkPerfMonitor() {
    }

    public static ArkPerfMonitor getInstance() {
        return _instance;
    }

    public void addRecord(String str, String str2, long j3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j3 < 30) {
            return;
        }
        synchronized (this._records) {
            PerfRecord perfRecord = this._records.get(new PerfRecordKey(str, str2));
            if (perfRecord == null) {
                perfRecord = new PerfRecord();
                this._records.put(new PerfRecordKey(str, str2), perfRecord);
            }
            perfRecord.totalTime += j3;
            perfRecord.count++;
        }
    }

    public void doReport(String str, String str2, IReport iReport) {
        int i3;
        synchronized (this._records) {
            PerfRecord perfRecord = this._records.get(new PerfRecordKey(str, str2));
            i3 = 0;
            if (perfRecord != null) {
                int i16 = (int) (perfRecord.totalTime / perfRecord.count);
                perfRecord.count = 0;
                perfRecord.totalTime = 0.0d;
                i3 = i16;
            }
        }
        if (i3 != 0 && iReport != null) {
            iReport.report(str, str2, i3);
        }
    }
}
