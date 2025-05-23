package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CooperateCms extends JceStruct {
    public String androidPackage;
    public int elementid;
    public int fileid;
    public String picUrl;
    public int productid;
    public int softid;
    public String title;
    public String url;

    public CooperateCms() {
        this.elementid = 0;
        this.picUrl = "";
        this.title = "";
        this.url = "";
        this.androidPackage = "";
        this.productid = 0;
        this.softid = 0;
        this.fileid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.elementid = jceInputStream.read(this.elementid, 0, true);
        this.picUrl = jceInputStream.readString(1, true);
        this.title = jceInputStream.readString(2, true);
        this.url = jceInputStream.readString(3, true);
        this.androidPackage = jceInputStream.readString(4, true);
        this.productid = jceInputStream.read(this.productid, 5, true);
        this.softid = jceInputStream.read(this.softid, 6, true);
        this.fileid = jceInputStream.read(this.fileid, 7, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.elementid, 0);
        jceOutputStream.write(this.picUrl, 1);
        jceOutputStream.write(this.title, 2);
        jceOutputStream.write(this.url, 3);
        jceOutputStream.write(this.androidPackage, 4);
        jceOutputStream.write(this.productid, 5);
        jceOutputStream.write(this.softid, 6);
        jceOutputStream.write(this.fileid, 7);
    }

    public CooperateCms(int i3, String str, String str2, String str3, String str4, int i16, int i17, int i18) {
        this.elementid = i3;
        this.picUrl = str;
        this.title = str2;
        this.url = str3;
        this.androidPackage = str4;
        this.productid = i16;
        this.softid = i17;
        this.fileid = i18;
    }
}
