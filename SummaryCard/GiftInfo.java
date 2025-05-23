package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GiftInfo extends JceStruct {
    static byte[] cache_vGiftInfo;
    public long uOpenFlag;
    public byte[] vGiftInfo;

    public GiftInfo() {
        this.uOpenFlag = 0L;
        this.vGiftInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uOpenFlag = jceInputStream.read(this.uOpenFlag, 0, false);
        if (cache_vGiftInfo == null) {
            cache_vGiftInfo = r0;
            byte[] bArr = {0};
        }
        this.vGiftInfo = jceInputStream.read(cache_vGiftInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uOpenFlag, 0);
        byte[] bArr = this.vGiftInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public GiftInfo(long j3, byte[] bArr) {
        this.uOpenFlag = j3;
        this.vGiftInfo = bArr;
    }
}
