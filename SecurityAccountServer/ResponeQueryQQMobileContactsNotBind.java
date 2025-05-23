package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryQQMobileContactsNotBind extends JceStruct {
    static ArrayList<NotBindContactFriendInfo> cache_BindFriendContacts;
    static ArrayList<NotBindContactNotFriendInfo> cache_BindNotFriendContacts = new ArrayList<>();
    static byte[] cache_sessionSid;
    public ArrayList<NotBindContactFriendInfo> BindFriendContacts;
    public ArrayList<NotBindContactNotFriendInfo> BindNotFriendContacts;
    public String MobileUniqueNo;
    public boolean isChangeDev;
    public long lastUsedFlag;
    public long nextFlag;
    public byte[] sessionSid;
    public long timeStamp;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
        cache_BindNotFriendContacts.add(new NotBindContactNotFriendInfo());
        cache_BindFriendContacts = new ArrayList<>();
        cache_BindFriendContacts.add(new NotBindContactFriendInfo());
    }

    public ResponeQueryQQMobileContactsNotBind() {
        this.nextFlag = 0L;
        this.sessionSid = null;
        this.BindNotFriendContacts = null;
        this.BindFriendContacts = null;
        this.MobileUniqueNo = "";
        this.lastUsedFlag = 1L;
        this.timeStamp = 0L;
        this.isChangeDev = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 1, true);
        this.BindNotFriendContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_BindNotFriendContacts, 2, true);
        this.BindFriendContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_BindFriendContacts, 3, true);
        this.MobileUniqueNo = jceInputStream.readString(4, true);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 5, false);
        this.timeStamp = jceInputStream.read(this.timeStamp, 6, false);
        this.isChangeDev = jceInputStream.read(this.isChangeDev, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.sessionSid, 1);
        jceOutputStream.write((Collection) this.BindNotFriendContacts, 2);
        jceOutputStream.write((Collection) this.BindFriendContacts, 3);
        jceOutputStream.write(this.MobileUniqueNo, 4);
        jceOutputStream.write(this.lastUsedFlag, 5);
        jceOutputStream.write(this.timeStamp, 6);
        jceOutputStream.write(this.isChangeDev, 7);
    }

    public ResponeQueryQQMobileContactsNotBind(long j3, byte[] bArr, ArrayList<NotBindContactNotFriendInfo> arrayList, ArrayList<NotBindContactFriendInfo> arrayList2, String str, long j16, long j17, boolean z16) {
        this.nextFlag = j3;
        this.sessionSid = bArr;
        this.BindNotFriendContacts = arrayList;
        this.BindFriendContacts = arrayList2;
        this.MobileUniqueNo = str;
        this.lastUsedFlag = j16;
        this.timeStamp = j17;
        this.isChangeDev = z16;
    }
}
