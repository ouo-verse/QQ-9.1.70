package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class quote_photo_dst extends JceStruct {
    public long albumhandset;
    public String albumid;
    public long batchid;
    public String desc;
    public int dst_type;
    public String qunid;

    public quote_photo_dst() {
        this.albumid = "";
        this.desc = "";
        this.qunid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dst_type = jceInputStream.read(this.dst_type, 0, false);
        this.albumid = jceInputStream.readString(1, false);
        this.batchid = jceInputStream.read(this.batchid, 2, false);
        this.desc = jceInputStream.readString(3, false);
        this.albumhandset = jceInputStream.read(this.albumhandset, 4, false);
        this.qunid = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dst_type, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.batchid, 2);
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.albumhandset, 4);
        String str3 = this.qunid;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public quote_photo_dst(int i3, String str, long j3, String str2, long j16, String str3) {
        this.dst_type = i3;
        this.albumid = str;
        this.batchid = j3;
        this.desc = str2;
        this.albumhandset = j16;
        this.qunid = str3;
    }
}
