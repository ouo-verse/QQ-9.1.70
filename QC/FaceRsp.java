package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FaceRsp extends JceStruct {
    static CommonRsp cache_stRet = new CommonRsp();
    public int authRet;
    public CommonRsp stRet;
    public String url;

    public FaceRsp() {
        this.stRet = null;
        this.authRet = 0;
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stRet = (CommonRsp) jceInputStream.read((JceStruct) cache_stRet, 0, false);
        this.authRet = jceInputStream.read(this.authRet, 1, false);
        this.url = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonRsp commonRsp = this.stRet;
        if (commonRsp != null) {
            jceOutputStream.write((JceStruct) commonRsp, 0);
        }
        jceOutputStream.write(this.authRet, 1);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public FaceRsp(CommonRsp commonRsp, int i3, String str) {
        this.stRet = commonRsp;
        this.authRet = i3;
        this.url = str;
    }
}
