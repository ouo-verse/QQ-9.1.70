package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StFeedCellCommon {
    public int appId;
    public int bizId;
    public String clientKey;
    public String curLikeKey;
    public ArrayList<BytesEntry> extendInfo;
    public String feedId;
    public int subId;
    public long time;

    public StFeedCellCommon() {
        this.feedId = "";
        this.curLikeKey = "";
        this.clientKey = "";
        this.extendInfo = new ArrayList<>();
    }

    public int getAppId() {
        return this.appId;
    }

    public int getBizId() {
        return this.bizId;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public String getCurLikeKey() {
        return this.curLikeKey;
    }

    public ArrayList<BytesEntry> getExtendInfo() {
        return this.extendInfo;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getSubId() {
        return this.subId;
    }

    public long getTime() {
        return this.time;
    }

    public void setAppId(int i3) {
        this.appId = i3;
    }

    public void setBizId(int i3) {
        this.bizId = i3;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    public void setCurLikeKey(String str) {
        this.curLikeKey = str;
    }

    public void setExtendInfo(ArrayList<BytesEntry> arrayList) {
        this.extendInfo = arrayList;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setSubId(int i3) {
        this.subId = i3;
    }

    public void setTime(long j3) {
        this.time = j3;
    }

    public StFeedCellCommon(int i3, int i16, long j3, String str, String str2, int i17, String str3, ArrayList<BytesEntry> arrayList) {
        this.feedId = "";
        this.curLikeKey = "";
        this.clientKey = "";
        new ArrayList();
        this.appId = i3;
        this.subId = i16;
        this.time = j3;
        this.feedId = str;
        this.curLikeKey = str2;
        this.bizId = i17;
        this.clientKey = str3;
        this.extendInfo = arrayList;
    }
}
