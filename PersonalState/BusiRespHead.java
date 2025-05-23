package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BusiRespHead extends JceStruct {
    public int iReplyCode;
    public int iSeq;
    public short shVersion;
    public String strResult;

    public BusiRespHead() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.iReplyCode = 0;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 2, true);
        this.strResult = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write(this.iReplyCode, 2);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public BusiRespHead(short s16, int i3, int i16, String str) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.iReplyCode = i16;
        this.strResult = str;
    }
}
