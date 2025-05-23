package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes24.dex */
public final class XmlToJsonParam implements Serializable {
    public long busiId;
    public long busiType;
    public int c2cType;
    public String content;
    public int ctrlFlag;
    public HashMap<String, String> members;
    public byte[] pbReserv;
    public Long seqId;
    long serialVersionUID;
    public int serviceType;
    public Long templId;
    public HashMap<String, String> templParam;

    public XmlToJsonParam() {
        this.serialVersionUID = 1L;
        this.content = "";
    }

    public long getBusiId() {
        return this.busiId;
    }

    public long getBusiType() {
        return this.busiType;
    }

    public int getC2cType() {
        return this.c2cType;
    }

    public String getContent() {
        return this.content;
    }

    public int getCtrlFlag() {
        return this.ctrlFlag;
    }

    public HashMap<String, String> getMembers() {
        return this.members;
    }

    public byte[] getPbReserv() {
        return this.pbReserv;
    }

    public Long getSeqId() {
        return this.seqId;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public Long getTemplId() {
        return this.templId;
    }

    public HashMap<String, String> getTemplParam() {
        return this.templParam;
    }

    public String toString() {
        return "XmlToJsonParam{busiType=" + this.busiType + ",busiId=" + this.busiId + ",c2cType=" + this.c2cType + ",serviceType=" + this.serviceType + ",ctrlFlag=" + this.ctrlFlag + ",content=" + this.content + ",templId=" + this.templId + ",seqId=" + this.seqId + ",templParam=" + this.templParam + ",pbReserv=" + this.pbReserv + ",members=" + this.members + ",}";
    }

    public XmlToJsonParam(long j3, long j16, int i3, int i16, int i17, String str, Long l3, Long l16, HashMap<String, String> hashMap, byte[] bArr, HashMap<String, String> hashMap2) {
        this.serialVersionUID = 1L;
        this.busiType = j3;
        this.busiId = j16;
        this.c2cType = i3;
        this.serviceType = i16;
        this.ctrlFlag = i17;
        this.content = str;
        this.templId = l3;
        this.seqId = l16;
        this.templParam = hashMap;
        this.pbReserv = bArr;
        this.members = hashMap2;
    }
}
