package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestUpdateAddressBook extends JceStruct {
    static ArrayList<AddressBookItem> cache_AddressBookAddList;
    static ArrayList<AddressBookItem> cache_AddressBookDelList;
    static byte[] cache_sessionSid;
    public ArrayList<AddressBookItem> AddressBookAddList;
    public ArrayList<AddressBookItem> AddressBookDelList;
    public String MobileUniqueNo;
    public long nextFlag;
    public byte[] sessionSid;

    public RequestUpdateAddressBook() {
        this.nextFlag = 0L;
        this.MobileUniqueNo = "";
        this.sessionSid = null;
        this.AddressBookAddList = null;
        this.AddressBookDelList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.MobileUniqueNo = jceInputStream.readString(1, true);
        if (cache_sessionSid == null) {
            cache_sessionSid = r0;
            byte[] bArr = {0};
        }
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        if (cache_AddressBookAddList == null) {
            cache_AddressBookAddList = new ArrayList<>();
            cache_AddressBookAddList.add(new AddressBookItem());
        }
        this.AddressBookAddList = (ArrayList) jceInputStream.read((JceInputStream) cache_AddressBookAddList, 3, true);
        if (cache_AddressBookDelList == null) {
            cache_AddressBookDelList = new ArrayList<>();
            cache_AddressBookDelList.add(new AddressBookItem());
        }
        this.AddressBookDelList = (ArrayList) jceInputStream.read((JceInputStream) cache_AddressBookDelList, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.MobileUniqueNo, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write((Collection) this.AddressBookAddList, 3);
        jceOutputStream.write((Collection) this.AddressBookDelList, 4);
    }

    public RequestUpdateAddressBook(long j3, String str, byte[] bArr, ArrayList<AddressBookItem> arrayList, ArrayList<AddressBookItem> arrayList2) {
        this.nextFlag = j3;
        this.MobileUniqueNo = str;
        this.sessionSid = bArr;
        this.AddressBookAddList = arrayList;
        this.AddressBookDelList = arrayList2;
    }
}
