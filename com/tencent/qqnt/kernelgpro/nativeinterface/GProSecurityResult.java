package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSecurityResult implements Serializable {
    public long action;
    long serialVersionUID;
    public String strDetail;
    public String strPrompt;

    public GProSecurityResult() {
        this.serialVersionUID = 1L;
        this.strPrompt = "";
        this.strDetail = "";
    }

    public long getAction() {
        return this.action;
    }

    public String getStrDetail() {
        return this.strDetail;
    }

    public String getStrPrompt() {
        return this.strPrompt;
    }

    public String toString() {
        return "GProSecurityResult{action=" + this.action + ",strPrompt=" + this.strPrompt + ",strDetail=" + this.strDetail + ",}";
    }

    public GProSecurityResult(long j3, String str, String str2) {
        this.serialVersionUID = 1L;
        this.action = j3;
        this.strPrompt = str;
        this.strDetail = str2;
    }
}
