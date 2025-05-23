package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NotBindContactFriendInfo extends JceStruct {
    static byte[] cache_MobileNoMask;
    public byte[] MobileNoMask;
    public long bindUin;
    public String contactsInfoEncrypt;
    public long uAbiFlag;

    static {
        cache_MobileNoMask = r0;
        byte[] bArr = {0};
    }

    public NotBindContactFriendInfo() {
        this.contactsInfoEncrypt = "";
        this.MobileNoMask = null;
        this.uAbiFlag = 0L;
        this.bindUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.contactsInfoEncrypt = jceInputStream.readString(0, true);
        this.MobileNoMask = jceInputStream.read(cache_MobileNoMask, 1, true);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 2, false);
        this.bindUin = jceInputStream.read(this.bindUin, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.contactsInfoEncrypt, 0);
        jceOutputStream.write(this.MobileNoMask, 1);
        jceOutputStream.write(this.uAbiFlag, 2);
        jceOutputStream.write(this.bindUin, 3);
    }

    public NotBindContactFriendInfo(String str, byte[] bArr, long j3, long j16) {
        this.contactsInfoEncrypt = str;
        this.MobileNoMask = bArr;
        this.uAbiFlag = j3;
        this.bindUin = j16;
    }
}
