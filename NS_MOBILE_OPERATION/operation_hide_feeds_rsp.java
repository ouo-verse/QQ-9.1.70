package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_hide_feeds_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25016msg;
    public int ret;

    public operation_hide_feeds_rsp() {
        this.f25016msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25016msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25016msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public operation_hide_feeds_rsp(int i3, String str) {
        this.ret = i3;
        this.f25016msg = str;
    }
}
