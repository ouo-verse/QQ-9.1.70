package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileContactsFriendInfo extends JceStruct {
    static byte[] cache_MobileNoMask;
    public byte[] MobileNoMask;
    public String QQ;
    public int accountAbi;
    public long bindingDate;
    public String contactsInfoEncrypt;
    public long isRecommend;
    public long originBinder;

    public MobileContactsFriendInfo() {
        this.QQ = "";
        this.bindingDate = 0L;
        this.isRecommend = 0L;
        this.contactsInfoEncrypt = "";
        this.MobileNoMask = null;
        this.originBinder = 0L;
        this.accountAbi = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.QQ = jceInputStream.readString(0, true);
        this.bindingDate = jceInputStream.read(this.bindingDate, 1, false);
        this.isRecommend = jceInputStream.read(this.isRecommend, 2, false);
        this.contactsInfoEncrypt = jceInputStream.readString(3, true);
        if (cache_MobileNoMask == null) {
            cache_MobileNoMask = r2;
            byte[] bArr = {0};
        }
        this.MobileNoMask = jceInputStream.read(cache_MobileNoMask, 4, true);
        this.originBinder = jceInputStream.read(this.originBinder, 5, false);
        this.accountAbi = jceInputStream.read(this.accountAbi, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.QQ, 0);
        jceOutputStream.write(this.bindingDate, 1);
        jceOutputStream.write(this.isRecommend, 2);
        jceOutputStream.write(this.contactsInfoEncrypt, 3);
        jceOutputStream.write(this.MobileNoMask, 4);
        jceOutputStream.write(this.originBinder, 5);
        jceOutputStream.write(this.accountAbi, 6);
    }

    public MobileContactsFriendInfo(String str, long j3, long j16, String str2, byte[] bArr, long j17, int i3) {
        this.QQ = str;
        this.bindingDate = j3;
        this.isRecommend = j16;
        this.contactsInfoEncrypt = str2;
        this.MobileNoMask = bArr;
        this.originBinder = j17;
        this.accountAbi = i3;
    }
}
