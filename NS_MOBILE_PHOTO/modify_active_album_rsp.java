package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class modify_active_album_rsp extends JceStruct {
    public String fake_feeds_client_key;

    /* renamed from: msg, reason: collision with root package name */
    public String f25042msg;
    public int ret;

    public modify_active_album_rsp() {
        this.ret = 0;
        this.f25042msg = "";
        this.fake_feeds_client_key = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25042msg = jceInputStream.readString(1, true);
        this.fake_feeds_client_key = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.f25042msg, 1);
        String str = this.fake_feeds_client_key;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public modify_active_album_rsp(int i3, String str, String str2) {
        this.ret = i3;
        this.f25042msg = str;
        this.fake_feeds_client_key = str2;
    }
}
