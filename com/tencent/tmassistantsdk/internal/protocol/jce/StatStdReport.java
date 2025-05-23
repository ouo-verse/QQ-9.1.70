package com.tencent.tmassistantsdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class StatStdReport extends JceStruct {
    public String extraData;
    public String name;
    public int scene;
    public long time;
    public String traceId;
    public String versionInfo;

    public StatStdReport() {
        this.name = "";
        this.scene = 0;
        this.extraData = "";
        this.time = 0L;
        this.versionInfo = "";
        this.traceId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, true);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.extraData = jceInputStream.readString(2, false);
        this.time = jceInputStream.read(this.time, 3, false);
        this.versionInfo = jceInputStream.readString(4, false);
        this.traceId = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.name, 0);
        jceOutputStream.write(this.scene, 1);
        String str = this.extraData;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.time, 3);
        String str2 = this.versionInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.traceId;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public StatStdReport(String str, int i3, String str2, long j3, String str3, String str4) {
        this.name = str;
        this.scene = i3;
        this.extraData = str2;
        this.time = j3;
        this.versionInfo = str3;
        this.traceId = str4;
    }
}
