package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestUploadAddressBookV2 extends JceStruct {
    static ArrayList<AddressBookItem> cache_AddressBookList;
    static byte[] cache_sessionSid;
    public ArrayList<AddressBookItem> AddressBookList;
    public String MobileUniqueNo;
    public long nextFlag;
    public byte[] sessionSid;

    public RequestUploadAddressBookV2() {
        this.nextFlag = 0L;
        this.MobileUniqueNo = "";
        this.sessionSid = null;
        this.AddressBookList = null;
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
        if (cache_AddressBookList == null) {
            cache_AddressBookList = new ArrayList<>();
            cache_AddressBookList.add(new AddressBookItem());
        }
        this.AddressBookList = (ArrayList) jceInputStream.read((JceInputStream) cache_AddressBookList, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.MobileUniqueNo, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write((Collection) this.AddressBookList, 3);
    }

    public RequestUploadAddressBookV2(long j3, String str, byte[] bArr, ArrayList<AddressBookItem> arrayList) {
        this.nextFlag = j3;
        this.MobileUniqueNo = str;
        this.sessionSid = bArr;
        this.AddressBookList = arrayList;
    }
}
