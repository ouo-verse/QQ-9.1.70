package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SvcReqSetToken extends JceStruct {
    static byte[] cache_vNewToken;
    static byte[] cache_vNewVoipToken;
    static byte[] cache_vProfileID;
    static ArrayList<Integer> cache_vTokenID = new ArrayList<>();
    static ArrayList<Integer> cache_vVoipToken;
    public byte bEnterVersion;
    public byte bOnlinePush;
    public byte bPhotoPush;
    public byte bPushMsg;
    public byte bPushQZone;
    public byte bPushWithoutContent;
    public byte bScenes;
    public byte bVoipFlag;
    public byte cBindUinNotifySwitch;
    public byte cNotifySwitch;
    public long iOSVersion;
    public long lUin;
    public String sEmptySound;
    public String sExtends;
    public String sPushSound;
    public String sSound;
    public String sVideoSound;
    public String strDevType;
    public String strOSVer;
    public long uGroupProSwitch;
    public long uVendorType;
    public byte[] vNewToken;
    public byte[] vNewVoipToken;
    public byte[] vProfileID;
    public ArrayList<Integer> vTokenID;
    public ArrayList<Integer> vVoipToken;

    static {
        cache_vTokenID.add(0);
        cache_vVoipToken = new ArrayList<>();
        cache_vVoipToken.add(0);
        cache_vNewToken = r2;
        byte[] bArr = {0};
        cache_vNewVoipToken = r2;
        byte[] bArr2 = {0};
        cache_vProfileID = r1;
        byte[] bArr3 = {0};
    }

    public SvcReqSetToken() {
        this.lUin = 0L;
        this.vTokenID = null;
        this.sSound = "";
        this.sExtends = "";
        this.bPushMsg = (byte) 1;
        this.bPushQZone = (byte) 1;
        this.bOnlinePush = (byte) 0;
        this.bEnterVersion = (byte) 0;
        this.bPhotoPush = (byte) 0;
        this.bPushWithoutContent = (byte) 0;
        this.sPushSound = "";
        this.sEmptySound = "";
        this.sVideoSound = "";
        this.bVoipFlag = (byte) 0;
        this.vVoipToken = null;
        this.vNewToken = null;
        this.vNewVoipToken = null;
        this.bScenes = (byte) 0;
        this.vProfileID = null;
        this.uGroupProSwitch = 0L;
        this.iOSVersion = 0L;
        this.strDevType = "";
        this.strOSVer = "";
        this.cNotifySwitch = (byte) 1;
        this.cBindUinNotifySwitch = (byte) 1;
        this.uVendorType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.vTokenID = (ArrayList) jceInputStream.read((JceInputStream) cache_vTokenID, 1, true);
        this.sSound = jceInputStream.readString(2, true);
        this.sExtends = jceInputStream.readString(3, true);
        this.bPushMsg = jceInputStream.read(this.bPushMsg, 4, false);
        this.bPushQZone = jceInputStream.read(this.bPushQZone, 5, false);
        this.bOnlinePush = jceInputStream.read(this.bOnlinePush, 6, false);
        this.bEnterVersion = jceInputStream.read(this.bEnterVersion, 7, false);
        this.bPhotoPush = jceInputStream.read(this.bPhotoPush, 8, false);
        this.bPushWithoutContent = jceInputStream.read(this.bPushWithoutContent, 9, false);
        this.sPushSound = jceInputStream.readString(10, false);
        this.sEmptySound = jceInputStream.readString(11, false);
        this.sVideoSound = jceInputStream.readString(12, false);
        this.bVoipFlag = jceInputStream.read(this.bVoipFlag, 13, false);
        this.vVoipToken = (ArrayList) jceInputStream.read((JceInputStream) cache_vVoipToken, 14, false);
        this.vNewToken = jceInputStream.read(cache_vNewToken, 15, false);
        this.vNewVoipToken = jceInputStream.read(cache_vNewVoipToken, 16, false);
        this.bScenes = jceInputStream.read(this.bScenes, 17, false);
        this.vProfileID = jceInputStream.read(cache_vProfileID, 18, false);
        this.uGroupProSwitch = jceInputStream.read(this.uGroupProSwitch, 19, false);
        this.iOSVersion = jceInputStream.read(this.iOSVersion, 20, false);
        this.strDevType = jceInputStream.readString(21, false);
        this.strOSVer = jceInputStream.readString(22, false);
        this.cNotifySwitch = jceInputStream.read(this.cNotifySwitch, 23, false);
        this.cBindUinNotifySwitch = jceInputStream.read(this.cBindUinNotifySwitch, 24, false);
        this.uVendorType = jceInputStream.read(this.uVendorType, 25, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write((Collection) this.vTokenID, 1);
        jceOutputStream.write(this.sSound, 2);
        jceOutputStream.write(this.sExtends, 3);
        jceOutputStream.write(this.bPushMsg, 4);
        jceOutputStream.write(this.bPushQZone, 5);
        jceOutputStream.write(this.bOnlinePush, 6);
        jceOutputStream.write(this.bEnterVersion, 7);
        jceOutputStream.write(this.bPhotoPush, 8);
        jceOutputStream.write(this.bPushWithoutContent, 9);
        String str = this.sPushSound;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        String str2 = this.sEmptySound;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        String str3 = this.sVideoSound;
        if (str3 != null) {
            jceOutputStream.write(str3, 12);
        }
        jceOutputStream.write(this.bVoipFlag, 13);
        ArrayList<Integer> arrayList = this.vVoipToken;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 14);
        }
        byte[] bArr = this.vNewToken;
        if (bArr != null) {
            jceOutputStream.write(bArr, 15);
        }
        byte[] bArr2 = this.vNewVoipToken;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 16);
        }
        jceOutputStream.write(this.bScenes, 17);
        byte[] bArr3 = this.vProfileID;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 18);
        }
        jceOutputStream.write(this.uGroupProSwitch, 19);
        jceOutputStream.write(this.iOSVersion, 20);
        String str4 = this.strDevType;
        if (str4 != null) {
            jceOutputStream.write(str4, 21);
        }
        String str5 = this.strOSVer;
        if (str5 != null) {
            jceOutputStream.write(str5, 22);
        }
        jceOutputStream.write(this.cNotifySwitch, 23);
        jceOutputStream.write(this.cBindUinNotifySwitch, 24);
        jceOutputStream.write(this.uVendorType, 25);
    }

    public SvcReqSetToken(long j3, ArrayList<Integer> arrayList, String str, String str2, byte b16, byte b17, byte b18, byte b19, byte b26, byte b27, String str3, String str4, String str5, byte b28, ArrayList<Integer> arrayList2, byte[] bArr, byte[] bArr2, byte b29, byte[] bArr3, long j16, long j17, String str6, String str7, byte b36, byte b37, long j18) {
        this.lUin = j3;
        this.vTokenID = arrayList;
        this.sSound = str;
        this.sExtends = str2;
        this.bPushMsg = b16;
        this.bPushQZone = b17;
        this.bOnlinePush = b18;
        this.bEnterVersion = b19;
        this.bPhotoPush = b26;
        this.bPushWithoutContent = b27;
        this.sPushSound = str3;
        this.sEmptySound = str4;
        this.sVideoSound = str5;
        this.bVoipFlag = b28;
        this.vVoipToken = arrayList2;
        this.vNewToken = bArr;
        this.vNewVoipToken = bArr2;
        this.bScenes = b29;
        this.vProfileID = bArr3;
        this.uGroupProSwitch = j16;
        this.iOSVersion = j17;
        this.strDevType = str6;
        this.strOSVer = str7;
        this.cNotifySwitch = b36;
        this.cBindUinNotifySwitch = b37;
        this.uVendorType = j18;
    }
}
