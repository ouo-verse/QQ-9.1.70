package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feed_info extends JceStruct {
    public int appid;
    public long has_pic;
    public long opuin;
    public int sourceType;
    public String strImgUrl;
    public String strcontent;
    public String strkey;
    public long time;
    public int typeId;

    public feed_info() {
        this.appid = 0;
        this.typeId = 0;
        this.time = 0L;
        this.opuin = 0L;
        this.strkey = "";
        this.strcontent = "";
        this.has_pic = 0L;
        this.strImgUrl = "";
        this.sourceType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.typeId = jceInputStream.read(this.typeId, 1, false);
        this.time = jceInputStream.read(this.time, 2, false);
        this.opuin = jceInputStream.read(this.opuin, 3, false);
        this.strkey = jceInputStream.readString(4, false);
        this.strcontent = jceInputStream.readString(5, false);
        this.has_pic = jceInputStream.read(this.has_pic, 6, false);
        this.strImgUrl = jceInputStream.readString(7, false);
        this.sourceType = jceInputStream.read(this.sourceType, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.typeId, 1);
        jceOutputStream.write(this.time, 2);
        jceOutputStream.write(this.opuin, 3);
        String str = this.strkey;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.strcontent;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.has_pic, 6);
        String str3 = this.strImgUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.sourceType, 8);
    }

    public feed_info(int i3, int i16, long j3, long j16, String str, String str2, long j17, String str3, int i17) {
        this.appid = i3;
        this.typeId = i16;
        this.time = j3;
        this.opuin = j16;
        this.strkey = str;
        this.strcontent = str2;
        this.has_pic = j17;
        this.strImgUrl = str3;
        this.sourceType = i17;
    }
}
