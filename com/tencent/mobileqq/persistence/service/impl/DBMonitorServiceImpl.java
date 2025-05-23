package com.tencent.mobileqq.persistence.service.impl;

import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.persistence.DBMonitorConfigProcessor;
import com.tencent.mobileqq.persistence.service.IDBMonitorService;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DBMonitorServiceImpl implements IDBMonitorService {
    private static final int DB_DEBUG_REPORT_SAMPLING = 1;
    private static final int MARKET_DEBUG_DB_COST_SAMPLING = 200;
    private final DBMonitorConfigProcessor.a mConfig = DBMonitorConfigProcessor.a();

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public int getDBSizeReportedSampling() {
        return this.mConfig.f258295f;
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public int getMarketDBCostReportedSampling(String str) {
        int i3 = this.mConfig.f258300k;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1335458389:
                if (str.equals("delete")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1319603331:
                if (str.equals(SQLiteDatabase.OPERATE_TYPE_EXEC_SQL)) {
                    c16 = 1;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c16 = 2;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c16 = 3;
                    break;
                }
                break;
            case 490686848:
                if (str.equals(SQLiteDatabase.OPERATE_TYPE_RAW_QUERY)) {
                    c16 = 4;
                    break;
                }
                break;
            case 1094496948:
                if (str.equals(SQLiteDatabase.OPERATE_TYPE_REPLACE)) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return this.mConfig.f258302m;
            case 1:
                return this.mConfig.f258299j;
            case 2:
                return this.mConfig.f258301l;
            case 3:
                return this.mConfig.f258303n;
            case 4:
                return this.mConfig.f258297h;
            case 5:
                return this.mConfig.f258298i;
            default:
                return i3;
        }
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public int getOperateCostReportedSampling() {
        return this.mConfig.f258293d;
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public int getOperateCostReportedThreshold() {
        return this.mConfig.f258291b;
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public boolean isDBSizeReported() {
        return this.mConfig.f258294e;
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public boolean isMarketDBCostReported() {
        return this.mConfig.f258296g;
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public boolean isOperateCostReported() {
        return this.mConfig.f258290a;
    }

    @Override // com.tencent.mobileqq.persistence.service.IDBMonitorService
    public void reportDBEventByBeacon(String str, String str2, Map<String, String> map) {
        QQBeaconReport.report(str, str2, map);
    }
}
