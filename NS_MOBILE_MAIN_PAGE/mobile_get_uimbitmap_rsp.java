package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_uimbitmap_rsp extends JceStruct {
    public boolean switch_flag;
    public long uin;

    public mobile_get_uimbitmap_rsp() {
        this.switch_flag = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.switch_flag = jceInputStream.read(this.switch_flag, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.switch_flag, 1);
    }

    public mobile_get_uimbitmap_rsp(long j3, boolean z16) {
        this.uin = j3;
        this.switch_flag = z16;
    }
}
