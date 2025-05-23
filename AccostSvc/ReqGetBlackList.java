package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetBlackList extends JceStruct {
    static int cache_eListType;
    static int cache_eType;
    static ReqHeader cache_stHeader;
    public int eListType;
    public int eType;
    public long lNextMid;
    public ReqHeader stHeader;

    public ReqGetBlackList() {
        this.stHeader = null;
        this.lNextMid = 0L;
        this.eListType = 1;
        this.eType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lNextMid = jceInputStream.read(this.lNextMid, 1, true);
        this.eListType = jceInputStream.read(this.eListType, 2, false);
        this.eType = jceInputStream.read(this.eType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lNextMid, 1);
        jceOutputStream.write(this.eListType, 2);
        jceOutputStream.write(this.eType, 3);
    }

    public ReqGetBlackList(ReqHeader reqHeader, long j3, int i3, int i16) {
        this.stHeader = reqHeader;
        this.lNextMid = j3;
        this.eListType = i3;
        this.eType = i16;
    }
}
