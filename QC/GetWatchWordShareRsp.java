package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetWatchWordShareRsp extends JceStruct {
    public String detailurl;
    public String errmsg;
    public String itemmsg;
    public String itemname;
    public String itemtype;
    public int portrait;
    public int ret;
    public String sharemsg;
    public String shareuinnick;
    public String thumbnailurl;

    public GetWatchWordShareRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.itemname = "";
        this.itemtype = "";
        this.shareuinnick = "";
        this.sharemsg = "";
        this.thumbnailurl = "";
        this.detailurl = "";
        this.itemmsg = "";
        this.portrait = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.itemname = jceInputStream.readString(2, false);
        this.itemtype = jceInputStream.readString(3, false);
        this.shareuinnick = jceInputStream.readString(4, false);
        this.sharemsg = jceInputStream.readString(5, false);
        this.thumbnailurl = jceInputStream.readString(6, false);
        this.detailurl = jceInputStream.readString(7, false);
        this.itemmsg = jceInputStream.readString(8, false);
        this.portrait = jceInputStream.read(this.portrait, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.itemname;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.itemtype;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.shareuinnick;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.sharemsg;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.thumbnailurl;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.detailurl;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.itemmsg;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
        jceOutputStream.write(this.portrait, 9);
    }

    public GetWatchWordShareRsp(int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i16) {
        this.ret = i3;
        this.errmsg = str;
        this.itemname = str2;
        this.itemtype = str3;
        this.shareuinnick = str4;
        this.sharemsg = str5;
        this.thumbnailurl = str6;
        this.detailurl = str7;
        this.itemmsg = str8;
        this.portrait = i16;
    }
}
