package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiItemDetail extends JceStruct {
    public int appid;
    public ExtraAppInfo extraappinfo;
    public UniBusiExtraInfo extrainfo;
    public int feetype;
    public String image;
    public String itemBgColor;
    public int itemid;
    public String itemname;
    public long validlast;
    public long validts;
    static UniBusiExtraInfo cache_extrainfo = new UniBusiExtraInfo();
    static ExtraAppInfo cache_extraappinfo = new ExtraAppInfo();

    public UniBusiItemDetail() {
        this.itemid = 0;
        this.itemname = "";
        this.feetype = 0;
        this.validts = 0L;
        this.validlast = 0L;
        this.extrainfo = null;
        this.image = "";
        this.itemBgColor = "";
        this.appid = 0;
        this.extraappinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.itemid = jceInputStream.read(this.itemid, 0, false);
        this.itemname = jceInputStream.readString(1, false);
        this.feetype = jceInputStream.read(this.feetype, 2, false);
        this.validts = jceInputStream.read(this.validts, 3, false);
        this.validlast = jceInputStream.read(this.validlast, 4, false);
        this.extrainfo = (UniBusiExtraInfo) jceInputStream.read((JceStruct) cache_extrainfo, 5, false);
        this.image = jceInputStream.readString(6, false);
        this.itemBgColor = jceInputStream.readString(7, false);
        this.appid = jceInputStream.read(this.appid, 8, false);
        this.extraappinfo = (ExtraAppInfo) jceInputStream.read((JceStruct) cache_extraappinfo, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.itemid, 0);
        String str = this.itemname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.feetype, 2);
        jceOutputStream.write(this.validts, 3);
        jceOutputStream.write(this.validlast, 4);
        UniBusiExtraInfo uniBusiExtraInfo = this.extrainfo;
        if (uniBusiExtraInfo != null) {
            jceOutputStream.write((JceStruct) uniBusiExtraInfo, 5);
        }
        String str2 = this.image;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.itemBgColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.appid, 8);
        ExtraAppInfo extraAppInfo = this.extraappinfo;
        if (extraAppInfo != null) {
            jceOutputStream.write((JceStruct) extraAppInfo, 9);
        }
    }

    public UniBusiItemDetail(int i3, String str, int i16, long j3, long j16, UniBusiExtraInfo uniBusiExtraInfo, String str2, String str3, int i17, ExtraAppInfo extraAppInfo) {
        this.itemid = i3;
        this.itemname = str;
        this.feetype = i16;
        this.validts = j3;
        this.validlast = j16;
        this.extrainfo = uniBusiExtraInfo;
        this.image = str2;
        this.itemBgColor = str3;
        this.appid = i17;
        this.extraappinfo = extraAppInfo;
    }
}
