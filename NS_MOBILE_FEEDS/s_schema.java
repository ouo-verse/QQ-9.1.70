package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_schema extends JceStruct {
    public int actiontype;
    public String actionurl;
    public String appid;
    public String downloadurl;
    public String postparams;
    public String schemapageurl;
    public byte usepost;
    public boolean yingyongbao;

    public s_schema() {
        this.actionurl = "";
        this.downloadurl = "";
        this.appid = "";
        this.postparams = "";
        this.schemapageurl = "";
        this.yingyongbao = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.actiontype = jceInputStream.read(this.actiontype, 0, false);
        this.actionurl = jceInputStream.readString(1, false);
        this.downloadurl = jceInputStream.readString(2, false);
        this.appid = jceInputStream.readString(3, false);
        this.postparams = jceInputStream.readString(4, false);
        this.usepost = jceInputStream.read(this.usepost, 5, false);
        this.schemapageurl = jceInputStream.readString(6, false);
        this.yingyongbao = jceInputStream.read(this.yingyongbao, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.actiontype, 0);
        String str = this.actionurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.downloadurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.appid;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.postparams;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.usepost, 5);
        String str5 = this.schemapageurl;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.yingyongbao, 9);
    }

    public s_schema(int i3, String str, String str2, String str3, String str4, byte b16, String str5, boolean z16) {
        this.actiontype = i3;
        this.actionurl = str;
        this.downloadurl = str2;
        this.appid = str3;
        this.postparams = str4;
        this.usepost = b16;
        this.schemapageurl = str5;
        this.yingyongbao = z16;
    }
}
