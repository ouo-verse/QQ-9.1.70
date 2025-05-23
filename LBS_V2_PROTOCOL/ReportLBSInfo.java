package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReportLBSInfo extends JceStruct {
    public String data_id;
    public String dev;
    public int iLat;
    public int iLon;
    public int idx;
    public String lang;

    /* renamed from: os, reason: collision with root package name */
    public String f24909os;
    public String os_ver;
    public String other;
    public int ref;
    public String ref_ver;
    public String request_id;
    public long time;

    public ReportLBSInfo() {
        this.request_id = "";
        this.time = 0L;
        this.data_id = "";
        this.idx = 0;
        this.ref = 0;
        this.ref_ver = "";
        this.iLat = 0;
        this.iLon = 0;
        this.dev = "";
        this.f24909os = "";
        this.os_ver = "";
        this.lang = "";
        this.other = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.request_id = jceInputStream.readString(0, false);
        this.time = jceInputStream.read(this.time, 1, false);
        this.data_id = jceInputStream.readString(2, false);
        this.idx = jceInputStream.read(this.idx, 3, false);
        this.ref = jceInputStream.read(this.ref, 4, false);
        this.ref_ver = jceInputStream.readString(5, false);
        this.iLat = jceInputStream.read(this.iLat, 6, false);
        this.iLon = jceInputStream.read(this.iLon, 7, false);
        this.dev = jceInputStream.readString(8, false);
        this.f24909os = jceInputStream.readString(9, false);
        this.os_ver = jceInputStream.readString(10, false);
        this.lang = jceInputStream.readString(11, false);
        this.other = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.request_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.time, 1);
        String str2 = this.data_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.idx, 3);
        jceOutputStream.write(this.ref, 4);
        String str3 = this.ref_ver;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.iLat, 6);
        jceOutputStream.write(this.iLon, 7);
        String str4 = this.dev;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.f24909os;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.os_ver;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        String str7 = this.lang;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
        String str8 = this.other;
        if (str8 != null) {
            jceOutputStream.write(str8, 12);
        }
    }

    public ReportLBSInfo(String str, long j3, String str2, int i3, int i16, String str3, int i17, int i18, String str4, String str5, String str6, String str7, String str8) {
        this.request_id = str;
        this.time = j3;
        this.data_id = str2;
        this.idx = i3;
        this.ref = i16;
        this.ref_ver = str3;
        this.iLat = i17;
        this.iLon = i18;
        this.dev = str4;
        this.f24909os = str5;
        this.os_ver = str6;
        this.lang = str7;
        this.other = str8;
    }
}
