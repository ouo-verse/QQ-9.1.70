package PHOTO_OPENID_TO_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetShareKeyReq extends JceStruct {
    public String albumid;
    public String openid;
    public String uin;

    public GetShareKeyReq() {
        this.openid = "";
        this.albumid = "";
        this.uin = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.openid = jceInputStream.readString(0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.uin = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.openid, 0);
        jceOutputStream.write(this.albumid, 1);
        String str = this.uin;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public GetShareKeyReq(String str, String str2, String str3) {
        this.openid = str;
        this.albumid = str2;
        this.uin = str3;
    }
}
