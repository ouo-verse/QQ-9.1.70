package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LastLoginInfo extends JceStruct {
    public String contactsInfoEncrypt;

    public LastLoginInfo() {
        this.contactsInfoEncrypt = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.contactsInfoEncrypt = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.contactsInfoEncrypt, 0);
    }

    public LastLoginInfo(String str) {
        this.contactsInfoEncrypt = str;
    }
}
