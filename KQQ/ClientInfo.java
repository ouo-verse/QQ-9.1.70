package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ClientInfo extends JceStruct {
    static int cache_eUinType;
    public int eUinType;
    public String strAuthName;
    public String strAuthPassword;
    public String strUin;

    public ClientInfo() {
        this.eUinType = 0;
        this.strUin = "";
        this.strAuthName = "";
        this.strAuthPassword = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eUinType = jceInputStream.read(this.eUinType, 1, true);
        this.strUin = jceInputStream.readString(2, true);
        this.strAuthName = jceInputStream.readString(3, true);
        this.strAuthPassword = jceInputStream.readString(4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eUinType, 1);
        jceOutputStream.write(this.strUin, 2);
        jceOutputStream.write(this.strAuthName, 3);
        jceOutputStream.write(this.strAuthPassword, 4);
    }

    public ClientInfo(int i3, String str, String str2, String str3) {
        this.eUinType = i3;
        this.strUin = str;
        this.strAuthName = str2;
        this.strAuthPassword = str3;
    }
}
