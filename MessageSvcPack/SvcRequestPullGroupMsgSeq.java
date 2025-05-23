package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcRequestPullGroupMsgSeq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_filter;
    static ArrayList<PullGroupSeqParam> cache_vGroupInfo;
    public byte cVerifyType;
    public int filter;
    public ArrayList<PullGroupSeqParam> vGroupInfo;

    public SvcRequestPullGroupMsgSeq() {
        this.vGroupInfo = null;
        this.cVerifyType = (byte) 0;
        this.filter = MsgFilter.NO_FILTER.value();
    }

    public String className() {
        return "MessageSvcPack.SvcRequestPullGroupMsgSeq";
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
        jceDisplayer.display((Collection) this.vGroupInfo, "vGroupInfo");
        jceDisplayer.display(this.cVerifyType, "cVerifyType");
        jceDisplayer.display(this.filter, "filter");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple((Collection) this.vGroupInfo, true);
        jceDisplayer.displaySimple(this.cVerifyType, true);
        jceDisplayer.displaySimple(this.filter, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        SvcRequestPullGroupMsgSeq svcRequestPullGroupMsgSeq = (SvcRequestPullGroupMsgSeq) obj;
        if (!JceUtil.equals(this.vGroupInfo, svcRequestPullGroupMsgSeq.vGroupInfo) || !JceUtil.equals(this.cVerifyType, svcRequestPullGroupMsgSeq.cVerifyType) || !JceUtil.equals(this.filter, svcRequestPullGroupMsgSeq.filter)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "MessageSvcPack.SvcRequestPullGroupMsgSeq";
    }

    public byte getCVerifyType() {
        return this.cVerifyType;
    }

    public int getFilter() {
        return this.filter;
    }

    public ArrayList<PullGroupSeqParam> getVGroupInfo() {
        return this.vGroupInfo;
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
        if (cache_vGroupInfo == null) {
            cache_vGroupInfo = new ArrayList<>();
            cache_vGroupInfo.add(new PullGroupSeqParam());
        }
        this.vGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupInfo, 0, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 1, false);
        this.filter = jceInputStream.read(this.filter, 2, false);
    }

    public void setCVerifyType(byte b16) {
        this.cVerifyType = b16;
    }

    public void setFilter(int i3) {
        this.filter = i3;
    }

    public void setVGroupInfo(ArrayList<PullGroupSeqParam> arrayList) {
        this.vGroupInfo = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vGroupInfo, 0);
        jceOutputStream.write(this.cVerifyType, 1);
        jceOutputStream.write(this.filter, 2);
    }

    public SvcRequestPullGroupMsgSeq(ArrayList<PullGroupSeqParam> arrayList, byte b16, int i3) {
        this.vGroupInfo = null;
        this.cVerifyType = (byte) 0;
        MsgFilter.NO_FILTER.value();
        this.vGroupInfo = arrayList;
        this.cVerifyType = b16;
        this.filter = i3;
    }
}
