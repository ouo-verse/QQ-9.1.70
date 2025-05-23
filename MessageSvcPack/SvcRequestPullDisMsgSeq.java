package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcRequestPullDisMsgSeq extends JceStruct {
    static ArrayList<PullDisSeqParam> cache_vDisInfo;
    public byte cVerifyType;
    public ArrayList<PullDisSeqParam> vDisInfo;

    public SvcRequestPullDisMsgSeq() {
        this.vDisInfo = null;
        this.cVerifyType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vDisInfo == null) {
            cache_vDisInfo = new ArrayList<>();
            cache_vDisInfo.add(new PullDisSeqParam());
        }
        this.vDisInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vDisInfo, 0, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vDisInfo, 0);
        jceOutputStream.write(this.cVerifyType, 1);
    }

    public SvcRequestPullDisMsgSeq(ArrayList<PullDisSeqParam> arrayList, byte b16) {
        this.vDisInfo = arrayList;
        this.cVerifyType = b16;
    }
}
