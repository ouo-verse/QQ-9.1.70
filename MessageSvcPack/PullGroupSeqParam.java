package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* loaded from: classes.dex */
public final class PullGroupSeqParam extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long lGroupCode;
    public long lLastSeqId;

    public PullGroupSeqParam() {
        this.lGroupCode = 0L;
        this.lLastSeqId = 0L;
    }

    public String className() {
        return "MessageSvcPack.PullGroupSeqParam";
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
        jceDisplayer.display(this.lGroupCode, "lGroupCode");
        jceDisplayer.display(this.lLastSeqId, "lLastSeqId");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.lGroupCode, true);
        jceDisplayer.displaySimple(this.lLastSeqId, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        PullGroupSeqParam pullGroupSeqParam = (PullGroupSeqParam) obj;
        if (!JceUtil.equals(this.lGroupCode, pullGroupSeqParam.lGroupCode) || !JceUtil.equals(this.lLastSeqId, pullGroupSeqParam.lLastSeqId)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "MessageSvcPack.PullGroupSeqParam";
    }

    public long getLGroupCode() {
        return this.lGroupCode;
    }

    public long getLLastSeqId() {
        return this.lLastSeqId;
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
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 0, true);
        this.lLastSeqId = jceInputStream.read(this.lLastSeqId, 1, true);
    }

    public void setLGroupCode(long j3) {
        this.lGroupCode = j3;
    }

    public void setLLastSeqId(long j3) {
        this.lLastSeqId = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lGroupCode, 0);
        jceOutputStream.write(this.lLastSeqId, 1);
    }

    public PullGroupSeqParam(long j3, long j16) {
        this.lGroupCode = j3;
        this.lLastSeqId = j16;
    }
}
