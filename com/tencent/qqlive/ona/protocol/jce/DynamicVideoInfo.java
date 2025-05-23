package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DynamicVideoInfo extends JceStruct {
    public String cid;
    public String vid;
    public long videoLeftInterval;
    public long videoWatchedTime;

    public DynamicVideoInfo() {
        this.videoWatchedTime = 0L;
        this.videoLeftInterval = 0L;
        this.vid = "";
        this.cid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.videoWatchedTime = jceInputStream.read(this.videoWatchedTime, 0, false);
        this.videoLeftInterval = jceInputStream.read(this.videoLeftInterval, 1, false);
        this.vid = jceInputStream.readString(2, false);
        this.cid = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.videoWatchedTime, 0);
        jceOutputStream.write(this.videoLeftInterval, 1);
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.cid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public DynamicVideoInfo(long j3, long j16, String str, String str2) {
        this.videoWatchedTime = j3;
        this.videoLeftInterval = j16;
        this.vid = str;
        this.cid = str2;
    }
}
