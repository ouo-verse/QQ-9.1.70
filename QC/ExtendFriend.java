package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ExtendFriend extends JceStruct {
    public int fontid;

    public ExtendFriend() {
        this.fontid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fontid = jceInputStream.read(this.fontid, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fontid, 0);
    }

    public ExtendFriend(int i3) {
        this.fontid = i3;
    }
}
