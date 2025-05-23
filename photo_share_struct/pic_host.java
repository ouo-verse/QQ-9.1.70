package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class pic_host extends JceStruct {
    public String nick;
    public long uin;

    public pic_host() {
        this.uin = 0L;
        this.nick = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nick = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public pic_host(long j3, String str) {
        this.uin = j3;
        this.nick = str;
    }
}
