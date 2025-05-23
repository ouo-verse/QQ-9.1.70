package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetUserTailRsp extends JceStruct {
    public String strTailName;
    public String strTailNoIcon;

    public SetUserTailRsp() {
        this.strTailName = "";
        this.strTailNoIcon = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strTailName = jceInputStream.readString(0, true);
        this.strTailNoIcon = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strTailName, 0);
        String str = this.strTailNoIcon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public SetUserTailRsp(String str, String str2) {
        this.strTailName = str;
        this.strTailNoIcon = str2;
    }
}
