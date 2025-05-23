package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_vCookies;
    public byte bReqType;
    public byte bTriggered;
    public int iSeq;
    public long lUIN;
    public short shVersion;
    public byte[] vCookies;

    public ReqHead() {
        this.lUIN = 0L;
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.bReqType = (byte) 0;
        this.bTriggered = (byte) 0;
        this.vCookies = null;
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
        jceDisplayer.display(this.lUIN, "lUIN");
        jceDisplayer.display(this.shVersion, "shVersion");
        jceDisplayer.display(this.iSeq, "iSeq");
        jceDisplayer.display(this.bReqType, "bReqType");
        jceDisplayer.display(this.bTriggered, "bTriggered");
        jceDisplayer.display(this.vCookies, "vCookies");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqHead reqHead = (ReqHead) obj;
        if (!JceUtil.equals(this.lUIN, reqHead.lUIN) || !JceUtil.equals(this.shVersion, reqHead.shVersion) || !JceUtil.equals(this.iSeq, reqHead.iSeq) || !JceUtil.equals(this.bReqType, reqHead.bReqType) || !JceUtil.equals(this.bTriggered, reqHead.bTriggered) || !JceUtil.equals(this.vCookies, reqHead.vCookies)) {
            return false;
        }
        return true;
    }

    public byte getBReqType() {
        return this.bReqType;
    }

    public byte getBTriggered() {
        return this.bTriggered;
    }

    public int getISeq() {
        return this.iSeq;
    }

    public long getLUIN() {
        return this.lUIN;
    }

    public short getShVersion() {
        return this.shVersion;
    }

    public byte[] getVCookies() {
        return this.vCookies;
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
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.shVersion = jceInputStream.read(this.shVersion, 1, true);
        this.iSeq = jceInputStream.read(this.iSeq, 2, true);
        this.bReqType = jceInputStream.read(this.bReqType, 3, false);
        this.bTriggered = jceInputStream.read(this.bTriggered, 4, false);
        if (cache_vCookies == null) {
            cache_vCookies = r0;
            byte[] bArr = {0};
        }
        this.vCookies = jceInputStream.read(cache_vCookies, 5, false);
    }

    public void setBReqType(byte b16) {
        this.bReqType = b16;
    }

    public void setBTriggered(byte b16) {
        this.bTriggered = b16;
    }

    public void setISeq(int i3) {
        this.iSeq = i3;
    }

    public void setLUIN(long j3) {
        this.lUIN = j3;
    }

    public void setShVersion(short s16) {
        this.shVersion = s16;
    }

    public void setVCookies(byte[] bArr) {
        this.vCookies = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.shVersion, 1);
        jceOutputStream.write(this.iSeq, 2);
        jceOutputStream.write(this.bReqType, 3);
        jceOutputStream.write(this.bTriggered, 4);
        byte[] bArr = this.vCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
    }

    public ReqHead(long j3, short s16, int i3, byte b16, byte b17, byte[] bArr) {
        this.lUIN = j3;
        this.shVersion = s16;
        this.iSeq = i3;
        this.bReqType = b16;
        this.bTriggered = b17;
        this.vCookies = bArr;
    }
}
