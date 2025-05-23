package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_getspaceright_req extends JceStruct {
    public int getDetail;
    public long uin;

    public mobile_sub_getspaceright_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.getDetail = jceInputStream.read(this.getDetail, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.getDetail, 1);
    }

    public mobile_sub_getspaceright_req(long j3, int i3) {
        this.uin = j3;
        this.getDetail = i3;
    }
}
