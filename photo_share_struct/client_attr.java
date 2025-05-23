package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class client_attr extends JceStruct {
    public int action;
    public uin_attr attr;
    public long gender;
    public String qq_nick;
    public long uin;
    static uin_attr cache_attr = new uin_attr();
    static int cache_action = 0;

    public client_attr() {
        this.uin = 0L;
        this.attr = null;
        this.qq_nick = "";
        this.action = 0;
        this.gender = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.attr = (uin_attr) jceInputStream.read((JceStruct) cache_attr, 1, false);
        this.qq_nick = jceInputStream.readString(2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.gender = jceInputStream.read(this.gender, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        uin_attr uin_attrVar = this.attr;
        if (uin_attrVar != null) {
            jceOutputStream.write((JceStruct) uin_attrVar, 1);
        }
        String str = this.qq_nick;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.action, 3);
        jceOutputStream.write(this.gender, 4);
    }

    public client_attr(long j3, uin_attr uin_attrVar, String str, int i3, long j16) {
        this.uin = j3;
        this.attr = uin_attrVar;
        this.qq_nick = str;
        this.action = i3;
        this.gender = j16;
    }
}
