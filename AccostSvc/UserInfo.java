package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserInfo extends JceStruct {
    static byte[] cache_sig;
    public String MobileNick;
    public long lMobileUin;
    public String nickname;
    public String sKey;
    public byte[] sig;

    public UserInfo() {
        this.nickname = "";
        this.lMobileUin = 0L;
        this.sig = null;
        this.MobileNick = "";
        this.sKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nickname = jceInputStream.readString(0, false);
        this.lMobileUin = jceInputStream.read(this.lMobileUin, 1, false);
        if (cache_sig == null) {
            cache_sig = r1;
            byte[] bArr = {0};
        }
        this.sig = jceInputStream.read(cache_sig, 2, false);
        this.MobileNick = jceInputStream.readString(3, false);
        this.sKey = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.lMobileUin, 1);
        byte[] bArr = this.sig;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        String str2 = this.MobileNick;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.sKey;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public UserInfo(String str, long j3, byte[] bArr, String str2, String str3) {
        this.nickname = str;
        this.lMobileUin = j3;
        this.sig = bArr;
        this.MobileNick = str2;
        this.sKey = str3;
    }
}
