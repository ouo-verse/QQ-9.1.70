package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class WiFiService extends JceStruct {
    static d cache_wifi;
    public int autoConnFlag;
    public byte fee;
    public String pkgid;
    public byte type;
    public d wifi;

    public WiFiService() {
        this.type = (byte) 0;
        this.fee = (byte) 0;
        this.pkgid = "";
        this.wifi = null;
        this.autoConnFlag = 0;
    }

    public String getBssid() {
        d dVar = this.wifi;
        if (dVar != null) {
            return dVar.f336465b;
        }
        return "";
    }

    public short getSignal() {
        d dVar = this.wifi;
        if (dVar != null) {
            return dVar.f336466c;
        }
        return (short) 0;
    }

    public String getSsid() {
        d dVar = this.wifi;
        if (dVar != null) {
            return dVar.f336464a;
        }
        return "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.fee = jceInputStream.read(this.fee, 1, true);
        this.pkgid = jceInputStream.readString(2, false);
        if (cache_wifi == null) {
            cache_wifi = new d();
        }
        this.wifi = (d) jceInputStream.read((JceStruct) cache_wifi, 3, false);
        this.autoConnFlag = jceInputStream.read(this.autoConnFlag, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[pkgid=");
        sb5.append(this.pkgid);
        if (this.wifi != null) {
            sb5.append(", ssid=");
            sb5.append(this.wifi.f336464a);
            sb5.append(", bssid=");
            sb5.append(this.wifi.f336465b);
            sb5.append("]");
        } else {
            sb5.append("]");
        }
        sb5.append("autoConnFlag=" + this.autoConnFlag);
        return sb5.toString();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.fee, 1);
        String str = this.pkgid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        d dVar = this.wifi;
        if (dVar != null) {
            jceOutputStream.write((JceStruct) dVar, 3);
        }
        jceOutputStream.write(this.autoConnFlag, 4);
    }

    public WiFiService(byte b16, byte b17, String str, d dVar, int i3) {
        this.type = b16;
        this.fee = b17;
        this.pkgid = str;
        this.wifi = dVar;
        this.autoConnFlag = i3;
    }
}
