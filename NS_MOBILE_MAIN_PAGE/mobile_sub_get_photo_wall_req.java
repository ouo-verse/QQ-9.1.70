package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_photo_wall_req extends JceStruct {
    public String attachInfo;
    public long uin;

    public mobile_sub_get_photo_wall_req() {
        this.attachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.attachInfo = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_sub_get_photo_wall_req(long j3, String str) {
        this.uin = j3;
        this.attachInfo = str;
    }
}
