package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestDelMsgV2 extends JceStruct {
    static ArrayList<AccostMsg> cache_vAccostMsg;
    static ArrayList<SvcDelMsgInfo> cache_vDelInfos;
    public byte cInst;
    public byte cVerifyType;
    public long lUin;
    public ArrayList<AccostMsg> vAccostMsg;
    public ArrayList<SvcDelMsgInfo> vDelInfos;

    public SvcRequestDelMsgV2() {
        this.lUin = 0L;
        this.vDelInfos = null;
        this.cVerifyType = (byte) 0;
        this.vAccostMsg = null;
        this.cInst = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        if (cache_vDelInfos == null) {
            cache_vDelInfos = new ArrayList<>();
            cache_vDelInfos.add(new SvcDelMsgInfo());
        }
        this.vDelInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vDelInfos, 1, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 2, true);
        if (cache_vAccostMsg == null) {
            cache_vAccostMsg = new ArrayList<>();
            cache_vAccostMsg.add(new AccostMsg());
        }
        this.vAccostMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_vAccostMsg, 3, true);
        this.cInst = jceInputStream.read(this.cInst, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write((Collection) this.vDelInfos, 1);
        jceOutputStream.write(this.cVerifyType, 2);
        jceOutputStream.write((Collection) this.vAccostMsg, 3);
        jceOutputStream.write(this.cInst, 4);
    }

    public SvcRequestDelMsgV2(long j3, ArrayList<SvcDelMsgInfo> arrayList, byte b16, ArrayList<AccostMsg> arrayList2, byte b17) {
        this.lUin = j3;
        this.vDelInfos = arrayList;
        this.cVerifyType = b16;
        this.vAccostMsg = arrayList2;
        this.cInst = b17;
    }
}
