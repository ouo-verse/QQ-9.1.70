package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdSceneDesc extends JceStruct {
    static AdDeviceStatusInfo cache_deviceStatusInfo = new AdDeviceStatusInfo();
    static AdInsideSceneDesc cache_insideSceneDesc = new AdInsideSceneDesc();
    static int cache_startType;
    public int coldStart;
    public AdDeviceStatusInfo deviceStatusInfo;
    public int dwellTime;
    public AdInsideSceneDesc insideSceneDesc;
    public String sessionId;
    public int startType;

    public AdSceneDesc() {
        this.startType = 0;
        this.coldStart = 0;
        this.sessionId = "";
        this.dwellTime = 0;
        this.deviceStatusInfo = null;
        this.insideSceneDesc = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.startType = jceInputStream.read(this.startType, 0, false);
        this.coldStart = jceInputStream.read(this.coldStart, 1, false);
        this.sessionId = jceInputStream.readString(2, false);
        this.dwellTime = jceInputStream.read(this.dwellTime, 3, false);
        this.deviceStatusInfo = (AdDeviceStatusInfo) jceInputStream.read((JceStruct) cache_deviceStatusInfo, 4, false);
        this.insideSceneDesc = (AdInsideSceneDesc) jceInputStream.read((JceStruct) cache_insideSceneDesc, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.startType, 0);
        jceOutputStream.write(this.coldStart, 1);
        String str = this.sessionId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.dwellTime, 3);
        AdDeviceStatusInfo adDeviceStatusInfo = this.deviceStatusInfo;
        if (adDeviceStatusInfo != null) {
            jceOutputStream.write((JceStruct) adDeviceStatusInfo, 4);
        }
        AdInsideSceneDesc adInsideSceneDesc = this.insideSceneDesc;
        if (adInsideSceneDesc != null) {
            jceOutputStream.write((JceStruct) adInsideSceneDesc, 5);
        }
    }

    public AdSceneDesc(int i3, int i16, String str, int i17, AdDeviceStatusInfo adDeviceStatusInfo, AdInsideSceneDesc adInsideSceneDesc) {
        this.startType = i3;
        this.coldStart = i16;
        this.sessionId = str;
        this.dwellTime = i17;
        this.deviceStatusInfo = adDeviceStatusInfo;
        this.insideSceneDesc = adInsideSceneDesc;
    }
}
