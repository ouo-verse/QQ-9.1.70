package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PushResp extends JceStruct {
    static byte[] cache_jcebuf;
    public byte[] jcebuf;
    public long lSeq;
    public int type;

    public PushResp() {
        this.type = 0;
        this.lSeq = 0L;
        this.jcebuf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 1, true);
        this.lSeq = jceInputStream.read(this.lSeq, 2, true);
        if (cache_jcebuf == null) {
            cache_jcebuf = r0;
            byte[] bArr = {0};
        }
        this.jcebuf = jceInputStream.read(cache_jcebuf, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.lSeq, 2);
        byte[] bArr = this.jcebuf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public PushResp(int i3, long j3, byte[] bArr) {
        this.type = i3;
        this.lSeq = j3;
        this.jcebuf = bArr;
    }
}
