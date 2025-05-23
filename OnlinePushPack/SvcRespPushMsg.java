package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcRespPushMsg extends JceStruct {
    static byte[] cache_bytes_push_token;
    static DeviceInfo cache_deviceInfo;
    static ArrayList<DelMsgInfo> cache_vDelInfos = new ArrayList<>();
    public byte[] bytes_push_token;
    public DeviceInfo deviceInfo;
    public long lUin;
    public int service_type;
    public int svrip;
    public ArrayList<DelMsgInfo> vDelInfos;

    static {
        cache_vDelInfos.add(new DelMsgInfo());
        cache_bytes_push_token = r0;
        byte[] bArr = {0};
        cache_deviceInfo = new DeviceInfo();
    }

    public SvcRespPushMsg() {
        this.lUin = 0L;
        this.vDelInfos = null;
        this.svrip = 0;
        this.bytes_push_token = null;
        this.service_type = 0;
        this.deviceInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.vDelInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vDelInfos, 1, true);
        this.svrip = jceInputStream.read(this.svrip, 2, true);
        this.bytes_push_token = jceInputStream.read(cache_bytes_push_token, 3, false);
        this.service_type = jceInputStream.read(this.service_type, 4, false);
        this.deviceInfo = (DeviceInfo) jceInputStream.read((JceStruct) cache_deviceInfo, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write((Collection) this.vDelInfos, 1);
        jceOutputStream.write(this.svrip, 2);
        byte[] bArr = this.bytes_push_token;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.service_type, 4);
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            jceOutputStream.write((JceStruct) deviceInfo, 5);
        }
    }

    public SvcRespPushMsg(long j3, ArrayList<DelMsgInfo> arrayList, int i3, byte[] bArr, int i16, DeviceInfo deviceInfo) {
        this.lUin = j3;
        this.vDelInfos = arrayList;
        this.svrip = i3;
        this.bytes_push_token = bArr;
        this.service_type = i16;
        this.deviceInfo = deviceInfo;
    }
}
