package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PfaFriend extends JceStruct {
    public String uin = "";
    public int type = 0;
    public String rec_desc = "";
    public int month_remain_limit = 0;
    public int per_limit = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, true);
        this.type = jceInputStream.read(this.type, 1, true);
        this.rec_desc = jceInputStream.readString(2, false);
        this.month_remain_limit = jceInputStream.read(this.month_remain_limit, 3, false);
        this.per_limit = jceInputStream.read(this.per_limit, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.type, 1);
        String str = this.rec_desc;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.month_remain_limit, 3);
        jceOutputStream.write(this.per_limit, 4);
    }
}
