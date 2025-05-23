package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RdmReq extends JceStruct {
    static Map<String, String> cache_params;
    public String appKey;
    public long elapse;
    public String eventName;
    public boolean isImmediatelyUpload;
    public boolean isMerge;
    public boolean isRealTime;
    public boolean isSucceed;
    public Map<String, String> params;
    public int reportType;
    public long size;

    static {
        HashMap hashMap = new HashMap();
        cache_params = hashMap;
        hashMap.put("", "");
    }

    public RdmReq() {
        this.reportType = 0;
        this.eventName = "";
        this.isSucceed = true;
        this.elapse = 0L;
        this.size = 0L;
        this.params = null;
        this.isRealTime = false;
        this.isMerge = false;
        this.appKey = "";
        this.isImmediatelyUpload = false;
    }

    public String className() {
        return "rdm.RdmReq";
    }

    public String fullClassName() {
        return "rdm.RdmReq";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reportType = jceInputStream.read(this.reportType, 1, true);
        this.eventName = jceInputStream.readString(2, true);
        this.isSucceed = jceInputStream.read(this.isSucceed, 3, true);
        this.elapse = jceInputStream.read(this.elapse, 4, true);
        this.size = jceInputStream.read(this.size, 5, true);
        this.params = (Map) jceInputStream.read((JceInputStream) cache_params, 6, true);
        this.isRealTime = jceInputStream.read(this.isRealTime, 7, true);
        this.isMerge = jceInputStream.read(this.isMerge, 8, true);
        this.appKey = jceInputStream.readString(9, false);
        this.isImmediatelyUpload = jceInputStream.read(this.isImmediatelyUpload, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "RdmReq{reportType=" + this.reportType + ", eventName='" + this.eventName + "', isSucceed=" + this.isSucceed + ", elapse=" + this.elapse + ", size=" + this.size + ", params=" + this.params + ", isRealTime=" + this.isRealTime + ", isMerge=" + this.isMerge + ", appKey='" + this.appKey + "', isImmediatelyUpload=" + this.isImmediatelyUpload + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reportType, 1);
        jceOutputStream.write(this.eventName, 2);
        jceOutputStream.write(this.isSucceed, 3);
        jceOutputStream.write(this.elapse, 4);
        jceOutputStream.write(this.size, 5);
        jceOutputStream.write((Map) this.params, 6);
        jceOutputStream.write(this.isRealTime, 7);
        jceOutputStream.write(this.isMerge, 8);
        String str = this.appKey;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.isImmediatelyUpload, 10);
    }

    public RdmReq(int i3, String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18, String str2, boolean z19) {
        this.reportType = i3;
        this.eventName = str;
        this.isSucceed = z16;
        this.elapse = j3;
        this.size = j16;
        this.params = map;
        this.isRealTime = z17;
        this.isMerge = z18;
        this.appKey = str2;
        this.isImmediatelyUpload = z19;
    }
}
