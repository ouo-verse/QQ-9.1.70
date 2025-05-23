package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcResponsePullDisGroupSeq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<stDisGroupInfo> cache_vDisInfo;
    public byte cReplyCode;
    public String strResult;
    public long uUploadLimit;
    public ArrayList<stDisGroupInfo> vDisInfo;

    public SvcResponsePullDisGroupSeq() {
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.vDisInfo = null;
        this.uUploadLimit = 0L;
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
        jceDisplayer.display(this.cReplyCode, "cReplyCode");
        jceDisplayer.display(this.strResult, "strResult");
        jceDisplayer.display((Collection) this.vDisInfo, "vDisInfo");
        jceDisplayer.display(this.uUploadLimit, "uUploadLimit");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.cReplyCode, true);
        jceDisplayer.displaySimple(this.strResult, true);
        jceDisplayer.displaySimple((Collection) this.vDisInfo, true);
        jceDisplayer.displaySimple(this.uUploadLimit, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        SvcResponsePullDisGroupSeq svcResponsePullDisGroupSeq = (SvcResponsePullDisGroupSeq) obj;
        if (!JceUtil.equals(this.cReplyCode, svcResponsePullDisGroupSeq.cReplyCode) || !JceUtil.equals(this.strResult, svcResponsePullDisGroupSeq.strResult) || !JceUtil.equals(this.vDisInfo, svcResponsePullDisGroupSeq.vDisInfo) || !JceUtil.equals(this.uUploadLimit, svcResponsePullDisGroupSeq.uUploadLimit)) {
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
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 0, true);
        this.strResult = jceInputStream.readString(1, true);
        if (cache_vDisInfo == null) {
            cache_vDisInfo = new ArrayList<>();
            cache_vDisInfo.add(new stDisGroupInfo());
        }
        this.vDisInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vDisInfo, 2, true);
        this.uUploadLimit = jceInputStream.read(this.uUploadLimit, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cReplyCode, 0);
        jceOutputStream.write(this.strResult, 1);
        jceOutputStream.write((Collection) this.vDisInfo, 2);
        jceOutputStream.write(this.uUploadLimit, 3);
    }

    public SvcResponsePullDisGroupSeq(byte b16, String str, ArrayList<stDisGroupInfo> arrayList, long j3) {
        this.cReplyCode = b16;
        this.strResult = str;
        this.vDisInfo = arrayList;
        this.uUploadLimit = j3;
    }
}
