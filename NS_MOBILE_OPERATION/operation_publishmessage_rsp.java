package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_publishmessage_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25019msg;
    public int ret;
    public String tid;
    public String verifyurl;

    public operation_publishmessage_rsp() {
        this.verifyurl = "";
        this.tid = "";
        this.f25019msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.verifyurl = jceInputStream.readString(1, false);
        this.tid = jceInputStream.readString(2, false);
        this.f25019msg = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.verifyurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.tid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.f25019msg;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public operation_publishmessage_rsp(int i3, String str, String str2, String str3) {
        this.ret = i3;
        this.verifyurl = str;
        this.tid = str2;
        this.f25019msg = str3;
    }
}
