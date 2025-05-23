package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_set_red_key_data_req extends JceStruct {
    public long appid;
    public String pay_key;
    public String ugc_key;
    public long uin;

    public mobile_set_red_key_data_req() {
        this.uin = 0L;
        this.appid = 0L;
        this.ugc_key = "";
        this.pay_key = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.ugc_key = jceInputStream.readString(2, true);
        this.pay_key = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.ugc_key, 2);
        jceOutputStream.write(this.pay_key, 3);
    }

    public mobile_set_red_key_data_req(long j3, long j16, String str, String str2) {
        this.uin = j3;
        this.appid = j16;
        this.ugc_key = str;
        this.pay_key = str2;
    }
}
