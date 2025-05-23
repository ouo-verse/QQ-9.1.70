package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDisGroupInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_eInfoFlag;
    public int eInfoFlag;
    public long lDisCode;
    public long lRedPackTime;
    public long uDisMsgSeq;
    public long uInfoSeq;
    public long uMemberMsgSeq;

    public stDisGroupInfo() {
        this.lDisCode = 0L;
        this.uDisMsgSeq = 0L;
        this.uMemberMsgSeq = 0L;
        this.uInfoSeq = 0L;
        this.eInfoFlag = eDisGroupInfoFlag.E_DIS_GROUP_DEFAULT.value();
        this.lRedPackTime = 0L;
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
        jceDisplayer.display(this.lDisCode, "lDisCode");
        jceDisplayer.display(this.uDisMsgSeq, "uDisMsgSeq");
        jceDisplayer.display(this.uMemberMsgSeq, "uMemberMsgSeq");
        jceDisplayer.display(this.uInfoSeq, "uInfoSeq");
        jceDisplayer.display(this.eInfoFlag, "eInfoFlag");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.lDisCode, true);
        jceDisplayer.displaySimple(this.uDisMsgSeq, true);
        jceDisplayer.displaySimple(this.uMemberMsgSeq, true);
        jceDisplayer.displaySimple(this.uInfoSeq, true);
        jceDisplayer.displaySimple(this.eInfoFlag, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stDisGroupInfo stdisgroupinfo = (stDisGroupInfo) obj;
        if (!JceUtil.equals(this.lDisCode, stdisgroupinfo.lDisCode) || !JceUtil.equals(this.uDisMsgSeq, stdisgroupinfo.uDisMsgSeq) || !JceUtil.equals(this.uMemberMsgSeq, stdisgroupinfo.uMemberMsgSeq) || !JceUtil.equals(this.uInfoSeq, stdisgroupinfo.uInfoSeq) || !JceUtil.equals(this.eInfoFlag, stdisgroupinfo.eInfoFlag)) {
            return false;
        }
        return true;
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
        this.lDisCode = jceInputStream.read(this.lDisCode, 0, true);
        this.uDisMsgSeq = jceInputStream.read(this.uDisMsgSeq, 1, true);
        this.uMemberMsgSeq = jceInputStream.read(this.uMemberMsgSeq, 2, true);
        this.uInfoSeq = jceInputStream.read(this.uInfoSeq, 3, false);
        this.eInfoFlag = jceInputStream.read(this.eInfoFlag, 4, false);
        this.lRedPackTime = jceInputStream.read(this.lRedPackTime, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lDisCode, 0);
        jceOutputStream.write(this.uDisMsgSeq, 1);
        jceOutputStream.write(this.uMemberMsgSeq, 2);
        jceOutputStream.write(this.uInfoSeq, 3);
        jceOutputStream.write(this.eInfoFlag, 4);
        jceOutputStream.write(this.lRedPackTime, 6);
    }

    public stDisGroupInfo(long j3, long j16, long j17, long j18, int i3) {
        this.lDisCode = 0L;
        this.uDisMsgSeq = 0L;
        this.uMemberMsgSeq = 0L;
        this.uInfoSeq = 0L;
        eDisGroupInfoFlag.E_DIS_GROUP_DEFAULT.value();
        this.lRedPackTime = 0L;
        this.lDisCode = j3;
        this.uDisMsgSeq = j16;
        this.uMemberMsgSeq = j17;
        this.uInfoSeq = j18;
        this.eInfoFlag = i3;
    }
}
