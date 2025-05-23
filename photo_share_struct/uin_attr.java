package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class uin_attr extends JceStruct {
    static int cache_status;
    public long add_time;
    public String nick;
    public byte priv;
    public String share_albumid;
    public int status;

    public uin_attr() {
        this.status = 0;
        this.nick = "";
        this.priv = (byte) 3;
        this.share_albumid = "";
        this.add_time = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, false);
        this.nick = jceInputStream.readString(1, false);
        this.priv = jceInputStream.read(this.priv, 2, false);
        this.share_albumid = jceInputStream.readString(3, false);
        this.add_time = jceInputStream.read(this.add_time, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.priv, 2);
        String str2 = this.share_albumid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.add_time, 4);
    }

    public uin_attr(int i3, String str, byte b16, String str2, long j3) {
        this.status = i3;
        this.nick = str;
        this.priv = b16;
        this.share_albumid = str2;
        this.add_time = j3;
    }
}
