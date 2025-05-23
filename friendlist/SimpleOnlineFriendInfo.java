package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SimpleOnlineFriendInfo extends JceStruct {
    static int cache_eIconType;
    static int cache_eNetworkType;
    static byte[] cache_vecExtInfo;
    static byte[] cache_vecExtOnlineBusinessInfo;
    static byte[] cache_vecMusicInfo;
    static byte[] cache_vecPoiInfo;
    public byte cNetwork;
    public byte cSpecialFlag;
    public byte detalStatusFlag;
    public int eIconType;
    public int eNetworkType;
    public long friendUin;
    public int iBatteryStatus;
    public int iTermType;
    public byte isIphoneOnline;
    public byte isMqqOnLine;
    public String sShowName;
    public byte sqqOnLineState;
    public byte sqqOnLineStateV2;
    public byte status;
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

    public SimpleOnlineFriendInfo() {
        this.friendUin = 0L;
        this.status = QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA;
        this.isMqqOnLine = (byte) 0;
        this.sqqOnLineState = (byte) 0;
        this.isIphoneOnline = (byte) 0;
        this.detalStatusFlag = (byte) 0;
        this.sqqOnLineStateV2 = (byte) 0;
        this.sShowName = "";
        this.cSpecialFlag = (byte) 0;
        this.iTermType = 0;
        this.cNetwork = (byte) 0;
        this.uAbiFlag = 0L;
        this.eNetworkType = 0;
        this.eIconType = 0;
        this.strTermDesc = "";
        this.uExtOnlineStatus = 0L;
        this.iBatteryStatus = 0;
        this.vecMusicInfo = null;
        this.vecPoiInfo = null;
        this.vecExtOnlineBusinessInfo = null;
        this.vecExtInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.friendUin = jceInputStream.read(this.friendUin, 0, true);
        this.status = jceInputStream.read(this.status, 1, true);
        this.isMqqOnLine = jceInputStream.read(this.isMqqOnLine, 2, true);
        this.sqqOnLineState = jceInputStream.read(this.sqqOnLineState, 3, true);
        this.isIphoneOnline = jceInputStream.read(this.isIphoneOnline, 4, false);
        this.detalStatusFlag = jceInputStream.read(this.detalStatusFlag, 5, false);
        this.sqqOnLineStateV2 = jceInputStream.read(this.sqqOnLineStateV2, 6, false);
        this.sShowName = jceInputStream.readString(7, false);
        this.cSpecialFlag = jceInputStream.read(this.cSpecialFlag, 8, false);
        this.iTermType = jceInputStream.read(this.iTermType, 9, false);
        this.cNetwork = jceInputStream.read(this.cNetwork, 10, false);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 11, false);
        this.eNetworkType = jceInputStream.read(this.eNetworkType, 12, false);
        this.eIconType = jceInputStream.read(this.eIconType, 13, false);
        this.strTermDesc = jceInputStream.readString(14, false);
        this.uExtOnlineStatus = jceInputStream.read(this.uExtOnlineStatus, 15, false);
        this.iBatteryStatus = jceInputStream.read(this.iBatteryStatus, 16, false);
        this.vecMusicInfo = jceInputStream.read(cache_vecMusicInfo, 17, false);
        this.vecPoiInfo = jceInputStream.read(cache_vecPoiInfo, 18, false);
        this.vecExtOnlineBusinessInfo = jceInputStream.read(cache_vecExtOnlineBusinessInfo, 19, false);
        this.vecExtInfo = jceInputStream.read(cache_vecExtInfo, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.friendUin, 0);
        jceOutputStream.write(this.status, 1);
        jceOutputStream.write(this.isMqqOnLine, 2);
        jceOutputStream.write(this.sqqOnLineState, 3);
        jceOutputStream.write(this.isIphoneOnline, 4);
        jceOutputStream.write(this.detalStatusFlag, 5);
        jceOutputStream.write(this.sqqOnLineStateV2, 6);
        String str = this.sShowName;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.cSpecialFlag, 8);
        jceOutputStream.write(this.iTermType, 9);
        jceOutputStream.write(this.cNetwork, 10);
        jceOutputStream.write(this.uAbiFlag, 11);
        jceOutputStream.write(this.eNetworkType, 12);
        jceOutputStream.write(this.eIconType, 13);
        String str2 = this.strTermDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 14);
        }
        jceOutputStream.write(this.uExtOnlineStatus, 15);
        jceOutputStream.write(this.iBatteryStatus, 16);
        byte[] bArr = this.vecMusicInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 17);
        }
        byte[] bArr2 = this.vecPoiInfo;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 18);
        }
        byte[] bArr3 = this.vecExtOnlineBusinessInfo;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 19);
        }
        byte[] bArr4 = this.vecExtInfo;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 20);
        }
    }

    public SimpleOnlineFriendInfo(long j3, byte b16, byte b17, byte b18, byte b19, byte b26, byte b27, String str, byte b28, int i3, byte b29, long j16, int i16, int i17, String str2, long j17, int i18, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.friendUin = j3;
        this.status = b16;
        this.isMqqOnLine = b17;
        this.sqqOnLineState = b18;
        this.isIphoneOnline = b19;
        this.detalStatusFlag = b26;
        this.sqqOnLineStateV2 = b27;
        this.sShowName = str;
        this.cSpecialFlag = b28;
        this.iTermType = i3;
        this.cNetwork = b29;
        this.uAbiFlag = j16;
        this.eNetworkType = i16;
        this.eIconType = i17;
        this.strTermDesc = str2;
        this.uExtOnlineStatus = j17;
        this.iBatteryStatus = i18;
        this.vecMusicInfo = bArr;
        this.vecPoiInfo = bArr2;
        this.vecExtOnlineBusinessInfo = bArr3;
        this.vecExtInfo = bArr4;
    }
}
