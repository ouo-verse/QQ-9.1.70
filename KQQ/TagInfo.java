package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TagInfo extends JceStruct {
    public byte bType;
    public long iTagId;
    public String strContent;

    public TagInfo() {
        this.bType = (byte) 0;
        this.iTagId = 0L;
        this.strContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bType = jceInputStream.read(this.bType, 0, true);
        this.iTagId = jceInputStream.read(this.iTagId, 1, true);
        this.strContent = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bType, 0);
        jceOutputStream.write(this.iTagId, 1);
        String str = this.strContent;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public TagInfo(byte b16, long j3, String str) {
        this.bType = b16;
        this.iTagId = j3;
        this.strContent = str;
    }
}
