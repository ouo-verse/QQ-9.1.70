package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideTraceInfo extends JceStruct {
    public String sceneId;
    public String traceId;
    public long videoStartTime;

    public AdInsideTraceInfo() {
        this.traceId = "";
        this.sceneId = "";
        this.videoStartTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.traceId = jceInputStream.readString(0, false);
        this.sceneId = jceInputStream.readString(1, false);
        this.videoStartTime = jceInputStream.read(this.videoStartTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.traceId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sceneId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.videoStartTime, 2);
    }

    public AdInsideTraceInfo(String str, String str2, long j3) {
        this.traceId = str;
        this.sceneId = str2;
        this.videoStartTime = j3;
    }
}
