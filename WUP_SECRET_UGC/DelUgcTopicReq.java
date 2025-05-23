package WUP_SECRET_UGC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DelUgcTopicReq extends JceStruct {
    public int source;
    public String ugc_id;
    public String uid;

    public DelUgcTopicReq() {
        this.uid = "";
        this.ugc_id = "";
        this.source = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uid = jceInputStream.readString(0, false);
        this.ugc_id = jceInputStream.readString(1, false);
        this.source = jceInputStream.read(this.source, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.ugc_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.source, 2);
    }

    public DelUgcTopicReq(String str, String str2, int i3) {
        this.uid = str;
        this.ugc_id = str2;
        this.source = i3;
    }
}
