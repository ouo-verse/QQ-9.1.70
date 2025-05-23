package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestGetMsgV2 extends JceStruct {
    static int cache_cSyncFlag;
    static int cache_eBusiType;
    static int cache_eMqqSysType;
    static byte[] cache_vCookies;
    static byte[] cache_vNotifyCookie;
    static byte[] cache_vPubAccountCookie;
    static byte[] cache_vSyncCookie;
    public byte cAutoGetMsg;
    public byte cChannel;
    public byte cChannelEx;
    public byte cContextFlag;
    public byte cInnerFlag;
    public byte cInst;
    public byte cMsgStoreType;
    public byte cOnlineSyncFlag;
    public byte cPushService;
    public byte cRambleFlag;
    public byte cRecivePic;
    public int cSyncFlag;
    public byte cUnFilter;
    public byte cVerifyType;
    public int eBusiType;
    public int eMqqSysType;
    public long iOSVersion;
    public long lGeneralAbi;
    public long lUin;
    public String sA2;
    public short shAbility;
    public short shLatestRambleNumber;
    public short shOtherRambleNumber;
    public int uDateTime;
    public byte[] vCookies;
    public byte[] vNotifyCookie;
    public byte[] vPubAccountCookie;
    public byte[] vSyncCookie;

    public SvcRequestGetMsgV2() {
        this.lUin = 0L;
        this.uDateTime = 0;
        this.sA2 = "";
        this.cVerifyType = (byte) 0;
        this.cRecivePic = (byte) 0;
        this.cAutoGetMsg = (byte) 0;
        this.shAbility = (short) 0;
        this.cMsgStoreType = (byte) 0;
        this.cPushService = (byte) 0;
        this.cChannel = (byte) 1;
        this.vCookies = null;
        this.eBusiType = BusinessType.BusinessType_MQQ.value();
        this.eMqqSysType = MqqSysType.MqqSysType_default.value();
        this.vNotifyCookie = null;
        this.iOSVersion = 0L;
        this.cUnFilter = (byte) 0;
        this.cInst = (byte) 0;
        this.cChannelEx = (byte) 0;
        this.vSyncCookie = null;
        this.cSyncFlag = MsgSyncFlag.SYNC_BEGIN.value();
        this.cRambleFlag = (byte) 0;
        this.shLatestRambleNumber = (short) 20;
        this.shOtherRambleNumber = (short) 3;
        this.cInnerFlag = (byte) 0;
        this.cOnlineSyncFlag = (byte) 1;
        this.cContextFlag = (byte) 0;
        this.lGeneralAbi = 0L;
        this.vPubAccountCookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.uDateTime = jceInputStream.read(this.uDateTime, 1, true);
        this.sA2 = jceInputStream.readString(2, false);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 3, false);
        this.cRecivePic = jceInputStream.read(this.cRecivePic, 4, false);
        this.cAutoGetMsg = jceInputStream.read(this.cAutoGetMsg, 5, false);
        this.shAbility = jceInputStream.read(this.shAbility, 6, false);
        this.cMsgStoreType = jceInputStream.read(this.cMsgStoreType, 7, false);
        this.cPushService = jceInputStream.read(this.cPushService, 8, false);
        this.cChannel = jceInputStream.read(this.cChannel, 9, false);
        if (cache_vCookies == null) {
            cache_vCookies = r0;
            byte[] bArr = {0};
        }
        this.vCookies = jceInputStream.read(cache_vCookies, 10, false);
        this.eBusiType = jceInputStream.read(this.eBusiType, 11, false);
        this.eMqqSysType = jceInputStream.read(this.eMqqSysType, 12, false);
        if (cache_vNotifyCookie == null) {
            cache_vNotifyCookie = r0;
            byte[] bArr2 = {0};
        }
        this.vNotifyCookie = jceInputStream.read(cache_vNotifyCookie, 13, false);
        this.iOSVersion = jceInputStream.read(this.iOSVersion, 14, false);
        this.cUnFilter = jceInputStream.read(this.cUnFilter, 15, false);
        this.cInst = jceInputStream.read(this.cInst, 16, false);
        this.cChannelEx = jceInputStream.read(this.cChannelEx, 17, false);
        if (cache_vSyncCookie == null) {
            cache_vSyncCookie = r0;
            byte[] bArr3 = {0};
        }
        this.vSyncCookie = jceInputStream.read(cache_vSyncCookie, 18, false);
        this.cSyncFlag = jceInputStream.read(this.cSyncFlag, 19, false);
        this.cRambleFlag = jceInputStream.read(this.cRambleFlag, 20, false);
        this.shLatestRambleNumber = jceInputStream.read(this.shLatestRambleNumber, 21, false);
        this.shOtherRambleNumber = jceInputStream.read(this.shOtherRambleNumber, 22, false);
        this.cInnerFlag = jceInputStream.read(this.cInnerFlag, 23, false);
        this.cOnlineSyncFlag = jceInputStream.read(this.cOnlineSyncFlag, 24, false);
        this.cContextFlag = jceInputStream.read(this.cContextFlag, 25, false);
        this.lGeneralAbi = jceInputStream.read(this.lGeneralAbi, 26, false);
        if (cache_vPubAccountCookie == null) {
            cache_vPubAccountCookie = r0;
            byte[] bArr4 = {0};
        }
        this.vPubAccountCookie = jceInputStream.read(cache_vPubAccountCookie, 27, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.uDateTime, 1);
        String str = this.sA2;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.cVerifyType, 3);
        jceOutputStream.write(this.cRecivePic, 4);
        jceOutputStream.write(this.cAutoGetMsg, 5);
        jceOutputStream.write(this.shAbility, 6);
        jceOutputStream.write(this.cMsgStoreType, 7);
        jceOutputStream.write(this.cPushService, 8);
        jceOutputStream.write(this.cChannel, 9);
        byte[] bArr = this.vCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 10);
        }
        jceOutputStream.write(this.eBusiType, 11);
        jceOutputStream.write(this.eMqqSysType, 12);
        byte[] bArr2 = this.vNotifyCookie;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 13);
        }
        jceOutputStream.write(this.iOSVersion, 14);
        jceOutputStream.write(this.cUnFilter, 15);
        jceOutputStream.write(this.cInst, 16);
        jceOutputStream.write(this.cChannelEx, 17);
        byte[] bArr3 = this.vSyncCookie;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 18);
        }
        jceOutputStream.write(this.cSyncFlag, 19);
        jceOutputStream.write(this.cRambleFlag, 20);
        jceOutputStream.write(this.shLatestRambleNumber, 21);
        jceOutputStream.write(this.shOtherRambleNumber, 22);
        jceOutputStream.write(this.cInnerFlag, 23);
        jceOutputStream.write(this.cOnlineSyncFlag, 24);
        jceOutputStream.write(this.cContextFlag, 25);
        jceOutputStream.write(this.lGeneralAbi, 26);
        byte[] bArr4 = this.vPubAccountCookie;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 27);
        }
    }

    public SvcRequestGetMsgV2(long j3, int i3, String str, byte b16, byte b17, byte b18, short s16, byte b19, byte b26, byte b27, byte[] bArr, int i16, int i17, byte[] bArr2, long j16, byte b28, byte b29, byte b36, byte[] bArr3, int i18, byte b37, short s17, short s18, byte b38, byte b39, byte b46, long j17, byte[] bArr4) {
        this.lUin = 0L;
        this.uDateTime = 0;
        this.sA2 = "";
        this.cVerifyType = (byte) 0;
        this.cRecivePic = (byte) 0;
        this.cAutoGetMsg = (byte) 0;
        this.shAbility = (short) 0;
        this.cMsgStoreType = (byte) 0;
        this.cPushService = (byte) 0;
        this.cChannel = (byte) 1;
        this.vCookies = null;
        this.eBusiType = BusinessType.BusinessType_MQQ.value();
        this.eMqqSysType = MqqSysType.MqqSysType_default.value();
        this.vNotifyCookie = null;
        this.iOSVersion = 0L;
        this.cUnFilter = (byte) 0;
        this.cInst = (byte) 0;
        this.cChannelEx = (byte) 0;
        this.vSyncCookie = null;
        MsgSyncFlag.SYNC_BEGIN.value();
        this.lUin = j3;
        this.uDateTime = i3;
        this.sA2 = str;
        this.cVerifyType = b16;
        this.cRecivePic = b17;
        this.cAutoGetMsg = b18;
        this.shAbility = s16;
        this.cMsgStoreType = b19;
        this.cPushService = b26;
        this.cChannel = b27;
        this.vCookies = bArr;
        this.eBusiType = i16;
        this.eMqqSysType = i17;
        this.vNotifyCookie = bArr2;
        this.iOSVersion = j16;
        this.cUnFilter = b28;
        this.cInst = b29;
        this.cChannelEx = b36;
        this.vSyncCookie = bArr3;
        this.cSyncFlag = i18;
        this.cRambleFlag = b37;
        this.shLatestRambleNumber = s17;
        this.shOtherRambleNumber = s18;
        this.cInnerFlag = b38;
        this.cOnlineSyncFlag = b39;
        this.cContextFlag = b46;
        this.lGeneralAbi = j17;
        this.vPubAccountCookie = bArr4;
    }
}
