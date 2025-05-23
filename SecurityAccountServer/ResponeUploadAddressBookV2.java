package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeUploadAddressBookV2 extends JceStruct {
    static ArrayList<MobileContactsFriendInfo> cache_BindFriendContacts;
    static ArrayList<MobileContactsNotFriendInfo> cache_BindNotFriendContacts;
    static byte[] cache_sessionSid;
    public ArrayList<MobileContactsFriendInfo> BindFriendContacts;
    public ArrayList<MobileContactsNotFriendInfo> BindNotFriendContacts;
    public long MaxsignTimeStamp;
    public long nextFlag;
    public byte[] sessionSid;
    public long timeStamp;

    public ResponeUploadAddressBookV2() {
        this.nextFlag = 0L;
        this.sessionSid = null;
        this.BindFriendContacts = null;
        this.BindNotFriendContacts = null;
        this.MaxsignTimeStamp = 0L;
        this.timeStamp = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        if (cache_sessionSid == null) {
            cache_sessionSid = r0;
            byte[] bArr = {0};
        }
        this.sessionSid = jceInputStream.read(cache_sessionSid, 1, true);
        if (cache_BindFriendContacts == null) {
            cache_BindFriendContacts = new ArrayList<>();
            cache_BindFriendContacts.add(new MobileContactsFriendInfo());
        }
        this.BindFriendContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_BindFriendContacts, 2, true);
        if (cache_BindNotFriendContacts == null) {
            cache_BindNotFriendContacts = new ArrayList<>();
            cache_BindNotFriendContacts.add(new MobileContactsNotFriendInfo());
        }
        this.BindNotFriendContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_BindNotFriendContacts, 3, true);
        this.MaxsignTimeStamp = jceInputStream.read(this.MaxsignTimeStamp, 4, false);
        this.timeStamp = jceInputStream.read(this.timeStamp, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.sessionSid, 1);
        jceOutputStream.write((Collection) this.BindFriendContacts, 2);
        jceOutputStream.write((Collection) this.BindNotFriendContacts, 3);
        jceOutputStream.write(this.MaxsignTimeStamp, 4);
        jceOutputStream.write(this.timeStamp, 5);
    }

    public ResponeUploadAddressBookV2(long j3, byte[] bArr, ArrayList<MobileContactsFriendInfo> arrayList, ArrayList<MobileContactsNotFriendInfo> arrayList2, long j16, long j17) {
        this.nextFlag = j3;
        this.sessionSid = bArr;
        this.BindFriendContacts = arrayList;
        this.BindNotFriendContacts = arrayList2;
        this.MaxsignTimeStamp = j16;
        this.timeStamp = j17;
    }
}
