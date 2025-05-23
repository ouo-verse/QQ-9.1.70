package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProQQMsgSubscribe implements Serializable {
    public int isSubscribe;
    long serialVersionUID = 1;
    public long subscribeTimestamp;
    public int subscribeType;
    public long topTimestamp;

    public int getIsSubscribe() {
        return this.isSubscribe;
    }

    public long getSubscribeTimestamp() {
        return this.subscribeTimestamp;
    }

    public int getSubscribeType() {
        return this.subscribeType;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public void setIsSubscribe(int i3) {
        this.isSubscribe = i3;
    }

    public void setSubscribeTimestamp(long j3) {
        this.subscribeTimestamp = j3;
    }

    public void setSubscribeType(int i3) {
        this.subscribeType = i3;
    }

    public void setTopTimestamp(long j3) {
        this.topTimestamp = j3;
    }

    public String toString() {
        return "GProQQMsgSubscribe{isSubscribe=" + this.isSubscribe + ",topTimestamp=" + this.topTimestamp + ",subscribeTimestamp=" + this.subscribeTimestamp + ",subscribeType=" + this.subscribeType + ",}";
    }
}
