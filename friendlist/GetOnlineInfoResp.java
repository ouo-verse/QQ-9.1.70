package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetOnlineInfoResp extends JceStruct {
    static int cache_eIconType;
    static int cache_eNetworkType;
    static int cache_result;
    static byte[] cache_vecExtInfo;
    static byte[] cache_vecExtOnlineBusinessInfo;
    static byte[] cache_vecMusicInfo;
    static byte[] cache_vecPoiInfo;
    public long dwInterval;
    public long dwStatus;
    public long dwUin;
    public int eIconType;
    public int eNetworkType;
    public short errorCode;
    public int iBatteryStatus;
    public long iTermType;
    public int result;
    public String strCustomOnlineStatusDesc;
    public String strTermDesc;
    public long uAbiFlag;
    public long uExtOnlineStatus;
    public byte[] vecExtInfo;
    public byte[] vecExtOnlineBusinessInfo;
    public byte[] vecMusicInfo;
    public byte[] vecPoiInfo;

    static {
        cache_vecMusicInfo = r1;
        byte[] bArr = {0};
        cache_vecPoiInfo = r1;
        byte[] bArr2 = {0};
        cache_vecExtOnlineBusinessInfo = r1;
        byte[] bArr3 = {0};
        cache_vecExtInfo = r0;
        byte[] bArr4 = {0};
    }

    public GetOnlineInfoResp() {
        this.result = 0;
        this.errorCode = (short) 0;
        this.dwStatus = 20L;
        this.iTermType = 0L;
        this.uAbiFlag = 0L;
        this.eNetworkType = 0;
        this.eIconType = 0;
        this.dwInterval = 30L;
        this.dwUin = 0L;
        this.strTermDesc = "";
        this.strCustomOnlineStatusDesc = "";
        this.uExtOnlineStatus = 0L;
        this.iBatteryStatus = 0;
        this.vecMusicInfo = null;
        this.vecPoiInfo = null;
        this.vecExtOnlineBusinessInfo = null;
        this.vecExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.errorCode = jceInputStream.read(this.errorCode, 1, true);
        this.dwStatus = jceInputStream.read(this.dwStatus, 2, false);
        this.iTermType = jceInputStream.read(this.iTermType, 3, false);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 4, false);
        this.eNetworkType = jceInputStream.read(this.eNetworkType, 5, false);
        this.eIconType = jceInputStream.read(this.eIconType, 6, false);
        this.dwInterval = jceInputStream.read(this.dwInterval, 7, false);
        this.dwUin = jceInputStream.read(this.dwUin, 8, false);
        this.strTermDesc = jceInputStream.readString(9, false);
        this.strCustomOnlineStatusDesc = jceInputStream.readString(10, false);
        this.uExtOnlineStatus = jceInputStream.read(this.uExtOnlineStatus, 11, false);
        this.iBatteryStatus = jceInputStream.read(this.iBatteryStatus, 12, false);
        this.vecMusicInfo = jceInputStream.read(cache_vecMusicInfo, 13, false);
        this.vecPoiInfo = jceInputStream.read(cache_vecPoiInfo, 14, false);
        this.vecExtOnlineBusinessInfo = jceInputStream.read(cache_vecExtOnlineBusinessInfo, 15, false);
        this.vecExtInfo = jceInputStream.read(cache_vecExtInfo, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.errorCode, 1);
        jceOutputStream.write(this.dwStatus, 2);
        jceOutputStream.write(this.iTermType, 3);
        jceOutputStream.write(this.uAbiFlag, 4);
        jceOutputStream.write(this.eNetworkType, 5);
        jceOutputStream.write(this.eIconType, 6);
        jceOutputStream.write(this.dwInterval, 7);
        jceOutputStream.write(this.dwUin, 8);
        String str = this.strTermDesc;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        String str2 = this.strCustomOnlineStatusDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        jceOutputStream.write(this.uExtOnlineStatus, 11);
        jceOutputStream.write(this.iBatteryStatus, 12);
        byte[] bArr = this.vecMusicInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 13);
        }
        byte[] bArr2 = this.vecPoiInfo;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 14);
        }
        byte[] bArr3 = this.vecExtOnlineBusinessInfo;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 15);
        }
        byte[] bArr4 = this.vecExtInfo;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 16);
        }
    }

    public GetOnlineInfoResp(int i3, short s16, long j3, long j16, long j17, int i16, int i17, long j18, long j19, String str, String str2, long j26, int i18, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.result = i3;
        this.errorCode = s16;
        this.dwStatus = j3;
        this.iTermType = j16;
        this.uAbiFlag = j17;
        this.eNetworkType = i16;
        this.eIconType = i17;
        this.dwInterval = j18;
        this.dwUin = j19;
        this.strTermDesc = str;
        this.strCustomOnlineStatusDesc = str2;
        this.uExtOnlineStatus = j26;
        this.iBatteryStatus = i18;
        this.vecMusicInfo = bArr;
        this.vecPoiInfo = bArr2;
        this.vecExtOnlineBusinessInfo = bArr3;
        this.vecExtInfo = bArr4;
    }
}
