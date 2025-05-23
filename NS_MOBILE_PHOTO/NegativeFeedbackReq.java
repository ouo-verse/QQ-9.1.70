package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class NegativeFeedbackReq extends JceStruct {
    public String albumid;
    public int type;
    public long uin;

    public NegativeFeedbackReq() {
        this.type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.albumid = jceInputStream.read(this.albumid, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.uin, 1);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public NegativeFeedbackReq(int i3, long j3, String str) {
        this.type = i3;
        this.uin = j3;
        this.albumid = str;
    }
}
