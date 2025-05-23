package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGetPicUrlByKeysRsp extends JceStruct {
    public String picUrl;

    public stGetPicUrlByKeysRsp() {
        this.picUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picUrl = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.picUrl, 0);
    }

    public stGetPicUrlByKeysRsp(String str) {
        this.picUrl = str;
    }
}
