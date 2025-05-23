package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OnlineInfos extends JceStruct {
    static byte[] cache_subPlatform;
    public byte[] appName;
    public int clientType;
    public byte[] deviceName;
    public byte[] encryptGuid;
    public int encryptGuidVersion;
    public int instanceId;
    public int loginSigAppId;
    public int onlineStatus;
    public int platformId;
    public byte[] subPlatform;
    public long uClientType;

    static {
        cache_subPlatform = r0;
        byte[] bArr = {0};
    }

    public OnlineInfos() {
        this.instanceId = 0;
        this.clientType = 0;
        this.onlineStatus = 0;
        this.platformId = 0;
        this.subPlatform = null;
        this.uClientType = 0L;
        this.deviceName = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.instanceId = jceInputStream.read(this.instanceId, 0, false);
        this.clientType = jceInputStream.read(this.clientType, 1, false);
        this.onlineStatus = jceInputStream.read(this.onlineStatus, 2, false);
        this.platformId = jceInputStream.read(this.platformId, 3, false);
        this.subPlatform = jceInputStream.read(cache_subPlatform, 4, false);
        this.uClientType = jceInputStream.read(this.uClientType, 5, false);
        this.deviceName = jceInputStream.read(this.deviceName, 6, false);
        this.encryptGuid = jceInputStream.read(this.encryptGuid, 7, false);
        this.loginSigAppId = jceInputStream.read(this.loginSigAppId, 8, false);
        this.encryptGuidVersion = jceInputStream.read(this.encryptGuidVersion, 9, false);
        this.appName = jceInputStream.read(this.appName, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.instanceId, 0);
        jceOutputStream.write(this.clientType, 1);
        jceOutputStream.write(this.onlineStatus, 2);
        jceOutputStream.write(this.platformId, 3);
        byte[] bArr = this.subPlatform;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        jceOutputStream.write(this.uClientType, 5);
        byte[] bArr2 = this.deviceName;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
        byte[] bArr3 = this.encryptGuid;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 7);
        }
        jceOutputStream.write(this.loginSigAppId, 8);
        jceOutputStream.write(this.encryptGuidVersion, 9);
        byte[] bArr4 = this.appName;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 10);
        }
    }

    public OnlineInfos(int i3, int i16, int i17, int i18, byte[] bArr, long j3, byte[] bArr2, byte[] bArr3, int i19, int i26, byte[] bArr4) {
        this.instanceId = i3;
        this.clientType = i16;
        this.onlineStatus = i17;
        this.platformId = i18;
        this.subPlatform = bArr;
        this.uClientType = j3;
        this.deviceName = bArr2;
        this.encryptGuid = bArr3;
        this.loginSigAppId = i19;
        this.encryptGuidVersion = i26;
        this.appName = bArr4;
    }
}
