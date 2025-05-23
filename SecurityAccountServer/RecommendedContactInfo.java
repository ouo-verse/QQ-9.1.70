package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RecommendedContactInfo extends JceStruct {
    static byte[] cache_MobileNoMask;
    static int cache_conType;
    static int cache_eNetworkType;
    public byte[] MobileNoMask;
    public int age;
    public int conType;
    public String contactsInfoEncrypt;
    public byte detalStatusFlag;
    public int eNetworkType;
    public long faceFlag;
    public long faceSysId;
    public long faceTimeStamp;
    public long faceType;
    public String faceUrl;
    public int iTermType;
    public String personalSign;
    public int sex;
    public String strTermDesc;
    public long uAbiFlag;

    static {
        cache_MobileNoMask = r0;
        byte[] bArr = {0};
    }

    public RecommendedContactInfo() {
        this.contactsInfoEncrypt = "";
        this.MobileNoMask = null;
        this.conType = 0;
        this.detalStatusFlag = (byte) 0;
        this.iTermType = 0;
        this.eNetworkType = 0;
        this.strTermDesc = "";
        this.uAbiFlag = 0L;
        this.sex = 0;
        this.age = 0;
        this.personalSign = "";
        this.faceType = 0L;
        this.faceTimeStamp = 0L;
        this.faceFlag = 0L;
        this.faceUrl = "";
        this.faceSysId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.contactsInfoEncrypt = jceInputStream.readString(1, true);
        this.MobileNoMask = jceInputStream.read(cache_MobileNoMask, 2, true);
        this.conType = jceInputStream.read(this.conType, 3, false);
        this.detalStatusFlag = jceInputStream.read(this.detalStatusFlag, 4, false);
        this.iTermType = jceInputStream.read(this.iTermType, 5, false);
        this.eNetworkType = jceInputStream.read(this.eNetworkType, 6, false);
        this.strTermDesc = jceInputStream.readString(7, false);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 8, false);
        this.sex = jceInputStream.read(this.sex, 9, false);
        this.age = jceInputStream.read(this.age, 10, false);
        this.personalSign = jceInputStream.readString(11, false);
        this.faceType = jceInputStream.read(this.faceType, 12, false);
        this.faceTimeStamp = jceInputStream.read(this.faceTimeStamp, 13, false);
        this.faceFlag = jceInputStream.read(this.faceFlag, 14, false);
        this.faceUrl = jceInputStream.readString(15, false);
        this.faceSysId = jceInputStream.read(this.faceSysId, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.contactsInfoEncrypt, 1);
        jceOutputStream.write(this.MobileNoMask, 2);
        jceOutputStream.write(this.conType, 3);
        jceOutputStream.write(this.detalStatusFlag, 4);
        jceOutputStream.write(this.iTermType, 5);
        jceOutputStream.write(this.eNetworkType, 6);
        String str = this.strTermDesc;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.uAbiFlag, 8);
        jceOutputStream.write(this.sex, 9);
        jceOutputStream.write(this.age, 10);
        String str2 = this.personalSign;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        jceOutputStream.write(this.faceType, 12);
        jceOutputStream.write(this.faceTimeStamp, 13);
        jceOutputStream.write(this.faceFlag, 14);
        String str3 = this.faceUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 15);
        }
        jceOutputStream.write(this.faceSysId, 16);
    }

    public RecommendedContactInfo(String str, byte[] bArr, int i3, byte b16, int i16, int i17, String str2, long j3, int i18, int i19, String str3, long j16, long j17, long j18, String str4, long j19) {
        this.contactsInfoEncrypt = str;
        this.MobileNoMask = bArr;
        this.conType = i3;
        this.detalStatusFlag = b16;
        this.iTermType = i16;
        this.eNetworkType = i17;
        this.strTermDesc = str2;
        this.uAbiFlag = j3;
        this.sex = i18;
        this.age = i19;
        this.personalSign = str3;
        this.faceType = j16;
        this.faceTimeStamp = j17;
        this.faceFlag = j18;
        this.faceUrl = str4;
        this.faceSysId = j19;
    }
}
