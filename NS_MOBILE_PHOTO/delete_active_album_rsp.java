package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class delete_active_album_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25038msg;
    public int ret;

    public delete_active_album_rsp() {
        this.ret = 0;
        this.f25038msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25038msg = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.f25038msg, 1);
    }

    public delete_active_album_rsp(int i3, String str) {
        this.ret = i3;
        this.f25038msg = str;
    }
}
