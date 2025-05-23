package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_pwdright_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25006msg;
    public int ret;

    public mobile_sub_pwdright_rsp() {
        this.f25006msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25006msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25006msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_sub_pwdright_rsp(int i3, String str) {
        this.ret = i3;
        this.f25006msg = str;
    }
}
