package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_pwdright_req extends JceStruct {
    static s_pwdright cache_pwdright;
    public s_pwdright pwdright;
    public long uin;

    public mobile_sub_pwdright_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        if (cache_pwdright == null) {
            cache_pwdright = new s_pwdright();
        }
        this.pwdright = (s_pwdright) jceInputStream.read((JceStruct) cache_pwdright, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        s_pwdright s_pwdrightVar = this.pwdright;
        if (s_pwdrightVar != null) {
            jceOutputStream.write((JceStruct) s_pwdrightVar, 1);
        }
    }

    public mobile_sub_pwdright_req(long j3, s_pwdright s_pwdrightVar) {
        this.uin = j3;
        this.pwdright = s_pwdrightVar;
    }
}
