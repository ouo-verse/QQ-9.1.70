package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_setuncare_rsp extends JceStruct {
    public int carestatus;
    public int ret;

    public mobile_sub_setuncare_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.carestatus = jceInputStream.read(this.carestatus, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.carestatus, 1);
    }

    public mobile_sub_setuncare_rsp(int i3, int i16) {
        this.ret = i3;
        this.carestatus = i16;
    }
}
