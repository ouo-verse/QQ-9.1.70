package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AIOKeyWordReq extends JceStruct {
    public String sMatchKey;
    public String sUin;

    public AIOKeyWordReq() {
        this.sUin = "";
        this.sMatchKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUin = jceInputStream.readString(0, true);
        this.sMatchKey = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUin, 0);
        jceOutputStream.write(this.sMatchKey, 1);
    }

    public AIOKeyWordReq(String str, String str2) {
        this.sUin = str;
        this.sMatchKey = str2;
    }
}
