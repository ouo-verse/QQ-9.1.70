package RegisterProxySvcPack;

import MessageSvcPack.SvcRequestGetMsgV2;
import MessageSvcPack.SvcRequestPullDisMsgSeq;
import MessageSvcPack.SvcRequestPullGroupMsgSeq;
import QQService.SvcReqGet;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.msf.service.protocol.push.SvcReqRegister;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestRegisterNew extends JceStruct {
    static byte[] cache_bytes_0x769_reqbody;
    static byte[] cache_vCookies;
    static byte[] cache_vSaveTraffic;
    static byte[] cache_vSig;
    public long badge;
    public byte[] bytes_0x769_reqbody;
    public SvcRequestGetMsgV2 c2cmsg;
    public byte cDisgroupMsgFilter;
    public byte cGetDisPttUrl;
    public byte cGetGroupPttUrl;
    public byte cGroupMask;
    public byte cOptGroupMsgFlag;
    public byte cSubCmd;
    public SvcRequestPullDisMsgSeq confmsg;
    public SvcRequestPullDisGroupSeq disgroupmsg;
    public SvcRequestPullGroupMsgSeq groupmsg;
    public SvcReqGet heartbeat;
    public SvcReqRegister regist;
    public long uEndSeq;
    public int uGuildUdcFlag;
    public int uRoamMsgOptimizeFlag;
    public long ulLastFilterListTime;
    public long ulMaxDisGrpMsgTime;
    public long ulReportFlag;
    public long ulRequestOptional;
    public long ulSyncTime;
    public byte[] vCookies;
    public byte[] vSaveTraffic;
    public byte[] vSig;
    static SvcRequestGetMsgV2 cache_c2cmsg = new SvcRequestGetMsgV2();
    static SvcRequestPullGroupMsgSeq cache_groupmsg = new SvcRequestPullGroupMsgSeq();
    static SvcRequestPullDisMsgSeq cache_confmsg = new SvcRequestPullDisMsgSeq();
    static SvcReqRegister cache_regist = new SvcReqRegister();
    static SvcRequestPullDisGroupSeq cache_disgroupmsg = new SvcRequestPullDisGroupSeq();
    static SvcReqGet cache_heartbeat = new SvcReqGet();

    static {
        cache_vSaveTraffic = r1;
        byte[] bArr = {0};
        cache_vCookies = r1;
        byte[] bArr2 = {0};
        cache_vSig = r1;
        byte[] bArr3 = {0};
        cache_bytes_0x769_reqbody = r0;
        byte[] bArr4 = {0};
    }

    public SvcRequestRegisterNew() {
        this.ulRequestOptional = 0L;
        this.c2cmsg = null;
        this.groupmsg = null;
        this.confmsg = null;
        this.regist = null;
        this.cSubCmd = (byte) 0;
        this.cGetGroupPttUrl = (byte) 0;
        this.cGetDisPttUrl = (byte) 0;
        this.badge = 0L;
        this.disgroupmsg = null;
        this.vSaveTraffic = null;
        this.vCookies = null;
        this.vSig = null;
        this.heartbeat = null;
        this.cDisgroupMsgFilter = (byte) 0;
        this.cGroupMask = (byte) 0;
        this.uEndSeq = 0L;
        this.cOptGroupMsgFlag = (byte) 0;
        this.ulSyncTime = 0L;
        this.ulMaxDisGrpMsgTime = 0L;
        this.bytes_0x769_reqbody = null;
        this.ulLastFilterListTime = 0L;
        this.uGuildUdcFlag = 0;
        this.ulReportFlag = 0L;
        this.uRoamMsgOptimizeFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ulRequestOptional = jceInputStream.read(this.ulRequestOptional, 0, true);
        this.c2cmsg = (SvcRequestGetMsgV2) jceInputStream.read((JceStruct) cache_c2cmsg, 1, false);
        this.groupmsg = (SvcRequestPullGroupMsgSeq) jceInputStream.read((JceStruct) cache_groupmsg, 2, false);
        this.confmsg = (SvcRequestPullDisMsgSeq) jceInputStream.read((JceStruct) cache_confmsg, 3, false);
        this.regist = (SvcReqRegister) jceInputStream.read((JceStruct) cache_regist, 4, false);
        this.cSubCmd = jceInputStream.read(this.cSubCmd, 5, false);
        this.cGetGroupPttUrl = jceInputStream.read(this.cGetGroupPttUrl, 6, false);
        this.cGetDisPttUrl = jceInputStream.read(this.cGetDisPttUrl, 7, false);
        this.badge = jceInputStream.read(this.badge, 8, false);
        this.disgroupmsg = (SvcRequestPullDisGroupSeq) jceInputStream.read((JceStruct) cache_disgroupmsg, 9, false);
        this.vSaveTraffic = jceInputStream.read(cache_vSaveTraffic, 10, false);
        this.vCookies = jceInputStream.read(cache_vCookies, 11, false);
        this.vSig = jceInputStream.read(cache_vSig, 12, false);
        this.heartbeat = (SvcReqGet) jceInputStream.read((JceStruct) cache_heartbeat, 13, false);
        this.cDisgroupMsgFilter = jceInputStream.read(this.cDisgroupMsgFilter, 14, false);
        this.cGroupMask = jceInputStream.read(this.cGroupMask, 15, false);
        this.uEndSeq = jceInputStream.read(this.uEndSeq, 16, false);
        this.cOptGroupMsgFlag = jceInputStream.read(this.cOptGroupMsgFlag, 17, false);
        this.ulSyncTime = jceInputStream.read(this.ulSyncTime, 18, false);
        this.ulMaxDisGrpMsgTime = jceInputStream.read(this.ulMaxDisGrpMsgTime, 19, false);
        this.bytes_0x769_reqbody = jceInputStream.read(cache_bytes_0x769_reqbody, 20, false);
        this.ulLastFilterListTime = jceInputStream.read(this.ulLastFilterListTime, 23, false);
        this.uGuildUdcFlag = jceInputStream.read(this.uGuildUdcFlag, 24, false);
        this.ulReportFlag = jceInputStream.read(this.ulReportFlag, 25, false);
        this.uRoamMsgOptimizeFlag = jceInputStream.read(this.uRoamMsgOptimizeFlag, 27, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ulRequestOptional, 0);
        SvcRequestGetMsgV2 svcRequestGetMsgV2 = this.c2cmsg;
        if (svcRequestGetMsgV2 != null) {
            jceOutputStream.write((JceStruct) svcRequestGetMsgV2, 1);
        }
        SvcRequestPullGroupMsgSeq svcRequestPullGroupMsgSeq = this.groupmsg;
        if (svcRequestPullGroupMsgSeq != null) {
            jceOutputStream.write((JceStruct) svcRequestPullGroupMsgSeq, 2);
        }
        SvcRequestPullDisMsgSeq svcRequestPullDisMsgSeq = this.confmsg;
        if (svcRequestPullDisMsgSeq != null) {
            jceOutputStream.write((JceStruct) svcRequestPullDisMsgSeq, 3);
        }
        SvcReqRegister svcReqRegister = this.regist;
        if (svcReqRegister != null) {
            jceOutputStream.write((JceStruct) svcReqRegister, 4);
        }
        jceOutputStream.write(this.cSubCmd, 5);
        jceOutputStream.write(this.cGetGroupPttUrl, 6);
        jceOutputStream.write(this.cGetDisPttUrl, 7);
        jceOutputStream.write(this.badge, 8);
        SvcRequestPullDisGroupSeq svcRequestPullDisGroupSeq = this.disgroupmsg;
        if (svcRequestPullDisGroupSeq != null) {
            jceOutputStream.write((JceStruct) svcRequestPullDisGroupSeq, 9);
        }
        byte[] bArr = this.vSaveTraffic;
        if (bArr != null) {
            jceOutputStream.write(bArr, 10);
        }
        byte[] bArr2 = this.vCookies;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 11);
        }
        byte[] bArr3 = this.vSig;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 12);
        }
        SvcReqGet svcReqGet = this.heartbeat;
        if (svcReqGet != null) {
            jceOutputStream.write((JceStruct) svcReqGet, 13);
        }
        jceOutputStream.write(this.cDisgroupMsgFilter, 14);
        jceOutputStream.write(this.cGroupMask, 15);
        jceOutputStream.write(this.uEndSeq, 16);
        jceOutputStream.write(this.cOptGroupMsgFlag, 17);
        jceOutputStream.write(this.ulSyncTime, 18);
        jceOutputStream.write(this.ulMaxDisGrpMsgTime, 19);
        byte[] bArr4 = this.bytes_0x769_reqbody;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 20);
        }
        jceOutputStream.write(this.ulLastFilterListTime, 23);
        jceOutputStream.write(this.uGuildUdcFlag, 24);
        jceOutputStream.write(this.ulReportFlag, 25);
        jceOutputStream.write(this.uRoamMsgOptimizeFlag, 27);
    }

    public SvcRequestRegisterNew(long j3, SvcRequestGetMsgV2 svcRequestGetMsgV2, SvcRequestPullGroupMsgSeq svcRequestPullGroupMsgSeq, SvcRequestPullDisMsgSeq svcRequestPullDisMsgSeq, SvcReqRegister svcReqRegister, byte b16, byte b17, byte b18, long j16, SvcRequestPullDisGroupSeq svcRequestPullDisGroupSeq, byte[] bArr, byte[] bArr2, byte[] bArr3, SvcReqGet svcReqGet, byte b19, byte b26, long j17, byte b27, long j18, long j19, byte[] bArr4, long j26, int i3, long j27, int i16) {
        this.ulRequestOptional = j3;
        this.c2cmsg = svcRequestGetMsgV2;
        this.groupmsg = svcRequestPullGroupMsgSeq;
        this.confmsg = svcRequestPullDisMsgSeq;
        this.regist = svcReqRegister;
        this.cSubCmd = b16;
        this.cGetGroupPttUrl = b17;
        this.cGetDisPttUrl = b18;
        this.badge = j16;
        this.disgroupmsg = svcRequestPullDisGroupSeq;
        this.vSaveTraffic = bArr;
        this.vCookies = bArr2;
        this.vSig = bArr3;
        this.heartbeat = svcReqGet;
        this.cDisgroupMsgFilter = b19;
        this.cGroupMask = b26;
        this.uEndSeq = j17;
        this.cOptGroupMsgFlag = b27;
        this.ulSyncTime = j18;
        this.ulMaxDisGrpMsgTime = j19;
        this.bytes_0x769_reqbody = bArr4;
        this.ulLastFilterListTime = j26;
        this.uGuildUdcFlag = i3;
        this.ulReportFlag = j27;
        this.uRoamMsgOptimizeFlag = i16;
    }
}
