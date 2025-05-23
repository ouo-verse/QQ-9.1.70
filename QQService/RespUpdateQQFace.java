package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespUpdateQQFace extends JceStruct {
    static RespHead cache_stHeader;
    public RespHead stHeader;

    public RespUpdateQQFace() {
        this.stHeader = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
    }

    public RespUpdateQQFace(RespHead respHead) {
        this.stHeader = respHead;
    }
}
