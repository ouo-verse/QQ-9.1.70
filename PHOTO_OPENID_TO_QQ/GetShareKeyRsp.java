package PHOTO_OPENID_TO_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetShareKeyRsp extends JceStruct {
    public int ret;
    public String share_key;

    public GetShareKeyRsp() {
        this.ret = 0;
        this.share_key = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.share_key = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.share_key, 1);
    }

    public GetShareKeyRsp(int i3, String str) {
        this.ret = i3;
        this.share_key = str;
    }
}
