package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcRequestPullDisGroupSeq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<PullDisSeqParam> cache_vDisInfo;
    public ArrayList<PullDisSeqParam> vDisInfo;

    public SvcRequestPullDisGroupSeq() {
        this.vDisInfo = null;
    }

    public String className() {
        return "RegisterProxySvcPack.SvcRequestPullDisGroupSeq";
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
        new JceDisplayer(sb5, i3).display((Collection) this.vDisInfo, "vDisInfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple((Collection) this.vDisInfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.vDisInfo, ((SvcRequestPullDisGroupSeq) obj).vDisInfo);
    }

    public String fullClassName() {
        return "RegisterProxySvcPack.SvcRequestPullDisGroupSeq";
    }

    public ArrayList<PullDisSeqParam> getVDisInfo() {
        return this.vDisInfo;
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
        if (cache_vDisInfo == null) {
            cache_vDisInfo = new ArrayList<>();
            cache_vDisInfo.add(new PullDisSeqParam());
        }
        this.vDisInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vDisInfo, 0, true);
    }

    public void setVDisInfo(ArrayList<PullDisSeqParam> arrayList) {
        this.vDisInfo = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vDisInfo, 0);
    }

    public SvcRequestPullDisGroupSeq(ArrayList<PullDisSeqParam> arrayList) {
        this.vDisInfo = arrayList;
    }
}
