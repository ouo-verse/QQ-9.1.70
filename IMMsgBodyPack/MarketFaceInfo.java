package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MarketFaceInfo extends JceStruct {
    static byte[] cache_marketFaceBuff;
    public long insertIdx;
    public byte[] marketFaceBuff;

    public MarketFaceInfo() {
        this.insertIdx = 0L;
        this.marketFaceBuff = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.insertIdx = jceInputStream.read(this.insertIdx, 0, true);
        if (cache_marketFaceBuff == null) {
            cache_marketFaceBuff = r0;
            byte[] bArr = {0};
        }
        this.marketFaceBuff = jceInputStream.read(cache_marketFaceBuff, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.insertIdx, 0);
        jceOutputStream.write(this.marketFaceBuff, 1);
    }

    public MarketFaceInfo(long j3, byte[] bArr) {
        this.insertIdx = j3;
        this.marketFaceBuff = bArr;
    }
}
