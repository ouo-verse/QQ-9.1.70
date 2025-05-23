package PUSHAPI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PushRsp extends JceStruct {
    static byte[] cache_UID;
    public String Mark;
    public byte[] UID;
    public long flag;
    public byte is_bgd;
    public long ptime;
    public String sUID;

    static {
        cache_UID = r0;
        byte[] bArr = {0};
    }

    public PushRsp() {
        this.Mark = "";
        this.sUID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.UID = jceInputStream.read(cache_UID, 0, false);
        this.ptime = jceInputStream.read(this.ptime, 1, false);
        this.Mark = jceInputStream.readString(3, false);
        this.is_bgd = jceInputStream.read(this.is_bgd, 4, false);
        this.sUID = jceInputStream.readString(5, false);
        this.flag = jceInputStream.read(this.flag, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.UID;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.ptime, 1);
        String str = this.Mark;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.is_bgd, 4);
        String str2 = this.sUID;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.flag, 6);
    }

    public PushRsp(byte[] bArr, long j3, String str, byte b16, String str2, long j16) {
        this.UID = bArr;
        this.ptime = j3;
        this.Mark = str;
        this.is_bgd = b16;
        this.sUID = str2;
        this.flag = j16;
    }
}
