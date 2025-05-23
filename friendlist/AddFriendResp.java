package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AddFriendResp extends JceStruct {
    static int cache_adduinsetting;
    static byte[] cache_name;
    static byte[] cache_name1;
    static int cache_result;
    static byte[] cache_sig;
    static byte[] cache_verify;
    public String ErrorString;
    public long adduin;
    public int adduinsetting;
    public short errorCode;
    public byte myAllowFlag;
    public byte myfriendgroupid;
    public byte[] name;
    public byte[] name1;
    public int result;
    public byte[] sig;
    public long uin;
    public byte[] verify;

    static {
        cache_sig = r1;
        byte[] bArr = {0};
        cache_name = r1;
        byte[] bArr2 = {0};
        cache_name1 = r1;
        byte[] bArr3 = {0};
        cache_verify = r0;
        byte[] bArr4 = {0};
    }

    public AddFriendResp() {
        this.uin = 0L;
        this.adduin = 0L;
        this.adduinsetting = 0;
        this.myAllowFlag = (byte) 0;
        this.myfriendgroupid = (byte) 0;
        this.result = 0;
        this.errorCode = (short) 0;
        this.ErrorString = "";
        this.sig = null;
        this.name = null;
        this.name1 = null;
        this.verify = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.adduin = jceInputStream.read(this.adduin, 1, true);
        this.adduinsetting = jceInputStream.read(this.adduinsetting, 2, true);
        this.myAllowFlag = jceInputStream.read(this.myAllowFlag, 3, true);
        this.myfriendgroupid = jceInputStream.read(this.myfriendgroupid, 4, true);
        this.result = jceInputStream.read(this.result, 6, true);
        this.errorCode = jceInputStream.read(this.errorCode, 7, false);
        this.ErrorString = jceInputStream.readString(8, false);
        this.sig = jceInputStream.read(cache_sig, 9, false);
        this.name = jceInputStream.read(cache_name, 10, false);
        this.name1 = jceInputStream.read(cache_name1, 11, false);
        this.verify = jceInputStream.read(cache_verify, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.adduin, 1);
        jceOutputStream.write(this.adduinsetting, 2);
        jceOutputStream.write(this.myAllowFlag, 3);
        jceOutputStream.write(this.myfriendgroupid, 4);
        jceOutputStream.write(this.result, 6);
        jceOutputStream.write(this.errorCode, 7);
        String str = this.ErrorString;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        byte[] bArr = this.sig;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
        byte[] bArr2 = this.name;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 10);
        }
        byte[] bArr3 = this.name1;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 11);
        }
        byte[] bArr4 = this.verify;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 12);
        }
    }

    public AddFriendResp(long j3, long j16, int i3, byte b16, byte b17, int i16, short s16, String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.uin = j3;
        this.adduin = j16;
        this.adduinsetting = i3;
        this.myAllowFlag = b16;
        this.myfriendgroupid = b17;
        this.result = i16;
        this.errorCode = s16;
        this.ErrorString = str;
        this.sig = bArr;
        this.name = bArr2;
        this.name1 = bArr3;
        this.verify = bArr4;
    }
}
