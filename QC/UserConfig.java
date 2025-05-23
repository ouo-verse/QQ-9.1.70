package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserConfig extends JceStruct {
    public int effect_id;
    public long group_code;
    public long set_mode;
    public long status;

    public UserConfig() {
        this.group_code = 0L;
        this.effect_id = 0;
        this.status = 0L;
        this.set_mode = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.group_code = jceInputStream.read(this.group_code, 0, false);
        this.effect_id = jceInputStream.read(this.effect_id, 1, false);
        this.status = jceInputStream.read(this.status, 2, false);
        this.set_mode = jceInputStream.read(this.set_mode, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.group_code, 0);
        jceOutputStream.write(this.effect_id, 1);
        jceOutputStream.write(this.status, 2);
        jceOutputStream.write(this.set_mode, 3);
    }

    public UserConfig(long j3, int i3, long j16, long j17) {
        this.group_code = j3;
        this.effect_id = i3;
        this.status = j16;
        this.set_mode = j17;
    }
}
