package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdVideoInfo extends JceStruct {
    static int cache_castType;
    static int cache_encodeProtocolType;
    public int castType;
    public String coverId;
    public String defn;
    public int encodeProtocolType;
    public String flowId;
    public int isLive;
    public String lid;
    public String livepId;
    public String preVid;
    public long startTime;
    public int tpId;
    public String vid;

    public AdVideoInfo() {
        this.vid = "";
        this.coverId = "";
        this.isLive = 0;
        this.livepId = "";
        this.lid = "";
        this.tpId = 0;
        this.defn = "";
        this.preVid = "";
        this.startTime = 0L;
        this.flowId = "";
        this.encodeProtocolType = 0;
        this.castType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vid = jceInputStream.readString(0, false);
        this.coverId = jceInputStream.readString(1, false);
        this.isLive = jceInputStream.read(this.isLive, 2, false);
        this.livepId = jceInputStream.readString(3, false);
        this.lid = jceInputStream.readString(4, false);
        this.tpId = jceInputStream.read(this.tpId, 5, false);
        this.defn = jceInputStream.readString(6, false);
        this.preVid = jceInputStream.readString(7, false);
        this.startTime = jceInputStream.read(this.startTime, 8, false);
        this.flowId = jceInputStream.readString(9, false);
        this.encodeProtocolType = jceInputStream.read(this.encodeProtocolType, 10, false);
        this.castType = jceInputStream.read(this.castType, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.coverId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.isLive, 2);
        String str3 = this.livepId;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.lid;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.tpId, 5);
        String str5 = this.defn;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.preVid;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        jceOutputStream.write(this.startTime, 8);
        String str7 = this.flowId;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
        jceOutputStream.write(this.encodeProtocolType, 10);
        jceOutputStream.write(this.castType, 11);
    }

    public AdVideoInfo(String str, String str2, int i3, String str3, String str4, int i16, String str5, String str6, long j3, String str7, int i17, int i18) {
        this.vid = str;
        this.coverId = str2;
        this.isLive = i3;
        this.livepId = str3;
        this.lid = str4;
        this.tpId = i16;
        this.defn = str5;
        this.preVid = str6;
        this.startTime = j3;
        this.flowId = str7;
        this.encodeProtocolType = i17;
        this.castType = i18;
    }
}
