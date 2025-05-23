package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_client_action_report_res extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f24988msg;
    public int ret;

    public mobile_client_action_report_res() {
        this.ret = 0;
        this.f24988msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f24988msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f24988msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_client_action_report_res(int i3, String str) {
        this.ret = i3;
        this.f24988msg = str;
    }
}
