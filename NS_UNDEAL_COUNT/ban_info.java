package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ban_info extends JceStruct {
    public byte iBanLevel;
    public String strMessage;

    public ban_info() {
        this.strMessage = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iBanLevel = jceInputStream.read(this.iBanLevel, 0, false);
        this.strMessage = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iBanLevel, 0);
        String str = this.strMessage;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public ban_info(byte b16, String str) {
        this.iBanLevel = b16;
        this.strMessage = str;
    }
}
