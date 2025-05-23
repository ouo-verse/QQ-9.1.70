package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_concern_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25003msg;
    public int ret;

    public mobile_sub_concern_rsp() {
        this.f25003msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25003msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25003msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_sub_concern_rsp(int i3, String str) {
        this.ret = i3;
        this.f25003msg = str;
    }
}
