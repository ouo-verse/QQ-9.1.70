package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_detail_actshuoshuo_req extends JceStruct {
    public String act_id;
    public String busi_param;

    public mobile_detail_actshuoshuo_req() {
        this.act_id = "";
        this.busi_param = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.act_id = jceInputStream.readString(0, false);
        this.busi_param = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.act_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.busi_param;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public mobile_detail_actshuoshuo_req(String str, String str2) {
        this.act_id = str;
        this.busi_param = str2;
    }
}
