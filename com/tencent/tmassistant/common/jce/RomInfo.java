package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class RomInfo extends JceStruct {
    public int rootFlag;
    public String sysId;
    public String sysVersionCode;
    public String sysVersionName;

    public RomInfo() {
        this.sysId = "";
        this.sysVersionName = "";
        this.sysVersionCode = "";
        this.rootFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sysId = jceInputStream.readString(0, false);
        this.sysVersionName = jceInputStream.readString(1, false);
        this.sysVersionCode = jceInputStream.readString(2, false);
        this.rootFlag = jceInputStream.read(this.rootFlag, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sysId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sysVersionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sysVersionCode;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.rootFlag, 3);
    }

    public RomInfo(String str, String str2, String str3, int i3) {
        this.sysId = str;
        this.sysVersionName = str2;
        this.sysVersionCode = str3;
        this.rootFlag = i3;
    }
}
