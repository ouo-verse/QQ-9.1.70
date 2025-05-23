package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class TianShuAdPosItemData {
    public HashMap<String, String> mExtraData;
    public int mNeedCnt;
    public int mPosId;

    public TianShuAdPosItemData() {
    }

    public HashMap<String, String> getMExtraData() {
        return this.mExtraData;
    }

    public int getMNeedCnt() {
        return this.mNeedCnt;
    }

    public int getMPosId() {
        return this.mPosId;
    }

    public String toString() {
        return "TianShuAdPosItemData{mPosId=" + this.mPosId + ",mNeedCnt=" + this.mNeedCnt + ",mExtraData=" + this.mExtraData + ",}";
    }

    public TianShuAdPosItemData(int i3, int i16, HashMap<String, String> hashMap) {
        this.mPosId = i3;
        this.mNeedCnt = i16;
        this.mExtraData = hashMap;
    }
}
