package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Verify implements IKernelModel {
    public String randStr;
    public String ticket;
    public String token;
    public int type;

    public Verify() {
        this.ticket = "";
        this.randStr = "";
        this.token = "";
    }

    public String getRandStr() {
        return this.randStr;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setRandStr(String str) {
        this.randStr = str;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public Verify(int i3, String str, String str2, String str3) {
        this.type = i3;
        this.ticket = str;
        this.randStr = str2;
        this.token = str3;
    }
}
