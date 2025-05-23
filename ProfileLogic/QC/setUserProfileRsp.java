package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class setUserProfileRsp extends JceStruct {
    public int ret;
    public String url;

    public setUserProfileRsp() {
        this.ret = 0;
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public setUserProfileRsp(int i3, String str) {
        this.ret = i3;
        this.url = str;
    }
}
