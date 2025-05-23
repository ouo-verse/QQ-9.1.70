package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AddressBookItem extends JceStruct {
    public String mobileNo;
    public String name;

    public AddressBookItem() {
        this.mobileNo = "";
        this.name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mobileNo = jceInputStream.readString(0, true);
        this.name = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mobileNo, 0);
        jceOutputStream.write(this.name, 1);
    }

    public AddressBookItem(String str, String str2) {
        this.mobileNo = str;
        this.name = str2;
    }
}
