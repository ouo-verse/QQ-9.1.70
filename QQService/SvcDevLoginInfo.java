package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcDevLoginInfo extends JceStruct {
    static DeviceItemDes cache_stDeviceItemDes = new DeviceItemDes();
    static byte[] cache_vecGuid;
    public long iAppId;
    public long iCanBeKicked;
    public long iLoginPlatform;
    public long iLoginTime;
    public long iProductType;
    public long iTerType;
    public DeviceItemDes stDeviceItemDes;
    public String strDeviceName;
    public String strDeviceTypeInfo;
    public String strLoginLocation;
    public byte[] vecGuid;

    static {
        cache_vecGuid = r0;
        byte[] bArr = {0};
    }

    public SvcDevLoginInfo() {
        this.iAppId = 0L;
        this.vecGuid = null;
        this.iLoginTime = 0L;
        this.iLoginPlatform = 0L;
        this.strLoginLocation = "";
        this.strDeviceName = "";
        this.strDeviceTypeInfo = "";
        this.stDeviceItemDes = null;
        this.iTerType = 0L;
        this.iProductType = 0L;
        this.iCanBeKicked = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 0, true);
        this.vecGuid = jceInputStream.read(cache_vecGuid, 1, false);
        this.iLoginTime = jceInputStream.read(this.iLoginTime, 2, true);
        this.iLoginPlatform = jceInputStream.read(this.iLoginPlatform, 3, false);
        this.strLoginLocation = jceInputStream.readString(4, false);
        this.strDeviceName = jceInputStream.readString(5, false);
        this.strDeviceTypeInfo = jceInputStream.readString(6, false);
        this.stDeviceItemDes = (DeviceItemDes) jceInputStream.read((JceStruct) cache_stDeviceItemDes, 7, false);
        this.iTerType = jceInputStream.read(this.iTerType, 8, false);
        this.iProductType = jceInputStream.read(this.iProductType, 9, false);
        this.iCanBeKicked = jceInputStream.read(this.iCanBeKicked, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 0);
        byte[] bArr = this.vecGuid;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.iLoginTime, 2);
        jceOutputStream.write(this.iLoginPlatform, 3);
        String str = this.strLoginLocation;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.strDeviceName;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.strDeviceTypeInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        DeviceItemDes deviceItemDes = this.stDeviceItemDes;
        if (deviceItemDes != null) {
            jceOutputStream.write((JceStruct) deviceItemDes, 7);
        }
        jceOutputStream.write(this.iTerType, 8);
        jceOutputStream.write(this.iProductType, 9);
        jceOutputStream.write(this.iCanBeKicked, 10);
    }

    public SvcDevLoginInfo(long j3, byte[] bArr, long j16, long j17, String str, String str2, String str3, DeviceItemDes deviceItemDes, long j18, long j19, long j26) {
        this.iAppId = j3;
        this.vecGuid = bArr;
        this.iLoginTime = j16;
        this.iLoginPlatform = j17;
        this.strLoginLocation = str;
        this.strDeviceName = str2;
        this.strDeviceTypeInfo = str3;
        this.stDeviceItemDes = deviceItemDes;
        this.iTerType = j18;
        this.iProductType = j19;
        this.iCanBeKicked = j26;
    }
}
