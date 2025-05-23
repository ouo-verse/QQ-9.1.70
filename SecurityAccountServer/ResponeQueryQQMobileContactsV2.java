package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryQQMobileContactsV2 extends JceStruct {
    static ArrayList<MobileContactsDetailInfoEncrypt> cache_alreadyBindContacts;
    static byte[] cache_sessionSid;
    public ArrayList<MobileContactsDetailInfoEncrypt> alreadyBindContacts;
    public long nextFlag;
    public byte[] sessionSid;
    public long timeStamp;

    public ResponeQueryQQMobileContactsV2() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.sessionSid = null;
        this.alreadyBindContacts = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        if (cache_sessionSid == null) {
            cache_sessionSid = r0;
            byte[] bArr = {0};
        }
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        if (cache_alreadyBindContacts == null) {
            cache_alreadyBindContacts = new ArrayList<>();
            cache_alreadyBindContacts.add(new MobileContactsDetailInfoEncrypt());
        }
        this.alreadyBindContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_alreadyBindContacts, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write((Collection) this.alreadyBindContacts, 3);
    }

    public ResponeQueryQQMobileContactsV2(long j3, long j16, byte[] bArr, ArrayList<MobileContactsDetailInfoEncrypt> arrayList) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.sessionSid = bArr;
        this.alreadyBindContacts = arrayList;
    }
}
