package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_get_batch_photo_req extends JceStruct {
    public String albumid;
    public String attach_info;
    public String batchid;
    public int count;
    public String qunid;

    public qun_get_batch_photo_req() {
        this.qunid = "";
        this.albumid = "";
        this.batchid = "";
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.batchid = jceInputStream.readString(2, true);
        this.count = jceInputStream.read(this.count, 3, false);
        this.attach_info = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.batchid, 2);
        jceOutputStream.write(this.count, 3);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public qun_get_batch_photo_req(String str, String str2, String str3, int i3, String str4) {
        this.qunid = str;
        this.albumid = str2;
        this.batchid = str3;
        this.count = i3;
        this.attach_info = str4;
    }
}
