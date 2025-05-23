package NS_GROUP_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class profile_count_item extends JceStruct {
    public long count;
    public String jumpSchema;
    public long uin;

    public profile_count_item() {
        this.uin = 0L;
        this.jumpSchema = "";
        this.count = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.jumpSchema = jceInputStream.readString(1, false);
        this.count = jceInputStream.read(this.count, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.jumpSchema;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.count, 2);
    }

    public profile_count_item(long j3, String str, long j16) {
        this.uin = j3;
        this.jumpSchema = str;
        this.count = j16;
    }
}
