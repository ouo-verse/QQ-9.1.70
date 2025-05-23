package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ReportLogRequest extends JceStruct {
    static byte[] cache_logData;
    public String hostAppPackageName;
    public int hostAppVersion;
    public String hostUserId;
    public byte[] logData;
    public int logType;

    public ReportLogRequest() {
        this.logType = 0;
        this.logData = null;
        this.hostUserId = "";
        this.hostAppPackageName = "";
        this.hostAppVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.logType = jceInputStream.read(this.logType, 0, false);
        if (cache_logData == null) {
            cache_logData = r0;
            byte[] bArr = {0};
        }
        this.logData = jceInputStream.read(cache_logData, 1, false);
        this.hostUserId = jceInputStream.readString(2, false);
        this.hostAppPackageName = jceInputStream.readString(3, false);
        this.hostAppVersion = jceInputStream.read(this.hostAppVersion, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.logType, 0);
        byte[] bArr = this.logData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        String str = this.hostUserId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.hostAppPackageName;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.hostAppVersion, 4);
    }

    public ReportLogRequest(int i3, byte[] bArr, String str, String str2, int i16) {
        this.logType = i3;
        this.logData = bArr;
        this.hostUserId = str;
        this.hostAppPackageName = str2;
        this.hostAppVersion = i16;
    }
}
