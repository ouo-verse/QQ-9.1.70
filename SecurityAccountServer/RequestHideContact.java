package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestHideContact extends JceStruct {
    static AddressBookItem cache_contact = new AddressBookItem();
    public AddressBookItem contact;
    public boolean isHide;

    public RequestHideContact() {
        this.contact = null;
        this.isHide = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.contact = (AddressBookItem) jceInputStream.read((JceStruct) cache_contact, 0, true);
        this.isHide = jceInputStream.read(this.isHide, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.contact, 0);
        jceOutputStream.write(this.isHide, 1);
    }

    public RequestHideContact(AddressBookItem addressBookItem, boolean z16) {
        this.contact = addressBookItem;
        this.isHide = z16;
    }
}
