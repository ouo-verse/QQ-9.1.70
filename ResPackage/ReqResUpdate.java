package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqResUpdate extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_ResID;
    public int ResID;
    public long SeqID;
    public byte SeqOnly;

    public ReqResUpdate() {
        this.ResID = 0;
        this.SeqID = 0L;
        this.SeqOnly = (byte) 0;
    }

    public String className() {
        return "ResPackage.ReqResUpdate";
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
        jceDisplayer.display(this.ResID, "ResID");
        jceDisplayer.display(this.SeqID, "SeqID");
        jceDisplayer.display(this.SeqOnly, "SeqOnly");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.ResID, true);
        jceDisplayer.displaySimple(this.SeqID, true);
        jceDisplayer.displaySimple(this.SeqOnly, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqResUpdate reqResUpdate = (ReqResUpdate) obj;
        if (!JceUtil.equals(this.ResID, reqResUpdate.ResID) || !JceUtil.equals(this.SeqID, reqResUpdate.SeqID) || !JceUtil.equals(this.SeqOnly, reqResUpdate.SeqOnly)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "ResPackage.ReqResUpdate";
    }

    public int getResID() {
        return this.ResID;
    }

    public long getSeqID() {
        return this.SeqID;
    }

    public byte getSeqOnly() {
        return this.SeqOnly;
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
        this.ResID = jceInputStream.read(this.ResID, 0, true);
        this.SeqID = jceInputStream.read(this.SeqID, 1, true);
        this.SeqOnly = jceInputStream.read(this.SeqOnly, 2, false);
    }

    public void setResID(int i3) {
        this.ResID = i3;
    }

    public void setSeqID(long j3) {
        this.SeqID = j3;
    }

    public void setSeqOnly(byte b16) {
        this.SeqOnly = b16;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ResID, 0);
        jceOutputStream.write(this.SeqID, 1);
        jceOutputStream.write(this.SeqOnly, 2);
    }

    public ReqResUpdate(int i3, long j3, byte b16) {
        this.ResID = i3;
        this.SeqID = j3;
        this.SeqOnly = b16;
    }
}
