package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class JoinShareAlbumRsp extends JceStruct {
    public boolean isAutoJoin;

    /* renamed from: msg, reason: collision with root package name */
    public String f25029msg;
    public int ret;

    public JoinShareAlbumRsp() {
        this.ret = 0;
        this.f25029msg = "";
        this.isAutoJoin = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25029msg = jceInputStream.readString(1, false);
        this.isAutoJoin = jceInputStream.read(this.isAutoJoin, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25029msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.isAutoJoin, 2);
    }

    public JoinShareAlbumRsp(int i3, String str) {
        this.ret = i3;
        this.f25029msg = str;
        this.isAutoJoin = false;
    }
}
