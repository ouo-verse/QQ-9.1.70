package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TempMsgHead extends JceStruct {
    public int c2c_type;
    public int service_type;

    public TempMsgHead() {
        this.c2c_type = 0;
        this.service_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.c2c_type = jceInputStream.read(this.c2c_type, 0, false);
        this.service_type = jceInputStream.read(this.service_type, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.c2c_type, 0);
        jceOutputStream.write(this.service_type, 1);
    }

    public TempMsgHead(int i3, int i16) {
        this.c2c_type = i3;
        this.service_type = i16;
    }
}
