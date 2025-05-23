package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes15.dex */
public final class PushRegisterInfo extends JceStruct {
    static ArrayList<Long> cache_pushIds;
    public byte bKikPC;
    public byte bKikWeak;
    public int batteryCapacity;
    public byte cBindUinNotifySwitch;
    public long extStatus;
    public long iLargeSeq;
    public int iStatus;
    public int powerConnect;
    public ArrayList<Long> pushIds;
    public long timeStamp;
    public String uin;

    public PushRegisterInfo() {
        this.uin = "";
        this.pushIds = null;
        this.iStatus = 0;
        this.bKikPC = (byte) 0;
        this.bKikWeak = (byte) 0;
        this.timeStamp = 0L;
        this.iLargeSeq = 0L;
        this.extStatus = -1L;
        this.batteryCapacity = 0;
        this.powerConnect = -1;
        this.cBindUinNotifySwitch = (byte) 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(1, true);
        if (cache_pushIds == null) {
            cache_pushIds = new ArrayList<>();
            cache_pushIds.add(0L);
        }
        this.pushIds = (ArrayList) jceInputStream.read((JceInputStream) cache_pushIds, 2, true);
        this.iStatus = jceInputStream.read(this.iStatus, 3, true);
        this.bKikPC = jceInputStream.read(this.bKikPC, 4, true);
        this.bKikWeak = jceInputStream.read(this.bKikWeak, 5, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 6, true);
        this.iLargeSeq = jceInputStream.read(this.iLargeSeq, 7, false);
        this.extStatus = jceInputStream.read(this.extStatus, 8, false);
        this.batteryCapacity = jceInputStream.read(this.batteryCapacity, 9, false);
        this.powerConnect = jceInputStream.read(this.powerConnect, 10, false);
        this.cBindUinNotifySwitch = jceInputStream.read(this.cBindUinNotifySwitch, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write((Collection) this.pushIds, 2);
        jceOutputStream.write(this.iStatus, 3);
        jceOutputStream.write(this.bKikPC, 4);
        jceOutputStream.write(this.bKikWeak, 5);
        jceOutputStream.write(this.timeStamp, 6);
        jceOutputStream.write(this.iLargeSeq, 7);
        jceOutputStream.write(this.extStatus, 8);
        jceOutputStream.write(this.batteryCapacity, 9);
        jceOutputStream.write(this.powerConnect, 10);
        jceOutputStream.write(this.cBindUinNotifySwitch, 11);
    }

    public PushRegisterInfo(String str, ArrayList<Long> arrayList, int i3, byte b16, byte b17, long j3, long j16, long j17) {
        this.batteryCapacity = 0;
        this.powerConnect = -1;
        this.cBindUinNotifySwitch = (byte) 1;
        this.uin = str;
        this.pushIds = arrayList;
        this.iStatus = i3;
        this.bKikPC = b16;
        this.bKikWeak = b17;
        this.timeStamp = j3;
        this.iLargeSeq = j16;
        this.extStatus = j17;
    }
}
