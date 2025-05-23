package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomTrackDeco extends JceStruct {
    static byte[] cache_strExtFields;
    public int iAppID;
    public int iItemId;
    public byte[] strExtFields;

    static {
        cache_strExtFields = r0;
        byte[] bArr = {0};
    }

    public CustomTrackDeco() {
        this.iAppID = 149;
        this.iItemId = -1;
        this.strExtFields = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppID = jceInputStream.read(this.iAppID, 0, false);
        this.iItemId = jceInputStream.read(this.iItemId, 1, false);
        this.strExtFields = jceInputStream.read(cache_strExtFields, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppID, 0);
        jceOutputStream.write(this.iItemId, 1);
        byte[] bArr = this.strExtFields;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public CustomTrackDeco(int i3, int i16, byte[] bArr) {
        this.iAppID = i3;
        this.iItemId = i16;
        this.strExtFields = bArr;
    }
}
