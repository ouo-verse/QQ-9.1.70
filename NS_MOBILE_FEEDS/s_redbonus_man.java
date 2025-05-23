package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_redbonus_man extends JceStruct {
    static s_user cache_user = new s_user();
    public long payMoney;
    public long payTime;
    public s_user user;

    public s_redbonus_man() {
        this.user = null;
        this.payTime = 0L;
        this.payMoney = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        this.payTime = jceInputStream.read(this.payTime, 1, false);
        this.payMoney = jceInputStream.read(this.payMoney, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        jceOutputStream.write(this.payTime, 1);
        jceOutputStream.write(this.payMoney, 2);
    }

    public s_redbonus_man(s_user s_userVar, long j3, long j16) {
        this.user = s_userVar;
        this.payTime = j3;
        this.payMoney = j16;
    }
}
