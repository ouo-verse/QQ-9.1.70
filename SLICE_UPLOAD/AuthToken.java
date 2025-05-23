package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AuthToken extends JceStruct {
    static byte[] cache_data;
    static byte[] cache_ext_key;
    static int cache_type;
    public int appid;
    public byte[] data;
    public byte[] ext_key;
    public int type;
    public long wt_appid;

    static {
        cache_data = r1;
        byte[] bArr = {0};
        cache_ext_key = r0;
        byte[] bArr2 = {0};
    }

    public AuthToken() {
        this.type = 0;
        this.data = null;
        this.ext_key = null;
        this.appid = 0;
        this.wt_appid = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.data = jceInputStream.read(cache_data, 1, true);
        this.ext_key = jceInputStream.read(cache_ext_key, 2, true);
        this.appid = jceInputStream.read(this.appid, 3, true);
        this.wt_appid = jceInputStream.read(this.wt_appid, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.data, 1);
        jceOutputStream.write(this.ext_key, 2);
        jceOutputStream.write(this.appid, 3);
        jceOutputStream.write(this.wt_appid, 4);
    }

    public AuthToken(int i3, byte[] bArr, byte[] bArr2, int i16, long j3) {
        this.type = i3;
        this.data = bArr;
        this.ext_key = bArr2;
        this.appid = i16;
        this.wt_appid = j3;
    }
}
