package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UgcCustomTrack extends JceStruct {
    static byte[] cache_strExtFields;
    public int iItemId;
    public byte[] strExtFields;

    static {
        cache_strExtFields = r0;
        byte[] bArr = {0};
    }

    public UgcCustomTrack() {
        this.iItemId = -1;
        this.strExtFields = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strExtFields = jceInputStream.read(cache_strExtFields, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        byte[] bArr = this.strExtFields;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public UgcCustomTrack(int i3, byte[] bArr) {
        this.iItemId = i3;
        this.strExtFields = bArr;
    }
}
