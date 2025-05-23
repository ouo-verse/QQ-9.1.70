package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stConfMsgRecord extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_vAppShareCookie;
    static byte[] cache_vMsg;
    static byte[] cache_vRemarkOfSender;
    public byte cConfType;
    public long lConfUin;
    public long lFromUin;
    public long lGroupUin;
    public long lSendUin;
    public long lToUin;
    public long uAppShareID;
    public long uInfoSeq;
    public int uMsgLen;
    public long uMsgSeq;
    public long uMsgTime;
    public byte[] vAppShareCookie;
    public byte[] vMsg;
    public byte[] vRemarkOfSender;
    public int wSeqNum;
    public int wType;

    public stConfMsgRecord() {
        this.wType = 0;
        this.wSeqNum = 0;
        this.lFromUin = 0L;
        this.lToUin = 0L;
        this.lGroupUin = 0L;
        this.cConfType = (byte) 0;
        this.lConfUin = 0L;
        this.lSendUin = 0L;
        this.uMsgSeq = 0L;
        this.uMsgTime = 0L;
        this.uInfoSeq = 0L;
        this.uMsgLen = 0;
        this.vMsg = null;
        this.uAppShareID = 0L;
        this.vAppShareCookie = null;
        this.vRemarkOfSender = null;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.wType, "wType");
        jceDisplayer.display(this.wSeqNum, "wSeqNum");
        jceDisplayer.display(this.lFromUin, "lFromUin");
        jceDisplayer.display(this.lToUin, "lToUin");
        jceDisplayer.display(this.lGroupUin, "lGroupUin");
        jceDisplayer.display(this.cConfType, "cConfType");
        jceDisplayer.display(this.lConfUin, "lConfUin");
        jceDisplayer.display(this.lSendUin, "lSendUin");
        jceDisplayer.display(this.uMsgSeq, "uMsgSeq");
        jceDisplayer.display(this.uMsgTime, "uMsgTime");
        jceDisplayer.display(this.uInfoSeq, "uInfoSeq");
        jceDisplayer.display(this.uMsgLen, "uMsgLen");
        jceDisplayer.display(this.vMsg, "vMsg");
        jceDisplayer.display(this.uAppShareID, "uAppShareID");
        jceDisplayer.display(this.vAppShareCookie, "vAppShareCookie");
        jceDisplayer.display(this.vRemarkOfSender, "vRemarkOfSender");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stConfMsgRecord stconfmsgrecord = (stConfMsgRecord) obj;
        if (!JceUtil.equals(this.wType, stconfmsgrecord.wType) || !JceUtil.equals(this.wSeqNum, stconfmsgrecord.wSeqNum) || !JceUtil.equals(this.lFromUin, stconfmsgrecord.lFromUin) || !JceUtil.equals(this.lToUin, stconfmsgrecord.lToUin) || !JceUtil.equals(this.lGroupUin, stconfmsgrecord.lGroupUin) || !JceUtil.equals(this.cConfType, stconfmsgrecord.cConfType) || !JceUtil.equals(this.lConfUin, stconfmsgrecord.lConfUin) || !JceUtil.equals(this.lSendUin, stconfmsgrecord.lSendUin) || !JceUtil.equals(this.uMsgSeq, stconfmsgrecord.uMsgSeq) || !JceUtil.equals(this.uMsgTime, stconfmsgrecord.uMsgTime) || !JceUtil.equals(this.uInfoSeq, stconfmsgrecord.uInfoSeq) || !JceUtil.equals(this.uMsgLen, stconfmsgrecord.uMsgLen) || !JceUtil.equals(this.vMsg, stconfmsgrecord.vMsg) || !JceUtil.equals(this.uAppShareID, stconfmsgrecord.uAppShareID) || !JceUtil.equals(this.vAppShareCookie, stconfmsgrecord.vAppShareCookie) || !JceUtil.equals(this.vRemarkOfSender, stconfmsgrecord.vRemarkOfSender)) {
            return false;
        }
        return true;
    }

    public byte getCConfType() {
        return this.cConfType;
    }

    public long getLConfUin() {
        return this.lConfUin;
    }

    public long getLFromUin() {
        return this.lFromUin;
    }

    public long getLGroupUin() {
        return this.lGroupUin;
    }

    public long getLSendUin() {
        return this.lSendUin;
    }

    public long getLToUin() {
        return this.lToUin;
    }

    public long getUAppShareID() {
        return this.uAppShareID;
    }

    public long getUInfoSeq() {
        return this.uInfoSeq;
    }

    public int getUMsgLen() {
        return this.uMsgLen;
    }

    public long getUMsgSeq() {
        return this.uMsgSeq;
    }

    public long getUMsgTime() {
        return this.uMsgTime;
    }

    public byte[] getVAppShareCookie() {
        return this.vAppShareCookie;
    }

    public byte[] getVMsg() {
        return this.vMsg;
    }

    public byte[] getVRemarkOfSender() {
        return this.vRemarkOfSender;
    }

    public int getWSeqNum() {
        return this.wSeqNum;
    }

    public int getWType() {
        return this.wType;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wType = jceInputStream.read(this.wType, 0, true);
        this.wSeqNum = jceInputStream.read(this.wSeqNum, 1, true);
        this.lFromUin = jceInputStream.read(this.lFromUin, 2, true);
        this.lToUin = jceInputStream.read(this.lToUin, 3, true);
        this.lGroupUin = jceInputStream.read(this.lGroupUin, 4, true);
        this.cConfType = jceInputStream.read(this.cConfType, 5, true);
        this.lConfUin = jceInputStream.read(this.lConfUin, 6, true);
        this.lSendUin = jceInputStream.read(this.lSendUin, 7, true);
        this.uMsgSeq = jceInputStream.read(this.uMsgSeq, 8, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 9, true);
        this.uInfoSeq = jceInputStream.read(this.uInfoSeq, 10, true);
        this.uMsgLen = jceInputStream.read(this.uMsgLen, 11, true);
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        this.vMsg = jceInputStream.read(cache_vMsg, 12, true);
        this.uAppShareID = jceInputStream.read(this.uAppShareID, 13, false);
        if (cache_vAppShareCookie == null) {
            cache_vAppShareCookie = r0;
            byte[] bArr2 = {0};
        }
        this.vAppShareCookie = jceInputStream.read(cache_vAppShareCookie, 14, false);
        if (cache_vRemarkOfSender == null) {
            cache_vRemarkOfSender = r0;
            byte[] bArr3 = {0};
        }
        this.vRemarkOfSender = jceInputStream.read(cache_vRemarkOfSender, 15, false);
    }

    public void setCConfType(byte b16) {
        this.cConfType = b16;
    }

    public void setLConfUin(long j3) {
        this.lConfUin = j3;
    }

    public void setLFromUin(long j3) {
        this.lFromUin = j3;
    }

    public void setLGroupUin(long j3) {
        this.lGroupUin = j3;
    }

    public void setLSendUin(long j3) {
        this.lSendUin = j3;
    }

    public void setLToUin(long j3) {
        this.lToUin = j3;
    }

    public void setUAppShareID(long j3) {
        this.uAppShareID = j3;
    }

    public void setUInfoSeq(long j3) {
        this.uInfoSeq = j3;
    }

    public void setUMsgLen(int i3) {
        this.uMsgLen = i3;
    }

    public void setUMsgSeq(long j3) {
        this.uMsgSeq = j3;
    }

    public void setUMsgTime(long j3) {
        this.uMsgTime = j3;
    }

    public void setVAppShareCookie(byte[] bArr) {
        this.vAppShareCookie = bArr;
    }

    public void setVMsg(byte[] bArr) {
        this.vMsg = bArr;
    }

    public void setVRemarkOfSender(byte[] bArr) {
        this.vRemarkOfSender = bArr;
    }

    public void setWSeqNum(int i3) {
        this.wSeqNum = i3;
    }

    public void setWType(int i3) {
        this.wType = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wType, 0);
        jceOutputStream.write(this.wSeqNum, 1);
        jceOutputStream.write(this.lFromUin, 2);
        jceOutputStream.write(this.lToUin, 3);
        jceOutputStream.write(this.lGroupUin, 4);
        jceOutputStream.write(this.cConfType, 5);
        jceOutputStream.write(this.lConfUin, 6);
        jceOutputStream.write(this.lSendUin, 7);
        jceOutputStream.write(this.uMsgSeq, 8);
        jceOutputStream.write(this.uMsgTime, 9);
        jceOutputStream.write(this.uInfoSeq, 10);
        jceOutputStream.write(this.uMsgLen, 11);
        jceOutputStream.write(this.vMsg, 12);
        jceOutputStream.write(this.uAppShareID, 13);
        byte[] bArr = this.vAppShareCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 14);
        }
        byte[] bArr2 = this.vRemarkOfSender;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 15);
        }
    }

    public stConfMsgRecord(int i3, int i16, long j3, long j16, long j17, byte b16, long j18, long j19, long j26, long j27, long j28, int i17, byte[] bArr, long j29, byte[] bArr2, byte[] bArr3) {
        this.wType = i3;
        this.wSeqNum = i16;
        this.lFromUin = j3;
        this.lToUin = j16;
        this.lGroupUin = j17;
        this.cConfType = b16;
        this.lConfUin = j18;
        this.lSendUin = j19;
        this.uMsgSeq = j26;
        this.uMsgTime = j27;
        this.uInfoSeq = j28;
        this.uMsgLen = i17;
        this.vMsg = bArr;
        this.uAppShareID = j29;
        this.vAppShareCookie = bArr2;
        this.vRemarkOfSender = bArr3;
    }
}
