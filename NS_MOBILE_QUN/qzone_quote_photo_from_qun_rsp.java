package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qzone_quote_photo_from_qun_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25046msg;
    public int ret;

    public qzone_quote_photo_from_qun_rsp() {
        this.f25046msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25046msg = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.f25046msg, 1);
    }

    public qzone_quote_photo_from_qun_rsp(int i3, String str) {
        this.ret = i3;
        this.f25046msg = str;
    }
}
