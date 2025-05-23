package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DebugInfo extends JceStruct {
    public String info;
    public String info1;
    public String info2;
    public String info3;
    public String info4;
    public String info5;

    public DebugInfo() {
        this.info = "";
        this.info1 = "";
        this.info2 = "";
        this.info3 = "";
        this.info4 = "";
        this.info5 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.info = jceInputStream.readString(0, false);
        this.info1 = jceInputStream.readString(1, false);
        this.info2 = jceInputStream.readString(2, false);
        this.info3 = jceInputStream.readString(3, false);
        this.info4 = jceInputStream.readString(4, false);
        this.info5 = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.info;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.info1;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.info2;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.info3;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.info4;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.info5;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
    }

    public DebugInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.info = str;
        this.info1 = str2;
        this.info2 = str3;
        this.info3 = str4;
        this.info4 = str5;
        this.info5 = str6;
    }
}
