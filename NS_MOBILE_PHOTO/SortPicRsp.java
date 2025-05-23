package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SortPicRsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25034msg;
    public int ret;

    public SortPicRsp() {
        this.ret = 0;
        this.f25034msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25034msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25034msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public SortPicRsp(int i3, String str) {
        this.ret = i3;
        this.f25034msg = str;
    }
}
