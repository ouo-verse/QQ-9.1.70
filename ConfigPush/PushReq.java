package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PushReq extends JceStruct {
    static byte[] cache_jcebuf;
    public byte[] jcebuf;
    public long lSeq;
    public int type;

    public PushReq() {
        this.type = 0;
        this.jcebuf = null;
        this.lSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 1, true);
        if (cache_jcebuf == null) {
            cache_jcebuf = r0;
            byte[] bArr = {0};
        }
        this.jcebuf = jceInputStream.read(cache_jcebuf, 2, true);
        this.lSeq = jceInputStream.read(this.lSeq, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.jcebuf, 2);
        jceOutputStream.write(this.lSeq, 3);
    }

    public PushReq(int i3, byte[] bArr, long j3) {
        this.type = i3;
        this.jcebuf = bArr;
        this.lSeq = j3;
    }
}
