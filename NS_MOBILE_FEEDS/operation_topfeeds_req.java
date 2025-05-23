package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_topfeeds_req extends JceStruct {
    public int feedstype;
    public int operationtype;
    public String strkey;
    public long uin;

    public operation_topfeeds_req() {
        this.strkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.operationtype = jceInputStream.read(this.operationtype, 1, true);
        this.feedstype = jceInputStream.read(this.feedstype, 2, true);
        this.strkey = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.operationtype, 1);
        jceOutputStream.write(this.feedstype, 2);
        jceOutputStream.write(this.strkey, 3);
    }

    public operation_topfeeds_req(long j3, int i3, int i16, String str) {
        this.uin = j3;
        this.operationtype = i3;
        this.feedstype = i16;
        this.strkey = str;
    }
}
