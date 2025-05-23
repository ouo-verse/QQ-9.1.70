package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes26.dex */
public final class IPCDownloadParam extends JceStruct {
    static IPCBaseParam cache_baseParam;
    public String actionFlag;
    public IPCBaseParam baseParam;
    public String opList;
    public String reverse;
    public String verifyType;

    public IPCDownloadParam() {
        this.baseParam = null;
        this.opList = "";
        this.actionFlag = "";
        this.verifyType = "";
        this.reverse = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_baseParam == null) {
            cache_baseParam = new IPCBaseParam();
        }
        this.baseParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_baseParam, 0, true);
        this.opList = jceInputStream.readString(1, false);
        this.actionFlag = jceInputStream.readString(2, false);
        this.verifyType = jceInputStream.readString(3, false);
        this.reverse = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.baseParam, 0);
        String str = this.opList;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.actionFlag;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.verifyType;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.reverse;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public IPCDownloadParam(IPCBaseParam iPCBaseParam, String str, String str2, String str3, String str4) {
        this.baseParam = iPCBaseParam;
        this.opList = str;
        this.actionFlag = str2;
        this.verifyType = str3;
        this.reverse = str4;
    }
}
