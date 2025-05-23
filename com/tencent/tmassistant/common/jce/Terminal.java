package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Terminal extends JceStruct {
    public String androidId;
    public String androidIdSdCard;
    public String brand;
    public String imei;
    public String imei2;
    public String imsi;
    public String imsi2;
    public String macAdress;
    public String manufacture;
    public String mode;
    public String product;
    public int xResolution;
    public int yResolution;

    public Terminal() {
        this.imei = "";
        this.macAdress = "";
        this.androidId = "";
        this.androidIdSdCard = "";
        this.imsi = "";
        this.imei2 = "";
        this.imsi2 = "";
        this.xResolution = 0;
        this.yResolution = 0;
        this.brand = "";
        this.mode = "";
        this.manufacture = "";
        this.product = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.macAdress = jceInputStream.readString(1, false);
        this.androidId = jceInputStream.readString(2, false);
        this.androidIdSdCard = jceInputStream.readString(3, false);
        this.imsi = jceInputStream.readString(4, false);
        this.imei2 = jceInputStream.readString(5, false);
        this.imsi2 = jceInputStream.readString(6, false);
        this.xResolution = jceInputStream.read(this.xResolution, 7, false);
        this.yResolution = jceInputStream.read(this.yResolution, 8, false);
        this.brand = jceInputStream.readString(9, false);
        this.mode = jceInputStream.readString(10, false);
        this.manufacture = jceInputStream.readString(11, false);
        this.product = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.macAdress;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.androidId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.androidIdSdCard;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.imsi;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.imei2;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.imsi2;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        jceOutputStream.write(this.xResolution, 7);
        jceOutputStream.write(this.yResolution, 8);
        String str8 = this.brand;
        if (str8 != null) {
            jceOutputStream.write(str8, 9);
        }
        String str9 = this.mode;
        if (str9 != null) {
            jceOutputStream.write(str9, 10);
        }
        String str10 = this.manufacture;
        if (str10 != null) {
            jceOutputStream.write(str10, 11);
        }
        String str11 = this.product;
        if (str11 != null) {
            jceOutputStream.write(str11, 12);
        }
    }

    public Terminal(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, String str8, String str9, String str10, String str11) {
        this.imei = str;
        this.macAdress = str2;
        this.androidId = str3;
        this.androidIdSdCard = str4;
        this.imsi = str5;
        this.imei2 = str6;
        this.imsi2 = str7;
        this.xResolution = i3;
        this.yResolution = i16;
        this.brand = str8;
        this.mode = str9;
        this.manufacture = str10;
        this.product = str11;
    }
}
