package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPreventAddictionCheckRsp implements Serializable {
    public String context;
    public String instrTraceId;
    public ArrayList<GProPAInstructionInfo> instructions;

    /* renamed from: msg, reason: collision with root package name */
    public String f359308msg;
    public int ret;
    long serialVersionUID;

    public GProPreventAddictionCheckRsp() {
        this.serialVersionUID = 1L;
        this.f359308msg = "";
        this.context = "";
        this.instrTraceId = "";
        this.instructions = new ArrayList<>();
    }

    public String getContext() {
        return this.context;
    }

    public String getInstrTraceId() {
        return this.instrTraceId;
    }

    public ArrayList<GProPAInstructionInfo> getInstructions() {
        return this.instructions;
    }

    public String getMsg() {
        return this.f359308msg;
    }

    public int getRet() {
        return this.ret;
    }

    public String toString() {
        return "GProPreventAddictionCheckRsp{ret=" + this.ret + ",msg=" + this.f359308msg + ",context=" + this.context + ",instrTraceId=" + this.instrTraceId + ",instructions=" + this.instructions + ",}";
    }

    public GProPreventAddictionCheckRsp(int i3, String str, String str2, String str3, ArrayList<GProPAInstructionInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.f359308msg = "";
        this.context = "";
        this.instrTraceId = "";
        new ArrayList();
        this.ret = i3;
        this.f359308msg = str;
        this.context = str2;
        this.instrTraceId = str3;
        this.instructions = arrayList;
    }
}
