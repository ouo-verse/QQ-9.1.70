package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetItemWatchWordRsp extends JceStruct {
    public String errmsg;
    public int ret;
    public String sharemsg;

    public GetItemWatchWordRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.sharemsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.sharemsg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sharemsg;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public GetItemWatchWordRsp(int i3, String str, String str2) {
        this.ret = i3;
        this.errmsg = str;
        this.sharemsg = str2;
    }
}
