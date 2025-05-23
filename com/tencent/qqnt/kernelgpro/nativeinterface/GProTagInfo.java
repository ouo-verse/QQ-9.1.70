package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTagInfo implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    public long f359313id;
    public long setTime;
    long serialVersionUID = 1;
    public String desc = "";

    public String getDesc() {
        return this.desc;
    }

    public long getId() {
        return this.f359313id;
    }

    public long getSetTime() {
        return this.setTime;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setId(long j3) {
        this.f359313id = j3;
    }

    public void setSetTime(long j3) {
        this.setTime = j3;
    }

    public String toString() {
        return "GProTagInfo{id=" + this.f359313id + ",desc=" + this.desc + ",setTime=" + this.setTime + ",}";
    }
}
