package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_forward_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25015msg;
    public String newid;
    public int ret;
    public String verifyurl;

    public operation_forward_rsp() {
        this.f25015msg = "";
        this.newid = "";
        this.verifyurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25015msg = jceInputStream.readString(1, false);
        this.newid = jceInputStream.readString(2, false);
        this.verifyurl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25015msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.newid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.verifyurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public operation_forward_rsp(int i3, String str, String str2, String str3) {
        this.ret = i3;
        this.f25015msg = str;
        this.newid = str2;
        this.verifyurl = str3;
    }
}
