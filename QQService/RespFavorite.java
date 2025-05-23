package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespFavorite extends JceStruct {
    static RespHead cache_stHeader;
    static byte[] cache_vNotice;
    public byte cOpType;
    public int iKoiLikeCount;
    public long lMID;
    public RespHead stHeader;
    public byte[] vNotice;

    public RespFavorite() {
        this.stHeader = null;
        this.lMID = 0L;
        this.cOpType = (byte) 0;
        this.vNotice = null;
        this.iKoiLikeCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lMID = jceInputStream.read(this.lMID, 1, true);
        this.cOpType = jceInputStream.read(this.cOpType, 2, true);
        if (cache_vNotice == null) {
            cache_vNotice = r0;
            byte[] bArr = {0};
        }
        this.vNotice = jceInputStream.read(cache_vNotice, 3, false);
        this.iKoiLikeCount = jceInputStream.read(this.iKoiLikeCount, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lMID, 1);
        jceOutputStream.write(this.cOpType, 2);
        byte[] bArr = this.vNotice;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.iKoiLikeCount, 4);
    }

    public RespFavorite(RespHead respHead, long j3, byte b16, byte[] bArr, int i3) {
        this.stHeader = respHead;
        this.lMID = j3;
        this.cOpType = b16;
        this.vNotice = bArr;
        this.iKoiLikeCount = i3;
    }
}
