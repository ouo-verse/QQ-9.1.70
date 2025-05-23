package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchBatchDeleteSessionReq {
    public boolean isAllSelect;
    public ArrayList<String> deleteSessionIds = new ArrayList<>();
    public ArrayList<String> reserveSessionIds = new ArrayList<>();

    public ArrayList<String> getDeleteSessionIds() {
        return this.deleteSessionIds;
    }

    public boolean getIsAllSelect() {
        return this.isAllSelect;
    }

    public ArrayList<String> getReserveSessionIds() {
        return this.reserveSessionIds;
    }

    public String toString() {
        return "GProAISearchBatchDeleteSessionReq{deleteSessionIds=" + this.deleteSessionIds + ",reserveSessionIds=" + this.reserveSessionIds + ",isAllSelect=" + this.isAllSelect + ",}";
    }
}
