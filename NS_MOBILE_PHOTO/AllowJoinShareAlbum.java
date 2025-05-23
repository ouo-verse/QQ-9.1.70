package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class AllowJoinShareAlbum extends JceStruct {
    static byte[] cache_data;
    public byte[] data;
    public int source;

    static {
        cache_data = r0;
        byte[] bArr = {0};
    }

    public AllowJoinShareAlbum() {
        this.source = 0;
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.source = jceInputStream.read(this.source, 0, false);
        this.data = jceInputStream.read(cache_data, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.source, 0);
        byte[] bArr = this.data;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public AllowJoinShareAlbum(int i3, byte[] bArr) {
        this.source = i3;
        this.data = bArr;
    }
}
