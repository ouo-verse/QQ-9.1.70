package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ReSortGroup extends JceStruct {
    static byte[] cache_cGroupId;
    static byte[] cache_cSortId;
    public byte[] cGroupId;
    public byte cNum;
    public byte[] cSortId;

    public ReSortGroup() {
        this.cNum = (byte) 0;
        this.cGroupId = null;
        this.cSortId = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cNum = jceInputStream.read(this.cNum, 0, true);
        if (cache_cGroupId == null) {
            cache_cGroupId = r0;
            byte[] bArr = {0};
        }
        this.cGroupId = jceInputStream.read(cache_cGroupId, 1, true);
        if (cache_cSortId == null) {
            cache_cSortId = r0;
            byte[] bArr2 = {0};
        }
        this.cSortId = jceInputStream.read(cache_cSortId, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cNum, 0);
        jceOutputStream.write(this.cGroupId, 1);
        jceOutputStream.write(this.cSortId, 2);
    }

    public ReSortGroup(byte b16, byte[] bArr, byte[] bArr2) {
        this.cNum = b16;
        this.cGroupId = bArr;
        this.cSortId = bArr2;
    }
}
