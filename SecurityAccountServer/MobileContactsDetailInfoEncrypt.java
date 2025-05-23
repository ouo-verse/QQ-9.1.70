package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileContactsDetailInfoEncrypt extends JceStruct {
    static byte[] cache_MobileNoMask;
    public byte[] MobileNoMask;
    public String QQ;
    public int accountAbi;
    public long bindingDate;
    public String contactsInfoEncrypt;
    public long isRecommend;
    public String nickname;
    public long originBinder;
    public short rmdScore;

    public MobileContactsDetailInfoEncrypt() {
        this.QQ = "";
        this.bindingDate = 0L;
        this.isRecommend = 0L;
        this.nickname = "";
        this.contactsInfoEncrypt = "";
        this.MobileNoMask = null;
        this.originBinder = 0L;
        this.accountAbi = 0;
        this.rmdScore = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.QQ = jceInputStream.readString(0, true);
        this.bindingDate = jceInputStream.read(this.bindingDate, 1, false);
        this.isRecommend = jceInputStream.read(this.isRecommend, 2, false);
        this.nickname = jceInputStream.readString(3, false);
        this.contactsInfoEncrypt = jceInputStream.readString(4, true);
        if (cache_MobileNoMask == null) {
            cache_MobileNoMask = r2;
            byte[] bArr = {0};
        }
        this.MobileNoMask = jceInputStream.read(cache_MobileNoMask, 5, true);
        this.originBinder = jceInputStream.read(this.originBinder, 6, false);
        this.accountAbi = jceInputStream.read(this.accountAbi, 7, false);
        this.rmdScore = jceInputStream.read(this.rmdScore, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.QQ, 0);
        jceOutputStream.write(this.bindingDate, 1);
        jceOutputStream.write(this.isRecommend, 2);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.contactsInfoEncrypt, 4);
        jceOutputStream.write(this.MobileNoMask, 5);
        jceOutputStream.write(this.originBinder, 6);
        jceOutputStream.write(this.accountAbi, 7);
        jceOutputStream.write(this.rmdScore, 8);
    }

    public MobileContactsDetailInfoEncrypt(String str, long j3, long j16, String str2, String str3, byte[] bArr, long j17, int i3, short s16) {
        this.QQ = str;
        this.bindingDate = j3;
        this.isRecommend = j16;
        this.nickname = str2;
        this.contactsInfoEncrypt = str3;
        this.MobileNoMask = bArr;
        this.originBinder = j17;
        this.accountAbi = i3;
        this.rmdScore = s16;
    }
}
