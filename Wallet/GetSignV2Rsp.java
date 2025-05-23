package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSignV2Rsp extends JceStruct {
    public String busi_info;
    public String mch_id;
    public int nav_type;
    public int ret;
    public String sign;
    public long time_stamp;
    public int token_scene;
    public int token_type;
    public long userid;
    public int userid_type;

    public GetSignV2Rsp() {
        this.ret = 0;
        this.mch_id = "";
        this.userid_type = 0;
        this.userid = 0L;
        this.time_stamp = 0L;
        this.token_scene = 0;
        this.token_type = 0;
        this.busi_info = "";
        this.nav_type = 0;
        this.sign = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.mch_id = jceInputStream.readString(1, true);
        this.userid_type = jceInputStream.read(this.userid_type, 2, true);
        this.userid = jceInputStream.read(this.userid, 3, true);
        this.time_stamp = jceInputStream.read(this.time_stamp, 4, true);
        this.token_scene = jceInputStream.read(this.token_scene, 5, true);
        this.token_type = jceInputStream.read(this.token_type, 6, true);
        this.busi_info = jceInputStream.readString(7, true);
        this.nav_type = jceInputStream.read(this.nav_type, 8, true);
        this.sign = jceInputStream.readString(9, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.mch_id, 1);
        jceOutputStream.write(this.userid_type, 2);
        jceOutputStream.write(this.userid, 3);
        jceOutputStream.write(this.time_stamp, 4);
        jceOutputStream.write(this.token_scene, 5);
        jceOutputStream.write(this.token_type, 6);
        jceOutputStream.write(this.busi_info, 7);
        jceOutputStream.write(this.nav_type, 8);
        jceOutputStream.write(this.sign, 9);
    }

    public GetSignV2Rsp(int i3, String str, int i16, long j3, long j16, int i17, int i18, String str2, int i19, String str3) {
        this.ret = i3;
        this.mch_id = str;
        this.userid_type = i16;
        this.userid = j3;
        this.time_stamp = j16;
        this.token_scene = i17;
        this.token_type = i18;
        this.busi_info = str2;
        this.nav_type = i19;
        this.sign = str3;
    }
}
