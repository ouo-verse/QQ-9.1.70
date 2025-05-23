package MShark;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CSGUIDRegist extends JceStruct {
    public String imei = "";
    public String imsi = "";
    public String mac = "";

    /* renamed from: lc, reason: collision with root package name */
    public String f24911lc = "";
    public int buildno = 0;
    public String channelid = "";
    public String pkgname = "";
    public String build_brand = "";
    public String build_version_incremental = "";
    public String build_version_release = "";
    public int product = 0;
    public int platform = 0;
    public int subplatform = 0;
    public boolean isbuildin = false;

    /* renamed from: ua, reason: collision with root package name */
    public String f24912ua = "";

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new CSGUIDRegist();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, true);
        this.imsi = jceInputStream.readString(1, false);
        this.mac = jceInputStream.readString(2, false);
        this.f24911lc = jceInputStream.readString(3, false);
        this.buildno = jceInputStream.read(this.buildno, 4, false);
        this.channelid = jceInputStream.readString(5, false);
        this.pkgname = jceInputStream.readString(6, false);
        this.build_brand = jceInputStream.readString(7, false);
        this.build_version_incremental = jceInputStream.readString(8, false);
        this.build_version_release = jceInputStream.readString(9, false);
        this.product = jceInputStream.read(this.product, 10, false);
        this.platform = jceInputStream.read(this.platform, 11, false);
        this.subplatform = jceInputStream.read(this.subplatform, 12, false);
        this.isbuildin = jceInputStream.read(this.isbuildin, 13, false);
        this.f24912ua = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imei, 0);
        String str = this.imsi;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.mac;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.f24911lc;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        int i3 = this.buildno;
        if (i3 != 0) {
            jceOutputStream.write(i3, 4);
        }
        String str4 = this.channelid;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.pkgname;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.build_brand;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.build_version_incremental;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        String str8 = this.build_version_release;
        if (str8 != null) {
            jceOutputStream.write(str8, 9);
        }
        int i16 = this.product;
        if (i16 != 0) {
            jceOutputStream.write(i16, 10);
        }
        int i17 = this.platform;
        if (i17 != 0) {
            jceOutputStream.write(i17, 11);
        }
        int i18 = this.subplatform;
        if (i18 != 0) {
            jceOutputStream.write(i18, 12);
        }
        jceOutputStream.write(this.isbuildin, 13);
        String str9 = this.f24912ua;
        if (str9 != null) {
            jceOutputStream.write(str9, 14);
        }
    }
}
