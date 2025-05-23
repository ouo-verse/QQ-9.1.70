package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RMBeaconReportInfo {
    public RMBizTypeEnum bizType;
    public String eventCode;
    public boolean isRealTime;
    public boolean isSuc;
    public String md5HexStr;
    public ArrayList<HashMap<String, String>> reportInfos;
    public int storeID;
    public int transType;

    public RMBeaconReportInfo() {
        this.eventCode = "";
        this.bizType = RMBizTypeEnum.values()[0];
        this.reportInfos = new ArrayList<>();
        this.md5HexStr = "";
    }

    public RMBizTypeEnum getBizType() {
        return this.bizType;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public boolean getIsRealTime() {
        return this.isRealTime;
    }

    public boolean getIsSuc() {
        return this.isSuc;
    }

    public String getMd5HexStr() {
        return this.md5HexStr;
    }

    public ArrayList<HashMap<String, String>> getReportInfos() {
        return this.reportInfos;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public int getTransType() {
        return this.transType;
    }

    public RMBeaconReportInfo(String str, RMBizTypeEnum rMBizTypeEnum, boolean z16, boolean z17, ArrayList<HashMap<String, String>> arrayList, int i3, int i16, String str2) {
        this.eventCode = "";
        this.bizType = RMBizTypeEnum.values()[0];
        new ArrayList();
        this.eventCode = str;
        this.bizType = rMBizTypeEnum;
        this.isSuc = z16;
        this.isRealTime = z17;
        this.reportInfos = arrayList;
        this.storeID = i3;
        this.transType = i16;
        this.md5HexStr = str2;
    }
}
