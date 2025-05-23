package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestGetConfMsg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte cGetPttUrl;
    public byte cGetSmartRemark;
    public byte cVerifyType;
    public long dwLastGetTime;
    public long dwLastInfoSeq;
    public long lBeginSeq;
    public long lConfUin;
    public long lEndSeq;

    public SvcRequestGetConfMsg() {
        this.lConfUin = 0L;
        this.lBeginSeq = 0L;
        this.lEndSeq = 0L;
        this.cVerifyType = (byte) 0;
        this.cGetPttUrl = (byte) 0;
        this.cGetSmartRemark = (byte) 0;
        this.dwLastGetTime = 0L;
        this.dwLastInfoSeq = 0L;
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
        jceDisplayer.display(this.lConfUin, "lConfUin");
        jceDisplayer.display(this.lBeginSeq, "lBeginSeq");
        jceDisplayer.display(this.lEndSeq, "lEndSeq");
        jceDisplayer.display(this.cVerifyType, "cVerifyType");
        jceDisplayer.display(this.cGetPttUrl, "cGetPttUrl");
        jceDisplayer.display(this.cGetSmartRemark, "cGetSmartRemark");
        jceDisplayer.display(this.dwLastGetTime, "dwLastGetTime");
        jceDisplayer.display(this.dwLastInfoSeq, "dwLastInfoSeq");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        SvcRequestGetConfMsg svcRequestGetConfMsg = (SvcRequestGetConfMsg) obj;
        if (!JceUtil.equals(this.lConfUin, svcRequestGetConfMsg.lConfUin) || !JceUtil.equals(this.lBeginSeq, svcRequestGetConfMsg.lBeginSeq) || !JceUtil.equals(this.lEndSeq, svcRequestGetConfMsg.lEndSeq) || !JceUtil.equals(this.cVerifyType, svcRequestGetConfMsg.cVerifyType) || !JceUtil.equals(this.cGetPttUrl, svcRequestGetConfMsg.cGetPttUrl) || !JceUtil.equals(this.cGetSmartRemark, svcRequestGetConfMsg.cGetSmartRemark) || !JceUtil.equals(this.dwLastGetTime, svcRequestGetConfMsg.dwLastGetTime) || !JceUtil.equals(this.dwLastInfoSeq, svcRequestGetConfMsg.dwLastInfoSeq)) {
            return false;
        }
        return true;
    }

    public byte getCGetPttUrl() {
        return this.cGetPttUrl;
    }

    public byte getCGetSmartRemark() {
        return this.cGetSmartRemark;
    }

    public byte getCVerifyType() {
        return this.cVerifyType;
    }

    public long getDwLastGetTime() {
        return this.dwLastGetTime;
    }

    public long getDwLastInfoSeq() {
        return this.dwLastInfoSeq;
    }

    public long getLBeginSeq() {
        return this.lBeginSeq;
    }

    public long getLConfUin() {
        return this.lConfUin;
    }

    public long getLEndSeq() {
        return this.lEndSeq;
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
        this.lConfUin = jceInputStream.read(this.lConfUin, 0, true);
        this.lBeginSeq = jceInputStream.read(this.lBeginSeq, 1, true);
        this.lEndSeq = jceInputStream.read(this.lEndSeq, 2, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 3, false);
        this.cGetPttUrl = jceInputStream.read(this.cGetPttUrl, 4, false);
        this.cGetSmartRemark = jceInputStream.read(this.cGetSmartRemark, 5, false);
        this.dwLastGetTime = jceInputStream.read(this.dwLastGetTime, 6, false);
        this.dwLastInfoSeq = jceInputStream.read(this.dwLastInfoSeq, 7, false);
    }

    public void setCGetPttUrl(byte b16) {
        this.cGetPttUrl = b16;
    }

    public void setCGetSmartRemark(byte b16) {
        this.cGetSmartRemark = b16;
    }

    public void setCVerifyType(byte b16) {
        this.cVerifyType = b16;
    }

    public void setDwLastGetTime(long j3) {
        this.dwLastGetTime = j3;
    }

    public void setDwLastInfoSeq(long j3) {
        this.dwLastInfoSeq = j3;
    }

    public void setLBeginSeq(long j3) {
        this.lBeginSeq = j3;
    }

    public void setLConfUin(long j3) {
        this.lConfUin = j3;
    }

    public void setLEndSeq(long j3) {
        this.lEndSeq = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lConfUin, 0);
        jceOutputStream.write(this.lBeginSeq, 1);
        jceOutputStream.write(this.lEndSeq, 2);
        jceOutputStream.write(this.cVerifyType, 3);
        jceOutputStream.write(this.cGetPttUrl, 4);
        jceOutputStream.write(this.cGetSmartRemark, 5);
        jceOutputStream.write(this.dwLastGetTime, 6);
        jceOutputStream.write(this.dwLastInfoSeq, 7);
    }

    public SvcRequestGetConfMsg(long j3, long j16, long j17, byte b16, byte b17, byte b18, long j18, long j19) {
        this.lConfUin = j3;
        this.lBeginSeq = j16;
        this.lEndSeq = j17;
        this.cVerifyType = b16;
        this.cGetPttUrl = b17;
        this.cGetSmartRemark = b18;
        this.dwLastGetTime = j18;
        this.dwLastInfoSeq = j19;
    }
}
