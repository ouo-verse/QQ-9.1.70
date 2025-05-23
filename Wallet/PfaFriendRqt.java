package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PfaFriendRqt extends JceStruct {
    public String mqq_version = "";
    public String pfa_msg_edition = "";
    public String skey = "";
    public int pfa_sub_type = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mqq_version = jceInputStream.readString(0, true);
        this.pfa_msg_edition = jceInputStream.readString(1, true);
        this.skey = jceInputStream.readString(2, true);
        this.pfa_sub_type = jceInputStream.read(this.pfa_sub_type, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mqq_version, 0);
        jceOutputStream.write(this.pfa_msg_edition, 1);
        jceOutputStream.write(this.skey, 2);
        jceOutputStream.write(this.pfa_sub_type, 3);
    }
}
