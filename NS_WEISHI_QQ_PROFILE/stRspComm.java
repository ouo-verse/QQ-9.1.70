package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRspComm extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25070msg;
    public int ret;

    public stRspComm() {
        this.ret = 0;
        this.f25070msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25070msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25070msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stRspComm(int i3, String str) {
        this.ret = i3;
        this.f25070msg = str;
    }
}
