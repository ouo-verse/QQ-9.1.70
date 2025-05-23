package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestUploadAddressBookNotBind extends JceStruct {
    static ArrayList<AddressBookItem> cache_AddressBookList = new ArrayList<>();
    static byte[] cache_sessionSid;
    public ArrayList<AddressBookItem> AddressBookList;
    public String MobileUniqueNo;
    public long nextFlag;
    public byte[] sessionSid;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
        cache_AddressBookList.add(new AddressBookItem());
    }

    public RequestUploadAddressBookNotBind() {
        this.nextFlag = 0L;
        this.MobileUniqueNo = "";
        this.sessionSid = null;
        this.AddressBookList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.MobileUniqueNo = jceInputStream.readString(1, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        this.AddressBookList = (ArrayList) jceInputStream.read((JceInputStream) cache_AddressBookList, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.MobileUniqueNo, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write((Collection) this.AddressBookList, 3);
    }

    public RequestUploadAddressBookNotBind(long j3, String str, byte[] bArr, ArrayList<AddressBookItem> arrayList) {
        this.nextFlag = j3;
        this.MobileUniqueNo = str;
        this.sessionSid = bArr;
        this.AddressBookList = arrayList;
    }
}
