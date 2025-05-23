package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserData extends JceStruct {
    public byte cIfPushPic;

    public UserData() {
        this.cIfPushPic = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cIfPushPic = jceInputStream.read(this.cIfPushPic, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cIfPushPic, 0);
    }

    public UserData(byte b16) {
        this.cIfPushPic = b16;
    }
}
