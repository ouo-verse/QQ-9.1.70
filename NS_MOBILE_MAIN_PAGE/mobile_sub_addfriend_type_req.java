package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_addfriend_type_req extends JceStruct {
    public long fuin;

    public mobile_sub_addfriend_type_req() {
        this.fuin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fuin = jceInputStream.read(this.fuin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fuin, 0);
    }

    public mobile_sub_addfriend_type_req(long j3) {
        this.fuin = j3;
    }
}
