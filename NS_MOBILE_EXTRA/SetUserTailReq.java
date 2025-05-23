package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetUserTailReq extends JceStruct {
    public int iDiyTag;
    public String strDiyMemo;
    public String strIdentifySqua;

    public SetUserTailReq() {
        this.strIdentifySqua = "";
        this.strDiyMemo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strIdentifySqua = jceInputStream.readString(0, false);
        this.strDiyMemo = jceInputStream.readString(1, false);
        this.iDiyTag = jceInputStream.read(this.iDiyTag, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strIdentifySqua;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strDiyMemo;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.iDiyTag, 2);
    }

    public SetUserTailReq(String str, String str2, int i3) {
        this.strIdentifySqua = str;
        this.strDiyMemo = str2;
        this.iDiyTag = i3;
    }
}
