package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedsInfo extends JceStruct {
    public int appid;
    public long hostUin;
    public String jumpUrl;
    public String likekey;

    public FeedsInfo() {
        this.appid = 0;
        this.hostUin = 0L;
        this.likekey = "";
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.hostUin = jceInputStream.read(this.hostUin, 1, false);
        this.likekey = jceInputStream.readString(2, false);
        this.jumpUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.hostUin, 1);
        String str = this.likekey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.jumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public FeedsInfo(int i3, long j3, String str, String str2) {
        this.appid = i3;
        this.hostUin = j3;
        this.likekey = str;
        this.jumpUrl = str2;
    }
}
