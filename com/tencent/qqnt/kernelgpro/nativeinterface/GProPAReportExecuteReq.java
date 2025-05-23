package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPAReportExecuteReq implements Serializable {
    public long execTime;
    public String instrTraceId;
    public ArrayList<String> ruleNameList;
    long serialVersionUID;

    public GProPAReportExecuteReq() {
        this.serialVersionUID = 1L;
        this.ruleNameList = new ArrayList<>();
        this.instrTraceId = "";
    }

    public long getExecTime() {
        return this.execTime;
    }

    public String getInstrTraceId() {
        return this.instrTraceId;
    }

    public ArrayList<String> getRuleNameList() {
        return this.ruleNameList;
    }

    public void setExecTime(long j3) {
        this.execTime = j3;
    }

    public void setInstrTraceId(String str) {
        this.instrTraceId = str;
    }

    public void setRuleNameList(ArrayList<String> arrayList) {
        this.ruleNameList = arrayList;
    }

    public String toString() {
        return "GProPAReportExecuteReq{ruleNameList=" + this.ruleNameList + ",instrTraceId=" + this.instrTraceId + ",execTime=" + this.execTime + ",}";
    }

    public GProPAReportExecuteReq(ArrayList<String> arrayList, String str, long j3) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.ruleNameList = arrayList;
        this.instrTraceId = str;
        this.execTime = j3;
    }
}
