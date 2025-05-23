package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_host_hb_info_req extends JceStruct {
    public String ext_info;
    public long huin;

    public mobile_host_hb_info_req() {
        this.huin = 0L;
        this.ext_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.huin = jceInputStream.read(this.huin, 0, true);
        this.ext_info = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.huin, 0);
        String str = this.ext_info;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_host_hb_info_req(long j3, String str) {
        this.huin = j3;
        this.ext_info = str;
    }
}
