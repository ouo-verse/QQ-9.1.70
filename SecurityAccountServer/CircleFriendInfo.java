package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleFriendInfo extends JceStruct {
    public String source;
    public String strRemark;
    public long uin;

    public CircleFriendInfo() {
        this.uin = 0L;
        this.strRemark = "";
        this.source = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.strRemark = jceInputStream.readString(1, true);
        this.source = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.strRemark, 1);
        String str = this.source;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public CircleFriendInfo(long j3, String str, String str2) {
        this.uin = j3;
        this.strRemark = str;
        this.source = str2;
    }
}
