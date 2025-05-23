package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_brandspace_h5 extends JceStruct {
    public String frdfans_nick;
    public long frdfans_num;
    public String url;

    public s_brandspace_h5() {
        this.frdfans_num = 0L;
        this.frdfans_nick = "";
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.frdfans_num = jceInputStream.read(this.frdfans_num, 0, true);
        this.frdfans_nick = jceInputStream.readString(1, false);
        this.url = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.frdfans_num, 0);
        String str = this.frdfans_nick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public s_brandspace_h5(long j3, String str, String str2) {
        this.frdfans_num = j3;
        this.frdfans_nick = str;
        this.url = str2;
    }
}
