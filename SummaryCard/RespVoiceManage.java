package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespVoiceManage extends JceStruct {
    static int cache_eOpType;
    public int eOpType;

    public RespVoiceManage() {
        this.eOpType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eOpType = jceInputStream.read(this.eOpType, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eOpType, 0);
    }

    public RespVoiceManage(int i3) {
        this.eOpType = i3;
    }
}
