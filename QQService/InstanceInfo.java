package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InstanceInfo extends JceStruct {
    public byte[] appName;
    public byte cTablet;
    public byte[] deviceName;
    public byte[] encryptGuid;
    public int encryptGuidVersion;
    public int iAppId;
    public long iClientType;
    public long iPlatform;
    public long iProductType;
    public int loginSigAppId;

    public InstanceInfo() {
        this.iAppId = 0;
        this.cTablet = (byte) 0;
        this.iPlatform = 0L;
        this.iProductType = 0L;
        this.iClientType = 0L;
        this.deviceName = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 0, false);
        this.cTablet = jceInputStream.read(this.cTablet, 1, false);
        this.iPlatform = jceInputStream.read(this.iPlatform, 2, false);
        this.iProductType = jceInputStream.read(this.iProductType, 3, false);
        this.iClientType = jceInputStream.read(this.iClientType, 4, false);
        this.deviceName = jceInputStream.read(this.deviceName, 5, false);
        this.encryptGuid = jceInputStream.read(this.encryptGuid, 6, false);
        this.loginSigAppId = jceInputStream.read(this.loginSigAppId, 7, false);
        this.encryptGuidVersion = jceInputStream.read(this.encryptGuidVersion, 8, false);
        this.appName = jceInputStream.read(this.appName, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 0);
        jceOutputStream.write(this.cTablet, 1);
        jceOutputStream.write(this.iPlatform, 2);
        jceOutputStream.write(this.iProductType, 3);
        jceOutputStream.write(this.iClientType, 4);
        byte[] bArr = this.deviceName;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        byte[] bArr2 = this.encryptGuid;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
        jceOutputStream.write(this.loginSigAppId, 7);
        jceOutputStream.write(this.encryptGuidVersion, 8);
        byte[] bArr3 = this.appName;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 9);
        }
    }

    public InstanceInfo(int i3, byte b16, long j3, long j16, long j17, byte[] bArr, byte[] bArr2, int i16, int i17, byte[] bArr3) {
        this.iAppId = i3;
        this.cTablet = b16;
        this.iPlatform = j3;
        this.iProductType = j16;
        this.iClientType = j17;
        this.deviceName = bArr;
        this.encryptGuid = bArr2;
        this.loginSigAppId = i16;
        this.encryptGuidVersion = i17;
        this.appName = bArr3;
    }
}
