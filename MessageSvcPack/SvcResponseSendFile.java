package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcResponseSendFile extends JceStruct {
    public String strResult;
    public long uReplyCode;

    public SvcResponseSendFile() {
        this.uReplyCode = 0L;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uReplyCode = jceInputStream.read(this.uReplyCode, 0, true);
        this.strResult = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uReplyCode, 0);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public SvcResponseSendFile(long j3, String str) {
        this.uReplyCode = j3;
        this.strResult = str;
    }
}
