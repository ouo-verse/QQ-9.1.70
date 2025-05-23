package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LikInfo extends JceStruct {
    public int appid;
    public int hasDoLik;
    public long hostUin;
    public String likeKey;
    public int totalLik;

    public LikInfo() {
        this.totalLik = 0;
        this.likeKey = "";
        this.appid = 0;
        this.hostUin = 0L;
        this.hasDoLik = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.totalLik = jceInputStream.read(this.totalLik, 0, false);
        this.likeKey = jceInputStream.readString(1, false);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.hostUin = jceInputStream.read(this.hostUin, 3, false);
        this.hasDoLik = jceInputStream.read(this.hasDoLik, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.totalLik, 0);
        String str = this.likeKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.hostUin, 3);
        jceOutputStream.write(this.hasDoLik, 4);
    }

    public LikInfo(int i3, String str, int i16, long j3, int i17) {
        this.totalLik = i3;
        this.likeKey = str;
        this.appid = i16;
        this.hostUin = j3;
        this.hasDoLik = i17;
    }
}
