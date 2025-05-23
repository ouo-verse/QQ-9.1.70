package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NotBindContactNotFriendInfo extends JceStruct {
    static byte[] cache_MobileNoMask;
    public byte[] MobileNoMask;
    public int age;
    public String contactsInfoEncrypt;
    public boolean isNew;
    public String nickname;
    public int sameFriend;
    public int sex;
    public long uAbiFlag;

    static {
        cache_MobileNoMask = r0;
        byte[] bArr = {0};
    }

    public NotBindContactNotFriendInfo() {
        this.contactsInfoEncrypt = "";
        this.MobileNoMask = null;
        this.uAbiFlag = 0L;
        this.sex = 0;
        this.age = 0;
        this.sameFriend = 0;
        this.isNew = false;
        this.nickname = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.contactsInfoEncrypt = jceInputStream.readString(0, true);
        this.MobileNoMask = jceInputStream.read(cache_MobileNoMask, 1, true);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 2, false);
        this.sex = jceInputStream.read(this.sex, 3, false);
        this.age = jceInputStream.read(this.age, 4, false);
        this.sameFriend = jceInputStream.read(this.sameFriend, 5, false);
        this.isNew = jceInputStream.read(this.isNew, 6, false);
        this.nickname = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.contactsInfoEncrypt, 0);
        jceOutputStream.write(this.MobileNoMask, 1);
        jceOutputStream.write(this.uAbiFlag, 2);
        jceOutputStream.write(this.sex, 3);
        jceOutputStream.write(this.age, 4);
        jceOutputStream.write(this.sameFriend, 5);
        jceOutputStream.write(this.isNew, 6);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
    }

    public NotBindContactNotFriendInfo(String str, byte[] bArr, long j3, int i3, int i16, int i17, boolean z16, String str2) {
        this.contactsInfoEncrypt = str;
        this.MobileNoMask = bArr;
        this.uAbiFlag = j3;
        this.sex = i3;
        this.age = i16;
        this.sameFriend = i17;
        this.isNew = z16;
        this.nickname = str2;
    }
}
