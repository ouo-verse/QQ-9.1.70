package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileContactsNotFriendInfo extends JceStruct {
    static byte[] cache_MobileNoMask;
    static int cache_conType;
    static int cache_eNetworkType;
    static byte[] cache_personalSign;
    public byte[] MobileNoMask;
    public int accountAbi;
    public int age;
    public long bindingDate;
    public int conType;
    public String contactsInfoEncrypt;
    public byte detalStatusFlag;
    public int eNetworkType;
    public int iTermType;
    public boolean isHide;
    public boolean isNew;
    public long isRecommend;
    public boolean isUpdateSign;
    public String nickname;
    public long originBinder;
    public byte[] personalSign;
    public long richTime;
    public int sameFriend;
    public int sex;
    public String strTermDesc;
    public long uAbiFlag;

    static {
        cache_MobileNoMask = r1;
        byte[] bArr = {0};
        cache_personalSign = r0;
        byte[] bArr2 = {0};
    }

    public MobileContactsNotFriendInfo() {
        this.bindingDate = 0L;
        this.isRecommend = 0L;
        this.nickname = "";
        this.contactsInfoEncrypt = "";
        this.MobileNoMask = null;
        this.originBinder = 0L;
        this.accountAbi = 0;
        this.conType = 0;
        this.detalStatusFlag = (byte) 0;
        this.iTermType = 0;
        this.eNetworkType = 0;
        this.strTermDesc = "";
        this.uAbiFlag = 0L;
        this.personalSign = null;
        this.isUpdateSign = true;
        this.richTime = 0L;
        this.isNew = false;
        this.isHide = false;
        this.sex = 0;
        this.age = 0;
        this.sameFriend = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bindingDate = jceInputStream.read(this.bindingDate, 0, false);
        this.isRecommend = jceInputStream.read(this.isRecommend, 1, false);
        this.nickname = jceInputStream.readString(2, false);
        this.contactsInfoEncrypt = jceInputStream.readString(3, true);
        this.MobileNoMask = jceInputStream.read(cache_MobileNoMask, 4, true);
        this.originBinder = jceInputStream.read(this.originBinder, 5, false);
        this.accountAbi = jceInputStream.read(this.accountAbi, 6, false);
        this.conType = jceInputStream.read(this.conType, 7, false);
        this.detalStatusFlag = jceInputStream.read(this.detalStatusFlag, 8, false);
        this.iTermType = jceInputStream.read(this.iTermType, 9, false);
        this.eNetworkType = jceInputStream.read(this.eNetworkType, 10, false);
        this.strTermDesc = jceInputStream.readString(11, false);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 12, false);
        this.personalSign = jceInputStream.read(cache_personalSign, 13, false);
        this.isUpdateSign = jceInputStream.read(this.isUpdateSign, 14, false);
        this.richTime = jceInputStream.read(this.richTime, 15, false);
        this.isNew = jceInputStream.read(this.isNew, 16, false);
        this.isHide = jceInputStream.read(this.isHide, 17, false);
        this.sex = jceInputStream.read(this.sex, 18, false);
        this.age = jceInputStream.read(this.age, 19, false);
        this.sameFriend = jceInputStream.read(this.sameFriend, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bindingDate, 0);
        jceOutputStream.write(this.isRecommend, 1);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.contactsInfoEncrypt, 3);
        jceOutputStream.write(this.MobileNoMask, 4);
        jceOutputStream.write(this.originBinder, 5);
        jceOutputStream.write(this.accountAbi, 6);
        jceOutputStream.write(this.conType, 7);
        jceOutputStream.write(this.detalStatusFlag, 8);
        jceOutputStream.write(this.iTermType, 9);
        jceOutputStream.write(this.eNetworkType, 10);
        String str2 = this.strTermDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        jceOutputStream.write(this.uAbiFlag, 12);
        byte[] bArr = this.personalSign;
        if (bArr != null) {
            jceOutputStream.write(bArr, 13);
        }
        jceOutputStream.write(this.isUpdateSign, 14);
        jceOutputStream.write(this.richTime, 15);
        jceOutputStream.write(this.isNew, 16);
        jceOutputStream.write(this.isHide, 17);
        jceOutputStream.write(this.sex, 18);
        jceOutputStream.write(this.age, 19);
        jceOutputStream.write(this.sameFriend, 20);
    }

    public MobileContactsNotFriendInfo(long j3, long j16, String str, String str2, byte[] bArr, long j17, int i3, int i16, byte b16, int i17, int i18, String str3, long j18, byte[] bArr2, boolean z16, long j19, boolean z17, boolean z18, int i19, int i26, int i27) {
        this.bindingDate = j3;
        this.isRecommend = j16;
        this.nickname = str;
        this.contactsInfoEncrypt = str2;
        this.MobileNoMask = bArr;
        this.originBinder = j17;
        this.accountAbi = i3;
        this.conType = i16;
        this.detalStatusFlag = b16;
        this.iTermType = i17;
        this.eNetworkType = i18;
        this.strTermDesc = str3;
        this.uAbiFlag = j18;
        this.personalSign = bArr2;
        this.isUpdateSign = z16;
        this.richTime = j19;
        this.isNew = z17;
        this.isHide = z18;
        this.sex = i19;
        this.age = i26;
        this.sameFriend = i27;
    }
}
