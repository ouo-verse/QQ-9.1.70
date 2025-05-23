package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_delfavour_req extends JceStruct {
    public long appid;
    public long subid;
    public long uin;
    public String vecFavID;

    public operation_delfavour_req() {
        this.vecFavID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.vecFavID = jceInputStream.readString(1, false);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.subid = jceInputStream.read(this.subid, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.vecFavID;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.subid, 3);
    }

    public operation_delfavour_req(long j3, String str, long j16, long j17) {
        this.uin = j3;
        this.vecFavID = str;
        this.appid = j16;
        this.subid = j17;
    }
}
