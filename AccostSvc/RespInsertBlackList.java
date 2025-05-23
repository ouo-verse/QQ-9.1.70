package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespInsertBlackList extends JceStruct {
    static RespHeader cache_stHeader;
    public RespHeader stHeader;

    public RespInsertBlackList() {
        this.stHeader = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHeader();
        }
        this.stHeader = (RespHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
    }

    public RespInsertBlackList(RespHeader respHeader) {
        this.stHeader = respHeader;
    }
}
