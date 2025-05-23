package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPreventAddictionPushInfo implements Serializable {
    public long closeMask;
    public long duration;
    public String instrTraceId;
    public ArrayList<GProPAInstructionInfo> instructions;

    /* renamed from: msg, reason: collision with root package name */
    public String f359309msg;
    public int ret;
    long serialVersionUID;
    public long uin;

    public GProPreventAddictionPushInfo() {
        this.serialVersionUID = 1L;
        this.f359309msg = "";
        this.instructions = new ArrayList<>();
        this.instrTraceId = "";
    }

    public long getCloseMask() {
        return this.closeMask;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getInstrTraceId() {
        return this.instrTraceId;
    }

    public ArrayList<GProPAInstructionInfo> getInstructions() {
        return this.instructions;
    }

    public String getMsg() {
        return this.f359309msg;
    }

    public int getRet() {
        return this.ret;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProPreventAddictionPushInfo{uin=" + this.uin + ",ret=" + this.ret + ",msg=" + this.f359309msg + ",instructions=" + this.instructions + ",duration=" + this.duration + ",instrTraceId=" + this.instrTraceId + ",closeMask=" + this.closeMask + ",}";
    }

    public GProPreventAddictionPushInfo(long j3, int i3, String str, ArrayList<GProPAInstructionInfo> arrayList, long j16, String str2, long j17) {
        this.serialVersionUID = 1L;
        this.f359309msg = "";
        new ArrayList();
        this.uin = j3;
        this.ret = i3;
        this.f359309msg = str;
        this.instructions = arrayList;
        this.duration = j16;
        this.instrTraceId = str2;
        this.closeMask = j17;
    }
}
