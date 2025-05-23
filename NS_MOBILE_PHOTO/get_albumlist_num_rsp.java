package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_albumlist_num_rsp extends JceStruct {
    public long album_num;

    /* renamed from: msg, reason: collision with root package name */
    public String f25039msg;
    public int ret;

    public get_albumlist_num_rsp() {
        this.f25039msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.album_num = jceInputStream.read(this.album_num, 0, true);
        this.ret = jceInputStream.read(this.ret, 1, false);
        this.f25039msg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.album_num, 0);
        jceOutputStream.write(this.ret, 1);
        String str = this.f25039msg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public get_albumlist_num_rsp(long j3, int i3, String str) {
        this.album_num = j3;
        this.ret = i3;
        this.f25039msg = str;
    }
}
