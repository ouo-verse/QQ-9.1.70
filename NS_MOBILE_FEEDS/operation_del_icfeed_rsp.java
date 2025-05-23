package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_del_icfeed_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f24990msg;
    public int ret;
    public String verifyurl;

    public operation_del_icfeed_rsp() {
        this.f24990msg = "";
        this.verifyurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f24990msg = jceInputStream.readString(1, false);
        this.verifyurl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f24990msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.verifyurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public operation_del_icfeed_rsp(int i3, String str, String str2) {
        this.ret = i3;
        this.f24990msg = str;
        this.verifyurl = str2;
    }
}
