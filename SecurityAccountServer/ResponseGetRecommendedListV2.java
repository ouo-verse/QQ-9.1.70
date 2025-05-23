package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponseGetRecommendedListV2 extends JceStruct {
    static ArrayList<MobileContactsDetailInfoEncrypt> cache_alreadyBindContacts;
    static ArrayList<MobileContactsDetailInfoEncrypt> cache_assistBindContacts;
    static ArrayList<CircleFriendInfo> cache_circleInfo;
    static byte[] cache_sessionSid;
    static int cache_type;
    public long ConfigVersion;
    public long ForcePopSwitch;
    public String MobileUniqueNo;
    public long PopCloseCount;
    public long PopWindowsCount;
    public long PopWindowsTime;
    public ArrayList<MobileContactsDetailInfoEncrypt> alreadyBindContacts;
    public ArrayList<MobileContactsDetailInfoEncrypt> assistBindContacts;
    public long bindingTime;
    public ArrayList<CircleFriendInfo> circleInfo;
    public long lastUsedFlag;
    public String mobileNo;
    public String nationCode;
    public long nextFlag;
    public long originBinder;
    public byte[] sessionSid;
    public long timeStamp;
    public int type;

    public ResponseGetRecommendedListV2() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.sessionSid = null;
        this.alreadyBindContacts = null;
        this.circleInfo = null;
        this.assistBindContacts = null;
        this.nationCode = "";
        this.mobileNo = "";
        this.MobileUniqueNo = "";
        this.lastUsedFlag = 1L;
        this.type = 0;
        this.originBinder = 1L;
        this.bindingTime = 0L;
        this.ConfigVersion = 0L;
        this.PopWindowsCount = 0L;
        this.PopWindowsTime = 0L;
        this.PopCloseCount = 0L;
        this.ForcePopSwitch = 0L;
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
        if (cache_circleInfo == null) {
            cache_circleInfo = new ArrayList<>();
            cache_circleInfo.add(new CircleFriendInfo());
        }
        this.circleInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_circleInfo, 4, false);
        if (cache_assistBindContacts == null) {
            cache_assistBindContacts = new ArrayList<>();
            cache_assistBindContacts.add(new MobileContactsDetailInfoEncrypt());
        }
        this.assistBindContacts = (ArrayList) jceInputStream.read((JceInputStream) cache_assistBindContacts, 5, false);
        this.nationCode = jceInputStream.readString(6, false);
        this.mobileNo = jceInputStream.readString(7, false);
        this.MobileUniqueNo = jceInputStream.readString(8, false);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 9, false);
        this.type = jceInputStream.read(this.type, 10, false);
        this.originBinder = jceInputStream.read(this.originBinder, 11, false);
        this.bindingTime = jceInputStream.read(this.bindingTime, 12, false);
        this.ConfigVersion = jceInputStream.read(this.ConfigVersion, 13, false);
        this.PopWindowsCount = jceInputStream.read(this.PopWindowsCount, 14, false);
        this.PopWindowsTime = jceInputStream.read(this.PopWindowsTime, 15, false);
        this.PopCloseCount = jceInputStream.read(this.PopCloseCount, 16, false);
        this.ForcePopSwitch = jceInputStream.read(this.ForcePopSwitch, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write((Collection) this.alreadyBindContacts, 3);
        ArrayList<CircleFriendInfo> arrayList = this.circleInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<MobileContactsDetailInfoEncrypt> arrayList2 = this.assistBindContacts;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        String str = this.nationCode;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        String str2 = this.mobileNo;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        String str3 = this.MobileUniqueNo;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        jceOutputStream.write(this.lastUsedFlag, 9);
        jceOutputStream.write(this.type, 10);
        jceOutputStream.write(this.originBinder, 11);
        jceOutputStream.write(this.bindingTime, 12);
        jceOutputStream.write(this.ConfigVersion, 13);
        jceOutputStream.write(this.PopWindowsCount, 14);
        jceOutputStream.write(this.PopWindowsTime, 15);
        jceOutputStream.write(this.PopCloseCount, 16);
        jceOutputStream.write(this.ForcePopSwitch, 17);
    }

    public ResponseGetRecommendedListV2(long j3, long j16, byte[] bArr, ArrayList<MobileContactsDetailInfoEncrypt> arrayList, ArrayList<CircleFriendInfo> arrayList2, ArrayList<MobileContactsDetailInfoEncrypt> arrayList3, String str, String str2, String str3, long j17, int i3, long j18, long j19, long j26, long j27, long j28, long j29, long j36) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.sessionSid = bArr;
        this.alreadyBindContacts = arrayList;
        this.circleInfo = arrayList2;
        this.assistBindContacts = arrayList3;
        this.nationCode = str;
        this.mobileNo = str2;
        this.MobileUniqueNo = str3;
        this.lastUsedFlag = j17;
        this.type = i3;
        this.originBinder = j18;
        this.bindingTime = j19;
        this.ConfigVersion = j26;
        this.PopWindowsCount = j27;
        this.PopWindowsTime = j28;
        this.PopCloseCount = j29;
        this.ForcePopSwitch = j36;
    }
}
