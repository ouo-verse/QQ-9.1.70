package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TerminalExtra extends JceStruct {
    public String abiList;
    public short apiLevel;
    public int cpuCoresNum;
    public int cpuMaxFreq;
    public int cpuMinFreq;
    public String cpuName;
    public String fingerprint;
    public int flashRemainSize;
    public int flashTotalSize;
    public String model;
    public int ramRemainSize;
    public long ramTotalSize;
    public String romName;
    public String romVersion;
    public short storageSpeed;

    public TerminalExtra() {
        this.cpuName = "";
        this.cpuCoresNum = 0;
        this.cpuMaxFreq = 0;
        this.cpuMinFreq = 0;
        this.ramTotalSize = 0L;
        this.romName = "";
        this.romVersion = "";
        this.fingerprint = "";
        this.model = "";
        this.apiLevel = (short) 0;
        this.storageSpeed = (short) 0;
        this.abiList = "";
        this.ramRemainSize = 0;
        this.flashTotalSize = 0;
        this.flashRemainSize = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cpuName = jceInputStream.readString(0, false);
        this.cpuCoresNum = jceInputStream.read(this.cpuCoresNum, 1, false);
        this.cpuMaxFreq = jceInputStream.read(this.cpuMaxFreq, 2, false);
        this.cpuMinFreq = jceInputStream.read(this.cpuMinFreq, 3, false);
        this.ramTotalSize = jceInputStream.read(this.ramTotalSize, 4, false);
        this.romName = jceInputStream.readString(5, false);
        this.romVersion = jceInputStream.readString(6, false);
        this.fingerprint = jceInputStream.readString(7, false);
        this.model = jceInputStream.readString(8, false);
        this.apiLevel = jceInputStream.read(this.apiLevel, 9, false);
        this.storageSpeed = jceInputStream.read(this.storageSpeed, 10, false);
        this.abiList = jceInputStream.readString(11, false);
        this.ramRemainSize = jceInputStream.read(this.ramRemainSize, 12, false);
        this.flashTotalSize = jceInputStream.read(this.flashTotalSize, 13, false);
        this.flashRemainSize = jceInputStream.read(this.flashRemainSize, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cpuName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.cpuCoresNum, 1);
        jceOutputStream.write(this.cpuMaxFreq, 2);
        jceOutputStream.write(this.cpuMinFreq, 3);
        jceOutputStream.write(this.ramTotalSize, 4);
        String str2 = this.romName;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.romVersion;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.fingerprint;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.model;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.apiLevel, 9);
        jceOutputStream.write(this.storageSpeed, 10);
        String str6 = this.abiList;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        jceOutputStream.write(this.ramRemainSize, 12);
        jceOutputStream.write(this.flashTotalSize, 13);
        jceOutputStream.write(this.flashRemainSize, 14);
    }

    public TerminalExtra(String str, int i3, int i16, int i17, long j3, String str2, String str3, String str4, String str5, short s16, short s17, String str6, int i18, int i19, int i26) {
        this.cpuName = str;
        this.cpuCoresNum = i3;
        this.cpuMaxFreq = i16;
        this.cpuMinFreq = i17;
        this.ramTotalSize = j3;
        this.romName = str2;
        this.romVersion = str3;
        this.fingerprint = str4;
        this.model = str5;
        this.apiLevel = s16;
        this.storageSpeed = s17;
        this.abiList = str6;
        this.ramRemainSize = i18;
        this.flashTotalSize = i19;
        this.flashRemainSize = i26;
    }
}
