package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class shareData extends JceStruct {
    public String msgtail;
    public String picurl;
    public String pkgname;
    public String url;

    public shareData() {
        this.pkgname = "";
        this.msgtail = "";
        this.picurl = "";
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pkgname = jceInputStream.readString(0, true);
        this.msgtail = jceInputStream.readString(1, true);
        this.picurl = jceInputStream.readString(2, true);
        this.url = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.pkgname, 0);
        jceOutputStream.write(this.msgtail, 1);
        jceOutputStream.write(this.picurl, 2);
        jceOutputStream.write(this.url, 3);
    }

    public shareData(String str, String str2, String str3, String str4) {
        this.pkgname = str;
        this.msgtail = str2;
        this.picurl = str3;
        this.url = str4;
    }
}
