package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespHeader extends JceStruct {
    public int Result;
    public String ResultDesc;

    public RespHeader() {
        this.Result = 0;
        this.ResultDesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Result = jceInputStream.read(this.Result, 0, true);
        this.ResultDesc = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Result, 0);
        String str = this.ResultDesc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public RespHeader(int i3, String str) {
        this.Result = i3;
        this.ResultDesc = str;
    }
}
