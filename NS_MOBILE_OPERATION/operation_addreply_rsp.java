package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_addreply_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25011msg;
    public String replyLikeKey;
    public String replyid;
    public int ret;
    public String verifyurl;

    public operation_addreply_rsp() {
        this.ret = 0;
        this.f25011msg = "";
        this.verifyurl = "";
        this.replyid = "";
        this.replyLikeKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25011msg = jceInputStream.readString(1, false);
        this.verifyurl = jceInputStream.readString(2, false);
        this.replyid = jceInputStream.readString(3, false);
        this.replyLikeKey = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25011msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.verifyurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.replyid;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.replyLikeKey;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public operation_addreply_rsp(int i3, String str, String str2, String str3, String str4) {
        this.ret = i3;
        this.f25011msg = str;
        this.verifyurl = str2;
        this.replyid = str3;
        this.replyLikeKey = str4;
    }
}
