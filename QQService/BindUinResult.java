package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BindUinResult extends JceStruct {
    public int iResult;
    public long lUin;
    public String strResult;

    public BindUinResult() {
        this.lUin = 0L;
        this.iResult = 0;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.iResult = jceInputStream.read(this.iResult, 1, true);
        this.strResult = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iResult, 1);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public BindUinResult(long j3, int i3, String str) {
        this.lUin = j3;
        this.iResult = i3;
        this.strResult = str;
    }
}
