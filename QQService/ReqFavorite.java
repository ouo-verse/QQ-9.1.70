package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqFavorite extends JceStruct {
    public int cOpType;
    public int emSource;
    public int iCount;
    public int iHasZplanAvatar;
    public long lMID;
    public ReqHead stHeader;
    static ReqHead cache_stHeader = new ReqHead();
    static int cache_cOpType = 0;
    static int cache_emSource = 0;

    public ReqFavorite() {
        this.stHeader = null;
        this.lMID = 0L;
        this.cOpType = 0;
        this.emSource = 65535;
        this.iCount = 1;
        this.iHasZplanAvatar = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lMID = jceInputStream.read(this.lMID, 1, true);
        this.cOpType = jceInputStream.read(this.cOpType, 2, true);
        this.emSource = jceInputStream.read(this.emSource, 3, false);
        this.iCount = jceInputStream.read(this.iCount, 4, false);
        this.iHasZplanAvatar = jceInputStream.read(this.iHasZplanAvatar, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lMID, 1);
        jceOutputStream.write(this.cOpType, 2);
        jceOutputStream.write(this.emSource, 3);
        jceOutputStream.write(this.iCount, 4);
        jceOutputStream.write(this.iHasZplanAvatar, 5);
    }

    public ReqFavorite(ReqHead reqHead, long j3, int i3, int i16, int i17, int i18) {
        this.stHeader = reqHead;
        this.lMID = j3;
        this.cOpType = i3;
        this.emSource = i16;
        this.iCount = i17;
        this.iHasZplanAvatar = i18;
    }
}
