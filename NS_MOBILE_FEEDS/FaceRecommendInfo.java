package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FaceRecommendInfo extends JceStruct {
    public String groupid;
    public String nick;
    public long uin;

    public FaceRecommendInfo() {
        this.uin = 0L;
        this.nick = "";
        this.groupid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nick = jceInputStream.readString(1, false);
        this.groupid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.groupid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public FaceRecommendInfo(long j3, String str, String str2) {
        this.uin = j3;
        this.nick = str;
        this.groupid = str2;
    }
}
