package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OnlineInfo extends JceStruct {
    static byte[] cache_subPlatform;
    public int clientType;
    public int instanceId;
    public int onlineStatus;
    public int platformId;
    public byte[] subPlatform;

    static {
        cache_subPlatform = r0;
        byte[] bArr = {0};
    }

    public OnlineInfo() {
        this.instanceId = 0;
        this.clientType = 0;
        this.onlineStatus = 0;
        this.platformId = 0;
        this.subPlatform = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.instanceId = jceInputStream.read(this.instanceId, 0, false);
        this.clientType = jceInputStream.read(this.clientType, 1, false);
        this.onlineStatus = jceInputStream.read(this.onlineStatus, 2, false);
        this.platformId = jceInputStream.read(this.platformId, 3, false);
        this.subPlatform = jceInputStream.read(cache_subPlatform, 4, false);
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
    }

    public OnlineInfo(int i3, int i16, int i17, int i18, byte[] bArr) {
        this.instanceId = i3;
        this.clientType = i16;
        this.onlineStatus = i17;
        this.platformId = i18;
        this.subPlatform = bArr;
    }
}
