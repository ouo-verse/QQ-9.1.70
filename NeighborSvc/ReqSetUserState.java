package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetUserState extends JceStruct {
    static int cache_eUserState;
    static ReqHeader cache_stHeader;
    public int eUserState;
    public ReqHeader stHeader;

    public ReqSetUserState() {
        this.stHeader = null;
        this.eUserState = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.eUserState = jceInputStream.read(this.eUserState, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.eUserState, 1);
    }

    public ReqSetUserState(ReqHeader reqHeader, int i3) {
        this.stHeader = reqHeader;
        this.eUserState = i3;
    }
}
