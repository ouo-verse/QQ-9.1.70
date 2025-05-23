package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Conch extends JceStruct {
    static byte[] cache_params;
    static TimeCtrl cache_time = new TimeCtrl();
    static TipsInfo cache_tips = new TipsInfo();
    public int cmdId = 0;
    public byte[] params = null;
    public int conchSeqno = 0;
    public TimeCtrl time = null;
    public TipsInfo tips = null;

    static {
        cache_params = r0;
        byte[] bArr = {0};
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new Conch();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmdId = jceInputStream.read(this.cmdId, 0, false);
        this.params = jceInputStream.read(cache_params, 1, false);
        this.conchSeqno = jceInputStream.read(this.conchSeqno, 2, false);
        this.time = (TimeCtrl) jceInputStream.read((JceStruct) cache_time, 3, false);
        this.tips = (TipsInfo) jceInputStream.read((JceStruct) cache_tips, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmdId, 0);
        byte[] bArr = this.params;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        int i3 = this.conchSeqno;
        if (i3 != 0) {
            jceOutputStream.write(i3, 2);
        }
        TimeCtrl timeCtrl = this.time;
        if (timeCtrl != null) {
            jceOutputStream.write((JceStruct) timeCtrl, 3);
        }
        TipsInfo tipsInfo = this.tips;
        if (tipsInfo != null) {
            jceOutputStream.write((JceStruct) tipsInfo, 4);
        }
    }
}
