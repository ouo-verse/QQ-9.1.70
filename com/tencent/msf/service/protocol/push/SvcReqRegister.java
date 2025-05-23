package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SvcReqRegister extends JceStruct {
    static byte[] cache_bytes_0x769_reqbody;
    static VendorPushInfo cache_stVendorPushInfo;
    static ArrayList<a> cache_vecBindUin = new ArrayList<>();
    static byte[] cache_vecCustomStatus;
    static byte[] cache_vecDevParam;
    static byte[] cache_vecGuid;
    static byte[] cache_vecRegisterExtData;
    static byte[] cache_vecServerBuf;
    public byte bIsOnline;
    public byte bIsSetStatus;
    public byte bIsShowOnline;
    public byte bKikPC;
    public byte bKikWeak;
    public byte bLoginType;
    public byte bOnlinePush;
    public byte bOpenPush;
    public byte bRegType;
    public byte bSetMute;
    public byte bSlientPush;
    public byte bTimActiveFlag;
    public byte[] bytes_0x769_reqbody;
    public byte cBindUinNotifySwitch;
    public byte cConnType;
    public byte cNetType;
    public byte cNotifySwitch;
    public int iBatteryStatus;
    public long iLargeSeq;
    public long iLastWatchStartTime;
    public int iLocaleID;
    public long iOSVersion;
    public int iStatus;
    public long lBid;
    public long lCpId;
    public long lUin;
    public long lVendorDevId;
    public String sBuildVer;
    public String sChannelNo;
    public String sOther;
    public VendorPushInfo stVendorPushInfo;
    public String strDevName;
    public String strDevType;
    public String strIOSIdfa;
    public String strOSVer;
    public String strVendorName;
    public String strVendorOSName;
    public long timeStamp;
    public long uExtOnlineStatus;
    public long uNewSSOIp;
    public long uOldSSOIp;
    public ArrayList<a> vecBindUin;
    public byte[] vecCustomStatus;
    public byte[] vecDevParam;
    public byte[] vecGuid;
    public byte[] vecRegisterExtData;
    public byte[] vecServerBuf;

    static {
        cache_vecDevParam = r1;
        byte[] bArr = {0};
        cache_vecGuid = r1;
        byte[] bArr2 = {0};
        cache_vecBindUin.add(new a());
        cache_bytes_0x769_reqbody = r1;
        byte[] bArr3 = {0};
        cache_vecServerBuf = r1;
        byte[] bArr4 = {0};
        cache_stVendorPushInfo = new VendorPushInfo();
        cache_vecCustomStatus = r1;
        byte[] bArr5 = {0};
        cache_vecRegisterExtData = r0;
        byte[] bArr6 = {0};
    }

    public SvcReqRegister() {
        this.lUin = 0L;
        this.lBid = 0L;
        this.cConnType = (byte) 0;
        this.sOther = "";
        this.iStatus = 11;
        this.bOnlinePush = (byte) 0;
        this.bIsOnline = (byte) 0;
        this.bIsShowOnline = (byte) 0;
        this.bKikPC = (byte) 0;
        this.bKikWeak = (byte) 0;
        this.timeStamp = 0L;
        this.iOSVersion = 0L;
        this.cNetType = (byte) 0;
        this.sBuildVer = "";
        this.bRegType = (byte) 0;
        this.vecDevParam = null;
        this.vecGuid = null;
        this.iLocaleID = 2052;
        this.bSlientPush = (byte) 0;
        this.strDevName = "";
        this.strDevType = "";
        this.strOSVer = "";
        this.bOpenPush = (byte) 1;
        this.iLargeSeq = 0L;
        this.iLastWatchStartTime = 0L;
        this.vecBindUin = null;
        this.uOldSSOIp = 0L;
        this.uNewSSOIp = 0L;
        this.sChannelNo = "";
        this.lCpId = 0L;
        this.strVendorName = "";
        this.strVendorOSName = "";
        this.strIOSIdfa = "";
        this.bytes_0x769_reqbody = null;
        this.bIsSetStatus = (byte) 0;
        this.vecServerBuf = null;
        this.bSetMute = (byte) 0;
        this.cNotifySwitch = (byte) 1;
        this.uExtOnlineStatus = 0L;
        this.iBatteryStatus = 0;
        this.bTimActiveFlag = (byte) 1;
        this.cBindUinNotifySwitch = (byte) 1;
        this.stVendorPushInfo = null;
        this.lVendorDevId = 0L;
        this.vecCustomStatus = null;
        this.bLoginType = (byte) 0;
        this.vecRegisterExtData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.lBid = jceInputStream.read(this.lBid, 1, true);
        this.cConnType = jceInputStream.read(this.cConnType, 2, true);
        this.sOther = jceInputStream.readString(3, true);
        this.iStatus = jceInputStream.read(this.iStatus, 4, false);
        this.bOnlinePush = jceInputStream.read(this.bOnlinePush, 5, false);
        this.bIsOnline = jceInputStream.read(this.bIsOnline, 6, false);
        this.bIsShowOnline = jceInputStream.read(this.bIsShowOnline, 7, false);
        this.bKikPC = jceInputStream.read(this.bKikPC, 8, false);
        this.bKikWeak = jceInputStream.read(this.bKikWeak, 9, false);
        this.timeStamp = jceInputStream.read(this.timeStamp, 10, false);
        this.iOSVersion = jceInputStream.read(this.iOSVersion, 11, false);
        this.cNetType = jceInputStream.read(this.cNetType, 12, false);
        this.sBuildVer = jceInputStream.readString(13, false);
        this.bRegType = jceInputStream.read(this.bRegType, 14, false);
        this.vecDevParam = jceInputStream.read(cache_vecDevParam, 15, false);
        this.vecGuid = jceInputStream.read(cache_vecGuid, 16, false);
        this.iLocaleID = jceInputStream.read(this.iLocaleID, 17, false);
        this.bSlientPush = jceInputStream.read(this.bSlientPush, 18, false);
        this.strDevName = jceInputStream.readString(19, false);
        this.strDevType = jceInputStream.readString(20, false);
        this.strOSVer = jceInputStream.readString(21, false);
        this.bOpenPush = jceInputStream.read(this.bOpenPush, 22, false);
        this.iLargeSeq = jceInputStream.read(this.iLargeSeq, 23, false);
        this.iLastWatchStartTime = jceInputStream.read(this.iLastWatchStartTime, 24, false);
        this.vecBindUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vecBindUin, 25, false);
        this.uOldSSOIp = jceInputStream.read(this.uOldSSOIp, 26, false);
        this.uNewSSOIp = jceInputStream.read(this.uNewSSOIp, 27, false);
        this.sChannelNo = jceInputStream.readString(28, false);
        this.lCpId = jceInputStream.read(this.lCpId, 29, false);
        this.strVendorName = jceInputStream.readString(30, false);
        this.strVendorOSName = jceInputStream.readString(31, false);
        this.strIOSIdfa = jceInputStream.readString(32, false);
        this.bytes_0x769_reqbody = jceInputStream.read(cache_bytes_0x769_reqbody, 33, false);
        this.bIsSetStatus = jceInputStream.read(this.bIsSetStatus, 34, false);
        this.vecServerBuf = jceInputStream.read(cache_vecServerBuf, 35, false);
        this.bSetMute = jceInputStream.read(this.bSetMute, 36, false);
        this.cNotifySwitch = jceInputStream.read(this.cNotifySwitch, 37, false);
        this.uExtOnlineStatus = jceInputStream.read(this.uExtOnlineStatus, 38, false);
        this.iBatteryStatus = jceInputStream.read(this.iBatteryStatus, 39, false);
        this.bTimActiveFlag = jceInputStream.read(this.bTimActiveFlag, 40, false);
        this.cBindUinNotifySwitch = jceInputStream.read(this.cBindUinNotifySwitch, 41, false);
        this.stVendorPushInfo = (VendorPushInfo) jceInputStream.read((JceStruct) cache_stVendorPushInfo, 42, false);
        this.lVendorDevId = jceInputStream.read(this.lVendorDevId, 43, false);
        this.vecCustomStatus = jceInputStream.read(cache_vecCustomStatus, 45, false);
        this.bLoginType = jceInputStream.read(this.bLoginType, 46, false);
        this.vecRegisterExtData = jceInputStream.read(cache_vecRegisterExtData, 47, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.lBid, 1);
        jceOutputStream.write(this.cConnType, 2);
        jceOutputStream.write(this.sOther, 3);
        jceOutputStream.write(this.iStatus, 4);
        jceOutputStream.write(this.bOnlinePush, 5);
        jceOutputStream.write(this.bIsOnline, 6);
        jceOutputStream.write(this.bIsShowOnline, 7);
        jceOutputStream.write(this.bKikPC, 8);
        jceOutputStream.write(this.bKikWeak, 9);
        jceOutputStream.write(this.timeStamp, 10);
        jceOutputStream.write(this.iOSVersion, 11);
        jceOutputStream.write(this.cNetType, 12);
        String str = this.sBuildVer;
        if (str != null) {
            jceOutputStream.write(str, 13);
        }
        jceOutputStream.write(this.bRegType, 14);
        byte[] bArr = this.vecDevParam;
        if (bArr != null) {
            jceOutputStream.write(bArr, 15);
        }
        byte[] bArr2 = this.vecGuid;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 16);
        }
        jceOutputStream.write(this.iLocaleID, 17);
        jceOutputStream.write(this.bSlientPush, 18);
        String str2 = this.strDevName;
        if (str2 != null) {
            jceOutputStream.write(str2, 19);
        }
        String str3 = this.strDevType;
        if (str3 != null) {
            jceOutputStream.write(str3, 20);
        }
        String str4 = this.strOSVer;
        if (str4 != null) {
            jceOutputStream.write(str4, 21);
        }
        jceOutputStream.write(this.bOpenPush, 22);
        jceOutputStream.write(this.iLargeSeq, 23);
        jceOutputStream.write(this.iLastWatchStartTime, 24);
        ArrayList<a> arrayList = this.vecBindUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 25);
        }
        jceOutputStream.write(this.uOldSSOIp, 26);
        jceOutputStream.write(this.uNewSSOIp, 27);
        String str5 = this.sChannelNo;
        if (str5 != null) {
            jceOutputStream.write(str5, 28);
        }
        jceOutputStream.write(this.lCpId, 29);
        String str6 = this.strVendorName;
        if (str6 != null) {
            jceOutputStream.write(str6, 30);
        }
        String str7 = this.strVendorOSName;
        if (str7 != null) {
            jceOutputStream.write(str7, 31);
        }
        String str8 = this.strIOSIdfa;
        if (str8 != null) {
            jceOutputStream.write(str8, 32);
        }
        byte[] bArr3 = this.bytes_0x769_reqbody;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 33);
        }
        jceOutputStream.write(this.bIsSetStatus, 34);
        byte[] bArr4 = this.vecServerBuf;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 35);
        }
        jceOutputStream.write(this.bSetMute, 36);
        jceOutputStream.write(this.cNotifySwitch, 37);
        jceOutputStream.write(this.uExtOnlineStatus, 38);
        jceOutputStream.write(this.iBatteryStatus, 39);
        jceOutputStream.write(this.bTimActiveFlag, 40);
        jceOutputStream.write(this.cBindUinNotifySwitch, 41);
        VendorPushInfo vendorPushInfo = this.stVendorPushInfo;
        if (vendorPushInfo != null) {
            jceOutputStream.write((JceStruct) vendorPushInfo, 42);
        }
        jceOutputStream.write(this.lVendorDevId, 43);
        byte[] bArr5 = this.vecCustomStatus;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 45);
        }
        jceOutputStream.write(this.bLoginType, 46);
        byte[] bArr6 = this.vecRegisterExtData;
        if (bArr6 != null) {
            jceOutputStream.write(bArr6, 47);
        }
    }

    public SvcReqRegister(long j3, long j16, byte b16, String str, int i3, byte b17, byte b18, byte b19, byte b26, byte b27, long j17, long j18, byte b28, String str2, byte b29, byte[] bArr, byte[] bArr2, int i16, byte b36, String str3, String str4, String str5, byte b37, long j19, long j26, ArrayList<a> arrayList, long j27, long j28, String str6, long j29, String str7, String str8, String str9, byte[] bArr3, byte b38, byte[] bArr4, byte b39, byte b46, long j36, int i17, byte b47, byte b48, VendorPushInfo vendorPushInfo, long j37, byte[] bArr5, byte b49, byte[] bArr6) {
        this.lUin = j3;
        this.lBid = j16;
        this.cConnType = b16;
        this.sOther = str;
        this.iStatus = i3;
        this.bOnlinePush = b17;
        this.bIsOnline = b18;
        this.bIsShowOnline = b19;
        this.bKikPC = b26;
        this.bKikWeak = b27;
        this.timeStamp = j17;
        this.iOSVersion = j18;
        this.cNetType = b28;
        this.sBuildVer = str2;
        this.bRegType = b29;
        this.vecDevParam = bArr;
        this.vecGuid = bArr2;
        this.iLocaleID = i16;
        this.bSlientPush = b36;
        this.strDevName = str3;
        this.strDevType = str4;
        this.strOSVer = str5;
        this.bOpenPush = b37;
        this.iLargeSeq = j19;
        this.iLastWatchStartTime = j26;
        this.vecBindUin = arrayList;
        this.uOldSSOIp = j27;
        this.uNewSSOIp = j28;
        this.sChannelNo = str6;
        this.lCpId = j29;
        this.strVendorName = str7;
        this.strVendorOSName = str8;
        this.strIOSIdfa = str9;
        this.bytes_0x769_reqbody = bArr3;
        this.bIsSetStatus = b38;
        this.vecServerBuf = bArr4;
        this.bSetMute = b39;
        this.cNotifySwitch = b46;
        this.uExtOnlineStatus = j36;
        this.iBatteryStatus = i17;
        this.bTimActiveFlag = b47;
        this.cBindUinNotifySwitch = b48;
        this.stVendorPushInfo = vendorPushInfo;
        this.lVendorDevId = j37;
        this.vecCustomStatus = bArr5;
        this.bLoginType = b49;
        this.vecRegisterExtData = bArr6;
    }
}
