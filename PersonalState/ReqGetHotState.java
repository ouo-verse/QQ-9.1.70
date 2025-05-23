package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetHotState extends JceStruct {
    static BusiReqHead cache_oHead;
    public BusiReqHead oHead;

    public ReqGetHotState() {
        this.oHead = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_oHead == null) {
            cache_oHead = new BusiReqHead();
        }
        this.oHead = (BusiReqHead) jceInputStream.read((JceStruct) cache_oHead, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.oHead, 0);
    }

    public ReqGetHotState(BusiReqHead busiReqHead) {
        this.oHead = busiReqHead;
    }
}
