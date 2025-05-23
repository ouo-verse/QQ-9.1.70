package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Net extends JceStruct {
    public String extNetworkOperator;
    public int extNetworkType;
    public byte isWap;
    public byte netType;
    public String wifiBssid;
    public String wifiSsid;

    public Net() {
        this.netType = (byte) 0;
        this.extNetworkOperator = "";
        this.extNetworkType = 0;
        this.isWap = (byte) 0;
        this.wifiSsid = "";
        this.wifiBssid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.netType = jceInputStream.read(this.netType, 0, true);
        this.extNetworkOperator = jceInputStream.readString(1, false);
        this.extNetworkType = jceInputStream.read(this.extNetworkType, 2, false);
        this.isWap = jceInputStream.read(this.isWap, 3, false);
        this.wifiSsid = jceInputStream.readString(4, false);
        this.wifiBssid = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.netType, 0);
        String str = this.extNetworkOperator;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.extNetworkType, 2);
        jceOutputStream.write(this.isWap, 3);
        String str2 = this.wifiSsid;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.wifiBssid;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public Net(byte b16, String str, int i3, byte b17, String str2, String str3) {
        this.netType = b16;
        this.extNetworkOperator = str;
        this.extNetworkType = i3;
        this.isWap = b17;
        this.wifiSsid = str2;
        this.wifiBssid = str3;
    }
}
