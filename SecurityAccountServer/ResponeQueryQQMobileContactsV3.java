package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryQQMobileContactsV3 extends JceStruct {
    static ArrayList<MobileContactsFriendInfo> cache_BindFriendContacts = new ArrayList<>();
    static ArrayList<MobileContactsNotFriendInfo> cache_BindNotFriendContacts;
    static int cache_queryFlag;
    static byte[] cache_sessionSid;
    static int cache_type;
    public ArrayList<MobileContactsFriendInfo> BindFriendContacts;
    public ArrayList<MobileContactsNotFriendInfo> BindNotFriendContacts;
    public long ConfigVersion;
    public long ForcePopSwitch;
    public long MaxsignTimeStamp;
    public String MobileUniqueNo;
    public long PopCloseCount;
    public long PopWindowsCount;
    public long PopWindowsTime;
    public long UIBits;
    public long bindingTime;
    public boolean isChangeDev;
    public boolean isInactive;
    public long isRecommend;
    public long lastUsedFlag;
    public String mobileNo;
    public String nationCode;
    public long nextFlag;
    public long nextQueryTimeInterval;
    public long nextReLoginTimeInterval;
    public long nextReconnectionTimeInterval;
    public boolean noBindUploadContacts;
    public long originBinder;
    public int queryFlag;
    public byte[] sessionSid;
    public long timeStamp;
    public int type;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
        cache_BindFriendContacts.add(new MobileContactsFriendInfo());
        cache_BindNotFriendContacts = new ArrayList<>();
        cache_BindNotFriendContacts.add(new MobileContactsNotFriendInfo());
        cache_type = 0;
    }

    public ResponeQueryQQMobileContactsV3() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.sessionSid = null;
        this.queryFlag = 0;
        this.BindFriendContacts = null;
        this.BindNotFriendContacts = null;
        this.nationCode = "";
        this.mobileNo = "";
        this.MobileUniqueNo = "";
        this.isRecommend = 0L;
        this.originBinder = 1L;
        this.bindingTime = 0L;
        this.lastUsedFlag = 1L;
        this.type = 0;
        this.ConfigVersion = 0L;
        this.PopWindowsCount = 0L;
        this.PopWindowsTime = 0L;
        this.PopCloseCount = 0L;
        this.ForcePopSwitch = 0L;
        this.nextQueryTimeInterval = 0L;
        this.MaxsignTimeStamp = 0L;
        this.isInactive = false;
        this.UIBits = 0L;
        this.isChangeDev = false;
        this.noBindUploadContacts = false;
        this.nextReconnectionTimeInterval = 0L;
        this.nextReLoginTimeInterval = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        this.queryFlag = jceInputStream.read(this.queryFlag, 3, true);
        this.BindFriendContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_BindFriendContacts, 4, true);
        this.BindNotFriendContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_BindNotFriendContacts, 5, true);
        this.nationCode = jceInputStream.readString(6, true);
        this.mobileNo = jceInputStream.readString(7, true);
        this.MobileUniqueNo = jceInputStream.readString(8, true);
        this.isRecommend = jceInputStream.read(this.isRecommend, 9, true);
        this.originBinder = jceInputStream.read(this.originBinder, 10, true);
        this.bindingTime = jceInputStream.read(this.bindingTime, 11, false);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 12, false);
        this.type = jceInputStream.read(this.type, 13, false);
        this.ConfigVersion = jceInputStream.read(this.ConfigVersion, 14, false);
        this.PopWindowsCount = jceInputStream.read(this.PopWindowsCount, 15, false);
        this.PopWindowsTime = jceInputStream.read(this.PopWindowsTime, 16, false);
        this.PopCloseCount = jceInputStream.read(this.PopCloseCount, 17, false);
        this.ForcePopSwitch = jceInputStream.read(this.ForcePopSwitch, 18, false);
        this.nextQueryTimeInterval = jceInputStream.read(this.nextQueryTimeInterval, 19, false);
        this.MaxsignTimeStamp = jceInputStream.read(this.MaxsignTimeStamp, 20, false);
        this.isInactive = jceInputStream.read(this.isInactive, 21, false);
        this.UIBits = jceInputStream.read(this.UIBits, 22, false);
        this.isChangeDev = jceInputStream.read(this.isChangeDev, 23, false);
        this.noBindUploadContacts = jceInputStream.read(this.noBindUploadContacts, 24, false);
        this.nextReconnectionTimeInterval = jceInputStream.read(this.nextReconnectionTimeInterval, 25, false);
        this.nextReLoginTimeInterval = jceInputStream.read(this.nextReLoginTimeInterval, 26, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write(this.queryFlag, 3);
        jceOutputStream.write((Collection) this.BindFriendContacts, 4);
        jceOutputStream.write((Collection) this.BindNotFriendContacts, 5);
        jceOutputStream.write(this.nationCode, 6);
        jceOutputStream.write(this.mobileNo, 7);
        jceOutputStream.write(this.MobileUniqueNo, 8);
        jceOutputStream.write(this.isRecommend, 9);
        jceOutputStream.write(this.originBinder, 10);
        jceOutputStream.write(this.bindingTime, 11);
        jceOutputStream.write(this.lastUsedFlag, 12);
        jceOutputStream.write(this.type, 13);
        jceOutputStream.write(this.ConfigVersion, 14);
        jceOutputStream.write(this.PopWindowsCount, 15);
        jceOutputStream.write(this.PopWindowsTime, 16);
        jceOutputStream.write(this.PopCloseCount, 17);
        jceOutputStream.write(this.ForcePopSwitch, 18);
        jceOutputStream.write(this.nextQueryTimeInterval, 19);
        jceOutputStream.write(this.MaxsignTimeStamp, 20);
        jceOutputStream.write(this.isInactive, 21);
        jceOutputStream.write(this.UIBits, 22);
        jceOutputStream.write(this.isChangeDev, 23);
        jceOutputStream.write(this.noBindUploadContacts, 24);
        jceOutputStream.write(this.nextReconnectionTimeInterval, 25);
        jceOutputStream.write(this.nextReLoginTimeInterval, 26);
    }

    public ResponeQueryQQMobileContactsV3(long j3, long j16, byte[] bArr, int i3, ArrayList<MobileContactsFriendInfo> arrayList, ArrayList<MobileContactsNotFriendInfo> arrayList2, String str, String str2, String str3, long j17, long j18, long j19, long j26, int i16, long j27, long j28, long j29, long j36, long j37, long j38, long j39, boolean z16, long j46, boolean z17, boolean z18, long j47, long j48) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.sessionSid = bArr;
        this.queryFlag = i3;
        this.BindFriendContacts = arrayList;
        this.BindNotFriendContacts = arrayList2;
        this.nationCode = str;
        this.mobileNo = str2;
        this.MobileUniqueNo = str3;
        this.isRecommend = j17;
        this.originBinder = j18;
        this.bindingTime = j19;
        this.lastUsedFlag = j26;
        this.type = i16;
        this.ConfigVersion = j27;
        this.PopWindowsCount = j28;
        this.PopWindowsTime = j29;
        this.PopCloseCount = j36;
        this.ForcePopSwitch = j37;
        this.nextQueryTimeInterval = j38;
        this.MaxsignTimeStamp = j39;
        this.isInactive = z16;
        this.UIBits = j46;
        this.isChangeDev = z17;
        this.noBindUploadContacts = z18;
        this.nextReconnectionTimeInterval = j47;
        this.nextReLoginTimeInterval = j48;
    }
}
