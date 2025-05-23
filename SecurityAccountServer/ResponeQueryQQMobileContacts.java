package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryQQMobileContacts extends JceStruct {
    static ArrayList<MobileContactsDetailInfo> cache_alreadyBindContacts = new ArrayList<>();
    static ArrayList<MobileContactsDetailInfo> cache_noBindContacts;
    static byte[] cache_sessionSid;
    public ArrayList<MobileContactsDetailInfo> alreadyBindContacts;
    public long nextFlag;
    public ArrayList<MobileContactsDetailInfo> noBindContacts;
    public byte[] sessionSid;
    public long timeStamp;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
        cache_alreadyBindContacts.add(new MobileContactsDetailInfo());
        cache_noBindContacts = new ArrayList<>();
        cache_noBindContacts.add(new MobileContactsDetailInfo());
    }

    public ResponeQueryQQMobileContacts() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.sessionSid = null;
        this.alreadyBindContacts = null;
        this.noBindContacts = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        this.alreadyBindContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_alreadyBindContacts, 3, true);
        this.noBindContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_noBindContacts, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write((Collection) this.alreadyBindContacts, 3);
        jceOutputStream.write((Collection) this.noBindContacts, 4);
    }

    public ResponeQueryQQMobileContacts(long j3, long j16, byte[] bArr, ArrayList<MobileContactsDetailInfo> arrayList, ArrayList<MobileContactsDetailInfo> arrayList2) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.sessionSid = bArr;
        this.alreadyBindContacts = arrayList;
        this.noBindContacts = arrayList2;
    }
}
