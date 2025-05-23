package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRspDelLoginInfo extends JceStruct {
    public int iResult;
    public String strResult;

    public SvcRspDelLoginInfo() {
        this.iResult = 0;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iResult = jceInputStream.read(this.iResult, 0, true);
        this.strResult = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iResult, 0);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public SvcRspDelLoginInfo(int i3, String str) {
        this.iResult = i3;
        this.strResult = str;
    }
}
