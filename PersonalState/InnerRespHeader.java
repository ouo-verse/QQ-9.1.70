package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InnerRespHeader extends JceStruct {
    public int iReplyCode;
    public int iSeq;
    public long lUIN;
    public short shVersion;
    public String strResult;

    public InnerRespHeader() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.lUIN = 0L;
        this.iReplyCode = 0;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
        this.lUIN = jceInputStream.read(this.lUIN, 2, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 3, true);
        this.strResult = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write(this.lUIN, 2);
        jceOutputStream.write(this.iReplyCode, 3);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public InnerRespHeader(short s16, int i3, long j3, int i16, String str) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.lUIN = j3;
        this.iReplyCode = i16;
        this.strResult = str;
    }
}
